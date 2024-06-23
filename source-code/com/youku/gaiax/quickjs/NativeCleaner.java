package com.youku.gaiax.quickjs;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class NativeCleaner<T> {
    private final Set<NativeReference<T>> phantomReferences = new HashSet();
    private final ReferenceQueue<T> referenceQueue = new ReferenceQueue<>();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class NativeReference<T> extends PhantomReference<T> {
        private final long pointer;

        private NativeReference(T t, long j, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.pointer = j;
        }
    }

    NativeCleaner() {
    }

    public void clean() {
        while (true) {
            NativeReference nativeReference = (NativeReference) this.referenceQueue.poll();
            if (nativeReference == null) {
                return;
            }
            if (this.phantomReferences.contains(nativeReference)) {
                onRemove(nativeReference.pointer);
                this.phantomReferences.remove(nativeReference);
            }
        }
    }

    public void forceClean() {
        for (NativeReference<T> nativeReference : this.phantomReferences) {
            onRemove(((NativeReference) nativeReference).pointer);
        }
        this.phantomReferences.clear();
    }

    public abstract void onRemove(long j);

    public void register(T t, long j) {
        this.phantomReferences.add(new NativeReference<>(t, j, this.referenceQueue));
    }

    public int size() {
        return this.phantomReferences.size();
    }
}
