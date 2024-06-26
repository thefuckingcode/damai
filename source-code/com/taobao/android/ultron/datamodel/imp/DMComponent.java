package com.taobao.android.ultron.datamodel.imp;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.l.c;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.common.model.LinkageType;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.youku.resource.widget.YKActionSheet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import tb.t12;
import tb.tr2;
import tb.vu2;

/* compiled from: Taobao */
public class DMComponent implements IDMComponent, Serializable, Cloneable {
    private static final String BOOL_TRUE_VALUE = "true";
    private static final String STRING_UNDERLINE = "_";
    private static final String TAG = "DMComponent";
    String mBizName;
    private List<IDMComponent> mChildren = new ArrayList();
    JSONObject mContainerInfo;
    String mContainerType = "native";
    private IDMComponent.CustomValidate mCustomValidate;
    JSONObject mData;
    private Map<String, List<IDMEvent>> mEventMap;
    JSONObject mEvents;
    private ArrayMap<String, Object> mExtMap = new ArrayMap<>();
    boolean mExtendBlock;
    JSONObject mFields;
    boolean mHasMore;
    JSONObject mHidden;
    String mID;
    LinkageType mLinkageType = LinkageType.REFRESH;
    int mModifiedCount;
    DMComponent mParent;
    private JSONObject mStashData;
    String mSubmit;
    String mTag;
    String mTriggerEvent;
    String mType;

    public DMComponent(JSONObject jSONObject, String str, JSONObject jSONObject2, Map<String, List<IDMEvent>> map) {
        this.mContainerType = str;
        this.mContainerInfo = jSONObject2;
        this.mEventMap = map;
        loadData(jSONObject);
    }

    private void loadData(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mData = jSONObject;
            this.mID = jSONObject.getString("id");
            this.mTag = jSONObject.getString("tag");
            this.mType = this.mData.getString("type");
            this.mSubmit = jSONObject.getString("submit");
            this.mBizName = jSONObject.getString("bizName");
            JSONObject jSONObject2 = jSONObject.getJSONObject("fields");
            boolean z = false;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
                jSONObject.put("fields", (Object) jSONObject2);
                tr2.b(TAG, "original fields not exist， fix it", this.mTag, this.mID);
            }
            this.mFields = jSONObject2;
            if (this.mTag == null) {
                this.mTag = "";
                jSONObject.put("tag", "");
            }
            if (this.mType == null) {
                this.mType = "";
                jSONObject.put("type", "");
            }
            this.mHidden = this.mData.getJSONObject("hidden");
            this.mEvents = this.mData.getJSONObject("events");
            this.mExtendBlock = this.mData.containsKey("extendBlock") ? this.mData.getBoolean("extendBlock").booleanValue() : false;
            if (this.mData.containsKey("hasMore")) {
                z = this.mData.getBoolean("hasMore").booleanValue();
            }
            this.mHasMore = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void addChild(IDMComponent iDMComponent) {
        this.mChildren.add(iDMComponent);
    }

    public void addChildren(List<IDMComponent> list) {
        this.mChildren.addAll(list);
    }

    /* access modifiers changed from: protected */
    public JSONObject adjustData() {
        return this.mData;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getCardGroup() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return "unknown";
        }
        return jSONObject.getString("cardGroup");
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public List<IDMComponent> getChildren() {
        return this.mChildren;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getContainerInfo() {
        return this.mContainerInfo;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getContainerType() {
        return this.mContainerType;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getData() {
        return this.mData;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public Map<String, List<IDMEvent>> getEventMap() {
        return this.mEventMap;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getEvents() {
        return this.mEvents;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public ArrayMap<String, Object> getExtMap() {
        return this.mExtMap;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getFields() {
        return this.mFields;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getHidden() {
        return this.mHidden;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getId() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return "unknown";
        }
        return jSONObject.getString("id");
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getKey() {
        String tag = getTag();
        String id = getId();
        if (tag == null || id == null) {
            return null;
        }
        return tag + "_" + id;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public LinkageType getLinkageType() {
        return this.mLinkageType;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public int getModifiedCount() {
        return this.mModifiedCount;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public IDMComponent getParent() {
        return this.mParent;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getPosition() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return "unknown";
        }
        return jSONObject.getString("position");
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public JSONObject getStashData() {
        return this.mStashData;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public int getStatus() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return 2;
        }
        String string = jSONObject.getString("status");
        if ("hidden".equals(string)) {
            return 0;
        }
        return YKActionSheet.ACTION_STYLE_DISABLE.equals(string) ? 1 : 2;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getTag() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return "unknown";
        }
        return jSONObject.getString("tag");
    }

    public String getTriggerEvent() {
        return this.mTriggerEvent;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public String getType() {
        JSONObject jSONObject = this.mData;
        if (jSONObject == null) {
            return "unknown";
        }
        return jSONObject.getString("type");
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public boolean isExtendBlock() {
        return this.mExtendBlock;
    }

    /* access modifiers changed from: protected */
    public void onReload(IDMContext iDMContext, JSONObject jSONObject) {
        loadData(jSONObject);
    }

    /* access modifiers changed from: protected */
    public void onReloadEvent(Map<String, List<IDMEvent>> map) {
        this.mEventMap = map;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public void record() {
        this.mStashData = JSON.parseObject(this.mData.toJSONString());
        Map<String, List<IDMEvent>> map = this.mEventMap;
        if (map != null) {
            t12.a(map);
        }
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public void rollBack() {
        JSONObject jSONObject = this.mStashData;
        if (jSONObject != null) {
            loadData(jSONObject);
            this.mStashData = null;
        }
        Map<String, List<IDMEvent>> map = this.mEventMap;
        if (map != null) {
            t12.b(map);
        }
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public void setCustomValidate(IDMComponent.CustomValidate customValidate) {
        this.mCustomValidate = customValidate;
    }

    /* access modifiers changed from: package-private */
    public void setLinkageType(LinkageType linkageType) {
        this.mLinkageType = linkageType;
    }

    public void setParent(DMComponent dMComponent) {
        this.mParent = dMComponent;
    }

    public void setTriggerEvent(String str) {
        this.mTriggerEvent = str;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldSubmit() {
        String str = this.mSubmit;
        if (str != null) {
            return str.equalsIgnoreCase("true");
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public JSONObject submitData() {
        return this.mData;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public void updateModifiedCount() {
        this.mModifiedCount++;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public vu2 validate() {
        JSONObject jSONObject;
        int size;
        IDMComponent.CustomValidate customValidate = this.mCustomValidate;
        if (customValidate != null) {
            return customValidate.onCustomValidate(this);
        }
        vu2 vu2 = new vu2();
        JSONObject jSONObject2 = this.mData;
        if (jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject(c.j)) == null) {
            return vu2;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("fields");
        JSONArray jSONArray2 = jSONObject.getJSONArray("regex");
        JSONArray jSONArray3 = jSONObject.getJSONArray("msg");
        if (jSONArray != null && jSONArray2 != null && jSONArray3 != null && !jSONArray.isEmpty() && (size = jSONArray.size()) == jSONArray2.size() && size == jSONArray3.size()) {
            for (int i = 0; i < size; i++) {
                String string = this.mFields.getString(jSONArray.getString(i));
                if (string == null) {
                    string = "";
                }
                String string2 = jSONArray2.getString(i);
                String string3 = jSONArray3.getString(i);
                Pattern pattern = null;
                try {
                    pattern = Pattern.compile(string2);
                } catch (Exception unused) {
                }
                if (pattern != null && !pattern.matcher(string).find()) {
                    vu2.f(false);
                    vu2.e(string3);
                    vu2.d(this);
                    return vu2;
                }
            }
        }
        return vu2;
    }

    @Override // com.taobao.android.ultron.common.model.IDMComponent
    public void writeFields(String str, Object obj) {
        if (this.mFields != null && !TextUtils.isEmpty(str) && obj != null) {
            this.mFields.put(str, obj);
        }
    }
}
