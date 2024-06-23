package cn.damai.tetris.component.live.mvp;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.live.bean.LiveHeaderCardBean;
import cn.damai.tetris.core.AbsView;
import cn.damai.uikit.irecycler.HorizontalRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m42;
import tb.uf2;

/* compiled from: Taobao */
public class BannerView extends AbsView<BannerContract$Presenter> implements BannerContract$View<BannerContract$Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private BannerAdapter mAdapter;
    private HorizontalRecyclerView mBannerView;
    private Context mContext;

    public BannerView(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mBannerView = (HorizontalRecyclerView) view.findViewById(R$id.hrv_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        linearLayoutManager.setOrientation(0);
        this.mBannerView.setLayoutManager(linearLayoutManager);
        BannerAdapter bannerAdapter = new BannerAdapter(this.mContext);
        this.mAdapter = bannerAdapter;
        this.mBannerView.setAdapter(bannerAdapter);
        this.mBannerView.addItemDecoration(new SpaceItemDecoration(m42.a(this.mContext, 6.0f)));
    }

    @Override // cn.damai.tetris.component.live.mvp.BannerContract$View
    public void setData(LiveHeaderCardBean liveHeaderCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604782689")) {
            ipChange.ipc$dispatch("-1604782689", new Object[]{this, liveHeaderCardBean});
        } else if (liveHeaderCardBean == null || uf2.b(liveHeaderCardBean.card) <= 0) {
            this.mBannerView.setVisibility(8);
        } else {
            this.mBannerView.setVisibility(0);
            this.mAdapter.a(liveHeaderCardBean.card, (BannerPresenter) getPresenter());
        }
    }
}
