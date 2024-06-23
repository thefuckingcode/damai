package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class jt1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectDataHolder> b = new ArrayList();
    private List<ProjectDataHolder> c = new ArrayList();
    private boolean d;
    private yt1 e = yt1.k(this.a);

    public jt1(Context context) {
        this.a = context;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883611148")) {
            ipChange.ipc$dispatch("1883611148", new Object[]{this});
            return;
        }
        this.c.clear();
    }

    private ProjectDataHolder b(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683389303")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("1683389303", new Object[]{this, Integer.valueOf(i), str});
        }
        if (i != 0) {
            str = "";
        } else if (TextUtils.isEmpty(str)) {
            str = f(R$string.project_title_introduce);
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private String f(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "760231075")) {
            return this.a.getResources().getString(i);
        }
        return (String) ipChange.ipc$dispatch("760231075", new Object[]{this, Integer.valueOf(i)});
    }

    private void g(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993471047")) {
            ipChange.ipc$dispatch("993471047", new Object[]{this, staticData});
        } else if (staticData != null) {
            StaticData.ItemExtendInfo itemExtendInfo = staticData.getItemExtendInfo();
            if (itemExtendInfo == null || TextUtils.isEmpty(itemExtendInfo.getItemExtend())) {
                this.c.clear();
                return;
            }
            List<ProjectDataHolder> i = this.e.i(itemExtendInfo.getItemExtend());
            if (i != null && !i.isEmpty()) {
                this.c.add(b(0, itemExtendInfo.getItemDescTitle()));
                this.c.addAll(i);
            }
        } else {
            this.c.clear();
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1908217908")) {
            ipChange.ipc$dispatch("-1908217908", new Object[]{this});
            return;
        }
        this.b.clear();
        if (xf2.e(this.c) > 0) {
            this.b.addAll(this.c);
        }
    }

    public ProjectDataHolder c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-714595008")) {
            return new ProjectDataHolder(15);
        }
        return (ProjectDataHolder) ipChange.ipc$dispatch("-714595008", new Object[]{this});
    }

    public List<ProjectDataHolder> d(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456028281")) {
            return (List) ipChange.ipc$dispatch("1456028281", new Object[]{this, staticData});
        }
        if (!this.d) {
            a();
            if (staticData != null) {
                g(staticData);
                this.d = true;
            }
        }
        h();
        return this.b;
    }

    public yt1 e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1155074190")) {
            return this.e;
        }
        return (yt1) ipChange.ipc$dispatch("-1155074190", new Object[]{this});
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287228297")) {
            ipChange.ipc$dispatch("287228297", new Object[]{this});
            return;
        }
        this.d = false;
    }
}
