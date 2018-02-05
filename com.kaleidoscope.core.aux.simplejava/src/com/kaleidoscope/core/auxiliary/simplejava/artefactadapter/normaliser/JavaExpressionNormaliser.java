package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Simplejava.JavaExpression;


public class JavaExpressionNormaliser<T> implements Comparator<T> {
	@Override
	public int compare(T expected, T actual) {	
		JavaExpression expectedJavaExpression = (JavaExpression)expected;
		JavaExpression actualJavaExpression = (JavaExpression)actual;
		return Integer.compare(expectedJavaExpression.getIndex(), actualJavaExpression.getIndex());
	}

	public void normalize(List<T> imports){
		Collections.sort(imports, this);
	}
}
