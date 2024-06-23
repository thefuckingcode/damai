package com.youku.live.messagechannel.utils;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
public class LRUQueue<T extends Comparable<T>> extends LinkedBlockingQueue<T> {
    private static transient /* synthetic */ IpChange $ipChange;

    public LRUQueue(int i) {
        super(i);
    }

    public synchronized boolean add(T t) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2009537877")) {
            return ((Boolean) ipChange.ipc$dispatch("2009537877", new Object[]{this, t})).booleanValue();
        } else if (t == null) {
            return false;
        } else {
            Iterator<E> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                E next = it.next();
                if (next.compareTo(t) == 0) {
                    remove(next);
                    break;
                }
            }
            if (remainingCapacity() <= 0) {
                remove();
            }
            super.add((Object) t);
            return z;
        }
    }
}
