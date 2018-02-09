package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

import Simpleexcel.SimpleexcelPackage;

public class ExcelMain {
	static ExcelArtefactAdapter excelArtefactAdapter = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String excelPath = "./Resources/Relationship1.xlsx";

		ResourceSet set = setResourceSet();

		// calling EXCELAdapter
		Path path = Paths.get(excelPath);
		excelArtefactAdapter = new ExcelArtefactAdapter(path);

		// parse Excel
		System.out.println("Parsing EXCEL file...");
		excelArtefactAdapter.parse();

		System.out.println("Parsing completed...");

		// unparse and regenerate EXCEL
		System.out.println("Reading XMI file...");
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		excelArtefactAdapter.unparse();
		System.out.println("EXCEL file regenrated ...");
	}

	private static ResourceSet setResourceSet() {
		// obtain a new resource set
		ResourceSet set = new ResourceSetImpl();

		// TODO Auto-generated method stub
		set.getPackageRegistry().put(SimpleexcelPackage.eNS_URI, SimpleexcelPackage.eINSTANCE);
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new EcoreResourceFactoryImpl());
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		return set;
	}

}
