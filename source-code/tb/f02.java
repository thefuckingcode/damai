package tb;

import java.net.Proxy;
import okhttp3.m;
import okhttp3.o;

/* compiled from: Taobao */
public final class f02 {
    public static String a(o oVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(oVar.g());
        sb.append(' ');
        if (b(oVar, type)) {
            sb.append(oVar.i());
        } else {
            sb.append(c(oVar.i()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(o oVar, Proxy.Type type) {
        return !oVar.f() && type == Proxy.Type.HTTP;
    }

    public static String c(m mVar) {
        String h = mVar.h();
        String j = mVar.j();
        if (j == null) {
            return h;
        }
        return h + jl1.CONDITION_IF + j;
    }
}
