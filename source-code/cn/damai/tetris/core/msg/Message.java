package cn.damai.tetris.core.msg;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class Message implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public Object value;
    public int what;

    public Message(int i, Object obj) {
        this.what = i;
        this.value = obj;
    }

    public static Message get(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1439374403")) {
            return new Message(i, obj);
        }
        return (Message) ipChange.ipc$dispatch("-1439374403", new Object[]{Integer.valueOf(i), obj});
    }
}
