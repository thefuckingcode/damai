package cn.damai.commonbusiness.photoselect.imageselected;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter;
import cn.damai.commonbusiness.photoselect.imageselected.constant.Constants;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel;
import cn.damai.commonbusiness.photoselect.imageselected.utils.MediaUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import tb.c01;
import tb.hp1;
import tb.hq1;
import tb.k01;
import tb.lp1;
import tb.ne2;
import tb.sm0;
import tb.xf2;

/* compiled from: Taobao */
public class ImageSelectorActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FOLDER_REQUEST_CODE = 100;
    private static final int PERMISSION_REQUEST_CODE = 17;
    private static final int REQUEST_CODE_TAKE_PHOTO = 101;
    private RelativeLayout bottomBar;
    private LinearLayout btnConfirm;
    private FrameLayout btnPreview;
    private LinearLayout btn_folder;
    private boolean isSingle;
    private boolean isToSettings = false;
    private ImageAdapter mAdapter;
    private long mDate;
    private String mFileName;
    private sm0 mFolder;
    private ArrayList<sm0> mFolders;
    private GridLayoutManager mLayoutManager;
    private int mMaxCount;
    private ArrayList<String> mSelectedImages;
    private File mTempFile;
    private RecyclerView rvImage;
    private View status_bar_gap;
    private TextView tvConfirm;
    private TextView tvConfirmNum;
    private TextView tvFolderName;
    private TextView tvPreview;
    private TextView tv_title_video;
    private String type;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1703348308")) {
                ipChange.ipc$dispatch("-1703348308", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ImageSelectorActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "421571105")) {
                ipChange.ipc$dispatch("421571105", new Object[]{this, view});
                return;
            }
            ImageSelectorActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1762105822")) {
                ipChange.ipc$dispatch("-1762105822", new Object[]{this, view});
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(ImageSelectorActivity.this.mAdapter.l());
            ImageSelectorActivity.this.toPreviewActivity(arrayList, 0);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "349184547")) {
                ipChange.ipc$dispatch("349184547", new Object[]{this, view});
                return;
            }
            ImageSelectorActivity.this.confirm();
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834492380")) {
                ipChange.ipc$dispatch("-1834492380", new Object[]{this, view});
                return;
            }
            ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
            ImageSelectFolderActivity.openActivity(imageSelectorActivity, 100, imageSelectorActivity.mAdapter.l(), ImageSelectorActivity.this.mFolders);
        }
    }

    /* compiled from: Taobao */
    public class f implements ImageAdapter.OnImageSelectListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter.OnImageSelectListener
        public void OnImageSelect(Image image, boolean z, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1287379560")) {
                ipChange.ipc$dispatch("-1287379560", new Object[]{this, image, Boolean.valueOf(z), Integer.valueOf(i)});
                return;
            }
            ImageSelectorActivity.this.setSelectImageCount(i);
        }
    }

    /* compiled from: Taobao */
    public class g implements ImageAdapter.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.adapter.ImageAdapter.OnItemClickListener
        public void OnItemClick(Image image, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "689627163")) {
                ipChange.ipc$dispatch("689627163", new Object[]{this, image, Integer.valueOf(i)});
            } else if ("3".equals(image.getType())) {
                ImageSelectorActivity.this.openCamera();
            } else {
                ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
                imageSelectorActivity.toPreviewActivity(imageSelectorActivity.mAdapter.k(), i);
            }
        }
    }

    /* compiled from: Taobao */
    public class h implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "819126551")) {
                ipChange.ipc$dispatch("819126551", new Object[]{this});
                return;
            }
            hq1.f().g("picture_upload");
            if (Build.VERSION.SDK_INT >= 24) {
                ImageSelectorActivity.this.takePhotoBiggerThan7();
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
            File externalCacheDir = ImageSelectorActivity.this.getExternalCacheDir();
            imageSelectorActivity.mTempFile = new File(externalCacheDir, format + ".jpg");
            intent.putExtra("output", Uri.fromFile(ImageSelectorActivity.this.mTempFile));
            ImageSelectorActivity.this.startActivityForResult(intent, 101);
        }
    }

    /* compiled from: Taobao */
    public class i implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "892657446")) {
                ipChange.ipc$dispatch("892657446", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            ImageSelectorActivity.this.startAppSettings();
            ImageSelectorActivity.this.isToSettings = true;
        }
    }

    private void checkPermissionAndLoadImages() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956484763")) {
            ipChange.ipc$dispatch("-1956484763", new Object[]{this});
        } else if (Environment.getExternalStorageState().equals("mounted")) {
            if (ContextCompat.checkSelfPermission(getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                loadDataForSdCard();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 17);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void confirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425514183")) {
            ipChange.ipc$dispatch("425514183", new Object[]{this});
            return;
        }
        ImageAdapter imageAdapter = this.mAdapter;
        if (imageAdapter != null) {
            ArrayList<Image> l = imageAdapter.l();
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<Image> it = l.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPath());
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra(c01.SELECT_RESULT, arrayList);
            intent.putParcelableArrayListExtra("imagelist", l);
            setResult(-1, intent);
            finish();
        }
    }

    private void initImageList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704898046")) {
            ipChange.ipc$dispatch("704898046", new Object[]{this});
            return;
        }
        if (getResources().getConfiguration().orientation == 1) {
            this.mLayoutManager = new GridLayoutManager(this, MediaUtils.e);
        } else {
            this.mLayoutManager = new GridLayoutManager(this, 5);
        }
        this.rvImage.setLayoutManager(this.mLayoutManager);
        ImageAdapter imageAdapter = new ImageAdapter(this, this.mMaxCount, this.isSingle);
        this.mAdapter = imageAdapter;
        this.rvImage.setAdapter(imageAdapter);
        ((SimpleItemAnimator) this.rvImage.getItemAnimator()).setSupportsChangeAnimations(false);
        ArrayList<sm0> arrayList = this.mFolders;
        if (arrayList != null && !arrayList.isEmpty()) {
            setFolder(this.mFolders.get(0));
        }
        this.mAdapter.u(new f());
        this.mAdapter.v(new g());
    }

    private void initListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-466663873")) {
            ipChange.ipc$dispatch("-466663873", new Object[]{this});
            return;
        }
        findViewById(R$id.btn_back).setOnClickListener(new b());
        this.btnPreview.setOnClickListener(new c());
        this.btnConfirm.setOnClickListener(new d());
        findViewById(R$id.btn_folder).setOnClickListener(new e());
        this.rvImage.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            /* class cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1569673615")) {
                    ipChange.ipc$dispatch("-1569673615", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-621668722")) {
                    ipChange.ipc$dispatch("-621668722", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                }
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }

    private void loadDataForSdCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750771347")) {
            ipChange.ipc$dispatch("-750771347", new Object[]{this});
        } else if ("2".equals(this.type)) {
            loadVideoForSdCard();
        } else {
            loadImageForSDCard(false);
        }
    }

    private void loadImageForSDCard(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-565600506")) {
            ipChange.ipc$dispatch("-565600506", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ImageModel.loadImageForSDCard(this, new ImageModel.DataCallback() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.DataCallback
            public void onSuccess(ArrayList<sm0> arrayList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2039171977")) {
                    ipChange.ipc$dispatch("-2039171977", new Object[]{this, arrayList});
                    return;
                }
                ImageSelectorActivity.this.mFolders = arrayList;
                ImageSelectorActivity.this.runOnUiThread(new Runnable() {
                    /* class cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.AnonymousClass11.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1033540001")) {
                            ipChange.ipc$dispatch("-1033540001", new Object[]{this});
                        } else if (ImageSelectorActivity.this.mFolders != null && !ImageSelectorActivity.this.mFolders.isEmpty()) {
                            Image image = new Image();
                            image.setType("3");
                            image.setPath("take_picture");
                            if (xf2.e(((sm0) ImageSelectorActivity.this.mFolders.get(0)).b()) > 0) {
                                ((sm0) ImageSelectorActivity.this.mFolders.get(0)).b().add(0, image);
                            } else {
                                ArrayList<Image> arrayList = new ArrayList<>();
                                arrayList.add(image);
                                ((sm0) ImageSelectorActivity.this.mFolders.get(0)).d(arrayList);
                            }
                            ImageSelectorActivity imageSelectorActivity = ImageSelectorActivity.this;
                            imageSelectorActivity.setFolder((sm0) imageSelectorActivity.mFolders.get(0));
                            AnonymousClass11 r0 = AnonymousClass11.this;
                            if (z) {
                                Image image2 = ((sm0) ImageSelectorActivity.this.mFolders.get(0)).b().get(1);
                                image2.setShowNum(ImageSelectorActivity.this.mAdapter.l().size() + 1);
                                ImageSelectorActivity.this.mAdapter.l().add(image2);
                                ImageSelectorActivity.this.mAdapter.notifyDataSetChanged();
                                ImageSelectorActivity imageSelectorActivity2 = ImageSelectorActivity.this;
                                imageSelectorActivity2.setSelectImageCount(imageSelectorActivity2.mAdapter.l().size());
                            }
                            ImageSelectorActivity.this.setSelectImage();
                        }
                    }
                });
            }
        });
    }

    private void loadVideoForSdCard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092820110")) {
            ipChange.ipc$dispatch("1092820110", new Object[]{this});
            return;
        }
        startProgressDialog();
        MediaUtils.c().f(this, new ImageModel.DataCallback() {
            /* class cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.photoselect.imageselected.model.ImageModel.DataCallback
            public void onSuccess(final ArrayList<sm0> arrayList) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1709406216")) {
                    ipChange.ipc$dispatch("-1709406216", new Object[]{this, arrayList});
                    return;
                }
                ImageSelectorActivity.this.stopProgressDialog();
                ImageSelectorActivity.this.runOnUiThread(new Runnable() {
                    /* class cn.damai.commonbusiness.photoselect.imageselected.ImageSelectorActivity.AnonymousClass12.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-904457282")) {
                            ipChange.ipc$dispatch("-904457282", new Object[]{this});
                            return;
                        }
                        ArrayList arrayList = arrayList;
                        if (arrayList != null && arrayList.size() > 0 && arrayList.get(0) != null) {
                            ArrayList<Image> b = ((sm0) arrayList.get(0)).b();
                            if (!(b == null || b.size() <= 0 || ImageSelectorActivity.this.mAdapter == null)) {
                                ImageSelectorActivity.this.rvImage.scrollToPosition(0);
                                ImageSelectorActivity.this.mAdapter.q(b);
                            }
                            ImageSelectorActivity.this.setSelectImage();
                        }
                    }
                });
            }
        });
    }

    public static void openActivity(Activity activity, int i2, boolean z, int i3, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641236396")) {
            ipChange.ipc$dispatch("-1641236396", new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), arrayList});
            return;
        }
        Intent intent = new Intent(activity, ImageSelectorActivity.class);
        intent.putExtra(Constants.MAX_SELECT_COUNT, i3);
        intent.putExtra(Constants.IS_SINGLE, z);
        intent.putStringArrayListExtra("selected", arrayList);
        activity.startActivityForResult(intent, i2);
    }

    private Uri saveAppDCIMFils(Bitmap bitmap, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546379399")) {
            return (Uri) ipChange.ipc$dispatch("-546379399", new Object[]{this, bitmap, str});
        }
        ContentResolver contentResolver = getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put(SocialConstants.PARAM_COMMENT, str);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", "DCIM/DM/");
        } else {
            contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
        }
        contentValues.put("mime_type", "image/jpeg");
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream openOutputStream = getContentResolver().openOutputStream(insert);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, openOutputStream);
            openOutputStream.flush();
            openOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return insert;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setFolder(sm0 sm0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035323416")) {
            ipChange.ipc$dispatch("2035323416", new Object[]{this, sm0});
        } else if (sm0 != null && this.mAdapter != null && !sm0.equals(this.mFolder)) {
            this.mFolder = sm0;
            this.tvFolderName.setText(sm0.c());
            this.rvImage.scrollToPosition(0);
            this.mAdapter.q(sm0.b());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSelectImage() {
        ImageAdapter imageAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880389626")) {
            ipChange.ipc$dispatch("-880389626", new Object[]{this});
        } else if ("2".equals(this.type)) {
            setSelectImageCount(0);
        } else {
            ArrayList<String> arrayList = this.mSelectedImages;
            if (arrayList != null && (imageAdapter = this.mAdapter) != null) {
                imageAdapter.w(arrayList);
                this.mSelectedImages = null;
                if (this.mAdapter.l() == null || this.mAdapter.l().size() <= 0) {
                    setSelectImageCount(0);
                } else {
                    setSelectImageCount(this.mAdapter.l().size());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSelectImageCount(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069785746")) {
            ipChange.ipc$dispatch("-1069785746", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 == 0) {
            this.btnConfirm.setEnabled(false);
            this.btnPreview.setEnabled(false);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_unable_btn_h36);
            this.tvPreview.setTextColor(Color.parseColor("#66666666"));
            this.tvConfirmNum.setVisibility(8);
        } else {
            this.btnConfirm.setEnabled(true);
            this.btnPreview.setEnabled(true);
            this.btnConfirm.setBackgroundResource(R$drawable.submit_enable_btn_h36);
            this.tvPreview.setTextColor(Color.parseColor("#666666"));
            TextView textView = this.tvConfirmNum;
            textView.setText(i2 + "");
            this.tvConfirmNum.setVisibility(0);
        }
    }

    private void setStatusBarColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-121392029")) {
            ipChange.ipc$dispatch("-121392029", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 23) {
            View view = this.status_bar_gap;
            if (view != null) {
                view.getLayoutParams().height = ne2.a(this);
                this.status_bar_gap.setVisibility(0);
            }
            ne2.f(this, true, R$color.black);
            ne2.d(true, this);
        } else {
            ne2.f(this, false, R$color.black);
            View view2 = this.status_bar_gap;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    private void showExceptionDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603547277")) {
            ipChange.ipc$dispatch("1603547277", new Object[]{this});
            return;
        }
        new DMDialog(this).o(false).v(PurchaseConstants.NORMAL_WARNING_TITLE).q("该相册需要赋予访问存储的权限，请到“设置”>“应用”>“权限”中配置权限。").t(3).i("取消", new a()).n("确定", new i()).show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startAppSettings() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711726399")) {
            ipChange.ipc$dispatch("-1711726399", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void takePhotoBiggerThan7() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70323348")) {
            ipChange.ipc$dispatch("-70323348", new Object[]{this});
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        this.mDate = time;
        this.mFileName = simpleDateFormat.format(Long.valueOf(time));
        File externalCacheDir = getExternalCacheDir();
        this.mTempFile = new File(externalCacheDir, this.mFileName + ".jpg");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("_data", this.mTempFile.getAbsolutePath());
        Uri insert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        intent.putExtra("output", insert);
        startActivityForResult(intent, 101);
        Log.d("xxtag", "path   ======  " + this.mTempFile.getAbsolutePath());
        Log.d("xxtag", "uri from insert: ======  " + insert);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void toPreviewActivity(ArrayList<Image> arrayList, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1133485852")) {
            ipChange.ipc$dispatch("-1133485852", new Object[]{this, arrayList, Integer.valueOf(i2)});
        } else if (arrayList != null && !arrayList.isEmpty()) {
            PreviewActivity.openActivity(this, arrayList, this.mAdapter.l(), this.isSingle, this.mMaxCount, i2, this.type);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411236917")) {
            ipChange.ipc$dispatch("-411236917", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1424508609")) {
            return R$layout.activity_image_select;
        }
        return ((Integer) ipChange.ipc$dispatch("-1424508609", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222874652")) {
            ipChange.ipc$dispatch("1222874652", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "625269647")) {
            ipChange.ipc$dispatch("625269647", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737223598")) {
            ipChange.ipc$dispatch("1737223598", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        this.mMaxCount = intent.getIntExtra(Constants.MAX_SELECT_COUNT, 0);
        this.isSingle = intent.getBooleanExtra(Constants.IS_SINGLE, false);
        this.mSelectedImages = intent.getStringArrayListExtra("selected");
        this.type = intent.getStringExtra("type");
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<sm0> arrayList;
        int intExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664902165")) {
            ipChange.ipc$dispatch("664902165", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i2 == 18) {
            if (intent == null || !intent.getBooleanExtra(Constants.IS_CONFIRM, false)) {
                this.mAdapter.notifyDataSetChanged();
                setSelectImageCount(this.mAdapter.l().size());
                return;
            }
            confirm();
        } else if (i2 == 100) {
            if (intent != null && (arrayList = this.mFolders) != null && !arrayList.isEmpty() && this.mFolders.size() > (intExtra = intent.getIntExtra("position", 0))) {
                setFolder(this.mFolders.get(intExtra));
            }
        } else if (i3 == -1 && i2 == 101) {
            try {
                k01.d(this, this.mTempFile);
                if (Build.VERSION.SDK_INT <= 29) {
                    saveAppDCIMFils(BitmapFactory.decodeFile(this.mTempFile.getAbsolutePath()), this.mFileName);
                }
                loadImageForSDCard(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1723357814")) {
            ipChange.ipc$dispatch("-1723357814", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager != null && this.mAdapter != null) {
            int i2 = configuration.orientation;
            if (i2 == 1) {
                gridLayoutManager.setSpanCount(MediaUtils.e);
            } else if (i2 == 2) {
                gridLayoutManager.setSpanCount(5);
            }
            this.mAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-614144052")) {
            ipChange.ipc$dispatch("-614144052", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        removeHeadTitleView();
        this.status_bar_gap = findViewById(R$id.title_bar_space_view);
        this.tv_title_video = (TextView) findViewById(R$id.tv_title_video);
        this.btn_folder = (LinearLayout) findViewById(R$id.btn_folder);
        this.rvImage = (RecyclerView) findViewById(R$id.rv_image);
        this.bottomBar = (RelativeLayout) findViewById(R$id.rl_bottom_bar);
        this.tvConfirmNum = (TextView) findViewById(R$id.tv_confirm_num);
        this.tvConfirm = (TextView) findViewById(R$id.tv_confirm);
        this.tvPreview = (TextView) findViewById(R$id.tv_preview);
        this.btnConfirm = (LinearLayout) findViewById(R$id.btn_confirm);
        this.btnPreview = (FrameLayout) findViewById(R$id.btn_preview);
        this.tvFolderName = (TextView) findViewById(R$id.tv_folder_name);
        setStatusBarColor();
        initListener();
        initImageList();
        checkPermissionAndLoadImages();
        if ("2".equals(this.type)) {
            this.tv_title_video.setVisibility(0);
            this.btn_folder.setVisibility(8);
            this.bottomBar.setVisibility(8);
        } else {
            this.tv_title_video.setVisibility(8);
            this.btn_folder.setVisibility(0);
            this.bottomBar.setVisibility(0);
        }
        setDamaiUTKeyBuilder(new a.b().i("select_pic"));
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829542069")) {
            ipChange.ipc$dispatch("-1829542069", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792840042")) {
            ipChange.ipc$dispatch("1792840042", new Object[]{this});
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1003947940")) {
            ipChange.ipc$dispatch("-1003947940", new Object[]{this, Integer.valueOf(i2), strArr, iArr});
        } else if (i2 != 17) {
        } else {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showExceptionDialog();
            } else {
                loadDataForSdCard();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625107228")) {
            ipChange.ipc$dispatch("-625107228", new Object[]{this});
            return;
        }
        super.onStart();
        if (this.isToSettings) {
            this.isToSettings = false;
            checkPermissionAndLoadImages();
        }
    }

    public void openCamera() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711682124")) {
            ipChange.ipc$dispatch("-1711682124", new Object[]{this});
            return;
        }
        hp1.b(this, false, lp1.CAMERA, "才能拍照添加图片～", new h());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-732887693")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("-732887693", new Object[]{this});
    }

    public static void openActivity(Activity activity, int i2, boolean z, int i3, String str, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343287222")) {
            ipChange.ipc$dispatch("-343287222", new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, arrayList});
            return;
        }
        Intent intent = new Intent(activity, ImageSelectorActivity.class);
        intent.putExtra(Constants.MAX_SELECT_COUNT, i3);
        intent.putExtra(Constants.IS_SINGLE, z);
        intent.putStringArrayListExtra("selected", arrayList);
        intent.putExtra("type", str);
        activity.startActivityForResult(intent, i2);
    }
}
