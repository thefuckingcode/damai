package com.taobao.tao.log;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
public class ConcurrentLinkedCache<E> extends ConcurrentLinkedQueue<E> {
    @NonNull
    public Iterator<E> getIteratorAndClear() {
        synchronized (this) {
            try {
                if (!isEmpty()) {
                    ArrayList arrayList = new ArrayList(this);
                    clear();
                    return arrayList.iterator();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
            return new Iterator<E>() {
                /* class com.taobao.tao.log.ConcurrentLinkedCache.AnonymousClass1 */

                public boolean hasNext() {
                    return false;
                }

                @Override // java.util.Iterator
                public E next() {
                    return null;
                }
            };
        }
    }
}
