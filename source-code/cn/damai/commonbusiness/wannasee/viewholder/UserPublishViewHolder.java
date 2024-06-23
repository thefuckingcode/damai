package cn.damai.commonbusiness.wannasee.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.wannasee.bean.TimeLineStyle;
import cn.damai.im.UserInfoUtil;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.user.userhome.bean.MinepublishCheckBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.yl2;

/* compiled from: Taobao */
public class UserPublishViewHolder extends BaseViewHolder<MinepublishCheckBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private yl2 a = new yl2(this.itemView);
    private final TextView b = ((TextView) this.itemView.findViewById(R$id.id_user_publish_name));
    private MinepublishCheckBean c;
    OnItemBindListener<MinepublishCheckBean> d;

    public UserPublishViewHolder(Context context, ViewGroup viewGroup, OnItemBindListener<MinepublishCheckBean> onItemBindListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_user_center_publish_layout, viewGroup, false));
        this.d = onItemBindListener;
        this.itemView.setOnClickListener(this);
    }

    /* renamed from: c */
    public void a(MinepublishCheckBean minepublishCheckBean, int i) {
        UserData a2;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "812923799")) {
            ipChange.ipc$dispatch("812923799", new Object[]{this, minepublishCheckBean, Integer.valueOf(i)});
            return;
        }
        this.c = minepublishCheckBean;
        yl2 yl2 = this.a;
        if (i != 0) {
            z = false;
        }
        yl2.setTimeStyle(new TimeLineStyle(z, "今天"));
        String str = null;
        if (!(!LoginManager.k().q() || (a2 = UserInfoUtil.a()) == null || a2.getUserBaseInfo() == null)) {
            str = "H i，" + a2.getUserBaseInfo().getNickname();
        }
        if (str == null) {
            str = "H i";
        }
        this.b.setText(str);
    }

    public void onClick(View view) {
        OnItemBindListener<MinepublishCheckBean> onItemBindListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561774865")) {
            ipChange.ipc$dispatch("-561774865", new Object[]{this, view});
            return;
        }
        MinepublishCheckBean minepublishCheckBean = this.c;
        if (minepublishCheckBean != null && (onItemBindListener = this.d) != null) {
            onItemBindListener.onItemClick(minepublishCheckBean, 0);
        }
    }
}
