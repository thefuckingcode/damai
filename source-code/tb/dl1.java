package tb;

import android.util.Pair;
import com.alibaba.android.ultron.trade.event.model.OpenPopupWindowEventModel;
import com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager;
import com.alibaba.fastjson.JSON;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.List;

/* compiled from: Taobao */
public class dl1 extends va {

    /* compiled from: Taobao */
    class a implements PopupWindowManager.OnCancelListener {
        final /* synthetic */ jn2 a;

        a(dl1 dl1, jn2 jn2) {
            this.a = jn2;
        }

        @Override // com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager.OnCancelListener
        public void onCancel() {
            this.a.h();
        }
    }

    public dl1() {
        a();
    }

    @Override // tb.va
    public void h(jn2 jn2) {
        IDMEvent e = e();
        if (e != null && e.getFields() != null) {
            OpenPopupWindowEventModel openPopupWindowEventModel = null;
            try {
                openPopupWindowEventModel = (OpenPopupWindowEventModel) JSON.parseObject(e.getFields().toJSONString(), OpenPopupWindowEventModel.class);
            } catch (Exception unused) {
            }
            List<IDMComponent> components = e.getComponents();
            yf1 yf1 = new yf1(components);
            yf1.a();
            jn2.o(yf1);
            this.c.getViewManager().showPopup(components, openPopupWindowEventModel, new a(this, jn2));
            this.c.getViewManager().setPopupWindowTrigger(new Pair<>(this.e, e));
            this.c.getTradeEventHandler().n(jn2);
        }
    }
}
