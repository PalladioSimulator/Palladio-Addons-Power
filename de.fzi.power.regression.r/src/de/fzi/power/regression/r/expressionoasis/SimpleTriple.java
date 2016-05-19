package de.fzi.power.regression.r.expressionoasis;

import org.vedantatree.expressionoasis.expressions.Expression;

public class SimpleTriple implements ExportTriple<String>, ExportTripleProvider<String> {

	private String prefix;
	private String separator;
	private String postfix;

	public SimpleTriple(String prefix, String separator, String postfix) {
		this.prefix = prefix;
		this.separator = separator;
		this.postfix = postfix;
	}
	
	@Override
	public ExportTriple<String> getExportTriple(Expression expression, ExportVisitor<String> visitor) {
		return this;
	}

	@Override
	public String getPrefix() {
		return prefix;
	}

	@Override
	public String getSeparator() {
		return separator;
	}

	@Override
	public String getPostfix() {
		return postfix;
	}

}
