package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.ui.RankListFragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.tag.DMPeopleSeeTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cx1;

/* compiled from: Taobao */
public class RankSquareTitleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private DMPeopleSeeTagView d;
    private Context e;
    private int f;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1324411712")) {
                ipChange.ipc$dispatch("-1324411712", new Object[]{this, view});
                return;
            }
            long longValue = ((Long) view.getTag()).longValue();
            c.e().x(cx1.f().o());
            if (RankSquareTitleViewHolder.this.f == 4 || RankSquareTitleViewHolder.this.f == 5) {
                Bundle bundle = new Bundle();
                bundle.putLong(RankListFragment.KEY_RANK_ID, longValue);
                DMNav.from(RankSquareTitleViewHolder.this.e).withExtras(bundle).toUri(NavUri.b("rank"));
            } else if (RankSquareTitleViewHolder.this.f == 3) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("id", String.valueOf(longValue));
                DMNav.from(RankSquareTitleViewHolder.this.e).withExtras(bundle2).toUri(NavUri.b("detailed_list"));
            } else if (RankSquareTitleViewHolder.this.f == 2) {
                Bundle bundle3 = new Bundle();
                bundle3.putLong(RankListFragment.KEY_RANK_ID, longValue);
                DMNav.from(RankSquareTitleViewHolder.this.e).withExtras(bundle3).toUri(NavUri.b("ranking"));
            }
        }
    }

    public RankSquareTitleViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.rank_square_title_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.e = layoutInflater.getContext();
        d(this.itemView);
    }

    private void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1625053723")) {
            ipChange.ipc$dispatch("-1625053723", new Object[]{this, view});
            return;
        }
        this.a = view.findViewById(R$id.grey_line);
        this.b = (TextView) view.findViewById(R$id.tv_name);
        this.c = (TextView) view.findViewById(R$id.tv_subtitle);
        this.d = (DMPeopleSeeTagView) view.findViewById(R$id.tv_fans_count);
        view.setOnClickListener(new a());
    }

    public void c(String str, String str2, int i, long j, int i2, int i3) {
        IpChange ipChange = $ipChange;
        int i4 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-35734326")) {
            ipChange.ipc$dispatch("-35734326", new Object[]{this, str, str2, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (!TextUtils.isEmpty(str)) {
            this.f = i2;
            this.itemView.setTag(Long.valueOf(j));
            this.b.setText(str);
            this.c.setText(str2);
            this.d.setPeopleNum(i);
            View view = this.a;
            if (i3 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
            cx1.f().j(this.itemView);
        }
    }
}
