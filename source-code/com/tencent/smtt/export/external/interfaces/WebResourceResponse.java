package com.tencent.smtt.export.external.interfaces;

import java.io.InputStream;
import java.util.Map;

public class WebResourceResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private int mStatusCode;

    public WebResourceResponse() {
    }

    public WebResourceResponse(String str, String str2, InputStream inputStream) {
        this.mMimeType = str;
        this.mEncoding = str2;
        setData(inputStream);
    }

    public WebResourceResponse(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        this(str, str2, inputStream);
        setStatusCodeAndReasonPhrase(i, str3);
        setResponseHeaders(map);
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        this.mStatusCode = i;
        this.mReasonPhrase = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public void setResponseHeaders(Map<String, String> map) {
        this.mResponseHeaders = map;
    }

    public Map<String, String> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public void setData(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public InputStream getData() {
        return this.mInputStream;
    }
}
