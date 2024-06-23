package cn.damai.tetris.componentplugin;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.projectfilter.bean.FilterReqParamBean;
import cn.damai.projectfilter.listener.RequestParamProvider;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.componentplugin.bean.CategoryRequestNewParams;
import cn.damai.tetris.componentplugin.bean.LoadData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jl1;
import tb.qa;
import tb.wf;

/* compiled from: Taobao */
public class ProjectFilterModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private RequestHolder a = new RequestHolder();
    private RequestParamProvider b;
    @Nullable
    private ContainerArg c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final String h;
    private final String i;

    /* compiled from: Taobao */
    public interface OnModelBizListener {
        void onLoadProjectFail(boolean z, String str, String str2);

        void onLoadProjectSuccess(LoadData loadData);
    }

    public ProjectFilterModel(RequestParamProvider requestParamProvider, @Nullable ContainerArg containerArg, CategoryItemListInfo categoryItemListInfo) {
        int i2 = 1;
        this.d = 1;
        this.e = -1;
        this.f = 0;
        this.g = 0;
        this.b = requestParamProvider;
        this.c = containerArg;
        categoryItemListInfo = categoryItemListInfo == null ? CategoryItemListInfo.defaultItem() : categoryItemListInfo;
        k();
        this.h = categoryItemListInfo.targetLayerId;
        this.i = categoryItemListInfo.targetSectionId;
        boolean isCurrentCityEnd = categoryItemListInfo.isCurrentCityEnd(this.g);
        this.d++;
        this.g += categoryItemListInfo.currentCitySize;
        if (isCurrentCityEnd) {
            this.e = categoryItemListInfo.nearByCitySize > 0 ? 2 : i2;
        } else {
            this.e = -1;
        }
        this.f = categoryItemListInfo.nearByCitySize;
    }

    static /* synthetic */ int b(ProjectFilterModel projectFilterModel, int i2) {
        int i3 = projectFilterModel.f + i2;
        projectFilterModel.f = i3;
        return i3;
    }

    static /* synthetic */ int d(ProjectFilterModel projectFilterModel) {
        int i2 = projectFilterModel.d;
        projectFilterModel.d = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(ProjectFilterModel projectFilterModel, int i2) {
        int i3 = projectFilterModel.g + i2;
        projectFilterModel.g = i3;
        return i3;
    }

    static /* synthetic */ int h(ProjectFilterModel projectFilterModel) {
        int i2 = projectFilterModel.e;
        projectFilterModel.e = i2 + 1;
        return i2;
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491277")) {
            ipChange.ipc$dispatch("-491277", new Object[]{this});
            return;
        }
        this.d = 1;
        this.e = -1;
        this.f = 0;
        this.g = 0;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479022555")) {
            ipChange.ipc$dispatch("-479022555", new Object[]{this});
            return;
        }
        this.a.c();
    }

    public void j(final boolean z, final OnModelBizListener onModelBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305984654")) {
            ipChange.ipc$dispatch("-1305984654", new Object[]{this, Boolean.valueOf(z), onModelBizListener});
            return;
        }
        if (z) {
            k();
        }
        FilterReqParamBean obtainRequestParam = this.b.obtainRequestParam();
        final boolean z2 = this.e < 1;
        final boolean equals = TextUtils.equals("4", obtainRequestParam.sortType);
        CategoryRequestNewParams createReqParams = obtainRequestParam.createReqParams();
        if (z2) {
            createReqParams.pageIndex = this.d;
            createReqParams.cityOption = 0;
        } else {
            createReqParams.pageIndex = this.e;
            createReqParams.cityOption = 1;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(createReqParams);
        TetrisRequest.overrideParams(tetrisRequest, this.c, obtainRequestParam.skipOverrideKeyList);
        DrObj drObj = new DrObj(this.h, this.i, tetrisRequest.args);
        tetrisRequest.dr = jl1.ARRAY_START_STR + JSON.toJSONString(drObj) + jl1.ARRAY_END_STR;
        this.a.a(tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.tetris.componentplugin.ProjectFilterModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-987035957")) {
                    ipChange.ipc$dispatch("-987035957", new Object[]{this, str, str2});
                    return;
                }
                onModelBizListener.onLoadProjectFail(z, str, str2);
            }

            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                int i = 1;
                if (AndroidInstantRuntime.support(ipChange, "1781779549")) {
                    ipChange.ipc$dispatch("1781779549", new Object[]{this, baseResponse});
                } else if (baseResponse == null) {
                    onFail("", "");
                } else {
                    baseResponse.isShowJuli = equals;
                    CategoryItemListInfo a = wf.a(baseResponse);
                    baseResponse.nearByCityListSize = ProjectFilterModel.this.f;
                    ProjectFilterModel.b(ProjectFilterModel.this, a.nearByCitySize);
                    boolean isCanRequestNextPage = a.isCanRequestNextPage(z2, ProjectFilterModel.this.d);
                    if (z2) {
                        boolean isCurrentCityEnd = a.isCurrentCityEnd(ProjectFilterModel.this.g);
                        ProjectFilterModel.d(ProjectFilterModel.this);
                        ProjectFilterModel.f(ProjectFilterModel.this, a.currentCitySize);
                        if (isCurrentCityEnd) {
                            ProjectFilterModel projectFilterModel = ProjectFilterModel.this;
                            if (a.nearByCitySize > 0) {
                                i = 2;
                            }
                            projectFilterModel.e = i;
                        }
                    } else {
                        ProjectFilterModel.h(ProjectFilterModel.this);
                    }
                    onModelBizListener.onLoadProjectSuccess(new LoadData(z, isCanRequestNextPage, new qa().f(baseResponse)));
                }
            }
        }));
    }
}
