package com.alibaba.yymidservice.popup.popupcenter.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jr1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0001H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/alibaba/yymidservice/popup/popupcenter/view/PopupViewHandleCallback;", "", "T", "K", "t", "k", "Ltb/jr1;", "popHandle", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface PopupViewHandleCallback {
    @Nullable
    <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super jr1> continuation);
}
