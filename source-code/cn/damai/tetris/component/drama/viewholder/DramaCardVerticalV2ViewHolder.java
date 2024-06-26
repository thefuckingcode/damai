package cn.damai.tetris.component.drama.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2;
import cn.damai.tetris.component.drama.bean.DramaV2Bean;
import cn.damai.uikit.view.ScoreStarDigitView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.ac0;
import tb.lk1;

/* compiled from: Taobao */
public class DramaCardVerticalV2ViewHolder extends BaseViewHolderV2<DramaV2Bean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private ac0 c = new ac0(this.itemView);
    private TextView d;
    private TextView e;
    private ScoreStarDigitView f;
    private OnItemClickListener<DramaV2Bean> g;
    private HashMap<Integer, Integer> h;

    public DramaCardVerticalV2ViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<DramaV2Bean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.item_tetris_drama_card_v2, viewGroup, false));
        View findViewById = this.itemView.findViewById(R$id.drama_inner_layout);
        this.d = (TextView) this.itemView.findViewById(R$id.drama_title);
        this.e = (TextView) this.itemView.findViewById(R$id.drama_ipuv);
        this.f = (ScoreStarDigitView) this.itemView.findViewById(R$id.drama_star_score);
        this.g = onItemClickListener;
        findViewById.setOnClickListener(this);
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725808375")) {
            ipChange.ipc$dispatch("725808375", new Object[]{this});
        } else if (this.h == null) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            this.h = hashMap;
            hashMap.put(0, Integer.valueOf(R$drawable.homepage_rank_icon_0));
            this.h.put(1, Integer.valueOf(R$drawable.homepage_rank_icon_1));
            this.h.put(2, Integer.valueOf(R$drawable.homepage_rank_icon_2));
            this.h.put(3, Integer.valueOf(R$drawable.homepage_rank_icon_3));
            this.h.put(4, Integer.valueOf(R$drawable.homepage_rank_icon_4));
            this.h.put(5, Integer.valueOf(R$drawable.homepage_rank_icon_5));
            this.h.put(6, Integer.valueOf(R$drawable.homepage_rank_icon_6));
            this.h.put(7, Integer.valueOf(R$drawable.homepage_rank_icon_7));
            this.h.put(8, Integer.valueOf(R$drawable.homepage_rank_icon_8));
            this.h.put(9, Integer.valueOf(R$drawable.homepage_rank_icon_9));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void c(DramaV2Bean dramaV2Bean, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1027953707")) {
            ipChange.ipc$dispatch("-1027953707", new Object[]{this, dramaV2Bean, Integer.valueOf(i)});
        } else if (dramaV2Bean != null) {
            this.c.a(dramaV2Bean.headPic);
            this.d.setText(dramaV2Bean.name);
            double scoreValue = dramaV2Bean.getScoreValue();
            if (scoreValue <= 0.0d) {
                z = false;
            }
            this.f.setVisibility(z ? 0 : 8);
            TextView textView = this.e;
            if (z) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            if (z) {
                this.f.updateView(scoreValue);
            } else {
                this.e.setText(lk1.e(dramaV2Bean.ipvuv));
            }
            if (TextUtils.isEmpty(dramaV2Bean.itemScoreDefault)) {
                this.c.c(null);
            } else {
                this.c.c(dramaV2Bean.itemScoreDefault);
            }
            int i3 = dramaV2Bean.mustSeePos;
            if (i3 >= 0) {
                d();
                Integer num = this.h.get(Integer.valueOf(i3));
                if (num == null) {
                    this.c.b(-1);
                } else {
                    this.c.b(num.intValue());
                }
            }
        }
    }

    public void onClick(View view) {
        T t;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356650167")) {
            ipChange.ipc$dispatch("356650167", new Object[]{this, view});
            return;
        }
        OnItemClickListener<DramaV2Bean> onItemClickListener = this.g;
        if (onItemClickListener != null && (t = this.a) != null) {
            onItemClickListener.onItemClick(t, this.b);
        }
    }
}
