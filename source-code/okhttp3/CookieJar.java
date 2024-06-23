package okhttp3;

import java.util.Collections;
import java.util.List;
import tb.ln;

/* compiled from: Taobao */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new a();

    /* compiled from: Taobao */
    class a implements CookieJar {
        a() {
        }

        @Override // okhttp3.CookieJar
        public List<ln> loadForRequest(m mVar) {
            return Collections.emptyList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(m mVar, List<ln> list) {
        }
    }

    List<ln> loadForRequest(m mVar);

    void saveFromResponse(m mVar, List<ln> list);
}
