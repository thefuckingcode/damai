package cn.damai.tetris.page;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import tb.py2;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final String b;
    private final String c;

    public a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1867265994")) {
            return this.c;
        }
        return (String) ipChange.ipc$dispatch("1867265994", new Object[]{this});
    }

    public String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458048474")) {
            return (String) ipChange.ipc$dispatch("458048474", new Object[]{this, str});
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(1000);
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() == 200) {
                return new String(f(httpURLConnection.getInputStream()), "UTF-8");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "717458175")) {
            return (String) ipChange.ipc$dispatch("717458175", new Object[]{this});
        }
        String replace = "https://oss.taopiaopiao.com/patternName_version_bak_cityid.json".replace("cityid", a()).replace("patternName", d()).replace("version", e());
        String b2 = b(replace);
        py2.a(this.a, this.b, replace);
        return b2;
    }

    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1458774815")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("1458774815", new Object[]{this});
    }

    public String e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-891850308")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("-891850308", new Object[]{this});
    }

    public byte[] f(InputStream inputStream) throws Exception {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920946854")) {
            return (byte[]) ipChange.ipc$dispatch("-920946854", new Object[]{this, inputStream});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public a() {
        this.a = "";
        this.b = "";
        this.c = "";
    }
}
