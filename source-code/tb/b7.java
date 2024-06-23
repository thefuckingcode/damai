package tb;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class b7 {
    private static volatile b7 c;
    private JSONObject a;
    private boolean b = false;

    private b7() {
    }

    public static b7 a() {
        if (c == null) {
            synchronized (b7.class) {
                if (c == null) {
                    c = new b7();
                }
            }
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r5 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004a, code lost:
        if (r5 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC, Splitter:B:23:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[Catch:{ IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0047  */
    private String b(Context context) {
        InputStream inputStream;
        Throwable th;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        if (context == null) {
            return null;
        }
        try {
            inputStream = context.getAssets().open("dinamic/dx_appstyle.json");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException unused3) {
                if (bufferedReader != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            inputStream = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                    throw th;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return sb.toString();
    }

    public JSONObject c() {
        JSONObject jSONObject = this.a;
        if (jSONObject != null && this.b) {
            return jSONObject;
        }
        JSONObject parseObject = JSON.parseObject(b(b.a()));
        this.a = parseObject;
        this.b = true;
        return parseObject;
    }
}
