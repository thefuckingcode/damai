package com.ta.audid.upload;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.ta.audid.Constants;
import com.ta.audid.Variables;
import com.ta.audid.utils.MD5Utils;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.Base64;
import com.tencent.open.SocialOperation;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/* compiled from: Taobao */
public class HttpUtils {
    private static final int MAX_CONNECTION_TIME_OUT = 10000;
    private static final int MAX_READ_CONNECTION_STREAM_TIME_OUT = 10000;
    private static final long TIME_SCOPE = 1800000;

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.DataInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a3, code lost:
        r2 = r0;
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01a7, code lost:
        r6 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ce, code lost:
        com.ta.audid.utils.UtdidLogger.d("", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0200 A[SYNTHETIC, Splitter:B:103:0x0200] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a2 A[ExcHandler: all (r0v27 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r10 
      PHI: (r10v4 ??) = (r10v3 ??), (r10v5 ??) binds: [B:80:0x01bd, B:60:0x0188] A[DONT_GENERATE, DONT_INLINE], Splitter:B:60:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c5 A[Catch:{ Exception -> 0x01e3, all -> 0x01a2 }, LOOP:1: B:82:0x01bf->B:84:0x01c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c9 A[EDGE_INSN: B:85:0x01c9->B:86:? ?: BREAK  , SYNTHETIC, Splitter:B:85:0x01c9] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f0 A[SYNTHETIC, Splitter:B:97:0x01f0] */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static HttpResponse sendRequest(String str, String str2, boolean z) {
        HttpURLConnection httpURLConnection;
        Object th;
        DataOutputStream dataOutputStream;
        ?? r6;
        Exception e;
        ?? dataInputStream;
        HttpResponse httpResponse = new HttpResponse();
        if (TextUtils.isEmpty(str)) {
            return httpResponse;
        }
        try {
            URL url = new URL(str);
            if (!TextUtils.isEmpty(url.getHost()) && (httpURLConnection = (HttpURLConnection) url.openConnection()) != null) {
                httpURLConnection.setDoInput(true);
                if (z) {
                    httpURLConnection.setDoOutput(true);
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e2) {
                        UtdidLogger.e("", e2, new Object[0]);
                        return httpResponse;
                    }
                } else {
                    try {
                        httpURLConnection.setRequestMethod("GET");
                    } catch (ProtocolException e3) {
                        UtdidLogger.e("", e3, new Object[0]);
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                StringBuilder sb = new StringBuilder();
                httpURLConnection.setRequestProperty("x-audid-appkey", "");
                String packageName = Variables.getInstance().getContext().getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    try {
                        httpURLConnection.setRequestProperty("x-audid-appname", URLEncoder.encode(packageName, "UTF-8"));
                        sb.append(packageName);
                    } catch (Exception unused) {
                    }
                }
                httpURLConnection.setRequestProperty("x-audid-sdk", Constants.SDK_VERSION);
                sb.append(Constants.SDK_VERSION);
                String currentTimeMillisString = Variables.getInstance().getCurrentTimeMillisString();
                httpURLConnection.setRequestProperty("x-audid-timestamp", currentTimeMillisString);
                UtdidLogger.d("", "timestamp:" + currentTimeMillisString);
                sb.append(currentTimeMillisString);
                sb.append(str2);
                httpURLConnection.setRequestProperty(SocialOperation.GAME_SIGNATURE, Base64.encodeToString(MD5Utils.getHmacMd5Hex(sb.toString()).getBytes(), 2));
                long currentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                try {
                    httpURLConnection.connect();
                    if (str2 == null || str2.length() <= 0) {
                        dataOutputStream = null;
                    } else {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.writeBytes(str2);
                            dataOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e4) {
                            UtdidLogger.d("", e4);
                        }
                    }
                    try {
                        httpResponse.httpResponseCode = httpURLConnection.getResponseCode();
                        httpResponse.signature = httpURLConnection.getHeaderField(SocialOperation.GAME_SIGNATURE);
                    } catch (Exception e5) {
                        UtdidLogger.d("", e5);
                    }
                    try {
                        httpResponse.timestamp = Long.parseLong(httpURLConnection.getHeaderField("x-audid-timestamp"));
                        UtdidLogger.d("", "repsonse.timestamp:" + httpResponse.timestamp);
                        long currentTimeMillis2 = Variables.getInstance().getCurrentTimeMillis();
                        long j = httpResponse.timestamp;
                        if (j > 0 && (j > currentTimeMillis2 + 1800000 || j < currentTimeMillis2 - 1800000)) {
                            Variables.getInstance().setSystemTime(httpResponse.timestamp);
                        }
                    } catch (Exception unused2) {
                    }
                    httpResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = dataInputStream.read(bArr, 0, 2048);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e6) {
                                        UtdidLogger.d("", e6);
                                    }
                                }
                            }
                            dataInputStream.close();
                            if (byteArrayOutputStream.size() > 0) {
                                httpResponse.data = byteArrayOutputStream.toByteArray();
                            }
                        } catch (Exception e7) {
                            e = e7;
                            r6 = dataInputStream;
                            UtdidLogger.d("", e);
                            if (r6 != 0) {
                                try {
                                    r6.close();
                                } catch (Exception e8) {
                                    UtdidLogger.d("", e8);
                                }
                            }
                            return httpResponse;
                        } catch (Throwable th3) {
                        }
                    } catch (IOException e9) {
                        IOException e10 = e9;
                        try {
                            UtdidLogger.d("", e10);
                            try {
                                dataInputStream = new DataInputStream(httpURLConnection.getErrorStream());
                                byte[] bArr2 = new byte[2048];
                                while (true) {
                                    int read2 = dataInputStream.read(bArr2, 0, 2048);
                                    if (read2 == -1) {
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read2);
                                }
                                dataInputStream.close();
                                if (byteArrayOutputStream.size() > 0) {
                                }
                                return httpResponse;
                            } catch (Exception e11) {
                                e = e11;
                                r6 = dataOutputStream2;
                                UtdidLogger.d("", e);
                                if (r6 != 0) {
                                }
                                return httpResponse;
                            }
                        } catch (Throwable th4) {
                            Throwable th5 = th4;
                            ?? r62 = dataOutputStream2;
                            if (r62 != 0) {
                                try {
                                    r62.close();
                                } catch (Exception e12) {
                                    UtdidLogger.d("", e12);
                                }
                            }
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        UtdidLogger.d("", th);
                        httpResponse.rt = System.currentTimeMillis() - currentTimeMillis;
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e13) {
                                UtdidLogger.d("", e13);
                            }
                        }
                        return httpResponse;
                    } catch (Throwable th7) {
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (IOException e14) {
                                UtdidLogger.d("", e14);
                            }
                        }
                        throw th7;
                    }
                }
            }
            return httpResponse;
        } catch (MalformedURLException e15) {
            UtdidLogger.e("", e15, new Object[0]);
            return httpResponse;
        } catch (IOException e16) {
            UtdidLogger.e("", e16, new Object[0]);
            return httpResponse;
        } catch (Throwable th8) {
            UtdidLogger.e("", th8, new Object[0]);
            return httpResponse;
        }
    }
}
