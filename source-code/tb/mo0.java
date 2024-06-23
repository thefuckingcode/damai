package tb;

import android.graphics.Rect;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.nq0;

/* compiled from: Taobao */
public final class mo0 {
    @NotNull
    public static final mo0 INSTANCE = new mo0();

    private mo0() {
    }

    public final int a(@NotNull String str) {
        k21.i(str, "direction");
        if (k21.d(str, Constants.Value.HORIZONTAL)) {
            return 0;
        }
        k21.d(str, LiveBundleLayout.TYPE_VERTICAL);
        return 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0079 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    @Nullable
    public final Rect b(@Nullable String str) {
        boolean z;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
                if (z) {
                    return null;
                }
                List list = StringsKt__StringsKt.z0(o.F(o.F(str, jl1.BLOCK_START_STR, "", false, 4, null), "}", "", false, 4, null), new String[]{","}, false, 0, 6, null);
                nq0.b bVar = nq0.Companion;
                return new Rect(bVar.d((String) list.get(1)).d(), bVar.d((String) list.get(0)).d(), bVar.d((String) list.get(3)).d(), bVar.d((String) list.get(2)).d());
            }
        }
        z = false;
        if (z) {
        }
    }

    public final int c(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return nq0.Companion.d(str).d();
    }
}
