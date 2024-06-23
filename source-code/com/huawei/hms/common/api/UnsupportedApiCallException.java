package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
/* compiled from: Taobao */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature feature;

    public UnsupportedApiCallException(Feature feature2) {
        this.feature = feature2;
    }

    public final String getMessage() {
        return this.feature + " is unsupported";
    }
}
