package com.alibaba.yymidservice.popup.popupcenter.view;

import android.app.Activity;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jr1;
import tb.k12;
import tb.k21;
import tb.p30;
import tb.pr1;
import tb.q32;

/* compiled from: Taobao */
public final class MiddlePriortyDefaultHandle extends pr1 {
    @NotNull
    private Activity a;

    public MiddlePriortyDefaultHandle(@NotNull Activity activity) {
        k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
        this.a = activity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super jr1> continuation) {
        MiddlePriortyDefaultHandle$popHandle$1 middlePriortyDefaultHandle$popHandle$1;
        int i;
        jr1 jr1;
        if (continuation instanceof MiddlePriortyDefaultHandle$popHandle$1) {
            middlePriortyDefaultHandle$popHandle$1 = (MiddlePriortyDefaultHandle$popHandle$1) continuation;
            int i2 = middlePriortyDefaultHandle$popHandle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                middlePriortyDefaultHandle$popHandle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = middlePriortyDefaultHandle$popHandle$1.result;
                Object obj2 = b.d();
                i = middlePriortyDefaultHandle$popHandle$1.label;
                jr1 = null;
                if (i != 0) {
                    k12.b(obj);
                    T t2 = t instanceof PopupResponseBean ? t : null;
                    if (t2 != null) {
                        Activity activity = this.a;
                        middlePriortyDefaultHandle$popHandle$1.label = 1;
                        obj = PopupDialogKt.a(activity, t2, middlePriortyDefaultHandle$popHandle$1);
                        if (obj == obj2) {
                            return obj2;
                        }
                    }
                    if (jr1 != null) {
                        return jr1;
                    }
                    middlePriortyDefaultHandle$popHandle$1.L$0 = middlePriortyDefaultHandle$popHandle$1;
                    middlePriortyDefaultHandle$popHandle$1.label = 2;
                    q32 q32 = new q32(IntrinsicsKt__IntrinsicsJvmKt.c(middlePriortyDefaultHandle$popHandle$1));
                    Result.a aVar = Result.Companion;
                    q32.resumeWith(Result.m913constructorimpl(jr1.c.INSTANCE));
                    obj = q32.a();
                    if (obj == b.d()) {
                        p30.c(middlePriortyDefaultHandle$popHandle$1);
                    }
                    if (obj == obj2) {
                        return obj2;
                    }
                    return (jr1) obj;
                } else if (i == 1) {
                    k12.b(obj);
                } else if (i == 2) {
                    MiddlePriortyDefaultHandle$popHandle$1 middlePriortyDefaultHandle$popHandle$12 = (MiddlePriortyDefaultHandle$popHandle$1) middlePriortyDefaultHandle$popHandle$1.L$0;
                    k12.b(obj);
                    return (jr1) obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jr1 = (jr1) obj;
                if (jr1 != null) {
                }
            }
        }
        middlePriortyDefaultHandle$popHandle$1 = new MiddlePriortyDefaultHandle$popHandle$1(this, continuation);
        Object obj3 = middlePriortyDefaultHandle$popHandle$1.result;
        Object obj22 = b.d();
        i = middlePriortyDefaultHandle$popHandle$1.label;
        jr1 = null;
        if (i != 0) {
        }
        jr1 = (jr1) obj3;
        if (jr1 != null) {
        }
    }
}
