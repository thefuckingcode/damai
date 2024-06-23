package tb;

import android.app.Activity;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
public class w9 implements IContext {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private String b;
    private String c;
    private DinamicXEngine d;
    private IContainer e;

    /* compiled from: Taobao */
    public class a implements IDXNotificationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(w9 w9Var) {
        }

        @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
        public void onNotificationListener(vy vyVar) {
            int i;
            int i2;
            IpChange ipChange = $ipChange;
            int i3 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1761767225")) {
                ipChange.ipc$dispatch("-1761767225", new Object[]{this, vyVar});
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onNotificationListener : failedTemplateItems(");
            List<DXTemplateItem> list = vyVar.b;
            if (list == null) {
                i = 0;
            } else {
                i = list.size();
            }
            sb.append(i);
            sb.append(" finishedTemplateItems(");
            List<DXTemplateItem> list2 = vyVar.a;
            if (list2 == null) {
                i2 = 0;
            } else {
                i2 = list2.size();
            }
            sb.append(i2);
            sb.append(" templateUpdateRequestList(");
            List<w00> list3 = vyVar.c;
            if (list3 != null) {
                i3 = list3.size();
            }
            sb.append(i3);
            n91.a("Tetris.dinamicX", sb.toString());
            List<DXTemplateItem> list4 = vyVar.a;
            if (!(list4 == null || list4.isEmpty())) {
                for (DXTemplateItem dXTemplateItem : vyVar.a) {
                    o80.i(dXTemplateItem);
                }
            }
        }
    }

    public w9() {
        int nextInt = new Random().nextInt();
        this.c = wj2.a(nextInt + "");
    }

    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1993215287")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("1993215287", new Object[]{this});
    }

    public void b(IContainer iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45995096")) {
            ipChange.ipc$dispatch("-45995096", new Object[]{this, iContainer});
            return;
        }
        this.e = iContainer;
    }

    @Override // cn.damai.tetris.core.IContext
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2021924353")) {
            return this.a;
        }
        return (Activity) ipChange.ipc$dispatch("2021924353", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IContext
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "931713002")) {
            return this.e;
        }
        return (IContainer) ipChange.ipc$dispatch("931713002", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IContext
    public DinamicXEngine getDXEngine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1110483161")) {
            return (DinamicXEngine) ipChange.ipc$dispatch("-1110483161", new Object[]{this});
        }
        if (this.d == null) {
            DinamicXEngine dinamicXEngine = new DinamicXEngine(new DXEngineConfig("bizTypeHome"));
            this.d = dinamicXEngine;
            dinamicXEngine.L(new a(this));
        }
        return this.d;
    }

    @Override // cn.damai.tetris.core.IContext
    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1572620196")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("1572620196", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.IContext
    public void setActivity(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109790093")) {
            ipChange.ipc$dispatch("109790093", new Object[]{this, activity});
            return;
        }
        this.a = activity;
    }

    @Override // cn.damai.tetris.core.IContext
    public void setPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624257978")) {
            ipChange.ipc$dispatch("1624257978", new Object[]{this, str});
            return;
        }
        this.b = str;
    }
}
