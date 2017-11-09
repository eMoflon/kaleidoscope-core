/**
 */
package KaleidoscopeDelta.impl;

import KaleidoscopeDelta.AttributeDelta;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaPackage;
import KaleidoscopeDelta.MovedNodeDelta;
import KaleidoscopeDelta.StructuralDelta;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structural Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getAddedEdges <em>Added Edges</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getDeletedEdges <em>Deleted Edges</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getChangedAttributes <em>Changed Attributes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getAddedNodes <em>Added Nodes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getDeletedNodes <em>Deleted Nodes</em>}</li>
 *   <li>{@link KaleidoscopeDelta.impl.StructuralDeltaImpl#getMovedNodes <em>Moved Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructuralDeltaImpl extends DeltaImpl implements StructuralDelta {
	/**
	 * The cached value of the '{@link #getAddedEdges() <em>Added Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> addedEdges;

	/**
	 * The cached value of the '{@link #getDeletedEdges() <em>Deleted Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> deletedEdges;

	/**
	 * The cached value of the '{@link #getChangedAttributes() <em>Changed Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeDelta> changedAttributes;

	/**
	 * The cached value of the '{@link #getAddedNodes() <em>Added Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> addedNodes;

	/**
	 * The cached value of the '{@link #getDeletedNodes() <em>Deleted Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> deletedNodes;

	/**
	 * The cached value of the '{@link #getMovedNodes() <em>Moved Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<MovedNodeDelta> movedNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuralDeltaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KaleidoscopeDeltaPackage.Literals.STRUCTURAL_DELTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getAddedEdges() {
		if (addedEdges == null) {
			addedEdges = new EObjectContainmentEList<Edge>(Edge.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES);
		}
		return addedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getDeletedEdges() {
		if (deletedEdges == null) {
			deletedEdges = new EObjectContainmentEList<Edge>(Edge.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES);
		}
		return deletedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeDelta> getChangedAttributes() {
		if (changedAttributes == null) {
			changedAttributes = new EObjectContainmentEList<AttributeDelta>(AttributeDelta.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES);
		}
		return changedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getAddedNodes() {
		if (addedNodes == null) {
			addedNodes = new EObjectResolvingEList<EObject>(EObject.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_NODES);
		}
		return addedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getDeletedNodes() {
		if (deletedNodes == null) {
			deletedNodes = new EObjectContainmentEList<EObject>(EObject.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES);
		}
		return deletedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MovedNodeDelta> getMovedNodes() {
		if (movedNodes == null) {
			movedNodes = new EObjectResolvingEList<MovedNodeDelta>(MovedNodeDelta.class, this,
					KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__MOVED_NODES);
		}
		return movedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES:
			return ((InternalEList<?>) getAddedEdges()).basicRemove(otherEnd, msgs);
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES:
			return ((InternalEList<?>) getDeletedEdges()).basicRemove(otherEnd, msgs);
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES:
			return ((InternalEList<?>) getChangedAttributes()).basicRemove(otherEnd, msgs);
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES:
			return ((InternalEList<?>) getDeletedNodes()).basicRemove(otherEnd, msgs);
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
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES:
			return getAddedEdges();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES:
			return getDeletedEdges();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES:
			return getChangedAttributes();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_NODES:
			return getAddedNodes();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES:
			return getDeletedNodes();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__MOVED_NODES:
			return getMovedNodes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES:
			getAddedEdges().clear();
			getAddedEdges().addAll((Collection<? extends Edge>) newValue);
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES:
			getDeletedEdges().clear();
			getDeletedEdges().addAll((Collection<? extends Edge>) newValue);
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES:
			getChangedAttributes().clear();
			getChangedAttributes().addAll((Collection<? extends AttributeDelta>) newValue);
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_NODES:
			getAddedNodes().clear();
			getAddedNodes().addAll((Collection<? extends EObject>) newValue);
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES:
			getDeletedNodes().clear();
			getDeletedNodes().addAll((Collection<? extends EObject>) newValue);
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__MOVED_NODES:
			getMovedNodes().clear();
			getMovedNodes().addAll((Collection<? extends MovedNodeDelta>) newValue);
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
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES:
			getAddedEdges().clear();
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES:
			getDeletedEdges().clear();
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES:
			getChangedAttributes().clear();
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_NODES:
			getAddedNodes().clear();
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES:
			getDeletedNodes().clear();
			return;
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__MOVED_NODES:
			getMovedNodes().clear();
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
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_EDGES:
			return addedEdges != null && !addedEdges.isEmpty();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_EDGES:
			return deletedEdges != null && !deletedEdges.isEmpty();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__CHANGED_ATTRIBUTES:
			return changedAttributes != null && !changedAttributes.isEmpty();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__ADDED_NODES:
			return addedNodes != null && !addedNodes.isEmpty();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__DELETED_NODES:
			return deletedNodes != null && !deletedNodes.isEmpty();
		case KaleidoscopeDeltaPackage.STRUCTURAL_DELTA__MOVED_NODES:
			return movedNodes != null && !movedNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //StructuralDeltaImpl
