package com.taobao.accs.connection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsIPCProvider;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.net.BaseConnection;
import com.taobao.accs.net.InAppConnection;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.utils.IPCUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tb.h9;
import tb.lf1;

/* compiled from: Taobao */
public class AllWeatherConnectionService extends ConnectionService {
    private static final String TAG = "AllWeatherConnectionService";
    protected static final ConnectionLock connLock = new ConnectionLock();
    private boolean isBackScheduled = false;
    private volatile boolean isDownGradle = false;
    private Boolean lastAllowed = null;
    private String mConfigTag;
    private Context mContext = GlobalClientInfo.getContext();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class ConnectionLock {
        static final String LOCK_FILE_NAME = "aw_con.lock";
        private long lastModified = -1;
        private String lastValue;

        ConnectionLock() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:46|(2:48|49)|50|51|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(7:30|31|(1:33)|(2:35|36)|37|38|39) */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0123, code lost:
            if (r10 == null) goto L_0x0126;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00fb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0106 */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x011e A[SYNTHETIC, Splitter:B:74:0x011e] */
        private String getOrSetProcessByLock(int i, String str) {
            FileLock fileLock;
            RandomAccessFile randomAccessFile;
            Throwable th;
            try {
                File file = new File(GlobalClientInfo.getContext().getDir("accs", 0), LOCK_FILE_NAME);
                long lastModified2 = file.lastModified();
                if (i == 0) {
                    if (lastModified2 == this.lastModified) {
                        if (ALog.isPrintLog(ALog.Level.I)) {
                            ALog.i(AllWeatherConnectionService.TAG, "use cache", "modified", Long.valueOf(lastModified2), "lastValue", this.lastValue);
                        }
                        return this.lastValue;
                    } else if (lastModified2 != 0) {
                        if (ALog.isPrintLog(ALog.Level.I)) {
                            ALog.i(AllWeatherConnectionService.TAG, "set modified: " + lastModified2, new Object[0]);
                        }
                        this.lastModified = lastModified2;
                    }
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (OverlappingFileLockException e) {
                    ALog.e(AllWeatherConnectionService.TAG, "fileLock err", e, new Object[0]);
                    fileLock = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    try {
                        ALog.e(AllWeatherConnectionService.TAG, "getChannelEnabledImpl", th, "rw", Integer.valueOf(i));
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th3) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
                if (i == 1) {
                    try {
                        ALog.e(AllWeatherConnectionService.TAG, "getOrSetProcessByLock write", "process", str);
                        randomAccessFile.setLength(0);
                        if (!TextUtils.isEmpty(str)) {
                            randomAccessFile.write(str.getBytes());
                        }
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        randomAccessFile.close();
                        return str;
                    } catch (Throwable th4) {
                        th = th4;
                        ALog.e(AllWeatherConnectionService.TAG, "getChannelEnabledImpl", th, "rw", Integer.valueOf(i));
                        if (fileLock != null) {
                        }
                    }
                } else if (i == 0) {
                    String readLine = randomAccessFile.readLine();
                    ALog.e(AllWeatherConnectionService.TAG, "getOrSetProcessByLock read&write", lf1.OPERATION_READ, readLine, lf1.OPERATION_WRITE, str);
                    if (!TextUtils.isEmpty(readLine) || TextUtils.isEmpty(str)) {
                        this.lastValue = readLine;
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                        return readLine;
                    }
                    randomAccessFile.write(str.getBytes());
                    this.lastValue = str;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    randomAccessFile.close();
                    return str;
                } else {
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused5) {
                    }
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                fileLock = null;
                ALog.e(AllWeatherConnectionService.TAG, "getChannelEnabledImpl", th, "rw", Integer.valueOf(i));
                if (fileLock != null) {
                }
            }
        }

        public void clear() {
            getOrSetProcessByLock(1, null);
        }

        public String getProcessIfEmptyThenSet(String str) {
            return getOrSetProcessByLock(0, str);
        }

        public void setProcess(String str) {
            getOrSetProcessByLock(1, str);
        }
    }

    public AllWeatherConnectionService() {
        schedule();
    }

    private void downGrade() {
        ALog.e(TAG, "downGrade", new Object[0]);
        this.isDownGradle = true;
        connLock.setProcess(this.mContext.getPackageName());
        if (UtilityImpl.isMainProcess(this.mContext)) {
            reset();
            try {
                ConnectionServiceManager.getInstance().getConnectionWrapper().start();
            } catch (IPCException e) {
                ALog.e(TAG, "downGrade err", e, new Object[0]);
            }
        }
        if (UtilityImpl.isChannelProcessAlive(this.mContext)) {
            Intent intent = new Intent(Constants.ACTION_CLOSE_CONNECTION);
            intent.putExtra(Constants.KEY_CONFIG_TAG, this.mConfigTag);
            intent.setClassName(this.mContext.getPackageName(), AdapterUtilityImpl.channelService);
            IntentDispatch.dispatchIntent(this.mContext, intent);
        }
    }

    private void schedule() {
        if (OrangeAdapter.isConnAutoSwitch2Channel() && UtilityImpl.isMainProcess(this.mContext)) {
            ThreadPoolExecutorFactory.schedule(new Runnable() {
                /* class com.taobao.accs.connection.AllWeatherConnectionService.AnonymousClass1 */

                public void run() {
                    ALog.e(AllWeatherConnectionService.TAG, "onBackground() by schedule", new Object[0]);
                    if (ConnectionServiceManager.getInstance().isAllWeather()) {
                        AllWeatherConnectionService.this.onBackground();
                    }
                }
            }, 15, TimeUnit.SECONDS);
        }
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public IConnection getConnection(String str, AccsClientConfig accsClientConfig) {
        if (this.conn == null) {
            this.mConfigTag = str;
            String processIfEmptyThenSet = connLock.getProcessIfEmptyThenSet(IPCUtils.getCurrentProcessName());
            boolean z = TextUtils.isEmpty(processIfEmptyThenSet) || processIfEmptyThenSet.equals(this.mContext.getPackageName());
            if (!Utils.isMainProcess(this.mContext) || !z) {
                try {
                    if (UtilityImpl.isMainProcess(this.mContext)) {
                        GlobalClientInfo.getInstance(this.mContext).recoverListener("default");
                    }
                    this.conn = (IConnection) ARanger.create(new ComponentName(GlobalClientInfo.mContext, AccsIPCProvider.class), IConnection.class, new Pair(AccsClientConfig.class, accsClientConfig), new Pair(Integer.class, Integer.valueOf((ForeBackManager.getManager().getState() != 1 || !UtilityImpl.isForeground(GlobalClientInfo.mContext)) ? 0 : 1)));
                    this.isProxyConnection = true;
                } catch (IPCException unused) {
                    downGrade();
                }
            } else {
                this.conn = new ConnectionWrapper(str);
                this.isProxyConnection = false;
            }
            ALog.e(TAG, "getConnection-aw", "isUsingARanger", Boolean.valueOf(this.isProxyConnection));
        }
        return this.conn;
    }

    /* access modifiers changed from: protected */
    public boolean isCurProcessAllow2Connect() {
        String currentProcessName = IPCUtils.getCurrentProcessName();
        String processIfEmptyThenSet = connLock.getProcessIfEmptyThenSet(currentProcessName);
        boolean z = TextUtils.isEmpty(processIfEmptyThenSet) || processIfEmptyThenSet.equals(currentProcessName);
        Boolean bool = this.lastAllowed;
        if (bool == null || bool.booleanValue() != z) {
            ALog.e(TAG, "isCurProcessAllow2Connect", "process", processIfEmptyThenSet, "allowed", Boolean.valueOf(z));
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.lastAllowed = valueOf;
        return valueOf.booleanValue();
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public boolean isProxyConnection() {
        return this.isProxyConnection;
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public void onBackground() {
        if (this.isDownGradle) {
            ALog.e(TAG, "onBackground() but already downGrade", new Object[0]);
        } else if (!this.isBackScheduled) {
            this.isBackScheduled = true;
            ALog.e(TAG, "onBackground schedule start", new Object[0]);
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() {
                /* class com.taobao.accs.connection.AllWeatherConnectionService.AnonymousClass2 */

                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onBackground scheduling, ctx==null? ");
                    sb.append(AllWeatherConnectionService.this.mContext == null);
                    ALog.e(AllWeatherConnectionService.TAG, sb.toString(), new Object[0]);
                    try {
                        ((IChannelConnection) ARanger.create(new ComponentName(AllWeatherConnectionService.this.mContext, AccsIPCProvider.class), IChannelConnection.class, new Pair[0])).start(AllWeatherConnectionService.this.mConfigTag, ForeBackManager.getManager().getState(), new IChannelConnListener() {
                            /* class com.taobao.accs.connection.AllWeatherConnectionService.AnonymousClass2.AnonymousClass1 */

                            @Override // com.taobao.accs.connection.IChannelConnListener
                            public void onStart() {
                                ALog.e(AllWeatherConnectionService.TAG, "onChannelStart()", new Object[0]);
                                AllWeatherConnectionService.connLock.setProcess(UtilityImpl.getChannelProcessName(AllWeatherConnectionService.this.mContext));
                            }
                        });
                    } catch (IPCException e) {
                        ALog.e(AllWeatherConnectionService.TAG, "IChannelConnection err", e, new Object[0]);
                    }
                }
            }, 5, TimeUnit.SECONDS);
        }
    }

    @Override // com.taobao.accs.connection.ConnectionService
    public void onChannelConnectionChanged(boolean z) {
        ALog.e(TAG, "onConnectionStateChanged", "connected", Boolean.valueOf(z), "isUsingARanger", Boolean.valueOf(this.isProxyConnection));
        if (z && !this.isProxyConnection) {
            try {
                BaseConnection connection = ((ConnectionWrapper) this.conn).getConnection();
                if (connection instanceof InAppConnection) {
                    reset();
                    if (OrangeAdapter.normalChangesEnabled()) {
                        h9.z0(false);
                    }
                    ((InAppConnection) connection).unRegisterSessionInfo();
                }
                IConnection connectionWrapper = ConnectionServiceManager.getInstance().getConnectionWrapper();
                connectionWrapper.setForeBackState(ForeBackManager.getManager().getState());
                ArrayList<AccsConnectStateListener> accsConnectStateListenerArrayList = connection.getAccsConnectStateListenerArrayList();
                if (accsConnectStateListenerArrayList != null) {
                    Iterator<AccsConnectStateListener> it = accsConnectStateListenerArrayList.iterator();
                    while (it.hasNext()) {
                        connectionWrapper.registerConnectStateListener(it.next());
                    }
                }
            } catch (Throwable th) {
                ALog.e(TAG, "channelConnListener err", th, new Object[0]);
            }
        }
    }
}
