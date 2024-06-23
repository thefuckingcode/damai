package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.internal.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class xi1 extends q81 implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    @NotNull
    public xi1 getList() {
        return this;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.b
    @NotNull
    public String toString() {
        return n30.c() ? v("Active") : super.toString();
    }

    @NotNull
    public final String v(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        for (b bVar = (b) j(); !k21.d(bVar, this); bVar = bVar.k()) {
            if (bVar instanceof l41) {
                l41 l41 = (l41) bVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(AVFSCacheConstants.COMMA_SEP);
                }
                sb.append(l41);
            }
        }
        sb.append(jl1.ARRAY_END_STR);
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
