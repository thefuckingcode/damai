package com.taobao.wireless.security.sdk.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.taobao.wireless.security.sdk.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Taobao */
public class a implements IInitializeComponent {
    private Set<C0233a> a = new HashSet();
    private Object b = new Object();

    /* renamed from: com.taobao.wireless.security.sdk.initialize.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    class C0233a implements IInitializeComponent.IInitFinishListener {
        IInitializeComponent.IInitFinishListener a;

        public C0233a(a aVar, IInitializeComponent.IInitFinishListener iInitFinishListener) {
            this.a = iInitFinishListener;
        }

        @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
        public void onError() {
            this.a.onError();
        }

        @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
        public void onSuccess() {
            this.a.onSuccess();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public int initialize(Context context) {
        try {
            return SecurityGuardManager.getInitializer().initialize(context);
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized void initializeAsync(Context context) {
        SecurityGuardManager.getInitializer().initializeAsync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public boolean isSoValid(Context context) {
        return true;
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized void loadLibraryAsync(Context context) {
        SecurityGuardManager.getInitializer().initializeAsync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void loadLibraryAsync(Context context, String str) {
        try {
            SecurityGuardManager.getInitializer().loadLibraryAsync(context, str);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public synchronized int loadLibrarySync(Context context) {
        try {
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
        return SecurityGuardManager.getInitializer().loadLibrarySync(context);
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public int loadLibrarySync(Context context, String str) {
        try {
            return SecurityGuardManager.getInitializer().loadLibrarySync(context, str);
        } catch (SecException e) {
            e.printStackTrace();
            return 1;
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void registerInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) {
        if (iInitFinishListener != null) {
            C0233a aVar = new C0233a(this, iInitFinishListener);
            synchronized (this.b) {
                this.a.add(aVar);
            }
            try {
                SecurityGuardManager.getInitializer().registerInitFinishListener(aVar);
            } catch (SecException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.taobao.wireless.security.sdk.initialize.IInitializeComponent
    public void unregisterInitFinishListener(IInitializeComponent.IInitFinishListener iInitFinishListener) {
        if (iInitFinishListener != null) {
            C0233a aVar = null;
            synchronized (this.b) {
                Iterator<C0233a> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C0233a next = it.next();
                    if (next.a == iInitFinishListener) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar != null) {
                    this.a.remove(aVar);
                }
            }
            if (aVar != null) {
                try {
                    SecurityGuardManager.getInitializer().unregisterInitFinishListener(aVar);
                } catch (SecException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
