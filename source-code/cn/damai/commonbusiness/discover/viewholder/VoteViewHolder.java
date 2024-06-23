package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.uikit.tag.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public class VoteViewHolder extends BaseViewHolder<VoteInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private VotePanel a;
    private ImageView b;
    private View c;
    private DMCategroyTagView d;
    private View e;
    private VoteInfoBean f;

    public VoteViewHolder(Context context, ViewGroup viewGroup, VotePanel.VoteActionListener voteActionListener) {
        this(LayoutInflater.from(context).inflate(R$layout.item_feed_vote, viewGroup, false), voteActionListener);
    }

    /* renamed from: c */
    public void a(VoteInfoBean voteInfoBean, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077775665")) {
            ipChange.ipc$dispatch("-1077775665", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        } else if (voteInfoBean != null && this.f != voteInfoBean) {
            this.f = voteInfoBean;
            this.c.setBackground(voteInfoBean.getVoteBgDrawable());
            if (TextUtils.isEmpty(voteInfoBean.activityTag)) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            } else if ("投票".equals(voteInfoBean.activityTag)) {
                this.e.setVisibility(0);
                this.d.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setTagName(voteInfoBean.activityTag);
                this.d.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            }
            String str = voteInfoBean.feedBackground;
            if (TextUtils.isEmpty(str)) {
                this.b.setVisibility(8);
                i2 = n42.a(xs0.a(), 37.0f);
            } else {
                this.b.setVisibility(0);
                int a2 = n42.a(xs0.a(), 82.0f);
                int a3 = n42.a(xs0.a(), 90.0f);
                a.b().f(str, (DisplayMetrics.getwidthPixels(n42.b(xs0.a())) - (n42.a(xs0.a(), 21.0f) * 2)) / 2, a3).g(this.b);
                i2 = a2;
            }
            View i3 = this.a.i();
            ViewGroup.LayoutParams layoutParams = i3.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
                i3.setLayoutParams(layoutParams);
            }
            this.a.d(voteInfoBean, i);
        }
    }

    public VoteViewHolder(View view, VotePanel.VoteActionListener voteActionListener) {
        super(view);
        this.c = view.findViewById(R$id.item_feed_vote_ui);
        this.b = (ImageView) view.findViewById(R$id.item_feed_vote_top_img);
        this.d = (cn.damai.uikit.tag.DMCategroyTagView) view.findViewById(R$id.item_vote_tag);
        this.e = view.findViewById(R$id.item_vote_tag_img);
        this.a = new VotePanel((ViewGroup) view.findViewById(R$id.item_vote_layout_id), voteActionListener);
    }
}
