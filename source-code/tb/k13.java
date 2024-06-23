package tb;

/* compiled from: Taobao */
public final class k13 {
    public String a;
    public byte b = 2;
    public int c = 0;
    public String d = "none";
    public int e = 1;
    long f = 0;

    k13(String str, byte b2) {
        this.a = str;
        if (b2 <= 0 || 3 < b2) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b2)));
        }
        this.b = b2;
    }
}
