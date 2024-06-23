package tb;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class zx1 implements JavaAnnotationArgument {
    @NotNull
    public static final a Factory = new a(null);
    @Nullable
    private final og1 a;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final zx1 a(@NotNull Object obj, @Nullable og1 og1) {
            k21.i(obj, "value");
            if (ReflectClassUtilKt.i(obj.getClass())) {
                return new ky1(og1, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new ay1(og1, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new cy1(og1, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new gy1(og1, (Class) obj);
            }
            return new my1(og1, obj);
        }
    }

    public zx1(@Nullable og1 og1) {
        this.a = og1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    @Nullable
    public og1 getName() {
        return this.a;
    }
}
