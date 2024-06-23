package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.alime.IAliMeCouponFaq;
import com.alibaba.pictures.bricks.alime.OnAliMeListener;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.coupon.order.bean.GaiaXBean;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.view.OnFagActionListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class og0 implements OnFagActionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context a;
    @Nullable
    private BricksBaseFragment b;

    /* compiled from: Taobao */
    public static final class a implements OnAliMeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ og0 a;

        a(og0 og0) {
            this.a = og0;
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "870920698")) {
                ipChange.ipc$dispatch("870920698", new Object[]{this});
                return;
            }
            BricksBaseFragment a2 = this.a.a();
            if (a2 != null) {
                a2.hideLoadingDialog();
            }
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "203116367")) {
                ipChange.ipc$dispatch("203116367", new Object[]{this});
                return;
            }
            BricksBaseFragment a2 = this.a.a();
            if (a2 != null) {
                a2.hideLoadingDialog();
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b implements OnAliMeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ og0 a;

        b(og0 og0) {
            this.a = og0;
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenFail() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1838688559")) {
                ipChange.ipc$dispatch("-1838688559", new Object[]{this});
                return;
            }
            BricksBaseFragment a2 = this.a.a();
            if (a2 != null) {
                a2.hideLoadingDialog();
            }
        }

        @Override // com.alibaba.pictures.bricks.alime.OnAliMeListener
        public void onAliMeOpenSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2144069400")) {
                ipChange.ipc$dispatch("2144069400", new Object[]{this});
                return;
            }
            BricksBaseFragment a2 = this.a.a();
            if (a2 != null) {
                a2.hideLoadingDialog();
            }
        }
    }

    public og0(@NotNull Context context, @Nullable BricksBaseFragment bricksBaseFragment) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.a = context;
        this.b = bricksBaseFragment;
    }

    @Nullable
    public final BricksBaseFragment a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "304048558")) {
            return this.b;
        }
        return (BricksBaseFragment) ipChange.ipc$dispatch("304048558", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onFagAllClick(@NotNull OrderDetail orderDetail) {
        String orderId;
        String itemId;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131323297")) {
            ipChange.ipc$dispatch("-1131323297", new Object[]{this, orderDetail});
            return;
        }
        k21.i(orderDetail, "order");
        CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
        if (orderInfoVO != null && (orderId = orderInfoVO.getOrderId()) != null && (itemId = orderDetail.getItemId()) != null) {
            BricksBaseFragment bricksBaseFragment = this.b;
            if (bricksBaseFragment != null) {
                bricksBaseFragment.showLoadingDialog(new String[0]);
            }
            IAliMeCouponFaq a2 = n4.INSTANCE.a();
            if (a2 != null) {
                a2.openAliMe4Fag(this.a, itemId, orderId, new a(this));
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onItemClick(@NotNull View view, @NotNull String str, @NotNull OrderDetail orderDetail, int i) {
        JSONObject data;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1506698870")) {
            ipChange.ipc$dispatch("-1506698870", new Object[]{this, view, str, orderDetail, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(str, "question");
        k21.i(orderDetail, "order");
        qm1 qm1 = qm1.INSTANCE;
        String itemId = orderDetail.getItemId();
        CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
        String str2 = null;
        qm1.p(view, itemId, orderInfoVO != null ? orderInfoVO.getOrderId() : null, str, i);
        String itemId2 = orderDetail.getItemId();
        if (itemId2 == null || itemId2.length() == 0) {
            GaiaXBean validGaiaXBean = orderDetail.getValidGaiaXBean("damai_script_order_detail_header");
            itemId2 = (validGaiaXBean == null || (data = validGaiaXBean.getData()) == null) ? null : data.getString("itemId");
        }
        CouponOrderInfoBean orderInfoVO2 = orderDetail.getOrderInfoVO();
        if (orderInfoVO2 != null) {
            str2 = orderInfoVO2.getOrderId();
        }
        if (!(itemId2 == null || itemId2.length() == 0)) {
            if (!(str2 == null || str2.length() == 0)) {
                z = false;
            }
            if (!z) {
                BricksBaseFragment bricksBaseFragment = this.b;
                if (bricksBaseFragment != null) {
                    bricksBaseFragment.showLoadingDialog(new String[0]);
                }
                IAliMeCouponFaq a2 = n4.INSTANCE.a();
                if (a2 != null) {
                    Context context = this.a;
                    k21.f(itemId2);
                    a2.openAliMe4SingleFaq(context, itemId2, str2, str, new b(this));
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.coupon.view.OnFagActionListener
    public void onItemExpose(@NotNull View view, @NotNull String str, @Nullable OrderDetail orderDetail, int i) {
        CouponOrderInfoBean orderInfoVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725618176")) {
            ipChange.ipc$dispatch("725618176", new Object[]{this, view, str, orderDetail, Integer.valueOf(i)});
            return;
        }
        k21.i(view, "itemView");
        k21.i(str, "question");
        qm1.INSTANCE.e(view, orderDetail != null ? orderDetail.getItemId() : null, (orderDetail == null || (orderInfoVO = orderDetail.getOrderInfoVO()) == null) ? null : orderInfoVO.getOrderId(), str, i);
    }
}
