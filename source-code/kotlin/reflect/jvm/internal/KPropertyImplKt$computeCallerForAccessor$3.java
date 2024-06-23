package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import org.jetbrains.annotations.NotNull;
import tb.ff;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/reflect/Field;", "field", "Ltb/ff;", "invoke", "(Ljava/lang/reflect/Field;)Ltb/ff;", "computeFieldCaller"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class KPropertyImplKt$computeCallerForAccessor$3 extends Lambda implements Function1<Field, ff<? extends Field>> {
    final /* synthetic */ boolean $isGetter;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isJvmStaticProperty$1;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isNotNullProperty$2;
    final /* synthetic */ KPropertyImpl.a $this_computeCallerForAccessor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPropertyImplKt$computeCallerForAccessor$3(KPropertyImpl.a aVar, boolean z, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1) {
        super(1);
        this.$this_computeCallerForAccessor = aVar;
        this.$isGetter = z;
        this.$isNotNullProperty$2 = kPropertyImplKt$computeCallerForAccessor$2;
        this.$isJvmStaticProperty$1 = kPropertyImplKt$computeCallerForAccessor$1;
    }

    @NotNull
    public final ff<Field> invoke(@NotNull Field field) {
        k21.i(field, "field");
        if ((KPropertyImplKt.e(this.$this_computeCallerForAccessor.m().i())) || !Modifier.isStatic(field.getModifiers())) {
            if (this.$isGetter) {
                if (this.$this_computeCallerForAccessor.k()) {
                    return new ff.f.a(field, KPropertyImplKt.d(this.$this_computeCallerForAccessor));
                }
                return new ff.f.c(field);
            } else if (this.$this_computeCallerForAccessor.k()) {
                return new ff.g.a(field, this.$isNotNullProperty$2.invoke(), KPropertyImplKt.d(this.$this_computeCallerForAccessor));
            } else {
                return new ff.g.c(field, this.$isNotNullProperty$2.invoke());
            }
        } else if (this.$isJvmStaticProperty$1.invoke()) {
            if (this.$isGetter) {
                if (this.$this_computeCallerForAccessor.k()) {
                    return new ff.f.b(field);
                }
                return new ff.f.d(field);
            } else if (this.$this_computeCallerForAccessor.k()) {
                return new ff.g.b(field, this.$isNotNullProperty$2.invoke());
            } else {
                return new ff.g.d(field, this.$isNotNullProperty$2.invoke());
            }
        } else if (this.$isGetter) {
            return new ff.f.e(field);
        } else {
            return new ff.g.e(field, this.$isNotNullProperty$2.invoke());
        }
    }
}
