package com.youku.live.dago.widgetlib.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.ali.user.open.core.Site;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import tb.gl1;
import tb.v;

/* compiled from: Taobao */
public class UIUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LANDSCAPE = 1;
    private static final int PORTRAIT = 0;
    private static long lastClickTime;
    private static volatile boolean mHasCheckAllScreen;
    private static volatile boolean mIsAllScreenDevice;
    @NonNull
    private static volatile Point[] mRealSizes = new Point[2];

    public static void addClickEffect(View... viewArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872135140")) {
            ipChange.ipc$dispatch("-872135140", new Object[]{viewArr});
            return;
        }
        for (final View view : viewArr) {
            view.setOnTouchListener(new View.OnTouchListener() {
                /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1697869146")) {
                        return ((Boolean) ipChange.ipc$dispatch("-1697869146", new Object[]{this, view, motionEvent})).booleanValue();
                    }
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.93f);
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.93f);
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.8f);
                        ObjectAnimator.ofPropertyValuesHolder(view, ofFloat3, ofFloat, ofFloat2).setDuration(150L).start();
                    } else if (action == 1 || action == 3) {
                        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("scaleX", 0.93f, 1.0f);
                        PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("scaleY", 0.93f, 1.0f);
                        PropertyValuesHolder ofFloat6 = PropertyValuesHolder.ofFloat("alpha", 0.8f, 1.0f);
                        ObjectAnimator.ofPropertyValuesHolder(view, ofFloat6, ofFloat4, ofFloat5).setDuration(200L).start();
                    }
                    return false;
                }
            });
        }
    }

    public static void addHomeTabClickEffect(View... viewArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309476660")) {
            ipChange.ipc$dispatch("-1309476660", new Object[]{viewArr});
            return;
        }
        for (final View view : viewArr) {
            view.setOnTouchListener(new View.OnTouchListener() {
                /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1417519257")) {
                        return ((Boolean) ipChange.ipc$dispatch("-1417519257", new Object[]{this, view, motionEvent})).booleanValue();
                    }
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.8f);
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.8f);
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.8f);
                        ObjectAnimator.ofPropertyValuesHolder(view, ofFloat3, ofFloat, ofFloat2).setDuration(200L).start();
                    } else if (action == 1 || action == 3) {
                        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("scaleX", 0.8f, 1.2f);
                        PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("scaleY", 0.8f, 1.2f);
                        PropertyValuesHolder ofFloat6 = PropertyValuesHolder.ofFloat("alpha", 0.8f, 1.0f);
                        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat6, ofFloat4, ofFloat5);
                        ofPropertyValuesHolder.setDuration(200L);
                        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                            /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass3.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void onAnimationEnd(Animator animator) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-454357670")) {
                                    ipChange.ipc$dispatch("-454357670", new Object[]{this, animator});
                                    return;
                                }
                                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.2f, 1.0f);
                                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.2f, 1.0f);
                                ObjectAnimator.ofPropertyValuesHolder(view, ofFloat, ofFloat2).setDuration(100L).start();
                            }
                        });
                        ofPropertyValuesHolder.start();
                    }
                    return false;
                }
            });
        }
    }

    public static final StateListDrawable buttonSelector(Drawable drawable, Drawable drawable2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751380385")) {
            return (StateListDrawable) ipChange.ipc$dispatch("-751380385", new Object[]{drawable, drawable2});
        } else if (drawable == null || drawable2 == null) {
            return null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
            stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
            stateListDrawable.addState(new int[]{16842910}, drawable);
            return stateListDrawable;
        }
    }

    public static boolean checkDeviceHasNavigationBar(Context context) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1961732444")) {
            return ((Boolean) ipChange.ipc$dispatch("1961732444", new Object[]{context})).booleanValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
            if ("1".equals(str)) {
                z = false;
            } else if (!"0".equals(str)) {
                z = z2;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d A[SYNTHETIC, Splitter:B:46:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097 A[SYNTHETIC, Splitter:B:51:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3 A[SYNTHETIC, Splitter:B:58:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ad A[SYNTHETIC, Splitter:B:63:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00b9 A[SYNTHETIC, Splitter:B:71:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c3 A[SYNTHETIC, Splitter:B:76:0x00c3] */
    @SuppressLint({"NewApi"})
    private static CharSequence coerceToText(Context context, ClipData.Item item) {
        FileInputStream fileInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551310028")) {
            return (CharSequence) ipChange.ipc$dispatch("-551310028", new Object[]{context, item});
        }
        CharSequence text = item.getText();
        if (text != null) {
            return text;
        }
        Uri uri = item.getUri();
        if (uri != null) {
            InputStreamReader inputStreamReader2 = null;
            try {
                fileInputStream = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                    try {
                        StringBuilder sb = new StringBuilder(128);
                        char[] cArr = new char[8192];
                        while (true) {
                            int read = inputStreamReader.read(cArr);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        String sb2 = sb.toString();
                        try {
                            inputStreamReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return sb2;
                    } catch (FileNotFoundException unused) {
                        inputStreamReader2 = inputStreamReader;
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return uri.toString();
                    } catch (IOException e6) {
                        e = e6;
                        try {
                            Log.w("ClippedData", "Failure lf_loading text", e);
                            String iOException = e.toString();
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            return iOException;
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException unused2) {
                    if (inputStreamReader2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return uri.toString();
                } catch (IOException e11) {
                    inputStreamReader = null;
                    e = e11;
                    Log.w("ClippedData", "Failure lf_loading text", e);
                    String iOException2 = e.toString();
                    if (inputStreamReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return iOException2;
                } catch (Throwable th3) {
                    inputStreamReader = null;
                    th = th3;
                    if (inputStreamReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
                fileInputStream = null;
                if (inputStreamReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                return uri.toString();
            } catch (IOException e12) {
                inputStreamReader = null;
                e = e12;
                fileInputStream = null;
                Log.w("ClippedData", "Failure lf_loading text", e);
                String iOException22 = e.toString();
                if (inputStreamReader != null) {
                }
                if (fileInputStream != null) {
                }
                return iOException22;
            } catch (Throwable th4) {
                inputStreamReader = null;
                th = th4;
                fileInputStream = null;
                if (inputStreamReader != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
        } else {
            Intent intent = item.getIntent();
            return intent != null ? intent.toUri(1) : "";
        }
    }

    public static final StateListDrawable compoundButtonSelector(Drawable drawable, Drawable drawable2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94642036")) {
            return (StateListDrawable) ipChange.ipc$dispatch("94642036", new Object[]{drawable, drawable2});
        } else if (drawable == null || drawable2 == null) {
            return null;
        } else {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842912}, drawable2);
            stateListDrawable.addState(new int[]{16842910}, drawable);
            return stateListDrawable;
        }
    }

    public static final void convertActivityToTranslucent(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265868109")) {
            ipChange.ipc$dispatch("1265868109", new Object[]{activity});
        } else if (Build.VERSION.SDK_INT >= 21) {
            convertActivityToTranslucentAfterL(activity);
        } else {
            convertActivityToTranslucentBeforeL(activity);
        }
    }

    @SuppressLint({"NewApi"})
    private static final void convertActivityToTranslucentAfterL(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440967357")) {
            ipChange.ipc$dispatch("440967357", new Object[]{activity});
            return;
        }
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            Class<?> cls = null;
            for (Class<?> cls2 : declaredClasses) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, invoke);
        } catch (Throwable unused) {
        }
    }

    private static final void convertActivityToTranslucentBeforeL(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "369091092")) {
            ipChange.ipc$dispatch("369091092", new Object[]{activity});
            return;
        }
        try {
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            Class<?> cls = null;
            for (Class<?> cls2 : declaredClasses) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean copyToClipboard(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890440969")) {
            return ((Boolean) ipChange.ipc$dispatch("1890440969", new Object[]{context, str})).booleanValue();
        }
        try {
            if (Build.VERSION.SDK_INT < 11) {
                ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            } else {
                ((android.content.ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Text Label", str));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static GradientDrawable createRectangleDrawable(Context context, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977091277")) {
            return (GradientDrawable) ipChange.ipc$dispatch("977091277", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        if (i != -1) {
            gradientDrawable.setColor(i);
        }
        if (i2 != -1) {
            gradientDrawable.setStroke(dip2px(1), i2);
        }
        gradientDrawable.setCornerRadius((float) i3);
        return gradientDrawable;
    }

    public static final int dip2px(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "483342670")) {
            return ((Integer) ipChange.ipc$dispatch("483342670", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (AppContextUtils.getApp() == null) {
            return 0;
        } else {
            return (int) ((((float) i) * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static final void finishActivity(final Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1899879961")) {
            ipChange.ipc$dispatch("-1899879961", new Object[]{activity});
        } else if (isRunInMainThread()) {
            activity.finish();
        } else {
            post(new Runnable() {
                /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1650488059")) {
                        ipChange.ipc$dispatch("1650488059", new Object[]{this});
                        return;
                    }
                    activity.finish();
                }
            });
        }
    }

    public static final float float2dp(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917057509")) {
            return ((Float) ipChange.ipc$dispatch("-917057509", new Object[]{Float.valueOf(f)})).floatValue();
        } else if (AppContextUtils.getApp() == null) {
            return 0.0f;
        } else {
            return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        }
    }

    public static View getCenterXChild(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "508166581")) {
            return (View) ipChange.ipc$dispatch("508166581", new Object[]{recyclerView});
        }
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (isChildInCenterX(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int getCenterXChildPosition(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53594961")) {
            return ((Integer) ipChange.ipc$dispatch("-53594961", new Object[]{recyclerView})).intValue();
        }
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (isChildInCenterX(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static View getCenterYChild(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462395476")) {
            return (View) ipChange.ipc$dispatch("1462395476", new Object[]{recyclerView});
        }
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (isChildInCenterY(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int getCenterYChildPosition(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "47317006")) {
            return ((Integer) ipChange.ipc$dispatch("47317006", new Object[]{recyclerView})).intValue();
        }
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (isChildInCenterY(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static final int getColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735501100")) {
            return ((Integer) ipChange.ipc$dispatch("735501100", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (getResources() == null) {
            return 0;
        } else {
            return getResources().getColor(i);
        }
    }

    public static final ColorDrawable getColorDrawable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1971490316")) {
            return (ColorDrawable) ipChange.ipc$dispatch("-1971490316", new Object[]{Integer.valueOf(i)});
        } else if (getResources() == null) {
            return null;
        } else {
            return new ColorDrawable(getResources().getColor(i));
        }
    }

    public static final ColorStateList getColorStateList(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240588382")) {
            return (ColorStateList) ipChange.ipc$dispatch("-1240588382", new Object[]{Integer.valueOf(i)});
        } else if (getResources() == null) {
            return null;
        } else {
            return getResources().getColorStateList(i);
        }
    }

    public static final Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1939476938") ? (Context) ipChange.ipc$dispatch("-1939476938", new Object[0]) : AppContextUtils.getApp();
    }

    public static final int getDecorViewHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001318783")) {
            return ((Integer) ipChange.ipc$dispatch("-1001318783", new Object[]{activity})).intValue();
        }
        return getFullActivityHeight(activity) - getStatusBarHeight(activity);
    }

    public static final int getDimens(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "500511323")) {
            return ((Integer) ipChange.ipc$dispatch("500511323", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (AppContextUtils.getApp() == null || getResources() == null) {
            return 0;
        } else {
            return getResources().getDimensionPixelSize(i);
        }
    }

    public static final Drawable getDrawable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933519466")) {
            return (Drawable) ipChange.ipc$dispatch("-933519466", new Object[]{Integer.valueOf(i)});
        } else if (AppContextUtils.getApp() == null || getResources() == null) {
            return null;
        } else {
            return getResources().getDrawable(i);
        }
    }

    public static final float getFontHeight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1354146807")) {
            return ((Float) ipChange.ipc$dispatch("-1354146807", new Object[]{Float.valueOf(f)})).floatValue();
        }
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public static final float getFontHeightOnlyText(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718298974")) {
            return ((Float) ipChange.ipc$dispatch("-718298974", new Object[]{Float.valueOf(f)})).floatValue();
        }
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static int getFullActivityHeight(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064580669")) {
            return ((Integer) ipChange.ipc$dispatch("-2064580669", new Object[]{context})).intValue();
        } else if (!isAllScreenDevice()) {
            return getScreenHeight(context);
        } else {
            return getScreenRealHeight(context);
        }
    }

    public static final Handler getHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068724771")) {
            return (Handler) ipChange.ipc$dispatch("2068724771", new Object[0]);
        }
        if (AppContextUtils.getApp() == null) {
            return null;
        }
        return new Handler(getContext().getMainLooper());
    }

    public static int getNavigationBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707040628")) {
            return ((Integer) ipChange.ipc$dispatch("707040628", new Object[]{context})).intValue();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android");
        if (identifier <= 0 || !checkDeviceHasNavigationBar(context)) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getNavigationBarHeight_2(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159674663")) {
            return ((Integer) ipChange.ipc$dispatch("1159674663", new Object[]{context})).intValue();
        }
        Resources resources = getResources();
        if (!hasSoftKeys(context) || resources == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", Constants.DIMEN, "android"));
    }

    public static final Resources getResources() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132989465")) {
            return (Resources) ipChange.ipc$dispatch("132989465", new Object[0]);
        }
        if (AppContextUtils.getApp() == null) {
            return null;
        }
        return getContext().getResources();
    }

    public static View getRootView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-217035350")) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        }
        return (View) ipChange.ipc$dispatch("-217035350", new Object[]{activity});
    }

    public static final Drawable getRoundShapeDrawable(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1558200242")) {
            return (Drawable) ipChange.ipc$dispatch("-1558200242", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        float f = (float) i;
        ovalShape.resize(f, f);
        shapeDrawable.setShape(ovalShape);
        Paint paint = shapeDrawable.getPaint();
        if (paint != null) {
            paint.setColor(i2);
        }
        return shapeDrawable;
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378823695")) {
            return ((Integer) ipChange.ipc$dispatch("-378823695", new Object[]{context})).intValue();
        }
        if (context == null) {
            context = AppContextUtils.getApp();
        }
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int getScreenRealHeight(@Nullable Context context) {
        int i;
        WindowManager windowManager;
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "668678191")) {
            return ((Integer) ipChange.ipc$dispatch("668678191", new Object[]{context})).intValue();
        } else if (Build.VERSION.SDK_INT < 17) {
            return getScreenHeight(context);
        } else {
            if (context != null) {
                i = context.getResources().getConfiguration().orientation;
            } else {
                i = AppContextUtils.getApp().getResources().getConfiguration().orientation;
            }
            if (i != 1) {
                c = 1;
            }
            if (mRealSizes[c] == null) {
                if (context != null) {
                    windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW);
                } else {
                    windowManager = (WindowManager) AppContextUtils.getApp().getSystemService(v.ATTACH_MODE_WINDOW);
                }
                if (windowManager == null) {
                    return getScreenHeight(context);
                }
                android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                Display.getRealSize(defaultDisplay, point);
                mRealSizes[c] = point;
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(mRealSizes[c]);
        }
    }

    public static final int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1620177720")) {
            return ((Integer) ipChange.ipc$dispatch("-1620177720", new Object[]{context})).intValue();
        }
        if (context == null) {
            context = AppContextUtils.getApp();
        }
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static final float getSp(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096772464")) {
            return ((Float) ipChange.ipc$dispatch("-1096772464", new Object[]{Float.valueOf(f)})).floatValue();
        } else if (AppContextUtils.getApp() == null) {
            return 0.0f;
        } else {
            return TypedValue.applyDimension(2, f, getContext().getResources().getDisplayMetrics());
        }
    }

    public static int getStatusBarHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935237206")) {
            return ((Integer) ipChange.ipc$dispatch("935237206", new Object[]{context})).intValue();
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
    }

    public static final String getString(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264476183")) {
            return (String) ipChange.ipc$dispatch("-264476183", new Object[]{Integer.valueOf(i)});
        } else if (AppContextUtils.getApp() == null) {
            return null;
        } else {
            if (getResources() == null) {
                return "";
            }
            return getResources().getString(i);
        }
    }

    public static final String[] getStringArray(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881180563")) {
            return (String[]) ipChange.ipc$dispatch("-881180563", new Object[]{Integer.valueOf(i)});
        } else if (AppContextUtils.getApp() == null) {
            return null;
        } else {
            if (getResources() == null) {
                return new String[0];
            }
            return getResources().getStringArray(i);
        }
    }

    @SuppressLint({"NewApi"})
    public static final int getSystemWindowHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735062052")) {
            return ((Integer) ipChange.ipc$dispatch("-735062052", new Object[]{activity})).intValue();
        }
        android.view.Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(AppContextUtils.getApp().getResources().getDisplayMetrics());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 14 && i2 < 17) {
            try {
                return ((Integer) android.view.Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
                return i;
            }
        } else if (i2 < 17) {
            return ((Integer) android.view.Display.class.getMethod("getRealHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getRealMetrics(defaultDisplay, displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        }
    }

    @SuppressLint({"NewApi"})
    public static final int getSystemWindowWidth(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "958623403")) {
            return ((Integer) ipChange.ipc$dispatch("958623403", new Object[]{activity})).intValue();
        }
        android.view.Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(AppContextUtils.getApp().getResources().getDisplayMetrics());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 14 && i2 < 17) {
            try {
                return ((Integer) android.view.Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
                return i;
            }
        } else if (i2 < 17) {
            return ((Integer) android.view.Display.class.getMethod("getRealWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getRealMetrics(defaultDisplay, displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        }
    }

    public static final int getTouchSlop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641885497")) {
            return ((Integer) ipChange.ipc$dispatch("-641885497", new Object[0])).intValue();
        }
        return ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static boolean hasSoftKeys(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617968977")) {
            return ((Boolean) ipChange.ipc$dispatch("1617968977", new Object[]{context})).booleanValue();
        } else if (com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().toLowerCase().equals("meizu")) {
            return true;
        } else {
            if (Build.VERSION.SDK_INT >= 17) {
                android.view.Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Display.getRealMetrics(defaultDisplay, displayMetrics);
                int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                Display.getMetrics(defaultDisplay, displayMetrics2);
                int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics2);
                if (i2 - com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics2) > 0 || i - i3 > 0) {
                    return true;
                }
                return false;
            }
            boolean hasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return false;
            }
            return true;
        }
    }

    public static final void hideSoftInputBox(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420483012")) {
            ipChange.ipc$dispatch("-1420483012", new Object[]{activity});
            return;
        }
        View peekDecorView = activity.getWindow().peekDecorView();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (peekDecorView != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    public static final void hideSystemBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549841251")) {
            ipChange.ipc$dispatch("1549841251", new Object[]{activity});
            return;
        }
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                findViewById.setSystemUiVisibility(5894);
            } else if (i >= 14 && i < 19) {
                findViewById.setSystemUiVisibility(5380);
            }
        }
    }

    public static void increaseHitRectBy(float f, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028948153")) {
            ipChange.ipc$dispatch("1028948153", new Object[]{Float.valueOf(f), view});
            return;
        }
        increaseHitRectBy(f, f, f, f, view);
    }

    public static final View inflate(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "233524121")) {
            return LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null);
        }
        return (View) ipChange.ipc$dispatch("233524121", new Object[]{Integer.valueOf(i)});
    }

    public static View inflateViewLayout(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1312645178")) {
            return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        }
        return (View) ipChange.ipc$dispatch("1312645178", new Object[]{context, Integer.valueOf(i)});
    }

    public static boolean isAllScreenDevice() {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212743906")) {
            return ((Boolean) ipChange.ipc$dispatch("-212743906", new Object[0])).booleanValue();
        }
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        if (Build.VERSION.SDK_INT < 21 || AppContextUtils.getApp() == null) {
            return false;
        }
        WindowManager windowManager = (WindowManager) AppContextUtils.getApp().getSystemService(v.ATTACH_MODE_WINDOW);
        if (windowManager != null) {
            android.view.Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            Display.getRealSize(defaultDisplay, point);
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (xVar < yVar) {
                f2 = (float) xVar;
                f = (float) yVar;
            } else {
                float f3 = (float) yVar;
                f = (float) xVar;
                f2 = f3;
            }
            if (f / f2 >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

    public static boolean isChildInCenterX(RecyclerView recyclerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554568118")) {
            return ((Boolean) ipChange.ipc$dispatch("-554568118", new Object[]{recyclerView, view})).booleanValue();
        }
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int width = iArr[0] + (recyclerView.getWidth() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            return iArr2[0] <= width && iArr2[0] + view.getWidth() >= width;
        }
    }

    public static boolean isChildInCenterY(RecyclerView recyclerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226931817")) {
            return ((Boolean) ipChange.ipc$dispatch("1226931817", new Object[]{recyclerView, view})).booleanValue();
        }
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int height = iArr[1] + (recyclerView.getHeight() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            return iArr2[1] <= height && iArr2[1] + view.getHeight() >= height;
        }
    }

    public static boolean isFastDoubleClick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25693702")) {
            return ((Boolean) ipChange.ipc$dispatch("25693702", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 500) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    public static final boolean isLandScape() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159965274")) {
            return ((Boolean) ipChange.ipc$dispatch("-159965274", new Object[0])).booleanValue();
        }
        if (getContext().getResources() != null && getContext().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static final boolean isPortrait() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "627470422")) {
            return ((Boolean) ipChange.ipc$dispatch("627470422", new Object[0])).booleanValue();
        }
        return getContext().getResources() == null || getContext().getResources().getConfiguration().orientation == 1;
    }

    public static final boolean isRunInMainThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693215982")) {
            return ((Boolean) ipChange.ipc$dispatch("693215982", new Object[0])).booleanValue();
        }
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final boolean post(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127707335")) {
            return ((Boolean) ipChange.ipc$dispatch("-127707335", new Object[]{runnable})).booleanValue();
        } else if (getHandler() == null) {
            return false;
        } else {
            return getHandler().post(runnable);
        }
    }

    public static final boolean postDelayed(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "120294073")) {
            return ((Boolean) ipChange.ipc$dispatch("120294073", new Object[]{runnable, Long.valueOf(j)})).booleanValue();
        } else if (getHandler() == null) {
            return false;
        } else {
            return getHandler().postDelayed(runnable, j);
        }
    }

    public static final int px2dip(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615795232")) {
            return ((Integer) ipChange.ipc$dispatch("1615795232", new Object[]{Integer.valueOf(i)})).intValue();
        } else if (AppContextUtils.getApp() == null) {
            return 0;
        } else {
            return (int) ((((float) i) / getContext().getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static int px2wx(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1162004238")) {
            return (int) ((((float) i) * 750.0f) / ((float) getScreenWidth(AppContextUtils.getApp())));
        }
        return ((Integer) ipChange.ipc$dispatch("1162004238", new Object[]{Integer.valueOf(i)})).intValue();
    }

    @SuppressLint({"NewApi"})
    public static String readFromClipboard(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723837461")) {
            return (String) ipChange.ipc$dispatch("723837461", new Object[]{context});
        } else if (Build.VERSION.SDK_INT < 11) {
            return com.alibaba.wireless.security.aopsdk.replace.android.text.ClipboardManager.getText((ClipboardManager) context.getSystemService("clipboard")).toString();
        } else {
            context.getContentResolver();
            ClipData primaryClip = com.alibaba.wireless.security.aopsdk.replace.android.content.ClipboardManager.getPrimaryClip((android.content.ClipboardManager) context.getSystemService("clipboard"));
            return primaryClip != null ? coerceToText(context, primaryClip.getItemAt(0)).toString() : "";
        }
    }

    public static final void runInMainThread(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1558202910")) {
            ipChange.ipc$dispatch("1558202910", new Object[]{runnable});
        } else if (isRunInMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public static final void setBackground(View view, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199549325")) {
            ipChange.ipc$dispatch("-199549325", new Object[]{view, drawable});
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static final void setBackgroundIfNotExist(View view, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757219060")) {
            ipChange.ipc$dispatch("1757219060", new Object[]{view, drawable});
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (view.getBackground() == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static final <V extends View> void setGone(boolean z, V... vArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902455521")) {
            ipChange.ipc$dispatch("-902455521", new Object[]{Boolean.valueOf(z), vArr});
            return;
        }
        for (V v : vArr) {
            if (v != null) {
                if (z) {
                    if (8 != v.getVisibility()) {
                        v.setVisibility(8);
                    }
                } else if (v.getVisibility() != 0) {
                    v.setVisibility(0);
                }
            }
        }
    }

    public static void setImmersionMode(View view) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "565424007")) {
            ipChange.ipc$dispatch("565424007", new Object[]{view});
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            i = 5894;
        } else if (i2 >= 14 && i2 < 19) {
            i = 5380;
        }
        if (i2 >= 11) {
            view.setSystemUiVisibility(i);
        }
    }

    public static <V extends View> V setInvisible(V v, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526585200")) {
            return (V) ((View) ipChange.ipc$dispatch("-526585200", new Object[]{v, Boolean.valueOf(z)}));
        }
        if (v != null) {
            if (z) {
                if (4 != v.getVisibility()) {
                    v.setVisibility(4);
                }
            } else if (v.getVisibility() != 0) {
                v.setVisibility(0);
            }
        }
        return v;
    }

    public static final void setMarginTopDelta(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1034104206")) {
            ipChange.ipc$dispatch("-1034104206", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i + dip2px(i2);
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void setSoftInputMode(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724740923")) {
            ipChange.ipc$dispatch("724740923", new Object[]{activity, Integer.valueOf(i)});
        } else if (activity != null) {
            setSoftInputMode(activity.getWindow(), i);
        }
    }

    public static void setText(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "423338698")) {
            ipChange.ipc$dispatch("423338698", new Object[]{textView, str});
        } else if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
    }

    public static final void setTextBottomDrawables(TextView textView, Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604649193")) {
            ipChange.ipc$dispatch("-1604649193", new Object[]{textView, drawable, Integer.valueOf(i)});
        } else if (textView != null && drawable != null) {
            textView.setCompoundDrawablePadding(dip2px(i));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextLeftDrawables(TextView textView, Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489610189")) {
            ipChange.ipc$dispatch("-1489610189", new Object[]{textView, drawable, Integer.valueOf(i)});
        } else if (textView != null && drawable != null) {
            textView.setCompoundDrawablePadding(dip2px(i));
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextRightDrawables(TextView textView, Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477962426")) {
            ipChange.ipc$dispatch("-477962426", new Object[]{textView, drawable, Integer.valueOf(i)});
        } else if (textView != null && drawable != null) {
            textView.setCompoundDrawablePadding(dip2px(i));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextTopDrawables(TextView textView, Drawable drawable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674874111")) {
            ipChange.ipc$dispatch("674874111", new Object[]{textView, drawable, Integer.valueOf(i)});
        } else if (textView != null && drawable != null) {
            textView.setCompoundDrawablePadding(dip2px(i));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextViewContent(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447941508")) {
            ipChange.ipc$dispatch("-447941508", new Object[]{textView, str});
        } else if (textView != null) {
            textView.setText(str);
        }
    }

    public static final void setTextWithColorSpan(TextView textView, String str, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567503284")) {
            ipChange.ipc$dispatch("1567503284", new Object[]{textView, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(getColor(i3)), i, i2, 33);
        textView.setText(spannableString);
    }

    public static final void setViewFixFullScreen(View view) {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "415280836")) {
            ipChange.ipc$dispatch("415280836", new Object[]{view});
        } else if (view != null && view.getContext() != null && (view.getContext() instanceof Activity) && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = getScreenWidth(view.getContext());
            layoutParams.height = getDecorViewHeight((Activity) view.getContext());
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void setViewFixFullScreenIgnoreStateBar(View view) {
        ViewGroup.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638431400")) {
            ipChange.ipc$dispatch("-1638431400", new Object[]{view});
        } else if (view != null && view.getContext() != null && (view.getContext() instanceof Activity) && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = getScreenWidth(view.getContext());
            layoutParams.height = getScreenHeight((Activity) view.getContext());
            view.setLayoutParams(layoutParams);
        }
    }

    @TargetApi(21)
    public static void setViewRoundedCorner(View view, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533203219")) {
            ipChange.ipc$dispatch("-533203219", new Object[]{view, Integer.valueOf(i)});
        } else if (Build.VERSION.SDK_INT >= 21 && view != null && i >= 0) {
            if (i > 0) {
                view.setClipToOutline(true);
            } else {
                view.setClipToOutline(false);
            }
            view.setOutlineProvider(new ViewOutlineProvider() {
                /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void getOutline(View view, Outline outline) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "520993255")) {
                        ipChange.ipc$dispatch("520993255", new Object[]{this, view, outline});
                        return;
                    }
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) i);
                }
            });
        }
    }

    public static void showFailedInfoAboutView(Context context, TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773702011")) {
            ipChange.ipc$dispatch("-1773702011", new Object[]{context, textView});
            return;
        }
        textView.setText(Html.fromHtml("你可以检查网络连接情况或者尝试刷新，如仍然无法解决，可以加入客服群<a href=\"qq\" style=\"color:#0badb1; text-decoration:none;\">155787050</a> 询问"));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            int length = text.length();
            Spannable spannable = (Spannable) textView.getText();
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.setSpan(new ClickableSpan(uRLSpan.getURL(), context) {
                    /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass1MyURLSpan */
                    private static transient /* synthetic */ IpChange $ipChange;
                    String mUrl;
                    final /* synthetic */ Context val$context;

                    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        this.val$context = r2;
                        this.mUrl = r1;
                    }

                    public void onClick(View view) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-2097488020")) {
                            ipChange.ipc$dispatch("-2097488020", new Object[]{this, view});
                            return;
                        }
                        ClipboardManager clipboardManager = (ClipboardManager) this.val$context.getSystemService("clipboard");
                        if (this.mUrl.equals(Site.QQ)) {
                            clipboardManager.setText("155787050");
                            Toast.makeText(this.val$context, "已复制到剪贴板中", 0).show();
                        }
                    }
                }, spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static final void showSoftInputBox(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638406303")) {
            ipChange.ipc$dispatch("-638406303", new Object[]{activity});
            return;
        }
        View peekDecorView = activity.getWindow().peekDecorView();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (peekDecorView != null && inputMethodManager != null) {
            inputMethodManager.toggleSoftInputFromWindow(peekDecorView.getWindowToken(), 2, 1);
        }
    }

    public static final void showSystemBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321565602")) {
            ipChange.ipc$dispatch("-1321565602", new Object[]{activity});
            return;
        }
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById != null && Build.VERSION.SDK_INT >= 14) {
            findViewById.setSystemUiVisibility(0);
        }
    }

    public static int transformToDensityPixel(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-86233087")) {
            return (int) (f * f2);
        }
        return ((Integer) ipChange.ipc$dispatch("-86233087", new Object[]{Float.valueOf(f), Float.valueOf(f2)})).intValue();
    }

    public static int transformToDensityPixel(int i, DisplayMetrics displayMetrics) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-955602799")) {
            return transformToDensityPixel((float) i, (float) displayMetrics.densityDpi);
        }
        return ((Integer) ipChange.ipc$dispatch("-955602799", new Object[]{Integer.valueOf(i), displayMetrics})).intValue();
    }

    public static int wx2px(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1194320828")) {
            return (int) (((float) (i * getScreenWidth(AppContextUtils.getApp()))) / 750.0f);
        }
        return ((Integer) ipChange.ipc$dispatch("1194320828", new Object[]{Integer.valueOf(i)})).intValue();
    }

    public static Drawable zoomImage(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1425628414")) {
            return (Drawable) ipChange.ipc$dispatch("-1425628414", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        Resources resources = getContext().getResources();
        return new BitmapDrawable(resources, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, i), i2, i3, true));
    }

    public static void increaseHitRectBy(final float f, final float f2, final float f3, final float f4, final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399491531")) {
            ipChange.ipc$dispatch("1399491531", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), view});
            return;
        }
        final View view2 = (View) view.getParent();
        if (view2 != null && view.getContext() != null) {
            view2.post(new Runnable() {
                /* class com.youku.live.dago.widgetlib.util.UIUtil.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1060947544")) {
                        ipChange.ipc$dispatch("1060947544", new Object[]{this});
                        return;
                    }
                    float f = (float) view.getContext().getResources().getDisplayMetrics().densityDpi;
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    rect.top -= UIUtil.transformToDensityPixel(f, f);
                    rect.left -= UIUtil.transformToDensityPixel(f2, f);
                    rect.bottom += UIUtil.transformToDensityPixel(f3, f);
                    rect.right += UIUtil.transformToDensityPixel(f4, f);
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
        }
    }

    public static void setSoftInputMode(Window window, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051147918")) {
            ipChange.ipc$dispatch("-1051147918", new Object[]{window, Integer.valueOf(i)});
        } else if (window != null) {
            window.setSoftInputMode(i);
            ((ILog) Dsl.getService(ILog.class)).i("setSoftInputMode", "setSoftInputMode: " + i);
        }
    }

    public static final int dip2px(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753668906")) {
            return ((Integer) ipChange.ipc$dispatch("-753668906", new Object[]{context, Integer.valueOf(i)})).intValue();
        } else if (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) {
            return 0;
        } else {
            return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static final int getDecorViewHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806408959")) {
            return ((Integer) ipChange.ipc$dispatch("806408959", new Object[]{context})).intValue();
        }
        return getFullActivityHeight(context) - getStatusBarHeight(context);
    }

    public static <V extends View> boolean setGone(V v, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569193896")) {
            return ((Boolean) ipChange.ipc$dispatch("-1569193896", new Object[]{v, Boolean.valueOf(z)})).booleanValue();
        }
        if (v != null) {
            if (z) {
                if (8 != v.getVisibility()) {
                    v.setVisibility(8);
                    return true;
                }
            } else if (v.getVisibility() != 0) {
                v.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public static final void setTextBottomDrawables(TextView textView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082017112")) {
            ipChange.ipc$dispatch("-2082017112", new Object[]{textView, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (textView != null && i > 0) {
            textView.setCompoundDrawablePadding(dip2px(i2));
            if (getContext() != null && getContext().getResources() != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getContext().getResources().getDrawable(i));
            }
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextLeftDrawables(TextView textView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1280662284")) {
            ipChange.ipc$dispatch("1280662284", new Object[]{textView, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (textView != null && i > 0) {
            textView.setCompoundDrawablePadding(dip2px(i2));
            if (getContext() != null && getContext().getResources() != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(i), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextRightDrawables(TextView textView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56059175")) {
            ipChange.ipc$dispatch("-56059175", new Object[]{textView, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (textView != null && i > 0) {
            textView.setCompoundDrawablePadding(dip2px(i2));
            if (getContext() != null && getContext().getResources() != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getContext().getResources().getDrawable(i), (Drawable) null);
            }
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void setTextTopDrawables(TextView textView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-541895232")) {
            ipChange.ipc$dispatch("-541895232", new Object[]{textView, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (textView != null && i > 0) {
            textView.setCompoundDrawablePadding(dip2px(i2));
            if (getContext() != null && getContext().getResources() != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getResources().getDrawable(i), (Drawable) null, (Drawable) null);
            }
        } else if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public static final void showSoftInputBox(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602596573")) {
            ipChange.ipc$dispatch("-1602596573", new Object[]{view});
            return;
        }
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                view.requestFocus();
                inputMethodManager.showSoftInput(view, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void setBackground(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1952732692")) {
            ipChange.ipc$dispatch("1952732692", new Object[]{view, Integer.valueOf(i)});
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (i > 0) {
            Drawable drawable = view.getResources().getDrawable(i);
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static final void setBackgroundIfNotExist(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539123917")) {
            ipChange.ipc$dispatch("-539123917", new Object[]{view, Integer.valueOf(i)});
            return;
        }
        int paddingBottom = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        Drawable background = view.getBackground();
        if (i > 0 && background == null) {
            Drawable drawable = view.getResources().getDrawable(i);
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }
}
