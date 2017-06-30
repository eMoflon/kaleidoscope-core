/**
 */
package SimpleJava.impl;

import SimpleJava.JavaExpression;
import SimpleJava.JavaStatement;
import SimpleJava.SimpleJavaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link SimpleJava.impl.JavaStatementImpl#getNext <em>Next</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaStatementImpl#getPrev <em>Prev</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaStatementImpl#getExpr <em>Expr</em>}</li>
 *   <li>{@link SimpleJava.impl.JavaStatementImpl#isReturn <em>Return</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaStatementImpl extends MinimalEObjectImpl.Container implements JavaStatement {
	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected JavaStatement next;

	/**
	 * The cached value of the '{@link #getPrev() <em>Prev</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrev()
	 * @generated
	 * @ordered
	 */
	protected JavaStatement prev;

	/**
	 * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpr()
	 * @generated
	 * @ordered
	 */
	protected JavaExpression expr;

	/**
	 * The default value of the '{@link #isReturn() <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturn()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETURN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReturn() <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturn()
	 * @generated
	 * @ordered
	 */
	protected boolean return_ = RETURN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimpleJavaPackage.Literals.JAVA_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaStatement getNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNext(JavaStatement newNext, NotificationChain msgs) {
		JavaStatement oldNext = next;
		next = newNext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__NEXT, oldNext, newNext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(JavaStatement newNext) {
		if (newNext != next) {
			NotificationChain msgs = null;
			if (next != null)
				msgs = ((InternalEObject)next).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__NEXT, null, msgs);
			if (newNext != null)
				msgs = ((InternalEObject)newNext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__NEXT, null, msgs);
			msgs = basicSetNext(newNext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__NEXT, newNext, newNext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaStatement getPrev() {
		return prev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrev(JavaStatement newPrev, NotificationChain msgs) {
		JavaStatement oldPrev = prev;
		prev = newPrev;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__PREV, oldPrev, newPrev);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrev(JavaStatement newPrev) {
		if (newPrev != prev) {
			NotificationChain msgs = null;
			if (prev != null)
				msgs = ((InternalEObject)prev).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__PREV, null, msgs);
			if (newPrev != null)
				msgs = ((InternalEObject)newPrev).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__PREV, null, msgs);
			msgs = basicSetPrev(newPrev, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__PREV, newPrev, newPrev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaExpression getExpr() {
		return expr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpr(JavaExpression newExpr, NotificationChain msgs) {
		JavaExpression oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__EXPR, oldExpr, newExpr);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpr(JavaExpression newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleJavaPackage.JAVA_STATEMENT__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__EXPR, newExpr, newExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReturn() {
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturn(boolean newReturn) {
		boolean oldReturn = return_;
		return_ = newReturn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimpleJavaPackage.JAVA_STATEMENT__RETURN, oldReturn, return_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimpleJavaPackage.JAVA_STATEMENT__NEXT:
				return basicSetNext(null, msgs);
			case SimpleJavaPackage.JAVA_STATEMENT__PREV:
				return basicSetPrev(null, msgs);
			case SimpleJavaPackage.JAVA_STATEMENT__EXPR:
				return basicSetExpr(null, msgs);
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
			case SimpleJavaPackage.JAVA_STATEMENT__NEXT:
				return getNext();
			case SimpleJavaPackage.JAVA_STATEMENT__PREV:
				return getPrev();
			case SimpleJavaPackage.JAVA_STATEMENT__EXPR:
				return getExpr();
			case SimpleJavaPackage.JAVA_STATEMENT__RETURN:
				return isReturn();
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
			case SimpleJavaPackage.JAVA_STATEMENT__NEXT:
				setNext((JavaStatement)newValue);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__PREV:
				setPrev((JavaStatement)newValue);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__EXPR:
				setExpr((JavaExpression)newValue);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__RETURN:
				setReturn((Boolean)newValue);
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
			case SimpleJavaPackage.JAVA_STATEMENT__NEXT:
				setNext((JavaStatement)null);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__PREV:
				setPrev((JavaStatement)null);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__EXPR:
				setExpr((JavaExpression)null);
				return;
			case SimpleJavaPackage.JAVA_STATEMENT__RETURN:
				setReturn(RETURN_EDEFAULT);
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
			case SimpleJavaPackage.JAVA_STATEMENT__NEXT:
				return next != null;
			case SimpleJavaPackage.JAVA_STATEMENT__PREV:
				return prev != null;
			case SimpleJavaPackage.JAVA_STATEMENT__EXPR:
				return expr != null;
			case SimpleJavaPackage.JAVA_STATEMENT__RETURN:
				return return_ != RETURN_EDEFAULT;
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
		result.append(" (return: ");
		result.append(return_);
		result.append(')');
		return result.toString();
	}

} //JavaStatementImpl
