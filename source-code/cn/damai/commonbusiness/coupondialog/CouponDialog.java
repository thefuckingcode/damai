package cn.damai.commonbusiness.coupondialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.R$style;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.uikit.number.DMDigitTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.co;
import tb.d20;
import tb.g91;
import tb.xf2;

/* compiled from: Taobao */
public class CouponDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<View> a;
    private List<CouponListResponse.Coupon> b;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private CouponListAdapter h;
    private OnUseButtonClickListener i;
    private String j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private boolean p;

    /* compiled from: Taobao */
    public class CouponListAdapter extends RecyclerView.Adapter<CouponViewHolder> {
        private static transient /* synthetic */ IpChange $ipChange;

        CouponListAdapter() {
        }

        /* renamed from: a */
        public void onBindViewHolder(@NonNull CouponViewHolder couponViewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "921738220")) {
                ipChange.ipc$dispatch("921738220", new Object[]{this, couponViewHolder, Integer.valueOf(i)});
                return;
            }
            couponViewHolder.a(i, (CouponListResponse.Coupon) CouponDialog.this.b.get(i));
        }

        @NonNull
        /* renamed from: b */
        public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1733564042")) {
                return new CouponViewHolder();
            }
            return (CouponViewHolder) ipChange.ipc$dispatch("1733564042", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1239992233")) {
                return xf2.e(CouponDialog.this.b);
            }
            return ((Integer) ipChange.ipc$dispatch("-1239992233", new Object[]{this})).intValue();
        }
    }

    /* compiled from: Taobao */
    public class CouponViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a = ((TextView) this.itemView.findViewById(R$id.dialog_coupon_list_item_money_flag));
        private DMDigitTextView b = ((DMDigitTextView) this.itemView.findViewById(R$id.dialog_coupon_list_item_money));
        private TextView c = ((TextView) this.itemView.findViewById(R$id.dialog_coupon_list_item_use_condition));
        private TextView d = ((TextView) this.itemView.findViewById(R$id.dialog_coupon_list_item_title));
        private TextView e = ((TextView) this.itemView.findViewById(R$id.dialog_coupon_list_item_time));

        public CouponViewHolder() {
            super(LayoutInflater.from(CouponDialog.this.getContext()).inflate(R$layout.dialog_coupon_list_item, (ViewGroup) null));
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }

        public void a(int i, CouponListResponse.Coupon coupon) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "388929434")) {
                ipChange.ipc$dispatch("388929434", new Object[]{this, Integer.valueOf(i), coupon});
            } else if (coupon != null) {
                if (!TextUtils.isEmpty(coupon.amount)) {
                    this.a.setVisibility(0);
                    this.b.setText(coupon.amount);
                } else {
                    this.a.setVisibility(8);
                }
                this.c.setText(coupon.condition);
                this.d.setText(coupon.name);
                if (TextUtils.isEmpty(coupon.startTime) || TextUtils.isEmpty(coupon.endTime)) {
                    this.e.setText(String.format("%s%s", coupon.startTime, coupon.endTime));
                } else {
                    this.e.setText(String.format("%s-%s", coupon.startTime, coupon.endTime));
                }
                coupon.startShowTimeMillis = System.currentTimeMillis();
                coupon.eventTrack = CouponDialog.this.o;
                coupon.couponId = CouponDialog.this.n;
                this.itemView.setTag(coupon);
                CouponDialog.this.a.add(this.itemView);
            }
        }
    }

    /* compiled from: Taobao */
    public interface OnUseButtonClickListener {
        void onClick(String str);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1872786913")) {
                ipChange.ipc$dispatch("1872786913", new Object[]{this, view});
            } else if (CouponDialog.this.i != null) {
                CouponDialog.this.i.onClick(CouponDialog.this.j);
            } else {
                CouponDialog.this.l();
                DMNav.from(CouponDialog.this.getContext()).toUri(CouponDialog.this.j);
                CouponDialog.this.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-310890014")) {
                ipChange.ipc$dispatch("-310890014", new Object[]{this, view});
                return;
            }
            CouponDialog.this.dismiss();
        }
    }

    public CouponDialog(@NonNull Context context) {
        this(context, R$style.DMDialogStyle);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228006254")) {
            ipChange.ipc$dispatch("228006254", new Object[]{this});
            return;
        }
        View inflate = getLayoutInflater().inflate(R$layout.dialog_coupon, (ViewGroup) null);
        this.c = inflate;
        this.d = (TextView) inflate.findViewById(R$id.dialog_coupon_title);
        this.e = (TextView) this.c.findViewById(R$id.dialog_coupon_subtitle);
        RecyclerView recyclerView = (RecyclerView) this.c.findViewById(R$id.dialog_coupon_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        CouponListAdapter couponListAdapter = new CouponListAdapter();
        this.h = couponListAdapter;
        recyclerView.setAdapter(couponListAdapter);
        TextView textView = (TextView) this.c.findViewById(R$id.dialog_coupon_use_btn);
        this.f = textView;
        textView.setOnClickListener(new a());
        this.g = (TextView) this.c.findViewById(R$id.dialog_coupon_use_tip);
        ((ImageView) this.c.findViewById(R$id.dialog_coupon_close_btn)).setOnClickListener(new b());
        setContentView(this.c);
    }

    public String g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-270008176")) {
            return this.n;
        }
        return (String) ipChange.ipc$dispatch("-270008176", new Object[]{this});
    }

    public String h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1407520384")) {
            return this.o;
        }
        return (String) ipChange.ipc$dispatch("1407520384", new Object[]{this});
    }

    public List<View> i() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1490057897")) {
            return this.a;
        }
        return (List) ipChange.ipc$dispatch("1490057897", new Object[]{this});
    }

    public boolean j() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1505190492")) {
            return this.p;
        }
        return ((Boolean) ipChange.ipc$dispatch("1505190492", new Object[]{this})).booleanValue();
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032219924")) {
            ipChange.ipc$dispatch("2032219924", new Object[]{this});
        } else if (!TextUtils.isEmpty(this.l)) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(this.m)) {
                hashMap.put("city", d20.d() + "市");
            } else {
                hashMap.put("item_id", this.m);
                hashMap.put("usercode", d20.E());
            }
            c.e().x(cn.damai.common.user.b.getInstance().e(this.l, "redpaper", "use", hashMap, Boolean.TRUE));
        }
    }

    public void m(CouponListResponse.ContentList contentList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "669731716")) {
            ipChange.ipc$dispatch("669731716", new Object[]{this, contentList});
            return;
        }
        this.k = false;
        if (contentList != null) {
            this.n = contentList.id;
            this.o = contentList.eventTrack;
            this.j = contentList.appButtonAction;
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(contentList.title);
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setText(contentList.header);
            }
            TextView textView3 = this.f;
            if (textView3 != null) {
                textView3.setText(contentList.buttonName);
                boolean z = !TextUtils.isEmpty(contentList.appButtonAction) && !TextUtils.isEmpty(contentList.buttonName);
                this.p = z;
                this.f.setVisibility(z ? 0 : 8);
            }
            TextView textView4 = this.g;
            if (textView4 != null) {
                textView4.setText(contentList.footer);
            }
            List<CouponListResponse.Coupon> list = contentList.itemList;
            if (xf2.e(list) <= 0) {
                CouponDialogHelper.l(getContext()).x(0);
                return;
            }
            this.b.clear();
            this.b.addAll(list);
            CouponListAdapter couponListAdapter = this.h;
            if (couponListAdapter != null) {
                couponListAdapter.notifyDataSetChanged();
            }
            this.k = true;
        }
    }

    public void n(List<CouponListResponse.Model> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956168180")) {
            ipChange.ipc$dispatch("-956168180", new Object[]{this, list});
            return;
        }
        this.k = false;
        if (xf2.e(list) <= 0) {
            if (CouponDialogHelper.l(getContext()).m()) {
                CouponDialogHelper.l(getContext()).D("仅限新用户领取");
            }
            CouponDialogHelper.l(getContext()).x(0);
            return;
        }
        CouponListResponse.Model model = list.get(0);
        if (model == null) {
            if (CouponDialogHelper.l(getContext()).m()) {
                CouponDialogHelper.l(getContext()).D("仅限新用户领取");
            }
            CouponDialogHelper.l(getContext()).x(0);
        } else if ("1".equals(model.type)) {
            List<CouponListResponse.ContentList> list2 = model.contentList;
            if (xf2.e(list2) <= 0) {
                if (CouponDialogHelper.l(getContext()).m()) {
                    CouponDialogHelper.l(getContext()).D("仅限新用户领取");
                }
                CouponDialogHelper.l(getContext()).x(0);
                return;
            }
            CouponListResponse.ContentList contentList = list2.get(0);
            if (contentList == null) {
                if (CouponDialogHelper.l(getContext()).m()) {
                    CouponDialogHelper.l(getContext()).D("仅限新用户领取");
                }
                CouponDialogHelper.l(getContext()).x(0);
                return;
            }
            co.f().h(contentList.eventTrack);
            m(contentList);
        }
    }

    public void o(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694936096")) {
            ipChange.ipc$dispatch("1694936096", new Object[]{this, str, str2});
            return;
        }
        this.l = str;
        this.m = str2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814256628")) {
            ipChange.ipc$dispatch("-1814256628", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842620190")) {
            ipChange.ipc$dispatch("842620190", new Object[]{this});
        } else if (this.k) {
            show();
            g91.b("CouponDialogHelper", "showDialog().");
            CouponDialogHelper.l(getContext()).v();
            CouponDialogHelper.l(getContext()).z(true);
        }
    }

    public CouponDialog(@NonNull Context context, int i2) {
        super(context, i2);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.k = false;
        k();
    }
}
