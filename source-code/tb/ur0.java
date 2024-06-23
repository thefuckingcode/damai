package tb;

import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.alibaba.pictures.bricks.gaiaxholder.UtParam;
import com.alibaba.pictures.bricks.gaiaxholder.UtType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class ur0 implements GaiaXUtParamsGenerator {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private OrderDetail a;

    public ur0(@Nullable OrderDetail orderDetail) {
        this.a = orderDetail;
    }

    @Override // com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator
    @Nullable
    public UtParam generate(@NotNull UtType utType, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377874056")) {
            return (UtParam) ipChange.ipc$dispatch("1377874056", new Object[]{this, utType, str, str2, str3});
        }
        k21.i(utType, "type");
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "gxTemplateId");
        k21.i(str3, "eventName");
        OrderDetail orderDetail = this.a;
        String str4 = null;
        if (orderDetail != null && k21.d("damai_script_play_apply_store", str2)) {
            if (k21.d("UT_APPLY_STORE_CALL_CLICK", str3) || k21.d("UT_APPLY_STORE_CALL_EXPOSE", str3)) {
                UtParam utParam = new UtParam();
                utParam.setSpma(tc.INSTANCE.a());
                utParam.setSpmb(ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE);
                utParam.setSpmc("applicablestores");
                utParam.setSpmd("telephone");
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("item_id", orderDetail.getItemId());
                CouponOrderInfoBean orderInfoVO = orderDetail.getOrderInfoVO();
                if (orderInfoVO != null) {
                    str4 = orderInfoVO.getOrderId();
                }
                hashMap.put("orderid", str4);
                utParam.setArgs(hashMap);
                return utParam;
            } else if (k21.d("UT_APPLY_STORE_ADDR_CLICK", str3) || k21.d("UT_APPLY_STORE_ADDR_EXPOSE", str3)) {
                UtParam utParam2 = new UtParam();
                utParam2.setSpma(tc.INSTANCE.a());
                utParam2.setSpmb(ln2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE);
                utParam2.setSpmc("applicablestores");
                utParam2.setSpmd(ILocatable.ADDRESS);
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("item_id", orderDetail.getItemId());
                CouponOrderInfoBean orderInfoVO2 = orderDetail.getOrderInfoVO();
                if (orderInfoVO2 != null) {
                    str4 = orderInfoVO2.getOrderId();
                }
                hashMap2.put("orderid", str4);
                utParam2.setArgs(hashMap2);
                return utParam2;
            }
        }
        return null;
    }
}
