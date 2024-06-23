package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.v50;
import tb.xs0;

/* compiled from: Taobao */
public class FeedProjectViewHolder extends BaseViewHolder<ProjectItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnItemBindListener<ProjectItemBean> a;
    private DMPosterView b;
    private TextView c;
    private TextView d;
    private View e;
    private TextView f;
    private View g;
    private View h;
    private int i;
    private int j;
    private ProjectItemBean k;
    private int l;

    public FeedProjectViewHolder(View view, OnItemBindListener<ProjectItemBean> onItemBindListener) {
        super(view);
        this.a = onItemBindListener;
        this.b = (DMPosterView) view.findViewById(R$id.feed_project_poster);
        this.c = (TextView) view.findViewById(R$id.feed_project_title);
        this.d = (TextView) view.findViewById(R$id.feed_project_time);
        this.e = view.findViewById(R$id.feed_project_with_price_ui);
        this.f = (TextView) view.findViewById(R$id.feed_project_with_price_tv);
        this.g = view.findViewById(R$id.feed_project_wantsee);
        this.h = view.findViewById(R$id.feed_project_price_pending_ui);
        DMCommonTagView dMCommonTagView = (DMCommonTagView) view.findViewById(R$id.feed_project_tag);
        this.b.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.b.setVideoIconSize(24.0f, 6.0f);
        this.b.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.b.getLabelView();
        if (labelView != null) {
            float a2 = (float) v50.a(xs0.a(), 12.0f);
            labelView.setCornerRadii(a2, a2, a2, 0.0f);
        }
        this.i = n42.a(xs0.a(), 214.0f);
        this.j = n42.a(xs0.a(), 160.0f);
    }

    private boolean d(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592798194")) {
            return ((Boolean) ipChange.ipc$dispatch("-1592798194", new Object[]{this, projectItemBean})).booleanValue();
        }
        String str = projectItemBean.liveStatus;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals("1", str) || TextUtils.equals("2", str)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void a(ProjectItemBean projectItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087775395")) {
            ipChange.ipc$dispatch("1087775395", new Object[]{this, projectItemBean, Integer.valueOf(i2)});
        } else if (projectItemBean != null) {
            this.k = projectItemBean;
            this.l = i2;
            this.b.setImageUrlForWebp(projectItemBean.verticalPic, this.j, this.i);
            this.b.setBorderVisibility(8);
            this.b.setBorderRadius(0);
            this.b.setCategoryTagName(projectItemBean.getCategoryNameCompat());
            if (!d(projectItemBean)) {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (TextUtils.equals("1", projectItemBean.liveStatus)) {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            }
            this.b.setScoreStar(projectItemBean.itemScore);
            this.b.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.c.setText(projectItemBean.name);
            if (!TextUtils.isEmpty(projectItemBean.liveStartTime)) {
                this.d.setText(projectItemBean.liveStartTime);
            } else {
                this.d.setText(projectItemBean.showTime);
            }
            String str = projectItemBean.priceLow;
            if (TextUtils.isEmpty(str) || str.contains("待定")) {
                this.h.setVisibility(0);
                this.e.setVisibility(8);
            } else {
                this.h.setVisibility(8);
                this.e.setVisibility(0);
                this.f.setText(str);
            }
            this.itemView.setOnClickListener(this);
            OnItemBindListener<ProjectItemBean> onItemBindListener = this.a;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(this.itemView, projectItemBean, i2);
            }
        }
    }

    public void onClick(View view) {
        ProjectItemBean projectItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837881831")) {
            ipChange.ipc$dispatch("-1837881831", new Object[]{this, view});
            return;
        }
        OnItemBindListener<ProjectItemBean> onItemBindListener = this.a;
        if (onItemBindListener != null && (projectItemBean = this.k) != null) {
            onItemBindListener.onItemClick(projectItemBean, this.l);
        }
    }
}
