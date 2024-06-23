package cn.damai.tetris.component.star;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import cn.damai.commonbusiness.R$id;
import cn.damai.player.video.ProxyVideoView;
import cn.damai.tetris.component.star.TourInfoContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class TourInfoView extends AbsView implements TourInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    ViewGroup kvView;
    private ViewGroup mVideoUi;
    private ProxyVideoView mVideoView;
    ViewGroup nkvView;
    HorizontalScrollView scrollView;

    public TourInfoView(View view) {
        super(view);
        this.kvView = (ViewGroup) view.findViewById(R$id.kv_star_tour_info);
        this.nkvView = (ViewGroup) view.findViewById(R$id.nkv_star_tour_info);
        this.scrollView = (HorizontalScrollView) view.findViewById(R$id.star_tour_info_cities);
        this.mVideoView = (ProxyVideoView) view.findViewById(R$id.kv_star_tour_info_video_v2);
        this.mVideoUi = (ViewGroup) view.findViewById(R$id.kv_star_tour_info_video_ui);
    }

    @Override // cn.damai.tetris.component.star.TourInfoContract.View
    public ViewGroup getKVInfoView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1111269527")) {
            return this.kvView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("1111269527", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.star.TourInfoContract.View
    public ViewGroup getNKVInfoView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "251634899")) {
            return this.nkvView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("251634899", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.star.TourInfoContract.View
    public ViewGroup getTourCityView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1560894497")) {
            return this.scrollView;
        }
        return (ViewGroup) ipChange.ipc$dispatch("1560894497", new Object[]{this});
    }

    @Override // cn.damai.tetris.component.star.TourInfoContract.View
    public ProxyVideoView getVideoView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1431281118")) {
            return this.mVideoView;
        }
        return (ProxyVideoView) ipChange.ipc$dispatch("1431281118", new Object[]{this});
    }
}
