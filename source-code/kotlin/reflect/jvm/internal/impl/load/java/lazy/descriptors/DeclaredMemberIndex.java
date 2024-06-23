package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.og1;

/* compiled from: Taobao */
public interface DeclaredMemberIndex {

    /* compiled from: Taobao */
    public static final class a implements DeclaredMemberIndex {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @NotNull
        /* renamed from: a */
        public List<JavaMethod> findMethodsByName(@NotNull og1 og1) {
            k21.i(og1, "name");
            return m.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaField findFieldByName(@NotNull og1 og1) {
            k21.i(og1, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @Nullable
        public JavaRecordComponent findRecordComponentByName(@NotNull og1 og1) {
            k21.i(og1, "name");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<og1> getFieldNames() {
            return e0.d();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<og1> getMethodNames() {
            return e0.d();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        @NotNull
        public Set<og1> getRecordComponentNames() {
            return e0.d();
        }
    }

    @Nullable
    JavaField findFieldByName(@NotNull og1 og1);

    @NotNull
    Collection<JavaMethod> findMethodsByName(@NotNull og1 og1);

    @Nullable
    JavaRecordComponent findRecordComponentByName(@NotNull og1 og1);

    @NotNull
    Set<og1> getFieldNames();

    @NotNull
    Set<og1> getMethodNames();

    @NotNull
    Set<og1> getRecordComponentNames();
}
