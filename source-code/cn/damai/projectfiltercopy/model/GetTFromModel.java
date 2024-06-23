package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.Type;

/* compiled from: Taobao */
public abstract class GetTFromModel<T> {
    public final FilterModel mModel;

    public GetTFromModel(FilterModel filterModel) {
        this.mModel = filterModel;
    }

    public abstract T getT(Type type);
}
