package cn.damai.seat.listener.seatui;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.SeatProfile;
import tb.h72;

/* compiled from: Taobao */
public interface OnJpgSeatUiListener extends ApiType {
    void onSelectSeatChanged();

    void showSeatUi(SeatProfile seatProfile, h72 h72, PriceLevel priceLevel, boolean z);
}
