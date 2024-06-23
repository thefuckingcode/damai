package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.w9;
import tb.zb0;

/* compiled from: Taobao */
public class DramaWorthSeePresenter extends BasePresenter<DramaWorthSeeModel, DramaWorthSeeView, BaseSection> implements DramaWorthSeeContract.Presenter<DramaWorthSeeModel, DramaWorthSeeView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DramaWorthSeePresenter(DramaWorthSeeView dramaWorthSeeView, String str, w9 w9Var) {
        super(dramaWorthSeeView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract.Presenter
    public void expose(View view, DramaV2Bean dramaV2Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1932586539")) {
            ipChange.ipc$dispatch("-1932586539", new Object[]{this, view, dramaV2Bean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        a03.h(f, "repertoire_id", dramaV2Bean.getDramaId());
        userTrackExpose(view, "item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract.Presenter
    public void itemAllClick(DramaWorthSeeContract.View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213312290")) {
            ipChange.ipc$dispatch("-1213312290", new Object[]{this, view, str, Integer.valueOf(i)});
            return;
        }
        userTrackClick("all", a03.f(), true);
        zb0.d(getContext(), str);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaWorthSeeContract.Presenter
    public void itemClick(DramaWorthSeeContract.View view, DramaV2Bean dramaV2Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161769201")) {
            ipChange.ipc$dispatch("-1161769201", new Object[]{this, view, dramaV2Bean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        userTrackClick("item_" + i, f, true);
        zb0.b(getContext(), dramaV2Bean);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270669077")) {
            ipChange.ipc$dispatch("-1270669077", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(DramaWorthSeeModel dramaWorthSeeModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-65608909")) {
            ipChange.ipc$dispatch("-65608909", new Object[]{this, dramaWorthSeeModel});
            return;
        }
        ((DramaWorthSeeView) getView()).setData(dramaWorthSeeModel.getBean(), 0);
    }
}
