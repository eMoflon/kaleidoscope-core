/**
 */
package SimpleJava.impl;

import SimpleJava.JavaExpression;
import SimpleJava.JavaMethodInvocation;
import SimpleJava.SimpleJavaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Method Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SimpleJava.impl.JavaMethodInvocationImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodInvocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodInvocationImpl#isInitialization <em>Initialization</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodInvocationImpl#getOptionalExpression <em>Optional Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaMethodInvocationImpl extends JavaExpressionImpl implements JavaMethodInvocation {
	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaExpression> arguments;

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
	 * The default value of the '{@link #isInitialization() <em>Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialization()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitialization() <em>Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitialization()
	 * @generated
	 * @ordered
	 */
	protected boolean initialization = INITIALIZATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptionalExpression() <em>Optional Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalExpression()
	 * @generated
	 * @ordered
	 */
	protected JavaExpression optionalExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaMethodInvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleJavaPackage.Literals.JAVA_METHOD_INVOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaExpression> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<JavaExpression>(JavaExpression.class, this, SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS);
		}
		return arguments;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD_INVOCATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitialization() {
		return initialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialization(boolean newInitialization) {
		boolean oldInitialization = initialization;
		initialization = newInitialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD_INVOCATION__INITIALIZATION, oldInitialization, initialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaExpression getOptionalExpression() {
		return optionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOptionalExpression(JavaExpression newOptionalExpression, NotificationChain msgs) {
		JavaExpression oldOptionalExpression = optionalExpression;
		optionalExpression = newOptionalExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION, oldOptionalExpression, newOptionalExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalExpression(JavaExpression newOptionalExpression) {
		if (newOptionalExpression != optionalExpression) {
			NotificationChain msgs = null;
			if (optionalExpression != null)
				msgs = ((InternalEObject)optionalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION, null, msgs);
			if (newOptionalExpression != null)
				msgs = ((InternalEObject)newOptionalExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION, null, msgs);
			msgs = basicSetOptionalExpression(newOptionalExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION, newOptionalExpression, newOptionalExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION:
				return basicSetOptionalExpression(null, msgs);
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
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS:
				return getArguments();
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__NAME:
				return getName();
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__INITIALIZATION:
				return isInitialization();
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION:
				return getOptionalExpression();
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
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends JavaExpression>)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__NAME:
				setName((String)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__INITIALIZATION:
				setInitialization((Boolean)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION:
				setOptionalExpression((JavaExpression)newValue);
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
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS:
				getArguments().clear();
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__INITIALIZATION:
				setInitialization(INITIALIZATION_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION:
				setOptionalExpression((JavaExpression)null);
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
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__INITIALIZATION:
				return initialization != INITIALIZATION_EDEFAULT;
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION:
				return optionalExpression != null;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", initialization: ");
		result.append(initialization);
		result.append(')');
		return result.toString();
	}

} //JavaMethodInvocationImpl
