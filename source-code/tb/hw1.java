package tb;

import cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig.OrigRegion;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public class hw1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static hw1 a;

    hw1() {
    }

    public static hw1 b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122840091")) {
            return (hw1) ipChange.ipc$dispatch("122840091", new Object[0]);
        }
        if (a == null) {
            synchronized (hw1.class) {
                if (a == null) {
                    a = new hw1();
                }
            }
        }
        return a;
    }

    public LinkedHashMap<String, OrigRegion> a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1978553282")) {
            return kb.d().a(inputStream);
        }
        return (LinkedHashMap) ipChange.ipc$dispatch("1978553282", new Object[]{this, inputStream});
    }

    public hw1 c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150409954")) {
            return (hw1) ipChange.ipc$dispatch("-1150409954", new Object[]{this});
        }
        cv0.c();
        return this;
    }
}
