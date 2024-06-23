package com.youku.gaiax.module.render.view;

import androidx.recyclerview.widget.DiffUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001c\u0010\u000b\u001a\u00020\n8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\n8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/module/render/view/GaiaXDefaultDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "Lcom/alibaba/fastjson/JSONArray;", "oldDatas", "Lcom/alibaba/fastjson/JSONArray;", "getOldDatas", "()Lcom/alibaba/fastjson/JSONArray;", "newDatas", "getNewDatas", "<init>", "(Lcom/alibaba/fastjson/JSONArray;Lcom/alibaba/fastjson/JSONArray;)V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GaiaXDefaultDiffCallBack extends DiffUtil.Callback {
    @NotNull
    private final JSONArray newDatas;
    @NotNull
    private final JSONArray oldDatas;

    public GaiaXDefaultDiffCallBack(@NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2) {
        k21.i(jSONArray, "oldDatas");
        k21.i(jSONArray2, "newDatas");
        this.oldDatas = jSONArray;
        this.newDatas = jSONArray2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        if (i != i2) {
            return false;
        }
        JSONObject jSONObject = this.oldDatas.getJSONObject(i);
        JSONObject jSONObject2 = this.newDatas.getJSONObject(i2);
        if (jSONObject == null || jSONObject2 == null) {
            return false;
        }
        String string = jSONObject.getString("id");
        String string2 = jSONObject2.getString("id");
        if (string != null && string2 != null && k21.d(string, string2)) {
            return true;
        }
        String string3 = jSONObject.getString("contentId");
        String string4 = jSONObject2.getString("contentId");
        if (string3 != null && string4 != null && k21.d(string3, string4)) {
            return true;
        }
        String string5 = jSONObject.getString("title");
        String string6 = jSONObject2.getString("title");
        if (string5 != null && string6 != null && k21.d(string5, string6)) {
            return true;
        }
        String j = zo0.j(jSONObject, "data.title");
        String j2 = zo0.j(jSONObject2, "data.title");
        if (j != null && j2 != null && k21.d(j, j2)) {
            return true;
        }
        String j3 = zo0.j(jSONObject, "text.title");
        String j4 = zo0.j(jSONObject2, "text.title");
        if (j3 == null || j4 == null || !k21.d(j3, j4)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final JSONArray getNewDatas() {
        return this.newDatas;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newDatas.size();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final JSONArray getOldDatas() {
        return this.oldDatas;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldDatas.size();
    }
}
