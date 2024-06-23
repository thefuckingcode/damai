package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
public class x11 extends j2<Integer> {
    public x11(String str) {
        super(str);
    }

    /* renamed from: a */
    public void set(Span span, Integer num) {
        span.setTag(this.a, num);
    }
}
