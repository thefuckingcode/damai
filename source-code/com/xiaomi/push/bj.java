package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import mtopsdk.network.util.Constants;
import org.apache.commons.net.SocketClient;

/* compiled from: Taobao */
public class bj {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* compiled from: Taobao */
    public static final class a extends FilterInputStream {
        private boolean a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.a = true;
            return -1;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f132a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f132a.toString());
        }
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m281a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010a, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010b, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0116, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0140, code lost:
        com.xiaomi.push.ab.a(r1);
        com.xiaomi.push.ab.a((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0146, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0006] */
    private static bh a(Context context, String str, String str2, Map<String, String> map, String str3) {
        IOException e;
        Throwable th;
        HttpURLConnection a2;
        boolean z;
        BufferedReader bufferedReader;
        bh bhVar = new bh();
        OutputStream outputStream = null;
        try {
            a2 = m283a(context, m284a(str));
            a2.setConnectTimeout(10000);
            a2.setReadTimeout(15000);
            String str4 = str2;
            if (str2 == 0) {
                str4 = "GET";
            }
            a2.setRequestMethod(str4);
            int i = 0;
            if (map != null) {
                z = "gzip".equalsIgnoreCase(map.get(Constants.Protocol.CONTENT_ENCODING));
                for (String str5 : map.keySet()) {
                    a2.setRequestProperty(str5, map.get(str5));
                }
            } else {
                z = false;
            }
            if (!TextUtils.isEmpty(str3)) {
                a2.setDoOutput(true);
                byte[] bytes = str3.getBytes();
                OutputStream gZIPOutputStream = z ? new GZIPOutputStream(a2.getOutputStream()) : a2.getOutputStream();
                try {
                    gZIPOutputStream.write(bytes, 0, bytes.length);
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = 0;
                    outputStream = gZIPOutputStream;
                    throw new IOException(th.getMessage());
                }
            }
            bhVar.a = a2.getResponseCode();
            com.xiaomi.channel.commonutils.logger.b.m182a("Http POST Response Code: " + bhVar.a);
            while (true) {
                String headerFieldKey = a2.getHeaderFieldKey(i);
                String headerField = a2.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    break;
                }
                bhVar.f131a.put(headerFieldKey, headerField);
                i = i + 1 + 1;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new a(a2.getInputStream())));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                bhVar.f130a = stringBuffer.toString();
                bufferedReader.close();
                ab.a((Closeable) null);
                ab.a((Closeable) null);
                return bhVar;
            } catch (IOException e3) {
                e = e3;
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                str2 = bufferedReader;
                throw new IOException(th.getMessage());
            }
        } catch (IOException unused) {
            bufferedReader = new BufferedReader(new InputStreamReader(new a(a2.getErrorStream())));
        } catch (Throwable th4) {
        }
    }

    public static bh a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException(WPKFactory.INIT_KEY_CONTEXT);
        } else if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection a2 = m283a(context, url2);
                a2.setConnectTimeout(10000);
                a2.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    a2.setRequestProperty(IRequestConst.USER_AGENT, str);
                }
                if (str2 != null) {
                    a2.setRequestProperty(IRequestConst.COOKIE, str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        a2.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                    bVar.a = a2.getResponseCode();
                    if (bVar.f132a == null) {
                        bVar.f132a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = a2.getHeaderFieldKey(i);
                        String headerField = a2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey)) {
                            if (!TextUtils.isEmpty(headerField)) {
                                bVar.f132a.put(headerFieldKey, headerField);
                            }
                        }
                        i++;
                    }
                }
                return new a(a2.getInputStream());
            } catch (IOException e) {
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m282a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (e(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb.append(cArr, 0, read);
                    } else {
                        ab.a(inputStream);
                        return sb.toString();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                ab.a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            ab.a(inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bo.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v13 */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream = null;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes("--*****\r\n");
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + SocketClient.NETASCII_EOL);
            dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
            FileInputStream fileInputStream2 = new FileInputStream((File) file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                    dataOutputStream.flush();
                }
                dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes("*****");
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes(SocketClient.NETASCII_EOL);
                dataOutputStream.flush();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            String stringBuffer2 = stringBuffer.toString();
                            ab.a(fileInputStream2);
                            ab.a(bufferedReader2);
                            return stringBuffer2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        throw new IOException("IOException:" + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        fileInputStream = fileInputStream2;
                        file = bufferedReader;
                        throw new IOException(th.getMessage());
                    }
                }
            } catch (IOException e3) {
                e = e3;
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                file = bufferedReader;
                throw new IOException(th.getMessage());
            }
        } catch (IOException e4) {
            e = e4;
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        } catch (Throwable th4) {
            ab.a(fileInputStream);
            ab.a((Closeable) file);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("Failed to convert from params map to string: " + e);
                    com.xiaomi.channel.commonutils.logger.b.m182a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m283a(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && m285a(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    /* renamed from: a  reason: collision with other method in class */
    private static URL m284a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m285a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return false;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
        } catch (Exception unused) {
        }
    }

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    public static boolean c(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = b(context);
            }
            return z && d(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    public static boolean d(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null || 1 != activeNetworkInfo.getType()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        NetworkInfo a2 = m281a(context);
        return a2 != null && a2.getType() == 0 && 20 == a2.getSubtype();
    }

    public static boolean g(Context context) {
        NetworkInfo a2 = m281a(context);
        return a2 != null && a2.getType() == 0 && 13 == a2.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo a2 = m281a(context);
        if (a2 == null || a2.getType() != 0) {
            return false;
        }
        String subtypeName = a2.getSubtypeName();
        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
            switch (a2.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean i(Context context) {
        NetworkInfo a2 = m281a(context);
        if (a2 == null || a2.getType() != 0) {
            return false;
        }
        int subtype = a2.getSubtype();
        return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
    }
}
