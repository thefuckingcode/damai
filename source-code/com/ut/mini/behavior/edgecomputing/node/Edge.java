package com.ut.mini.behavior.edgecomputing.node;

import android.os.Build;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.behavior.edgecomputing.datacollector.UTDataCollector;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorEdgeColumn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class Edge {
    private static final String TABLE_TYPE = "ut";
    public static final String TAG = "Edge";
    public Map<String, Object> baseSaveMap;
    public String create_time = "";
    public long id = -1;
    public String left_event_id = "";
    public String left_event_name = "";
    public long left_node_id = 0;
    public String left_scene = "";
    public String left_table = "";
    public String right_event_id = "";
    public String right_event_name = "";
    public long right_node_id = 0;
    public String right_scene = "";
    public String right_table = "";
    public String update_time = "";

    public Map<String, Object> getBaseSaveMap() {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.baseSaveMap = synchronizedMap;
        synchronizedMap.put(UTDataCollectorEdgeColumn.LEFT_NODE_ID, Long.valueOf(this.left_node_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_NODE_ID, Long.valueOf(this.right_node_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_TABLE, BaseNodeHelper.stringNotNull(this.left_table));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_TABLE, BaseNodeHelper.stringNotNull(this.right_table));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_EVENT_ID, BaseNodeHelper.stringNotNull(this.left_event_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_EVENT_ID, BaseNodeHelper.stringNotNull(this.right_event_id));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_EVENT_NAME, BaseNodeHelper.stringNotNull(this.left_event_name));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_EVENT_NAME, BaseNodeHelper.stringNotNull(this.right_event_name));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.LEFT_SCENE, BaseNodeHelper.stringNotNull(this.left_scene));
        this.baseSaveMap.put(UTDataCollectorEdgeColumn.RIGHT_SCENE, BaseNodeHelper.stringNotNull(this.right_scene));
        this.baseSaveMap.put("create_time", BaseNodeHelper.stringNotNull(this.create_time));
        return this.baseSaveMap;
    }

    /* access modifiers changed from: package-private */
    public String getType() {
        return "edge";
    }

    public long save() {
        Map<String, Object> baseSaveMap2 = getBaseSaveMap();
        this.baseSaveMap = baseSaveMap2;
        if (baseSaveMap2 != null && Build.VERSION.SDK_INT >= 21) {
            return UTDataCollector.getInstance().getDataCollectorAdapter().commit(TABLE_TYPE, getType(), this.create_time, this.baseSaveMap);
        }
        return -1;
    }

    public long update() {
        Logger.f(TAG, "update id", Long.valueOf(this.id));
        if (this.id < 0) {
            return -1;
        }
        Map<String, Object> baseSaveMap2 = getBaseSaveMap();
        this.baseSaveMap = baseSaveMap2;
        if (baseSaveMap2 == null || Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        return UTDataCollector.getInstance().getDataCollectorAdapter().update(TABLE_TYPE, getType(), "" + System.currentTimeMillis(), "id=" + this.id, null, this.baseSaveMap);
    }
}
