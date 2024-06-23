package cn.damai.tetris.component.rank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.city.CitySelectActivity;
import cn.damai.commonbusiness.city.bean.CityParam;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.tetris.component.rank.RankEmptyContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.w9;

/* compiled from: Taobao */
public class RankEmptyView extends AbsView<RankEmptyContract.Presenter> implements RankEmptyContract.View<RankEmptyContract.Presenter> {

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            Activity activity;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-871483741")) {
                ipChange.ipc$dispatch("-871483741", new Object[]{this, view});
                return;
            }
            w9 context = RankEmptyView.this.getContext();
            if (context != null && (activity = context.getActivity()) != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CitySelectActivity.OBTAIN_CITY_PARAM, CityParam.onlyObtainCity(d20.d()));
                DMNav.from(activity).withExtras(bundle).forResult(RankSquareCMSActivity.CITY_OBTAIN_REQUEST_CODE).toHost("home_cityselect");
            }
        }
    }

    public RankEmptyView(View view) {
        super(view);
        view.findViewById(R$id.id_tetris_rank_change_city).setOnClickListener(new a());
    }
}
