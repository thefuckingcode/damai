package tb;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomeConfigPopBean;
import cn.damai.homepage.ui.view.HomeLottieView;
import cn.damai.homepage.util.ZipDownLoadManager;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
public class vw0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static vw0 d;
    private Context a;
    private LottieAnimationView b;
    private LottieListener c = new d();

    /* compiled from: Taobao */
    public class a implements ZipDownLoadManager.OnZipDownLoadListsner {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1962759999")) {
                ipChange.ipc$dispatch("1962759999", new Object[]{this});
                return;
            }
            br.c("LottieDownLoadSuccess", "");
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "3782256")) {
                ipChange.ipc$dispatch("3782256", new Object[]{this, str});
                return;
            }
            br.c("LottieDownLoadSuccess", str);
            d20.T("paopaodate", vw0.this.g());
        }
    }

    /* compiled from: Taobao */
    public class b implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(vw0 vw0, String str) {
            this.a = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0068 A[Catch:{ IOException -> 0x006d }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0080 A[Catch:{ IOException -> 0x0084 }] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(na1 na1) {
            Throwable th;
            Exception e;
            FileInputStream fileInputStream;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716022274")) {
                return (Bitmap) ipChange.ipc$dispatch("-1716022274", new Object[]{this, na1});
            }
            Bitmap bitmap = null;
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(this.a + File.separator + na1.b());
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    if (decodeStream == null) {
                        try {
                            decodeStream = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                        } catch (IOException e2) {
                            g91.b("HomePageLottieHelper", e2.getMessage());
                            return decodeStream;
                        }
                    }
                    fileInputStream.close();
                    return decodeStream;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        try {
                            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                            if (fileInputStream != null) {
                            }
                        } catch (IOException e4) {
                            g91.b("HomePageLottieHelper", e4.getMessage());
                        }
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        try {
                            Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                        } catch (IOException e5) {
                            g91.b("HomePageLottieHelper", e5.getMessage());
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                e.printStackTrace();
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeLottieView a;
        final /* synthetic */ String b;

        c(vw0 vw0, HomeLottieView homeLottieView, String str) {
            this.a = homeLottieView;
            this.b = str;
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-621640826")) {
                ipChange.ipc$dispatch("-621640826", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(8);
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "511890793")) {
                ipChange.ipc$dispatch("511890793", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(8);
            this.a.cancelAnimation();
            cu2.b(new File(this.b), true);
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1691934789")) {
                ipChange.ipc$dispatch("1691934789", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "856378498")) {
                ipChange.ipc$dispatch("856378498", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(0);
        }
    }

    /* compiled from: Taobao */
    public class d implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1300973226")) {
                ipChange.ipc$dispatch("1300973226", new Object[]{this, aVar});
                return;
            }
            vw0.this.b.setComposition(aVar);
            vw0.this.b.playAnimation();
        }
    }

    private String c(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242596339")) {
            return (String) ipChange.ipc$dispatch("1242596339", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (name.endsWith(".png") && !name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    public static vw0 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438478393")) {
            return (vw0) ipChange.ipc$dispatch("-1438478393", new Object[0]);
        }
        if (d == null) {
            d = new vw0();
        }
        return d;
    }

    private String e(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688844111")) {
            return (String) ipChange.ipc$dispatch("-688844111", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (name.endsWith(".json") && !name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                } else {
                    str = e(file2);
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private String f(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250796461")) {
            return (String) ipChange.ipc$dispatch("1250796461", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (!name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String g() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1731985448")) {
            return new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).format(new Date(System.currentTimeMillis()));
        }
        return (String) ipChange.ipc$dispatch("-1731985448", new Object[]{this});
    }

    private String h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973633065")) {
            return (String) ipChange.ipc$dispatch("-973633065", new Object[]{this, context});
        } else if (cu2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getExternalCacheDir());
            String str = File.separator;
            sb.append(str);
            sb.append("cn.damai");
            sb.append(str);
            sb.append("lottieCache");
            return sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getCacheDir().getPath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("cn.damai");
            sb2.append(str2);
            sb2.append("lottieCache");
            return sb2.toString();
        }
    }

    public void i(HomeConfigBean homeConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1651767190")) {
            ipChange.ipc$dispatch("-1651767190", new Object[]{this, homeConfigBean});
            return;
        }
        HomeConfigPopBean homeConfigPopBean = homeConfigBean.pop;
        if (homeConfigPopBean != null) {
            String str = homeConfigPopBean.icon;
            this.a = xs0.a();
            if (!TextUtils.isEmpty(str)) {
                String B = d20.B("paopaodate");
                if (B == null || !B.equals(g())) {
                    new ZipDownLoadManager().h(str).f(h(this.a)).g(new a()).e();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void j(HomeLottieView homeLottieView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766969943")) {
            ipChange.ipc$dispatch("766969943", new Object[]{this, homeLottieView, str});
            return;
        }
        this.b = homeLottieView.getLottieView();
        try {
            String e = e(new File(str));
            if (!TextUtils.isEmpty(e)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(e));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String c2 = c(new File(e).getParentFile());
                if (!TextUtils.isEmpty(c2)) {
                    homeLottieView.setBgImage(c2);
                }
                String f = f(new File(e).getParentFile());
                if (!TextUtils.isEmpty(f)) {
                    homeLottieView.setImageAssetDelegate(new b(this, f));
                }
                com.airbnb.lottie.b.m(sb.toString(), "homeLottie").f(this.c);
                homeLottieView.addAnimatorListener(new c(this, homeLottieView, str));
            }
        } catch (Exception e2) {
            g91.b("HomePageLottieHelper", e2.getMessage());
        }
    }
}
