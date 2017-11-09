/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.AttributeDelta;
import KaleidoscopeDelta.CompositeOP;
import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.Delta;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;
import KaleidoscopeDelta.MoveNodeOP;
import KaleidoscopeDelta.MovedNodeDelta;
import KaleidoscopeDelta.Operation;
import KaleidoscopeDelta.OperationalDelta;
import KaleidoscopeDelta.StructuralDelta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KaleidoscopeDeltaPackageImpl extends EPackageImpl implements KaleidoscopeDeltaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDeltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass movedNodeDeltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralDeltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationalDeltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteNodeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addNodeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEdgeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addEdgeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moveNodeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeChangeOPEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeOPEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private KaleidoscopeDeltaPackageImpl() {
		super(eNS_URI, KaleidoscopeDeltaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link KaleidoscopeDeltaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static KaleidoscopeDeltaPackage init() {
		if (isInited)
			return (KaleidoscopeDeltaPackage) EPackage.Registry.INSTANCE.getEPackage(KaleidoscopeDeltaPackage.eNS_URI);

		// Obtain or create and register package
		KaleidoscopeDeltaPackageImpl theKaleidoscopeDeltaPackage = (KaleidoscopeDeltaPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof KaleidoscopeDeltaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new KaleidoscopeDeltaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theKaleidoscopeDeltaPackage.createPackageContents();

		// Initialize created meta-data
		theKaleidoscopeDeltaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theKaleidoscopeDeltaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KaleidoscopeDeltaPackage.eNS_URI, theKaleidoscopeDeltaPackage);
		return theKaleidoscopeDeltaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Src() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Trg() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Type() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeDelta() {
		return attributeDeltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeDelta_AffectedAttribute() {
		return (EReference) attributeDeltaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeDelta_OldValue() {
		return (EAttribute) attributeDeltaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMovedNodeDelta() {
		return movedNodeDeltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMovedNodeDelta_MovedNode() {
		return (EReference) movedNodeDeltaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMovedNodeDelta_OldIndex() {
		return (EAttribute) movedNodeDeltaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralDelta() {
		return structuralDeltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_AddedEdges() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_DeletedEdges() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_ChangedAttributes() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_AddedNodes() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_DeletedNodes() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralDelta_MovedNodes() {
		return (EReference) structuralDeltaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationalDelta() {
		return operationalDeltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalDelta_Operations() {
		return (EReference) operationalDeltaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationalDelta_TargetModel() {
		return (EReference) operationalDeltaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteNodeOP() {
		return deleteNodeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteNodeOP_Node() {
		return (EReference) deleteNodeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddNodeOP() {
		return addNodeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddNodeOP_Node() {
		return (EReference) addNodeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteEdgeOP() {
		return deleteEdgeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteEdgeOP_Edge() {
		return (EReference) deleteEdgeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddEdgeOP() {
		return addEdgeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddEdgeOP_Edge() {
		return (EReference) addEdgeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoveNodeOP() {
		return moveNodeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMoveNodeOP_NewIndex() {
		return (EAttribute) moveNodeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoveNodeOP_Node() {
		return (EReference) moveNodeOPEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeChangeOP() {
		return attributeChangeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeChangeOP_NewValue() {
		return (EAttribute) attributeChangeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeChangeOP_Attr() {
		return (EReference) attributeChangeOPEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeChangeOP_Node() {
		return (EReference) attributeChangeOPEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelta() {
		return deltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeOP() {
		return compositeOPEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeOP_Operations() {
		return (EReference) compositeOPEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KaleidoscopeDeltaFactory getKaleidoscopeDeltaFactory() {
		return (KaleidoscopeDeltaFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SRC);
		createEReference(edgeEClass, EDGE__TRG);
		createEReference(edgeEClass, EDGE__TYPE);

		attributeDeltaEClass = createEClass(ATTRIBUTE_DELTA);
		createEReference(attributeDeltaEClass, ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE);
		createEAttribute(attributeDeltaEClass, ATTRIBUTE_DELTA__OLD_VALUE);

		movedNodeDeltaEClass = createEClass(MOVED_NODE_DELTA);
		createEReference(movedNodeDeltaEClass, MOVED_NODE_DELTA__MOVED_NODE);
		createEAttribute(movedNodeDeltaEClass, MOVED_NODE_DELTA__OLD_INDEX);

		structuralDeltaEClass = createEClass(STRUCTURAL_DELTA);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__ADDED_EDGES);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__DELETED_EDGES);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__CHANGED_ATTRIBUTES);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__ADDED_NODES);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__DELETED_NODES);
		createEReference(structuralDeltaEClass, STRUCTURAL_DELTA__MOVED_NODES);

		operationalDeltaEClass = createEClass(OPERATIONAL_DELTA);
		createEReference(operationalDeltaEClass, OPERATIONAL_DELTA__OPERATIONS);
		createEReference(operationalDeltaEClass, OPERATIONAL_DELTA__TARGET_MODEL);

		operationEClass = createEClass(OPERATION);

		deleteNodeOPEClass = createEClass(DELETE_NODE_OP);
		createEReference(deleteNodeOPEClass, DELETE_NODE_OP__NODE);

		addNodeOPEClass = createEClass(ADD_NODE_OP);
		createEReference(addNodeOPEClass, ADD_NODE_OP__NODE);

		deleteEdgeOPEClass = createEClass(DELETE_EDGE_OP);
		createEReference(deleteEdgeOPEClass, DELETE_EDGE_OP__EDGE);

		addEdgeOPEClass = createEClass(ADD_EDGE_OP);
		createEReference(addEdgeOPEClass, ADD_EDGE_OP__EDGE);

		moveNodeOPEClass = createEClass(MOVE_NODE_OP);
		createEAttribute(moveNodeOPEClass, MOVE_NODE_OP__NEW_INDEX);
		createEReference(moveNodeOPEClass, MOVE_NODE_OP__NODE);

		attributeChangeOPEClass = createEClass(ATTRIBUTE_CHANGE_OP);
		createEAttribute(attributeChangeOPEClass, ATTRIBUTE_CHANGE_OP__NEW_VALUE);
		createEReference(attributeChangeOPEClass, ATTRIBUTE_CHANGE_OP__ATTR);
		createEReference(attributeChangeOPEClass, ATTRIBUTE_CHANGE_OP__NODE);

		deltaEClass = createEClass(DELTA);

		compositeOPEClass = createEClass(COMPOSITE_OP);
		createEReference(compositeOPEClass, COMPOSITE_OP__OPERATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		structuralDeltaEClass.getESuperTypes().add(this.getDelta());
		operationalDeltaEClass.getESuperTypes().add(this.getDelta());
		deleteNodeOPEClass.getESuperTypes().add(this.getOperation());
		addNodeOPEClass.getESuperTypes().add(this.getOperation());
		deleteEdgeOPEClass.getESuperTypes().add(this.getOperation());
		addEdgeOPEClass.getESuperTypes().add(this.getOperation());
		moveNodeOPEClass.getESuperTypes().add(this.getOperation());
		attributeChangeOPEClass.getESuperTypes().add(this.getOperation());
		compositeOPEClass.getESuperTypes().add(this.getOperation());

		// Initialize classes, features, and operations; add parameters
		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Src(), ecorePackage.getEObject(), null, "src", null, 1, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEdge_Trg(), ecorePackage.getEObject(), null, "trg", null, 1, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEdge_Type(), ecorePackage.getEReference(), null, "type", null, 0, 1, Edge.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeDeltaEClass, AttributeDelta.class, "AttributeDelta", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeDelta_AffectedAttribute(), ecorePackage.getEAttribute(), null, "affectedAttribute",
				null, 1, 1, AttributeDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeDelta_OldValue(), ecorePackage.getEJavaObject(), "oldValue", null, 1, 1,
				AttributeDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(movedNodeDeltaEClass, MovedNodeDelta.class, "MovedNodeDelta", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMovedNodeDelta_MovedNode(), ecorePackage.getEObject(), null, "movedNode", null, 1, 1,
				MovedNodeDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMovedNodeDelta_OldIndex(), ecorePackage.getEInt(), "oldIndex", null, 0, 1,
				MovedNodeDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(structuralDeltaEClass, StructuralDelta.class, "StructuralDelta", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuralDelta_AddedEdges(), this.getEdge(), null, "addedEdges", null, 0, -1,
				StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuralDelta_DeletedEdges(), this.getEdge(), null, "deletedEdges", null, 0, -1,
				StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuralDelta_ChangedAttributes(), this.getAttributeDelta(), null, "changedAttributes",
				null, 0, -1, StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuralDelta_AddedNodes(), ecorePackage.getEObject(), null, "addedNodes", null, 0, -1,
				StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuralDelta_DeletedNodes(), ecorePackage.getEObject(), null, "deletedNodes", null, 0, -1,
				StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructuralDelta_MovedNodes(), this.getMovedNodeDelta(), null, "movedNodes", null, 0, -1,
				StructuralDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationalDeltaEClass, OperationalDelta.class, "OperationalDelta", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationalDelta_Operations(), this.getOperation(), null, "operations", null, 0, -1,
				OperationalDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationalDelta_TargetModel(), ecorePackage.getEObject(), null, "targetModel", null, 0, 1,
				OperationalDelta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteNodeOPEClass, DeleteNodeOP.class, "DeleteNodeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteNodeOP_Node(), ecorePackage.getEObject(), null, "node", null, 1, 1, DeleteNodeOP.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addNodeOPEClass, AddNodeOP.class, "AddNodeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddNodeOP_Node(), ecorePackage.getEObject(), null, "node", null, 1, 1, AddNodeOP.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteEdgeOPEClass, DeleteEdgeOP.class, "DeleteEdgeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteEdgeOP_Edge(), this.getEdge(), null, "edge", null, 1, 1, DeleteEdgeOP.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addEdgeOPEClass, AddEdgeOP.class, "AddEdgeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddEdgeOP_Edge(), this.getEdge(), null, "edge", null, 1, 1, AddEdgeOP.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(moveNodeOPEClass, MoveNodeOP.class, "MoveNodeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMoveNodeOP_NewIndex(), ecorePackage.getEInt(), "newIndex", null, 0, 1, MoveNodeOP.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMoveNodeOP_Node(), ecorePackage.getEObject(), null, "node", null, 1, 1, MoveNodeOP.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeChangeOPEClass, AttributeChangeOP.class, "AttributeChangeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeChangeOP_NewValue(), ecorePackage.getEJavaObject(), "newValue", null, 0, 1,
				AttributeChangeOP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeChangeOP_Attr(), ecorePackage.getEAttribute(), null, "attr", null, 1, 1,
				AttributeChangeOP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeChangeOP_Node(), ecorePackage.getEObject(), null, "node", null, 1, 1,
				AttributeChangeOP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deltaEClass, Delta.class, "Delta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeOPEClass, CompositeOP.class, "CompositeOP", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeOP_Operations(), this.getOperation(), null, "operations", null, 0, -1,
				CompositeOP.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //KaleidoscopeDeltaPackageImpl
