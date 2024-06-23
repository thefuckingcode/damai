package com.taobao.phenix.cache.disk;

/* compiled from: Taobao */
public class OnlyCacheFailedException extends Exception {
    public OnlyCacheFailedException(String str) {
        super("No disk cache , " + str + " cannot conduct final result at OnlyCache()");
    }
}
