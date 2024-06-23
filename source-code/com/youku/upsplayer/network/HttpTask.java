package com.youku.upsplayer.network;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.util.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class HttpTask implements INetworkTask {
    private static final String TAG = "HttpTask";
    private ConnectStat connectStat = new ConnectStat();
    private Map<String, List<String>> header = null;
    private String recvData = null;

    protected static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(SocketClient.NETASCII_EOL);
                }
            } catch (Exception e) {
                Logger.e("Util", e.toString());
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    Logger.e("Util", e2.toString());
                }
                throw th;
            }
            try {
                break;
            } catch (Exception e3) {
                Logger.e("Util", e3.toString());
            }
        }
        inputStream.close();
        return sb.toString();
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

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0161  */
    public void connectAPI(RequestData requestData) {
        String exc;
        if (!TextUtils.isEmpty(requestData.url)) {
            InputStream inputStream = null;
            this.recvData = null;
            ConnectStat connectStat2 = this.connectStat;
            connectStat2.url = requestData.url;
            connectStat2.connect_success = false;
            try {
                URL url = new URL(requestData.url);
                String str = TAG;
                Logger.d(str, "connectAPI url " + url.toString());
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(requestData.connect_timeout);
                openConnection.setReadTimeout(requestData.read_timeout);
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                setHttps(httpURLConnection, url);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod("GET");
                if (!TextUtils.isEmpty(requestData.host)) {
                    Logger.d(str, "use host " + requestData.host);
                    httpURLConnection.setRequestProperty(BizTime.HOST, requestData.host);
                }
                if (!TextUtils.isEmpty(requestData.cookie)) {
                    httpURLConnection.setRequestProperty(IRequestConst.COOKIE, requestData.cookie);
                }
                if (!TextUtils.isEmpty(requestData.agent)) {
                    httpURLConnection.setRequestProperty(IRequestConst.USER_AGENT, requestData.agent);
                }
                Logger.d(str, "before http connect");
                long currentTimeMillis = System.currentTimeMillis();
                httpURLConnection.connect();
                this.connectStat.connect_time = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis2 = System.currentTimeMillis();
                this.connectStat.response_code = httpURLConnection.getResponseCode();
                Logger.d(str, "http connect status :" + this.connectStat.response_code);
                ConnectStat connectStat3 = this.connectStat;
                if (connectStat3.response_code == 200) {
                    connectStat3.connect_success = true;
                    try {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        this.recvData = stringBuffer.toString();
                        try {
                            inputStream2.close();
                        } catch (Exception e) {
                            exc = e.toString();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        ConnectStat connectStat4 = this.connectStat;
                        connectStat4.connect_success = false;
                        connectStat4.response_code = ErrorConstants.getReadResponseErrorCode();
                        ConnectStat connectStat5 = this.connectStat;
                        connectStat5.errMsg = ErrorConstants.getErrorMsg(this.connectStat.response_code) + ":" + e2.getMessage();
                        ConnectStat connectStat6 = this.connectStat;
                        connectStat6.response_code = ErrorConstants.converRespondCode(connectStat6.response_code);
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            exc = e3.toString();
                        }
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            Logger.e("Util", e4.toString());
                        }
                        throw th;
                    }
                    if (!TextUtils.isEmpty(this.recvData)) {
                        String str2 = TAG;
                        Logger.d_long(str2, "recv: " + this.recvData);
                    }
                }
                this.connectStat.read_time = System.currentTimeMillis() - currentTimeMillis2;
                String str3 = TAG;
                Logger.d(str3, "httpConn time=" + this.connectStat.read_time);
                this.connectStat.header = httpURLConnection.getHeaderFields();
            } catch (IOException e5) {
                ConnectStat connectStat7 = this.connectStat;
                connectStat7.connect_success = false;
                connectStat7.response_code = ErrorConstants.judgeException(e5);
                ConnectStat connectStat8 = this.connectStat;
                connectStat8.errMsg = ErrorConstants.getErrorMsg(connectStat8.response_code);
                ConnectStat connectStat9 = this.connectStat;
                connectStat9.response_code = ErrorConstants.converRespondCode(connectStat9.response_code);
                if (TextUtils.isEmpty(this.connectStat.errMsg)) {
                    this.connectStat.errMsg = e5.getMessage();
                }
                Logger.e(TAG, Log.getStackTraceString(e5));
                return;
            }
        } else {
            return;
        }
        Logger.e("Util", exc);
        if (!TextUtils.isEmpty(this.recvData)) {
        }
        this.connectStat.read_time = System.currentTimeMillis() - currentTimeMillis2;
        String str32 = TAG;
        Logger.d(str32, "httpConn time=" + this.connectStat.read_time);
        this.connectStat.header = httpURLConnection.getHeaderFields();
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        if (requestData == null) {
            return null;
        }
        connectAPI(requestData);
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
