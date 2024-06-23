package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.h.a.c;
import tb.k53;

/* compiled from: Taobao */
public final class z13 extends z0 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static final z13 a = new z13((byte) 0);
    }

    private z13() {
    }

    /* synthetic */ z13(byte b) {
        this();
    }

    public static z13 d() {
        return a.a;
    }

    private static void e(@NonNull vy0 vy0) {
        k53.a.a.d(String.valueOf(vy0.b()), vy0.a(), vy0.c());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.efs.sdk.base.a.h.a.c, java.lang.Object] */
    @Override // com.efs.sdk.base.a.h.a.b
    public final /* bridge */ /* synthetic */ void a(@NonNull c<vy0> cVar, @Nullable vy0 vy0) {
        vy0 vy02 = vy0;
        if (vy02 != null) {
            r03.c();
            r03.d(vy02);
        }
    }

    @Override // tb.z0
    public final void a(@Nullable vy0 vy0) {
        if (vy0 != null) {
            e(vy0);
        }
    }

    @Override // tb.z0
    public final void b(@NonNull vy0 vy0) {
        e(vy0);
        if (vy0.d.containsKey("cver")) {
            String str = (String) vy0.d.get("cver");
            if (!TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(str);
                k53 k53 = k53.a.a;
                if (k53.b != null && com.efs.sdk.base.a.d.a.a().d) {
                    l23 l23 = new l23("efs_core", "config_coverage", k53.a.c);
                    l23.a("cver", Integer.valueOf(parseInt));
                    k53.b.b(l23);
                }
            }
        }
    }
}
