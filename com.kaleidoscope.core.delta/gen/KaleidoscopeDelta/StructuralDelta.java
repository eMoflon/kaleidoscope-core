/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getAddedEdges <em>Added Edges</em>}</li>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getDeletedEdges <em>Deleted Edges</em>}</li>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getChangedAttributes <em>Changed Attributes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getAddedNodes <em>Added Nodes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getDeletedNodes <em>Deleted Nodes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.StructuralDelta#getMovedNodes <em>Moved Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta()
 * @model
 * @generated
 */
public interface StructuralDelta extends Delta {
	/**
	 * Returns the value of the '<em><b>Added Edges</b></em>' containment reference list.
	 * The list contents are of type {@link KaleidoscopeDelta.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Added Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Edges</em>' containment reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_AddedEdges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getAddedEdges();

	/**
	 * Returns the value of the '<em><b>Deleted Edges</b></em>' containment reference list.
	 * The list contents are of type {@link KaleidoscopeDelta.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Edges</em>' containment reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_DeletedEdges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getDeletedEdges();

	/**
	 * Returns the value of the '<em><b>Changed Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link KaleidoscopeDelta.AttributeDelta}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changed Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changed Attributes</em>' containment reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_ChangedAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeDelta> getChangedAttributes();

	/**
	 * Returns the value of the '<em><b>Added Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Added Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Nodes</em>' reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_AddedNodes()
	 * @model
	 * @generated
	 */
	EList<EObject> getAddedNodes();

	/**
	 * Returns the value of the '<em><b>Deleted Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Nodes</em>' containment reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_DeletedNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getDeletedNodes();

	/**
	 * Returns the value of the '<em><b>Moved Nodes</b></em>' reference list.
	 * The list contents are of type {@link KaleidoscopeDelta.MovedNodeDelta}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moved Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moved Nodes</em>' reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getStructuralDelta_MovedNodes()
	 * @model
	 * @generated
	 */
	EList<MovedNodeDelta> getMovedNodes();
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // StructuralDelta
