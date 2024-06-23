package tb;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;

/* compiled from: Taobao */
public class dz0<T extends BaseConfigItem> extends PopRequest {
    public T k;
    public Event l;

    public dz0(int i, Event event, T t, Activity activity, PopRequest.PopRequestStatusCallBack popRequestStatusCallBack) {
        super(i, t.layerType, activity, popRequestStatusCallBack, t.priority, t.enqueue, t.forcePopRespectingPriority, t.exclusive);
        this.l = event;
        this.k = t;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dz0)) {
            return super.equals(obj);
        }
        dz0 dz0 = (dz0) obj;
        return !TextUtils.isEmpty(this.k.uuid) && this.l.equals(dz0.l) && this.k.uuid.equals(dz0.k.uuid);
    }

    public T r() {
        return this.k;
    }

    public Event s() {
        return this.l;
    }
}
