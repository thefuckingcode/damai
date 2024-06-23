package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.Response;
import anetwork.channel.aidl.ParcelableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
public class FutureResponse implements Future<Response> {
    private static final String TAG = "anet.FutureResponse";
    private ParcelableFuture delegate;
    private Response response;

    public FutureResponse(ParcelableFuture parcelableFuture) {
        this.delegate = parcelableFuture;
    }

    public boolean cancel(boolean z) {
        ParcelableFuture parcelableFuture = this.delegate;
        if (parcelableFuture == null) {
            return false;
        }
        try {
            return parcelableFuture.cancel(z);
        } catch (RemoteException e) {
            ALog.j(TAG, "[cancel]", null, e, new Object[0]);
            return false;
        }
    }

    public boolean isCancelled() {
        try {
            return this.delegate.isCancelled();
        } catch (RemoteException e) {
            ALog.j(TAG, "[isCancelled]", null, e, new Object[0]);
            return false;
        }
    }

    public boolean isDone() {
        try {
            return this.delegate.isDone();
        } catch (RemoteException e) {
            ALog.j(TAG, "[isDone]", null, e, new Object[0]);
            return true;
        }
    }

    public FutureResponse(Response response2) {
        this.response = response2;
    }

    @Override // java.util.concurrent.Future
    public Response get() throws InterruptedException, ExecutionException {
        Response response2 = this.response;
        if (response2 != null) {
            return response2;
        }
        ParcelableFuture parcelableFuture = this.delegate;
        if (parcelableFuture != null) {
            try {
                return parcelableFuture.get(20000);
            } catch (RemoteException e) {
                ALog.j(TAG, "[get]", null, e, new Object[0]);
            }
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public Response get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Response response2 = this.response;
        if (response2 != null) {
            return response2;
        }
        ParcelableFuture parcelableFuture = this.delegate;
        if (parcelableFuture != null) {
            try {
                return parcelableFuture.get(j);
            } catch (RemoteException e) {
                ALog.j(TAG, "[get(long timeout, TimeUnit unit)]", null, e, new Object[0]);
            }
        }
        return null;
    }
}
