package tb;

import android.taobao.windvane.config.WVServerConfig;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yl {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static Pattern a;

    /* compiled from: Taobao */
    public static final class a {

        /* access modifiers changed from: package-private */
        /* renamed from: tb.yl$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0312a implements OConfigListener {
            public static final C0312a INSTANCE = new C0312a();

            C0312a() {
            }

            @Override // com.taobao.orange.OConfigListener
            public final void onConfigUpdate(String str, Map<String, String> map) {
                if (k21.d(str, "movie_windvane")) {
                    String config = OrangeConfig.getInstance().getConfig(str, "domain", null);
                    boolean z = false;
                    if (!(config == null || config.length() == 0)) {
                        WVServerConfig.DOMAIN_PATTERN = config;
                        WVServerConfig.domainPat = null;
                    }
                    String config2 = OrangeConfig.getInstance().getConfig(str, "forbidden_domain", null);
                    if (!(config2 == null || config2.length() == 0)) {
                        WVServerConfig.FORBIDDEN_DOMAIN_PATTERN = config2;
                        WVServerConfig.forbiddenDomain = null;
                    }
                    String config3 = OrangeConfig.getInstance().getConfig(str, "third_party_domain", null);
                    if (!(config3 == null || config3.length() == 0)) {
                        WVServerConfig.THIRD_PARTY_DOMAIN_PATTERN = config3;
                        WVServerConfig.thirdPartyDomain = null;
                    }
                    String config4 = OrangeConfig.getInstance().getConfig(str, "redirect_domain", null);
                    a aVar = yl.Companion;
                    if (aVar.b() == null) {
                        if (config4 == null || config4.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            try {
                                aVar.d(Pattern.compile(config4, 2));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        private a() {
        }

        public final void a() {
            OrangeConfig.getInstance().registerListener(new String[]{"movie_windvane"}, C0312a.INSTANCE, true);
        }

        @Nullable
        public final Pattern b() {
            return yl.a;
        }

        public final boolean c(@Nullable String str) {
            Matcher matcher;
            if (str == null) {
                return false;
            }
            try {
                Pattern b = yl.Companion.b();
                return (b == null || (matcher = b.matcher(str)) == null || !matcher.find()) ? false : true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final void d(@Nullable Pattern pattern) {
            yl.a = pattern;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }
}
