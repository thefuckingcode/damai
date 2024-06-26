package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.cuser.adapter.CommonFavAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.it2;
import tb.js2;
import tb.v50;
import tb.zq;

/* compiled from: Taobao */
public class FollowProjListHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FollowFeedData a;
        final /* synthetic */ FeedMergeDataDO b;

        a(FollowFeedData followFeedData, FeedMergeDataDO feedMergeDataDO) {
            this.a = followFeedData;
            this.b = feedMergeDataDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1044612126")) {
                ipChange.ipc$dispatch("-1044612126", new Object[]{this, view});
                return;
            }
            FollowFeedData followFeedData = this.a;
            if (followFeedData.viewStatus != 0 || 6 != followFeedData.subBizType) {
                Bundle bundle = new Bundle();
                FollowFeedData followFeedData2 = this.a;
                long j = followFeedData2.havanaId;
                if (j != 0) {
                    FollowProjListHolder followProjListHolder = FollowProjListHolder.this;
                    String valueOf = String.valueOf(j);
                    FollowFeedData followFeedData3 = this.a;
                    followProjListHolder.o(bundle, valueOf, followFeedData3.subBizType, followFeedData3.viewStatus, followFeedData3.schema);
                } else {
                    FollowProjListHolder.this.o(bundle, followFeedData2.bizId, followFeedData2.subBizType, followFeedData2.viewStatus, followFeedData2.schema);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("content_id", this.a.bizId);
                hashMap.put("content_type", this.b.bizType);
                FollowProjListHolder followProjListHolder2 = FollowProjListHolder.this;
                Activity activity = followProjListHolder2.w;
                String str = followProjListHolder2.q;
                it2.f(activity, str, js2.DYNAMIC, "dynamic_" + FollowProjListHolder.this.itemView.getTag(), true, FollowProjListHolder.this.t, hashMap);
            }
        }
    }

    public FollowProjListHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192916374")) {
            ipChange.ipc$dispatch("1192916374", new Object[]{this, feedMergeDataDO});
            return;
        }
        List<FollowFeedData> list = feedMergeDataDO.followData;
        if (list != null) {
            ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).removeAllViews();
            for (int size = list.size() - 1; size >= 0; size--) {
                CommonFavAdapter.ViewHolder c = new CommonFavAdapter(this.w, null).onCreateViewHolder((ViewGroup) this.itemView, 0);
                ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).addView(c.itemView, 0);
                this.itemView.findViewById(R$id.item_scrollview).getLayoutParams().height = v50.a(this.w, 172.0f);
                FollowFeedData followFeedData = list.get(size);
                if (c.a.getTag() instanceof zq) {
                    ((zq) c.a.getTag()).cancel();
                }
                DMImageCreator k = cn.damai.common.image.a.b().c(followFeedData.img).k(new DMRoundedCornersBitmapProcessor(v50.a(this.w, 3.0f), 0));
                int i = R$drawable.uikit_default_image_bg_gradient;
                c.a.setTag(k.i(i).c(i).g(c.a));
                c.a.setOnClickListener(new a(followFeedData, feedMergeDataDO));
                c.b.setText(followFeedData.name);
                if (6 == followFeedData.subBizType && followFeedData.viewStatus == 0) {
                    c.c.setVisibility(0);
                } else {
                    c.c.setVisibility(8);
                }
            }
        }
    }
}
