/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KaleidoscopeDeltaFactoryImpl extends EFactoryImpl implements KaleidoscopeDeltaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KaleidoscopeDeltaFactory init() {
		try {
			KaleidoscopeDeltaFactory theKaleidoscopeDeltaFactory = (KaleidoscopeDeltaFactory) EPackage.Registry.INSTANCE
					.getEFactory(KaleidoscopeDeltaPackage.eNS_URI);
			if (theKaleidoscopeDeltaFactory != null) {
				return theKaleidoscopeDeltaFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KaleidoscopeDeltaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KaleidoscopeDeltaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case KaleidoscopeDeltaPackage.EDGE:
			return createEdge();
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA:
			return createAttributeDelta();
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA:
			return createMovedNodeDelta();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA:
			return createStructuralDelta();
		case KaleidoscopeDeltaPackage.OPERATIONAL_DELTA:
			return createOperationalDelta();
		case KaleidoscopeDeltaPackage.DELETE_NODE_OP:
			return createDeleteNodeOP();
		case KaleidoscopeDeltaPackage.ADD_NODE_OP:
			return createAddNodeOP();
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP:
			return createDeleteEdgeOP();
		case KaleidoscopeDeltaPackage.ADD_EDGE_OP:
			return createAddEdgeOP();
		case KaleidoscopeDeltaPackage.MOVE_NODE_OP:
			return createMoveNodeOP();
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP:
			return createAttributeChangeOP();
		case KaleidoscopeDeltaPackage.DELTA:
			return createDelta();
		case KaleidoscopeDeltaPackage.COMPOSITE_OP:
			return createCompositeOP();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDelta createAttributeDelta() {
		AttributeDeltaImpl attributeDelta = new AttributeDeltaImpl();
		return attributeDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MovedNodeDelta createMovedNodeDelta() {
		MovedNodeDeltaImpl movedNodeDelta = new MovedNodeDeltaImpl();
		return movedNodeDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralDelta createStructuralDelta() {
		StructuralDeltaImpl structuralDelta = new StructuralDeltaImpl();
		return structuralDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationalDelta createOperationalDelta() {
		OperationalDeltaImpl operationalDelta = new OperationalDeltaImpl();
		return operationalDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNodeOP createDeleteNodeOP() {
		DeleteNodeOPImpl deleteNodeOP = new DeleteNodeOPImpl();
		return deleteNodeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNodeOP createAddNodeOP() {
		AddNodeOPImpl addNodeOP = new AddNodeOPImpl();
		return addNodeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteEdgeOP createDeleteEdgeOP() {
		DeleteEdgeOPImpl deleteEdgeOP = new DeleteEdgeOPImpl();
		return deleteEdgeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddEdgeOP createAddEdgeOP() {
		AddEdgeOPImpl addEdgeOP = new AddEdgeOPImpl();
		return addEdgeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoveNodeOP createMoveNodeOP() {
		MoveNodeOPImpl moveNodeOP = new MoveNodeOPImpl();
		return moveNodeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeChangeOP createAttributeChangeOP() {
		AttributeChangeOPImpl attributeChangeOP = new AttributeChangeOPImpl();
		return attributeChangeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delta createDelta() {
		DeltaImpl delta = new DeltaImpl();
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeOP createCompositeOP() {
		CompositeOPImpl compositeOP = new CompositeOPImpl();
		return compositeOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KaleidoscopeDeltaPackage getKaleidoscopeDeltaPackage() {
		return (KaleidoscopeDeltaPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KaleidoscopeDeltaPackage getPackage() {
		return KaleidoscopeDeltaPackage.eINSTANCE;
	}

} //KaleidoscopeDeltaFactoryImpl
