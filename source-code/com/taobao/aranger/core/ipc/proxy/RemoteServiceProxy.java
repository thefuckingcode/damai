package com.taobao.aranger.core.ipc.proxy;

import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import java.util.List;

/* compiled from: Taobao */
public class RemoteServiceProxy implements IRemoteService {
    private static volatile IRemoteService b;
    private final IBinder a;

    private RemoteServiceProxy(IBinder iBinder) {
        this.a = iBinder;
    }

    public static IRemoteService a(IBinder iBinder) {
        if (iBinder.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null) {
            return new RemoteServiceProxy(iBinder);
        }
        if (b == null) {
            synchronized (RemoteServiceProxy.class) {
                if (b == null) {
                    b = new ARangerProvider();
                }
            }
        }
        return b;
    }

    @Keep
    public IBinder asBinder() {
        return this.a;
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public void connect() throws Exception {
        Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.taobao.aranger.intf.IRemoteService
    public boolean isRemote() {
        return this.a.queryLocalInterface(Constants.DEFAULT_CONTENT_DESCRIPTOR) == null;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) throws Exception {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeStringList(list);
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a  */
    @Override // com.taobao.aranger.intf.IRemoteService
    public Reply sendCall(Call call) throws Exception {
        Throwable th;
        Parcel obtain = Parcel.obtain();
        Parcel parcel = null;
        try {
            Parcel obtain2 = !call.isVoid() ? Parcel.obtain() : null;
            try {
                call.writeToParcel(obtain, 0);
                this.a.transact(0, obtain, obtain2, (!call.isOneWay() || !call.isVoid()) ? 0 : 1);
                if (call.isVoid()) {
                    Reply result = Reply.obtain().setResult(null);
                    obtain.recycle();
                    if (obtain2 != null) {
                        obtain2.recycle();
                    }
                    return result;
                } else if (obtain2 == null || obtain2.dataSize() == 0) {
                    throw new IPCException(34, "reply data decode error from hook remote channel!");
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
    }
}
