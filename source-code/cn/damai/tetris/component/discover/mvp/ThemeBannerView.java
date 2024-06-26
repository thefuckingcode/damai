package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.bean.ThemeBannerBean;
import cn.damai.commonbusiness.discover.bean.ThemeBannerWrapBean;
import cn.damai.commonbusiness.discover.viewholder.ThemeBannerViewHolder;
import cn.damai.tetris.component.discover.mvp.ThemeBannerContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ThemeBannerView extends AbsView<ThemeBannerContract.Presenter> implements ThemeBannerContract.View<ThemeBannerContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ThemeBannerViewHolder mViewHolder;

    /* compiled from: Taobao */
    public class a implements OnItemBindListener<ThemeBannerBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void exposeItem(View view, ThemeBannerBean themeBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "467544883")) {
                ipChange.ipc$dispatch("467544883", new Object[]{this, view, themeBannerBean, Integer.valueOf(i)});
                return;
            }
            ThemeBannerContract.Presenter presenter = (ThemeBannerContract.Presenter) ThemeBannerView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeItem(view, themeBannerBean, i);
            }
        }

        /* renamed from: b */
        public void onItemClick(ThemeBannerBean themeBannerBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1423750050")) {
                ipChange.ipc$dispatch("-1423750050", new Object[]{this, themeBannerBean, Integer.valueOf(i)});
                return;
            }
            ThemeBannerContract.Presenter presenter = (ThemeBannerContract.Presenter) ThemeBannerView.this.getPresenter();
            if (presenter != null) {
                presenter.itemClick(themeBannerBean, i);
            }
        }
    }

    public ThemeBannerView(View view) {
        super(view);
        this.mViewHolder = new ThemeBannerViewHolder(view, new a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.ThemeBannerContract.View
    public void setData(ThemeBannerWrapBean themeBannerWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1909990369")) {
            ipChange.ipc$dispatch("-1909990369", new Object[]{this, themeBannerWrapBean, Integer.valueOf(i)});
        } else if (themeBannerWrapBean != null) {
            this.mViewHolder.a(themeBannerWrapBean, i);
        }
    }
}
