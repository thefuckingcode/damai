package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;

/* compiled from: Taobao */
public class ImageActivity extends Activity {
    RelativeLayout a;
    private QQToken b;
    private String c;
    private Handler d;
    private c e;
    private Button f;
    private Button g;
    private b h;
    private TextView i;
    private ProgressBar j;
    private int k = 0;
    private boolean l = false;
    private long m = 0;
    private int n = 0;
    private final int o = 640;
    private final int p = 640;
    private Rect q = new Rect();
    private String r;
    private Bitmap s;
    private final View.OnClickListener t = new View.OnClickListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass2 */

        public void onClick(View view) {
            ImageActivity.this.j.setVisibility(0);
            ImageActivity.this.g.setEnabled(false);
            ImageActivity.this.g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f.setEnabled(false);
            ImageActivity.this.f.setTextColor(Color.rgb(36, 94, 134));
            new Thread(new Runnable() {
                /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass2.AnonymousClass1 */

                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.m);
            if (ImageActivity.this.e.b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };
    private final View.OnClickListener u = new View.OnClickListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass3 */

        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };
    private final IUiListener v = new DefaultUiListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass5 */

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.g.setEnabled(true);
            int i = -1;
            ImageActivity.this.g.setTextColor(-1);
            ImageActivity.this.f.setEnabled(true);
            ImageActivity.this.f.setTextColor(-1);
            ImageActivity.this.j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i = jSONObject.getInt("ret");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i == 0) {
                ImageActivity.this.a((ImageActivity) "设置成功", (String) 0);
                ImageActivity.this.a("10658", 0L);
                e.a().a(ImageActivity.this.b.getOpenId(), ImageActivity.this.b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", "3", "0");
                ImageActivity imageActivity = ImageActivity.this;
                if (imageActivity.c != null && !"".equals(ImageActivity.this.c)) {
                    Intent intent = new Intent();
                    intent.setClassName(imageActivity, ImageActivity.this.c);
                    if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                        imageActivity.startActivity(intent);
                    }
                }
                ImageActivity.this.a(0, jSONObject.toString(), null, null);
                ImageActivity.this.d();
                return;
            }
            ImageActivity.this.a((ImageActivity) "设置出错了，请重新登录再尝试下呢：）", (String) 1);
            e.a().a(ImageActivity.this.b.getOpenId(), ImageActivity.this.b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "1");
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.g.setEnabled(true);
            ImageActivity.this.g.setTextColor(-1);
            ImageActivity.this.f.setEnabled(true);
            ImageActivity.this.f.setTextColor(-1);
            ImageActivity.this.f.setText("重试");
            ImageActivity.this.j.setVisibility(8);
            ImageActivity.this.l = true;
            ImageActivity.this.a((ImageActivity) uiError.errorMessage, (String) 1);
            ImageActivity.this.a("10660", 0L);
        }
    };
    private final IUiListener w = new DefaultUiListener() {
        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass6 */

        private void a(int i) {
            if (ImageActivity.this.k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i = -1;
            try {
                i = jSONObject.getInt("ret");
                if (i == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.d.post(new Runnable() {
                        /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass6.AnonymousClass1 */

                        public void run() {
                            ImageActivity.this.c((ImageActivity) string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i != 0) {
                a(i);
            }
        }

        @Override // com.tencent.tauth.IUiListener, com.tencent.tauth.DefaultUiListener
        public void onError(UiError uiError) {
            a(0);
        }
    };

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a2 = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a2.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.c, g.a(), "user/set_user_face", a2, "POST", tempRequestListener);
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, "12", Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b = ImageActivity.this.b((ImageActivity) "com.tencent.plus.blue_normal.png");
            Drawable b2 = ImageActivity.this.b((ImageActivity) "com.tencent.plus.blue_down.png");
            Drawable b3 = ImageActivity.this.b((ImageActivity) "com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b = ImageActivity.this.b((ImageActivity) "com.tencent.plus.gray_normal.png");
            Drawable b2 = ImageActivity.this.b((ImageActivity) "com.tencent.plus.gray_down.png");
            Drawable b3 = ImageActivity.this.b((ImageActivity) "com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b2);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b3);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    public void onBackPressed() {
        setResult(0);
        d();
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.r = bundleExtra.getString("picture");
        this.c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString(Constants.PARAM_ACCESS_TOKEN);
        long j2 = bundleExtra.getLong(Constants.PARAM_EXPIRES_IN);
        String string3 = bundleExtra.getString("openid");
        this.n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.b = qQToken;
        qQToken.setAccessToken(string2, ((j2 - System.currentTimeMillis()) / 1000) + "");
        this.b.setOpenId(string3);
        b();
        e();
        this.m = System.currentTimeMillis();
        a("10653", 0L);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.e.setImageBitmap(null);
        Bitmap bitmap = this.s;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.s.recycle();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        Matrix imageMatrix = this.e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = 640.0f / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.q));
        Rect rect = this.q;
        int i2 = (int) ((((float) rect.left) - f2) / f4);
        int i3 = i2 < 0 ? 0 : i2;
        int i4 = (int) ((((float) rect.top) - f3) / f4);
        int i5 = i4 < 0 ? 0 : i4;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(width, width);
        int i6 = (int) (650.0f / f4);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.s, i3, i5, Math.min(this.s.getWidth() - i3, i6), Math.min(this.s.getHeight() - i5, i6), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        finish();
        int i2 = this.n;
        if (i2 != 0) {
            overridePendingTransition(0, i2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        this.k++;
        new UserInfo(this, this.b).getUserInfo(this.w);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Drawable b(String str) {
        return m.a(str, this);
    }

    private void b() {
        try {
            Bitmap a2 = a(this.r);
            this.s = a2;
            if (a2 != null) {
                this.e.setImageBitmap(a2);
                this.f.setOnClickListener(this.t);
                this.g.setOnClickListener(this.u);
                this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass1 */

                    public void onGlobalLayout() {
                        ImageActivity.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        ImageActivity imageActivity = ImageActivity.this;
                        imageActivity.q = imageActivity.h.a();
                        ImageActivity.this.e.a(ImageActivity.this.q);
                    }
                });
                return;
            }
            throw new IOException("cannot read picture: '" + this.r + "'!");
        } catch (IOException e2) {
            e2.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e2.getMessage());
            d();
        }
    }

    private String d(String str) {
        return str.replaceAll("&gt;", jl1.G).replaceAll("&lt;", jl1.L).replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        openInputStream.close();
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        while (i3 * i4 > 4194304) {
            i3 /= 2;
            i4 /= 2;
            i2 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(String str, int i2) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a.a(this, 16.0f), a.a(this, 16.0f)));
        if (i2 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.a.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.a.addView(relativeLayout2);
        c cVar = new c(this);
        this.e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.e);
        this.h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(a.a(this, 24.0f), a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = a.a(this, 7.0f);
        this.i.setLayoutParams(layoutParams6);
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.i.setSingleLine();
        this.i.setTextColor(-1);
        this.i.setTextSize(24.0f);
        this.i.setVisibility(8);
        linearLayout.addView(this.i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a2 = a.a(this, 10.0f);
        relativeLayout3.setPadding(a2, a2, a2, 0);
        this.a.addView(relativeLayout3);
        a aVar = new a(this);
        int a3 = a.a(this, 14.0f);
        int a4 = a.a(this, 7.0f);
        this.g = new Button(this);
        this.g.setLayoutParams(new RelativeLayout.LayoutParams(a.a(this, 78.0f), a.a(this, 45.0f)));
        this.g.setText("取消");
        this.g.setTextColor(-1);
        this.g.setTextSize(18.0f);
        this.g.setPadding(a3, a4, a3, a4);
        aVar.b(this.g);
        relativeLayout3.addView(this.g);
        this.f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a.a(this, 78.0f), a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f.setLayoutParams(layoutParams8);
        this.f.setTextColor(-1);
        this.f.setTextSize(18.0f);
        this.f.setPadding(a3, a4, a3, a4);
        this.f.setText("选取");
        aVar.a(this.f);
        relativeLayout3.addView(this.f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.j.setLayoutParams(layoutParams10);
        this.j.setVisibility(8);
        this.a.addView(this.j);
        return this.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(String str) {
        String d2 = d(str);
        if (!"".equals(d2)) {
            this.i.setText(d2);
            this.i.setVisibility(0);
        }
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.b).setAvator(bitmap, this.v);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(final String str, final int i2) {
        this.d.post(new Runnable() {
            /* class com.tencent.connect.avatar.ImageActivity.AnonymousClass4 */

            public void run() {
                ImageActivity.this.b((ImageActivity) str, (String) i2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i2);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j2) {
        a(str, j2, this.b.getAppId());
    }

    public static void a(String str, long j2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", Constants.SDK_VERSION);
        if (j2 != 0) {
            hashMap.put("elt", String.valueOf(j2));
        }
        h.a().a("https://cgi.qplus.com/report/report", hashMap);
    }
}
