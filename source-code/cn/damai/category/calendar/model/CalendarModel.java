package cn.damai.category.calendar.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CategoryPerformBean;
import cn.damai.category.common.bean.CategoryProjectBean;
import cn.damai.category.common.request.CategoryRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.te;

/* compiled from: Taobao */
public class CalendarModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private MutableLiveData<CalendarBean> mCalendarBean = new MutableLiveData<>();
    private MutableLiveData<CategoryProjectBean> mCalendarProjectBean = new MutableLiveData<>();
    private MutableLiveData<CategoryPerformBean> mCategoryPerformBean = new MutableLiveData<>();
    private Context mContext;
    private te mRepository;

    public CalendarModel(Context context) {
        this.mContext = context;
        this.mRepository = new te();
    }

    public void calendarRequest(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713825454")) {
            ipChange.ipc$dispatch("1713825454", new Object[]{this, str, str2});
            return;
        }
        this.mRepository.a(str, str2, new DMMtopRequestListener<CalendarBean>(CalendarBean.class) {
            /* class cn.damai.category.calendar.model.CalendarModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1028119269")) {
                    ipChange.ipc$dispatch("1028119269", new Object[]{this, str, str2});
                    return;
                }
                CalendarModel.this.mCalendarBean.setValue(null);
            }

            public void onSuccess(CalendarBean calendarBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-578133848")) {
                    ipChange.ipc$dispatch("-578133848", new Object[]{this, calendarBean});
                    return;
                }
                CalendarModel.this.mCalendarBean.setValue(calendarBean);
            }
        });
    }

    public MutableLiveData<CalendarBean> getCalendarBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-800706547")) {
            return this.mCalendarBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-800706547", new Object[]{this});
    }

    public MutableLiveData<CategoryProjectBean> getCalendarProjectBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-171354486")) {
            return this.mCalendarProjectBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-171354486", new Object[]{this});
    }

    public MutableLiveData<CategoryPerformBean> getCategoryPerformBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "815664914")) {
            return this.mCategoryPerformBean;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("815664914", new Object[]{this});
    }

    public void getCategoryPerformRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487474155")) {
            ipChange.ipc$dispatch("-1487474155", new Object[]{this, categoryRequest});
            return;
        }
        this.mRepository.b(categoryRequest, new DMMtopRequestListener<CategoryPerformBean>(CategoryPerformBean.class) {
            /* class cn.damai.category.calendar.model.CalendarModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1035878628")) {
                    ipChange.ipc$dispatch("1035878628", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(CategoryPerformBean categoryPerformBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-20257050")) {
                    ipChange.ipc$dispatch("-20257050", new Object[]{this, categoryPerformBean});
                    return;
                }
                CalendarModel.this.mCategoryPerformBean.setValue(categoryPerformBean);
            }
        });
    }

    public void getProjectListRequest(CategoryRequest categoryRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1938862359")) {
            ipChange.ipc$dispatch("-1938862359", new Object[]{this, categoryRequest});
            return;
        }
        this.mRepository.c(categoryRequest, new DMMtopRequestListener<CategoryProjectBean>(CategoryProjectBean.class) {
            /* class cn.damai.category.calendar.model.CalendarModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1043637987")) {
                    ipChange.ipc$dispatch("1043637987", new Object[]{this, str, str2});
                    return;
                }
                CalendarModel.this.mCalendarProjectBean.setValue(null);
            }

            public void onSuccess(CategoryProjectBean categoryProjectBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "410380397")) {
                    ipChange.ipc$dispatch("410380397", new Object[]{this, categoryProjectBean});
                    return;
                }
                CalendarModel.this.mCalendarProjectBean.setValue(categoryProjectBean);
            }
        });
    }
}
