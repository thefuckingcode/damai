package tb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.issue.net.CommentGradeText;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.sdk.m.u.n;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class re0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1226725188")) {
                ipChange.ipc$dispatch("-1226725188", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = intValue;
            this.a.requestLayout();
        }
    }

    /* compiled from: Taobao */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1064477405")) {
                ipChange.ipc$dispatch("-1064477405", new Object[]{this, animator});
                return;
            }
            re0.h(this.a);
        }

        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1792104212")) {
                ipChange.ipc$dispatch("-1792104212", new Object[]{this, animator});
                return;
            }
            re0.h(this.a);
        }

        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1249098210")) {
                ipChange.ipc$dispatch("1249098210", new Object[]{this, animator});
            }
        }

        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1374663867")) {
                ipChange.ipc$dispatch("-1374663867", new Object[]{this, animator});
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-672913008")) {
                ipChange.ipc$dispatch("-672913008", new Object[]{this, animation});
                return;
            }
            this.a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1643310052")) {
                ipChange.ipc$dispatch("1643310052", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365861097")) {
                ipChange.ipc$dispatch("365861097", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    public class d implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        d(Activity activity, int i, int i2) {
            this.a = activity;
            this.b = i;
            this.c = i2;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-869657593")) {
                ipChange.ipc$dispatch("-869657593", new Object[]{this});
                return;
            }
            try {
                r21.i().q("video_upload");
                c01.b(this.a, this.b, true, this.c, "2", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    public static class e {
        public final ValueAnimator a;
        public final boolean b;

        public e(ValueAnimator valueAnimator, boolean z) {
            this.a = valueAnimator;
            this.b = z;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class f {
        private static final re0 a = new re0();
    }

    public static void b(View view, boolean z, int i) {
        ValueAnimator valueAnimator;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115067948")) {
            ipChange.ipc$dispatch("-115067948", new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        Object tag = view.getTag();
        if (Build.VERSION.SDK_INT >= 11) {
            if (tag instanceof e) {
                e eVar = (e) tag;
                if (eVar.b != z) {
                    eVar.a.cancel();
                } else {
                    return;
                }
            }
            if (z) {
                valueAnimator = ValueAnimator.ofInt(0, i);
            } else {
                int min = Math.min(view.getMeasuredHeight(), i);
                if (min < 0) {
                    min = 0;
                }
                valueAnimator = ValueAnimator.ofInt(min, 0);
            }
            valueAnimator.setDuration(300L);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new a(view));
            valueAnimator.start();
            view.setTag(new e(valueAnimator, z));
        }
    }

    public static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067176920")) {
            return ((Integer) ipChange.ipc$dispatch("1067176920", new Object[]{str})).intValue();
        } else if (str == null || str.length() <= 0 || TextUtils.isEmpty(str)) {
            return 0;
        } else {
            return str.replace(" ", "").length();
        }
    }

    public static ArrayList<Image> d(ArrayList<String> arrayList, Image image, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114695082")) {
            return (ArrayList) ipChange.ipc$dispatch("2114695082", new Object[]{arrayList, image, str});
        }
        ArrayList<Image> arrayList2 = new ArrayList<>();
        if (image != null) {
            arrayList2.add(image);
        }
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                Image image2 = new Image();
                image2.setPath(arrayList.get(i));
                image2.setType(str);
                arrayList2.add(image2);
            }
        }
        return arrayList2;
    }

    public static final re0 f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1014976357") ? (re0) ipChange.ipc$dispatch("-1014976357", new Object[0]) : f.a;
    }

    public static void g(View view, LottieAnimationView lottieAnimationView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007983753")) {
            ipChange.ipc$dispatch("2007983753", new Object[]{view, lottieAnimationView});
            return;
        }
        d20.T(p21.a, p21.b);
        view.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        layoutParams.height = 310;
        layoutParams.width = n.g;
        lottieAnimationView.setImageAssetsFolder("imagesissue/");
        lottieAnimationView.setAnimation("lottie_issue_guide.json");
        lottieAnimationView.playAnimation();
        if (Build.VERSION.SDK_INT >= 11) {
            lottieAnimationView.addAnimatorListener(new b(view));
        }
    }

    /* access modifiers changed from: private */
    public static void h(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640743686")) {
            ipChange.ipc$dispatch("-1640743686", new Object[]{view});
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new c(view));
    }

    public static void i(Activity activity, int i, boolean z, int i2, ArrayList<Image> arrayList, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629511501")) {
            ipChange.ipc$dispatch("629511501", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), arrayList, str, Integer.valueOf(i3)});
            return;
        }
        try {
            c01.d(activity, arrayList, arrayList, z, i2, i, str, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void j(Activity activity, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771034700")) {
            ipChange.ipc$dispatch("-1771034700", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        hp1.b(activity, false, lp1.STORAGE, "才能添加视频～", new d(activity, i, i2));
    }

    public String e(int i, ArrayList<CommentGradeText> arrayList, String str) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-793789234")) {
            return (String) ipChange.ipc$dispatch("-793789234", new Object[]{this, Integer.valueOf(i), arrayList, str});
        } else if (i == 0) {
            return str;
        } else {
            String str2 = i <= 2 ? "1" : i <= 4 ? "2" : i <= 6 ? "3" : i <= 8 ? "4" : "5";
            if (arrayList == null || arrayList.size() <= 0) {
                return str;
            }
            while (arrayList.size() > 0) {
                if (str2.equals(arrayList.get(i2).getLevel())) {
                    return arrayList.get(i2).getText();
                }
                i2++;
            }
            return str;
        }
    }

    public void k(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665899872")) {
            ipChange.ipc$dispatch("665899872", new Object[]{this, view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public void l(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40258330")) {
            ipChange.ipc$dispatch("-40258330", new Object[]{this, view});
        } else if (view.getVisibility() == 0 || view.getVisibility() == 8) {
            view.setVisibility(4);
        }
    }

    public void m(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587146005")) {
            ipChange.ipc$dispatch("-1587146005", new Object[]{this, view});
        } else if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }
}
