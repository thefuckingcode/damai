package com.taobao.weex.ui.component.list.template;

import java.util.HashMap;
import java.util.Map;
import tb.v7;

/* compiled from: Taobao */
public class CellRenderContext {
    public Map map = new HashMap(8);
    public int position;
    public CellRenderState renderState;
    public v7 stack = new v7();
    public WXRecyclerTemplateList templateList;

    public void clear() {
        if (this.stack.c().size() > 0) {
            this.stack.c().clear();
        }
        if (this.map.size() > 0) {
            this.map.clear();
        }
        this.renderState = null;
        this.position = 0;
        this.templateList = null;
    }

    public CellRenderState getRenderState() {
        if (this.renderState != null) {
            this.renderState = this.templateList.getCellDataManager().getRenderState(this.position);
        }
        return this.renderState;
    }
}
