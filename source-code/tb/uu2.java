package tb;

import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.android.ultron.datamodel.imp.a;
import java.util.Map;

/* compiled from: Taobao */
public class uu2 {
    private a a;

    public uu2(a aVar) {
        this.a = aVar;
    }

    public vu2 a() {
        vu2 validate;
        Map<String, DMComponent> l = this.a.l();
        if (l != null && l.size() > 0) {
            for (DMComponent dMComponent : l.values()) {
                if (!(dMComponent.getStatus() == 0 || (validate = dMComponent.validate()) == null || validate.c())) {
                    UmbrellaTracker.commitFailureStability("formValidationFailed", "ValidateModule", "1.0", this.a.a(), null, null, "errorcode", validate.b());
                    return validate;
                }
            }
        }
        return new vu2();
    }
}
