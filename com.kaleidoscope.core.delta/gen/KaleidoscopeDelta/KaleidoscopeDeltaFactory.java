/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage
 * @generated
 */
public interface KaleidoscopeDeltaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KaleidoscopeDeltaFactory eINSTANCE = KaleidoscopeDelta.impl.KaleidoscopeDeltaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge</em>'.
	 * @generated
	 */
	Edge createEdge();

	/**
	 * Returns a new object of class '<em>Attribute Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Delta</em>'.
	 * @generated
	 */
	AttributeDelta createAttributeDelta();

	/**
	 * Returns a new object of class '<em>Moved Node Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Moved Node Delta</em>'.
	 * @generated
	 */
	MovedNodeDelta createMovedNodeDelta();

	/**
	 * Returns a new object of class '<em>Structural Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Delta</em>'.
	 * @generated
	 */
	StructuralDelta createStructuralDelta();

	/**
	 * Returns a new object of class '<em>Operational Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operational Delta</em>'.
	 * @generated
	 */
	OperationalDelta createOperationalDelta();

	/**
	 * Returns a new object of class '<em>Delete Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Node OP</em>'.
	 * @generated
	 */
	DeleteNodeOP createDeleteNodeOP();

	/**
	 * Returns a new object of class '<em>Add Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Node OP</em>'.
	 * @generated
	 */
	AddNodeOP createAddNodeOP();

	/**
	 * Returns a new object of class '<em>Delete Edge OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Edge OP</em>'.
	 * @generated
	 */
	DeleteEdgeOP createDeleteEdgeOP();

	/**
	 * Returns a new object of class '<em>Add Edge OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Edge OP</em>'.
	 * @generated
	 */
	AddEdgeOP createAddEdgeOP();

	/**
	 * Returns a new object of class '<em>Move Node OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Move Node OP</em>'.
	 * @generated
	 */
	MoveNodeOP createMoveNodeOP();

	/**
	 * Returns a new object of class '<em>Attribute Change OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Change OP</em>'.
	 * @generated
	 */
	AttributeChangeOP createAttributeChangeOP();

	/**
	 * Returns a new object of class '<em>Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delta</em>'.
	 * @generated
	 */
	Delta createDelta();

	/**
	 * Returns a new object of class '<em>Composite OP</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite OP</em>'.
	 * @generated
	 */
	CompositeOP createCompositeOP();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KaleidoscopeDeltaPackage getKaleidoscopeDeltaPackage();

} //KaleidoscopeDeltaFactory
