/**
 */
package SimpleJava.impl;

import SimpleJava.JavaMethod;
import SimpleJava.JavaVariableDeclaration;
import SimpleJava.SimpleJavaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getType <em>Type</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getThrows <em>Throws</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getParams <em>Params</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaMethodImpl#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaMethodImpl extends MinimalEObjectImpl.Container implements JavaMethod {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected static final String MODIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected String modifier = MODIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getThrows() <em>Throws</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrows()
	 * @generated
	 * @ordered
	 */
	protected static final String THROWS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThrows() <em>Throws</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrows()
	 * @generated
	 * @ordered
	 */
	protected String throws_ = THROWS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaVariableDeclaration> params;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleJavaPackage.Literals.JAVA_METHOD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifier(String newModifier) {
		String oldModifier = modifier;
		modifier = newModifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD__MODIFIER, oldModifier, modifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThrows() {
		return throws_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrows(String newThrows) {
		String oldThrows = throws_;
		throws_ = newThrows;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD__THROWS, oldThrows, throws_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaVariableDeclaration> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<JavaVariableDeclaration>(JavaVariableDeclaration.class, this, SimpleJavaPackage.JAVA_METHOD__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_METHOD__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleJavaPackage.JAVA_METHOD__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
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
			case SimpleJavaPackage.JAVA_METHOD__NAME:
				return getName();
			case SimpleJavaPackage.JAVA_METHOD__TYPE:
				return getType();
			case SimpleJavaPackage.JAVA_METHOD__MODIFIER:
				return getModifier();
			case SimpleJavaPackage.JAVA_METHOD__THROWS:
				return getThrows();
			case SimpleJavaPackage.JAVA_METHOD__PARAMS:
				return getParams();
			case SimpleJavaPackage.JAVA_METHOD__INDEX:
				return getIndex();
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
			case SimpleJavaPackage.JAVA_METHOD__NAME:
				setName((String)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD__TYPE:
				setType((String)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD__MODIFIER:
				setModifier((String)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD__THROWS:
				setThrows((String)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends JavaVariableDeclaration>)newValue);
				return;
			case SimpleJavaPackage.JAVA_METHOD__INDEX:
				setIndex((Integer)newValue);
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
			case SimpleJavaPackage.JAVA_METHOD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD__MODIFIER:
				setModifier(MODIFIER_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD__THROWS:
				setThrows(THROWS_EDEFAULT);
				return;
			case SimpleJavaPackage.JAVA_METHOD__PARAMS:
				getParams().clear();
				return;
			case SimpleJavaPackage.JAVA_METHOD__INDEX:
				setIndex(INDEX_EDEFAULT);
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
			case SimpleJavaPackage.JAVA_METHOD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SimpleJavaPackage.JAVA_METHOD__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SimpleJavaPackage.JAVA_METHOD__MODIFIER:
				return MODIFIER_EDEFAULT == null ? modifier != null : !MODIFIER_EDEFAULT.equals(modifier);
			case SimpleJavaPackage.JAVA_METHOD__THROWS:
				return THROWS_EDEFAULT == null ? throws_ != null : !THROWS_EDEFAULT.equals(throws_);
			case SimpleJavaPackage.JAVA_METHOD__PARAMS:
				return params != null && !params.isEmpty();
			case SimpleJavaPackage.JAVA_METHOD__INDEX:
				return index != INDEX_EDEFAULT;
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
		result.append(", type: ");
		result.append(type);
		result.append(", modifier: ");
		result.append(modifier);
		result.append(", throws: ");
		result.append(throws_);
		result.append(", index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

} //JavaMethodImpl
