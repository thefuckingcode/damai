package com.alibaba.motu.tbrest.request;

import android.text.TextUtils;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.sign.RestBaseRequestAuthentication;
import com.alibaba.motu.tbrest.utils.LogUtil;
import com.alibaba.motu.tbrest.utils.MD5Utils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import mtopsdk.common.util.HttpHeaderConstant;

/* compiled from: Taobao */
public class UrlWrapper {
    private static final int MAX_CONNECTION_TIME_OUT = 10000;
    private static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 60000;
    public static int mErrorCode;
    private static RestSslSocketFactory mRestSslSocketFactory;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01f0 A[SYNTHETIC, Splitter:B:104:0x01f0] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c A[SYNTHETIC, Splitter:B:76:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c0 A[SYNTHETIC, Splitter:B:88:0x01c0] */
    public static BizResponse sendRequest(String str, String str2, byte[] bArr) {
        URL url;
        Throwable th;
        DataOutputStream dataOutputStream;
        SSLHandshakeException e;
        Exception e2;
        Throwable th2;
        DataInputStream dataInputStream;
        IOException e3;
        StringBuilder sb = new StringBuilder();
        sb.append("sendRequest use adashx, bytes length : ");
        sb.append(bArr == null ? "0" : Integer.valueOf(bArr.length));
        LogUtil.d(sb.toString());
        BizResponse bizResponse = new BizResponse();
        try {
            if (SendService.getInstance().openHttp.booleanValue()) {
                url = new URL(str2);
            } else {
                url = new URL(str2);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (mRestSslSocketFactory == null && !TextUtils.isEmpty(url.getHost())) {
                    mRestSslSocketFactory = new RestSslSocketFactory(url.getHost());
                }
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(mRestSslSocketFactory);
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                if (!TextUtils.isEmpty(str)) {
                    httpURLConnection.setRequestProperty("x-k", str);
                }
                try {
                    String str3 = SendService.getInstance().appSecret;
                    if (str3 == null || str3.length() <= 0) {
                        String sign = new RestBaseRequestAuthentication(str, "", false).getSign(MD5Utils.getMd5Hex(bArr));
                        LogUtil.d("signValue:" + sign);
                        httpURLConnection.setRequestProperty("x-s", sign);
                        httpURLConnection.setRequestProperty(HttpHeaderConstant.X_T, "3");
                    } else {
                        String sign2 = new RestBaseRequestAuthentication(str, str3, true).getSign(MD5Utils.getMd5Hex(bArr));
                        LogUtil.d("signValue:" + sign2);
                        httpURLConnection.setRequestProperty("x-s", sign2);
                        httpURLConnection.setRequestProperty(HttpHeaderConstant.X_T, "3");
                    }
                } catch (Throwable th3) {
                    LogUtil.e(th3.toString());
                }
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    httpURLConnection.connect();
                    if (bArr == null || bArr.length <= 0) {
                        dataOutputStream = null;
                    } else {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                        } catch (SSLHandshakeException e4) {
                            e = e4;
                        } catch (Exception e5) {
                            e2 = e5;
                            try {
                                LogUtil.e(e2.toString());
                                bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream != null) {
                                }
                                return bizResponse;
                            } catch (Throwable th4) {
                                th = th4;
                                if (dataOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e6) {
                            LogUtil.e(e6.toString());
                        }
                    }
                    bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        try {
                            byte[] bArr2 = new byte[2048];
                            while (true) {
                                int read = dataInputStream.read(bArr2, 0, 2048);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e7) {
                                        LogUtil.e(e7.toString());
                                    }
                                }
                            }
                            dataInputStream.close();
                        } catch (IOException e8) {
                            e3 = e8;
                            try {
                                LogUtil.e(e3.toString());
                                if (dataInputStream != null) {
                                }
                                if (byteArrayOutputStream.size() > 0) {
                                }
                                return bizResponse;
                            } catch (Throwable th5) {
                                th2 = th5;
                                if (dataInputStream != null) {
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e9) {
                        dataInputStream = null;
                        e3 = e9;
                        LogUtil.e(e3.toString());
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        if (byteArrayOutputStream.size() > 0) {
                        }
                        return bizResponse;
                    } catch (Throwable th6) {
                        dataInputStream = null;
                        th2 = th6;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e10) {
                                LogUtil.e(e10.toString());
                            }
                        }
                        throw th2;
                    }
                    if (byteArrayOutputStream.size() > 0) {
                        int parseResult = BizRequest.parseResult(byteArrayOutputStream.toByteArray());
                        mErrorCode = parseResult;
                        bizResponse.errCode = parseResult;
                        bizResponse.data = BizRequest.mResponseAdditionalData;
                    }
                } catch (SSLHandshakeException e11) {
                    dataOutputStream = null;
                    e = e11;
                    LogUtil.e(e.toString());
                    bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e12) {
                            LogUtil.e(e12.toString());
                        }
                    }
                    return bizResponse;
                } catch (Exception e13) {
                    dataOutputStream = null;
                    e2 = e13;
                    LogUtil.e(e2.toString());
                    bizResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e14) {
                            LogUtil.e(e14.toString());
                        }
                    }
                    return bizResponse;
                } catch (Throwable th7) {
                    dataOutputStream = null;
                    th = th7;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e15) {
                            LogUtil.e(e15.toString());
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException | MalformedURLException unused) {
        }
        return bizResponse;
    }

    public static BizResponse sendRequestByUrl(String str, byte[] bArr) {
        return sendRequest(SendService.getInstance().appKey, str, bArr);
    }

    public static BizResponse sendRequest(String str, byte[] bArr) {
        String str2;
        String str3 = SendService.getInstance().appKey;
        if (SendService.getInstance().openHttp.booleanValue()) {
            str2 = "http://" + str + "/upload";
        } else {
            str2 = "https://" + str + "/upload";
        }
        return sendRequest(str3, str2, bArr);
    }
}
