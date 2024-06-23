package mtopsdk.xstate;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.xstate.aidl.IXState;

/* compiled from: Taobao */
public class XStateService extends Service {
    private static final String TAG = "mtopsdk.XStateService";
    Object lock = new Object();
    IXState.Stub stub = null;

    /* compiled from: Taobao */
    class XStateStub extends IXState.Stub {
        public XStateStub() {
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public String getValue(String str) throws RemoteException {
            return XStateDelegate.getValue(str);
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void init() throws RemoteException {
            XStateDelegate.init(XStateService.this.getBaseContext());
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public String removeKey(String str) throws RemoteException {
            return XStateDelegate.removeKey(str);
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void setValue(String str, String str2) throws RemoteException {
            XStateDelegate.setValue(str, str2);
        }

        @Override // mtopsdk.xstate.aidl.IXState
        public void unInit() throws RemoteException {
            XStateDelegate.unInit();
        }
    }

    public IBinder onBind(Intent intent) {
        synchronized (this.lock) {
            if (this.stub == null) {
                XStateStub xStateStub = new XStateStub();
                this.stub = xStateStub;
                try {
                    xStateStub.init();
                } catch (RemoteException e) {
                    TBSdkLog.e(TAG, "[onBind]init() exception", e);
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, "[onBind]init() error", th);
                }
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[onBind] XStateService  stub= " + this.stub.hashCode());
        }
        return this.stub;
    }

    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            IXState.Stub stub2 = this.stub;
            if (stub2 != null) {
                try {
                    stub2.unInit();
                } catch (RemoteException e) {
                    TBSdkLog.e(TAG, "[onDestroy]unInit() exception", e);
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, "[onDestroy]unInit() error", th);
                }
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
