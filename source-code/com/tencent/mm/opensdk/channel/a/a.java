package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0235a {
        public String a;
        public String b;
        public String c;
        public long d;
        public Bundle e;
    }

    public static int a(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return i;
        }
        try {
            return bundle.getInt(str, i);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e.getMessage());
            return i;
        }
    }

    public static Object a(int i, String str) {
        switch (i) {
            case 1:
                return Integer.valueOf(str);
            case 2:
                return Long.valueOf(str);
            case 3:
                return str;
            case 4:
                return Boolean.valueOf(str);
            case 5:
                return Float.valueOf(str);
            case 6:
                try {
                    return Double.valueOf(str);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                    return null;
                }
            default:
                Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0235a aVar) {
        String str;
        if (context == null || aVar == null) {
            str = "send fail, invalid argument";
        } else if (b.b(aVar.b)) {
            str = "send fail, action is null";
        } else {
            String str2 = null;
            if (!b.b(aVar.a)) {
                str2 = aVar.a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.b);
            Bundle bundle = aVar.e;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.c);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.d);
            intent.putExtra(ConstantsAPI.CHECK_SUM, a(aVar.c, (int) Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:37|38|(2:39|(1:41)(1:148))|42|43|44|45|46|(2:47|48)|49) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x007f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0115 A[SYNTHETIC, Splitter:B:101:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x011c A[SYNTHETIC, Splitter:B:105:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0123 A[SYNTHETIC, Splitter:B:109:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0144 A[SYNTHETIC, Splitter:B:118:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x014b A[SYNTHETIC, Splitter:B:122:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0152 A[SYNTHETIC, Splitter:B:126:0x0152] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x015c A[SYNTHETIC, Splitter:B:134:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0163 A[SYNTHETIC, Splitter:B:138:0x0163] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x016a A[SYNTHETIC, Splitter:B:142:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e6 A[SYNTHETIC, Splitter:B:84:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00ed A[SYNTHETIC, Splitter:B:88:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00f4 A[SYNTHETIC, Splitter:B:92:0x00f4] */
    public static byte[] a(String str, int i) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        MalformedURLException e;
        ByteArrayOutputStream byteArrayOutputStream3;
        InputStream inputStream2;
        IOException e2;
        ByteArrayOutputStream byteArrayOutputStream4;
        InputStream inputStream3;
        Exception e3;
        ByteArrayOutputStream byteArrayOutputStream5;
        InputStream inputStream4;
        ByteArrayOutputStream byteArrayOutputStream6;
        InputStream inputStream5 = null;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
            return null;
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                try {
                    Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                    }
                    return null;
                } catch (MalformedURLException e4) {
                    e = e4;
                    inputStream2 = null;
                    byteArrayOutputStream3 = null;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream3 != null) {
                    }
                    return null;
                } catch (IOException e5) {
                    e2 = e5;
                    inputStream3 = null;
                    byteArrayOutputStream4 = null;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream3 != null) {
                    }
                    if (byteArrayOutputStream4 != null) {
                    }
                    return null;
                } catch (Exception e6) {
                    e3 = e6;
                    inputStream = null;
                    byteArrayOutputStream5 = null;
                    try {
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream5 != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream5;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream5 = inputStream;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream5 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream5 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } else {
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i);
                    if (httpURLConnection.getResponseCode() >= 300) {
                        Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                        return null;
                    }
                    InputStream inputStream6 = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream6 = new ByteArrayOutputStream();
                    } catch (MalformedURLException e7) {
                        inputStream2 = inputStream6;
                        e = e7;
                        byteArrayOutputStream3 = null;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                        if (httpURLConnection != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (byteArrayOutputStream3 != null) {
                        }
                        return null;
                    } catch (IOException e8) {
                        inputStream3 = inputStream6;
                        e2 = e8;
                        byteArrayOutputStream4 = null;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                        if (httpURLConnection != null) {
                        }
                        if (inputStream3 != null) {
                        }
                        if (byteArrayOutputStream4 != null) {
                        }
                        return null;
                    } catch (Exception e9) {
                        inputStream = inputStream6;
                        e3 = e9;
                        byteArrayOutputStream5 = null;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                        if (httpURLConnection != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (byteArrayOutputStream5 != null) {
                        }
                        return null;
                    } catch (Throwable th4) {
                        inputStream4 = inputStream6;
                        th = th4;
                        inputStream5 = inputStream4;
                        byteArrayOutputStream = null;
                        if (httpURLConnection != null) {
                        }
                        if (inputStream5 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream6.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream6.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream6.toByteArray();
                        Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                        httpURLConnection.disconnect();
                        inputStream6.close();
                        try {
                            byteArrayOutputStream6.close();
                        } catch (Throwable unused3) {
                        }
                        return byteArray;
                    } catch (MalformedURLException e10) {
                        inputStream2 = inputStream6;
                        e = e10;
                        byteArrayOutputStream3 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        if (byteArrayOutputStream3 != null) {
                            try {
                                byteArrayOutputStream3.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        return null;
                    } catch (IOException e11) {
                        inputStream3 = inputStream6;
                        e2 = e11;
                        byteArrayOutputStream4 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused7) {
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable unused8) {
                            }
                        }
                        if (byteArrayOutputStream4 != null) {
                            try {
                                byteArrayOutputStream4.close();
                            } catch (Throwable unused9) {
                            }
                        }
                        return null;
                    } catch (Exception e12) {
                        inputStream = inputStream6;
                        e3 = e12;
                        byteArrayOutputStream5 = byteArrayOutputStream6;
                        Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused10) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable unused11) {
                            }
                        }
                        if (byteArrayOutputStream5 != null) {
                            try {
                                byteArrayOutputStream5.close();
                            } catch (Throwable unused12) {
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        byteArrayOutputStream2 = byteArrayOutputStream6;
                        inputStream = inputStream6;
                        th = th5;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        inputStream5 = inputStream;
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused13) {
                            }
                        }
                        if (inputStream5 != null) {
                            try {
                                inputStream5.close();
                            } catch (Throwable unused14) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused15) {
                            }
                        }
                        throw th;
                    }
                } catch (MalformedURLException e13) {
                    e = e13;
                    inputStream2 = null;
                    byteArrayOutputStream3 = null;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (byteArrayOutputStream3 != null) {
                    }
                    return null;
                } catch (IOException e14) {
                    e2 = e14;
                    inputStream3 = null;
                    byteArrayOutputStream4 = null;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream3 != null) {
                    }
                    if (byteArrayOutputStream4 != null) {
                    }
                    return null;
                } catch (Exception e15) {
                    e3 = e15;
                    inputStream = null;
                    byteArrayOutputStream5 = null;
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
                    if (httpURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream5 != null) {
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStream4 = null;
                    inputStream5 = inputStream4;
                    byteArrayOutputStream = null;
                    if (httpURLConnection != null) {
                    }
                    if (inputStream5 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (MalformedURLException e16) {
            e = e16;
            httpURLConnection = null;
            inputStream2 = null;
            byteArrayOutputStream3 = null;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream2 != null) {
            }
            if (byteArrayOutputStream3 != null) {
            }
            return null;
        } catch (IOException e17) {
            e2 = e17;
            httpURLConnection = null;
            inputStream3 = null;
            byteArrayOutputStream4 = null;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e2.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream3 != null) {
            }
            if (byteArrayOutputStream4 != null) {
            }
            return null;
        } catch (Exception e18) {
            e3 = e18;
            httpURLConnection = null;
            inputStream = null;
            byteArrayOutputStream5 = null;
            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e3.getMessage());
            if (httpURLConnection != null) {
            }
            if (inputStream != null) {
            }
            if (byteArrayOutputStream5 != null) {
            }
            return null;
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
            inputStream4 = null;
            inputStream5 = inputStream4;
            byteArrayOutputStream = null;
            if (httpURLConnection != null) {
            }
            if (inputStream5 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    public static byte[] a(String str, int i, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bytes);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            for (byte b : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
