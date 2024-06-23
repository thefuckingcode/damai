package cn.damai.projectfilter.listener;

import cn.damai.projectfilter.bean.Type;

/* compiled from: Taobao */
public interface FilterBtnAction {
    int computeFloatTopPadding();

    void doBeforeFilterBtnClick(Type type);
}
