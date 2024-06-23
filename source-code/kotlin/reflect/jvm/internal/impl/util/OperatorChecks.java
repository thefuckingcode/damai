package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import org.jetbrains.annotations.NotNull;
import tb.il1;
import tb.m40;
import tb.nc1;
import tb.og1;
import tb.v1;
import tb.wu2;

/* compiled from: Taobao */
public final class OperatorChecks extends v1 {
    @NotNull
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    @NotNull
    private static final List<Checks> a;

    static {
        og1 og1 = il1.GET;
        nc1.b bVar = nc1.b.INSTANCE;
        Check[] checkArr = {bVar, new wu2.a(1)};
        og1 og12 = il1.SET;
        Check[] checkArr2 = {bVar, new wu2.a(2)};
        og1 og13 = il1.GET_VALUE;
        b bVar2 = b.INSTANCE;
        a aVar = a.INSTANCE;
        og1 og14 = il1.CONTAINS;
        wu2.d dVar = wu2.d.INSTANCE;
        ReturnsCheck.ReturnsBoolean returnsBoolean = ReturnsCheck.ReturnsBoolean.INSTANCE;
        og1 og15 = il1.ITERATOR;
        wu2.c cVar = wu2.c.INSTANCE;
        a = m.j(new Checks(og1, checkArr, (Function1) null, 4, (m40) null), new Checks(og12, checkArr2, OperatorChecks$checks$1.INSTANCE), new Checks(og13, new Check[]{bVar, bVar2, new wu2.a(2), aVar}, (Function1) null, 4, (m40) null), new Checks(il1.SET_VALUE, new Check[]{bVar, bVar2, new wu2.a(3), aVar}, (Function1) null, 4, (m40) null), new Checks(il1.PROVIDE_DELEGATE, new Check[]{bVar, bVar2, new wu2.b(2), aVar}, (Function1) null, 4, (m40) null), new Checks(il1.INVOKE, new Check[]{bVar}, (Function1) null, 4, (m40) null), new Checks(og14, new Check[]{bVar, dVar, bVar2, returnsBoolean}, (Function1) null, 4, (m40) null), new Checks(og15, new Check[]{bVar, cVar}, (Function1) null, 4, (m40) null), new Checks(il1.NEXT, new Check[]{bVar, cVar}, (Function1) null, 4, (m40) null), new Checks(il1.HAS_NEXT, new Check[]{bVar, cVar, returnsBoolean}, (Function1) null, 4, (m40) null), new Checks(il1.RANGE_TO, new Check[]{bVar, dVar, bVar2}, (Function1) null, 4, (m40) null), new Checks(il1.EQUALS, new Check[]{nc1.a.INSTANCE}, OperatorChecks$checks$2.INSTANCE), new Checks(il1.COMPARE_TO, new Check[]{bVar, ReturnsCheck.ReturnsInt.INSTANCE, dVar, bVar2}, (Function1) null, 4, (m40) null), new Checks(il1.BINARY_OPERATION_NAMES, new Check[]{bVar, dVar, bVar2}, (Function1) null, 4, (m40) null), new Checks(il1.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{bVar, cVar}, (Function1) null, 4, (m40) null), new Checks(m.j(il1.INC, il1.DEC), new Check[]{bVar}, OperatorChecks$checks$3.INSTANCE), new Checks(il1.ASSIGNMENT_OPERATIONS, new Check[]{bVar, ReturnsCheck.ReturnsUnit.INSTANCE, dVar, bVar2}, (Function1) null, 4, (m40) null), new Checks(il1.COMPONENT_REGEX, new Check[]{bVar, cVar}, (Function1) null, 4, (m40) null));
    }

    private OperatorChecks() {
    }

    @Override // tb.v1
    @NotNull
    public List<Checks> b() {
        return a;
    }
}
