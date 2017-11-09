/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.AttributeDelta;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.AttributeDeltaImpl#getAffectedAttribute <em>Affected Attribute</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.AttributeDeltaImpl#getOldValue <em>Old Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeDeltaImpl extends EObjectImpl implements AttributeDelta {
	/**
	 * The cached value of the '{@link #getAffectedAttribute() <em>Affected Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute affectedAttribute;

	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object OLD_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected Object oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeDeltaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.ATTRIBUTE_DELTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAffectedAttribute() {
		if (affectedAttribute != null && affectedAttribute.eIsProxy()) {
			InternalEObject oldAffectedAttribute = (InternalEObject) affectedAttribute;
			affectedAttribute = (EAttribute) eResolveProxy(oldAffectedAttribute);
			if (affectedAttribute != oldAffectedAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE, oldAffectedAttribute,
							affectedAttribute));
			}
		}
		return affectedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAffectedAttribute() {
		return affectedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedAttribute(EAttribute newAffectedAttribute) {
		EAttribute oldAffectedAttribute = affectedAttribute;
		affectedAttribute = newAffectedAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE, oldAffectedAttribute,
					affectedAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(Object newOldValue) {
		Object oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__OLD_VALUE,
					oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE:
			if (resolve)
				return getAffectedAttribute();
			return basicGetAffectedAttribute();
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__OLD_VALUE:
			return getOldValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE:
			setAffectedAttribute((EAttribute) newValue);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__OLD_VALUE:
			setOldValue(newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE:
			setAffectedAttribute((EAttribute) null);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__OLD_VALUE:
			setOldValue(OLD_VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__AFFECTED_ATTRIBUTE:
			return affectedAttribute != null;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_DELTA__OLD_VALUE:
			return OLD_VALUE_EDEFAULT == null ? oldValue != null : !OLD_VALUE_EDEFAULT.equals(oldValue);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (oldValue: ");
		result.append(oldValue);
		result.append(')');
		return result.toString();
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //AttributeDeltaImpl
