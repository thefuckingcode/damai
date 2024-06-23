package cn.damai.tetris.component.brand;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.brand.bean.CommonCard;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.v50;

/* compiled from: Taobao */
public class BrandCouponAdapter extends RecyclerView.Adapter<CardHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<CommonCard> b;
    private View.OnClickListener c;
    private BrandHeaderPresenter d;

    /* compiled from: Taobao */
    public class CardHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public View a = this.itemView.findViewById(R$id.common_top_space);
        private TextView b = ((TextView) this.itemView.findViewById(R$id.common_card_top_value));
        private TextView c = ((TextView) this.itemView.findViewById(R$id.common_card_top_info));
        private TextView d = ((TextView) this.itemView.findViewById(R$id.item_header_coupon_want));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.common_card_bottom_text));
        private TextView f = ((TextView) this.itemView.findViewById(R$id.common_card_desc_info));
        private TextView g = ((TextView) this.itemView.findViewById(R$id.common_card_desc_info2));
        private View h = this.itemView.findViewById(R$id.item_header_coupon_got);

        public CardHolder(View view, Context context) {
            super(view);
            BrandCouponAdapter.this.a = context;
        }

        public void c(CommonCard commonCard) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149319400")) {
                ipChange.ipc$dispatch("-149319400", new Object[]{this, commonCard});
            } else if (commonCard != null) {
                this.b.setText(commonCard.decreaseMoneyNum);
                this.c.setText(commonCard.overAmountText);
                this.f.setText(commonCard.name);
                if (BrandCouponAdapter.this.getItemCount() > 1) {
                    this.f.post(new Runnable() {
                        /* class cn.damai.tetris.component.brand.BrandCouponAdapter.CardHolder.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1358462764")) {
                                ipChange.ipc$dispatch("1358462764", new Object[]{this});
                            } else if (BrandCouponAdapter.this.a != null) {
                                if (CardHolder.this.f.getLayout().getLineCount() > 1) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CardHolder.this.f.getLayoutParams();
                                    layoutParams.setMargins(v50.a(BrandCouponAdapter.this.a, 9.0f), v50.a(BrandCouponAdapter.this.a, 9.0f), v50.a(BrandCouponAdapter.this.a, 3.0f), 0);
                                    CardHolder.this.f.setLayoutParams(layoutParams);
                                    return;
                                }
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CardHolder.this.f.getLayoutParams();
                                layoutParams2.setMargins(v50.a(BrandCouponAdapter.this.a, 9.0f), v50.a(BrandCouponAdapter.this.a, 15.0f), v50.a(BrandCouponAdapter.this.a, 3.0f), 0);
                                CardHolder.this.f.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
                TextView textView = this.g;
                if (!(textView == null || (str = commonCard.tag) == null)) {
                    textView.setText(str);
                }
                if (commonCard.gainCouponButtonCode == 1) {
                    this.d.setVisibility(8);
                    this.h.setVisibility(0);
                    this.e.setText("已领取");
                    return;
                }
                this.d.setVisibility(0);
                this.h.setVisibility(8);
                if (commonCard.gainCouponButtonCode == 2) {
                    this.d.setText("关注领取");
                } else {
                    this.d.setText("立即领取");
                }
            }
        }
    }

    public BrandCouponAdapter(Context context, String str, String str2, View.OnClickListener onClickListener, BrandHeaderPresenter brandHeaderPresenter) {
        this.a = context;
        this.c = onClickListener;
        this.d = brandHeaderPresenter;
    }

    /* renamed from: c */
    public void onBindViewHolder(final CardHolder cardHolder, @SuppressLint({"RecyclerView"}) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345850230")) {
            ipChange.ipc$dispatch("-345850230", new Object[]{this, cardHolder, Integer.valueOf(i)});
        } else if (cardHolder != null) {
            cardHolder.c(this.b.get(i));
            cardHolder.itemView.setTag(this.b.get(i));
            CommonCard commonCard = this.b.get(i);
            if (!(commonCard == null || commonCard.gainCouponButtonCode == 1)) {
                cardHolder.itemView.setOnClickListener(this.c);
            }
            commonCard.index = i;
            if (getItemCount() == 1) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, v50.a(this.a, 64.0f));
                layoutParams.setMargins(v50.a(this.a, 12.0f), 0, v50.a(this.a, 12.0f), 0);
                cardHolder.itemView.setLayoutParams(layoutParams);
            } else {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) cardHolder.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new RecyclerView.LayoutParams(-2, -2);
                }
                if (i == getItemCount() - 1) {
                    layoutParams2.setMargins(0, 0, v50.a(this.a, 12.0f), 0);
                } else {
                    layoutParams2.setMargins(0, 0, 0, 0);
                }
                cardHolder.itemView.setLayoutParams(layoutParams2);
                cardHolder.c.post(new Runnable() {
                    /* class cn.damai.tetris.component.brand.BrandCouponAdapter.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-430963930")) {
                            ipChange.ipc$dispatch("-430963930", new Object[]{this});
                        } else if (BrandCouponAdapter.this.a != null) {
                            int lineCount = cardHolder.c.getLayout().getLineCount();
                            View findViewById = cardHolder.itemView.findViewById(R$id.common_card_top_vv);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                            if (lineCount > 1) {
                                layoutParams.setMargins(0, v50.a(BrandCouponAdapter.this.a, 5.0f), 0, 0);
                                findViewById.setLayoutParams(layoutParams);
                                return;
                            }
                            layoutParams.setMargins(0, v50.a(BrandCouponAdapter.this.a, 10.0f), 0, 0);
                            findViewById.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
            BrandHeaderPresenter brandHeaderPresenter = this.d;
            if (brandHeaderPresenter != null) {
                brandHeaderPresenter.trackExpo(commonCard);
            }
        }
    }

    /* renamed from: d */
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494945004")) {
            return (CardHolder) ipChange.ipc$dispatch("1494945004", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (getItemCount() == 1) {
            view = from.inflate(R$layout.layout_coupon_common_card_w, (ViewGroup) null);
        } else {
            view = from.inflate(R$layout.layout_coupon_common_card, (ViewGroup) null);
        }
        return new CardHolder(view, this.a);
    }

    public void e(List<CommonCard> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687381494")) {
            ipChange.ipc$dispatch("-1687381494", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438595207")) {
            return ((Integer) ipChange.ipc$dispatch("-438595207", new Object[]{this})).intValue();
        }
        List<CommonCard> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
