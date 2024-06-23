package mtopsdk.network.impl;

import android.taobao.windvane.connect.HttpConnector;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MockResponse;
import mtopsdk.network.AbstractCallImpl;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.cookie.CookieManager;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.RequestBody;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import mtopsdk.network.util.Constants;
import mtopsdk.network.util.NetworkUtils;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: Taobao */
public class DefaultCallImpl extends AbstractCallImpl {
    private static final String TAG = "mtopsdk.DefaultCallImpl";
    ExecutorService executorService;

    /* compiled from: Taobao */
    class AsyncCallTask implements Runnable {
        NetworkCallback callback;
        Request request;

        public AsyncCallTask(Request request2, NetworkCallback networkCallback) {
            this.request = request2;
            this.callback = networkCallback;
        }

        public void run() {
            try {
                if (((AbstractCallImpl) DefaultCallImpl.this).canceled) {
                    TBSdkLog.d(DefaultCallImpl.TAG, ((AbstractCallImpl) DefaultCallImpl.this).seqNo, "call task is canceled.");
                    this.callback.onCancel(DefaultCallImpl.this);
                    return;
                }
                Response execute = DefaultCallImpl.this.execute();
                if (execute == null) {
                    this.callback.onFailure(DefaultCallImpl.this, new Exception("response is null"));
                } else {
                    this.callback.onResponse(DefaultCallImpl.this, execute);
                }
            } catch (CancellationException unused) {
                this.callback.onCancel(DefaultCallImpl.this);
            } catch (InterruptedException unused2) {
                this.callback.onCancel(DefaultCallImpl.this);
            } catch (Exception e) {
                this.callback.onFailure(DefaultCallImpl.this, e);
                TBSdkLog.e(DefaultCallImpl.TAG, ((AbstractCallImpl) DefaultCallImpl.this).seqNo, "do call.execute failed.", e);
            }
        }
    }

    public DefaultCallImpl(Request request, ExecutorService executorService2) {
        super(request, null);
        this.executorService = executorService2;
    }

    @Override // mtopsdk.network.Call
    public void enqueue(NetworkCallback networkCallback) {
        ExecutorService executorService2 = this.executorService;
        if (executorService2 != null) {
            try {
                this.future = executorService2.submit(new AsyncCallTask(request(), networkCallback));
            } catch (Exception e) {
                networkCallback.onFailure(this, e);
            }
        } else {
            networkCallback.onFailure(this, new Exception("miss executorService in CallImpl "));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // mtopsdk.network.Call
    public Response execute() throws InterruptedException {
        int i;
        Response response;
        int i2;
        MockResponse mockResponse;
        Request request = request();
        String str = null;
        if (!AbstractCallImpl.isDebugApk || !AbstractCallImpl.isOpenMock || (mockResponse = getMockResponse(request.api)) == null) {
            i = 0;
            int i3 = 0;
            while (true) {
                try {
                    HttpURLConnection openConnection = openConnection(request);
                    prepareRequest(openConnection, request);
                    response = readResponse(openConnection, request);
                    break;
                } catch (UnknownHostException e) {
                    str = e.getMessage();
                    i3 = -1;
                } catch (SocketTimeoutException e2) {
                    str = e2.getMessage();
                    i3 = -2;
                } catch (ConnectTimeoutException e3) {
                    str = e3.getMessage();
                    i3 = -3;
                } catch (SSLHandshakeException e4) {
                    str = e4.getMessage();
                    i3 = -4;
                } catch (SSLException e5) {
                    str = e5.getMessage();
                    i3 = -5;
                } catch (ConnectException e6) {
                    str = e6.getMessage();
                    i3 = -6;
                } catch (Exception e7) {
                    str = e7.getMessage();
                    i3 = -7;
                }
                i = i2;
            }
            return response != null ? buildResponse(request, i3, str, null, null, null) : response;
        }
        int i4 = mockResponse.statusCode;
        Map<String, List<String>> map = mockResponse.headers;
        byte[] bArr = mockResponse.byteData;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str2 = this.seqNo;
            TBSdkLog.i(TAG, str2, "[execute]get MockResponse succeed.mockResponse=" + mockResponse);
        }
        return buildResponse(request, i4, null, map, bArr, null);
        i2 = i + 1;
        if (i >= request.retryTimes) {
            response = null;
            if (response != null) {
            }
        } else {
            i = i2;
        }
    }

    @Override // mtopsdk.network.Ext
    public boolean isNoNetworkError(int i) {
        return i == -1 || i == -2 || i == -3;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection openConnection(Request request) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.url).openConnection();
        httpURLConnection.setConnectTimeout(request.connectTimeoutMills);
        httpURLConnection.setReadTimeout(request.readTimeoutMills);
        return httpURLConnection;
    }

    /* access modifiers changed from: package-private */
    public void prepareRequest(HttpURLConnection httpURLConnection, Request request) throws IOException {
        httpURLConnection.setRequestMethod(request.method);
        for (Map.Entry<String, String> entry : request.headers.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase(IRequestConst.COOKIE)) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!StringUtils.isBlank(CookieManager.getCookie(request.url))) {
            httpURLConnection.addRequestProperty(IRequestConst.COOKIE, CookieManager.getCookie(request.url));
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            String str = request.seqNo;
            TBSdkLog.i(TAG, str, "request url =" + request.url);
            String str2 = request.seqNo;
            TBSdkLog.i(TAG, str2, "request headers =" + httpURLConnection.getRequestProperties());
        }
        if ("POST".equalsIgnoreCase(request.method)) {
            httpURLConnection.setDoOutput(true);
        }
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", requestBody.contentType());
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                httpURLConnection.setFixedLengthStreamingMode((int) contentLength);
                httpURLConnection.addRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(contentLength));
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                requestBody.writeTo(outputStream);
            } catch (Exception e) {
                TBSdkLog.e(TAG, "write outputstream error.", e);
            } catch (Throwable th) {
                NetworkUtils.closeQuietly(outputStream);
                throw th;
            }
            NetworkUtils.closeQuietly(outputStream);
        }
    }

    /* access modifiers changed from: package-private */
    public Response readResponse(HttpURLConnection httpURLConnection, Request request) throws IOException {
        final InputStream inputStream;
        if (!Thread.currentThread().isInterrupted()) {
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            if (responseMessage == null) {
                responseMessage = "";
            }
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            storeCookies(request.url, headerFields);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                String str = request.seqNo;
                TBSdkLog.i(TAG, str, "response headers:" + headerFields);
            }
            final String contentType = httpURLConnection.getContentType();
            final int contentLength = httpURLConnection.getContentLength();
            boolean checkContentEncodingGZip = NetworkUtils.checkContentEncodingGZip(headerFields);
            if (responseCode >= 400) {
                inputStream = httpURLConnection.getErrorStream();
            } else if (checkContentEncodingGZip) {
                inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            AnonymousClass1 r8 = new ResponseBody() {
                /* class mtopsdk.network.impl.DefaultCallImpl.AnonymousClass1 */

                @Override // mtopsdk.network.domain.ResponseBody
                public InputStream byteStream() {
                    return inputStream;
                }

                @Override // mtopsdk.network.domain.ResponseBody
                public long contentLength() throws IOException {
                    return (long) contentLength;
                }

                @Override // mtopsdk.network.domain.ResponseBody
                public String contentType() {
                    return contentType;
                }
            };
            if (!Thread.currentThread().isInterrupted()) {
                r8.getBytes();
                return new Response.Builder().request(request).code(responseCode).message(responseMessage).headers(HeaderHandlerUtil.cloneHeaderMap(headerFields)).body(r8).build();
            }
            TBSdkLog.d(TAG, this.seqNo, "[readResponse]call task is canceled.");
            throw new CancellationException("call canceled");
        }
        TBSdkLog.d(TAG, this.seqNo, "[readResponse]call task is canceled.");
        throw new CancellationException("call canceled");
    }

    public void storeCookies(String str, Map<String, List<String>> map) {
        if (str != null && map != null) {
            try {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null && (key.equalsIgnoreCase(HttpConnector.SET_COOKIE) || key.equalsIgnoreCase("Set-Cookie2"))) {
                        for (String str2 : entry.getValue()) {
                            CookieManager.setCookie(str, str2);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
