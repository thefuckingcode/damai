package com.alibaba.yymidservice.popup.popupcenter;

import com.youku.uplayer.AliMediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.alibaba.yymidservice.popup.popupcenter.PopupPriorityManager", f = "PopupPriorityManager.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8}, l = {AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD_UPGEAR_NEED_BUFFER, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED, 169, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SEEK_GEAR_INDEX, 192, 202, 203}, m = "middleHandle", n = {"this", "prePopupResult", "this", "prePopupResult", "detailBean", "this", "prePopupResult", "detailBean", "this", "prePopupResult", "detailBean", "this", "detailBean", "map", "this", "detailBean", "map", "this", "detailBean", "map", "this", "middleResult", "middleResult"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* compiled from: Taobao */
final class PopupPriorityManager$middleHandle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopupPriorityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupPriorityManager$middleHandle$1(PopupPriorityManager popupPriorityManager, Continuation<? super PopupPriorityManager$middleHandle$1> continuation) {
        super(continuation);
        this.this$0 = popupPriorityManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PopupPriorityManager.c(this.this$0, null, this);
    }
}
