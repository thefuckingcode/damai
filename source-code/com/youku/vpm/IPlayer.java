package com.youku.vpm;

import com.youku.vpm.framework.TableId;
import java.util.Map;

/* compiled from: Taobao */
public interface IPlayer extends IExt, IMonitor {
    Map<String, String> getAllDims(TableId tableId);

    Map<String, String> getAllValues(TableId tableId);

    String getPlayerInfoByKey(int i);
}
