package cn.damai.commonbusiness.photoselect.imageselected;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.view.MyViewPager;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.DMVideoPlayerDefaultController;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import tb.cs;
import tb.ne2;

/* compiled from: Taobao */
public class PreviewDeleteActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ArrayList<Image> tempImages;
    private static ArrayList<Image> tempSelectImages;
    private ImagePagerAdapter adapter;
    private DMIconFontTextView btnConfirm;
    private boolean isShowBar = true;
    private boolean isSingle;
    private DMVideoPlayerDefaultController mController;
    private ArrayList<Image> mImages;
    private int mMaxCount;
    private ArrayList<Image> mSelectImages;
    private DMVideoPlayer mVideoPlayer;
    private int position;
    private LinearLayout rlTopBar;
    private View status_bar_gap;
    private TextView tvIndicator;
    private String type;
    private MyViewPager vpImage;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1036385306")) {
                ipChange.ipc$dispatch("1036385306", new Object[]{this, view});
                return;
            }
            PreviewDeleteActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1147291621")) {
                ipChange.ipc$dispatch("-1147291621", new Object[]{this, view});
                return;
            }
            PreviewDeleteActivity.this.showPhotoCustomDialog();
        }
    }

    /* compiled from: Taobao */
    public class c implements ImagePagerAdapter.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter.OnItemClickListener
        @RequiresApi(api = 11)
        public void onItemClick(int i, Image image) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "262336268")) {
                ipChange.ipc$dispatch("262336268", new Object[]{this, Integer.valueOf(i), image});
            } else if (PreviewDeleteActivity.this.isShowBar) {
                PreviewDeleteActivity.this.hideBar();
            } else {
                PreviewDeleteActivity.this.showBar();
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
            if (AndroidInstantRuntime.support(ipChange, "-1402013617")) {
                ipChange.ipc$dispatch("-1402013617", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if ("2".equals(PreviewDeleteActivity.this.type)) {
                PreviewDeleteActivity.this.delVideoFinish();
            } else {
                int currentItem = PreviewDeleteActivity.this.vpImage.getCurrentItem();
                PreviewDeleteActivity.this.clickSelect();
                PreviewDeleteActivity.this.mImages.remove(currentItem);
                PreviewDeleteActivity.this.adapter.notifyDataSetChanged();
                TextView textView = PreviewDeleteActivity.this.tvIndicator;
                textView.setText((PreviewDeleteActivity.this.vpImage.getCurrentItem() + 1) + "/" + PreviewDeleteActivity.this.mImages.size());
                if (PreviewDeleteActivity.this.mImages.size() == 0) {
                    PreviewDeleteActivity.this.finish();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clickSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730969526")) {
            ipChange.ipc$dispatch("-1730969526", new Object[]{this});
            return;
        }
        int currentItem = this.vpImage.getCurrentItem();
        ArrayList<Image> arrayList = this.mImages;
        if (arrayList != null && arrayList.size() > currentItem) {
            Image image = this.mImages.get(currentItem);
            if (this.mSelectImages.contains(image)) {
                image.setShowNum(0);
                this.mSelectImages.remove(image);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void delVideoFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2061173273")) {
            ipChange.ipc$dispatch("2061173273", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        intent.putExtra("selectedList", new ArrayList());
        intent.putExtra("selected", arrayList);
        setResult(-1, intent);
        super.finish();
    }

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2142501903")) {
            return ((Integer) ipChange.ipc$dispatch("-2142501903", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @RequiresApi(api = 11)
    private void hideBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113559331")) {
            ipChange.ipc$dispatch("-1113559331", new Object[]{this});
            return;
        }
        this.isShowBar = false;
        LinearLayout linearLayout = this.rlTopBar;
        ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, (float) (-linearLayout.getHeight())).setDuration(300L);
        duration.addListener(new AnimatorListenerAdapter() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "380370389")) {
                    ipChange.ipc$dispatch("380370389", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (PreviewDeleteActivity.this.rlTopBar != null) {
                    PreviewDeleteActivity.this.rlTopBar.setVisibility(8);
                    PreviewDeleteActivity.this.rlTopBar.postDelayed(new Runnable() {
                        /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity.AnonymousClass6.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1213807044")) {
                                ipChange.ipc$dispatch("1213807044", new Object[]{this});
                                return;
                            }
                            PreviewDeleteActivity.this.setStatusBarVisible(false);
                        }
                    }, 5);
                }
            }
        });
        duration.start();
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187097144")) {
            ipChange.ipc$dispatch("1187097144", new Object[]{this});
            return;
        }
        findViewById(R$id.btn_back).setOnClickListener(new a());
        this.btnConfirm.setOnClickListener(new b());
    }

    private void initVideo() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314880893")) {
            ipChange.ipc$dispatch("-314880893", new Object[]{this});
            return;
        }
        ArrayList<Image> arrayList = this.mImages;
        if (arrayList != null && arrayList.size() > (i = this.position) && this.mImages.get(i) != null && !TextUtils.isEmpty(this.mImages.get(this.position).getPath()) && this.mVideoPlayer != null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
            videoInfo.setVideoUrl(this.mImages.get(this.position).getPath());
            if (!TextUtils.isEmpty(this.mImages.get(this.position).getThumbnail())) {
                videoInfo.setPicUrl(this.mImages.get(this.position).getThumbnail());
            } else {
                videoInfo.setVideoThumbnailType("1");
            }
            this.mVideoPlayer.setVideoData(videoInfo);
            this.mVideoPlayer.autoPlay();
            cs.d().k(this.mVideoPlayer);
        }
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215456128")) {
            ipChange.ipc$dispatch("215456128", new Object[]{this});
            return;
        }
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, this.mImages);
        this.adapter = imagePagerAdapter;
        this.vpImage.setAdapter(imagePagerAdapter);
        this.adapter.c(new c());
        this.vpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "899761045")) {
                    ipChange.ipc$dispatch("899761045", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-529844940")) {
                    ipChange.ipc$dispatch("-529844940", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "320842016")) {
                    ipChange.ipc$dispatch("320842016", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TextView textView = PreviewDeleteActivity.this.tvIndicator;
                textView.setText((i + 1) + "/" + PreviewDeleteActivity.this.mImages.size());
            }
        });
    }

    private void onVideoPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902700318")) {
            ipChange.ipc$dispatch("-902700318", new Object[]{this});
        }
    }

    public static void openDeleteActivity(Activity activity, ArrayList<Image> arrayList, ArrayList<Image> arrayList2, boolean z, int i, int i2, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1583047825")) {
            ipChange.ipc$dispatch("-1583047825", new Object[]{activity, arrayList, arrayList2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)});
            return;
        }
        tempImages = (ArrayList) arrayList.clone();
        tempSelectImages = (ArrayList) arrayList2.clone();
        Intent intent = new Intent(activity, PreviewDeleteActivity.class);
        intent.putExtra(cn.damai.commonbusiness.photoselect.imageselected.constant.Constants.MAX_SELECT_COUNT, i);
        intent.putExtra(cn.damai.commonbusiness.photoselect.imageselected.constant.Constants.IS_SINGLE, z);
        intent.putExtra("position", i2);
        intent.putExtra("type", str);
        activity.startActivityForResult(intent, i3);
    }

    private void setStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-98704374")) {
            ipChange.ipc$dispatch("-98704374", new Object[]{this});
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @RequiresApi(api = 11)
    private void setStatusBarVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1998882713")) {
            ipChange.ipc$dispatch("1998882713", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1028);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @RequiresApi(api = 11)
    private void showBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681511848")) {
            ipChange.ipc$dispatch("-681511848", new Object[]{this});
            return;
        }
        this.isShowBar = true;
        setStatusBarVisible(true);
        this.rlTopBar.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.PreviewDeleteActivity$5$a */
            /* compiled from: Taobao */
            public class a extends AnimatorListenerAdapter {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "721980026")) {
                        ipChange.ipc$dispatch("721980026", new Object[]{this, animator});
                        return;
                    }
                    super.onAnimationStart(animator);
                    if (PreviewDeleteActivity.this.rlTopBar != null) {
                        PreviewDeleteActivity.this.rlTopBar.setVisibility(0);
                    }
                }
            }

            @RequiresApi(api = 11)
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "84336978")) {
                    ipChange.ipc$dispatch("84336978", new Object[]{this});
                } else if (PreviewDeleteActivity.this.rlTopBar != null) {
                    ObjectAnimator duration = ObjectAnimator.ofFloat(PreviewDeleteActivity.this.rlTopBar, "translationY", PreviewDeleteActivity.this.rlTopBar.getTranslationY(), 0.0f).setDuration(300L);
                    duration.addListener(new a());
                    duration.start();
                }
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showPhotoCustomDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687556224")) {
            ipChange.ipc$dispatch("-1687556224", new Object[]{this});
            return;
        }
        DMDialog dMDialog = new DMDialog(this);
        dMDialog.v(getResources().getString(R$string.damai_delete_image));
        dMDialog.g(R$string.damai_no, null);
        dMDialog.l(R$string.damai_yes, new d());
        dMDialog.show();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836420932")) {
            ipChange.ipc$dispatch("836420932", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283218537")) {
            ipChange.ipc$dispatch("283218537", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mImages.size(); i++) {
            arrayList.add(this.mImages.get(i).getPath());
        }
        intent.putExtra("selected", arrayList);
        intent.putExtra("selectedList", this.mImages);
        setResult(-1, intent);
        super.finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "152859174")) {
            return R$layout.activity_delete_preview;
        }
        return ((Integer) ipChange.ipc$dispatch("152859174", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1418331627")) {
            ipChange.ipc$dispatch("-1418331627", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352253622")) {
            ipChange.ipc$dispatch("352253622", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069444135")) {
            ipChange.ipc$dispatch("2069444135", new Object[]{this});
            return;
        }
        this.status_bar_gap = findViewById(R$id.title_bar_space_view);
        this.vpImage = (MyViewPager) findViewById(R$id.vp_image);
        this.tvIndicator = (TextView) findViewById(R$id.tv_indicator);
        this.btnConfirm = (DMIconFontTextView) findViewById(R$id.btn_confirm);
        this.rlTopBar = (LinearLayout) findViewById(R$id.rl_top_bar);
        this.mVideoPlayer = (DMVideoPlayer) findViewById(R$id.video_player);
        DMVideoPlayerDefaultController dMVideoPlayerDefaultController = new DMVideoPlayerDefaultController(this);
        this.mController = dMVideoPlayerDefaultController;
        this.mVideoPlayer.setController(dMVideoPlayerDefaultController);
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "709793234")) {
            ipChange.ipc$dispatch("709793234", new Object[]{this});
        } else if (!cs.d().e()) {
            super.onBackPressed();
            cs.d().f();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    @RequiresApi(api = 11)
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841237325")) {
            ipChange.ipc$dispatch("-1841237325", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setStatusBarVisible(true);
        this.mImages = tempImages;
        tempImages = null;
        this.mSelectImages = tempSelectImages;
        tempSelectImages = null;
        Intent intent = getIntent();
        this.mMaxCount = intent.getIntExtra(cn.damai.commonbusiness.photoselect.imageselected.constant.Constants.MAX_SELECT_COUNT, 0);
        this.isSingle = intent.getBooleanExtra(cn.damai.commonbusiness.photoselect.imageselected.constant.Constants.IS_SINGLE, false);
        this.type = intent.getStringExtra("type");
        this.position = intent.getIntExtra("position", 0);
        setStatusBarColor();
        initListener();
        hideBaseLayout();
        if ("2".equals(this.type)) {
            this.tvIndicator.setVisibility(8);
            this.vpImage.setVisibility(8);
            this.mVideoPlayer.setVisibility(0);
            initVideo();
            return;
        }
        this.tvIndicator.setVisibility(0);
        TextView textView = this.tvIndicator;
        textView.setText("1/" + this.mImages.size());
        this.vpImage.setVisibility(0);
        this.mVideoPlayer.setVisibility(8);
        initViewPager();
        this.vpImage.setCurrentItem(this.position);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067532979")) {
            ipChange.ipc$dispatch("1067532979", new Object[]{this});
            return;
        }
        super.onDestroy();
        cs.d().j();
    }

    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211684553")) {
            ipChange.ipc$dispatch("-1211684553", new Object[]{this});
            return;
        }
        super.onPause();
        onVideoPause();
        cs.d().f();
    }

    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554696272")) {
            ipChange.ipc$dispatch("-1554696272", new Object[]{this});
            return;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168579765")) {
            ipChange.ipc$dispatch("-1168579765", new Object[]{this});
            return;
        }
        super.onStart();
        if ("2".equals(this.type)) {
            cs.d().m();
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "615554586")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("615554586", new Object[]{this});
    }
}
