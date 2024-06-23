package com.alibaba.poplayer.trigger.view;

import com.alibaba.poplayer.trigger.BaseConfigItem;

/* compiled from: Taobao */
public class ViewConfigItem extends BaseConfigItem {
    public static String LOG = "ViewConfigItem";
    public boolean continuousSelect = true;
    public String operationName = TrackingService.OPER_TRACK;
    public BaseConfigItem.a pageInfo;
    public boolean selectFromCache = true;
    public String viewuri;

    @Override // com.alibaba.poplayer.trigger.BaseConfigItem
    public String toString() {
        return "View{pageInfo=" + this.pageInfo + ", viewuri='" + this.viewuri + '\'' + ", continuousSelect=" + this.continuousSelect + ", selectFromCache=" + this.selectFromCache + ", operationName='" + this.operationName + '\'' + '}' + super.toString();
    }
}
