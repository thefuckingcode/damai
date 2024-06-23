package cn.damai.tetris.component.home.adapter;

import android.view.View;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.core.TrackInfo;
import java.util.List;

/* compiled from: Taobao */
public interface IVideoAdapter {

    /* compiled from: Taobao */
    public interface OnVideoItemClickListener {
        void onBuyClick(int i, String str, String str2, String str3);

        void onItemClick(View view, int i, HomePageVideoBean.HomePageVideoItem homePageVideoItem);

        void onItemReClick(int i, String str, String str2, String str3);
    }

    void reset(boolean z);

    void setData(String str, List<HomePageVideoBean.HomePageVideoItem> list, TrackInfo trackInfo);

    void setOnVideoItemClickListener(OnVideoItemClickListener onVideoItemClickListener);
}
