package kotlin.reflect.jvm.internal.impl.builtins;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.uplayer.AliMediaPlayer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bp2;
import tb.cs2;
import tb.e60;
import tb.en0;
import tb.f60;
import tb.fn0;
import tb.g61;
import tb.hd;
import tb.ib2;
import tb.jl1;
import tb.og1;
import tb.oi;
import tb.vo2;

/* compiled from: Taobao */
public abstract class b {
    public static final og1 BUILTINS_MODULE_NAME = og1.i("<built-ins module>");
    private ModuleDescriptorImpl a;
    private final NotNullLazyValue<e> b;
    private final NotNullLazyValue<Collection<PackageViewDescriptor>> c;
    private final MemoizedFunctionToNotNull<og1, ClassDescriptor> d;
    private final StorageManager e;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Function0<Collection<PackageViewDescriptor>> {
        a() {
        }

        /* renamed from: a */
        public Collection<PackageViewDescriptor> invoke() {
            return Arrays.asList(b.this.a.getPackage(c.BUILT_INS_PACKAGE_FQ_NAME), b.this.a.getPackage(c.COLLECTIONS_PACKAGE_FQ_NAME), b.this.a.getPackage(c.RANGES_PACKAGE_FQ_NAME), b.this.a.getPackage(c.ANNOTATION_PACKAGE_FQ_NAME));
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0266b implements Function0<e> {
        C0266b() {
        }

        /* renamed from: a */
        public e invoke() {
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            PrimitiveType[] values = PrimitiveType.values();
            for (PrimitiveType primitiveType : values) {
                ib2 q = b.this.q(primitiveType.getTypeName().b());
                ib2 q2 = b.this.q(primitiveType.getArrayTypeName().b());
                enumMap.put((Object) primitiveType, (Object) q2);
                hashMap.put(q, q2);
                hashMap2.put(q2, q);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    /* compiled from: Taobao */
    class c implements Function1<og1, ClassDescriptor> {
        c() {
        }

        /* renamed from: a */
        public ClassDescriptor invoke(og1 og1) {
            ClassifierDescriptor contributedClassifier = b.this.s().getContributedClassifier(og1, NoLookupLocation.FROM_BUILTINS);
            if (contributedClassifier == null) {
                throw new AssertionError("Built-in class " + c.BUILT_INS_PACKAGE_FQ_NAME.c(og1) + " is not found");
            } else if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            } else {
                throw new AssertionError("Must be a class descriptor " + og1 + ", but was " + contributedClassifier);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements Function0<Void> {
        final /* synthetic */ ModuleDescriptorImpl a;

        d(ModuleDescriptorImpl moduleDescriptorImpl) {
            this.a = moduleDescriptorImpl;
        }

        /* renamed from: a */
        public Void invoke() {
            if (b.this.a == null) {
                b.this.a = this.a;
                return null;
            }
            throw new AssertionError("Built-ins module is already set: " + b.this.a + " (attempting to reset to " + this.a + jl1.BRACKET_END_STR);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class e {
        public final Map<PrimitiveType, ib2> a;
        public final Map<g61, ib2> b;
        public final Map<ib2, ib2> c;

        /* synthetic */ e(Map map, Map map2, Map map3, a aVar) {
            this(map, map2, map3);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private e(@NotNull Map<PrimitiveType, ib2> map, @NotNull Map<g61, ib2> map2, @NotNull Map<ib2, ib2> map3) {
            if (map == null) {
                a(0);
            }
            if (map2 == null) {
                a(1);
            }
            if (map3 == null) {
                a(2);
            }
            this.a = map;
            this.b = map2;
            this.c = map3;
        }
    }

    protected b(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            a(0);
        }
        this.e = storageManager;
        this.c = storageManager.createLazyValue(new a());
        this.b = storageManager.createLazyValue(new C0266b());
        this.d = storageManager.createMemoizedFunction(new c());
    }

    @Nullable
    private static g61 A(@NotNull g61 g61, @NotNull ModuleDescriptor moduleDescriptor) {
        oi h;
        oi a2;
        ClassDescriptor a3;
        if (g61 == null) {
            a(70);
        }
        if (moduleDescriptor == null) {
            a(71);
        }
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return null;
        }
        cs2 cs2 = cs2.INSTANCE;
        if (!cs2.b(declarationDescriptor.getName()) || (h = DescriptorUtilsKt.h(declarationDescriptor)) == null || (a2 = cs2.a(h)) == null || (a3 = FindClassInModuleKt.a(moduleDescriptor, a2)) == null) {
            return null;
        }
        return a3.getDefaultType();
    }

    public static boolean A0(@NotNull g61 g61) {
        if (g61 == null) {
            a(119);
        }
        return i0(g61, c.a._short);
    }

    public static boolean B0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(106);
        }
        return e(classDescriptor, c.a.any) || e(classDescriptor, c.a.nothing);
    }

    public static boolean C0(@Nullable g61 g61) {
        return g61 != null && s0(g61, c.a.string);
    }

    public static boolean D0(@NotNull TypeConstructor typeConstructor, @NotNull fn0 fn0) {
        if (typeConstructor == null) {
            a(100);
        }
        if (fn0 == null) {
            a(101);
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        return (declarationDescriptor instanceof ClassDescriptor) && e(declarationDescriptor, fn0);
    }

    public static boolean E0(@NotNull g61 g61) {
        if (g61 == null) {
            a(127);
        }
        return i0(g61, c.a.uByteArrayFqName.j());
    }

    public static boolean F0(@NotNull g61 g61) {
        if (g61 == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
        }
        return i0(g61, c.a.uIntArrayFqName.j());
    }

    public static boolean G0(@NotNull g61 g61) {
        if (g61 == null) {
            a(130);
        }
        return i0(g61, c.a.uLongArrayFqName.j());
    }

    public static boolean H0(@NotNull g61 g61) {
        if (g61 == null) {
            a(128);
        }
        return i0(g61, c.a.uShortArrayFqName.j());
    }

    public static boolean I0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(9);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().i(c.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public static boolean J0(@NotNull g61 g61) {
        if (g61 == null) {
            a(141);
        }
        return s0(g61, c.a.unit);
    }

    public static boolean K0(@NotNull g61 g61) {
        if (g61 == null) {
            a(131);
        }
        return E0(g61) || H0(g61) || F0(g61) || G0(g61);
    }

    @Nullable
    public static PrimitiveType O(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(76);
        }
        if (c.a.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return c.a.arrayClassFqNameToPrimitiveType.get(f60.m(declarationDescriptor));
        }
        return null;
    }

    @NotNull
    private ClassDescriptor P(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(15);
        }
        return p(primitiveType.getTypeName().b());
    }

    @Nullable
    public static PrimitiveType R(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(75);
        }
        if (c.a.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return c.a.fqNameToPrimitiveType.get(f60.m(declarationDescriptor));
        }
        return null;
    }

    public static boolean Z(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(107);
        }
        return e(classDescriptor, c.a.any);
    }

    private static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i2 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = "module";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP:
            case 145:
            case DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 134:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR:
            case 130:
            case 131:
            case 132:
            case 133:
            case 135:
            case 136:
            case 137:
            case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR:
            case SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR:
            case 140:
            case 141:
            case 142:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_DISABLE_LIMITSPEED_P2P:
            case 146:
            case 148:
            case 149:
            case 150:
            case 151:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER:
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case 125:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 132:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 133:
            case 134:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 135:
                objArr[2] = "isNothing";
                break;
            case 136:
                objArr[2] = "isNullableNothing";
                break;
            case 137:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR:
                objArr[2] = "isNullableAny";
                break;
            case 140:
                objArr[2] = "isDefaultBound";
                break;
            case 141:
                objArr[2] = "isUnit";
                break;
            case 142:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_DISABLE_LIMITSPEED_P2P:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_MAX_GEAR_KEEP:
                objArr[2] = "isMemberOfAny";
                break;
            case 145:
            case 146:
                objArr[2] = "isEnum";
                break;
            case DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH:
            case 148:
                objArr[2] = "isComparable";
                break;
            case 149:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case 151:
                objArr[2] = "isSetOrNullableSet";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR:
                objArr[2] = "isMapOrNullableMap";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER:
                objArr[2] = "isKClass";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED:
                objArr[2] = "isDeprecated";
                break;
            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(format);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean a0(@NotNull g61 g61) {
        if (g61 == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR);
        }
        return h0(g61, c.a.any);
    }

    public static boolean b0(@NotNull g61 g61) {
        if (g61 == null) {
            a(87);
        }
        return h0(g61, c.a.array);
    }

    public static boolean c0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(88);
        }
        return e(classDescriptor, c.a.array) || O(classDescriptor) != null;
    }

    public static boolean d0(@NotNull g61 g61) {
        if (g61 == null) {
            a(109);
        }
        return i0(g61, c.a._boolean);
    }

    private static boolean e(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull fn0 fn0) {
        if (classifierDescriptor == null) {
            a(102);
        }
        if (fn0 == null) {
            a(103);
        }
        return classifierDescriptor.getName().equals(fn0.i()) && fn0.equals(f60.m(classifierDescriptor));
    }

    public static boolean e0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(8);
        }
        return f60.r(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
    }

    public static boolean f0(@NotNull g61 g61) {
        if (g61 == null) {
            a(116);
        }
        return i0(g61, c.a._byte);
    }

    public static boolean g0(@NotNull g61 g61) {
        if (g61 == null) {
            a(113);
        }
        return i0(g61, c.a._char);
    }

    private static boolean h0(@NotNull g61 g61, @NotNull fn0 fn0) {
        if (g61 == null) {
            a(96);
        }
        if (fn0 == null) {
            a(97);
        }
        return D0(g61.c(), fn0);
    }

    private static boolean i0(@NotNull g61 g61, @NotNull fn0 fn0) {
        if (g61 == null) {
            a(133);
        }
        if (fn0 == null) {
            a(134);
        }
        return h0(g61, fn0) && !g61.d();
    }

    public static boolean j0(@NotNull g61 g61) {
        if (g61 == null) {
            a(140);
        }
        return v0(g61);
    }

    public static boolean k0(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(c.a.deprecated)) {
            return true;
        }
        if (!(declarationDescriptor instanceof PropertyDescriptor)) {
            return false;
        }
        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
        boolean isVar = propertyDescriptor.isVar();
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
        if (getter != null && k0(getter)) {
            if (!isVar) {
                return true;
            }
            if (setter == null || !k0(setter)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean l0(@NotNull g61 g61) {
        if (g61 == null) {
            a(122);
        }
        return m0(g61) && !g61.d();
    }

    public static boolean m0(@NotNull g61 g61) {
        if (g61 == null) {
            a(132);
        }
        return h0(g61, c.a._double);
    }

    public static boolean n0(@NotNull g61 g61) {
        if (g61 == null) {
            a(120);
        }
        return o0(g61) && !g61.d();
    }

    public static boolean o0(@NotNull g61 g61) {
        if (g61 == null) {
            a(121);
        }
        return h0(g61, c.a._float);
    }

    @NotNull
    private ClassDescriptor p(@NotNull String str) {
        if (str == null) {
            a(13);
        }
        ClassDescriptor invoke = this.d.invoke(og1.f(str));
        if (invoke == null) {
            a(14);
        }
        return invoke;
    }

    public static boolean p0(@NotNull g61 g61) {
        if (g61 == null) {
            a(115);
        }
        return i0(g61, c.a._int);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NotNull
    private ib2 q(@NotNull String str) {
        if (str == null) {
            a(45);
        }
        ib2 defaultType = p(str).getDefaultType();
        if (defaultType == null) {
            a(46);
        }
        return defaultType;
    }

    public static boolean q0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER);
        }
        return e(classDescriptor, c.a.kClass);
    }

    public static boolean r0(@NotNull g61 g61) {
        if (g61 == null) {
            a(117);
        }
        return i0(g61, c.a._long);
    }

    private static boolean s0(@NotNull g61 g61, @NotNull fn0 fn0) {
        if (g61 == null) {
            a(104);
        }
        if (fn0 == null) {
            a(105);
        }
        return !g61.d() && h0(g61, fn0);
    }

    public static boolean t0(@NotNull g61 g61) {
        if (g61 == null) {
            a(135);
        }
        return u0(g61) && !bp2.l(g61);
    }

    public static boolean u0(@NotNull g61 g61) {
        if (g61 == null) {
            a(137);
        }
        return h0(g61, c.a.nothing);
    }

    public static boolean v0(@NotNull g61 g61) {
        if (g61 == null) {
            a(SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR);
        }
        return a0(g61) && g61.d();
    }

    public static boolean w0(@NotNull g61 g61) {
        if (g61 == null) {
            a(90);
        }
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return (declarationDescriptor == null || O(declarationDescriptor) == null) ? false : true;
    }

    public static boolean x0(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            a(95);
        }
        return R(classDescriptor) != null;
    }

    public static boolean y0(@NotNull g61 g61) {
        if (g61 == null) {
            a(93);
        }
        return !g61.d() && z0(g61);
    }

    public static boolean z0(@NotNull g61 g61) {
        if (g61 == null) {
            a(94);
        }
        ClassifierDescriptor declarationDescriptor = g61.c().getDeclarationDescriptor();
        return (declarationDescriptor instanceof ClassDescriptor) && x0((ClassDescriptor) declarationDescriptor);
    }

    @NotNull
    public ib2 B() {
        ib2 Q = Q(PrimitiveType.FLOAT);
        if (Q == null) {
            a(59);
        }
        return Q;
    }

    @NotNull
    public ClassDescriptor C(int i) {
        return p(c.b(i));
    }

    @NotNull
    public ib2 D() {
        ib2 Q = Q(PrimitiveType.INT);
        if (Q == null) {
            a(57);
        }
        return Q;
    }

    @NotNull
    public ClassDescriptor E() {
        ClassDescriptor o = o(c.a.kClass.l());
        if (o == null) {
            a(20);
        }
        return o;
    }

    @NotNull
    public ib2 F() {
        ib2 Q = Q(PrimitiveType.LONG);
        if (Q == null) {
            a(58);
        }
        return Q;
    }

    @NotNull
    public ClassDescriptor G() {
        return p("Nothing");
    }

    @NotNull
    public ib2 H() {
        ib2 defaultType = G().getDefaultType();
        if (defaultType == null) {
            a(47);
        }
        return defaultType;
    }

    @NotNull
    public ib2 I() {
        ib2 j = i().j(true);
        if (j == null) {
            a(50);
        }
        return j;
    }

    @NotNull
    public ib2 J() {
        ib2 j = H().j(true);
        if (j == null) {
            a(48);
        }
        return j;
    }

    @NotNull
    public ClassDescriptor K() {
        return p("Number");
    }

    @NotNull
    public ib2 L() {
        ib2 defaultType = K().getDefaultType();
        if (defaultType == null) {
            a(54);
        }
        return defaultType;
    }

    public void L0(@NotNull ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            a(1);
        }
        this.e.compute(new d(moduleDescriptorImpl));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public PlatformDependentDeclarationFilter M() {
        PlatformDependentDeclarationFilter.b bVar = PlatformDependentDeclarationFilter.b.INSTANCE;
        if (bVar == null) {
            a(3);
        }
        return bVar;
    }

    @NotNull
    public ib2 N(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(72);
        }
        ib2 ib2 = ((e) this.b.invoke()).a.get(primitiveType);
        if (ib2 == null) {
            a(73);
        }
        return ib2;
    }

    @NotNull
    public ib2 Q(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(52);
        }
        ib2 defaultType = P(primitiveType).getDefaultType();
        if (defaultType == null) {
            a(53);
        }
        return defaultType;
    }

    @NotNull
    public ib2 S() {
        ib2 Q = Q(PrimitiveType.SHORT);
        if (Q == null) {
            a(56);
        }
        return Q;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public StorageManager T() {
        StorageManager storageManager = this.e;
        if (storageManager == null) {
            a(5);
        }
        return storageManager;
    }

    @NotNull
    public ClassDescriptor U() {
        return p("String");
    }

    @NotNull
    public ib2 V() {
        ib2 defaultType = U().getDefaultType();
        if (defaultType == null) {
            a(64);
        }
        return defaultType;
    }

    @NotNull
    public ClassDescriptor W(int i) {
        ClassDescriptor o = o(c.COROUTINES_PACKAGE_FQ_NAME_RELEASE.c(og1.f(c.d(i))));
        if (o == null) {
            a(17);
        }
        return o;
    }

    @NotNull
    public ClassDescriptor X() {
        return p("Unit");
    }

    @NotNull
    public ib2 Y() {
        ib2 defaultType = X().getDefaultType();
        if (defaultType == null) {
            a(63);
        }
        return defaultType;
    }

    /* access modifiers changed from: protected */
    public void f(boolean z) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.e, this, null);
        this.a = moduleDescriptorImpl;
        moduleDescriptorImpl.l(BuiltInsLoader.Companion.a().createPackageFragmentProvider(this.e, this.a, v(), M(), g(), z));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.a;
        moduleDescriptorImpl2.r(moduleDescriptorImpl2);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public AdditionalClassPartsProvider g() {
        AdditionalClassPartsProvider.a aVar = AdditionalClassPartsProvider.a.INSTANCE;
        if (aVar == null) {
            a(2);
        }
        return aVar;
    }

    @NotNull
    public ClassDescriptor h() {
        return p("Any");
    }

    @NotNull
    public ib2 i() {
        ib2 defaultType = h().getDefaultType();
        if (defaultType == null) {
            a(49);
        }
        return defaultType;
    }

    @NotNull
    public ClassDescriptor j() {
        return p("Array");
    }

    @NotNull
    public g61 k(@NotNull g61 g61) {
        g61 A;
        if (g61 == null) {
            a(66);
        }
        if (!b0(g61)) {
            g61 n = bp2.n(g61);
            ib2 ib2 = ((e) this.b.invoke()).c.get(n);
            if (ib2 != null) {
                return ib2;
            }
            ModuleDescriptor i = f60.i(n);
            if (i != null && (A = A(n, i)) != null) {
                return A;
            }
            throw new IllegalStateException("not array: " + g61);
        } else if (g61.b().size() == 1) {
            g61 type = g61.b().get(0).getType();
            if (type == null) {
                a(67);
            }
            return type;
        } else {
            throw new IllegalStateException();
        }
    }

    @NotNull
    public ib2 l(@NotNull Variance variance, @NotNull g61 g61) {
        if (variance == null) {
            a(81);
        }
        if (g61 == null) {
            a(82);
        }
        ib2 m = m(variance, g61, Annotations.Companion.b());
        if (m == null) {
            a(83);
        }
        return m;
    }

    @NotNull
    public ib2 m(@NotNull Variance variance, @NotNull g61 g61, @NotNull Annotations annotations) {
        if (variance == null) {
            a(77);
        }
        if (g61 == null) {
            a(78);
        }
        if (annotations == null) {
            a(79);
        }
        ib2 g = KotlinTypeFactory.g(annotations, j(), Collections.singletonList(new vo2(variance, g61)));
        if (g == null) {
            a(80);
        }
        return g;
    }

    @NotNull
    public ib2 n() {
        ib2 Q = Q(PrimitiveType.BOOLEAN);
        if (Q == null) {
            a(62);
        }
        return Q;
    }

    @NotNull
    public ClassDescriptor o(@NotNull en0 en0) {
        if (en0 == null) {
            a(11);
        }
        ClassDescriptor a2 = e60.a(this.a, en0, NoLookupLocation.FROM_BUILTINS);
        if (a2 == null) {
            a(12);
        }
        return a2;
    }

    @NotNull
    public ModuleDescriptorImpl r() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.a;
        if (moduleDescriptorImpl == null) {
            a(6);
        }
        return moduleDescriptorImpl;
    }

    @NotNull
    public MemberScope s() {
        MemberScope memberScope = this.a.getPackage(c.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            a(10);
        }
        return memberScope;
    }

    @NotNull
    public ib2 t() {
        ib2 Q = Q(PrimitiveType.BYTE);
        if (Q == null) {
            a(55);
        }
        return Q;
    }

    @NotNull
    public ib2 u() {
        ib2 Q = Q(PrimitiveType.CHAR);
        if (Q == null) {
            a(61);
        }
        return Q;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Iterable<ClassDescriptorFactory> v() {
        List singletonList = Collections.singletonList(new hd(this.e, this.a));
        if (singletonList == null) {
            a(4);
        }
        return singletonList;
    }

    @NotNull
    public ClassDescriptor w() {
        ClassDescriptor o = o(c.a.collection);
        if (o == null) {
            a(33);
        }
        return o;
    }

    @NotNull
    public ClassDescriptor x() {
        return p("Comparable");
    }

    @NotNull
    public ib2 y() {
        ib2 I = I();
        if (I == null) {
            a(51);
        }
        return I;
    }

    @NotNull
    public ib2 z() {
        ib2 Q = Q(PrimitiveType.DOUBLE);
        if (Q == null) {
            a(60);
        }
        return Q;
    }
}
