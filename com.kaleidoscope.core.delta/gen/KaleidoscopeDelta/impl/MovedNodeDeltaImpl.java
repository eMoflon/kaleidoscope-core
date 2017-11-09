/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.KaleidoscopeDeltaPackage;
import KaleidoscopeDelta.MovedNodeDelta;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moved Node Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.MovedNodeDeltaImpl#getMovedNode <em>Moved Node</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.MovedNodeDeltaImpl#getOldIndex <em>Old Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovedNodeDeltaImpl extends EObjectImpl implements MovedNodeDelta {
	/**
	 * The cached value of the '{@link #getMovedNode() <em>Moved Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovedNode()
	 * @generated
	 * @ordered
	 */
	protected EObject movedNode;

	/**
	 * The default value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected int oldIndex = OLD_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MovedNodeDeltaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.MOVED_NODE_DELTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getMovedNode() {
		if (movedNode != null && movedNode.eIsProxy()) {
			InternalEObject oldMovedNode = (InternalEObject) movedNode;
			movedNode = eResolveProxy(oldMovedNode);
			if (movedNode != oldMovedNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE, oldMovedNode, movedNode));
			}
		}
		return movedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetMovedNode() {
		return movedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMovedNode(EObject newMovedNode) {
		EObject oldMovedNode = movedNode;
		movedNode = newMovedNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE,
					oldMovedNode, movedNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOldIndex() {
		return oldIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldIndex(int newOldIndex) {
		int oldOldIndex = oldIndex;
		oldIndex = newOldIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__OLD_INDEX,
					oldOldIndex, oldIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE:
			if (resolve)
				return getMovedNode();
			return basicGetMovedNode();
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__OLD_INDEX:
			return getOldIndex();
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
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE:
			setMovedNode((EObject) newValue);
			return;
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__OLD_INDEX:
			setOldIndex((Integer) newValue);
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
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE:
			setMovedNode((EObject) null);
			return;
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__OLD_INDEX:
			setOldIndex(OLD_INDEX_EDEFAULT);
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
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__MOVED_NODE:
			return movedNode != null;
		case KaleidoscopeDeltaPackage.MOVED_NODE_DELTA__OLD_INDEX:
			return oldIndex != OLD_INDEX_EDEFAULT;
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
		result.append(" (oldIndex: ");
		result.append(oldIndex);
		result.append(')');
		return result.toString();
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //MovedNodeDeltaImpl
