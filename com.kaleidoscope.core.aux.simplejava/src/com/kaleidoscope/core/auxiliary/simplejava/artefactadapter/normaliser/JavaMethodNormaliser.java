package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Simplejava.JavaMethod;


public class JavaMethodNormaliser implements Comparator<JavaMethod> {
	@Override
	public int compare(JavaMethod expected, JavaMethod actual) {
		return Integer.compare(expected.getIndex(), actual.getIndex());
	}

	public void normalize(List<JavaMethod> methods){
		Comparator<JavaMethod> comparator = new JavaMethodNormaliser();
		Collections.sort(methods, comparator);
	}
}
