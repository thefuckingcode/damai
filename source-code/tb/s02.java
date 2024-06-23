package tb;

import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.response.Response;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: Taobao */
public class s02 {
    private static Queue<ie0> a = new ArrayDeque(7);
    private static Queue<dk2> b = new ArrayDeque(7);
    private static Queue<sd> c = new ArrayDeque(7);
    private static Queue<mq1> d = new ArrayDeque(7);
    private static Queue<ar1> e = new ArrayDeque(7);

    public static Response<ByteBuffer> a() {
        sd poll = c.poll();
        return poll == null ? new sd() : poll;
    }

    public static ie0 b() {
        ie0 poll = a.poll();
        return poll == null ? new ie0() : poll;
    }

    public static Response<Framedata> c() {
        mq1 poll = d.poll();
        return poll == null ? new mq1() : poll;
    }

    public static Response<Framedata> d() {
        ar1 poll = e.poll();
        return poll == null ? new ar1() : poll;
    }

    public static Response<String> e() {
        dk2 poll = b.poll();
        return poll == null ? new dk2() : poll;
    }

    static void f(sd sdVar) {
        c.offer(sdVar);
    }

    static void g(mq1 mq1) {
        d.offer(mq1);
    }

    static void h(ar1 ar1) {
        e.offer(ar1);
    }

    static void i(dk2 dk2) {
        b.offer(dk2);
    }
}
