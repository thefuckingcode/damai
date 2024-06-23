package tb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.R$id;
import com.alibaba.yymidservice.R$layout;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXDelegate;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.Objects;

public final class l70 {
    public static final a Companion = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        public static /* synthetic */ View b(a aVar, Activity activity, String str, String str2, String str3, JSONObject jSONObject, float f, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, int i, Object obj) {
            return aVar.a(activity, str, str2, str3, jSONObject, (i & 32) != 0 ? (float) DeviceInfoProviderProxy.getWindowWidth() : f, (i & 64) != 0 ? new PictureGaiaXEventProvider(activity) : pictureGaiaXDelegate, (i & 128) != 0 ? true : z, (i & 256) != 0 ? true : z2);
        }

        public final View a(Activity activity, String str, String str2, String str3, JSONObject jSONObject, float f, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
            String str4;
            k21.i(activity, "activity");
            k21.i(str2, "templateId");
            k21.i(pictureGaiaXDelegate, "yyDelegate");
            View inflate = activity.getLayoutInflater().inflate(R$layout.component_common_gaiax, (ViewGroup) null);
            k21.h(inflate, "activity.layoutInflater.…onent_common_gaiax, null)");
            View findViewById = inflate.findViewById(R$id.component_common_gaiax_layout);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) findViewById;
            GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
            boolean z3 = false;
            String str5 = str == null || str.length() == 0 ? "" : str;
            if (str3 == null || str3.length() == 0) {
                z3 = true;
            }
            if (z3) {
                str4 = "";
            } else {
                str4 = str3;
            }
            GaiaXBuilder.renderGaiaX$default(gaiaXBuilder, frameLayout, activity, str5, str2, str4, null, jSONObject, f, 0, pictureGaiaXDelegate, z, z2, null, 4128, null);
            return inflate;
        }
    }
}
