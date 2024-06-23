package anetwork.channel.aidl.adapter;

import android.os.Build;
import android.os.RemoteException;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableFuture;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.b02;
import tb.fe0;

/* compiled from: Taobao */
public class ConnectionDelegate extends Connection.Stub implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private b02 config;
    private String desc;
    private ParcelableFuture future;
    private Map<String, List<String>> header;
    private ParcelableInputStreamImpl inputStream;
    private StatisticData statisticData;
    private int statusCode;
    private CountDownLatch statusLatch = new CountDownLatch(1);
    private CountDownLatch streamLatch = new CountDownLatch(1);

    public ConnectionDelegate(int i) {
        this.statusCode = i;
        this.desc = fe0.b(i);
    }

    private RemoteException buildRemoteException(String str) {
        if (Build.VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    private void waitCountDownLatch(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (!countDownLatch.await((long) (this.config.i() + 1000), TimeUnit.MILLISECONDS)) {
                ParcelableFuture parcelableFuture = this.future;
                if (parcelableFuture != null) {
                    parcelableFuture.cancel(true);
                }
                throw buildRemoteException("wait time out");
            }
        } catch (InterruptedException unused) {
            throw buildRemoteException("thread interrupt");
        }
    }

    @Override // anetwork.channel.aidl.Connection
    public void cancel() throws RemoteException {
        ParcelableFuture parcelableFuture = this.future;
        if (parcelableFuture != null) {
            parcelableFuture.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.Connection
    public Map<String, List<String>> getConnHeadFields() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.header;
    }

    @Override // anetwork.channel.aidl.Connection
    public String getDesc() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.desc;
    }

    @Override // anetwork.channel.aidl.Connection
    public ParcelableInputStream getInputStream() throws RemoteException {
        waitCountDownLatch(this.streamLatch);
        return this.inputStream;
    }

    @Override // anetwork.channel.aidl.Connection
    public StatisticData getStatisticData() {
        return this.statisticData;
    }

    @Override // anetwork.channel.aidl.Connection
    public int getStatusCode() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.statusCode;
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        this.statusCode = networkEvent$FinishEvent.getHttpCode();
        this.desc = networkEvent$FinishEvent.getDesc() != null ? networkEvent$FinishEvent.getDesc() : fe0.b(this.statusCode);
        this.statisticData = networkEvent$FinishEvent.getStatisticData();
        ParcelableInputStreamImpl parcelableInputStreamImpl = this.inputStream;
        if (parcelableInputStreamImpl != null) {
            parcelableInputStreamImpl.writeEnd();
        }
        this.streamLatch.countDown();
        this.statusLatch.countDown();
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream, Object obj) {
        this.inputStream = (ParcelableInputStreamImpl) parcelableInputStream;
        this.streamLatch.countDown();
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
        this.statusCode = i;
        this.desc = fe0.b(i);
        this.header = map;
        this.statusLatch.countDown();
        return false;
    }

    public void setFuture(ParcelableFuture parcelableFuture) {
        this.future = parcelableFuture;
    }

    public ConnectionDelegate(b02 b02) {
        this.config = b02;
    }
}
