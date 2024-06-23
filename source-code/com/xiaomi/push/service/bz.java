package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ab;
import com.xiaomi.push.bp;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.v;
import com.youku.alixplayer.MsgID;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftNumBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
public class bz {
    private static String a;

    /* renamed from: a  reason: collision with other field name */
    private static SimpleDateFormat f953a;

    /* renamed from: a  reason: collision with other field name */
    private static AtomicLong f954a = new AtomicLong(0);

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f953a = simpleDateFormat;
        a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    private static ii a(String str, String str2, hm hmVar) {
        return new ii("-1", false).d(str).b(str2).a(ab.a(it.a(hmVar))).c(ht.UploadTinyData.f497a);
    }

    public static synchronized String a() {
        String str;
        synchronized (bz.class) {
            String format = f953a.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(a, format)) {
                f954a.set(0);
                a = format;
            }
            str = format + "-" + f954a.incrementAndGet();
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
    public static ArrayList<ii> a(List<hn> list, String str, String str2, int i) {
        int i2;
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else if (list.size() == 0) {
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        } else {
            ArrayList<ii> arrayList = new ArrayList<>();
            hm hmVar = new hm();
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                hn hnVar = list.get(i4);
                if (hnVar != null) {
                    if (hnVar.m552a() == null || !hnVar.m552a().containsKey("item_size")) {
                        i2 = 0;
                    } else {
                        String str4 = hnVar.m552a().get("item_size");
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                i2 = Integer.parseInt(str4);
                            } catch (Exception unused) {
                            }
                            if (hnVar.m552a().size() != 1) {
                                hnVar.a((Map<String, String>) null);
                            } else {
                                hnVar.m552a().remove("item_size");
                            }
                        }
                        i2 = 0;
                        if (hnVar.m552a().size() != 1) {
                        }
                    }
                    if (i2 <= 0) {
                        i2 = it.a(hnVar).length;
                    }
                    if (i2 > i) {
                        b.d("TinyData is too big, ignore upload request item:" + hnVar.d());
                    } else {
                        if (i3 + i2 > i) {
                            arrayList.add(a(str, str2, hmVar));
                            hmVar = new hm();
                            i3 = 0;
                        }
                        hmVar.a(hnVar);
                        i3 += i2;
                    }
                }
            }
            if (hmVar.a() != 0) {
                arrayList.add(a(str, str2, hmVar));
            }
            return arrayList;
        }
        b.d(str3);
        return null;
    }

    public static void a(Context context, String str, String str2, long j, String str3) {
        hn hnVar = new hn();
        hnVar.d(str);
        hnVar.c(str2);
        hnVar.a(j);
        hnVar.b(str3);
        hnVar.a("push_sdk_channel");
        hnVar.g(context.getPackageName());
        hnVar.e(context.getPackageName());
        hnVar.a(true);
        hnVar.b(System.currentTimeMillis());
        hnVar.f(a());
        ca.a(context, hnVar);
    }

    public static void a(String str, String str2, String str3, ao aoVar) {
        if (aoVar != null) {
            hn hnVar = new hn();
            hnVar.d(str);
            hnVar.c(str2);
            hnVar.g(str3);
            hnVar.e(str3);
            HashMap hashMap = new HashMap();
            hashMap.put("chid", String.valueOf(aoVar.a));
            hashMap.put("screen_on", String.valueOf(aoVar.f893a));
            hashMap.put("wifi", String.valueOf(aoVar.f895b));
            hashMap.put("rx_msg", String.valueOf(aoVar.f892a));
            hashMap.put("enqueue", String.valueOf(aoVar.f894b));
            hashMap.put(GiftNumBean.KEY_NUM, String.valueOf(aoVar.b));
            hashMap.put("run", String.valueOf(aoVar.c));
            hashMap.put("send", String.valueOf(System.currentTimeMillis()));
            hnVar.a(hashMap);
            ca.a(hnVar);
        }
    }

    public static boolean a(hn hnVar, boolean z) {
        String str;
        if (hnVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z && TextUtils.isEmpty(hnVar.f469a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hnVar.f476d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(hnVar.f475c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!bp.m292a(hnVar.f476d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (!bp.m292a(hnVar.f475c)) {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else {
            String str2 = hnVar.f474b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + hnVar.f474b.length() + "), max size for data is " + MsgID.MEDIA_INFO_VIDEO_START_RECOVER + " , verfiy ClientUploadDataItem failed.";
        }
        b.m182a(str);
        return true;
    }

    public static boolean a(String str) {
        return !v.m883b() || Constants.HYBRID_PACKAGE_NAME.equals(str);
    }
}
