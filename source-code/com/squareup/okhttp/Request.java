package com.squareup.okhttp;

import anet.channel.request.a;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/* compiled from: Taobao */
public final class Request {
    private final RequestBody body;
    private volatile CacheControl cacheControl;
    private final Headers headers;
    private final String method;
    private final Object tag;
    private volatile URI uri;
    private volatile URL url;
    private final String urlString;

    /* compiled from: Taobao */
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Object tag;
        private URL url;
        private String urlString;

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.urlString != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.isEmpty()) {
                return removeHeader("Cache-Control");
            }
            return header("Cache-Control", cacheControl2);
        }

        public Builder delete(RequestBody requestBody) {
            return method(a.c.DELETE, requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method(a.c.HEAD, null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (requestBody == null || HttpMethod.permitsRequestBody(str)) {
                if (requestBody == null && HttpMethod.permitsRequestBody(str)) {
                    requestBody = RequestBody.create((MediaType) null, Util.EMPTY_BYTE_ARRAY);
                }
                this.method = str;
                this.body = requestBody;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method(a.c.PUT, requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder url(String str) {
            if (str != null) {
                this.urlString = str;
                this.url = null;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder delete() {
            return method(a.c.DELETE, null);
        }

        public Builder url(URL url2) {
            if (url2 != null) {
                this.url = url2;
                this.urlString = url2.toString();
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        private Builder(Request request) {
            this.urlString = request.urlString;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }
    }

    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl2 = this.cacheControl;
        if (cacheControl2 != null) {
            return cacheControl2;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return url().getProtocol().equals("https");
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public Object tag() {
        return this.tag;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.urlString);
        sb.append(", tag=");
        Object obj = this.tag;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public URI uri() throws IOException {
        try {
            URI uri2 = this.uri;
            if (uri2 != null) {
                return uri2;
            }
            URI uriLenient = Platform.get().toUriLenient(url());
            this.uri = uriLenient;
            return uriLenient;
        } catch (URISyntaxException e) {
            throw new IOException(e.getMessage());
        }
    }

    public URL url() {
        try {
            URL url2 = this.url;
            if (url2 != null) {
                return url2;
            }
            URL url3 = new URL(this.urlString);
            this.url = url3;
            return url3;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL: " + this.urlString, e);
        }
    }

    public String urlString() {
        return this.urlString;
    }

    private Request(Builder builder) {
        this.urlString = builder.urlString;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tag = builder.tag != null ? builder.tag : this;
        this.url = builder.url;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }
}
