/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.EdgeImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.EdgeImpl#getTrg <em>Trg</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.EdgeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends EObjectImpl implements Edge {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected EObject src;

	/**
	 * The cached value of the '{@link #getTrg() <em>Trg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrg()
	 * @generated
	 * @ordered
	 */
	protected EObject trg;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EReference type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject) src;
			src = eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KaleidoscopeDeltaPackage.EDGE__SRC,
							oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(EObject newSrc) {
		EObject oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.EDGE__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTrg() {
		if (trg != null && trg.eIsProxy()) {
			InternalEObject oldTrg = (InternalEObject) trg;
			trg = eResolveProxy(oldTrg);
			if (trg != oldTrg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KaleidoscopeDeltaPackage.EDGE__TRG,
							oldTrg, trg));
			}
		}
		return trg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTrg() {
		return trg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrg(EObject newTrg) {
		EObject oldTrg = trg;
		trg = newTrg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.EDGE__TRG, oldTrg, trg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (EReference) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KaleidoscopeDeltaPackage.EDGE__TYPE,
							oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EReference newType) {
		EReference oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.EDGE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.EDGE__SRC:
			if (resolve)
				return getSrc();
			return basicGetSrc();
		case KaleidoscopeDeltaPackage.EDGE__TRG:
			if (resolve)
				return getTrg();
			return basicGetTrg();
		case KaleidoscopeDeltaPackage.EDGE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
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
		case KaleidoscopeDeltaPackage.EDGE__SRC:
			setSrc((EObject) newValue);
			return;
		case KaleidoscopeDeltaPackage.EDGE__TRG:
			setTrg((EObject) newValue);
			return;
		case KaleidoscopeDeltaPackage.EDGE__TYPE:
			setType((EReference) newValue);
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
		case KaleidoscopeDeltaPackage.EDGE__SRC:
			setSrc((EObject) null);
			return;
		case KaleidoscopeDeltaPackage.EDGE__TRG:
			setTrg((EObject) null);
			return;
		case KaleidoscopeDeltaPackage.EDGE__TYPE:
			setType((EReference) null);
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
		case KaleidoscopeDeltaPackage.EDGE__SRC:
			return src != null;
		case KaleidoscopeDeltaPackage.EDGE__TRG:
			return trg != null;
		case KaleidoscopeDeltaPackage.EDGE__TYPE:
			return type != null;
		}
		return super.eIsSet(featureID);
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //EdgeImpl
