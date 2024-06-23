package tb;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class ae0 extends om<Pair<? extends oi, ? extends og1>> {
    @NotNull
    private final oi b;
    @NotNull
    private final og1 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae0(@NotNull oi oiVar, @NotNull og1 og1) {
        super(do2.a(oiVar, og1));
        k21.i(oiVar, "enumClassId");
        k21.i(og1, "enumEntryName");
        this.b = oiVar;
        this.c = og1;
    }

    @Override // tb.om
    @NotNull
    public g61 a(@NotNull ModuleDescriptor moduleDescriptor) {
        k21.i(moduleDescriptor, "module");
        ClassDescriptor a = FindClassInModuleKt.a(moduleDescriptor, this.b);
        ib2 ib2 = null;
        if (a != null) {
            if (!f60.A(a)) {
                a = null;
            }
            if (a != null) {
                ib2 = a.getDefaultType();
            }
        }
        if (ib2 != null) {
            return ib2;
        }
        ib2 j = me0.j("Containing class for error-class based enum entry " + this.b + '.' + this.c);
        k21.h(j, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return j;
    }

    @NotNull
    public final og1 c() {
        return this.c;
    }

    @Override // tb.om
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
