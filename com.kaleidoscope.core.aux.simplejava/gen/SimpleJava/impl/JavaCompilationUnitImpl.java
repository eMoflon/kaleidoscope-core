/**
 */
package SimpleJava.impl;

import SimpleJava.JavaCompilationUnit;
import SimpleJava.JavaImport;
import SimpleJava.JavaMethod;
import SimpleJava.SimpleJavaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimpleJava.impl.JavaCompilationUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaCompilationUnitImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaCompilationUnitImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaCompilationUnitImpl#getFieldDeclarations <em>Field Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaCompilationUnitImpl extends EObjectImpl implements JavaCompilationUnit {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaImport> imports;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaMethod> methods;

	/**
	 * The default value of the '{@link #getFieldDeclarations() <em>Field Declarations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldDeclarations()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_DECLARATIONS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFieldDeclarations() <em>Field Declarations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldDeclarations()
	 * @generated
	 * @ordered
	 */
	protected String fieldDeclarations = FIELD_DECLARATIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaCompilationUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleJavaPackage.Literals.JAVA_COMPILATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_COMPILATION_UNIT__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaImport> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<JavaImport>(JavaImport.class, this,
					SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaMethod> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<JavaMethod>(JavaMethod.class, this,
					SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFieldDeclarations() {
		return fieldDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldDeclarations(String newFieldDeclarations) {
		String oldFieldDeclarations = fieldDeclarations;
		fieldDeclarations = newFieldDeclarations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SimpleJavaPackage.JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS, oldFieldDeclarations,
					fieldDeclarations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS:
			return ((InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS:
			return ((InternalEList<?>) getMethods()).basicRemove(otherEnd, msgs);
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
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__NAME:
			return getName();
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS:
			return getImports();
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS:
			return getMethods();
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS:
			return getFieldDeclarations();
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
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__NAME:
			setName((String) newValue);
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS:
			getImports().clear();
			getImports().addAll((Collection<? extends JavaImport>) newValue);
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS:
			getMethods().clear();
			getMethods().addAll((Collection<? extends JavaMethod>) newValue);
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS:
			setFieldDeclarations((String) newValue);
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
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS:
			getImports().clear();
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS:
			getMethods().clear();
			return;
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS:
			setFieldDeclarations(FIELD_DECLARATIONS_EDEFAULT);
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
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__IMPORTS:
			return imports != null && !imports.isEmpty();
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__METHODS:
			return methods != null && !methods.isEmpty();
		case SimpleJavaPackage.JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS:
			return FIELD_DECLARATIONS_EDEFAULT == null ? fieldDeclarations != null
					: !FIELD_DECLARATIONS_EDEFAULT.equals(fieldDeclarations);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", fieldDeclarations: ");
		result.append(fieldDeclarations);
		result.append(')');
		return result.toString();
	}
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} //JavaCompilationUnitImpl
