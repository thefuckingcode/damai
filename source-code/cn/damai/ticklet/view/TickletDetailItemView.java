package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletDetailCompViewBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lw2;
import tb.v50;

/* compiled from: Taobao */
public class TickletDetailItemView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View parent;
    private LinearLayout ticklet_detail_item_layout;
    private TextView ticklet_detail_item_tip;
    private TextView ticklet_detail_item_title;
    private TextView ticklet_detail_second_title;
    private ImageView ticklet_item_image;
    private ImageView ticklet_item_title_icon;
    private DMIconFontTextView tiklet_detail_item_icon;

    public TickletDetailItemView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-303707855")) {
            ipChange.ipc$dispatch("-303707855", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_item_view, this);
        this.parent = inflate;
        this.ticklet_detail_item_layout = (LinearLayout) inflate.findViewById(R$id.ticklet_detail_item_layout);
        this.ticklet_detail_item_title = (TextView) this.parent.findViewById(R$id.ticklet_detail_item_title);
        this.ticklet_item_title_icon = (ImageView) this.parent.findViewById(R$id.ticklet_item_title_icon);
        this.ticklet_item_image = (ImageView) this.parent.findViewById(R$id.ticklet_item_image);
        this.tiklet_detail_item_icon = (DMIconFontTextView) this.parent.findViewById(R$id.tiklet_detail_item_icon_arrow);
        this.ticklet_detail_item_tip = (TextView) this.parent.findViewById(R$id.ticklet_detail_item_tip);
        this.ticklet_detail_second_title = (TextView) this.parent.findViewById(R$id.ticklet_detail_second_title);
    }

    public void update(TickletDetailCompViewBean.BizData bizData, boolean z, boolean z2, View.OnClickListener onClickListener) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036123118")) {
            ipChange.ipc$dispatch("2036123118", new Object[]{this, bizData, Boolean.valueOf(z), Boolean.valueOf(z2), onClickListener});
        } else if (bizData != null) {
            if (z) {
                i = v50.a(this.context, 5.0f);
            } else {
                i = v50.a(this.context, 21.0f);
            }
            if (z2) {
                i2 = v50.a(this.context, 5.0f);
            } else {
                i2 = v50.a(this.context, 21.0f);
            }
            setPadding(0, i, 0, i2);
            lw2.E(this.ticklet_detail_item_title, bizData.title);
            lw2.E(this.ticklet_detail_item_tip, bizData.note);
            if (!TextUtils.isEmpty(bizData.iconUrl)) {
                lw2.s(this.ticklet_item_title_icon, bizData.iconUrl, R$drawable.uikit_default_image_bg_grey);
                this.ticklet_item_title_icon.setVisibility(0);
            } else {
                this.ticklet_item_title_icon.setVisibility(8);
            }
            if (onClickListener != null) {
                setOnClickListener(onClickListener);
                this.tiklet_detail_item_icon.setVisibility(0);
                return;
            }
            setOnClickListener(null);
            this.tiklet_detail_item_icon.setVisibility(8);
        }
    }

    public TickletDetailItemView(Context context2, @Nullable AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletDetailItemView(Context context2, @Nullable AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        setMinimumHeight(v50.a(context2, 54.0f));
        initView();
    }

    public void update(Object obj, boolean z, boolean z2, View.OnClickListener onClickListener) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "817473216")) {
            ipChange.ipc$dispatch("817473216", new Object[]{this, obj, Boolean.valueOf(z), Boolean.valueOf(z2), onClickListener});
        } else if (obj != null) {
            TickletDetailCompViewBean tickletDetailCompViewBean = (TickletDetailCompViewBean) obj;
            if (z) {
                i = v50.a(this.context, 5.0f);
            } else {
                i = v50.a(this.context, 21.0f);
            }
            if (z2) {
                i2 = v50.a(this.context, 5.0f);
            } else {
                i2 = v50.a(this.context, 21.0f);
            }
            setPadding(0, i, 0, i2);
            lw2.E(this.ticklet_detail_item_title, tickletDetailCompViewBean.title);
            lw2.E(this.ticklet_detail_item_tip, tickletDetailCompViewBean.note);
            TickletDetailCompViewBean.BizData bizData = tickletDetailCompViewBean.bizData;
            if (bizData == null || TextUtils.isEmpty(bizData.iconUrl)) {
                this.ticklet_item_title_icon.setVisibility(8);
            } else {
                lw2.s(this.ticklet_item_title_icon, tickletDetailCompViewBean.bizData.iconUrl, R$drawable.uikit_default_image_bg_grey);
                this.ticklet_item_title_icon.setVisibility(0);
            }
            if (TickletDetailCompViewBean.SERVICE_RESOURCE.equals(tickletDetailCompViewBean.key)) {
                this.ticklet_detail_second_title.setVisibility(0);
                this.ticklet_detail_second_title.setText(this.context.getString(R$string.ticklet_custom_service_tip));
            } else {
                this.ticklet_detail_second_title.setVisibility(8);
            }
            TickletDetailCompViewBean.BizData bizData2 = tickletDetailCompViewBean.bizData;
            if (bizData2 == null || TextUtils.isEmpty(bizData2.picUrl)) {
                this.ticklet_item_image.setVisibility(8);
            } else {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ticklet_item_image.getLayoutParams();
                layoutParams.height = v50.a(this.context, 68.0f);
                if (TickletDetailCompViewBean.VENUE_GUIDE_MAIN.equals(tickletDetailCompViewBean.key)) {
                    layoutParams.height = v50.a(this.context, 113.0f);
                }
                this.ticklet_item_image.setVisibility(0);
                lw2.q(this.context, this.ticklet_item_image, tickletDetailCompViewBean.bizData.picUrl, R$drawable.uikit_default_image_bg_grey);
            }
            if (!tickletDetailCompViewBean.isNoAllowGoto()) {
                this.tiklet_detail_item_icon.setVisibility(0);
                if (onClickListener != null) {
                    setOnClickListener(onClickListener);
                } else {
                    setOnClickListener(null);
                }
            } else {
                setOnClickListener(null);
                this.tiklet_detail_item_icon.setVisibility(8);
            }
        }
    }
}
