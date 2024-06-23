package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigRegion;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
public class kb {
    private static transient /* synthetic */ IpChange $ipChange;
    private z30 a = z30.b(this);
    private LinkedHashMap<String, a40> b;
    private e40 c = e40.d();

    private kb() {
    }

    public static String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "417894615") ? (String) ipChange.ipc$dispatch("417894615", new Object[0]) : "dadafeed";
    }

    public static kb d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-929234603") ? (kb) ipChange.ipc$dispatch("-929234603", new Object[0]) : new kb();
    }

    private InputStream e(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188754223")) {
            return (InputStream) ipChange.ipc$dispatch("-1188754223", new Object[]{this, inputStream});
        }
        if (!inputStream.markSupported()) {
            new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(4);
            byte[] bArr = new byte[2];
            int read = inputStream.read(bArr, 0, 2);
            int i = 65535 & (bArr[0] + (bArr[1] << 8));
            inputStream.reset();
            if (read == 2 && i == 35615) {
                return new GZIPInputStream(inputStream);
            }
            return inputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return inputStream;
        }
    }

    public static String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1819404565") ? (String) ipChange.ipc$dispatch("1819404565", new Object[0]) : "0.4";
    }

    public LinkedHashMap<String, OrigRegion> a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805232092")) {
            return (LinkedHashMap) ipChange.ipc$dispatch("-1805232092", new Object[]{this, inputStream});
        }
        y30 a2 = this.a.a(e(inputStream));
        this.b = a2.a;
        this.c = a2.b;
        LinkedHashMap<String, OrigRegion> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, a40> entry : this.b.entrySet()) {
            a40 value = entry.getValue();
            value.e(entry.getKey());
            value.a();
            OrigRegion origRegion = new OrigRegion();
            origRegion.init(value.d(), value.c());
            linkedHashMap.put(value.d(), origRegion);
        }
        return linkedHashMap;
    }

    public e40 b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2093682439")) {
            return this.c;
        }
        return (e40) ipChange.ipc$dispatch("-2093682439", new Object[]{this});
    }
}
