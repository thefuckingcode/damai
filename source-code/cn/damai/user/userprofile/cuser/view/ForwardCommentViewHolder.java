package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.p21;
import tb.tb2;
import tb.wz1;
import tb.xf2;

/* compiled from: Taobao */
public class ForwardCommentViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;
    public TextView x;
    public TextView y;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        a(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "874930325")) {
                ipChange.ipc$dispatch("874930325", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(p21.ISSUE_PARAM_COMMENT_ID, this.a.forwardId);
            DMNav.from(ForwardCommentViewHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        b(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1308746602")) {
                ipChange.ipc$dispatch("-1308746602", new Object[]{this, view});
                return;
            }
            DynamicFeedData dynamicFeedData = this.a;
            String str = dynamicFeedData.forwardTargetId;
            if (dynamicFeedData.forwardTargetType.intValue() != 20 && this.a.forwardTargetDataType != 1) {
                Bundle bundle = new Bundle();
                bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                DMNav.from(ForwardCommentViewHolder.this.w).withExtras(bundle).toUri(NavUri.b(wz1.REPERTOITE));
            } else if (this.a.forwardViewStatus == 0) {
                ToastUtil.i("该商品已下架");
            } else {
                Bundle bundle2 = new Bundle();
                try {
                    bundle2.putLong(IssueConstants.ProjectID, Long.parseLong(str));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                tb2.a(ForwardCommentViewHolder.this.w, this.a.schema, bundle2);
            }
        }
    }

    public ForwardCommentViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_content_wrapper);
        this.x = (TextView) view.findViewById(R$id.tv_comment);
        this.v = (NineGridlayout) view.findViewById(R$id.ninelayout);
        TextView textView = (TextView) view.findViewById(R$id.user_feed_fabuquanzi);
        ImageView imageView = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        this.y = (TextView) view.findViewById(R$id.feeds_item_playtitle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ed  */
    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        List<DynamicFeedData> list;
        DynamicFeedData dynamicFeedData;
        View view;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1289838345")) {
            ipChange.ipc$dispatch("1289838345", new Object[]{this, feedMergeDataDO});
        } else if (feedMergeDataDO != null && (list = feedMergeDataDO.dynamicData) != null && list.size() > 0 && (dynamicFeedData = feedMergeDataDO.dynamicData.get(0)) != null) {
            if (!xf2.j(dynamicFeedData.comment)) {
                this.x.setText(dynamicFeedData.comment);
            }
            if (!xf2.j(dynamicFeedData.forwardUserNick)) {
                View view2 = this.itemView;
                int i2 = R$id.tv_comment_text;
                if (view2.findViewById(i2) != null) {
                    this.itemView.findViewById(i2).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i2)).setText(Html.fromHtml(dynamicFeedData.forwardUserNick + ":  <font color='#111111'>" + dynamicFeedData.forwardComment + "</font>"));
                    this.itemView.findViewById(R$id.ll_comment).setOnClickListener(new a(dynamicFeedData));
                    if (dynamicFeedData.requestSuccess.booleanValue() || this.y == null || xf2.j(dynamicFeedData.forwardTargetName)) {
                        view = this.itemView;
                        i = R$id.feeds_item_playicon;
                        if (view.findViewById(i) != null) {
                            this.itemView.findViewById(i).setVisibility(8);
                        }
                        this.y.setText("内容已删除");
                    }
                    View view3 = this.itemView;
                    int i3 = R$id.feeds_item_playicon;
                    if (view3.findViewById(i3) != null) {
                        this.itemView.findViewById(i3).setVisibility(0);
                    }
                    this.y.setText(dynamicFeedData.forwardTargetName);
                    this.y.setOnClickListener(new b(dynamicFeedData));
                    return;
                }
            }
            View view4 = this.itemView;
            int i4 = R$id.tv_comment_text;
            if (view4.findViewById(i4) != null) {
                this.itemView.findViewById(i4).setVisibility(8);
            }
            this.itemView.findViewById(R$id.ll_comment).setOnClickListener(new a(dynamicFeedData));
            if (dynamicFeedData.requestSuccess.booleanValue()) {
            }
            view = this.itemView;
            i = R$id.feeds_item_playicon;
            if (view.findViewById(i) != null) {
            }
            this.y.setText("内容已删除");
        }
    }
}
