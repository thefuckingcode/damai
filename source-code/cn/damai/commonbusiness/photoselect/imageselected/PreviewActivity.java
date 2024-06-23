package cn.damai.commonbusiness.photoselect.imageselected;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter;
import cn.damai.commonbusiness.photoselect.imageselected.constant.Constants;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask;
import cn.damai.commonbusiness.photoselect.imageselected.view.MyViewPager;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.DMVideoPlayerDefaultController;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.cs;
import tb.ne2;

/* compiled from: Taobao */
public class PreviewActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ArrayList<Image> tempImages;
    private static ArrayList<Image> tempSelectImages;
    private LinearLayout btnConfirm;
    private boolean isConfirm = false;
    private boolean isShowBar = true;
    private boolean isSingle;
    private LinearLayout llTopBar;
    private DMVideoPlayerDefaultController mController;
    private ArrayList<Image> mImages;
    private int mMaxCount;
    private ArrayList<Image> mSelectImages;
    private String mVideoFilePath;
    private DMVideoPlayer mVideoPlayer;
    private int position;
    private RelativeLayout rlBottomBar;
    private View status_bar_gap;
    String tempPath;
    private TextView tvConfirm;
    private TextView tvConfirmNum;
    private TextView tvSelect;
    private TextView tvVideoSelect;
    private String type;
    private MyViewPager vpImage;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1435758287")) {
                ipChange.ipc$dispatch("1435758287", new Object[]{this, view});
                return;
            }
            PreviewActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-747918640")) {
                ipChange.ipc$dispatch("-747918640", new Object[]{this, view});
                return;
            }
            PreviewActivity.this.isConfirm = true;
            PreviewActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363371729")) {
                ipChange.ipc$dispatch("1363371729", new Object[]{this, view});
                return;
            }
            PreviewActivity.this.clickSelect();
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-820305198")) {
                ipChange.ipc$dispatch("-820305198", new Object[]{this, view});
                return;
            }
            PreviewActivity.this.clickSelect();
            PreviewActivity.this.isConfirm = true;
            PreviewActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class e implements ImagePagerAdapter.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter.OnItemClickListener
        @RequiresApi(api = 11)
        public void onItemClick(int i, Image image) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2027193653")) {
                ipChange.ipc$dispatch("2027193653", new Object[]{this, Integer.valueOf(i), image});
            } else if (PreviewActivity.this.isShowBar) {
                PreviewActivity.this.hideBar();
            } else {
                PreviewActivity.this.showBar();
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f(PreviewActivity previewActivity) {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "880142520")) {
                ipChange.ipc$dispatch("880142520", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void changeSelect(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043620831")) {
            ipChange.ipc$dispatch("-2043620831", new Object[]{this, image});
            return;
        }
        if (this.mSelectImages.contains(image)) {
            this.tvSelect.setBackgroundResource(R$drawable.circle_ff2869_oval);
            TextView textView = this.tvSelect;
            textView.setText(image.getShowNum() + "");
        } else {
            this.tvSelect.setBackgroundResource(R$drawable.circle_per60_white_oval);
            this.tvSelect.setText("");
        }
        setSelectImageCount(this.mSelectImages.size());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clickSelect() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9083125")) {
            ipChange.ipc$dispatch("9083125", new Object[]{this});
            return;
        }
        int currentItem = this.vpImage.getCurrentItem();
        if ("2".equals(this.type)) {
            currentItem = this.position;
        }
        ArrayList<Image> arrayList = this.mImages;
        if (arrayList != null && arrayList.size() > currentItem) {
            Image image = this.mImages.get(currentItem);
            if (this.mSelectImages.contains(image)) {
                this.mSelectImages.remove(image);
                int showNum = image.getShowNum();
                image.setShowNum(0);
                setSelectImageNum(showNum);
            } else if (this.isSingle) {
                if (this.mSelectImages.size() > 0) {
                    String string = this.mContext.getResources().getString(R$string.damai_add_image_count, String.valueOf(this.mMaxCount));
                    DMDialog dMDialog = new DMDialog(this.mContext);
                    dMDialog.v(string);
                    dMDialog.l(R$string.damai_know, null);
                    dMDialog.show();
                } else if (!image.isImageLimit(this.mContext)) {
                    for (int i2 = 0; i2 < this.mSelectImages.size(); i2++) {
                        this.mSelectImages.get(i2).setShowNum(0);
                    }
                    this.mSelectImages.clear();
                    this.mSelectImages.add(image);
                    if ("2".equals(this.type)) {
                        image.setPath(this.tempPath);
                    }
                    image.setShowNum(this.mSelectImages.size());
                }
            } else if (this.mMaxCount <= 0 || this.mSelectImages.size() < (i = this.mMaxCount)) {
                if (!image.isImageLimit(this.mContext)) {
                    this.mSelectImages.add(image);
                    image.setShowNum(this.mSelectImages.size());
                }
            } else if (i == this.mSelectImages.size()) {
                DMDialog dMDialog2 = new DMDialog(this);
                dMDialog2.v(getResources().getString(R$string.damai_add_image_count, String.valueOf(this.mMaxCount)));
                dMDialog2.l(R$string.damai_know, new f(this));
                dMDialog2.show();
            }
            if (!"2".equals(this.type)) {
                changeSelect(image);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @RequiresApi(api = 11)
    private void hideBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501336840")) {
            ipChange.ipc$dispatch("1501336840", new Object[]{this});
            return;
        }
        this.isShowBar = false;
        LinearLayout linearLayout = this.llTopBar;
        ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout, "translationY", 0.0f, (float) (-linearLayout.getHeight())).setDuration(300L);
        duration.addListener(new AnimatorListenerAdapter() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewActivity.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1887233396")) {
                    ipChange.ipc$dispatch("-1887233396", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (PreviewActivity.this.llTopBar != null) {
                    PreviewActivity.this.llTopBar.setVisibility(8);
                    PreviewActivity.this.llTopBar.postDelayed(new Runnable() {
                        /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewActivity.AnonymousClass8.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-208098643")) {
                                ipChange.ipc$dispatch("-208098643", new Object[]{this});
                                return;
                            }
                            PreviewActivity.this.setStatusBarVisible(false);
                        }
                    }, 5);
                }
            }
        });
        duration.start();
        RelativeLayout relativeLayout = this.rlBottomBar;
        ObjectAnimator.ofFloat(relativeLayout, "translationY", 0.0f, (float) relativeLayout.getHeight()).setDuration(300L).start();
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-705845523")) {
            ipChange.ipc$dispatch("-705845523", new Object[]{this});
            return;
        }
        findViewById(R$id.btn_back).setOnClickListener(new a());
        this.btnConfirm.setOnClickListener(new b());
        this.tvSelect.setOnClickListener(new c());
        this.tvVideoSelect.setOnClickListener(new d());
    }

    private void initVideo() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44471278")) {
            ipChange.ipc$dispatch("44471278", new Object[]{this});
            return;
        }
        this.tempPath = null;
        ArrayList<Image> arrayList = this.mImages;
        if (arrayList != null && arrayList.size() > (i = this.position) && this.mImages.get(i) != null) {
            String path = this.mImages.get(this.position).getPath();
            this.mVideoFilePath = path;
            if (!TextUtils.isEmpty(path) && this.mVideoPlayer != null) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                videoInfo.setUseNativePlayer(true);
                if (Build.VERSION.SDK_INT >= 29) {
                    this.tempPath = ImageTask.a(this, Uri.parse(this.mVideoFilePath), this.mImages.get(this.position).getName());
                } else {
                    this.tempPath = this.mVideoFilePath;
                }
                videoInfo.setVideoUrl(this.tempPath);
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
    }

    private void initViewPager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663775595")) {
            ipChange.ipc$dispatch("1663775595", new Object[]{this});
            return;
        }
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, this.mImages);
        this.vpImage.setAdapter(imagePagerAdapter);
        imagePagerAdapter.c(new e());
        this.vpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewActivity.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "771761662")) {
                    ipChange.ipc$dispatch("771761662", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "222531741")) {
                    ipChange.ipc$dispatch("222531741", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1913009463")) {
                    ipChange.ipc$dispatch("-1913009463", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                PreviewActivity previewActivity = PreviewActivity.this;
                previewActivity.changeSelect((Image) previewActivity.mImages.get(i));
            }
        });
    }

    public static void openActivity(Activity activity, ArrayList<Image> arrayList, ArrayList<Image> arrayList2, boolean z, int i, int i2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320046860")) {
            ipChange.ipc$dispatch("-320046860", new Object[]{activity, arrayList, arrayList2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        tempImages = arrayList;
        tempSelectImages = arrayList2;
        Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(Constants.MAX_SELECT_COUNT, i);
        intent.putExtra(Constants.IS_SINGLE, z);
        intent.putExtra("position", i2);
        intent.putExtra("type", str);
        activity.startActivityForResult(intent, 18);
    }

    private void setSelectImageCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078396388")) {
            ipChange.ipc$dispatch("-2078396388", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.btnConfirm.setEnabled(false);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_unable_btn_h36);
            this.tvConfirmNum.setVisibility(8);
        } else {
            this.btnConfirm.setEnabled(true);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_enable_btn_h36);
            TextView textView = this.tvConfirmNum;
            textView.setText(i + "");
            this.tvConfirmNum.setVisibility(0);
        }
    }

    private void setSelectImageNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-276233517")) {
            ipChange.ipc$dispatch("-276233517", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ArrayList<Image> arrayList = this.mSelectImages;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.mSelectImages.size(); i2++) {
                if (this.mSelectImages.get(i2).getShowNum() > i) {
                    this.mSelectImages.get(i2).setShowNum(this.mSelectImages.get(i2).getShowNum() - 1);
                }
            }
        }
    }

    private void setStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743556725")) {
            ipChange.ipc$dispatch("1743556725", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-587792562")) {
            ipChange.ipc$dispatch("-587792562", new Object[]{this, Boolean.valueOf(z)});
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
        if (AndroidInstantRuntime.support(ipChange, "1933384323")) {
            ipChange.ipc$dispatch("1933384323", new Object[]{this});
            return;
        }
        this.isShowBar = true;
        setStatusBarVisible(true);
        this.llTopBar.postDelayed(new Runnable() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.PreviewActivity.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.PreviewActivity$7$a */
            /* compiled from: Taobao */
            public class a extends AnimatorListenerAdapter {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-184257615")) {
                        ipChange.ipc$dispatch("-184257615", new Object[]{this, animator});
                        return;
                    }
                    super.onAnimationStart(animator);
                    if (PreviewActivity.this.llTopBar != null) {
                        PreviewActivity.this.llTopBar.setVisibility(0);
                    }
                }
            }

            @RequiresApi(api = 11)
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1343191163")) {
                    ipChange.ipc$dispatch("1343191163", new Object[]{this});
                } else if (PreviewActivity.this.llTopBar != null) {
                    ObjectAnimator duration = ObjectAnimator.ofFloat(PreviewActivity.this.llTopBar, "translationY", PreviewActivity.this.llTopBar.getTranslationY(), 0.0f).setDuration(300L);
                    duration.addListener(new a());
                    duration.start();
                    ObjectAnimator.ofFloat(PreviewActivity.this.rlBottomBar, "translationY", PreviewActivity.this.rlBottomBar.getTranslationY(), 0.0f).setDuration(300L).start();
                }
            }
        }, 100);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480206713")) {
            ipChange.ipc$dispatch("480206713", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void finish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48071970")) {
            ipChange.ipc$dispatch("-48071970", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(Constants.IS_CONFIRM, this.isConfirm);
        setResult(18, intent);
        super.finish();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1892911825")) {
            return R$layout.activity_preview;
        }
        return ((Integer) ipChange.ipc$dispatch("1892911825", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983693002")) {
            ipChange.ipc$dispatch("983693002", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800573089")) {
            ipChange.ipc$dispatch("1800573089", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526846812")) {
            ipChange.ipc$dispatch("1526846812", new Object[]{this});
            return;
        }
        this.status_bar_gap = findViewById(R$id.title_bar_space_view);
        this.vpImage = (MyViewPager) findViewById(R$id.vp_image);
        this.tvConfirm = (TextView) findViewById(R$id.tv_confirm);
        this.tvConfirmNum = (TextView) findViewById(R$id.tv_confirm_num);
        this.btnConfirm = (LinearLayout) findViewById(R$id.btn_confirm);
        this.tvSelect = (TextView) findViewById(R$id.tv_select);
        this.tvVideoSelect = (TextView) findViewById(R$id.tv_video_select);
        this.rlBottomBar = (RelativeLayout) findViewById(R$id.rl_bottom_bar);
        this.llTopBar = (LinearLayout) findViewById(R$id.rl_top_bar);
        this.mVideoPlayer = (DMVideoPlayer) findViewById(R$id.video_player);
        this.mController = new DMVideoPlayerDefaultController(this);
        this.mVideoPlayer.setAutoAdaptVideoSize(true);
        this.mVideoPlayer.setController(this.mController);
        hideBaseLayout();
    }

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136854595")) {
            ipChange.ipc$dispatch("-2136854595", new Object[]{this});
        } else if (!cs.d().e()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    @RequiresApi(api = 11)
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050970974")) {
            ipChange.ipc$dispatch("2050970974", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setStatusBarVisible(true);
        this.mImages = tempImages;
        tempImages = null;
        this.mSelectImages = tempSelectImages;
        tempSelectImages = null;
        Intent intent = getIntent();
        this.mMaxCount = intent.getIntExtra(Constants.MAX_SELECT_COUNT, 0);
        this.isSingle = intent.getBooleanExtra(Constants.IS_SINGLE, false);
        this.type = intent.getStringExtra("type");
        this.position = intent.getIntExtra("position", 0);
        setStatusBarColor();
        initListener();
        if ("2".equals(this.type)) {
            this.vpImage.setVisibility(8);
            this.tvSelect.setVisibility(8);
            this.rlBottomBar.setVisibility(8);
            this.tvVideoSelect.setVisibility(0);
            this.mVideoPlayer.setVisibility(0);
            initVideo();
            return;
        }
        this.vpImage.setVisibility(0);
        this.tvSelect.setVisibility(0);
        this.rlBottomBar.setVisibility(0);
        this.tvVideoSelect.setVisibility(8);
        this.mVideoPlayer.setVisibility(8);
        initViewPager();
        this.vpImage.setCurrentItem(this.position);
        int i = this.position;
        if (i == 0) {
            changeSelect(this.mImages.get(i));
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426885150")) {
            ipChange.ipc$dispatch("1426885150", new Object[]{this});
            return;
        }
        super.onDestroy();
        cs.d().j();
    }

    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403211618")) {
            ipChange.ipc$dispatch("1403211618", new Object[]{this});
            return;
        }
        super.onPause();
        cs.d().f();
    }

    @Override // androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097293595")) {
            ipChange.ipc$dispatch("-2097293595", new Object[]{this});
            return;
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446316406")) {
            ipChange.ipc$dispatch("1446316406", new Object[]{this});
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
        if (!AndroidInstantRuntime.support(ipChange, "-676483195")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-676483195", new Object[]{this});
    }
}
