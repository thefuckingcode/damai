package cn.damai.seat.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.seat.R$id;
import cn.damai.seat.R$layout;
import cn.damai.seat.bean.biz.Price;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.g72;
import tb.h72;
import tb.n42;
import tb.s72;
import tb.xf2;
import tb.zz2;

/* compiled from: Taobao */
public class SeatPriceListPanel extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private View b;
    private HorizontalScrollView c;
    private LinearLayout d;
    private LinearLayout e;
    private int f;
    private int g;
    private h72 h;
    private List<? extends PriceLevel> i;
    private PriceLevel j;
    private ViewHolder k;
    private OnPriceClickListener l;
    private boolean m = true;
    private boolean n;

    /* compiled from: Taobao */
    public interface OnPriceClickListener {
        void onPriceClick(@NonNull PriceLevel priceLevel, int i);
    }

    /* compiled from: Taobao */
    public class ViewHolder extends BaseViewHolder<PriceLevel> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private View d;
        private PriceLevel e;
        private int f;

        public ViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.price_icon_combine_text);
            this.b = (TextView) view.findViewById(R$id.price_text);
            this.c = (TextView) view.findViewById(R$id.price_tag);
            this.d = view.findViewById(R$id.price_text_div);
        }

        /* renamed from: c */
        public void a(PriceLevel priceLevel, int i) {
            String str;
            int i2;
            Tag tag;
            IpChange ipChange = $ipChange;
            int i3 = 0;
            if (AndroidInstantRuntime.support(ipChange, "669458212")) {
                ipChange.ipc$dispatch("669458212", new Object[]{this, priceLevel, Integer.valueOf(i)});
                return;
            }
            this.e = priceLevel;
            this.f = i;
            boolean isSalable = priceLevel.isSalable();
            boolean z = SeatPriceListPanel.this.j == priceLevel;
            this.itemView.setSelected(z);
            if (z) {
                SeatPriceListPanel.this.k = this;
            }
            if (z) {
                i2 = -16777216;
                str = priceLevel.getPriceTitle();
            } else {
                i2 = Color.parseColor("#666666");
                str = priceLevel.getShowPriceText();
            }
            if (!isSalable) {
                i2 = Color.parseColor("#CCCCCC");
            }
            this.b.setText(str);
            this.b.setTextColor(i2);
            String str2 = null;
            if ((priceLevel instanceof Price) && (tag = ((Price) priceLevel).promotionTag) != null) {
                str2 = tag.tagDesc;
            }
            boolean z2 = !TextUtils.isEmpty(str2);
            this.c.setVisibility(z2 ? 0 : 8);
            View view = this.d;
            if (z2) {
                i3 = 8;
            }
            view.setVisibility(i3);
            if (z2) {
                this.c.setText(str2);
            }
            SeatPriceListPanel seatPriceListPanel = SeatPriceListPanel.this;
            this.a.setText(seatPriceListPanel.k(priceLevel, seatPriceListPanel.h));
            this.itemView.setOnClickListener(this);
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-807549081")) {
                ipChange.ipc$dispatch("-807549081", new Object[]{this, view});
            } else if (s72.c() || this.e == null || SeatPriceListPanel.this.l == null || !SeatPriceListPanel.this.a()) {
            } else {
                if (this.e.isSalable()) {
                    SeatPriceListPanel.this.l.onPriceClick(this.e, this.f);
                } else {
                    ToastUtil.a().e(SeatPriceListPanel.this.a, "该票档当前不可售");
                }
            }
        }
    }

    public SeatPriceListPanel(Activity activity, View view, OnPriceClickListener onPriceClickListener) {
        super(activity);
        this.l = onPriceClickListener;
        this.b = view;
        this.c = (HorizontalScrollView) view.findViewById(R$id.price_scroll_view);
        this.e = (LinearLayout) this.b.findViewById(R$id.price_list_1_layout);
        this.d = (LinearLayout) this.b.findViewById(R$id.price_list_2_layout);
        this.f = n42.a(activity, 3.0f);
        this.g = n42.a(activity, 12.0f);
    }

    private void i(ViewGroup viewGroup, List<? extends PriceLevel> list, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591163492")) {
            ipChange.ipc$dispatch("1591163492", new Object[]{this, viewGroup, list, Integer.valueOf(i2)});
        } else if (f92.d(list)) {
            viewGroup.removeAllViews();
        } else {
            int size = list.size();
            int childCount = viewGroup.getChildCount();
            if (childCount > size) {
                while (size < childCount) {
                    View childAt = viewGroup.getChildAt(0);
                    if (childAt != null) {
                        viewGroup.removeView(childAt);
                    }
                    size++;
                }
            } else if (childCount < size) {
                int i3 = size - childCount;
                for (int i4 = 0; i4 < i3; i4++) {
                    View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_seat_price_level_new, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        int i5 = this.f;
                        marginLayoutParams.rightMargin = i5;
                        marginLayoutParams.leftMargin = i5;
                    }
                    inflate.setTag(new ViewHolder(inflate));
                    viewGroup.addView(inflate);
                }
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                PriceLevel priceLevel = (PriceLevel) list.get(i6);
                View childAt2 = viewGroup.getChildAt(i6);
                if (childAt2 != null) {
                    Object tag = childAt2.getTag();
                    if (tag instanceof ViewHolder) {
                        ((ViewHolder) tag).a(priceLevel, i2);
                        i2++;
                    }
                }
            }
        }
    }

    private void j(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1468991424")) {
            ipChange.ipc$dispatch("-1468991424", new Object[]{this, list});
        } else if (this.m) {
            this.m = false;
            if (xf2.e(list) <= 4 || !g72.x(list)) {
                z = false;
            }
            this.n = z;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CharSequence k(PriceLevel priceLevel, h72 h72) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "514935325")) {
            return (CharSequence) ipChange.ipc$dispatch("514935325", new Object[]{this, priceLevel, h72});
        } else if (priceLevel == null || h72 == null || !a()) {
            return null;
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (priceLevel.isSinglePrice()) {
                spannableStringBuilder.append((CharSequence) l(priceLevel.colorInt(), false));
            } else {
                List<SubPrice> subPriceList = priceLevel.getSubPriceList();
                boolean isTaoPiao = priceLevel.isTaoPiao();
                if (!f92.d(subPriceList)) {
                    int size = subPriceList.size();
                    int i2 = 0;
                    boolean z = false;
                    while (i2 < size) {
                        SubPrice subPrice = subPriceList.get(i2);
                        int colorInt = subPrice.colorInt();
                        boolean z2 = i2 == 0;
                        boolean z3 = i2 == size + -1;
                        if (subPrice.count >= 4) {
                            SpannableStringBuilder l2 = l(colorInt, isTaoPiao);
                            if (!z2 && !z) {
                                spannableStringBuilder.append((CharSequence) " +");
                            }
                            spannableStringBuilder.append((CharSequence) l2).append((CharSequence) " x").append((CharSequence) String.valueOf(subPrice.count));
                            if (!z3) {
                                spannableStringBuilder.append((CharSequence) " +");
                                z = true;
                            }
                        } else {
                            for (int i3 = 0; i3 < subPrice.count; i3++) {
                                spannableStringBuilder.append((CharSequence) l(colorInt, isTaoPiao));
                            }
                            z = false;
                        }
                        i2++;
                    }
                }
            }
            return spannableStringBuilder;
        }
    }

    private SpannableStringBuilder l(int i2, boolean z) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496042638")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("496042638", new Object[]{this, Integer.valueOf(i2), Boolean.valueOf(z)});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" proxy");
        if (z) {
            bitmap = this.h.a(i2, 0.0f, (byte) 12, false);
        } else {
            bitmap = this.h.a(i2, 0.0f, (byte) 10, false);
        }
        Activity activity = this.a;
        int i3 = this.g;
        spannableStringBuilder.setSpan(new zz2(activity, bitmap, i3, i3), 1, 6, 17);
        return spannableStringBuilder;
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25937666")) {
            ipChange.ipc$dispatch("-25937666", new Object[]{this});
            return;
        }
        HorizontalScrollView horizontalScrollView = this.c;
        if (horizontalScrollView != null && this.j != null) {
            horizontalScrollView.post(new Runnable() {
                /* class cn.damai.seat.helper.SeatPriceListPanel.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-271828223")) {
                        ipChange.ipc$dispatch("-271828223", new Object[]{this});
                    } else if (SeatPriceListPanel.this.a() && SeatPriceListPanel.this.c != null && SeatPriceListPanel.this.j != null && SeatPriceListPanel.this.k != null) {
                        View view = SeatPriceListPanel.this.k.itemView;
                        int width = view.getWidth();
                        int width2 = SeatPriceListPanel.this.c.getWidth();
                        if (width2 > 0 && width > 0) {
                            int left = view.getLeft();
                            int right = view.getRight();
                            int scrollX = SeatPriceListPanel.this.c.getScrollX();
                            int i = left - scrollX;
                            int i2 = right - scrollX;
                            if (width >= width2) {
                                SeatPriceListPanel.this.c.smoothScrollBy(i, 0);
                            } else if (i < 0) {
                                SeatPriceListPanel.this.c.smoothScrollBy(i, 0);
                            } else if (i2 > width2) {
                                SeatPriceListPanel.this.c.smoothScrollBy(i2 - width2, 0);
                            }
                        }
                    }
                }
            });
        }
    }

    public void n(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692068500")) {
            ipChange.ipc$dispatch("692068500", new Object[]{this, priceLevel});
            return;
        }
        o(this.i, this.h, priceLevel);
    }

    public void o(List<? extends PriceLevel> list, h72 h72, PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994365028")) {
            ipChange.ipc$dispatch("-994365028", new Object[]{this, list, h72, priceLevel});
            return;
        }
        this.i = list;
        this.j = priceLevel;
        this.h = h72;
        j(list);
        if (this.n) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            this.d.setVisibility(0);
            if (!f92.d(list)) {
                for (PriceLevel priceLevel2 : list) {
                    if (priceLevel2.isSinglePrice()) {
                        arrayList.add(priceLevel2);
                    } else {
                        arrayList2.add(priceLevel2);
                    }
                }
            }
            int e2 = xf2.e(arrayList);
            i(this.e, arrayList, 0);
            i(this.d, arrayList2, e2);
        } else {
            i(this.e, list, 0);
            this.d.setVisibility(8);
        }
        if (priceLevel != null) {
            m();
        }
    }
}
