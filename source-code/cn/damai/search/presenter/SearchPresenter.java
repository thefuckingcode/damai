package cn.damai.search.presenter;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.artist.ArtistFollowResultBean;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.message.observer.Action;
import cn.damai.search.bean.PageIndexParams;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.bean.SearchFindWordList;
import cn.damai.search.bean.SearchTourUT;
import cn.damai.search.bean.SearchWord;
import cn.damai.search.bean.youku.SearchNoteBean;
import cn.damai.search.bean.youku.SearchResultBeanV2;
import cn.damai.search.bean.youku.SearchResultBeanYouKu;
import cn.damai.search.bean.youku.SearchThemeBean;
import cn.damai.search.bean.youku.SuggestRes;
import cn.damai.search.contract.SearchContract;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.model.SearchEggsRequest;
import cn.damai.search.model.SearchFindRequest;
import cn.damai.search.model.SearchListV2Request;
import cn.damai.search.model.SearchSugWordRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.f92;
import tb.h62;
import tb.p81;
import tb.xf2;
import tb.xs0;
import tb.z52;
import tb.z60;

/* compiled from: Taobao */
public class SearchPresenter extends SearchContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int BRAND_SIZE = 3;

    /* compiled from: Taobao */
    public class a implements Action<ArtistFollowResultBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(ArtistFollowResultBean artistFollowResultBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1654201956")) {
                ipChange.ipc$dispatch("1654201956", new Object[]{this, artistFollowResultBean});
            } else if (artistFollowResultBean != null) {
                SearchPresenter.this.mView.updateAccountFollowState(artistFollowResultBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<ArtistFollowResultBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(ArtistFollowResultBean artistFollowResultBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-859265405")) {
                ipChange.ipc$dispatch("-859265405", new Object[]{this, artistFollowResultBean});
            } else if (artistFollowResultBean != null) {
                SearchPresenter.this.mView.updateAccountFollowState(artistFollowResultBean);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<BaccountInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void call(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "684186160")) {
                ipChange.ipc$dispatch("684186160", new Object[]{this, baccountInfo});
                return;
            }
            SearchPresenter.this.mView.requestAccountFollow(baccountInfo);
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<BaccountInfo> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        /* renamed from: a */
        public void call(BaccountInfo baccountInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-482510159")) {
                ipChange.ipc$dispatch("-482510159", new Object[]{this, baccountInfo});
            } else if (baccountInfo != null) {
                SearchPresenter.this.mView.jumpAccountMainPage(baccountInfo);
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements Action<Integer> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        /* renamed from: a */
        public void call(Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "586103898")) {
                ipChange.ipc$dispatch("586103898", new Object[]{this, num});
            } else if (num != null) {
                SearchPresenter.this.mView.pageRefresh(num.intValue());
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements Action<SearchTourUT> {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        /* renamed from: a */
        public void call(SearchTourUT searchTourUT) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-692753679")) {
                ipChange.ipc$dispatch("-692753679", new Object[]{this, searchTourUT});
                return;
            }
            SearchPresenter.this.mView.tourCityJumpProject(searchTourUT);
        }
    }

    private String getBAccountType(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1044881711")) {
            return (String) ipChange.ipc$dispatch("-1044881711", new Object[]{this, str});
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i == 10) {
            return "3";
        }
        if (i != 11) {
            return i != 13 ? "2" : "5";
        }
        return "4";
    }

    private void hoistBrandAccountIfNeed(ArrayList<BaccountInfo> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1493327098")) {
            ipChange.ipc$dispatch("-1493327098", new Object[]{this, arrayList});
            return;
        }
        try {
            if (f92.a(arrayList) > 1) {
                int size = arrayList.size();
                int i = -1;
                int i2 = -1;
                for (int i3 = 0; i3 < size; i3++) {
                    BaccountInfo baccountInfo = arrayList.get(i3);
                    if (i2 < 0 && TextUtils.equals("4", baccountInfo.type)) {
                        i2 = i3;
                    }
                    if (i < 0 && TextUtils.equals("3", baccountInfo.type)) {
                        i = i3;
                    }
                }
                if (i >= 0 && i2 > i) {
                    arrayList.add(i, arrayList.remove(i2));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String md5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508915668")) {
            return (String) ipChange.ipc$dispatch("1508915668", new Object[]{this, str});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            if (bigInteger.length() >= 32) {
                return bigInteger;
            }
            return 0 + bigInteger;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private BaccountInfo parse2BAccountBean(SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592762223")) {
            return (BaccountInfo) ipChange.ipc$dispatch("-1592762223", new Object[]{this, listBean});
        }
        BaccountInfo baccountInfo = new BaccountInfo();
        baccountInfo.fansCount = listBean.fansCount;
        baccountInfo.performanceCount = listBean.performanceCount;
        baccountInfo.type = getBAccountType(listBean.type);
        baccountInfo.headPic = listBean.headPic;
        baccountInfo.backgroundPic = listBean.backgroundPic;
        baccountInfo.damaiId = listBean.damaiId;
        baccountInfo.name = listBean.name;
        baccountInfo.moreInfo = listBean.moreInfo;
        baccountInfo.vaccount = listBean.vaccount;
        baccountInfo.subtype = listBean.subtype;
        return baccountInfo;
    }

    private void parseArtificialImageText(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998169634")) {
            ipChange.ipc$dispatch("998169634", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean != null && !f92.d(listBean.tabArray)) {
            searchResultBeanV2.artificialImageTextList = SearchNoteBean.transfer(listBean.tabArray);
        }
    }

    private void parseArtificialInfo(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "547259416")) {
            ipChange.ipc$dispatch("547259416", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean != null && !f92.d(listBean.tabArray)) {
            searchResultBeanV2.artificialThemeList = SearchThemeBean.transfer(listBean.tabArray);
        }
    }

    private void parseBAccount(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1467447189")) {
            ipChange.ipc$dispatch("1467447189", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean != null) {
            if (searchResultBeanV2.baccountInfo == null) {
                searchResultBeanV2.baccountInfo = new ArrayList<>();
            }
            searchResultBeanV2.baccountInfo.clear();
            BaccountInfo baccountInfo = new BaccountInfo();
            baccountInfo.fansCount = listBean.fansCount;
            baccountInfo.performanceCount = listBean.performanceCount;
            baccountInfo.type = getBAccountType(listBean.type);
            baccountInfo.headPic = listBean.headPic;
            baccountInfo.backgroundPic = listBean.backgroundPic;
            baccountInfo.damaiId = listBean.damaiId;
            baccountInfo.name = listBean.name;
            baccountInfo.moreInfo = listBean.moreInfo;
            baccountInfo.vaccount = listBean.vaccount;
            baccountInfo.subtype = listBean.subtype;
            searchResultBeanV2.baccountInfo.add(baccountInfo);
        }
    }

    private void parseBrandOptimization(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530695519")) {
            ipChange.ipc$dispatch("530695519", new Object[]{this, searchResultBeanV2, list});
        } else if (xf2.e(list) >= 3) {
            if (searchResultBeanV2.brandOptimization == null) {
                searchResultBeanV2.brandOptimization = new ArrayList();
            }
            searchResultBeanV2.brandOptimization.clear();
            for (int i = 0; i < 3; i++) {
                SearchResultBeanYouKu.ListBean listBean = list.get(i);
                if (listBean != null) {
                    BrandOptimizationDO brandOptimizationDO = new BrandOptimizationDO();
                    brandOptimizationDO.type = listBean.type;
                    brandOptimizationDO.id = listBean.id;
                    brandOptimizationDO.cover = listBean.cover;
                    brandOptimizationDO.lable = listBean.label;
                    brandOptimizationDO.itemName = listBean.itemName;
                    brandOptimizationDO.tagUrl = listBean.tagUrl;
                    brandOptimizationDO.city = listBean.city;
                    searchResultBeanV2.brandOptimization.add(brandOptimizationDO);
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (r0.equals(cn.damai.search.bean.youku.SearchResultBeanYouKu.FLAG_IMAGE_TEXT) == false) goto L_0x0030;
     */
    private void parseByFlag(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        char c2 = 2;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1697264541")) {
            ipChange.ipc$dispatch("1697264541", new Object[]{this, searchResultBeanV2, listBean});
        } else if (!TextUtils.isEmpty(listBean.flag)) {
            String str = listBean.flag;
            str.hashCode();
            switch (str.hashCode()) {
                case -1826247023:
                    if (str.equals(SearchResultBeanYouKu.FLAG_SERVER_INFO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -940183705:
                    if (str.equals(SearchResultBeanYouKu.FlAG_PROJECT)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -878166744:
                    break;
                case -44167869:
                    if (str.equals(SearchResultBeanYouKu.FLAG_SUGGEST_PROJECT)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3566168:
                    if (str.equals(SearchResultBeanYouKu.FLAG_TOUR)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 153134088:
                    if (str.equals(SearchResultBeanYouKu.FLAG_ARTIFICIAL_INFO)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 452757006:
                    if (str.equals(SearchResultBeanYouKu.FLAG_ARTIFICIAL_IMAGE_TEXT)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 631034585:
                    if (str.equals(SearchResultBeanYouKu.FLAG_BACCOUNT)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1625169556:
                    if (str.equals(SearchResultBeanYouKu.FLAG_BRAND_OPTIMIZATION)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    parseServerInfo(searchResultBeanV2, listBean);
                    return;
                case 1:
                    int e2 = xf2.e(listBean.tabArray);
                    while (i < e2) {
                        parseOneProduct(searchResultBeanV2, listBean.tabArray.get(i));
                        i++;
                    }
                    return;
                case 2:
                    parseNoteList(searchResultBeanV2, listBean.tabArray);
                    return;
                case 3:
                    parseSuggestProject(searchResultBeanV2, listBean.tabArray);
                    return;
                case 4:
                    parseTour(searchResultBeanV2, listBean);
                    return;
                case 5:
                    parseArtificialInfo(searchResultBeanV2, listBean);
                    return;
                case 6:
                    parseArtificialImageText(searchResultBeanV2, listBean);
                    return;
                case 7:
                    List<SearchResultBeanYouKu.ListBean> list = listBean.tabArray;
                    if (xf2.e(list) > 0) {
                        ArrayList<BaccountInfo> arrayList = new ArrayList<>();
                        int size = list.size();
                        while (i < size) {
                            SearchResultBeanYouKu.ListBean listBean2 = list.get(i);
                            if (listBean2 != null) {
                                arrayList.add(parse2BAccountBean(listBean2));
                            }
                            i++;
                        }
                        if (arrayList.size() > 0) {
                            hoistBrandAccountIfNeed(arrayList);
                            searchResultBeanV2.baccountInfo = arrayList;
                            return;
                        }
                        return;
                    }
                    return;
                case '\b':
                    if (xf2.e(listBean.tabArray) >= 3) {
                        parseBrandOptimization(searchResultBeanV2, listBean.tabArray);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void parseNoteList(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970421813")) {
            ipChange.ipc$dispatch("-970421813", new Object[]{this, searchResultBeanV2, list});
        } else if (xf2.e(list) > 0) {
            ArrayList arrayList = new ArrayList();
            searchResultBeanV2.contentNoteList = arrayList;
            arrayList.clear();
            for (int i = 0; i < xf2.e(list); i++) {
                searchResultBeanV2.contentNoteList.add(h62.a(list.get(i), i));
            }
        }
    }

    private void parseOneProduct(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824994839")) {
            ipChange.ipc$dispatch("1824994839", new Object[]{this, searchResultBeanV2, listBean});
            return;
        }
        if (searchResultBeanV2.projectInfo == null) {
            searchResultBeanV2.projectInfo = new ArrayList();
        }
        searchResultBeanV2.projectInfo.add(h62.b(listBean));
    }

    private void parseServerInfo(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1344124975")) {
            ipChange.ipc$dispatch("1344124975", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean != null) {
            long j = listBean.currentTime;
            if (j > 0) {
                searchResultBeanV2.currentTime = j * 1000;
            }
        }
    }

    private void parseSuggestProject(SearchResultBeanV2 searchResultBeanV2, List<SearchResultBeanYouKu.ListBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "250769872")) {
            ipChange.ipc$dispatch("250769872", new Object[]{this, searchResultBeanV2, list});
        } else if (xf2.e(list) > 0) {
            searchResultBeanV2.recommendProjectList = new ArrayList();
            for (SearchResultBeanYouKu.ListBean listBean : list) {
                searchResultBeanV2.recommendProjectList.add(h62.b(listBean));
            }
        }
    }

    private void parseTour(SearchResultBeanV2 searchResultBeanV2, SearchResultBeanYouKu.ListBean listBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117340616")) {
            ipChange.ipc$dispatch("2117340616", new Object[]{this, searchResultBeanV2, listBean});
        } else if (listBean.topItem != null && xf2.e(listBean.items) != 0) {
            SearchTourBean searchTourBean = new SearchTourBean();
            searchResultBeanV2.tour = searchTourBean;
            searchTourBean.title = listBean.title;
            searchTourBean.items = listBean.items;
            searchTourBean.topItem = h62.b(listBean.topItem);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SearchResultBeanV2 transformResult(SearchResultBeanYouKu searchResultBeanYouKu, PageIndexParams.Params params) {
        SearchResultBeanYouKu.DataBean dataBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-622094967")) {
            return (SearchResultBeanV2) ipChange.ipc$dispatch("-622094967", new Object[]{this, searchResultBeanYouKu, params});
        }
        SearchResultBeanV2 searchResultBeanV2 = new SearchResultBeanV2();
        if (searchResultBeanYouKu == null || (dataBean = searchResultBeanYouKu.data) == null || xf2.e(dataBean.resultList) == 0) {
            searchResultBeanV2.total = 0;
            searchResultBeanV2.isEnd = true;
            searchResultBeanV2.isImageTextEnd = true;
        } else {
            SearchResultBeanYouKu.DataBean dataBean2 = searchResultBeanYouKu.data;
            if (params.isHomeRequest()) {
                searchResultBeanV2.total = dataBean2.total;
                searchResultBeanV2.isEnd = dataBean2.isEnded;
                searchResultBeanV2.isImageTextEnd = SearchResultBeanYouKu.isResImageTextEnded(searchResultBeanYouKu);
            } else if (params.isProjectNextPageRequest()) {
                searchResultBeanV2.total = dataBean2.total;
                searchResultBeanV2.isEnd = dataBean2.isEnded;
            } else if (params.isNoteNextPageRequest()) {
                searchResultBeanV2.isImageTextEnd = SearchResultBeanYouKu.isResImageTextEnded(searchResultBeanYouKu);
            } else {
                searchResultBeanV2.total = 0;
                searchResultBeanV2.isEnd = true;
                searchResultBeanV2.isImageTextEnd = true;
            }
            for (SearchResultBeanYouKu.ListBean listBean : searchResultBeanYouKu.data.resultList) {
                if (listBean != null) {
                    if (!params.isNoteNextPageRequest()) {
                        parseByFlag(searchResultBeanV2, listBean);
                    } else if (TextUtils.equals(SearchResultBeanYouKu.FLAG_IMAGE_TEXT, listBean.flag)) {
                        parseNoteList(searchResultBeanV2, listBean.tabArray);
                    }
                }
            }
        }
        return searchResultBeanV2;
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchEggs(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273629186")) {
            ipChange.ipc$dispatch("-1273629186", new Object[]{this, str});
            return;
        }
        SearchEggsRequest searchEggsRequest = new SearchEggsRequest();
        searchEggsRequest.keyword = str;
        searchEggsRequest.request(new DMMtopRequestListener<SearchEggs>(SearchEggs.class) {
            /* class cn.damai.search.presenter.SearchPresenter.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1528093686")) {
                    ipChange.ipc$dispatch("1528093686", new Object[]{this, str, str2});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                SearchPresenter.this.mView.error(str, str2, "mtop.damai.wireless.search.searchegg.get", str, 2);
            }

            public void onSuccess(SearchEggs searchEggs) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-326106127")) {
                    ipChange.ipc$dispatch("-326106127", new Object[]{this, searchEggs});
                    return;
                }
                SearchPresenter.this.mView.returnSearchEggs(searchEggs, str);
            }
        });
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchFindList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306201813")) {
            ipChange.ipc$dispatch("-1306201813", new Object[]{this});
            return;
        }
        new SearchFindRequest().request(new DMMtopRequestListener<SearchFindWordList>(SearchFindWordList.class) {
            /* class cn.damai.search.presenter.SearchPresenter.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1543612404")) {
                    ipChange.ipc$dispatch("1543612404", new Object[]{this, str, str2});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                SearchPresenter.this.mView.error(str, str2, "mtop.damai.wireless.search.hotword.get", "", 0);
            }

            public void onSuccess(SearchFindWordList searchFindWordList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-243290244")) {
                    ipChange.ipc$dispatch("-243290244", new Object[]{this, searchFindWordList});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                SearchPresenter.this.mView.returnSearchFindList(searchFindWordList);
            }
        });
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchListV2(final String str, final PageIndexParams.Params params) {
        String str2;
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063722661")) {
            ipChange.ipc$dispatch("-2063722661", new Object[]{this, str, params});
            return;
        }
        SearchListV2Request searchListV2Request = new SearchListV2Request();
        searchListV2Request.keyword = str;
        int i = params.pageIndex;
        searchListV2Request.pg = i;
        String str4 = null;
        if (i == 1) {
            str4 = z60.c(xs0.a()).d();
            String md5 = md5(System.currentTimeMillis() + str4);
            if (md5 != null) {
                str4 = md5;
            }
        }
        searchListV2Request.categories = params.categories;
        searchListV2Request.aaid = str4;
        double[] b2 = p81.b();
        if (b2 == null || b2.length <= 1) {
            str2 = "116.43672127748412";
            str3 = "39.93700227507351";
        } else {
            str2 = String.valueOf(b2[0]);
            str3 = String.valueOf(b2[1]);
        }
        searchListV2Request.longitude = str2;
        searchListV2Request.latitude = str3;
        searchListV2Request.request(new DMMtopRequestListener<SearchResultBeanYouKu>(SearchResultBeanYouKu.class) {
            /* class cn.damai.search.presenter.SearchPresenter.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-902514110")) {
                    ipChange.ipc$dispatch("-902514110", new Object[]{this, str, str2});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                if (params.isHomeRequest()) {
                    SearchPresenter.this.mView.error(str, str2, z52.a, str, 1);
                } else {
                    ToastUtil.a().j(xs0.a(), str2);
                }
            }

            public void onSuccess(SearchResultBeanYouKu searchResultBeanYouKu) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "184455023")) {
                    ipChange.ipc$dispatch("184455023", new Object[]{this, searchResultBeanYouKu});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                SearchPresenter.this.mView.returnSearchListV2(SearchPresenter.this.transformResult(searchResultBeanYouKu, params), str, params);
            }
        });
    }

    @Override // cn.damai.search.contract.SearchContract.Presenter
    public void getSearchSuggest(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229509746")) {
            ipChange.ipc$dispatch("-229509746", new Object[]{this, str});
            return;
        }
        new SearchSugWordRequest(str).request(new DMMtopRequestListener<SuggestRes>(SuggestRes.class) {
            /* class cn.damai.search.presenter.SearchPresenter.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1535853045")) {
                    ipChange.ipc$dispatch("1535853045", new Object[]{this, str, str2});
                    return;
                }
                SearchPresenter.this.mView.stopLoading();
                SearchPresenter.this.mView.error(str, str2, "mtop.damai.wireless.search.suggest", str, 3);
            }

            public void onSuccess(SuggestRes suggestRes) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "392852548")) {
                    ipChange.ipc$dispatch("392852548", new Object[]{this, suggestRes});
                    return;
                }
                SearchPresenter.this.mView.returnSearchSuggest(SearchWord.youKuSuggestToNative(suggestRes), str);
                SearchPresenter.this.mView.stopLoading();
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218643229")) {
            ipChange.ipc$dispatch("218643229", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(SearchHelper.ACCOUNT_MORE_SEARCH_ATTENTION, new a());
        this.mDMMessage.b("artist_follow_status", new b());
        this.mDMMessage.b(SearchHelper.ATTENTION_SEARCH_ACCOUNT, new c());
        this.mDMMessage.b(SearchHelper.JUMP_ACCOUNT_MAIN_PAGE, new d());
        this.mDMMessage.b(z52.NOTIFY_RFRESH, new e());
        this.mDMMessage.b(SearchHelper.TOUR_JUMP_PROJECT_PAGE, new f());
    }
}
