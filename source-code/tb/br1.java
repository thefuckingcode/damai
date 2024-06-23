package tb;

import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class br1 {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static br1 e;
    @NotNull
    private Map<String, PopupResponseBean> a = new LinkedHashMap();
    @NotNull
    private Map<String, Boolean> b = new LinkedHashMap();
    @Nullable
    private ArrayList<String> c;
    @Nullable
    private ArrayList<String> d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final synchronized br1 a() {
            br1 br1;
            if (br1.e == null) {
                br1.e = new br1();
            }
            br1 = br1.e;
            k21.f(br1);
            return br1;
        }
    }

    @Nullable
    public final synchronized PopupResponseBean c(@NotNull String str) {
        k21.i(str, "sceneType");
        if (!this.a.containsKey(str)) {
            return null;
        }
        return this.a.get(str);
    }

    public final synchronized boolean d(@NotNull String str) {
        k21.i(str, "sceneType");
        return this.b.containsKey(str);
    }

    @Nullable
    public final synchronized ArrayList<PopupDetailBean> e(@NotNull String str) {
        k21.i(str, "sceneType");
        ArrayList<PopupDetailBean> arrayList = null;
        if (!this.a.containsKey(str)) {
            return null;
        }
        PopupResponseBean popupResponseBean = this.a.get(str);
        if (popupResponseBean != null) {
            arrayList = popupResponseBean.trigger;
        }
        return arrayList;
    }

    @NotNull
    public final Map<String, PopupResponseBean> f() {
        return this.a;
    }

    @NotNull
    public final Map<String, Boolean> g() {
        return this.b;
    }

    @Nullable
    public final ArrayList<String> h() {
        return this.d;
    }

    @Nullable
    public final ArrayList<String> i() {
        return this.c;
    }

    public final synchronized void j(@NotNull String str) {
        k21.i(str, "sceneType");
        k(str);
        l(str);
    }

    public final synchronized void k(@NotNull String str) {
        k21.i(str, "sceneType");
        if (this.a.containsKey(str)) {
            this.a.remove(str);
        }
    }

    public final synchronized void l(@NotNull String str) {
        k21.i(str, "sceneType");
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }

    public final void m(@Nullable ArrayList<String> arrayList) {
        this.d = arrayList;
    }

    public final void n(@Nullable ArrayList<String> arrayList) {
        this.c = arrayList;
    }
}
