package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.tencent.smtt.sdk.TbsListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeMappingMode.kt */
public final class TypeMappingMode {
    public static final TypeMappingMode CLASS_DECLARATION;
    public static final Companion Companion = new Companion(null);
    public static final TypeMappingMode DEFAULT;
    public static final TypeMappingMode GENERIC_ARGUMENT;
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, null, false, null, null, TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL, null);
    public static final TypeMappingMode SUPER_TYPE;
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr[Variance.INVARIANT.ordinal()] = 2;
        }
    }

    private TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3) {
        this.needPrimitiveBoxing = z;
        this.needInlineClassWrapping = z2;
        this.isForAnnotationParameter = z3;
        this.skipDeclarationSiteWildcards = z4;
        this.skipDeclarationSiteWildcardsIfPossible = z5;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z6;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* synthetic */ TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r5, r7, (i & 64) == 0 ? z6 : r2, (i & 128) != 0 ? r7 : typeMappingMode2, (i & 256) != 0 ? r7 : typeMappingMode3);
        boolean z7 = true;
        boolean z8 = (i & 1) != 0 ? true : z;
        boolean z9 = (i & 2) != 0 ? true : z2;
        boolean z10 = false;
        boolean z11 = (i & 4) != 0 ? false : z3;
        boolean z12 = (i & 8) != 0 ? false : z4;
        z10 = (i & 16) == 0 ? z5 : z10;
        TypeMappingMode typeMappingMode4 = (i & 32) != 0 ? null : typeMappingMode;
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    /* compiled from: TypeMappingMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, null, false, null, null, 511, null);
        GENERIC_ARGUMENT = typeMappingMode;
        DEFAULT = new TypeMappingMode(false, false, false, false, false, typeMappingMode, false, null, null, 476, null);
        CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, typeMappingMode, false, null, null, 476, null);
        SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, 471, null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, typeMappingMode, false, null, null, TbsListener.ErrorCode.INFO_CAN_NOT_LOAD_X5, null);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, new TypeMappingMode(false, false, true, false, false, typeMappingMode, false, null, null, 475, null), false, null, null, 472, null);
    }

    public final TypeMappingMode toGenericArgumentMode(Variance variance) {
        Intrinsics.checkParameterIsNotNull(variance, "effectiveVariance");
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            TypeMappingMode typeMappingMode = this.genericContravariantArgumentMode;
            if (typeMappingMode != null) {
                return typeMappingMode;
            }
        } else if (i != 2) {
            TypeMappingMode typeMappingMode2 = this.genericArgumentMode;
            if (typeMappingMode2 != null) {
                return typeMappingMode2;
            }
        } else {
            TypeMappingMode typeMappingMode3 = this.genericInvariantArgumentMode;
            if (typeMappingMode3 != null) {
                return typeMappingMode3;
            }
        }
        return this;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode);
    }
}
