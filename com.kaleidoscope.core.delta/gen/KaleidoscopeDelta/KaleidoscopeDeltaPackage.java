/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see KaleidoscopeDelta.KaleidoscopeDeltaFactory
 * @model kind="package"
 * @generated
 */
public interface KaleidoscopeDeltaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "KaleidoscopeDelta";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/com.kaleidoscope.core.delta/model/KaleidoscopeDelta.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.kaleidoscope.core.delta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KaleidoscopeDeltaPackage eINSTANCE = KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl.init();

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.EdgeImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SRC = 0;

	/**
	 * The feature id for the '<em><b>Trg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TRG = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.AttributeDeltaImpl <em>Attribute Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.AttributeDeltaImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAttributeDelta()
	 * @generated
	 */
	int ATTRIBUTE_DELTA = 1;

	/**
	 * The feature id for the '<em><b>Affected Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DELTA__OLD_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Attribute Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DELTA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DELTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.MovedNodeDeltaImpl <em>Moved Node Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.MovedNodeDeltaImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getMovedNodeDelta()
	 * @generated
	 */
	int MOVED_NODE_DELTA = 2;

	/**
	 * The feature id for the '<em><b>Moved Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_NODE_DELTA__MOVED_NODE = 0;

	/**
	 * The feature id for the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_NODE_DELTA__OLD_INDEX = 1;

	/**
	 * The number of structural features of the '<em>Moved Node Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_NODE_DELTA_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Moved Node Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVED_NODE_DELTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.DeltaImpl <em>Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.DeltaImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDelta()
	 * @generated
	 */
	int DELTA = 12;

	/**
	 * The number of structural features of the '<em>Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.StructuralDeltaImpl <em>Structural Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.StructuralDeltaImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getStructuralDelta()
	 * @generated
	 */
	int STRUCTURAL_DELTA = 3;

	/**
	 * The feature id for the '<em><b>Added Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__ADDED_EDGES = DELTA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deleted Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__DELETED_EDGES = DELTA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Changed Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__CHANGED_ATTRIBUTES = DELTA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Added Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__ADDED_NODES = DELTA_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Deleted Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__DELETED_NODES = DELTA_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Moved Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA__MOVED_NODES = DELTA_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Structural Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA_FEATURE_COUNT = DELTA_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Structural Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_DELTA_OPERATION_COUNT = DELTA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.OperationalDeltaImpl <em>Operational Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.OperationalDeltaImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getOperationalDelta()
	 * @generated
	 */
	int OPERATIONAL_DELTA = 4;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_DELTA__OPERATIONS = DELTA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_DELTA__TARGET_MODEL = DELTA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operational Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_DELTA_FEATURE_COUNT = DELTA_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operational Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATIONAL_DELTA_OPERATION_COUNT = DELTA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.OperationImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 5;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.DeleteNodeOPImpl <em>Delete Node OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.DeleteNodeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDeleteNodeOP()
	 * @generated
	 */
	int DELETE_NODE_OP = 6;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_OP__NODE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.AddNodeOPImpl <em>Add Node OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.AddNodeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAddNodeOP()
	 * @generated
	 */
	int ADD_NODE_OP = 7;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE_OP__NODE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Add Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NODE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.DeleteEdgeOPImpl <em>Delete Edge OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.DeleteEdgeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDeleteEdgeOP()
	 * @generated
	 */
	int DELETE_EDGE_OP = 8;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_EDGE_OP__EDGE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Edge OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_EDGE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete Edge OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_EDGE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.AddEdgeOPImpl <em>Add Edge OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.AddEdgeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAddEdgeOP()
	 * @generated
	 */
	int ADD_EDGE_OP = 9;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE_OP__EDGE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Edge OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Add Edge OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_EDGE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.MoveNodeOPImpl <em>Move Node OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.MoveNodeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getMoveNodeOP()
	 * @generated
	 */
	int MOVE_NODE_OP = 10;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_NODE_OP__NEW_INDEX = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_NODE_OP__NODE = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Move Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_NODE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Move Node OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVE_NODE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.AttributeChangeOPImpl <em>Attribute Change OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.AttributeChangeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAttributeChangeOP()
	 * @generated
	 */
	int ATTRIBUTE_CHANGE_OP = 11;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OP__NEW_VALUE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OP__ATTR = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OP__NODE = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Change OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Attribute Change OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link KaleidoscopeDelta.impl.CompositeOPImpl <em>Composite OP</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see KaleidoscopeDelta.impl.CompositeOPImpl
	 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getCompositeOP()
	 * @generated
	 */
	int COMPOSITE_OP = 13;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OP__OPERATIONS = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OP_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite OP</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OP_OPERATION_COUNT = OPERATION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see KaleidoscopeDelta.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.Edge#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see KaleidoscopeDelta.Edge#getSrc()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Src();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.Edge#getTrg <em>Trg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trg</em>'.
	 * @see KaleidoscopeDelta.Edge#getTrg()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Trg();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.Edge#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see KaleidoscopeDelta.Edge#getType()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Type();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.AttributeDelta <em>Attribute Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Delta</em>'.
	 * @see KaleidoscopeDelta.AttributeDelta
	 * @generated
	 */
	EClass getAttributeDelta();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.AttributeDelta#getAffectedAttribute <em>Affected Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Attribute</em>'.
	 * @see KaleidoscopeDelta.AttributeDelta#getAffectedAttribute()
	 * @see #getAttributeDelta()
	 * @generated
	 */
	EReference getAttributeDelta_AffectedAttribute();

	/**
	 * Returns the meta object for the attribute '{@link KaleidoscopeDelta.AttributeDelta#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see KaleidoscopeDelta.AttributeDelta#getOldValue()
	 * @see #getAttributeDelta()
	 * @generated
	 */
	EAttribute getAttributeDelta_OldValue();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.MovedNodeDelta <em>Moved Node Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moved Node Delta</em>'.
	 * @see KaleidoscopeDelta.MovedNodeDelta
	 * @generated
	 */
	EClass getMovedNodeDelta();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.MovedNodeDelta#getMovedNode <em>Moved Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Moved Node</em>'.
	 * @see KaleidoscopeDelta.MovedNodeDelta#getMovedNode()
	 * @see #getMovedNodeDelta()
	 * @generated
	 */
	EReference getMovedNodeDelta_MovedNode();

	/**
	 * Returns the meta object for the attribute '{@link KaleidoscopeDelta.MovedNodeDelta#getOldIndex <em>Old Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Index</em>'.
	 * @see KaleidoscopeDelta.MovedNodeDelta#getOldIndex()
	 * @see #getMovedNodeDelta()
	 * @generated
	 */
	EAttribute getMovedNodeDelta_OldIndex();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.StructuralDelta <em>Structural Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Delta</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta
	 * @generated
	 */
	EClass getStructuralDelta();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.StructuralDelta#getAddedEdges <em>Added Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Added Edges</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getAddedEdges()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_AddedEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.StructuralDelta#getDeletedEdges <em>Deleted Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deleted Edges</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getDeletedEdges()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_DeletedEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.StructuralDelta#getChangedAttributes <em>Changed Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changed Attributes</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getChangedAttributes()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_ChangedAttributes();

	/**
	 * Returns the meta object for the reference list '{@link KaleidoscopeDelta.StructuralDelta#getAddedNodes <em>Added Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Added Nodes</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getAddedNodes()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_AddedNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.StructuralDelta#getDeletedNodes <em>Deleted Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deleted Nodes</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getDeletedNodes()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_DeletedNodes();

	/**
	 * Returns the meta object for the reference list '{@link KaleidoscopeDelta.StructuralDelta#getMovedNodes <em>Moved Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Moved Nodes</em>'.
	 * @see KaleidoscopeDelta.StructuralDelta#getMovedNodes()
	 * @see #getStructuralDelta()
	 * @generated
	 */
	EReference getStructuralDelta_MovedNodes();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.OperationalDelta <em>Operational Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operational Delta</em>'.
	 * @see KaleidoscopeDelta.OperationalDelta
	 * @generated
	 */
	EClass getOperationalDelta();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.OperationalDelta#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see KaleidoscopeDelta.OperationalDelta#getOperations()
	 * @see #getOperationalDelta()
	 * @generated
	 */
	EReference getOperationalDelta_Operations();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.OperationalDelta#getTargetModel <em>Target Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Model</em>'.
	 * @see KaleidoscopeDelta.OperationalDelta#getTargetModel()
	 * @see #getOperationalDelta()
	 * @generated
	 */
	EReference getOperationalDelta_TargetModel();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see KaleidoscopeDelta.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.DeleteNodeOP <em>Delete Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Node OP</em>'.
	 * @see KaleidoscopeDelta.DeleteNodeOP
	 * @generated
	 */
	EClass getDeleteNodeOP();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.DeleteNodeOP#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see KaleidoscopeDelta.DeleteNodeOP#getNode()
	 * @see #getDeleteNodeOP()
	 * @generated
	 */
	EReference getDeleteNodeOP_Node();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.AddNodeOP <em>Add Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Node OP</em>'.
	 * @see KaleidoscopeDelta.AddNodeOP
	 * @generated
	 */
	EClass getAddNodeOP();

	/**
	 * Returns the meta object for the containment reference '{@link KaleidoscopeDelta.AddNodeOP#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see KaleidoscopeDelta.AddNodeOP#getNode()
	 * @see #getAddNodeOP()
	 * @generated
	 */
	EReference getAddNodeOP_Node();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.DeleteEdgeOP <em>Delete Edge OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Edge OP</em>'.
	 * @see KaleidoscopeDelta.DeleteEdgeOP
	 * @generated
	 */
	EClass getDeleteEdgeOP();

	/**
	 * Returns the meta object for the containment reference '{@link KaleidoscopeDelta.DeleteEdgeOP#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see KaleidoscopeDelta.DeleteEdgeOP#getEdge()
	 * @see #getDeleteEdgeOP()
	 * @generated
	 */
	EReference getDeleteEdgeOP_Edge();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.AddEdgeOP <em>Add Edge OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Edge OP</em>'.
	 * @see KaleidoscopeDelta.AddEdgeOP
	 * @generated
	 */
	EClass getAddEdgeOP();

	/**
	 * Returns the meta object for the containment reference '{@link KaleidoscopeDelta.AddEdgeOP#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edge</em>'.
	 * @see KaleidoscopeDelta.AddEdgeOP#getEdge()
	 * @see #getAddEdgeOP()
	 * @generated
	 */
	EReference getAddEdgeOP_Edge();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.MoveNodeOP <em>Move Node OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Move Node OP</em>'.
	 * @see KaleidoscopeDelta.MoveNodeOP
	 * @generated
	 */
	EClass getMoveNodeOP();

	/**
	 * Returns the meta object for the attribute '{@link KaleidoscopeDelta.MoveNodeOP#getNewIndex <em>New Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Index</em>'.
	 * @see KaleidoscopeDelta.MoveNodeOP#getNewIndex()
	 * @see #getMoveNodeOP()
	 * @generated
	 */
	EAttribute getMoveNodeOP_NewIndex();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.MoveNodeOP#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see KaleidoscopeDelta.MoveNodeOP#getNode()
	 * @see #getMoveNodeOP()
	 * @generated
	 */
	EReference getMoveNodeOP_Node();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.AttributeChangeOP <em>Attribute Change OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Change OP</em>'.
	 * @see KaleidoscopeDelta.AttributeChangeOP
	 * @generated
	 */
	EClass getAttributeChangeOP();

	/**
	 * Returns the meta object for the attribute '{@link KaleidoscopeDelta.AttributeChangeOP#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see KaleidoscopeDelta.AttributeChangeOP#getNewValue()
	 * @see #getAttributeChangeOP()
	 * @generated
	 */
	EAttribute getAttributeChangeOP_NewValue();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.AttributeChangeOP#getAttr <em>Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attr</em>'.
	 * @see KaleidoscopeDelta.AttributeChangeOP#getAttr()
	 * @see #getAttributeChangeOP()
	 * @generated
	 */
	EReference getAttributeChangeOP_Attr();

	/**
	 * Returns the meta object for the reference '{@link KaleidoscopeDelta.AttributeChangeOP#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see KaleidoscopeDelta.AttributeChangeOP#getNode()
	 * @see #getAttributeChangeOP()
	 * @generated
	 */
	EReference getAttributeChangeOP_Node();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.Delta <em>Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta</em>'.
	 * @see KaleidoscopeDelta.Delta
	 * @generated
	 */
	EClass getDelta();

	/**
	 * Returns the meta object for class '{@link KaleidoscopeDelta.CompositeOP <em>Composite OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite OP</em>'.
	 * @see KaleidoscopeDelta.CompositeOP
	 * @generated
	 */
	EClass getCompositeOP();

	/**
	 * Returns the meta object for the containment reference list '{@link KaleidoscopeDelta.CompositeOP#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see KaleidoscopeDelta.CompositeOP#getOperations()
	 * @see #getCompositeOP()
	 * @generated
	 */
	EReference getCompositeOP_Operations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KaleidoscopeDeltaFactory getKaleidoscopeDeltaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.EdgeImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SRC = eINSTANCE.getEdge_Src();

		/**
		 * The meta object literal for the '<em><b>Trg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TRG = eINSTANCE.getEdge_Trg();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TYPE = eINSTANCE.getEdge_Type();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.AttributeDeltaImpl <em>Attribute Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.AttributeDeltaImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAttributeDelta()
		 * @generated
		 */
		EClass ATTRIBUTE_DELTA = eINSTANCE.getAttributeDelta();

		/**
		 * The meta object literal for the '<em><b>Affected Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE = eINSTANCE.getAttributeDelta_AffectedAttribute();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DELTA__OLD_VALUE = eINSTANCE.getAttributeDelta_OldValue();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.MovedNodeDeltaImpl <em>Moved Node Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.MovedNodeDeltaImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getMovedNodeDelta()
		 * @generated
		 */
		EClass MOVED_NODE_DELTA = eINSTANCE.getMovedNodeDelta();

		/**
		 * The meta object literal for the '<em><b>Moved Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVED_NODE_DELTA__MOVED_NODE = eINSTANCE.getMovedNodeDelta_MovedNode();

		/**
		 * The meta object literal for the '<em><b>Old Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVED_NODE_DELTA__OLD_INDEX = eINSTANCE.getMovedNodeDelta_OldIndex();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.StructuralDeltaImpl <em>Structural Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.StructuralDeltaImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getStructuralDelta()
		 * @generated
		 */
		EClass STRUCTURAL_DELTA = eINSTANCE.getStructuralDelta();

		/**
		 * The meta object literal for the '<em><b>Added Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__ADDED_EDGES = eINSTANCE.getStructuralDelta_AddedEdges();

		/**
		 * The meta object literal for the '<em><b>Deleted Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__DELETED_EDGES = eINSTANCE.getStructuralDelta_DeletedEdges();

		/**
		 * The meta object literal for the '<em><b>Changed Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__CHANGED_ATTRIBUTES = eINSTANCE.getStructuralDelta_ChangedAttributes();

		/**
		 * The meta object literal for the '<em><b>Added Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__ADDED_NODES = eINSTANCE.getStructuralDelta_AddedNodes();

		/**
		 * The meta object literal for the '<em><b>Deleted Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__DELETED_NODES = eINSTANCE.getStructuralDelta_DeletedNodes();

		/**
		 * The meta object literal for the '<em><b>Moved Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_DELTA__MOVED_NODES = eINSTANCE.getStructuralDelta_MovedNodes();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.OperationalDeltaImpl <em>Operational Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.OperationalDeltaImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getOperationalDelta()
		 * @generated
		 */
		EClass OPERATIONAL_DELTA = eINSTANCE.getOperationalDelta();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONAL_DELTA__OPERATIONS = eINSTANCE.getOperationalDelta_Operations();

		/**
		 * The meta object literal for the '<em><b>Target Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATIONAL_DELTA__TARGET_MODEL = eINSTANCE.getOperationalDelta_TargetModel();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.OperationImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.DeleteNodeOPImpl <em>Delete Node OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.DeleteNodeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDeleteNodeOP()
		 * @generated
		 */
		EClass DELETE_NODE_OP = eINSTANCE.getDeleteNodeOP();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_NODE_OP__NODE = eINSTANCE.getDeleteNodeOP_Node();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.AddNodeOPImpl <em>Add Node OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.AddNodeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAddNodeOP()
		 * @generated
		 */
		EClass ADD_NODE_OP = eINSTANCE.getAddNodeOP();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_NODE_OP__NODE = eINSTANCE.getAddNodeOP_Node();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.DeleteEdgeOPImpl <em>Delete Edge OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.DeleteEdgeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDeleteEdgeOP()
		 * @generated
		 */
		EClass DELETE_EDGE_OP = eINSTANCE.getDeleteEdgeOP();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_EDGE_OP__EDGE = eINSTANCE.getDeleteEdgeOP_Edge();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.AddEdgeOPImpl <em>Add Edge OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.AddEdgeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAddEdgeOP()
		 * @generated
		 */
		EClass ADD_EDGE_OP = eINSTANCE.getAddEdgeOP();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_EDGE_OP__EDGE = eINSTANCE.getAddEdgeOP_Edge();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.MoveNodeOPImpl <em>Move Node OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.MoveNodeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getMoveNodeOP()
		 * @generated
		 */
		EClass MOVE_NODE_OP = eINSTANCE.getMoveNodeOP();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOVE_NODE_OP__NEW_INDEX = eINSTANCE.getMoveNodeOP_NewIndex();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOVE_NODE_OP__NODE = eINSTANCE.getMoveNodeOP_Node();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.AttributeChangeOPImpl <em>Attribute Change OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.AttributeChangeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getAttributeChangeOP()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGE_OP = eINSTANCE.getAttributeChangeOP();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_CHANGE_OP__NEW_VALUE = eINSTANCE.getAttributeChangeOP_NewValue();

		/**
		 * The meta object literal for the '<em><b>Attr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CHANGE_OP__ATTR = eINSTANCE.getAttributeChangeOP_Attr();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_CHANGE_OP__NODE = eINSTANCE.getAttributeChangeOP_Node();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.DeltaImpl <em>Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.DeltaImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getDelta()
		 * @generated
		 */
		EClass DELTA = eINSTANCE.getDelta();

		/**
		 * The meta object literal for the '{@link KaleidoscopeDelta.impl.CompositeOPImpl <em>Composite OP</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see KaleidoscopeDelta.impl.CompositeOPImpl
		 * @see KaleidoscopeDelta.impl.KaleidoscopeDeltaPackageImpl#getCompositeOP()
		 * @generated
		 */
		EClass COMPOSITE_OP = eINSTANCE.getCompositeOP();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_OP__OPERATIONS = eINSTANCE.getCompositeOP_Operations();

	}

} //KaleidoscopeDeltaPackage
