package tb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.popupcenter.view.DialogCustomView;
import com.alibaba.yymidservice.popup.request.PopupReportRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmOverloads;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class kr1 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String fileName = "popup_scene_type_config";
    @Nullable
    private static kr1 g;
    @NotNull
    private Map<String, List<DialogCustomView>> a = new LinkedHashMap();
    @Nullable
    private Activity b;
    @NotNull
    private String c = "";
    @Nullable
    private ArrayList<String> d;
    @Nullable
    private ArrayList<String> e;
    @NotNull
    private AtomicBoolean f = new AtomicBoolean(false);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final synchronized kr1 a() {
            kr1 kr1;
            if (kr1.g == null) {
                kr1.g = new kr1();
            }
            kr1 = kr1.g;
            k21.f(kr1);
            return kr1;
        }
    }

    private final boolean f() {
        try {
            InputStream open = AppInfoProviderProxy.getApplication().getAssets().open("popup_scene_type_config.json");
            k21.h(open, "getApplication().assets.open(\"$fileName.json\")");
            String c2 = zh0.c(open);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            bh0 bh0 = bh0.INSTANCE;
            JSONObject a2 = bh0.a(c2);
            if (a2.containsKey("sceneTypes")) {
                String string = a2.getString("sceneTypes");
                if (string != null) {
                    r(or1.a((String[]) bh0.c(string, String[].class)));
                }
            }
            if (!a2.containsKey("localPopupPages")) {
                return false;
            }
            String string2 = a2.getString("localPopupPages");
            if (string2 == null) {
                return false;
            }
            q(or1.a((String[]) bh0.c(string2, String[].class)));
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @NotNull
    public final String c(@NotNull Activity activity) {
        k21.i(activity, "activity");
        return activity.getClass().getSimpleName() + '_' + activity.hashCode();
    }

    @Nullable
    public final PopupResponseBean d(@NotNull Activity activity) {
        k21.i(activity, "sceneType");
        return br1.Companion.a().c(c(activity));
    }

    @NotNull
    public final String e() {
        return this.c;
    }

    @Nullable
    public final ArrayList<String> g() {
        return this.e;
    }

    @Nullable
    public final ArrayList<String> h() {
        return this.d;
    }

    @Nullable
    public final List<DialogCustomView> i(@NotNull Activity activity) {
        k21.i(activity, "sceneType");
        if (this.a.containsKey(c(activity))) {
            return this.a.get(c(activity));
        }
        return null;
    }

    @Nullable
    public final Activity j() {
        return this.b;
    }

    @Nullable
    public final ArrayList<PopupDetailBean> k(@NotNull Activity activity) {
        k21.i(activity, "sceneType");
        return br1.Companion.a().e(c(activity));
    }

    @NotNull
    public final AtomicBoolean l() {
        return this.f;
    }

    public final boolean m(@NotNull Activity activity) {
        k21.i(activity, "sceneType");
        return br1.Companion.a().d(c(activity));
    }

    public final void n(@NotNull Application application, @NotNull String str, @Nullable ArrayList<String> arrayList) {
        k21.i(application, "application");
        k21.i(str, "cityId");
        f();
        br1.Companion.a().m(arrayList);
        this.c = str;
        application.registerActivityLifecycleCallbacks(new jq1());
        HashMap hashMap = new HashMap();
        bh0 bh0 = bh0.INSTANCE;
        hashMap.put("sceneTypeLocals", bh0.e(this.d));
        hashMap.put("localPopupPages", bh0.e(this.e));
        hashMap.put("sceneTypeOrange", bh0.e(arrayList));
        or1.g("PopupLauncher", AgooConstants.MESSAGE_POPUP, "popInit", hashMap);
    }

    @JvmOverloads
    public final void o(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable org.json.JSONObject jSONObject) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "comboCityId");
        new PopupReportRequest().a(context, str, str2, jSONObject);
    }

    public final void p(@NotNull String str) {
        k21.i(str, "cityIdStr");
        this.c = str;
    }

    public final void q(@Nullable ArrayList<String> arrayList) {
        this.e = arrayList;
    }

    public final void r(@Nullable ArrayList<String> arrayList) {
        this.d = arrayList;
    }

    public final void s(@Nullable Activity activity) {
        this.b = activity;
    }
}
