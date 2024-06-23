package cn.damai.seat.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.commonbusiness.seatbiz.utils.Cancelable;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.h72;

/* compiled from: Taobao */
public interface BaseSeatModel extends BaseModel {
    void addBusiness(MtopBusiness mtopBusiness);

    void addCancelable(Cancelable cancelable);

    h72 getIconProvider();

    void onDestroy();
}
