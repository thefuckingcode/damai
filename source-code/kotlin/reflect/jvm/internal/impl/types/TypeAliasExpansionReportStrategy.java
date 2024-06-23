package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.g61;
import tb.k21;

/* compiled from: Taobao */
public interface TypeAliasExpansionReportStrategy {

    /* compiled from: Taobao */
    public static final class a implements TypeAliasExpansionReportStrategy {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void boundsViolationInSubstitution(@NotNull g61 g61, @NotNull g61 g612, @NotNull g61 g613, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
            k21.i(g61, "bound");
            k21.i(g612, "unsubstitutedArgument");
            k21.i(g613, "argument");
            k21.i(typeParameterDescriptor, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void conflictingProjection(@NotNull TypeAliasDescriptor typeAliasDescriptor, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull g61 g61) {
            k21.i(typeAliasDescriptor, "typeAlias");
            k21.i(g61, "substitutedArgument");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void recursiveTypeAlias(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
            k21.i(typeAliasDescriptor, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy
        public void repeatedAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
            k21.i(annotationDescriptor, "annotation");
        }
    }

    void boundsViolationInSubstitution(@NotNull g61 g61, @NotNull g61 g612, @NotNull g61 g613, @NotNull TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(@NotNull TypeAliasDescriptor typeAliasDescriptor, @Nullable TypeParameterDescriptor typeParameterDescriptor, @NotNull g61 g61);

    void recursiveTypeAlias(@NotNull TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(@NotNull AnnotationDescriptor annotationDescriptor);
}
