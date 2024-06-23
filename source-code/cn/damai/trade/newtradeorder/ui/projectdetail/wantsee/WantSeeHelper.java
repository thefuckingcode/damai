package cn.damai.trade.newtradeorder.ui.projectdetail.wantsee;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.core.util.Pair;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectWantSeeBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import tb.lk1;
import tb.xf2;

/* compiled from: Taobao */
public class WantSeeHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WantSeeHelper a;

    WantSeeHelper() {
    }

    public static WantSeeHelper b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989413203")) {
            return (WantSeeHelper) ipChange.ipc$dispatch("1989413203", new Object[0]);
        }
        if (a == null) {
            synchronized (WantSeeHelper.class) {
                if (a == null) {
                    a = new WantSeeHelper();
                }
            }
        }
        return a;
    }

    public static Pair<String, String> d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2131976812")) {
            return (Pair) ipChange.ipc$dispatch("2131976812", new Object[]{Long.valueOf(j)});
        } else if (j <= 99999) {
            return new Pair<>(String.valueOf(j), "人");
        } else {
            if (j < 100000000) {
                return new Pair<>(String.valueOf(((float) ((int) ((((float) j) / 10000.0f) * 10.0f))) / 10.0f), "万人");
            }
            return new Pair<>(String.valueOf(((float) ((int) ((((float) j) / 1.0E8f) * 10.0f))) / 10.0f), "亿人");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    public static void e(final TextView textView, final String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-848188064")) {
            ipChange.ipc$dispatch("-848188064", new Object[]{textView, str});
        } else if (textView.getTag() == null) {
            textView.setTag(new Object());
            if (xf2.h(str)) {
                final long k = lk1.k(str, -1);
                if (k > 0) {
                    textView.postDelayed(new Runnable() {
                        /* class cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper$1$a */
                        /* compiled from: Taobao */
                        public class a implements ValueAnimator.AnimatorUpdateListener {
                            private static transient /* synthetic */ IpChange $ipChange;

                            a() {
                            }

                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1918017727")) {
                                    ipChange.ipc$dispatch("1918017727", new Object[]{this, valueAnimator});
                                    return;
                                }
                                textView.setText(valueAnimator.getAnimatedValue().toString());
                            }
                        }

                        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.wantsee.WantSeeHelper$1$b */
                        /* compiled from: Taobao */
                        public class b extends AnimatorListenerAdapter {
                            private static transient /* synthetic */ IpChange $ipChange;

                            b() {
                            }

                            public void onAnimationEnd(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "1001214959")) {
                                    ipChange.ipc$dispatch("1001214959", new Object[]{this, animator});
                                    return;
                                }
                                AnonymousClass1 r5 = AnonymousClass1.this;
                                textView.setText(str);
                            }
                        }

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1719852507")) {
                                ipChange.ipc$dispatch("-1719852507", new Object[]{this});
                                return;
                            }
                            ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) k);
                            ofInt.setDuration(300L);
                            ofInt.setInterpolator(new LinearInterpolator());
                            ofInt.addUpdateListener(new a());
                            ofInt.addListener(new b());
                            ofInt.start();
                        }
                    }, 150);
                    if (z) {
                        textView.setText(str);
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (z) {
            }
        } else {
            textView.setText(str);
        }
    }

    public String a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1813308914")) {
            return (String) ipChange.ipc$dispatch("1813308914", new Object[]{this, Long.valueOf(j)});
        } else if (j < 10000) {
            return String.valueOf(j);
        } else {
            if (j < 100000) {
                DecimalFormat decimalFormat = new DecimalFormat();
                decimalFormat.setMinimumFractionDigits(1);
                decimalFormat.setMaximumFractionDigits(1);
                decimalFormat.setGroupingSize(0);
                decimalFormat.setRoundingMode(RoundingMode.FLOOR);
                return decimalFormat.format(((double) j) / 10000.0d) + "万";
            } else if (j < 1000000) {
                DecimalFormat decimalFormat2 = new DecimalFormat();
                decimalFormat2.setMinimumFractionDigits(1);
                decimalFormat2.setMaximumFractionDigits(1);
                decimalFormat2.setGroupingSize(0);
                decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
                return decimalFormat2.format(((double) j) / 10000.0d) + "万";
            } else if (j >= 10000000) {
                return "999万";
            } else {
                DecimalFormat decimalFormat3 = new DecimalFormat();
                decimalFormat3.setMinimumFractionDigits(0);
                decimalFormat3.setMaximumFractionDigits(0);
                decimalFormat3.setGroupingSize(0);
                decimalFormat3.setRoundingMode(RoundingMode.FLOOR);
                return decimalFormat3.format(((double) j) / 10000.0d) + "万";
            }
        }
    }

    public boolean c(ProjectWantSeeBean projectWantSeeBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804913043")) {
            return ((Boolean) ipChange.ipc$dispatch("1804913043", new Object[]{this, projectWantSeeBean})).booleanValue();
        } else if (projectWantSeeBean == null) {
            return false;
        } else {
            return projectWantSeeBean.isShowWant() && !TextUtils.isEmpty(projectWantSeeBean.getWantNumStr());
        }
    }
}
