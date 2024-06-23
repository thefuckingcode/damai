package com.ali.user.open.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;

/* compiled from: Taobao */
public class ResourceUtils {
    public static final String TAG = "ResourceUtils";

    public static int getIdentifier(Context context, String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(KernelContext.packageName)) {
            str3 = KernelContext.packageName;
        } else {
            str3 = context.getPackageName();
        }
        SDKLogger.i("resources", "resources = " + KernelContext.resources + " packageName = " + KernelContext.packageName);
        Resources resources = KernelContext.resources;
        if (resources != null) {
            return resources.getIdentifier(str2, str, str3);
        }
        return context.getResources().getIdentifier(str2, str, str3);
    }

    public static String getString(Context context, String str) {
        Resources resources = KernelContext.resources;
        if (resources != null) {
            return resources.getString(getIdentifier(context, "string", str));
        }
        return context.getResources().getString(getIdentifier(context, "string", str));
    }

    public static String getString(String str) {
        return getString(KernelContext.getApplicationContext(), str);
    }
}
