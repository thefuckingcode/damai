package tb;

import cn.damai.ultron.net.UltronPresenter;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;

/* compiled from: Taobao */
public class ha0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIEWER_TITLE = "dmViewerTitle";

    public static IDMComponent a(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096064030")) {
            return (IDMComponent) ipChange.ipc$dispatch("1096064030", new Object[]{iPresenter});
        }
        hn2 k = k(iPresenter);
        if (k == null) {
            return null;
        }
        List<IDMComponent> a = k.a();
        for (int i = 0; i < xf2.e(a); i++) {
            IDMComponent iDMComponent = a.get(i);
            if (iDMComponent.getTag().equalsIgnoreCase(VIEWER_TITLE)) {
                return iDMComponent;
            }
        }
        return null;
    }

    public static IDMComponent b(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1576533348")) {
            return j(iPresenter, "dmDeliveryAddress");
        }
        return (IDMComponent) ipChange.ipc$dispatch("-1576533348", new Object[]{iPresenter});
    }

    public static IDMComponent c(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1197850445")) {
            return j(iPresenter, "dmDeliverySelectCard");
        }
        return (IDMComponent) ipChange.ipc$dispatch("-1197850445", new Object[]{iPresenter});
    }

    public static IDMComponent d(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1505518434")) {
            return j(iPresenter, "dmContactPhone");
        }
        return (IDMComponent) ipChange.ipc$dispatch("1505518434", new Object[]{iPresenter});
    }

    public static IDMComponent e(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-511095735")) {
            return j(iPresenter, "dmEttributesHiddenBlock");
        }
        return (IDMComponent) ipChange.ipc$dispatch("-511095735", new Object[]{iPresenter});
    }

    public static IDMComponent f(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1531163480")) {
            return j(iPresenter, "dmItemInfo");
        }
        return (IDMComponent) ipChange.ipc$dispatch("-1531163480", new Object[]{iPresenter});
    }

    public static IDMComponent g(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1102400321")) {
            return j(iPresenter, "dmPayType");
        }
        return (IDMComponent) ipChange.ipc$dispatch("1102400321", new Object[]{iPresenter});
    }

    public static IDMComponent h(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "414609503")) {
            return j(iPresenter, "dmSubmit");
        }
        return (IDMComponent) ipChange.ipc$dispatch("414609503", new Object[]{iPresenter});
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    public static String i(IPresenter iPresenter) {
        IDMEvent iDMEvent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060149500")) {
            return (String) ipChange.ipc$dispatch("-2060149500", new Object[]{iPresenter});
        }
        IDMComponent h = h(iPresenter);
        if (h == null) {
            return null;
        }
        if (h.getEventMap().size() > 0) {
            List<IDMEvent> list = h.getEventMap().get("detailClick");
            if (xf2.e(list) > 0) {
                iDMEvent = list.get(0);
                if (iDMEvent != null) {
                    return null;
                }
                IDMComponent iDMComponent = iDMEvent.getComponents().get(0);
                if (iDMComponent == null && iDMComponent.getFields() == null) {
                    return null;
                }
                return iDMComponent.getFields().toJSONString();
            }
        }
        iDMEvent = null;
        if (iDMEvent != null) {
        }
    }

    private static IDMComponent j(IPresenter iPresenter, String str) {
        IDMContext dataContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609335469")) {
            return (IDMComponent) ipChange.ipc$dispatch("-1609335469", new Object[]{iPresenter, str});
        }
        BaseDataManager dataManager = iPresenter instanceof UltronPresenter ? iPresenter.getDataManager() : null;
        if (dataManager == null || (dataContext = dataManager.getDataContext()) == null) {
            return null;
        }
        List<IDMComponent> components = dataContext.getComponents();
        for (int i = 0; i < xf2.e(components); i++) {
            IDMComponent iDMComponent = components.get(i);
            if (iDMComponent.getTag().equalsIgnoreCase(str)) {
                return iDMComponent;
            }
        }
        return null;
    }

    private static hn2 k(IPresenter iPresenter) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213253683")) {
            return (hn2) ipChange.ipc$dispatch("-1213253683", new Object[]{iPresenter});
        }
        if (!(iPresenter instanceof UltronPresenter) || (dataManager = iPresenter.getDataManager()) == null) {
            return null;
        }
        return dataManager.getDataSource();
    }

    public static IDMComponent l(IPresenter iPresenter, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696642784")) {
            return (IDMComponent) ipChange.ipc$dispatch("696642784", new Object[]{iPresenter, str});
        }
        hn2 k = k(iPresenter);
        if (k == null) {
            return null;
        }
        List<IDMComponent> a = k.a();
        for (int i = 0; i < xf2.e(a); i++) {
            IDMComponent iDMComponent = a.get(i);
            if ((iDMComponent.getTag() + JSMethod.NOT_SET + iDMComponent.getId()).equalsIgnoreCase(str)) {
                return iDMComponent;
            }
        }
        return null;
    }
}
