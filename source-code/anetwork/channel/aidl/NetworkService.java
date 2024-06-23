package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.degrade.DegradableNetworkDelegate;
import anetwork.channel.http.HttpNetworkDelegate;

/* compiled from: Taobao */
public class NetworkService extends Service {
    private static final String TAG = "anet.NetworkService";
    private Context context;
    private RemoteNetwork.Stub degradeableNetwork = null;
    private RemoteNetwork.Stub httpNetwork = null;
    IRemoteNetworkGetter.Stub stub = new IRemoteNetworkGetter.Stub() {
        /* class anetwork.channel.aidl.NetworkService.AnonymousClass1 */

        @Override // anetwork.channel.aidl.IRemoteNetworkGetter
        public RemoteNetwork get(int i) throws RemoteException {
            return i == 1 ? NetworkService.this.degradeableNetwork : NetworkService.this.httpNetwork;
        }
    };

    public IBinder onBind(Intent intent) {
        this.context = getApplicationContext();
        if (ALog.g(2)) {
            ALog.f(TAG, "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.degradeableNetwork = new DegradableNetworkDelegate(this.context);
        this.httpNetwork = new HttpNetworkDelegate(this.context);
        if (IRemoteNetworkGetter.class.getName().equals(intent.getAction())) {
            return this.stub;
        }
        return null;
    }

    public void onDestroy() {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
