package com.taobao.android.ultron.common.model;

import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import tb.vu2;

/* compiled from: Taobao */
public interface IDMComponent extends Serializable {

    /* compiled from: Taobao */
    public interface CustomValidate {
        vu2 onCustomValidate(IDMComponent iDMComponent);
    }

    String getCardGroup();

    List<IDMComponent> getChildren();

    JSONObject getContainerInfo();

    String getContainerType();

    JSONObject getData();

    Map<String, List<IDMEvent>> getEventMap();

    JSONObject getEvents();

    ArrayMap<String, Object> getExtMap();

    JSONObject getFields();

    JSONObject getHidden();

    String getId();

    String getKey();

    LinkageType getLinkageType();

    int getModifiedCount();

    IDMComponent getParent();

    String getPosition();

    JSONObject getStashData();

    int getStatus();

    String getTag();

    String getType();

    void record();

    void rollBack();

    void setCustomValidate(CustomValidate customValidate);

    void updateModifiedCount();

    vu2 validate();

    void writeFields(String str, Object obj);
}
