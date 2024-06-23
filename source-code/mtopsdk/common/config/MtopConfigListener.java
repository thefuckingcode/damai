package mtopsdk.common.config;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
public interface MtopConfigListener {
    String getConfig(String str, String str2, String str3);

    Map<String, String> getSwitchConfigByGroupName(String str);

    void initConfig(Context context);
}
