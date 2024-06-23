package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
public abstract class cz {

    /* compiled from: Taobao */
    public static class a extends cy {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cy, com.xiaomi.push.cy
        public String a(Context context, String str, List<bi> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bi biVar : list) {
                    buildUpon.appendQueryParameter(biVar.a(), biVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bj.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(cy cyVar, String str, List<bi> list, String str2) {
        if (cyVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cyVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(List<bi> list) {
        int i = 0;
        for (bi biVar : list) {
            if (!TextUtils.isEmpty(biVar.a())) {
                i += biVar.a().length();
            }
            if (!TextUtils.isEmpty(biVar.b())) {
                i += biVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<bi> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a9  */
    public static String a(Context context, String str, List<bi> list, cy cyVar, boolean z) {
        cr crVar;
        IOException iOException;
        String str2;
        String str3;
        IOException e;
        if (bj.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cr a2 = cv.a().m339a(str);
                    if (a2 != null) {
                        arrayList = a2.a(str);
                    }
                    crVar = a2;
                } else {
                    crVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it = arrayList.iterator();
                String str4 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!cyVar.m348a(context, next, (List<bi>) arrayList2)) {
                            return str4;
                        }
                        String a3 = cyVar.a(context, next, (List<bi>) arrayList2);
                        try {
                            if (!TextUtils.isEmpty(a3)) {
                                if (crVar != null) {
                                    try {
                                        crVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(cyVar, next, arrayList2, a3));
                                    } catch (IOException e2) {
                                        iOException = e2;
                                        str2 = a3;
                                    }
                                }
                                return a3;
                            }
                            if (crVar != null) {
                                str3 = a3;
                                try {
                                    crVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(cyVar, next, arrayList2, a3), null);
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } else {
                                str3 = a3;
                            }
                            str4 = str3;
                        } catch (IOException e4) {
                            e = e4;
                            str3 = a3;
                            iOException = e;
                            str2 = str3;
                            if (crVar != null) {
                                crVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(cyVar, next, arrayList2, str2), iOException);
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        str2 = str4;
                        if (crVar != null) {
                        }
                        iOException.printStackTrace();
                        str4 = str2;
                    }
                }
                return str4;
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}
