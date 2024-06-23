package anetwork.channel;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public interface NetworkCallBack$ResponseCodeListener extends NetworkListener {
    boolean onResponseCode(int i, Map<String, List<String>> map, Object obj);
}
