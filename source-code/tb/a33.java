package tb;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.uploader.implement.a;
import com.uploader.implement.a.c.b;
import com.uploader.implement.a.e;
import com.uploader.implement.b.a.f;
import com.uploader.implement.c;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import org.json.JSONObject;

/* compiled from: Taobao */
public class a33 implements e {
    private boolean a;
    private e23 b;
    private f c;
    private long d;
    private final Pair<Boolean, Pair<String, Integer>> e;
    private final int f = hashCode();
    private final f63 g;
    private final String h;
    private final c i;

    public a33(c cVar, e23 e23, String str, long j, long j2, boolean z) throws Exception {
        this.i = cVar;
        this.b = e23;
        this.a = z;
        Pair<Boolean, Pair<String, Integer>> g2 = cVar.a.g();
        this.e = g2;
        if (g2 != null) {
            this.h = (String) cVar.a.a().first;
            this.d = cVar.a.i();
            this.g = new f63(e23.b, e23.j, j, j2, null, b(j, j2, str).getBytes("UTF-8"), j < e23.f ? "\r\n\r\n".getBytes() : null, e23.k);
            return;
        }
        throw new RuntimeException("currentUploadTarget is null");
    }

    private com.uploader.implement.a.f c(Map<String, String> map, byte[] bArr, int i2, int i3) {
        f13 f13;
        if (map == null) {
            map = new HashMap<>();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i2, i3)));
        map.put("divided_length", Integer.toString(i3));
        while (true) {
            f13 = null;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                } else if (!TextUtils.isEmpty(readLine)) {
                    int length = readLine.length();
                    int indexOf = readLine.indexOf(":");
                    if (indexOf > 1) {
                        String substring = readLine.substring(0, indexOf);
                        if (indexOf < length) {
                            map.put(substring.trim(), b.c(readLine.substring(indexOf + 1, length)));
                        }
                    } else {
                        int indexOf2 = readLine.indexOf(" ");
                        if (indexOf2 > 1) {
                            String substring2 = readLine.substring(0, indexOf2);
                            if (indexOf2 < length) {
                                String substring3 = readLine.substring(indexOf2 + 1, length);
                                map.put("response_code", substring2);
                                map.put("response_msg", substring3);
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                if (a.d(16)) {
                    a.b(16, "FileUploadActionRequest", this.f + " decode response header failed", e2);
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        if (map.get("x-arup-process") != null) {
            f13 = new f13(2, map);
        } else if (map.get("x-arup-offset") != null) {
            f13 = new f13(3, map);
        } else if (map.get("x-arup-file-status") != null) {
            f13 = new f13(4, map);
        } else if (map.get("x-arup-error-code") != null) {
            f13 = new f13(5, map);
        } else {
            if (map.get("x-arup-session-status") != null) {
                f13 = new f13(6, map);
            }
            return f13;
        }
        map.put("divided_length", Integer.toString(i3));
        if (a.d(4)) {
            a.a(4, "FileUploadActionRequest", this.f + " decode actionResponse header:" + map.toString());
        }
        return f13;
    }

    @Override // com.uploader.implement.a.e
    public f63 b() {
        return this.g;
    }

    /* renamed from: d */
    public f a() {
        f fVar = this.c;
        if (fVar != null) {
            return fVar;
        }
        Object obj = this.e.second;
        f fVar2 = new f((String) ((Pair) obj).first, ((Integer) ((Pair) obj).second).intValue(), true, ((Boolean) this.e.first).booleanValue());
        this.c = fVar2;
        return fVar2;
    }

    private final String b(long j, long j2, String str) throws Exception {
        StringBuilder sb;
        int i2 = 0;
        if (this.a) {
            String str2 = this.i.b.getCurrentElement().b;
            String utdid = this.i.b.getUtdid();
            String appVersion = this.i.b.getAppVersion();
            String valueOf = String.valueOf(this.d + (System.currentTimeMillis() / 1000));
            HashMap hashMap = new HashMap();
            hashMap.put("host", "arup.alibaba.com");
            hashMap.put("content-type", "application/offset+octet-stream");
            hashMap.put("x-arup-version", "2.1");
            hashMap.put("x-arup-device-id", utdid);
            hashMap.put("x-arup-appkey", str2);
            hashMap.put("x-arup-appversion", appVersion);
            hashMap.put("x-arup-file-count", Integer.toString(1));
            String userId = this.i.b.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                hashMap.put("x-arup-userinfo", userId);
            }
            hashMap.put("x-arup-timestamp", valueOf);
            if ("patch".equals(str)) {
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append(this.b.d);
                sb2.append("=");
                sb2.append(j);
                hashMap.put("x-arup-req-offset", sb2.toString());
                sb2.setLength(0);
                sb2.append(this.b.d);
                sb2.append("=");
                sb2.append(String.valueOf(this.b.f));
                hashMap.put("x-arup-req-offset-file-length", sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder(128);
            sb3.append(this.b.e);
            sb3.append("&");
            sb3.append(this.h);
            sb3.append("&");
            sb3.append(str2);
            sb3.append("&");
            sb3.append(appVersion);
            sb3.append("&");
            sb3.append(utdid);
            sb3.append("&");
            sb3.append(valueOf);
            String signature = this.i.b.signature(sb3.toString());
            if (TextUtils.isEmpty(signature)) {
                if (a.d(16)) {
                    a.a(16, "FileUploadActionRequest", this.f + " compute upload sign failed.");
                }
                throw new Exception("compute api sign failed.");
            }
            hashMap.put("x-arup-sign", signature);
            sb = new StringBuilder(128);
            sb.append(str);
            sb.append(" ");
            sb.append("/");
            sb.append("f");
            sb.append("/");
            sb.append(this.b.e);
            sb.append("/");
            sb.append(this.h);
            sb.append(" ");
            sb.append("HTTP/1.1");
            sb.append(SocketClient.NETASCII_EOL);
            for (Map.Entry entry : hashMap.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(":");
                sb.append(b.e((String) entry.getValue()));
                sb.append(SocketClient.NETASCII_EOL);
            }
            sb.append(SocketClient.NETASCII_EOL);
        } else {
            sb = null;
        }
        if (j < this.b.f) {
            if (sb == null) {
                sb = new StringBuilder(128);
            }
            sb.append("--");
            sb.append(this.b.d);
            sb.append("--");
            sb.append(SocketClient.NETASCII_EOL);
            Map<String, String> map = this.b.h;
            if (map != null && map.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry2 : this.b.h.entrySet()) {
                    String key = entry2.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        jSONObject.put(key, entry2.getValue());
                    }
                }
                sb.append("x-arup-meta");
                sb.append(":");
                sb.append(b.e(jSONObject.toString()));
                sb.append(SocketClient.NETASCII_EOL);
            }
            sb.append("x-arup-file-md5");
            sb.append(":");
            sb.append(b.e(this.b.g));
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-file-name");
            sb.append(":");
            sb.append(b.e(this.b.c));
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-range");
            sb.append(":");
            sb.append(j);
            sb.append(",");
            sb.append(j2);
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-file-length");
            sb.append(":");
            sb.append(String.valueOf(this.b.f));
            sb.append("\r\n\r\n");
        }
        if (sb == null) {
            return null;
        }
        if (a.d(2)) {
            String sb4 = sb.toString();
            String str3 = "";
            while (true) {
                int indexOf = sb4.indexOf(SocketClient.NETASCII_EOL, i2);
                if (indexOf == -1) {
                    break;
                }
                str3 = str3 + sb4.substring(i2, indexOf) + StringUtils.LF;
                i2 = indexOf + 2;
            }
            a.a(2, "FileUploadActionRequest", this.f + " create upload header:" + str3);
        }
        return sb.toString();
    }

    @Override // com.uploader.implement.a.e
    @NonNull
    public Pair<com.uploader.implement.a.f, Integer> a(Map<String, String> map, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
        loop0:
        while (true) {
            int i6 = 0;
            while (true) {
                i4 = -1;
                try {
                    int read = byteArrayInputStream.read();
                    if (read == -1) {
                        i5 = -1;
                        break loop0;
                    }
                    if (read == 13) {
                        if (i6 == 0 || i6 == 2) {
                            i6++;
                        }
                    } else if (read == 10 && (i6 == 1 || i6 == 3)) {
                        i6++;
                        if (i6 == 4) {
                            i5 = i3 - byteArrayInputStream.available();
                            break loop0;
                        }
                    }
                    if (i6 != 0) {
                    }
                } catch (Exception e2) {
                    if (a.d(16)) {
                        a.b(16, "FileUploadActionRequest", this.f + " divide, exception", e2);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e3) {
                        if (a.d(8)) {
                            a.b(8, "FileUploadActionRequest", this.f + " divide", e3);
                        }
                    }
                    i5 = -1;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        if (a.d(8)) {
                            a.b(8, "FileUploadActionRequest", this.f + " divide", e4);
                        }
                    }
                    throw th;
                }
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e5) {
            if (a.d(8)) {
                a.b(8, "FileUploadActionRequest", this.f + " divide", e5);
            }
        }
        if (i5 <= -1) {
            return new Pair<>(null, 0);
        }
        com.uploader.implement.a.f c2 = c(map, bArr, i2, i5);
        if (c2 != null) {
            i4 = i5;
        }
        return new Pair<>(c2, Integer.valueOf(i4));
    }
}
