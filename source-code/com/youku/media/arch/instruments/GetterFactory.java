package com.youku.media.arch.instruments;

import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
public interface GetterFactory {

    /* compiled from: Taobao */
    public interface Provider {
        GetterFactory getFactory();
    }

    void fillinPersistentNamespaces(ConfigFetcher configFetcher);

    ConfigFetcher.ConfigGetter getGetter();

    void notifyCachedNamespaceAdded(String str);

    void notifyCachedNamespaceRemoved(String str);

    boolean skipDefaultCache();
}
