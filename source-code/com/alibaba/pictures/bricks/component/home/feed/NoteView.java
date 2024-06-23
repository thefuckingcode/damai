package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.uikit.tag.DMCommonTagView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.Label;
import com.alibaba.pictures.bricks.bean.NoteBean;
import com.alibaba.pictures.bricks.bean.PerformFilmVipDO;
import com.alibaba.pictures.bricks.bean.ProjectInNote;
import com.alibaba.pictures.bricks.bean.PublishUser;
import com.alibaba.pictures.bricks.bean.VideoInfo;
import com.alibaba.pictures.bricks.component.home.feed.NoteContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.BricksStrokeLinearLayout;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.GifCareImageView;
import com.alibaba.pictures.bricks.view.HWRatioLayout;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.utils.WXUtils;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ft0;
import tb.k21;
import tb.l42;
import tb.m40;
import tb.oj1;
import tb.pj1;
import tb.qv2;
import tb.u50;
import tb.vc;

/* compiled from: Taobao */
public final class NoteView extends AbsView<GenericItem<ItemValue>, NoteModel, NotePresent> implements NoteContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final b Companion = new b(null);
    @NotNull
    public static final String LABEL_TYPE_ACHIEVEMENT = "ACHIEVEMENT";
    @NotNull
    public static final String LABEL_TYPE_DNA = "DNA";
    @NotNull
    public static final String LABEL_TYPE_RELATION = "RELATION";
    private int cornerRadius;
    private int highLightPadding;
    private int highLightStrokeWidth;
    @Nullable
    private final ImageView imDna;
    @NotNull
    private final View itemView;
    @NotNull
    private final LinearLayout llDna;
    @Nullable
    private final View mBottomUi;
    @NotNull
    private final TextView mCommenText;
    @NotNull
    private final RoundImageView mHead;
    @Nullable
    private NoteItemClickListener<NoteBean> mListener = new a(this);
    @NotNull
    private final TextView mPlayTimetv;
    @NotNull
    private final ImageView mS1FeatureV;
    @NotNull
    private final HWRatioLayout mS1HwLayout;
    @NotNull
    private final GifCareImageView mS1PicImg;
    @NotNull
    private final TextView mS1TitleTv;
    @NotNull
    private final TextView mS2TextTv;
    @NotNull
    private final View mS2TextUi;
    @Nullable
    private final BricksStrokeLinearLayout mStrokeLinearLayout;
    @NotNull
    private final TextView mUserNameTv;
    @NotNull
    private final View mVideoIcon;
    @NotNull
    private View mVideoIconOld;
    @NotNull
    private final TextView mWatchCountIcon;
    @NotNull
    private final TextView mWatchCountTv;
    @NotNull
    private final View mWatchCountUi;
    private int pos;
    @NotNull
    private final ViewGroup tagsParent;
    @Nullable
    private NoteBean temp;
    @NotNull
    private final DMDigitTextView tvDnaSimilarity;

    /* compiled from: Taobao */
    public static final class a implements NoteItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ NoteView a;

        a(NoteView noteView) {
            this.a = noteView;
        }

        /* renamed from: a */
        public void onDnaClick(@Nullable NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "775137215")) {
                ipChange.ipc$dispatch("775137215", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (noteBean != null) {
                ((NotePresent) this.a.getPresenter()).dnaClick(noteBean);
            }
        }

        /* renamed from: b */
        public void onEditClick(@Nullable NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-723285830")) {
                ipChange.ipc$dispatch("-723285830", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (noteBean != null) {
                ((NotePresent) this.a.getPresenter()).projectClick(noteBean);
            }
        }

        /* renamed from: c */
        public void onItemClick(@Nullable NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "704205635")) {
                ipChange.ipc$dispatch("704205635", new Object[]{this, noteBean, Integer.valueOf(i)});
            } else if (noteBean != null) {
                ((NotePresent) this.a.getPresenter()).itemClick(noteBean);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteView(@NotNull View view) {
        super(view);
        k21.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.note_s1_img);
        k21.h(findViewById, "itemView.findViewById(R.id.note_s1_img)");
        this.mS1PicImg = (GifCareImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.note_s1_title);
        k21.h(findViewById2, "itemView.findViewById(R.id.note_s1_title)");
        this.mS1TitleTv = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.note_s1_hw_layout);
        k21.h(findViewById3, "itemView.findViewById(R.id.note_s1_hw_layout)");
        this.mS1HwLayout = (HWRatioLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.note_si_feature);
        k21.h(findViewById4, "itemView.findViewById(R.id.note_si_feature)");
        this.mS1FeatureV = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(R$id.note_s2_ui);
        k21.h(findViewById5, "itemView.findViewById(R.id.note_s2_ui)");
        this.mS2TextUi = findViewById5;
        View findViewById6 = view.findViewById(R$id.note_s2_text);
        k21.h(findViewById6, "itemView.findViewById(R.id.note_s2_text)");
        this.mS2TextTv = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R$id.user_head);
        k21.h(findViewById7, "itemView.findViewById(R.id.user_head)");
        this.mHead = (RoundImageView) findViewById7;
        View findViewById8 = view.findViewById(R$id.user_name);
        k21.h(findViewById8, "itemView.findViewById(R.id.user_name)");
        this.mUserNameTv = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R$id.watch_count);
        k21.h(findViewById9, "itemView.findViewById(R.id.watch_count)");
        this.mWatchCountTv = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R$id.watch_count_icon);
        k21.h(findViewById10, "itemView.findViewById(R.id.watch_count_icon)");
        this.mWatchCountIcon = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R$id.new_common_text);
        k21.h(findViewById11, "itemView.findViewById(R.id.new_common_text)");
        this.mCommenText = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R$id.watch_count_ui);
        k21.h(findViewById12, "itemView.findViewById(R.id.watch_count_ui)");
        this.mWatchCountUi = findViewById12;
        View findViewById13 = view.findViewById(R$id.video_icon);
        k21.h(findViewById13, "itemView.findViewById(R.id.video_icon)");
        this.mVideoIcon = findViewById13;
        View findViewById14 = view.findViewById(R$id.video_icon_old);
        k21.h(findViewById14, "itemView.findViewById(R.id.video_icon_old)");
        this.mVideoIconOld = findViewById14;
        View findViewById15 = view.findViewById(R$id.icon_play_mini_tv);
        k21.h(findViewById15, "itemView.findViewById(R.id.icon_play_mini_tv)");
        this.mPlayTimetv = (TextView) findViewById15;
        this.mBottomUi = view.findViewById(R$id.bottom_layout);
        this.mStrokeLinearLayout = (BricksStrokeLinearLayout) view.findViewById(R$id.note_stroke_layout);
        View findViewById16 = view.findViewById(R$id.ll_dna);
        k21.h(findViewById16, "itemView.findViewById(R.id.ll_dna)");
        this.llDna = (LinearLayout) findViewById16;
        this.imDna = (ImageView) view.findViewById(R$id.iv_dna_pic);
        View findViewById17 = view.findViewById(R$id.tv_dna_similarity);
        k21.h(findViewById17, "itemView.findViewById(R.id.tv_dna_similarity)");
        this.tvDnaSimilarity = (DMDigitTextView) findViewById17;
        View findViewById18 = view.findViewById(R$id.market_tag_container);
        k21.h(findViewById18, "itemView.findViewById(R.id.market_tag_container)");
        this.tagsParent = (ViewGroup) findViewById18;
        u50 u50 = u50.INSTANCE;
        Context context = view.getContext();
        k21.h(context, "itemView.context");
        this.cornerRadius = u50.a(context, 6.0f);
        Context context2 = view.getContext();
        k21.h(context2, "itemView.context");
        this.highLightPadding = u50.a(context2, 3.0f);
        Context context3 = view.getContext();
        k21.h(context3, "itemView.context");
        this.highLightStrokeWidth = u50.a(context3, 3.0f);
    }

    private final void bindProjectInfo(NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "155199751")) {
            ipChange.ipc$dispatch("155199751", new Object[]{this, noteBean});
            return;
        }
        if ((noteBean != null ? noteBean.project : null) == null) {
            this.itemView.findViewById(R$id.ll_card_note_proj).setVisibility(8);
            this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(8);
            return;
        }
        ProjectInNote projectInNote = noteBean.project;
        if (projectInNote != null) {
            View view = this.itemView;
            int i = R$id.ll_card_note_proj;
            View findViewById = view.findViewById(i);
            if (!TextUtils.isEmpty(noteBean.project.name)) {
                k21.h(findViewById, "projectView");
                ((NotePresent) getPresenter()).projectExpose(noteBean, findViewById);
                findViewById.setVisibility(0);
                this.itemView.findViewById(i).setOnClickListener(new oj1(this));
                int i2 = R$drawable.bricks_uikit_default_image_bg_gradient;
                ImageLoaderProviderProxy.loadinto(projectInNote.verticalPic, (ImageView) this.itemView.findViewById(R$id.ll_card_note_proj_img), i2, i2);
                View findViewById2 = this.itemView.findViewById(R$id.ll_card_note_proj_name);
                k21.g(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) findViewById2).setText(projectInNote.name);
                this.tagsParent.removeAllViews();
                this.tagsParent.setVisibility(8);
                if (TextUtils.isEmpty(projectInNote.priceLow)) {
                    this.itemView.findViewById(R$id.dfp_price_prefix).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price_postfix).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price).setVisibility(8);
                    this.itemView.findViewById(R$id.dfp_price_pending).setVisibility(0);
                } else {
                    this.itemView.findViewById(R$id.dfp_price_prefix).setVisibility(0);
                    this.itemView.findViewById(R$id.dfp_price_postfix).setVisibility(0);
                    View view2 = this.itemView;
                    int i3 = R$id.dfp_price;
                    view2.findViewById(i3).setVisibility(0);
                    View findViewById3 = this.itemView.findViewById(i3);
                    k21.g(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) findViewById3).setText(projectInNote.priceLow);
                    this.itemView.findViewById(R$id.dfp_price_pending).setVisibility(8);
                    MarketTagBean gotTopTag = projectInNote.gotTopTag(true);
                    if (gotTopTag == null || TextUtils.isEmpty(gotTopTag.shortTag)) {
                        this.tagsParent.setVisibility(8);
                    } else {
                        this.tagsParent.setVisibility(0);
                        DMCommonTagView addMarketTagView = gotTopTag.addMarketTagView(this.tagsParent, true);
                        addMarketTagView.setHasPandding(false);
                        if (addMarketTagView.getTagView() != null) {
                            addMarketTagView.getTagView().setTextSize(1, 8.0f);
                            ViewGroup.LayoutParams layoutParams = addMarketTagView.getTagView().getLayoutParams();
                            u50 u50 = u50.INSTANCE;
                            Context context = this.tagsParent.getContext();
                            k21.h(context, "tagsParent.context");
                            layoutParams.height = u50.b(context, 12);
                        }
                    }
                }
                if (!TextUtils.isEmpty(projectInNote.itemScore)) {
                    View view3 = this.itemView;
                    int i4 = R$id.ll_card_note_proj_score;
                    view3.findViewById(i4).setVisibility(0);
                    View findViewById4 = this.itemView.findViewById(i4);
                    k21.g(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) findViewById4).setText(projectInNote.itemScore);
                } else {
                    this.itemView.findViewById(R$id.ll_card_note_proj_score).setVisibility(8);
                }
            } else {
                this.itemView.findViewById(i).setVisibility(8);
            }
            if (noteBean.project.attractiveLabel == null || TextUtils.isEmpty(projectInNote.attractiveLabel.title)) {
                this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(8);
                return;
            }
            this.itemView.findViewById(R$id.note_card_bottom_ll).setVisibility(0);
            if (TextUtils.isEmpty(projectInNote.attractiveLabel.icon)) {
                View findViewById5 = this.itemView.findViewById(R$id.note_card_bottom_icon);
                k21.g(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) findViewById5).setImageResource(R$drawable.bricks_home_card_note_tipicon);
            } else {
                ImageLoaderProviderProxy.loadinto(projectInNote.attractiveLabel.icon, (ImageView) this.itemView.findViewById(R$id.note_card_bottom_icon));
            }
            View findViewById6 = this.itemView.findViewById(R$id.note_card_bottom_desc);
            k21.g(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById6).setText(projectInNote.attractiveLabel.title);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindProjectInfo$lambda-1  reason: not valid java name */
    public static final void m120bindProjectInfo$lambda1(NoteView noteView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1070587251")) {
            ipChange.ipc$dispatch("1070587251", new Object[]{noteView, view});
            return;
        }
        k21.i(noteView, "this$0");
        NoteItemClickListener<NoteBean> noteItemClickListener = noteView.mListener;
        if (noteItemClickListener != null && noteView.temp != null) {
            k21.f(noteItemClickListener);
            noteItemClickListener.onEditClick(noteView.temp, noteView.pos);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m121bindView$lambda0(NoteView noteView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707846858")) {
            ipChange.ipc$dispatch("-707846858", new Object[]{noteView, view});
            return;
        }
        k21.i(noteView, "this$0");
        NoteItemClickListener<NoteBean> noteItemClickListener = noteView.mListener;
        k21.f(noteItemClickListener);
        noteItemClickListener.onItemClick(noteView.temp, noteView.pos);
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.NoteContract.View
    public void bindView(@NotNull NoteBean noteBean) {
        int i;
        int i2;
        int i3;
        PerformFilmVipDO performFilmVipDO;
        Label label;
        ft0 ft0;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1718782525")) {
            ipChange.ipc$dispatch("-1718782525", new Object[]{this, noteBean});
            return;
        }
        k21.i(noteBean, "bean");
        this.temp = noteBean;
        boolean z = noteBean.highLight;
        this.itemView.setOnClickListener(new pj1(this));
        int i4 = -1;
        if (z) {
            i3 = Color.parseColor("#66FFFFFF");
            int parseColor = Color.parseColor("#99FFFFFF");
            View view = this.mBottomUi;
            k21.f(view);
            view.setBackgroundResource(R$drawable.bricks_bg_note_high_light);
            BricksStrokeLinearLayout bricksStrokeLinearLayout = this.mStrokeLinearLayout;
            k21.f(bricksStrokeLinearLayout);
            int i5 = this.highLightPadding;
            bricksStrokeLinearLayout.setPadding(i5, i5, i5, i5);
            this.mStrokeLinearLayout.setCornerAndStroke(this.cornerRadius, this.highLightStrokeWidth, new int[]{Color.parseColor("#FF4E6E"), Color.parseColor("#FF833C")});
            i = parseColor;
            i2 = -1;
        } else {
            View view2 = this.mBottomUi;
            k21.f(view2);
            view2.setBackgroundResource(R$drawable.bricks_bg_note_none_hight_light);
            BricksStrokeLinearLayout bricksStrokeLinearLayout2 = this.mStrokeLinearLayout;
            k21.f(bricksStrokeLinearLayout2);
            bricksStrokeLinearLayout2.setPadding(0, 0, 0, 0);
            this.mStrokeLinearLayout.setCornerAndStroke(this.cornerRadius, 1, Color.parseColor("#0D000000"));
            i4 = -16777216;
            int parseColor2 = Color.parseColor("#666666");
            int parseColor3 = Color.parseColor("#663C3F44");
            i = Color.parseColor("#9C9CA5");
            i2 = parseColor2;
            i3 = parseColor3;
        }
        this.mS1TitleTv.setTextColor(i4);
        this.mUserNameTv.setTextColor(i2);
        this.mWatchCountTv.setTextColor(i);
        this.mWatchCountIcon.setTextColor(i3);
        boolean isShowVideoIcon = noteBean.isShowVideoIcon();
        if (isShowVideoIcon) {
            VideoInfo videoInfo = noteBean.videoInfo;
            if (videoInfo == null || TextUtils.isEmpty(videoInfo.formatVideoTime())) {
                this.mVideoIcon.setVisibility(8);
                this.mVideoIconOld.setVisibility(0);
            } else {
                this.mVideoIcon.setVisibility(0);
                this.mVideoIconOld.setVisibility(8);
                this.mPlayTimetv.setText(noteBean.videoInfo.formatVideoTime());
            }
        } else {
            this.mVideoIconOld.setVisibility(8);
            this.mVideoIcon.setVisibility(8);
        }
        boolean isHasVideoUnderReviewStatus = noteBean.isHasVideoUnderReviewStatus();
        if (noteBean.isPicNote() || isShowVideoIcon || isHasVideoUnderReviewStatus) {
            this.mS2TextUi.setVisibility(8);
            this.mS1HwLayout.setVisibility(0);
            this.mS1TitleTv.setVisibility(0);
            this.mS1TitleTv.setText(noteBean.content);
            float f = noteBean.hwRatio;
            if (f > 0.0f) {
                this.mS1HwLayout.setHwRatio(f);
            } else {
                this.mS1HwLayout.setHwRatio(1.0f);
            }
            String str = noteBean.pic;
            if (isShowVideoIcon) {
                str = noteBean.getVideoCoverUrl();
            }
            if (isHasVideoUnderReviewStatus) {
                this.mS1PicImg.setImageDrawable(new qv2());
            } else {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        Context context = this.itemView.getContext();
                        int a2 = (int) (((((float) DisplayMetrics.getwidthPixels(l42.b(context))) / 2.0f) - ((float) l42.a(context, 15.0f))) * 1.33f);
                        if (a2 > 800) {
                            a2 = 800;
                        }
                        str = com.alibaba.pictures.bricks.util.a.c(str, a2, a2);
                        if (AppInfoProviderProxy.isDebuggable()) {
                            vc vcVar = vc.INSTANCE;
                            vc.b(vcVar, "ImWidth = " + a2 + " Note Url = " + str, null, 2, null);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                GifCareImageView gifCareImageView = this.mS1PicImg;
                int i6 = R$drawable.bricks_uikit_default_image_bg_gradient;
                ImageLoaderProviderProxy.loadinto(str, gifCareImageView, i6, i6);
            }
        } else {
            this.mS2TextUi.setVisibility(0);
            this.mS1HwLayout.setVisibility(8);
            this.mS1TitleTv.setVisibility(8);
            int i7 = noteBean.colorIndex;
            if (i7 < 0) {
                ft0 = new ft0();
                noteBean.colorIndex = ft0.a();
            } else {
                ft0 = new ft0(i7);
            }
            GradientDrawable c = ft0.c(GradientDrawable.Orientation.TL_BR);
            k21.h(c, "helper.getTheme(Gradient…awable.Orientation.TL_BR)");
            if (Build.VERSION.SDK_INT >= 16) {
                this.mS2TextUi.setBackground(c);
            } else {
                this.mS2TextUi.setBackgroundDrawable(c);
            }
            this.mS2TextTv.setText(noteBean.content);
        }
        if (noteBean.containsStrategy()) {
            this.mS1FeatureV.setVisibility(0);
            this.mS1FeatureV.setImageResource(R$drawable.bricks_feed_note_card_stragety);
        } else if (noteBean.isFeature()) {
            this.mS1FeatureV.setVisibility(0);
            this.mS1FeatureV.setImageResource(R$drawable.bricks_feed_note_card_stragety);
        } else {
            this.mS1FeatureV.setVisibility(8);
        }
        PublishUser publishUser = noteBean.publishUser;
        if (publishUser != null && !TextUtils.isEmpty(publishUser.nickname)) {
            noteBean.nickname = noteBean.publishUser.nickname;
        }
        PublishUser publishUser2 = noteBean.publishUser;
        if (publishUser2 != null && !TextUtils.isEmpty(publishUser2.headImg)) {
            noteBean.headImg = noteBean.publishUser.headImg;
        }
        this.mUserNameTv.setText(noteBean.nickname);
        PublishUser publishUser3 = noteBean.publishUser;
        if (publishUser3 == null || (label = publishUser3.label) == null) {
            if (TextUtils.isEmpty(noteBean.ipvuv)) {
                this.mWatchCountUi.setVisibility(8);
                if (TextUtils.isEmpty(noteBean.similarity)) {
                    this.llDna.setVisibility(8);
                } else {
                    this.llDna.setVisibility(0);
                    this.tvDnaSimilarity.setText(noteBean.similarity + WXUtils.PERCENT);
                    ImageView imageView = this.imDna;
                    k21.f(imageView);
                    imageView.setImageResource(R$drawable.bricks_icon_discover_content_detail_dna_mini);
                }
            } else {
                this.mWatchCountUi.setVisibility(0);
                this.mWatchCountTv.setText(noteBean.ipvuv);
                this.llDna.setVisibility(8);
            }
        } else if ("RELATION".equals(label.labelType)) {
            this.mWatchCountUi.setVisibility(8);
            this.llDna.setVisibility(8);
            this.mCommenText.setVisibility(0);
            this.mCommenText.setText(noteBean.publishUser.label.labelTitle);
            this.mCommenText.setTextColor(Color.parseColor("#9C9CA5"));
        } else if ("ACHIEVEMENT".equals(noteBean.publishUser.label.labelType)) {
            this.llDna.setVisibility(0);
            this.mWatchCountUi.setVisibility(8);
            this.mCommenText.setVisibility(8);
            this.tvDnaSimilarity.setText(noteBean.publishUser.label.labelTitle);
            this.tvDnaSimilarity.setTextColor(Color.parseColor("#FF903C"));
            ImageView imageView2 = this.imDna;
            k21.f(imageView2);
            imageView2.setImageResource(R$drawable.bricks_card_note_tag_pub);
        } else if ("DNA".equals(noteBean.publishUser.label.labelType)) {
            this.llDna.setVisibility(0);
            this.mWatchCountUi.setVisibility(8);
            this.mCommenText.setVisibility(8);
            String str2 = noteBean.publishUser.label.labelTitle;
            DMDigitTextView dMDigitTextView = this.tvDnaSimilarity;
            dMDigitTextView.setText(str2 + WXUtils.PERCENT);
            this.tvDnaSimilarity.setTextColor(Color.parseColor("#af8cfc"));
            ImageView imageView3 = this.imDna;
            k21.f(imageView3);
            imageView3.setImageResource(R$drawable.bricks_icon_discover_content_detail_dna_mini);
        }
        this.mHead.setBorder(1, Color.parseColor("#1A000000"));
        String str3 = noteBean.headImg;
        RoundImageView roundImageView = this.mHead;
        int i8 = R$drawable.bricks_uikit_account_place_holder_default;
        ImageLoaderProviderProxy.loadinto(str3, roundImageView, i8, i8);
        PublishUser publishUser4 = noteBean.publishUser;
        if (publishUser4 == null || (performFilmVipDO = publishUser4.performFilmVipDO) == null || TextUtils.isEmpty(performFilmVipDO.memberFlag)) {
            ((ImageView) this.itemView.findViewById(R$id.user_head_tag)).setVisibility(8);
        } else {
            String str4 = noteBean.publishUser.performFilmVipDO.memberFlag;
            ImageView imageView4 = (ImageView) this.itemView.findViewById(R$id.user_head_tag);
            if (k21.d("1", str4)) {
                imageView4.setVisibility(0);
                imageView4.setImageResource(R$drawable.bricks_dm_yy_member_icon);
            } else if (k21.d("10", str4)) {
                imageView4.setVisibility(0);
                imageView4.setImageResource(R$drawable.bricks_dm_yy_black_member_icon);
            } else {
                imageView4.setVisibility(8);
            }
        }
        this.itemView.setTag(noteBean);
        if (this.llDna.getVisibility() == 0) {
            ((NotePresent) getPresenter()).exposeDna(this.itemView);
        }
        bindProjectInfo(noteBean);
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2087302821")) {
            return this.itemView;
        }
        return (View) ipChange.ipc$dispatch("-2087302821", new Object[]{this});
    }

    public final int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "111362520")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("111362520", new Object[]{this})).intValue();
    }

    @Nullable
    public final NoteBean getTemp() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1889891825")) {
            return this.temp;
        }
        return (NoteBean) ipChange.ipc$dispatch("1889891825", new Object[]{this});
    }

    public final void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094105906")) {
            ipChange.ipc$dispatch("1094105906", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public final void setTemp(@Nullable NoteBean noteBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1369870963")) {
            ipChange.ipc$dispatch("1369870963", new Object[]{this, noteBean});
            return;
        }
        this.temp = noteBean;
    }
}
