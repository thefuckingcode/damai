package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.android.ultron.datamodel.imp.a;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class t90 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017123551")) {
            ipChange.ipc$dispatch("-2017123551", new Object[]{this, jn2});
            return;
        }
        CharSequence charSequence = (CharSequence) f(0);
        CharSequence charSequence2 = (CharSequence) f(1);
        IDMComponent a = jn2.a();
        if (a != null) {
            DMComponent dMComponent = null;
            if (a instanceof DMComponent) {
                dMComponent = (DMComponent) a;
            }
            if (dMComponent != null && !TextUtils.isEmpty(charSequence) && charSequence2 != null) {
                String replaceAll = charSequence2.toString().trim().replaceAll(" ", "");
                Map<String, ? extends Object> hashMap = new HashMap<>();
                hashMap.put("value", replaceAll);
                i(dMComponent, hashMap);
                l(hashMap);
                IDMContext dataContext = this.c.getDataContext();
                if (dataContext instanceof a) {
                    Map<String, DMComponent> c = ((a) dataContext).c();
                    c.put(dMComponent.getTag() + JSMethod.NOT_SET + dMComponent.getId(), dMComponent);
                }
            }
        }
    }
}
