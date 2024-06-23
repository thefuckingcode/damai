package cn.damai.comment.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.comment.bean.CommentTextDoBean;
import cn.damai.comment.bean.CommentUserDoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.bean.ContentDetailItem;
import cn.damai.comment.bean.FollowStateBean;
import cn.damai.comment.bean.HotDiscussBean;
import cn.damai.comment.listener.OnPraiseViewClickListenerNew;
import cn.damai.comment.request.FollowRequest;
import cn.damai.comment.util.NineImgUtil;
import cn.damai.comment.util.SoftInputUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.im.UserInfoUtil;
import cn.damai.issue.net.IssueRequest;
import cn.damai.issue.net.IssueResponse;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import cn.damai.uikit.view.DMAvatar;
import cn.damai.uikit.view.NineGridlayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.d20;
import tb.f92;
import tb.gr;
import tb.if2;
import tb.ta;
import tb.up2;
import tb.za;

/* compiled from: Taobao */
public class DMHotDiscussView extends LinearLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cntContentId;
    ViewFlipper[] flippers;
    boolean foucusState = false;
    private HotDiscussBean hotDiscussBean;
    int[] ids = {R$id.comment_hl_content_flipper1, R$id.comment_hl_content_flipper2};
    private String itemId;
    private LottieAnimationView mAnimView;
    private Context mContext;
    private EditText mInput;
    private String mInputContent;
    private TextView mPublishBtn;
    private CommentsItemBean preCommentBean;
    private String spmb = ta.PROJECT_PAGE;
    private String spmc = "hot_discussion";

    /* compiled from: Taobao */
    public class a implements OnPraiseViewClickListenerNew {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PraiseView a;

        a(PraiseView praiseView) {
            this.a = praiseView;
        }

        @Override // cn.damai.comment.listener.OnPraiseViewClickListenerNew
        public void OnPraiseViewClick(boolean z, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1540370558")) {
                ipChange.ipc$dispatch("1540370558", new Object[]{this, Boolean.valueOf(z), str});
                return;
            }
            cn.damai.common.user.c.e().x(new a.b().i(DMHotDiscussView.this.spmb).f(DMHotDiscussView.this.spmc).l("likesbtn").g(false).j(DMHotDiscussView.this.getCommonUtMap()));
            if (this.a.getPraiseInfo().isHasPraised()) {
                DMHotDiscussView.this.mAnimView.setVisibility(0);
                DMHotDiscussView.this.mAnimView.setAnimation("avatar/data.json");
                DMHotDiscussView.this.mAnimView.setRepeatCount(5);
                DMHotDiscussView.this.mAnimView.playAnimation();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements SoftInputUtils.OnSoftKeyboardChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.comment.util.SoftInputUtils.OnSoftKeyboardChangeListener
        public void onSoftKeyBoardChange(int i, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1510341388")) {
                ipChange.ipc$dispatch("-1510341388", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            } else if (!z) {
                DMHotDiscussView.this.mPublishBtn.setVisibility(8);
            } else if (!LoginManager.k().q()) {
                LoginManager.k().v(DMHotDiscussView.this.getContext());
            } else {
                DMHotDiscussView.this.mPublishBtn.setVisibility(0);
                DMHotDiscussView.this.mInput.setFocusable(true);
                DMHotDiscussView.this.mInput.setFocusableInTouchMode(true);
                DMHotDiscussView.this.mInput.requestFocus();
                DMHotDiscussView.this.mInput.findFocus();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-586315358")) {
                ipChange.ipc$dispatch("-586315358", new Object[]{this, editable});
                return;
            }
            DMHotDiscussView.this.mInputContent = editable.toString();
            DMHotDiscussView dMHotDiscussView = DMHotDiscussView.this;
            dMHotDiscussView.updatePublishBtuttonEnable(!TextUtils.isEmpty(dMHotDiscussView.mInputContent));
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-62461983")) {
                ipChange.ipc$dispatch("-62461983", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "39433473")) {
                ipChange.ipc$dispatch("39433473", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements NineImgUtil.OnClickExtraListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d(DMHotDiscussView dMHotDiscussView) {
        }

        @Override // cn.damai.comment.util.NineImgUtil.OnClickExtraListener
        public void onExtraLister(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-234798150")) {
                ipChange.ipc$dispatch("-234798150", new Object[]{this, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ boolean a;
        final /* synthetic */ TextView b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ Context f;
        final /* synthetic */ int g;

        e(DMHotDiscussView dMHotDiscussView, boolean z, TextView textView, String str, String str2, int i, Context context, int i2) {
            this.a = z;
            this.b = textView;
            this.c = str;
            this.d = str2;
            this.e = i;
            this.f = context;
            this.g = i2;
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1696043716")) {
                ipChange.ipc$dispatch("-1696043716", new Object[]{this});
                return;
            }
            if (this.a) {
                this.b.setText(this.c);
            } else {
                int paddingLeft = this.b.getPaddingLeft();
                int paddingRight = this.b.getPaddingRight();
                CharSequence ellipsize = TextUtils.ellipsize(this.c, this.b.getPaint(), ((float) (((this.b.getWidth() - paddingLeft) - paddingRight) * this.e)) - (this.b.getTextSize() * ((float) this.d.length())), TextUtils.TruncateAt.END);
                if (ellipsize.length() < this.c.length()) {
                    String str = ((Object) ellipsize) + this.d;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f.getResources().getColor(this.g)), str.length() - this.d.length(), str.length(), 17);
                    this.b.setText(spannableStringBuilder);
                } else {
                    this.b.setText(this.c);
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    public DMHotDiscussView(Context context) {
        super(context);
        initView(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Map getCommonUtMap() {
        ContentDetailItem contentDetailItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1211372014")) {
            return (Map) ipChange.ipc$dispatch("1211372014", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.itemId);
        hashMap.put("city", d20.c());
        if (!TextUtils.isEmpty(this.cntContentId)) {
            hashMap.put(za.CNT_CONTENT_ID, this.cntContentId);
            hashMap.put("quanziid", this.cntContentId);
        }
        HotDiscussBean hotDiscussBean2 = this.hotDiscussBean;
        if (!(hotDiscussBean2 == null || (contentDetailItem = hotDiscussBean2.contentDetail) == null)) {
            hashMap.put("content_id", contentDetailItem.contentId);
            hashMap.put("content_type", "note");
        }
        return hashMap;
    }

    private View getFlipperItem(CommentsItemBean commentsItemBean) {
        CommentTextDoBean commentTextDoBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "105051278")) {
            return (View) ipChange.ipc$dispatch("105051278", new Object[]{this, commentsItemBean});
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.hcomment_hl_flipper_item, (ViewGroup) null);
        if (commentsItemBean == null || commentsItemBean.getTextDOList() == null || commentsItemBean.getTextDOList().size() == 0 || (commentTextDoBean = commentsItemBean.getTextDOList().get(0)) == null || TextUtils.isEmpty(commentTextDoBean.getValue())) {
            return null;
        }
        TextView textView = (TextView) inflate.findViewById(R$id.tv_people_comment);
        String value = commentTextDoBean.getValue();
        if (!TextUtils.isEmpty(value)) {
            textView.setVisibility(0);
            textView.setText(value);
        }
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_user_date);
        String gmtDisplay = commentsItemBean.getGmtDisplay();
        if (!TextUtils.isEmpty(gmtDisplay)) {
            textView2.setText(gmtDisplay);
            textView2.setVisibility(0);
        }
        DMAvatar dMAvatar = (DMAvatar) inflate.findViewById(R$id.user_icon_dmavatar);
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_20x20);
        if (commentsItemBean.getUserDO() != null) {
            CommentUserDoBean userDO = commentsItemBean.getUserDO();
            setUserData(dMAvatar, userDO.getHeaderImage(), userDO.isVip(), userDO.getMemberFlag());
        } else {
            dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
        }
        return inflate;
    }

    private void initPublishArea() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1149367927")) {
            ipChange.ipc$dispatch("-1149367927", new Object[]{this});
            return;
        }
        setMyAvatar((cn.damai.uikit.view.DMAvatar) findViewById(R$id.comment_hl_myavatar));
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.comment_reply_contentll);
        EditText editText = (EditText) findViewById(R$id.comment_reply_content_et);
        this.mInput = editText;
        editText.setFocusable(true);
        this.mInput.setFocusableInTouchMode(true);
        TextView textView = (TextView) findViewById(R$id.content_detail_publisher_btn);
        this.mPublishBtn = textView;
        textView.setOnClickListener(this);
        new SoftInputUtils();
        SoftInputUtils.c((Activity) this.mContext, new b());
        this.mInput.addTextChangedListener(new c());
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611848472")) {
            ipChange.ipc$dispatch("-1611848472", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        LayoutInflater.from(context).inflate(R$layout.ll_common_comment_highlight_view, (ViewGroup) this, true);
        ViewFlipper[] viewFlipperArr = new ViewFlipper[2];
        this.flippers = viewFlipperArr;
        viewFlipperArr[0] = (ViewFlipper) findViewById(this.ids[0]);
        this.flippers[1] = (ViewFlipper) findViewById(this.ids[1]);
    }

    private void initViewFlipper(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025934123")) {
            ipChange.ipc$dispatch("1025934123", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            int i = 0;
            while (i < list.size() && i < 2) {
                this.flippers[i].setVisibility(0);
                this.flippers[i].removeAllViews();
                this.flippers[i].addView(getFlipperItem(list.get(i)));
                i++;
            }
        }
    }

    private void setImageGrid(ContentDetailItem contentDetailItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687907390")) {
            ipChange.ipc$dispatch("-1687907390", new Object[]{this, contentDetailItem});
            return;
        }
        NineGridlayout nineGridlayout = (NineGridlayout) findViewById(R$id.comment_hl_content_pics);
        nineGridlayout.setAutoShrink(true);
        nineGridlayout.setSingleWH(-1, -1);
        CommentsItemBean commentsItemBean = new CommentsItemBean();
        if (contentDetailItem.image != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<ContentDetailItem.ContentBanner> it = contentDetailItem.image.iterator();
            while (it.hasNext()) {
                CommentImageInfoBean commentImageInfoBean = new CommentImageInfoBean();
                commentImageInfoBean.url = it.next().url;
                arrayList.add(commentImageInfoBean);
            }
            commentsItemBean.setImageDOList(arrayList);
        }
        CommentsVideoBean commentsVideoBean = new CommentsVideoBean();
        VideoInfo videoInfo = contentDetailItem.videoInfo;
        if (videoInfo != null) {
            commentsVideoBean.setCoverUrl(videoInfo.coverUrl);
            commentsVideoBean.setUrl(contentDetailItem.videoInfo.url);
            commentsVideoBean.setSourceLabel(contentDetailItem.videoInfo.sourceLabel);
            commentsVideoBean.setWidth(contentDetailItem.videoInfo.width);
            commentsVideoBean.setHeight(contentDetailItem.videoInfo.height);
        }
        commentsItemBean.setVideoDO(commentsVideoBean);
        setNineImgs(commentsItemBean, nineGridlayout, this.mContext);
    }

    private void setMyAvatar(cn.damai.uikit.view.DMAvatar dMAvatar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-583770855")) {
            ipChange.ipc$dispatch("-583770855", new Object[]{this, dMAvatar});
            return;
        }
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_20x20);
        if (LoginManager.k().q()) {
            UserData a2 = UserInfoUtil.a();
            if (a2 == null || a2.getUserBaseInfo() == null) {
                dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
                return;
            }
            UserBaseInfoBean userBaseInfo = a2.getUserBaseInfo();
            if (userBaseInfo == null || TextUtils.isEmpty(userBaseInfo.getHeadImg())) {
                dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
            } else {
                dMAvatar.setAvatar(userBaseInfo.getHeadImg());
            }
            if (userBaseInfo == null || !userBaseInfo.isVip()) {
                dMAvatar.setAvatarCrownVisibility(8);
                dMAvatar.setAvatarBorderVisibility(8);
                return;
            }
            dMAvatar.setAvatarBorderVisibility(0);
            dMAvatar.setAvatarCrownVisibility(0);
            return;
        }
        dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
    }

    private void setNineImgs(CommentsItemBean commentsItemBean, NineGridlayout nineGridlayout, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506663608")) {
            ipChange.ipc$dispatch("-1506663608", new Object[]{this, commentsItemBean, nineGridlayout, context});
            return;
        }
        List<CommentImageInfoBean> imageDOList = commentsItemBean.getImageDOList();
        nineGridlayout.setVisibility(0);
        if (context != null) {
            d dVar = new d(this);
            NineImgUtil.a().b(context, ((int) up2.d(context)) - up2.a(context, 42.0f), true, nineGridlayout, commentsItemBean, imageDOList, dVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTvStr(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1564752111")) {
            ipChange.ipc$dispatch("1564752111", new Object[]{this, Integer.valueOf(i), str, str2});
            return;
        }
        TextView textView = (TextView) findViewById(i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("0".equals(str)) {
            textView.setText(str2);
        } else {
            textView.setText(str);
        }
    }

    private void setUserData(cn.damai.uikit.view.DMAvatar dMAvatar, String str, boolean z, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638570485")) {
            ipChange.ipc$dispatch("-638570485", new Object[]{this, dMAvatar, str, Boolean.valueOf(z), str2});
        } else if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str)) {
                dMAvatar.setAvatar(str);
            } else {
                dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
            }
            if (z) {
                dMAvatar.setAvatarCrownVisibility(0);
                dMAvatar.setAvatarBorderVisibility(0);
                return;
            }
            dMAvatar.setAvatarCrownVisibility(8);
            dMAvatar.setAvatarBorderVisibility(8);
            dMAvatar.setYYMemberTagView(false, str2);
        } else {
            dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
        }
    }

    private void sumbitComment(ContentDetailItem contentDetailItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "60445088")) {
            ipChange.ipc$dispatch("60445088", new Object[]{this, contentDetailItem});
            return;
        }
        IssueRequest issueRequest = new IssueRequest();
        issueRequest.commentType = Constants.VIA_REPORT_TYPE_START_GROUP;
        String str = contentDetailItem.sourceId;
        issueRequest.targetId = str;
        issueRequest.targetType = "3";
        issueRequest.mainCommentId = str;
        issueRequest.sourceType = contentDetailItem.sourceType;
        issueRequest.text = this.mInputContent;
        issueRequest.request(new DMMtopRequestListener<IssueResponse>(IssueResponse.class) {
            /* class cn.damai.comment.view.DMHotDiscussView.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2127400638")) {
                    ipChange.ipc$dispatch("2127400638", new Object[]{this, str, str2});
                    return;
                }
                DMHotDiscussView.this.mInputContent = "";
                SoftInputUtils.a((Activity) DMHotDiscussView.this.mContext);
            }

            public void onSuccess(IssueResponse issueResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2075054839")) {
                    ipChange.ipc$dispatch("2075054839", new Object[]{this, issueResponse});
                    return;
                }
                DMHotDiscussView.this.mInputContent = "";
                DMHotDiscussView.this.mInput.setText(DMHotDiscussView.this.mInputContent);
                SoftInputUtils.a((Activity) DMHotDiscussView.this.mContext);
                if (issueResponse.getCommentsDO() != null) {
                    DMHotDiscussView.this.addNewComment(issueResponse.getCommentsDO());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateLikeBtn(boolean z) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101668453")) {
            ipChange.ipc$dispatch("-2101668453", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            i = R$drawable.dm_icon_like_select;
        } else {
            i = R$drawable.dm_icon_like_unselect;
        }
        ((ImageView) findViewById(R$id.comment_like_numicon)).setImageResource(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updatePublishBtuttonEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792110110")) {
            ipChange.ipc$dispatch("1792110110", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public void addNewComment(IssueResponse.CommentsDOBean commentsDOBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "45201968")) {
            ipChange.ipc$dispatch("45201968", new Object[]{this, commentsDOBean});
        } else if (commentsDOBean.getTextDOList() != null && !f92.d(commentsDOBean.getTextDOList()) && commentsDOBean.getTextDOList().get(0) != null && !TextUtils.isEmpty(commentsDOBean.getTextDOList().get(0).getValue())) {
            CommentsItemBean commentsItemBean = new CommentsItemBean();
            CommentTextDoBean commentTextDoBean = new CommentTextDoBean();
            commentTextDoBean.setValue(commentsDOBean.getTextDOList().get(0).getValue());
            ArrayList arrayList = new ArrayList();
            arrayList.add(commentTextDoBean);
            commentsItemBean.setTextDOList(arrayList);
            commentsItemBean.setGmtDisplay(commentsDOBean.getGmtDisplay());
            CommentUserDoBean commentUserDoBean = new CommentUserDoBean();
            if (commentsDOBean.getUserDO() != null) {
                commentUserDoBean.setHeaderImage(commentsDOBean.getUserDO().getHeaderImage());
                commentUserDoBean.setVip(commentsDOBean.getUserDO().vip);
                commentUserDoBean.setPerformFilmVipDO(commentsDOBean.getUserDO().performFilmVipDO);
            }
            commentsItemBean.setUserDO(commentUserDoBean);
            if (this.flippers[0].getVisibility() != 0) {
                this.flippers[0].setVisibility(0);
            }
            this.flippers[0].addView(getFlipperItem(commentsItemBean));
            this.flippers[0].showNext();
            if (this.preCommentBean != null) {
                if (this.flippers[1].getVisibility() != 0) {
                    this.flippers[1].setVisibility(0);
                }
                this.flippers[1].addView(getFlipperItem(this.preCommentBean));
                this.flippers[1].showNext();
            } else {
                HotDiscussBean.CommentList commentList = this.hotDiscussBean.commentList;
                if (commentList != null && !f92.d(commentList.comments)) {
                    if (this.flippers[1].getVisibility() != 0) {
                        this.flippers[1].setVisibility(0);
                    }
                    this.flippers[1].addView(getFlipperItem(this.hotDiscussBean.commentList.comments.get(0)));
                    this.flippers[1].showNext();
                }
            }
            this.preCommentBean = commentsItemBean;
        }
    }

    public void bindData(HotDiscussBean hotDiscussBean2) {
        ContentDetailItem contentDetailItem;
        String str;
        SpannableStringBuilder spannableStringBuilder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678107098")) {
            ipChange.ipc$dispatch("-678107098", new Object[]{this, hotDiscussBean2});
        } else if (hotDiscussBean2 == null || (contentDetailItem = hotDiscussBean2.contentDetail) == null) {
            setVisibility(8);
        } else {
            this.hotDiscussBean = hotDiscussBean2;
            this.preCommentBean = null;
            if (hotDiscussBean2.themeInfo != null) {
                TextView textView = (TextView) findViewById(R$id.comment_hl_themetitle);
                textView.setVisibility(0);
                String str2 = hotDiscussBean2.themeInfo.name;
                if (!TextUtils.isEmpty(str2)) {
                    spannableStringBuilder = if2.b(this.mContext, R$drawable.icon_theme_title_prefix_blue, str2);
                } else {
                    spannableStringBuilder = "";
                }
                textView.setText(spannableStringBuilder);
                textView.setOnClickListener(this);
            }
            if (contentDetailItem.userInfo != null) {
                ((TextView) findViewById(R$id.comment_hl_username)).setText(contentDetailItem.userInfo.nickname);
                cn.damai.uikit.view.DMAvatar dMAvatar = (cn.damai.uikit.view.DMAvatar) findViewById(R$id.comment_hl_avatar);
                dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_20x20);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R$id.comment_hl_avatar_anim);
                this.mAnimView = lottieAnimationView;
                lottieAnimationView.setVisibility(8);
                ContentDetailItem.ContentUserInfo contentUserInfo = contentDetailItem.userInfo;
                PerformFilmVipDO performFilmVipDO = contentUserInfo.performFilmVipDO;
                if (performFilmVipDO != null) {
                    str = performFilmVipDO.memberFlag;
                } else {
                    str = "";
                }
                setUserData(dMAvatar, contentUserInfo.headImg, contentUserInfo.vip, str);
            }
            ArrayList<ContentDetailItem.ContentText> arrayList = contentDetailItem.content;
            if (arrayList != null && arrayList.size() > 0) {
                TextView textView2 = (TextView) findViewById(R$id.comment_hl_content);
                textView2.setOnClickListener(this);
                toggleEllipsize(getContext(), textView2, 2, contentDetailItem.content.get(0).value, "更多", R$color.color_9C9CA5, false);
            }
            setImageGrid(contentDetailItem);
            if (contentDetailItem.praiseInfo != null) {
                PraiseView praiseView = (PraiseView) findViewById(R$id.comment_hl_praise_layout);
                CommentPraiseInfoBean commentPraiseInfoBean = new CommentPraiseInfoBean();
                commentPraiseInfoBean.setPraiseCount(contentDetailItem.praiseInfo.praiseCount + "");
                commentPraiseInfoBean.setHasPraised(contentDetailItem.praiseInfo.hasPraised);
                praiseView.setData(commentPraiseInfoBean, contentDetailItem.sourceId);
                praiseView.setOnPraiseLayoutClickListenerCommon(new a(praiseView));
            }
            int i = R$id.comment_like_num;
            setTvStr(i, contentDetailItem.focusCount + "", "想看");
            updateLikeBtn(contentDetailItem.focus);
            findViewById(R$id.comment_like_layout).setOnClickListener(this);
            this.foucusState = contentDetailItem.focus;
            findViewById(R$id.comment_reply_layout).setOnClickListener(this);
            HotDiscussBean.CommentList commentList = this.hotDiscussBean.commentList;
            if (commentList != null) {
                initViewFlipper(commentList.comments);
                if (this.hotDiscussBean.commentList.comments != null) {
                    int i2 = R$id.comment_num_reply;
                    setTvStr(i2, this.hotDiscussBean.commentList.totalComment + "", "回复");
                }
            }
            initPublishArea();
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", this.itemId);
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            String str3 = this.spmc;
            e2.G(this, str3, str3, this.spmb, hashMap);
        }
    }

    public void onClick(View view) {
        HotDiscussBean hotDiscussBean2;
        ContentDetailItem contentDetailItem;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530358586")) {
            ipChange.ipc$dispatch("-1530358586", new Object[]{this, view});
            return;
        }
        Map<String, String> commonUtMap = getCommonUtMap();
        if (view.getId() == R$id.comment_like_layout) {
            HotDiscussBean hotDiscussBean3 = this.hotDiscussBean;
            if (hotDiscussBean3 != null && (contentDetailItem = hotDiscussBean3.contentDetail) != null) {
                requestFollow(contentDetailItem, view, hotDiscussBean3.card);
                commonUtMap.put("status", this.foucusState ? "0" : "1");
                cn.damai.common.user.c.e().x(new a.b().i(this.spmb).f(this.spmc).l("favorite").g(false).j(commonUtMap));
            }
        } else if (view.getId() == R$id.comment_reply_layout) {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(getContext());
                return;
            }
            EditText editText = (EditText) findViewById(R$id.comment_reply_content_et);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
            cn.damai.common.user.c.e().x(new a.b().i(this.spmb).f(this.spmc).l(com.taobao.aranger.constant.Constants.PARAM_REPLY).g(false).j(commonUtMap));
        } else if (view.getId() == R$id.comment_hl_themetitle) {
            HotDiscussBean hotDiscussBean4 = this.hotDiscussBean;
            if (hotDiscussBean4 != null && hotDiscussBean4.themeInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putString("themeId", this.hotDiscussBean.themeInfo.id);
                DMNav.from(this.mContext).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_THEME));
                commonUtMap.put(za.CNT_CONTENT_ID, this.hotDiscussBean.themeInfo.id);
                commonUtMap.put("titlelabel", this.hotDiscussBean.themeInfo.name);
                cn.damai.common.user.c.e().x(new a.b().i(this.spmb).f(this.spmc).l("theme").g(true).j(commonUtMap));
            }
        } else if (view.getId() == R$id.comment_hl_content) {
            HotDiscussBean hotDiscussBean5 = this.hotDiscussBean;
            if (hotDiscussBean5 != null && hotDiscussBean5.contentDetail != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("contentId", this.hotDiscussBean.contentDetail.contentId);
                DMNav.from(this.mContext).withExtras(bundle2).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
                cn.damai.common.user.c.e().x(new a.b().i(this.spmb).f(this.spmc).l("hot_discussion").g(true).j(commonUtMap));
            }
        } else if (view.getId() == R$id.content_detail_publisher_btn && (hotDiscussBean2 = this.hotDiscussBean) != null && hotDiscussBean2.contentDetail != null) {
            if (!LoginManager.k().q()) {
                LoginManager.k().v(getContext());
                return;
            }
            sumbitComment(this.hotDiscussBean.contentDetail);
            cn.damai.common.user.c.e().x(new a.b().i(this.spmb).f(this.spmc).l("reply_send").g(false).j(commonUtMap));
        }
    }

    public void requestFollow(ContentDetailItem contentDetailItem, final View view, HotDiscussBean.Card card) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165321003")) {
            ipChange.ipc$dispatch("-165321003", new Object[]{this, contentDetailItem, view, card});
        } else if (contentDetailItem != null) {
            boolean z = this.foucusState;
            String str = "19:" + contentDetailItem.contentId;
            if (!z && card != null && !TextUtils.isEmpty(card.targetId) && !TextUtils.isEmpty(card.targetType)) {
                str = str + "," + card.targetType + ":" + card.targetId;
            }
            FollowRequest followRequest = new FollowRequest(!z, str);
            view.setClickable(false);
            followRequest.request(new DMMtopRequestListener<FollowStateBean>(FollowStateBean.class) {
                /* class cn.damai.comment.view.DMHotDiscussView.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2135159997")) {
                        ipChange.ipc$dispatch("2135159997", new Object[]{this, str, str2});
                        return;
                    }
                    Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + str + " , " + str2);
                    view.setClickable(true);
                }

                public void onSuccess(FollowStateBean followStateBean) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-160784059")) {
                        ipChange.ipc$dispatch("-160784059", new Object[]{this, followStateBean});
                        return;
                    }
                    boolean isFollowed = followStateBean.isFollowed();
                    DMHotDiscussView dMHotDiscussView = DMHotDiscussView.this;
                    dMHotDiscussView.foucusState = isFollowed;
                    dMHotDiscussView.updateLikeBtn(isFollowed);
                    try {
                        TextView textView = (TextView) DMHotDiscussView.this.findViewById(R$id.comment_like_num);
                        if (DMHotDiscussView.this.hotDiscussBean.contentDetail != null) {
                            int i = DMHotDiscussView.this.hotDiscussBean.contentDetail.focusCount;
                            if (followStateBean.status.equals("0")) {
                                String str = ((Object) textView.getText()) + "";
                                if (str != null) {
                                    try {
                                        i = Integer.parseInt(str);
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (i > 0) {
                                    i--;
                                }
                            } else {
                                i++;
                            }
                            DMHotDiscussView.this.setTvStr(R$id.comment_like_num, i + "", "想看");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    view.setClickable(true);
                }
            });
        }
    }

    public void setBackground(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227477871")) {
            ipChange.ipc$dispatch("227477871", new Object[]{this, str});
            return;
        }
        findViewById(R$id.ll_follow).setBackgroundColor(Color.parseColor(str));
    }

    public void setCntContentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107867342")) {
            ipChange.ipc$dispatch("-107867342", new Object[]{this, str});
            return;
        }
        this.cntContentId = str;
    }

    public void setItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939558897")) {
            ipChange.ipc$dispatch("-1939558897", new Object[]{this, str});
            return;
        }
        this.itemId = str;
    }

    public void showInnerTitle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-44790882")) {
            ipChange.ipc$dispatch("-44790882", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            findViewById(R$id.comment_hl_title).setVisibility(0);
        } else {
            findViewById(R$id.comment_hl_title).setVisibility(8);
        }
    }

    public void toggleEllipsize(Context context, TextView textView, int i, String str, String str2, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660289104")) {
            ipChange.ipc$dispatch("-660289104", new Object[]{this, context, textView, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Boolean.valueOf(z)});
        } else if (!TextUtils.isEmpty(str)) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new e(this, z, textView, str, str2, i, context, i2));
        }
    }

    public void updateSpmBC(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1956371201")) {
            ipChange.ipc$dispatch("1956371201", new Object[]{this, str, str2});
            return;
        }
        this.spmb = str;
        this.spmc = str2;
    }

    public DMHotDiscussView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public DMHotDiscussView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    @RequiresApi(api = 21)
    public DMHotDiscussView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }
}
