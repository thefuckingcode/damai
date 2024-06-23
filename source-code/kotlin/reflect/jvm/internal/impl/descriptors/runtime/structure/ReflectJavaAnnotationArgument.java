package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory Factory = new Factory(null);
    private final Name name;

    public ReflectJavaAnnotationArgument(Name name2) {
        this.name = name2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReflectJavaAnnotationArgument create(Object obj, Name name) {
            Intrinsics.checkParameterIsNotNull(obj, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
                return new ReflectJavaEnumValueAnnotationArgument(name, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new ReflectJavaArrayAnnotationArgument(name, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new ReflectJavaClassObjectAnnotationArgument(name, (Class) obj);
            }
            return new ReflectJavaLiteralAnnotationArgument(name, obj);
        }
    }
}
