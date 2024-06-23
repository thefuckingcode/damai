package com.uc.webview.export.internal.setup;

import android.util.Pair;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.h5container.H5MainActivity;
import com.ali.user.mobile.ui.WebConstant;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.uc.startup.a;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.p;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public abstract class ax extends l {
    protected bu a;

    /* access modifiers changed from: protected */
    public abstract bu a(bt btVar);

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void a(List<bt> list) {
        int i;
        StringBuilder sb = new StringBuilder("runQuick ucms:");
        sb.append(list == null ? "null" : Integer.valueOf(list.size()));
        Log.i("StandardSetupTask", sb.toString());
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        IWaStat.WaStat.stat(IWaStat.SETUP_UCM_LIST_SIZE, Integer.toString(i));
        if (list == null || list.size() <= 0) {
            throw new UCSetupException(3004, "UCM packages not found, status:" + af.c());
        }
        b(list.get(0));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01f8  */
    public final void b(bt btVar) {
        bu buVar;
        ClassLoader classLoader;
        i.a().a("gk_quick_init", Boolean.TRUE);
        UCSetupException uCSetupException = null;
        try {
            this.mUCM = btVar;
            af.c = btVar;
            b.a(296);
            a(this.mUCM.soDirPath, getOption(UCCore.OPTION_INJECT_LIBRARY_PATH_CALLBACK));
            if (!this.mUCM.quickPathReady()) {
                bu a2 = a(this.mUCM);
                this.a = a2;
                a2.c();
            }
            b.a(297);
            b.a(255);
            af.d();
            bt btVar2 = this.mUCM;
            Pair<String, String> pair = btVar2.coreImplModule;
            if (pair != null) {
                classLoader = af.a((String) pair.first, (String) pair.second, btVar2.soDirPath);
                b.a(H5MainActivity.REQUEST_CORP);
                bu buVar2 = this.a;
                if (buVar2 != null) {
                    ae.b bVar = ae.b.VERIFY_CORE_JAR;
                    synchronized (bu.g) {
                        if (!buVar2.h.isEmpty()) {
                            if (buVar2.h.contains(bVar)) {
                                ae.a().b(bVar);
                            }
                        }
                    }
                }
                b.a(H5MainActivity.REQUEST_REALNAME);
                long d = b.d();
                callback(UCCore.LEGACY_EVENT_SETUP);
                b.a(312, b.d() - d);
                if (isStopped()) {
                    Log.i("StandardSetupTask", "startQuickSetupTransaction process stopped");
                    af.a(af.a.INIT_STOPPED, new Object[0]);
                    buVar = this.a;
                    if (buVar != null) {
                        buVar.e();
                        this.a = null;
                    }
                    if (af.c() != af.a.CORE_ENGINE_INITED && af.c() != af.a.INIT_STOPPED) {
                        if (uCSetupException == null) {
                            uCSetupException = new UCSetupException(3004, "UCM packages not found, status:" + af.c());
                        }
                        SDKFactory.b(getContext());
                        throw uCSetupException;
                    }
                }
            } else {
                classLoader = null;
            }
            b.a(305);
            af.a(af.a.CORE_DEX_LOADED, classLoader);
            b.a(313);
            if (a.b()) {
                ae a3 = ae.a();
                int i = ae.d.a;
                ae.b bVar2 = ae.b.INIT_UCMOBILE_WEBKIT;
                ae a4 = ae.a();
                a4.getClass();
                a3.a(i, bVar2, new ae.a(new ay(this), null), null);
            }
            b.a(306);
            new i().run();
            b.a(WebConstant.OPEN_WEV_H5_BIND_RESPONSE);
            b.a(GridBean.TYPE_VIDEO_UNDER_REVIEW);
            bu buVar3 = this.a;
            if (buVar3 != null) {
                synchronized (bu.g) {
                    if (!buVar3.h.isEmpty()) {
                        Iterator<ae.b> it = buVar3.h.iterator();
                        while (it.hasNext()) {
                            ae.a().b(it.next());
                        }
                    }
                }
            }
            SDKFactory.b(getContext());
            b.a(GridBean.TYPE_VIDEO_COVER);
            j.b();
            long d2 = b.d();
            setLoadedUCM(new UCMRunningInfo(getContext(), this.mUCM, af.e(), this.mUCM.mSdkShellClassLoader, g.a(af.a, this.mUCM, this.mOptions), false, j.a(af.a), SDKFactory.e(), p.a((Boolean) this.mOptions.get(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG)), p.a(p.a((Boolean) this.mOptions.get(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG)))));
            b.a(309, b.d() - d2);
            long d3 = b.d();
            try {
                callback(UCCore.LEGACY_EVENT_INIT);
                callback("switch");
            } catch (UCSetupException e) {
                setException(e);
            } catch (Throwable th) {
                setException(new UCSetupException(4018, th));
            }
            b.a(307, b.d() - d3);
            ae a5 = ae.a();
            int i2 = ae.d.a;
            ae.b bVar3 = ae.b.INIT_SDK_SETTINGS;
            ae a6 = ae.a();
            a6.getClass();
            a5.a(i2, bVar3, new ae.a(new az(this), null), null);
            af.a(af.a.CORE_ENGINE_INITED, new Object[0]);
            b.a(WebConstant.OPEN_WEB_LOGIN_IV_REQCODE);
            b.a(256);
            buVar = this.a;
            if (buVar != null) {
            }
        } catch (UCSetupException e2) {
            bu buVar4 = this.a;
            if (buVar4 != null) {
                buVar4.e();
                this.a = null;
            }
            uCSetupException = e2;
        } catch (Throwable th2) {
            bu buVar5 = this.a;
            if (buVar5 != null) {
                buVar5.e();
                this.a = null;
            }
            throw th2;
        }
        if (af.c() != af.a.CORE_ENGINE_INITED) {
        }
    }
}
