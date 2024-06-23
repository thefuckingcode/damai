package tb;

import android.os.AsyncTask;
import com.taobao.android.dinamic.expression.parser.resolver.e;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: Taobao */
public class a7 extends v0 {

    /* compiled from: Taobao */
    class a extends AsyncTask<Void, Void, Void> {
        a(a7 a7Var) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            b7.a().c();
            return null;
        }
    }

    public a7() {
        new a(this).execute(new Void[0]);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, x70 x70) {
        Object obj;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    Object obj2 = list.get(0);
                    if (obj2 != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(obj2.toString(), " .[]", false);
                        if (stringTokenizer.hasMoreTokens()) {
                            obj = b7.a().c();
                            while (stringTokenizer.hasMoreTokens()) {
                                obj = e.a(obj, stringTokenizer.nextToken());
                            }
                            return (obj != null && list.size() > 1) ? list.get(1) : obj;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return obj;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                x70.e().b().a(r70.ERROR_CODE_TEMPLATE_PARSER_EXCEPTION, "AppStyleParser parse error");
            }
        }
        return null;
    }
}
