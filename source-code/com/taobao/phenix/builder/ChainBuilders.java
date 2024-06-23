package com.taobao.phenix.builder;

import android.content.Context;
import tb.ec1;
import tb.f42;
import tb.oh0;
import tb.sy0;
import tb.w80;
import tb.x80;

/* compiled from: Taobao */
public interface ChainBuilders {
    Context applicationContext();

    w80 diskCacheBuilder();

    x80 diskCacheKVBuilder();

    oh0 fileLoaderBuilder();

    sy0 httpLoaderBuilder();

    boolean isGenericTypeCheckEnabled();

    ec1 memCacheBuilder();

    f42 schedulerBuilder();
}
