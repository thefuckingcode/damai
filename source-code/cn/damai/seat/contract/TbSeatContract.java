package cn.damai.seat.contract;

import android.graphics.Picture;
import android.os.Bundle;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.listener.Action;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.SimpleCallBack;
import cn.damai.seat.listener.seatui.OnSeatUiListener;
import cn.damai.seat.presenter.BaseSeatPresenter;
import java.util.List;
import tb.h72;
import tb.t72;

/* compiled from: Taobao */
public interface TbSeatContract {

    /* compiled from: Taobao */
    public static abstract class Presenter extends BaseSeatPresenter<TbSeatView, TbSeatModel> {
        public abstract boolean hasVRImage();

        public abstract void load(boolean z);

        public abstract void onConfirmClick();

        public abstract void onPriceClick(PriceLevel priceLevel, int i);

        public abstract void onPromotionClick();

        public abstract void onSeatChanged(SeatNew seatNew, boolean z);

        public abstract void onVRInfoClick();

        public abstract void refresh();

        public abstract void start(TbParams tbParams);
    }

    /* compiled from: Taobao */
    public interface TbSeatModel extends BaseSeatModel {
        boolean changePrice(PriceLevel priceLevel, int i);

        boolean changeSeat(SeatNew seatNew, boolean z, Action action);

        void computeSeat(SeatComputeListener seatComputeListener);

        SeatNew getLastedSelectSeat();

        TbParams getParams();

        Picture getPriceFilterPic();

        List<? extends PriceLevel> getPriceList();

        PriceLevel getSelectPrice();

        t72 getViewData();

        boolean isLoadFinish();

        void load(boolean z, OnSeatUiListener onSeatUiListener);

        void load3DVrImageData(SeatNew seatNew);

        void prepare(@NonNull TbParams tbParams, SimpleCallBack<RegionData> simpleCallBack);

        PromotionDataBean promotion();

        void refresh(OnSeatUiListener onSeatUiListener);

        void removeAllSeat();

        boolean shouldShowDiffRowTip();

        void submitSeat(OnSubmitListener onSubmitListener);

        void update3DVrData(SeatBox seatBox);
    }

    /* compiled from: Taobao */
    public interface TbSeatView extends BaseSeatView {
        void dismissVRInfo();

        void invalidateSeatView();

        void onOpenPurchaseActivity(Bundle bundle);

        void openOrderDetailActivity(String str);

        void showBottomBar(PriceBarInfo priceBarInfo);

        void showDiffRowView(boolean z);

        void showLoadingLayer(boolean z);

        void showPriceChanged(PriceLevel priceLevel, Picture picture);

        void showSeatUiList(h72 h72, List<ItemSeatV2> list);

        void showSeatView(t72 t72, PriceLevel priceLevel, Picture picture, boolean z);

        void showTipDialog(String str);

        void updatePromotionTags(List<ShortTag> list, boolean z);

        void updateSeatListV2Panel(List<TicketMainUiModel> list);

        void updateVRInfo(SeatNew seatNew);
    }
}
