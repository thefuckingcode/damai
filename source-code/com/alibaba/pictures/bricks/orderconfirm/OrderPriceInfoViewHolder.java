package com.alibaba.pictures.bricks.orderconfirm;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.orderconfirm.view.BricksTextInputDialog;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.vl1;
import tb.wm1;
import tb.xm1;
import tb.ym1;

/* compiled from: Taobao */
public final class OrderPriceInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EVENT_BUY_AMOUNT_INPUT = "order_input";
    @NotNull
    public static final String EVENT_BUY_AMOUNT_MINUS = "order_minus";
    @NotNull
    public static final String EVENT_BUY_AMOUNT_PLUS = "order_plus";
    @Nullable
    private OnEventListener a;
    @Nullable
    private JSONObject b;
    private final View c;
    private final View d;
    private final TextView e;
    private final TextView f;
    private final DigitTextView g;
    private int h = Integer.MAX_VALUE;
    private int i = 1;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements BricksTextInputDialog.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderPriceInfoViewHolder a;
        final /* synthetic */ String b;

        b(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str) {
            this.a = orderPriceInfoViewHolder;
            this.b = str;
        }

        @Override // com.alibaba.pictures.bricks.orderconfirm.view.BricksTextInputDialog.OnClickListener
        public void onClick(@Nullable DialogInterface dialogInterface, @Nullable CharSequence charSequence) {
            String obj;
            String obj2;
            Integer num;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1747330610")) {
                ipChange.ipc$dispatch("1747330610", new Object[]{this, dialogInterface, charSequence});
                return;
            }
            vl1 vl1 = vl1.INSTANCE;
            TextView textView = this.a.e;
            k21.h(textView, "buyAmountTv");
            vl1.b(textView, this.b);
            if (charSequence != null && (obj = charSequence.toString()) != null && (obj2 = StringsKt__StringsKt.T0(obj).toString()) != null && (num = n.k(obj2)) != null) {
                int intValue = num.intValue();
                if (intValue < 1) {
                    BricksToastUtil.INSTANCE.b("至少购买1张哦");
                } else if (intValue > this.a.h) {
                    BricksToastUtil.INSTANCE.b("单次购买超出限购数量，请重新输入哦");
                } else {
                    OnEventListener j = this.a.j();
                    if (j != null) {
                        j.onEvent(OrderPriceInfoViewHolder.EVENT_BUY_AMOUNT_INPUT, null, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderPriceInfoViewHolder(@NotNull View view, @Nullable OnEventListener onEventListener, @Nullable JSONObject jSONObject) {
        super(view);
        k21.i(view, "itemView");
        this.a = onEventListener;
        this.b = jSONObject;
        this.c = view.findViewById(R$id.order_buy_amount_counter_plus);
        this.d = view.findViewById(R$id.order_buy_amount_counter_minus);
        this.e = (TextView) view.findViewById(R$id.order_buy_amount_counter_text);
        this.f = (TextView) view.findViewById(R$id.order_buy_amount_limit_desc);
        this.g = (DigitTextView) view.findViewById(R$id.order_buy_amount_total_price);
    }

    /* access modifiers changed from: private */
    public static final void g(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "106578925")) {
            ipChange.ipc$dispatch("106578925", new Object[]{orderPriceInfoViewHolder, str, view});
            return;
        }
        k21.i(orderPriceInfoViewHolder, "this$0");
        vl1 vl1 = vl1.INSTANCE;
        TextView textView = orderPriceInfoViewHolder.e;
        k21.h(textView, "buyAmountTv");
        vl1.b(textView, str);
        int i2 = orderPriceInfoViewHolder.i;
        if (i2 >= orderPriceInfoViewHolder.h) {
            BricksToastUtil.INSTANCE.b("单次购买超出限购数量，请重新输入哦");
            return;
        }
        OnEventListener onEventListener = orderPriceInfoViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(EVENT_BUY_AMOUNT_PLUS, null, Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void h(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880003764")) {
            ipChange.ipc$dispatch("-880003764", new Object[]{orderPriceInfoViewHolder, str, view});
            return;
        }
        k21.i(orderPriceInfoViewHolder, "this$0");
        vl1 vl1 = vl1.INSTANCE;
        TextView textView = orderPriceInfoViewHolder.e;
        k21.h(textView, "buyAmountTv");
        vl1.b(textView, str);
        int i2 = orderPriceInfoViewHolder.i;
        if (i2 <= 1) {
            BricksToastUtil.INSTANCE.b("至少购买1张哦");
            orderPriceInfoViewHolder.i = 1;
            return;
        }
        OnEventListener onEventListener = orderPriceInfoViewHolder.a;
        if (onEventListener != null) {
            onEventListener.onEvent(EVENT_BUY_AMOUNT_MINUS, null, Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void i(OrderPriceInfoViewHolder orderPriceInfoViewHolder, String str, String str2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "908927073")) {
            ipChange.ipc$dispatch("908927073", new Object[]{orderPriceInfoViewHolder, str, str2, view});
            return;
        }
        k21.i(orderPriceInfoViewHolder, "this$0");
        new BricksTextInputDialog(orderPriceInfoViewHolder.e.getContext()).g("", str).h(new b(orderPriceInfoViewHolder, str2)).show();
    }

    public final void f(@Nullable JSONObject jSONObject) {
        Object obj;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1950029881")) {
            ipChange.ipc$dispatch("-1950029881", new Object[]{this, jSONObject});
        } else if (jSONObject != null) {
            try {
                this.i = jSONObject.getIntValue("buyAmount");
                this.h = jSONObject.getIntValue("buyLimit");
            } catch (Exception unused) {
                this.i = 1;
                this.h = Integer.MAX_VALUE;
            }
            this.e.setText(String.valueOf(this.i));
            JSONObject jSONObject2 = this.b;
            String obj2 = (jSONObject2 == null || (obj = jSONObject2.get("itemId")) == null) ? null : obj.toString();
            vl1 vl1 = vl1.INSTANCE;
            TextView textView = this.e;
            k21.h(textView, "buyAmountTv");
            vl1.c(textView, obj2);
            String string = jSONObject.getString("limitDesc");
            this.f.setText(string);
            this.g.setText(jSONObject.getString("totalPriceTxt"));
            this.c.setEnabled(this.i < this.h);
            View view = this.d;
            if (this.i > 1) {
                z = true;
            }
            view.setEnabled(z);
            this.c.setOnClickListener(new xm1(this, obj2));
            this.d.setOnClickListener(new wm1(this, obj2));
            this.e.setOnClickListener(new ym1(this, string, obj2));
        }
    }

    @Nullable
    public final OnEventListener j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1830850207")) {
            return this.a;
        }
        return (OnEventListener) ipChange.ipc$dispatch("1830850207", new Object[]{this});
    }
}
