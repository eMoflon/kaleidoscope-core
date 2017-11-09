/**
 */
package KaleidoscopeDelta.util;

import KaleidoscopeDelta.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage
 * @generated
 */
public class KaleidoscopeDeltaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KaleidoscopeDeltaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KaleidoscopeDeltaSwitch() {
		if (modelPackage == null) {
			modelPackage = KaleidoscopeDeltaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case KaleidoscopeDeltaPackage.EDGE: {
			Edge edge = (Edge) theEObject;
			T result = caseEdge(edge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA: {
			AttributeDelta attributeDelta = (AttributeDelta) theEObject;
			T result = caseAttributeDelta(attributeDelta);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA: {
			MovedNodeDelta movedNodeDelta = (MovedNodeDelta) theEObject;
			T result = caseMovedNodeDelta(movedNodeDelta);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA: {
			StructuralDelta structuralDelta = (StructuralDelta) theEObject;
			T result = caseStructuralDelta(structuralDelta);
			if (result == null)
				result = caseDelta(structuralDelta);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.OPERATIONAL_DELTA: {
			OperationalDelta operationalDelta = (OperationalDelta) theEObject;
			T result = caseOperationalDelta(operationalDelta);
			if (result == null)
				result = caseDelta(operationalDelta);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.OPERATION: {
			Operation operation = (Operation) theEObject;
			T result = caseOperation(operation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.DELETE_NODE_OP: {
			DeleteNodeOP deleteNodeOP = (DeleteNodeOP) theEObject;
			T result = caseDeleteNodeOP(deleteNodeOP);
			if (result == null)
				result = caseOperation(deleteNodeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.ADD_NODE_OP: {
			AddNodeOP addNodeOP = (AddNodeOP) theEObject;
			T result = caseAddNodeOP(addNodeOP);
			if (result == null)
				result = caseOperation(addNodeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP: {
			DeleteEdgeOP deleteEdgeOP = (DeleteEdgeOP) theEObject;
			T result = caseDeleteEdgeOP(deleteEdgeOP);
			if (result == null)
				result = caseOperation(deleteEdgeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.ADD_EDGE_OP: {
			AddEdgeOP addEdgeOP = (AddEdgeOP) theEObject;
			T result = caseAddEdgeOP(addEdgeOP);
			if (result == null)
				result = caseOperation(addEdgeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.MOVE_NODE_OP: {
			MoveNodeOP moveNodeOP = (MoveNodeOP) theEObject;
			T result = caseMoveNodeOP(moveNodeOP);
			if (result == null)
				result = caseOperation(moveNodeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP: {
			AttributeChangeOP attributeChangeOP = (AttributeChangeOP) theEObject;
			T result = caseAttributeChangeOP(attributeChangeOP);
			if (result == null)
				result = caseOperation(attributeChangeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.DELTA: {
			Delta delta = (Delta) theEObject;
			T result = caseDelta(delta);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KaleidoscopeDeltaPackage.COMPOSITE_OP: {
			CompositeOP compositeOP = (CompositeOP) theEObject;
			T result = caseCompositeOP(compositeOP);
			if (result == null)
				result = caseOperation(compositeOP);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Delta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Delta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDelta(AttributeDelta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moved Node Delta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moved Node Delta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMovedNodeDelta(MovedNodeDelta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Delta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Delta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralDelta(StructuralDelta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operational Delta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operational Delta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationalDelta(OperationalDelta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Node OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteNodeOP(DeleteNodeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Node OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddNodeOP(AddNodeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Edge OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Edge OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteEdgeOP(DeleteEdgeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Edge OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Edge OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddEdgeOP(AddEdgeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Move Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Move Node OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoveNodeOP(MoveNodeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChangeOP(AttributeChangeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelta(Delta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite OP</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite OP</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeOP(CompositeOP object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //KaleidoscopeDeltaSwitch
