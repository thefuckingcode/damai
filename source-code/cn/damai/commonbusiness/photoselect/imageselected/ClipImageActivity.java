package cn.damai.commonbusiness.photoselect.imageselected;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.photoselect.imageselected.view.ClipImageView;
import com.ali.user.mobile.login.model.LoginConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.util.ArrayList;
import tb.c01;
import tb.k01;
import tb.xf2;

/* compiled from: Taobao */
public class ClipImageActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout a;
    private FrameLayout b;
    private ClipImageView c;
    private int d;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-560445710")) {
                ipChange.ipc$dispatch("-560445710", new Object[]{this, view});
            } else if (ClipImageActivity.this.c.getDrawable() != null) {
                ClipImageActivity.this.a.setEnabled(false);
                ClipImageActivity clipImageActivity = ClipImageActivity.this;
                clipImageActivity.d(clipImageActivity.c.clipImage());
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1550844659")) {
                ipChange.ipc$dispatch("1550844659", new Object[]{this, view});
                return;
            }
            ClipImageActivity.this.finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1274663016")) {
            ipChange.ipc$dispatch("-1274663016", new Object[]{this, bitmap});
            return;
        }
        String str = null;
        if (bitmap != null) {
            str = k01.e(bitmap, getExternalCacheDir().getPath() + File.separator + "image_select");
            bitmap.recycle();
        }
        if (xf2.i(str)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            Intent intent = new Intent();
            intent.putStringArrayListExtra(c01.SELECT_RESULT, arrayList);
            setResult(-1, intent);
        }
        finish();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598433023")) {
            ipChange.ipc$dispatch("598433023", new Object[]{this});
            return;
        }
        this.c = (ClipImageView) findViewById(R$id.process_img);
        this.a = (FrameLayout) findViewById(R$id.btn_confirm);
        this.b = (FrameLayout) findViewById(R$id.btn_back);
        this.a.setOnClickListener(new a());
        this.b.setOnClickListener(new b());
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831997390")) {
            ipChange.ipc$dispatch("-1831997390", new Object[]{this});
        } else if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581648602")) {
            ipChange.ipc$dispatch("-1581648602", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (intent == null || i != this.d) {
            finish();
            return;
        }
        Bitmap b2 = k01.b(intent.getStringArrayListExtra(c01.SELECT_RESULT).get(0), LoginConstant.RESULT_WINDWANE_CLOSEW, 1080);
        if (b2 != null) {
            this.c.setBitmapData(b2);
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771421690")) {
            ipChange.ipc$dispatch("771421690", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185461979")) {
            ipChange.ipc$dispatch("185461979", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(R$layout.activity_clip_image);
        this.d = getIntent().getIntExtra("requestCode", 0);
        f();
        c01.a(this, this.d, true, 0);
        e();
    }
}
