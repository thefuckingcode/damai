package cn.damai.tetris.v2.adpater;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.core.IModel;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import tb.o80;
import tb.wj2;

/* compiled from: Taobao */
public class VDinamicXViewHolder extends VBaseViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public DXTemplateItem d;

    public VDinamicXViewHolder(IContext iContext, View view, DXTemplateItem dXTemplateItem) {
        super(view, iContext);
        this.d = dXTemplateItem;
        view.setBackgroundColor(0);
    }

    private JSONObject f(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1170070832")) {
            return jSONObject;
        }
        return (JSONObject) ipChange.ipc$dispatch("1170070832", new Object[]{this, jSONObject});
    }

    private void g(DinamicXEngine dinamicXEngine) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472671412")) {
            ipChange.ipc$dispatch("-1472671412", new Object[]{this, dinamicXEngine});
            return;
        }
        String componentId = this.b.getComponentId();
        if (wj2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID.equals(componentId) || wj2.DX_MUSIC_FESTIVAL_IP_LIST_CID.equals(componentId)) {
            jSONObject = f(this.b.getItem());
        } else {
            jSONObject = f(this.b.getRawData());
        }
        View view = this.itemView;
        if (view instanceof DXRootView) {
            dinamicXEngine.Q((DXRootView) view, jSONObject);
        } else if (((ViewGroup) view).getChildAt(0) != null && (((ViewGroup) this.itemView).getChildAt(0) instanceof DXRootView)) {
            dinamicXEngine.Q((DXRootView) ((ViewGroup) this.itemView).getChildAt(0), jSONObject);
        } else if (((ViewGroup) this.itemView).getChildCount() == 2 && ((ViewGroup) this.itemView).getChildAt(1) != null && (((ViewGroup) this.itemView).getChildAt(1) instanceof DXRootView)) {
            dinamicXEngine.Q((DXRootView) ((ViewGroup) this.itemView).getChildAt(1), jSONObject);
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.v2.adpater.VBaseViewHolder
    public IModel b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386131539")) {
            return (IModel) ipChange.ipc$dispatch("-1386131539", new Object[]{this});
        }
        DinamicXEngine dXEngine = this.a.getDXEngine();
        if (dXEngine == null) {
            return null;
        }
        DXTemplateItem h = dXEngine.h(this.d);
        if (h == null || this.d.version != h.version) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.d);
            dXEngine.g(arrayList);
            o80.a(this);
        } else {
            g(dXEngine);
        }
        return null;
    }

    public void h(DXTemplateItem dXTemplateItem) {
        DinamicXEngine dXEngine;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447585553")) {
            ipChange.ipc$dispatch("447585553", new Object[]{this, dXTemplateItem});
        } else if (dXTemplateItem.equals(this.d) && (dXEngine = this.a.getDXEngine()) != null && this.b != null) {
            g(dXEngine);
        }
    }
}
