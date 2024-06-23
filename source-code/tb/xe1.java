package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class xe1 implements ClassDescriptor {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final MemberScope a(@NotNull ClassDescriptor classDescriptor, @NotNull xo2 xo2, @NotNull i61 i61) {
            k21.i(classDescriptor, "<this>");
            k21.i(xo2, "typeSubstitution");
            k21.i(i61, "kotlinTypeRefiner");
            xe1 xe1 = classDescriptor instanceof xe1 ? (xe1) classDescriptor : null;
            if (xe1 != null) {
                return xe1.a(xo2, i61);
            }
            MemberScope memberScope = classDescriptor.getMemberScope(xo2);
            k21.h(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
            return memberScope;
        }

        @NotNull
        public final MemberScope b(@NotNull ClassDescriptor classDescriptor, @NotNull i61 i61) {
            k21.i(classDescriptor, "<this>");
            k21.i(i61, "kotlinTypeRefiner");
            xe1 xe1 = classDescriptor instanceof xe1 ? (xe1) classDescriptor : null;
            if (xe1 != null) {
                return xe1.b(i61);
            }
            MemberScope unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope();
            k21.h(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
            return unsubstitutedMemberScope;
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope a(@NotNull xo2 xo2, @NotNull i61 i61);

    /* access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope b(@NotNull i61 i61);
}
