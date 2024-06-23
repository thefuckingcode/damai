package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.PageSpec;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.ui.adapter.ArtificialAdapter;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.c62;
import tb.f92;
import tb.n42;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class SearchHeadViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private SearchHeadAccountViewHolder a;
    private SearchHeadTourViewHolder b;
    private SearchHeadBrandOptViewHolder c;
    private View d;
    private View e;
    private View f;
    private View g;
    private Context h;
    private ArtificialAdapter i;
    private int j = n42.a(xs0.a(), 12.0f);
    private int k = n42.a(xs0.a(), 15.0f);
    private View l;
    private View m;
    private String n;
    private String o;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArtificialProxy a;

        a(ArtificialProxy artificialProxy) {
            this.a = artificialProxy;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-561252613")) {
                ipChange.ipc$dispatch("-561252613", new Object[]{this, view});
                return;
            }
            SearchHeadViewHolder.this.j(this.a, 0);
        }
    }

    /* compiled from: Taobao */
    public class b implements OnItemBindListener<ArtificialProxy> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void exposeItem(View view, ArtificialProxy artificialProxy, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "969217969")) {
                ipChange.ipc$dispatch("969217969", new Object[]{this, view, artificialProxy, Integer.valueOf(i)});
                return;
            }
            SearchHeadViewHolder.this.g(view, artificialProxy, i);
        }

        /* renamed from: b */
        public void onItemClick(ArtificialProxy artificialProxy, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-394834074")) {
                ipChange.ipc$dispatch("-394834074", new Object[]{this, artificialProxy, Integer.valueOf(i)});
                return;
            }
            SearchHeadViewHolder.this.j(artificialProxy, i);
        }
    }

    public SearchHeadViewHolder(Context context, Daojishi daojishi) {
        super(LayoutInflater.from(xs0.a()).inflate(R$layout.item_view_search_head, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        View findViewById = this.itemView.findViewById(R$id.item_layout_b_account);
        View findViewById2 = this.itemView.findViewById(R$id.item_layout_tour);
        View findViewById3 = this.itemView.findViewById(R$id.item_layout_brand_opt);
        this.d = this.itemView.findViewById(R$id.item_layout_below_account);
        this.e = this.itemView.findViewById(R$id.item_layout_below_account_inner);
        this.f = this.itemView.findViewById(R$id.item_single_artificial);
        this.g = this.itemView.findViewById(R$id.item_multi_artificial);
        this.l = this.itemView.findViewById(R$id.item_view_search_divide_line_below_tour);
        this.m = this.itemView.findViewById(R$id.item_view_search_divide_line_below_brand);
        this.a = new SearchHeadAccountViewHolder(context, findViewById);
        this.b = new SearchHeadTourViewHolder(context, findViewById2, daojishi);
        this.c = new SearchHeadBrandOptViewHolder(context, findViewById3);
        this.h = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(View view, ArtificialProxy artificialProxy, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643619959")) {
            ipChange.ipc$dispatch("-1643619959", new Object[]{this, view, artificialProxy, Integer.valueOf(i2)});
        } else if (view != null && artificialProxy != null) {
            String id = artificialProxy.getId();
            ArtificialProxy.Type type = artificialProxy.getType();
            if (type != null) {
                c62.C().A(view, i2, this.n, this.o, id, type.utName);
            }
        }
    }

    private boolean h(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941091347")) {
            return ((Boolean) ipChange.ipc$dispatch("941091347", new Object[]{this, searchDataHolder})).booleanValue();
        } else if (searchDataHolder.tour != null || xf2.e(searchDataHolder.mBrandOptimizations) >= 3 || !f92.d(searchDataHolder.artificialList)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean i(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "605361562")) {
            return !f92.d(searchDataHolder.mBrandOptimizations) || !f92.d(searchDataHolder.artificialList);
        }
        return ((Boolean) ipChange.ipc$dispatch("605361562", new Object[]{this, searchDataHolder})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(ArtificialProxy artificialProxy, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164574469")) {
            ipChange.ipc$dispatch("164574469", new Object[]{this, artificialProxy, Integer.valueOf(i2)});
        } else if (this.h != null && artificialProxy != null) {
            PageSpec toPageSpec = artificialProxy.getToPageSpec();
            if (!TextUtils.isEmpty(toPageSpec.url)) {
                c.e().x(c62.C().B(this.n, this.o, i2));
                if (toPageSpec.mBundle != null) {
                    DMNav.from(this.h).withExtras(toPageSpec.mBundle).toUri(toPageSpec.url);
                } else {
                    DMNav.from(this.h).toUri(toPageSpec.url);
                }
            }
        }
    }

    private void k(List<ArtificialProxy> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044400648")) {
            ipChange.ipc$dispatch("2044400648", new Object[]{this, list});
            return;
        }
        if (this.i == null) {
            this.i = new ArtificialAdapter(this.h, new b());
            RecyclerView recyclerView = (RecyclerView) this.g.findViewById(R$id.item_multi_artificial);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.h, 0, false));
            recyclerView.setAdapter(this.i);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                /* class cn.damai.search.ui.viewholder.SearchHeadViewHolder.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1136092223")) {
                        ipChange.ipc$dispatch("-1136092223", new Object[]{this, rect, view, recyclerView, state});
                        return;
                    }
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    if (childAdapterPosition == 0) {
                        rect.left = SearchHeadViewHolder.this.k;
                    } else {
                        rect.left = SearchHeadViewHolder.this.j;
                    }
                    if (childAdapterPosition >= SearchHeadViewHolder.this.i.getItemCount() - 1) {
                        rect.right = SearchHeadViewHolder.this.k;
                    }
                }
            });
        }
        this.i.c(list);
    }

    private void l(ArtificialProxy artificialProxy) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299895470")) {
            ipChange.ipc$dispatch("-299895470", new Object[]{this, artificialProxy});
            return;
        }
        ImageView imageView = (ImageView) this.f.findViewById(R$id.item_single_artificial_img);
        TextView textView = (TextView) this.f.findViewById(R$id.item_single_artificial_text);
        this.f.findViewById(R$id.item_single_video_tag).setVisibility(artificialProxy.isShowVideoTag() ? 0 : 8);
        textView.setText(artificialProxy.getTitle());
        SearchHelper.s(imageView, artificialProxy.getImgUrl(), DisplayMetrics.getwidthPixels(n42.b(xs0.a())) - (n42.a(xs0.a(), 36.0f) * 2), n42.a(xs0.a(), 170.0f));
        this.f.setOnClickListener(new a(artificialProxy));
        g(this.f, artificialProxy, 0);
    }

    public void f(SearchDataHolder searchDataHolder, String str, String str2) {
        boolean z;
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1753313108")) {
            ipChange.ipc$dispatch("1753313108", new Object[]{this, searchDataHolder, str, str2});
        } else if (searchDataHolder != null) {
            this.n = str2;
            this.o = str;
            BaccountInfo baccountInfo = searchDataHolder.mAccountInfo;
            List<BrandOptimizationDO> list = searchDataHolder.mBrandOptimizations;
            SearchTourBean searchTourBean = searchDataHolder.tour;
            boolean z3 = xf2.e(list) >= 3;
            boolean h2 = h(searchDataHolder);
            int i4 = 8;
            this.l.setVisibility(searchTourBean != null && i(searchDataHolder) ? 0 : 8);
            List<String> list2 = null;
            if (baccountInfo != null) {
                list2 = baccountInfo.moreInfo;
                z = true;
            } else {
                z = false;
            }
            this.a.a(baccountInfo, h2);
            this.b.e(searchTourBean, str, list2);
            this.c.d(list, str);
            List<ArtificialProxy> list3 = searchDataHolder.artificialList;
            int e2 = xf2.e(list3);
            if (e2 <= 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                z2 = false;
            } else if (e2 == 1) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                l(list3.get(0));
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                k(list3);
            }
            this.m.setVisibility((!z3 || !z2) ? 8 : 0);
            View view = this.d;
            if (h2) {
                i4 = 0;
            }
            view.setVisibility(i4);
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (!z || !h2) {
                i3 = 0;
                i2 = 0;
            } else {
                i3 = -n42.a(xs0.a(), 28.0f);
                i2 = n42.a(xs0.a(), 23.0f);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i3;
                this.e.setPadding(0, i2, 0, 0);
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
