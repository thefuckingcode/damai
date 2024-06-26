package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int i, Request request2, boolean z) {
            this.index = i;
            this.request = request2;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request2) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request2, this.forWebSocket);
            }
            return Call.this.client.interceptors().get(this.index).intercept(new ApplicationInterceptorChain(this.index + 1, request2, this.forWebSocket));
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        /* access modifiers changed from: package-private */
        public void cancel() {
            Call.this.cancel();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0030 A[SYNTHETIC, Splitter:B:12:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004f A[Catch:{ all -> 0x0029 }] */
        @Override // com.squareup.okhttp.internal.NamedRunnable
        public void execute() {
            IOException e;
            boolean z = true;
            try {
                Response responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                if (Call.this.canceled) {
                    try {
                        this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (!z) {
                        }
                        Call.this.client.getDispatcher().finished(this);
                    }
                } else {
                    this.responseCallback.onResponse(responseWithInterceptorChain);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
                if (!z) {
                    try {
                        Logger logger = Internal.logger;
                        Level level = Level.INFO;
                        logger.log(level, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e);
                    } catch (Throwable th) {
                        Call.this.client.getDispatcher().finished(this);
                        throw th;
                    }
                } else {
                    this.responseCallback.onFailure(Call.this.engine.getRequest(), e);
                }
                Call.this.client.getDispatcher().finished(this);
            }
            Call.this.client.getDispatcher().finished(this);
        }

        /* access modifiers changed from: package-private */
        public Call get() {
            return Call.this;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return Call.this.originalRequest.url().getHost();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return Call.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public Object tag() {
            return Call.this.originalRequest.tag();
        }

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }
    }

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String toLoggableString() {
        String str = this.canceled ? "canceled call" : "call";
        try {
            String url = new URL(this.originalRequest.url(), "/...").toString();
            return str + " to " + url;
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.disconnect();
        }
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    /* access modifiers changed from: package-private */
    public Response getResponse(Request request, boolean z) throws IOException {
        RequestBody body = request.body();
        if (body != null) {
            Request.Builder newBuilder = request.newBuilder();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header("Content-Type", contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(Constants.Protocol.CONTENT_LENGTH, Long.toString(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader(Constants.Protocol.CONTENT_LENGTH);
            }
            request = newBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                Response response = this.engine.getResponse();
                Request followUpRequest = this.engine.followUpRequest();
                if (followUpRequest == null) {
                    if (!z) {
                        this.engine.releaseConnection();
                    }
                    return response;
                }
                i++;
                if (i <= 20) {
                    if (!this.engine.sameConnection(followUpRequest.url())) {
                        this.engine.releaseConnection();
                    }
                    this.engine = new HttpEngine(this.client, followUpRequest, false, false, z, this.engine.close(), null, null, response);
                } else {
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
            } catch (IOException e) {
                HttpEngine recover = this.engine.recover(e, null);
                if (recover != null) {
                    this.engine = recover;
                } else {
                    throw e;
                }
            }
        }
        this.engine.releaseConnection();
        return null;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    /* access modifiers changed from: package-private */
    public Object tag() {
        return this.originalRequest.tag();
    }

    /* access modifiers changed from: package-private */
    public void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }
}
