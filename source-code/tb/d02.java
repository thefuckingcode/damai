package tb;

import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: Taobao */
public class d02 {
    private static Queue<of2> a = new ArrayDeque(7);

    static {
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
        new ArrayDeque(7);
    }

    public static Request<String> a() {
        of2 poll = a.poll();
        return poll == null ? new of2() : poll;
    }

    static void b(of2 of2) {
        a.offer(of2);
    }
}
