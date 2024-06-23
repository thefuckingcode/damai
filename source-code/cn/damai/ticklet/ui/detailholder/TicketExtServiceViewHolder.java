package cn.damai.ticklet.ui.detailholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.ticklet.bean.TicketExtServiceBean;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.lw2;

/* compiled from: Taobao */
public class TicketExtServiceViewHolder extends BaseViewHolder<TicketExtServiceBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View arrowIcon;
    @NotNull
    private final TextView content;
    @NotNull
    private final LinearLayout tipLayout;
    @NotNull
    private final TextView title;
    @NotNull
    private final ImageView titleIcon;
    @NotNull
    private final TextView tvTipContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TicketExtServiceViewHolder(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        View findViewById = view.findViewById(R$id.title);
        k21.h(findViewById, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.title_icon);
        k21.h(findViewById2, "itemView.findViewById(R.id.title_icon)");
        this.titleIcon = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.content);
        k21.h(findViewById3, "itemView.findViewById(R.id.content)");
        this.content = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.right_arrow);
        k21.h(findViewById4, "itemView.findViewById(R.id.right_arrow)");
        this.arrowIcon = findViewById4;
        View findViewById5 = view.findViewById(R$id.service_tip_layout);
        k21.h(findViewById5, "itemView.findViewById(R.id.service_tip_layout)");
        this.tipLayout = (LinearLayout) findViewById5;
        View findViewById6 = view.findViewById(R$id.service_tip_content);
        k21.h(findViewById6, "itemView.findViewById(R.id.service_tip_content)");
        this.tvTipContent = (TextView) findViewById6;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1755109416")) {
            ipChange.ipc$dispatch("1755109416", new Object[]{this, iItem});
            return;
        }
        k21.i(iItem, "item");
        TicketExtServiceBean ticketExtServiceBean = (TicketExtServiceBean) getValue();
        this.title.setText(ticketExtServiceBean.getTitle());
        String iconUrl = ticketExtServiceBean.getIconUrl();
        if (iconUrl == null || iconUrl.length() == 0) {
            this.titleIcon.setVisibility(8);
        } else {
            lw2.s(this.titleIcon, ticketExtServiceBean.getIconUrl(), R$drawable.uikit_default_image_bg_grey);
            this.titleIcon.setVisibility(0);
        }
        Action itemAction = getItemAction();
        if (itemAction != null) {
            String actionUrl = itemAction.getActionUrl();
            if (actionUrl == null || actionUrl.length() == 0) {
                this.arrowIcon.setVisibility(8);
            } else {
                this.arrowIcon.setVisibility(0);
            }
        }
        String note = ticketExtServiceBean.getNote();
        if (note == null || note.length() == 0) {
            this.content.setVisibility(8);
        } else {
            this.content.setVisibility(0);
            this.content.setText(ticketExtServiceBean.getNote());
        }
        String subNote = ticketExtServiceBean.getSubNote();
        if (!(subNote == null || subNote.length() == 0)) {
            z = false;
        }
        if (z) {
            this.tipLayout.setVisibility(8);
            return;
        }
        this.tipLayout.setVisibility(0);
        this.tvTipContent.setText(ticketExtServiceBean.getSubNote());
    }

    @NotNull
    public final View getArrowView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1563617125")) {
            return this.arrowIcon;
        }
        return (View) ipChange.ipc$dispatch("-1563617125", new Object[]{this});
    }
}
