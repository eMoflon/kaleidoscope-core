/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Change OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.AttributeChangeOP#getNewValue <em>New Value</em>}</li>
 *   <li>{@link KaleidoscopeDelta.AttributeChangeOP#getAttr <em>Attr</em>}</li>
 *   <li>{@link KaleidoscopeDelta.AttributeChangeOP#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeChangeOP()
 * @model
 * @generated
 */
public interface AttributeChangeOP extends Operation {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(Object)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeChangeOP_NewValue()
	 * @model
	 * @generated
	 */
	Object getNewValue();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AttributeChangeOP#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(Object value);

	/**
	 * Returns the value of the '<em><b>Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr</em>' reference.
	 * @see #setAttr(EAttribute)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeChangeOP_Attr()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttr();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AttributeChangeOP#getAttr <em>Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attr</em>' reference.
	 * @see #getAttr()
	 * @generated
	 */
	void setAttr(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(EObject)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeChangeOP_Node()
	 * @model required="true"
	 * @generated
	 */
	EObject getNode();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AttributeChangeOP#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(EObject value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // AttributeChangeOP
