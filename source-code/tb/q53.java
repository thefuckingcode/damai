package tb;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: Taobao */
public final class q53 extends l63 {
    Map<String, String> l = null;
    Map<String, String> m = null;
    String n = "";
    byte[] o = null;
    private String p = null;

    public final void J(Map<String, String> map) {
        this.l = map;
    }

    public final void K(byte[] bArr) {
        this.o = bArr;
    }

    public final void L(String str) {
        this.n = str;
    }

    public final void M(Map<String, String> map) {
        this.m = map;
    }

    public final void N(String str) {
        this.p = str;
    }

    @Override // com.loc.bl
    public final Map<String, String> b() {
        return this.l;
    }

    @Override // com.loc.bl
    public final String j() {
        return this.n;
    }

    @Override // com.loc.bl, tb.l63
    public final String m() {
        return !TextUtils.isEmpty(this.p) ? this.p : super.m();
    }

    @Override // com.loc.bl
    public final Map<String, String> q() {
        return this.m;
    }

    @Override // com.loc.bl
    public final byte[] r() {
        return this.o;
    }
}
