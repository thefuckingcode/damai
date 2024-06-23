package cn.damai.commonbusiness.seatbiz.sku.qilin.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import cn.damai.common.app.base.BaseFragment;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$anim;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.PermissionsHelper;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.notice.NoticeDetailFragment;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.seatbiz.common.bean.CreateOrderExParams;
import cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment;
import cn.damai.commonbusiness.seatbiz.promotion.bean.PromotionDataBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcRes;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketSubUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopCalcTicketPriceRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.ActionControlBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BusinessInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.CalculatePriceControlBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DateBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DialogBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformSummaryBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.RenderingControlBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.SkuSaveInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.TradeInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.model.SkuModel;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.DengjiRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuItem;
import cn.damai.commonbusiness.seatbiz.sku.qilin.request.SkuRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuPriceDetailFragment;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.NcovSkuSimpleDateView;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.VerticalNestedScrollView;
import cn.damai.commonbusiness.seatbiz.sku.xflush.ProjectDetailXFlushUtil;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.live.LiveActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMThemeDialog;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.annotation.JSMethod;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import tb.d20;
import tb.dh1;
import tb.dr;
import tb.eh1;
import tb.f92;
import tb.gh1;
import tb.gr;
import tb.h91;
import tb.hp1;
import tb.ih1;
import tb.ik1;
import tb.jl1;
import tb.lp1;
import tb.mi1;
import tb.n42;
import tb.ne2;
import tb.ni1;
import tb.oz0;
import tb.s71;
import tb.se;
import tb.ta;
import tb.ub2;
import tb.wb2;
import tb.wj1;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class NcovSkuFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int GO_BY_TYPE = 1;
    public static final int GO_SEAT_TYPE = 2;
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_PRIVILEGE_ID = "sku_privilege_id";
    public static final String KEY_SKU_BEAN = "sku_bean";
    public static final int PAGE_TYPE_BUY = 1;
    public static final int PAGE_TYPE_SEE = 2;
    private List<View> exposureViewList = new ArrayList();
    private ActionControlBean mActionControlBean;
    private AppBarLayout mAppBar;
    private String mAtomSplit;
    private DMIconFontTextView mBackBtn;
    private BasicInfoBean mBasicInfoBean;
    private String mDataId;
    private String mDataType;
    private String mDateDataId = null;
    private TextView mDateTipTv;
    private View mDateTitleLayout;
    private DengjiRequest mDengjiRequest = new DengjiRequest();
    private TextView mDescTv;
    private DialogBean mDialogBean;
    private View mDicountContainer;
    private LinearLayout mErrorView;
    private View mHeader;
    private View mHeaderImg;
    private boolean mIsFirstHideDate = true;
    private boolean mIsLoadCache = false;
    private boolean mIsProjectDetailSkuBean = false;
    private boolean mIsSeeRequestDengji = false;
    private boolean mIsShowDate = false;
    private boolean mIsShowDateView = true;
    private boolean mIsShowYK;
    private BusinessInfo mItemAdditionalInfo;
    private long mItemId;
    private SkuModel mModel;
    private NcovPromotionFragment mNcovPromotionFragment;
    private NcovSkuPriceDetailFragment mNcovSkuPriceDetailFragment;
    private mi1 mNewSkuData;
    private long mPageOpenTs;
    private SeatPreloadExtra mPreloadExtra;
    private View mPriceDetailContainer;
    private String mPrivilegeId;
    private ImageView mProjcetImage;
    private PromotionBean mPromotionBean;
    private View mRegesiterLayout;
    private TextView mRegisterTipTv;
    private long mRemindCountDown;
    private long mRemindSaleTime;
    private String mRemindTitle;
    private boolean mRequestFirst = true;
    private VerticalNestedScrollView mScrollView;
    private int mScrollY = 0;
    private SeatPrepare mSeatDoor;
    private DateBean mSelectedDate;
    private PerformBean mSelectedPerform;
    private PriceBean mSelectedPrice;
    private SkuBean mSkuBean;
    private dh1 mSkuBottomView;
    private eh1 mSkuDateView;
    private LinearLayout mSkuPerformLayout;
    private gh1 mSkuPerformView;
    private ih1 mSkuPriceView;
    private SkuRequest mSkuRequest = new SkuRequest();
    private NcovSkuSimpleDateView mSkuSimpleDateView;
    private View mSkuView;
    private View mStartBgView;
    private View mStatusBarSpace;
    private TicketCalcBean mTicketCalcBean;
    private View mTitleBgLayout;
    private TextView mTitleTv;
    private View mTopLayout;
    private View mTopNormalLayout;
    private View mTopSeeLayout;
    private TextView mTopTitleTv;
    private TradeInfo mTradeInfo;
    ResponseErrorPage page;
    public NcovSkuBottomInfo skuBottomInfo = new NcovSkuBottomInfo();

    /* compiled from: Taobao */
    public interface OnPerformChangedListener {
        void onClose();

        void performChanged(int i, BasicInfoBean basicInfoBean, PerformBean performBean, PriceBean priceBean, PromotionBean promotionBean, TradeInfo tradeInfo);
    }

    /* compiled from: Taobao */
    public class a extends dh1 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(View view, View view2, NcovSkuBottomInfo ncovSkuBottomInfo) {
            super(view, view2, ncovSkuBottomInfo);
        }

        @Override // tb.dh1
        public void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-660404620")) {
                ipChange.ipc$dispatch("-660404620", new Object[]{this});
                return;
            }
            NcovSkuFragment.this.goBottomBtn();
        }

        @Override // tb.dh1
        public void e(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-334122345")) {
                ipChange.ipc$dispatch("-334122345", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            NcovSkuFragment.this.recordSkuInfo(z);
        }

        @Override // tb.dh1
        public void g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2104621717")) {
                ipChange.ipc$dispatch("2104621717", new Object[]{this});
            } else if (NcovSkuFragment.this.mPriceDetailContainer.getVisibility() == 0) {
                NcovSkuFragment.this.dismissPriceDetailFragment();
            } else {
                NcovSkuFragment.this.showPriceDetailFragment();
                if (NcovSkuFragment.this.mSelectedPerform != null) {
                    cn.damai.common.user.c.e().x(wb2.i().k(NcovSkuFragment.this.mItemId, NcovSkuFragment.this.mSelectedPerform.performId));
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(NcovSkuFragment ncovSkuFragment) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1886181631")) {
                ipChange.ipc$dispatch("1886181631", new Object[]{this, dVar});
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "992393377")) {
                    ipChange.ipc$dispatch("992393377", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                if (NcovSkuFragment.this.mNewSkuData != null) {
                    NcovSkuFragment.this.mNewSkuData.a = i;
                }
                NcovSkuFragment.this.mHeaderImg.setBackgroundColor(NcovSkuFragment.this.mNewSkuData.a);
            }
        }

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1927532372")) {
                ipChange.ipc$dispatch("1927532372", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                DMRGBUtil.g(1.0f, bitmap, NcovSkuFragment.this.mBasicInfoBean.mainImageUrl, new a());
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "246832960")) {
                ipChange.ipc$dispatch("246832960", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            cn.damai.common.user.c.e().x(wb2.i().t(NcovSkuFragment.this.mItemId));
        }
    }

    /* compiled from: Taobao */
    public class e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1139391267")) {
                ipChange.ipc$dispatch("-1139391267", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (NcovSkuFragment.this.mIsSeeRequestDengji) {
                if (NcovSkuFragment.this.mSkuPriceView != null) {
                    NcovSkuFragment.this.mSkuPriceView.s(NcovSkuFragment.this.mSelectedPrice);
                }
                NcovSkuFragment.this.mIsSeeRequestDengji = false;
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1283445241")) {
                ipChange.ipc$dispatch("-1283445241", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (!NcovSkuFragment.this.mActivity.isFinishing() && NcovSkuFragment.this.isAdded()) {
                try {
                    d20.T("trade_push_permission_preference", "trade_push_dialog_show");
                    cn.damai.common.user.c.e().A(ta.g().i("pdt_dtl", "1"), "selectsuggestmessage", "message");
                    Intent a2 = wj1.a(NcovSkuFragment.this.mActivity);
                    if (wj1.c(a2)) {
                        NcovSkuFragment.this.startActivity(a2);
                    } else {
                        ToastUtil.a().j(xs0.a(), "请前往应用权限管理，为大麦开启通知权限~");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.a().j(xs0.a(), "请前往应用权限管理，为大麦开启通知权限~");
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1625297828")) {
                ipChange.ipc$dispatch("1625297828", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (NcovSkuFragment.this.mSkuPriceView != null) {
                NcovSkuFragment.this.mSkuPriceView.s(NcovSkuFragment.this.mSelectedPrice);
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements SeatPrepare.OnSeatPrepareListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare.OnSeatPrepareListener
        public void onSeatPageOpened() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1839963649")) {
                ipChange.ipc$dispatch("-1839963649", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare.OnSeatPrepareListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1549262980")) {
                ipChange.ipc$dispatch("1549262980", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                NcovSkuFragment.this.startProgressDialog();
            } else {
                NcovSkuFragment.this.stopProgressDialog();
            }
        }
    }

    /* compiled from: Taobao */
    public class i implements NcovPromotionFragment.OnConfirmClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.promotion.NcovPromotionFragment.OnConfirmClickListener
        public void onCloseClick() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1780814765")) {
                ipChange.ipc$dispatch("1780814765", new Object[]{this});
                return;
            }
            NcovSkuFragment.this.dismissPromotionFragment();
        }
    }

    /* compiled from: Taobao */
    public class j implements NcovSkuPriceDetailFragment.OnPriceDetailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuPriceDetailFragment.OnPriceDetailListener
        public void onClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1340236819")) {
                ipChange.ipc$dispatch("1340236819", new Object[]{this});
                return;
            }
            NcovSkuFragment.this.dismissPriceDetailFragment();
        }
    }

    /* compiled from: Taobao */
    public class k implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-244245884")) {
                ipChange.ipc$dispatch("-244245884", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            NcovSkuFragment.this.mDataId = null;
            NcovSkuFragment.this.mDataType = null;
            NcovSkuFragment.this.requestSku();
        }
    }

    /* compiled from: Taobao */
    public class l implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1347046787")) {
                ipChange.ipc$dispatch("-1347046787", new Object[]{this, view});
                return;
            }
            NcovSkuFragment.this.mActivity.finish();
        }
    }

    /* compiled from: Taobao */
    public class m implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
        @SuppressLint({"NewApi"})
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "1639195958")) {
                ipChange.ipc$dispatch("1639195958", new Object[]{this, appBarLayout, Integer.valueOf(i)});
                return;
            }
            float abs = ((float) Math.abs(i)) / ((float) NcovSkuFragment.this.mTopLayout.getHeight());
            if (abs > 0.5f) {
                ne2.f(NcovSkuFragment.this.mActivity, true, R$color.black);
                ne2.d(true, NcovSkuFragment.this.mActivity);
                NcovSkuFragment.this.mBackBtn.setTextColor(-16777216);
            } else {
                ne2.e(NcovSkuFragment.this.mActivity);
                NcovSkuFragment.this.mBackBtn.setTextColor(-1);
            }
            if (abs > 1.0f) {
                abs = 1.0f;
            }
            NcovSkuFragment.this.mTitleBgLayout.setAlpha(abs);
            NcovSkuFragment.this.mStatusBarSpace.setAlpha(abs);
            NcovSkuFragment ncovSkuFragment = NcovSkuFragment.this;
            if (ncovSkuFragment.skuBottomInfo.pageType == 1) {
                ncovSkuFragment.mTitleTv.setAlpha(abs);
            } else {
                ncovSkuFragment.mTitleTv.setAlpha(1.0f);
                NcovSkuFragment.this.mTitleTv.setTextColor(NcovSkuFragment.this.mActivity.getResources().getColor(R$color.white));
            }
            NcovSkuFragment.this.mHeader.scrollTo(0, -i);
            if (NcovSkuFragment.this.mTopLayout.getHeight() != Math.abs(i)) {
                z = false;
            }
            if (z) {
                NcovSkuFragment.this.mTitleTv.setTextColor(NcovSkuFragment.this.mActivity.getResources().getColor(R$color.color_000000));
            }
            if (z && NcovSkuFragment.this.mIsShowDate) {
                NcovSkuFragment.this.mSkuSimpleDateView.l(0);
                NcovSkuFragment.this.mSkuDateView.i(8);
                NcovSkuFragment.this.mIsShowDateView = false;
            }
        }
    }

    /* compiled from: Taobao */
    public class n implements VerticalNestedScrollView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.commonbusiness.seatbiz.sku.qilin.widget.VerticalNestedScrollView.OnScrollListener
        public void onScroll(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "592758112")) {
                ipChange.ipc$dispatch("592758112", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            NcovSkuFragment.this.mScrollY = i;
        }
    }

    /* compiled from: Taobao */
    public class o extends eh1 {
        private static transient /* synthetic */ IpChange $ipChange;

        o(View view, long j) {
            super(view, j);
        }

        @Override // tb.eh1
        public void h(DateBean dateBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-288784297")) {
                ipChange.ipc$dispatch("-288784297", new Object[]{this, dateBean});
                return;
            }
            NcovSkuFragment.this.mSelectedPerform = null;
            NcovSkuFragment.this.mDataId = dateBean.dateId;
            NcovSkuFragment.this.mDateDataId = dateBean.dateId;
            NcovSkuFragment.this.mDataType = "4";
            NcovSkuFragment.this.mIsShowDateView = false;
            NcovSkuFragment.this.mIsLoadCache = false;
            NcovSkuFragment.this.mRequestFirst = false;
            NcovSkuFragment.this.requestSku();
        }
    }

    /* compiled from: Taobao */
    public class p extends gh1 {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ NoticeDetailFragment a;

            a(NoticeDetailFragment noticeDetailFragment) {
                this.a = noticeDetailFragment;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-868426481")) {
                    ipChange.ipc$dispatch("-868426481", new Object[]{this, view});
                } else if (!NcovSkuFragment.this.mActivity.isFinishing()) {
                    FragmentTransaction beginTransaction = NcovSkuFragment.this.getChildFragmentManager().beginTransaction();
                    beginTransaction.remove(this.a);
                    beginTransaction.commitAllowingStateLoss();
                    NcovSkuFragment.this.mDicountContainer.setVisibility(8);
                }
            }
        }

        /* compiled from: Taobao */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ NoticeDetailFragment a;

            b(NoticeDetailFragment noticeDetailFragment) {
                this.a = noticeDetailFragment;
            }

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1242863888")) {
                    ipChange.ipc$dispatch("1242863888", new Object[]{this, view});
                } else if (!NcovSkuFragment.this.mActivity.isFinishing()) {
                    FragmentTransaction beginTransaction = NcovSkuFragment.this.getChildFragmentManager().beginTransaction();
                    beginTransaction.remove(this.a);
                    beginTransaction.commitAllowingStateLoss();
                    NcovSkuFragment.this.mDicountContainer.setVisibility(8);
                }
            }
        }

        p(View view, Activity activity, long j, NcovSkuBottomInfo ncovSkuBottomInfo) {
            super(view, activity, j, ncovSkuBottomInfo);
        }

        @Override // tb.gh1
        public void i(PerformSummaryBean performSummaryBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435673564")) {
                ipChange.ipc$dispatch("1435673564", new Object[]{this, performSummaryBean});
            } else if (performSummaryBean != null) {
                NcovSkuFragment ncovSkuFragment = NcovSkuFragment.this;
                ncovSkuFragment.mDataId = performSummaryBean.performId + "";
                NcovSkuFragment.this.mDataType = "2";
                NcovSkuFragment.this.mRequestFirst = false;
                NcovSkuFragment.this.mIsLoadCache = false;
                NcovSkuFragment.this.requestSku();
                NcovSkuFragment.this.skuBottomInfo.discountTip = performSummaryBean.mktPromotionTips;
            }
        }

        @Override // tb.gh1
        public void j(ArrayList<ItemContent> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-806229598")) {
                ipChange.ipc$dispatch("-806229598", new Object[]{this, arrayList});
                return;
            }
            cn.damai.common.user.c.e().x(wb2.i().j(NcovSkuFragment.this.mItemId));
            NoticeDetailFragment instance = NoticeDetailFragment.instance(arrayList, NcovSkuFragment.this.mItemId + "");
            instance.setClose(new a(instance));
            FragmentTransaction fragmentTransaction = NcovSkuFragment.this.getFragmentTransaction();
            fragmentTransaction.replace(R$id.fragment_discount, instance);
            fragmentTransaction.commitAllowingStateLoss();
            NcovSkuFragment.this.mDicountContainer.setVisibility(0);
            NcovSkuFragment.this.mDicountContainer.setOnClickListener(new b(instance));
        }
    }

    /* compiled from: Taobao */
    public class q extends ih1 {
        private static transient /* synthetic */ IpChange $ipChange;

        q(Fragment fragment, View view, View view2, long j, NcovSkuBottomInfo ncovSkuBottomInfo) {
            super(fragment, view, view2, j, ncovSkuBottomInfo);
        }

        @Override // tb.ih1
        public void e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1282243892")) {
                ipChange.ipc$dispatch("1282243892", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            NcovSkuFragment.this.calculateTicketPrice(i);
        }

        @Override // tb.ih1
        public void m(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-636163800")) {
                ipChange.ipc$dispatch("-636163800", new Object[]{this, str, str2});
                return;
            }
            NcovSkuFragment.this.showSeatPic(str, str2);
            if (NcovSkuFragment.this.mSelectedPerform != null) {
                cn.damai.common.user.c.e().x(wb2.i().n(NcovSkuFragment.this.mItemId, NcovSkuFragment.this.mSelectedPerform.performId));
            }
        }

        @Override // tb.ih1
        public void n(PriceBean priceBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-381227443")) {
                ipChange.ipc$dispatch("-381227443", new Object[]{this, priceBean});
                return;
            }
            NcovSkuFragment.this.mSelectedPrice = priceBean;
            NcovSkuFragment ncovSkuFragment = NcovSkuFragment.this;
            if (ncovSkuFragment.skuBottomInfo.pageType == 1) {
                ncovSkuFragment.scrollNum();
            }
        }

        @Override // tb.ih1
        public void w() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-94799022")) {
                ipChange.ipc$dispatch("-94799022", new Object[]{this});
                return;
            }
            NcovSkuFragment.this.showPromotionFragment();
            cn.damai.common.user.c.e().x(wb2.i().m(NcovSkuFragment.this.mItemId));
        }

        @Override // tb.ih1
        public void y() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "436722302")) {
                ipChange.ipc$dispatch("436722302", new Object[]{this});
                return;
            }
            NcovSkuFragment.this.setDefaultCalc();
            NcovSkuFragment.this.mSkuBottomView.i(NcovSkuFragment.this.mSelectedPrice);
        }
    }

    private void buyNow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1516940147")) {
            ipChange.ipc$dispatch("-1516940147", new Object[]{this});
        } else if (this.mBasicInfoBean != null && checkSelectData(true)) {
            Bundle bundle = new Bundle();
            bundle.putString("buyParam", this.mItemId + JSMethod.NOT_SET + this.mSkuPriceView.h() + JSMethod.NOT_SET + this.mSelectedPrice.skuId);
            bundle.putBoolean("buyNow", true);
            bundle.putLong(LiveActivity.OPTION_DAMAI_ITEM_ID, this.mItemId);
            CreateOrderExParams createOrderExParams = new CreateOrderExParams();
            createOrderExParams.setChannel("damai_app");
            createOrderExParams.setSeatInfo("");
            createOrderExParams.setAtomSplit(this.mAtomSplit);
            bundle.putString(Request.K_EXPARAMS, JSON.toJSONString(createOrderExParams));
            Activity activity = this.mActivity;
            if (activity != null && !activity.isFinishing()) {
                DMNav.from(this.mActivity).withExtras(bundle).toUri(NavUri.b(gr.c));
                confirmUtReport();
            }
        }
    }

    private void cacheLastSelectParams() {
        mi1 mi1;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444072013")) {
            ipChange.ipc$dispatch("-444072013", new Object[]{this});
            return;
        }
        PerformBean performBean = this.mSelectedPerform;
        if ((performBean == null || performBean.chooseSeatType == 1) && (mi1 = this.mNewSkuData) != null) {
            mi1.b = this.mSelectedDate;
            mi1.c = performBean;
            mi1.d = this.mSelectedPrice;
            mi1.e = this.mBasicInfoBean;
            mi1.f = this.mPromotionBean;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void calculateTicketPrice(int i2) {
        CalculatePriceControlBean calculatePriceControlBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927013763")) {
            ipChange.ipc$dispatch("-1927013763", new Object[]{this, Integer.valueOf(i2)});
        } else if (this.mSelectedPrice != null && this.mSelectedPerform != null) {
            startProgressDialog();
            ArrayList arrayList = new ArrayList();
            SeatCalcParams seatCalcParams = new SeatCalcParams();
            seatCalcParams.count = i2;
            seatCalcParams.priceId = this.mSelectedPrice.priceId + "";
            seatCalcParams.price = (int) (this.mSelectedPrice.dashPrice * 100.0d);
            arrayList.add(seatCalcParams);
            String str = null;
            ActionControlBean actionControlBean = this.mActionControlBean;
            if (!(actionControlBean == null || (calculatePriceControlBean = actionControlBean.calculatePriceControl) == null)) {
                str = calculatePriceControlBean.calculateTag;
            }
            new MtopCalcTicketPriceRequest(this.mItemId + "", this.mSelectedPerform.performId + "", str, arrayList).request(new DMMtopRequestListener<TicketCalcRes>(TicketCalcRes.class) {
                /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass21 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1324433359")) {
                        ipChange.ipc$dispatch("1324433359", new Object[]{this, str, str2});
                        return;
                    }
                    NcovSkuFragment.this.setDefaultCalc();
                    NcovSkuFragment.this.updateCaleView();
                }

                public void onSuccess(TicketCalcRes ticketCalcRes) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-469212167")) {
                        ipChange.ipc$dispatch("-469212167", new Object[]{this, ticketCalcRes});
                    } else if (ticketCalcRes == null || ticketCalcRes.isBizSuccess()) {
                        NcovSkuFragment.this.mTicketCalcBean = ticketCalcRes.model;
                        NcovSkuFragment.this.updateCaleView();
                    } else {
                        onFail("", "");
                    }
                }
            });
        }
    }

    private boolean checkSelectData(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-13118343")) {
            return ((Boolean) ipChange.ipc$dispatch("-13118343", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        } else if (this.mSelectedPerform == null) {
            ToastUtil.f(this.mActivity.getString(R$string.project_perform_choose_time));
            return false;
        } else if (!z || this.mSelectedPrice != null) {
            return true;
        } else {
            ToastUtil.f(this.mActivity.getString(R$string.project_perform_choose_price));
            return false;
        }
    }

    private void confirmUtReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856935814")) {
            ipChange.ipc$dispatch("-856935814", new Object[]{this});
            return;
        }
        new SimpleDateFormat("HH:mm", Locale.CHINA).setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mSelectedDate != null) {
            stringBuffer.append(this.mSelectedDate.dateId + "+&+");
        }
        if (this.mSelectedPerform != null) {
            stringBuffer.append(this.mSelectedPerform.performBeginDTStr + " (" + this.mSelectedPerform.performName + jl1.BRACKET_END_STR);
        }
        cn.damai.common.user.c.e().x(wb2.i().q(this.mItemId, stringBuffer.toString()));
    }

    private void dengjiReuqest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669026289")) {
            ipChange.ipc$dispatch("-669026289", new Object[]{this});
        } else if (this.mSelectedPrice != null && this.skuBottomInfo != null) {
            try {
                startProgressDialog();
            } catch (Exception unused) {
            }
            this.mDengjiRequest.targetId = String.valueOf(this.mSelectedPrice.skuId);
            DengjiRequest dengjiRequest = this.mDengjiRequest;
            dengjiRequest.targetType = this.skuBottomInfo.followRelationTargetType;
            dengjiRequest.itemId = this.mItemId;
            this.mModel.dengjiRequest(dengjiRequest);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissPriceDetailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984004733")) {
            ipChange.ipc$dispatch("984004733", new Object[]{this});
        } else if (this.mNcovSkuPriceDetailFragment != null && !this.mActivity.isFinishing()) {
            dh1 dh1 = this.mSkuBottomView;
            if (dh1 != null) {
                dh1.f(true);
            }
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.remove(this.mNcovSkuPriceDetailFragment);
            fragmentTransaction.commitAllowingStateLoss();
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass28 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1649151040")) {
                        ipChange.ipc$dispatch("1649151040", new Object[]{this});
                    } else if (!NcovSkuFragment.this.mActivity.isFinishing() && NcovSkuFragment.this.isVisible()) {
                        NcovSkuFragment.this.mPriceDetailContainer.setVisibility(8);
                    }
                }
            }, 400);
        }
    }

    private void dismissPriceDetailFragmentQuick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879477120")) {
            ipChange.ipc$dispatch("-879477120", new Object[]{this});
        } else if (this.mNcovSkuPriceDetailFragment != null && !this.mActivity.isFinishing() && this.mNcovSkuPriceDetailFragment.isVisible()) {
            dh1 dh1 = this.mSkuBottomView;
            if (dh1 != null) {
                dh1.f(true);
            }
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.remove(this.mNcovSkuPriceDetailFragment);
            beginTransaction.commitAllowingStateLoss();
            this.mPriceDetailContainer.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissPromotionFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "174041012")) {
            ipChange.ipc$dispatch("174041012", new Object[]{this});
        } else if (this.mNcovPromotionFragment != null && !this.mActivity.isFinishing()) {
            FragmentTransaction fragmentTransaction = getFragmentTransaction();
            fragmentTransaction.remove(this.mNcovPromotionFragment);
            fragmentTransaction.commitAllowingStateLoss();
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass26 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2042178050")) {
                        ipChange.ipc$dispatch("2042178050", new Object[]{this});
                    } else if (!NcovSkuFragment.this.mActivity.isFinishing() && NcovSkuFragment.this.isVisible()) {
                        NcovSkuFragment.this.mDicountContainer.setVisibility(8);
                    }
                }
            }, 400);
            novBackUtHandle();
        }
    }

    private SkuSaveInfo getHasCache() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "660776539")) {
            return ub2.a(this.mItemId);
        }
        return (SkuSaveInfo) ipChange.ipc$dispatch("660776539", new Object[]{this});
    }

    public static NcovSkuFragment getInstance(SkuBean skuBean, long j2, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544758102")) {
            return (NcovSkuFragment) ipChange.ipc$dispatch("544758102", new Object[]{skuBean, Long.valueOf(j2), str, str2});
        }
        NcovSkuFragment ncovSkuFragment = new NcovSkuFragment();
        Bundle bundle = new Bundle();
        if (skuBean != null) {
            bundle.putSerializable(KEY_SKU_BEAN, skuBean);
        }
        bundle.putLong("item_id", j2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(KEY_PRIVILEGE_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(NcovSkuActivity.KEY_ATOMSPLIT, str2);
        }
        ncovSkuFragment.setArguments(bundle);
        return ncovSkuFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void goBottomBtn() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41994716")) {
            ipChange.ipc$dispatch("-41994716", new Object[]{this});
            return;
        }
        NcovSkuBottomInfo ncovSkuBottomInfo = this.skuBottomInfo;
        if (ncovSkuBottomInfo != null && ncovSkuBottomInfo.isCanClickable) {
            cacheLastSelectParams();
            int i2 = this.skuBottomInfo.buyStatus;
            if (i2 == 1) {
                buyNow();
            } else if (i2 == 2) {
                dengjiReuqest();
            } else if (i2 == 3) {
                dengjiReuqest();
            } else if (i2 == 4) {
                goSeat();
            }
        }
    }

    private void goSeat() {
        int i2;
        IpChange ipChange = $ipChange;
        int i3 = 1;
        if (AndroidInstantRuntime.support(ipChange, "1743812304")) {
            ipChange.ipc$dispatch("1743812304", new Object[]{this});
        } else if (this.mBasicInfoBean != null && checkSelectData(false)) {
            SeatPrepare seatPrepare = this.mSeatDoor;
            if (seatPrepare == null) {
                seatPrepare = new SeatPrepare(getActivity(), this.mItemId);
            }
            ClickedPerform clickedPerform = new ClickedPerform(2, this.mBasicInfoBean, this.mSelectedPerform, this.mSelectedPrice, this.mPromotionBean, this.mTradeInfo);
            try {
                if (!TextUtils.isEmpty(this.mAtomSplit)) {
                    i3 = Integer.parseInt(this.mAtomSplit);
                }
                i2 = i3;
            } catch (Exception e2) {
                e2.printStackTrace();
                i2 = 1;
            }
            BasicInfoBean basicInfoBean = this.mBasicInfoBean;
            seatPrepare.h(clickedPerform, basicInfoBean != null ? basicInfoBean.nationalStandardCityId : "", this.mPrivilegeId, i2, new h());
            confirmUtReport();
        }
    }

    @SuppressLint({"NewApi"})
    private void initBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1138730485")) {
            ipChange.ipc$dispatch("-1138730485", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mItemId = arguments.getLong("item_id");
            this.mPrivilegeId = arguments.getString(KEY_PRIVILEGE_ID);
            this.mSkuBean = (SkuBean) arguments.getSerializable(KEY_SKU_BEAN);
            this.mAtomSplit = arguments.getString(NcovSkuActivity.KEY_ATOMSPLIT);
            this.mIsShowYK = arguments.getBoolean(NcovSkuActivity.KEY_ISSHOWYK);
            this.mRemindTitle = arguments.getString(NcovSkuActivity.KEY_REMIND_TITLE);
            this.mRemindSaleTime = arguments.getLong(NcovSkuActivity.KEY_REMIND_SALE_TIME);
            long j2 = arguments.getLong(NcovSkuActivity.KEY_REMIND_COUNTDOWN);
            this.mRemindCountDown = j2;
            if (j2 > 600) {
                this.mPageOpenTs = SystemClock.elapsedRealtime();
            }
            this.mPreloadExtra = SeatPreloadExtra.obtainExtra(arguments);
        }
        this.mNewSkuData = ni1.a().b(this.mItemId);
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "487071715")) {
            ipChange.ipc$dispatch("487071715", new Object[]{this});
            return;
        }
        this.mModel = new SkuModel(this.mActivity);
        if (this.mSkuBean == null) {
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass11 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "526729638")) {
                        ipChange.ipc$dispatch("526729638", new Object[]{this});
                        return;
                    }
                    NcovSkuFragment.this.mDataId = null;
                    NcovSkuFragment.this.mDataType = null;
                    NcovSkuFragment.this.loadCacheParam();
                    NcovSkuFragment.this.requestSku();
                }
            }, 50);
        } else {
            this.mIsProjectDetailSkuBean = true;
            loadCacheParam();
            updateAllview(null);
        }
        this.mModel.getSkuBean().observe(this, new Observer<SkuBean>() {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable SkuBean skuBean) {
                String str;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1188203338")) {
                    ipChange.ipc$dispatch("1188203338", new Object[]{this, skuBean});
                    return;
                }
                String str2 = null;
                if (skuBean != null && skuBean.x_mtopFail) {
                    String str3 = skuBean.x_errCode;
                    NcovSkuFragment ncovSkuFragment = NcovSkuFragment.this;
                    if (ncovSkuFragment.page != null && ncovSkuFragment.isFlowLimitedErrorCode(str3)) {
                        NcovSkuFragment.this.page.updateReportBtnVis(skuBean.x_errCode);
                        NcovSkuFragment.this.page.loadErrorMsg(skuBean.x_errCode, "抱歉，当前排队的人数太多啦，请稍后再试哦");
                    }
                    if (!oz0.b().c(skuBean.x_errCode)) {
                        ProjectDetailXFlushUtil.b(String.valueOf(NcovSkuFragment.this.mItemId), skuBean.x_errCode, "errMsg:" + skuBean.x_errMsg + "_dataId:" + skuBean.x_dataId + "_dataType:" + skuBean.x_dataType);
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemId", String.valueOf(NcovSkuFragment.this.mItemId));
                        hashMap.put(NcovSkuActivity.KEY_PRIVILEGEID, String.valueOf(NcovSkuFragment.this.mPrivilegeId));
                        NcovSkuFragment.this.pageAlarm(skuBean.x_errCode, skuBean.x_errMsg, "screenings", hashMap);
                    }
                    skuBean = null;
                    str2 = str3;
                } else if (skuBean == null || skuBean.perform == null) {
                    String str4 = "";
                    ProjectDetailXFlushUtil.b(String.valueOf(NcovSkuFragment.this.mItemId), str4, skuBean == null ? "Mtop_skuBean=null" : "Mtop_skuBean.perform=null");
                    if (NcovSkuFragment.this.mSkuBean == null) {
                        str4 = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
                        str = "error sku bean empty";
                    } else if (NcovSkuFragment.this.mSkuBean.performCalendar == null) {
                        str4 = "02";
                        str = "error sku perform calendar bean empty";
                    } else if (NcovSkuFragment.this.mSkuBean.perform == null) {
                        str4 = "03";
                        str = "error sku perform bean empty";
                    } else {
                        str = str4;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("itemId", String.valueOf(NcovSkuFragment.this.mItemId));
                    hashMap2.put(NcovSkuActivity.KEY_PRIVILEGEID, String.valueOf(NcovSkuFragment.this.mPrivilegeId));
                    NcovSkuFragment.this.pageAlarm(str4, str, "screenings", hashMap2);
                }
                NcovSkuFragment.this.stopProgressDialog();
                NcovSkuFragment.this.mIsProjectDetailSkuBean = false;
                NcovSkuFragment.this.mSkuBean = skuBean;
                NcovSkuFragment.this.updateAllview(str2);
            }
        });
        this.mModel.getFollowDataBean().observe(this, new Observer<FollowDataBean>() {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass13 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onChanged(@Nullable FollowDataBean followDataBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1206233571")) {
                    ipChange.ipc$dispatch("-1206233571", new Object[]{this, followDataBean});
                    return;
                }
                NcovSkuFragment.this.updateDengji(followDataBean);
            }
        });
    }

    private void initLayout() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033589149")) {
            ipChange.ipc$dispatch("-1033589149", new Object[]{this});
            return;
        }
        this.mSkuView = this.rootView.findViewById(R$id.layout_sku);
        this.mErrorView = (LinearLayout) this.rootView.findViewById(R$id.error_view);
        this.mStatusBarSpace = this.rootView.findViewById(R$id.title_bar_space);
        adjustStatusBar();
        this.mAppBar = (AppBarLayout) this.rootView.findViewById(R$id.appbar);
        this.mTopLayout = this.rootView.findViewById(R$id.layout_top);
        this.mHeader = this.rootView.findViewById(R$id.header);
        this.mTitleBgLayout = this.rootView.findViewById(R$id.title_bg_layout);
        this.mHeaderImg = this.rootView.findViewById(R$id.header_image);
        this.mProjcetImage = (ImageView) this.rootView.findViewById(R$id.img_project);
        mi1 mi1 = this.mNewSkuData;
        if (!(mi1 == null || (i2 = mi1.a) == 0)) {
            this.mHeaderImg.setBackgroundColor(i2);
        }
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.rootView.findViewById(R$id.title_back_btn);
        this.mBackBtn = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new l());
        this.mTitleTv = (TextView) this.rootView.findViewById(R$id.title_tv);
        this.mTopNormalLayout = this.rootView.findViewById(R$id.layout_top_normal);
        this.mTopSeeLayout = this.rootView.findViewById(R$id.layout_top_see);
        this.mTopTitleTv = (TextView) this.rootView.findViewById(R$id.tv_title);
        this.mDescTv = (TextView) this.rootView.findViewById(R$id.tv_desc);
        this.mStartBgView = this.rootView.findViewById(R$id.layout_start_bg);
        this.mDateTitleLayout = this.rootView.findViewById(R$id.layout_date_title);
        this.mDateTipTv = (TextView) this.rootView.findViewById(R$id.tv_date_tip);
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new m());
        this.mSkuSimpleDateView = new NcovSkuSimpleDateView(this.rootView.findViewById(R$id.layout_simple_date)) {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.NcovSkuSimpleDateView
            public void j(View view, DayEntity dayEntity) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "400554746")) {
                    ipChange.ipc$dispatch("400554746", new Object[]{this, view, dayEntity});
                } else if (dayEntity != null) {
                    NcovSkuFragment.this.mSelectedPerform = null;
                    NcovSkuFragment.this.mDataId = dayEntity.dateId;
                    NcovSkuFragment.this.mDateDataId = dayEntity.dateId;
                    NcovSkuFragment.this.mDataType = "4";
                    NcovSkuFragment.this.mRequestFirst = false;
                    NcovSkuFragment.this.mIsLoadCache = false;
                    NcovSkuFragment.this.requestSku();
                    cn.damai.common.user.c.e().x(wb2.i().r(NcovSkuFragment.this.mItemId, dayEntity.dateId, dayEntity.index));
                }
            }

            @Override // cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.NcovSkuSimpleDateView
            public void k() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1321684810")) {
                    ipChange.ipc$dispatch("-1321684810", new Object[]{this});
                    return;
                }
                cn.damai.common.user.c.e().x(wb2.i().f(NcovSkuFragment.this.mItemId));
                NcovSkuFragment.this.mAppBar.setExpanded(true, false);
                NcovSkuFragment.this.mIsShowDateView = true;
                NcovSkuFragment.this.mAppBar.postDelayed(new Runnable() {
                    /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass5.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1140325220")) {
                            ipChange.ipc$dispatch("1140325220", new Object[]{this});
                            return;
                        }
                        NcovSkuFragment.this.mSkuSimpleDateView.l(8);
                        NcovSkuFragment.this.mSkuDateView.i(0);
                    }
                }, 50);
            }
        };
        VerticalNestedScrollView verticalNestedScrollView = (VerticalNestedScrollView) this.rootView.findViewById(R$id.preform_scrollview);
        this.mScrollView = verticalNestedScrollView;
        verticalNestedScrollView.setOnScrollListener(new n());
        this.mSkuDateView = new o(this.rootView.findViewById(R$id.layout_date), this.mItemId);
        View view = this.rootView;
        int i3 = R$id.layout_perform_view;
        this.mSkuPerformLayout = (LinearLayout) view.findViewById(i3);
        this.mRegesiterLayout = this.rootView.findViewById(R$id.layout_register);
        this.mRegisterTipTv = (TextView) this.rootView.findViewById(R$id.tv_register_tip);
        this.mSkuPerformView = new p(this.rootView.findViewById(i3), getActivity(), this.mItemId, this.skuBottomInfo);
        View view2 = this.rootView;
        int i4 = R$id.layout_price;
        View findViewById = view2.findViewById(i4);
        View view3 = this.rootView;
        int i5 = R$id.bottom_layout;
        this.mSkuPriceView = new q(this, findViewById, view3.findViewById(i5), this.mItemId, this.skuBottomInfo);
        this.mSkuBottomView = new a(this.rootView.findViewById(i5), this.rootView.findViewById(i4), this.skuBottomInfo);
        this.mPriceDetailContainer = this.rootView.findViewById(R$id.fragment_price_detail);
        this.mDicountContainer = this.rootView.findViewById(R$id.fragment_discount);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isFlowLimitedErrorCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1329869368")) {
            return ((Boolean) ipChange.ipc$dispatch("1329869368", new Object[]{this, str})).booleanValue();
        } else if (oz0.FAIL_SYS_TRAFFIC_LIMIT.equalsIgnoreCase(str) || "ANDROID_SYS_API_FLOW_LIMIT_LOCKED".equalsIgnoreCase(str)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isUseChecked() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1180272169")) {
            return !this.mRequestFirst || this.mIsLoadCache;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1180272169", new Object[]{this})).booleanValue();
    }

    private void loadCacheData() {
        PerformBean performBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955798823")) {
            ipChange.ipc$dispatch("1955798823", new Object[]{this});
            return;
        }
        SkuSaveInfo a2 = ub2.a(this.mItemId);
        if (a2 != null && !s71.a(this.mSkuBean.perform.skuList) && (performBean = this.mSelectedPerform) != null && performBean.performId == a2.performId) {
            for (int i2 = 0; i2 < this.mSkuBean.perform.skuList.size(); i2++) {
                PriceBean priceBean = this.mSkuBean.perform.skuList.get(i2);
                int i3 = this.skuBottomInfo.pageType;
                if (i3 == 1) {
                    if (priceBean.priceId == a2.priceId && priceBean.clickable && priceBean.frontEndStatus == 1) {
                        this.mSelectedPrice = priceBean;
                        this.mSkuPriceView.s(priceBean);
                        return;
                    }
                } else if (i3 == 2 && priceBean.priceId == a2.priceId && priceBean.clickable) {
                    this.mSelectedPrice = priceBean;
                    this.mSkuPriceView.s(priceBean);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loadCacheParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116096084")) {
            ipChange.ipc$dispatch("-116096084", new Object[]{this});
            return;
        }
        SkuSaveInfo a2 = ub2.a(this.mItemId);
        if (a2 != null) {
            this.mIsLoadCache = true;
            this.mDateDataId = a2.dataId;
            this.mDataId = a2.performId + "";
            this.mDataType = "2";
        }
    }

    private void novBackUtHandle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1446526742")) {
            ipChange.ipc$dispatch("-1446526742", new Object[]{this});
            return;
        }
        viewIgnoreTagForExposure(this.mNcovPromotionFragment.getView());
        cn.damai.common.user.c.e().q(getActivity());
        cn.damai.common.user.c.e().p(this, ((NcovSkuActivity) getActivity()).mBuilder);
        cn.damai.common.user.c.e().b(this.exposureViewList);
        this.exposureViewList.clear();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pageAlarm(String str, String str2, String str3, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989071844")) {
            ipChange.ipc$dispatch("-1989071844", new Object[]{this, str, str2, str3, map});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("itemId", this.mItemId + "");
        if (this.mPreloadExtra != null) {
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, this.mPreloadExtra.performId + "");
        }
        hashMap.put(Constants.KEY_DATA_ID, this.mDataId);
        hashMap.put(MtopJSBridge.MtopJSParam.DATA_TYPE, this.mDataType);
        if (map != null) {
            hashMap.putAll(map);
        }
        dr.INSTANCE.a().a("mtop.alibaba.detail.subpage.getdetail").c(str).d(str2).g("SKU页").j(str3).e(hashMap).f(false).b();
    }

    private void postSeatPreloadIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944528278")) {
            ipChange.ipc$dispatch("1944528278", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "30226325")) {
                    ipChange.ipc$dispatch("30226325", new Object[]{this});
                } else if (NcovSkuFragment.this.mPreloadExtra != null && NcovSkuFragment.this.mPreloadExtra.isValid()) {
                    NcovSkuFragment.this.mSeatDoor.i(NcovSkuFragment.this.mPreloadExtra.type, NcovSkuFragment.this.mPreloadExtra.cityId, NcovSkuFragment.this.mPreloadExtra.performId);
                }
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void recordSkuInfo(boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-297005983")) {
            ipChange.ipc$dispatch("-297005983", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mSelectedPerform != null && this.mSelectedPrice != null && !this.mActivity.isFinishing()) {
            ub2.d(this.mItemId, new SkuSaveInfo(this.mDateDataId, this.mSelectedPerform.performId, this.mSelectedPrice.priceId));
            seeAddReuqest();
            if (z) {
                this.mIsSeeRequestDengji = true;
                dengjiReuqest();
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("已为您预选了想看的场次和票档");
            if (hp1.i(lp1.CALENDAR) && !se.b(getContext(), this.mRemindTitle, this.mRemindSaleTime)) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mPageOpenTs;
                StringBuilder sb = new StringBuilder();
                sb.append("initial CountDown:");
                sb.append(this.mRemindCountDown);
                sb.append(" passed time:");
                long j2 = elapsedRealtime / 1000;
                sb.append(j2);
                h91.a("Remind", sb.toString());
                if (this.mRemindCountDown - j2 > 600) {
                    se.a(getContext(), this.mRemindTitle, this.mRemindSaleTime, null);
                    spannableStringBuilder.append((CharSequence) "开抢前10分钟，您将收到抢票提醒");
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_FF2869)), 14, 20, 17);
                    str = "提醒设置成功";
                    DMThemeDialog dMThemeDialog = new DMThemeDialog(this.mActivity);
                    dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_SUPPORT_WANNA);
                    dMThemeDialog.k(spannableStringBuilder);
                    dMThemeDialog.o(str);
                    dMThemeDialog.g(true, null);
                    dMThemeDialog.i("知道了", new g());
                    dMThemeDialog.show();
                }
            }
            str = "提交成功";
            DMThemeDialog dMThemeDialog2 = new DMThemeDialog(this.mActivity);
            dMThemeDialog2.r(DMThemeDialog.DMDialogTheme.THEME_SUPPORT_WANNA);
            dMThemeDialog2.k(spannableStringBuilder);
            dMThemeDialog2.o(str);
            dMThemeDialog2.g(true, null);
            dMThemeDialog2.i("知道了", new g());
            dMThemeDialog2.show();
        }
    }

    private void resetBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-621567917")) {
            ipChange.ipc$dispatch("-621567917", new Object[]{this});
            return;
        }
        NcovSkuBottomInfo ncovSkuBottomInfo = this.skuBottomInfo;
        ncovSkuBottomInfo.allPrice = 0.0d;
        ncovSkuBottomInfo.promotionAmount = 0.0d;
        ncovSkuBottomInfo.discountTip = null;
        ncovSkuBottomInfo.buyTip = null;
        ncovSkuBottomInfo.buyStatus = 0;
        ncovSkuBottomInfo.followRelationTargetType = 0;
        ncovSkuBottomInfo.isCanClickable = false;
        ncovSkuBottomInfo.pageType = 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void scrollNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573651668")) {
            ipChange.ipc$dispatch("1573651668", new Object[]{this});
            return;
        }
        this.mScrollView.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass18 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-848864897")) {
                    ipChange.ipc$dispatch("-848864897", new Object[]{this});
                } else if (!NcovSkuFragment.this.mActivity.isFinishing() && NcovSkuFragment.this.isVisible() && NcovSkuFragment.this.mSelectedPrice != null) {
                    NcovSkuFragment.this.mScrollView.smoothScrollTo(0, ((BaseFragment) NcovSkuFragment.this).rootView.findViewById(R$id.view_scroll_location).getTop() + n42.a(NcovSkuFragment.this.mActivity, 120.0f));
                }
            }
        }, 100);
    }

    private void scrollPrice() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215590129")) {
            ipChange.ipc$dispatch("1215590129", new Object[]{this});
            return;
        }
        this.mScrollView.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass17 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-652351392")) {
                    ipChange.ipc$dispatch("-652351392", new Object[]{this});
                } else if (!NcovSkuFragment.this.mActivity.isFinishing() && NcovSkuFragment.this.isVisible() && NcovSkuFragment.this.mSelectedPerform != null) {
                    View findViewById = ((BaseFragment) NcovSkuFragment.this).rootView.findViewById(R$id.layout_price);
                    int[] iArr = new int[2];
                    findViewById.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    int i2 = DisplayMetrics.getheightPixels(n42.b(NcovSkuFragment.this.mActivity));
                    int a = n42.a(NcovSkuFragment.this.mActivity, 180.0f);
                    if (i == 0 || i >= i2 - a) {
                        NcovSkuFragment.this.mAppBar.setExpanded(false, false);
                        NcovSkuFragment.this.mScrollView.smoothScrollTo(0, findViewById.getTop());
                    }
                }
            }
        }, 100);
    }

    private void seeAddReuqest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597305756")) {
            ipChange.ipc$dispatch("-1597305756", new Object[]{this});
        } else if (this.mSelectedPrice != null) {
            DengjiRequest dengjiRequest = new DengjiRequest();
            dengjiRequest.targetId = String.valueOf(this.mSelectedPrice.skuId);
            dengjiRequest.targetType = 20;
            dengjiRequest.itemId = this.mItemId;
            dengjiRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) {
                /* class cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuFragment.AnonymousClass22 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1316674000")) {
                        ipChange.ipc$dispatch("1316674000", new Object[]{this, str, str2});
                    }
                }

                public void onSuccess(FollowDataBean followDataBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "595787536")) {
                        ipChange.ipc$dispatch("595787536", new Object[]{this, followDataBean});
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDefaultCalc() {
        ih1 ih1;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965314057")) {
            ipChange.ipc$dispatch("965314057", new Object[]{this});
            return;
        }
        PriceBean priceBean = this.mSelectedPrice;
        if (priceBean != null && (ih1 = this.mSkuPriceView) != null) {
            this.skuBottomInfo.allPrice = ik1.b(priceBean.price, ih1.h());
            this.skuBottomInfo.promotionAmount = 0.0d;
            TicketCalcBean ticketCalcBean = new TicketCalcBean();
            ticketCalcBean.calculateModuleVOS = new ArrayList();
            TicketMainUiModel ticketMainUiModel = new TicketMainUiModel();
            ticketMainUiModel.moduleTitle = "商品信息";
            ticketMainUiModel.moduleTotalAmtText = "¥" + ik1.c(this.skuBottomInfo.allPrice);
            ticketMainUiModel.moduleType = "1";
            ArrayList arrayList = new ArrayList();
            TicketSubUiModel ticketSubUiModel = new TicketSubUiModel();
            ticketSubUiModel.skuName = this.mSelectedPrice.priceName;
            ticketSubUiModel.count = this.mSkuPriceView.h() + "";
            ticketSubUiModel.amountText = "¥" + ik1.c(this.skuBottomInfo.allPrice) + "元";
            arrayList.add(ticketSubUiModel);
            ticketMainUiModel.moduleDetailVOList = arrayList;
            ticketCalcBean.calculateModuleVOS.add(ticketMainUiModel);
            this.mTicketCalcBean = ticketCalcBean;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPriceDetailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "213627552")) {
            ipChange.ipc$dispatch("213627552", new Object[]{this});
            return;
        }
        this.mPriceDetailContainer.setVisibility(0);
        dh1 dh1 = this.mSkuBottomView;
        if (dh1 != null) {
            dh1.f(false);
        }
        this.mNcovSkuPriceDetailFragment = NcovSkuPriceDetailFragment.getInstance(this.mTicketCalcBean, new j());
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.fragment_price_detail, this.mNcovSkuPriceDetailFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPromotionFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621282455")) {
            ipChange.ipc$dispatch("1621282455", new Object[]{this});
            return;
        }
        this.mDicountContainer.setVisibility(0);
        long j2 = this.mItemId;
        PromotionBean promotionBean = this.mPromotionBean;
        this.mNcovPromotionFragment = NcovPromotionFragment.instance(new PromotionDataBean("preferentialexplain", j2, promotionBean.promotionGroupList, promotionBean.promotionRemark, null, null), new i());
        FragmentTransaction fragmentTransaction = getFragmentTransaction();
        fragmentTransaction.replace(R$id.fragment_discount, this.mNcovPromotionFragment);
        fragmentTransaction.commitAllowingStateLoss();
        cn.damai.common.user.c.e().q(getActivity());
        this.exposureViewList = viewIgnoreTagForExposure(getActivity().getWindow().getDecorView());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showSeatPic(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386132729")) {
            ipChange.ipc$dispatch("1386132729", new Object[]{this, str, str2});
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        PicInfo picInfo = new PicInfo();
        picInfo.setPicUrl(str);
        picInfo.setPicTitle(str2);
        arrayList.add(picInfo);
        Bundle bundle = new Bundle();
        bundle.putString("projectId", String.valueOf(this.mItemId));
        bundle.putParcelableArrayList("pic_info", arrayList);
        bundle.putInt("position", 0);
        DMNav.from(this.mActivity).withExtras(bundle).toUri(gr.e());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateAllview(String str) {
        String str2;
        boolean z;
        boolean z2;
        String str3;
        PerformBean performBean;
        String str4;
        String str5;
        RenderingControlBean renderingControlBean;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "-1308623142")) {
            ipChange.ipc$dispatch("-1308623142", new Object[]{this, str});
            return;
        }
        SkuBean skuBean = this.mSkuBean;
        if (skuBean != null && skuBean.performCalendar != null && skuBean.perform != null) {
            this.mSkuView.setVisibility(0);
            this.mErrorView.setVisibility(8);
            SkuBean skuBean2 = this.mSkuBean;
            this.mTradeInfo = skuBean2.tradeinfo;
            this.mPromotionBean = skuBean2.promotionDetail;
            this.mBasicInfoBean = skuBean2.itemBasicInfo;
            updateHeaderBg();
            SkuBean skuBean3 = this.mSkuBean;
            this.mItemAdditionalInfo = skuBean3.itemAdditionalInfo;
            this.mDialogBean = skuBean3.skuRelatedText;
            ActionControlBean actionControlBean = skuBean3.actionControl;
            this.mActionControlBean = actionControlBean;
            if (!(actionControlBean == null || (renderingControlBean = actionControlBean.renderingControl) == null)) {
                this.skuBottomInfo.pageType = renderingControlBean.renderingType;
            }
            this.mDateTitleLayout.setVisibility(8);
            this.mSkuSimpleDateView.m(8);
            this.mSkuDateView.i(8);
            this.mSkuPerformView.n(8);
            this.mSkuPriceView.v(8);
            if (this.skuBottomInfo.pageType == 1) {
                this.mTopNormalLayout.setVisibility(0);
                this.mTopSeeLayout.setVisibility(8);
                this.mProjcetImage.setVisibility(8);
                this.mHeaderImg.setVisibility(0);
            } else {
                this.mTopNormalLayout.setVisibility(8);
                this.mTopSeeLayout.setVisibility(0);
                this.mProjcetImage.setVisibility(0);
                this.mHeaderImg.setVisibility(8);
            }
            if (this.mBasicInfoBean != null) {
                if (this.skuBottomInfo.pageType == 2) {
                    this.mTitleTv.setTextColor(this.mActivity.getResources().getColor(R$color.white));
                } else {
                    this.mTitleTv.setTextColor(this.mActivity.getResources().getColor(R$color.color_000000));
                }
                this.mTitleTv.setText(this.mBasicInfoBean.projectTitle);
                this.mTopTitleTv.setText(this.mBasicInfoBean.projectTitle);
                BasicInfoBean basicInfoBean = this.mBasicInfoBean;
                String str6 = basicInfoBean.venueName;
                if (!TextUtils.isEmpty(basicInfoBean.cityName)) {
                    BasicInfoBean basicInfoBean2 = this.mBasicInfoBean;
                    str6 = basicInfoBean2.cityName;
                    if (!TextUtils.isEmpty(basicInfoBean2.venueName)) {
                        str6 = str6 + " | " + this.mBasicInfoBean.venueName;
                    }
                }
                this.mDescTv.setText(str6);
            }
            BusinessInfo businessInfo = this.mItemAdditionalInfo;
            if (businessInfo != null) {
                str2 = businessInfo.performZoneNotice;
                this.skuBottomInfo.buyTip = businessInfo.unpaidNotice;
            } else {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                this.mDateTipTv.setText(str2);
            }
            this.mIsShowDate = false;
            if (xf2.e(this.mSkuBean.performCalendar.dateViews) <= 0 || !this.mSkuBean.performCalendar.showDates) {
                this.mSkuPerformLayout.setPadding(0, 0, 0, n42.a(this.mActivity, 3.0f));
                z = true;
            } else {
                this.mDateTitleLayout.setVisibility(0);
                this.mSkuSimpleDateView.m(0);
                this.mIsShowDate = true;
                if (this.mIsShowDateView) {
                    this.mSkuDateView.i(0);
                    this.mSkuSimpleDateView.l(8);
                } else {
                    this.mSkuDateView.i(8);
                    this.mSkuSimpleDateView.l(0);
                }
                z = false;
                for (int i2 = 0; i2 < this.mSkuBean.performCalendar.dateViews.size(); i2++) {
                    DateBean dateBean = this.mSkuBean.performCalendar.dateViews.get(i2);
                    if (dateBean != null && dateBean.checked && isUseChecked() && (str4 = dateBean.dateId) != null && (str5 = this.mDateDataId) != null && str4.equals(str5)) {
                        this.mSelectedDate = dateBean;
                        z = true;
                    }
                }
                this.mSkuPerformLayout.setPadding(0, n42.a(this.mActivity, 15.0f), 0, n42.a(this.mActivity, 3.0f));
            }
            if (!z || s71.a(this.mSkuBean.performCalendar.performViews)) {
                z2 = false;
            } else {
                z2 = false;
                for (int i3 = 0; i3 < this.mSkuBean.performCalendar.performViews.size(); i3++) {
                    PerformSummaryBean performSummaryBean = this.mSkuBean.performCalendar.performViews.get(i3);
                    if (performSummaryBean != null && performSummaryBean.checked && isUseChecked() && (str3 = this.mDataId) != null && (performBean = this.mSkuBean.perform) != null && performBean.performId == Long.parseLong(str3)) {
                        if (this.skuBottomInfo.pageType != 1) {
                            this.mSelectedPerform = this.mSkuBean.perform;
                        } else if (this.mIsLoadCache) {
                            PerformBean performBean2 = this.mSkuBean.perform;
                            if (performBean2.performSalable) {
                                this.mSelectedPerform = performBean2;
                            }
                        } else {
                            this.mSelectedPerform = this.mSkuBean.perform;
                        }
                        z2 = true;
                    }
                }
                if (this.mSkuBean.performCalendar.performViews.size() == 1 && this.mSkuBean.performCalendar.performViews.get(0) != null && this.mSkuBean.performCalendar.performViews.get(0).clickable) {
                    this.mSelectedPerform = this.mSkuBean.perform;
                    z2 = true;
                }
            }
            if (this.mIsShowDate) {
                this.mSkuSimpleDateView.n(this.mSkuBean.performCalendar.dateViews, isUseChecked(), this.mDateDataId, this.skuBottomInfo.pageType);
                eh1 eh1 = this.mSkuDateView;
                SkuBean skuBean4 = this.mSkuBean;
                eh1.l(skuBean4.performCalendar, skuBean4.holidayCalendar, isUseChecked(), this.mDateDataId, this.skuBottomInfo.pageType);
            }
            CalculatePriceControlBean calculatePriceControlBean = null;
            if (z) {
                long j2 = 0;
                PerformBean performBean3 = this.mSelectedPerform;
                if (performBean3 != null) {
                    j2 = performBean3.performId;
                }
                BusinessInfo businessInfo2 = this.mSkuBean.itemAdditionalInfo;
                ArrayList<ItemContent> subItemContentList = (businessInfo2 == null || f92.d(businessInfo2.subItemContentList())) ? null : this.mSkuBean.itemAdditionalInfo.subItemContentList();
                gh1 gh1 = this.mSkuPerformView;
                SkuBean skuBean5 = this.mSkuBean;
                gh1.p(str2, skuBean5.performCalendar.performViews, skuBean5.perform, isUseChecked(), this.mIsLoadCache, j2, subItemContentList);
            }
            if (this.mIsShowDate && this.mSelectedPerform != null && this.mIsFirstHideDate) {
                this.mIsShowDateView = false;
                this.mSkuDateView.i(8);
                this.mSkuSimpleDateView.l(0);
            }
            this.mIsFirstHideDate = false;
            if (z && z2) {
                SkuBean skuBean6 = this.mSkuBean;
                ActionControlBean actionControlBean2 = skuBean6.actionControl;
                if (actionControlBean2 != null) {
                    calculatePriceControlBean = actionControlBean2.calculatePriceControl;
                }
                ih1 ih1 = this.mSkuPriceView;
                PerformBean performBean4 = skuBean6.perform;
                ih1.D(performBean4, performBean4.skuList, calculatePriceControlBean, skuBean6.wishHeat, skuBean6.itemAdditionalInfo);
                loadCacheData();
            }
            PromotionBean promotionBean = this.mPromotionBean;
            if (promotionBean != null) {
                wb2.i().u(this.mSelectedPerform, promotionBean.skuPromotionRelations);
            }
            this.mSkuBottomView.i(this.mSelectedPrice);
            ih1 ih12 = this.mSkuPriceView;
            boolean z4 = !TextUtils.isEmpty(this.mSkuBean.perform.seatImg);
            PromotionBean promotionBean2 = this.mPromotionBean;
            if (promotionBean2 == null || f92.d(promotionBean2.promotionGroupList)) {
                z3 = false;
            }
            ih12.z(z4, z3);
            if (z2) {
                scrollPrice();
            }
        } else if (this.mRequestFirst) {
            this.mSkuView.setVisibility(8);
            this.mErrorView.setVisibility(0);
        } else {
            this.mSkuView.setVisibility(0);
            this.mErrorView.setVisibility(8);
            if (TextUtils.isEmpty(str) || !isFlowLimitedErrorCode(str)) {
                ToastUtil.f("麦麦开小差了，请稍后重试哦");
            } else {
                ToastUtil.f("抱歉，当前排队的人数太多啦，请稍后再试哦");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCaleView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768676520")) {
            ipChange.ipc$dispatch("-768676520", new Object[]{this});
            return;
        }
        stopProgressDialog();
        NcovSkuBottomInfo ncovSkuBottomInfo = this.skuBottomInfo;
        ncovSkuBottomInfo.isCanClickable = true;
        TicketCalcBean ticketCalcBean = this.mTicketCalcBean;
        if (ticketCalcBean != null) {
            try {
                ncovSkuBottomInfo.allPrice = ik1.a(Double.parseDouble(ticketCalcBean.realTotalAmt), 100);
                this.skuBottomInfo.promotionAmount = ik1.a(Double.parseDouble(this.mTicketCalcBean.reduceTotalAmt), 100);
            } catch (Exception unused) {
            }
            this.mSkuBottomView.i(this.mSelectedPrice);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateDengji(FollowDataBean followDataBean) {
        DialogBean dialogBean;
        HashMap hashMap;
        NcovSkuBottomInfo ncovSkuBottomInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70989214")) {
            ipChange.ipc$dispatch("70989214", new Object[]{this, followDataBean});
            return;
        }
        stopProgressDialog();
        String str = "";
        if ((followDataBean == null || followDataBean.getStatus() != 1) && (ncovSkuBottomInfo = this.skuBottomInfo) != null) {
            int i2 = ncovSkuBottomInfo.buyStatus;
            if (i2 == 2) {
                str = getString(R$string.damai_goodregesiter_out_stock_fail);
            } else if (i2 == 3) {
                str = getString(R$string.damai_kaishoudengji_fail);
            }
            ToastUtil.f(str);
            this.mIsSeeRequestDengji = false;
        } else if (!PermissionsHelper.a(this.mActivity)) {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this.mActivity);
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION);
            dMThemeDialog.k("第一时间了解到您关注的演出动态");
            dMThemeDialog.o("开启消息通知");
            dMThemeDialog.g(true, null);
            dMThemeDialog.i("去开启", new f());
            dMThemeDialog.show();
        } else if (this.skuBottomInfo != null && (dialogBean = this.mDialogBean) != null && (hashMap = dialogBean.registerToastMap) != null) {
            Object obj = hashMap.get(this.skuBottomInfo.buyStatus + str);
            if (obj != null) {
                new DMThemeDialog(this.mActivity).o("提交成功").k(obj.toString()).r(DMThemeDialog.DMDialogTheme.THEME_SUPPORT_WANNA).h("知道了", getResources().getColor(R$color.color_ffffff), new e()).g(true, null).show();
            }
        }
    }

    private void updateHeaderBg() {
        BasicInfoBean basicInfoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-337717374")) {
            ipChange.ipc$dispatch("-337717374", new Object[]{this});
            return;
        }
        mi1 mi1 = this.mNewSkuData;
        if (mi1 != null && mi1.a == 0 && (basicInfoBean = this.mBasicInfoBean) != null && !TextUtils.isEmpty(basicInfoBean.mainImageUrl)) {
            DMImageCreator k2 = cn.damai.common.image.a.b().f(this.mBasicInfoBean.mainImageUrl, ScreenUtil.dip2px(xs0.a(), 93.0f), ScreenUtil.dip2px(xs0.a(), 131.0f)).k(new DMRoundedCornersBitmapProcessor(6, 0));
            int i2 = R$drawable.uikit_default_image_bg_trans_white;
            k2.i(i2).c(i2).n(new c()).e(new b(this)).f();
        }
    }

    private List<View> viewIgnoreTagForExposure(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290971803")) {
            return (List) ipChange.ipc$dispatch("-1290971803", new Object[]{this, view});
        }
        new ArrayList();
        return cn.damai.common.user.c.e().I(cn.damai.common.user.c.e().d(view));
    }

    /* access modifiers changed from: protected */
    public void adjustStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669730373")) {
            ipChange.ipc$dispatch("-669730373", new Object[]{this});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            ne2.f(this.mActivity, true, R$color.black);
        } else {
            ne2.f(this.mActivity, false, R$color.black);
        }
        View view = this.mStatusBarSpace;
        if (view == null) {
            return;
        }
        if (i2 >= 23) {
            view.getLayoutParams().height = ne2.a(this.mActivity);
            this.mStatusBarSpace.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public FragmentTransaction getFragmentTransaction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602236913")) {
            return (FragmentTransaction) ipChange.ipc$dispatch("-1602236913", new Object[]{this});
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i2 = R$anim.sku_ncov_in_from_bottom;
        int i3 = R$anim.sku_ncov_out_to_bottom;
        beginTransaction.setCustomAnimations(i2, i3, i2, i3);
        return beginTransaction;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1699645486")) {
            return R$layout.fragment_sku_ncov;
        }
        return ((Integer) ipChange.ipc$dispatch("-1699645486", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73852298")) {
            ipChange.ipc$dispatch("-73852298", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    public boolean handlerBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142198272")) {
            return ((Boolean) ipChange.ipc$dispatch("-142198272", new Object[]{this})).booleanValue();
        }
        NcovSkuPriceDetailFragment ncovSkuPriceDetailFragment = this.mNcovSkuPriceDetailFragment;
        if (ncovSkuPriceDetailFragment == null || !ncovSkuPriceDetailFragment.isVisible() || this.mPriceDetailContainer.getVisibility() != 0) {
            NcovPromotionFragment ncovPromotionFragment = this.mNcovPromotionFragment;
            if (ncovPromotionFragment == null || !ncovPromotionFragment.isVisible() || this.mDicountContainer.getVisibility() != 0) {
                return false;
            }
            dismissPromotionFragment();
            return true;
        }
        dismissPriceDetailFragment();
        return true;
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918560139")) {
            ipChange.ipc$dispatch("-918560139", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501895416")) {
            ipChange.ipc$dispatch("-501895416", new Object[]{this});
            return;
        }
        this.mActivity = getActivity();
        this.skuBottomInfo = new NcovSkuBottomInfo();
        initBundle();
        initLayout();
        this.mSeatDoor = new SeatPrepare(this.mActivity, this.mItemId);
        initData();
        postSeatPreloadIfNeed();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812342510")) {
            ipChange.ipc$dispatch("1812342510", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334581774")) {
            ipChange.ipc$dispatch("-1334581774", new Object[]{this});
            return;
        }
        super.onDestroy();
        SeatPrepare seatPrepare = this.mSeatDoor;
        if (seatPrepare != null) {
            seatPrepare.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156083658")) {
            ipChange.ipc$dispatch("-1156083658", new Object[]{this});
            return;
        }
        dismissPriceDetailFragmentQuick();
        this.mIsProjectDetailSkuBean = false;
        super.onPause();
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168931473")) {
            ipChange.ipc$dispatch("168931473", new Object[]{this});
            return;
        }
        super.onResume();
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.mActivity, null, null, null);
        this.page = responseErrorPage;
        responseErrorPage.mTitleView.setVisibility(8);
        this.page.setRefreshListener(new k());
        this.page.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mErrorView.addView(this.page);
        if (this.mSelectedPrice != null && this.mSelectedPerform != null && !this.mIsProjectDetailSkuBean && !ih1.B) {
            requestSku();
        }
        if (ih1.B) {
            ih1.B = false;
        }
        this.mSeatDoor.d(true);
    }

    public void requestSku() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182505007")) {
            ipChange.ipc$dispatch("182505007", new Object[]{this});
            return;
        }
        startProgressDialog();
        this.mIsProjectDetailSkuBean = false;
        this.mSelectedPrice = null;
        this.mSelectedPerform = null;
        ih1 ih1 = this.mSkuPriceView;
        if (ih1 != null) {
            ih1.u(8);
        }
        resetBottom();
        SkuRequest skuRequest = this.mSkuRequest;
        skuRequest.itemId = this.mItemId + "";
        SkuItem skuItem = this.mSkuRequest.exParams;
        skuItem.dataId = this.mDataId;
        skuItem.dataType = this.mDataType;
        if (!TextUtils.isEmpty(this.mPrivilegeId) && !"0".equals(this.mPrivilegeId)) {
            this.mSkuRequest.exParams.privilegeActId = this.mPrivilegeId;
        }
        this.mModel.skuRequest(this.mSkuRequest);
    }

    public void showYoukuDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865855801")) {
            ipChange.ipc$dispatch("865855801", new Object[]{this});
        } else if (this.mIsShowYK && !ub2.b(this.mItemId)) {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(getContext());
            dMThemeDialog.o("优酷会员免费看").r(DMThemeDialog.DMDialogTheme.THEME_YOUKU_LIVE).k("优酷会员可免费观看无需购票\n非优酷会员用户请继续选购").i("知道了", new d()).g(false, null);
            dMThemeDialog.show();
            ub2.e(this.mItemId);
            wb2.i().x(this.mSkuView, this.mItemId);
        }
    }

    public static NcovSkuFragment getInstance(SkuBean skuBean, long j2, String str, String str2, boolean z, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162855254")) {
            return (NcovSkuFragment) ipChange.ipc$dispatch("162855254", new Object[]{skuBean, Long.valueOf(j2), str, str2, Boolean.valueOf(z), bundle});
        }
        NcovSkuFragment ncovSkuFragment = new NcovSkuFragment();
        Bundle bundle2 = new Bundle();
        if (skuBean != null) {
            bundle2.putSerializable(KEY_SKU_BEAN, skuBean);
        }
        bundle2.putLong("item_id", j2);
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString(KEY_PRIVILEGE_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle2.putString(NcovSkuActivity.KEY_ATOMSPLIT, str2);
        }
        bundle2.putBoolean(NcovSkuActivity.KEY_ISSHOWYK, z);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        ncovSkuFragment.setArguments(bundle2);
        return ncovSkuFragment;
    }
}
