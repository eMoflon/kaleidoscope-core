/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moved Node Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.MovedNodeDelta#getMovedNode <em>Moved Node</em>}</li>
 *   <li>{@link KaleidoscopeDelta.MovedNodeDelta#getOldIndex <em>Old Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMovedNodeDelta()
 * @model
 * @generated
 */
public interface MovedNodeDelta extends EObject {
	/**
	 * Returns the value of the '<em><b>Moved Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moved Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moved Node</em>' reference.
	 * @see #setMovedNode(EObject)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMovedNodeDelta_MovedNode()
	 * @model required="true"
	 * @generated
	 */
	EObject getMovedNode();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.MovedNodeDelta#getMovedNode <em>Moved Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moved Node</em>' reference.
	 * @see #getMovedNode()
	 * @generated
	 */
	void setMovedNode(EObject value);

	/**
	 * Returns the value of the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Index</em>' attribute.
	 * @see #setOldIndex(int)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMovedNodeDelta_OldIndex()
	 * @model
	 * @generated
	 */
	int getOldIndex();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.MovedNodeDelta#getOldIndex <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Index</em>' attribute.
	 * @see #getOldIndex()
	 * @generated
	 */
	void setOldIndex(int value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // MovedNodeDelta
