package cn.damai.discover.main.ui.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.discover.content.view.LiveTopicView;
import cn.damai.discover.content.view.UserInfoView;
import cn.damai.discover.main.bean.FollowRecommendBean;
import cn.damai.discover.main.bean.FollowRelateThemeBean;
import cn.damai.discover.main.bean.FollowUserInfoBean;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.h03;
import tb.m42;
import tb.u80;

/* compiled from: Taobao */
public class PeopleItemHolder extends LiveViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView c = ((TextView) this.b.findViewById(R$id.tv_tip));
    private UserInfoView d = ((UserInfoView) this.b.findViewById(R$id.userinfo_view));
    private TextView e = ((TextView) this.b.findViewById(R$id.btn_follow));
    private TextView f = ((TextView) this.b.findViewById(R$id.tv_desc));
    private View g = this.b.findViewById(R$id.layout_image);
    private View h = this.b.findViewById(R$id.imagelayout_1);
    private View i = this.b.findViewById(R$id.imagelayout_2);
    private View j = this.b.findViewById(R$id.imagelayout_3);
    private RoundImageView k = ((RoundImageView) this.b.findViewById(R$id.image_1));
    private RoundImageView l = ((RoundImageView) this.b.findViewById(R$id.image_2));
    private RoundImageView m = ((RoundImageView) this.b.findViewById(R$id.image_3));
    private ImageView n = ((ImageView) this.b.findViewById(R$id.video1));
    private LiveTopicView o;

    public PeopleItemHolder(View view) {
        super(view);
        ImageView imageView = (ImageView) this.b.findViewById(R$id.video2);
        ImageView imageView2 = (ImageView) this.b.findViewById(R$id.video3);
        this.o = (LiveTopicView) this.b.findViewById(R$id.live_topic_view);
        int a = (DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - m42.a(this.a, 147.0f)) / 3;
        this.h.getLayoutParams().height = a;
        this.i.getLayoutParams().height = a;
        this.j.getLayoutParams().height = a;
    }

    public void a(FollowRecommendBean followRecommendBean, int i2, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971814260")) {
            ipChange.ipc$dispatch("1971814260", new Object[]{this, followRecommendBean, Integer.valueOf(i2), onClickListener});
            return;
        }
        if (i2 == 0) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        this.d.setUserDesc(followRecommendBean.publishTime);
        FollowRelateThemeBean followRelateThemeBean = followRecommendBean.relateTheme;
        if (followRelateThemeBean != null) {
            this.o.setTopicName(followRelateThemeBean.name);
        }
        if (!TextUtils.isEmpty(followRecommendBean.contentText)) {
            this.f.setVisibility(0);
            this.f.setText(followRecommendBean.contentText);
        } else {
            this.f.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        VideoInfo videoInfo = followRecommendBean.videoInfo;
        if (videoInfo != null && !TextUtils.isEmpty(videoInfo.coverUrl)) {
            arrayList.add(followRecommendBean.videoInfo.coverUrl);
        }
        if (!u80.g(followRecommendBean.contentImage)) {
            arrayList.addAll(followRecommendBean.contentImage);
        }
        followRecommendBean.contentImage = arrayList;
        if (!u80.g(arrayList)) {
            this.g.setVisibility(0);
            this.h.setVisibility(4);
            this.i.setVisibility(4);
            this.j.setVisibility(4);
            if (followRecommendBean.contentImage.size() >= 1) {
                this.h.setVisibility(0);
                VideoInfo videoInfo2 = followRecommendBean.videoInfo;
                if (videoInfo2 == null || TextUtils.isEmpty(videoInfo2.coverUrl)) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
                DMImageCreator e2 = a.b().e(followRecommendBean.contentImage.get(0));
                int i3 = R$drawable.live_common_image_default;
                e2.c(i3).g(this.k);
                if (followRecommendBean.contentImage.size() >= 2) {
                    this.i.setVisibility(0);
                    a.b().e(followRecommendBean.contentImage.get(1)).c(i3).g(this.l);
                    if (followRecommendBean.contentImage.size() >= 3) {
                        this.j.setVisibility(0);
                        a.b().e(followRecommendBean.contentImage.get(2)).c(i3).g(this.m);
                    }
                }
            }
        } else {
            this.g.setVisibility(8);
        }
        FollowUserInfoBean followUserInfoBean = followRecommendBean.userInfo;
        if (followUserInfoBean != null) {
            UserInfoView userInfoView = this.d;
            boolean z = followUserInfoBean.vip;
            PerformFilmVipDO performFilmVipDO = followUserInfoBean.performFilmVipDO;
            userInfoView.setVip(z, performFilmVipDO != null ? performFilmVipDO.memberFlag : h03.h());
            this.d.setUserName(followUserInfoBean.nickname);
            this.d.setUserTagType(followUserInfoBean.userTypeCode);
            this.d.setTagName(followUserInfoBean.userTypeText);
            this.d.setAvatarUrl(followUserInfoBean.headImg);
            if (followUserInfoBean.focus) {
                this.e.setText("已关注");
                this.e.setBackgroundResource(R$drawable.live_star_button_follow);
                this.e.setTextColor(this.a.getResources().getColor(R$color.color_999999));
            } else {
                this.e.setText("关注");
                this.e.setBackgroundResource(R$drawable.live_star_button_addfollow);
                this.e.setTextColor(this.a.getResources().getColor(R$color.white));
            }
            this.e.setTag(followRecommendBean.userInfo);
            this.e.setOnClickListener(onClickListener);
        }
    }
}
