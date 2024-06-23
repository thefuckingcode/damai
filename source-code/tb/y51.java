package tb;

import com.taobao.android.protodb.Iterator;

/* compiled from: Taobao */
public class y51 implements Iterator<u51> {
    private final String[] a;
    private int b = 0;

    public y51(String[] strArr) {
        this.a = strArr;
        this.b = 0;
    }

    /* renamed from: a */
    public u51 next() {
        int i;
        String[] strArr = this.a;
        if (strArr == null || (i = this.b) >= strArr.length) {
            return null;
        }
        this.b = i + 1;
        return new u51(strArr[i]);
    }
}
