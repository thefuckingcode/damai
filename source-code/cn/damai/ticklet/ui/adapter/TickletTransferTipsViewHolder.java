package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lw2;
import tb.nn2;

/* compiled from: Taobao */
public class TickletTransferTipsViewHolder extends ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.ticklet_transfer_tip_text));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.ticklet_transfer_tip_right_arrow));
    private Activity c;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ nn2 a;

        a(nn2 nn2) {
            this.a = nn2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1052531042")) {
                ipChange.ipc$dispatch("-1052531042", new Object[]{this, view});
            } else if (this.a.e() != null && !TextUtils.isEmpty(this.a.e().getLink())) {
                lw2.f().n(TickletTransferTipsViewHolder.this.c, this.a.e().getLink());
            }
        }
    }

    public TickletTransferTipsViewHolder(Activity activity, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.ticklet_transfer_tips_item, (ViewGroup) null));
        this.c = activity;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void b(nn2 nn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274109249")) {
            ipChange.ipc$dispatch("-274109249", new Object[]{this, nn2});
            return;
        }
        this.a.setText(nn2.b());
        if (!TextUtils.isEmpty(nn2.e().getLink())) {
            a aVar = new a(nn2);
            this.b.setVisibility(0);
            this.a.setOnClickListener(aVar);
            this.b.setOnClickListener(aVar);
            return;
        }
        this.b.setVisibility(8);
    }
}
