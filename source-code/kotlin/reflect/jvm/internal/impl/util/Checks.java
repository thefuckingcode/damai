package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.sh;

/* compiled from: Taobao */
public final class Checks {
    @Nullable
    private final og1 a;
    @Nullable
    private final Regex b;
    @Nullable
    private final Collection<og1> c;
    @NotNull
    private final Function1<FunctionDescriptor, String> d;
    @NotNull
    private final Check[] e;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private Checks(og1 og1, Regex regex, Collection<og1> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.a = og1;
        this.b = regex;
        this.c = collection;
        this.d = function1;
        this.e = checkArr;
    }

    @NotNull
    public final sh a(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        Check[] checkArr = this.e;
        int length = checkArr.length;
        int i = 0;
        while (i < length) {
            Check check = checkArr[i];
            i++;
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new sh.b(invoke);
            }
        }
        String invoke2 = this.d.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new sh.b(invoke2);
        }
        return sh.c.INSTANCE;
    }

    public final boolean b(@NotNull FunctionDescriptor functionDescriptor) {
        k21.i(functionDescriptor, "functionDescriptor");
        if (this.a != null && !k21.d(functionDescriptor.getName(), this.a)) {
            return false;
        }
        if (this.b != null) {
            String b2 = functionDescriptor.getName().b();
            k21.h(b2, "functionDescriptor.name.asString()");
            if (!this.b.matches(b2)) {
                return false;
            }
        }
        Collection<og1> collection = this.c;
        if (collection == null || collection.contains(functionDescriptor.getName())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(og1 og1, Check[] checkArr, Function1 function1, int i, m40 m40) {
        this(og1, checkArr, (i & 4) != 0 ? AnonymousClass2.INSTANCE : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Checks(@NotNull og1 og1, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this(og1, (Regex) null, (Collection<og1>) null, function1, r6);
        k21.i(og1, "name");
        k21.i(checkArr, "checks");
        k21.i(function1, "additionalChecks");
        Check[] checkArr2 = new Check[checkArr.length];
        System.arraycopy(checkArr, 0, checkArr2, 0, checkArr.length);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Regex regex, Check[] checkArr, Function1 function1, int i, m40 m40) {
        this(regex, checkArr, (i & 4) != 0 ? AnonymousClass3.INSTANCE : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Checks(@NotNull Regex regex, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this((og1) null, regex, (Collection<og1>) null, function1, r6);
        k21.i(regex, "regex");
        k21.i(checkArr, "checks");
        k21.i(function1, "additionalChecks");
        Check[] checkArr2 = new Check[checkArr.length];
        System.arraycopy(checkArr, 0, checkArr2, 0, checkArr.length);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i, m40 m40) {
        this(collection, checkArr, (i & 4) != 0 ? AnonymousClass4.INSTANCE : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Checks(@NotNull Collection<og1> collection, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this((og1) null, (Regex) null, collection, function1, r6);
        k21.i(collection, "nameList");
        k21.i(checkArr, "checks");
        k21.i(function1, "additionalChecks");
        Check[] checkArr2 = new Check[checkArr.length];
        System.arraycopy(checkArr, 0, checkArr2, 0, checkArr.length);
    }
}
