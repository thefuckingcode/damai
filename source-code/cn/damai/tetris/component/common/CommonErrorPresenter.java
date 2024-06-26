package cn.damai.tetris.component.common;

import android.view.ViewGroup;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.tetris.component.common.CommonErrorContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class CommonErrorPresenter extends BasePresenter<CommonErrorContract.Model, CommonErrorContract.View, BaseSection> implements CommonErrorContract.Presenter<CommonErrorContract.Model, CommonErrorContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public CommonErrorPresenter(CommonErrorView commonErrorView, String str, w9 w9Var) {
        super(commonErrorView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077052836")) {
            ipChange.ipc$dispatch("-2077052836", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(CommonErrorContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606607007")) {
            ipChange.ipc$dispatch("-1606607007", new Object[]{this, model});
            return;
        }
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(getContext().getActivity(), 3, model.getCode(), model.getMsg(), (String) null);
        responseErrorPage.setLeftBtnVisibility(8);
        ((ViewGroup) ((CommonErrorContract.View) getView()).getRootView()).addView(responseErrorPage);
    }
}
