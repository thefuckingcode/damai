package cn.damai.seat.support.combine;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.seat.listener.RegionSeatRequestChecker;

/* compiled from: Taobao */
public interface OnSeatCombineListener {
    void onSeatCombineFinish(RegionSeatRequestChecker regionSeatRequestChecker, SeatBox seatBox);
}
