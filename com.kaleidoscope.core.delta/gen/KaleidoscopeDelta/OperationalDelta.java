/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operational Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.OperationalDelta#getOperations <em>Operations</em>}</li>
 *   <li>{@link KaleidoscopeDelta.OperationalDelta#getTargetModel <em>Target Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getOperationalDelta()
 * @model
 * @generated
 */
public interface OperationalDelta extends Delta {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link KaleidoscopeDelta.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getOperationalDelta_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Target Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Model</em>' reference.
	 * @see #setTargetModel(EObject)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getOperationalDelta_TargetModel()
	 * @model
	 * @generated
	 */
	EObject getTargetModel();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.OperationalDelta#getTargetModel <em>Target Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Model</em>' reference.
	 * @see #getTargetModel()
	 * @generated
	 */
	void setTargetModel(EObject value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // OperationalDelta
