package com.ut.mini;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.analytics.core.config.UTClientConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.gj2;
import tb.yi;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class RepeatExposurePageMgr {
    private static final String PAGE_ALL = "a";
    private static final String PAGE_BLACK = "b";
    private static final String PAGE_WHITE = "w";
    private static final String PAGE_WHITE_HTTP_HEAD = "http";
    private static final String REPEAT_EXPOSURE_KEY = "repeatExposure";
    private static final String SP_REPEAT_EXPOSURE_KEY = "repeatExposure";
    private static final String SP_REPEAT_EXPOSURE_NAME = "ut_repeatExposure";
    private static final String TAG = "RepeatExposurePageMgr";
    private static RepeatExposurePageMgr mInstance;
    private boolean mAllBlack = false;
    private boolean mGetConfigFromServer = false;
    private boolean mInit = false;
    private List<String> mRepeatExposurePageBlackList;
    private List<String> mRepeatExposurePageWhiteList;

    private RepeatExposurePageMgr() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    private void changeConfig(String str) {
        int i;
        int i2 = 0;
        try {
            reset();
            HashMap hashMap = (HashMap) JSON.parseObject(str, Map.class);
            List<String> list = (List) hashMap.get("b");
            this.mRepeatExposurePageBlackList = list;
            i = list != null ? list.size() : 0;
            try {
                this.mRepeatExposurePageWhiteList = (List) hashMap.get("w");
                List list2 = (List) hashMap.get("a");
                if (list2 == null || list2.size() != 1 || !"b".equalsIgnoreCase((String) list2.get(0))) {
                    this.mAllBlack = false;
                } else {
                    this.mAllBlack = true;
                }
            } catch (Exception unused) {
                i2 = i;
                reset();
                i = i2;
                if (i < 1) {
                }
                RepeatExposureQueueMgr.getInstance().start();
            }
        } catch (Exception unused2) {
            reset();
            i = i2;
            if (i < 1) {
            }
            RepeatExposureQueueMgr.getInstance().start();
        }
        if (i < 1 || this.mAllBlack) {
            RepeatExposureQueueMgr.getInstance().start();
        } else {
            RepeatExposureQueueMgr.getInstance().stop();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getConfigFromSp() {
        Context b = yi.c().b();
        if (b == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = b.getSharedPreferences(SP_REPEAT_EXPOSURE_NAME, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString("repeatExposure", null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static RepeatExposurePageMgr getInstance() {
        if (mInstance == null) {
            synchronized (RepeatExposurePageMgr.class) {
                if (mInstance == null) {
                    mInstance = new RepeatExposurePageMgr();
                }
            }
        }
        return mInstance;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void putConfigToSp(String str) {
        SharedPreferences.Editor edit;
        Context b = yi.c().b();
        if (b != null) {
            try {
                SharedPreferences sharedPreferences = b.getSharedPreferences(SP_REPEAT_EXPOSURE_NAME, 0);
                if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                    edit.putString("repeatExposure", str);
                    edit.apply();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void reset() {
        try {
            List<String> list = this.mRepeatExposurePageBlackList;
            if (list != null) {
                list.clear();
            }
            List<String> list2 = this.mRepeatExposurePageWhiteList;
            if (list2 != null) {
                list2.clear();
            }
        } catch (Exception unused) {
        }
        this.mAllBlack = false;
    }

    public void init() {
        if (!this.mInit) {
            this.mInit = true;
            gj2.c().f(new Runnable() {
                /* class com.ut.mini.RepeatExposurePageMgr.AnonymousClass1 */

                public void run() {
                    synchronized (RepeatExposurePageMgr.this) {
                        if (!RepeatExposurePageMgr.this.mGetConfigFromServer) {
                            String configFromSp = RepeatExposurePageMgr.this.getConfigFromSp();
                            Logger.f(RepeatExposurePageMgr.TAG, "getConfigFromSp", configFromSp);
                            RepeatExposurePageMgr.this.changeConfig(configFromSp);
                        }
                    }
                }
            });
            UTClientConfigMgr.d().f(new UTClientConfigMgr.IConfigChangeListener() {
                /* class com.ut.mini.RepeatExposurePageMgr.AnonymousClass2 */

                @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
                public String getKey() {
                    return "repeatExposure";
                }

                @Override // com.alibaba.analytics.core.config.UTClientConfigMgr.IConfigChangeListener
                public void onChange(String str) {
                    synchronized (RepeatExposurePageMgr.this) {
                        RepeatExposurePageMgr.this.mGetConfigFromServer = true;
                        Logger.f(RepeatExposurePageMgr.TAG, "getConfigFromServer", str);
                        RepeatExposurePageMgr.this.changeConfig(str);
                        RepeatExposurePageMgr.this.putConfigToSp(str);
                    }
                }
            });
        }
    }

    public boolean isRepeatExposurePage(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
            try {
                List<String> list = this.mRepeatExposurePageBlackList;
                if (list != null && list.contains(str)) {
                    return true;
                }
                List<String> list2 = this.mRepeatExposurePageWhiteList;
                if (list2 == null || !list2.contains(str)) {
                    return this.mAllBlack;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
