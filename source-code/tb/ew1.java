package tb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.qrcode.QrCodeResultActivity;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.h5container.H5MainActivity;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.seat.ui.SVGDisplayActivity;
import com.ali.user.mobile.login.model.LoginConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.constants.LoginUrlConstants;
import com.taobao.login4android.scan.QrScanActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: Taobao */
public class ew1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(String str, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1766809756")) {
            ipChange.ipc$dispatch("-1766809756", new Object[]{str, activity});
            return;
        }
        if (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
            str = str.trim();
            if (str.contains("m.damai.cn/proj.aspx?id=")) {
                long j = 0;
                try {
                    j = Long.parseLong(str.substring(str.indexOf("id=") + 3, str.length()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Bundle bundle = new Bundle();
                bundle.putLong(IssueConstants.ProjectID, j);
                DMNav.from(activity).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
            } else if (str.contains("m.damai.cn/activityproject.aspx?id=")) {
                String substring = str.substring(str.indexOf("id=") + 3, str.length());
                Bundle bundle2 = new Bundle();
                bundle2.putString("activityid", substring);
                DMNav.from(activity).withExtras(bundle2).toUri(NavUri.b("topic_main"));
            } else if (LoginUrlConstants.isCommonScanUrl(str)) {
                Intent intent = new Intent(activity, QrScanActivity.class);
                intent.putExtra(LoginConstant.SCAN_KEY, str);
                activity.startActivity(intent);
            } else if (str.contains("mapi.damai.cn/Page/ScanCodeLogin/Confirm.aspx")) {
                g91.c("a", "____________ url:" + str);
                Intent intent2 = new Intent(activity, H5MainActivity.class);
                intent2.putExtra("url", str);
                intent2.putExtra("from", hf1.MODULE_BANNER);
                activity.startActivityForResult(intent2, 10);
            } else if (b(str).contains("ossgw.alicdn.com/rapid-oss-bucket")) {
                qc0.a(activity, str);
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putString("from", hf1.MODULE_BANNER);
                bundle3.putBoolean("fromQr", true);
                DMNav.from(activity).withExtras(bundle3).toUri(str);
            }
        } else if (str != null && str.startsWith("svg://damai.cn/check")) {
            int indexOf = str.indexOf("=");
            if (indexOf > 0 && indexOf < str.length() - 1) {
                String substring2 = str.substring(indexOf + 1);
                if (!substring2.contains("http")) {
                    substring2 = "http://" + substring2;
                }
                Bundle bundle4 = new Bundle();
                bundle4.putString(SVGDisplayActivity.REQUEST_SVG_URL, substring2);
                DMNav.from(activity).withExtras(bundle4).toUri(NavUri.b("svg_display"));
            }
        } else if (str != null && str.startsWith(pp2.SCHEME)) {
            DMNav.from(activity).toUri(URLDecoder.decode(str));
        } else if (str != null && str.startsWith("gaiax://gaiax/preview")) {
            try {
                String replaceAll = str.replaceAll("gaiax://gaiax/preview", "");
                Bundle bundle5 = new Bundle();
                bundle5.putString("url", replaceAll);
                DMNav.from(activity).withExtras(bundle5).toUri("youku://gaiax/preview" + replaceAll);
            } catch (Exception e2) {
                g91.c("gaiax_preview", e2.getStackTrace().toString());
            }
        } else if (str == null || !cw0.c(str)) {
            activity.startActivity(new Intent(activity, QrCodeResultActivity.class));
        } else {
            cw0.d(str);
        }
        if ((str.contains("mtl3.alibaba-inc.com") || str.contains("mtl4.alibaba-inc.com") || str.contains("mtl.alibaba-inc.com")) && str.contains("dynamicdeploy")) {
            UpdateUtil.j(str);
        }
        activity.finish();
    }

    private static String b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772990299")) {
            return (String) ipChange.ipc$dispatch("-772990299", new Object[]{str});
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
