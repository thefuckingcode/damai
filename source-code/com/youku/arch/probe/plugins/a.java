package com.youku.arch.probe.plugins;

import android.content.BroadcastReceiver;
import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.wireless.IQoeCallBack;
import com.huawei.hms.wireless.IQoeService;
import com.youku.arch.probe.a.b;
import com.youku.arch.probe.plugins.BasePlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class a extends BasePlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String c = "a";
    private volatile com.youku.arch.probe.b.a[] d;
    private volatile AbstractC0257a e;
    private IQoeService f;
    private boolean g;
    private IQoeCallBack h;
    private BroadcastReceiver i;

    /* renamed from: com.youku.arch.probe.plugins.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0257a {
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public com.youku.arch.analysis.net.a a(com.youku.arch.analysis.net.a aVar) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1409726966")) {
            return aVar;
        }
        return (com.youku.arch.analysis.net.a) ipChange.ipc$dispatch("-1409726966", new Object[]{this, aVar});
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991937562")) {
            ipChange.ipc$dispatch("-991937562", new Object[]{this});
            return;
        }
        this.b.unregisterReceiver(this.i);
        this.e = null;
        try {
            com.youku.b.a.a.b("HmsMonitorPlugin", "unRegisterNetQoeCallBack");
            this.f.unRegisterNetQoeCallBack(this.b.getPackageName(), this.h);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.youku.arch.probe.plugins.BasePlugin
    public void a(BasePlugin.NotiType notiType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806431720")) {
            ipChange.ipc$dispatch("-1806431720", new Object[]{this, notiType});
        } else if (this.f == null) {
            com.youku.b.a.a.b("HmsMonitorPlugin", "qoeService is null");
        }
    }

    public int b() {
        com.youku.arch.probe.b.a aVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991907784")) {
            return ((Integer) ipChange.ipc$dispatch("-991907784", new Object[]{this})).intValue();
        } else if (com.youku.arch.probe.a.a.q <= 0) {
            return 0;
        } else {
            int a = b.a(this.b);
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                if (this.d[i3].i >= 0) {
                    if (this.d[i3].i < 2) {
                        if (a == 0 && this.d[i3].d > i2) {
                            aVar = this.d[i3];
                        }
                    } else if (a == 1 && this.d[i3].d > i2) {
                        aVar = this.d[i3];
                    }
                    i2 = aVar.d;
                }
            }
            return i2;
        }
    }

    public Map<String, Integer> c() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "139741145")) {
            return (Map) ipChange.ipc$dispatch("139741145", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        String str = "hmsQoe";
        int i3 = -1;
        if (this.g) {
            int a = b.a(this.b);
            com.youku.arch.probe.b.a aVar = null;
            for (int i4 = 0; i4 < 4; i4++) {
                if (this.d[i4].i >= 0) {
                    if (this.d[i4].i < 2) {
                        if (a == 0 && this.d[i4].d > 0) {
                            aVar = this.d[i4];
                        }
                    } else if (a == 1 && this.d[i4].d > 0) {
                        aVar = this.d[i4];
                    }
                }
            }
            hashMap.put(str, Integer.valueOf(aVar != null ? aVar.h : -1));
            hashMap.put("hmsBw", Integer.valueOf(aVar != null ? aVar.d : -1));
            if (aVar != null) {
                i3 = aVar.b;
            }
            i2 = Integer.valueOf(i3);
            str = "hmsRt";
        } else {
            i2 = -1;
        }
        hashMap.put(str, i2);
        return hashMap;
    }
}
