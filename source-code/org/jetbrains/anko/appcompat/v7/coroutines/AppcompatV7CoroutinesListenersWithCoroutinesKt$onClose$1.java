package org.jetbrains.anko.appcompat.v7.coroutines;

import androidx.appcompat.widget.SearchView;
import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.experimental.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.experimental.Job;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onClose"}, k = 3, mv = {1, 1, 11})
/* compiled from: ListenersWithCoroutines.kt */
final class AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1 implements SearchView.OnCloseListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function2 $handler;
    final /* synthetic */ boolean $returnValue;

    AppcompatV7CoroutinesListenersWithCoroutinesKt$onClose$1(CoroutineContext coroutineContext, Function2 function2, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function2;
        this.$returnValue = z;
    }

    @Override // androidx.appcompat.widget.SearchView.OnCloseListener
    public final boolean onClose() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$context, null, null, null, this.$handler, 14, null);
        return this.$returnValue;
    }
}
