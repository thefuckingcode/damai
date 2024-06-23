package com.taobao.power_image.loader;

import tb.vr1;

/* compiled from: Taobao */
public interface PowerImageLoaderProtocol {

    /* compiled from: Taobao */
    public interface PowerImageResponse {
        void onResult(PowerImageResult powerImageResult);
    }

    void handleRequest(vr1 vr1, PowerImageResponse powerImageResponse);
}
