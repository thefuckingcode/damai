package com.taobao.accs.base;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AccsHandler;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
public abstract class TaoBaseService extends Service implements AccsDataListener {
    private static final String TAG = "TaoBaseService";
    private static boolean isBinded;
    private Messenger messenger = new Messenger(new Handler() {
        /* class com.taobao.accs.base.TaoBaseService.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(TaoBaseService.TAG, "handleMessage on receive msg", "msg", message.toString());
                Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(TaoBaseService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    TaoBaseService.this.onStartCommand(intent, 0, 0);
                }
            }
        }
    });

    /* compiled from: Taobao */
    public enum ExtHeaderType {
        TYPE_BUSINESS,
        TYPE_SID,
        TYPE_USERID,
        TYPE_COOKIE,
        TYPE_TAG,
        TYPE_STATUS,
        TYPE_DELAY,
        TYPE_EXPIRE,
        TYPE_LOCATION,
        TYPE_UNIT,
        TYPE_NEED_BUSINESS_ACK;

        public static ExtHeaderType valueOf(int i) {
            switch (i) {
                case 0:
                    return TYPE_BUSINESS;
                case 1:
                    return TYPE_SID;
                case 2:
                    return TYPE_USERID;
                case 3:
                    return TYPE_COOKIE;
                case 4:
                    return TYPE_TAG;
                case 5:
                    return TYPE_STATUS;
                case 6:
                    return TYPE_DELAY;
                case 7:
                    return TYPE_EXPIRE;
                case 8:
                    return TYPE_LOCATION;
                case 9:
                    return TYPE_UNIT;
                case 10:
                    return TYPE_NEED_BUSINESS_ACK;
                default:
                    return null;
            }
        }
    }

    /* compiled from: Taobao */
    public static class ExtraInfo implements Serializable {
        public static final String EXT_HEADER = "ext_header";
        public int connType;
        public Map<ExtHeaderType, String> extHeader;
        public String fromHost;
        public String fromPackage;
        public Map<Integer, String> oriExtHeader;
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, ExtraInfo extraInfo) {
    }

    public IBinder onBind(Intent intent) {
        if (!isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(this, getClass()), new ServiceConnection() {
                /* class com.taobao.accs.base.TaoBaseService.AnonymousClass2 */

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                public void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        }
        return this.messenger.getBinder();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(ConnectInfo connectInfo) {
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(ConnectInfo connectInfo) {
    }

    public int onStartCommand(final Intent intent, int i, int i2) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.base.TaoBaseService.AnonymousClass3 */

            public void run() {
                TaoBaseService taoBaseService = TaoBaseService.this;
                AccsHandler.onReceiveData(taoBaseService, intent, taoBaseService);
            }
        });
        return 2;
    }

    /* compiled from: Taobao */
    public static class ConnectInfo implements Serializable {
        private static final long serialVersionUID = 8974674111758240362L;
        public boolean connected;
        public int errorCode;
        public String errordetail;
        public String host;
        public boolean isCenterHost;
        public boolean isInapp;
        public String process;

        public ConnectInfo(String str, boolean z, boolean z2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
        }

        public String toString() {
            return "ConnectInfo{" + "host='" + this.host + '\'' + ", isInapp=" + this.isInapp + ", isCenterHost=" + this.isCenterHost + ", connected=" + this.connected + ", errorCode=" + this.errorCode + ", errorDetail='" + this.errordetail + '\'' + '}';
        }

        public ConnectInfo(String str, boolean z, boolean z2, int i, String str2) {
            this.host = str;
            this.isInapp = z;
            this.isCenterHost = z2;
            this.errorCode = i;
            this.errordetail = str2;
        }
    }
}
