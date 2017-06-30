package com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SimpleJava.JavaExpression;


public class JavaExpressionNormaliser<T> implements Comparator<T> {
	@Override
	public int compare(T expected, T actual) {	
		JavaExpression expectedJavaExpression = (JavaExpression)expected;
		JavaExpression actualJavaExpression = (JavaExpression)actual;
		return Integer.compare(expectedJavaExpression.getIndex(), actualJavaExpression.getIndex());
	}

	public void normalize(List<T> imports){
		
		Comparator<T> comparator = new JavaExpressionNormaliser();
		Collections.sort(imports, comparator);
	}
}
