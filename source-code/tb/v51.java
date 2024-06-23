package tb;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Taobao */
public class v51 {
    private static v51 c = new v51();
    private c a = new c();
    private b b = new b();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b implements Comparator<String> {
        private b(v51 v51) {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c implements Comparator<String> {
        private c(v51 v51) {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * -1;
        }
    }

    private v51() {
    }

    public static v51 a() {
        return c;
    }

    public String[] b(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.b;
        } else {
            comparator = this.a;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }
}
