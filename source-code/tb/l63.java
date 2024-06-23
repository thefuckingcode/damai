package tb;

import android.net.Uri;
import android.text.TextUtils;
import com.loc.bl;

/* compiled from: Taobao */
public abstract class l63 extends bl {
    @Override // com.loc.bl
    public String m() {
        Uri.Builder buildUpon;
        String str;
        if (TextUtils.isEmpty(j())) {
            return j();
        }
        String j = j();
        Uri parse = Uri.parse(j);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return j;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            buildUpon = parse.buildUpon();
            str = "dualstack-arestapi.amap.com";
        } else {
            buildUpon = parse.buildUpon();
            str = "dualstack-" + parse.getAuthority();
        }
        return buildUpon.authority(str).build().toString();
    }
}
