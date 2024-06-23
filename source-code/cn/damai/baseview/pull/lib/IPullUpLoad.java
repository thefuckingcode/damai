package cn.damai.baseview.pull.lib;

import android.widget.GridView;
import android.widget.ListView;
import cn.damai.baseview.PullScrollView;

/* compiled from: Taobao */
public interface IPullUpLoad {
    void getScrollListener(GridView gridView);

    void getScrollListener(ListView listView);

    void getScrollListener(PullScrollView pullScrollView);
}
