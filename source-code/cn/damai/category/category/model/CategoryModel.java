package cn.damai.category.category.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.category.bean.CategoryBrandBean;
import cn.damai.category.category.bean.CategoryNewProjectBean;
import cn.damai.category.category.bean.CategoryNewTitleListBean;
import cn.damai.category.category.bean.CategoryStarBean;
import cn.damai.category.category.bean.StarListBean;
import cn.damai.category.category.repository.CategoryRepository;
import cn.damai.category.category.request.BrandRequest;
import cn.damai.category.category.request.FollowRequest;
import cn.damai.category.category.request.StarListRequest;
import cn.damai.category.category.request.StarRequest;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.request.CategoryPerformRequest;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.city.net.CityListResponse;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CategoryModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private MutableLiveData<CalendarBean> mCalendarBean = new MutableLiveData<>();
    private MutableLiveData<CategoryNewProjectBean> mCalendarProjectBean = new MutableLiveData<>();
    private MutableLiveData<CategoryBrandBean> mCategoryBrandBean = new MutableLiveData<>();
    private MutableLiveData<CategoryPerformBean> mCategoryPerformBean = new MutableLiveData<>();
    private MutableLiveData<CategoryStarBean> mCategoryStarBean = new MutableLiveData<>();
    private MutableLiveData<CategoryNewTitleListBean> mCategoryTitleBean = new MutableLiveData<>();
    private MutableLiveData<CityListResponse> mCityBean = new MutableLiveData<>();
    private Context mContext;
    private MutableLiveData<FollowDataBean> mFollowDataBean = new MutableLiveData<>();
    private CategoryRepository mRepository;
    private MutableLiveData<StarListBean> mStarListBean = new MutableLiveData<>();

    public CategoryModel(Context context) {
        this.mContext = context;
        this.mRepository = new CategoryRepository();
    }

    public void calendarRequest(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015630072")) {
            ipChange.ipc$dispatch("1015630072", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRepository.calendarRequest(str, str2, str3, new DMMtopRequestListener<CalendarBean>(CalendarBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-197068572")) {
                    ipChange.ipc$dispatch("-197068572", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CalendarBean calendarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "178314569")) {
                    ipChange.ipc$dispatch("178314569", new Object[]{this, calendarBean});
                    return;
                }
                CategoryModel.this.mCalendarBean.setValue(calendarBean);
            }
        });
    }

    public void categoryNewTitleRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1563637998")) {
            ipChange.ipc$dispatch("-1563637998", new Object[]{this});
            return;
        }
        this.mRepository.getCategoryNewTitle(new DMMtopRequestListener<CategoryNewTitleListBean>(CategoryNewTitleListBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-189309213")) {
                    ipChange.ipc$dispatch("-189309213", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mCategoryTitleBean.setValue(null);
            }

            public void onSuccess(CategoryNewTitleListBean categoryNewTitleListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1310041985")) {
                    ipChange.ipc$dispatch("1310041985", new Object[]{this, categoryNewTitleListBean});
                    return;
                }
                CategoryModel.this.mCategoryTitleBean.setValue(categoryNewTitleListBean);
            }
        });
    }

    public void followRequest(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112461077")) {
            ipChange.ipc$dispatch("-2112461077", new Object[]{this, str, str2, str3});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = str;
        followRequest.targetId = str2;
        followRequest.targetType = str3;
        this.mRepository.followRequest(followRequest, new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-235865367")) {
                    ipChange.ipc$dispatch("-235865367", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mFollowDataBean.setValue(null);
            }

            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-339923625")) {
                    ipChange.ipc$dispatch("-339923625", new Object[]{this, followDataBean});
                    return;
                }
                CategoryModel.this.mFollowDataBean.setValue(followDataBean);
            }
        });
    }

    public void getBrandRequest(BrandRequest brandRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136717809")) {
            ipChange.ipc$dispatch("1136717809", new Object[]{this, brandRequest});
            return;
        }
        this.mRepository.getBrandRequest(brandRequest, new DMMtopRequestListener<CategoryBrandBean>(CategoryBrandBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-243624726")) {
                    ipChange.ipc$dispatch("-243624726", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mCategoryBrandBean.setValue(null);
            }

            public void onSuccess(CategoryBrandBean categoryBrandBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-961118695")) {
                    ipChange.ipc$dispatch("-961118695", new Object[]{this, categoryBrandBean});
                    return;
                }
                CategoryModel.this.mCategoryBrandBean.setValue(categoryBrandBean);
            }
        });
    }

    public MutableLiveData<CalendarBean> getCalendarBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1746999283")) {
            return this.mCalendarBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-1746999283", new Object[]{this});
    }

    public MutableLiveData<CategoryNewProjectBean> getCalendarProjectBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-881746294")) {
            return this.mCalendarProjectBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-881746294", new Object[]{this});
    }

    public MutableLiveData<CategoryBrandBean> getCategoryBrandBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2001048520")) {
            return this.mCategoryBrandBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-2001048520", new Object[]{this});
    }

    public MutableLiveData<CategoryPerformBean> getCategoryPerformBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "105273106")) {
            return this.mCategoryPerformBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("105273106", new Object[]{this});
    }

    public MutableLiveData<CategoryStarBean> getCategoryStarBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-730802497")) {
            return this.mCategoryStarBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-730802497", new Object[]{this});
    }

    public void getCategorySubRequest(CategoryPerformRequest categoryPerformRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815729121")) {
            ipChange.ipc$dispatch("-1815729121", new Object[]{this, categoryPerformRequest});
            return;
        }
        this.mRepository.getCategorySubRequest(categoryPerformRequest, new DMMtopRequestListener<CategoryPerformBean>(CategoryPerformBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-220346649")) {
                    ipChange.ipc$dispatch("-220346649", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mCategoryPerformBean.setValue(null);
            }

            public void onSuccess(CategoryPerformBean categoryPerformBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-497806807")) {
                    ipChange.ipc$dispatch("-497806807", new Object[]{this, categoryPerformBean});
                    return;
                }
                CategoryModel.this.mCategoryPerformBean.setValue(categoryPerformBean);
            }
        });
    }

    public MutableLiveData<CategoryNewTitleListBean> getCategoryTitleBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "527707593")) {
            return this.mCategoryTitleBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("527707593", new Object[]{this});
    }

    public MutableLiveData<CityListResponse> getCityBeanBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1256557494")) {
            return this.mCityBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-1256557494", new Object[]{this});
    }

    public void getCityRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372646831")) {
            ipChange.ipc$dispatch("-1372646831", new Object[]{this});
            return;
        }
        this.mRepository.cityRequest(new DMMtopRequestListener<CityListResponse>(CityListResponse.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-204827931")) {
                    ipChange.ipc$dispatch("-204827931", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CityListResponse cityListResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1924585262")) {
                    ipChange.ipc$dispatch("-1924585262", new Object[]{this, cityListResponse});
                    return;
                }
                CategoryModel.this.mCityBean.setValue(cityListResponse);
            }
        });
    }

    public MutableLiveData<FollowDataBean> getFollowDataBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-687190134")) {
            return this.mFollowDataBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-687190134", new Object[]{this});
    }

    public void getPerformListRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055716145")) {
            ipChange.ipc$dispatch("1055716145", new Object[]{this, categoryRequest});
            return;
        }
        this.mRepository.getPerfromListRequest(categoryRequest, new DMMtopRequestListener<CategoryNewProjectBean>(CategoryNewProjectBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-212587290")) {
                    ipChange.ipc$dispatch("-212587290", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mCalendarProjectBean.setValue(null);
            }

            public void onSuccess(CategoryNewProjectBean categoryNewProjectBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-563844997")) {
                    ipChange.ipc$dispatch("-563844997", new Object[]{this, categoryNewProjectBean});
                    return;
                }
                CategoryModel.this.mCalendarProjectBean.setValue(categoryNewProjectBean);
            }
        });
    }

    public MutableLiveData<StarListBean> getStarListBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "127137887")) {
            return this.mStarListBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("127137887", new Object[]{this});
    }

    public void getStarListRequest(StarListRequest starListRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99836929")) {
            ipChange.ipc$dispatch("99836929", new Object[]{this, starListRequest});
            return;
        }
        this.mRepository.getStarListRequest(starListRequest, new DMMtopRequestListener<StarListBean>(StarListBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-251384085")) {
                    ipChange.ipc$dispatch("-251384085", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mStarListBean.setValue(null);
            }

            public void onSuccess(StarListBean starListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2037905443")) {
                    ipChange.ipc$dispatch("-2037905443", new Object[]{this, starListBean});
                    return;
                }
                CategoryModel.this.mStarListBean.setValue(starListBean);
            }
        });
    }

    public void getStarRequest(StarRequest starRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266492027")) {
            ipChange.ipc$dispatch("-266492027", new Object[]{this, starRequest});
            return;
        }
        this.mRepository.getStarRequest(starRequest, new DMMtopRequestListener<CategoryStarBean>(CategoryStarBean.class) {
            /* class cn.damai.category.category.model.CategoryModel.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-228106008")) {
                    ipChange.ipc$dispatch("-228106008", new Object[]{this, str, str2});
                    return;
                }
                CategoryModel.this.mCategoryStarBean.setValue(null);
            }

            public void onSuccess(CategoryStarBean categoryStarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-213112160")) {
                    ipChange.ipc$dispatch("-213112160", new Object[]{this, categoryStarBean});
                    return;
                }
                CategoryModel.this.mCategoryStarBean.setValue(categoryStarBean);
            }
        });
    }
}
