package com.taobao.accs.data;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ConnectionServiceManager;
import com.taobao.accs.utl.ALog;
import com.taobao.weex.ui.component.WXComponent;

/* compiled from: Taobao */
public class MsgDistributeService extends Service {
    private static final String TAG = "MsgDistributeService";
    private static boolean isBinded;
    private Messenger messenger = new Messenger(new Handler() {
        /* class com.taobao.accs.data.MsgDistributeService.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message != null) {
                ALog.i(MsgDistributeService.TAG, "handleMessage on receive msg", "msg", message.toString());
                Intent intent = (Intent) message.getData().getParcelable(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                if (intent != null) {
                    ALog.i(MsgDistributeService.TAG, "handleMessage get intent success", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                    MsgDistributeService.this.onStartCommand(intent, 0, 0);
                }
            }
        }
    });

    public IBinder onBind(Intent intent) {
        if (!isBinded) {
            isBinded = true;
            getApplicationContext().bindService(new Intent(this, getClass()), new ServiceConnection() {
                /* class com.taobao.accs.data.MsgDistributeService.AnonymousClass2 */

                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                public void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        }
        return this.messenger.getBinder();
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
            ALog.i(TAG, "onStartCommand", "action", intent.getAction());
            String action = intent.getAction();
            if (Constants.ACTION_SEND.equals(action)) {
                ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() {
                    /* class com.taobao.accs.data.MsgDistributeService.AnonymousClass3 */

                    public void run() {
                        ALog.i(MsgDistributeService.TAG, "onStartCommand send message", new Object[0]);
                        ACCSManager.AccsRequest accsRequest = (ACCSManager.AccsRequest) intent.getSerializableExtra(Constants.KEY_SEND_REQDATA);
                        String stringExtra = intent.getStringExtra("packageName");
                        String stringExtra2 = intent.getStringExtra("appKey");
                        String stringExtra3 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                        if (TextUtils.isEmpty(stringExtra3)) {
                            stringExtra3 = stringExtra2;
                        }
                        ACCSManager.getAccsInstance(MsgDistributeService.this.getApplicationContext(), stringExtra2, stringExtra3).sendRequest(MsgDistributeService.this.getApplicationContext(), accsRequest, stringExtra, false);
                    }
                });
            } else if (Constants.ACTION_SENDMESSAGE_INMAIN.equals(action)) {
                if (ConnectionServiceManager.getInstance().isEnabled(getApplicationContext())) {
                    boolean booleanExtra = intent.getBooleanExtra(c.a, true);
                    ConnectionServiceManager.getInstance().getConnectionWrapper().send((Message) intent.getSerializableExtra(WXComponent.PROP_FS_MATCH_PARENT), booleanExtra);
                }
            } else if (Constants.ACTION_CHANNEL_CONNECTION_CHANGED.equals(action)) {
                boolean booleanExtra2 = intent.getBooleanExtra(c.a, false);
                ALog.e(TAG, "ACTION_CHANNEL_CONNECTION_CHANGED", "available", Boolean.valueOf(booleanExtra2));
                ConnectionServiceManager.getInstance().onChannelConnectionChanged(booleanExtra2);
            } else {
                ALog.i(TAG, "onStartCommand distribute message", new Object[0]);
                intent.setFlags(0);
                MsgDistribute.distribMessage(getApplicationContext(), intent);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "onStartCommand", th, new Object[0]);
        }
        return 2;
    }
}
