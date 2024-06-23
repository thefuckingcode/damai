package cn.damai.tetris.component.rank;

import cn.damai.commonbusiness.search.bean.FollowDataBean;

/* compiled from: Taobao */
public interface OnItemClickListener<T> {
    void onItemClick(T t, int i);

    void onWantSeeClick(T t, int i, FollowDataBean followDataBean);
}
