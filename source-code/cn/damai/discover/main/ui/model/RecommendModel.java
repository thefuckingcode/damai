package cn.damai.discover.main.ui.model;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.home.bean.HomeContentFloatBean;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.model.AbsModel;
import cn.damai.discover.main.bean.ReadBean;
import cn.damai.discover.main.bean.ReadContent;
import cn.damai.discover.main.request.BoxReadClearRequest;
import cn.damai.discover.main.request.BoxReadRequest;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DiscoverRecParams;
import cn.damai.tetris.request.TetrisRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.d20;
import tb.dr;
import tb.f81;
import tb.g91;
import tb.hp1;
import tb.lp1;
import tb.qa;
import tb.s41;

/* compiled from: Taobao */
public class RecommendModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private HomeContentFloatBean.Data mHighLightCard;
    private int pageNo = 1;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void alarm(TetrisRequest tetrisRequest, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-994748967")) {
            ipChange.ipc$dispatch("-994748967", new Object[]{this, tetrisRequest, str, str2});
        } else if (tetrisRequest != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.i());
            hashMap.put("city", d20.d());
            hashMap.put("args", tetrisRequest.args);
            dr.INSTANCE.a().a(tetrisRequest.getApiName()).c(str).d(str2).e(hashMap).h(tetrisRequest.patternName).i(tetrisRequest.patternVersion).g("现场主页推荐").j("live").f(false).b();
        }
    }

    public void clearRead(ReadContent readContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262704483")) {
            ipChange.ipc$dispatch("1262704483", new Object[]{this, readContent});
        } else if (readContent != null) {
            new BoxReadClearRequest(readContent.id).request(new DMMtopRequestListener<Object>(Object.class) {
                /* class cn.damai.discover.main.ui.model.RecommendModel.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1662344769")) {
                        ipChange.ipc$dispatch("-1662344769", new Object[]{this, str, str2});
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "205925850")) {
                        ipChange.ipc$dispatch("205925850", new Object[]{this, obj});
                    }
                }
            });
        }
    }

    public void load(final boolean z, final OnBizListener<PageData<BaseResponse>> onBizListener) {
        String str;
        HomeContentFloatBean.Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693480344")) {
            ipChange.ipc$dispatch("-1693480344", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        String str2 = null;
        if (!z || (data = this.mHighLightCard) == null) {
            str = null;
        } else {
            str2 = data.type;
            str = data.id;
        }
        AnonymousClass1 r2 = new DiscoverRecParams(this.pageNo + "", str2, str) {
            /* class cn.damai.discover.main.ui.model.RecommendModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.request.DiscoverRecParams, cn.damai.tetris.request.TetrisParams
            public String getVersion() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "10457469")) {
                    return "2.1";
                }
                return (String) ipChange.ipc$dispatch("10457469", new Object[]{this});
            }
        };
        if (hp1.i(lp1.LOCATION)) {
            r2.latitude = d20.n() + "";
            r2.longitude = d20.o() + "";
        }
        final TetrisRequest tetrisRequest = new TetrisRequest(r2);
        this.mHolder.a(tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) {
            /* class cn.damai.discover.main.ui.model.RecommendModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1646826051")) {
                    ipChange.ipc$dispatch("-1646826051", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
                if (z) {
                    RecommendModel.this.alarm(tetrisRequest, str, str2);
                }
            }

            public void onSuccess(BaseResponse baseResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1564143317")) {
                    ipChange.ipc$dispatch("-1564143317", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    RecommendModel.this.mHighLightCard = null;
                }
                if (baseResponse != null) {
                    qa.d(baseResponse, f81.q());
                    onBizListener.onBizSuccess(PageData.success(z, qa.k(baseResponse), baseResponse));
                    return;
                }
                onFail("", "");
            }
        }));
    }

    public void loadRead(final OnBizListener<ReadContent> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815437746")) {
            ipChange.ipc$dispatch("-815437746", new Object[]{this, onBizListener});
            return;
        }
        this.mHolder.a(new BoxReadRequest().request(new DMMtopRequestListener<ReadBean>(ReadBean.class) {
            /* class cn.damai.discover.main.ui.model.RecommendModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1654585410")) {
                    ipChange.ipc$dispatch("-1654585410", new Object[]{this, str, str2});
                    return;
                }
                g91.c("RecModel", "code=" + str + " msg=" + str2);
            }

            public void onSuccess(ReadBean readBean) {
                ReadContent firstReadCount;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "341768692")) {
                    ipChange.ipc$dispatch("341768692", new Object[]{this, readBean});
                } else if (readBean != null && readBean.success() && readBean.isNoteRecommendValid() && (firstReadCount = readBean.getFirstReadCount()) != null) {
                    onBizListener.onBizSuccess(firstReadCount);
                }
            }
        }));
    }

    public void setHighLightCard(String str) {
        HomeContentFloatBean.Data data;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "729921760")) {
            ipChange.ipc$dispatch("729921760", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && (data = (HomeContentFloatBean.Data) s41.a(str, HomeContentFloatBean.Data.class)) != null && data.isValid()) {
            this.mHighLightCard = data;
        }
    }
}
