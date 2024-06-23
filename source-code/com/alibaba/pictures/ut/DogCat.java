package com.alibaba.pictures.ut;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.pictures.ut.ExposureDog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.exposure.ExposureConfigMgr;
import com.ut.mini.internal.UTTeamWork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cg0;
import tb.id2;
import tb.k21;
import tb.oq2;
import tb.ot2;
import tb.uq2;

/* compiled from: Taobao */
public final class DogCat {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final DogCat INSTANCE = new DogCat();
    @Nullable
    private static id2 a;
    private static final Rect b = new Rect();
    private static final Lazy c = b.b(DogCat$catMap$2.INSTANCE);
    private static final Lazy d = b.b(DogCat$dogMap$2.INSTANCE);
    private static Object e;
    @Nullable
    private static String f;
    private static final List<ExposureDog.ExposureObserver> g = new ArrayList();

    static {
        uq2.INSTANCE.a();
    }

    private DogCat() {
    }

    private final double D(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462858656")) {
            return ((Double) ipChange.ipc$dispatch("-462858656", new Object[]{this, view})).doubleValue();
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = b;
        int i = width * height;
        if (!view.getGlobalVisibleRect(rect) || i <= 0) {
            return 0.0d;
        }
        return (((double) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect))) * 1.0d) / ((double) i);
    }

    public static /* synthetic */ String b(DogCat dogCat, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return dogCat.a(str, str2);
    }

    @JvmStatic
    @Nullable
    public static final <T extends Activity> T m(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328279637")) {
            return (T) ((Activity) ipChange.ipc$dispatch("1328279637", new Object[]{view}));
        }
        k21.i(view, "view");
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (T) ((Activity) context);
            }
        }
        return null;
    }

    private final Map<Integer, ExposureDog> o() {
        Object value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694955811")) {
            value = ipChange.ipc$dispatch("1694955811", new Object[]{this});
        } else {
            value = d.getValue();
        }
        return (Map) value;
    }

    private final String z(Object obj, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1268499157")) {
            return (String) ipChange.ipc$dispatch("1268499157", new Object[]{this, obj, str});
        }
        ot2.a("tryGetAndUpdatePageName,tPageName=" + str);
        if ((str == null || str.length() == 0) && (obj instanceof IUTPageOperation)) {
            IUTPageOperation iUTPageOperation = (IUTPageOperation) obj;
            f = iUTPageOperation.getPageSPM();
            str = iUTPageOperation.getUTPageName();
        }
        if (!(str == null || str.length() == 0)) {
            String str2 = f;
            if (str2 == null || str2.length() == 0) {
                f = uq2.INSTANCE.h(str);
            }
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        uq2 uq2 = uq2.INSTANCE;
        String e2 = uq2.e();
        if (!(e2 == null || e2.length() == 0)) {
            z = false;
        }
        if (z) {
            return str;
        }
        String e3 = uq2.e();
        k21.f(e3);
        if (o.L(str, e3, false, 2, null)) {
            return str;
        }
        return uq2.e() + str;
    }

    @Nullable
    public final String A(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129822273")) {
            return (String) ipChange.ipc$dispatch("-129822273", new Object[]{this, str});
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            List<String> split = new Regex("\\.").split(str, 0);
            if (split.size() >= 4) {
                return split.get(3);
            }
            return split.size() >= 2 ? split.get(split.size() - 1) : "0";
        } catch (Exception e2) {
            ot2.c("tryGetSpmD-error:" + e2.getMessage());
            return null;
        }
    }

    public final void B(@Nullable Object obj, @Nullable Properties properties) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914096019")) {
            ipChange.ipc$dispatch("914096019", new Object[]{this, obj, properties});
        } else if (obj != null && properties != null && properties.size() > 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : properties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                hashMap.put(key.toString(), value.toString());
                ot2.a("updatePageProperties:" + key + ',' + value);
            }
            ot2.a("updatePageProperties:" + obj);
            UTAnalytics instance = UTAnalytics.getInstance();
            k21.h(instance, "UTAnalytics.getInstance()");
            instance.getDefaultTracker().updatePageProperties(obj, hashMap);
        }
    }

    public final void C(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915926485")) {
            ipChange.ipc$dispatch("-1915926485", new Object[]{this, str});
            return;
        }
        k21.i(str, "spm");
        HashMap hashMap = new HashMap(1);
        hashMap.put("spm", str);
        UTAnalytics instance = UTAnalytics.getInstance();
        k21.h(instance, "UTAnalytics.getInstance()");
        instance.getDefaultTracker().updateNextPageProperties(hashMap);
    }

    @Nullable
    public final String a(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1379476677")) {
            return (String) ipChange.ipc$dispatch("1379476677", new Object[]{this, str, str2});
        }
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            int size = new Regex("\\.").split(str, 0).size();
            if (size == 1) {
                if (!(str2 == null || str2.length() == 0)) {
                    z = false;
                }
                if (z) {
                    return f() + '.' + str + ".0";
                }
                return uq2.INSTANCE.f() + '.' + str2 + '.' + str + ".0";
            } else if (size == 2) {
                if (str2 != null) {
                    if (str2.length() != 0) {
                        z = false;
                    }
                }
                if (z) {
                    return f() + '.' + str;
                }
                return uq2.INSTANCE.f() + '.' + str2 + '.' + str;
            } else if (size != 3) {
                return str;
            } else {
                return uq2.INSTANCE.f() + '.' + str;
            }
        } catch (Exception e2) {
            ot2.c("autoCompletionElementSpm-error:" + e2.getMessage());
            return str;
        }
    }

    public final boolean c(@Nullable String str) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196338313")) {
            return ((Boolean) ipChange.ipc$dispatch("-1196338313", new Object[]{this, str})).booleanValue();
        }
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                    if (!z || new Regex("\\.").split(str, 0).size() != 4) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e2) {
                ot2.c("checkElementSpmLegal-error:" + e2.getMessage());
                return false;
            }
        }
        z = true;
        if (!z) {
        }
        return false;
    }

    @NotNull
    public final ClickCat d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1475618820")) {
            return new ClickCat(null);
        }
        return (ClickCat) ipChange.ipc$dispatch("1475618820", new Object[]{this});
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1601830543")) {
            return (String) ipChange.ipc$dispatch("1601830543", new Object[]{this});
        }
        UTPageHitHelper instance = UTPageHitHelper.getInstance();
        k21.h(instance, "UTPageHitHelper.getInstance()");
        String currentPageName = instance.getCurrentPageName();
        if (currentPageName == null || currentPageName.length() == 0) {
            z = true;
        }
        if (!z) {
            return currentPageName;
        }
        Object obj = e;
        if (!(obj instanceof IUTPageOperation)) {
            return currentPageName;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.pictures.ut.IUTPageOperation");
        return ((IUTPageOperation) obj).getUTPageName();
    }

    @Nullable
    public final String f() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1905928542")) {
            return (String) ipChange.ipc$dispatch("-1905928542", new Object[]{this});
        }
        String e2 = e();
        uq2 uq2 = uq2.INSTANCE;
        String h = uq2.h(e2);
        if (h == null || h.length() == 0) {
            h = f;
        }
        if (!(h == null || h.length() == 0)) {
            e2 = h;
        }
        if (e2 == null || e2.length() == 0) {
            z = true;
        }
        if (z) {
            return uq2.c();
        }
        return uq2.f() + '.' + e2;
    }

    @NotNull
    public final cg0 g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "769245380")) {
            return new cg0();
        }
        return (cg0) ipChange.ipc$dispatch("769245380", new Object[]{this});
    }

    @NotNull
    public final ExposureDog h(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361682202")) {
            return (ExposureDog) ipChange.ipc$dispatch("-1361682202", new Object[]{this, view});
        }
        k21.i(view, "view");
        ExposureDog exposureDog = o().get(Integer.valueOf(view.hashCode()));
        if (exposureDog == null) {
            ExposureDog exposureDog2 = new ExposureDog(view);
            o().put(Integer.valueOf(view.hashCode()), exposureDog2);
            return exposureDog2;
        }
        exposureDog.j(null);
        exposureDog.q(null);
        return exposureDog;
    }

    @Nullable
    public final String i(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "733190009")) {
            return (String) ipChange.ipc$dispatch("733190009", new Object[]{this, str});
        }
        if (!(str == null || str.length() == 0)) {
            z = false;
        }
        if (z || (o.L(str, "Page_", false, 2, null)) || (o.L(str, "page_", false, 2, null))) {
            return e();
        }
        return k21.r(uq2.INSTANCE.e(), str);
    }

    @NotNull
    public final String j(@Nullable String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189039317")) {
            return (String) ipChange.ipc$dispatch("1189039317", new Object[]{this, str});
        } else if (str == null) {
            return "default";
        } else {
            try {
                List list = StringsKt__StringsKt.z0(str, new String[]{"."}, false, 0, 6, null);
                String str3 = "";
                if (list.size() >= 4) {
                    str3 = (String) list.get(2);
                    str2 = (String) list.get(3);
                } else if (list.size() == 3) {
                    str3 = (String) list.get(1);
                    str2 = (String) list.get(2);
                } else if (list.size() == 2) {
                    str3 = (String) list.get(0);
                    str2 = (String) list.get(1);
                } else if (list.size() == 1) {
                    str3 = (String) list.get(0);
                    str2 = str3;
                } else {
                    str2 = str3;
                }
                if (!(str3 == null || str3.length() == 0)) {
                    String substring = str3.substring(str3.length() - 1);
                    k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                    if (s(substring) && (StringsKt__StringsKt.Q(str3, JSMethod.NOT_SET, false, 2, null))) {
                        str3 = str3.substring(0, StringsKt__StringsKt.l0(str3, JSMethod.NOT_SET, 0, false, 6, null));
                        k21.h(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                }
                if (!(str2 == null || str2.length() == 0)) {
                    String substring2 = str2.substring(str2.length() - 1);
                    k21.h(substring2, "(this as java.lang.String).substring(startIndex)");
                    if (s(substring2) && (StringsKt__StringsKt.Q(str2, JSMethod.NOT_SET, false, 2, null))) {
                        str2 = str2.substring(0, StringsKt__StringsKt.l0(str2, JSMethod.NOT_SET, 0, false, 6, null));
                        k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                }
                return str3 + JSMethod.NOT_SET + str2;
            } catch (Exception e2) {
                ot2.c(e2.toString());
                return "default";
            }
        }
    }

    @NotNull
    public final String k(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687697508")) {
            return (String) ipChange.ipc$dispatch("1687697508", new Object[]{this, str, str2});
        }
        String i = i(str);
        if (i == null) {
            i = "";
        }
        return i + JSMethod.NOT_SET + j(str2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = java.lang.String.valueOf(r5.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r0 = java.lang.String.valueOf(r5.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        java.lang.String.valueOf(r5.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0042 */
    @NotNull
    public final String l(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823907999")) {
            return (String) ipChange.ipc$dispatch("1823907999", new Object[]{this, view});
        }
        String str = null;
        if (view == null || view.getId() == -1) {
            str = String.valueOf(View.generateViewId());
        } else {
            str = view.getResources().getResourceEntryName(view.getId());
            if (TextUtils.isEmpty(str)) {
                str = String.valueOf(view.getId());
            }
        }
        return str != null ? str : "general";
    }

    @Nullable
    public final Map<String, String> n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-184391818")) {
            return UTPageHitHelper.getInstance().getPageProperties(e);
        }
        return (Map) ipChange.ipc$dispatch("-184391818", new Object[]{this});
    }

    @Nullable
    public final String p(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1078604805")) {
            return uq2.INSTANCE.h(str);
        }
        return (String) ipChange.ipc$dispatch("-1078604805", new Object[]{this, str});
    }

    @Nullable
    public final String q(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260162711")) {
            return (String) ipChange.ipc$dispatch("-260162711", new Object[]{this, view});
        } else if (view == null) {
            return null;
        } else {
            Object tag = view.getTag(oq2.a());
            if (tag instanceof String) {
                return (String) tag;
            }
            return null;
        }
    }

    @Nullable
    public final id2 r() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "402634912")) {
            return a;
        }
        return (id2) ipChange.ipc$dispatch("402634912", new Object[]{this});
    }

    public final boolean s(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200713009")) {
            return ((Boolean) ipChange.ipc$dispatch("-1200713009", new Object[]{this, str})).booleanValue();
        }
        k21.i(str, "str");
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean t(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428745888")) {
            return ((Boolean) ipChange.ipc$dispatch("-1428745888", new Object[]{this, view})).booleanValue();
        }
        k21.i(view, "view");
        return D(view) >= ExposureConfigMgr.dimThreshold;
    }

    public final void u(@Nullable Object obj, @Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-756605368")) {
            ipChange.ipc$dispatch("-756605368", new Object[]{this, obj, str});
        } else if (obj != null) {
            String z2 = z(obj, str);
            ot2.a("pageAppear:" + obj + ",name=" + z2);
            if (!(z2 == null || z2.length() == 0)) {
                z = false;
            }
            if (!z) {
                UTAnalytics instance = UTAnalytics.getInstance();
                k21.h(instance, "UTAnalytics.getInstance()");
                instance.getDefaultTracker().pageAppear(obj, z2);
                while (true) {
                    List<ExposureDog.ExposureObserver> list = g;
                    if (list.size() > 0) {
                        ExposureDog.ExposureObserver remove = list.remove(0);
                        if (remove != null) {
                            remove.run();
                        }
                    } else {
                        e = obj;
                        return;
                    }
                }
            }
        }
    }

    public final void v(@Nullable Object obj, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372063289")) {
            ipChange.ipc$dispatch("-1372063289", new Object[]{this, obj, str});
        } else if (obj != null) {
            String z = z(obj, str);
            UTAnalytics instance = UTAnalytics.getInstance();
            k21.h(instance, "UTAnalytics.getInstance()");
            instance.getDefaultTracker().pageAppearDonotSkip(obj, z);
            while (true) {
                List<ExposureDog.ExposureObserver> list = g;
                if (list.size() > 0) {
                    ExposureDog.ExposureObserver remove = list.remove(0);
                    if (remove != null) {
                        remove.run();
                    }
                } else {
                    e = obj;
                    return;
                }
            }
        }
    }

    public final void w(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "578019980")) {
            ipChange.ipc$dispatch("578019980", new Object[]{this, obj});
        } else if (obj != null) {
            ot2.a("pageDisAppear:" + obj);
            UTAnalytics instance = UTAnalytics.getInstance();
            k21.h(instance, "UTAnalytics.getInstance()");
            instance.getDefaultTracker().pageDisAppear(obj);
            f = null;
            while (true) {
                List<ExposureDog.ExposureObserver> list = g;
                if (list.size() > 0) {
                    ExposureDog.ExposureObserver remove = list.remove(0);
                    if (remove != null) {
                        remove.run();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void x(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565755604")) {
            ipChange.ipc$dispatch("565755604", new Object[]{this, obj});
            return;
        }
        UTAnalytics instance = UTAnalytics.getInstance();
        k21.h(instance, "UTAnalytics.getInstance()");
        instance.getDefaultTracker().skipPage(obj);
    }

    public final void y(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078132769")) {
            ipChange.ipc$dispatch("2078132769", new Object[]{this, activity});
        } else if (activity != null) {
            UTTeamWork.getInstance().startExpoTrack(activity);
        }
    }
}
