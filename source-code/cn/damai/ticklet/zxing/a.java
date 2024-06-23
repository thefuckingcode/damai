package cn.damai.ticklet.zxing;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import java.util.Hashtable;
import tb.dw1;
import tb.ge0;
import tb.od0;
import tb.rd0;
import tb.t9;
import tb.vb;
import tb.vd;

/* compiled from: Taobao */
public final class a implements Writer {
    private static transient /* synthetic */ IpChange $ipChange;

    private static vb a(dw1 dw1, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914457086")) {
            return (vb) ipChange.ipc$dispatch("-914457086", new Object[]{dw1, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        vd c = dw1.c();
        int e = c.e();
        int d = c.d();
        int max = Math.max(i, e);
        int max2 = Math.max(i2, d);
        int min = Math.min(max / e, max2 / d);
        int i3 = (max - (e * min)) / 2;
        int i4 = (max2 - (d * min)) / 2;
        vb vbVar = new vb(max, max2);
        int i5 = 0;
        while (i5 < d) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < e) {
                if (c.b(i7, i5) == 1) {
                    vbVar.d(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return vbVar;
    }

    @Override // com.google.zxing.Writer
    public vb encode(String str, t9 t9Var, int i, int i2) throws WriterException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1858851980")) {
            return encode(str, t9Var, i, i2, null);
        }
        return (vb) ipChange.ipc$dispatch("-1858851980", new Object[]{this, str, t9Var, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Override // com.google.zxing.Writer
    public vb encode(String str, t9 t9Var, int i, int i2, Hashtable hashtable) throws WriterException {
        ge0 ge0;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456734869")) {
            return (vb) ipChange.ipc$dispatch("1456734869", new Object[]{this, str, t9Var, Integer.valueOf(i), Integer.valueOf(i2), hashtable});
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (t9Var != t9.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + t9Var);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            ge0 ge02 = ge0.L;
            if (!(hashtable == null || (ge0 = (ge0) hashtable.get(od0.ERROR_CORRECTION)) == null)) {
                ge02 = ge0;
            }
            dw1 dw1 = new dw1();
            rd0.l(str, ge02, hashtable, dw1);
            return a(dw1, i, i2);
        }
    }
}
