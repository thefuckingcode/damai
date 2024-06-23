package cn.damai.tetris.componentplugin;

import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.component.drama.bean.CategoryQuery;
import cn.damai.tetris.componentplugin.bean.CategoryRequestNewParams;
import cn.damai.tetris.componentplugin.bean.LoadData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.jl1;
import tb.qa;
import tb.wf;

@Deprecated
/* compiled from: Taobao */
public class FilterPanelModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private RequestHolder a = new RequestHolder();
    private CategoryQuery b = CategoryQuery.defaultQuery();
    private int c = 1;
    private int d = -1;
    private int e = 0;
    private int f = 0;
    private String g;
    private String h;
    @NonNull
    private ContainerArg i;

    public FilterPanelModel(ContainerArg containerArg) {
        this.i = containerArg == null ? ContainerArg.defaultDramaChannelArg() : containerArg;
    }

    static /* synthetic */ int b(FilterPanelModel filterPanelModel, int i2) {
        int i3 = filterPanelModel.e + i2;
        filterPanelModel.e = i3;
        return i3;
    }

    static /* synthetic */ int d(FilterPanelModel filterPanelModel) {
        int i2 = filterPanelModel.c;
        filterPanelModel.c = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(FilterPanelModel filterPanelModel, int i2) {
        int i3 = filterPanelModel.f + i2;
        filterPanelModel.f = i3;
        return i3;
    }

    static /* synthetic */ int h(FilterPanelModel filterPanelModel) {
        int i2 = filterPanelModel.d;
        filterPanelModel.d = i2 + 1;
        return i2;
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509863256")) {
            ipChange.ipc$dispatch("509863256", new Object[]{this});
            return;
        }
        this.c = 1;
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1237707722")) {
            ipChange.ipc$dispatch("1237707722", new Object[]{this});
            return;
        }
        this.a.c();
    }

    public void j(final boolean z, final OnBizListener<LoadData> onBizListener) {
        CategoryRequestNewParams categoryRequestNewParams;
        IpChange ipChange = $ipChange;
        final boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1973920219")) {
            ipChange.ipc$dispatch("-1973920219", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        if (z) {
            k();
        }
        int i2 = this.d;
        final boolean z3 = i2 < 1;
        CategoryQuery categoryQuery = this.b;
        int i3 = categoryQuery.sortType;
        if (i3 == 4) {
            z2 = true;
        }
        if (z3) {
            categoryRequestNewParams = new CategoryRequestNewParams(0, categoryQuery.dateType, categoryQuery.startDate, categoryQuery.endDate, i3, categoryQuery.groupId, this.c);
        } else {
            categoryRequestNewParams = new CategoryRequestNewParams(1, categoryQuery.dateType, categoryQuery.startDate, categoryQuery.endDate, 4, categoryQuery.groupId, i2);
        }
        TetrisRequest tetrisRequest = new TetrisRequest(categoryRequestNewParams);
        ArrayList arrayList = new ArrayList();
        if (categoryRequestNewParams.groupId != null) {
            arrayList.add("groupId");
        }
        TetrisRequest.overrideParams(tetrisRequest, this.i, arrayList);
        DrObj drObj = new DrObj(this.g, this.h, tetrisRequest.args);
        tetrisRequest.dr = jl1.ARRAY_START_STR + JSON.toJSONString(drObj) + jl1.ARRAY_END_STR;
        this.a.a(tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.tetris.componentplugin.FilterPanelModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1147563120")) {
                    ipChange.ipc$dispatch("1147563120", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onFail(str, str2);
            }

            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "762229528")) {
                    ipChange.ipc$dispatch("762229528", new Object[]{this, baseResponse});
                } else if (baseResponse == null) {
                    onFail("", "");
                } else {
                    baseResponse.isShowJuli = z2;
                    CategoryItemListInfo a = wf.a(baseResponse);
                    baseResponse.nearByCityListSize = FilterPanelModel.this.e;
                    FilterPanelModel.b(FilterPanelModel.this, a.nearByCitySize);
                    boolean isCanRequestNextPage = a.isCanRequestNextPage(z3, FilterPanelModel.this.c);
                    if (z3) {
                        boolean isCurrentCityEnd = a.isCurrentCityEnd(FilterPanelModel.this.f);
                        FilterPanelModel.d(FilterPanelModel.this);
                        FilterPanelModel.f(FilterPanelModel.this, a.currentCitySize);
                        if (isCurrentCityEnd) {
                            FilterPanelModel.this.d = 1;
                        }
                    } else {
                        FilterPanelModel.h(FilterPanelModel.this);
                    }
                    onBizListener.onSuccess(new LoadData(z, isCanRequestNextPage, new qa().f(baseResponse)));
                }
            }
        }));
    }

    public void l(CategoryItemListInfo categoryItemListInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271597631")) {
            ipChange.ipc$dispatch("1271597631", new Object[]{this, categoryItemListInfo});
            return;
        }
        k();
        if (categoryItemListInfo == null) {
            categoryItemListInfo = CategoryItemListInfo.defaultItem();
        }
        this.g = categoryItemListInfo.targetLayerId;
        this.h = categoryItemListInfo.targetSectionId;
        boolean isCurrentCityEnd = categoryItemListInfo.isCurrentCityEnd(this.f);
        this.c++;
        this.f += categoryItemListInfo.currentCitySize;
        if (isCurrentCityEnd) {
            this.d = 1;
        } else {
            this.d = -1;
        }
        this.e = categoryItemListInfo.nearByCitySize;
    }

    public void m(CategoryQuery categoryQuery) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1607470891")) {
            ipChange.ipc$dispatch("-1607470891", new Object[]{this, categoryQuery});
            return;
        }
        if (categoryQuery == null) {
            categoryQuery = CategoryQuery.defaultQuery();
        }
        this.b = categoryQuery;
    }
}
