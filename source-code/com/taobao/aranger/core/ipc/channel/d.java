package com.taobao.aranger.core.ipc.channel;

import android.net.Uri;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.exception.IPCException;
import java.util.List;

/* compiled from: Taobao */
public class d extends b {
    static volatile boolean c;
    private final b a;
    private final b b;

    public d(Uri uri) {
        this.a = new DefaultRemoteChannel(uri);
        this.b = new QuickRemoteChannel(uri);
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public void c() throws IPCException {
        if (c) {
            this.a.c();
            return;
        }
        try {
            this.b.c();
        } catch (IPCException e) {
            int errorCode = e.getErrorCode();
            if (errorCode != 1) {
                if (errorCode == 19 || errorCode == 34) {
                    c = true;
                } else {
                    throw e;
                }
            }
            this.a.c();
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public Reply d(Call call) throws IPCException {
        if (c) {
            return this.a.d(call);
        }
        try {
            return this.b.d(call);
        } catch (IPCException e) {
            int errorCode = e.getErrorCode();
            if (errorCode != 1) {
                if (errorCode == 19 || errorCode == 34) {
                    c = true;
                } else {
                    throw e;
                }
            }
            return this.a.d(call);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        if (c) {
            this.a.internalRecycle(list);
            return;
        }
        try {
            this.b.internalRecycle(list);
        } catch (IPCException e) {
            int errorCode = e.getErrorCode();
            if (errorCode != 1) {
                if (errorCode == 19 || errorCode == 34) {
                    c = true;
                } else {
                    throw e;
                }
            }
            this.a.internalRecycle(list);
        }
    }
}
