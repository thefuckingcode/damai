package com.taobao.ma.analyze.api;

import com.taobao.ma.decode.MaDecode;

/* compiled from: Taobao */
public class MaMemoryAPI {
    public static void ReleaseCameraMemory() {
        MaDecode.releaseStaticMemory();
    }
}
