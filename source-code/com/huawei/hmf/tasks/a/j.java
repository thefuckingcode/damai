package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
public final class j {

    /* compiled from: Taobao */
    public static class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
        public final CountDownLatch a = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.a.countDown();
        }
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static Task<List<Task<?>>> a(final Collection<? extends Task<?>> collection) {
        return c(collection).continueWith(new Continuation<Void, List<Task<?>>>() {
            /* class com.huawei.hmf.tasks.a.j.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.huawei.hmf.tasks.Task] */
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ List<Task<?>> then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList(collection.size());
                arrayList.addAll(collection);
                return arrayList;
            }
        });
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static void a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <TResult> Task<List<TResult>> b(final Collection<? extends Task<?>> collection) {
        return c(collection).continueWith(new Continuation<Void, List<TResult>>() {
            /* class com.huawei.hmf.tasks.a.j.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.huawei.hmf.tasks.Task] */
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ Object then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (Task task2 : collection) {
                    arrayList.add(task2.getResult());
                }
                return arrayList;
            }
        });
    }

    public static Task<Void> c(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull((Task) it.next(), "task can not is null");
        }
        i iVar = new i();
        e eVar = new e(collection.size(), iVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            Task task = (Task) it2.next();
            task.addOnSuccessListener(TaskExecutors.immediate(), eVar);
            task.addOnFailureListener(TaskExecutors.immediate(), eVar);
            task.addOnCanceledListener(TaskExecutors.immediate(), eVar);
        }
        return iVar;
    }

    public final <TResult> Task<TResult> a(Executor executor, final Callable<TResult> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                /* class com.huawei.hmf.tasks.a.j.AnonymousClass1 */

                public final void run() {
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (Exception e) {
                        taskCompletionSource.setException(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
        return taskCompletionSource.getTask();
    }
}
