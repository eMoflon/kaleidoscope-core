package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SimpleJava.JavaVariableDeclaration;

public class JavaVariableDeclarationNormaliser implements Comparator<JavaVariableDeclaration> {
	@Override
	public int compare(JavaVariableDeclaration expected, JavaVariableDeclaration actual) {		
		return Integer.compare(expected.getIndex(), actual.getIndex());
	}

	public void normalize(List<JavaVariableDeclaration> javaVariableDeclarations){
		Comparator<JavaVariableDeclaration> comparator = new JavaVariableDeclarationNormaliser();
		Collections.sort(javaVariableDeclarations, comparator);
	}
}
