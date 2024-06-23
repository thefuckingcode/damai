package cn.damai.ticklet.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.PerformOpModule;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ln2;
import tb.lw2;
import tb.sl2;
import tb.v50;

/* compiled from: Taobao */
public class TickletTicketActionItemView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int contentColorDefault;
    private Context context;
    private DMIconFontTextView iconArrow;
    private ImageView ivIcon;
    private View partent;
    private FrameLayout rlSendNum;
    private TextView tvShareDesc;
    private TextView tv_send_number;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PerformOpModule a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ TicketNftExtAttr e;
        final /* synthetic */ Activity f;
        final /* synthetic */ boolean g;

        a(PerformOpModule performOpModule, String str, String str2, int i, TicketNftExtAttr ticketNftExtAttr, Activity activity, boolean z) {
            this.a = performOpModule;
            this.b = str;
            this.c = str2;
            this.d = i;
            this.e = ticketNftExtAttr;
            this.f = activity;
            this.g = z;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-497994251")) {
                ipChange.ipc$dispatch("-497994251", new Object[]{this, view});
            } else if ("1".equals(this.a.performOpType) || "2".equals(this.a.performOpType)) {
                if ("1".equals(this.a.performOpType)) {
                    c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, ln2.PROJECT_EVALUATE, "evaluatebtn", sl2.j().t(this.b, this.c), Boolean.TRUE));
                } else if ("2".equals(this.a.performOpType)) {
                    c.e().x(b.getInstance().e(sl2.TICKLET_DETAIL_PAGE, ln2.PROJECT_EVALUATE, "viewevaluation", sl2.j().t(this.b, this.c), Boolean.TRUE));
                }
                PerformOpModule.ExtAttr extAttr = this.a.extAttr;
                if (extAttr != null && !TextUtils.isEmpty(extAttr.commentURI)) {
                    DMNav.from(TickletTicketActionItemView.this.context).toUri(this.a.extAttr.commentURI);
                }
            } else if ("5".equals(this.a.performOpType)) {
                c e2 = c.e();
                b instance = b.getInstance();
                e2.x(instance.e(sl2.TICKLET_DETAIL_PAGE, "nft", "skip_to_lingjing_" + this.d, new HashMap(), Boolean.TRUE));
                PerformOpModule.ExtAttr extAttr2 = this.a.extAttr;
                if (extAttr2 != null && !TextUtils.isEmpty(extAttr2.targetUrl)) {
                    DMNav.from(TickletTicketActionItemView.this.context).toUri(this.a.extAttr.targetUrl);
                }
            } else if ("6".equals(this.a.performOpType)) {
                c e3 = c.e();
                b instance2 = b.getInstance();
                e3.x(instance2.e(sl2.TICKLET_DETAIL_PAGE, "nft", "showoff_" + this.d, new HashMap(), Boolean.TRUE));
                if (this.e != null && this.f != null) {
                    lw2 f2 = lw2.f();
                    Activity activity = this.f;
                    TicketNftExtAttr ticketNftExtAttr = this.e;
                    PerformOpModule.ExtAttr extAttr3 = this.a.extAttr;
                    f2.t(view, activity, ticketNftExtAttr, extAttr3.userNick, extAttr3.projectDetailH5Url, this.g);
                }
            }
        }
    }

    public TickletTicketActionItemView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766960002")) {
            ipChange.ipc$dispatch("1766960002", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_action_layout, this);
        this.partent = inflate;
        this.rlSendNum = (FrameLayout) inflate.findViewById(R$id.fr_send_number);
        this.ivIcon = (ImageView) this.partent.findViewById(R$id.ticklet_action_icon);
        this.tvShareDesc = (TextView) this.partent.findViewById(R$id.ticklet_icon_desc);
        this.tv_send_number = (TextView) this.partent.findViewById(R$id.tv_send_number);
        this.iconArrow = (DMIconFontTextView) this.partent.findViewById(R$id.tiklet_action_icon_arrow);
    }

    public void setListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-712807972")) {
            ipChange.ipc$dispatch("-712807972", new Object[]{this, onClickListener});
            return;
        }
        setOnClickListener(onClickListener);
    }

    public void update(String str, int i, int i2, int i3, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-221951602")) {
            ipChange.ipc$dispatch("-221951602", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), onClickListener});
            return;
        }
        if (i != 0) {
            this.tvShareDesc.setTextColor(i);
        } else {
            this.tvShareDesc.setTextColor(this.contentColorDefault);
        }
        this.tvShareDesc.setText(str);
        lw2.D(this.iconArrow, false);
        this.ivIcon.setImageResource(i2);
        if (i3 > 0) {
            lw2.D(this.rlSendNum, true);
            if (i3 > 9) {
                this.tv_send_number.setTextSize(1, 9.0f);
                this.tv_send_number.setText("9+");
            } else {
                this.tv_send_number.setTextSize(1, 10.0f);
                this.tv_send_number.setText(String.valueOf(i3));
            }
        } else {
            lw2.D(this.rlSendNum, false);
        }
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public TickletTicketActionItemView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTicketActionItemView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.contentColorDefault = Color.parseColor("#999999");
        this.context = context2;
        setPadding(10, 0, 10, 0);
        initView();
    }

    public void update(int i, int i2, PerformOpModule performOpModule, int i3, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759214719")) {
            ipChange.ipc$dispatch("1759214719", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), performOpModule, Integer.valueOf(i3), str, str2});
            return;
        }
        update(i, i2, performOpModule, null, i3, str, str2, null, false);
    }

    public void update(int i, int i2, PerformOpModule performOpModule, TicketNftExtAttr ticketNftExtAttr, int i3, String str, String str2, Activity activity, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860292477")) {
            ipChange.ipc$dispatch("1860292477", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), performOpModule, ticketNftExtAttr, Integer.valueOf(i3), str, str2, activity, Boolean.valueOf(z)});
            return;
        }
        if (i2 != 0) {
            this.tvShareDesc.setTextColor(i2);
        } else {
            this.tvShareDesc.setTextColor(this.contentColorDefault);
        }
        this.tvShareDesc.setText(performOpModule.performOpDesc);
        lw2.D(this.iconArrow, false);
        this.ivIcon.setImageResource(i);
        lw2.D(this.rlSendNum, false);
        setOnClickListener(new a(performOpModule, str, str2, i3, ticketNftExtAttr, activity, z));
    }

    public void update(String str, int i, int i2, boolean z, String str2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322457325")) {
            ipChange.ipc$dispatch("-322457325", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str2, onClickListener});
            return;
        }
        this.tvShareDesc.setText(str);
        this.tvShareDesc.setTextSize(1, (float) i);
        lw2.D(this.iconArrow, z);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ivIcon.getLayoutParams();
        float f = (float) i2;
        layoutParams.width = v50.a(this.context, f);
        layoutParams.height = v50.a(this.context, f);
        ImageView imageView = this.ivIcon;
        int i3 = R$drawable.uikit_default_image_bg_grey;
        imageView.setImageResource(i3);
        lw2.D(this.ivIcon, true);
        if (!TextUtils.isEmpty(str2)) {
            lw2.s(this.ivIcon, str2, i3);
        }
        lw2.D(this.rlSendNum, false);
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }
}
