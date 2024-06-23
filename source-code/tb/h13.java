package tb;

/* compiled from: Taobao */
public class h13 extends ej2 {
    public boolean d;

    public h13(String str, String str2, String str3, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public String toString() {
        return "[retryable:" + this.d + " code:" + this.a + " subcode:" + this.b + " info:" + this.c + jl1.ARRAY_END_STR;
    }
}
