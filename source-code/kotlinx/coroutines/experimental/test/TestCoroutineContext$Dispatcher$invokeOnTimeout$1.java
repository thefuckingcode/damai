package kotlinx.coroutines.experimental.test;

import kotlin.Metadata;
import kotlinx.coroutines.experimental.DisposableHandle;
import kotlinx.coroutines.experimental.test.TestCoroutineContext;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"kotlinx/coroutines/experimental/test/TestCoroutineContext$Dispatcher$invokeOnTimeout$1", "Lkotlinx/coroutines/experimental/DisposableHandle;", "(Lkotlinx/coroutines/experimental/test/TestCoroutineContext$Dispatcher;Lkotlinx/coroutines/experimental/test/TimedRunnable;)V", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 10})
/* compiled from: TestCoroutineContext.kt */
public final class TestCoroutineContext$Dispatcher$invokeOnTimeout$1 implements DisposableHandle {
    final /* synthetic */ TimedRunnable $node;
    final /* synthetic */ TestCoroutineContext.Dispatcher this$0;

    TestCoroutineContext$Dispatcher$invokeOnTimeout$1(TestCoroutineContext.Dispatcher dispatcher, TimedRunnable timedRunnable) {
        this.this$0 = dispatcher;
        this.$node = timedRunnable;
    }

    @Override // kotlinx.coroutines.experimental.DisposableHandle
    public void dispose() {
        TestCoroutineContext.access$getQueue$p(TestCoroutineContext.this).remove(this.$node);
    }
}
