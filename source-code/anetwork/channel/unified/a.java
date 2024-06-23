package anetwork.channel.unified;

import anetwork.channel.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class a implements Future<Response> {
    private UnifiedRequestTask a;
    private boolean b;

    public a(UnifiedRequestTask unifiedRequestTask) {
        this.a = unifiedRequestTask;
    }

    /* renamed from: a */
    public Response get() throws InterruptedException, ExecutionException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    /* renamed from: b */
    public Response get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public boolean cancel(boolean z) {
        if (!this.b) {
            this.a.c();
            this.b = true;
        }
        return true;
    }

    public boolean isCancelled() {
        return this.b;
    }

    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }
}
