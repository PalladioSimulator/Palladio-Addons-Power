package de.fzi.power.regression.r.expressionoasis;

public interface ExportTriple<T> {

	T getPrefix();

	T getSeparator();
	
	T getPostfix();
	
}
