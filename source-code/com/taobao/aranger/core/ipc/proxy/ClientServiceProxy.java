package com.taobao.aranger.core.ipc.proxy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import java.util.List;

/* compiled from: Taobao */
public class ClientServiceProxy extends Binder implements IClientService {
    private final IBinder mRemote;

    private ClientServiceProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public static IClientService getProxy(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(Constants.CLIENT_SERVICE_DESCRIPTOR);
        if (queryLocalInterface instanceof IClientService) {
            return (IClientService) queryLocalInterface;
        }
        return new ClientServiceProxy(iBinder);
    }

    @Keep
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        if (this.mRemote.isBinderAlive()) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeStringList(list);
                this.mRemote.transact(4, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        } else {
            throw new IPCException(5, "the remote binder is not alive");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    @Override // com.taobao.aranger.intf.IClientService
    public Reply sendCallback(Callback callback) throws Exception {
        Throwable th;
        if (this.mRemote.isBinderAlive()) {
            Parcel obtain = Parcel.obtain();
            Parcel parcel = null;
            try {
                Parcel obtain2 = !callback.isVoid() ? Parcel.obtain() : null;
                int i = 0;
                try {
                    callback.writeToParcel(obtain, 0);
                    IBinder iBinder = this.mRemote;
                    if (callback.isOneWay() && callback.isVoid()) {
                        i = 1;
                    }
                    iBinder.transact(3, obtain, obtain2, i);
                    if (callback.isVoid()) {
                        Reply result = Reply.obtain().setResult(null);
                        obtain.recycle();
                        if (obtain2 != null) {
                            obtain2.recycle();
                        }
                        return result;
                    } else if (obtain2 == null || obtain2.dataSize() == 0) {
                        throw new IPCException(33, "reply data decode error from client channel!");
                    } else {
                        Reply createFromParcel = Reply.CREATOR.createFromParcel(obtain2);
                        obtain.recycle();
                        obtain2.recycle();
                        return createFromParcel;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcel = obtain2;
                    obtain.recycle();
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                obtain.recycle();
                if (parcel != null) {
                }
                throw th;
            }
        } else {
            throw new IPCException(5, "the remote binder is not alive");
        }
    }
}
