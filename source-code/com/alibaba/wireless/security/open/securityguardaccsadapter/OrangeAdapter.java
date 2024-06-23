package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.content.Context;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
public class OrangeAdapter {
    private static final boolean DEBUG = false;
    public static final String SECURITYGUARD_ORANGE_NAMESPACE = "securityguard_orange_namespace";
    private static final String TAG = "OrangeAdapter";
    public static Context gContext;
    private static String[] mNameSpaces = {SECURITYGUARD_ORANGE_NAMESPACE};

    public static void registerListener(Context context) {
        gContext = context;
        OrangeConfig.getInstance().registerListener(mNameSpaces, new OrangeListener(), true);
    }

    public static void setOrangeNameSpaces(String[] strArr) {
        mNameSpaces = strArr;
    }
}
