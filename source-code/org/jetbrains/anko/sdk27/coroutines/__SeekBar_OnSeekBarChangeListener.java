package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SeekBar;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.experimental.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.experimental.CoroutineScope;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\nH\u0016JK\u0010\u0014\u001a\u00020\f2;\u0010\u0018\u001a7\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J?\u0010\u001a\u001a\u00020\f2/\u0010\u0018\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J?\u0010\u001c\u001a\u00020\f2/\u0010\u0018\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001bRJ\u0010\u0005\u001a9\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0006¢\u0006\u0002\b\u000eX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000fR>\u0010\u0010\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011¢\u0006\u0002\b\u000eX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0012R>\u0010\u0013\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011¢\u0006\u0002\b\u000eX\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\t¨\u0006\u001d"}, d2 = {"Lorg/jetbrains/anko/sdk27/coroutines/__SeekBar_OnSeekBarChangeListener;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;)V", "_onProgressChanged", "Lkotlin/Function5;", "Lkotlinx/coroutines/experimental/CoroutineScope;", "Landroid/widget/SeekBar;", "", "", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function5;", "_onStartTrackingTouch", "Lkotlin/Function3;", "Lkotlin/jvm/functions/Function3;", "_onStopTrackingTouch", "onProgressChanged", "seekBar", NotificationCompat.CATEGORY_PROGRESS, "fromUser", "listener", "(Lkotlin/jvm/functions/Function5;)V", "onStartTrackingTouch", "(Lkotlin/jvm/functions/Function3;)V", "onStopTrackingTouch", "anko-sdk27-coroutines_release"}, k = 1, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
public final class __SeekBar_OnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
    private Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> _onProgressChanged;
    private Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> _onStartTrackingTouch;
    private Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> _onStopTrackingTouch;
    private final CoroutineContext context;

    public __SeekBar_OnSeekBarChangeListener(CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function5 = this._onProgressChanged;
        if (function5 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __SeekBar_OnSeekBarChangeListener$onProgressChanged$1(function5, seekBar, i, z, null), 14, null);
        }
    }

    public final void onProgressChanged(Function5<? super CoroutineScope, ? super SeekBar, ? super Integer, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "listener");
        this._onProgressChanged = function5;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onStartTrackingTouch;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __SeekBar_OnSeekBarChangeListener$onStartTrackingTouch$1(function3, seekBar, null), 14, null);
        }
    }

    public final void onStartTrackingTouch(Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onStartTrackingTouch = function3;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onStopTrackingTouch;
        if (function3 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.context, null, null, null, new __SeekBar_OnSeekBarChangeListener$onStopTrackingTouch$1(function3, seekBar, null), 14, null);
        }
    }

    public final void onStopTrackingTouch(Function3<? super CoroutineScope, ? super SeekBar, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onStopTrackingTouch = function3;
    }
}
