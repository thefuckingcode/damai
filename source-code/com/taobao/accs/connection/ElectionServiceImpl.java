package com.taobao.accs.connection;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.taobao.windvane.connect.api.ApiConstants;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.net.SpdyConnection;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
public abstract class ElectionServiceImpl implements IBaseService {
    private static final String TAG = "ElectionServiceImpl";
    private static AtomicBoolean isInit = new AtomicBoolean();
    protected static ConcurrentHashMap<String, BaseConnection> mConnections = new ConcurrentHashMap<>(2);
    private Service mBaseService = null;
    private Context mContext;

    public ElectionServiceImpl(Service service) {
        this.mBaseService = service;
        this.mContext = service.getApplicationContext();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e2, code lost:
        if (r11 == false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e4, code lost:
        r12.start();
     */
    protected static BaseConnection getConnection(final Context context, String str, boolean z, int i, int i2) {
        Throwable th;
        AccsClientConfig configByTag;
        if (!isInit.getAndSet(true) && ConnectionServiceManager.getInstance().isAllWeather()) {
            ThreadPoolExecutorFactory.execute(new Runnable() {
                /* class com.taobao.accs.connection.ElectionServiceImpl.AnonymousClass1 */

                public void run() {
                    try {
                        ALog.preTag = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.KEY_LOG_TAG, ALog.preTag);
                        ALog.e(ElectionServiceImpl.TAG, "add preTag", new Object[0]);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        BaseConnection baseConnection = null;
        try {
            if (TextUtils.isEmpty(str)) {
                ALog.w(TAG, "getConnection configTag null or env invalid", "conns.size", Integer.valueOf(mConnections.size()));
                if (mConnections.size() > 0) {
                    return mConnections.elements().nextElement();
                }
                return null;
            }
            ALog.i(TAG, "getConnection", Constants.KEY_CONFIG_TAG, str, "start", Boolean.valueOf(z));
            if (OrangeAdapter.isChannelModeEnable() || (configByTag = AccsClientConfig.getConfigByTag(str)) == null || !configByTag.getDisableChannel()) {
                int mode = Utils.getMode(context);
                String str2 = str + "|" + mode;
                synchronized (ElectionServiceImpl.class) {
                    try {
                        BaseConnection baseConnection2 = mConnections.get(str2);
                        if (baseConnection2 == null) {
                            try {
                                ALog.e(TAG, "new app connection", "key", str2);
                                AccsClientConfig.mEnv = mode;
                                if (OrangeAdapter.isChannelModeEnable()) {
                                    baseConnection = new InAppConnection(context, 1, str, i2);
                                } else {
                                    baseConnection = new SpdyConnection(context, 0, str);
                                }
                                mConnections.put(str2, baseConnection);
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        } else {
                            baseConnection = baseConnection2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            } else {
                ALog.e(TAG, "getConnection channel disabled!", Constants.KEY_CONFIG_TAG, str);
                return null;
            }
        } catch (Throwable th4) {
            ALog.e(TAG, "getConnection", th4, new Object[0]);
        }
        return baseConnection;
    }

    private void handleStartCommand(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra("appKey");
            String stringExtra3 = intent.getStringExtra("ttid");
            String stringExtra4 = intent.getStringExtra("app_sercet");
            String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
            boolean booleanExtra = intent.getBooleanExtra("start", false);
            int intExtra = intent.getIntExtra("mode", 0);
            ALog.i(TAG, "handleStartCommand", Constants.KEY_CONFIG_TAG, stringExtra5, "appkey", stringExtra2, ApiConstants.APPSECRET, stringExtra4, "ttid", stringExtra3, "pkg", stringExtra);
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && stringExtra.equals(this.mContext.getPackageName())) {
                Utils.setMode(this.mContext, intExtra);
                BaseConnection connection = getConnection(this.mContext, stringExtra5, booleanExtra, -1);
                if (connection != null) {
                    connection.mTtid = stringExtra3;
                } else {
                    ALog.e(TAG, "handleStartCommand start action, no connection", Constants.KEY_CONFIG_TAG, stringExtra5);
                }
                UtilityImpl.saveAppKey(this.mContext, stringExtra2);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "handleStartCommand", th, new Object[0]);
        }
    }

    public static synchronized void resetAllConnections(Context context) {
        synchronized (ElectionServiceImpl.class) {
            try {
                HashSet hashSet = new HashSet();
                for (Map.Entry<String, BaseConnection> entry : mConnections.entrySet()) {
                    hashSet.add(entry.getKey().split(SymbolExpUtil.SYMBOL_VERTICALBAR)[0]);
                    entry.getValue().shutdown();
                }
                mConnections.clear();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    getConnection(context, (String) it.next(), false, 0).start();
                }
            } catch (Exception e) {
                ALog.e(TAG, "resetAllConnections", e, new Object[0]);
            }
        }
        return;
    }

    @Override // com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onCreate() {
        ALog.i(TAG, "onCreate,", "sdkVersion", Integer.valueOf((int) Constants.SDK_VERSION_CODE));
    }

    @Override // com.taobao.accs.base.IBaseService
    public void onDestroy() {
        ALog.e(TAG, "Service onDestroy", new Object[0]);
        this.mContext = null;
        this.mBaseService = null;
    }

    public abstract int onHostStartCommand(Intent intent, int i, int i2);

    @Override // com.taobao.accs.base.IBaseService
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        ALog.i(TAG, "onStartCommand begin", "action", action);
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            handleStartCommand(intent);
        }
        return onHostStartCommand(intent, i, i2);
    }

    @Override // com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    public abstract void onVotedHost();

    public static BaseConnection getConnection(Context context, String str, boolean z, int i) {
        boolean isForeground = UtilityImpl.isForeground(context);
        if (isForeground && UtilityImpl.isChannelProcess(context) && !UtilityImpl.isMainProcessAlive(context)) {
            isForeground = false;
        }
        int i2 = isForeground ? 1 : 0;
        int i3 = isForeground ? 1 : 0;
        int i4 = isForeground ? 1 : 0;
        return getConnection(context, str, z, i, i2);
    }
}
