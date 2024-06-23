package tb;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.a.e.b;
import tb.k53;

/* compiled from: Taobao */
public final class p33 extends z0 {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        private static final p33 a = new p33((byte) 0);
    }

    private p33() {
    }

    /* synthetic */ p33(byte b) {
        this();
    }

    public static p33 d() {
        return a.a;
    }

    private static void e(@Nullable vy0 vy0) {
        String str;
        if (com.efs.sdk.base.a.d.a.a().d()) {
            if (vy0 == null) {
                str = "upload result : " + "false";
            } else {
                str = "upload result : " + vy0.a + ", resp is " + vy0.toString();
            }
            t43.a("efs.px.api", str);
        }
    }

    private static void f(vy0 vy0) {
        k53.a.a.d(String.valueOf(vy0.b()), vy0.a(), vy0.c());
    }

    private static void g(vy0 vy0) {
        int parseInt;
        if (vy0.d.containsKey("cver")) {
            String str = (String) vy0.d.get("cver");
            if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(str)) > c.a().e.a) {
                c.a().d(parseInt);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.efs.sdk.base.a.h.a.c, java.lang.Object] */
    @Override // com.efs.sdk.base.a.h.a.b
    public final /* synthetic */ void a(@NonNull com.efs.sdk.base.a.h.a.c<vy0> cVar, @Nullable vy0 vy0) {
        vy0 vy02 = vy0;
        if (vy02 != null) {
            com.efs.sdk.base.a.h.b.a aVar = (com.efs.sdk.base.a.h.b.a) cVar;
            vy02.d.putAll(aVar.f);
            aVar.f.clear();
            r03.c();
            r03.d(vy02);
        }
    }

    @Override // tb.z0
    public final void a(@Nullable vy0 vy0) {
        e(vy0);
        if (vy0 != null) {
            f(vy0);
            g(vy0);
        }
    }

    @Override // tb.z0
    public final void b(@NonNull vy0 vy0) {
        int i;
        if (!vy0.d.containsKey("flow_limit") || !Boolean.FALSE.toString().equals(vy0.d.get("flow_limit"))) {
            String str = vy0.d.containsKey("type") ? (String) vy0.d.get("type") : "";
            if (vy0.d.containsKey("size")) {
                String str2 = (String) vy0.d.get("size");
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.parseInt(str2);
                    b b = b.b();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i;
                    b.sendMessage(obtain);
                }
            }
            i = 0;
            b b2 = b.b();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i;
            b2.sendMessage(obtain2);
        }
        f(vy0);
        k53.a.a.c.d.incrementAndGet();
        g(vy0);
        e(vy0);
    }
}
