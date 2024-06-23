package tb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.security.realidentity.jsbridge.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class a01 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a01 INSTANCE = new a01();
    @NotNull
    private static String[] a = {"tbvideo-taobao-film.oss-cn-hangzhou.aliyuncs.com", "tbvideoinputfirst.oss-cn-hangzhou.aliyuncs.com", "tbvideoinputsecond.oss-cn-beijing.aliyuncs.com", "taobaodianying.oss-cn-zhangjiakou.aliyuncs.com", "bdworkflow.oss-cn-hangzhou.aliyuncs.com", "tbfilm-oss.oss-cn-zhangjiakou.aliyuncs.com", "tfavatar-oss.oss-cn-shanghai.aliyuncs.com", "dmassets.oss-cn-shanghai.aliyuncs.com", "perico.oss-cn-beijing.aliyuncs.com", "damaipimg.oss-cn-beijing.aliyuncs.com", "damai-comment.oss-cn-beijing.aliyuncs.com", "damai-intercms.oss-cn-beijing.aliyuncs.com", "damai-sentiment.oss-cn-beijing.aliyuncs.com", "damai-mec-comment.oss-cn-beijing.aliyuncs.com", "damai-mx-partner-admin.oss-cn-beijing.aliyuncs.com", "damai-finance-upload.oss-cn-beijing.aliyuncs.com", "ticklet.oss-cn-beijing.aliyuncs.com"};
    @NotNull
    private static String[] b = {"tbvideo-oss.taopiaopiao.com", "tbvideo-oss.taopiaopiao.com", "tbvideo.taopiaopiao.com", "oss.taopiaopiao.com", "bdworkflow.taopiaopiao.com", "tbfilm-oss.taopiaopiao.com", "tfavatar-oss.taopiaopiao.com", "assets.damai.cn", "perico.damai.cn", "pimg.damai.cn", "comment-cdn.damai.cn", "intercms.damai.cn", "sentiment.damai.cn", "mec-comment.damai.cn", "mx-partner-admin.damai.cn", "finance-upload.damai.cn", "ticklet.damai.cn"};

    private a01() {
    }

    @JvmStatic
    public static final int c(@Nullable View view) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "502694360")) {
            return ((Integer) ipChange.ipc$dispatch("502694360", new Object[]{view})).intValue();
        }
        Objects.requireNonNull(view);
        int paddingTop = view.getPaddingTop() + view.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.height;
        }
        return INSTANCE.b(view, view.getHeight(), i, paddingTop);
    }

    @JvmStatic
    public static final int d(@Nullable View view) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1259564949")) {
            return ((Integer) ipChange.ipc$dispatch("1259564949", new Object[]{view})).intValue();
        }
        Objects.requireNonNull(view);
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.width;
        }
        return INSTANCE.b(view, view.getWidth(), i, paddingLeft);
    }

    @JvmStatic
    public static final boolean e(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893192458")) {
            return ((Boolean) ipChange.ipc$dispatch("1893192458", new Object[]{view})).booleanValue();
        }
        if (view != null) {
            a01 a01 = INSTANCE;
            return a01.h(d(view)) && a01.h(c(view));
        }
    }

    @JvmStatic
    public static final boolean f(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1729185407")) {
            return view != null && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1729185407", new Object[]{view})).booleanValue();
    }

    private final boolean h(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1151650580")) {
            return i > 0 || i == Integer.MIN_VALUE;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1151650580", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    @Nullable
    public final Uri a(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934450812")) {
            return (Uri) ipChange.ipc$dispatch("-934450812", new Object[]{this, context, str});
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        query.close();
        Uri parse = Uri.parse("content://media/external/images/media");
        return Uri.withAppendedPath(parse, "" + i);
    }

    public final int b(@Nullable View view, int i, int i2, int i3) {
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966102871")) {
            return ((Integer) ipChange.ipc$dispatch("-966102871", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        Objects.requireNonNull(view);
        int i5 = i2 - i3;
        if (i5 > 0) {
            return i5;
        }
        if (!view.isLayoutRequested() && (i4 = i - i3) > 0) {
            return i4;
        }
        return 0;
    }

    public final boolean g(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "802701573")) {
            return ((Boolean) ipChange.ipc$dispatch("802701573", new Object[]{this, context, str})).booleanValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str != null && Build.VERSION.SDK_INT == 29) {
            String substring = str.substring(0, StringsKt__StringsKt.l0(str, "/", 0, false, 6, null));
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String packageName = context.getPackageName();
            k21.h(packageName, "context.packageName");
            if (!(StringsKt__StringsKt.Q(substring, packageName, false, 2, null))) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1308351878")) {
            return view != null && h(d(view)) && h(c(view)) && view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1308351878", new Object[]{this, view})).booleanValue();
    }

    @Nullable
    public final String j(@Nullable Uri uri, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990470130")) {
            return (String) ipChange.ipc$dispatch("1990470130", new Object[]{this, uri, str});
        }
        if (!(uri == null || !ne1.INSTANCE.f() || str == null)) {
            try {
                String host = uri.getHost();
                if (host != null && !k21.d(host, "oss.taopiaopiao.com")) {
                    if (!k21.d(host, "gw.alicdn.com")) {
                        int i = ArraysKt___ArraysKt.B(a, host);
                        if (i >= 0) {
                            String[] strArr = b;
                            if (i < strArr.length) {
                                String str2 = strArr[i];
                                int i2 = StringsKt__StringsKt.f0(str, "?", 0, false, 6, null);
                                if (i2 > 0) {
                                    str = str.substring(0, i2);
                                    k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                }
                                return o.H(str, host, str2, false, 4, null);
                            }
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                me1.INSTANCE.c(e.toString());
            }
        }
        return null;
    }
}
