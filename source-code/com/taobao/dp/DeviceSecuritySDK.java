package com.taobao.dp;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.compat.ICompatComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.dp.client.IInitResultListener;
import com.taobao.dp.http.IUrlRequestService;

@Deprecated
/* compiled from: Taobao */
public final class DeviceSecuritySDK {
    public static final int ENVIRONMENT_DAILY = 2;
    public static final int ENVIRONMENT_ONLINE = 0;
    public static final int ENVIRONMENT_PRE = 1;
    private static DeviceSecuritySDK instance;
    private ICompatComponent mCompatComponent = null;
    private IUMIDComponent mUmidComponent = null;
    private String mVersion;

    private DeviceSecuritySDK(Context context) {
        try {
            SecurityGuardManager instance2 = SecurityGuardManager.getInstance(context);
            IUMIDComponent iUMIDComponent = (IUMIDComponent) instance2.getInterface(IUMIDComponent.class);
            this.mUmidComponent = iUMIDComponent;
            if (iUMIDComponent == null) {
                this.mCompatComponent = (ICompatComponent) instance2.getInterface(ICompatComponent.class);
            }
            this.mVersion = instance2.getSDKVerison();
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public static DeviceSecuritySDK getInstance(Context context) {
        if (instance == null) {
            synchronized (DeviceSecuritySDK.class) {
                if (instance == null) {
                    instance = new DeviceSecuritySDK(context);
                }
            }
        }
        return instance;
    }

    @Deprecated
    public String getSecurityToken() {
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                return iUMIDComponent.getSecurityToken();
            }
            ICompatComponent iCompatComponent = this.mCompatComponent;
            if (iCompatComponent != null) {
                return iCompatComponent.getCachedSecurityToken(0);
            }
            return "000000000000000000000000";
        } catch (SecException e) {
            e.printStackTrace();
            return "000000000000000000000000";
        }
    }

    public String getVersion() {
        return this.mVersion;
    }

    @Deprecated
    public void init() {
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                iUMIDComponent.initUMID();
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public void initAsync(String str, int i, IUrlRequestService iUrlRequestService, IInitResultListener iInitResultListener) {
        initAsync(str, "", i, iUrlRequestService, iInitResultListener);
    }

    public int initSync(String str, int i, IUrlRequestService iUrlRequestService) {
        return initSync(str, "", i, iUrlRequestService);
    }

    @Deprecated
    public void sendLoginResult(String str) {
    }

    public void setEnvironment(int i) {
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                iUMIDComponent.setEnvironment(i);
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setOnlineHost(OnlineHost onlineHost) throws IllegalArgumentException {
        if (onlineHost != null) {
            try {
                IUMIDComponent iUMIDComponent = this.mUmidComponent;
                if (iUMIDComponent != null) {
                    iUMIDComponent.setOnlineHost(onlineHost.getHost());
                }
            } catch (SecException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("host is null");
        }
        return;
    }

    public void initAsync(String str, String str2, int i, IUrlRequestService iUrlRequestService, final IInitResultListener iInitResultListener) {
        AnonymousClass1 r2 = iInitResultListener != null ? new IUMIDInitListenerEx() {
            /* class com.taobao.dp.DeviceSecuritySDK.AnonymousClass1 */

            @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
            public void onUMIDInitFinishedEx(String str, int i) {
                iInitResultListener.onInitFinished(str, i);
            }
        } : null;
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                iUMIDComponent.initUMID(i, r2);
            }
        } catch (SecException e) {
            e.printStackTrace();
            if (iInitResultListener != null) {
                iInitResultListener.onInitFinished(null, -1);
            }
        }
    }

    public int initSync(String str, String str2, int i, IUrlRequestService iUrlRequestService) {
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                return iUMIDComponent.initUMIDSync(i);
            }
            return -1;
        } catch (SecException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public void init(IUrlRequestService iUrlRequestService) {
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                iUMIDComponent.initUMID();
            }
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public String getSecurityToken(int i) {
        String cachedSecurityToken;
        try {
            IUMIDComponent iUMIDComponent = this.mUmidComponent;
            if (iUMIDComponent != null) {
                cachedSecurityToken = iUMIDComponent.getSecurityToken(i);
            } else {
                ICompatComponent iCompatComponent = this.mCompatComponent;
                if (iCompatComponent == null) {
                    return "000000000000000000000000";
                }
                cachedSecurityToken = iCompatComponent.getCachedSecurityToken(i);
            }
            return cachedSecurityToken;
        } catch (SecException e) {
            e.printStackTrace();
            return "000000000000000000000000";
        }
    }
}
