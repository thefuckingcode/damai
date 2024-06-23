package kotlin.reflect.jvm.internal.impl.renderer;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fn0;
import tb.g61;
import tb.jl1;
import tb.k21;
import tb.m40;
import tb.og1;
import tb.ur2;

/* compiled from: Taobao */
public abstract class DescriptorRenderer {
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    @NotNull
    public static final a Companion;
    @JvmField
    @NotNull
    public static final DescriptorRenderer DEBUG_TEXT;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    @JvmField
    @NotNull
    public static final DescriptorRenderer HTML;
    @JvmField
    @NotNull
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @JvmField
    @NotNull
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    /* compiled from: Taobao */
    public interface ValueParametersHandler {

        /* compiled from: Taobao */
        public static final class a implements ValueParametersHandler {
            @NotNull
            public static final a INSTANCE = new a();

            private a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                k21.i(valueParameterDescriptor, "parameter");
                k21.i(sb, "builder");
                if (i != i2 - 1) {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i, @NotNull StringBuilder sb) {
                k21.i(sb, "builder");
                sb.append(jl1.BRACKET_END_STR);
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb) {
                k21.i(valueParameterDescriptor, "parameter");
                k21.i(sb, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i, @NotNull StringBuilder sb) {
                k21.i(sb, "builder");
                sb.append(jl1.BRACKET_START_STR);
            }
        }

        void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendAfterValueParameters(int i, @NotNull StringBuilder sb);

        void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i, int i2, @NotNull StringBuilder sb);

        void appendBeforeValueParameters(int i, @NotNull StringBuilder sb);
    }

    /* compiled from: Taobao */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public /* synthetic */ class C0282a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final String a(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            k21.i(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (C0282a.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new AssertionError(k21.r("Unexpected classifier: ", classifierDescriptorWithTypeParameters));
            }
        }

        @NotNull
        public final DescriptorRenderer b(@NotNull Function1<? super DescriptorRendererOptions, ur2> function1) {
            k21.i(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.V();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    static {
        a aVar = new a(null);
        Companion = aVar;
        COMPACT_WITH_MODIFIERS = aVar.b(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = aVar.b(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = aVar.b(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = aVar.b(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = aVar.b(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = aVar.b(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = aVar.b(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = aVar.b(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = aVar.b(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = aVar.b(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public static /* synthetic */ String c(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.b(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @NotNull
    public abstract String a(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract String b(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String d(@NotNull String str, @NotNull String str2, @NotNull b bVar);

    @NotNull
    public abstract String e(@NotNull fn0 fn0);

    @NotNull
    public abstract String f(@NotNull og1 og1, boolean z);

    @NotNull
    public abstract String g(@NotNull g61 g61);

    @NotNull
    public abstract String h(@NotNull TypeProjection typeProjection);

    @NotNull
    public final DescriptorRenderer i(@NotNull Function1<? super DescriptorRendererOptions, ur2> function1) {
        k21.i(function1, "changeOptions");
        DescriptorRendererOptionsImpl a2 = ((DescriptorRendererImpl) this).R().a();
        function1.invoke(a2);
        a2.V();
        return new DescriptorRendererImpl(a2);
    }
}
