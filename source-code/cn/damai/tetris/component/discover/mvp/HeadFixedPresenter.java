package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.discover.bean.HeadFixedBean;
import cn.damai.commonbusiness.discover.bean.HeadFixedWrapBean;
import cn.damai.tetris.component.discover.mvp.HeadFixedContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.w9;

/* compiled from: Taobao */
public class HeadFixedPresenter extends BasePresenter<HeadFixedModel, HeadFixedView, BaseSection> implements HeadFixedContract.Presenter<HeadFixedModel, HeadFixedView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public HeadFixedPresenter(HeadFixedView headFixedView, String str, w9 w9Var) {
        super(headFixedView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.discover.mvp.HeadFixedContract.Presenter
    public void exposeItem(View view, HeadFixedBean headFixedBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972654725")) {
            ipChange.ipc$dispatch("-972654725", new Object[]{this, view, headFixedBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "关注");
        f.put("index", "" + i);
        f.put("type", "" + headFixedBean.type);
        a03.h(f, "id", headFixedBean.dispatchTaskId);
        TrackType trackType = TrackType.expose;
        userTrack(trackType, view, "live", "talks", "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.discover.mvp.HeadFixedContract.Presenter
    public void itemClick(HeadFixedBean headFixedBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647221721")) {
            ipChange.ipc$dispatch("-647221721", new Object[]{this, headFixedBean, Integer.valueOf(i)});
            return;
        }
        w9 context = getContext();
        if (context != null && context.getActivity() != null) {
            DMNav.from(context.getActivity()).toUri(headFixedBean.url);
            HashMap<String, String> f = a03.f();
            f.put("titlelabel", "关注");
            f.put("index", "" + i);
            f.put("type", "" + headFixedBean.type);
            f.put("url", headFixedBean.url);
            a03.h(f, "id", headFixedBean.dispatchTaskId);
            TrackType trackType = TrackType.click;
            userTrack(trackType, null, "live", "talks", "item_" + i, f, true);
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1205853647")) {
            ipChange.ipc$dispatch("1205853647", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(HeadFixedModel headFixedModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794389335")) {
            ipChange.ipc$dispatch("-794389335", new Object[]{this, headFixedModel});
            return;
        }
        HeadFixedWrapBean bean = headFixedModel.getBean();
        ((HeadFixedView) getView()).setData(bean, bean.pos);
    }
}
