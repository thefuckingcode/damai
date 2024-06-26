package cn.damai.h5container;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.baseview.CropImageView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tb.g91;
import tb.gq1;

/* compiled from: Taobao */
public class CaptureActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CROP_SUCCESS = 4112;
    public static final int GRESS_SUCCESS = 4114;
    public static final int LOCK_SUCCESS = 4115;
    public static final int OPERA_CANCEL = 4113;
    ImageButton ib_gress;
    CropImageView iv_img;
    ImageView iv_lock;
    private Bitmap mCalculateBitmap;
    Handler mHandler = new Handler() {
        /* class cn.damai.h5container.CaptureActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "750447261")) {
                ipChange.ipc$dispatch("750447261", new Object[]{this, message});
                return;
            }
            CaptureActivity.this.stopProgressDialog();
            if (message.what == 4112 && ((Bitmap) message.obj) != null) {
                CaptureActivity.this.setResult(-1);
                CaptureActivity.this.finish();
            }
            super.handleMessage(message);
        }
    };
    private final int maxFilelength = e.DX_ERROR_CODE_SLIDER_LAYOUT_ITEM_COUNT_0;
    RelativeLayout rl_lock;
    TextView tv_cancel;
    TextView tv_ok;
    int width;

    private void closeIO(InputStream inputStream, OutputStream outputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1044617229")) {
            ipChange.ipc$dispatch("1044617229", new Object[]{this, inputStream, outputStream});
            return;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                g91.d(e);
                return;
            }
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bitmap cropImage(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1662973919")) {
            return (Bitmap) ipChange.ipc$dispatch("-1662973919", new Object[]{this, bitmap});
        } else if (bitmap == null || bitmap.isRecycled()) {
            return null;
        } else {
            int i = 100;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            int length = byteArrayOutputStream.toByteArray().length;
            while (length > 200000) {
                byteArrayOutputStream.reset();
                i -= 10;
                this.mCalculateBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                length = byteArrayOutputStream.toByteArray().length;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, length);
            saveToAvatar(byteArrayOutputStream, gq1.a(this));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return decodeByteArray;
        }
    }

    private void display() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009007340")) {
            ipChange.ipc$dispatch("-2009007340", new Object[]{this});
            return;
        }
        Bitmap calculateBitmap = getCalculateBitmap(getContentResolver(), getIntent().getData(), this.width);
        this.mCalculateBitmap = calculateBitmap;
        this.iv_img.setImageBitmap(calculateBitmap);
        this.iv_img.unlock();
        if (this.iv_img.isLock()) {
            this.iv_lock.setImageResource(R$drawable.publish_filter_locking_press);
        } else {
            this.iv_lock.setImageResource(R$drawable.publish_filter_locking_normal);
        }
    }

    private Bitmap getCalculateBitmap(ContentResolver contentResolver, Uri uri, int i) {
        Exception e;
        OutOfMemoryError e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46297693")) {
            return (Bitmap) ipChange.ipc$dispatch("46297693", new Object[]{this, contentResolver, uri, Integer.valueOf(i)});
        }
        Bitmap bitmap = null;
        if (uri == null || uri.getPath().length() == 0) {
            return null;
        }
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, null, options);
            closeIO(openInputStream, null);
            int i2 = options.outWidth;
            if (i2 > i) {
                int ceil = (int) Math.ceil((double) (i2 / i));
                int ceil2 = (int) Math.ceil((double) (options.outHeight / i));
                if (ceil > 1 || ceil2 > 1) {
                    if (ceil > ceil2) {
                        options.inSampleSize = ceil;
                    } else {
                        options.inSampleSize = ceil2;
                    }
                }
            }
            options.inJustDecodeBounds = false;
            try {
                InputStream openInputStream2 = contentResolver.openInputStream(uri);
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
                try {
                    closeIO(openInputStream2, null);
                    return decodeStream;
                } catch (Exception e3) {
                    e = e3;
                    bitmap = decodeStream;
                    g91.d(e);
                    return bitmap;
                } catch (OutOfMemoryError e4) {
                    e2 = e4;
                    bitmap = decodeStream;
                    g91.d(e2);
                    return bitmap;
                }
            } catch (Exception e5) {
                e = e5;
                g91.d(e);
                return bitmap;
            } catch (OutOfMemoryError e6) {
                e2 = e6;
                g91.d(e2);
                return bitmap;
            }
        } catch (FileNotFoundException e7) {
            g91.d(e7);
            return null;
        }
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099456294")) {
            ipChange.ipc$dispatch("-1099456294", new Object[]{this});
            return;
        }
        this.width = DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics());
    }

    private void registerListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428427491")) {
            ipChange.ipc$dispatch("-1428427491", new Object[]{this});
            return;
        }
        this.tv_cancel.setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.h5container.CaptureActivity.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1747080691")) {
                    ipChange.ipc$dispatch("1747080691", new Object[]{this, view});
                    return;
                }
                CaptureActivity.this.setResult(0);
                CaptureActivity.this.finish();
            }
        });
        this.tv_ok.setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.h5container.CaptureActivity.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-436596236")) {
                    ipChange.ipc$dispatch("-436596236", new Object[]{this, view});
                    return;
                }
                CaptureActivity.this.startProgressDialog();
                new Thread(new Runnable() {
                    /* class cn.damai.h5container.CaptureActivity.AnonymousClass3.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "692434127")) {
                            ipChange.ipc$dispatch("692434127", new Object[]{this});
                            return;
                        }
                        CaptureActivity captureActivity = CaptureActivity.this;
                        Bitmap cropImage = captureActivity.cropImage(captureActivity.mCalculateBitmap);
                        Message obtainMessage = CaptureActivity.this.mHandler.obtainMessage();
                        if (cropImage != null) {
                            obtainMessage.obj = cropImage;
                            obtainMessage.what = CaptureActivity.CROP_SUCCESS;
                        } else {
                            obtainMessage.what = CaptureActivity.OPERA_CANCEL;
                        }
                        CaptureActivity.this.mHandler.sendMessage(obtainMessage);
                    }
                }).start();
            }
        });
        this.ib_gress.setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.h5container.CaptureActivity.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1674694133")) {
                    ipChange.ipc$dispatch("1674694133", new Object[]{this, view});
                    return;
                }
                CaptureActivity.this.startProgressDialog();
                CaptureActivity.this.mHandler.postDelayed(new Runnable() {
                    /* class cn.damai.h5container.CaptureActivity.AnonymousClass4.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "821516846")) {
                            ipChange.ipc$dispatch("821516846", new Object[]{this});
                            return;
                        }
                        Bitmap rotate = CaptureActivity.this.iv_img.rotate(90);
                        Message obtainMessage = CaptureActivity.this.mHandler.obtainMessage();
                        if (rotate != null) {
                            obtainMessage.what = CaptureActivity.GRESS_SUCCESS;
                        } else {
                            obtainMessage.what = CaptureActivity.OPERA_CANCEL;
                        }
                        CaptureActivity.this.mHandler.sendMessage(obtainMessage);
                    }
                }, 0);
            }
        });
        this.rl_lock.setOnClickListener(new View.OnClickListener() {
            /* class cn.damai.h5container.CaptureActivity.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-508982794")) {
                    ipChange.ipc$dispatch("-508982794", new Object[]{this, view});
                    return;
                }
                CropImageView cropImageView = CaptureActivity.this.iv_img;
                cropImageView.setLock(!cropImageView.isLock());
                if (CaptureActivity.this.iv_img.isLock()) {
                    CaptureActivity.this.iv_lock.setImageResource(R$drawable.publish_filter_locking_press);
                } else {
                    CaptureActivity.this.iv_lock.setImageResource(R$drawable.publish_filter_locking_normal);
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[SYNTHETIC, Splitter:B:24:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    private void saveToAvatar(ByteArrayOutputStream byteArrayOutputStream, String str) {
        Throwable th;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1149107058")) {
            ipChange.ipc$dispatch("1149107058", new Object[]{this, byteArrayOutputStream, str});
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (fileOutputStream == null) {
                fileOutputStream.close();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000984292")) {
            ipChange.ipc$dispatch("-2000984292", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-22804146")) {
            return R$layout.damai_capture_activity;
        }
        return ((Integer) ipChange.ipc$dispatch("-22804146", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726040045")) {
            ipChange.ipc$dispatch("1726040045", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956472354")) {
            ipChange.ipc$dispatch("-956472354", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088423425")) {
            ipChange.ipc$dispatch("-2088423425", new Object[]{this});
            return;
        }
        initData();
        this.iv_img = (CropImageView) findViewById(R$id.iv_img);
        this.tv_cancel = (TextView) findViewById(R$id.tv_cancel);
        this.tv_ok = (TextView) findViewById(R$id.tv_ok);
        this.ib_gress = (ImageButton) findViewById(R$id.ib_gress);
        this.iv_lock = (ImageView) findViewById(R$id.iv_lock);
        this.rl_lock = (RelativeLayout) findViewById(R$id.rl_lock);
        registerListener();
        display();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022657499")) {
            ipChange.ipc$dispatch("1022657499", new Object[]{this});
            return;
        }
        super.onDestroy();
        Bitmap bitmap = this.mCalculateBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mCalculateBitmap = null;
            System.gc();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1326376676")) {
            ipChange.ipc$dispatch("-1326376676", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1100422791")) {
            ipChange.ipc$dispatch("-1100422791", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-672362686")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-672362686", new Object[]{this});
    }
}
