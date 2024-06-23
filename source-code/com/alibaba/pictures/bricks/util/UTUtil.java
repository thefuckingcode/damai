package com.alibaba.pictures.bricks.util;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public final class UTUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final UTUtil INSTANCE = new UTUtil();
    @NotNull
    private static final String a = "a2o4t.";
    @NotNull
    private static ArrayList<UTExposureBean> b = new ArrayList<>();
    @NotNull
    private static HashMap<String, String> c = new HashMap<>();
    @NotNull
    private static UTExposureBean d = new UTExposureBean();

    /* compiled from: Taobao */
    public static final class UTExposureBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 1;
        @Nullable
        private String area;
        private long duration;
        @Nullable
        private HashMap<String, String> exargs;
        @Nullable
        private String spm;
        @Nullable
        private String viewid;

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }
        }

        @Nullable
        public final String getArea() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "879730014")) {
                return this.area;
            }
            return (String) ipChange.ipc$dispatch("879730014", new Object[]{this});
        }

        public final long getDuration() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1502105585")) {
                return this.duration;
            }
            return ((Long) ipChange.ipc$dispatch("-1502105585", new Object[]{this})).longValue();
        }

        @Nullable
        public final HashMap<String, String> getExargs() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1808195006")) {
                return this.exargs;
            }
            return (HashMap) ipChange.ipc$dispatch("-1808195006", new Object[]{this});
        }

        @Nullable
        public final String getSpm() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "47975221")) {
                return this.spm;
            }
            return (String) ipChange.ipc$dispatch("47975221", new Object[]{this});
        }

        @Nullable
        public final String getViewid() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2005352879")) {
                return this.viewid;
            }
            return (String) ipChange.ipc$dispatch("-2005352879", new Object[]{this});
        }

        public final void setArea(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1209069888")) {
                ipChange.ipc$dispatch("1209069888", new Object[]{this, str});
                return;
            }
            this.area = str;
        }

        public final void setDuration(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1590150421")) {
                ipChange.ipc$dispatch("1590150421", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.duration = j;
        }

        public final void setExargs(@Nullable HashMap<String, String> hashMap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1110549440")) {
                ipChange.ipc$dispatch("1110549440", new Object[]{this, hashMap});
                return;
            }
            this.exargs = hashMap;
        }

        public final void setSpm(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389187359")) {
                ipChange.ipc$dispatch("-1389187359", new Object[]{this, str});
                return;
            }
            this.spm = str;
        }

        public final void setViewid(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "863478189")) {
                ipChange.ipc$dispatch("863478189", new Object[]{this, str});
                return;
            }
            this.viewid = str;
        }
    }

    private UTUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006d  */
    private final String a(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6 = str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "571397317")) {
            return (String) ipChange.ipc$dispatch("571397317", new Object[]{this, str, str6, str3});
        }
        if (!TextUtils.isEmpty(str2)) {
            String substring = str6.substring(str2.length() - 1);
            k21.h(substring, "this as java.lang.String).substring(startIndex)");
            if (b(substring) && (StringsKt__StringsKt.Q(str6, JSMethod.NOT_SET, false, 2, null))) {
                str4 = "this as java.lang.String).substring(startIndex)";
                String substring2 = str6.substring(0, StringsKt__StringsKt.l0(str2, JSMethod.NOT_SET, 0, false, 6, null));
                k21.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                str6 = substring2;
                if (!TextUtils.isEmpty(str3)) {
                    String substring3 = str3.substring(str3.length() - 1);
                    k21.h(substring3, str4);
                    if (b(substring3) && (StringsKt__StringsKt.Q(str3, JSMethod.NOT_SET, false, 2, null))) {
                        str5 = str3.substring(0, StringsKt__StringsKt.l0(str3, JSMethod.NOT_SET, 0, false, 6, null));
                        k21.h(str5, "this as java.lang.String…ing(startIndex, endIndex)");
                        return "page_" + str + '_' + str6 + '_' + str5;
                    }
                }
                str5 = str3;
                return "page_" + str + '_' + str6 + '_' + str5;
            }
        }
        str4 = "this as java.lang.String).substring(startIndex)";
        if (!TextUtils.isEmpty(str3)) {
        }
        str5 = str3;
        return "page_" + str + '_' + str6 + '_' + str5;
    }

    private final boolean b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078280178")) {
            return ((Boolean) ipChange.ipc$dispatch("-1078280178", new Object[]{this, str})).booleanValue();
        }
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @Nullable HashMap<String, String> hashMap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216308689")) {
            ipChange.ipc$dispatch("-1216308689", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), hashMap, Integer.valueOf(i)});
            return;
        }
        k21.i(str, "widgetName");
        k21.i(str2, "moduleName");
        k21.i(str3, "pageName");
        k21.i(str4, Constants.ACTION_PARAMS_AREA);
        String str5 = "page_" + str3;
        String a2 = a(str3, str2, str);
        String str6 = (a + str3 + '.' + str2) + '.' + str;
        b.clear();
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        UTExposureBean uTExposureBean = new UTExposureBean();
        d = uTExposureBean;
        uTExposureBean.setArea(str4);
        d.setDuration(j);
        d.setExargs(hashMap2);
        d.setViewid(str6);
        d.setSpm(str6);
        b.add(d);
        String jSONString = JSON.toJSONString(b);
        HashMap<String, String> hashMap3 = c;
        k21.h(jSONString, "expdataStr");
        hashMap3.put("expdata", jSONString);
        try {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str5, i, a2, null, null, c).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
