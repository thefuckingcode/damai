package cn.damai.category.discountticket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.biz.BannerWrap;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.category.discountticket.bean.biz.ViewMoreBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.sub.BannerItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kt2;

/* compiled from: Taobao */
public class DiscountTicketAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private LayoutInflater a;
    private Context b;
    private List c;
    private OnItemClickListener d;
    private kt2 e;

    /* compiled from: Taobao */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public BaseViewHolder(View view) {
            super(view);
        }

        public abstract void a(T t);
    }

    /* compiled from: Taobao */
    public interface OnItemClickListener {
        void onBannerClick(BannerItem bannerItem, int i);

        void onGetCouponClick(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean);

        void onProjectItemClick(ProjectItemBean projectItemBean, boolean z);

        void onTipLinkClick(HeaderCouponBean headerCouponBean);

        void onViewMoreClick();
    }

    /* compiled from: Taobao */
    public static class a implements OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnItemClickListener a;

        public a(OnItemClickListener onItemClickListener) {
            this.a = onItemClickListener;
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onBannerClick(BannerItem bannerItem, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-808882880")) {
                ipChange.ipc$dispatch("-808882880", new Object[]{this, bannerItem, Integer.valueOf(i)});
                return;
            }
            OnItemClickListener onItemClickListener = this.a;
            if (onItemClickListener != null) {
                onItemClickListener.onBannerClick(bannerItem, i);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onGetCouponClick(HeaderCouponBean headerCouponBean, CouponActivityBean couponActivityBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-865724587")) {
                ipChange.ipc$dispatch("-865724587", new Object[]{this, headerCouponBean, couponActivityBean});
                return;
            }
            OnItemClickListener onItemClickListener = this.a;
            if (onItemClickListener != null) {
                onItemClickListener.onGetCouponClick(headerCouponBean, couponActivityBean);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onProjectItemClick(ProjectItemBean projectItemBean, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "731826339")) {
                ipChange.ipc$dispatch("731826339", new Object[]{this, projectItemBean, Boolean.valueOf(z)});
                return;
            }
            OnItemClickListener onItemClickListener = this.a;
            if (onItemClickListener != null) {
                onItemClickListener.onProjectItemClick(projectItemBean, z);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onTipLinkClick(HeaderCouponBean headerCouponBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-112154313")) {
                ipChange.ipc$dispatch("-112154313", new Object[]{this, headerCouponBean});
                return;
            }
            OnItemClickListener onItemClickListener = this.a;
            if (onItemClickListener != null) {
                onItemClickListener.onTipLinkClick(headerCouponBean);
            }
        }

        @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.OnItemClickListener
        public void onViewMoreClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-912065429")) {
                ipChange.ipc$dispatch("-912065429", new Object[]{this});
                return;
            }
            OnItemClickListener onItemClickListener = this.a;
            if (onItemClickListener != null) {
                onItemClickListener.onViewMoreClick();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private ProjectItemBean a;

        public b(ProjectItemBean projectItemBean) {
            this.a = projectItemBean;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2088152574")) {
                ipChange.ipc$dispatch("2088152574", new Object[]{this, view});
            } else if (this.a != null) {
                DiscountTicketAdapter.this.d.onProjectItemClick(this.a, false);
            }
        }
    }

    public DiscountTicketAdapter(kt2 kt2, Context context, OnItemClickListener onItemClickListener) {
        this.d = new a(onItemClickListener);
        this.b = context;
        this.e = kt2;
        this.a = LayoutInflater.from(context);
    }

    public void c(Object obj) {
        int indexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041024157")) {
            ipChange.ipc$dispatch("-1041024157", new Object[]{this, obj});
            return;
        }
        List list = this.c;
        if (list != null && (indexOf = list.indexOf(obj)) >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public void d(boolean z, List list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037823907")) {
            ipChange.ipc$dispatch("1037823907", new Object[]{this, Boolean.valueOf(z), list});
            return;
        }
        if (z) {
            this.c = list;
        } else {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (list != null && list.size() > 0) {
                this.c.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347712904")) {
            return ((Integer) ipChange.ipc$dispatch("-1347712904", new Object[]{this})).intValue();
        }
        List list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486911713")) {
            return ((Integer) ipChange.ipc$dispatch("-1486911713", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Class<?> cls = this.c.get(i).getClass();
        if (cls == Column3WrapBean.class) {
            return 1;
        }
        if (cls == ProjectItemBean.class) {
            return 2;
        }
        if (cls == HeaderCouponBean.class) {
            return 3;
        }
        if (cls == ViewMoreBean.class) {
            return 4;
        }
        if (cls == DiscountTipBean.class) {
            return 5;
        }
        if (cls == BannerWrap.class) {
            return 6;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2026671743")) {
            ipChange.ipc$dispatch("-2026671743", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        Object obj = this.c.get(i);
        if (viewHolder instanceof BaseViewHolder) {
            ((BaseViewHolder) viewHolder).a(obj);
        } else if (viewHolder instanceof ProjectItemViewHolder) {
            ProjectItemBean projectItemBean = (ProjectItemBean) obj;
            ((ProjectItemViewHolder) viewHolder).k(projectItemBean);
            viewHolder.itemView.setOnClickListener(new b(projectItemBean));
            kt2 kt2 = this.e;
            if (kt2 != null) {
                kt2.l(viewHolder.itemView, projectItemBean.pos, projectItemBean.id);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1436978581")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1436978581", new Object[]{this, viewGroup, Integer.valueOf(i)});
        } else if (i == 1) {
            return new Column3ProjectViewHolder(LayoutInflater.from(this.b).inflate(R$layout.item_discount_near_3_row, viewGroup, false)) {
                /* class cn.damai.category.discountticket.adapter.DiscountTicketAdapter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.category.discountticket.adapter.Column3ProjectViewHolder
                public void e(View view, ProjectItemBean projectItemBean, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1434300607")) {
                        ipChange.ipc$dispatch("1434300607", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
                    } else if (DiscountTicketAdapter.this.e != null) {
                        DiscountTicketAdapter.this.e.k(view, i, projectItemBean.id);
                    }
                }

                @Override // cn.damai.category.discountticket.adapter.Column3ProjectViewHolder
                public void f(ProjectItemBean projectItemBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "438710440")) {
                        ipChange.ipc$dispatch("438710440", new Object[]{this, projectItemBean});
                        return;
                    }
                    DiscountTicketAdapter.this.d.onProjectItemClick(projectItemBean, true);
                }
            };
        } else {
            if (i == 3) {
                return new HeaderCouponViewHolder(LayoutInflater.from(this.b).inflate(R$layout.item_header_coupon, viewGroup, false)) {
                    /* class cn.damai.category.discountticket.adapter.DiscountTicketAdapter.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.category.discountticket.adapter.HeaderCouponViewHolder
                    public void d(View view, int i, String str) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1380342009")) {
                            ipChange.ipc$dispatch("-1380342009", new Object[]{this, view, Integer.valueOf(i), str});
                        } else if (DiscountTicketAdapter.this.e != null) {
                            DiscountTicketAdapter.this.e.j(view, i, str);
                        }
                    }

                    @Override // cn.damai.category.discountticket.adapter.HeaderCouponViewHolder
                    public void e(@NonNull HeaderCouponBean headerCouponBean, @NonNull CouponActivityBean couponActivityBean) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "304191901")) {
                            ipChange.ipc$dispatch("304191901", new Object[]{this, headerCouponBean, couponActivityBean});
                            return;
                        }
                        DiscountTicketAdapter.this.d.onGetCouponClick(headerCouponBean, couponActivityBean);
                    }

                    @Override // cn.damai.category.discountticket.adapter.HeaderCouponViewHolder
                    public void f(HeaderCouponBean headerCouponBean) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "562562943")) {
                            ipChange.ipc$dispatch("562562943", new Object[]{this, headerCouponBean});
                            return;
                        }
                        DiscountTicketAdapter.this.d.onTipLinkClick(headerCouponBean);
                    }
                };
            }
            if (i == 4) {
                return new ViewMoreViewHolder(LayoutInflater.from(this.b).inflate(R$layout.item_discount_view_more, viewGroup, false)) {
                    /* class cn.damai.category.discountticket.adapter.DiscountTicketAdapter.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.category.discountticket.adapter.ViewMoreViewHolder
                    public void c() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1619368863")) {
                            ipChange.ipc$dispatch("-1619368863", new Object[]{this});
                            return;
                        }
                        DiscountTicketAdapter.this.d.onViewMoreClick();
                    }

                    @Override // cn.damai.category.discountticket.adapter.ViewMoreViewHolder
                    public void d(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-445959816")) {
                            ipChange.ipc$dispatch("-445959816", new Object[]{this, view});
                        } else if (DiscountTicketAdapter.this.e != null) {
                            DiscountTicketAdapter.this.e.m(view);
                        }
                    }
                };
            }
            if (i == 5) {
                return new MoreDiscountTipViewHolder(LayoutInflater.from(this.b).inflate(R$layout.item_discount_more_discount_tip, viewGroup, false));
            }
            if (i != 6) {
                return new ProjectItemViewHolder(this.b, this.a);
            }
            return new BannerViewHolder(LayoutInflater.from(this.b).inflate(R$layout.item_discount_banner, viewGroup, false)) {
                /* class cn.damai.category.discountticket.adapter.DiscountTicketAdapter.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.uikit.banner.sub.XBanner.OnBannerClickListener
                public void onBannerClick(BannerItem bannerItem, int i) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2003743691")) {
                        ipChange.ipc$dispatch("2003743691", new Object[]{this, bannerItem, Integer.valueOf(i)});
                        return;
                    }
                    DiscountTicketAdapter.this.d.onBannerClick(bannerItem, i);
                }
            };
        }
    }
}
