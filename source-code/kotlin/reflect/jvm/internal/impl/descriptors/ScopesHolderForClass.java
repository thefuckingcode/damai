package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import tb.dz1;
import tb.i61;
import tb.k21;
import tb.m40;
import tb.te2;

/* compiled from: Taobao */
public final class ScopesHolderForClass<T extends MemberScope> {
    @NotNull
    public static final a Companion = new a(null);
    static final /* synthetic */ KProperty<Object>[] e = {dz1.i(new PropertyReference1Impl(dz1.b(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final Function1<i61, T> b;
    @NotNull
    private final i61 c;
    @NotNull
    private final NotNullLazyValue d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final <T extends MemberScope> ScopesHolderForClass<T> a(@NotNull ClassDescriptor classDescriptor, @NotNull StorageManager storageManager, @NotNull i61 i61, @NotNull Function1<? super i61, ? extends T> function1) {
            k21.i(classDescriptor, "classDescriptor");
            k21.i(storageManager, "storageManager");
            k21.i(i61, "kotlinTypeRefinerForOwnerModule");
            k21.i(function1, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, i61, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super tb.i61, ? extends T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    private ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super i61, ? extends T> function1, i61 i61) {
        this.a = classDescriptor;
        this.b = function1;
        this.c = i61;
        this.d = storageManager.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, i61 i61, m40 m40) {
        this(classDescriptor, storageManager, function1, i61);
    }

    private final T d() {
        return (T) ((MemberScope) te2.a(this.d, this, e[0]));
    }

    @NotNull
    public final T c(@NotNull i61 i61) {
        k21.i(i61, "kotlinTypeRefiner");
        if (!i61.c(DescriptorUtilsKt.l(this.a))) {
            return d();
        }
        TypeConstructor typeConstructor = this.a.getTypeConstructor();
        k21.h(typeConstructor, "classDescriptor.typeConstructor");
        return !i61.d(typeConstructor) ? d() : (T) i61.b(this.a, new ScopesHolderForClass$getScope$1(this, i61));
    }
}
