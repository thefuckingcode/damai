package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.loader.network.HttpLoader;
import com.taobao.phenix.loader.network.a;

/* compiled from: Taobao */
public class sy0 implements Builder<HttpLoader> {
    public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    public static final int DEFAULT_READ_TIMEOUT = 10000;
    private boolean a;
    private HttpLoader b;
    private Integer c;
    private Integer d;

    /* renamed from: a */
    public synchronized HttpLoader build() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        if (this.b == null) {
            this.b = new a();
        }
        HttpLoader httpLoader = this.b;
        Integer num = this.c;
        httpLoader.connectTimeout(num != null ? num.intValue() : 15000);
        HttpLoader httpLoader2 = this.b;
        Integer num2 = this.d;
        httpLoader2.readTimeout(num2 != null ? num2.intValue() : 10000);
        return this.b;
    }

    /* renamed from: b */
    public sy0 with(HttpLoader httpLoader) {
        cs1.e(!this.a, "HttpLoaderBuilder has been built, not allow with() now");
        this.b = httpLoader;
        return this;
    }
}
