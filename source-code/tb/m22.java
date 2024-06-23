package tb;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.dinamic.parser.a;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
public class m22 extends z1 {
    private Constructor<?> a;

    public m22() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.FileParser", "Fail to get XmlBlock", e);
        }
    }

    public boolean c(DinamicTemplate dinamicTemplate) {
        return new File("/sdcard/com.taobao.taobao/home", dinamicTemplate.name).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[Catch:{ Exception -> 0x007d }] */
    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, ew2 ew2) {
        byte[] bArr;
        byte[] a2;
        Object b;
        if (this.a == null || TextUtils.isEmpty(dinamicTemplate.name)) {
            return null;
        }
        try {
            File file = new File("/sdcard/com.taobao.taobao/home", dinamicTemplate.name);
            if (file.exists()) {
                bArr = a.a(new FileInputStream(file));
                a2 = a(bArr, ew2);
                if (!(a2 == null || a2.length == 0)) {
                    Log.d("Home.FileParser", "File parser is applied: " + dinamicTemplate.name);
                    b = bz1.b(this.a.newInstance(a2), "newParser", new Object[0]);
                    if (b instanceof XmlResourceParser) {
                        return (XmlResourceParser) b;
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Log.e("Home.FileParser", "Fail to read sdcard layout: " + dinamicTemplate.name, e);
        }
        bArr = null;
        a2 = a(bArr, ew2);
        Log.d("Home.FileParser", "File parser is applied: " + dinamicTemplate.name);
        try {
            b = bz1.b(this.a.newInstance(a2), "newParser", new Object[0]);
            if (b instanceof XmlResourceParser) {
            }
        } catch (Exception e2) {
            Log.e("Home.FileParser", "New sdcard parser exception: " + dinamicTemplate.name, e2);
        }
        return null;
    }
}
