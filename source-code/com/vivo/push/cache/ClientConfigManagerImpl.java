package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.a;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.p;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class ClientConfigManagerImpl implements d {
    private static final String TAG = "ClientConfigManager";
    private static volatile ClientConfigManagerImpl sClientConfigManagerImpl;
    private a mAppConfigSettings = new a(this.mContext);
    private Context mContext;
    private e mPushConfigSettings = new e(this.mContext);

    private ClientConfigManagerImpl(Context context) {
        this.mContext = ContextDelegate.getContext(context);
    }

    public static synchronized ClientConfigManagerImpl getInstance(Context context) {
        ClientConfigManagerImpl clientConfigManagerImpl;
        synchronized (ClientConfigManagerImpl.class) {
            if (sClientConfigManagerImpl == null) {
                sClientConfigManagerImpl = new ClientConfigManagerImpl(context);
            }
            clientConfigManagerImpl = sClientConfigManagerImpl;
        }
        return clientConfigManagerImpl;
    }

    private void prepareAppConfig() {
        a aVar = this.mAppConfigSettings;
        if (aVar == null) {
            this.mAppConfigSettings = new a(this.mContext);
        } else {
            aVar.c();
        }
    }

    private e preparePushConfigSettings() {
        e eVar = this.mPushConfigSettings;
        if (eVar == null) {
            this.mPushConfigSettings = new e(this.mContext);
        } else {
            eVar.c();
        }
        return this.mPushConfigSettings;
    }

    public void clearPush() {
        this.mAppConfigSettings.d();
    }

    public Set<String> getBlackEventList() {
        return null;
    }

    public String getSuitTag() {
        return preparePushConfigSettings().c("CSPT");
    }

    public String getValueByKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mPushConfigSettings.c();
        return this.mPushConfigSettings.c(str);
    }

    public Set<Long> getWhiteLogList() {
        HashSet hashSet = new HashSet();
        String valueByKey = getValueByKey("WLL");
        if (!TextUtils.isEmpty(valueByKey)) {
            for (String str : valueByKey.split(",")) {
                try {
                    hashSet.add(Long.valueOf(Long.parseLong(str)));
                } catch (Exception unused) {
                }
            }
        }
        p.d(TAG, " initWhiteLogList ".concat(String.valueOf(hashSet)));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[RETURN] */
    public boolean isCancleBroadcastReceiver() {
        int i;
        String c = preparePushConfigSettings().c("PSM");
        if (!TextUtils.isEmpty(c)) {
            try {
                i = Integer.parseInt(c);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if ((i & 4) == 0) {
                return true;
            }
            return false;
        }
        i = 0;
        if ((i & 4) == 0) {
        }
    }

    public boolean isDebug() {
        this.mAppConfigSettings.c();
        return a.a(this.mAppConfigSettings.b());
    }

    public boolean isEnablePush() {
        prepareAppConfig();
        a c = this.mAppConfigSettings.c(this.mContext.getPackageName());
        if (c != null) {
            return "1".equals(c.b());
        }
        return true;
    }

    @Override // com.vivo.push.cache.d
    public boolean isInBlackList(long j) {
        String c = preparePushConfigSettings().c("BL");
        if (!TextUtils.isEmpty(c)) {
            String[] split = c.split(",");
            for (String str : split) {
                try {
                    if (!TextUtils.isEmpty(str) && Long.parseLong(str) == j) {
                        return true;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean isDebug(int i) {
        return a.a(i);
    }
}
