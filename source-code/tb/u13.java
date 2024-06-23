package tb;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.sdk.m.c.a;
import com.loc.ah;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public final class u13 {
    private static volatile ah a;
    private static Properties b = f();

    private u13() {
    }

    public static ah a() {
        if (a == null) {
            synchronized (u13.class) {
                if (a == null) {
                    try {
                        ah b2 = b(Build.getMANUFACTURER());
                        if ("".equals(b2.a())) {
                            Iterator it = Arrays.asList(ah.MIUI.a(), ah.Flyme.a(), ah.EMUI.a(), ah.ColorOS.a(), ah.FuntouchOS.a(), ah.SmartisanOS.a(), ah.AmigoOS.a(), ah.Sense.a(), ah.LG.a(), ah.Google.a(), ah.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    b2 = ah.Other;
                                    break;
                                }
                                ah b3 = b((String) it.next());
                                if (!"".equals(b3.a())) {
                                    b2 = b3;
                                    break;
                                }
                            }
                        }
                        a = b2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return a;
    }

    private static ah b(String str) {
        if (str == null || str.length() <= 0) {
            return ah.Other;
        }
        ah ahVar = ah.MIUI;
        if (!str.equals(ahVar.a())) {
            ah ahVar2 = ah.Flyme;
            if (!str.equals(ahVar2.a())) {
                ah ahVar3 = ah.EMUI;
                if (!str.equals(ahVar3.a())) {
                    ah ahVar4 = ah.ColorOS;
                    if (!str.equals(ahVar4.a())) {
                        ah ahVar5 = ah.FuntouchOS;
                        if (!str.equals(ahVar5.a())) {
                            ah ahVar6 = ah.SmartisanOS;
                            if (!str.equals(ahVar6.a())) {
                                ah ahVar7 = ah.AmigoOS;
                                if (!str.equals(ahVar7.a())) {
                                    ah ahVar8 = ah.EUI;
                                    if (!str.equals(ahVar8.a())) {
                                        ah ahVar9 = ah.Sense;
                                        if (!str.equals(ahVar9.a())) {
                                            ah ahVar10 = ah.LG;
                                            if (!str.equals(ahVar10.a())) {
                                                ah ahVar11 = ah.Google;
                                                if (!str.equals(ahVar11.a())) {
                                                    ah ahVar12 = ah.NubiaUI;
                                                    if (str.equals(ahVar12.a()) && r(ahVar12)) {
                                                        return ahVar12;
                                                    }
                                                } else if (q(ahVar11)) {
                                                    return ahVar11;
                                                }
                                            } else if (p(ahVar10)) {
                                                return ahVar10;
                                            }
                                        } else if (o(ahVar9)) {
                                            return ahVar9;
                                        }
                                    } else if (n(ahVar8)) {
                                        return ahVar8;
                                    }
                                } else if (m(ahVar7)) {
                                    return ahVar7;
                                }
                            } else if (l(ahVar6)) {
                                return ahVar6;
                            }
                        } else if (k(ahVar5)) {
                            return ahVar5;
                        }
                    } else if (j(ahVar4)) {
                        return ahVar4;
                    }
                } else if (i(ahVar3)) {
                    return ahVar3;
                }
            } else if (g(ahVar2)) {
                return ahVar2;
            }
        } else if (d(ahVar)) {
            return ahVar;
        }
        return ah.Other;
    }

    private static void c(ah ahVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                ahVar.a(group);
                ahVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean d(ah ahVar) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            return false;
        }
        String e = e("ro.build.version.incremental");
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static String e(String str) {
        Properties properties = b;
        String property = properties.getProperty(jl1.ARRAY_START_STR + str + jl1.ARRAY_END_STR, null);
        return TextUtils.isEmpty(property) ? h(str) : property.replace(jl1.ARRAY_START_STR, "").replace(jl1.ARRAY_END_STR, "");
    }

    private static Properties f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static boolean g(ah ahVar) {
        String e = e("ro.flyme.published");
        String e2 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(e) && TextUtils.isEmpty(e2)) {
            return false;
        }
        String e3 = e("ro.build.display.id");
        c(ahVar, e3);
        ahVar.b(e3);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034 A[SYNTHETIC, Splitter:B:13:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[SYNTHETIC, Splitter:B:21:0x003b] */
    private static String h(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static boolean i(ah ahVar) {
        String e = e(a.a);
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean j(ah ahVar) {
        String e = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean k(ah ahVar) {
        String e = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean l(ah ahVar) {
        String e = e("ro.smartisan.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean m(ah ahVar) {
        String e = e("ro.build.display.id");
        if (TextUtils.isEmpty(e) || !e.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean n(ah ahVar) {
        String e = e("ro.letv.release.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean o(ah ahVar) {
        String e = e("ro.build.sense.version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean p(ah ahVar) {
        String e = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }

    private static boolean q(ah ahVar) {
        if (!"android-google".equals(e("ro.com.google.clientidbase"))) {
            return false;
        }
        String e = e("ro.build.version.release");
        ahVar.a(Build.VERSION.SDK_INT);
        ahVar.b(e);
        return true;
    }

    private static boolean r(ah ahVar) {
        String e = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(e)) {
            return false;
        }
        c(ahVar, e);
        ahVar.b(e);
        return true;
    }
}
