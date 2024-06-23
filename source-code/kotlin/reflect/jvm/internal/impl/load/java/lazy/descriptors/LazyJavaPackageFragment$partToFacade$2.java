package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import tb.a51;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaPackageFragment$partToFacade$2 extends Lambda implements Function0<HashMap<a51, a51>> {
    final /* synthetic */ LazyJavaPackageFragment this$0;

    /* compiled from: Taobao */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final HashMap<a51, a51> invoke() {
        HashMap<a51, a51> hashMap = new HashMap<>();
        for (Map.Entry<String, KotlinJvmBinaryClass> entry : this.this$0.g().entrySet()) {
            a51 d = a51.d(entry.getKey());
            k21.h(d, "byInternalName(partInternalName)");
            KotlinClassHeader classHeader = entry.getValue().getClassHeader();
            int i = a.$EnumSwitchMapping$0[classHeader.c().ordinal()];
            if (i == 1) {
                String e = classHeader.e();
                if (e != null) {
                    a51 d2 = a51.d(e);
                    k21.h(d2, "byInternalName(header.multifileClassName ?: continue@kotlinClasses)");
                    hashMap.put(d, d2);
                }
            } else if (i == 2) {
                hashMap.put(d, d);
            }
        }
        return hashMap;
    }
}
