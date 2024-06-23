package com.tencent.smtt.sdk.a;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.FileProvider;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: MttLoader */
public class c {

    /* compiled from: MttLoader */
    public static class a {
        public int a = -1;
        public int b = -1;
        public String c = "";
        public String d = "0";
        public String e = null;
    }

    /* access modifiers changed from: private */
    /* compiled from: MttLoader */
    public static class b {
        public String a;
        public String b;

        private b() {
            this.a = "";
            this.b = "";
        }
    }

    public static boolean a(Context context, String str, int i, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        Set<String> keySet;
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
                for (String str3 : keySet) {
                    String str4 = hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra(str3, str4);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            Uri a2 = a(context, str);
            if (a2 == null) {
                return false;
            }
            intent.setDataAndType(a2, "mtt/" + str2);
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Uri a(Context context, String str) {
        return FileProvider.a(context, str);
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        boolean z;
        Set<String> keySet;
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f  */
    public static int a(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        boolean z;
        PackageInfo packageInfo;
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0)) == null || packageInfo.versionCode <= 601000)) {
                z = true;
                String encode = URLEncoder.encode(str, "UTF-8");
                if (z) {
                    str = encode;
                }
                z2 = z;
                String str3 = !z2 ? ",encoded=1" : "";
                sb.append("mttbrowser://url=");
                sb.append(str);
                sb.append(",product=");
                sb.append("TBS");
                sb.append(",packagename=");
                sb.append(context.getPackageName());
                sb.append(",from=");
                sb.append(str2);
                sb.append(",version=");
                sb.append(TbsConfig.TBS_SDK_VERSIONNAME);
                sb.append(str3);
                return a(context, sb.toString(), hashMap, webView);
            }
        } catch (Throwable unused) {
        }
        z = false;
        try {
            String encode2 = URLEncoder.encode(str, "UTF-8");
            if (z) {
            }
            z2 = z;
        } catch (Exception unused2) {
        }
        if (!z2) {
        }
        sb.append("mttbrowser://url=");
        sb.append(str);
        sb.append(",product=");
        sb.append("TBS");
        sb.append(",packagename=");
        sb.append(context.getPackageName());
        sb.append(",from=");
        sb.append(str2);
        sb.append(",version=");
        sb.append(TbsConfig.TBS_SDK_VERSIONNAME);
        sb.append(str3);
        return a(context, sb.toString(), hashMap, webView);
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        Set<String> keySet;
        if (context == null) {
            return 3;
        }
        if (!a(str)) {
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return 2;
            }
            a a2 = a(context);
            if (a2.a == -1) {
                return 4;
            }
            if (a2.a == 2 && a2.b < 33) {
                return 5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (a2.a == 2) {
                if (a2.b >= 33 && a2.b <= 39) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                } else if (a2.b >= 40 && a2.b <= 45) {
                    intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                } else if (a2.b >= 46) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a3 = a(context, parse);
                    if (a3 != null && !TextUtils.isEmpty(a3.a)) {
                        intent.setClassName(a3.b, a3.a);
                    }
                }
            } else if (a2.a == 1) {
                if (a2.b == 1) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                } else if (a2.b == 2) {
                    intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                }
            } else if (a2.a != 0) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                b a4 = a(context, parse);
                if (a4 != null && !TextUtils.isEmpty(a4.a)) {
                    intent.setClassName(a4.b, a4.a);
                }
            } else if (a2.b >= 4 && a2.b <= 6) {
                intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
            } else if (a2.b > 6) {
                intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                b a5 = a(context, parse);
                if (a5 != null && !TextUtils.isEmpty(a5.a)) {
                    intent.setClassName(a5.b, a5.a);
                }
            }
            intent.setData(parse);
            if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
                for (String str2 : keySet) {
                    String str3 = hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        intent.putExtra(str2, str3);
                    }
                }
            }
            try {
                intent.putExtra("loginType", d(context));
                intent.addFlags(268435456);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (ActivityNotFoundException unused) {
                return 4;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    private static int d(Context context) {
        String str = context.getApplicationInfo().processName;
        if (str.equals(TbsConfig.APP_QQ)) {
            return 13;
        }
        if (str.equals(TbsConfig.APP_QZONE)) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals(TbsConfig.APP_WX) ? 24 : 26;
    }

    private static b a(Context context, Uri uri) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.a = resolveInfo.activityInfo.name;
                bVar.b = resolveInfo.activityInfo.packageName;
            }
        }
        return bVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:3|4|5|6|7|(2:11|12)|13|14|15|16|17|18|19|20|(1:35)|36) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0081 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
    public static a a(Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        a aVar = new a();
        if (z) {
            return aVar;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
            aVar.a = 2;
            aVar.e = TbsConfig.APP_QB;
            aVar.c = "ADRQB_";
            if (packageInfo != null && packageInfo.versionCode > 420000) {
                aVar.b = packageInfo.versionCode;
                aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.d = packageInfo.versionName.replaceAll("\\.", "");
                return aVar;
            }
            packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
            aVar.a = 0;
            aVar.e = "com.tencent.qbx";
            aVar.c = "ADRQBX_";
            packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
            aVar.a = 1;
            aVar.e = "com.tencent.qbx5";
            aVar.c = "ADRQBX5_";
            packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
            aVar.e = TbsConfig.APP_QB;
            aVar.a = 2;
            aVar.c = "ADRQB_";
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                aVar.e = "com.tencent.mtt.x86";
                aVar.a = 2;
                aVar.c = "ADRQB_";
            } catch (Exception unused) {
                try {
                    b a2 = a(context, Uri.parse("http://mdc.html5.qq.com/mh?channel_id=50079&u="));
                    if (a2 != null && !TextUtils.isEmpty(a2.b)) {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(a2.b, 0);
                        try {
                            aVar.e = a2.b;
                            aVar.a = 2;
                            aVar.c = "ADRQB_";
                        } catch (Exception unused2) {
                        }
                        packageInfo = packageInfo2;
                    }
                } catch (Exception unused3) {
                }
            }
            if (packageInfo != null) {
                aVar.b = packageInfo.versionCode;
                aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception unused4) {
        }
        return aVar;
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            return trim.toLowerCase().contains("://");
        }
        return false;
    }

    public static boolean b(Context context) {
        return a(context).a != -1;
    }

    public static boolean c(Context context) {
        a a2 = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a2.d).longValue() >= 6001500) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (a2.b >= 601500) {
            return true;
        }
        return z;
    }

    public static boolean a(Context context, long j, long j2) {
        a a2 = a(context);
        boolean z = false;
        try {
            if (Long.valueOf(a2.d).longValue() >= j) {
                z = true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (((long) a2.b) >= j2) {
            return true;
        }
        return z;
    }
}
