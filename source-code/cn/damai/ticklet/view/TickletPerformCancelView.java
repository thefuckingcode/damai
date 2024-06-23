package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.lw2;
import tb.rr;
import tb.sl2;
import tb.v50;

/* compiled from: Taobao */
public class TickletPerformCancelView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    TextView action;
    TickletPerformCallBack callback;
    Context context;
    View partent;
    String performId;
    String projectId;
    TextView ticklet_perform_arrow;
    RelativeLayout ticklet_perform_head;
    TextView ticklet_perform_tip;
    String transferBackUrl;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1333330445")) {
                ipChange.ipc$dispatch("-1333330445", new Object[]{this, view});
                return;
            }
            c e = c.e();
            sl2 j = sl2.j();
            TickletPerformCancelView tickletPerformCancelView = TickletPerformCancelView.this;
            e.x(j.n(sl2.TICKLET_DETAIL_PAGE, tickletPerformCancelView.performId, tickletPerformCancelView.projectId, "trans_refund_manage", "open", false));
            if (TickletPerformCancelView.this.ticklet_perform_tip.getVisibility() == 8) {
                TickletPerformCallBack tickletPerformCallBack = TickletPerformCancelView.this.callback;
                if (tickletPerformCallBack != null) {
                    tickletPerformCallBack.performCancel(true);
                }
                TickletPerformCancelView.this.ticklet_perform_tip.setVisibility(0);
                TickletPerformCancelView.this.action.setVisibility(0);
                TickletPerformCancelView.this.ticklet_perform_arrow.setText(R$string.iconfont_xiangxiajiantou_);
                return;
            }
            TickletPerformCancelView.this.close();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "777959924")) {
                ipChange.ipc$dispatch("777959924", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(TickletPerformCancelView.this.transferBackUrl)) {
                c e = c.e();
                sl2 j = sl2.j();
                TickletPerformCancelView tickletPerformCancelView = TickletPerformCancelView.this;
                e.x(j.n(sl2.TICKLET_DETAIL_PAGE, tickletPerformCancelView.performId, tickletPerformCancelView.projectId, "trans_refund_manage", "details", true));
                TickletPerformCancelView.this.close();
                Bundle bundle = new Bundle();
                bundle.putString("url", TickletPerformCancelView.this.transferBackUrl);
                DMNav.from(TickletPerformCancelView.this.context).withExtras(bundle).forResult(1001).toUri(NavUri.b(a.c.d));
            }
        }
    }

    @RequiresApi(api = 11)
    public TickletPerformCancelView(Context context2) {
        this(context2, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404234371")) {
            ipChange.ipc$dispatch("-404234371", new Object[]{this});
            return;
        }
        TickletPerformCallBack tickletPerformCallBack = this.callback;
        if (tickletPerformCallBack != null) {
            tickletPerformCallBack.performCancel(false);
        }
        this.ticklet_perform_tip.setVisibility(8);
        this.action.setVisibility(8);
        this.ticklet_perform_arrow.setText(R$string.iconfont_xiangshangjiantou_);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-850338176")) {
            ipChange.ipc$dispatch("-850338176", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_perform_cancel_layout, this);
        this.partent = inflate;
        this.ticklet_perform_head = (RelativeLayout) inflate.findViewById(R$id.ticklet_perform_head);
        this.ticklet_perform_arrow = (DMIconFontTextView) this.partent.findViewById(R$id.ticklet_perform_arrow);
        this.ticklet_perform_tip = (TextView) this.partent.findViewById(R$id.ticklet_perform_tip);
        this.action = (TextView) this.partent.findViewById(R$id.ticklet_perform_action);
        rr.b(this.ticklet_perform_head, Color.parseColor("#00000000"), v50.a(this.context, 4.0f), Color.parseColor("#1A000000"), v50.a(this.context, 15.0f), 0, v50.a(this.context, 15.0f));
        this.ticklet_perform_arrow.setOnClickListener(new a());
        this.action.setOnClickListener(new b());
        setOnClickListener(null);
    }

    public void setCallback(TickletPerformCallBack tickletPerformCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108701243")) {
            ipChange.ipc$dispatch("-108701243", new Object[]{this, tickletPerformCallBack});
            return;
        }
        this.callback = tickletPerformCallBack;
    }

    public void update(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-924704460")) {
            ipChange.ipc$dispatch("-924704460", new Object[]{this, str, str2, str3, str4});
        } else if (!TextUtils.isEmpty(str)) {
            this.projectId = str4;
            this.performId = str3;
            lw2.E(this.ticklet_perform_tip, str);
            this.ticklet_perform_head.setVisibility(0);
            this.ticklet_perform_arrow.setText(R$string.iconfont_xiangxiajiantou_);
            this.action.setVisibility(0);
            this.transferBackUrl = str2;
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", str4);
            hashMap.put("screening_id", str3);
            c.e().G(this.action, "details", "trans_refund_manage", sl2.TICKLET_DETAIL_PAGE, hashMap);
        }
    }

    @RequiresApi(api = 11)
    public TickletPerformCancelView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    @RequiresApi(api = 11)
    public TickletPerformCancelView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        setGravity(16);
        setOrientation(1);
        setBackgroundResource(R$drawable.ticklet_list_item_bg_top);
        initView();
    }
}
