package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.cuser.adapter.CommonFollowAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cq;
import tb.d20;
import tb.it2;
import tb.js2;
import tb.v50;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class FollowUserListHolder extends FeedsWraperHolder {
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
            if (AndroidInstantRuntime.support(ipChange, "-293185712")) {
                ipChange.ipc$dispatch("-293185712", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            FollowFeedData followFeedData = this.a;
            long j = followFeedData.havanaId;
            if (j != 0) {
                FollowUserListHolder followUserListHolder = FollowUserListHolder.this;
                String valueOf = String.valueOf(j);
                FollowFeedData followFeedData2 = this.a;
                followUserListHolder.o(bundle, valueOf, followFeedData2.subBizType, followFeedData2.viewStatus, followFeedData2.schema);
            } else {
                FollowUserListHolder.this.o(bundle, followFeedData.bizId, followFeedData.subBizType, followFeedData.viewStatus, followFeedData.schema);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("content_id", this.a.bizId);
            hashMap.put("content_type", this.b.bizType);
            FollowUserListHolder followUserListHolder2 = FollowUserListHolder.this;
            Activity activity = followUserListHolder2.w;
            String str = followUserListHolder2.q;
            it2.f(activity, str, js2.DYNAMIC, "dynamic_" + FollowUserListHolder.this.itemView.getTag(), true, FollowUserListHolder.this.t, hashMap);
        }
    }

    public FollowUserListHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-847700860")) {
            ipChange.ipc$dispatch("-847700860", new Object[]{this, feedMergeDataDO});
            return;
        }
        List<FollowFeedData> list = feedMergeDataDO.followData;
        if (list != null) {
            ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).removeAllViews();
            for (int size = list.size() - 1; size >= 0; size--) {
                CommonFollowAdapter.ViewHolder d = new CommonFollowAdapter(this.w, null).onCreateViewHolder((ViewGroup) this.itemView, 0);
                ((ViewGroup) this.itemView.findViewById(R$id.item_parent)).addView(d.itemView);
                View view = this.itemView;
                int i = R$id.item_scrollview;
                ViewGroup.LayoutParams layoutParams = view.findViewById(i).getLayoutParams();
                if (this.t) {
                    layoutParams.height = v50.a(this.w, 112.0f);
                } else {
                    layoutParams.height = v50.a(this.w, 154.0f);
                }
                this.itemView.findViewById(i).setLayoutParams(layoutParams);
                FollowFeedData followFeedData = list.get(size);
                if (d.a.getTag() instanceof zq) {
                    ((zq) d.a.getTag()).cancel();
                }
                new cq((float) v50.a(this.w, 2.0f), this.w.getResources().getColor(R$color.color_6black));
                d.a.setAvatar(followFeedData.img + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                d.a.setOnClickListener(new a(followFeedData, feedMergeDataDO));
                d.b.setText(followFeedData.name);
                if (followFeedData.vtag != 0) {
                    d.a.setAvatarVTagVisibility(0);
                } else {
                    d.a.setAvatarVTagVisibility(8);
                }
                if (followFeedData.vip) {
                    d.a.setAvatarCrownVisibility(0);
                    d.a.setAvatarBorderVisibility(0);
                } else {
                    d.a.setAvatarCrownVisibility(8);
                    d.a.setAvatarBorderVisibility(8);
                }
                if (this.t || xf2.j(followFeedData.bizId) || followFeedData.bizId.equals(d20.E())) {
                    d.c.setVisibility(8);
                } else {
                    d.c.setVisibility(0);
                    d.c.setState(followFeedData.followStatus);
                    Log.d("usertag", " type : " + followFeedData.subBizType + " , id : " + followFeedData.bizId);
                    long j = followFeedData.havanaId;
                    if (j != 0) {
                        d.c.setInitParams(String.valueOf(j), followFeedData.subBizType + "");
                    } else {
                        d.c.setInitParams(followFeedData.bizId, followFeedData.subBizType + "");
                    }
                }
            }
        }
    }
}
