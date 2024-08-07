package com.youku.alixplayer.opensdk.ups.request.service;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.DefaultTrustManager;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.util.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: Taobao */
public class URLConnectionTask implements INetworkTask {
    private static final String TAG = "URLConnectionTask";
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;
    private int[] mTimeOut = null;
    private String recvData = null;

    public static int converRespondCode(int i, Exception exc) {
        char c;
        if (exc == null) {
            return i + 20000;
        }
        if (exc instanceof UnknownHostException) {
            c = 65131;
        } else if (exc instanceof SocketTimeoutException) {
            c = 65135;
        } else if (exc instanceof ConnectTimeoutException) {
            c = 65136;
        } else if (exc instanceof ConnectException) {
            c = 65130;
        } else if ((exc instanceof SSLHandshakeException) || (exc instanceof SSLException)) {
            c = 65134;
        } else if (exc instanceof CancellationException) {
            c = 65332;
        } else {
            String message = exc.getMessage();
            c = (message == null || !message.contains("not verified")) ? (char) 65435 : 65133;
        }
        if (c == 65136) {
            return ErrorConstants.REQUEST_ERROR_CODE_NO_RESPONSE;
        }
        if (i == -401) {
            return ErrorConstants.REQUEST_ERROR_CODE_SOCKET_TIMEOUT;
        }
        return Math.abs(i) + 29000;
    }

    private void setHttps(HttpURLConnection httpURLConnection, URL url) {
        if (url != null && httpURLConnection != null) {
            String protocol = url.getProtocol();
            if (!TextUtils.isEmpty(protocol) && protocol.equalsIgnoreCase("https")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                try {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init(null, new TrustManager[]{new DefaultTrustManager()}, new SecureRandom());
                    httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.e(TAG, e.getMessage());
                }
            }
        }
    }

    public boolean connectAPI(RequestData requestData) {
        Exception e;
        if (TextUtils.isEmpty(requestData.url)) {
            return false;
        }
        InputStream inputStream = null;
        this.recvData = null;
        ConnectStat connectStat2 = this.connectStat;
        connectStat2.url = requestData.url;
        connectStat2.connect_success = false;
        int i = -1;
        boolean z = true;
        try {
            URL url = new URL(requestData.url);
            Logger.d(TAG, "connectAPI url " + url.toString());
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(requestData.connect_timeout);
            openConnection.setReadTimeout(requestData.read_timeout);
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            setHttps(httpURLConnection, url);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (!TextUtils.isEmpty(requestData.host)) {
                Logger.d(TAG, "use host " + requestData.host);
                httpURLConnection.setRequestProperty(BizTime.HOST, requestData.host);
            }
            if (!TextUtils.isEmpty(requestData.cookie)) {
                httpURLConnection.setRequestProperty(IRequestConst.COOKIE, requestData.cookie);
            }
            if (!TextUtils.isEmpty(requestData.agent)) {
                httpURLConnection.setRequestProperty(IRequestConst.USER_AGENT, requestData.agent);
            }
            Logger.d(TAG, "before http connect");
            long currentTimeMillis = System.currentTimeMillis();
            httpURLConnection.connect();
            this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis();
            i = httpURLConnection.getResponseCode();
            this.connectStat.response_code = converRespondCode(i, null);
            Logger.d(TAG, "http connect status :" + i);
            if (i == 200) {
                this.connectStat.connect_success = true;
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                String stringBuffer2 = stringBuffer.toString();
                this.recvData = stringBuffer2;
                try {
                    if (!TextUtils.isEmpty(stringBuffer2)) {
                        Logger.d_long(TAG, "recv: " + this.recvData);
                    }
                    z = false;
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                    try {
                        ConnectStat connectStat3 = this.connectStat;
                        connectStat3.connect_success = false;
                        connectStat3.response_code = converRespondCode(i, e);
                        inputStream.close();
                        return z;
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            Logger.e("Util", e3.toString());
                        }
                        throw th;
                    }
                }
            }
            this.connectStat.read_time = System.currentTimeMillis() - currentTimeMillis2;
            Logger.d(TAG, "httpConn time=" + this.connectStat.read_time);
            this.connectStat.header = httpURLConnection.getHeaderFields();
            try {
                inputStream.close();
            } catch (Exception e4) {
                Logger.e("Util", e4.toString());
            }
        } catch (Exception e5) {
            e = e5;
            ConnectStat connectStat32 = this.connectStat;
            connectStat32.connect_success = false;
            connectStat32.response_code = converRespondCode(i, e);
            inputStream.close();
            return z;
        }
        return z;
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        if (requestData == null) {
            return null;
        }
        if (this.mTimeOut == null) {
            this.mTimeOut = new int[]{5000, 15000};
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mTimeOut;
            if (i >= iArr.length) {
                break;
            }
            int i2 = iArr[i];
            requestData.connect_timeout = i2;
            requestData.read_timeout = i2;
            if (!connectAPI(requestData)) {
                break;
            }
            i++;
        }
        return new GetInfoResult(this.recvData, this.header, this.connectStat);
    }

    /* access modifiers changed from: protected */
    public String getString(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception unused) {
            return bArr.toString();
        }
    }
}
