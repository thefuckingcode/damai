package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
public class IPCCallback extends c.a {
    private final Class<? extends IMessageEntity> a;
    private final DatagramTransport.a b;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.a aVar) {
        this.a = cls;
        this.b = aVar;
    }

    @Override // com.huawei.hms.core.aidl.c
    public void call(b bVar) throws RemoteException {
        if (bVar == null || TextUtils.isEmpty(bVar.a)) {
            HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
            throw new RemoteException();
        }
        e a2 = a.a(bVar.c());
        IMessageEntity iMessageEntity = null;
        if (bVar.b() > 0 && (iMessageEntity = newResponseInstance()) != null) {
            a2.a(bVar.a(), iMessageEntity);
        }
        if (bVar.b != null) {
            ResponseHeader responseHeader = new ResponseHeader();
            a2.a(bVar.b, responseHeader);
            this.b.a(responseHeader.getStatusCode(), iMessageEntity);
            return;
        }
        this.b.a(0, iMessageEntity);
    }

    /* access modifiers changed from: protected */
    public IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.a;
        if (cls == null) {
            return null;
        }
        try {
            return (IMessageEntity) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            HMSLog.e("IPCCallback", "In newResponseInstance, instancing exception." + e.getMessage());
            return null;
        }
    }
}
