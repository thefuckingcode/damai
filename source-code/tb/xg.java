package tb;

import android.net.Uri;
import android.os.IBinder;
import com.taobao.aranger.core.ipc.channel.a;
import com.taobao.aranger.core.ipc.channel.b;
import com.taobao.aranger.core.ipc.channel.c;
import com.taobao.aranger.core.ipc.channel.d;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class xg {
    private static final ConcurrentHashMap<Uri, b> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<IBinder, a> b = new ConcurrentHashMap<>();

    public static a a(IBinder iBinder) {
        ConcurrentHashMap<IBinder, a> concurrentHashMap = b;
        a aVar = concurrentHashMap.get(iBinder);
        if (aVar != null) {
            return aVar;
        }
        c cVar = new c(iBinder);
        concurrentHashMap.putIfAbsent(iBinder, cVar);
        return cVar;
    }

    public static b b(Uri uri) {
        ConcurrentHashMap<Uri, b> concurrentHashMap = a;
        b bVar = concurrentHashMap.get(uri);
        if (bVar != null) {
            return bVar;
        }
        d dVar = new d(uri);
        concurrentHashMap.putIfAbsent(uri, dVar);
        return dVar;
    }
}
