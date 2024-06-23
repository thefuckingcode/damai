package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.model.DMSVG;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: Taobao */
public class k32 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static BaseSVG a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217306755")) {
            return (BaseSVG) ipChange.ipc$dispatch("1217306755", new Object[]{inputStream});
        }
        try {
            f a = new o32().a(inputStream, nr.b());
            DMSVG dmsvg = new DMSVG();
            dmsvg.initSVGData(a);
            return dmsvg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BaseSVG b(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773101477")) {
            return (BaseSVG) ipChange.ipc$dispatch("1773101477", new Object[]{inputStream});
        }
        try {
            return new b().b(inputStream).a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BaseSVG c(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1979745818")) {
            return (BaseSVG) ipChange.ipc$dispatch("1979745818", new Object[]{inputStream});
        } else if (nr.c()) {
            return a(inputStream);
        } else {
            return b(inputStream);
        }
    }

    public static BaseSVG d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447434809")) {
            return (BaseSVG) ipChange.ipc$dispatch("1447434809", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            return c(new ByteArrayInputStream(str.getBytes()));
        }
    }
}
