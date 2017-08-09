package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SimpleJava.JavaCompilationUnit;


public class JavaCompilationUnitNormaliser implements Comparator<JavaCompilationUnit> {
	@Override
	public int compare(JavaCompilationUnit expected, JavaCompilationUnit actual) {
		return expected.getName().compareTo(actual.getName());
	}

	public void normalize(List<JavaCompilationUnit> compilationUnits){
		Comparator<JavaCompilationUnit> comparator = new JavaCompilationUnitNormaliser();
		Collections.sort(compilationUnits, comparator);
	}
}
