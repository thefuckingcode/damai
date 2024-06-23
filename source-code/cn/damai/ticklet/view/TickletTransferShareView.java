package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.inteface.TickletTransferShareCallback;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TickletTransferShareView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    TickletTransferShareItemView alipay;
    Context context;
    TickletTransferShareItemView damaiPhone;
    private IRecyclerView irc;
    View partent;
    private TextView tvTitle;
    TickletTransferShareItemView weChat;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletTransferShareCallback a;

        a(TickletTransferShareView tickletTransferShareView, TickletTransferShareCallback tickletTransferShareCallback) {
            this.a = tickletTransferShareCallback;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "293390508")) {
                ipChange.ipc$dispatch("293390508", new Object[]{this, view});
                return;
            }
            this.a.weChat();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletTransferShareCallback a;

        b(TickletTransferShareView tickletTransferShareView, TickletTransferShareCallback tickletTransferShareCallback) {
            this.a = tickletTransferShareCallback;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1890286419")) {
                ipChange.ipc$dispatch("-1890286419", new Object[]{this, view});
                return;
            }
            this.a.alipay();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletTransferShareCallback a;

        c(TickletTransferShareView tickletTransferShareView, TickletTransferShareCallback tickletTransferShareCallback) {
            this.a = tickletTransferShareCallback;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "221003950")) {
                ipChange.ipc$dispatch("221003950", new Object[]{this, view});
                return;
            }
            this.a.damaiPhone();
        }
    }

    public TickletTransferShareView(Context context2) {
        this(context2, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1202552903")) {
            ipChange.ipc$dispatch("-1202552903", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_transfer_share_view, this);
        this.partent = inflate;
        this.tvTitle = (TextView) inflate.findViewById(R$id.ticklet_detail_transfer_share_title);
        this.weChat = (TickletTransferShareItemView) this.partent.findViewById(R$id.ticklet_transfer_wechat);
        this.alipay = (TickletTransferShareItemView) this.partent.findViewById(R$id.ticklet_transfer_alipay);
        this.damaiPhone = (TickletTransferShareItemView) this.partent.findViewById(R$id.ticklet_transfer_share_phone);
        this.tvTitle.setText("转送到");
    }

    public void initData(String str, String str2, TickletTransferShareCallback tickletTransferShareCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2025112628")) {
            ipChange.ipc$dispatch("-2025112628", new Object[]{this, str, str2, tickletTransferShareCallback});
            return;
        }
        if ("1".equals(str)) {
            this.weChat.update(true, getResources().getString(R$string.iconfont_weixin), "#62C645", "微信好友", new a(this, tickletTransferShareCallback));
        } else {
            this.weChat.update(false, getResources().getString(R$string.iconfont_weixin), "#6662C645", "微信好友", null);
        }
        if ("1".equals(str2)) {
            this.alipay.update(true, getResources().getString(R$string.iconfont_zhifubao), "#029FE9", "支付宝好友", new b(this, tickletTransferShareCallback));
        } else {
            this.alipay.update(false, getResources().getString(R$string.iconfont_zhifubao), "#66029FE9", "支付宝好友", null);
        }
        this.damaiPhone.update(true, getResources().getString(R$string.iconfont_shouji), "#34C6E8", "手机号码", new c(this, tickletTransferShareCallback));
    }

    public TickletTransferShareView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public TickletTransferShareView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        setGravity(16);
        setGravity(80);
        initView();
    }
}
