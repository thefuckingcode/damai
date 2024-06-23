package com.google.common.cache;

import tb.ke;

/* compiled from: Taobao */
public interface AbstractCache$StatsCounter {
    void recordEviction();

    void recordHits(int i);

    void recordLoadException(long j);

    void recordLoadSuccess(long j);

    void recordMisses(int i);

    ke snapshot();
}
