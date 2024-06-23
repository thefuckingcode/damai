package cn.damai.homepage.helper;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.home.bean.HeadLottieBean;
import cn.damai.commonbusiness.home.bean.HeadLottieStyleBean;
import cn.damai.homepage.util.ZipDownLoadManager;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tb.d20;
import tb.na1;
import tb.rx0;

/* compiled from: Taobao */
public class HomePageTopLottieHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HomePageTopLottieHelper k;
    private List<HeadLottieStyleBean> a;
    private HeadLottieBean b;
    private View c;
    private LottieAnimationView d;
    private List<LottiePath> e = new ArrayList();
    private OnLoadResultListener f;
    private Context g;
    private int h = 0;
    private boolean i = true;
    private LottieListener j = new c();

    /* compiled from: Taobao */
    public class LottiePath implements Serializable {
        private static final long serialVersionUID = 950802914233960394L;
        public Bitmap[] bitmaps;
        public int imageNum;
        public String imagePath;
        public String jsonPath;

        public LottiePath(String str, String str2, int i) {
            this.jsonPath = str;
            this.imagePath = str2;
            this.imageNum = i;
            this.bitmaps = new Bitmap[i];
        }
    }

    /* compiled from: Taobao */
    public interface OnLoadResultListener {
        void onFailed();

        void onSuccess();

        void onUpdateStyle(HeadLottieStyleBean headLottieStyleBean);
    }

    /* compiled from: Taobao */
    public class a implements ZipDownLoadManager.OnZipDownLoadListsner {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-676987068")) {
                ipChange.ipc$dispatch("-676987068", new Object[]{this});
                return;
            }
            HomePageTopLottieHelper.this.t(this.a);
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581155019")) {
                ipChange.ipc$dispatch("-581155019", new Object[]{this, str});
            } else if (HomePageTopLottieHelper.this.p(str)) {
                d20.T(this.a, str);
                d20.T(this.a + "1", HomePageTopLottieHelper.this.b.zipUrl);
                HomePageTopLottieHelper.this.w();
                HomePageTopLottieHelper.this.f.onSuccess();
            } else {
                HomePageTopLottieHelper.this.t(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottiePath a;

        b(LottiePath lottiePath) {
            this.a = lottiePath;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[Catch:{ all -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007b A[Catch:{ IOException -> 0x0080 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008f A[Catch:{ IOException -> 0x0093 }] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(na1 na1) {
            Throwable th;
            Exception e;
            FileInputStream fileInputStream;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1341727458")) {
                return (Bitmap) ipChange.ipc$dispatch("1341727458", new Object[]{this, na1});
            }
            Bitmap bitmap = null;
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(this.a.imagePath + File.separator + na1.b());
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    if (decodeStream == null) {
                        try {
                            decodeStream = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return decodeStream;
                        }
                    }
                    fileInputStream.close();
                    return decodeStream;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (HomePageTopLottieHelper.this.b != null) {
                        }
                        try {
                            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                            if (fileInputStream != null) {
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                e.printStackTrace();
                if (HomePageTopLottieHelper.this.b != null) {
                    rx0.b(e.getMessage(), HomePageTopLottieHelper.this.b.zipUrl);
                }
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
    public class c implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "790604430")) {
                ipChange.ipc$dispatch("790604430", new Object[]{this, aVar});
                return;
            }
            HomePageTopLottieHelper.this.d.setComposition(aVar);
            HomePageTopLottieHelper.this.d.playAnimation();
        }
    }

    /* compiled from: Taobao */
    public class d implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottiePath a;

        d(LottiePath lottiePath) {
            this.a = lottiePath;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A[Catch:{ all -> 0x0086 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007b A[Catch:{ IOException -> 0x0080 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008f A[Catch:{ IOException -> 0x0093 }] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(na1 na1) {
            Throwable th;
            Exception e;
            FileInputStream fileInputStream;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1694689345")) {
                return (Bitmap) ipChange.ipc$dispatch("-1694689345", new Object[]{this, na1});
            }
            Bitmap bitmap = null;
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(this.a.imagePath + File.separator + na1.b());
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    if (decodeStream == null) {
                        try {
                            decodeStream = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return decodeStream;
                        }
                    }
                    fileInputStream.close();
                    return decodeStream;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (HomePageTopLottieHelper.this.b != null) {
                        }
                        try {
                            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
                            if (fileInputStream != null) {
                            }
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                e.printStackTrace();
                if (HomePageTopLottieHelper.this.b != null) {
                    rx0.b(e.getMessage(), HomePageTopLottieHelper.this.b.zipUrl);
                }
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
    public class e implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1966022836")) {
                ipChange.ipc$dispatch("-1966022836", new Object[]{this, aVar});
                return;
            }
            HomePageTopLottieHelper.this.d.setComposition(aVar);
            HomePageTopLottieHelper.this.d.playAnimation();
        }
    }

    static /* synthetic */ int i(HomePageTopLottieHelper homePageTopLottieHelper) {
        int i2 = homePageTopLottieHelper.h;
        homePageTopLottieHelper.h = i2 + 1;
        return i2;
    }

    private File[] m(File[] fileArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912433328")) {
            return (File[]) ipChange.ipc$dispatch("-1912433328", new Object[]{this, fileArr});
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            if (q(fileArr[i2].getName())) {
                arrayList.add(fileArr[i2]);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static HomePageTopLottieHelper n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576402885")) {
            return (HomePageTopLottieHelper) ipChange.ipc$dispatch("-1576402885", new Object[0]);
        }
        if (k == null) {
            k = new HomePageTopLottieHelper();
        }
        return k;
    }

    private String o(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322394386")) {
            return (String) ipChange.ipc$dispatch("1322394386", new Object[]{this, context, str});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("fenwei");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean p(String str) {
        List<HeadLottieStyleBean> list;
        File[] listFiles;
        File file;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177170824")) {
            return ((Boolean) ipChange.ipc$dispatch("-177170824", new Object[]{this, str})).booleanValue();
        }
        try {
            this.e.clear();
            File file2 = new File(str);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= listFiles.length) {
                        file = null;
                        break;
                    }
                    file = listFiles[i3];
                    if (file != null) {
                        String name = file.getName();
                        if (name.contains("lottie")) {
                            break;
                        } else if (name.toLowerCase().contains("lottie")) {
                            break;
                        }
                    }
                    i3++;
                }
                if (file == null) {
                    return false;
                }
                File[] m = m(file.listFiles());
                z(m);
                int i4 = 0;
                while (i4 < m.length) {
                    File file3 = m[i4];
                    String name2 = file3.getName();
                    StringBuilder sb = new StringBuilder();
                    i4++;
                    sb.append(i4);
                    sb.append("");
                    if (name2.equals(sb.toString())) {
                        File[] listFiles2 = file3.listFiles();
                        String str2 = null;
                        String str3 = null;
                        if (listFiles2 != null) {
                            i2 = 0;
                            for (File file4 : listFiles2) {
                                if (file4.isFile() && file4.getName().contains(Preloader.KEY_JSON)) {
                                    str2 = file4.getAbsolutePath();
                                } else if (file4.isDirectory() && file4.getName().contains("image")) {
                                    File[] listFiles3 = file4.listFiles();
                                    for (int i5 = 0; i5 < listFiles3.length; i5++) {
                                        if (listFiles3[i5].getName().contains("jpg") || listFiles3[i5].getName().contains("png")) {
                                            i2++;
                                        }
                                    }
                                    str3 = file4.getAbsolutePath();
                                }
                            }
                        } else {
                            i2 = 0;
                        }
                        if (!(str2 == null || str3 == null)) {
                            this.e.add(new LottiePath(str2, str3, i2));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.e.size() > 0 && (list = this.a) != null && list.size() == this.e.size();
    }

    private boolean q(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "222884071")) {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        }
        return ((Boolean) ipChange.ipc$dispatch("222884071", new Object[]{this, str})).booleanValue();
    }

    private void s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365224206")) {
            ipChange.ipc$dispatch("-365224206", new Object[]{this, str});
            return;
        }
        String B = d20.B(str);
        String B2 = d20.B(str + "1");
        if (TextUtils.isEmpty(B2) || !B2.equals(this.b.zipUrl) || TextUtils.isEmpty(B)) {
            new ZipDownLoadManager().h(this.b.zipUrl).f(o(this.g, str)).g(new a(str)).e();
        } else if (p(B)) {
            w();
            this.f.onSuccess();
        } else {
            t(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303278052")) {
            ipChange.ipc$dispatch("-1303278052", new Object[]{this, str});
            return;
        }
        d20.T(str, null);
        d20.T(str + "1", null);
        this.f.onFailed();
        this.i = true;
    }

    private int u(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37489578")) {
            return ((Integer) ipChange.ipc$dispatch("-37489578", new Object[]{this, str})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
            }
            return Color.parseColor(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608673426")) {
            ipChange.ipc$dispatch("1608673426", new Object[]{this});
            return;
        }
        if (this.e.size() > 1) {
            this.d.setRepeatCount(0);
            x();
        } else {
            this.d.setRepeatCount(-1);
            y();
        }
        new Handler().postDelayed(new Runnable() {
            /* class cn.damai.homepage.helper.HomePageTopLottieHelper.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-356145149")) {
                    ipChange.ipc$dispatch("-356145149", new Object[]{this});
                    return;
                }
                HomePageTopLottieHelper.this.i = true;
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @SuppressLint({"NewApi"})
    private void x() {
        HeadLottieStyleBean headLottieStyleBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300123325")) {
            ipChange.ipc$dispatch("1300123325", new Object[]{this});
        } else if (this.h < this.e.size()) {
            if (this.h < this.a.size()) {
                this.f.onUpdateStyle(this.a.get(this.h));
            }
            LottiePath lottiePath = this.e.get(this.h);
            int u = u((this.h >= this.a.size() || (headLottieStyleBean = this.a.get(this.h)) == null) ? null : headLottieStyleBean.color);
            if (u != -1) {
                this.c.setBackgroundColor(u);
            }
            try {
                this.d.setImageAssetDelegate(new b(lottiePath));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(lottiePath.jsonPath));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        com.airbnb.lottie.b.m(sb.toString(), null).f(this.j);
                        this.d.addAnimatorListener(new Animator.AnimatorListener() {
                            /* class cn.damai.homepage.helper.HomePageTopLottieHelper.AnonymousClass4 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void onAnimationCancel(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1132009622")) {
                                    ipChange.ipc$dispatch("-1132009622", new Object[]{this, animator});
                                }
                            }

                            public void onAnimationEnd(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1162372091")) {
                                    ipChange.ipc$dispatch("-1162372091", new Object[]{this, animator});
                                    return;
                                }
                                HomePageTopLottieHelper.this.B();
                                if (HomePageTopLottieHelper.this.h == HomePageTopLottieHelper.this.e.size() - 1) {
                                    HomePageTopLottieHelper.this.h = 0;
                                } else {
                                    HomePageTopLottieHelper.i(HomePageTopLottieHelper.this);
                                }
                                new Handler().postDelayed(new Runnable() {
                                    /* class cn.damai.homepage.helper.HomePageTopLottieHelper.AnonymousClass4.AnonymousClass1 */
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    public void run() {
                                        IpChange ipChange = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange, "-1053639276")) {
                                            ipChange.ipc$dispatch("-1053639276", new Object[]{this});
                                            return;
                                        }
                                        HomePageTopLottieHelper.this.x();
                                    }
                                }, 300);
                            }

                            public void onAnimationRepeat(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1181565993")) {
                                    ipChange.ipc$dispatch("1181565993", new Object[]{this, animator});
                                }
                            }

                            public void onAnimationStart(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1792484322")) {
                                    ipChange.ipc$dispatch("-1792484322", new Object[]{this, animator});
                                }
                            }
                        });
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100635412")) {
            ipChange.ipc$dispatch("1100635412", new Object[]{this});
            return;
        }
        this.f.onUpdateStyle(this.a.get(0));
        LottiePath lottiePath = this.e.get(0);
        HeadLottieStyleBean headLottieStyleBean = this.a.get(0);
        try {
            int u = u(headLottieStyleBean != null ? headLottieStyleBean.color : null);
            if (u != -1) {
                this.c.setBackgroundColor(u);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.d.setRepeatCount(-1);
        try {
            this.d.setImageAssetDelegate(new d(lottiePath));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(lottiePath.jsonPath));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    com.airbnb.lottie.b.m(sb.toString(), null).f(new e());
                    return;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void z(File[] fileArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-51591688")) {
            ipChange.ipc$dispatch("-51591688", new Object[]{this, fileArr});
            return;
        }
        for (int i2 = 0; i2 < fileArr.length; i2++) {
            int i3 = 0;
            while (i3 < (fileArr.length - i2) - 1) {
                int i4 = i3 + 1;
                if (Integer.parseInt(fileArr[i3].getName()) > Integer.parseInt(fileArr[i4].getName())) {
                    File file = fileArr[i4];
                    fileArr[i4] = fileArr[i3];
                    fileArr[i3] = file;
                }
                i3 = i4;
            }
        }
    }

    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748135099")) {
            ipChange.ipc$dispatch("1748135099", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null && !lottieAnimationView.isAnimating()) {
            this.d.playAnimation();
        }
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238293293")) {
            ipChange.ipc$dispatch("238293293", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
            this.d.removeAllAnimatorListeners();
            this.d.cancelAnimation();
            this.d.clearAnimation();
        }
    }

    public void r(Context context, HeadLottieBean headLottieBean, String str, View view, LottieAnimationView lottieAnimationView, OnLoadResultListener onLoadResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368722606")) {
            ipChange.ipc$dispatch("368722606", new Object[]{this, context, headLottieBean, str, view, lottieAnimationView, onLoadResultListener});
        } else if (this.i) {
            this.i = false;
            this.g = context.getApplicationContext();
            this.c = view;
            this.d = lottieAnimationView;
            this.b = headLottieBean;
            List<HeadLottieStyleBean> list = headLottieBean.style;
            this.a = list;
            if (list != null) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    this.a.get(i2).index = i2;
                }
            }
            this.f = onLoadResultListener;
            this.h = 0;
            B();
            s(str);
        }
    }

    public void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313028185")) {
            ipChange.ipc$dispatch("-313028185", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
        }
    }
}
