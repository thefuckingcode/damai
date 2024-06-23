package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.category.category.utils.BannerImageLoader;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.TimerView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.Banner;
import cn.damai.uikit.banner.listener.OnBannerListener;
import cn.damai.uikit.banner.transformer.DefaultTransformer;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.ScoreStarDigitView;
import com.alibaba.pictures.bricks.component.project.bean.VideoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.u71;
import tb.v50;

/* compiled from: Taobao */
public class VideoStarHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a = this.itemView.getContext();
    private DMPosterView b = ((DMPosterView) this.itemView.findViewById(R$id.poster));
    private Banner c = ((Banner) this.itemView.findViewById(R$id.banner_video));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.tv_name));
    private TextView e = ((TextView) this.itemView.findViewById(R$id.tv_time));
    private TextView f = ((TextView) this.itemView.findViewById(R$id.tv_address));
    private TimerView g = ((TimerView) this.itemView.findViewById(R$id.ll_timer));
    private BannerImageLoader h;
    private ScoreStarDigitView i = ((ScoreStarDigitView) this.itemView.findViewById(cn.damai.commonbusiness.R$id.layout_score));

    /* compiled from: Taobao */
    public class a implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.uikit.banner.listener.OnBannerListener
        public void OnBannerClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "344443763")) {
                ipChange.ipc$dispatch("344443763", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            VideoStarHolder.this.itemView.performClick();
        }
    }

    public VideoStarHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_starvideo_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        a();
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576190250")) {
            ipChange.ipc$dispatch("-576190250", new Object[]{this});
            return;
        }
        this.c.setBannerStyle(1);
        BannerImageLoader bannerImageLoader = new BannerImageLoader();
        this.h = bannerImageLoader;
        this.c.setImageLoader(bannerImageLoader);
        this.c.setImages(new ArrayList());
        this.c.setPageTransformer(true, new DefaultTransformer());
        this.c.setOffscreenPageLimit(5);
        this.c.setImageClipChildren(false);
        this.c.setPageMargin(v50.a(this.a, 0.0f));
        this.c.setViewPagerLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c.isAutoPlay(false);
        this.c.setIndicatorGravity(5);
        this.c.setOnBannerListener(new a());
        this.c.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    public void b(StarAndBrandItem starAndBrandItem, Daojishi daojishi) {
        ProjectItemBean projectItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553936831")) {
            ipChange.ipc$dispatch("553936831", new Object[]{this, starAndBrandItem, daojishi});
            return;
        }
        this.itemView.setVisibility(0);
        if (starAndBrandItem == null || (projectItemBean = starAndBrandItem.projectItemBean) == null || u71.a(projectItemBean.videos) || daojishi == null) {
            this.itemView.setVisibility(8);
            return;
        }
        ProjectItemBean projectItemBean2 = starAndBrandItem.projectItemBean;
        this.b.setImageUrl(projectItemBean2.verticalPic);
        this.b.setCategoryTagName(projectItemBean2.categoryName);
        if (projectItemBean2.isHotProject()) {
            this.b.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
        } else {
            this.b.setLabelType(null);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < projectItemBean2.videos.size(); i2++) {
            VideoBean videoBean = projectItemBean2.videos.get(i2);
            if (videoBean != null && !TextUtils.isEmpty(videoBean.picUrl)) {
                arrayList.add(videoBean.picUrl);
                arrayList2.add(Boolean.valueOf(videoBean.type == 1));
            }
        }
        this.c.updateVideo(arrayList, arrayList2);
        this.d.setText(projectItemBean2.name);
        this.e.setText(!TextUtils.isEmpty(projectItemBean2.showTime) ? projectItemBean2.showTime : "时间待定");
        String str = !TextUtils.isEmpty(projectItemBean2.cityName) ? projectItemBean2.cityName : "城市待定";
        this.f.setText(!TextUtils.isEmpty(projectItemBean2.venueName) ? str + " | " + projectItemBean2.venueName : str + " | 场馆待定");
        this.g.setVisibility(8);
        if (projectItemBean2.isSnapUp()) {
            long j = daojishi.serverTime;
            if (j > 0) {
                long j2 = projectItemBean2.upTime;
                if (j2 > j) {
                    if (((j2 - daojishi.diffTime) - SystemClock.elapsedRealtime()) / 1000 > 0) {
                        this.g.loadTimeData(projectItemBean2.onSaleTime, projectItemBean2.upTime, daojishi.diffTime);
                        this.g.setVisibility(0);
                    } else {
                        this.g.loadTimeData(projectItemBean2.onSaleTime, projectItemBean2.upTime, daojishi.diffTime);
                        this.g.setVisibility(0);
                    }
                    daojishi.stopTimer();
                    daojishi.addTimer(this.g);
                    daojishi.startTimer();
                    this.i.setVisibility(8);
                    if (projectItemBean2.itemStar == -1) {
                        this.i.setVisibility(0);
                        this.i.updateView(projectItemBean2.itemScore, 16);
                        return;
                    }
                    return;
                }
            }
        }
        daojishi.removeTimer(this.g);
        this.i.setVisibility(8);
        if (projectItemBean2.itemStar == -1) {
        }
    }
}
