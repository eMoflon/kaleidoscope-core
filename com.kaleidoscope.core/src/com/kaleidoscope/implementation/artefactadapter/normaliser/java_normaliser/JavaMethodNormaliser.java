package com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SimpleJava.JavaImport;
import SimpleJava.JavaMethod;


public class JavaMethodNormaliser implements Comparator<JavaMethod> {
	@Override
	public int compare(JavaMethod expected, JavaMethod actual) {
		return Integer.compare(expected.getIndex(), actual.getIndex());
//		return expected.getName().compareTo(actual.getName());		
	}

	public void normalize(List<JavaMethod> methods){
		Comparator<JavaMethod> comparator = new JavaMethodNormaliser();
		Collections.sort(methods, comparator);
	}
}
