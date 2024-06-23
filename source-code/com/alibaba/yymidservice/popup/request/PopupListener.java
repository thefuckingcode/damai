package com.alibaba.yymidservice.popup.request;

import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\u0004H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/yymidservice/popup/request/PopupListener;", "", "Lcom/alibaba/yymidservice/popup/request/bean/PopupResponseBean;", "t", "Ltb/ur2;", "onSuccess", "", "code", "msg", "onFail", "clickUpReport", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface PopupListener {
    void clickUpReport();

    void onFail(@Nullable String str, @Nullable String str2);

    void onSuccess(@NotNull PopupResponseBean popupResponseBean);
}
