package cn.damai.search.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.login.LoginManager;
import cn.damai.search.helper.SearchHelper;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.br;
import tb.c62;
import tb.cq;
import tb.gr;
import tb.wz1;
import tb.xf2;
import tb.zq;

/* compiled from: Taobao */
public class AccountMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<BaccountInfo> b;

    /* compiled from: Taobao */
    public class AccountViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private LinearLayout b;
        private ImageView c;
        private ImageView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private RelativeLayout h;
        private StringBuilder i = new StringBuilder();
        private View.OnClickListener j = new a();

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onClick(View view) {
                BaccountInfo baccountInfo;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1476786959")) {
                    ipChange.ipc$dispatch("-1476786959", new Object[]{this, view});
                    return;
                }
                int id = view.getId();
                if (R$id.ll_account == id) {
                    AccountViewHolder.this.d((BaccountInfo) view.getTag());
                } else if (R$id.relation_status_button == id && (baccountInfo = (BaccountInfo) view.getTag()) != null) {
                    if (!baccountInfo.isHasFollow()) {
                        br.c(SearchHelper.ACCOUNT_MORE_ATTENTION, baccountInfo);
                    } else {
                        AccountViewHolder.this.d(baccountInfo);
                    }
                }
            }
        }

        public AccountViewHolder(AccountMoreAdapter accountMoreAdapter, Context context, LayoutInflater layoutInflater) {
            super(layoutInflater.inflate(R$layout.search_list_baccount, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            this.b = (LinearLayout) this.itemView.findViewById(R$id.ll_account);
            this.c = (ImageView) this.itemView.findViewById(R$id.iv_account_image);
            this.d = (ImageView) this.itemView.findViewById(R$id.iv_account_arrow);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_account_name);
            this.f = (TextView) this.itemView.findViewById(R$id.tv_account_count);
            this.g = (TextView) this.itemView.findViewById(R$id.relation_status);
            this.h = (RelativeLayout) this.itemView.findViewById(R$id.relation_status_button);
            this.b.setOnClickListener(this.j);
            this.h.setOnClickListener(this.j);
        }

        private String b(BaccountInfo baccountInfo) {
            String str;
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "214005001")) {
                return (String) ipChange.ipc$dispatch("214005001", new Object[]{this, baccountInfo});
            } else if (baccountInfo == null) {
                return "";
            } else {
                StringBuilder sb = this.i;
                sb.delete(0, sb.length());
                if (TextUtils.isEmpty(baccountInfo.performanceCount) || baccountInfo.performanceCount.equals("0")) {
                    z = false;
                } else {
                    StringBuilder sb2 = this.i;
                    sb2.append(baccountInfo.performanceCount + "场在售演出");
                }
                String str2 = baccountInfo.type;
                if (str2 == null || !"3".equals(str2)) {
                    str = SearchHelper.g(baccountInfo.fansCount);
                } else {
                    str = SearchHelper.f(baccountInfo.distance);
                }
                if (!TextUtils.isEmpty(str)) {
                    if (z) {
                        this.i.append(" | ");
                    }
                    this.i.append(str);
                }
                if (this.i.length() > 0) {
                    return this.i.toString();
                }
                return "";
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void d(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1075045922")) {
                ipChange.ipc$dispatch("-1075045922", new Object[]{this, baccountInfo});
            } else if (baccountInfo != null) {
                SearchHelper.a = baccountInfo.index;
                c.e().x(c62.C().H(baccountInfo.damaiId));
                if (baccountInfo.type.equals("5")) {
                    Bundle bundle = new Bundle();
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, baccountInfo.damaiId);
                    DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(wz1.REPERTOITE));
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString(FeedsViewModel.ARG_USERID, baccountInfo.damaiId);
                bundle2.putString("usertype", baccountInfo.type);
                DMNav.from(this.a).withExtras(bundle2).toUri(NavUri.b(gr.ARTISTID_THEME));
            }
        }

        public void c(BaccountInfo baccountInfo, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "967640456")) {
                ipChange.ipc$dispatch("967640456", new Object[]{this, baccountInfo, Integer.valueOf(i2)});
            } else if (baccountInfo != null) {
                baccountInfo.index = i2;
                this.b.setTag(baccountInfo);
                this.h.setTag(baccountInfo);
                if (this.c.getTag() instanceof zq) {
                    ((zq) this.c.getTag()).cancel();
                }
                DMImageCreator c2 = cn.damai.common.image.a.b().h(this.a).c(baccountInfo.headPic);
                int i3 = R$drawable.uikit_user_default_icon;
                this.c.setTag(c2.i(i3).c(i3).k(new cq()).g(this.c));
                this.d.setVisibility(baccountInfo.isShowVTag() ? 0 : 8);
                this.e.setText(baccountInfo.name);
                String b2 = b(baccountInfo);
                if (TextUtils.isEmpty(b2)) {
                    this.f.setVisibility(8);
                } else {
                    this.f.setText(b2);
                    this.f.setVisibility(0);
                }
                if (!LoginManager.k().q() || !baccountInfo.isHasFollow()) {
                    f();
                } else {
                    e();
                }
            }
        }

        public void e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1215593984")) {
                ipChange.ipc$dispatch("-1215593984", new Object[]{this});
                return;
            }
            this.g.setText("已关注");
            this.g.setTextColor(Color.parseColor("#888888"));
            this.h.setBackgroundResource(R$drawable.attention_button_bg);
        }

        public void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1695422623")) {
                ipChange.ipc$dispatch("-1695422623", new Object[]{this});
                return;
            }
            this.g.setText("+关注");
            this.g.setTextColor(Color.parseColor("#FF1268"));
            this.h.setBackgroundResource(R$drawable.attention_cancel_button_bg);
        }
    }

    public AccountMoreAdapter(Context context, List<BaccountInfo> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1516305446")) {
            return xf2.e(this.b);
        }
        return ((Integer) ipChange.ipc$dispatch("1516305446", new Object[]{this})).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "843995411")) {
            ipChange.ipc$dispatch("843995411", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        ((AccountViewHolder) viewHolder).c(this.b.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547768253")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1547768253", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Context context = this.a;
        return new AccountViewHolder(this, context, LayoutInflater.from(context));
    }
}
