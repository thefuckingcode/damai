package cn.damai.tetris.component.drama.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$raw;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ac0;
import tb.lk1;
import tb.s72;

/* compiled from: Taobao */
public class DramaCardHorViewHolder extends BaseViewHolder<DramaV1Bean> implements View.OnClickListener, FocusUiCall {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a = ((TextView) this.itemView.findViewById(R$id.drama_title));
    private TextView b = ((TextView) this.itemView.findViewById(R$id.drama_tag));
    private TextView c = ((TextView) this.itemView.findViewById(R$id.drama_citys));
    private TextView d = ((TextView) this.itemView.findViewById(R$id.drama_ipuv));
    private TextView e = ((TextView) this.itemView.findViewById(R$id.drama_focus_state_tv));
    private LinearLayout f = ((LinearLayout) this.itemView.findViewById(R$id.drama_focus_state_ui));
    private Context g;
    private OnDramaItemClickListener h;
    private final ac0 i = new ac0(this.itemView);
    private DramaV1Bean j;
    private int k;

    /* compiled from: Taobao */
    public interface OnDramaItemClickListener {
        void onDramaItemClick(DramaV1Bean dramaV1Bean, int i);

        void onFocusClick(FocusUiCall focusUiCall, DramaV1Bean dramaV1Bean, int i);
    }

    public DramaCardHorViewHolder(Context context, ViewGroup viewGroup, OnDramaItemClickListener onDramaItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_drama_hor_card, viewGroup, false));
        this.h = onDramaItemClickListener;
        this.g = context;
    }

    /* renamed from: c */
    public void a(DramaV1Bean dramaV1Bean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953473901")) {
            ipChange.ipc$dispatch("-1953473901", new Object[]{this, dramaV1Bean, Integer.valueOf(i2)});
        } else if (dramaV1Bean != null) {
            this.j = dramaV1Bean;
            this.k = i2;
            this.i.a(dramaV1Bean.pic);
            this.i.d(this.j.getScoreValue());
            this.a.setText(dramaV1Bean.title);
            String contactStr = DramaV1Bean.getContactStr(dramaV1Bean.tags);
            if (TextUtils.isEmpty(contactStr)) {
                this.b.setText(dramaV1Bean.briefIntroduction);
            } else {
                this.b.setText(contactStr);
            }
            this.c.setText(DramaV1Bean.getContactStr(dramaV1Bean.citys, " "));
            this.d.setText(lk1.e(dramaV1Bean.ipvuv));
            notifyFocusChanged(false);
            this.itemView.setOnClickListener(this);
            this.f.setOnClickListener(this);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.FocusUiCall
    public void notifyFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168509426")) {
            ipChange.ipc$dispatch("-168509426", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        DramaV1Bean dramaV1Bean = this.j;
        if (dramaV1Bean != null) {
            this.e.setText(dramaV1Bean.focus ? "已想看" : "想看");
            this.e.setTextColor(this.j.focus ? Color.parseColor("#9C9CA5") : -16777216);
            View findViewById = this.f.findViewById(R$id.lottie_focus_layout);
            if (findViewById != null) {
                this.f.removeView(findViewById);
            }
            View inflate = LayoutInflater.from(this.g).inflate(R$layout.item_drama_focus_lottie, (ViewGroup) this.f, false);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.lottie_focus);
            this.f.addView(inflate, 0);
            lottieAnimationView.setAnimation(this.j.focus ? R$raw.lottie_favourite_click : R$raw.lottie_favorite_cancel);
            if (z) {
                lottieAnimationView.playAnimation();
            } else {
                lottieAnimationView.setProgress(1.0f);
            }
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515267012")) {
            ipChange.ipc$dispatch("-515267012", new Object[]{this, view});
        } else if (!s72.c() && this.h != null && this.j != null) {
            if (view.getId() == R$id.drama_focus_state_ui) {
                this.h.onFocusClick(this, this.j, this.k);
            } else {
                this.h.onDramaItemClick(this.j, this.k);
            }
        }
    }
}
