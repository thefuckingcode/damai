package com.taobao.aranger.core.ipc.channel;

import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.mit.IPCMonitor;
import java.util.List;

/* compiled from: Taobao */
public abstract class b implements IChannel {
    private void a(IPCMonitor.IpcState ipcState, IPCException iPCException, long j, long j2) throws IPCException {
        ipcState.q(iPCException != null ? iPCException.getErrorCode() : 0);
        ipcState.n(d.c);
        ipcState.l(System.currentTimeMillis() - (j + j2));
        ipcState.o(j2);
        ipcState.j();
        if (iPCException != null) {
            throw iPCException;
        }
    }

    public final void b() throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(6);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            c();
            e = null;
        } catch (IPCException e) {
            e = e;
        }
        a(ipcState, e, currentTimeMillis, 0);
    }

    /* access modifiers changed from: package-private */
    public abstract void c() throws IPCException;

    /* access modifiers changed from: package-private */
    public abstract Reply d(Call call) throws IPCException;

    public final void e(List<String> list) throws IPCException {
        IPCMonitor.IpcState ipcState = new IPCMonitor.IpcState(4);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            internalRecycle(list);
            e = null;
        } catch (IPCException e) {
            e = e;
        }
        a(ipcState, e, currentTimeMillis, 0);
    }

    public final Reply f(Call call) throws IPCException {
        IPCMonitor.IpcState ipcState;
        Reply reply;
        long j;
        IPCException iPCException;
        IPCException e;
        int type = call.getServiceWrapper().getType();
        if (type == 0) {
            ipcState = new IPCMonitor.IpcState(0);
        } else if (type != 1) {
            ipcState = new IPCMonitor.IpcState(2);
            ipcState.p(call.getMethodWrapper().getName());
        } else {
            ipcState = new IPCMonitor.IpcState(1);
            ipcState.p(call.getMethodWrapper().getName());
        }
        ipcState.r(call.getServiceWrapper().getName());
        long currentTimeMillis = System.currentTimeMillis();
        IPCException iPCException2 = null;
        try {
            Reply d = d(call);
            try {
                ipcState.m(call.getDataSize());
                long invokeTime = d.getInvokeTime();
                if (d.isError()) {
                    iPCException2 = new IPCException(d.getErrorCode(), d.getErrorMessage());
                }
                j = invokeTime;
                reply = d;
                iPCException = iPCException2;
            } catch (IPCException e2) {
                e = e2;
                iPCException2 = d;
                iPCException = e;
                j = 0;
                reply = iPCException2;
                a(ipcState, iPCException, currentTimeMillis, j);
                return reply;
            }
        } catch (IPCException e3) {
            e = e3;
            iPCException = e;
            j = 0;
            reply = iPCException2;
            a(ipcState, iPCException, currentTimeMillis, j);
            return reply;
        }
        a(ipcState, iPCException, currentTimeMillis, j);
        return reply;
    }
}
