/**
 */
package SimpleJava;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaExpression#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaExpression()
 * @model
 * @generated
 */
public interface JavaExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see SimpleJava.SimpleJavaPackage#getJavaExpression_Index()
	 * @model default="-1"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaExpression#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaExpression
