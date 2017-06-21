package com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import CryptoJava.JavaImport;


public class JavaImportNormaliser implements Comparator<JavaImport> {
	@Override
	public int compare(JavaImport expected, JavaImport actual) {
		return Integer.compare(expected.getIndex(), actual.getIndex());
//		return expected.getValue().compareTo(actual.getValue());
	}

	public void normalize(List<JavaImport> imports){
		Comparator<JavaImport> comparator = new JavaImportNormaliser();
		Collections.sort(imports, comparator);
	}
}
