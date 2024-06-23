package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public interface LookupTracker {

    /* compiled from: Taobao */
    public static final class a implements LookupTracker {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3) {
            k21.i(str, "filePath");
            k21.i(position, "position");
            k21.i(str2, "scopeFqName");
            k21.i(scopeKind, "scopeKind");
            k21.i(str3, "name");
        }
    }

    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
