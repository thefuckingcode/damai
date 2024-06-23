package cn.damai.projectfilter.listener;

import androidx.annotation.NonNull;
import cn.damai.projectfilter.bean.FilterReqParamBean;

/* compiled from: Taobao */
public interface RequestParamProvider {
    @NonNull
    FilterReqParamBean obtainRequestParam();

    void setParamChangeListener(FilterParamChangeListener filterParamChangeListener);
}
