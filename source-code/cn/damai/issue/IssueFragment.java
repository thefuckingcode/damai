package cn.damai.issue;

import android.animation.Animator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.standardmodal.WVStandardEventCenter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.damai.comment.R$anim;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.comment.bean.QueryThemeResultBean;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.comment.view.DMCommentSubItemView;
import cn.damai.comment.view.OnItemClickListener;
import cn.damai.comment.view.OnTipsSelectedListener;
import cn.damai.comment.view.PublishDMSelectView;
import cn.damai.comment.view.PublishInputTipsView;
import cn.damai.common.AppConfig;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.image.luban.Luban;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.uploader.AusResult;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.evaluate.request.EvaluateSuccessRenderRequest;
import cn.damai.evaluate.ui.EvaluateSuccessActivity;
import cn.damai.issue.bean.DraftBean;
import cn.damai.issue.bean.DraftExtra;
import cn.damai.issue.bean.DraftMd5NameAssembler;
import cn.damai.issue.listener.OnCheckDraftListener;
import cn.damai.issue.listener.OnDialogListener;
import cn.damai.issue.net.CommentGradeTagBean;
import cn.damai.issue.net.EvaluteSuccessRenderResponse;
import cn.damai.issue.net.IssueLiveDataResponse;
import cn.damai.issue.net.IssueRenderLiveDataResponse;
import cn.damai.issue.net.IssueRenderResponse;
import cn.damai.issue.net.IssueResponse;
import cn.damai.issue.tool.IDraftContentProvider;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.issue.tool.draft.DraftBox;
import cn.damai.issue.tool.draft.DraftEmptyBox;
import cn.damai.issue.tool.draft.IDraftBox;
import cn.damai.issue.view.CorrelationType;
import cn.damai.issue.view.CorrelationView;
import cn.damai.issue.view.DMLinearLayoutIssue;
import cn.damai.issue.view.DMSortableNinePhotoLayout;
import cn.damai.issue.view.SpoilerSwitchView;
import cn.damai.login.LoginManager;
import cn.damai.model.IssueViewModel;
import cn.damai.network.NetworkType;
import cn.damai.tetris.component.brand.bean.ProjectDO;
import cn.damai.uikit.banner.sub.RoundRadiusImageView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.BottomActionDialog;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.MyScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.selector.bean.ScriptSelectMo;
import com.alibaba.pictures.bricks.view.DMRatingBar;
import com.alibaba.pictures.uploader.FileUploadListener;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tb.br;
import tb.c01;
import tb.c62;
import tb.d20;
import tb.ek;
import tb.f4;
import tb.g01;
import tb.g91;
import tb.h03;
import tb.hp1;
import tb.jk;
import tb.jl1;
import tb.lp1;
import tb.nv2;
import tb.ol1;
import tb.p21;
import tb.pn;
import tb.r21;
import tb.re0;
import tb.s40;
import tb.s41;
import tb.ss2;
import tb.v50;
import tb.xf2;
import tb.xh1;
import tb.xs0;
import tb.yb0;
import tb.yh1;
import tb.yz2;

/* compiled from: Taobao */
public class IssueFragment extends DamaiBaseMvpFragment implements DMCommentSubItemView.GradeChangeLister, IDraftContentProvider {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_COVER_VEDIO = 1003;
    private static final int REQUEST_CODE_LOGIN = 1000;
    private static final int REQUEST_CODE_PREVIEW_VEDIO = 1002;
    private static final int REQUEST_CODE_SELECT_ALBUM = 17;
    private static final int REQUEST_CODE_SELECT_VEDIO = 1001;
    private static final int REQUEST_CODE_SHARE = 104;
    private static final int REQUEST_CODE_TAKE_PHOTO = 102;
    private static final int REQUEST_CODE_TO_IDOL = 101;
    public static final int REQUEST_CORRELATION_PROJECT = 105;
    private static final int REQUEST_PRIVILEGE_PROJECT = 103;
    private static final int VEDIO_MAX_COUNT = 1;
    private View associatedHolder;
    private RelativeLayout associatedLayout;
    private DMIconFontTextView associatedProjectArrow;
    private RoundRadiusImageView associatedProjectImage;
    private TextView associatedProjectName;
    private TextView associatedProjectTimeAddress;
    private TextView associatedProjectTip;
    private TextView associatedTipHint;
    private ConstraintLayout clCircleLayout;
    private CorrelationView correlationView;
    private Bitmap coverBitmap;
    String coverPath = "";
    private PublishDMSelectView dmSelectView;
    Observer<CommentsResultBean> evaluateDetailObserver;
    private LottieAnimationView fullStarLottie;
    private ImageView giftIntroduce;
    private TextView gradeTip;
    private LinearLayout guideAnimLayout;
    private LottieAnimationView guideLottie;
    private View holder_view;
    private PublishInputTipsView inputTipsView;
    private boolean isDelay = false;
    private IssueCircleSelect issueCircleSelect;
    Observer<IssueLiveDataResponse> issueObserver;
    Observer<IssueRenderLiveDataResponse> issueRenderResponseObserver;
    IssueViewModel issueViewModel;
    private DMLinearLayoutIssue issue_window_layout;
    private DMIconFontTextView ivCircleScreen;
    private ConstraintLayout llThemeLayout;
    private FileUploadListener mCoverUpdateListener = new l();
    private FileUploadListener mCoverUploadListener = new k();
    private FileUploader mCoverUploader;
    private DMRatingBar mDMRatingBar;
    private IDraftBox mDraftBox;
    private ArrayList<String> mEditAddImages = new ArrayList<>();
    private ArrayList<Image> mEditAddSelectImages = new ArrayList<>();
    private EditText mEditor;
    private int mEditorLimit = 10000;
    private TextView mEditorLimitTip;
    private TextView mEvaGift;
    private RelativeLayout mEvaluateLayout;
    private String mFilePath;
    private int mImagesPublishCount;
    private ArrayList<ss2> mImagesSelectData = new ArrayList<>();
    private int mIsRequestLoading = 0;
    private boolean mIsUploadImageFailure;
    private TextView mIssueEvaluateTip;
    private DMIconFontTextView mIssueTitleCancel;
    private TextView mIssueTitleConfirm;
    private TextView mIssueTitlecontent;
    private View.OnClickListener mOnClickListener = new f();
    private DMSortableNinePhotoLayout.OnSortListener mOnSortListener = new d();
    private DMRatingBar.OnStarChangeListener mOnStarChangeListener = new DMRatingBar.OnStarChangeListener() {
        /* class cn.damai.issue.IssueFragment.AnonymousClass10 */
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.issue.IssueFragment$10$a */
        /* compiled from: Taobao */
        public class a implements Animator.AnimatorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            public void onAnimationCancel(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "685345202")) {
                    ipChange.ipc$dispatch("685345202", new Object[]{this, animator});
                    return;
                }
                re0.f().m(IssueFragment.this.mDMRatingBar);
                re0.f().k(IssueFragment.this.fullStarLottie);
            }

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-783720771")) {
                    ipChange.ipc$dispatch("-783720771", new Object[]{this, animator});
                    return;
                }
                re0.f().m(IssueFragment.this.mDMRatingBar);
                re0.f().k(IssueFragment.this.fullStarLottie);
            }

            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1296046479")) {
                    ipChange.ipc$dispatch("-1296046479", new Object[]{this, animator});
                }
            }

            public void onAnimationStart(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1314181334")) {
                    ipChange.ipc$dispatch("1314181334", new Object[]{this, animator});
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onEventActionUp() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-457994634")) {
                ipChange.ipc$dispatch("-457994634", new Object[]{this});
                return;
            }
            if (!IssueFragment.this.issueViewModel.isPrivilege()) {
                IssueFragment.this.gradeTip();
            }
            if (IssueFragment.this.issueViewModel.getmGrades() == 10 && !"1".equals(IssueFragment.this.issueViewModel.getItemType())) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) IssueFragment.this.fullStarLottie.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = v50.a(IssueFragment.this.getContext(), 33.0f) - v50.a(IssueFragment.this.getContext(), 0.4f);
                ((ViewGroup.MarginLayoutParams) layoutParams).width = v50.a(IssueFragment.this.getContext(), 168.0f) - v50.a(IssueFragment.this.getContext(), 0.3f);
                re0.f().l(IssueFragment.this.mDMRatingBar);
                re0.f().m(IssueFragment.this.fullStarLottie);
                IssueFragment.this.fullStarLottie.playAnimation();
                if (Build.VERSION.SDK_INT >= 11) {
                    IssueFragment.this.fullStarLottie.addAnimatorListener(new a());
                }
            }
        }

        @Override // com.alibaba.pictures.bricks.view.DMRatingBar.OnStarChangeListener
        public void onStarChange(float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1943223143")) {
                ipChange.ipc$dispatch("-1943223143", new Object[]{this, Float.valueOf(f)});
                return;
            }
            SoftInputUtils.a(IssueFragment.this.getActivity());
            re0.f().m(IssueFragment.this.mDMRatingBar);
            re0.f().k(IssueFragment.this.fullStarLottie);
            g91.b("IssueActivity", "点击总评分 分评分无或者已经显示");
            IssueFragment.this.issueViewModel.setmGrades((int) (f * 2.0f));
            IssueFragment issueFragment = IssueFragment.this;
            issueFragment.gradesDesc(jk.a((float) issueFragment.issueViewModel.getmGrades()));
            if (IssueFragment.this.mSumItemBar == null || IssueFragment.this.mSumItemBar.getChildCount() <= 0 || IssueFragment.this.mSumItemBar.getVisibility() != 8 || IssueFragment.this.isDelay) {
                IssueFragment.this.updateIssueButtonStatus();
                return;
            }
            g91.b("IssueActivity", "点击总评分0");
            IssueFragment.this.isDelay = true;
            new Handler().postDelayed(new Runnable() {
                /* class cn.damai.issue.IssueFragment.AnonymousClass10.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "919967082")) {
                        ipChange.ipc$dispatch("919967082", new Object[]{this});
                        return;
                    }
                    IssueFragment issueFragment = IssueFragment.this;
                    issueFragment.issueViewModel.animateToggle(issueFragment.mSumItemBar, IssueFragment.this.viewHeight);
                    re0.f().m(IssueFragment.this.mSumItemBar);
                    IssueFragment.this.updateIssueButtonStatus();
                    g91.b("IssueActivity", "点击总评分1");
                }
            }, 50);
        }
    };
    private TextWatcher mOnTextChangedListener = new p();
    private ArrayList<String> mPaths = new ArrayList<>();
    private TextView mRatingBarDesc;
    private DMSortableNinePhotoLayout mShowNiePhoto;
    DMSortableNinePhotoLayout.OnNinePhotoClickListener mShowPhotoListener = new c();
    private FileUploadListener mSubmitFilesListener = new j();
    private FileUploader mSubmitUploader;
    private LinearLayout mSumItemBar;
    private TextView mTeachGoodEvaluate;
    private DraftExtra mTempDraftExtra;
    FileUploader mVideoUploader;
    private LinearLayout.LayoutParams params;
    private String privilegeType;
    private ViewGroup.LayoutParams rootParam;
    private MyScrollView scrollView;
    boolean softShowing;
    private SpoilerSwitchView spoilerSwitchView;
    private LinearLayout submitLayout;
    private int tempBottom = 0;
    Observer<QueryThemeResultBean> themeObserver;
    private TextView tvCircleContent;
    private TextView tvThemeContent;
    private CommentsVideoBean videoBean;
    private int viewHeight;
    private int visibleWindowDisplayHeight = 0;

    /* compiled from: Taobao */
    public class a implements OnCheckDraftListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* renamed from: cn.damai.issue.IssueFragment$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0027a implements OnDialogListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ DraftBean a;

            C0027a(DraftBean draftBean) {
                this.a = draftBean;
            }

            @Override // cn.damai.issue.listener.OnDialogListener
            public void onDialogClick(DialogInterface dialogInterface, boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-192161520")) {
                    ipChange.ipc$dispatch("-192161520", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                    return;
                }
                if (z) {
                    r21.y();
                } else {
                    r21.x();
                }
                if (!z) {
                    IssueFragment.this.mDraftBox.deleteCurDraft();
                }
                IssueFragment.this.mDraftBox.startAutoDraft();
                if (z) {
                    DraftBean draftBean = this.a;
                    String str = draftBean.userInput;
                    String str2 = draftBean.themeName;
                    String str3 = draftBean.themeId;
                    List<QueryThemeCliqueInfoBean> list = draftBean.circle;
                    List<QueryThemeCliqueInfoBean> list2 = draftBean.circleList;
                    IssueFragment.this.issueViewModel.setComeFromCircle(false);
                    IssueFragment.this.issueViewModel.setComeFromTheme(false);
                    IssueFragment.this.ivCircleScreen.setVisibility(0);
                    if (!TextUtils.isEmpty(str3)) {
                        IssueFragment.this.issueViewModel.setThemeId(this.a.themeId);
                        IssueFragment.this.updateTheme(str2);
                    }
                    if (!(list2 == null || list == null)) {
                        IssueFragment.this.issueViewModel.setCircleList(list2);
                        IssueFragment.this.issueViewModel.setCircle(list.get(0));
                        IssueFragment.this.updateCircle(list2, list.get(0));
                    }
                    IssueFragment.this.issueViewModel.setStoreId(this.a.storeId);
                    IssueFragment.this.issueViewModel.setItemType(this.a.itemType);
                    if (IssueFragment.this.issueViewModel.isPrivilege()) {
                        IssueFragment.this.mEditor.setText(str);
                        DraftExtra draftExtra = this.a.mExtra;
                        if (draftExtra != null && draftExtra.isValid()) {
                            IssueFragment.this.privilegeView(true, yb0.g(this.a.mExtra), true);
                        }
                    } else if (IssueFragment.this.issueViewModel.isEvaluate()) {
                        IssueFragment.this.mEditor.setText(str);
                    } else if (IssueFragment.this.issueViewModel.isEdit()) {
                        IssueFragment.this.mEditor.setText(str);
                    }
                }
            }
        }

        a() {
        }

        @Override // cn.damai.issue.listener.OnCheckDraftListener
        public void onHasDraft(DraftBean draftBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "474658730")) {
                ipChange.ipc$dispatch("474658730", new Object[]{this, draftBean});
            } else if (IssueFragment.this.isActivityOk()) {
                FragmentActivity activity = IssueFragment.this.getActivity();
                if (AppConfig.v()) {
                    String e = s41.e(draftBean);
                    g91.c(DraftBox.TAG, "命中草稿： " + e);
                }
                yb0.e(activity, new C0027a(draftBean));
            }
        }

        @Override // cn.damai.issue.listener.OnCheckDraftListener
        public void onNoneDraft() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2046385274")) {
                ipChange.ipc$dispatch("-2046385274", new Object[]{this});
                return;
            }
            IssueFragment.this.mDraftBox.startAutoDraft();
        }
    }

    /* compiled from: Taobao */
    public class b extends s40 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ String c;

        b(long j, long j2, String str) {
            this.a = j;
            this.b = j2;
            this.c = str;
        }

        @Override // tb.s40
        public void a(@NonNull ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-935253111")) {
                ipChange.ipc$dispatch("-935253111", new Object[]{this, ss2});
                return;
            }
            IssueFragment.this.delVideo(true);
            g91.c("uploader end fail", (System.currentTimeMillis() - this.a) + "");
            yz2.g("IssueFragment" + ":jsondata={HavanaId:" + d20.i() + ",videoSize:" + cn.damai.common.image.luban.b.b(this.c) + ",apn:" + IssueFragment.this.getNetworkType() + "}", "-7300", "上传视频失败");
        }

        @Override // tb.s40
        public void b(@NonNull ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1163342416")) {
                ipChange.ipc$dispatch("-1163342416", new Object[]{this, ss2});
            } else if (IssueFragment.this.isAdded() && ss2.d() != null) {
                ITaskResult d2 = ss2.d();
                String str = null;
                if (!TextUtils.isEmpty(d2.getFileUrl())) {
                    str = d2.getFileUrl();
                } else if (d2.getResult() != null && d2.getResult().containsKey("x-arup-file-url")) {
                    str = d2.getResult().get("x-arup-file-url");
                }
                if (str == null) {
                    g91.c("uploader success,but fileUrl == null", (System.currentTimeMillis() - this.a) + "");
                    IssueFragment.this.delVideo(true);
                    return;
                }
                IssueFragment.this.videoBean = new CommentsVideoBean();
                IssueFragment.this.videoBean.setUrl(str);
                IssueFragment.this.videoBean.setVideoTime(String.valueOf(this.b));
                g91.c("uploader fileUrl", str);
                g91.c("uploader end success", (System.currentTimeMillis() - this.a) + "");
                Bitmap d3 = MediaUtils.c().d(this.c);
                IssueFragment issueFragment = IssueFragment.this;
                issueFragment.uploadVideoCover(d3, issueFragment.mCoverUploadListener, false);
            }
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onSingleTaskProgress(@NonNull ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1187534520")) {
                ipChange.ipc$dispatch("-1187534520", new Object[]{this, ss2});
                return;
            }
            int c2 = ss2.c();
            DMSortableNinePhotoLayout dMSortableNinePhotoLayout = IssueFragment.this.mShowNiePhoto;
            dMSortableNinePhotoLayout.notifyItemChanged(0, "progress:" + c2);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMSortableNinePhotoLayout.OnNinePhotoClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickAddNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2131130092")) {
                ipChange.ipc$dispatch("2131130092", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                IssueFragment.this.openAlbum();
            } else {
                IssueFragment.this.uploadingTip();
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickAddVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-577821519")) {
                ipChange.ipc$dispatch("-577821519", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
                return;
            }
            re0.j(IssueFragment.this.getActivity(), 1001, 1);
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickChangeVideoCoverItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "983835213")) {
                ipChange.ipc$dispatch("983835213", new Object[]{this, dMSortableNinePhotoLayout, Integer.valueOf(i), image, arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                c01.c(IssueFragment.this.getActivity(), 1003, true, 1, new ArrayList());
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickDeleteNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1279772218")) {
                ipChange.ipc$dispatch("1279772218", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), image, arrayList});
            } else if ("2".equals(image.getType())) {
                IssueFragment.this.videoBean = null;
                FileUploader fileUploader = IssueFragment.this.mVideoUploader;
                if (fileUploader != null) {
                    fileUploader.p();
                }
                IssueFragment.this.delVideo(false);
            } else {
                int delImagePosCorrect = IssueFragment.this.delImagePosCorrect(i);
                if (xf2.e(IssueFragment.this.mEditAddImages) > 0 && IssueFragment.this.mEditAddImages.contains(IssueFragment.this.issueViewModel.getmImages().get(delImagePosCorrect))) {
                    IssueFragment.this.mEditAddImages.remove(IssueFragment.this.issueViewModel.getmImages().get(delImagePosCorrect));
                }
                if (delImagePosCorrect < xf2.e(IssueFragment.this.issueViewModel.getmSelectImages())) {
                    IssueFragment.this.issueViewModel.getmSelectImages().get(delImagePosCorrect).setShowNum(0);
                    IssueFragment.this.issueViewModel.getmSelectImages().remove(delImagePosCorrect);
                }
                if (delImagePosCorrect < xf2.e(IssueFragment.this.issueViewModel.getmImages())) {
                    IssueFragment.this.issueViewModel.getmImages().remove(delImagePosCorrect);
                }
                if (i < IssueFragment.this.mShowNiePhoto.getItemCount()) {
                    IssueFragment.this.mShowNiePhoto.removeItem(i);
                }
                IssueFragment.this.setmEvaGiftContent();
                IssueFragment.this.updateIssueButtonStatus();
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickNinePhotoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, Image image, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2080019237")) {
                ipChange.ipc$dispatch("2080019237", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), image, arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                re0.i(IssueFragment.this.getActivity(), IssueFragment.this.delImagePosCorrect(i), false, IssueFragment.this.issueViewModel.getmSelectImages().size(), IssueFragment.this.issueViewModel.getmSelectImages(), "1", 18);
            } else {
                IssueFragment.this.uploadingTip();
            }
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnNinePhotoClickListener
        public void onClickPalyerVideoItem(DMSortableNinePhotoLayout dMSortableNinePhotoLayout, View view, int i, ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1526738343")) {
                ipChange.ipc$dispatch("-1526738343", new Object[]{this, dMSortableNinePhotoLayout, view, Integer.valueOf(i), arrayList});
            } else if (IssueFragment.this.mIsRequestLoading == 0) {
                ArrayList arrayList2 = new ArrayList();
                if (IssueFragment.this.mShowNiePhoto.getData() != null && IssueFragment.this.mShowNiePhoto.getData().size() > 0 && IssueFragment.this.mShowNiePhoto.getData().get(0) != null) {
                    Image image = new Image();
                    image.setPath(IssueFragment.this.mShowNiePhoto.getData().get(0).getPath());
                    image.setType(IssueFragment.this.mShowNiePhoto.getData().get(0).getType());
                    image.setThumbnail(IssueFragment.this.mShowNiePhoto.getData().get(0).getThumbnail());
                    arrayList2.add(image);
                    re0.i(IssueFragment.this.getActivity(), i, true, arrayList2.size(), arrayList2, "2", 1002);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements DMSortableNinePhotoLayout.OnSortListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.issue.view.DMSortableNinePhotoLayout.OnSortListener
        public void onSortComplete(ArrayList<Image> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1399640364")) {
                ipChange.ipc$dispatch("-1399640364", new Object[]{this, arrayList});
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < xf2.e(arrayList); i++) {
                String path = arrayList.get(i).getPath();
                for (int i2 = 0; i2 < xf2.e(IssueFragment.this.issueViewModel.getmSelectImages()); i2++) {
                    Image image = IssueFragment.this.issueViewModel.getmSelectImages().get(i2);
                    String path2 = image.getPath();
                    if (path.equals(path2)) {
                        arrayList2.add(image);
                        arrayList3.add(path2);
                    }
                }
            }
            IssueFragment.this.issueViewModel.getmImages().clear();
            IssueFragment.this.issueViewModel.getmSelectImages().clear();
            IssueFragment.this.issueViewModel.getmImages().addAll(arrayList3);
            IssueFragment.this.issueViewModel.getmSelectImages().addAll(arrayList2);
        }
    }

    /* compiled from: Taobao */
    public class e implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1886958527")) {
                ipChange.ipc$dispatch("-1886958527", new Object[]{this});
                return;
            }
            r21.i().q("picture_upload");
            try {
                int i = IssueFragment.this.getSelectVideo() == null ? 9 : 8;
                if (IssueFragment.this.issueViewModel.isEdit()) {
                    for (int i2 = 0; i2 < xf2.e(IssueFragment.this.issueViewModel.getmImages()); i2++) {
                        if (IssueFragment.this.issueViewModel.getmImages().get(i2).startsWith("http")) {
                            i--;
                        }
                    }
                    c01.c(IssueFragment.this.getActivity(), 17, false, i, IssueFragment.this.mEditAddImages);
                    return;
                }
                c01.c(IssueFragment.this.getActivity(), 17, false, i, IssueFragment.this.issueViewModel.getmImages());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        public class a implements OnGrantListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2082115379")) {
                    ipChange.ipc$dispatch("2082115379", new Object[]{this});
                    return;
                }
                IssueFragment.this.onIssueClicked();
            }
        }

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591961537")) {
                ipChange.ipc$dispatch("-1591961537", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id == R$id.issue_title_cancel) {
                IssueFragment.this.onBackClicked();
            } else if (id == R$id.tv_circle_tip_content || id == R$id.iv_circle_screen) {
                if (!IssueFragment.this.issueViewModel.isComeFromCircle() && IssueFragment.this.issueCircleSelect.e() > 0) {
                    IssueFragment.this.issueCircleSelect.k();
                }
            } else if (id == R$id.issue_title_confirm) {
                if (IssueFragment.this.issueViewModel.isEvaluate() || IssueFragment.this.issueViewModel.isEdit() || IssueFragment.this.issueViewModel.isPrivilege()) {
                    if (IssueFragment.this.issueViewModel.isPrivilege() && "0".equals(IssueFragment.this.issueViewModel.getmTargetId())) {
                        ToastUtil.i("请选择关联项目哦");
                        return;
                    } else if (IssueFragment.this.issueViewModel.getmGrades() == 0 || IssueFragment.this.issueViewModel.getmGrades() < 0) {
                        if ("1".equals(IssueFragment.this.issueViewModel.getItemType())) {
                            ToastUtil.i("请给店铺打总分哦");
                            return;
                        } else if ("2".equals(IssueFragment.this.issueViewModel.getItemType())) {
                            ToastUtil.i("请给剧本打总分哦");
                            return;
                        } else {
                            ToastUtil.i("请给演出打总分哦");
                            return;
                        }
                    } else if (xf2.j(IssueFragment.this.issueViewModel.getmEditorContent())) {
                        ToastUtil.i("请输入评价内容哦");
                        return;
                    } else if (!(IssueFragment.this.getSelectVideo() == null || IssueFragment.this.mIsRequestLoading == 0)) {
                        IssueFragment.this.uploadingTip();
                        return;
                    }
                }
                if ((!IssueFragment.this.issueViewModel.isEdit() || xf2.e(IssueFragment.this.mEditAddImages) <= 0) && xf2.e(IssueFragment.this.issueViewModel.getmImages()) <= 0) {
                    IssueFragment.this.onIssueClicked();
                } else {
                    hp1.b(IssueFragment.this.getActivity(), false, lp1.STORAGE, "才能使用发布哦~", new a());
                }
            } else if (id == R$id.issue_title_teach_good_evaluate) {
                r21.i().u(IssueFragment.this.issueViewModel.getmIssueType(), IssueFragment.this.issueViewModel.isEvaluate() ? IssueFragment.this.issueViewModel.getmItemId() : "");
                Bundle bundle = new Bundle();
                bundle.putString("url", p21.ISSUE_TEACH_GOOD_URL);
                DMNav.from(IssueFragment.this.getActivity()).withExtras(bundle).toUri(NavUri.b(a.c.d));
            } else if (id == R$id.issue_evaluate_associated_project) {
                r21.i().r();
                Bundle bundle2 = new Bundle();
                bundle2.putString("hint", "搜索关键词查找关联项目");
                if (IssueFragment.this.issueViewModel.isComeFromTheme()) {
                    bundle2.putString("themeId", IssueFragment.this.issueViewModel.getThemeId());
                }
                DMNav.from(IssueFragment.this.getActivity()).withExtras(bundle2).forResult(103).toUri(NavUri.b("search_privilege_result"));
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements OnDialogListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.issue.listener.OnDialogListener
        public void onDialogClick(DialogInterface dialogInterface, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-179039320")) {
                ipChange.ipc$dispatch("-179039320", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
                return;
            }
            IssueFragment.this.finishByUser();
        }
    }

    /* compiled from: Taobao */
    public class h implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "142042638")) {
                ipChange.ipc$dispatch("142042638", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("text", IssueFragment.this.issueViewModel.getmEditorContent());
            if (IssueFragment.this.issueViewModel.isFromHome() && IssueFragment.this.getActivity() != null && !IssueFragment.this.getActivity().isFinishing()) {
                intent.putExtra("tip", IssueFragment.this.getString(R$string.damai_homepage_comment_await_comment_tips));
            }
            IssueFragment.this.getActivity().setResult(-1, intent);
            SoftInputUtils.a(IssueFragment.this.getActivity());
            IssueFragment.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class i implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i(IssueFragment issueFragment) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1111623661")) {
                ipChange.ipc$dispatch("1111623661", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class j extends s40 {
        private static transient /* synthetic */ IpChange $ipChange;

        j() {
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onAllSuccess(@NonNull List<ss2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-628247526")) {
                ipChange.ipc$dispatch("-628247526", new Object[]{this, list});
                return;
            }
            if (!list.isEmpty()) {
                for (ss2 ss2 : list) {
                    IssueFragment.this.mImagesSelectData.add(ss2);
                }
                IssueFragment.this.requestIssue();
            }
            IssueFragment.this.mIsRequestLoading = 0;
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-89522735")) {
                ipChange.ipc$dispatch("-89522735", new Object[]{this});
                return;
            }
            g91.c("uploader cover cancel", "cancel");
            IssueFragment.this.mIsUploadImageFailure = true;
            IssueFragment.this.mIsRequestLoading = 0;
            IssueFragment.this.requestIssue();
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<ss2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2115617391")) {
                ipChange.ipc$dispatch("-2115617391", new Object[]{this, uploadErrorCode, list});
                return;
            }
            g91.c("uploader cover fail", "fail");
            IssueFragment.this.mIsUploadImageFailure = true;
            IssueFragment.this.mIsRequestLoading = 0;
            IssueFragment.this.requestIssue();
        }
    }

    /* compiled from: Taobao */
    public class k extends s40 {
        private static transient /* synthetic */ IpChange $ipChange;

        k() {
        }

        @Override // tb.s40
        public void a(ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-493797465")) {
                ipChange.ipc$dispatch("-493797465", new Object[]{this, ss2});
                return;
            }
            g91.c("uploader cover fail", "fail");
            IssueFragment.this.delVideo(true);
        }

        @Override // tb.s40
        public void b(@NonNull ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-721886770")) {
                ipChange.ipc$dispatch("-721886770", new Object[]{this, ss2});
                return;
            }
            String str = null;
            if (ss2 != null) {
                str = IssueFragment.this.imageUrl(ss2.d());
            }
            if (!TextUtils.isEmpty(str)) {
                IssueFragment.this.updateVideoBean(str);
                IssueFragment.this.mShowNiePhoto.notifyItemChanged(0, "success");
                IssueFragment.this.mIsRequestLoading = 0;
                IssueFragment.this.mShowNiePhoto.setIsSortable(true);
                g91.c("uploader cover success", str);
                g91.c("uploader all success", JSON.toJSONString(IssueFragment.this.videoBean));
                return;
            }
            IssueFragment.this.delVideo(true);
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418029074")) {
                ipChange.ipc$dispatch("1418029074", new Object[]{this});
                return;
            }
            g91.c("uploader cover cancel", "cancel");
            IssueFragment.this.delVideo(true);
        }
    }

    /* compiled from: Taobao */
    public class l extends s40 {
        private static transient /* synthetic */ IpChange $ipChange;

        l() {
        }

        @Override // tb.s40
        public void b(@NonNull ss2 ss2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1059613165")) {
                ipChange.ipc$dispatch("1059613165", new Object[]{this, ss2});
                return;
            }
            IssueFragment.this.stopProgressDialog();
            String imageUrl = IssueFragment.this.imageUrl(ss2.d());
            if (!TextUtils.isEmpty(imageUrl)) {
                IssueFragment.this.updateVideoBean(imageUrl);
                if (IssueFragment.this.mShowNiePhoto.getData().size() > 0) {
                    IssueFragment.this.mShowNiePhoto.getData().get(0).setThumbnail(IssueFragment.this.coverPath);
                }
                IssueFragment.this.mShowNiePhoto.notifyItemChanged(0);
                IssueFragment.this.mIsRequestLoading = 0;
                IssueFragment.this.mShowNiePhoto.setIsSortable(true);
                g91.c("uploader cover update success", imageUrl);
                return;
            }
            IssueFragment.this.updateCoverFail();
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1369386413")) {
                ipChange.ipc$dispatch("-1369386413", new Object[]{this});
                return;
            }
            g91.c("uploader cover cancel", "cancel");
            IssueFragment.this.updateCoverFail();
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<ss2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1875377645")) {
                ipChange.ipc$dispatch("-1875377645", new Object[]{this, uploadErrorCode, list});
                return;
            }
            g91.c("uploader cover fail", "fail");
            IssueFragment.this.updateCoverFail();
        }
    }

    /* compiled from: Taobao */
    public class m implements DMLinearLayoutIssue.IssueSoftControl {
        private static transient /* synthetic */ IpChange $ipChange;

        m() {
        }

        @Override // cn.damai.issue.view.DMLinearLayoutIssue.IssueSoftControl
        public void dispatchDown(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-852266697")) {
                ipChange.ipc$dispatch("-852266697", new Object[]{this, motionEvent});
                return;
            }
            IssueFragment issueFragment = IssueFragment.this;
            if (issueFragment.softShowing && !issueFragment.inputTipsView.touchInSelf((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                SoftInputUtils.a(IssueFragment.this.getActivity());
            }
        }
    }

    /* compiled from: Taobao */
    public class n implements OnTipsSelectedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        n() {
        }

        @Override // cn.damai.comment.view.OnTipsSelectedListener
        public void onTipsSelected(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "611984503")) {
                ipChange.ipc$dispatch("611984503", new Object[]{this, str});
                return;
            }
            int selectionEnd = IssueFragment.this.mEditor.getSelectionEnd();
            if (selectionEnd == 0) {
                Editable text = IssueFragment.this.mEditor.getText();
                text.insert(selectionEnd, str + StringUtils.LF);
                return;
            }
            Editable text2 = IssueFragment.this.mEditor.getText();
            text2.insert(selectionEnd, StringUtils.LF + str + StringUtils.LF);
        }
    }

    /* compiled from: Taobao */
    public class o implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        o() {
        }

        @RequiresApi(api = 3)
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1285816821")) {
                ipChange.ipc$dispatch("1285816821", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            IssueFragment.this.issue_window_layout.getWindowVisibleDisplayFrame(rect);
            g91.b("IssueActivity", "r.bottom = " + rect.bottom + "  visibleWindowDisplayHeight = " + IssueFragment.this.visibleWindowDisplayHeight);
            int i = IssueFragment.this.tempBottom;
            int i2 = rect.bottom;
            if (i != i2) {
                IssueFragment.this.tempBottom = i2;
                if (IssueFragment.this.visibleWindowDisplayHeight <= rect.bottom || !IssueFragment.this.isGreaterMVersion()) {
                    g91.b("IssueActivity", "输入框hide");
                    IssueFragment.this.visibleWindowDisplayHeight = rect.bottom;
                    IssueFragment.this.params.height = 0;
                    IssueFragment issueFragment = IssueFragment.this;
                    issueFragment.softShowing = false;
                    if (issueFragment.inputTipsView.getNeedShowWhenKeyboardOpen()) {
                        IssueFragment.this.inputTipsView.setVisibility(8);
                        IssueFragment.this.submitLayout.setVisibility(0);
                    }
                } else {
                    g91.b("IssueActivity", "输入框show");
                    IssueFragment issueFragment2 = IssueFragment.this;
                    issueFragment2.softShowing = true;
                    issueFragment2.params.height = IssueFragment.this.visibleWindowDisplayHeight - rect.bottom;
                    if (IssueFragment.this.inputTipsView.getNeedShowWhenKeyboardOpen()) {
                        IssueFragment.this.submitLayout.setVisibility(8);
                        IssueFragment.this.inputTipsView.setVisibility(0);
                    }
                }
                IssueFragment.this.issue_window_layout.requestLayout();
            }
        }
    }

    /* compiled from: Taobao */
    public class p implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        p() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1658631388")) {
                ipChange.ipc$dispatch("-1658631388", new Object[]{this, editable});
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "913819551")) {
                ipChange.ipc$dispatch("913819551", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1157374911")) {
                ipChange.ipc$dispatch("1157374911", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            IssueFragment.this.onEditorContentChanged(charSequence);
        }
    }

    private void addVideo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946566393")) {
            ipChange.ipc$dispatch("-946566393", new Object[]{this, str, str2});
            return;
        }
        Image image = new Image();
        image.setPath(str);
        image.setType("2");
        image.setThumbnail(str2);
        this.mShowNiePhoto.addFirstItem(image);
    }

    private void associatedProjectView(String str, String str2, String str3, String str4, String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044178019")) {
            ipChange.ipc$dispatch("-2044178019", new Object[]{this, str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        TextView textView = this.associatedTipHint;
        if (textView != null && textView.getVisibility() == 0) {
            this.associatedTipHint.setVisibility(8);
        }
        if (this.associatedProjectImage.getVisibility() == 8) {
            this.associatedProjectImage.setVisibility(0);
        }
        if (TextUtils.isEmpty(str4) || this.issueViewModel.isEvaluate()) {
            this.associatedProjectImage.setImageResource(R$drawable.uikit_default_image_bg_grey);
        } else {
            cn.damai.common.image.a.b().e(str4).k(new DMRoundedCornersBitmapProcessor(v50.a(getActivity(), 6.0f), 0)).d(getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(this.associatedProjectImage);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (this.associatedProjectName.getVisibility() == 8) {
                this.associatedProjectName.setVisibility(0);
            }
            this.associatedProjectName.setText(str3);
        } else {
            this.associatedProjectName.setText("");
        }
        if (!TextUtils.isEmpty(str5)) {
            if (this.associatedProjectTimeAddress.getVisibility() == 8) {
                this.associatedProjectTimeAddress.setVisibility(0);
            }
            this.associatedProjectTimeAddress.setText(str5);
        } else {
            this.associatedProjectTimeAddress.setText("");
        }
        if (!TextUtils.isEmpty(str) && !z) {
            updateThemeByPojId(str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void bindInputTips(List<String> list) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1381478473")) {
            ipChange.ipc$dispatch("1381478473", new Object[]{this, list});
            return;
        }
        this.inputTipsView.bindData(list);
        PublishInputTipsView publishInputTipsView = this.inputTipsView;
        if (!this.softShowing) {
            i2 = 8;
        }
        publishInputTipsView.setVisibility(i2);
    }

    private int checkUploadParamsValid() {
        DMCommentSubItemView dMCommentSubItemView;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052149683")) {
            return ((Integer) ipChange.ipc$dispatch("1052149683", new Object[]{this})).intValue();
        }
        if (this.mIsUploadImageFailure) {
            return 1;
        }
        if (this.issueViewModel.getStoreId() != null && "1".equals(this.issueViewModel.getItemType())) {
            if (this.issueViewModel.isEvaluate() && this.correlationView.getCorrelationId() == null && this.correlationView.isClickable()) {
                return 2;
            }
            if (this.correlationView.getCorrelationId() != null) {
                for (int i2 = 0; i2 < this.mSumItemBar.getChildCount(); i2++) {
                    if ((this.mSumItemBar.getChildAt(i2) instanceof DMCommentSubItemView) && (dMCommentSubItemView = (DMCommentSubItemView) this.mSumItemBar.getChildAt(i2)) != null) {
                        if ((dMCommentSubItemView.getGrades() == 0) && (dMCommentSubItemView.getTagBean() != null)) {
                            return 3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int delImagePosCorrect(int i2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1810476753")) {
            return (this.mShowNiePhoto.getData() == null || this.mShowNiePhoto.getData().size() <= 0 || this.mShowNiePhoto.getData().get(0) == null || !"2".equals(this.mShowNiePhoto.getData().get(0).getType())) ? i2 : i2 - 1;
        }
        return ((Integer) ipChange.ipc$dispatch("-1810476753", new Object[]{this, Integer.valueOf(i2)})).intValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void delVideo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495628183")) {
            ipChange.ipc$dispatch("1495628183", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.videoBean = null;
        if (this.mShowNiePhoto.getItemCount() > 0) {
            this.mShowNiePhoto.removeItem(0);
        }
        this.mShowNiePhoto.setIsSortable(true);
        setmEvaGiftContent();
        updateIssueButtonStatus();
        this.mIsRequestLoading = 0;
        if (z && getActivity() != null && !getActivity().isFinishing() && isAdded()) {
            ToastUtil.a().e(getActivity(), getResources().getString(R$string.issue_add_video_upload_fail));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchDraftCheckIfNeed() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "338571993")) {
            ipChange.ipc$dispatch("338571993", new Object[]{this});
            return;
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null && this.mDraftBox != null) {
            if (issueViewModel2.isEdit() || this.issueViewModel.isPrivilege() || this.issueViewModel.isEvaluate()) {
                z = true;
            }
            if (z) {
                this.mDraftBox.checkCacheDraft(new a());
            }
        }
    }

    private void editClearFocus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214465096")) {
            ipChange.ipc$dispatch("-1214465096", new Object[]{this});
            return;
        }
        this.issue_window_layout.setFocusable(true);
        this.issue_window_layout.setFocusableInTouchMode(true);
        this.mEditor.clearFocus();
    }

    private void evaluteSuceessRender(final IssueResponse issueResponse, String str, boolean z, final DMShareMessage dMShareMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806966926")) {
            ipChange.ipc$dispatch("806966926", new Object[]{this, issueResponse, str, Boolean.valueOf(z), dMShareMessage});
            return;
        }
        EvaluateSuccessRenderRequest evaluateSuccessRenderRequest = new EvaluateSuccessRenderRequest();
        evaluateSuccessRenderRequest.canEnterActivity = z;
        evaluateSuccessRenderRequest.commentId = str;
        if (!xf2.j(this.issueViewModel.getmIpId())) {
            evaluateSuccessRenderRequest.ipId = this.issueViewModel.getmIpId();
        }
        if (!xf2.j(this.issueViewModel.getmItemId())) {
            evaluateSuccessRenderRequest.itemId = this.issueViewModel.getmItemId();
        }
        evaluateSuccessRenderRequest.request(new DMMtopRequestListener<EvaluteSuccessRenderResponse>(EvaluteSuccessRenderResponse.class) {
            /* class cn.damai.issue.IssueFragment.AnonymousClass21 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1908547905")) {
                    ipChange.ipc$dispatch("-1908547905", new Object[]{this, str, str2});
                    return;
                }
                if (!(dMShareMessage == null || IssueFragment.this.getContext() == null || !(IssueFragment.this.getContext() instanceof IssueActivity))) {
                    dMShareMessage.requestCode = 104;
                    if (IssueFragment.this.issueViewModel.getScriptId() == null && IssueFragment.this.issueViewModel.getStoreId() == null) {
                        GenerateImageUtil.p((IssueActivity) IssueFragment.this.getContext(), dMShareMessage);
                    } else {
                        IssueFragment issueFragment = IssueFragment.this;
                        issueFragment.startActivity(EvaluateSuccessActivity.createIntent(issueFragment.getContext(), IssueFragment.this.issueViewModel.getItemType(), IssueFragment.this.issueViewModel.getStoreId(), issueResponse, null, dMShareMessage));
                    }
                }
                IssueFragment.this.notifyPublishSuccess();
            }

            public void onSuccess(EvaluteSuccessRenderResponse evaluteSuccessRenderResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-143364208")) {
                    ipChange.ipc$dispatch("-143364208", new Object[]{this, evaluteSuccessRenderResponse});
                    return;
                }
                if (evaluteSuccessRenderResponse != null) {
                    EvaluteSuccessRenderResponse.CommentSuccessInfo commentSuccessInfo = evaluteSuccessRenderResponse.commentInfo;
                    if (commentSuccessInfo != null) {
                        dMShareMessage.shareFooter = commentSuccessInfo.getUserCommentTotal();
                    }
                    if (evaluteSuccessRenderResponse.activityInfo != null) {
                        DMShareMessage.AdsBanner adsBanner = new DMShareMessage.AdsBanner();
                        EvaluteSuccessRenderResponse.EvaSuccessActivityInfo evaSuccessActivityInfo = evaluteSuccessRenderResponse.activityInfo;
                        adsBanner.title = evaSuccessActivityInfo.activityName;
                        adsBanner.subTitle = evaSuccessActivityInfo.activityDes;
                        dMShareMessage.adsBanner = adsBanner;
                    }
                    EvaluteSuccessRenderResponse.CommentProjectDO commentProjectDO = evaluteSuccessRenderResponse.projectDO;
                    if (commentProjectDO != null) {
                        DMShareMessage dMShareMessage = dMShareMessage;
                        dMShareMessage.projectCity = commentProjectDO.cityName;
                        dMShareMessage.projectTime = commentProjectDO.showTime;
                        dMShareMessage.remarkValue = commentProjectDO.itemScore;
                        if (!TextUtils.isEmpty(commentProjectDO.projectId)) {
                            dMShareMessage.projectId = evaluteSuccessRenderResponse.projectDO.projectId;
                        }
                        if (!TextUtils.isEmpty(evaluteSuccessRenderResponse.projectDO.projectName)) {
                            dMShareMessage.shareTitle = evaluteSuccessRenderResponse.projectDO.projectName;
                        }
                        if (!TextUtils.isEmpty(evaluteSuccessRenderResponse.projectDO.projectPoster)) {
                            dMShareMessage.sharePictureUrl = evaluteSuccessRenderResponse.projectDO.projectPoster;
                        }
                    }
                    DMShareMessage.YYMemberIntegrate yYMemberIntegrate = evaluteSuccessRenderResponse.vipScore;
                    if (yYMemberIntegrate != null) {
                        dMShareMessage.vipScore = yYMemberIntegrate;
                    }
                }
                if (!(dMShareMessage == null || IssueFragment.this.getContext() == null || !(IssueFragment.this.getContext() instanceof IssueActivity))) {
                    dMShareMessage.requestCode = 104;
                    if (IssueFragment.this.issueViewModel.getScriptId() == null && IssueFragment.this.issueViewModel.getStoreId() == null) {
                        GenerateImageUtil.p((IssueActivity) IssueFragment.this.getContext(), dMShareMessage);
                    } else {
                        IssueFragment issueFragment = IssueFragment.this;
                        issueFragment.startActivity(EvaluateSuccessActivity.createIntent(issueFragment.getContext(), IssueFragment.this.issueViewModel.getItemType(), IssueFragment.this.issueViewModel.getStoreId(), issueResponse, evaluteSuccessRenderResponse, dMShareMessage));
                    }
                }
                IssueFragment.this.notifyPublishSuccess();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-742891878")) {
            ipChange.ipc$dispatch("-742891878", new Object[]{this});
            return;
        }
        getActivity().finish();
        if (this.issueViewModel.isFromHome()) {
            if (Build.VERSION.SDK_INT >= 5) {
                getActivity().overridePendingTransition(R$anim.anim_no, R$anim.anim_bottom_out);
            }
        } else if (Build.VERSION.SDK_INT >= 5) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishByUser() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603955016")) {
            ipChange.ipc$dispatch("-1603955016", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("text", this.issueViewModel.getmEditorContent());
        if (this.issueViewModel.isFromHome() && getActivity() != null && !getActivity().isFinishing()) {
            intent.putExtra("tip", getString(R$string.damai_homepage_comment_await_comment_tips));
        }
        getActivity().setResult(-1, intent);
        SoftInputUtils.a(getActivity());
        finish();
    }

    private ArrayList<String> getImageListParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762108414")) {
            return (ArrayList) ipChange.ipc$dispatch("1762108414", new Object[]{this});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.issueViewModel.isEdit()) {
            for (int i2 = 0; i2 < xf2.e(this.issueViewModel.getmImages()); i2++) {
                if (this.issueViewModel.getmImages().get(i2).startsWith("http")) {
                    arrayList.add(this.issueViewModel.getmImages().get(i2));
                }
            }
        }
        Iterator<String> it = this.mPaths.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i3 = 0;
            while (true) {
                if (i3 >= xf2.e(this.mImagesSelectData)) {
                    break;
                }
                ss2 ss2 = this.mImagesSelectData.get(i3);
                if (ss2.d() != null && !TextUtils.isEmpty(next) && !TextUtils.isEmpty(ss2.b()) && next.equals(ss2.b())) {
                    arrayList.add(imageUrl(ss2.d()));
                    break;
                }
                i3++;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getNetworkType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697634683")) {
            return (String) ipChange.ipc$dispatch("-697634683", new Object[]{this});
        }
        NetworkType b2 = xh1.b(xs0.a().getApplicationContext());
        if (b2 == NetworkType.NETWORK_WIFI) {
            return "WiFi";
        }
        if (b2 == NetworkType.NETWORK_2G) {
            return "2G";
        }
        if (b2 == NetworkType.NETWORK_3G) {
            return "3G";
        }
        return b2 == NetworkType.NETWORK_4G ? "4G" : "none";
    }

    private void getRenderTags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121678584")) {
            ipChange.ipc$dispatch("121678584", new Object[]{this});
            return;
        }
        startProgressDialog();
        if (this.issueRenderResponseObserver == null) {
            this.issueRenderResponseObserver = new Observer<IssueRenderLiveDataResponse>() {
                /* class cn.damai.issue.IssueFragment.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                /* renamed from: cn.damai.issue.IssueFragment$2$a */
                /* compiled from: Taobao */
                public class a implements DMImageCreator.DMImageFailListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    a() {
                    }

                    @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                    public void onFail(DMImageCreator.d dVar) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-110245045")) {
                            ipChange.ipc$dispatch("-110245045", new Object[]{this, dVar});
                            return;
                        }
                        IssueFragment.this.giftIntroduce.setVisibility(8);
                    }
                }

                /* renamed from: cn.damai.issue.IssueFragment$2$b */
                /* compiled from: Taobao */
                public class b implements DMImageCreator.DMImageSuccListener {
                    private static transient /* synthetic */ IpChange $ipChange;

                    b() {
                    }

                    @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                    public void onSuccess(DMImageCreator.e eVar) {
                        Bitmap bitmap;
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1807689568")) {
                            ipChange.ipc$dispatch("-1807689568", new Object[]{this, eVar});
                        } else if (eVar == null || (bitmap = eVar.b) == null) {
                            IssueFragment.this.giftIntroduce.setVisibility(8);
                        } else {
                            IssueFragment.this.giftIntroduce.setVisibility(0);
                            IssueFragment.this.giftIntroduce.setImageBitmap(bitmap);
                        }
                    }
                }

                public void onChanged(@Nullable IssueRenderLiveDataResponse issueRenderLiveDataResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1497894118")) {
                        ipChange.ipc$dispatch("1497894118", new Object[]{this, issueRenderLiveDataResponse});
                    } else if (issueRenderLiveDataResponse != null && issueRenderLiveDataResponse.data != null && IssueFragment.this.isActivityOk()) {
                        IssueFragment.this.stopProgressDialog();
                        IssueFragment issueFragment = IssueFragment.this;
                        issueFragment.onResponseSuccess(issueFragment.issue_window_layout);
                        IssueFragment.this.dispatchDraftCheckIfNeed();
                        IssueRenderResponse issueRenderResponse = issueRenderLiveDataResponse.data;
                        IssueFragment.this.renderSubItemEvaluate(issueRenderResponse.getGradeTags());
                        IssueFragment.this.issueViewModel.setCommentGradeTexts(issueRenderResponse.getCommentGradeTexts());
                        IssueFragment.this.gradeTip();
                        IssueFragment.this.bindInputTips(issueRenderResponse.getIconTitle());
                        IssueFragment.this.associatedProjectTimeAddress.setVisibility(0);
                        IssueFragment.this.associatedProjectName.setVisibility(0);
                        IssueFragment.this.setRatingPartStaticData(issueRenderResponse.getItemType());
                        if (issueRenderResponse.getStoreInfo() != null && "1".equals(issueRenderResponse.getItemType())) {
                            IssueFragment.this.dmSelectView.bindData(issueRenderResponse.getDmInfoList(), null);
                            IssueFragment.this.associatedProjectTimeAddress.setText(issueRenderResponse.getStoreInfo().getDes());
                            IssueFragment.this.associatedProjectName.setText(issueRenderResponse.getStoreInfo().getStoreName());
                            IssueFragment.this.associatedProjectImage.getLayoutParams().width = v50.a(IssueFragment.this.getContext(), 42.0f);
                            cn.damai.common.image.a.b().e(issueRenderResponse.getStoreInfo().getStoreImgUrl()).k(new DMRoundedCornersBitmapProcessor(v50.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.store_defult_img)).g(IssueFragment.this.associatedProjectImage);
                            IssueFragment.this.correlationView.setDefaultData(issueRenderResponse.associatedScriptNum, CorrelationType.SCRIPT, issueRenderResponse.getStoreInfo().getStoreId());
                            IssueFragment.this.issueViewModel.setStoreId(issueRenderResponse.getStoreInfo().getStoreId() + "");
                            IssueFragment.this.issueViewModel.setItemType(issueRenderResponse.getItemType());
                        } else if (issueRenderResponse.scriptInfo == null || !"2".equals(issueRenderResponse.getItemType())) {
                            ProjectDO projectDO = issueRenderLiveDataResponse.data.projectDO;
                            if (projectDO != null) {
                                String timeDes = TextUtils.isEmpty(IssueFragment.this.issueViewModel.getTimeDes()) ? "时间待定" : IssueFragment.this.issueViewModel.getTimeDes();
                                String venueName = TextUtils.isEmpty(projectDO.getVenueName()) ? "场馆待定" : projectDO.getVenueName();
                                String str = timeDes + " | " + venueName;
                                if (!TextUtils.isEmpty(projectDO.getVenueCity())) {
                                    str = projectDO.getVenueCity() + " | " + timeDes + " | " + venueName;
                                }
                                if (!TextUtils.isEmpty(IssueFragment.this.issueViewModel.getTimeAddress())) {
                                    str = IssueFragment.this.issueViewModel.getTimeAddress();
                                }
                                IssueFragment.this.issueViewModel.setmProjectName(projectDO.getName());
                                IssueFragment.this.issueViewModel.setmProjectPoster(projectDO.getVerticalPic());
                                IssueFragment.this.issueViewModel.setTimeAddress(str);
                                cn.damai.common.image.a.b().e(IssueFragment.this.issueViewModel.getmProjectPoster()).k(new DMRoundedCornersBitmapProcessor(v50.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(IssueFragment.this.associatedProjectImage);
                                IssueFragment.this.associatedProjectTimeAddress.setText(IssueFragment.this.issueViewModel.getTimeAddress());
                                IssueFragment.this.associatedProjectName.setText(IssueFragment.this.issueViewModel.getmProjectName());
                            }
                            IssueFragment.this.inputTipsView.setVisibility(8);
                            IssueFragment.this.dmSelectView.setVisibility(8);
                        } else {
                            IssueFragment.this.associatedProjectTimeAddress.setText(issueRenderResponse.scriptInfo.getDes());
                            IssueFragment.this.associatedProjectName.setText(issueRenderResponse.scriptInfo.getName());
                            cn.damai.common.image.a.b().e(issueRenderResponse.scriptInfo.getPosterUrl()).k(new DMRoundedCornersBitmapProcessor(v50.a(IssueFragment.this.getActivity(), 6.0f), 0)).d(IssueFragment.this.getResources().getDrawable(R$drawable.uikit_default_image_bg_grey)).g(IssueFragment.this.associatedProjectImage);
                            IssueFragment.this.correlationView.setDefaultData(issueRenderResponse.associatedStoreNum, CorrelationType.STORE, issueRenderResponse.scriptInfo.getId());
                            IssueFragment.this.spoilerSwitchView.setVisibility(0);
                            IssueFragment.this.issueViewModel.setItemType(issueRenderResponse.getItemType());
                        }
                        if (issueRenderResponse.getNoticeInfo() != null) {
                            IssueFragment.this.issueViewModel.setNoticeInfos(issueRenderResponse.getNoticeInfo().getActivityIntroduce());
                            IssueFragment.this.setmEvaGiftContent();
                            if (!TextUtils.isEmpty(issueRenderResponse.getNoticeInfo().getActivityPic())) {
                                cn.damai.common.image.a.b().e(issueRenderResponse.getNoticeInfo().getActivityPic()).k(new DMRoundedCornersBitmapProcessor(12, 0)).n(new b()).e(new a()).f();
                            } else {
                                IssueFragment.this.giftIntroduce.setVisibility(8);
                            }
                        }
                    } else if (issueRenderLiveDataResponse != null) {
                        IssueFragment issueFragment2 = IssueFragment.this;
                        issueFragment2.onResponseError(issueRenderLiveDataResponse.errorCode, issueRenderLiveDataResponse.errorMsg, "mtop.damai.wireless.comment.render", issueFragment2.issue_window_layout, true);
                    }
                }
            };
        }
        this.issueViewModel.getRenderTags().observe(this, this.issueRenderResponseObserver);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Image getSelectVideo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396931206")) {
            return (Image) ipChange.ipc$dispatch("-396931206", new Object[]{this});
        }
        DMSortableNinePhotoLayout dMSortableNinePhotoLayout = this.mShowNiePhoto;
        if (dMSortableNinePhotoLayout == null || dMSortableNinePhotoLayout.getData() == null || this.mShowNiePhoto.getData().size() <= 0 || this.mShowNiePhoto.getData().get(0) == null || !"2".equals(this.mShowNiePhoto.getData().get(0).getType())) {
            return null;
        }
        return this.mShowNiePhoto.getData().get(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gradeTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1622193737")) {
            ipChange.ipc$dispatch("1622193737", new Object[]{this});
            return;
        }
        String e2 = re0.f().e(this.issueViewModel.getmGrades(), this.issueViewModel.getCommentGradeTexts(), "");
        if (!TextUtils.isEmpty(e2)) {
            re0.f().m(this.gradeTip);
            this.gradeTip.setText(e2);
            return;
        }
        re0.f().k(this.gradeTip);
    }

    private String gradesCombine() {
        DMCommentSubItemView dMCommentSubItemView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172376838")) {
            return (String) ipChange.ipc$dispatch("1172376838", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jl1.ARRAY_START_STR);
        sb.append(String.format("\"%1$s%2$s%3$s\"", "1", ":", Integer.valueOf(this.issueViewModel.getmGrades())));
        LinearLayout linearLayout = this.mSumItemBar;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.mSumItemBar.getChildCount(); i2++) {
                if (!(!(this.mSumItemBar.getChildAt(i2) instanceof DMCommentSubItemView) || (dMCommentSubItemView = (DMCommentSubItemView) this.mSumItemBar.getChildAt(i2)) == null || dMCommentSubItemView.getTagBean() == null)) {
                    sb.append(",");
                    if (!TextUtils.isEmpty(dMCommentSubItemView.getTagBean().getDesc())) {
                        sb.append(String.format("\"%1$s%2$s%3$s%4$s%5$s\"", Long.valueOf(dMCommentSubItemView.getTagBean().getType()), ":", Integer.valueOf(dMCommentSubItemView.getGrades()), ":", dMCommentSubItemView.getTagBean().getDesc()));
                    } else {
                        sb.append(String.format("\"%1$s%2$s%3$s\"", Long.valueOf(dMCommentSubItemView.getTagBean().getType()), ":", Integer.valueOf(dMCommentSubItemView.getGrades())));
                    }
                }
            }
        }
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gradesDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868688010")) {
            ipChange.ipc$dispatch("1868688010", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mRatingBarDesc.setText(str);
            this.mRatingBarDesc.setVisibility(0);
        } else {
            this.mRatingBarDesc.setVisibility(8);
        }
    }

    private void guideAnimShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897266643")) {
            ipChange.ipc$dispatch("897266643", new Object[]{this});
        } else if (this.issueViewModel.isEvaluate() && !this.issueViewModel.isFromHome() && !p21.b.equals(d20.B(p21.a))) {
            re0.g(this.guideAnimLayout, this.guideLottie);
        }
    }

    private void handleEditContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180256586")) {
            ipChange.ipc$dispatch("-1180256586", new Object[]{this});
            return;
        }
        this.mDMRatingBar.setStarMark(((float) this.issueViewModel.getmGrades()) / 2.0f);
        this.mEditor.setText(this.issueViewModel.getmEditorContent());
        this.mEditor.setSelection(this.issueViewModel.getmEditorContent().length());
        CommentsVideoBean commentsVideoBean = this.videoBean;
        if (commentsVideoBean != null && !TextUtils.isEmpty(commentsVideoBean.getCoverUrl())) {
            addVideo(this.videoBean.getUrl(), this.videoBean.getCoverUrl());
        }
        this.mShowNiePhoto.setData(re0.d(this.issueViewModel.getmImages(), getSelectVideo(), "1"));
    }

    private void imageAus(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-634606303")) {
            ipChange.ipc$dispatch("-634606303", new Object[]{this, arrayList});
            return;
        }
        this.mPaths.clear();
        this.mImagesSelectData.clear();
        this.mImagesPublishCount = 0;
        if (this.mIsRequestLoading == 0) {
            this.mPaths.addAll(arrayList);
            FileUploader q = FileUploader.q("damai_comment_oss");
            this.mSubmitUploader = q;
            q.C(this.mSubmitFilesListener).y().G(this.mPaths);
            startProgressDialog();
        }
        this.mIsUploadImageFailure = false;
        this.mIsRequestLoading = 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String imageUrl(ITaskResult iTaskResult) {
        AusResult ausResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329952325")) {
            return (String) ipChange.ipc$dispatch("-1329952325", new Object[]{this, iTaskResult});
        }
        if (iTaskResult == null || TextUtils.isEmpty(iTaskResult.getBizResult()) || (ausResult = (AusResult) pn.e().parseJson(iTaskResult.getBizResult(), AusResult.class)) == null || TextUtils.isEmpty(ausResult.ossBucketName) || TextUtils.isEmpty(ausResult.ossEndpoint) || TextUtils.isEmpty(ausResult.ossObjectKey)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://" + ausResult.ossBucketName);
        stringBuffer.append(".");
        stringBuffer.append(ausResult.ossEndpoint.substring(8));
        stringBuffer.append("/");
        stringBuffer.append(ausResult.ossObjectKey);
        return stringBuffer.toString();
    }

    private void initContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741291633")) {
            ipChange.ipc$dispatch("-1741291633", new Object[]{this});
            return;
        }
        this.issue_window_layout = (DMLinearLayoutIssue) findViewById(R$id.issue_window_layout);
        this.mIssueTitleCancel = (DMIconFontTextView) findViewById(R$id.issue_title_cancel);
        this.mTeachGoodEvaluate = (TextView) findViewById(R$id.issue_title_teach_good_evaluate);
        this.submitLayout = (LinearLayout) findViewById(R$id.issue_submit_bottom_layout);
        this.mIssueTitlecontent = (TextView) findViewById(R$id.issue_title_content);
        this.mIssueTitleConfirm = (TextView) findViewById(R$id.issue_title_confirm);
        this.scrollView = (MyScrollView) findViewById(R$id.issue_scrollview);
        this.holder_view = findViewById(R$id.holder_view);
        this.mEvaluateLayout = (RelativeLayout) findViewById(R$id.issue_evaluate_layout);
        this.mIssueEvaluateTip = (TextView) findViewById(R$id.issue_evaluate_tip);
        this.mDMRatingBar = (cn.damai.uikit.view.DMRatingBar) findViewById(R$id.issue_evaluate_grade_view);
        this.mRatingBarDesc = (TextView) findViewById(R$id.issue_comment_grade_desc);
        this.mSumItemBar = (LinearLayout) findViewById(R$id.issue_subitem_evaluate_layout);
        this.gradeTip = (TextView) findViewById(R$id.issue_grade_tip);
        this.mEditor = (EditText) findViewById(R$id.issue_editor);
        this.mEditorLimitTip = (TextView) findViewById(R$id.issue_editor_limit);
        this.mEvaGift = (TextView) findViewById(R$id.issue_evaluate_gift);
        this.mShowNiePhoto = (DMSortableNinePhotoLayout) findViewById(R$id.issue_show_photo);
        this.giftIntroduce = (ImageView) findViewById(R$id.comment_gift_introduce);
        this.associatedProjectTip = (TextView) findViewById(R$id.issue_associated_project_tip);
        this.associatedLayout = (RelativeLayout) findViewById(R$id.issue_evaluate_associated_project);
        int i2 = R$id.issue_associated_tip_hint;
        this.associatedTipHint = (TextView) findViewById(i2);
        this.associatedTipHint = (TextView) findViewById(i2);
        this.associatedProjectImage = (RoundRadiusImageView) findViewById(R$id.issue_associated_project_image);
        this.associatedProjectName = (TextView) findViewById(R$id.issue_associated_project_name);
        this.associatedProjectTimeAddress = (TextView) findViewById(R$id.issue_associated_project_time_address);
        this.associatedProjectArrow = (DMIconFontTextView) findViewById(R$id.issue_associated_icon_arrow);
        this.associatedHolder = findViewById(R$id.issue_evaluate_associated_holder);
        this.llThemeLayout = (ConstraintLayout) findViewById(R$id.ll_theme_tip_layout);
        this.tvThemeContent = (TextView) findViewById(R$id.tv_theme_tip_content);
        this.clCircleLayout = (ConstraintLayout) findViewById(R$id.ll_circle_tip_layout);
        this.tvCircleContent = (TextView) findViewById(R$id.tv_circle_tip_content);
        this.ivCircleScreen = (DMIconFontTextView) findViewById(R$id.iv_circle_screen);
        IssueCircleSelect issueCircleSelect2 = new IssueCircleSelect(getContext());
        this.issueCircleSelect = issueCircleSelect2;
        issueCircleSelect2.d(this.clCircleLayout);
        this.guideAnimLayout = (LinearLayout) findViewById(R$id.issue_first_entry_guide_anim);
        this.guideLottie = (LottieAnimationView) findViewById(R$id.issue_first_entry_guide_lottie);
        this.fullStarLottie = (LottieAnimationView) findViewById(R$id.issue_full_star_lottie);
        this.dmSelectView = (PublishDMSelectView) findViewById(R$id.issue_dm_select);
        this.inputTipsView = (PublishInputTipsView) findViewById(R$id.publish_input_tips_view);
        this.correlationView = (CorrelationView) findViewById(R$id.correlation_view);
        this.spoilerSwitchView = (SpoilerSwitchView) findViewById(R$id.spoiler_view);
        updateIssueButtonStatus(false);
    }

    private void initIssueViewModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1413317202")) {
            ipChange.ipc$dispatch("1413317202", new Object[]{this});
            return;
        }
        IssueViewModel issueViewModel2 = (IssueViewModel) new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(xs0.a())).get(IssueViewModel.class);
        this.issueViewModel = issueViewModel2;
        boolean intentValue = issueViewModel2.getIntentValue(getArguments(), getActivity().getIntent());
        if (ol1.b()) {
            this.mDraftBox = new DraftBox(new DraftMd5NameAssembler(this.issueViewModel), this);
        } else {
            this.mDraftBox = new DraftEmptyBox();
        }
        if (!intentValue) {
            ToastUtil.i("请求数据出错.");
        }
    }

    private void initSetting() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233080131")) {
            ipChange.ipc$dispatch("-233080131", new Object[]{this});
            return;
        }
        this.mShowNiePhoto.init(getActivity());
        this.mShowNiePhoto.setIsSortable(true);
        if (this.issueViewModel.isEvaluate()) {
            str = getString(R$string.issue_comment_edit_hint);
            guideAnimShow();
            this.mDMRatingBar.setStarMark(((float) this.issueViewModel.getmGrades()) / 2.0f);
            this.associatedLayout.setVisibility(0);
            this.associatedHolder.setVisibility(0);
            this.associatedProjectArrow.setVisibility(8);
            associatedProjectView(this.issueViewModel.getmItemId(), "1", this.issueViewModel.getmProjectName(), this.issueViewModel.getmProjectPoster(), this.issueViewModel.getTimeAddress(), false);
        } else if (this.issueViewModel.isEdit()) {
            this.mIssueTitlecontent.setText(BottomActionDialog.EDIT);
            handleEditContent();
            str = "记录下你的现场感受吧";
        } else if (this.issueViewModel.isPrivilege()) {
            this.associatedProjectTip.setVisibility(0);
            this.associatedLayout.setVisibility(0);
            this.associatedLayout.setOnClickListener(this.mOnClickListener);
            this.associatedHolder.setVisibility(0);
            str = getString(R$string.issue_comment_edit_hint);
            privilegeView(false, null, false);
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            cn.damai.common.user.c.e().G(this.associatedLayout, c62.SEARCH_ITEM_ASSOCIATE, "top", r21.PAGE_EVALUATE_SUBMIT, hashMap);
        } else {
            str = "";
        }
        editClearFocus();
        if (!TextUtils.isEmpty(this.issueViewModel.getAppPublishHint())) {
            str = this.issueViewModel.getAppPublishHint();
        }
        if (this.issueViewModel.isComeFromTheme()) {
            updateTheme(this.issueViewModel.getThemeName());
        }
        if (this.issueViewModel.isComeFromCircle()) {
            updateCircle(this.issueViewModel.getCircle());
        }
        this.mEditor.setHint(str);
        this.mEditorLimitTip.setVisibility(0);
        showEditorLimitTip();
        updateIssueButtonStatus();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isGreaterMVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1060091194")) {
            return Build.VERSION.SDK_INT >= 23;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1060091194", new Object[]{this})).booleanValue();
    }

    private boolean isNetAvailable() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "156106843")) {
            return yh1.b(getActivity());
        }
        return ((Boolean) ipChange.ipc$dispatch("156106843", new Object[]{this})).booleanValue();
    }

    private void keyBoradChangeView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462702481")) {
            ipChange.ipc$dispatch("-1462702481", new Object[]{this});
            return;
        }
        this.params = (LinearLayout.LayoutParams) this.holder_view.getLayoutParams();
        Rect rect = new Rect();
        this.issue_window_layout.getWindowVisibleDisplayFrame(rect);
        this.visibleWindowDisplayHeight = rect.bottom;
        this.mEditor.getViewTreeObserver().addOnGlobalLayoutListener(new o());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323256656")) {
            ipChange.ipc$dispatch("323256656", new Object[]{this});
            return;
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.issue.IssueFragment.AnonymousClass22 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2077422742")) {
                    ipChange.ipc$dispatch("2077422742", new Object[]{this});
                    return;
                }
                br.c("comment_publish_success", IssueFragment.this.issueViewModel.getmTargetId());
                if (!IssueFragment.this.issueViewModel.isFromHome()) {
                    Intent intent = new Intent();
                    intent.putExtra("needRefresh", true);
                    if (IssueFragment.this.getActivity() != null && !IssueFragment.this.getActivity().isFinishing()) {
                        IssueFragment.this.getActivity().setResult(-1, intent);
                        IssueFragment.this.finish();
                    }
                }
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onBackClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589166684")) {
            ipChange.ipc$dispatch("1589166684", new Object[]{this});
            return;
        }
        if (this.issueViewModel.isEvaluate()) {
            r21.i().s(this.issueViewModel.getmIssueType(), this.issueViewModel.getmItemId());
        }
        if (this.issueViewModel.isEvaluate() || this.issueViewModel.isPrivilege() || this.issueViewModel.isEdit()) {
            IDraftBox iDraftBox = this.mDraftBox;
            if (iDraftBox == null || !iDraftBox.checkBackPressed(new g())) {
                finishByUser();
            }
        } else if (!xf2.j(this.issueViewModel.getmEditorContent()) || xf2.e(this.mShowNiePhoto.getData()) > 0) {
            String string = getResources().getString(R$string.edit_content_text);
            String string2 = getResources().getString(R$string.edit_comment_tv);
            new f4(getActivity()).e(string).h(string2, new i(this)).f(getResources().getString(R$string.edit_back_tv), new h()).c(false).j();
        } else {
            SoftInputUtils.a(getActivity());
            finish();
        }
    }

    private void onBackFromShare(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816054869")) {
            ipChange.ipc$dispatch("-1816054869", new Object[]{this, intent});
            return;
        }
        g91.b("wpf", "IssueFragment.onBackFromShare/in data:" + intent);
        if (intent == null) {
            intent = new Intent();
        }
        if (this.issueViewModel.isFromHome()) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                intent.putExtra("tip", getString(R$string.damai_homepage_commented_tips));
            }
            getActivity().setResult(-1, intent);
            finish();
        }
    }

    private void onCoverVideoResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325720438")) {
            ipChange.ipc$dispatch("-1325720438", new Object[]{this, intent});
        } else if (intent != null) {
            new ArrayList();
            new ArrayList();
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(c01.SELECT_RESULT);
            intent.getParcelableArrayListExtra("imagelist");
            if (stringArrayListExtra.size() > 0) {
                String str = stringArrayListExtra.get(0);
                this.coverPath = str;
                Bitmap b2 = g01.b(str, -1, -1);
                if (b2 == null) {
                    try {
                        this.coverPath = Luban.l(this.mActivity).k(this.coverPath).h(this.coverPath).getAbsolutePath();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    b2 = cn.damai.common.util.a.i(this.coverPath);
                }
                if (isNetAvailable()) {
                    uploadVideoCover(b2, this.mCoverUpdateListener, true);
                } else {
                    ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onEditorContentChanged(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034442742")) {
            ipChange.ipc$dispatch("-2034442742", new Object[]{this, charSequence});
            return;
        }
        g91.c(DraftBox.TAG, "onEditorContentChanged");
        try {
            this.issueViewModel.setmEditorContent(charSequence.toString().trim());
            if (this.mEditorLimit - this.issueViewModel.inputCount() <= 0) {
                IssueViewModel issueViewModel2 = this.issueViewModel;
                issueViewModel2.setmEditorContent(issueViewModel2.getmEditorContent().substring(0, this.mEditorLimit));
                this.mEditor.removeTextChangedListener(this.mOnTextChangedListener);
                this.mEditor.setText(this.issueViewModel.getmEditorContent());
                this.mEditor.setSelection(this.issueViewModel.getmEditorContent().length());
                this.mEditor.addTextChangedListener(this.mOnTextChangedListener);
            }
            showEditorLimitTip();
            setmEvaGiftContent();
            updateIssueButtonStatus();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onIssueClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "972948576")) {
            ipChange.ipc$dispatch("972948576", new Object[]{this});
            return;
        }
        SoftInputUtils.a(getActivity());
        if (this.issueViewModel.isEdit()) {
            if (xf2.e(this.mEditAddImages) > 0) {
                imageAus(this.mEditAddImages);
            } else {
                requestIssue();
            }
        } else if (xf2.e(this.issueViewModel.getmImages()) > 0) {
            imageAus(this.issueViewModel.getmImages());
        } else {
            requestIssue();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onIssueCommentSuccess(IssueResponse issueResponse) {
        IssueResponse.UserDOBeanX userDO;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267151881")) {
            ipChange.ipc$dispatch("-1267151881", new Object[]{this, issueResponse});
            return;
        }
        IssueResponse.CommentsDOBean commentsDO = issueResponse.getCommentsDO();
        if (commentsDO != null && (userDO = issueResponse.getUserDO()) != null) {
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.projectId = this.issueViewModel.getmTargetId();
            dMShareMessage.sharePictureUrl = this.issueViewModel.getmProjectPoster();
            dMShareMessage.shareLink = commentsDO.getUrl();
            dMShareMessage.evaluateGrade = this.issueViewModel.getmGrades();
            dMShareMessage.evaluateGradeDesc = jk.a((float) this.issueViewModel.getmGrades());
            if (issueResponse.getCommentsDO() != null && xf2.e(issueResponse.getCommentsDO().getGradeDOList()) > 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= issueResponse.getCommentsDO().getGradeDOList().size()) {
                        break;
                    }
                    CommentGradeBean commentGradeBean = issueResponse.getCommentsDO().getGradeDOList().get(i2);
                    if (commentGradeBean == null || commentGradeBean.type != 1) {
                        i2++;
                    } else {
                        dMShareMessage.evaluateGradeDesc = commentGradeBean.valueDesc;
                        if (!TextUtils.isEmpty(commentGradeBean.value)) {
                            try {
                                dMShareMessage.evaluateGrade = Integer.valueOf(commentGradeBean.value).intValue();
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (!(issueResponse.getCommentsDO() == null || this.issueViewModel.getItemType() == null)) {
                dMShareMessage.dmInfo = issueResponse.getCommentsDO().getDmInfo();
                dMShareMessage.storeInfo = issueResponse.getCommentsDO().getStoreInfo();
                try {
                    dMShareMessage.itemType = Integer.parseInt(this.issueViewModel.getItemType());
                } catch (NumberFormatException unused2) {
                    dMShareMessage.itemType = 0;
                }
            }
            if (getActivity() == null || getActivity().isFinishing()) {
                dMShareMessage.windowTitle = "分享评价";
            } else {
                dMShareMessage.windowTitle = getActivity().getString(R$string.ticklet_share_title);
            }
            dMShareMessage.shareTitle = this.issueViewModel.getmProjectName();
            dMShareMessage.shareContent = this.issueViewModel.getmEditorContent();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_EVALUATE_IMAGE;
            dMShareMessage.commentType = this.issueViewModel.getmCommentType();
            dMShareMessage.userNick = userDO.getNickname();
            dMShareMessage.userHeaderIcon = userDO.getHeaderImage();
            dMShareMessage.vip = userDO.isVip();
            if (userDO.getPerformFilmVipDO() != null) {
                str = userDO.getPerformFilmVipDO().memberFlag;
            } else {
                str = h03.h();
            }
            dMShareMessage.memberFlag = str;
            dMShareMessage.vipLevelIcon = userDO.getVipLevelIcon();
            dMShareMessage.evaluateTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(Long.valueOf(commentsDO.getGmtCreateTime()));
            dMShareMessage.extraMedia = CommentItemMoreUtil.l(this.videoBean, getImageListParams());
            evaluteSuceessRender(issueResponse, issueResponse.getCommentsDO().getCommentId(), issueResponse.isCanEnterActivity(), dMShareMessage);
        }
    }

    private void onPreviewImageResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790350661")) {
            ipChange.ipc$dispatch("-790350661", new Object[]{this, intent});
        } else if (intent != null) {
            this.issueViewModel.setmImages(intent.getStringArrayListExtra("selected"));
            this.issueViewModel.setmSelectImages(intent.getParcelableArrayListExtra("selectedList"));
            this.mShowNiePhoto.setData(re0.d(this.issueViewModel.getmImages(), getSelectVideo(), "1"));
            setmEvaGiftContent();
            updateIssueButtonStatus();
        }
    }

    private void onPreviewVideoResult(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707126171")) {
            ipChange.ipc$dispatch("1707126171", new Object[]{this, intent});
        } else if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("selected");
            if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                delVideo(false);
            }
        }
    }

    private void onSelectAlbumResult(Intent intent, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1377029331")) {
            ipChange.ipc$dispatch("1377029331", new Object[]{this, intent, str});
        } else if (intent != null) {
            if ("2".equals(str)) {
                new ArrayList();
                new ArrayList();
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(c01.SELECT_RESULT);
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("imagelist");
                if (stringArrayListExtra.size() > 0 && !TextUtils.isEmpty(stringArrayListExtra.get(0)) && parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                    this.mShowNiePhoto.setIsSortable(false);
                    addVideo(stringArrayListExtra.get(0), null);
                    g91.c("uploader fileUrl", "开始添加视频上传");
                    uploader(stringArrayListExtra.get(0), ((Image) parcelableArrayListExtra.get(0)).getDuration());
                }
            } else {
                if (this.issueViewModel.isEdit()) {
                    this.mEditAddImages = intent.getStringArrayListExtra(c01.SELECT_RESULT);
                    for (int i2 = 0; i2 < xf2.e(this.mEditAddImages); i2++) {
                        if (!this.issueViewModel.getmImages().contains(this.mEditAddImages.get(i2))) {
                            this.issueViewModel.getmImages().add(this.mEditAddImages.get(i2));
                        }
                    }
                    this.mEditAddSelectImages = intent.getParcelableArrayListExtra("imagelist");
                    for (int i3 = 0; i3 < xf2.e(this.mEditAddSelectImages); i3++) {
                        if (!this.issueViewModel.getmSelectImages().contains(this.mEditAddSelectImages.get(i3))) {
                            this.issueViewModel.getmSelectImages().add(this.mEditAddSelectImages.get(i3));
                        }
                    }
                } else {
                    this.issueViewModel.setmImages(intent.getStringArrayListExtra(c01.SELECT_RESULT));
                    this.issueViewModel.setmSelectImages(intent.getParcelableArrayListExtra("imagelist"));
                }
                this.mShowNiePhoto.setData(re0.d(this.issueViewModel.getmImages(), getSelectVideo(), str));
            }
            setmEvaGiftContent();
            updateIssueButtonStatus();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openAlbum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1285877896")) {
            ipChange.ipc$dispatch("-1285877896", new Object[]{this});
            return;
        }
        hp1.b(getActivity(), false, lp1.STORAGE, "才能添加图片～", new e());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void privilegeView(boolean z, Intent intent, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193889994")) {
            ipChange.ipc$dispatch("193889994", new Object[]{this, Boolean.valueOf(z), intent, Boolean.valueOf(z2)});
        } else if (!z || intent == null) {
            this.associatedTipHint.setVisibility(0);
            this.associatedProjectImage.setVisibility(8);
            this.associatedProjectName.setVisibility(8);
            this.associatedProjectTimeAddress.setVisibility(8);
            this.mEvaluateLayout.setVisibility(8);
            this.mTempDraftExtra = null;
        } else {
            this.issueViewModel.setmTargetId(intent.getStringExtra(IssueConstants.ProjectID));
            String stringExtra = intent.getStringExtra("projectName");
            String stringExtra2 = intent.getStringExtra("projectImage");
            String stringExtra3 = intent.getStringExtra("timeAddress");
            this.privilegeType = intent.getStringExtra(IssueConstants.privilegeType);
            this.mTempDraftExtra = new DraftExtra(this.issueViewModel.getmTargetId(), stringExtra, stringExtra2, stringExtra3, this.privilegeType, this.issueViewModel.getThemeName());
            this.mEvaluateLayout.setVisibility(0);
            associatedProjectView(this.issueViewModel.getmTargetId(), this.privilegeType, stringExtra, stringExtra2, stringExtra3, z2);
            updateIssueButtonStatus();
        }
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047966154")) {
            ipChange.ipc$dispatch("-1047966154", new Object[]{this});
            return;
        }
        this.mIssueTitleCancel.setOnClickListener(this.mOnClickListener);
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        String str = this.issueViewModel.isEvaluate() ? this.issueViewModel.getmItemId() : "";
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        cn.damai.common.user.c.e().G(this.mIssueTitleCancel, "cancel_comment", "top", r21.PAGE_EVALUATE_SUBMIT, hashMap);
        this.mTeachGoodEvaluate.setOnClickListener(this.mOnClickListener);
        this.mIssueTitleConfirm.setOnClickListener(this.mOnClickListener);
        this.mEditor.addTextChangedListener(this.mOnTextChangedListener);
        this.mShowNiePhoto.setOnNinePhotoClickListener(this.mShowPhotoListener);
        this.mShowNiePhoto.setOnSortListener(this.mOnSortListener);
        this.mDMRatingBar.setOnStarChangeListener(this.mOnStarChangeListener);
        this.tvCircleContent.setOnClickListener(this.mOnClickListener);
        this.ivCircleScreen.setOnClickListener(this.mOnClickListener);
        this.guideAnimLayout.setOnClickListener(null);
        this.issue_window_layout.setListener(new m());
        this.inputTipsView.setTipsSelectedListener(new n());
        this.dmSelectView.setOnItemClickListener(new OnItemClickListener() {
            /* class cn.damai.issue.IssueFragment.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.comment.view.OnItemClickListener
            public void onItemClick(@NotNull View view, int i, @org.jetbrains.annotations.Nullable DmInfo dmInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1190383351")) {
                    ipChange.ipc$dispatch("-1190383351", new Object[]{this, view, Integer.valueOf(i), dmInfo});
                } else if (dmInfo != null) {
                    IssueFragment.this.dmSelectView.postDelayed(new Runnable() {
                        /* class cn.damai.issue.IssueFragment.AnonymousClass7.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-401762030")) {
                                ipChange.ipc$dispatch("-401762030", new Object[]{this});
                                return;
                            }
                            int bottom = IssueFragment.this.dmSelectView.getBottom() - IssueFragment.this.scrollView.getMeasuredHeight();
                            if (bottom > IssueFragment.this.scrollView.getScrollY()) {
                                IssueFragment.this.scrollView.scrollTo(0, bottom);
                            }
                        }
                    }, 50);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void renderSubItemEvaluate(List<CommentGradeTagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105173416")) {
            ipChange.ipc$dispatch("-1105173416", new Object[]{this, list});
            return;
        }
        this.viewHeight = 0;
        if (list == null || list.size() <= 0) {
            re0.f().k(this.mSumItemBar);
            return;
        }
        this.mSumItemBar.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            new CommentGradeTagBean();
            CommentGradeTagBean commentGradeTagBean = list.get(i2);
            if (commentGradeTagBean != null) {
                DMCommentSubItemView dMCommentSubItemView = new DMCommentSubItemView(getActivity());
                dMCommentSubItemView.setData(commentGradeTagBean, ek.a(TextUtils.isEmpty(commentGradeTagBean.getValue()) ? 0.0f : Float.valueOf(commentGradeTagBean.getValue()).floatValue()), R$drawable.comment_evalaute_default_icon);
                dMCommentSubItemView.setGradeChangeLister(this);
                dMCommentSubItemView.setPadding(0, v50.a(getActivity(), 21.0f), 0, 0);
                this.mSumItemBar.addView(dMCommentSubItemView);
                this.viewHeight += v50.a(getActivity(), 47.0f);
                if (this.issueViewModel.getmGrades() > 0) {
                    re0.f().m(this.mSumItemBar);
                }
            }
        }
    }

    private void requestEvaluateDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7799428")) {
            ipChange.ipc$dispatch("7799428", new Object[]{this});
            return;
        }
        startProgressDialog();
        if (this.evaluateDetailObserver == null) {
            this.evaluateDetailObserver = new Observer<CommentsResultBean>() {
                /* class cn.damai.issue.IssueFragment.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onChanged(@Nullable CommentsResultBean commentsResultBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-484854701")) {
                        ipChange.ipc$dispatch("-484854701", new Object[]{this, commentsResultBean});
                        return;
                    }
                    IssueFragment.this.stopProgressDialog();
                    if (commentsResultBean != null && commentsResultBean.getData() != null && commentsResultBean.getData().size() > 0 && commentsResultBean.getData().get(0) != null) {
                        IssueFragment.this.setDetailInfoView(commentsResultBean.getData().get(0));
                        IssueFragment.this.dispatchDraftCheckIfNeed();
                    }
                }
            };
        }
        this.issueViewModel.requestEvaluateDetail().observe(this, this.evaluateDetailObserver);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestIssue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2135549373")) {
            ipChange.ipc$dispatch("-2135549373", new Object[]{this});
        } else if (isActivityOk()) {
            if (!LoginManager.k().q()) {
                LoginManager.k().x(getActivity(), new Intent(), 1000);
                return;
            }
            int checkUploadParamsValid = checkUploadParamsValid();
            if (checkUploadParamsValid == 0) {
                if (this.issueObserver == null) {
                    this.issueObserver = new Observer<IssueLiveDataResponse>() {
                        /* class cn.damai.issue.IssueFragment.AnonymousClass20 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onChanged(@Nullable IssueLiveDataResponse issueLiveDataResponse) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "262115664")) {
                                ipChange.ipc$dispatch("262115664", new Object[]{this, issueLiveDataResponse});
                                return;
                            }
                            IssueFragment.this.stopProgressDialog();
                            if (issueLiveDataResponse == null || issueLiveDataResponse.data == null || !IssueFragment.this.isActivityOk()) {
                                IssueFragment.this.stopProgressDialog();
                                IssueFragment.this.mImagesPublishCount = 0;
                                if (!(IssueFragment.this.getActivity() == null || issueLiveDataResponse == null)) {
                                    IssueFragment.this.getActivity().setResult(-1);
                                    ToastUtil.a().e(IssueFragment.this.getActivity(), issueLiveDataResponse.errorMsg);
                                }
                                IssueFragment.this.mIsRequestLoading = 0;
                                IssueFragment.this.updateIssueButtonStatus(true);
                                return;
                            }
                            if (IssueFragment.this.mDraftBox != null) {
                                IssueFragment.this.mDraftBox.notifyPublishSuccess();
                            }
                            IssueResponse issueResponse = issueLiveDataResponse.data;
                            HashMap hashMap = new HashMap();
                            hashMap.put("usercode", d20.E());
                            if (IssueFragment.this.issueViewModel.isEvaluate()) {
                                hashMap.put("type", "1");
                            } else if (IssueFragment.this.issueViewModel.isPrivilege()) {
                                hashMap.put("type", "0");
                            } else if (IssueFragment.this.issueViewModel.isEdit()) {
                                hashMap.put("type", "2");
                            }
                            r21.i().t(hashMap);
                            DmInfo selectedDm = IssueFragment.this.dmSelectView.getSelectedDm();
                            if (selectedDm != null && IssueFragment.this.dmSelectView.getVisibility() == 0) {
                                r21.n(String.valueOf(selectedDm.getDmId()));
                                ArrayList<String> arrayList = selectedDm.dmTags;
                                if (!(arrayList == null || arrayList.size() <= 0 || selectedDm.allDmTags == null)) {
                                    for (int i = 0; i < selectedDm.dmTags.size(); i++) {
                                        r21.o(String.valueOf(selectedDm.getDmId()), IssueFragment.this.dmSelectView.getSelectedDmIndex(), selectedDm.dmTags.get(i), selectedDm.allDmTags.indexOf(selectedDm.dmTags.get(i)));
                                    }
                                }
                            }
                            IssueFragment.this.mImagesPublishCount = 0;
                            if (IssueFragment.this.issueViewModel.isShowToastAfterPublishSuccess()) {
                                if (IssueFragment.this.issueViewModel.isPrivilege()) {
                                    ToastUtil.a().e(IssueFragment.this.getActivity(), IssueFragment.this.getString(R$string.issue_success_privilege));
                                } else {
                                    ToastUtil.a().e(IssueFragment.this.getActivity(), IssueFragment.this.getString(R$string.issue_success));
                                }
                            }
                            IssueFragment.this.mIsRequestLoading = 0;
                            if (!IssueFragment.this.issueViewModel.isEvaluate() || issueResponse == null || issueResponse.getCommentsDO() == null || issueResponse.getUserDO() == null) {
                                IssueFragment.this.notifyPublishSuccess();
                            } else {
                                try {
                                    IssueFragment.this.onIssueCommentSuccess(issueResponse);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("result", (Object) "success");
                            WVStandardEventCenter.postNotificationToJS("publishEvent", jSONObject.toString());
                        }
                    };
                }
                IssueViewModel issueViewModel2 = this.issueViewModel;
                ArrayList<String> imageListParams = getImageListParams();
                CommentsVideoBean commentsVideoBean = this.videoBean;
                issueViewModel2.requestIssue(imageListParams, commentsVideoBean != null ? JSON.toJSONString(commentsVideoBean) : null, gradesCombine(), this.privilegeType, this.issueViewModel.getThemeId(), this.issueViewModel.getCircle(), this.dmSelectView.getSelectedDm(), this.spoilerSwitchView.getIsSpoiler(), this.correlationView.getCorrelationId()).observe(this, this.issueObserver);
                startProgressDialog();
                updateIssueButtonStatus(false);
            } else if (checkUploadParamsValid == 1) {
                ToastUtil.a().e(getActivity(), "图片上传出错了，请重新上传～");
            } else if (checkUploadParamsValid == 2) {
                ToastUtil.a().e(getContext(), "剧本不能为空哦~");
            } else if (checkUploadParamsValid == 3) {
                ToastUtil.a().e(getContext(), "细分项不能为空哦~~");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDetailInfoView(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527131301")) {
            ipChange.ipc$dispatch("-527131301", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null) {
            bindInputTips(commentsItemBean.getIconTitle());
            setRatingPartStaticData(String.valueOf(commentsItemBean.getItemType()));
            if (commentsItemBean.getItemType() == 1) {
                this.dmSelectView.bindData(commentsItemBean.getAllDmInfo(), commentsItemBean.getDmInfo());
            }
            ArrayList arrayList = new ArrayList();
            String str = "";
            if (xf2.e(commentsItemBean.getGradeDOList()) > 0) {
                for (int i2 = 0; i2 < commentsItemBean.getGradeDOList().size(); i2++) {
                    CommentGradeBean commentGradeBean = commentsItemBean.getGradeDOList().get(i2);
                    if (commentGradeBean != null) {
                        if (commentGradeBean.type != 1) {
                            CommentGradeTagBean commentGradeTagBean = new CommentGradeTagBean();
                            commentGradeTagBean.setDesc(commentGradeBean.desc);
                            commentGradeTagBean.setValue(commentGradeBean.value);
                            commentGradeTagBean.setType(commentGradeBean.type);
                            arrayList.add(commentGradeTagBean);
                        } else if (!TextUtils.isEmpty(commentGradeBean.value)) {
                            this.issueViewModel.setmGrades((int) Float.parseFloat(commentGradeBean.value));
                            str = jk.a((float) this.issueViewModel.getmGrades());
                        }
                    }
                }
            }
            this.issueViewModel.updateDetailInfoView(commentsItemBean);
            this.issueViewModel.setItemType(String.valueOf(commentsItemBean.getItemType()));
            if (commentsItemBean.getStoreInfo() != null && 1 == commentsItemBean.getItemType()) {
                this.issueViewModel.setStoreId(commentsItemBean.getStoreInfo().getStoreId());
                this.correlationView.setDefaultData(commentsItemBean.getAssociatedScriptNum(), CorrelationType.SCRIPT, commentsItemBean.getStoreInfo().getStoreId(), Boolean.FALSE);
                if (commentsItemBean.getScriptInfo() == null || commentsItemBean.getScriptInfo().getId() == null) {
                    this.correlationView.setVisibility(8);
                } else {
                    this.correlationView.setSelectData(commentsItemBean.getScriptInfo().getId(), commentsItemBean.getScriptInfo().getName());
                }
            } else if (commentsItemBean.getScriptInfo() != null && 2 == commentsItemBean.getItemType()) {
                this.issueViewModel.setScriptId(commentsItemBean.getScriptInfo().getId());
                this.spoilerSwitchView.setVisibility(0);
                this.spoilerSwitchView.setIsSpoiler(commentsItemBean.isSpoilerType());
                this.correlationView.setDefaultData(commentsItemBean.getAssociatedStoreNum(), CorrelationType.STORE, commentsItemBean.getScriptInfo().getId());
                if (commentsItemBean.getStoreInfo() != null) {
                    this.correlationView.setSelectData(commentsItemBean.getStoreInfo().getStoreId(), commentsItemBean.getStoreInfo().getStoreName());
                }
            }
            this.videoBean = commentsItemBean.getVideoDO();
            handleEditContent();
            gradesDesc(str);
            renderSubItemEvaluate(arrayList);
            updateIssueButtonStatus();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRatingPartStaticData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731255139")) {
            ipChange.ipc$dispatch("-731255139", new Object[]{this, str});
            return;
        }
        this.mDMRatingBar.setMarkDrawable(R$drawable.rating_fill, R$drawable.rating_empty);
        setTeachGoodEvaluate();
        if ("1".equals(str)) {
            this.mIssueEvaluateTip.setText("店铺打分");
            this.mEditor.setHint(getString(R$string.issue_store_edit_hint));
            this.mDMRatingBar.setMarkDrawable(R$drawable.rating_fill_type_2, R$drawable.rating_empty_type_2);
        } else if ("2".equals(str)) {
            this.mIssueEvaluateTip.setText("剧本打分");
            this.mEditor.setHint(getString(R$string.issue_script_edit_hint));
        } else {
            this.mIssueEvaluateTip.setText("总体打分");
        }
        this.mDMRatingBar.invalidate();
    }

    private void setTeachGoodEvaluate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1368174556")) {
            ipChange.ipc$dispatch("-1368174556", new Object[]{this});
            return;
        }
        this.mTeachGoodEvaluate.setVisibility(0);
        this.mTeachGoodEvaluate.setText("😉想被精选么？点我");
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", d20.E());
        String str = this.issueViewModel.isEvaluate() ? this.issueViewModel.getmItemId() : "";
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("item_id", str);
        }
        cn.damai.common.user.c.e().G(this.mTeachGoodEvaluate, "tips", "top", r21.PAGE_EVALUATE_SUBMIT, hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setmEvaGiftContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1804278999")) {
            ipChange.ipc$dispatch("-1804278999", new Object[]{this});
        } else if (isActivityOk()) {
            SpannableStringBuilder spannableStringBuilder = this.issueViewModel.setmEvaGiftContent(getActivity(), xf2.e(this.mShowNiePhoto.getData()));
            if (spannableStringBuilder == null || spannableStringBuilder.length() <= 0) {
                this.mEvaGift.setVisibility(8);
                return;
            }
            this.mEvaGift.setVisibility(0);
            this.mEvaGift.setText(spannableStringBuilder);
        }
    }

    private void showEditorLimitTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084676099")) {
            ipChange.ipc$dispatch("1084676099", new Object[]{this});
        } else if (this.issueViewModel.inputCount() >= this.mEditorLimit) {
            ToastUtil.i("字数超限，最多可以输入10000字哦~");
        }
    }

    private void updateCircle(QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818558737")) {
            ipChange.ipc$dispatch("-818558737", new Object[]{this, queryThemeCliqueInfoBean});
        } else if (!TextUtils.isEmpty(queryThemeCliqueInfoBean.getName())) {
            this.clCircleLayout.setVisibility(0);
            this.issueCircleSelect.i(queryThemeCliqueInfoBean);
            this.tvCircleContent.setText(queryThemeCliqueInfoBean.getName());
            this.ivCircleScreen.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCoverFail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349940303")) {
            ipChange.ipc$dispatch("-349940303", new Object[]{this});
            return;
        }
        this.mIsRequestLoading = 0;
        stopProgressDialog();
        this.mShowNiePhoto.setIsSortable(true);
        ToastUtil.a().e(getActivity(), getResources().getString(R$string.issue_add_video_upload_fail));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if ("0".equals(r5.issueViewModel.getmTargetId()) == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (checkUploadParamsValid() == 0) goto L_0x006c;
     */
    private void updateIssueButtonStatus() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1147046423")) {
            ipChange.ipc$dispatch("-1147046423", new Object[]{this});
            return;
        }
        if (!this.issueViewModel.isEvaluate() && !this.issueViewModel.isEdit()) {
            if (this.issueViewModel.isPrivilege()) {
                if (!xf2.j(this.issueViewModel.getmEditorContent())) {
                    if (this.issueViewModel.getmGrades() > 0) {
                    }
                }
            }
            updateIssueButtonStatus(z2);
        } else if (!xf2.j(this.issueViewModel.getmEditorContent())) {
            if (this.issueViewModel.getmGrades() > 0) {
            }
        }
        z = false;
        z2 = z;
        updateIssueButtonStatus(z2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateTheme(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "461912039")) {
            ipChange.ipc$dispatch("461912039", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.llThemeLayout.setVisibility(0);
            TextView textView = this.tvThemeContent;
            if (str.length() > 14) {
                str2 = str.substring(0, 14) + "...";
            } else {
                str2 = str;
            }
            textView.setText(str2);
            this.issueViewModel.setThemeName(str);
        } else {
            this.issueViewModel.setThemeName("");
            this.llThemeLayout.setVisibility(8);
        }
    }

    private void updateThemeByPojId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378984526")) {
            ipChange.ipc$dispatch("-378984526", new Object[]{this, str, str2});
            return;
        }
        startProgressDialog();
        if (this.themeObserver == null) {
            this.themeObserver = new Observer<QueryThemeResultBean>() {
                /* class cn.damai.issue.IssueFragment.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onChanged(@Nullable QueryThemeResultBean queryThemeResultBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "408945125")) {
                        ipChange.ipc$dispatch("408945125", new Object[]{this, queryThemeResultBean});
                        return;
                    }
                    IssueFragment.this.stopProgressDialog();
                    if (queryThemeResultBean != null) {
                        IssueFragment.this.bindInputTips(queryThemeResultBean.getIconTitle());
                        if (!IssueFragment.this.issueViewModel.isComeFromTheme()) {
                            IssueFragment.this.issueViewModel.setThemeId(String.valueOf(queryThemeResultBean.getThemeId()));
                            IssueFragment.this.updateTheme(queryThemeResultBean.getThemeName());
                        }
                        if (IssueFragment.this.issueViewModel.isComeFromCircle()) {
                            return;
                        }
                        if (queryThemeResultBean.getCliqueInfos() != null) {
                            IssueFragment.this.updateCircle((IssueFragment) queryThemeResultBean.getCliqueInfos());
                            IssueFragment issueFragment = IssueFragment.this;
                            issueFragment.issueViewModel.setCircle(issueFragment.issueCircleSelect.f());
                            IssueFragment.this.issueViewModel.setCircleList(queryThemeResultBean.getCliqueInfos());
                            return;
                        }
                        IssueFragment.this.issueViewModel.setCircle(null);
                        IssueFragment.this.issueViewModel.setCircleList(null);
                        IssueFragment.this.updateCircle((IssueFragment) new ArrayList());
                        return;
                    }
                    IssueFragment.this.issueViewModel.setThemeId("");
                    IssueFragment.this.issueViewModel.setThemeName("");
                    IssueFragment.this.updateTheme("");
                }
            };
        }
        String str3 = "1";
        if (str3.equals(str2) || "3".equals(str2)) {
            str3 = "0";
        }
        this.issueViewModel.requestThemeTipsByPojId(str, str3).observe(this, this.themeObserver);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateVideoBean(String str) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308122715")) {
            ipChange.ipc$dispatch("-308122715", new Object[]{this, str});
            return;
        }
        CommentsVideoBean commentsVideoBean = this.videoBean;
        if (commentsVideoBean != null && (bitmap = this.coverBitmap) != null) {
            commentsVideoBean.setHeight(String.valueOf(bitmap.getHeight()));
            this.videoBean.setWidth(String.valueOf(this.coverBitmap.getWidth()));
            this.videoBean.setCoverUrl(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void uploadVideoCover(Bitmap bitmap, FileUploadListener fileUploadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-381075200")) {
            ipChange.ipc$dispatch("-381075200", new Object[]{this, bitmap, fileUploadListener, Boolean.valueOf(z)});
        } else if (isNetAvailable()) {
            g91.c("uploader fileUrl", "封面上传有网络");
            if (z) {
                try {
                    this.mShowNiePhoto.setIsSortable(false);
                    this.mIsRequestLoading = 3;
                    startProgressDialog();
                } catch (Exception e2) {
                    if (z) {
                        updateCoverFail();
                    } else {
                        delVideo(true);
                    }
                    e2.printStackTrace();
                    if (bitmap == null) {
                        return;
                    }
                } catch (Throwable th) {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            }
            String initPicPath = this.issueViewModel.initPicPath(this.mFilePath);
            this.mFilePath = initPicPath;
            if (!xf2.j(initPicPath) && bitmap != null) {
                this.coverBitmap = bitmap;
                String str = this.mFilePath + "/coverUrl.jpg";
                cn.damai.common.util.a.d(str);
                cn.damai.common.util.a.u(bitmap, str);
                FileUploader q = FileUploader.q("damai_comment_oss");
                this.mCoverUploader = q;
                q.C(fileUploadListener).D(str);
            } else if (z) {
                updateCoverFail();
            } else {
                delVideo(true);
            }
            if (bitmap == null) {
                return;
            }
            bitmap.recycle();
        } else {
            if (z) {
                updateCoverFail();
            } else {
                delVideo(false);
                ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
            }
            g91.c("uploader fileUrl", "封面上传无网络");
        }
    }

    private void uploader(String str, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493389051")) {
            ipChange.ipc$dispatch("1493389051", new Object[]{this, str, Long.valueOf(j2)});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        g91.c("uploader start", currentTimeMillis + "");
        this.mIsRequestLoading = 2;
        if (isNetAvailable()) {
            g91.c("uploader fileUrl", "有网络");
            FileUploader q = FileUploader.q(nv2.MtopUploadBiz);
            this.mVideoUploader = q;
            q.C(new b(currentTimeMillis, j2, str)).D(str);
            this.mShowNiePhoto.post(new Runnable() {
                /* class cn.damai.issue.IssueFragment.AnonymousClass12 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-420593195")) {
                        ipChange.ipc$dispatch("-420593195", new Object[]{this});
                    } else if (IssueFragment.this.mShowNiePhoto != null) {
                        IssueFragment.this.mShowNiePhoto.notifyItemChanged(0, "start");
                    }
                }
            });
            return;
        }
        g91.c("uploader ", "无网络 ");
        delVideo(false);
        ToastUtil.i(getResources().getString(R$string.damai_base_net_toast));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void uploadingTip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132711629")) {
            ipChange.ipc$dispatch("-1132711629", new Object[]{this});
            return;
        }
        int i2 = this.mIsRequestLoading;
        if (i2 == 2) {
            ToastUtil.i("视频上传中，请稍等");
        } else if (i2 == 3) {
            ToastUtil.i("封面上传中，请稍等");
        }
    }

    public final <T extends View> T findViewById(@IdRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561672264")) {
            return (T) ((View) ipChange.ipc$dispatch("1561672264", new Object[]{this, Integer.valueOf(i2)}));
        } else if (i2 == -1) {
            return null;
        } else {
            return (T) this.rootView.findViewById(i2);
        }
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public Activity getDraftActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "278530261")) {
            return getActivity();
        }
        return (Activity) ipChange.ipc$dispatch("278530261", new Object[]{this});
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    public List<QueryThemeCliqueInfoBean> getDraftCircle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704021387")) {
            return (List) ipChange.ipc$dispatch("-1704021387", new Object[]{this});
        } else if (this.issueCircleSelect == null) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.issueCircleSelect.f());
            return arrayList;
        }
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    public List<QueryThemeCliqueInfoBean> getDraftCircleList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508079053")) {
            return (List) ipChange.ipc$dispatch("-1508079053", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getCircleList();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public DraftExtra getDraftExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1732927376")) {
            return (DraftExtra) ipChange.ipc$dispatch("-1732927376", new Object[]{this});
        }
        DraftExtra draftExtra = this.mTempDraftExtra;
        if (draftExtra != null) {
            return new DraftExtra(draftExtra);
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012167294")) {
            return (String) ipChange.ipc$dispatch("-2012167294", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getmEditorContent();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftItemType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1121873963")) {
            return (String) ipChange.ipc$dispatch("1121873963", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getItemType();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftStoreId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030944084")) {
            return (String) ipChange.ipc$dispatch("1030944084", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getStoreId();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752151553")) {
            return (String) ipChange.ipc$dispatch("752151553", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getThemeName();
        }
        return null;
    }

    @Override // cn.damai.issue.tool.IDraftContentProvider
    @Nullable
    public String getDraftThemeId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252611132")) {
            return (String) ipChange.ipc$dispatch("1252611132", new Object[]{this});
        }
        IssueViewModel issueViewModel2 = this.issueViewModel;
        if (issueViewModel2 != null) {
            return issueViewModel2.getThemeId();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1351409346")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1351409346", new Object[]{this})).intValue();
    }

    @Override // cn.damai.comment.view.DMCommentSubItemView.GradeChangeLister
    public void gradeChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "354881046")) {
            ipChange.ipc$dispatch("354881046", new Object[]{this});
            return;
        }
        updateIssueButtonStatus();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219487622")) {
            ipChange.ipc$dispatch("219487622", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        getRenderTags();
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414957211")) {
            ipChange.ipc$dispatch("-414957211", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    @RequiresApi(api = 12)
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-475153896")) {
            ipChange.ipc$dispatch("-475153896", new Object[]{this});
        } else if (getActivity() != null) {
            initIssueViewModel();
            initContentView();
            HashMap hashMap = new HashMap();
            hashMap.put("usercode", d20.E());
            r21.m(hashMap);
            cn.damai.common.user.c.e().G(this.mIssueTitleConfirm, "release", "bottom", r21.PAGE_EVALUATE_SUBMIT, hashMap);
            registerListener();
            initSetting();
            setDamaiUTKeyBuilder(r21.i().j());
            r21.i().l(this.issueViewModel, this.correlationView);
            if ((!TextUtils.isEmpty(this.issueViewModel.getmItemId()) && this.issueViewModel.isEvaluate()) || this.issueViewModel.getScriptId() != null) {
                getRenderTags();
            } else if (TextUtils.isEmpty(this.issueViewModel.getmCommentId()) || !this.issueViewModel.isEdit()) {
                dispatchDraftCheckIfNeed();
            } else {
                requestEvaluateDetail();
            }
        }
    }

    public boolean isActivityOk() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11100196")) {
            return ((Boolean) ipChange.ipc$dispatch("-11100196", new Object[]{this})).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441805313")) {
            ipChange.ipc$dispatch("-1441805313", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        g91.b("wpf", "onActivityResult/in data:");
        if (i3 != -1) {
            return;
        }
        if (i2 == 17) {
            onSelectAlbumResult(intent, "1");
        } else if (i2 != 18) {
            switch (i2) {
                case 103:
                    if (intent == null || !"3".equals(intent.getStringExtra(IssueConstants.privilegeType))) {
                        privilegeView(true, intent, false);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("projectName");
                    String stringExtra2 = intent.getStringExtra("projectImage");
                    String stringExtra3 = intent.getStringExtra("timeAddress");
                    String stringExtra4 = intent.getStringExtra("targetId");
                    String stringExtra5 = intent.getStringExtra("time");
                    if (this.issueViewModel.getCircle() == null || !this.issueViewModel.isComeFromCircle()) {
                        str2 = null;
                        str = null;
                    } else {
                        str2 = String.valueOf(this.issueViewModel.getCircle().getId());
                        str = this.issueViewModel.getCircle().getName();
                    }
                    if (this.issueViewModel.isComeFromTheme()) {
                        String themeId = this.issueViewModel.getThemeId();
                        str3 = this.issueViewModel.getThemeName();
                        str4 = themeId;
                    } else {
                        str4 = null;
                        str3 = null;
                    }
                    CommentItemMoreUtil.h(getActivity(), stringExtra4, intent.getStringExtra(IssueConstants.ProjectID), stringExtra, stringExtra2, stringExtra5, stringExtra3, str2, str, str4, str3);
                    finish();
                    return;
                case 104:
                    onBackFromShare(intent);
                    return;
                case 105:
                    if (intent != null) {
                        ScriptSelectMo scriptSelectMo = (ScriptSelectMo) intent.getSerializableExtra("selectResult");
                        if (scriptSelectMo != null) {
                            this.correlationView.setSelectData(scriptSelectMo.getTargetId(), scriptSelectMo.getTargetName());
                        } else {
                            this.correlationView.setSelectData(null, null);
                            this.correlationView.restore();
                        }
                        updateIssueButtonStatus();
                        return;
                    }
                    return;
                default:
                    switch (i2) {
                        case 1000:
                            requestIssue();
                            return;
                        case 1001:
                            onSelectAlbumResult(intent, "2");
                            return;
                        case 1002:
                            onPreviewVideoResult(intent);
                            return;
                        case 1003:
                            onCoverVideoResult(intent);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            onPreviewImageResult(intent);
        }
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57417599")) {
            ipChange.ipc$dispatch("-57417599", new Object[]{this});
            return;
        }
        onBackClicked();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685556734")) {
            ipChange.ipc$dispatch("1685556734", new Object[]{this, view});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967622366")) {
            return (View) ipChange.ipc$dispatch("-1967622366", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(R$layout.activity_issue, viewGroup, false);
        this.rootView = inflate;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-505594654")) {
            ipChange.ipc$dispatch("-505594654", new Object[]{this});
            return;
        }
        super.onDestroy();
        FileUploader fileUploader = this.mCoverUploader;
        if (fileUploader != null) {
            fileUploader.p();
            this.mCoverUploader = null;
        }
        FileUploader fileUploader2 = this.mSubmitUploader;
        if (fileUploader2 != null) {
            fileUploader2.p();
            this.mSubmitUploader = null;
        }
        IDraftBox iDraftBox = this.mDraftBox;
        if (iDraftBox != null) {
            iDraftBox.release();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseMvpFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "195672993")) {
            ipChange.ipc$dispatch("195672993", new Object[]{this});
            return;
        }
        super.onResume();
        keyBoradChangeView();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCircle(List<QueryThemeCliqueInfoBean> list, QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169090528")) {
            ipChange.ipc$dispatch("1169090528", new Object[]{this, list, queryThemeCliqueInfoBean});
            return;
        }
        this.issueCircleSelect.m(list);
        this.issueCircleSelect.i(queryThemeCliqueInfoBean);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateCircle(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172684645")) {
            ipChange.ipc$dispatch("172684645", new Object[]{this, list});
            return;
        }
        this.issueViewModel.setCircleList(list);
        this.issueCircleSelect.m(list);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateIssueButtonStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198654965")) {
            ipChange.ipc$dispatch("-1198654965", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIssueTitleConfirm.setEnabled(true);
        if (z) {
            this.mIssueTitleConfirm.setBackgroundResource(R$drawable.issue_issue_button_bg);
        } else {
            this.mIssueTitleConfirm.setBackgroundResource(R$drawable.comment_submit_unable_btn_99);
        }
    }
}
