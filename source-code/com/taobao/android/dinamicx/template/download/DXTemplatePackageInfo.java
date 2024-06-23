package com.taobao.android.dinamicx.template.download;

import java.util.Map;

/* compiled from: Taobao */
public class DXTemplatePackageInfo implements Cloneable {
    public String mainFilePath;
    public Map<String, String> subFilePathDict;

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public DXTemplatePackageInfo clone() {
        DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
        dXTemplatePackageInfo.mainFilePath = this.mainFilePath;
        dXTemplatePackageInfo.subFilePathDict = this.subFilePathDict;
        return dXTemplatePackageInfo;
    }
}
