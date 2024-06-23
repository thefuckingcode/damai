package com.alient.oneservice.provider.impl.ut;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import com.alibaba.pictures.ut.DogCat;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProvider;
import java.util.HashMap;
import java.util.Map;
import tb.d20;
import tb.pn;

/* compiled from: Taobao */
public final class UserTrackProviderImpl implements UserTrackProvider {
    private final String KET_CITY = "city";
    boolean isUTDogCatSwitchOn = pn.d().isExpected(DamaiConstants.CONFIG_KEY_UT_DOG_CAT_SWITCH, "on", true);

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(View view, TrackInfo trackInfo) {
        click(view, trackInfo, false);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(View view, TrackInfo trackInfo) {
        if (trackInfo != null) {
            if (trackInfo.getArgs() == null) {
                trackInfo.setArgs(new HashMap<>());
            }
            HashMap hashMap = new HashMap(trackInfo.getArgs());
            if (trackInfo.getAbBucket() != null) {
                hashMap.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
            }
            if (!TextUtils.isEmpty(d20.d())) {
                hashMap.put("city", d20.d());
            }
            if (this.isUTDogCatSwitchOn) {
                DogCat.INSTANCE.h(view).q(trackInfo.getSpmb()).v(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).r(hashMap).k();
            } else {
                c.e().G(view, trackInfo.getSpmd(), trackInfo.getSpmc(), trackInfo.getSpmb(), hashMap);
            }
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(String str, TrackInfo trackInfo) {
    }

    public a.b getUTKeyBuilder(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        return new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void reportCustom(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(d20.d())) {
            map.put("city", d20.d());
        }
        if (this.isUTDogCatSwitchOn) {
            DogCat.INSTANCE.g().c(str).d(map).b(str2).a();
        } else {
            c.e().A(map, str2, str);
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void reportOriginalCustomEvent(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (!TextUtils.isEmpty(d20.d())) {
            map.put("city", d20.d());
        }
        if ("2201".equals(str)) {
            try {
                c.e().C(str4, str3, str2, "1.0", Long.parseLong(str5), map, Integer.parseInt(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            c.e().D(str2, str3, str4, str5, map, Integer.parseInt(str));
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(View view, TrackInfo trackInfo, boolean z) {
        if (trackInfo != null) {
            HashMap<String, String> args = trackInfo.getArgs();
            if (args == null) {
                args = new HashMap<>();
            }
            if (trackInfo.getPabBucket() != null) {
                args.put("PreABTrackInfo", trackInfo.getPabBucket().toJSONString());
            }
            if (trackInfo.getAbBucket() != null) {
                args.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
            }
            if (!TextUtils.isEmpty(d20.d())) {
                args.put("city", d20.d());
            }
            if (this.isUTDogCatSwitchOn) {
                DogCat.INSTANCE.d().m(z).n(trackInfo.getSpmb()).q(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).o(args).j();
                return;
            }
            c.e().x(getUTKeyBuilder(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd(), args, Boolean.valueOf(z)));
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void expose(View view, String str, TrackInfo trackInfo) {
        if (trackInfo != null) {
            if (trackInfo.getArgs() == null) {
                trackInfo.setArgs(new HashMap<>());
            }
            HashMap hashMap = new HashMap(trackInfo.getArgs());
            if (trackInfo.getAbBucket() != null) {
                hashMap.put("ABTrackInfo", trackInfo.getAbBucket().toJSONString());
            }
            if (!TextUtils.isEmpty(d20.d())) {
                hashMap.put("city", d20.d());
            }
            DogCat.INSTANCE.h(view).y(str).q(trackInfo.getSpmb()).v(trackInfo.getSpmb(), trackInfo.getSpmc(), trackInfo.getSpmd()).r(hashMap).k();
        }
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(TrackInfo trackInfo) {
        click(trackInfo, false);
    }

    @Override // com.alient.oneservice.ut.UserTrackProvider
    public void click(TrackInfo trackInfo, boolean z) {
        click(null, trackInfo, z);
    }
}
