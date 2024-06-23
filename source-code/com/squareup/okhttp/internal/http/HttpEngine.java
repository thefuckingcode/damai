package com.squareup.okhttp.internal.http;

import anet.channel.request.a;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.network.util.Constants;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.f;
import okio.h;
import okio.o;

/* compiled from: Taobao */
public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        /* class com.squareup.okhttp.internal.http.HttpEngine.AnonymousClass1 */

        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            return 0;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    private Address address;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private Connection connection;
    private final boolean forWebSocket;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    private Transport transport;
    private final Request userRequest;
    private Response userResponse;

    /* compiled from: Taobao */
    class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request2) {
            this.index = i;
            this.request = request2;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return HttpEngine.this.connection;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request2) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request2.url().getHost().equals(address.getUriHost()) || Util.getEffectivePort(request2.url()) != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request2);
                Interceptor interceptor2 = HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor2.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls == 1) {
                    return intercept;
                }
                throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
            }
            HttpEngine.this.transport.writeRequestHeaders(request2);
            if (HttpEngine.this.permitsRequestBody() && request2.body() != null) {
                BufferedSink c = h.c(HttpEngine.this.transport.createRequestBody(request2, request2.body().contentLength()));
                request2.body().writeTo(c);
                c.close();
            }
            return HttpEngine.this.readNetworkResponse();
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, Connection connection2, RouteSelector routeSelector2, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.connection = connection2;
        this.routeSelector = routeSelector2;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
        if (connection2 != null) {
            Internal.instance.setOwner(connection2, this);
            this.route = connection2.getRoute();
            return;
        }
        this.route = null;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink c = h.c(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), h.d(new Source() {
            /* class com.squareup.okhttp.internal.http.HttpEngine.AnonymousClass2 */
            boolean cacheRequestClosed;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            c.close();
                        }
                        return -1;
                    }
                    buffer.copyTo(c.buffer(), buffer.size() - read, read);
                    c.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            public o timeout() {
                return source.timeout();
            }
        }))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!Constants.Protocol.CONTENT_LENGTH.equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    private void connect() throws IOException {
        if (this.connection == null) {
            if (this.routeSelector == null) {
                Address createAddress = createAddress(this.client, this.networkRequest);
                this.address = createAddress;
                this.routeSelector = RouteSelector.get(createAddress, this.networkRequest, this.client);
            }
            Connection nextConnection = nextConnection();
            this.connection = nextConnection;
            this.route = nextConnection.getRoute();
            return;
        }
        throw new IllegalStateException();
    }

    private void connectFailed(RouteSelector routeSelector2, IOException iOException) {
        if (Internal.instance.recycleCount(this.connection) <= 0) {
            routeSelector2.connectFailed(this.connection.getRoute(), iOException);
        }
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) throws UnknownHostException {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        String host = request.url().getHost();
        if (host == null || host.length() == 0) {
            throw new UnknownHostException(request.url().toString());
        }
        if (request.isHttps()) {
            sSLSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(host, Util.getEffectivePort(request.url()), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }

    private Connection createNextConnection() throws IOException {
        Connection connection2;
        ConnectionPool connectionPool = this.client.getConnectionPool();
        while (true) {
            connection2 = connectionPool.get(this.address);
            if (connection2 == null) {
                return new Connection(connectionPool, this.routeSelector.next());
            }
            if (this.networkRequest.method().equals("GET") || Internal.instance.isReadable(connection2)) {
                return connection2;
            }
            connection2.getSocket().close();
        }
        return connection2;
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(a.c.HEAD)) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static String hostHeader(URL url) {
        if (Util.getEffectivePort(url) == Util.getDefaultPort(url.getProtocol())) {
            return url.getHost();
        }
        return url.getHost() + ":" + url.getPort();
    }

    private boolean isRecoverable(IOException iOException) {
        if (this.client.getRetryOnConnectionFailure() && !(iOException instanceof SSLPeerUnverifiedException) && ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException))) {
            return true;
        }
        return false;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException unused) {
                }
            }
        }
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header(BizTime.HOST) == null) {
            newBuilder.header(BizTime.HOST, hostHeader(request.url()));
        }
        Connection connection2 = this.connection;
        if ((connection2 == null || connection2.getProtocol() != Protocol.HTTP_1_0) && request.header(IRequestConst.CONNECTION) == null) {
            newBuilder.header(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), null)));
        }
        if (request.header(IRequestConst.USER_AGENT) == null) {
            newBuilder.header(IRequestConst.USER_AGENT, Version.userAgent());
        }
        return newBuilder.build();
    }

    private Connection nextConnection() throws IOException {
        Connection createNextConnection = createNextConnection();
        Internal.instance.connectAndSetOwner(this.client, createNextConnection, this, this.networkRequest);
        return createNextConnection;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response build = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.transport.openResponseBody(build)).build();
        }
        Internal.instance.setProtocol(this.connection, build.protocol());
        return build;
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header(Constants.Protocol.CONTENT_ENCODING)) || response.body() == null) {
            return response;
        }
        f fVar = new f(response.body().source());
        Headers build = response.headers().newBuilder().removeAll(Constants.Protocol.CONTENT_ENCODING).removeAll(Constants.Protocol.CONTENT_LENGTH).build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, h.d(fVar))).build();
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        if (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) {
            return false;
        }
        return true;
    }

    public Connection close() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            Util.closeQuietly(bufferedSink);
        } else {
            Sink sink = this.requestBodyOut;
            if (sink != null) {
                Util.closeQuietly(sink);
            }
        }
        Response response = this.userResponse;
        if (response == null) {
            Connection connection2 = this.connection;
            if (connection2 != null) {
                Util.closeQuietly(connection2.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly(response.body());
        Transport transport2 = this.transport;
        if (transport2 == null || this.connection == null || transport2.canReuseConnection()) {
            Connection connection3 = this.connection;
            if (connection3 != null && !Internal.instance.clearOwner(connection3)) {
                this.connection = null;
            }
            Connection connection4 = this.connection;
            this.connection = null;
            return connection4;
        }
        Util.closeQuietly(this.connection.getSocket());
        this.connection = null;
        return null;
    }

    public void disconnect() {
        Transport transport2 = this.transport;
        if (transport2 != null) {
            try {
                transport2.disconnect(this);
            } catch (IOException unused) {
            }
        }
    }

    public Request followUpRequest() throws IOException {
        Proxy proxy;
        String header;
        if (this.userResponse != null) {
            if (getRoute() != null) {
                proxy = getRoute().getProxy();
            } else {
                proxy = this.client.getProxy();
            }
            int code = this.userResponse.code();
            if (code != 307 && code != 308) {
                if (code != 401) {
                    if (code != 407) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
            } else if (!this.userRequest.method().equals("GET") && !this.userRequest.method().equals(a.c.HEAD)) {
                return null;
            }
            if (!this.client.getFollowRedirects() || (header = this.userResponse.header("Location")) == null) {
                return null;
            }
            URL url = new URL(this.userRequest.url(), header);
            if (!url.getProtocol().equals("https") && !url.getProtocol().equals("http")) {
                return null;
            }
            if (!url.getProtocol().equals(this.userRequest.url().getProtocol()) && !this.client.getFollowSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = this.userRequest.newBuilder();
            if (HttpMethod.permitsRequestBody(this.userRequest.method())) {
                newBuilder.method("GET", null);
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader(Constants.Protocol.CONTENT_LENGTH);
                newBuilder.removeHeader("Content-Type");
            }
            if (!sameConnection(url)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(url).build();
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        BufferedSink c = h.c(requestBody);
        this.bufferedRequestBody = c;
        return c;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public Route getRoute() {
        return this.route;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    /* access modifiers changed from: package-private */
    public boolean permitsRequestBody() {
        return HttpMethod.permitsRequestBody(this.userRequest.method());
    }

    public void readResponse() throws IOException {
        Response response;
        if (this.userResponse == null) {
            Request request = this.networkRequest;
            if (request == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (request != null) {
                if (this.forWebSocket) {
                    this.transport.writeRequestHeaders(request);
                    response = readNetworkResponse();
                } else if (!this.callerWritesRequestBody) {
                    response = new NetworkInterceptorChain(0, request).proceed(this.networkRequest);
                } else {
                    BufferedSink bufferedSink = this.bufferedRequestBody;
                    if (bufferedSink != null && bufferedSink.buffer().size() > 0) {
                        this.bufferedRequestBody.emit();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1) {
                            Sink sink = this.requestBodyOut;
                            if (sink instanceof RetryableSink) {
                                this.networkRequest = this.networkRequest.newBuilder().header(Constants.Protocol.CONTENT_LENGTH, Long.toString(((RetryableSink) sink).contentLength())).build();
                            }
                        }
                        this.transport.writeRequestHeaders(this.networkRequest);
                    }
                    Sink sink2 = this.requestBodyOut;
                    if (sink2 != null) {
                        BufferedSink bufferedSink2 = this.bufferedRequestBody;
                        if (bufferedSink2 != null) {
                            bufferedSink2.close();
                        } else {
                            sink2.close();
                        }
                        Sink sink3 = this.requestBodyOut;
                        if (sink3 instanceof RetryableSink) {
                            this.transport.writeRequestBody((RetryableSink) sink3);
                        }
                    }
                    response = readNetworkResponse();
                }
                receiveHeaders(response.headers());
                Response response2 = this.cacheResponse;
                if (response2 != null) {
                    if (validate(response2, response)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), response.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                        response.body().close();
                        releaseConnection();
                        InternalCache internalCache = Internal.instance.internalCache(this.client);
                        internalCache.trackConditionalCacheHit();
                        internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly(this.cacheResponse.body());
                }
                Response build = response.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                this.userResponse = build;
                if (hasBody(build)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    public void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        RouteSelector routeSelector2 = this.routeSelector;
        if (!(routeSelector2 == null || this.connection == null)) {
            connectFailed(routeSelector2, iOException);
        }
        boolean z = sink == null || (sink instanceof RetryableSink);
        RouteSelector routeSelector3 = this.routeSelector;
        if (routeSelector3 == null && this.connection == null) {
            return null;
        }
        if ((routeSelector3 != null && !routeSelector3.hasNext()) || !isRecoverable(iOException) || !z) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) sink, this.priorResponse);
    }

    public void releaseConnection() throws IOException {
        Transport transport2 = this.transport;
        if (!(transport2 == null || this.connection == null)) {
            transport2.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public boolean sameConnection(URL url) {
        URL url2 = this.userRequest.url();
        return url2.getHost().equals(url.getHost()) && Util.getEffectivePort(url2) == Util.getEffectivePort(url) && url2.getProtocol().equals(url.getProtocol());
    }

    public void sendRequest() throws IOException {
        if (this.cacheStrategy == null) {
            if (this.transport == null) {
                Request networkRequest2 = networkRequest(this.userRequest);
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                Response response = internalCache != null ? internalCache.get(networkRequest2) : null;
                CacheStrategy cacheStrategy2 = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest2, response).get();
                this.cacheStrategy = cacheStrategy2;
                this.networkRequest = cacheStrategy2.networkRequest;
                this.cacheResponse = cacheStrategy2.cacheResponse;
                if (internalCache != null) {
                    internalCache.trackResponse(cacheStrategy2);
                }
                if (response != null && this.cacheResponse == null) {
                    Util.closeQuietly(response.body());
                }
                if (this.networkRequest != null) {
                    if (this.connection == null) {
                        connect();
                    }
                    this.transport = Internal.instance.newTransport(this.connection, this);
                    if (this.callerWritesRequestBody && permitsRequestBody() && this.requestBodyOut == null) {
                        long contentLength = OkHeaders.contentLength(networkRequest2);
                        if (!this.bufferRequestBody) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                        } else {
                            this.requestBodyOut = new RetryableSink();
                        }
                    }
                } else {
                    if (this.connection != null) {
                        Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                        this.connection = null;
                    }
                    Response response2 = this.cacheResponse;
                    if (response2 != null) {
                        this.userResponse = response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                    } else {
                        this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
                    }
                    this.userResponse = unzip(this.userResponse);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis == -1) {
            this.sentRequestMillis = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }
}
