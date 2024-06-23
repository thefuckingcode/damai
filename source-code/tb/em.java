package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
public class em extends va {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    private boolean m(IDMComponent iDMComponent) {
        boolean z;
        JSONObject stashData = iDMComponent.getStashData();
        JSONObject data = iDMComponent.getData();
        int i = 0;
        if (stashData == null || data == null) {
            return false;
        }
        try {
            JSONObject jSONObject = data.getJSONObject("fields");
            JSONObject jSONObject2 = stashData.getJSONObject("fields");
            if (jSONObject.containsKey(el1.KEY_COMPONENTS_GROUPS)) {
                JSONArray jSONArray = jSONObject.getJSONArray(el1.KEY_COMPONENTS_GROUPS);
                JSONArray jSONArray2 = jSONObject2.getJSONArray(el1.KEY_COMPONENTS_GROUPS);
                int min = Math.min(jSONArray.size(), jSONArray2.size());
                z = false;
                while (i < min) {
                    try {
                        z = n(((JSONObject) jSONArray.get(i)).getJSONObject(mr1.KEY_AS_SELECT), ((JSONObject) jSONArray2.get(i)).getJSONObject(mr1.KEY_AS_SELECT));
                        if (!z) {
                            break;
                        }
                        i++;
                    } catch (Exception unused) {
                        i = z;
                        z = i == true ? 1 : 0;
                        return !z;
                    }
                }
            } else {
                z = n(jSONObject.getJSONObject(mr1.KEY_AS_SELECT), jSONObject2.getJSONObject(mr1.KEY_AS_SELECT));
            }
        } catch (Exception unused2) {
            z = i == true ? 1 : 0;
            return !z;
        }
        return !z;
    }

    private boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.toJSONString().equals(jSONObject2.toJSONString());
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        jn2 i = this.c.getTradeEventHandler().i();
        if (i != null && this.e != null) {
            IDMComponent a = i.a();
            if (m(a)) {
                this.c.getDataManager().respondToLinkage(a, i);
            }
            this.c.getViewManager().closePopupWindow(true);
        }
    }
}
