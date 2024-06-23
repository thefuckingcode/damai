package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.el2;
import tb.ln2;
import tb.xf2;

/* compiled from: Taobao */
public class TicketGuidePreInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView a = ((DMIconFontTextView) this.itemView.findViewById(R$id.icon_guide));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.tv_guide_name));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.tv_guide_desc));
    private LinearLayout d = ((LinearLayout) this.itemView.findViewById(R$id.ll_button));
    private DMIconFontTextView e = ((DMIconFontTextView) this.itemView.findViewById(R$id.icon_button_text));
    private TextView f = ((TextView) this.itemView.findViewById(R$id.tv_button_text));
    private TableLayout g = ((TableLayout) this.itemView.findViewById(R$id.ticket_guide_row));
    private Context h;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1954133771")) {
                ipChange.ipc$dispatch("1954133771", new Object[]{this, view});
                return;
            }
            c.e().x(ln2.r().w2(this.a));
            Bundle bundle = new Bundle();
            bundle.putBoolean("visEmail", this.b);
            bundle.putString("projectId", this.a);
            DMNav.from(TicketGuidePreInfoViewHolder.this.h).withExtras(bundle).toUri(NavUri.b("ticket_strategy_prefill"));
        }
    }

    public TicketGuidePreInfoViewHolder(Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.layout_ticket_guide_pre_info, (ViewGroup) null, false));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.h = context;
    }

    private void c(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589350801")) {
            ipChange.ipc$dispatch("1589350801", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundResource(R$drawable.bg_ticket_guide_btn);
        this.e.setVisibility(8);
        this.f.setTextColor(ContextCompat.getColor(this.h, R$color.white));
        this.f.setText("填写");
        this.f.setOnClickListener(new a(str, z));
    }

    private void d(List<String> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-704914063")) {
            ipChange.ipc$dispatch("-704914063", new Object[]{this, list});
            return;
        }
        int e2 = xf2.e(list);
        this.g.removeAllViews();
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-1, -2);
        while (i < e2) {
            View inflate = LayoutInflater.from(this.h).inflate(R$layout.layout_ticket_guide_text, (ViewGroup) null);
            inflate.setLayoutParams(layoutParams);
            int i2 = i + 1;
            ((TextView) inflate.findViewById(R$id.tv_ticket_guide_pos)).setText(String.valueOf(i2));
            ((TextView) inflate.findViewById(R$id.tv_ticket_guide_desc)).setText(list.get(i));
            TableLayout tableLayout = this.g;
            if (tableLayout != null) {
                tableLayout.addView(inflate);
            }
            i = i2;
        }
    }

    public void b(ProjectTickGuidePreBean projectTickGuidePreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-403932998")) {
            ipChange.ipc$dispatch("-403932998", new Object[]{this, projectTickGuidePreBean});
        } else if (projectTickGuidePreBean != null) {
            this.a.setText(el2.b().d(projectTickGuidePreBean.name));
            this.b.setText(projectTickGuidePreBean.title);
            this.c.setText(projectTickGuidePreBean.desc);
            c(projectTickGuidePreBean.visEmail, projectTickGuidePreBean.projectId);
            d(projectTickGuidePreBean.preFillCheckList);
        }
    }
}
