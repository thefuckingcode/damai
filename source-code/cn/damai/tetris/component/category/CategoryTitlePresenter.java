package cn.damai.tetris.component.category;

import cn.damai.tetris.component.category.CategoryTitleContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class CategoryTitlePresenter extends BasePresenter<CategoryTitleContract.Model, CategoryTitleContract.View, BaseSection> implements CategoryTitleContract.Presenter<CategoryTitleContract.Model, CategoryTitleContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public CategoryTitlePresenter(CategoryTitleView categoryTitleView, String str, w9 w9Var) {
        super(categoryTitleView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-389097748")) {
            ipChange.ipc$dispatch("-389097748", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(CategoryTitleContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324173697")) {
            ipChange.ipc$dispatch("324173697", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        ((CategoryTitleContract.View) getView()).setTip(model.hasCurrentCity(), false);
    }
}
