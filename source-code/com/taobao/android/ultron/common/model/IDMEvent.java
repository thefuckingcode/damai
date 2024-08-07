package com.taobao.android.ultron.common.model;

import com.alibaba.fastjson.JSONObject;
import java.util.List;

/* compiled from: Taobao */
public interface IDMEvent {
    List<IDMComponent> getComponents();

    JSONObject getFields();

    String getType();

    void record();

    void rollBack();

    void writeFields(String str, Object obj);
}
