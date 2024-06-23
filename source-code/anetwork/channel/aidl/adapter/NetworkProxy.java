package anetwork.channel.aidl.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.fulltrace.a;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.util.ALog;
import anetwork.channel.Network;
import anetwork.channel.NetworkListener;
import anetwork.channel.Request;
import anetwork.channel.Response;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.degrade.DegradableNetworkDelegate;
import anetwork.channel.http.HttpNetworkDelegate;
import java.util.concurrent.Future;
import tb.sh1;
import tb.ss0;
import tb.w6;

/* compiled from: Taobao */
public class NetworkProxy implements Network {
    protected static final int DEGRADE = 1;
    protected static final int HTTP = 0;
    protected static String TAG = "anet.NetworkProxy";
    private Context mContext;
    private volatile RemoteNetwork mDelegate = null;
    private int mType = 0;

    protected NetworkProxy(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void initDelegateInstance(boolean z) {
        if (this.mDelegate == null) {
            if (sh1.A()) {
                boolean j = ss0.j();
                if (!sh1.j() || !j) {
                    RemoteGetterHelper.initRemoteGetterAndWait(this.mContext, z);
                    tryGetRemoteNetworkInstance(this.mType);
                    if (this.mDelegate != null) {
                        return;
                    }
                } else {
                    RemoteGetterHelper.initRemoteGetterAndWait(this.mContext, false);
                    if (!RemoteGetterHelper.bBinding || this.mDelegate != null) {
                        tryGetRemoteNetworkInstance(this.mType);
                        if (this.mDelegate != null) {
                            return;
                        }
                    } else {
                        this.mDelegate = this.mType == 1 ? new DegradableNetworkDelegate(this.mContext) : new HttpNetworkDelegate(this.mContext);
                        ALog.f(TAG, "[initDelegateInstance] getNetworkInstance when binding service", null, new Object[0]);
                        return;
                    }
                }
                if (sh1.h() && j && RemoteGetterHelper.bBindFailed) {
                    synchronized (this) {
                        if (this.mDelegate == null) {
                            this.mDelegate = this.mType == 1 ? new DegradableNetworkDelegate(this.mContext) : new HttpNetworkDelegate(this.mContext);
                            ALog.e(TAG, "[initDelegateInstance] getNetworkInstance when bindService failed.", null, new Object[0]);
                            return;
                        }
                    }
                }
            }
            synchronized (this) {
                if (this.mDelegate == null) {
                    if (ALog.g(2)) {
                        ALog.f(TAG, "[getLocalNetworkInstance]", null, new Object[0]);
                    }
                    this.mDelegate = new HttpNetworkDelegate(this.mContext);
                }
            }
        }
    }

    private void recordRequestStat(Request request) {
        if (request != null) {
            request.setExtProperty("f-netReqStart", String.valueOf(System.currentTimeMillis()));
            String extProperty = request.getExtProperty("f-traceId");
            if (TextUtils.isEmpty(extProperty)) {
                extProperty = a.e().createRequest();
            }
            request.setExtProperty("f-traceId", extProperty);
            request.setExtProperty("f-reqProcess", ss0.d());
        }
    }

    private void reportRemoteError(Throwable th, String str) {
        ALog.d(TAG, null, str, th, new Object[0]);
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(-103, null, "rt");
        exceptionStatistic.exceptionStack = th.toString();
        w6.b().commitStat(exceptionStatistic);
    }

    private synchronized void tryGetRemoteNetworkInstance(int i) {
        if (this.mDelegate == null) {
            if (ALog.g(2)) {
                String str = TAG;
                ALog.f(str, "[tryGetRemoteNetworkInstance] type=" + i, null, new Object[0]);
            }
            IRemoteNetworkGetter remoteGetter = RemoteGetterHelper.getRemoteGetter();
            if (remoteGetter != null) {
                try {
                    this.mDelegate = remoteGetter.get(i);
                } catch (Throwable th) {
                    reportRemoteError(th, "[tryGetRemoteNetworkInstance]get RemoteNetwork Delegate failed.");
                }
            }
        }
    }

    @Override // anetwork.channel.Network
    public Future<Response> asyncSend(Request request, Object obj, Handler handler, NetworkListener networkListener) {
        boolean z = false;
        ALog.f(TAG, "networkProxy asyncSend", request.getSeqNo(), new Object[0]);
        recordRequestStat(request);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        initDelegateInstance(z);
        ParcelableRequest parcelableRequest = new ParcelableRequest(request);
        ParcelableNetworkListenerWrapper parcelableNetworkListenerWrapper = null;
        if (!(networkListener == null && handler == null)) {
            parcelableNetworkListenerWrapper = new ParcelableNetworkListenerWrapper(networkListener, handler, obj);
        }
        if (parcelableRequest.url == null) {
            if (parcelableNetworkListenerWrapper != null) {
                try {
                    parcelableNetworkListenerWrapper.onFinished(new DefaultFinishEvent(-102));
                } catch (RemoteException unused) {
                }
            }
            return new FutureResponse(new NetworkResponse(-102));
        }
        try {
            return new FutureResponse(this.mDelegate.asyncSend(parcelableRequest, parcelableNetworkListenerWrapper));
        } catch (Throwable th) {
            if (parcelableNetworkListenerWrapper != null) {
                try {
                    parcelableNetworkListenerWrapper.onFinished(new DefaultFinishEvent(-102));
                } catch (RemoteException unused2) {
                }
            }
            reportRemoteError(th, "[asyncSend]call asyncSend exception");
            return new FutureResponse(new NetworkResponse(-103));
        }
    }

    @Override // anetwork.channel.Network
    public Connection getConnection(Request request, Object obj) {
        ALog.f(TAG, "networkProxy getConnection", request.getSeqNo(), new Object[0]);
        recordRequestStat(request);
        initDelegateInstance(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(request);
        if (parcelableRequest.url == null) {
            return new ConnectionDelegate(-102);
        }
        try {
            return this.mDelegate.getConnection(parcelableRequest);
        } catch (Throwable th) {
            reportRemoteError(th, "[getConnection]call getConnection method failed.");
            return new ConnectionDelegate(-103);
        }
    }

    @Override // anetwork.channel.Network
    public Response syncSend(Request request, Object obj) {
        ALog.f(TAG, "networkProxy syncSend", request.getSeqNo(), new Object[0]);
        recordRequestStat(request);
        initDelegateInstance(true);
        ParcelableRequest parcelableRequest = new ParcelableRequest(request);
        if (parcelableRequest.url == null) {
            return new NetworkResponse(-102);
        }
        try {
            return this.mDelegate.syncSend(parcelableRequest);
        } catch (Throwable th) {
            reportRemoteError(th, "[syncSend]call syncSend method failed.");
            return new NetworkResponse(-103);
        }
    }
}
