package cn.damai.tetris.component.drama.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.mvp.DramaByMonthContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.Point;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.w9;
import tb.zb0;

/* compiled from: Taobao */
public class DramaByMonthPresenter extends BasePresenter<DramaByMonthModel, DramaByMonthView, BaseSection> implements DramaByMonthContract.Presenter<DramaByMonthModel, DramaByMonthView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DramaByMonthPresenter(DramaByMonthView dramaByMonthView, String str, w9 w9Var) {
        super(dramaByMonthView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.Presenter
    public void exposeDrama(View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76813909")) {
            ipChange.ipc$dispatch("-76813909", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        a03.h(f, "repertoire_id", dramaV1Bean.getDramaId());
        a03.b(f, dramaV1Bean.tempLabelName);
        userTrackExpose(view, "repertoire_item_" + i, f, false);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.Presenter
    public void itemClick(DramaByMonthContract.View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070376638")) {
            ipChange.ipc$dispatch("-2070376638", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        int i2 = dramaV1Bean.tabIndex;
        String trackPointFromModel = getTrackPointFromModel(Point.TRACK_C);
        if (TextUtils.isEmpty(trackPointFromModel)) {
            trackPointFromModel = "coming";
        }
        String trackPointFromModel2 = getTrackPointFromModel(Point.TRACK_B);
        if (TextUtils.isEmpty(trackPointFromModel2)) {
            trackPointFromModel2 = "drama";
        }
        HashMap<String, String> f = a03.f();
        a03.b(f, dramaV1Bean.tempLabelName);
        userTrack(TrackType.click, null, trackPointFromModel2, trackPointFromModel, "repertoire_item_" + dramaV1Bean.indexInTab, f, true);
        zb0.b(getContext(), dramaV1Bean);
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.Presenter
    public void onAllClick(DramaByMonthContract.View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878254835")) {
            ipChange.ipc$dispatch("1878254835", new Object[]{this, view, str});
            return;
        }
        userTrackClick("all", a03.f(), true);
        zb0.d(getContext(), str);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394274333")) {
            ipChange.ipc$dispatch("-1394274333", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.Presenter
    public void onTabClick(DramaByMonthContract.View view, DramaMonthBean dramaMonthBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281300042")) {
            ipChange.ipc$dispatch("1281300042", new Object[]{this, view, dramaMonthBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        a03.b(f, dramaMonthBean.labelName);
        userTrackClick("tab_" + i, f, false);
    }

    public void init(DramaByMonthModel dramaByMonthModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279719041")) {
            ipChange.ipc$dispatch("1279719041", new Object[]{this, dramaByMonthModel});
            return;
        }
        ((DramaByMonthView) getView()).setData(dramaByMonthModel.getBean(), 0);
    }
}
