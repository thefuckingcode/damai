package com.uc.webview.export.internal.uc.wa;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.c;
import com.uc.webview.export.internal.utility.e;
import com.uc.webview.export.internal.utility.f;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.n;
import com.uc.webview.export.internal.utility.p;
import com.xiaomi.mipush.sdk.Constants;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import mtopsdk.network.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a {
    public static boolean a = true;
    public static boolean b = false;
    public static int c = 0;
    public static int e = 20480;
    public static int f = 5242880;
    public static int g = (20480 + 1024);
    private static a j;
    public List<b> d;
    public SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Object i = new Object();
    private Context k;
    private f l = null;
    private Map<String, C0245a> m;
    private SimpleDateFormat n = new SimpleDateFormat("yyyyMMdd");
    private int o = 0;
    private String p = null;
    private Random q = null;

    /* compiled from: Taobao */
    public class b {
        String a;
        Map<String, String> b;

        public b(String str, Map<String, String> map) {
            this.a = str;
            this.b = map;
        }

        public final String toString() {
            return "Key: " + this.a + " Data: " + this.b.toString();
        }
    }

    private a() {
    }

    public static boolean c() {
        return com.uc.webview.export.internal.cd.a.c(UCCore.EVENT_STAT).booleanValue();
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        if (c()) {
            try {
                if (!b(this.k)) {
                    Log.d("SDKWaStat", "saveData interrupted by sampling");
                    return;
                }
                if (b) {
                    Log.d("SDKWaStat", "saveData");
                }
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                synchronized (this.i) {
                    if (SDKFactory.b() && !b(this.m)) {
                        hashMap.putAll(this.m);
                        this.m.clear();
                    }
                    if (!a(this.d)) {
                        arrayList.addAll(this.d);
                        this.d.clear();
                    }
                }
                a(hashMap, arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public String g() {
        String str = this.k.getApplicationContext().getApplicationInfo().dataDir + "/ucwa";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static String h() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (c.a(str) || str.equals("0")) {
            return "wa_upload_new.wa";
        }
        return "wa_upload_new.wa_" + str;
    }

    /* access modifiers changed from: private */
    public static String i() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (c.a(str) || str.equals("0")) {
            return "1";
        }
        return "1_" + str;
    }

    private Object[] j() {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream3;
        BufferedReader bufferedReader2;
        Exception e2;
        String str;
        String str2;
        String str3;
        int i2;
        String str4 = "@0";
        File file = new File(g(), h());
        String str5 = "SDKWaStat";
        if (b) {
            Log.d(str5, "getPVFromFile:" + file + " exists:" + file.exists());
        }
        if (!file.exists()) {
            return null;
        }
        file.length();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            fileInputStream2 = new FileInputStream(file);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2), 1024);
                char c2 = 0;
                int i3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (b) {
                            Log.d(str5, readLine);
                        }
                        if (!c.a(readLine)) {
                            if (readLine.length() + i3 <= e) {
                                i3 += readLine.length();
                                String trim = readLine.trim();
                                if (!trim.startsWith(str4)) {
                                    if (trim.startsWith("@1")) {
                                    }
                                    str2 = str4;
                                    str = str5;
                                    str4 = str2;
                                    str5 = str;
                                    c2 = 0;
                                }
                                int indexOf = trim.indexOf("@k@");
                                int indexOf2 = trim.indexOf("@d@");
                                if (indexOf >= 0 && indexOf2 >= 0) {
                                    String substring = trim.substring(indexOf + 3, indexOf2);
                                    String[] split = trim.substring(indexOf2 + 3).split("`");
                                    if (trim.startsWith(str4)) {
                                        String[] split2 = substring.split(Constants.WAVE_SEPARATOR);
                                        if (split2.length == 2 && split2[c2].length() == 8 && split2[1].length() <= 2) {
                                            C0245a aVar = (C0245a) hashMap.get(substring);
                                            if (aVar == null) {
                                                if (hashMap.size() == 8) {
                                                    if (arrayList.size() == 10) {
                                                        break;
                                                    }
                                                } else {
                                                    aVar = new C0245a(this, (byte) 0);
                                                    hashMap.put(substring, aVar);
                                                }
                                            }
                                            int length = split.length;
                                            int i4 = 0;
                                            while (i4 < length) {
                                                String[] split3 = split[i4].split("=");
                                                if (split3.length != 2 || split3[1].length() <= 2) {
                                                    str3 = str5;
                                                    i2 = length;
                                                } else {
                                                    String substring2 = split3[1].substring(2);
                                                    str3 = str5;
                                                    if (split3[1].startsWith("#0")) {
                                                        i2 = length;
                                                        Integer num = aVar.a.get(split3[0]);
                                                        if (num == null) {
                                                            aVar.a.put(split3[0], Integer.valueOf(Integer.parseInt(substring2)));
                                                        } else {
                                                            aVar.a.put(split3[0], Integer.valueOf(Integer.parseInt(substring2) + num.intValue()));
                                                        }
                                                    } else {
                                                        i2 = length;
                                                        if (split3[1].startsWith("#1")) {
                                                            aVar.b.put(split3[0], substring2);
                                                        }
                                                    }
                                                }
                                                i4++;
                                                length = i2;
                                                str4 = str4;
                                                str5 = str3;
                                            }
                                            str2 = str4;
                                            str = str5;
                                            aVar.b.put("core_t", split2[1]);
                                        }
                                    } else {
                                        str2 = str4;
                                        str = str5;
                                        if (arrayList.size() != 10) {
                                            HashMap hashMap2 = new HashMap(split.length);
                                            for (String str6 : split) {
                                                String[] split4 = str6.split("=");
                                                if (split4.length == 2) {
                                                    hashMap2.put(split4[0], split4[1].substring(2));
                                                }
                                            }
                                            hashMap2.put("ev_ac", substring);
                                            arrayList.add(new b(substring, hashMap2));
                                        }
                                    }
                                    str4 = str2;
                                    str5 = str;
                                    c2 = 0;
                                }
                                str2 = str4;
                                str = str5;
                                str4 = str2;
                                str5 = str;
                                c2 = 0;
                            } else if (b) {
                                Log.d(str5, "upload data size(" + (i3 + readLine.length()) + ") more then " + e);
                            }
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        fileInputStream3 = fileInputStream2;
                        try {
                            e2.printStackTrace();
                            UCCyclone.close(bufferedReader2);
                            UCCyclone.close(fileInputStream2);
                            UCCyclone.close(fileInputStream3);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            fileInputStream = fileInputStream3;
                            UCCyclone.close(bufferedReader);
                            UCCyclone.close(fileInputStream2);
                            UCCyclone.close(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        fileInputStream = fileInputStream2;
                        UCCyclone.close(bufferedReader);
                        UCCyclone.close(fileInputStream2);
                        UCCyclone.close(fileInputStream);
                        throw th;
                    }
                }
                if (hashMap.size() > 0 || arrayList.size() > 0) {
                    Object[] objArr = {hashMap, arrayList};
                    UCCyclone.close(bufferedReader2);
                    UCCyclone.close(fileInputStream2);
                    UCCyclone.close(fileInputStream2);
                    return objArr;
                }
                UCCyclone.close(bufferedReader2);
                UCCyclone.close(fileInputStream2);
                UCCyclone.close(fileInputStream2);
                return null;
            } catch (Exception e4) {
                e2 = e4;
                fileInputStream3 = fileInputStream2;
                bufferedReader2 = null;
                e2.printStackTrace();
                UCCyclone.close(bufferedReader2);
                UCCyclone.close(fileInputStream2);
                UCCyclone.close(fileInputStream3);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = fileInputStream2;
                bufferedReader = null;
                UCCyclone.close(bufferedReader);
                UCCyclone.close(fileInputStream2);
                UCCyclone.close(fileInputStream);
                throw th;
            }
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader2 = null;
            fileInputStream3 = null;
            fileInputStream2 = null;
            e2.printStackTrace();
            UCCyclone.close(bufferedReader2);
            UCCyclone.close(fileInputStream2);
            UCCyclone.close(fileInputStream3);
            return null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            fileInputStream2 = null;
            fileInputStream = null;
            UCCyclone.close(bufferedReader);
            UCCyclone.close(fileInputStream2);
            UCCyclone.close(fileInputStream);
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r2v39, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private List<String[]> k() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new String[]{"lt", "ev"});
        arrayList.add(new String[]{IRequestConst.CT, "corepv"});
        arrayList.add(new String[]{"pkg", this.k.getPackageName()});
        String[] strArr = new String[2];
        strArr[0] = "sdk_pm";
        String model = Build.getMODEL();
        String str23 = "unknown";
        if (c.a(model)) {
            str = str23;
        } else {
            str = model.trim().replaceAll("[`|=]", "");
        }
        strArr[1] = str;
        arrayList.add(strArr);
        String[] strArr2 = new String[2];
        strArr2[0] = "sdk_f";
        StringBuilder sb = new StringBuilder();
        String str24 = "1";
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)).booleanValue() || com.uc.webview.export.internal.update.a.b(this.k) == null) {
            str2 = "0";
        } else {
            str2 = str24;
        }
        sb.append(str2);
        if (SDKFactory.c((Long) 1L).booleanValue()) {
            str3 = str24;
        } else {
            str3 = "0";
        }
        sb.append(str3);
        if (i.a().b(UCCore.OPTION_MULTI_CORE_TYPE)) {
            str4 = str24;
        } else {
            str4 = "0";
        }
        sb.append(str4);
        if (SDKFactory.c((Long) 2L).booleanValue()) {
            str5 = str24;
        } else {
            str5 = "0";
        }
        sb.append(str5);
        if (SDKFactory.c((Long) 4L).booleanValue()) {
            str6 = str24;
        } else {
            str6 = "0";
        }
        sb.append(str6);
        if (SDKFactory.c((Long) 8L).booleanValue()) {
            str7 = str24;
        } else {
            str7 = "0";
        }
        sb.append(str7);
        if (SDKFactory.c((Long) 16L).booleanValue()) {
            str8 = str24;
        } else {
            str8 = "0";
        }
        sb.append(str8);
        if (SDKFactory.c((Long) 32L).booleanValue()) {
            str9 = str24;
        } else {
            str9 = "0";
        }
        sb.append(str9);
        if (SDKFactory.c((Long) 64L).booleanValue()) {
            str10 = str24;
        } else {
            str10 = "0";
        }
        sb.append(str10);
        if (SDKFactory.c((Long) 128L).booleanValue()) {
            str11 = str24;
        } else {
            str11 = "0";
        }
        sb.append(str11);
        if (SDKFactory.c((Long) 256L).booleanValue()) {
            str12 = str24;
        } else {
            str12 = "0";
        }
        sb.append(str12);
        if (SDKFactory.c((Long) 512L).booleanValue()) {
            str13 = str24;
        } else {
            str13 = "0";
        }
        sb.append(str13);
        if (SDKFactory.c((Long) 1024L).booleanValue()) {
            str14 = str24;
        } else {
            str14 = "0";
        }
        sb.append(str14);
        if (SDKFactory.c((Long) 2048L).booleanValue()) {
            str15 = str24;
        } else {
            str15 = "0";
        }
        sb.append(str15);
        if (SDKFactory.c((Long) 4096L).booleanValue()) {
            str16 = str24;
        } else {
            str16 = "0";
        }
        sb.append(str16);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI)).booleanValue()) {
            str17 = str24;
        } else {
            str17 = "0";
        }
        sb.append(str17);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE)).booleanValue()) {
            str18 = str24;
        } else {
            str18 = "0";
        }
        sb.append(str18);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)).booleanValue()) {
            str19 = str24;
        } else {
            str19 = "0";
        }
        sb.append(str19);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)).booleanValue()) {
            str20 = str24;
        } else {
            str20 = "0";
        }
        sb.append(str20);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_URI)).booleanValue()) {
            str21 = str24;
        } else {
            str21 = "0";
        }
        sb.append(str21);
        if (SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE)).booleanValue()) {
            str22 = str24;
        } else {
            str22 = "0";
        }
        sb.append(str22);
        strArr2[1] = sb.toString();
        arrayList.add(strArr2);
        String[] strArr3 = new String[2];
        strArr3[0] = "sdk_bd";
        String brand = Build.getBRAND();
        if (!c.a(brand)) {
            str23 = brand.trim().replaceAll("[`|=]", "");
        }
        strArr3[1] = str23;
        arrayList.add(strArr3);
        arrayList.add(new String[]{"sdk_osv", Build.VERSION.getRELEASE()});
        arrayList.add(new String[]{"sdk_prd", com.uc.webview.export.Build.SDK_PRD});
        arrayList.add(new String[]{"sdk_pfid", com.uc.webview.export.Build.SDK_PROFILE_ID});
        arrayList.add(new String[]{"sdk_cos", p.e()});
        arrayList.add(new String[]{"pro_sf", (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION)});
        arrayList.add(new String[]{"uuid", a(this.k.getSharedPreferences("UC_WA_STAT", 4))});
        String str25 = (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING);
        if (!c.a(str25)) {
            arrayList.add(new String[]{"ab_sn", str25});
        }
        String str26 = (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM);
        if (!c.a(str26)) {
            arrayList.add(new String[]{"ab_ve", str26});
        }
        if (!c.a(com.uc.webview.export.Build.CORE_VERSION)) {
            arrayList.add(new String[]{"sdk_sdk_cv", com.uc.webview.export.Build.CORE_VERSION.trim()});
        }
        if (!c.a(com.uc.webview.export.Build.UCM_VERSION)) {
            arrayList.add(new String[]{"sdk_ucm_cv", com.uc.webview.export.Build.UCM_VERSION.trim()});
        }
        Long l2 = (Long) UCCore.getGlobalOption(UCCore.STARTUP_ELAPSE_BEETWEEN_UC_INIT_AND_APP);
        if (l2 != null) {
            arrayList.add(new String[]{"st_el", Long.toString(l2.longValue())});
        }
        String[] strArr4 = new String[2];
        strArr4[0] = IWaStat.VIDEO_AC;
        if (!SDKFactory.c((Long) 1048576L).booleanValue()) {
            str24 = "0";
        }
        strArr4[1] = str24;
        arrayList.add(strArr4);
        String a2 = p.b.a(this.k);
        if (!c.a(a2)) {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, a2});
        } else {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, "null"});
        }
        arrayList.add(new String[]{"data_dir", this.k.getApplicationInfo().dataDir});
        File file = (File) ReflectionUtil.invokeNoThrow(this.k, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"});
        if (file != null) {
            arrayList.add(new String[]{"sp_dir", file.getAbsolutePath()});
        }
        arrayList.add(new String[]{"thrct", Integer.toString(n.b())});
        Integer num = (Integer) UCCore.getGlobalOption(UCCore.OPTION_APP_STARTUP_OPPORTUNITY);
        if (num != null) {
            arrayList.add(new String[]{"ini_op", Integer.toString(num.intValue())});
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p.f() ? "thick" : "thin");
        String str27 = (String) i.a().a(UCCore.OPTION_BUSINESS_INIT_TYPE);
        if (!p.a(str27)) {
            sb2.append('_');
            sb2.append(str27);
        }
        Boolean bool = (Boolean) i.a().a("gk_dec_exist");
        if (bool != null) {
            sb2.append('_');
            sb2.append(bool.booleanValue() ? "dec_exist" : "dec_not");
        }
        Boolean bool2 = (Boolean) i.a().a("gk_upd_exist");
        if (bool2 != null) {
            sb2.append('_');
            sb2.append(bool2.booleanValue() ? "upd_exist" : "upd_not");
        }
        Boolean bool3 = (Boolean) i.a().a("gk_quick_path");
        if (bool3 != null) {
            sb2.append('_');
            sb2.append(bool3.booleanValue() ? "qpath" : "qpath_not");
        }
        Boolean bool4 = (Boolean) i.a().a("gk_quick_init");
        if (bool4 != null) {
            sb2.append('_');
            sb2.append(bool4.booleanValue() ? "quick" : "quick_not");
        }
        if (b) {
            Log.i("SDKWaStat", "getSetupType:" + sb2.toString());
        }
        String sb3 = sb2.toString();
        if (!p.a(sb3)) {
            arrayList.add(new String[]{"setup_tp", sb3});
        }
        ?? b2 = i.a().b("gk_init_pre");
        int i2 = b2;
        if (i.a().b("gk_preload_io")) {
            i2 = b2 + 2;
        }
        int i3 = i2;
        if (i.a().b("gk_preload_so")) {
            i3 = i2 + 4;
        }
        int i4 = i3;
        if (i.a().b("gk_preload_cl")) {
            i4 = i3 + 8;
        }
        if (b) {
            Log.i("SDKWaStat", "getInitPreprocesses:" + i4);
        }
        String num2 = Integer.toString(i4 == 1 ? 1 : 0);
        if (!p.a(num2)) {
            arrayList.add(new String[]{"ini_pre", num2});
        }
        arrayList.add(new String[]{"spr", String.valueOf(this.o)});
        return arrayList;
    }

    /* access modifiers changed from: private */
    public String l() {
        Object[] j2 = j();
        if (j2 == null) {
            return null;
        }
        Map map = (Map) j2[0];
        List<b> list = (List) j2[1];
        try {
            JSONObject jSONObject = new JSONObject();
            for (String[] strArr : k()) {
                jSONObject.put(strArr[0], strArr[1]);
            }
            for (Map.Entry<String, Integer> entry : SDKFactory.p.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().intValue());
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry2 : map.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Integer> entry3 : ((C0245a) entry2.getValue()).a.entrySet()) {
                    jSONObject2.put(entry3.getKey(), String.valueOf(entry3.getValue()));
                }
                for (Map.Entry<String, String> entry4 : ((C0245a) entry2.getValue()).b.entrySet()) {
                    jSONObject2.put(entry4.getKey(), entry4.getValue());
                }
                jSONArray.put(jSONObject2);
            }
            for (b bVar : list) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, String> entry5 : bVar.b.entrySet()) {
                    jSONObject3.put(entry5.getKey(), entry5.getValue());
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("items", jSONArray);
            jSONObject.put("stat_size", String.valueOf(jSONObject.toString().length()));
            return jSONObject.toString();
        } catch (Exception e2) {
            Log.e("SDKWaStat", "getJsonUploadData", e2);
            return null;
        }
    }

    private static String c(Map<String, String> map) {
        String str = map.get(U4WPKAdapter.KEY_TM);
        if (str == null || str.length() <= 10) {
            return null;
        }
        return str.substring(0, 10);
    }

    public final f b() {
        if (this.l == null) {
            this.l = new f("U4SDKWaStat");
        }
        return this.l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.uc.webview.export.internal.uc.wa.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0245a {
        Map<String, Integer> a;
        Map<String, String> b;

        private C0245a() {
            this.a = new HashMap();
            this.b = new HashMap();
        }

        public final String toString() {
            return "Int Data: " + this.a.toString() + " String Data: " + this.b.toString();
        }

        /* synthetic */ C0245a(a aVar, byte b2) {
            this();
        }
    }

    public static a a() {
        Context context;
        if (j == null && (context = SDKFactory.e) != null) {
            a(context);
        }
        return j;
    }

    private static boolean b(Map map) {
        return map == null || map.size() == 0;
    }

    static /* synthetic */ void c(a aVar) {
        if (c()) {
            aVar.b().a(new e(aVar));
        }
    }

    private static String b(Map<String, C0245a> map, List<b> list) {
        String[] strArr = {HiAnalyticsConstant.KeyAndValue.NUMBER_01, "10", "20"};
        String str = null;
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            for (Map.Entry<String, C0245a> entry : map.entrySet()) {
                String c2 = c(entry.getValue().b);
                if (c2 != null && c2.endsWith(str2)) {
                    if (str == null || c2.compareTo(str) > 0) {
                        str = c2;
                    }
                }
            }
            for (b bVar : list) {
                String c3 = c(bVar.b);
                if (c3 != null && c3.endsWith(str2)) {
                    if (str == null || c3.compareTo(str) > 0) {
                        str = c3;
                    }
                }
            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (c()) {
                if (j == null) {
                    j = new a();
                }
                j.k = context.getApplicationContext();
            }
        }
    }

    public final void a(String str) {
        if (c()) {
            a(str, 0, 0, 1, null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ee A[Catch:{ all -> 0x00fd }] */
    public static boolean b(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        OutputStream outputStream;
        Throwable th2;
        try {
            if (!SDKFactory.f && Boolean.parseBoolean(UCCore.getParam(UCCore.CD_ENABLE_TRAFFIC_STAT)) && Build.VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40962);
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(p.c());
            httpURLConnection.setReadTimeout(p.d());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(bArr.length));
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                if (httpURLConnection.getResponseCode() != 200) {
                    if (b) {
                        Log.e("SDKWaStat", "response == null", new Throwable());
                    }
                    UCCyclone.close(outputStream);
                    UCCyclone.close(byteArrayOutputStream2);
                    UCCyclone.close(byteArrayOutputStream2);
                    return false;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(inputStream.available());
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream3.write(bArr2, 0, read);
                        } catch (Throwable th4) {
                            th2 = th4;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            byteArrayOutputStream = inputStream;
                            th = th2;
                            try {
                                if (b) {
                                }
                                return false;
                            } finally {
                                UCCyclone.close(outputStream);
                                UCCyclone.close(byteArrayOutputStream);
                                UCCyclone.close(byteArrayOutputStream2);
                            }
                        }
                    }
                    String str2 = new String(byteArrayOutputStream3.toByteArray());
                    if (b) {
                        Log.i("SDKWaStat", "response:" + str2);
                    }
                    if (str2.contains("retcode=0")) {
                        UCCyclone.close(outputStream);
                        UCCyclone.close(inputStream);
                        UCCyclone.close(byteArrayOutputStream3);
                        return true;
                    }
                    UCCyclone.close(outputStream);
                    UCCyclone.close(inputStream);
                    UCCyclone.close(byteArrayOutputStream3);
                    return false;
                } catch (Throwable th5) {
                    th2 = th5;
                    byteArrayOutputStream = inputStream;
                    th = th2;
                    if (b) {
                    }
                    return false;
                }
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (b) {
                    Log.e("SDKWaStat", "", th);
                }
                return false;
            }
        } catch (Throwable th7) {
            th = th7;
            byteArrayOutputStream = byteArrayOutputStream2;
            outputStream = byteArrayOutputStream;
            if (b) {
            }
            return false;
        }
    }

    public static void a(Pair<String, HashMap<String, String>> pair) {
        UCLogger create = UCLogger.create("d", "SDKWaStat");
        if (create != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ev_ac=");
            sb.append((String) pair.first);
            for (Map.Entry entry : ((HashMap) pair.second).entrySet()) {
                sb.append("`");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
            create.print(sb.toString(), new Throwable[0]);
        }
    }

    public final void a(String str, int i2, int i3, int i4, String str2) {
        Date date = new Date(System.currentTimeMillis());
        int e2 = SDKFactory.b() ? SDKFactory.e() : 0;
        if (!(e2 == 2 || e2 == 0)) {
            e2 = (e2 * 10) + SDKFactory.h;
        }
        String str3 = this.n.format(date) + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + e2;
        synchronized (this.i) {
            if (this.m == null) {
                this.m = new HashMap();
            }
            C0245a aVar = this.m.get(str3);
            if (aVar == null) {
                aVar = new C0245a(this, (byte) 0);
                a(aVar.b);
                this.m.put(str3, aVar);
            }
            aVar.b.put(U4WPKAdapter.KEY_TM, this.h.format(date));
            if (i2 == 0) {
                Integer num = aVar.a.get(str);
                if (num == null) {
                    aVar.a.put(str, Integer.valueOf(i4));
                } else {
                    aVar.a.put(str, Integer.valueOf(i4 + num.intValue()));
                }
            } else if (i2 != 1) {
                if (i2 == 2) {
                    Integer num2 = aVar.a.get(str);
                    if (num2 == null || Integer.MAX_VALUE - num2.intValue() >= i4) {
                        if (num2 == null) {
                            aVar.a.put(str, Integer.valueOf(i4));
                            aVar.a.put(str + "_sc", 1);
                        } else {
                            aVar.a.put(str, Integer.valueOf(i4 + num2.intValue()));
                            Map<String, Integer> map = aVar.a;
                            aVar.a.put(str + "_sc", Integer.valueOf(map.get(str + "_sc").intValue() + 1));
                        }
                    }
                }
            } else if (i3 == 1) {
                aVar.b.put(str, str2);
            } else {
                String str4 = aVar.b.get(str);
                if (c.a(str4)) {
                    aVar.b.put(str, str2);
                } else {
                    aVar.b.put(str, str4 + "|" + str2);
                }
            }
        }
    }

    public final void a(boolean z) {
        if (c() && !c.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
            try {
                b().a(new b(this));
                if (z) {
                    Thread.sleep(20);
                }
            } catch (Exception e2) {
                Log.e("SDKWaStat", "saveData", e2);
            }
        }
    }

    private static boolean a(List list) {
        return list == null || list.size() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008d, code lost:
        if (r8 != 4) goto L_0x008f;
     */
    private boolean b(Context context) {
        try {
            Boolean a2 = e.a("wa_uspl_dabl");
            if (a2 != null && a2.booleanValue()) {
                return true;
            }
            String format = this.n.format(new Date());
            if (!format.isEmpty() && !format.equals(this.p)) {
                Integer b2 = e.b("wa_uspl_rate");
                int i2 = 2;
                if (b2 != null) {
                    i2 = b2.intValue();
                } else {
                    String packageName = context.getPackageName();
                    if (!TextUtils.isEmpty(packageName)) {
                        char c2 = 65535;
                        switch (packageName.hashCode()) {
                            case 270694045:
                                if (packageName.equals("com.UCMobile")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 1191029559:
                                if (packageName.equals("cn.xuexi.android")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 1335515207:
                                if (packageName.equals(ShareConstant.DD_APP_PACKAGE)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1855462465:
                                if (packageName.equals("com.taobao.taobao")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 2049668591:
                                if (packageName.equals("com.eg.android.AlipayGphone")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    if (c2 != 3) {
                                    }
                                }
                            }
                        }
                    }
                    i2 = 10;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("UC_WA_STAT", 4);
                if (!format.equals(sharedPreferences.getString("srt", ""))) {
                    if (this.q == null) {
                        String a3 = p.b.a(this.k);
                        if (TextUtils.isEmpty(a3)) {
                            this.q = new Random();
                        } else {
                            this.q = new Random(((long) a3.hashCode()) ^ System.nanoTime());
                        }
                    }
                    sharedPreferences.edit().putString("srt", format).putBoolean("srh", this.q.nextInt(100) + 1 <= i2).commit();
                }
                if (!sharedPreferences.getBoolean("srh", false)) {
                    i2 = 0;
                }
                this.o = i2;
                this.p = format;
            }
            StringBuilder sb = new StringBuilder("isHitSampleRate date=");
            sb.append(this.p);
            sb.append(", rate=");
            sb.append(this.o);
            sb.append(", hit=");
            sb.append(this.o > 0);
            Log.d("SDKWaStat", sb.toString());
            if (this.o > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.d("SDKWaStat", "doSample failed", th);
            return true;
        }
    }

    private void a(Map<String, C0245a> map, List<b> list) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        Exception e2;
        int i2;
        BufferedWriter bufferedWriter;
        if (!b(map) || !a(list)) {
            File file = new File(g(), h());
            if (b) {
                Log.d("SDKWaStat", "savePVToFile:" + file);
            }
            BufferedWriter bufferedWriter2 = null;
            try {
                int i3 = 0;
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        i2 = fileInputStream2.available();
                        fileInputStream2.close();
                    } catch (Exception e3) {
                        e2 = e3;
                        fileOutputStream2 = null;
                        fileInputStream = fileInputStream2;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = null;
                        fileInputStream = fileInputStream2;
                        fileOutputStream = null;
                        UCCyclone.close(bufferedWriter2);
                        UCCyclone.close(fileOutputStream);
                        UCCyclone.close(fileOutputStream2);
                        UCCyclone.close(fileInputStream);
                        throw th;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 >= e) {
                    if (b) {
                        Log.d("SDKWaStat", "file size(" + i2 + ") more then " + e);
                    }
                    UCCyclone.close((Closeable) null);
                    UCCyclone.close((Closeable) null);
                    UCCyclone.close((Closeable) null);
                    UCCyclone.close((Closeable) null);
                    return;
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream), 1024);
                } catch (Exception e4) {
                    e2 = e4;
                    fileInputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        e2.printStackTrace();
                        UCCyclone.close(bufferedWriter2);
                        UCCyclone.close(fileOutputStream);
                        UCCyclone.close(fileOutputStream2);
                        UCCyclone.close(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        UCCyclone.close(bufferedWriter2);
                        UCCyclone.close(fileOutputStream);
                        UCCyclone.close(fileOutputStream2);
                        UCCyclone.close(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    UCCyclone.close(bufferedWriter2);
                    UCCyclone.close(fileOutputStream);
                    UCCyclone.close(fileOutputStream2);
                    UCCyclone.close(fileInputStream);
                    throw th;
                }
                try {
                    Iterator<Map.Entry<String, C0245a>> it = map.entrySet().iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        try {
                            Map.Entry<String, C0245a> next = it.next();
                            int i5 = i4 + i2;
                            if (i5 < e) {
                                bufferedWriter.write("@0");
                                bufferedWriter.write("@k@");
                                int i6 = i4 + 2 + 3;
                                String key = next.getKey();
                                String[] split = key.split(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
                                if (split[1].equals("0")) {
                                    int e5 = SDKFactory.e();
                                    if (e5 != 2) {
                                        e5 = (e5 * 10) + SDKFactory.h;
                                    }
                                    key = split[0] + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + e5;
                                }
                                bufferedWriter.write(key);
                                bufferedWriter.write("@d@");
                                i4 = i6 + key.length() + 3 + a(bufferedWriter, next.getValue().a, 0) + a(bufferedWriter, next.getValue().b, 1);
                                bufferedWriter.newLine();
                            } else if (b) {
                                Log.d("SDKWaStat", "write merge data, size(" + i5 + ") more then " + e);
                            }
                        } catch (Exception e6) {
                            e2 = e6;
                            bufferedWriter2 = bufferedWriter;
                            fileOutputStream2 = fileOutputStream;
                            fileInputStream = null;
                            e2.printStackTrace();
                            UCCyclone.close(bufferedWriter2);
                            UCCyclone.close(fileOutputStream);
                            UCCyclone.close(fileOutputStream2);
                            UCCyclone.close(fileInputStream);
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedWriter2 = bufferedWriter;
                            fileOutputStream2 = fileOutputStream;
                            fileInputStream = null;
                            UCCyclone.close(bufferedWriter2);
                            UCCyclone.close(fileOutputStream);
                            UCCyclone.close(fileOutputStream2);
                            UCCyclone.close(fileInputStream);
                            throw th;
                        }
                    }
                    while (true) {
                        if (i3 >= 10 || i3 >= list.size()) {
                            break;
                        }
                        int i7 = i4 + i2;
                        if (i7 >= e) {
                            Log.d("SDKWaStat", "write un merge data, size(" + i7 + ") more then " + e);
                            break;
                        }
                        b bVar = list.get(i3);
                        bufferedWriter.write("@1");
                        bufferedWriter.write("@k@");
                        bufferedWriter.write(bVar.a);
                        bufferedWriter.write("@d@");
                        i4 = i4 + 2 + 3 + bVar.a.length() + 3 + a(bufferedWriter, bVar.b, 1);
                        bufferedWriter.newLine();
                        i3++;
                    }
                    UCCyclone.close(bufferedWriter);
                    UCCyclone.close(fileOutputStream);
                    UCCyclone.close(fileOutputStream);
                    UCCyclone.close((Closeable) null);
                } catch (Exception e7) {
                    e2 = e7;
                    fileInputStream = null;
                    bufferedWriter2 = bufferedWriter;
                    fileOutputStream2 = fileOutputStream;
                    e2.printStackTrace();
                    UCCyclone.close(bufferedWriter2);
                    UCCyclone.close(fileOutputStream);
                    UCCyclone.close(fileOutputStream2);
                    UCCyclone.close(fileInputStream);
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    bufferedWriter2 = bufferedWriter;
                    fileOutputStream2 = fileOutputStream;
                    UCCyclone.close(bufferedWriter2);
                    UCCyclone.close(fileOutputStream);
                    UCCyclone.close(fileOutputStream2);
                    UCCyclone.close(fileInputStream);
                    throw th;
                }
            } catch (Exception e8) {
                e2 = e8;
                fileOutputStream2 = null;
                fileOutputStream = null;
                fileInputStream = null;
                e2.printStackTrace();
                UCCyclone.close(bufferedWriter2);
                UCCyclone.close(fileOutputStream);
                UCCyclone.close(fileOutputStream2);
                UCCyclone.close(fileInputStream);
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream2 = null;
                fileOutputStream = null;
                fileInputStream = null;
                UCCyclone.close(bufferedWriter2);
                UCCyclone.close(fileOutputStream);
                UCCyclone.close(fileOutputStream2);
                UCCyclone.close(fileInputStream);
                throw th;
            }
        }
    }

    static /* synthetic */ void b(String str) {
        IGlobalSettings f2 = SDKFactory.f();
        if (f2 != null) {
            f2.setStringValue(SettingKeys.SDKUUID, str);
        }
    }

    private static <T> int a(BufferedWriter bufferedWriter, Map<String, T> map, int i2) throws Exception {
        int i3 = 0;
        if (!b(map)) {
            for (Map.Entry<String, T> entry : map.entrySet()) {
                bufferedWriter.write(entry.getKey());
                bufferedWriter.write("=");
                bufferedWriter.write(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + i2);
                bufferedWriter.write(((Object) entry.getValue()) + "`");
                StringBuilder sb = new StringBuilder(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                sb.append(i2);
                int length = entry.getKey().length() + 1 + sb.toString().length();
                i3 += length + (((Object) entry.getValue()) + "`").length();
            }
        }
        return i3;
    }

    public static void a(Map<String, String> map) {
        map.put("sdk_sn", com.uc.webview.export.Build.TIME);
        map.put("ver", Build.Version.NAME);
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    /* access modifiers changed from: private */
    public String a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("2", "");
        if (!c.a(string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = this.k.getSharedPreferences("UC_WA_STAT", 4).edit();
        edit.putString("2", uuid);
        edit.commit();
        return uuid;
    }

    static /* synthetic */ boolean a(long j2, long j3) {
        if (j3 == 0) {
            return true;
        }
        int i2 = c;
        if (i2 <= 0) {
            i2 = 25200000;
        }
        if (!(j2 - j3 >= ((long) i2))) {
            if (b) {
                Log.d("SDKWaStat", "时间间隔小于7小时,不上传");
            }
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        int i3 = instance.get(11);
        return !(i3 == 0 || i3 == 11 || i3 == 12 || i3 == 23);
    }

    static /* synthetic */ byte[] a(a aVar, String[] strArr) {
        Object[] j2 = aVar.j();
        if (j2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("lt=uc");
        Map map = (Map) j2[0];
        List list = (List) j2[1];
        List<String[]> k2 = aVar.k();
        strArr[0] = b(map, list);
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (sb.length() < e) {
                sb.append(StringUtils.LF);
                for (String[] strArr2 : k2) {
                    a(sb, strArr2[0], strArr2[1]);
                }
                for (Map.Entry<String, Integer> entry2 : ((C0245a) entry.getValue()).a.entrySet()) {
                    a(sb, entry2.getKey(), String.valueOf(entry2.getValue()));
                }
                for (Map.Entry<String, String> entry3 : ((C0245a) entry.getValue()).b.entrySet()) {
                    a(sb, entry3.getKey(), entry3.getValue());
                }
                for (Map.Entry<String, Integer> entry4 : SDKFactory.p.entrySet()) {
                    a(sb, entry4.getKey(), String.valueOf(entry4.getValue().intValue()));
                }
            } else if (b) {
                Log.d("SDKWaStat", "getUploadData MergeData size(" + sb.length() + ") more then " + e);
            }
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            b bVar = (b) it2.next();
            if (sb.length() < e) {
                sb.append(StringUtils.LF);
                for (String[] strArr3 : k2) {
                    a(sb, strArr3[0], strArr3[1]);
                }
                for (Map.Entry<String, String> entry5 : bVar.b.entrySet()) {
                    a(sb, entry5.getKey(), entry5.getValue());
                }
            } else if (b) {
                Log.d("SDKWaStat", "getUploadData UnMergeData size(" + sb.length() + ") more then " + e);
            }
        }
        if (b) {
            Log.i("SDKWaStat", "getUploadData:\n" + sb.toString());
        }
        sb.append(StringUtils.LF);
        a(sb, "stat_size", String.valueOf(sb.toString().getBytes().length));
        return sb.toString().getBytes();
    }

    static /* synthetic */ String a(String str, boolean z) {
        boolean b2 = i.a().b(UCCore.OPTION_SDK_INTERNATIONAL_ENV);
        String str2 = b2 ? "4ee01a39f0c1" : "27120f2b4115";
        String valueOf = String.valueOf(System.currentTimeMillis());
        String a2 = f.a(str2 + str + valueOf + "AppChk#2014");
        StringBuilder sb = new StringBuilder(b2 ? "https://gjapplog.ucweb.com/collect?uc_param_str=&chk=" : "https://applog.uc.cn/collect?uc_param_str=&chk=");
        sb.append(a2.substring(a2.length() - 8, a2.length()));
        sb.append("&vno=");
        sb.append(valueOf);
        sb.append("&uuid=");
        sb.append(str);
        sb.append("&app=");
        sb.append(str2);
        if (f.a()) {
            sb.append("&zip=gzip");
        }
        if (z) {
            sb.append("&enc=aes");
        }
        return sb.toString();
    }

    static /* synthetic */ void a(a aVar, long j2, String str) {
        SharedPreferences.Editor edit = aVar.k.getSharedPreferences("UC_WA_STAT", 4).edit();
        edit.putLong(i(), j2);
        if (str != null) {
            edit.putString("4", str);
        }
        edit.commit();
    }
}
