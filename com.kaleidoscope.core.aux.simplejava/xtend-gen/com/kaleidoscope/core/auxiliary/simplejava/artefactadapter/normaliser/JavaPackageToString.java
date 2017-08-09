package com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser;

import SimpleJava.JavaArrayInit;
import SimpleJava.JavaAssignment;
import SimpleJava.JavaCompilationUnit;
import SimpleJava.JavaExpression;
import SimpleJava.JavaImport;
import SimpleJava.JavaLiteral;
import SimpleJava.JavaMethod;
import SimpleJava.JavaMethodInvocation;
import SimpleJava.JavaName;
import SimpleJava.JavaOpaqueMethod;
import SimpleJava.JavaPackage;
import SimpleJava.JavaStatement;
import SimpleJava.JavaUnknownStatement;
import SimpleJava.JavaVariableDeclaration;
import SimpleJava.JavaWorkflowMethod;
import com.google.common.base.Objects;
import com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser.JavaCompilationUnitNormaliser;
import com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser.JavaExpressionNormaliser;
import com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser.JavaImportNormaliser;
import com.kaleidoscope.core.auxiliary.simplejava.artefactadapter.normaliser.JavaMethodNormaliser;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class JavaPackageToString {
  private boolean sortMethods;
  
  private boolean sortImports;
  
  private JavaImportNormaliser javaImportNormaliser = new JavaImportNormaliser();
  
  private JavaMethodNormaliser javaMethodNormaliser = new JavaMethodNormaliser();
  
  private JavaCompilationUnitNormaliser javaCompilationUnitNormaliser = new JavaCompilationUnitNormaliser();
  
  private JavaExpressionNormaliser<JavaVariableDeclaration> javaVariableDeclarationNormaliser = new JavaExpressionNormaliser<JavaVariableDeclaration>();
  
  private JavaExpressionNormaliser<JavaExpression> javaExpressionNormaliser = new JavaExpressionNormaliser<JavaExpression>();
  
  public JavaPackageToString() {
    this.sortMethods = true;
    this.sortImports = true;
    JavaImportNormaliser _javaImportNormaliser = new JavaImportNormaliser();
    this.javaImportNormaliser = _javaImportNormaliser;
    JavaMethodNormaliser _javaMethodNormaliser = new JavaMethodNormaliser();
    this.javaMethodNormaliser = _javaMethodNormaliser;
    JavaExpressionNormaliser<JavaVariableDeclaration> _javaExpressionNormaliser = new JavaExpressionNormaliser<JavaVariableDeclaration>();
    this.javaVariableDeclarationNormaliser = _javaExpressionNormaliser;
  }
  
  public String unparse(final JavaPackage jPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package {");
    _builder.newLine();
    EList<JavaCompilationUnit> _cunits = jPackage.getCunits();
    final List<JavaCompilationUnit> sortedCompilationUnits = new ArrayList<JavaCompilationUnit>(_cunits);
    _builder.newLineIfNotEmpty();
    this.javaCompilationUnitNormaliser.normalize(sortedCompilationUnits);
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final JavaCompilationUnit cu : sortedCompilationUnits) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        String _name = jPackage.getName();
        CharSequence _unparseCompilationUnit = this.unparseCompilationUnit(_name, cu);
        _builder.append(_unparseCompilationUnit, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence unparseCompilationUnit(final String javaPackage, final JavaCompilationUnit jCompilationUnit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(javaPackage, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    EList<JavaImport> _imports = jCompilationUnit.getImports();
    final List<JavaImport> sortedImports = new ArrayList<JavaImport>(_imports);
    _builder.newLineIfNotEmpty();
    {
      if (this.sortImports) {
        this.javaImportNormaliser.normalize(sortedImports);
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final JavaImport i : sortedImports) {
        _builder.append("import ");
        String _value = i.getValue();
        _builder.append(_value, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    String _name = jCompilationUnit.getName();
    _builder.append(_name, "");
    _builder.append("{\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      String _fieldDeclarations = jCompilationUnit.getFieldDeclarations();
      boolean _notEquals = (!Objects.equal(_fieldDeclarations, null));
      if (_notEquals) {
        String _fieldDeclarations_1 = jCompilationUnit.getFieldDeclarations();
        _builder.append(_fieldDeclarations_1, "\t");
      }
    }
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<JavaMethod> _methods = jCompilationUnit.getMethods();
    final List<JavaMethod> sortedMethods = new ArrayList<JavaMethod>(_methods);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      if (this.sortMethods) {
        this.javaMethodNormaliser.normalize(sortedMethods);
      }
    }
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final JavaMethod m : sortedMethods) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "\t");
        }
        _builder.append("\t");
        CharSequence _unparseMethod = this.unparseMethod(m);
        _builder.append(_unparseMethod, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence unparseMethod(final JavaMethod jMethod) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((jMethod instanceof JavaWorkflowMethod)) {
        _builder.newLineIfNotEmpty();
        CharSequence _unparseWorkflowMethod = this.unparseWorkflowMethod(((JavaWorkflowMethod)jMethod));
        _builder.append(_unparseWorkflowMethod, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if ((jMethod instanceof JavaOpaqueMethod)) {
        CharSequence _unparseOpaqueMethod = this.unparseOpaqueMethod(((JavaOpaqueMethod)jMethod));
        _builder.append(_unparseOpaqueMethod, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence unparseWorkflowMethod(final JavaWorkflowMethod jMethod) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Generated(value={\"Crypto\"})");
    _builder.newLine();
    EList<JavaVariableDeclaration> _params = jMethod.getParams();
    final List<JavaVariableDeclaration> sortedParameters = new ArrayList<JavaVariableDeclaration>(_params);
    this.javaVariableDeclarationNormaliser.normalize(sortedParameters);
    String _modifier = jMethod.getModifier();
    _builder.append(_modifier, "");
    _builder.append(" ");
    String _type = jMethod.getType();
    _builder.append(_type, "");
    _builder.append(" ");
    String _name = jMethod.getName();
    _builder.append(_name, "");
    _builder.append("(");
    final Function1<JavaVariableDeclaration, String> _function = (JavaVariableDeclaration p) -> {
      String _type_1 = p.getType();
      String _plus = (_type_1 + " ");
      String _name_1 = p.getName();
      return (_plus + _name_1);
    };
    List<String> _map = ListExtensions.<JavaVariableDeclaration, String>map(sortedParameters, _function);
    String _join = IterableExtensions.join(_map, ",");
    _builder.append(_join, "");
    _builder.append(") ");
    {
      String _throws = jMethod.getThrows();
      int _length = _throws.length();
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        _builder.append("throws");
      }
    }
    _builder.append(" ");
    String _throws_1 = jMethod.getThrows();
    _builder.append(_throws_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    {
      EList<JavaStatement> _statements = jMethod.getStatements();
      for(final JavaStatement s : _statements) {
        _builder.append("  ");
        CharSequence _unparseStatement = this.unparseStatement(s);
        _builder.append(_unparseStatement, "  ");
        _builder.append("\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence unparseOpaqueMethod(final JavaOpaqueMethod jMethod) {
    StringConcatenation _builder = new StringConcatenation();
    String _modifier = jMethod.getModifier();
    _builder.append(_modifier, "");
    _builder.append(" ");
    String _type = jMethod.getType();
    _builder.append(_type, "");
    _builder.append(" ");
    String _name = jMethod.getName();
    _builder.append(_name, "");
    _builder.append("(");
    String _parameters = jMethod.getParameters();
    _builder.append(_parameters, "");
    _builder.append(") ");
    {
      String _throws = jMethod.getThrows();
      boolean _notEquals = (!Objects.equal(_throws, null));
      if (_notEquals) {
        {
          String _throws_1 = jMethod.getThrows();
          int _length = _throws_1.length();
          boolean _greaterThan = (_length > 1);
          if (_greaterThan) {
            _builder.append("throws");
          }
        }
        _builder.append(" ");
        String _throws_2 = jMethod.getThrows();
        _builder.append(_throws_2, "");
      }
    }
    _builder.newLineIfNotEmpty();
    String _body = jMethod.getBody();
    _builder.append(_body, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence unparseStatement(final JavaStatement jStat) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if ((jStat instanceof JavaUnknownStatement)) {
        String _body = ((JavaUnknownStatement)jStat).getBody();
        _builder.append(_body, "");
        _builder.newLineIfNotEmpty();
      } else {
        boolean _isReturn = jStat.isReturn();
        if (_isReturn) {
          _builder.append("return ");
          JavaExpression _expr = jStat.getExpr();
          CharSequence _unparseExpression = this.unparseExpression(_expr);
          _builder.append(_unparseExpression, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        } else {
          JavaExpression _expr_1 = jStat.getExpr();
          CharSequence _unparseExpression_1 = this.unparseExpression(_expr_1);
          String _plus = (_unparseExpression_1 + ";");
          _builder.append(_plus, "");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }
  
  public CharSequence unparseExpression(final JavaExpression jExpr) {
    CharSequence _xifexpression = null;
    if ((jExpr instanceof JavaName)) {
      return this.unparseName(((JavaName)jExpr));
    } else {
      CharSequence _xifexpression_1 = null;
      if ((jExpr instanceof JavaLiteral)) {
        _xifexpression_1 = this.unparseLiteral(((JavaLiteral)jExpr));
      } else {
        CharSequence _xifexpression_2 = null;
        if ((jExpr instanceof JavaAssignment)) {
          _xifexpression_2 = this.unparseAssignment(((JavaAssignment)jExpr));
        } else {
          CharSequence _xifexpression_3 = null;
          if ((jExpr instanceof JavaMethodInvocation)) {
            _xifexpression_3 = this.unparseMethodInvocation(((JavaMethodInvocation)jExpr));
          } else {
            CharSequence _xifexpression_4 = null;
            if ((jExpr instanceof JavaVariableDeclaration)) {
              _xifexpression_4 = this.unparseVariableDeclaration(((JavaVariableDeclaration)jExpr));
            } else {
              CharSequence _xifexpression_5 = null;
              if ((jExpr instanceof JavaArrayInit)) {
                _xifexpression_5 = this.unparseArrayInit(((JavaArrayInit)jExpr));
              }
              _xifexpression_4 = _xifexpression_5;
            }
            _xifexpression_3 = _xifexpression_4;
          }
          _xifexpression_2 = _xifexpression_3;
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence unparseName(final JavaName jName) {
    StringConcatenation _builder = new StringConcatenation();
    String _identifier = jName.getIdentifier();
    _builder.append(_identifier, "");
    return _builder;
  }
  
  public CharSequence unparseLiteral(final JavaLiteral jLiteral) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = jLiteral.getValue();
    _builder.append(_value, "");
    return _builder;
  }
  
  public CharSequence unparseAssignment(final JavaAssignment jAssign) {
    StringConcatenation _builder = new StringConcatenation();
    JavaExpression _lhs = jAssign.getLhs();
    CharSequence _unparseExpression = this.unparseExpression(_lhs);
    _builder.append(_unparseExpression, "");
    _builder.append(" = ");
    JavaExpression _rhs = jAssign.getRhs();
    CharSequence _unparseExpression_1 = this.unparseExpression(_rhs);
    _builder.append(_unparseExpression_1, "");
    return _builder;
  }
  
  public CharSequence unparseArrayInit(final JavaArrayInit jArrayInit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    String _type = jArrayInit.getType();
    StringBuilder _stringBuilder = new StringBuilder(_type);
    String _type_1 = jArrayInit.getType();
    int _indexOf = _type_1.indexOf("[]");
    int _plus = (_indexOf + 1);
    String _dimension = jArrayInit.getDimension();
    StringBuilder _insert = _stringBuilder.insert(_plus, _dimension);
    String _string = _insert.toString();
    _builder.append(_string, "");
    return _builder;
  }
  
  public CharSequence unparseMethodInvocation(final JavaMethodInvocation jMethodInvocation) {
    StringConcatenation _builder = new StringConcatenation();
    EList<JavaExpression> _arguments = jMethodInvocation.getArguments();
    final List<JavaExpression> sortedArguments = new ArrayList<JavaExpression>(_arguments);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.javaExpressionNormaliser.normalize(sortedArguments);
    _builder.newLineIfNotEmpty();
    {
      boolean _isInitialization = jMethodInvocation.isInitialization();
      if (_isInitialization) {
        _builder.append("new ");
      }
    }
    {
      JavaExpression _optionalExpression = jMethodInvocation.getOptionalExpression();
      boolean _notEquals = (!Objects.equal(_optionalExpression, null));
      if (_notEquals) {
        _builder.newLineIfNotEmpty();
        JavaExpression _optionalExpression_1 = jMethodInvocation.getOptionalExpression();
        CharSequence _unparseExpression = this.unparseExpression(_optionalExpression_1);
        _builder.append(_unparseExpression, "");
        _builder.append(".");
      }
    }
    String _name = jMethodInvocation.getName();
    _builder.append(_name, "");
    _builder.append("(");
    final Function1<JavaExpression, CharSequence> _function = (JavaExpression a) -> {
      return this.unparseExpression(a);
    };
    List<CharSequence> _map = ListExtensions.<JavaExpression, CharSequence>map(sortedArguments, _function);
    String _join = IterableExtensions.join(_map, ",");
    _builder.append(_join, "");
    _builder.append(")");
    return _builder;
  }
  
  public CharSequence unparseVariableDeclaration(final JavaVariableDeclaration jVarDec) {
    StringConcatenation _builder = new StringConcatenation();
    String _type = jVarDec.getType();
    _builder.append(_type, "");
    _builder.append(" ");
    String _name = jVarDec.getName();
    _builder.append(_name, "");
    return _builder;
  }
}
