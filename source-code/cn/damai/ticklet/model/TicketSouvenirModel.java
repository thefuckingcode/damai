package cn.damai.ticklet.model;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TicketSouvenirDetail;
import cn.damai.ticklet.bean.TicketSouvenirInfo;
import cn.damai.ticklet.bean.TicketSouvenirPaperBean;
import cn.damai.ticklet.bean.TicketSouvenirParams;
import cn.damai.ticklet.bean.UserPerformSouvenirVO;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.SimpleCallBack;
import cn.damai.ticklet.net.TickletSouvenirRequest;
import cn.damai.ticklet.utils.Utils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.al2;

/* compiled from: Taobao */
public class TicketSouvenirModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TicketSouvenirParams mParams;
    private TicketSouvenirDetail mSouvenirDetail;

    public TicketSouvenirModel(TicketSouvenirParams ticketSouvenirParams) {
        this.mParams = ticketSouvenirParams;
    }

    public TicketSouvenirParams getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "239358923")) {
            return this.mParams;
        }
        return (TicketSouvenirParams) ipChange.ipc$dispatch("239358923", new Object[]{this});
    }

    public boolean isNormalState() {
        TicketSouvenirInfo ticketSouvenirInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737120253")) {
            return ((Boolean) ipChange.ipc$dispatch("737120253", new Object[]{this})).booleanValue();
        }
        TicketSouvenirDetail ticketSouvenirDetail = this.mSouvenirDetail;
        return (ticketSouvenirDetail == null || (ticketSouvenirInfo = ticketSouvenirDetail.souvenirVO) == null || !ticketSouvenirInfo.isNormalState()) ? false : true;
    }

    public void loadSouvenirDetail(final SimpleCallBack<TicketSouvenirPaperBean> simpleCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033698259")) {
            ipChange.ipc$dispatch("1033698259", new Object[]{this, simpleCallBack});
            return;
        }
        TicketSouvenirParams ticketSouvenirParams = this.mParams;
        new TickletSouvenirRequest(ticketSouvenirParams.performId, ticketSouvenirParams.productSystemId).request(new DMMtopRequestListener<TicketSouvenirPaperBean>(TicketSouvenirPaperBean.class) {
            /* class cn.damai.ticklet.model.TicketSouvenirModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2058470389")) {
                    ipChange.ipc$dispatch("2058470389", new Object[]{this, str, str2});
                    return;
                }
                simpleCallBack.onFail(str, str2);
            }

            public void onSuccess(TicketSouvenirPaperBean ticketSouvenirPaperBean) {
                TicketSouvenirDetail ticketSouvenirDetail;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2096075947")) {
                    ipChange.ipc$dispatch("2096075947", new Object[]{this, ticketSouvenirPaperBean});
                } else if (ticketSouvenirPaperBean != null && (ticketSouvenirDetail = ticketSouvenirPaperBean.result) != null) {
                    UserPerformSouvenirVO userPerformSouvenirVO = ticketSouvenirDetail.userPerformSouvenirVO;
                    if (userPerformSouvenirVO != null && !Utils.b(userPerformSouvenirVO.userTicketVOList)) {
                        for (UserTicketTable userTicketTable : ticketSouvenirPaperBean.result.userPerformSouvenirVO.userTicketVOList) {
                            al2.b(userTicketTable);
                        }
                    }
                    TicketSouvenirModel.this.mSouvenirDetail = ticketSouvenirPaperBean.result;
                    simpleCallBack.onSuccess(ticketSouvenirPaperBean);
                }
            }
        });
    }

    @Nullable
    public TicketDeatilResult transferDetailResult4Layer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "842923415")) {
            return (TicketDeatilResult) ipChange.ipc$dispatch("842923415", new Object[]{this});
        }
        if (isNormalState()) {
            UserPerformSouvenirVO userPerformSouvenirVO = this.mSouvenirDetail.userPerformSouvenirVO;
            if (!Utils.b(userPerformSouvenirVO != null ? userPerformSouvenirVO.userTicketVOList : null)) {
                return this.mSouvenirDetail.makeDetailResult4SouvenirPopLayer();
            }
        }
        return null;
    }
}
