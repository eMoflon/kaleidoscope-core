/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.AttributeDelta#getAffectedAttribute <em>Affected Attribute</em>}</li>
 *   <li>{@link KaleidoscopeDelta.AttributeDelta#getOldValue <em>Old Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeDelta()
 * @model
 * @generated
 */
public interface AttributeDelta extends EObject {
	/**
	 * Returns the value of the '<em><b>Affected Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Attribute</em>' reference.
	 * @see #setAffectedAttribute(EAttribute)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeDelta_AffectedAttribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAffectedAttribute();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AttributeDelta#getAffectedAttribute <em>Affected Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Attribute</em>' reference.
	 * @see #getAffectedAttribute()
	 * @generated
	 */
	void setAffectedAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(Object)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAttributeDelta_OldValue()
	 * @model required="true"
	 * @generated
	 */
	Object getOldValue();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AttributeDelta#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(Object value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // AttributeDelta
