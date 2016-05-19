package de.fzi.power.regression.r.expressionoasis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

import org.vedantatree.expressionoasis.expressions.BinaryOperatorExpression;
import org.vedantatree.expressionoasis.expressions.Expression;
import org.vedantatree.expressionoasis.expressions.ExpressionVisitor;
import org.vedantatree.expressionoasis.expressions.UnaryOperatorExpression;

public class ExportVisitor<T> implements ExpressionVisitor {
	private class VisitorStackFrame<Q> {
		private Q prefix;
		private Q postfix;
		private Q separator;
		
		private int parameterCounter;
		private int expectedParameters;
		private List<VisitorStackFrame<Q>> parameterList;
		
		private VisitorStackFrame(int expectedParameters) {
			parameterList = new ArrayList<VisitorStackFrame<Q>>(expectedParameters);
			this.expectedParameters = expectedParameters;
			parameterCounter = 0;
		}
		
		public boolean hasParametersLeft() {
			return parameterCounter < expectedParameters;
		}
		
		public void setParameter(VisitorStackFrame<Q> frame) {
			if (hasParametersLeft()) {
				parameterList.add(frame);
				parameterCounter++;
			} else {
				throw new RuntimeException("The underlying VisitorStackFrame does not expect any more parameters");
			}
		}
		
		
		public void setPrefix(Q prefix) {
			this.prefix = prefix;
		}

		public void setPostfix(Q postfix) {
			this.postfix = postfix;
		}

		public void setSeparator(Q content) {
			this.separator = content;
		}
		
		public List<Q> toList() {
			Vector<Q> resultVector = new Vector<Q>();
			if (prefix != null) resultVector.add(prefix);
			Iterator<VisitorStackFrame<Q>> iterator = parameterList.iterator();
			while (iterator.hasNext()) {
				resultVector.addAll(iterator.next().toList());
				if (iterator.hasNext()) {
					if (separator != null) resultVector.add(separator);
				}
			}
			if (postfix != null) resultVector.add(postfix);
			return resultVector;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			
			for (Q q : toList()) {
				builder.append(q.toString());
			}
			/*builder.append(prefix);
			Iterator<VisitorStackFrame> iterator = parameterList.iterator();
			while (iterator.hasNext()) {
				builder.append(iterator.next().toString());
				if (iterator.hasNext()) {
					builder.append(content);
				}
			}
			builder.append(postfix);*/
			return builder.toString();
		}
	}
	
	private VisitorStackFrame<T> rootFrame;
	private Stack<VisitorStackFrame<T>> frameStack;
	private Stack<String> functionParameterSeparatorStack;
	private Map<Class<?>, ExportTripleProvider<T>> exportDescription; 
	
	public ExportVisitor(Map<Class<?>, ExportTripleProvider<T>> exportDescription) {
		this.exportDescription = exportDescription;
		frameStack = new Stack<VisitorStackFrame<T>>();
		functionParameterSeparatorStack = new Stack<String>();
		rootFrame = new VisitorStackFrame<T>(1);
		frameStack.push(rootFrame);
	}

	@Override
	public void visit(Expression expression) {
		VisitorStackFrame<T> currentFrame = frameStack.peek();
		if (!currentFrame.hasParametersLeft())
			throw new RuntimeException("ExportVisitor failed: Got Parameters where no ones where expexted");
		
		VisitorStackFrame<T> newFrame = null;
		if (expression instanceof BinaryOperatorExpression) {
			newFrame = new VisitorStackFrame<T>(2);
			currentFrame.setParameter(newFrame);
			frameStack.push(newFrame);
			
			fillOperatorFrame(newFrame, expression);
			currentFrame = newFrame;
		} else if (expression instanceof UnaryOperatorExpression) {
			newFrame = new VisitorStackFrame<T>(1);
			currentFrame.setParameter(newFrame);
			frameStack.push(newFrame);
			
			fillOperatorFrame(newFrame, expression);
			currentFrame = newFrame;
		} else {
			newFrame = new VisitorStackFrame<T>(0);
			currentFrame.setParameter(newFrame);
			
			fillOperatorFrame(newFrame, expression);
		}
		
		
		while (!currentFrame.hasParametersLeft()) {
			if (!frameStack.isEmpty()) {
				if (frameStack.peek().hasParametersLeft()) break;
				
				currentFrame = frameStack.pop();
			} else {
				break;
			}
		}

	}

	private void fillOperatorFrame(VisitorStackFrame<T> newFrame,
			Expression expression) {
		
		if (!exportDescription.containsKey(expression.getClass()))
			throw new RuntimeException("No export triple defined for expression: " + expression.toString());
		
		ExportTriple<T> triple = exportDescription.get(expression.getClass())
				.getExportTriple(expression, this);
		
		if (triple == null)
			throw new RuntimeException("No export triple defined for expression: " + expression.toString());
		
		newFrame.setSeparator(triple.getSeparator());
		newFrame.setPostfix(triple.getPostfix());
		newFrame.setPrefix(triple.getPrefix());
	}

	@Override
	public String toString() {
		return rootFrame.toString();
	}

	public Stack<String> getFunctionParameterSeparatorStack() {
		return functionParameterSeparatorStack;
	}
}
