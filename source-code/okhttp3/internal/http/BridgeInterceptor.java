package okhttp3.internal.http;

import com.lzy.okgo.model.HttpHeaders;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okio.GzipSource;
import okio.Okio;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: BridgeInterceptor.kt */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        Intrinsics.checkParameterIsNotNull(cookieJar2, "cookieJar");
        this.cookieJar = cookieJar2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body2 = request.body();
        if (body2 != null) {
            MediaType contentType = body2.contentType();
            if (contentType != null) {
                newBuilder.header(HttpHeaders.HEAD_KEY_CONTENT_TYPE, contentType.toString());
            }
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                newBuilder.header(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(contentLength));
                newBuilder.removeHeader("Transfer-Encoding");
            } else {
                newBuilder.header("Transfer-Encoding", "chunked");
                newBuilder.removeHeader(HttpHeaders.HEAD_KEY_CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header(HttpHeaders.HEAD_KEY_CONNECTION) == null) {
            newBuilder.header(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
        }
        if (request.header(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING) == null && request.header(HttpHeaders.HEAD_KEY_RANGE) == null) {
            newBuilder.header(HttpHeaders.HEAD_KEY_ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(HttpHeaders.HEAD_KEY_COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header(HttpHeaders.HEAD_KEY_USER_AGENT) == null) {
            newBuilder.header(HttpHeaders.HEAD_KEY_USER_AGENT, Version.userAgent);
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && StringsKt.equals("gzip", Response.header$default(proceed, "Content-Encoding", null, 2, null), true) && HttpHeaders.promisesBody(proceed) && (body = proceed.body()) != null) {
            GzipSource gzipSource = new GzipSource(body.source());
            request2.headers(proceed.headers().newBuilder().removeAll("Content-Encoding").removeAll(HttpHeaders.HEAD_KEY_CONTENT_LENGTH).build());
            request2.body(new RealResponseBody(Response.header$default(proceed, HttpHeaders.HEAD_KEY_CONTENT_TYPE, null, 2, null), -1, Okio.buffer(gzipSource)));
        }
        return request2.build();
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(t2.name());
            sb.append('=');
            sb.append(t2.value());
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
