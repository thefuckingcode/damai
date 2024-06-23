package com.tencent.smtt.sdk;

import android.util.Pair;
import com.lzy.okgo.model.HttpHeaders;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public class UrlRequestBuilderImpl extends UrlRequest.Builder {
    private static final String a = "UrlRequestBuilderImpl";
    private final String b;
    private final UrlRequest.Callback c;
    private final Executor d;
    private String e;
    private final ArrayList<Pair<String, String>> f = new ArrayList<>();
    private boolean g;
    private int h = 3;
    private String i;
    private byte[] j;
    private String k;
    private String l;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        } else if (callback == null) {
            throw new NullPointerException("Callback is required.");
        } else if (executor != null) {
            this.b = str;
            this.c = callback;
            this.d = executor;
        } else {
            throw new NullPointerException("Executor is required.");
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str != null) {
            this.e = str;
            return this;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        if (str != null) {
            this.i = str;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr != null) {
            this.j = bArr;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        } else if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        } else if (HttpHeaders.HEAD_KEY_ACCEPT_ENCODING.equalsIgnoreCase(str)) {
            return this;
        } else {
            this.f.add(Pair.create(str, str2));
            return this;
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setDns(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("host and address are required.");
        }
        this.k = str;
        this.l = str2;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i2) {
        this.h = i2;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        u a2 = u.a();
        if (a2 == null || !a2.b()) {
            return null;
        }
        UrlRequest urlRequest = (UrlRequest) a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, Integer.TYPE, UrlRequest.Callback.class, Executor.class, Boolean.TYPE, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.b, Integer.valueOf(this.h), this.c, this.d, Boolean.valueOf(this.g), this.e, this.f, this.i, this.j, this.k, this.l);
        if (urlRequest != null) {
            return urlRequest;
        }
        throw new NullPointerException("UrlRequest build fail");
    }
}
