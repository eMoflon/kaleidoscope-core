/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.common.util.EList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.CompositeOP#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getCompositeOP()
 * @model
 * @generated
 */
public interface CompositeOP extends Operation {
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
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getCompositeOP_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperations();
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // CompositeOP
