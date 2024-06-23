package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.e;

/* compiled from: Taobao */
public class e80 {
    @NonNull
    public static String a(e eVar) {
        StringBuilder sb = new StringBuilder();
        if (eVar == null) {
            sb.append("dxError is null");
            return sb.toString();
        }
        for (e.a aVar : eVar.c) {
            sb.append(aVar.toString());
        }
        return sb.toString();
    }
}
