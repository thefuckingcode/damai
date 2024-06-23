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
import com.taobao.accs.internal.ServiceImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.Utils;

/* compiled from: Taobao */
public class BaseService extends Service {
    private static final String TAG = "BaseService";
    private static boolean isBinded;
    IBaseService mBaseService = null;
    private Messenger messenger = new Messenger(new Handler() {
        /* class com.taobao.accs.base.BaseService.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(BaseService.TAG, "handleMessage on receive msg", "msg", message.toString());
                Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(BaseService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    BaseService.this.onStartCommand(intent, 0, 0);
                }
            }
        }
    });

    public IBinder onBind(Intent intent) {
        ALog.d(TAG, "onBind", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
        try {
            if (Utils.isTarget26(this) && !isBinded) {
                isBinded = true;
                ALog.i(TAG, "onBind bind service", new Object[0]);
                getApplicationContext().bindService(new Intent(this, getClass()), new ServiceConnection() {
                    /* class com.taobao.accs.base.BaseService.AnonymousClass4 */

                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                }, 1);
            }
        } catch (Throwable th) {
            ALog.i(TAG, "onBind bind service with exception", th.toString());
        }
        return this.messenger.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.base.BaseService.AnonymousClass2 */

            public void run() {
                try {
                    BaseService.this.mBaseService = new ServiceImpl(BaseService.this);
                    BaseService.this.mBaseService.onCreate();
                } catch (Exception e) {
                    ALog.e(BaseService.TAG, "create ServiceImpl error", e.getMessage());
                }
            }
        });
    }

    public void onDestroy() {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.base.BaseService.AnonymousClass5 */

            public void run() {
                IBaseService iBaseService = BaseService.this.mBaseService;
                if (iBaseService != null) {
                    iBaseService.onDestroy();
                    BaseService.this.mBaseService = null;
                }
            }
        });
        super.onDestroy();
    }

    public int onStartCommand(final Intent intent, final int i, final int i2) {
        ThreadPoolExecutorFactory.execute(new Runnable() {
            /* class com.taobao.accs.base.BaseService.AnonymousClass3 */

            public void run() {
                BaseService baseService = BaseService.this;
                IBaseService iBaseService = baseService.mBaseService;
                if (iBaseService != null) {
                    iBaseService.onStartCommand(intent, i, i2);
                    return;
                }
                baseService.onCreate();
                BaseService.this.onStartCommand(intent, i, i2);
            }
        });
        return 1;
    }
}
