package anetwork.channel.unified;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.util.ALog;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableFuture;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.ParcelableRequest;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.aidl.adapter.ConnectionDelegate;
import anetwork.channel.aidl.adapter.ParcelableFutureResponse;
import anetwork.channel.aidl.adapter.ParcelableNetworkListenerWrapper;
import anetwork.channel.entity.Repeater;
import anetwork.channel.http.NetworkSdkSetting;
import java.io.ByteArrayOutputStream;
import tb.ag2;
import tb.b02;
import tb.pd;
import tb.rd;

/* compiled from: Taobao */
public abstract class UnifiedNetworkDelegate extends RemoteNetwork.Stub {
    public static final int DEGRADABLE = 1;
    public static final int HTTP = 0;
    private static final String TAG = "anet.UnifiedNetworkDelegate";
    protected int type = 1;

    protected UnifiedNetworkDelegate(Context context) {
        NetworkSdkSetting.init(context);
    }

    private NetworkResponse convertToSync(ParcelableRequest parcelableRequest) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            ConnectionDelegate connectionDelegate = (ConnectionDelegate) getConnection(parcelableRequest);
            ParcelableInputStream inputStream = connectionDelegate.getInputStream();
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.length() > 0 ? inputStream.length() : 1024);
                pd c = rd.a().c(2048);
                while (true) {
                    int read = inputStream.read(c.c());
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(c.c(), 0, read);
                }
                networkResponse.setBytedata(byteArrayOutputStream.toByteArray());
            }
            int statusCode = connectionDelegate.getStatusCode();
            if (statusCode < 0) {
                networkResponse.setBytedata(null);
            } else {
                networkResponse.setConnHeadFields(connectionDelegate.getConnHeadFields());
            }
            networkResponse.setStatusCode(statusCode);
            networkResponse.setStatisticData(connectionDelegate.getStatisticData());
            return networkResponse;
        } catch (RemoteException e) {
            networkResponse.setStatusCode(-103);
            String message = e.getMessage();
            if (!TextUtils.isEmpty(message)) {
                networkResponse.setDesc(ag2.e(networkResponse.getDesc(), "|", message));
            }
            return networkResponse;
        } catch (Exception unused) {
            networkResponse.setStatusCode(-201);
            return networkResponse;
        }
    }

    @Override // anetwork.channel.aidl.RemoteNetwork
    public ParcelableFuture asyncSend(ParcelableRequest parcelableRequest, ParcelableNetworkListener parcelableNetworkListener) throws RemoteException {
        try {
            return asyncSend(new b02(parcelableRequest, this.type, false), parcelableNetworkListener);
        } catch (Exception e) {
            ALog.d(TAG, "asyncSend failed", parcelableRequest.seqNo, e, new Object[0]);
            throw new RemoteException(e.getMessage());
        }
    }

    @Override // anetwork.channel.aidl.RemoteNetwork
    public Connection getConnection(ParcelableRequest parcelableRequest) throws RemoteException {
        try {
            b02 b02 = new b02(parcelableRequest, this.type, true);
            ConnectionDelegate connectionDelegate = new ConnectionDelegate(b02);
            connectionDelegate.setFuture(asyncSend(b02, new ParcelableNetworkListenerWrapper(connectionDelegate, null, null)));
            return connectionDelegate;
        } catch (Exception e) {
            ALog.d(TAG, "asyncSend failed", parcelableRequest.seqNo, e, new Object[0]);
            throw new RemoteException(e.getMessage());
        }
    }

    @Override // anetwork.channel.aidl.RemoteNetwork
    public NetworkResponse syncSend(ParcelableRequest parcelableRequest) throws RemoteException {
        return convertToSync(parcelableRequest);
    }

    private ParcelableFuture asyncSend(b02 b02, ParcelableNetworkListener parcelableNetworkListener) throws RemoteException {
        return new ParcelableFutureResponse(new UnifiedRequestTask(b02, new Repeater(parcelableNetworkListener, b02)).e());
    }
}
