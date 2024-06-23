package cn.damai.model;

import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.comment.R$color;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsResultBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.comment.bean.QueryThemeResultBean;
import cn.damai.comment.util.CommentItemMoreUtil;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.discover.content.net.ContentDetailApi;
import cn.damai.evaluate.request.CommentListRequest;
import cn.damai.issue.net.CommentGradeText;
import cn.damai.issue.net.IssueActivityIntroduce;
import cn.damai.issue.net.IssueEditRequest;
import cn.damai.issue.net.IssueLiveDataResponse;
import cn.damai.issue.net.IssueRenderLiveDataResponse;
import cn.damai.issue.net.IssueRenderRequest;
import cn.damai.issue.net.IssueRenderResponse;
import cn.damai.issue.net.IssueRequest;
import cn.damai.issue.net.IssueResponse;
import cn.damai.issue.net.QueryThemeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.hp1;
import tb.lp1;
import tb.p21;
import tb.q21;
import tb.re0;
import tb.xf2;
import tb.yz2;

/* compiled from: Taobao */
public class IssueViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String appPublishHint;
    private QueryThemeCliqueInfoBean circle;
    private List<QueryThemeCliqueInfoBean> circleList;
    ArrayList<CommentGradeText> commentGradeTexts = new ArrayList<>();
    private boolean isComeFromCircle;
    private boolean isComeFromTheme;
    private boolean isShowToastAfterPublishSuccess;
    private String itemType;
    private String mCommentId;
    private String mCommentType;
    private String mEditorContent;
    private int mGrades;
    private ArrayList<String> mImages = new ArrayList<>();
    private String mIpId;
    private String mIssueFrom;
    private String mIssueType;
    private String mItemId;
    private String mProjectName;
    private String mProjectPoster;
    private ArrayList<Image> mSelectImages = new ArrayList<>();
    private String mStoreId;
    private String mTargetId;
    private String mTargetType;
    ArrayList<IssueActivityIntroduce> noticeInfos = new ArrayList<>();
    private String performBeginTime;
    q21 repository;
    private String scriptId;
    private String themeId;
    private String themeName;
    private String timeAddress;
    private String timeDes;
    private String uniqueOrderId;
    private String watchActivityId;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LinearLayout a;

        a(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1062304658")) {
                ipChange.ipc$dispatch("1062304658", new Object[]{this, valueAnimator});
                return;
            }
            IssueViewModel.this.setViewHeight(this.a, (int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public IssueViewModel(@NonNull Application application) {
        super(application);
        this.repository = new q21(application.getApplicationContext());
    }

    private void scriptMurderParams(IssueRequest issueRequest, DmInfo dmInfo, Boolean bool, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222856068")) {
            ipChange.ipc$dispatch("-1222856068", new Object[]{this, issueRequest, dmInfo, bool, str});
            return;
        }
        issueRequest.spoilerType = bool.booleanValue();
        if (dmInfo != null) {
            issueRequest.dmId = dmInfo.getDmId();
            issueRequest.dmTags = dmInfo.dmTags;
        }
        if (this.mStoreId != null && "1".equals(this.itemType)) {
            setmCommentType("32");
            issueRequest.commentType = "32";
            issueRequest.targetId = getmTargetId();
            issueRequest.storeId = getStoreId();
            issueRequest.scriptId = str;
        } else if (this.scriptId != null && "2".equals(this.itemType)) {
            setmCommentType(p21.ISSUE_PARAM_COMMENT_TYPE_SCRIPT);
            issueRequest.commentType = p21.ISSUE_PARAM_COMMENT_TYPE_SCRIPT;
            String str2 = this.scriptId;
            issueRequest.targetId = str2;
            issueRequest.scriptId = str2;
            issueRequest.storeId = str;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setViewHeight(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2078533348")) {
            ipChange.ipc$dispatch("2078533348", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        view.getLayoutParams().height = i;
        view.requestLayout();
    }

    public void animateToggle(LinearLayout linearLayout, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2018357032")) {
            ipChange.ipc$dispatch("2018357032", new Object[]{this, linearLayout, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 11) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, (float) i);
            ofFloat.setDuration(150L);
            ofFloat.addUpdateListener(new a(linearLayout));
            ofFloat.start();
        }
    }

    public String getAppPublishHint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1400062634")) {
            return this.appPublishHint;
        }
        return (String) ipChange.ipc$dispatch("1400062634", new Object[]{this});
    }

    public QueryThemeCliqueInfoBean getCircle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-127727722")) {
            return this.circle;
        }
        return (QueryThemeCliqueInfoBean) ipChange.ipc$dispatch("-127727722", new Object[]{this});
    }

    public List<QueryThemeCliqueInfoBean> getCircleList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-678552118")) {
            return this.circleList;
        }
        return (List) ipChange.ipc$dispatch("-678552118", new Object[]{this});
    }

    public ArrayList<CommentGradeText> getCommentGradeTexts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1462268555")) {
            return this.commentGradeTexts;
        }
        return (ArrayList) ipChange.ipc$dispatch("1462268555", new Object[]{this});
    }

    @RequiresApi(api = 12)
    public boolean getIntentValue(Bundle bundle, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237884373")) {
            return ((Boolean) ipChange.ipc$dispatch("-237884373", new Object[]{this, bundle, intent})).booleanValue();
        } else if (bundle == null) {
            return false;
        } else {
            this.mCommentType = bundle.getString(p21.ISSUE_PARAM_COMMENT_TYPE, "32");
            if (bundle.containsKey("publisherType")) {
                String string = bundle.getString("publisherType", p21.ISSUE_TYPE_EVALUATE);
                if ("ReleaseType_Evaluate".equals(string)) {
                    this.mIssueType = p21.ISSUE_TYPE_EVALUATE;
                    this.mCommentType = "32";
                } else if ("ReleaseType_Edit_Evaluate".equals(string)) {
                    this.mIssueType = p21.ISSUE_TYPE_EDIT;
                } else if ("ReleaseType_Discovery_Privilege".equals(string)) {
                    this.mIssueType = p21.ISSUE_TYPE_PRIVILEGE;
                    this.mCommentType = "62";
                }
            } else {
                this.mIssueType = bundle.getString(p21.ISSUE_TYPE, p21.ISSUE_TYPE_PRIVILEGE);
                this.mCommentType = "62";
            }
            if (intent != null && intent.getData() != null && !TextUtils.isEmpty(intent.getData().getPath()) && intent.getData().getPath().contains("activity/savecomment/index.html")) {
                this.mIssueType = p21.ISSUE_TYPE_PRIVILEGE;
                this.mCommentType = "62";
            }
            this.mIssueFrom = bundle.getString(p21.ISSUE_FROM, "");
            this.appPublishHint = bundle.getString("appPublishHint");
            this.timeAddress = bundle.getString("timeAddress", "");
            if (!bundle.getString(p21.ISSUE_PARAM_PERFORM_TIMR, "").isEmpty()) {
                this.performBeginTime = bundle.getString(p21.ISSUE_PARAM_PERFORM_TIMR, "");
            } else {
                this.performBeginTime = bundle.getString(p21.ISSUE_PARAM_PERFORM_BEGIN_TIMR, "");
            }
            this.mTargetId = bundle.getString("targetId", "0");
            this.mTargetType = bundle.getString("targetType", "0");
            this.isShowToastAfterPublishSuccess = bundle.getBoolean(p21.ISSUE_PARAM_TOAST_SWITCH, true);
            this.mItemId = bundle.getString("itemId", "");
            this.uniqueOrderId = bundle.getString(p21.ISSUE_PARAM_ORDER_ID, "");
            this.watchActivityId = bundle.getString(p21.ISSUE_PARAM_WATCH_ACTIVITY_ID, "");
            this.timeDes = bundle.getString(p21.ISSUE_PARAM_TIMEDES, "");
            this.mIpId = bundle.getString(p21.ISSUE_PARAM_IPID);
            this.mProjectName = bundle.getString("projectName");
            this.mProjectPoster = bundle.getString(p21.ISSUE_PARAM_PROJECT_POSTER);
            this.mGrades = bundle.getInt(p21.ISSUE_PARAM_GRADES, 0);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("images");
            if (xf2.e(stringArrayList) > 0) {
                this.mImages.addAll(stringArrayList);
                for (int i = 0; i < xf2.e(this.mImages); i++) {
                    this.mSelectImages.add(new Image(this.mImages.get(i), (long) (((int) System.currentTimeMillis()) / 1000), (((int) System.currentTimeMillis()) / 1000) + ".jpg", true));
                }
            }
            this.mEditorContent = bundle.getString("text");
            this.mCommentId = bundle.getString(p21.ISSUE_PARAM_COMMENT_ID);
            this.themeId = bundle.getString("themeId");
            this.themeName = bundle.getString(p21.ISSUE_PARAM_LIVE_THEME_NAME);
            String string2 = bundle.getString("circleId");
            String string3 = bundle.getString("circleName");
            this.isComeFromTheme = !TextUtils.isEmpty(this.themeId);
            boolean z = !TextUtils.isEmpty(string2);
            this.isComeFromCircle = z;
            if (z) {
                QueryThemeCliqueInfoBean queryThemeCliqueInfoBean = new QueryThemeCliqueInfoBean();
                this.circle = queryThemeCliqueInfoBean;
                try {
                    queryThemeCliqueInfoBean.setId(Long.parseLong(string2));
                } catch (NumberFormatException unused) {
                    this.circle.setId(0);
                }
                this.circle.setName(string3);
                ArrayList arrayList = new ArrayList();
                this.circleList = arrayList;
                arrayList.add(this.circle);
            }
            this.scriptId = bundle.getString("scriptId");
            return true;
        }
    }

    public String getItemType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1951400898")) {
            return this.itemType;
        }
        return (String) ipChange.ipc$dispatch("1951400898", new Object[]{this});
    }

    public ArrayList<IssueActivityIntroduce> getNoticeInfos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2124001452")) {
            return this.noticeInfos;
        }
        return (ArrayList) ipChange.ipc$dispatch("2124001452", new Object[]{this});
    }

    public String getPerformBeginTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1635328394")) {
            return this.performBeginTime;
        }
        return (String) ipChange.ipc$dispatch("1635328394", new Object[]{this});
    }

    public MutableLiveData<IssueRenderLiveDataResponse> getRenderTags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003531624")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1003531624", new Object[]{this});
        }
        final MutableLiveData<IssueRenderLiveDataResponse> mutableLiveData = new MutableLiveData<>();
        IssueRenderRequest issueRenderRequest = new IssueRenderRequest();
        issueRenderRequest.itemId = this.mItemId;
        issueRenderRequest.ipId = this.mIpId;
        issueRenderRequest.performTime = this.performBeginTime;
        issueRenderRequest.scriptId = this.scriptId;
        issueRenderRequest.request(new DMMtopRequestListener<IssueRenderResponse>(IssueRenderResponse.class) {
            /* class cn.damai.model.IssueViewModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-597803923")) {
                    ipChange.ipc$dispatch("-597803923", new Object[]{this, str, str2});
                    return;
                }
                IssueRenderLiveDataResponse issueRenderLiveDataResponse = new IssueRenderLiveDataResponse();
                yz2.a(yz2.i("mtop.damai.wireless.comment.render", "发布器评价渲染接口", str, str2, ""), "-8200", "发布器评价渲染错误");
                issueRenderLiveDataResponse.errorCode = str;
                issueRenderLiveDataResponse.errorMsg = str2;
                mutableLiveData.setValue(issueRenderLiveDataResponse);
            }

            public void onSuccess(IssueRenderResponse issueRenderResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1178309362")) {
                    ipChange.ipc$dispatch("1178309362", new Object[]{this, issueRenderResponse});
                } else if (issueRenderResponse != null) {
                    IssueRenderLiveDataResponse issueRenderLiveDataResponse = new IssueRenderLiveDataResponse();
                    issueRenderLiveDataResponse.data = issueRenderResponse;
                    mutableLiveData.setValue(issueRenderLiveDataResponse);
                }
            }
        });
        return mutableLiveData;
    }

    public q21 getRepository() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1135222078")) {
            return this.repository;
        }
        return (q21) ipChange.ipc$dispatch("-1135222078", new Object[]{this});
    }

    public String getScriptId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1482984549")) {
            return this.scriptId;
        }
        return (String) ipChange.ipc$dispatch("-1482984549", new Object[]{this});
    }

    public String getStoreId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "642061021")) {
            return this.mStoreId;
        }
        return (String) ipChange.ipc$dispatch("642061021", new Object[]{this});
    }

    public String getThemeId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "863728069")) {
            return this.themeId;
        }
        return (String) ipChange.ipc$dispatch("863728069", new Object[]{this});
    }

    public String getThemeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1184869237")) {
            return this.themeName;
        }
        return (String) ipChange.ipc$dispatch("1184869237", new Object[]{this});
    }

    public String getTimeAddress() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1110185704")) {
            return this.timeAddress;
        }
        return (String) ipChange.ipc$dispatch("1110185704", new Object[]{this});
    }

    public String getTimeDes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1509736582")) {
            return this.timeDes;
        }
        return (String) ipChange.ipc$dispatch("1509736582", new Object[]{this});
    }

    public String getmCommentId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1933387298")) {
            return this.mCommentId;
        }
        return (String) ipChange.ipc$dispatch("1933387298", new Object[]{this});
    }

    public String getmCommentType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "218538945")) {
            return this.mCommentType;
        }
        return (String) ipChange.ipc$dispatch("218538945", new Object[]{this});
    }

    public String getmEditorContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-828424940")) {
            return this.mEditorContent;
        }
        return (String) ipChange.ipc$dispatch("-828424940", new Object[]{this});
    }

    public int getmGrades() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "917268585")) {
            return this.mGrades;
        }
        return ((Integer) ipChange.ipc$dispatch("917268585", new Object[]{this})).intValue();
    }

    public ArrayList<String> getmImages() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1393880364")) {
            return this.mImages;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1393880364", new Object[]{this});
    }

    public String getmIpId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1655992784")) {
            return this.mIpId;
        }
        return (String) ipChange.ipc$dispatch("1655992784", new Object[]{this});
    }

    public String getmIssueFrom() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "162163691")) {
            return this.mIssueFrom;
        }
        return (String) ipChange.ipc$dispatch("162163691", new Object[]{this});
    }

    public String getmIssueType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-86410373")) {
            return this.mIssueType;
        }
        return (String) ipChange.ipc$dispatch("-86410373", new Object[]{this});
    }

    public String getmItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1016473092")) {
            return this.mItemId;
        }
        return (String) ipChange.ipc$dispatch("-1016473092", new Object[]{this});
    }

    public String getmProjectName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "443812684")) {
            return this.mProjectName;
        }
        return (String) ipChange.ipc$dispatch("443812684", new Object[]{this});
    }

    public String getmProjectPoster() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "860083086")) {
            return this.mProjectPoster;
        }
        return (String) ipChange.ipc$dispatch("860083086", new Object[]{this});
    }

    public ArrayList<Image> getmSelectImages() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-122884744")) {
            return this.mSelectImages;
        }
        return (ArrayList) ipChange.ipc$dispatch("-122884744", new Object[]{this});
    }

    public String getmTargetId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-639737542")) {
            return this.mTargetId;
        }
        return (String) ipChange.ipc$dispatch("-639737542", new Object[]{this});
    }

    public String getmTargetType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1346730201")) {
            return this.mTargetType;
        }
        return (String) ipChange.ipc$dispatch("1346730201", new Object[]{this});
    }

    public String initPicPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067042060")) {
            return (String) ipChange.ipc$dispatch("-2067042060", new Object[]{this, str});
        } else if (!hp1.i(lp1.STORAGE)) {
            return str;
        } else {
            String m = cn.damai.common.util.a.m();
            if (xf2.j(m)) {
                return str;
            }
            String str2 = m + "/publish";
            cn.damai.common.util.a.f(str2);
            cn.damai.common.util.a.t(str2, false);
            return str2;
        }
    }

    public int inputCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1485622793")) {
            return ((Integer) ipChange.ipc$dispatch("-1485622793", new Object[]{this})).intValue();
        } else if (!TextUtils.isEmpty(getmEditorContent())) {
            return re0.c(getmEditorContent());
        } else {
            return 0;
        }
    }

    public boolean isComeFromCircle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1794698373")) {
            return this.isComeFromCircle;
        }
        return ((Boolean) ipChange.ipc$dispatch("1794698373", new Object[]{this})).booleanValue();
    }

    public boolean isComeFromTheme() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1629816396")) {
            return this.isComeFromTheme;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1629816396", new Object[]{this})).booleanValue();
    }

    public boolean isEdit() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "156749497")) {
            return p21.ISSUE_TYPE_EDIT.equals(getmIssueType());
        }
        return ((Boolean) ipChange.ipc$dispatch("156749497", new Object[]{this})).booleanValue();
    }

    public boolean isEvaluate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2102983882")) {
            return p21.ISSUE_TYPE_EVALUATE.equals(getmIssueType());
        }
        return ((Boolean) ipChange.ipc$dispatch("2102983882", new Object[]{this})).booleanValue();
    }

    public boolean isFromHome() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1883245638")) {
            return "homepage".equals(getmIssueFrom());
        }
        return ((Boolean) ipChange.ipc$dispatch("-1883245638", new Object[]{this})).booleanValue();
    }

    public boolean isPrivilege() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-373068834")) {
            return p21.ISSUE_TYPE_PRIVILEGE.equals(getmIssueType());
        }
        return ((Boolean) ipChange.ipc$dispatch("-373068834", new Object[]{this})).booleanValue();
    }

    public boolean isShowToastAfterPublishSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "856957405")) {
            return this.isShowToastAfterPublishSuccess;
        }
        return ((Boolean) ipChange.ipc$dispatch("856957405", new Object[]{this})).booleanValue();
    }

    public MutableLiveData<CommentsResultBean> requestEvaluateDetail() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12858252")) {
            return (MutableLiveData) ipChange.ipc$dispatch("12858252", new Object[]{this});
        }
        final MutableLiveData<CommentsResultBean> mutableLiveData = new MutableLiveData<>();
        CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.commentId = this.mCommentId;
        commentListRequest.request(new DMMtopRequestListener<CommentsResultBean>(CommentsResultBean.class) {
            /* class cn.damai.model.IssueViewModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-613322641")) {
                    ipChange.ipc$dispatch("-613322641", new Object[]{this, str, str2});
                    return;
                }
                mutableLiveData.setValue(new CommentsResultBean());
                yz2.a(yz2.i("mtop.damai.wireless.comment.list.get", "发布器编辑接口", str, str2, ""), "-8202", "发布器编辑接口错误");
            }

            public void onSuccess(CommentsResultBean commentsResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1366844008")) {
                    ipChange.ipc$dispatch("1366844008", new Object[]{this, commentsResultBean});
                    return;
                }
                mutableLiveData.setValue(commentsResultBean);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<IssueLiveDataResponse> requestIssue(ArrayList<String> arrayList, String str, String str2, String str3, String str4, QueryThemeCliqueInfoBean queryThemeCliqueInfoBean, DmInfo dmInfo, Boolean bool, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033548337")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1033548337", new Object[]{this, arrayList, str, str2, str3, str4, queryThemeCliqueInfoBean, dmInfo, bool, str5});
        }
        final MutableLiveData<IssueLiveDataResponse> mutableLiveData = new MutableLiveData<>();
        final IssueRequest issueRequest = new IssueRequest();
        if (isEdit()) {
            issueRequest = new IssueEditRequest();
        }
        Long l = null;
        try {
            l = Long.valueOf(str4);
        } catch (NumberFormatException e) {
            Log.d("IssueViewModel", e.getMessage());
        }
        issueRequest.images = arrayList;
        issueRequest.video = str;
        issueRequest.grades = str2;
        issueRequest.text = getmEditorContent();
        if (queryThemeCliqueInfoBean != null) {
            issueRequest.cliqueId = Long.valueOf(queryThemeCliqueInfoBean.getId());
        }
        if (l != null) {
            issueRequest.associatedThemeId = l;
        }
        if (!TextUtils.isEmpty(this.uniqueOrderId)) {
            issueRequest.uniqueOrderId = this.uniqueOrderId;
        }
        if (!TextUtils.isEmpty(this.watchActivityId)) {
            issueRequest.watchActivityId = this.watchActivityId;
        }
        if (isEvaluate()) {
            setmCommentType("32");
            issueRequest.targetId = getmTargetId();
            issueRequest.targetType = getmTargetType();
            issueRequest.commentType = getmCommentType();
            issueRequest.targetValidTime = getPerformBeginTime();
            if (!xf2.j(getmIpId())) {
                issueRequest.ipId = getmIpId();
            }
            if (!xf2.j(getmItemId())) {
                issueRequest.itemId = getmItemId();
            }
        } else if (isEdit()) {
            issueRequest.commentId = getmCommentId();
        } else if (isPrivilege()) {
            issueRequest.targetId = getmTargetId();
            if ("1".equals(str3)) {
                issueRequest.itemId = getmTargetId();
            } else if ("2".equals(str3)) {
                issueRequest.ipId = getmTargetId();
            }
            issueRequest.targetType = getmTargetType();
            issueRequest.commentType = getmCommentType();
        }
        scriptMurderParams(issueRequest, dmInfo, bool, str5);
        issueRequest.request(new DMMtopRequestListener<IssueResponse>(IssueResponse.class) {
            /* class cn.damai.model.IssueViewModel.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-621082000")) {
                    ipChange.ipc$dispatch("-621082000", new Object[]{this, str, str2});
                    return;
                }
                IssueLiveDataResponse issueLiveDataResponse = new IssueLiveDataResponse();
                StringBuilder sb = new StringBuilder();
                if (IssueViewModel.this.isEvaluate()) {
                    sb.append("publisherType:ReleaseType_Evaluate");
                } else if (IssueViewModel.this.isEdit()) {
                    sb.append("publisherType:ReleaseType_Edit_Evaluate");
                    sb.append(",commentId:");
                    sb.append(issueRequest.commentId);
                } else if (IssueViewModel.this.isPrivilege()) {
                    sb.append("publisherType:ReleaseType_Privilege");
                } else {
                    sb.append("publisherType:Error");
                }
                sb.append(",targetId:");
                sb.append(issueRequest.targetId);
                sb.append(",commentType:");
                sb.append(issueRequest.commentType);
                sb.append(",itemId:");
                sb.append(issueRequest.itemId);
                yz2.a(yz2.i(ContentDetailApi.CONTENT_COMMENT_PUBLISH, "发布器发布接口", str, str2, sb.toString()), "-8200", "发布器发布错误");
                issueLiveDataResponse.errorCode = str;
                issueLiveDataResponse.errorMsg = str2;
                mutableLiveData.setValue(issueLiveDataResponse);
            }

            public void onSuccess(IssueResponse issueResponse) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1523528315")) {
                    ipChange.ipc$dispatch("-1523528315", new Object[]{this, issueResponse});
                    return;
                }
                IssueLiveDataResponse issueLiveDataResponse = new IssueLiveDataResponse();
                issueLiveDataResponse.data = issueResponse;
                mutableLiveData.setValue(issueLiveDataResponse);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<QueryThemeResultBean> requestThemeTipsByPojId(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064567484")) {
            return (MutableLiveData) ipChange.ipc$dispatch("2064567484", new Object[]{this, str, str2});
        }
        final MutableLiveData<QueryThemeResultBean> mutableLiveData = new MutableLiveData<>();
        QueryThemeRequest queryThemeRequest = new QueryThemeRequest();
        try {
            queryThemeRequest.targetId = Long.valueOf(str);
            queryThemeRequest.targetType = Integer.valueOf(str2);
        } catch (NumberFormatException e) {
            Log.d("requestThemeTipsByPojId", e.getMessage());
        }
        queryThemeRequest.request(new DMMtopRequestListener<QueryThemeResultBean>(QueryThemeResultBean.class) {
            /* class cn.damai.model.IssueViewModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-605563282")) {
                    ipChange.ipc$dispatch("-605563282", new Object[]{this, str, str2});
                    return;
                }
                mutableLiveData.setValue(new QueryThemeResultBean());
            }

            public void onSuccess(QueryThemeResultBean queryThemeResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1573119996")) {
                    ipChange.ipc$dispatch("1573119996", new Object[]{this, queryThemeResultBean});
                    return;
                }
                mutableLiveData.setValue(queryThemeResultBean);
            }
        });
        return mutableLiveData;
    }

    public void setAppPublishHint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335161972")) {
            ipChange.ipc$dispatch("1335161972", new Object[]{this, str});
            return;
        }
        this.appPublishHint = str;
    }

    public void setCircle(QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065523126")) {
            ipChange.ipc$dispatch("-2065523126", new Object[]{this, queryThemeCliqueInfoBean});
            return;
        }
        this.circle = queryThemeCliqueInfoBean;
    }

    public void setCircleList(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462939714")) {
            ipChange.ipc$dispatch("1462939714", new Object[]{this, list});
            return;
        }
        this.circleList = list;
    }

    public void setComeFromCircle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839312813")) {
            ipChange.ipc$dispatch("-839312813", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isComeFromCircle = z;
    }

    public void setComeFromTheme(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-113692860")) {
            ipChange.ipc$dispatch("-113692860", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isComeFromTheme = z;
    }

    public void setCommentGradeTexts(ArrayList<CommentGradeText> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636104307")) {
            ipChange.ipc$dispatch("-636104307", new Object[]{this, arrayList});
            return;
        }
        this.commentGradeTexts = arrayList;
    }

    public void setItemType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481557852")) {
            ipChange.ipc$dispatch("481557852", new Object[]{this, str});
            return;
        }
        this.itemType = str;
    }

    public void setNoticeInfos(ArrayList<IssueActivityIntroduce> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "227982988")) {
            ipChange.ipc$dispatch("227982988", new Object[]{this, arrayList});
            return;
        }
        this.noticeInfos = arrayList;
    }

    public void setPerformBeginTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2016222060")) {
            ipChange.ipc$dispatch("-2016222060", new Object[]{this, str});
            return;
        }
        this.performBeginTime = str;
    }

    public void setRepository(q21 q21) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232493634")) {
            ipChange.ipc$dispatch("232493634", new Object[]{this, q21});
            return;
        }
        this.repository = q21;
    }

    public void setScriptId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389791395")) {
            ipChange.ipc$dispatch("1389791395", new Object[]{this, str});
            return;
        }
        this.scriptId = str;
    }

    public void setShowToastAfterPublishSuccess(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645197317")) {
            ipChange.ipc$dispatch("-1645197317", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isShowToastAfterPublishSuccess = z;
    }

    public void setStoreId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107768889")) {
            ipChange.ipc$dispatch("1107768889", new Object[]{this, str});
            return;
        }
        this.mStoreId = str;
    }

    public void setThemeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-610487215")) {
            ipChange.ipc$dispatch("-610487215", new Object[]{this, str});
            return;
        }
        this.themeId = str;
    }

    public void setThemeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406003105")) {
            ipChange.ipc$dispatch("406003105", new Object[]{this, str});
            return;
        }
        this.themeName = str;
    }

    public void setTimeAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051034510")) {
            ipChange.ipc$dispatch("2051034510", new Object[]{this, str});
            return;
        }
        this.timeAddress = str;
    }

    public void setTimeDes(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059059792")) {
            ipChange.ipc$dispatch("-2059059792", new Object[]{this, str});
            return;
        }
        this.timeDes = str;
    }

    public void setmCommentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990547964")) {
            ipChange.ipc$dispatch("1990547964", new Object[]{this, str});
            return;
        }
        this.mCommentId = str;
    }

    public void setmCommentType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417346243")) {
            ipChange.ipc$dispatch("-1417346243", new Object[]{this, str});
            return;
        }
        this.mCommentType = str;
    }

    public void setmEditorContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971523914")) {
            ipChange.ipc$dispatch("971523914", new Object[]{this, str});
            return;
        }
        this.mEditorContent = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r6 >= (r12.noticeInfos.size() - 1)) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
        if (r7 <= 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r0 <= 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r2.append(r13.getResources().getString(cn.damai.comment.R$string.evaluate_more_tip));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        r14 = r13.getResources().getString(cn.damai.comment.R$string.evaluate_limit_words_tip, java.lang.String.valueOf(r7));
        r0 = java.lang.String.valueOf(r7).length() + r3;
        r2.append(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r0 = 0;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bb, code lost:
        if (r8 <= 0) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00bd, code lost:
        r14 = r2.toString().length() + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cc, code lost:
        r2.append(r13.getResources().getString(cn.damai.comment.R$string.evaluate_more_tip));
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00db, code lost:
        r7 = java.lang.String.valueOf(r8).length() + r14;
        r2.append(r13.getResources().getString(cn.damai.comment.R$string.evaluate_limit_images_tip, java.lang.String.valueOf(r8)));
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fb, code lost:
        r5 = r3;
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fe, code lost:
        r14 = 0;
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0100, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0101, code lost:
        r2.append(r12.noticeInfos.get(r6).getActivityPrivilege());
        r5 = r14;
        r14 = r5;
     */
    public SpannableStringBuilder setmEvaGiftContent(Context context, int i) {
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        int i5 = 2;
        int i6 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2005647165")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-2005647165", new Object[]{this, context, Integer.valueOf(i)});
        }
        ArrayList<IssueActivityIntroduce> arrayList = this.noticeInfos;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int inputCount = inputCount();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 >= this.noticeInfos.size()) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                break;
            }
            if (inputCount < this.noticeInfos.get(i7).getMinWordNum()) {
                i8 = this.noticeInfos.get(i7).getMinWordNum() - inputCount;
            }
            if (i < this.noticeInfos.get(i7).getMinPicNum()) {
                i9 = this.noticeInfos.get(i7).getMinPicNum() - i;
            }
            if (i8 <= 0 && i9 <= 0) {
                i7++;
            }
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
        Resources resources = context.getResources();
        int i10 = R$color.color_ff2d79;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(resources.getColor(i10));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(context.getResources().getColor(i10));
        spannableStringBuilder.setSpan(foregroundColorSpan, i6, i4, 33);
        spannableStringBuilder.setSpan(foregroundColorSpan2, i2, i3, 33);
        return spannableStringBuilder;
    }

    public void setmGrades(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "893816001")) {
            ipChange.ipc$dispatch("893816001", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mGrades = i;
    }

    public void setmImages(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149980316")) {
            ipChange.ipc$dispatch("-149980316", new Object[]{this, arrayList});
            return;
        }
        this.mImages = arrayList;
    }

    public void setmIpId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007431002")) {
            ipChange.ipc$dispatch("-2007431002", new Object[]{this, str});
            return;
        }
        this.mIpId = str;
    }

    public void setmIssueFrom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377776301")) {
            ipChange.ipc$dispatch("-1377776301", new Object[]{this, str});
            return;
        }
        this.mIssueFrom = str;
    }

    public void setmIssueType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493637693")) {
            ipChange.ipc$dispatch("-493637693", new Object[]{this, str});
            return;
        }
        this.mIssueType = str;
    }

    public void setmItemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232818938")) {
            ipChange.ipc$dispatch("1232818938", new Object[]{this, str});
            return;
        }
        this.mItemId = str;
    }

    public void setmProjectName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271172370")) {
            ipChange.ipc$dispatch("1271172370", new Object[]{this, str});
            return;
        }
        this.mProjectName = str;
    }

    public void setmProjectPoster(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775665168")) {
            ipChange.ipc$dispatch("1775665168", new Object[]{this, str});
            return;
        }
        this.mProjectPoster = str;
    }

    public void setmSelectImages(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534266944")) {
            ipChange.ipc$dispatch("1534266944", new Object[]{this, arrayList});
            return;
        }
        this.mSelectImages = arrayList;
    }

    public void setmTargetId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322232196")) {
            ipChange.ipc$dispatch("-322232196", new Object[]{this, str});
            return;
        }
        this.mTargetId = str;
    }

    public void setmTargetType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793979325")) {
            ipChange.ipc$dispatch("793979325", new Object[]{this, str});
            return;
        }
        this.mTargetType = str;
    }

    public void updateDetailInfoView(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210073984")) {
            ipChange.ipc$dispatch("210073984", new Object[]{this, commentsItemBean});
        } else if (commentsItemBean != null) {
            if (!(commentsItemBean.getTextDOList() == null || commentsItemBean.getTextDOList().size() <= 0 || commentsItemBean.getTextDOList().get(0) == null)) {
                this.mEditorContent = commentsItemBean.getTextDOList().get(0).getValue();
            }
            ArrayList<String> d = CommentItemMoreUtil.d(commentsItemBean.getImageDOList());
            if (xf2.e(d) > 0) {
                this.mImages.clear();
                this.mSelectImages.clear();
                this.mImages.addAll(d);
                for (int i = 0; i < xf2.e(this.mImages); i++) {
                    ArrayList<Image> arrayList = this.mSelectImages;
                    String str = this.mImages.get(i);
                    long currentTimeMillis = (long) (((int) System.currentTimeMillis()) / 1000);
                    arrayList.add(new Image(str, currentTimeMillis, (((int) System.currentTimeMillis()) / 1000) + ".jpg", true));
                }
            }
        }
    }
}
