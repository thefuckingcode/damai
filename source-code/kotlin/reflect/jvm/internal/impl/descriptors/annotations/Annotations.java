package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.d6;
import tb.en0;
import tb.k21;

/* compiled from: Taobao */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final Annotations b = new C0269a();

        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0269a implements Annotations {
            C0269a() {
            }

            @Nullable
            public Void a(@NotNull en0 en0) {
                k21.i(en0, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public /* bridge */ /* synthetic */ AnnotationDescriptor findAnnotation(en0 en0) {
                return (AnnotationDescriptor) a(en0);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean hasAnnotation(@NotNull en0 en0) {
                return b.b(this, en0);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<AnnotationDescriptor> iterator() {
                return m.g().iterator();
            }

            @NotNull
            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        @NotNull
        public final Annotations a(@NotNull List<? extends AnnotationDescriptor> list) {
            k21.i(list, "annotations");
            return list.isEmpty() ? b : new d6(list);
        }

        @NotNull
        public final Annotations b() {
            return b;
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        @Nullable
        public static AnnotationDescriptor a(@NotNull Annotations annotations, @NotNull en0 en0) {
            Object obj;
            k21.i(annotations, "this");
            k21.i(en0, "fqName");
            Iterator it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (k21.d(((AnnotationDescriptor) obj).getFqName(), en0)) {
                    break;
                }
            }
            return (AnnotationDescriptor) obj;
        }

        public static boolean b(@NotNull Annotations annotations, @NotNull en0 en0) {
            k21.i(annotations, "this");
            k21.i(en0, "fqName");
            return annotations.findAnnotation(en0) != null;
        }
    }

    @Nullable
    AnnotationDescriptor findAnnotation(@NotNull en0 en0);

    boolean hasAnnotation(@NotNull en0 en0);

    boolean isEmpty();
}
