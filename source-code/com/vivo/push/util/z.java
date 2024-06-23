package com.vivo.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.p;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.gl1;

/* compiled from: Taobao */
public final class z {
    private static String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] b = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
    private static String[] c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
    private static String[] d = {"com.vivo.push.sdk.RegistrationReceiver"};
    private static String[] e = new String[0];
    private static Map<String, Bundle> f = new ConcurrentHashMap();

    public static long a(Context context) {
        String b2 = t.b(context);
        if (!TextUtils.isEmpty(b2)) {
            return a(context, b2);
        }
        p.a("Utility", "systemPushPkgName is null");
        return -1;
    }

    public static String b(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.app_id");
        if (a2 != null) {
            return a2.toString();
        }
        Object a3 = a(context, str, "app_id");
        return a3 != null ? a3.toString() : "";
    }

    public static String c(Context context, String str) {
        Object a2 = a(context, str, "verification_status");
        return a2 != null ? a2.toString() : "";
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    for (String str2 : c) {
                        a(str2, serviceInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("serviceInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (e.length > 0) {
            try {
                if (context.getPackageManager() != null) {
                    ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
                    if (activityInfoArr != null) {
                        for (String str2 : e) {
                            a(str2, activityInfoArr, str);
                        }
                        return;
                    }
                    throw new VivoPushException("activityInfos is null");
                }
                throw new VivoPushException("localPackageManager is null");
            } catch (Exception e2) {
                throw new VivoPushException("error " + e2.getMessage());
            }
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
                if (activityInfoArr != null) {
                    for (String str2 : d) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("receivers is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    public static PublicKey c(Context context) {
        Cursor query = context.getContentResolver().query(p.a, null, null, null, null);
        if (query == null) {
            return null;
        }
        do {
            try {
                if (query.moveToNext()) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                query.close();
            } catch (Exception unused2) {
            }
            return null;
        } while (!"pushkey".equals(query.getString(query.getColumnIndex("name"))));
        String string = query.getString(query.getColumnIndex("value"));
        p.d("Utility", "result key : ".concat(String.valueOf(string)));
        PublicKey a2 = u.a(string);
        try {
            query.close();
        } catch (Exception unused3) {
        }
        return a2;
    }

    public static long a(Context context, String str) {
        Object a2 = a(context, str, "com.vivo.push.sdk_version");
        if (a2 == null) {
            a2 = a(context, str, "sdk_version");
        }
        if (a2 != null) {
            try {
                return Long.parseLong(a2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                p.a("Utility", "getSdkVersionCode error ", e2);
                return -1;
            }
        } else {
            p.a("Utility", "getSdkVersionCode sdk version is null");
            return -1;
        }
    }

    public static void b(Context context) throws VivoPushException {
        String str;
        p.d("Utility", "check PushService AndroidManifest declearation !");
        String b2 = t.b(context);
        boolean d2 = t.d(context, context.getPackageName());
        boolean e2 = t.e(context, context.getPackageName());
        boolean c2 = t.c(context, context.getPackageName());
        if (e2) {
            a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            b = new String[]{"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else if (c2 || d2) {
            if (c2) {
                c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                c = new String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            d = new String[0];
            a = new String[0];
            if (d2) {
                b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
            } else {
                b = new String[]{"android.permission.INTERNET"};
            }
        } else {
            throw new VivoPushException("AndroidManifest.xml中receiver配置项错误，详见接入文档");
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    String[] strArr2 = b;
                    for (String str2 : strArr2) {
                        for (String str3 : strArr) {
                            if (!str2.equals(str3)) {
                            }
                        }
                        throw new VivoPushException("permission : " + str2 + "  check fail : " + Arrays.toString(strArr));
                    }
                    f(context, b2);
                    d(context, b2);
                    e(context, b2);
                    try {
                        if (a(context, context.getPackageName(), "local_iv") != null) {
                            String packageName = context.getPackageName();
                            Object a2 = a(context, packageName, "com.vivo.push.api_key");
                            if (a2 != null) {
                                str = a2.toString();
                            } else {
                                Object a3 = a(context, packageName, "api_key");
                                str = a3 != null ? a3.toString() : "";
                            }
                            if (TextUtils.isEmpty(str)) {
                                throw new VivoPushException("com.vivo.push.api_key is null");
                            } else if (TextUtils.isEmpty(b(context, context.getPackageName()))) {
                                throw new VivoPushException("com.vivo.push.app_id is null");
                            } else if ((d2 || e2) && a(context, context.getPackageName()) == -1) {
                                throw new VivoPushException("sdkversion is null");
                            } else if (e2) {
                                a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                                a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                            }
                        } else {
                            throw new VivoPushException("AndroidManifest.xml中未配置".concat("local_iv"));
                        }
                    } catch (Exception e3) {
                        throw new VivoPushException("getMetaValue error " + e3.getMessage());
                    }
                } else {
                    throw new VivoPushException("Permissions is null!");
                }
            } else {
                throw new VivoPushException("localPackageManager is null");
            }
        } catch (Exception e4) {
            throw new VivoPushException(e4.getMessage());
        }
    }

    public static boolean d(Context context) {
        Cursor cursor = null;
        if (context == null) {
            try {
                p.a("Utility", "context is null");
                return false;
            } catch (Exception e2) {
                p.a("Utility", "isSupport", e2);
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        p.a("Utility", "close", e3);
                    }
                }
                throw th;
            }
        } else {
            String packageName = context.getPackageName();
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            Cursor query = context.getContentResolver().query(p.b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"323", packageName, String.valueOf(i)}, null);
            if (query == null) {
                p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        p.a("Utility", "close", e4);
                    }
                }
                return false;
            } else if (!query.moveToFirst() || (query.getInt(query.getColumnIndex("permission")) & 1) == 0) {
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", "close", e5);
                }
                return false;
            } else {
                try {
                    query.close();
                } catch (Exception e6) {
                    p.a("Utility", "close", e6);
                }
                return true;
            }
        }
    }

    public static Object a(Context context, String str, String str2) {
        Exception e2;
        Bundle bundle;
        Bundle bundle2 = null;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f;
            Object obj = (map == null || map.size() <= 0 || (bundle = f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                if (applicationInfo != null) {
                    bundle2 = applicationInfo.metaData;
                }
                Object obj2 = bundle2 != null ? bundle2.get(str2) : obj;
                try {
                    if (f.size() > 300) {
                        return obj2;
                    }
                    f.put(str, bundle2);
                    return obj2;
                } catch (Exception e3) {
                    bundle2 = obj2;
                    e2 = e3;
                    p.a("Utility", "getMetaValue::".concat(String.valueOf(e2)));
                    return bundle2;
                }
            } catch (Exception e4) {
                e2 = e4;
                bundle2 = obj;
                p.a("Utility", "getMetaValue::".concat(String.valueOf(e2)));
                return bundle2;
            }
        } catch (Exception e5) {
            e2 = e5;
            p.a("Utility", "getMetaValue::".concat(String.valueOf(e2)));
            return bundle2;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                } else {
                    throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
                }
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (!componentInfo.applicationInfo.packageName.equals(str)) {
            for (String str2 : a) {
                if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                    throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            } else if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                    throw new VivoPushException("checkModule " + intent + " has no receivers");
                }
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (str2.equals(resolveInfo.activityInfo.name)) {
                        return;
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            } else {
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    throw new VivoPushException("checkModule " + intent + " has no services");
                }
                for (ResolveInfo resolveInfo2 : queryIntentServices) {
                    if (str2.equals(resolveInfo2.serviceInfo.name)) {
                        if (!resolveInfo2.serviceInfo.exported) {
                            throw new VivoPushException(resolveInfo2.serviceInfo.name + " exported is false");
                        }
                        return;
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
        } catch (Exception e2) {
            p.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static boolean b(Context context, String str, String str2) {
        Cursor cursor = null;
        if (context == null) {
            try {
                p.a("Utility", "context is null");
                return false;
            } catch (Exception e2) {
                p.a("Utility", "isOverdue", e2);
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        p.a("Utility", "close", e3);
                    }
                }
                throw th;
            }
        } else {
            Cursor query = context.getContentResolver().query(p.c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, "323"}, null);
            if (query == null) {
                p.a("Utility", "cursor is null");
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        p.a("Utility", "close", e4);
                    }
                }
                return false;
            } else if (query.moveToFirst()) {
                boolean parseBoolean = Boolean.parseBoolean(query.getString(query.getColumnIndex("clientState")));
                try {
                    query.close();
                } catch (Exception e5) {
                    p.a("Utility", "close", e5);
                }
                return parseBoolean;
            } else {
                try {
                    query.close();
                } catch (Exception e6) {
                    p.a("Utility", "close", e6);
                }
                return false;
            }
        }
    }

    public static void a(Context context, Intent intent) {
        String b2 = t.b(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(b2)) {
            p.a("Utility", "illegality abe adapter : push pkg is null");
        } else if (TextUtils.isEmpty(stringExtra)) {
            p.a("Utility", "illegality abe adapter : src pkg is null");
        } else if (b2.equals(context.getPackageName())) {
            p.a("Utility", "illegality abe adapter : abe is not pushservice");
        } else if (!b2.equals(stringExtra)) {
            p.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + b2);
            intent.setPackage(b2);
            intent.setClassName(b2, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
        } else {
            p.a("Utility", "illegality abe adapter : pushPkg = " + b2 + " ; srcPkg = " + stringExtra);
        }
    }
}
