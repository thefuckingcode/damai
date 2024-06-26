package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.discover.viewholder.ThemeViewHolder;
import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.ThemeContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vk1;

/* compiled from: Taobao */
public class ThemeView extends AbsView<ThemeContract.Presenter> implements ThemeContract.View<ThemeContract.Presenter>, OnItemClickListener<ThemeBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ThemeViewHolder mHolder;

    public ThemeView(View view) {
        super(view);
        this.mHolder = new ThemeViewHolder(view, this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
    public /* synthetic */ void onDnaClick(ThemeBean themeBean, int i) {
        vk1.a(this, themeBean, i);
    }

    public void onEditClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-635697186")) {
            ipChange.ipc$dispatch("-635697186", new Object[]{this, themeBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.ThemeContract.View
    public void setData(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034738705")) {
            ipChange.ipc$dispatch("2034738705", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        this.mHolder.a(themeBean, i);
    }

    public void onItemClick(ThemeBean themeBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570293401")) {
            ipChange.ipc$dispatch("-1570293401", new Object[]{this, themeBean, Integer.valueOf(i)});
            return;
        }
        ThemeContract.Presenter presenter = (ThemeContract.Presenter) getPresenter();
        ThemeViewHolder themeViewHolder = this.mHolder;
        ThemeBean themeBean2 = themeViewHolder.k;
        if (themeBean2 != null && presenter != null) {
            presenter.itemClick(this, themeBean2, themeViewHolder.l);
        }
    }
}
