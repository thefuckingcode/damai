package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class LazyJavaClassMemberScope$computeMemberIndex$1 extends Lambda implements Function1<JavaMember, Boolean> {
    public static final LazyJavaClassMemberScope$computeMemberIndex$1 INSTANCE = new LazyJavaClassMemberScope$computeMemberIndex$1();

    LazyJavaClassMemberScope$computeMemberIndex$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(JavaMember javaMember) {
        return Boolean.valueOf(invoke(javaMember));
    }

    public final boolean invoke(@NotNull JavaMember javaMember) {
        k21.i(javaMember, AdvanceSetting.NETWORK_TYPE);
        return !javaMember.isStatic();
    }
}
