package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
public class s42 {
    private String a;
    private byte[] b;

    public s42(String str) {
        this.a = str;
    }

    public byte[] a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        byte[] bArr;
        return TextUtils.isEmpty(this.a) && ((bArr = this.b) == null || bArr.length == 0);
    }

    public int d() {
        String str = this.a;
        if (str != null) {
            return str.length();
        }
        byte[] bArr = this.b;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public s42(byte[] bArr) {
        this.b = bArr;
    }
}
