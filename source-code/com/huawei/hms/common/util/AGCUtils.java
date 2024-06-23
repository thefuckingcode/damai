package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class AGCUtils {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    public static String a(Context context, String str) {
        String str2;
        InputStream inputStream = null;
        try {
            AGConnectOptionsBuilder aGConnectOptionsBuilder = new AGConnectOptionsBuilder();
            inputStream = context.getResources().getAssets().open("agconnect-services.json");
            aGConnectOptionsBuilder.setInputStream(inputStream);
            str2 = aGConnectOptionsBuilder.build(context).getString(str);
        } catch (IOException e) {
            HMSLog.e("AGCUtils", "Get " + str + " failed: " + e);
        } catch (NullPointerException e2) {
            HMSLog.e("AGCUtils", "Get " + str + " with AGConnectServicesConfig failed: " + e2);
        } catch (Throwable th) {
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        HMSLog.e("AGCUtils", "The " + str + " is null.");
        return "";
        str2 = "";
        IOUtils.closeQuietly(inputStream);
        if (TextUtils.isEmpty(str2)) {
        }
    }

    public static String b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e);
            return "";
        }
    }

    public static boolean c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        String str;
        if (c(context)) {
            str = a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        } else {
            str = null;
        }
        try {
            AGConnectInstance instance = AGConnectInstance.getInstance();
            if (instance.getContext() != context) {
                instance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = instance.getOptions().getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a = a(context);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        return a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        if (c(context)) {
            return a(context, "client/cp_id");
        }
        String str = null;
        try {
            AGConnectInstance instance = AGConnectInstance.getInstance();
            if (instance.getContext() != context) {
                instance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = instance.getOptions().getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String b = b(context);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        return a(context, "client/cp_id");
    }

    public static String a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.appid")) == null) {
                HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e) {
            HMSLog.e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e);
            return "";
        }
    }
}
