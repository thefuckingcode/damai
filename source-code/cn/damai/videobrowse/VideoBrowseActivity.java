package cn.damai.videobrowse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.videobrowse.fragment.ImageFragment;
import cn.damai.videobrowse.view.ControlScrollViewPager;
import cn.damai.wxapi.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cs;
import tb.d20;
import tb.f92;
import tb.g91;
import tb.hp1;
import tb.lp1;
import tb.ne2;
import tb.pv2;
import tb.ts0;

/* compiled from: Taobao */
public class VideoBrowseActivity extends DamaiBaseActivity implements ImageFragment.OnImageLongClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = VideoBrowseActivity.class.getSimpleName();
    private TextView cursor;
    private DMIconFontTextView mBackView;
    private int mCurPosition;
    private int mCurScreenOrientation;
    private LinearLayout mLvIntroduceInfo;
    private View.OnClickListener mOnImageDownloadClickListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private List<PicInfo> mPicInfoList;
    private int mPicNum;
    private String mProjectId;
    private RelativeLayout mRvTitleBar;
    private DMIconFontTextView mTvImageDownload;
    private TextView mTvIntro;
    private String mVideoId;
    private VideoImageAdapter mVideoImageAdapter;
    private List<VideoInfo> mVideoInfoList;
    private int mVideoNum;
    private ControlScrollViewPager mViewerPager;
    private View status_bar_gap;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1161579906")) {
                ipChange.ipc$dispatch("1161579906", new Object[]{this, view});
                return;
            }
            VideoBrowseActivity.this.onBackPressed();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            PicInfo picInfo;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1089193348")) {
                ipChange.ipc$dispatch("1089193348", new Object[]{this, view});
            } else if (VideoBrowseActivity.this.mCurPosition >= VideoBrowseActivity.this.mVideoNum && VideoBrowseActivity.this.mCurPosition < VideoBrowseActivity.this.mVideoNum + VideoBrowseActivity.this.mPicNum && (picInfo = (PicInfo) VideoBrowseActivity.this.mPicInfoList.get(VideoBrowseActivity.this.mCurPosition - VideoBrowseActivity.this.mVideoNum)) != null && !TextUtils.isEmpty(picInfo.getPicUrl())) {
                VideoBrowseActivity.this.saveImageToLocalGallery(picInfo.getPicUrl());
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-688540361")) {
                ipChange.ipc$dispatch("-688540361", new Object[]{this, dVar});
                return;
            }
            ToastUtil.a().e(VideoBrowseActivity.this, "保存失败");
        }
    }

    /* compiled from: Taobao */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1085579660")) {
                ipChange.ipc$dispatch("1085579660", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null) {
                VideoBrowseActivity.this.saveToLocal(bitmap);
            }
        }
    }

    private void fixStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883469736")) {
            ipChange.ipc$dispatch("-883469736", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.status_bar_gap.setVisibility(0);
            }
            ne2.f(this, true, R$color.white);
            ne2.e(this);
        } else {
            ne2.f(this, false, R$color.white);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private String getCurVideoId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372636966")) {
            return (String) ipChange.ipc$dispatch("1372636966", new Object[]{this});
        } else if (this.mCurPosition >= this.mVideoNum) {
            return "";
        } else {
            VideoInfo videoInfo = null;
            List<VideoInfo> list = this.mVideoInfoList;
            if (list != null && list.size() > 0) {
                videoInfo = this.mVideoInfoList.get(this.mCurPosition);
            }
            if (videoInfo != null) {
                return videoInfo.getVid();
            }
            return "";
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557486116")) {
            ipChange.ipc$dispatch("-557486116", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mProjectId = intent.getStringExtra("projectId");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("pic_info");
        this.mPicInfoList = parcelableArrayListExtra;
        if (f92.d(parcelableArrayListExtra)) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("pic_info_map");
            if (!f92.d(arrayList)) {
                this.mPicInfoList = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl((String) ((HashMap) it.next()).get("img"));
                    this.mPicInfoList.add(picInfo);
                }
            }
        }
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("video_info");
        this.mVideoInfoList = parcelableArrayListExtra2;
        if (f92.d(parcelableArrayListExtra2)) {
            ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("video_info_map");
            if (!f92.d(arrayList2)) {
                this.mVideoInfoList = new ArrayList();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    HashMap hashMap = (HashMap) it2.next();
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.setPicUrl((String) hashMap.get("img"));
                    videoInfo.setVideoUrl((String) hashMap.get("url"));
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                    this.mVideoInfoList.add(videoInfo);
                }
            }
        }
        this.mCurPosition = intent.getIntExtra("position", -1);
        List<VideoInfo> list = this.mVideoInfoList;
        if (list != null && !list.isEmpty()) {
            this.mVideoNum = this.mVideoInfoList.size();
        }
        List<PicInfo> list2 = this.mPicInfoList;
        if (list2 != null && !list2.isEmpty()) {
            this.mPicNum = this.mPicInfoList.size();
        }
        this.mCurScreenOrientation = 1;
        try {
            int i = this.mCurPosition;
            if (i >= 0 && this.mVideoNum >= i + 1) {
                VideoInfo videoInfo2 = this.mVideoInfoList.get(i);
                String vid = videoInfo2.getVid();
                this.mVideoId = vid;
                if (TextUtils.isEmpty(vid)) {
                    this.mVideoId = videoInfo2.getVideoUrl();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477907113")) {
            ipChange.ipc$dispatch("-477907113", new Object[]{this});
            return;
        }
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.videobrowse.VideoBrowseActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1183229295")) {
                    ipChange.ipc$dispatch("1183229295", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                g91.b(str, "onPageScrolled(), state = " + i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-585821938")) {
                    ipChange.ipc$dispatch("-585821938", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                g91.b(str, "onPageScrolled(), positionOffset = " + f + ", positionOffsetPixels = " + i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1415754618")) {
                    ipChange.ipc$dispatch("1415754618", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                String str = VideoBrowseActivity.TAG;
                g91.b(str, "onPageSelected(), position = " + i);
                VideoBrowseActivity.this.mCurPosition = i;
                VideoBrowseActivity.this.setImagePositionIndicator();
                VideoBrowseActivity.this.updateIntroduceContent();
            }
        };
        this.mOnImageDownloadClickListener = new b();
    }

    private void initPosterView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348954046")) {
            ipChange.ipc$dispatch("-348954046", new Object[]{this});
            return;
        }
        this.cursor = (TextView) findViewById(R$id.video_image_browse_position_tv);
        setImagePositionIndicator();
        this.mViewerPager = (ControlScrollViewPager) findViewById(R$id.video_image_browse_viewer);
        VideoImageAdapter videoImageAdapter = new VideoImageAdapter(getSupportFragmentManager(), this.mProjectId, this.mVideoInfoList, this.mPicInfoList);
        this.mVideoImageAdapter = videoImageAdapter;
        this.mViewerPager.setAdapter(videoImageAdapter);
        this.mViewerPager.setScroll(true);
        this.mLvIntroduceInfo = (LinearLayout) findViewById(R$id.video_image_info_rv);
        this.mTvIntro = (TextView) findViewById(R$id.video_image_intro_tv);
        this.mTvImageDownload = (DMIconFontTextView) findViewById(R$id.image_download_tv);
        updateIntroduceContent();
    }

    private void initTitleViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196299170")) {
            ipChange.ipc$dispatch("-196299170", new Object[]{this});
            return;
        }
        this.status_bar_gap = findViewById(R$id.status_bar_gap);
        this.mRvTitleBar = (RelativeLayout) findViewById(R$id.video_image_browse_title_bar);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) findViewById(R$id.video_image_browse_back_tv);
        this.mBackView = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new a());
        fixStatusBar();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void saveImageToLocalGallery(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169876688")) {
            ipChange.ipc$dispatch("1169876688", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            cn.damai.common.image.a.b().c(str).n(new d()).e(new c()).f();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setImagePositionIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939297191")) {
            ipChange.ipc$dispatch("-939297191", new Object[]{this});
        } else if (this.mVideoNum + this.mPicNum > 1) {
            TextView textView = this.cursor;
            textView.setText((this.mCurPosition + 1) + "/" + (this.mVideoNum + this.mPicNum));
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954869954")) {
            ipChange.ipc$dispatch("954869954", new Object[]{this});
            return;
        }
        this.mViewerPager.addOnPageChangeListener(this.mOnPageChangeListener);
        this.mViewerPager.setCurrentItem(this.mCurPosition);
        this.mTvImageDownload.setOnClickListener(this.mOnImageDownloadClickListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateIntroduceContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "121148705")) {
            ipChange.ipc$dispatch("121148705", new Object[]{this});
            return;
        }
        String str = "";
        int i = this.mCurPosition;
        int i2 = this.mVideoNum;
        if (i < i2) {
            VideoInfo videoInfo = null;
            List<VideoInfo> list = this.mVideoInfoList;
            if (list != null && list.size() > 0) {
                videoInfo = this.mVideoInfoList.get(this.mCurPosition);
            }
            if (videoInfo != null) {
                str = videoInfo.getTitle();
            }
            this.mTvImageDownload.setVisibility(8);
        } else {
            int i3 = this.mPicNum;
            if (i3 > 0 && i < i3 + i2) {
                PicInfo picInfo = this.mPicInfoList.get(i - i2);
                if (picInfo != null) {
                    str = picInfo.getPicDesc();
                }
                this.mLvIntroduceInfo.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.mTvIntro.setVisibility(8);
            this.mLvIntroduceInfo.setVisibility(8);
            return;
        }
        this.mTvIntro.setVisibility(0);
        this.mLvIntroduceInfo.setVisibility(0);
        this.mTvIntro.setText(str);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987179180")) {
            ipChange.ipc$dispatch("1987179180", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-708279362")) {
            return R$layout.activity_video_image_browse_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("-708279362", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951144829")) {
            ipChange.ipc$dispatch("1951144829", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726808654")) {
            ipChange.ipc$dispatch("1726808654", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101206927")) {
            ipChange.ipc$dispatch("101206927", new Object[]{this});
            return;
        }
        hideBaseLayout();
        initExtraData();
        initTitleViews();
        initPosterView();
        initListeners();
        setupListeners();
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084348266")) {
            ipChange.ipc$dispatch("2084348266", new Object[]{this});
        } else if (cs.d().e()) {
            pv2.g().i("fullscreen", Constants.Event.RETURN, false, this.mProjectId, getCurVideoId(), d20.E());
        } else {
            pv2.g().i("top", Constants.Event.RETURN, true, this.mProjectId, getCurVideoId(), d20.E());
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283009461")) {
            ipChange.ipc$dispatch("-1283009461", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        g91.b(TAG, "onCreate()");
        setDamaiUTKeyBuilder(pv2.g().f(this.mProjectId, this.mVideoId, d20.E()));
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "181721675")) {
            ipChange.ipc$dispatch("181721675", new Object[]{this});
            return;
        }
        super.onDestroy();
        g91.b(TAG, "onDestroy()");
    }

    @Override // cn.damai.videobrowse.fragment.ImageFragment.OnImageLongClickListener
    public void onImageLongClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489145406")) {
            ipChange.ipc$dispatch("1489145406", new Object[]{this, str});
            return;
        }
        saveImageToLocalGallery(str);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772865231")) {
            ipChange.ipc$dispatch("1772865231", new Object[]{this});
            return;
        }
        super.onPause();
        g91.b(TAG, "onPause()");
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772033816")) {
            ipChange.ipc$dispatch("772033816", new Object[]{this});
            return;
        }
        super.onResume();
        g91.b(TAG, "onResume()");
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1815970019")) {
            ipChange.ipc$dispatch("1815970019", new Object[]{this});
            return;
        }
        super.onStart();
        g91.b(TAG, "onStart()");
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205718237")) {
            ipChange.ipc$dispatch("-205718237", new Object[]{this});
            return;
        }
        super.onStop();
        g91.b(TAG, "onStop()");
    }

    public void saveToLocal(final Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459585755")) {
            ipChange.ipc$dispatch("1459585755", new Object[]{this, bitmap});
            return;
        }
        hp1.b(this, false, lp1.STORAGE, "才能保存图片～", new OnGrantListener() {
            /* class cn.damai.videobrowse.VideoBrowseActivity.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.askpermission.OnGrantListener
            public void onGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1738543144")) {
                    ipChange.ipc$dispatch("-1738543144", new Object[]{this});
                    return;
                }
                ts0.b().a(new Runnable() {
                    /* class cn.damai.videobrowse.VideoBrowseActivity.AnonymousClass6.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-96610468")) {
                            ipChange.ipc$dispatch("-96610468", new Object[]{this});
                            return;
                        }
                        AnonymousClass6 r0 = AnonymousClass6.this;
                        Bitmap bitmap = bitmap;
                        if (bitmap != null) {
                            String saveBitmapToDcimDir = ShareUtil.saveBitmapToDcimDir(VideoBrowseActivity.this, bitmap);
                            if (!TextUtils.isEmpty(saveBitmapToDcimDir)) {
                                VideoBrowseActivity.this.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(saveBitmapToDcimDir))));
                                VideoBrowseActivity.this.runOnUiThread(new Runnable() {
                                    /* class cn.damai.videobrowse.VideoBrowseActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    public void run() {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-1007079441")) {
                                            ipChange.ipc$dispatch("-1007079441", new Object[]{this});
                                            return;
                                        }
                                        ToastUtil.a().e(VideoBrowseActivity.this, "已保存到本地相册");
                                    }
                                });
                                return;
                            }
                            VideoBrowseActivity.this.runOnUiThread(new Runnable() {
                                /* class cn.damai.videobrowse.VideoBrowseActivity.AnonymousClass6.AnonymousClass1.AnonymousClass2 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "-1203592946")) {
                                        ipChange.ipc$dispatch("-1203592946", new Object[]{this});
                                        return;
                                    }
                                    ToastUtil.a().e(VideoBrowseActivity.this, "保存失败");
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1085408690")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("1085408690", new Object[]{this});
    }
}
