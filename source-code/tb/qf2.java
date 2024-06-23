package tb;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
public class qf2 extends j2<String> {
    public qf2(String str) {
        super(str);
    }

    /* renamed from: a */
    public void set(Span span, String str) {
        span.setTag(this.a, str);
    }
}
