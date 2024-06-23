package com.taobao.weex.ui.component.list.template;

import java.util.HashMap;
import java.util.Map;
import tb.v7;

/* compiled from: Taobao */
public class CellRenderState {
    boolean hasDataUpdate = false;
    boolean hasPositionChange = false;
    boolean hasVirtualCompoentUpdate = false;
    long itemId = -1;
    private Map<String, v7> onceComponentStates;
    int position;
    private Map<String, Object> virtualComponentDatas;
    private Map<String, String> virtualComponentIds;

    public Map<String, v7> getOnceComponentStates() {
        if (this.onceComponentStates == null) {
            this.onceComponentStates = new HashMap();
        }
        return this.onceComponentStates;
    }

    public Map<String, Object> getVirtualComponentDatas() {
        if (this.virtualComponentDatas == null) {
            this.virtualComponentDatas = new HashMap(4);
        }
        return this.virtualComponentDatas;
    }

    public Map<String, String> getVirtualComponentIds() {
        if (this.virtualComponentIds == null) {
            this.virtualComponentIds = new HashMap(8);
        }
        return this.virtualComponentIds;
    }

    public boolean hasVirtualComponents() {
        Map<String, String> map = this.virtualComponentIds;
        return map != null && map.size() > 0;
    }

    public boolean isDirty() {
        return this.hasDataUpdate || this.hasVirtualCompoentUpdate || this.hasPositionChange;
    }

    public boolean isHasDataUpdate() {
        return this.hasDataUpdate;
    }

    public void resetDirty() {
        this.hasDataUpdate = false;
        this.hasVirtualCompoentUpdate = false;
        this.hasPositionChange = false;
    }
}
