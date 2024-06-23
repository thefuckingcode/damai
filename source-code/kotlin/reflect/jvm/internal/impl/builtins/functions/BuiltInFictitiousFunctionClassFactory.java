package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.lzy.okgo.cookie.SerializableCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
public final class BuiltInFictitiousFunctionClassFactory implements ClassDescriptorFactory {
    public static final Companion Companion = new Companion(null);
    private final ModuleDescriptor module;
    private final StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(StorageManager storageManager2, ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(storageManager2, "storageManager");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
        this.storageManager = storageManager2;
        this.module = moduleDescriptor;
    }

    /* access modifiers changed from: private */
    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    public static final class KindWithArity {
        private final int arity;
        private final FunctionClassDescriptor.Kind kind;

        public final FunctionClassDescriptor.Kind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KindWithArity)) {
                return false;
            }
            KindWithArity kindWithArity = (KindWithArity) obj;
            return Intrinsics.areEqual(this.kind, kindWithArity.kind) && this.arity == kindWithArity.arity;
        }

        public int hashCode() {
            FunctionClassDescriptor.Kind kind2 = this.kind;
            return ((kind2 != null ? kind2.hashCode() : 0) * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + ")";
        }

        public KindWithArity(FunctionClassDescriptor.Kind kind2, int i) {
            Intrinsics.checkParameterIsNotNull(kind2, "kind");
            this.kind = kind2;
            this.arity = i;
        }

        public final FunctionClassDescriptor.Kind getKind() {
            return this.kind;
        }
    }

    /* compiled from: BuiltInFictitiousFunctionClassFactory.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final KindWithArity parseClassName(String str, FqName fqName) {
            FunctionClassDescriptor.Kind byClassNamePrefix = FunctionClassDescriptor.Kind.Companion.byClassNamePrefix(fqName, str);
            if (byClassNamePrefix == null) {
                return null;
            }
            Companion companion = this;
            int length = byClassNamePrefix.getClassNamePrefix().length();
            if (str != null) {
                String substring = str.substring(length);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                Integer num = companion.toInt(substring);
                if (num != null) {
                    return new KindWithArity(byClassNamePrefix, num.intValue());
                }
                return null;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        @JvmStatic
        public final FunctionClassDescriptor.Kind getFunctionalClassKind(String str, FqName fqName) {
            Intrinsics.checkParameterIsNotNull(str, "className");
            Intrinsics.checkParameterIsNotNull(fqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(str, fqName);
            if (parseClassName != null) {
                return parseClassName.getKind();
            }
            return null;
        }

        private final Integer toInt(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int charAt = str.charAt(i2) - '0';
                if (charAt < 0 || 9 < charAt) {
                    return null;
                }
                i = (i * 10) + charAt;
            }
            return Integer.valueOf(i);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(FqName fqName, Name name) {
        Intrinsics.checkParameterIsNotNull(fqName, "packageFqName");
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        String asString = name.asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "name.asString()");
        if ((StringsKt.startsWith$default(asString, "Function", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "KFunction", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "SuspendFunction", false, 2, (Object) null) || StringsKt.startsWith$default(asString, "KSuspendFunction", false, 2, (Object) null)) && Companion.parseClassName(asString, fqName) != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public ClassDescriptor createClass(ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        if (!classId.isLocal() && !classId.isNestedClass()) {
            String asString = classId.getRelativeClassName().asString();
            Intrinsics.checkExpressionValueIsNotNull(asString, "classId.relativeClassName.asString()");
            if (!StringsKt.contains$default((CharSequence) asString, (CharSequence) "Function", false, 2, (Object) null)) {
                return null;
            }
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(packageFqName, "classId.packageFqName");
            KindWithArity parseClassName = Companion.parseClassName(asString, packageFqName);
            if (parseClassName != null) {
                FunctionClassDescriptor.Kind component1 = parseClassName.component1();
                int component2 = parseClassName.component2();
                ArrayList arrayList = new ArrayList();
                for (T t : this.module.getPackage(packageFqName).getFragments()) {
                    if (t instanceof BuiltInsPackageFragment) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (obj instanceof FunctionInterfacePackageFragment) {
                        arrayList3.add(obj);
                    }
                }
                Object obj2 = (FunctionInterfacePackageFragment) CollectionsKt.firstOrNull((List) arrayList3);
                if (obj2 == null) {
                    obj2 = CollectionsKt.first((List) arrayList2);
                }
                return new FunctionClassDescriptor(this.storageManager, (BuiltInsPackageFragment) obj2, component1, component2);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName) {
        Intrinsics.checkParameterIsNotNull(fqName, "packageFqName");
        return SetsKt.emptySet();
    }
}
