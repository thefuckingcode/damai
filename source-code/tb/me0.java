package tb;

import com.youku.arch.v3.event.Subject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class me0 {
    public static final ib2 ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = j("<LOOP IN SUPERTYPES>");
    private static final ModuleDescriptor a = new a();
    private static final c b = new c(og1.i("<ERROR CLASS>"));
    private static final g61 c = j("<ERROR PROPERTY TYPE>");
    private static final PropertyDescriptor d;
    private static final Set<PropertyDescriptor> e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements ModuleDescriptor {
        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00bc  */
        private static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                    switch (i) {
                        case 8:
                        case 9:
                        case 10:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i2];
                    switch (i) {
                        case 1:
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 13:
                        case 14:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                            break;
                        case 2:
                        case 7:
                            objArr[0] = "fqName";
                            break;
                        case 3:
                            objArr[0] = "nameFilter";
                            break;
                        case 11:
                            objArr[0] = "visitor";
                            break;
                        case 12:
                            objArr[0] = "targetModule";
                            break;
                        default:
                            objArr[0] = "capability";
                            break;
                    }
                    if (i == 1) {
                        objArr[1] = "getAnnotations";
                    } else if (i == 4) {
                        objArr[1] = "getSubPackagesOf";
                    } else if (i == 5) {
                        objArr[1] = "getName";
                    } else if (i == 6) {
                        objArr[1] = "getStableName";
                    } else if (i == 13) {
                        objArr[1] = "getOriginal";
                    } else if (i != 14) {
                        switch (i) {
                            case 8:
                                objArr[1] = "getAllDependencyModules";
                                break;
                            case 9:
                                objArr[1] = "getExpectedByModules";
                                break;
                            case 10:
                                objArr[1] = "getAllExpectedByModules";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                                break;
                        }
                    } else {
                        objArr[1] = "getBuiltIns";
                    }
                    switch (i) {
                        case 1:
                        case 4:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 13:
                        case 14:
                            break;
                        case 2:
                        case 3:
                            objArr[2] = "getSubPackagesOf";
                            break;
                        case 7:
                            objArr[2] = "getPackage";
                            break;
                        case 11:
                            objArr[2] = "accept";
                            break;
                        case 12:
                            objArr[2] = "shouldSeeInternalsOf";
                            break;
                        default:
                            objArr[2] = "getCapability";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                        switch (i) {
                            case 8:
                            case 9:
                            case 10:
                                break;
                            default:
                                throw new IllegalArgumentException(format);
                        }
                    }
                    throw new IllegalStateException(format);
                }
                i2 = 2;
                Object[] objArr2 = new Object[i2];
                switch (i) {
                }
                if (i == 1) {
                }
                switch (i) {
                }
                String format2 = String.format(str, objArr2);
                switch (i) {
                }
                throw new IllegalStateException(format2);
            }
            str = "@NotNull method %s.%s must not return null";
            switch (i) {
                case 8:
                case 9:
                case 10:
                    i2 = 2;
                    break;
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i == 1) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            switch (i) {
            }
            throw new IllegalStateException(format22);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            a(11);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            Annotations b = Annotations.Companion.b();
            if (b == null) {
                a(1);
            }
            return b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.a N0 = kotlin.reflect.jvm.internal.impl.builtins.a.N0();
            if (N0 == null) {
                a(14);
            }
            return N0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @Nullable
        public <T> T getCapability(@NotNull af1<T> af1) {
            if (af1 != null) {
                return null;
            }
            a(0);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @Nullable
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public List<ModuleDescriptor> getExpectedByModules() {
            List<ModuleDescriptor> list = m.g();
            if (list == null) {
                a(9);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
        @NotNull
        public og1 getName() {
            og1 i = og1.i("<ERROR MODULE>");
            if (i == null) {
                a(5);
            }
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @NotNull
        public DeclarationDescriptor getOriginal() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public PackageViewDescriptor getPackage(@NotNull en0 en0) {
            if (en0 == null) {
                a(7);
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public Collection<en0> getSubPackagesOf(@NotNull en0 en0, @NotNull Function1<? super og1, Boolean> function1) {
            if (en0 == null) {
                a(2);
            }
            if (function1 == null) {
                a(3);
            }
            List list = m.g();
            if (list == null) {
                a(4);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor != null) {
                return false;
            }
            a(12);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements TypeConstructor {
        final /* synthetic */ c a;
        final /* synthetic */ String b;

        b(c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i != 3 ? 2 : 3)];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String format = String.format(str, objArr);
            if (i != 3) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.a N0 = kotlin.reflect.jvm.internal.impl.builtins.a.N0();
            if (N0 == null) {
                a(2);
            }
            return N0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> list = m.g();
            if (list == null) {
                a(0);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<g61> getSupertypes() {
            List list = m.g();
            if (list == null) {
                a(1);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull i61 i61) {
            if (i61 == null) {
                a(3);
            }
            return this;
        }

        public String toString() {
            return this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends ni {
        /* JADX WARNING: Illegal instructions before constructor call */
        public c(@NotNull og1 og1) {
            super(r2, og1, r4, r5, r6, r0, false, LockBasedStorageManager.NO_LOCKS);
            if (og1 == null) {
                c(0);
            }
            ModuleDescriptor q = me0.q();
            Modality modality = Modality.OPEN;
            ClassKind classKind = ClassKind.CLASS;
            List emptyList = Collections.emptyList();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            ki G = ki.G(this, Annotations.Companion.b(), true, sourceElement);
            G.J(Collections.emptyList(), g60.INTERNAL);
            MemberScope h = me0.h(getName().b());
            G.A(new le0(me0.m("<ERROR>", this), h));
            e(h, Collections.singleton(G), G);
        }

        private static /* synthetic */ void c(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 2 || i == 5 || i == 8) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // tb.j1, tb.xe1
        @NotNull
        public MemberScope a(@NotNull xo2 xo2, @NotNull i61 i61) {
            if (xo2 == null) {
                c(6);
            }
            if (i61 == null) {
                c(7);
            }
            MemberScope h = me0.h("Error scope for class " + getName() + " with arguments: " + xo2);
            if (h == null) {
                c(8);
            }
            return h;
        }

        @Override // tb.j1
        @NotNull
        /* renamed from: d */
        public ClassDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor == null) {
                c(1);
            }
            return this;
        }

        @Override // tb.ni
        public String toString() {
            return getName().b();
        }
    }

    /* compiled from: Taobao */
    public static class d implements MemberScope {
        private final String a;

        /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
        private static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (!(i == 7 || i == 18)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
                if (!(i == 7 || i == 18)) {
                    switch (i) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                    Object[] objArr = new Object[i2];
                    switch (i) {
                        case 1:
                        case 3:
                        case 5:
                        case 8:
                        case 14:
                        case 19:
                            objArr[0] = "name";
                            break;
                        case 2:
                        case 4:
                        case 6:
                        case 9:
                        case 15:
                            objArr[0] = "location";
                            break;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                            break;
                        case 16:
                            objArr[0] = "kindFilter";
                            break;
                        case 17:
                            objArr[0] = "nameFilter";
                            break;
                        case 20:
                            objArr[0] = "p";
                            break;
                        default:
                            objArr[0] = "debugMessage";
                            break;
                    }
                    if (i == 7) {
                        objArr[1] = "getContributedVariables";
                    } else if (i != 18) {
                        switch (i) {
                            case 10:
                                objArr[1] = "getContributedFunctions";
                                break;
                            case 11:
                                objArr[1] = "getFunctionNames";
                                break;
                            case 12:
                                objArr[1] = "getVariableNames";
                                break;
                            case 13:
                                objArr[1] = "getClassifierNames";
                                break;
                            default:
                                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                                break;
                        }
                    } else {
                        objArr[1] = "getContributedDescriptors";
                    }
                    switch (i) {
                        case 1:
                        case 2:
                            objArr[2] = "getContributedClassifier";
                            break;
                        case 3:
                        case 4:
                            objArr[2] = "getContributedClassifierIncludeDeprecated";
                            break;
                        case 5:
                        case 6:
                            objArr[2] = "getContributedVariables";
                            break;
                        case 7:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 18:
                            break;
                        case 8:
                        case 9:
                            objArr[2] = "getContributedFunctions";
                            break;
                        case 14:
                        case 15:
                            objArr[2] = "recordLookup";
                            break;
                        case 16:
                        case 17:
                            objArr[2] = "getContributedDescriptors";
                            break;
                        case 19:
                            objArr[2] = "definitelyDoesNotContainName";
                            break;
                        case 20:
                            objArr[2] = "printScopeStructure";
                            break;
                        default:
                            objArr[2] = "<init>";
                            break;
                    }
                    String format = String.format(str, objArr);
                    if (!(i == 7 || i == 18)) {
                        switch (i) {
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                throw new IllegalArgumentException(format);
                        }
                    }
                    throw new IllegalStateException(format);
                }
                i2 = 2;
                Object[] objArr2 = new Object[i2];
                switch (i) {
                }
                if (i == 7) {
                }
                switch (i) {
                }
                String format2 = String.format(str, objArr2);
                switch (i) {
                }
                throw new IllegalStateException(format2);
            }
            str = "@NotNull method %s.%s must not return null";
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    i2 = 2;
                    break;
            }
            Object[] objArr22 = new Object[i2];
            switch (i) {
            }
            if (i == 7) {
            }
            switch (i) {
            }
            String format22 = String.format(str, objArr22);
            switch (i) {
            }
            throw new IllegalStateException(format22);
        }

        @NotNull
        /* renamed from: b */
        public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(8);
            }
            if (lookupLocation == null) {
                a(9);
            }
            Set<? extends SimpleFunctionDescriptor> singleton = Collections.singleton(me0.f(this));
            if (singleton == null) {
                a(10);
            }
            return singleton;
        }

        @NotNull
        /* renamed from: c */
        public Set<? extends PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            Set<? extends PropertyDescriptor> set = me0.e;
            if (set == null) {
                a(7);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getClassifierNames() {
            Set<og1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(13);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            return me0.e(og1.b());
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
            if (b60 == null) {
                a(16);
            }
            if (function1 == null) {
                a(17);
            }
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                a(18);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getFunctionNames() {
            Set<og1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(11);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getVariableNames() {
            Set<og1> emptySet = Collections.emptySet();
            if (emptySet == null) {
                a(12);
            }
            return emptySet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(14);
            }
            if (lookupLocation == null) {
                a(15);
            }
        }

        public String toString() {
            return "ErrorScope{" + this.a + '}';
        }

        private d(@NotNull String str) {
            if (str == null) {
                a(0);
            }
            this.a = str;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e implements MemberScope {
        private final String a;

        /* synthetic */ e(String str, a aVar) {
            this(str);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<og1> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(1);
            }
            if (lookupLocation == null) {
                a(2);
            }
            throw new IllegalStateException(this.a + ", required name: " + og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull b60 b60, @NotNull Function1<? super og1, Boolean> function1) {
            if (b60 == null) {
                a(9);
            }
            if (function1 == null) {
                a(10);
            }
            throw new IllegalStateException(this.a);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(7);
            }
            if (lookupLocation == null) {
                a(8);
            }
            throw new IllegalStateException(this.a + ", required name: " + og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(5);
            }
            if (lookupLocation == null) {
                a(6);
            }
            throw new IllegalStateException(this.a + ", required name: " + og1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<og1> getVariableNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull og1 og1, @NotNull LookupLocation lookupLocation) {
            if (og1 == null) {
                a(11);
            }
            if (lookupLocation == null) {
                a(12);
            }
            throw new IllegalStateException();
        }

        public String toString() {
            return "ThrowingScope{" + this.a + '}';
        }

        private e(@NotNull String str) {
            if (str == null) {
                a(0);
            }
            this.a = str;
        }
    }

    /* compiled from: Taobao */
    public static class f implements TypeConstructor {
        private final TypeParameterDescriptor a;
        private final TypeConstructor b;

        private static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @NotNull
        public TypeParameterDescriptor b() {
            TypeParameterDescriptor typeParameterDescriptor = this.a;
            if (typeParameterDescriptor == null) {
                a(1);
            }
            return typeParameterDescriptor;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.b g = DescriptorUtilsKt.g(this.a);
            if (g == null) {
                a(4);
            }
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.b.getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.b.getParameters();
            if (parameters == null) {
                a(2);
            }
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<g61> getSupertypes() {
            Collection<g61> supertypes = this.b.getSupertypes();
            if (supertypes == null) {
                a(3);
            }
            return supertypes;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.b.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull i61 i61) {
            if (i61 == null) {
                a(5);
            }
            return this;
        }
    }

    static {
        bv1 g = g();
        d = g;
        e = Collections.singleton(g);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 6 || i == 19) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = Subject.FUNCTION;
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 6 || i == 19) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static ClassDescriptor e(@NotNull String str) {
        if (str == null) {
            a(1);
        }
        return new c(og1.i("<ERROR CLASS: " + str + jl1.G));
    }

    /* access modifiers changed from: private */
    @NotNull
    public static SimpleFunctionDescriptor f(@NotNull d dVar) {
        if (dVar == null) {
            a(5);
        }
        ke0 ke0 = new ke0(b, dVar);
        ke0.l(null, null, Collections.emptyList(), Collections.emptyList(), j("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, g60.PUBLIC);
        return ke0;
    }

    @NotNull
    private static bv1 g() {
        bv1 h = bv1.h(b, Annotations.Companion.b(), Modality.OPEN, g60.PUBLIC, true, og1.i("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        h.t(c, Collections.emptyList(), null, null);
        return h;
    }

    @NotNull
    public static MemberScope h(@NotNull String str) {
        if (str == null) {
            a(2);
        }
        return i(str, false);
    }

    @NotNull
    public static MemberScope i(@NotNull String str, boolean z) {
        if (str == null) {
            a(3);
        }
        if (z) {
            return new e(str, null);
        }
        return new d(str, null);
    }

    @NotNull
    public static ib2 j(@NotNull String str) {
        if (str == null) {
            a(7);
        }
        return n(str, Collections.emptyList());
    }

    @NotNull
    public static TypeConstructor k(@NotNull String str) {
        if (str == null) {
            a(15);
        }
        return m("[ERROR : " + str + jl1.ARRAY_END_STR, b);
    }

    @NotNull
    public static TypeConstructor l(@NotNull String str) {
        if (str == null) {
            a(16);
        }
        return m(str, b);
    }

    /* access modifiers changed from: private */
    @NotNull
    public static TypeConstructor m(@NotNull String str, @NotNull c cVar) {
        if (str == null) {
            a(17);
        }
        if (cVar == null) {
            a(18);
        }
        return new b(cVar, str);
    }

    @NotNull
    public static ib2 n(@NotNull String str, @NotNull List<TypeProjection> list) {
        if (str == null) {
            a(11);
        }
        if (list == null) {
            a(12);
        }
        return new le0(k(str), h(str), list, false);
    }

    @NotNull
    public static ib2 o(@NotNull String str, @NotNull TypeConstructor typeConstructor) {
        if (str == null) {
            a(9);
        }
        if (typeConstructor == null) {
            a(10);
        }
        return new le0(typeConstructor, h(str));
    }

    @NotNull
    public static ib2 p(@NotNull String str) {
        if (str == null) {
            a(8);
        }
        return o(str, l(str));
    }

    @NotNull
    public static ModuleDescriptor q() {
        ModuleDescriptor moduleDescriptor = a;
        if (moduleDescriptor == null) {
            a(19);
        }
        return moduleDescriptor;
    }

    public static boolean r(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        return s(declarationDescriptor) || s(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == a;
    }

    private static boolean s(@Nullable DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof c;
    }

    public static boolean t(@Nullable g61 g61) {
        return g61 != null && (g61.c() instanceof f);
    }
}
