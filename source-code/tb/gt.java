package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.a;

/* compiled from: Taobao */
public class gt extends a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_EVENT_DMAUTOJUMP = -6351583547649020464L;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(lx lxVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        String str;
        Bundle bundle;
        Object obj;
        Object obj2;
        Object obj3;
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1784193469")) {
            ipChange.ipc$dispatch("-1784193469", new Object[]{this, lxVar, objArr, dXRuntimeContext});
        } else if (objArr != null && objArr.length > 0) {
            if (xp.a(objArr) >= 1) {
                Object obj4 = objArr[0];
                if (obj4 instanceof String) {
                    str = (String) obj4;
                    JSONArray jSONArray2 = null;
                    if (xp.a(objArr) >= 2 && (obj3 = objArr[1]) != null && (obj3 instanceof JSONArray)) {
                        jSONArray = (JSONArray) obj3;
                        if (c31.b(jSONArray) > 0) {
                            bundle = c31.a(jSONArray);
                            JSONArray jSONArray3 = (xp.a(objArr) >= 3 || (obj2 = objArr[2]) == null || !(obj2 instanceof JSONArray)) ? null : (JSONArray) obj2;
                            if (xp.a(objArr) >= 4 && (obj = objArr[3]) != null && (obj instanceof JSONArray)) {
                                jSONArray2 = (JSONArray) obj;
                            }
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            if (!TextUtils.isEmpty(str)) {
                                if (str.contains("damai://") || str.contains("http")) {
                                    DMNav.from(dXRuntimeContext.getContext()).withExtras(bundle).toUri(str);
                                } else {
                                    DMNav.from(dXRuntimeContext.getContext()).withExtras(bundle).toUri(NavUri.b(str));
                                }
                                if (c31.b(jSONArray3) >= 3) {
                                    pc0.a(jSONArray3, jSONArray2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    bundle = null;
                    if (xp.a(objArr) >= 3) {
                    }
                    jSONArray2 = (JSONArray) obj;
                    if (bundle == null) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                }
            }
            str = "";
            JSONArray jSONArray22 = null;
            jSONArray = (JSONArray) obj3;
            if (c31.b(jSONArray) > 0) {
            }
            bundle = null;
            if (xp.a(objArr) >= 3) {
            }
            jSONArray22 = (JSONArray) obj;
            if (bundle == null) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
        }
    }
}
