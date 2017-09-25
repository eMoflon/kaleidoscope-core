/**
 */
package KaleidoscopeDelta.util;

import KaleidoscopeDelta.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage
 * @generated
 */
public class KaleidoscopeDeltaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KaleidoscopeDeltaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KaleidoscopeDeltaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = KaleidoscopeDeltaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KaleidoscopeDeltaSwitch<Adapter> modelSwitch = new KaleidoscopeDeltaSwitch<Adapter>() {
		@Override
		public Adapter caseEdge(Edge object) {
			return createEdgeAdapter();
		}

		@Override
		public Adapter caseAttributeDelta(AttributeDelta object) {
			return createAttributeDeltaAdapter();
		}

		@Override
		public Adapter caseMovedNodeDelta(MovedNodeDelta object) {
			return createMovedNodeDeltaAdapter();
		}

		@Override
		public Adapter caseStructuralDelta(StructuralDelta object) {
			return createStructuralDeltaAdapter();
		}

		@Override
		public Adapter caseOperationalDelta(OperationalDelta object) {
			return createOperationalDeltaAdapter();
		}

		@Override
		public Adapter caseOperation(Operation object) {
			return createOperationAdapter();
		}

		@Override
		public Adapter caseDeleteNodeOP(DeleteNodeOP object) {
			return createDeleteNodeOPAdapter();
		}

		@Override
		public Adapter caseAddNodeOP(AddNodeOP object) {
			return createAddNodeOPAdapter();
		}

		@Override
		public Adapter caseDeleteEdgeOP(DeleteEdgeOP object) {
			return createDeleteEdgeOPAdapter();
		}

		@Override
		public Adapter caseAddEdgeOP(AddEdgeOP object) {
			return createAddEdgeOPAdapter();
		}

		@Override
		public Adapter caseMoveNodeOP(MoveNodeOP object) {
			return createMoveNodeOPAdapter();
		}

		@Override
		public Adapter caseAttributeChangeOP(AttributeChangeOP object) {
			return createAttributeChangeOPAdapter();
		}

		@Override
		public Adapter caseDelta(Delta object) {
			return createDeltaAdapter();
		}

		@Override
		public Adapter caseCompositeOP(CompositeOP object) {
			return createCompositeOPAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.AttributeDelta <em>Attribute Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.AttributeDelta
	 * @generated
	 */
	public Adapter createAttributeDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.MovedNodeDelta <em>Moved Node Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.MovedNodeDelta
	 * @generated
	 */
	public Adapter createMovedNodeDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.StructuralDelta <em>Structural Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.StructuralDelta
	 * @generated
	 */
	public Adapter createStructuralDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.OperationalDelta <em>Operational Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.OperationalDelta
	 * @generated
	 */
	public Adapter createOperationalDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.DeleteNodeOP <em>Delete Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.DeleteNodeOP
	 * @generated
	 */
	public Adapter createDeleteNodeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.AddNodeOP <em>Add Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.AddNodeOP
	 * @generated
	 */
	public Adapter createAddNodeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.DeleteEdgeOP <em>Delete Edge OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.DeleteEdgeOP
	 * @generated
	 */
	public Adapter createDeleteEdgeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.AddEdgeOP <em>Add Edge OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.AddEdgeOP
	 * @generated
	 */
	public Adapter createAddEdgeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.MoveNodeOP <em>Move Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.MoveNodeOP
	 * @generated
	 */
	public Adapter createMoveNodeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.AttributeChangeOP <em>Attribute Change OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.AttributeChangeOP
	 * @generated
	 */
	public Adapter createAttributeChangeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.Delta <em>Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.Delta
	 * @generated
	 */
	public Adapter createDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link KaleidoscopeDelta.CompositeOP <em>Composite OP</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see KaleidoscopeDelta.CompositeOP
	 * @generated
	 */
	public Adapter createCompositeOPAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //KaleidoscopeDeltaAdapterFactory
