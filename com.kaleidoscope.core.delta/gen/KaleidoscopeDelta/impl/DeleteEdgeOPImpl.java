/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Edge OP</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.DeleteEdgeOPImpl#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeleteEdgeOPImpl extends OperationImpl implements DeleteEdgeOP {
	/**
	 * The cached value of the '{@link #getEdge() <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge()
	 * @generated
	 * @ordered
	 */
	protected Edge edge;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteEdgeOPImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.DELETE_EDGE_OP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge() {
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdge(Edge newEdge, NotificationChain msgs) {
		Edge oldEdge = edge;
		edge = newEdge;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE, oldEdge, newEdge);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(Edge newEdge) {
		if (newEdge != edge) {
			NotificationChain msgs = null;
			if (edge != null)
				msgs = ((InternalEObject) edge).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE, null, msgs);
			if (newEdge != null)
				msgs = ((InternalEObject) newEdge).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE, null, msgs);
			msgs = basicSetEdge(newEdge, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE,
					newEdge, newEdge));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE:
			return basicSetEdge(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE:
			return getEdge();
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
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE:
			setEdge((Edge) newValue);
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
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE:
			setEdge((Edge) null);
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
		case KaleidoscopeDeltaPackage.DELETE_EDGE_OP__EDGE:
			return edge != null;
		}
		return super.eIsSet(featureID);
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //DeleteEdgeOPImpl
