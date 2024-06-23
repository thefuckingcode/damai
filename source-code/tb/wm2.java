package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.util.TComparator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wm2 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final wm2 INSTANCE = new wm2();

    private wm2() {
    }

    @Nullable
    public final ArrayList<BottomAction> a(@Nullable String str) {
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "17929716")) {
            return (ArrayList) ipChange.ipc$dispatch("17929716", new Object[]{this, str});
        }
        if (str != null) {
            try {
                List<String> z0 = g.z0(str, new String[]{","}, false, 0, 6, null);
                if (z0 != null) {
                    if (!z0.isEmpty()) {
                        z = false;
                    }
                }
                if (!z) {
                    ArrayList<BottomAction> arrayList = new ArrayList<>();
                    for (String str3 : z0) {
                        if (g.L(str3, "tel:", false, 2, null)) {
                            str2 = str3.substring(4, str3.length());
                            k21.h(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                        } else {
                            str2 = str3;
                        }
                        arrayList.add(new BottomAction(str2, str3));
                    }
                    return arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @NotNull
    public final DisplayMetrics b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713107041")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-1713107041", new Object[]{this, context});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        k21.h(displayMetrics, "context.resources.displayMetrics");
        return displayMetrics;
    }

    @Nullable
    public final Object c(@Nullable List<?> list, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122215718")) {
            return ipChange.ipc$dispatch("-122215718", new Object[]{this, list, Integer.valueOf(i)});
        } else if (list == null || list.size() <= i || i < 0) {
            return null;
        } else {
            return list.get(i);
        }
    }

    public final int d(@Nullable List<?> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1589233966")) {
            return ((Integer) ipChange.ipc$dispatch("-1589233966", new Object[]{this, list})).intValue();
        } else if (list != null) {
            return list.size();
        } else {
            return 0;
        }
    }

    public final boolean e(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1378311175")) {
            return ((Boolean) ipChange.ipc$dispatch("1378311175", new Object[]{this, context})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        String[] strArr = kp1.a;
        k21.h(strArr, "LOCATION");
        return !jp1.e(strArr, context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.alibaba.pictures.bricks.util.TComparator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> boolean f(@Nullable List<? extends T> list, @Nullable List<? extends T> list2, @NotNull TComparator<T> tComparator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231324272")) {
            return ((Boolean) ipChange.ipc$dispatch("-1231324272", new Object[]{this, list, list2, tComparator})).booleanValue();
        }
        k21.i(tComparator, "tCompare");
        int d = d(list);
        if (d != d(list2)) {
            return false;
        }
        if (d > 0) {
            for (int i = 0; i < d; i++) {
                Object obj = null;
                Object obj2 = list != null ? list.get(i) : null;
                if (list2 != null) {
                    obj = list2.get(i);
                }
                if (!tComparator.same(obj2, obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean g(@NotNull Intent intent, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690953439")) {
            return ((Boolean) ipChange.ipc$dispatch("-690953439", new Object[]{this, intent, context})).booleanValue();
        }
        k21.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return context.getPackageManager().resolveActivity(intent, 65536) != null;
    }

    public final void h(@Nullable Activity activity, @Nullable String str) {
        Uri uri;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130251895")) {
            ipChange.ipc$dispatch("-130251895", new Object[]{this, activity, str});
        } else if (activity != null && !activity.isFinishing() && str != null && !g.y(str)) {
            try {
                if (g.L(str, "tel", false, 2, null)) {
                    uri = Uri.parse(str);
                } else {
                    uri = Uri.parse("tel:" + str);
                }
                Intent intent = new Intent("android.intent.action.DIAL", uri);
                wm2 wm2 = INSTANCE;
                if (wm2.g(intent, activity)) {
                    activity.startActivity(intent);
                } else {
                    wm2.l(activity, "无法拨号，请手动拨打");
                }
            } catch (Exception e) {
                e.printStackTrace();
                INSTANCE.l(activity, "无法拨号，请手动拨打");
            }
        }
    }

    @Nullable
    public final JSONObject i(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746960177")) {
            return (JSONObject) ipChange.ipc$dispatch("-746960177", new Object[]{this, str});
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return JSON.parseObject(str);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final <T> T j(@Nullable JSON json, @Nullable Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920751463")) {
            return (T) ipChange.ipc$dispatch("-1920751463", new Object[]{this, json, cls});
        }
        try {
            return (T) JSON.toJavaObject(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final String k(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763889777")) {
            return (String) ipChange.ipc$dispatch("763889777", new Object[]{this, obj});
        } else if (obj == null) {
            return null;
        } else {
            try {
                return JSON.toJSONString(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public final void l(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1827086890")) {
            ipChange.ipc$dispatch("-1827086890", new Object[]{this, context, str});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "text");
        Toast.makeText(context, str, 0).show();
    }
}
