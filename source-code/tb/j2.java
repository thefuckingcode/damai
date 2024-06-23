package tb;

import com.taobao.opentracing.api.tag.Tag;

/* compiled from: Taobao */
public abstract class j2<T> implements Tag<T> {
    protected final String a;

    public j2(String str) {
        this.a = str;
    }

    @Override // com.taobao.opentracing.api.tag.Tag
    public String getKey() {
        return this.a;
    }
}
