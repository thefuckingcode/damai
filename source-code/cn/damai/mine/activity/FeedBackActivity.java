package cn.damai.mine.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import cn.damai.common.app.widget.DMProgressDialog;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.common.uploader.AusResult;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.mine.bean.FeedBack;
import cn.damai.mine.bean.FeedBackResult;
import cn.damai.mine.presenter.FeedBackSubmitRequest;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.uploader.FileUploadListener;
import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import tb.a01;
import tb.bk2;
import tb.g91;
import tb.hp1;
import tb.jl1;
import tb.le1;
import tb.lp1;
import tb.n42;
import tb.pn;
import tb.s40;
import tb.ss2;
import tb.v;
import tb.xf2;
import tb.yd1;

/* compiled from: Taobao */
public class FeedBackActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int RESULT_IMAGE = 1000;
    private final int MAX_TEXT_COUNT = 450;
    private List<AusResult> mARupReplyData = new ArrayList();
    private LinearLayout mAddImageContainer;
    private FrameLayout mAddImageLayout;
    private EditText mContentEd;
    public DMProgressDialog mDMProgressDialog;
    private View.OnClickListener mDeleteClickListener = new d();
    private String mFeedBackHit;
    private String mFeedBackId;
    private List<FeedBack> mFeedBackList = new ArrayList();
    private String mFeedBackTitle;
    private FileUploader mFeedbackUploader;
    private String mFilePath;
    private FlowLayout mFlowLayout;
    private ArrayList<FrameLayout> mImageLayouts = new ArrayList<>();
    private ArrayList<String> mPaths = new ArrayList<>();
    View.OnClickListener mQuestTypeListener = new a();
    private int mReplyTime = 0;
    private int mScreenHeight;
    private String mScreenShotExtra;
    private String mScreenShotFromPage;
    private String mScreenShotModule;
    private int mScreenWidth;
    private TextView mSelectQuestView;
    private Button mSubmitBtn;
    private Handler mSubmitHandler = new f();
    private FileUploadListener mSubmitListener = new e();
    private boolean mTextChangeLast;
    private boolean mTextChangePre;
    private TextWatcher mTextWatcherListener = new c();
    private TextView mTvDesc;
    private String mUploadContent;
    private int mUploadPicSize = 0;
    private String[] picFormArray = {"jpg", "png", "jpeg", "gif", "bmp", "dib", "jfif", "tif", "tiff", "ico"};

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "979522894")) {
                ipChange.ipc$dispatch("979522894", new Object[]{this, view});
                return;
            }
            FeedBack feedBack = (FeedBack) view.getTag();
            if (feedBack != null) {
                FeedBackActivity feedBackActivity = FeedBackActivity.this;
                feedBackActivity.updateUnQuestTypeView(feedBackActivity.mSelectQuestView);
                FeedBackActivity.this.mSelectQuestView = (TextView) view;
                FeedBackActivity feedBackActivity2 = FeedBackActivity.this;
                feedBackActivity2.updateQuestTypeView(feedBackActivity2.mSelectQuestView);
                FeedBackActivity.this.mFeedBackId = feedBack.name;
                FeedBackActivity.this.mFeedBackTitle = feedBack.title;
                FeedBackActivity.this.mFeedBackHit = feedBack.desc;
                FeedBackActivity.this.mContentEd.setHint(FeedBackActivity.this.mFeedBackHit);
                cn.damai.common.user.c.e().x(yd1.x().q0(feedBack.index));
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1244147472")) {
                ipChange.ipc$dispatch("1244147472", new Object[]{this});
                return;
            }
            FeedBackActivity.this.doSelectFile();
        }
    }

    /* compiled from: Taobao */
    public class c implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-487606649")) {
                ipChange.ipc$dispatch("-487606649", new Object[]{this, editable});
                return;
            }
            FeedBackActivity feedBackActivity = FeedBackActivity.this;
            if (editable.length() <= 0) {
                z = false;
            }
            feedBackActivity.mTextChangePre = z;
            if (FeedBackActivity.this.mTextChangePre != FeedBackActivity.this.mTextChangeLast) {
                FeedBackActivity feedBackActivity2 = FeedBackActivity.this;
                feedBackActivity2.mTextChangeLast = feedBackActivity2.mTextChangePre;
                FeedBackActivity feedBackActivity3 = FeedBackActivity.this;
                feedBackActivity3.updateSubmitState(feedBackActivity3.mTextChangePre);
            }
            if (editable.length() > 450) {
                FeedBackActivity.this.mContentEd.setText(editable.subSequence(0, 450));
                FeedBackActivity.this.mContentEd.setSelection(450);
                ToastUtil.i("最多输入450字哟~");
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-274333156")) {
                ipChange.ipc$dispatch("-274333156", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1195563844")) {
                ipChange.ipc$dispatch("-1195563844", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1276540591")) {
                ipChange.ipc$dispatch("-1276540591", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (xf2.e(FeedBackActivity.this.mPaths) > intValue) {
                FeedBackActivity.this.mPaths.remove(intValue);
                FeedBackActivity.this.updateImageLayout();
            }
        }
    }

    /* compiled from: Taobao */
    public class e extends s40 {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onAllSuccess(@NonNull List<ss2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1794740399")) {
                ipChange.ipc$dispatch("-1794740399", new Object[]{this, list});
                return;
            }
            FeedBackActivity.this.onAllUploadFinish(list);
        }

        @Override // tb.s40, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NonNull UploadErrorCode uploadErrorCode, @NonNull List<ss2> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "251413064")) {
                ipChange.ipc$dispatch("251413064", new Object[]{this, uploadErrorCode, list});
                return;
            }
            FeedBackActivity.this.onAllUploadFinish(list);
        }
    }

    /* compiled from: Taobao */
    public class f extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1762436124")) {
                ipChange.ipc$dispatch("1762436124", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (message.what == 4) {
                FeedBackActivity.this.deleteFile();
                FeedBackActivity.this.setResult(-1);
                FeedBackActivity.this.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class g implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-598891093")) {
                ipChange.ipc$dispatch("-598891093", new Object[]{this, dialogInterface});
                return;
            }
            FeedBackActivity.this.setBtnEnable(true);
            if (FeedBackActivity.this.mReplyTime < FeedBackActivity.this.mUploadPicSize) {
                FeedBackActivity.this.mFeedbackUploader.p();
            }
        }
    }

    private void addUTClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777592562")) {
            ipChange.ipc$dispatch("777592562", new Object[]{this, str});
            return;
        }
        if (this.mFeedBackId == null) {
            this.mFeedBackId = "0";
        }
        if (this.mFeedBackTitle == null) {
            this.mFeedBackTitle = "意见反馈";
        }
        cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
        yd1 x = yd1.x();
        e2.x(x.u(this.mFeedBackId + JSMethod.NOT_SET + this.mFeedBackTitle, str));
    }

    private void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796934659")) {
            ipChange.ipc$dispatch("796934659", new Object[]{this});
            return;
        }
        EditText editText = this.mContentEd;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deleteFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120858985")) {
            ipChange.ipc$dispatch("1120858985", new Object[]{this});
            return;
        }
        try {
            String m = cn.damai.common.util.a.m();
            if (!TextUtils.isEmpty(m)) {
                String str = m + "/feedback";
                this.mFilePath = str;
                cn.damai.common.util.a.f(str);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doSelectFile() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512055661")) {
            ipChange.ipc$dispatch("512055661", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 1000);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void error(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-873453434")) {
            ipChange.ipc$dispatch("-873453434", new Object[]{this, str, str2});
            return;
        }
        stopDMProgressDialog();
        if (TextUtils.isEmpty(str2)) {
            str2 = bk2.b(this, R$string.damai_faq_submit_failure_toast);
        }
        ToastUtil.i(str2);
    }

    private void getIntentData() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111479966")) {
            ipChange.ipc$dispatch("111479966", new Object[]{this});
            return;
        }
        this.mPaths.clear();
        if (getIntent() != null && (extras = getIntent().getExtras()) != null) {
            if (extras.containsKey(SocialConstants.PARAM_APP_DESC)) {
                String string = extras.getString(SocialConstants.PARAM_APP_DESC, getResources().getString(R$string.damai_faq_input_your_feedback_hint));
                this.mFeedBackHit = string;
                this.mContentEd.setHint(string);
            } else if (extras.containsKey("descInfo")) {
                String string2 = extras.getString("descInfo", "");
                this.mContentEd.setText(string2);
                this.mContentEd.setSelection(string2.length());
            }
            if (extras.containsKey("name")) {
                this.mFeedBackId = extras.getString("name", "0");
            }
            if (extras.containsKey("title")) {
                this.mFeedBackTitle = extras.getString("title", "");
            }
            if (hp1.i(lp1.STORAGE) && extras.containsKey("screenView")) {
                reduceImage(extras.getString("screenView"), false);
            }
            if (extras.containsKey("data")) {
                ArrayList parcelableArrayList = extras.getParcelableArrayList("data");
                this.mFeedBackList.clear();
                this.mFeedBackList.addAll(parcelableArrayList);
                initQuestType();
            }
            if (extras.containsKey("fromPage")) {
                this.mScreenShotFromPage = extras.getString("fromPage");
            }
            if (extras.containsKey("module")) {
                this.mScreenShotModule = extras.getString("module");
            }
            if (extras.containsKey("extra")) {
                this.mScreenShotExtra = extras.getString("extra");
            }
        }
    }

    private void initEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922543952")) {
            ipChange.ipc$dispatch("1922543952", new Object[]{this});
            return;
        }
        this.mAddImageLayout.setOnClickListener(this);
        this.mSubmitBtn.setOnClickListener(this);
        this.mContentEd.addTextChangedListener(this.mTextWatcherListener);
        String m = cn.damai.common.util.a.m();
        if (!TextUtils.isEmpty(m)) {
            try {
                String str = m + "/feedback";
                this.mFilePath = str;
                cn.damai.common.util.a.t(str, false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void initImageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287094518")) {
            ipChange.ipc$dispatch("-287094518", new Object[]{this});
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mScreenWidth = i;
        this.mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        int a2 = (i - n42.a(this, 38.0f)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        this.mAddImageLayout.setLayoutParams(layoutParams);
        this.mImageLayouts.clear();
        for (int i2 = 0; i2 < 3; i2++) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R$layout.merg_add_image, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            this.mAddImageContainer.addView(frameLayout);
            frameLayout.setVisibility(8);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) frameLayout.findViewById(R$id.image_tag);
            dMIconFontTextView.setTag(Integer.valueOf(i2));
            dMIconFontTextView.setOnClickListener(this.mDeleteClickListener);
            this.mImageLayouts.add(frameLayout);
        }
    }

    private void initQuestType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1614187246")) {
            ipChange.ipc$dispatch("1614187246", new Object[]{this});
            return;
        }
        int e2 = xf2.e(this.mFeedBackList);
        if (e2 > 0) {
            this.mTvDesc.setVisibility(0);
            this.mFlowLayout.setVisibility(0);
        } else {
            this.mTvDesc.setVisibility(8);
            this.mFlowLayout.setVisibility(8);
        }
        this.mFlowLayout.removeAllViews();
        int i = -1;
        for (int i2 = 0; i2 < e2; i2++) {
            FeedBack feedBack = this.mFeedBackList.get(i2);
            if (!TextUtils.isEmpty(feedBack.subTitle)) {
                i++;
                View inflate = this.mInflater.inflate(R$layout.feed_back_quest, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_quest);
                textView.setText(feedBack.subTitle);
                if (feedBack.name.equals(this.mFeedBackId)) {
                    this.mSelectQuestView = textView;
                    updateQuestTypeView(textView);
                } else {
                    updateUnQuestTypeView(textView);
                }
                this.mFlowLayout.addView(inflate);
                feedBack.index = i;
                textView.setTag(feedBack);
                textView.setOnClickListener(this.mQuestTypeListener);
            }
        }
    }

    private boolean isPicVerify(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076739087")) {
            return ((Boolean) ipChange.ipc$dispatch("1076739087", new Object[]{this, str})).booleanValue();
        }
        for (int i = 0; i < this.picFormArray.length; i++) {
            if (str.toLowerCase().endsWith(this.picFormArray[i])) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onAllUploadFinish(List<ss2> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511914197")) {
            ipChange.ipc$dispatch("1511914197", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            for (ss2 ss2 : list) {
                if (ss2.d() != null) {
                    AusResult ausResult = null;
                    if (ss2.d().getBizResult() != null) {
                        ausResult = (AusResult) pn.e().parseJson(ss2.d().getBizResult(), AusResult.class);
                    }
                    if (ausResult == null) {
                        ausResult = new AusResult();
                    }
                    String fileUrl = ss2.d().getFileUrl();
                    if (fileUrl != null) {
                        try {
                            String j = a01.INSTANCE.j(Uri.parse(fileUrl), fileUrl);
                            if (j != null) {
                                fileUrl = j;
                            }
                            ausResult.url = fileUrl;
                        } catch (Exception e2) {
                            g91.d(e2);
                        }
                    }
                    this.mARupReplyData.add(ausResult);
                }
            }
            requestSubmitFeedBack();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        if (r6 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r6.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (0 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r4.mPaths.add(r5);
     */
    private void reduceImage(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183215141")) {
            ipChange.ipc$dispatch("1183215141", new Object[]{this, str, Boolean.valueOf(z)});
        } else if (!TextUtils.isEmpty(str) && isPicVerify(str)) {
            if (z) {
                Bitmap bitmap = null;
                try {
                    if (!TextUtils.isEmpty(this.mFilePath)) {
                        String str2 = this.mFilePath + "/" + cn.damai.common.util.a.k(str);
                        cn.damai.common.util.a.d(str2);
                        bitmap = cn.damai.common.util.a.i(str);
                        cn.damai.common.util.a.u(bitmap, str2);
                        str = str2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    if (0 != 0) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } else {
                this.mPaths.add(str);
            }
            updateImageLayout();
        }
    }

    private void requestSubmitFeedBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558417838")) {
            ipChange.ipc$dispatch("1558417838", new Object[]{this});
            return;
        }
        FeedBackSubmitRequest feedBackSubmitRequest = new FeedBackSubmitRequest();
        feedBackSubmitRequest.content = this.mUploadContent;
        if (xf2.e(this.mARupReplyData) > 0) {
            feedBackSubmitRequest.imageAddrs = JSON.toJSONString(this.mARupReplyData);
        }
        feedBackSubmitRequest.resolution = this.mScreenHeight + jl1.MUL + this.mScreenWidth;
        feedBackSubmitRequest.bizIdentifiers = this.mFeedBackId;
        if (!TextUtils.isEmpty(this.mScreenShotFromPage)) {
            feedBackSubmitRequest.fromPage = this.mScreenShotFromPage;
        }
        if (!TextUtils.isEmpty(this.mScreenShotModule)) {
            feedBackSubmitRequest.module = this.mScreenShotModule;
        }
        if (!TextUtils.isEmpty(this.mScreenShotExtra)) {
            feedBackSubmitRequest.extra = this.mScreenShotExtra;
        }
        feedBackSubmitRequest.request(new DMMtopResultRequestListener<FeedBackResult>(FeedBackResult.class) {
            /* class cn.damai.mine.activity.FeedBackActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "698193338")) {
                    ipChange.ipc$dispatch("698193338", new Object[]{this, str, str2});
                    return;
                }
                FeedBackActivity.this.error(str, str2);
            }

            public void onSuccess(FeedBackResult feedBackResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1785118494")) {
                    ipChange.ipc$dispatch("1785118494", new Object[]{this, feedBackResult});
                    return;
                }
                FeedBackActivity.this.returnFeedBack(feedBackResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void returnFeedBack(FeedBackResult feedBackResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969340858")) {
            ipChange.ipc$dispatch("-1969340858", new Object[]{this, feedBackResult});
            return;
        }
        stopDMProgressDialog();
        if (feedBackResult != null && feedBackResult.isSuccess) {
            ToastUtil.i(getString(R$string.damai_faq_submit_success_toast));
            this.mSubmitHandler.sendEmptyMessageDelayed(4, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBtnEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895275199")) {
            ipChange.ipc$dispatch("-895275199", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mAddImageLayout.setEnabled(z);
        this.mSubmitBtn.setEnabled(z);
    }

    private void submitFeedBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643224045")) {
            ipChange.ipc$dispatch("-1643224045", new Object[]{this});
            return;
        }
        String obj = this.mContentEd.getText().toString();
        if (xf2.j(obj)) {
            ToastUtil.i(getString(R$string.damai_faq_input_feedback_toast));
            return;
        }
        this.mUploadPicSize = xf2.e(this.mPaths);
        String str = obj + Constants.WAVE_SEPARATOR + this.mUploadPicSize;
        this.mUploadContent = str;
        addUTClick(str);
        startDMProgressDialog();
        this.mARupReplyData.clear();
        this.mReplyTime = 0;
        if (this.mUploadPicSize == 0) {
            requestSubmitFeedBack();
            return;
        }
        FileUploader fileUploader = this.mFeedbackUploader;
        if (fileUploader != null) {
            fileUploader.C(null);
        }
        FileUploader q = FileUploader.q("feedback_oss");
        this.mFeedbackUploader = q;
        q.C(this.mSubmitListener).y().G(this.mPaths);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateImageLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367945570")) {
            ipChange.ipc$dispatch("-1367945570", new Object[]{this});
            return;
        }
        int e2 = xf2.e(this.mPaths);
        for (int i = 0; i < 3; i++) {
            FrameLayout frameLayout = this.mImageLayouts.get(i);
            ImageView imageView = (ImageView) frameLayout.findViewById(R$id.image_bg);
            if (i < e2) {
                frameLayout.setVisibility(0);
                le1 j = le1.p(this).j(String.format("file://%1$s", this.mPaths.get(i)));
                int i2 = R$drawable.uikit_default_image_bg_gradient;
                j.m(i2).e(i2).g(imageView);
            } else {
                frameLayout.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateQuestTypeView(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811272322")) {
            ipChange.ipc$dispatch("1811272322", new Object[]{this, textView});
            return;
        }
        textView.setTextColor(ContextCompat.getColor(this, R$color.white));
        textView.setBackgroundResource(R$drawable.bg_border_corner_red);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateSubmitState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129980138")) {
            ipChange.ipc$dispatch("1129980138", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mSubmitBtn.setEnabled(true);
            this.mSubmitBtn.setBackgroundResource(R$drawable.feedback_submit_button_bg);
            this.mSubmitBtn.setTextColor(ContextCompat.getColor(this, R$color.white));
        } else {
            this.mSubmitBtn.setEnabled(false);
            this.mSubmitBtn.setBackgroundResource(R$drawable.photo_select_normal);
            this.mSubmitBtn.setTextColor(ContextCompat.getColor(this, R$color.color_666666));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUnQuestTypeView(TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632080233")) {
            ipChange.ipc$dispatch("632080233", new Object[]{this, textView});
            return;
        }
        textView.setTextColor(ContextCompat.getColor(this, R$color.color_888888));
        textView.setBackgroundResource(R$drawable.bg_border_corner_ff_no_trans);
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259582344")) {
            ipChange.ipc$dispatch("-1259582344", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        onBackPressed();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "232274546")) {
            return R$layout.faq_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("232274546", new Object[]{this})).intValue();
    }

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324062885")) {
            ipChange.ipc$dispatch("-324062885", new Object[]{this});
            return;
        }
        this.base_header_title.setText(getResources().getString(R$string.damai_faq_feedback_title));
        this.mTvDesc = (TextView) findViewById(R$id.tv_desc);
        this.mFlowLayout = (FlowLayout) findViewById(R$id.fl_desc);
        EditText editText = (EditText) findViewById(R$id.et_content);
        this.mContentEd = editText;
        editText.setHint(getResources().getString(R$string.damai_faq_input_your_feedback_hint));
        this.mSubmitBtn = (Button) findViewById(R$id.btn_submit);
        this.mAddImageLayout = (FrameLayout) findViewById(R$id.fl_add_image);
        this.mAddImageContainer = (LinearLayout) findViewById(R$id.ll_add_image);
        this.mTvDesc.setVisibility(8);
        updateSubmitState(false);
        initImageView();
        initEvent();
        getIntentData();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559041918")) {
            ipChange.ipc$dispatch("-559041918", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1000) {
            reduceImage(cn.damai.common.util.a.l(getApplicationContext(), intent.getData()), true);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281445602")) {
            ipChange.ipc$dispatch("-281445602", new Object[]{this});
            return;
        }
        deleteFile();
        Handler handler = this.mSubmitHandler;
        if (handler != null) {
            handler.removeMessages(4);
            this.mSubmitHandler = null;
        }
        super.onBackPressed();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1774134655")) {
            ipChange.ipc$dispatch("-1774134655", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int id = view.getId();
        if (id == R$id.fl_add_image) {
            if (xf2.e(this.mPaths) < 3) {
                hp1.b(this, false, lp1.STORAGE, "才能添加图片～", new b());
            } else {
                ToastUtil.i("最多上传3张图片哟~");
            }
        } else if (id == R$id.btn_submit) {
            submitFeedBack();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759159039")) {
            ipChange.ipc$dispatch("1759159039", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(yd1.x().t());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504486938")) {
            ipChange.ipc$dispatch("1504486938", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            clearData();
            getIntentData();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-565055130")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-565055130", new Object[]{this});
    }

    public void startDMProgressDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926582694")) {
            ipChange.ipc$dispatch("-1926582694", new Object[]{this});
        } else if (!isFinishing()) {
            if (this.mDMProgressDialog == null) {
                DMProgressDialog a2 = new DMProgressDialog(this.mContext).a();
                this.mDMProgressDialog = a2;
                a2.setOnDismissListener(new g());
            }
            this.mDMProgressDialog.show();
            setBtnEnable(false);
        }
    }

    public void stopDMProgressDialog() {
        DMProgressDialog dMProgressDialog;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "528242192")) {
            ipChange.ipc$dispatch("528242192", new Object[]{this});
        } else if (!isFinishing() && (dMProgressDialog = this.mDMProgressDialog) != null) {
            dMProgressDialog.dismiss();
            this.mDMProgressDialog = null;
        }
    }
}
