package tb;

import com.taobao.accs.common.Constants;
import com.taobao.weex.ui.component.AbstractEditComponent;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.jvm.JvmField;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class il1 {
    @JvmField
    @NotNull
    public static final og1 AND;
    @JvmField
    @NotNull
    public static final Set<og1> ASSIGNMENT_OPERATIONS;
    @JvmField
    @NotNull
    public static final Set<og1> BINARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final og1 COMPARE_TO;
    @JvmField
    @NotNull
    public static final Regex COMPONENT_REGEX = new Regex("component\\d+");
    @JvmField
    @NotNull
    public static final og1 CONTAINS;
    @JvmField
    @NotNull
    public static final og1 DEC;
    @JvmField
    @NotNull
    public static final Set<og1> DELEGATED_PROPERTY_OPERATORS;
    @JvmField
    @NotNull
    public static final og1 DIV;
    @JvmField
    @NotNull
    public static final og1 DIV_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 EQUALS;
    @JvmField
    @NotNull
    public static final og1 GET;
    @JvmField
    @NotNull
    public static final og1 GET_VALUE;
    @JvmField
    @NotNull
    public static final og1 HAS_NEXT;
    @JvmField
    @NotNull
    public static final og1 INC;
    @NotNull
    public static final il1 INSTANCE = new il1();
    @JvmField
    @NotNull
    public static final og1 INVOKE;
    @JvmField
    @NotNull
    public static final og1 ITERATOR;
    @JvmField
    @NotNull
    public static final og1 MINUS;
    @JvmField
    @NotNull
    public static final og1 MINUS_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 MOD;
    @JvmField
    @NotNull
    public static final og1 MOD_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 NEXT;
    @JvmField
    @NotNull
    public static final og1 NOT;
    @JvmField
    @NotNull
    public static final og1 OR;
    @JvmField
    @NotNull
    public static final og1 PLUS;
    @JvmField
    @NotNull
    public static final og1 PLUS_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 PROVIDE_DELEGATE;
    @JvmField
    @NotNull
    public static final og1 RANGE_TO;
    @JvmField
    @NotNull
    public static final og1 REM;
    @JvmField
    @NotNull
    public static final og1 REM_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 SET;
    @JvmField
    @NotNull
    public static final og1 SET_VALUE;
    @JvmField
    @NotNull
    public static final Set<og1> SIMPLE_UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final og1 TIMES;
    @JvmField
    @NotNull
    public static final og1 TIMES_ASSIGN;
    @JvmField
    @NotNull
    public static final og1 TO_STRING;
    @JvmField
    @NotNull
    public static final og1 UNARY_MINUS;
    @JvmField
    @NotNull
    public static final Set<og1> UNARY_OPERATION_NAMES;
    @JvmField
    @NotNull
    public static final og1 UNARY_PLUS;

    static {
        og1 f = og1.f("getValue");
        k21.h(f, "identifier(\"getValue\")");
        GET_VALUE = f;
        og1 f2 = og1.f("setValue");
        k21.h(f2, "identifier(\"setValue\")");
        SET_VALUE = f2;
        og1 f3 = og1.f("provideDelegate");
        k21.h(f3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = f3;
        og1 f4 = og1.f("equals");
        k21.h(f4, "identifier(\"equals\")");
        EQUALS = f4;
        og1 f5 = og1.f("compareTo");
        k21.h(f5, "identifier(\"compareTo\")");
        COMPARE_TO = f5;
        og1 f6 = og1.f("contains");
        k21.h(f6, "identifier(\"contains\")");
        CONTAINS = f6;
        og1 f7 = og1.f("invoke");
        k21.h(f7, "identifier(\"invoke\")");
        INVOKE = f7;
        og1 f8 = og1.f("iterator");
        k21.h(f8, "identifier(\"iterator\")");
        ITERATOR = f8;
        og1 f9 = og1.f(gl1.TYPE_OPEN_URL_METHOD_GET);
        k21.h(f9, "identifier(\"get\")");
        GET = f9;
        og1 f10 = og1.f("set");
        k21.h(f10, "identifier(\"set\")");
        SET = f10;
        og1 f11 = og1.f(AbstractEditComponent.ReturnTypes.NEXT);
        k21.h(f11, "identifier(\"next\")");
        NEXT = f11;
        og1 f12 = og1.f(wj2.HAS_NEXT);
        k21.h(f12, "identifier(\"hasNext\")");
        HAS_NEXT = f12;
        og1 f13 = og1.f("toString");
        k21.h(f13, "identifier(\"toString\")");
        TO_STRING = f13;
        og1 f14 = og1.f(o70.AND_PREFIX);
        k21.h(f14, "identifier(\"and\")");
        AND = f14;
        og1 f15 = og1.f(o70.OR_PREFIX);
        k21.h(f15, "identifier(\"or\")");
        OR = f15;
        og1 f16 = og1.f("inc");
        k21.h(f16, "identifier(\"inc\")");
        INC = f16;
        og1 f17 = og1.f("dec");
        k21.h(f17, "identifier(\"dec\")");
        DEC = f17;
        og1 f18 = og1.f("plus");
        k21.h(f18, "identifier(\"plus\")");
        PLUS = f18;
        og1 f19 = og1.f("minus");
        k21.h(f19, "identifier(\"minus\")");
        MINUS = f19;
        og1 f20 = og1.f(o70.NOT_PREFIX);
        k21.h(f20, "identifier(\"not\")");
        NOT = f20;
        og1 f21 = og1.f("unaryMinus");
        k21.h(f21, "identifier(\"unaryMinus\")");
        UNARY_MINUS = f21;
        og1 f22 = og1.f("unaryPlus");
        k21.h(f22, "identifier(\"unaryPlus\")");
        UNARY_PLUS = f22;
        og1 f23 = og1.f(Constants.KEY_TIMES);
        k21.h(f23, "identifier(\"times\")");
        TIMES = f23;
        og1 f24 = og1.f(WXBasicComponentType.DIV);
        k21.h(f24, "identifier(\"div\")");
        DIV = f24;
        og1 f25 = og1.f("mod");
        k21.h(f25, "identifier(\"mod\")");
        MOD = f25;
        og1 f26 = og1.f("rem");
        k21.h(f26, "identifier(\"rem\")");
        REM = f26;
        og1 f27 = og1.f("rangeTo");
        k21.h(f27, "identifier(\"rangeTo\")");
        RANGE_TO = f27;
        og1 f28 = og1.f("timesAssign");
        k21.h(f28, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = f28;
        og1 f29 = og1.f("divAssign");
        k21.h(f29, "identifier(\"divAssign\")");
        DIV_ASSIGN = f29;
        og1 f30 = og1.f("modAssign");
        k21.h(f30, "identifier(\"modAssign\")");
        MOD_ASSIGN = f30;
        og1 f31 = og1.f("remAssign");
        k21.h(f31, "identifier(\"remAssign\")");
        REM_ASSIGN = f31;
        og1 f32 = og1.f("plusAssign");
        k21.h(f32, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = f32;
        og1 f33 = og1.f("minusAssign");
        k21.h(f33, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = f33;
        UNARY_OPERATION_NAMES = e0.g(f16, f17, f22, f21, f20);
        SIMPLE_UNARY_OPERATION_NAMES = e0.g(f22, f21, f20);
        BINARY_OPERATION_NAMES = e0.g(f23, f18, f19, f24, f25, f26, f27);
        ASSIGNMENT_OPERATIONS = e0.g(f28, f29, f30, f31, f32, f33);
        DELEGATED_PROPERTY_OPERATORS = e0.g(f, f2, f3);
    }

    private il1() {
    }
}
