package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.mit.IPCMonitor;
import java.util.List;

/* compiled from: Taobao */
public abstract class a implements IChannel {
    /* access modifiers changed from: package-private */
    public abstract Reply a(Callback callback) throws IPCException;

    public final void b(List<String> list) throws IPCException {
        IPCException e;
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(5);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            internalRecycle(list);
            ipcState.q(0);
            e = null;
        } catch (IPCException e2) {
            e = e2;
        }
        if (e != null) {
            ipcState.q(e.getErrorCode());
        }
        ipcState.l(System.currentTimeMillis() - currentTimeMillis);
        ipcState.j();
        if (e != null) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    public final Reply c(Callback callback) throws IPCException {
        Reply reply;
        IPCException e;
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(3);
        long currentTimeMillis = System.currentTimeMillis();
        IPCException iPCException = 0;
        long j = 0;
        try {
            reply = a(callback);
            try {
                ipcState.m(callback.getDataSize());
                ipcState.q(reply.getErrorCode());
                j = reply.getInvokeTime();
                if (reply.isError()) {
                    iPCException = new IPCException(reply.getErrorCode(), reply.getErrorMessage());
                }
            } catch (IPCException e2) {
                e = e2;
                iPCException = reply;
                reply = iPCException;
                iPCException = e;
                if (iPCException != null) {
                }
                ipcState.l((System.currentTimeMillis() - currentTimeMillis) - j);
                ipcState.j();
                if (iPCException == null) {
                }
            }
        } catch (IPCException e3) {
            e = e3;
            reply = iPCException;
            iPCException = e;
            if (iPCException != null) {
            }
            ipcState.l((System.currentTimeMillis() - currentTimeMillis) - j);
            ipcState.j();
            if (iPCException == null) {
            }
        }
        if (iPCException != null) {
            ipcState.q(iPCException.getErrorCode());
        }
        ipcState.l((System.currentTimeMillis() - currentTimeMillis) - j);
        ipcState.j();
        if (iPCException == null) {
            return reply;
        }
        throw iPCException;
    }
}
