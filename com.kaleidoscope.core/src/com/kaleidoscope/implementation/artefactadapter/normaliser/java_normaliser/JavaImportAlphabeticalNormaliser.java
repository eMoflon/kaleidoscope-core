package com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import CryptoJava.JavaImport;

public class JavaImportAlphabeticalNormaliser implements Comparator<JavaImport>{
	@Override
	public int compare(JavaImport expected, JavaImport actual) {
		return expected.getValue().compareTo(actual.getValue());
	}

	public void normalize(List<JavaImport> imports){
		
		Comparator<JavaImport> comparator = new JavaImportAlphabeticalNormaliser();
		
		if(imports instanceof EList){
			ECollections.sort((EList<JavaImport>)imports, comparator);
		}
		else{
			Collections.sort(imports, comparator);
		}
		
		
		for (int i = 0; i < imports.size(); i++) {			
			imports.get(i).setIndex(i);
		}
	}
}
