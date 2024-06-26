package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.BigThemeViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.BigThemeContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vk1;

/* compiled from: Taobao */
public class BigThemeView extends AbsView<BigThemeContract.Presenter> implements BigThemeContract.View<BigThemeContract.Presenter>, OnItemClickListener<ThemeBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BigThemeViewHolder mHolder;

    public BigThemeView(View view) {
        super(view);
        this.mHolder = new BigThemeViewHolder(view, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(ThemeBean themeBean, int i) {
        vk1.a(this, themeBean, i);
    }

    public void onEditClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309467404")) {
            ipChange.ipc$dispatch("-1309467404", new Object[]{this, themeBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigThemeContract.View
    public void setData(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794160167")) {
            ipChange.ipc$dispatch("1794160167", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        this.mHolder.a(themeBean, i);
    }

    public void onItemClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050903677")) {
            ipChange.ipc$dispatch("2050903677", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        BigThemeContract.Presenter presenter = (BigThemeContract.Presenter) getPresenter();
        BigThemeViewHolder bigThemeViewHolder = this.mHolder;
        ThemeBean themeBean2 = bigThemeViewHolder.j;
        if (themeBean2 != null && presenter != null) {
            presenter.itemClick(this, themeBean2, bigThemeViewHolder.k);
        }
    }
}
