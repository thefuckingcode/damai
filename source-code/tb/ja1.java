package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
public class ja1 extends j2<Long> {
    public ja1(String str) {
        super(str);
    }

    /* renamed from: a */
    public void set(Span span, Long l) {
        span.setTag(this.a, l);
    }
}
