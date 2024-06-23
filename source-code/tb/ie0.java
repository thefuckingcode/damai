package tb;

import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;

/* compiled from: Taobao */
public class ie0 {
    public static final int ERROR_NO_CONNECT = 0;
    public static final int ERROR_UNKNOWN = 1;
    public static final int ERROR_UN_INIT = 2;
    private int a;
    private Throwable b;
    private Request c;
    private Response d;
    private String e;
    private Object f;

    ie0() {
    }

    public void a(Request request, int i, Throwable th) {
        this.c = request;
        this.b = th;
        this.a = i;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[@ErrorResponse");
        sb.append(hashCode());
        sb.append(",");
        sb.append("errorCode=");
        sb.append(this.a);
        sb.append(",");
        sb.append("cause=");
        Throwable th = this.b;
        String str2 = "null";
        if (th == null) {
            str = str2;
        } else {
            str = th.toString();
        }
        sb.append(str);
        sb.append(",");
        sb.append("requestData=");
        Request request = this.c;
        sb.append(request != null ? request.toString() : str2);
        sb.append(",");
        sb.append("responseData=");
        Response response = this.d;
        if (response != null) {
            str2 = response.toString();
        }
        sb.append(str2);
        sb.append(",");
        sb.append("description=");
        sb.append(this.e);
        sb.append(",");
        if (this.f != null) {
            sb.append("reserved=");
            sb.append(this.f.toString());
            sb.append(",");
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }
}
