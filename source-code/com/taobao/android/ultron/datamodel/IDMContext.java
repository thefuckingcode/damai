package com.taobao.android.ultron.datamodel;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;
import tb.mc0;
import tb.vu2;

/* compiled from: Taobao */
public interface IDMContext {
    IDMComponent getComponentByName(String str);

    List<IDMComponent> getComponents();

    List<IDMComponent> getComponentsByRoot(String str);

    List<mc0> getDynamicTemplateList();

    JSONObject getGlobal();

    String getProtocolVersion();

    IDMComponent getRootComponent();

    boolean isCacheData();

    void setBizName(String str);

    void setComponents(List<IDMComponent> list);

    void setSubmitModule(ISubmitModule iSubmitModule);

    vu2 validate();
}
