/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Change OP</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.AttributeChangeOPImpl#getNewValue <em>New Value</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.AttributeChangeOPImpl#getAttr <em>Attr</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.AttributeChangeOPImpl#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeChangeOPImpl extends OperationImpl implements AttributeChangeOP {
	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object NEW_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected Object newValue = NEW_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttr() <em>Attr</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttr()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attr;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected EObject node;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeChangeOPImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.ATTRIBUTE_CHANGE_OP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(Object newNewValue) {
		Object oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttr() {
		if (attr != null && attr.eIsProxy()) {
			InternalEObject oldAttr = (InternalEObject) attr;
			attr = (EAttribute) eResolveProxy(oldAttr);
			if (attr != oldAttr) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR, oldAttr, attr));
			}
		}
		return attr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttr() {
		return attr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttr(EAttribute newAttr) {
		EAttribute oldAttr = attr;
		attr = newAttr;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR,
					oldAttr, attr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject) node;
			node = eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(EObject newNode) {
		EObject oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE,
					oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NEW_VALUE:
			return getNewValue();
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR:
			if (resolve)
				return getAttr();
			return basicGetAttr();
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE:
			if (resolve)
				return getNode();
			return basicGetNode();
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
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NEW_VALUE:
			setNewValue(newValue);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR:
			setAttr((EAttribute) newValue);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE:
			setNode((EObject) newValue);
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
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NEW_VALUE:
			setNewValue(NEW_VALUE_EDEFAULT);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR:
			setAttr((EAttribute) null);
			return;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE:
			setNode((EObject) null);
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
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NEW_VALUE:
			return NEW_VALUE_EDEFAULT == null ? newValue != null : !NEW_VALUE_EDEFAULT.equals(newValue);
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__ATTR:
			return attr != null;
		case KaleidoscopeDeltaPackage.ATTRIBUTE_CHANGE_OP__NODE:
			return node != null;
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
		result.append(" (newValue: ");
		result.append(newValue);
		result.append(')');
		return result.toString();
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //AttributeChangeOPImpl
