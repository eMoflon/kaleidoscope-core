/**
 */
package SimpleJava;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaCompilationUnit#getName <em>Name</em>}</li>
 *   <li>{@link SimpleJava.JavaCompilationUnit#getImports <em>Imports</em>}</li>
 *   <li>{@link SimpleJava.JavaCompilationUnit#getMethods <em>Methods</em>}</li>
 *   <li>{@link SimpleJava.JavaCompilationUnit#getFieldDeclarations <em>Field Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaCompilationUnit()
 * @model
 * @generated
 */
public interface JavaCompilationUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see SimpleJava.SimpleJavaPackage#getJavaCompilationUnit_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaCompilationUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link SimpleJava.JavaImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see SimpleJava.SimpleJavaPackage#getJavaCompilationUnit_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<JavaImport> getImports();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link SimpleJava.JavaMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see SimpleJava.SimpleJavaPackage#getJavaCompilationUnit_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<JavaMethod> getMethods();

	/**
	 * Returns the value of the '<em><b>Field Declarations</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field Declarations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Declarations</em>' attribute.
	 * @see #setFieldDeclarations(String)
	 * @see SimpleJava.SimpleJavaPackage#getJavaCompilationUnit_FieldDeclarations()
	 * @model default=""
	 * @generated
	 */
	String getFieldDeclarations();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaCompilationUnit#getFieldDeclarations <em>Field Declarations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Declarations</em>' attribute.
	 * @see #getFieldDeclarations()
	 * @generated
	 */
	void setFieldDeclarations(String value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaCompilationUnit
