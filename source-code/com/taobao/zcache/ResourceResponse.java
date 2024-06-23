package com.taobao.zcache;

import androidx.annotation.Keep;
import java.util.Map;

@Keep
/* compiled from: Taobao */
public class ResourceResponse {
    private final boolean _is404;
    private final byte[] data;
    private final Error error;
    private final Map<String, String> header;
    private final String md5;

    ResourceResponse(byte[] bArr, String str, Map<String, String> map, Error error2, boolean z) {
        this.data = bArr;
        this.md5 = str;
        this.header = map;
        this.error = error2;
        this._is404 = z;
    }

    public byte[] getData() {
        return this.data;
    }

    public Error getError() {
        return this.error;
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public String getMD5() {
        return this.md5;
    }

    public boolean is404() {
        return this._is404;
    }
}
