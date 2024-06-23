package tb;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.StatusNotice;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.OnHeadClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class mg2 extends a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final View e = this.c.findViewById(R$id.notification_ui);
    private final TextView f = ((TextView) this.c.findViewById(R$id.notification_bar_prefix_text_tv));
    private final TextView g = ((TextView) this.c.findViewById(R$id.project_notification_content_tv));
    private final FlowLayout h;
    private final TextView i;
    private final View j;

    public mg2(Activity activity, long j2, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j2, view, onHeadClickListener);
        FlowLayout flowLayout = (FlowLayout) this.c.findViewById(R$id.project_service_flow_layout);
        this.h = flowLayout;
        this.i = (TextView) this.c.findViewById(R$id.project_service_tv);
        this.j = this.c.findViewById(R$id.service_arrow);
        flowLayout.setSingleLine(true);
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1101600047")) {
            return R$id.header_service_etc_ui;
        }
        return ((Integer) ipChange.ipc$dispatch("-1101600047", new Object[]{this})).intValue();
    }

    public void d(ProjectItemDataBean projectItemDataBean, ProjectStaticDataBean projectStaticDataBean) {
        boolean z;
        boolean z2;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "838529519")) {
            ipChange.ipc$dispatch("838529519", new Object[]{this, projectItemDataBean, projectStaticDataBean});
            return;
        }
        StatusNotice j2 = gb.j(projectItemDataBean);
        if (j2 != null) {
            String notice = j2.getNotice();
            String prefixText = j2.getPrefixText();
            z2 = !TextUtils.isEmpty(notice);
            z = j2.isHasPopup();
            this.e.setVisibility(z2 ? 0 : 8);
            this.g.setText(notice);
            c(this.f, prefixText);
        } else {
            z = false;
            z2 = false;
        }
        List<ServiceNote> i3 = gb.i(projectStaticDataBean);
        if (!f92.d(i3)) {
            this.h.removeAllViews();
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            for (ServiceNote serviceNote : i3) {
                View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_service_tag, (ViewGroup) this.h, false);
                TextView textView = (TextView) inflate.findViewById(R$id.service_support);
                TextView textView2 = (TextView) inflate.findViewById(R$id.service_tv);
                if (serviceNote.isSupport()) {
                    textView.setText(b(R$string.iconfont_duihaomian_));
                    textView.setTextColor(Color.parseColor("#8C709BFF"));
                } else {
                    textView.setText(b(R$string.iconfont_guanbiyuan_));
                    textView.setTextColor(Color.parseColor("#8CFE2757"));
                }
                textView2.setText(serviceNote.tagName);
                this.h.addView(inflate);
            }
            z2 = true;
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            z3 = z;
        }
        this.j.setVisibility(z3 ? 0 : 8);
        this.c.setOnClickListener(z3 ? this : null);
        View view = this.c;
        if (!z2) {
            i2 = 8;
        }
        view.setVisibility(i2);
        ln2.r().e2(this.c, String.valueOf(this.b));
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139050646")) {
            ipChange.ipc$dispatch("-139050646", new Object[]{this, view});
            return;
        }
        this.d.onServiceEtcClick();
    }
}
