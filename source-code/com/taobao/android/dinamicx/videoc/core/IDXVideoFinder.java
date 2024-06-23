package com.taobao.android.dinamicx.videoc.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
public interface IDXVideoFinder<Key, Video> {
    @Nullable
    List<Video> findVideos(@NonNull Key key, @NonNull String str);

    Collection<String> scenes();
}
