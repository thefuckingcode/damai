package cn.damai.search.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchResultBean;
import cn.damai.search.bean.SearchAccountBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class SearchPrivilegeModel {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int INDEX_FIRST_PAGE = 1;
    private static final int INDEX_NO_REQUEST_YET = -1;
    private int countBAccount;
    private int countPastProject = -1;
    private int countProject;
    boolean isBAccountHasMore;
    boolean isProjectHasMore;
    private int pageIndexBAccount = -1;
    private int pageIndexPastProject = 1;
    private int pageIndexProject = 1;

    /* compiled from: Taobao */
    public static class CombineBean {
        public List<BaccountInfo> bAccountList;
        public boolean isFirstPage;
        public boolean isHasMore;
        public String keyWord;
        public List<ProjectItemBean> pastshowList;
        public List<ProjectItemBean> showList;

        public CombineBean(List<ProjectItemBean> list, List<BaccountInfo> list2, List<ProjectItemBean> list3, String str, boolean z, boolean z2) {
            this.showList = list;
            this.bAccountList = list2;
            this.keyWord = str;
            this.isFirstPage = z;
            this.isHasMore = z2;
            this.pastshowList = list3;
        }
    }

    /* compiled from: Taobao */
    public interface OnCombineListener {
        void onFail(boolean z, String str, String str2);

        void onSuccess(@NonNull CombineBean combineBean);
    }

    static /* synthetic */ int access$012(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countProject + i;
        searchPrivilegeModel.countProject = i2;
        return i2;
    }

    static /* synthetic */ int access$108(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexBAccount;
        searchPrivilegeModel.pageIndexBAccount = i + 1;
        return i;
    }

    static /* synthetic */ int access$308(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexProject;
        searchPrivilegeModel.pageIndexProject = i + 1;
        return i;
    }

    static /* synthetic */ int access$412(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countBAccount + i;
        searchPrivilegeModel.countBAccount = i2;
        return i2;
    }

    static /* synthetic */ int access$612(SearchPrivilegeModel searchPrivilegeModel, int i) {
        int i2 = searchPrivilegeModel.countPastProject + i;
        searchPrivilegeModel.countPastProject = i2;
        return i2;
    }

    static /* synthetic */ int access$708(SearchPrivilegeModel searchPrivilegeModel) {
        int i = searchPrivilegeModel.pageIndexPastProject;
        searchPrivilegeModel.pageIndexPastProject = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadBAccount(final boolean z, final boolean z2, final String str, @Nullable final List<ProjectItemBean> list, final OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326979902")) {
            ipChange.ipc$dispatch("326979902", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, list, onCombineListener});
            return;
        }
        SearchBAccountRequest searchBAccountRequest = new SearchBAccountRequest();
        searchBAccountRequest.keyword = str;
        searchBAccountRequest.baccountType = "5";
        searchBAccountRequest.pageNumber = this.pageIndexBAccount;
        searchBAccountRequest.request(new DMMtopRequestListener<SearchAccountBean>(SearchAccountBean.class) {
            /* class cn.damai.search.model.SearchPrivilegeModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "592047372")) {
                    ipChange.ipc$dispatch("592047372", new Object[]{this, str, str2});
                    return;
                }
                if (z2) {
                    SearchPrivilegeModel.this.pageIndexBAccount = -1;
                }
                onCombineListener.onFail(z, str, str2);
            }

            public void onSuccess(SearchAccountBean searchAccountBean) {
                IpChange ipChange = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange, "-1068745858")) {
                    ipChange.ipc$dispatch("-1068745858", new Object[]{this, searchAccountBean});
                    return;
                }
                if (z2) {
                    SearchPrivilegeModel.access$308(SearchPrivilegeModel.this);
                    SearchPrivilegeModel.access$012(SearchPrivilegeModel.this, xf2.e(list));
                }
                SearchPrivilegeModel.access$108(SearchPrivilegeModel.this);
                List<BaccountInfo> list = null;
                if (searchAccountBean == null) {
                    SearchPrivilegeModel.this.isBAccountHasMore = false;
                } else {
                    list = searchAccountBean.baccounts;
                    SearchPrivilegeModel.access$412(SearchPrivilegeModel.this, xf2.e(list));
                    SearchPrivilegeModel searchPrivilegeModel = SearchPrivilegeModel.this;
                    if (searchPrivilegeModel.countBAccount >= searchAccountBean.total) {
                        z = false;
                    }
                    searchPrivilegeModel.isBAccountHasMore = z;
                }
                SearchPrivilegeModel searchPrivilegeModel2 = SearchPrivilegeModel.this;
                boolean z2 = searchPrivilegeModel2.isBAccountHasMore;
                if (!z2) {
                    searchPrivilegeModel2.loadPast(z, str, onCombineListener, list, list);
                    return;
                }
                onCombineListener.onSuccess(new CombineBean(list, list, null, str, z, z2));
            }
        });
    }

    private void loadCombine(final boolean z, final String str, final OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062841183")) {
            ipChange.ipc$dispatch("-2062841183", new Object[]{this, Boolean.valueOf(z), str, onCombineListener});
            return;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.keyword = str;
        searchListRequest.pageIndex = this.pageIndexProject;
        searchListRequest.option = "1073741824";
        searchListRequest.returnItemOption = "3";
        searchListRequest.sourceType = "";
        searchListRequest.sortType = "";
        searchListRequest.cityId = "";
        searchListRequest.distanceCityId = "";
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.search.model.SearchPrivilegeModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "599806731")) {
                    ipChange.ipc$dispatch("599806731", new Object[]{this, str, str2});
                    return;
                }
                onCombineListener.onFail(z, str, str2);
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                IpChange ipChange = $ipChange;
                boolean z = false;
                if (AndroidInstantRuntime.support(ipChange, "-543473717")) {
                    ipChange.ipc$dispatch("-543473717", new Object[]{this, searchResultBean});
                    return;
                }
                List<ProjectItemBean> list = null;
                if (searchResultBean == null) {
                    SearchPrivilegeModel.this.isProjectHasMore = false;
                } else {
                    list = searchResultBean.projectInfo;
                    int e = SearchPrivilegeModel.this.countProject + xf2.e(list);
                    SearchPrivilegeModel searchPrivilegeModel = SearchPrivilegeModel.this;
                    if (e < searchResultBean.total) {
                        z = true;
                    }
                    searchPrivilegeModel.isProjectHasMore = z;
                }
                SearchPrivilegeModel searchPrivilegeModel2 = SearchPrivilegeModel.this;
                if (!searchPrivilegeModel2.isProjectHasMore) {
                    searchPrivilegeModel2.pageIndexBAccount = 1;
                    SearchPrivilegeModel.this.loadBAccount(z, true, str, list, onCombineListener);
                    return;
                }
                SearchPrivilegeModel.access$308(searchPrivilegeModel2);
                SearchPrivilegeModel.access$012(SearchPrivilegeModel.this, xf2.e(list));
                onCombineListener.onSuccess(new CombineBean(searchResultBean.projectInfo, null, null, str, z, true));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadPast(final boolean z, final String str, final OnCombineListener onCombineListener, final List<ProjectItemBean> list, final List<BaccountInfo> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812535426")) {
            ipChange.ipc$dispatch("-1812535426", new Object[]{this, Boolean.valueOf(z), str, onCombineListener, list, list2});
            return;
        }
        if (z) {
            this.pageIndexPastProject = 1;
        }
        SearchListRequest searchListRequest = new SearchListRequest();
        searchListRequest.keyword = str;
        searchListRequest.pageIndex = this.pageIndexPastProject;
        searchListRequest.option = "1073741824";
        searchListRequest.returnItemOption = "3";
        searchListRequest.sourceType = "";
        searchListRequest.sortType = "";
        searchListRequest.returnItemStatusOption = "3";
        searchListRequest.cityId = "";
        searchListRequest.distanceCityId = "";
        searchListRequest.request(new DMMtopRequestListener<SearchResultBean>(SearchResultBean.class) {
            /* class cn.damai.search.model.SearchPrivilegeModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "584288013")) {
                    ipChange.ipc$dispatch("584288013", new Object[]{this, str, str2});
                    return;
                }
                onCombineListener.onFail(z, str, str2);
            }

            public void onSuccess(SearchResultBean searchResultBean) {
                boolean z;
                List<ProjectItemBean> list;
                IpChange ipChange = $ipChange;
                boolean z2 = true;
                if (AndroidInstantRuntime.support(ipChange, "1364984073")) {
                    ipChange.ipc$dispatch("1364984073", new Object[]{this, searchResultBean});
                    return;
                }
                if (searchResultBean == null) {
                    list = null;
                    z = false;
                } else {
                    List<ProjectItemBean> list2 = searchResultBean.projectInfo;
                    if (SearchPrivilegeModel.this.countPastProject + xf2.e(list2) >= searchResultBean.total) {
                        z2 = false;
                    }
                    list = list2;
                    z = z2;
                }
                SearchPrivilegeModel.access$708(SearchPrivilegeModel.this);
                SearchPrivilegeModel.access$612(SearchPrivilegeModel.this, xf2.e(list));
                onCombineListener.onSuccess(new CombineBean(list, list2, list, str, z, z));
            }
        });
    }

    public void load(boolean z, String str, OnCombineListener onCombineListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-921477526")) {
            ipChange.ipc$dispatch("-921477526", new Object[]{this, Boolean.valueOf(z), str, onCombineListener});
            return;
        }
        if (z) {
            this.pageIndexProject = 1;
            this.pageIndexBAccount = -1;
            this.pageIndexPastProject = 1;
            this.countProject = 0;
            this.countBAccount = 0;
            this.countPastProject = 0;
            this.isBAccountHasMore = true;
            this.isProjectHasMore = true;
        }
        if (!this.isBAccountHasMore && !this.isProjectHasMore) {
            loadPast(false, str, onCombineListener, null, null);
        } else if (this.pageIndexBAccount > -1) {
            loadBAccount(false, false, str, null, onCombineListener);
        } else {
            loadCombine(z, str, onCombineListener);
        }
    }
}
