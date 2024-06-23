package com.taobao.aranger.core.ipc.channel;

import android.app.ActivityThread;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.proxy.RemoteServiceProxy;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ReflectUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.jz0;

/* compiled from: Taobao */
public class QuickRemoteChannel extends b {
    private static final String f = "QuickRemoteChannel";
    private static final Set<String> g = new CopyOnWriteArraySet();
    private final ContentResolver a;
    private final ActivityThread b = ActivityThread.currentActivityThread();
    private final Uri c;
    private final String d;
    private IRemoteService e;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class QuickBinderDeathRecipient implements IBinder.DeathRecipient {
        private final IBinder iBinder;
        private final String processName;

        public QuickBinderDeathRecipient(IBinder iBinder2, String str) {
            this.iBinder = iBinder2;
            this.processName = str;
        }

        public void binderDied() {
            try {
                this.iBinder.unlinkToDeath(this, 0);
                synchronized (QuickRemoteChannel.class) {
                    if (!TextUtils.isEmpty(this.processName) && QuickRemoteChannel.g.contains(this.processName)) {
                        Intent intent = new Intent();
                        intent.setAction(Constants.ACTION_DISCONNECT);
                        intent.putExtra(Constants.PARAM_PROCESS_NAME, this.processName);
                        ARanger.getContext().sendBroadcast(intent);
                        QuickRemoteChannel.g.remove(this.processName);
                    }
                }
            } catch (Exception e) {
                jz0.c(QuickRemoteChannel.f, "[QuickBinderDeathRecipient][binderDied]", e, new Object[0]);
            }
        }
    }

    QuickRemoteChannel(Uri uri) {
        this.c = uri;
        this.d = IPCUtils.getProcessNameFromUri(uri);
        this.a = ARanger.getContext().getContentResolver();
    }

    private IRemoteService i(Uri uri) throws Exception {
        IRemoteService iRemoteService = this.e;
        if (iRemoteService == null || (iRemoteService.isRemote() && !this.e.asBinder().isBinderAlive())) {
            IContentProvider iContentProvider = null;
            try {
                Method hideMethod = ReflectUtils.getHideMethod(ContentResolver.class, Constants.ACQUIRE_UNSTABLE_PROVIDER, Uri.class);
                hideMethod.setAccessible(true);
                iContentProvider = (IContentProvider) hideMethod.invoke(this.a, uri);
            } catch (Exception e2) {
                try {
                    jz0.c(f, "[getRemoteService][acquireUnstableProvider]", e2, new Object[0]);
                } catch (Exception e3) {
                    throw new IPCException(19, e3);
                }
            }
            if (iContentProvider == null) {
                try {
                    String authority = uri.getAuthority();
                    Method hideMethod2 = ReflectUtils.getHideMethod(ContentResolver.class, Constants.ACQUIRE_UNSTABLE_PROVIDER, Context.class, String.class);
                    hideMethod2.setAccessible(true);
                    iContentProvider = (IContentProvider) hideMethod2.invoke(this.a, ARanger.getContext(), authority);
                } catch (Exception e4) {
                    jz0.c(f, "[getRemoteService][acquireUnstableProvider]", e4, new Object[0]);
                }
            }
            if (iContentProvider == null) {
                int i = Build.VERSION.SDK_INT;
                if (i <= 16) {
                    iContentProvider = this.b.acquireProvider(ARanger.getContext(), uri.getAuthority(), false);
                } else if (i < 21) {
                    iContentProvider = this.b.acquireProvider(ARanger.getContext(), uri.getAuthority(), Binder.getCallingUid() / 100000, false);
                } else {
                    iContentProvider = this.b.acquireProvider(ARanger.getContext(), IPCUtils.getAuthorityWithoutUserId(uri.getAuthority()), IPCUtils.getUserIdFromAuthority(uri.getAuthority(), Process.myUserHandle().hashCode()), false);
                }
            }
            if (iContentProvider != null) {
                this.e = RemoteServiceProxy.a(iContentProvider.asBinder());
            } else {
                throw new IPCException(19, "can't get content provider");
            }
        }
        if (this.e.isRemote()) {
            Set<String> set = g;
            if (!set.contains(this.d)) {
                set.add(this.d);
                IBinder asBinder = this.e.asBinder();
                try {
                    asBinder.linkToDeath(new QuickBinderDeathRecipient(asBinder, this.d), 0);
                } catch (RemoteException e5) {
                    jz0.c(f, "[getRemoteService][linkToDeath]", e5, new Object[0]);
                }
            }
        }
        return this.e;
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public void c() throws IPCException {
        try {
            i(this.c).connect();
        } catch (Exception e2) {
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            } else if (e2 instanceof RemoteException) {
                throw new IPCException(1, e2);
            } else {
                throw new IPCException(9, e2);
            }
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public Reply d(Call call) throws IPCException {
        try {
            return i(this.c).sendCall(call);
        } catch (Exception e2) {
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            } else if (e2 instanceof RemoteException) {
                throw new IPCException(1, e2);
            } else {
                throw new IPCException(9, e2);
            }
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        try {
            i(this.c).recycle(list);
        } catch (Exception e2) {
            if (e2 instanceof IPCException) {
                throw ((IPCException) e2);
            } else if (e2 instanceof RemoteException) {
                throw new IPCException(1, e2);
            } else {
                throw new IPCException(9, e2);
            }
        }
    }
}
