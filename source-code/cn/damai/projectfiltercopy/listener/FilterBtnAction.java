package cn.damai.projectfiltercopy.listener;

import cn.damai.projectfiltercopy.bean.Type;

/* compiled from: Taobao */
public interface FilterBtnAction {
    int computeFloatTopPadding(Type type);

    void doBeforeFilterBtnClick(Type type);
}
