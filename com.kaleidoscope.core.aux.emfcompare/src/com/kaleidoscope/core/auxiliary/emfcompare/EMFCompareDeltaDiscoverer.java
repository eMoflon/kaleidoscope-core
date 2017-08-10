package com.kaleidoscope.core.auxiliary.emfcompare;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.impl.AttributeChangeImpl;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class EMFCompareDeltaDiscoverer<M extends EObject> implements OfflineDeltaDiscoverer<M, OperationalDelta> {

	private static final Logger logger = Logger.getLogger(EMFCompareDeltaDiscoverer.class);
	
	/**
	 * The method is used to generate an operational delta from two models of
	 * the same metamodel. The for loop inside the method goes through all the
	 * differences between the two models, and builds up a delta according to
	 * the type of difference.
	 * 
	 * @param oldModel
	 * @param newModel
	 * @return DeltaSpecification represents delta between the two models
	 */
	public OperationalDelta discoverDelta(M oldModel, M newModel) {
		
		Comparison comparison = compareModels(oldModel, newModel);
		List<Diff> differences = comparison.getDifferences();

		KaleidoscopeDelta.OperationalDelta operationalDelta = KaleidoscopeDeltaFactory.eINSTANCE.createOperationalDelta();

		logger.debug("------------------ Performing Comparison of Models --------------------");
		
		for (Diff diff : differences) {
			if (diff instanceof AttributeChangeImpl) {
				if (diff.getKind().equals(DifferenceKind.CHANGE)) {
					EAttribute affectedAttribute = ((AttributeChangeImpl) diff).getAttribute();
					Object newValue = ((AttributeChangeImpl) diff).getValue();

					Match match = diff.getMatch();
					
					AttributeChangeOP attributeDelta = KaleidoscopeDeltaFactory.eINSTANCE.createAttributeChangeOP();
					attributeDelta.setAttr(affectedAttribute);
					attributeDelta.setNode(match.getRight());
					attributeDelta.setNewValue(newValue);

					operationalDelta.getOperations().add(attributeDelta);
				}
			} else if (diff instanceof ReferenceChangeImpl) {
				if (diff.getKind() == DifferenceKind.ADD) {
					ReferenceChangeImpl refChgSpec = (ReferenceChangeImpl) diff;

					AddNodeOP addNodeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAddNodeOP();
					AddEdgeOP addEdgeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAddEdgeOP();

					Edge edge = KaleidoscopeDeltaFactory.eINSTANCE.createEdge();
					edge.setType(refChgSpec.getReference());
					edge.setSrc(refChgSpec.getMatch().getRight());
					edge.setTrg(refChgSpec.getValue());

					addEdgeOp.setEdge(edge);
					addNodeOp.setNode(((ReferenceChangeImpl) diff).getValue());

					operationalDelta.getOperations().add(addEdgeOp);
					operationalDelta.getOperations().add(addNodeOp);
				} else if (diff.getKind().equals(DifferenceKind.DELETE)) {
					DeleteNodeOP removeNodeOp = KaleidoscopeDeltaFactory.eINSTANCE.createDeleteNodeOP();
					DeleteEdgeOP removeEdgeOp = KaleidoscopeDeltaFactory.eINSTANCE.createDeleteEdgeOP();
					Edge edgeRemove = KaleidoscopeDeltaFactory.eINSTANCE.createEdge();

					edgeRemove.setType(((ReferenceChangeImpl) diff).getReference());
					edgeRemove.setSrc(((ReferenceChangeImpl) diff).getValue().eContainer());
					edgeRemove.setTrg(((ReferenceChangeImpl) diff).getValue());

					removeEdgeOp.setEdge(edgeRemove);
					removeNodeOp.setNode(((ReferenceChangeImpl) diff).getValue());

					operationalDelta.getOperations().add(removeEdgeOp);
					operationalDelta.getOperations().add(removeNodeOp);
				} else if (diff.getKind().equals(DifferenceKind.MOVE)) {
					//TODO[Dusko] Handle move operation detected by EMFCompare
				}
			}

			logger.debug("d.toString():" + diff);
			logger.debug("d.getKind(): " + diff.getKind());
			logger.debug("d.getMatch(): " + diff.getMatch());

			logger.debug("=========================================================");
		}
		
		logger.debug("------------------ Comparison Complete --------------------");
		
		return new OperationalDelta(operationalDelta);
	}

	private Comparison compareModels(M model1, M model2) {
		IComparisonScope scope = new DefaultComparisonScope(model1, model2, null);
		IDiffEngine diffEngine = new DefaultDiffEngine();
		EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine).build();
		Comparison comparison = comparator.compare(scope);
		return comparison;
	}
	
}
