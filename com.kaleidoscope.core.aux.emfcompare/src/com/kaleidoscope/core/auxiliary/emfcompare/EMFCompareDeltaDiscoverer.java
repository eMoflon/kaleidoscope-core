package com.kaleidoscope.core.auxiliary.emfcompare;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.AddEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.AddNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.MoveNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

/**
 * An offline delta discoverer based on the EMFCompare framework.
 * 
 * @author Anthony Anjorin, Dusko Gataric
 *
 * @param <M>
 *            The type of models to discover deltas between.
 */
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
	 * @return OperationalDelta representing o-delta between the two models
	 */
	public OperationalDelta discoverDelta(M oldModel, M newModel) {
		
		Comparison comparison = compareModels(oldModel, newModel);
		List<Diff> differences = comparison.getDifferences();
		OperationalDelta operationalDelta = new OperationalDelta();

		logger.debug("------------------ Performing Comparison of Models --------------------");
		
		for (Diff diff : Lists.reverse(differences)) {
			if (diff instanceof AttributeChangeImpl) {
				if (diff.getKind().equals(DifferenceKind.CHANGE)) {
					EAttribute affectedAttribute = ((AttributeChangeImpl) diff).getAttribute();
					Object newValue = ((AttributeChangeImpl) diff).getValue();
					Match match = diff.getMatch();
					AttributeChangeOp attributeDelta = new AttributeChangeOp(affectedAttribute, newValue, match.getRight() );
					operationalDelta.addOperation(attributeDelta);
				}
			} else if (diff instanceof ReferenceChangeImpl) {
				if (diff.getKind() == DifferenceKind.ADD) {
					ReferenceChangeImpl refChgSpec = (ReferenceChangeImpl) diff;
					JavaBasedEdge edge = new JavaBasedEdge(extractSrcOfEdge(refChgSpec), refChgSpec.getValue(), refChgSpec.getReference()); 
					AddEdgeOp addEdgeOp = new AddEdgeOp(edge);
					AddNodeOp addNodeOp = new AddNodeOp(refChgSpec.getValue());
					
					operationalDelta.addOperation(addEdgeOp);
					operationalDelta.addOperation(addNodeOp);
				} else if (diff.getKind().equals(DifferenceKind.DELETE)) {
					JavaBasedEdge edge = new JavaBasedEdge(((ReferenceChangeImpl) diff).getValue().eContainer(), ((ReferenceChangeImpl) diff).getValue(), ((ReferenceChangeImpl) diff).getReference()); 
					DeleteEdgeOp removeEdgeOp = new DeleteEdgeOp(edge);
					DeleteNodeOp removeNodeOp = new DeleteNodeOp(((ReferenceChangeImpl) diff).getValue());
					
					operationalDelta.addOperation(removeEdgeOp);
					operationalDelta.addOperation(removeNodeOp);
				} else if (diff.getKind().equals(DifferenceKind.MOVE)) {
					ReferenceChangeImpl refChgSpec = (ReferenceChangeImpl) diff;
					EObject movedNode = refChgSpec.getValue();
					EObject container = movedNode.eContainer();
					EStructuralFeature containmentFeature = movedNode.eContainmentFeature();
					MoveNodeOp moveNodeOp = null;
					if(containmentFeature != null) {
			    		  Object children = container.eGet(containmentFeature);
			    		  if(children instanceof EList){
			    			  @SuppressWarnings("unchecked")
							EList<EObject> listOfChildren = (EList<EObject>) children;
			    			  moveNodeOp = new MoveNodeOp(movedNode, listOfChildren.indexOf(movedNode));
			    			  operationalDelta.addOperation(moveNodeOp);
			    		  }
					}					
					
				}
			}
			logger.debug("d.toString():" + diff);
			logger.debug("d.getKind(): " + diff.getKind());
			logger.debug("d.getMatch(): " + diff.getMatch());

			logger.debug("=========================================================");
		}
		logger.debug("------------------ Comparison Complete --------------------");
		
		return operationalDelta;
	}

	private EObject extractSrcOfEdge(ReferenceChangeImpl refChgSpec) {
		EObject oldObject = refChgSpec.getMatch().getRight();
		EObject newObject = refChgSpec.getMatch().getLeft();
		
		// Handle case where old object is null, i.e., the source of the edge is itself newly created
		return oldObject != null? oldObject : newObject;
	}

	private Comparison compareModels(M oldModel, M newModel) {
		IComparisonScope scope = new DefaultComparisonScope(newModel, oldModel, null);
		IDiffEngine diffEngine = new DefaultDiffEngine();
		EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine).build();
		Comparison comparison = comparator.compare(scope);
		return comparison;
	}
}
