package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Simplejava.JavaImport;


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
