package com.alibaba.pictures.dolores.business;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.fb0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/dolores/business/FailAction;", "BizResponse", "", "Ltb/fb0;", "failResponse", "Ltb/ur2;", "onFail", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface FailAction<BizResponse> {
    void onFail(@Nullable fb0<BizResponse> fb0);
}
