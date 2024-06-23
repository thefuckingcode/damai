package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.xi1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class j implements Incomplete {
    private final boolean a;

    public j(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    @Nullable
    public xi1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
