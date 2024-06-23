package tb;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import cn.damai.commonbusiness.seatbiz.view.model.DMSVG;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.d;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
public class or extends cn.damai.commonbusiness.seatbiz.view.render.a {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMSVG a;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public float b;

        a() {
        }
    }

    public or(DMSVG dmsvg) {
        this.a = dmsvg;
        c();
        DMSVG dmsvg2 = this.a;
        if (dmsvg2 != null) {
            this.mRegionBounds = dmsvg2.getRegionBounds();
            this.regionLocationList = this.a.getRegionLocationMap();
        }
    }

    private String a() {
        HashMap<String, String> value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743305229")) {
            return (String) ipChange.ipc$dispatch("1743305229", new Object[]{this});
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, HashMap<String, String>> entry : this.rainbowColorMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key) && (value = entry.getValue()) != null) {
                for (Map.Entry<String, String> entry2 : value.entrySet()) {
                    String key2 = entry2.getKey();
                    if (!TextUtils.isEmpty(key2)) {
                        String value2 = entry2.getValue();
                        if (!TextUtils.isEmpty(value2)) {
                            String d = js1.d(key, key2);
                            stringBuffer.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            stringBuffer.append(d);
                            stringBuffer.append("{fill:");
                            stringBuffer.append(value2);
                            stringBuffer.append("!important}");
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    private String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208703237")) {
            return (String) ipChange.ipc$dispatch("1208703237", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.regionColorMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    String c = js1.c(key);
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(c);
                    sb.append("{fill:");
                    sb.append(value);
                    sb.append("!important}");
                }
            }
        }
        return sb.toString();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225748211")) {
            ipChange.ipc$dispatch("-1225748211", new Object[]{this});
            return;
        }
        DMSVG dmsvg = this.a;
        if (!(dmsvg == null || dmsvg.getSVGIds() == null)) {
            for (String str : this.a.getSVGIds()) {
                if (js1.e(str)) {
                    this.isHasFloorId = true;
                    return;
                }
            }
        }
        this.isHasFloorId = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007d  */
    private void d(String str, String str2, String[] strArr, SeatPrice seatPrice, RegionData regionData) {
        HashMap<String, String> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886774931")) {
            ipChange.ipc$dispatch("886774931", new Object[]{this, str, str2, strArr, seatPrice, regionData});
        } else if (strArr != null && strArr.length == 2) {
            String str3 = "";
            strArr[0] = str3;
            strArr[1] = str3;
            if (str != null) {
                String pricePointColor = getPricePointColor(seatPrice, str, regionData);
                boolean z = !TextUtils.isEmpty(pricePointColor);
                HashMap<String, String> hashMap2 = this.regionColorMap;
                if (hashMap2 == null) {
                    HashMap<String, HashMap<String, String>> hashMap3 = this.rainbowColorMap;
                    if (!(hashMap3 == null || str2 == null || (hashMap = hashMap3.get(str)) == null)) {
                        String str4 = hashMap.get(str2);
                        if (!TextUtils.isEmpty(str4)) {
                            if (!z) {
                                str3 = addAlpha2Color(str4);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                    }
                } else if (!z) {
                    String str5 = hashMap2.get(str);
                    if (!TextUtils.isEmpty(str5)) {
                        str3 = addAlpha2Color(str5);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        strArr[0] = str3;
                        if (!z) {
                            strArr[1] = ";fill-opacity:0.2";
                            return;
                        }
                        return;
                    }
                    return;
                }
                str3 = pricePointColor;
                if (!TextUtils.isEmpty(str3)) {
                }
            }
        }
    }

    private void e(int i, a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "271986493")) {
            ipChange.ipc$dispatch("271986493", new Object[]{this, Integer.valueOf(i), aVar});
            return;
        }
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        String hexString = Integer.toHexString(red);
        String hexString2 = Integer.toHexString(green);
        String hexString3 = Integer.toHexString(blue);
        if (alpha < 255) {
            aVar.b = ((float) alpha) / 255.0f;
        } else {
            aVar.b = 1.0f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        if (hexString.length() < 2) {
            hexString = "0" + hexString;
        }
        sb.append(hexString);
        if (hexString2.length() < 2) {
            hexString2 = "0" + hexString2;
        }
        sb.append(hexString2);
        if (hexString3.length() < 2) {
            hexString3 = "0" + hexString3;
        }
        sb.append(hexString3);
        aVar.a = sb.toString();
    }

    private String f(String str) {
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1509128908")) {
            return (String) ipChange.ipc$dispatch("-1509128908", new Object[]{this, str});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : sVGIds) {
            if (js1.f(str2)) {
                stringBuffer.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                stringBuffer.append(str2);
                stringBuffer.append("{fill:");
                stringBuffer.append(str);
                stringBuffer.append(";stroke:");
                stringBuffer.append(str);
                stringBuffer.append("!important}");
            }
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public String addAlpha2Color(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654419959")) {
            return (String) ipChange.ipc$dispatch("-654419959", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            return str + ";fill-opacity:0.2";
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildPicture(boolean z) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121114750")) {
            return (Picture) ipChange.ipc$dispatch("-1121114750", new Object[]{this, Boolean.valueOf(z)});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null) {
            return null;
        }
        dmsvg.resetCss();
        d dVar = new d();
        if (this.regionColorMap != null) {
            str = b();
        } else {
            str = this.rainbowColorMap != null ? a() : "";
        }
        if (z) {
            str = str + f("#E0E0E0");
        }
        if (!TextUtils.isEmpty(str)) {
            dVar.a(str);
        }
        return this.a.renderToPicture(dVar);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildPictureWithColorIntercepter(List<h32> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469856801")) {
            return (Picture) ipChange.ipc$dispatch("1469856801", new Object[]{this, list});
        }
        this.a.resetCss();
        return this.a.renderToPicture(new d());
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildPriceFilterPicture2(SeatPrice seatPrice, RegionData regionData) {
        DMSVG dmsvg;
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "702422050")) {
            return (Picture) ipChange.ipc$dispatch("702422050", new Object[]{this, seatPrice, regionData});
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (seatPrice == null || regionData == null || (dmsvg = this.a) == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        d dVar = new d();
        String[] strArr = new String[2];
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = js1.g(str);
            if (g != null) {
                d(g[0], g[1], strArr, seatPrice, regionData);
                if (!TextUtils.isEmpty(strArr[0])) {
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append("{fill:");
                    sb.append(strArr[0]);
                    sb.append(strArr[1]);
                    sb.append("!important}");
                }
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            dVar.a(sb2);
        }
        Log.d("SVG parse", "-------------------- buildPriceFilterPicture2 prepare cost = " + (System.currentTimeMillis() - currentTimeMillis));
        Picture renderToPicture = this.a.renderToPicture(dVar);
        Log.d("SVG parse", "-------------------- buildPriceFilterPicture2 cost = " + (System.currentTimeMillis() - currentTimeMillis));
        return renderToPicture;
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildRegionPicture(String str, RectF rectF, Path path) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2022756109")) {
            return (Picture) ipChange.ipc$dispatch("2022756109", new Object[]{this, str, rectF, path});
        }
        this.a.resetCss();
        return this.a.renderToPicture(new d());
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildStrokePicture(List<SeatPrice> list, RegionData regionData) {
        DMSVG dmsvg;
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1243447898")) {
            return (Picture) ipChange.ipc$dispatch("-1243447898", new Object[]{this, list, regionData});
        }
        if (list == null || list.isEmpty() || regionData == null || (dmsvg = this.a) == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        d dVar = new d();
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = js1.g(str);
            if (g != null) {
                String str2 = g[0];
                if (!TextUtils.isEmpty(str2) && hasSelectedColor(list, str2, regionData)) {
                    sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    sb.append(str);
                    sb.append("{fill:#00000000;");
                    sb.append("stroke:#FF0000;");
                    sb.append("stroke-width:2.5}");
                    sb.append("!important}");
                }
            }
        }
        dVar.a(sb.toString());
        return this.a.renderToPicture(dVar);
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public int getRegionCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1626430967")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1626430967", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public int getShapeCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1910726718")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1910726718", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.seatbiz.view.render.a
    public Picture buildPicture(@NonNull i32 i32) {
        Set<String> sVGIds;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "746075994")) {
            return (Picture) ipChange.ipc$dispatch("746075994", new Object[]{this, i32});
        }
        DMSVG dmsvg = this.a;
        if (dmsvg == null || (sVGIds = dmsvg.getSVGIds()) == null) {
            return null;
        }
        this.a.resetCss();
        d dVar = new d();
        Shape shape = new Shape();
        a aVar = new a();
        StringBuilder sb = new StringBuilder();
        for (String str : sVGIds) {
            String[] g = js1.g(str);
            if (g != null) {
                String str2 = g[0];
                if (!TextUtils.isEmpty(str2)) {
                    shape.floorId = str2;
                    shape.rowId = g[1];
                    shape.fillColor = 0;
                    shape.strokeColor = 0;
                    i32.b(shape);
                    int[] iArr = i32.a;
                    if (iArr[0] != 0) {
                        e(iArr[0], aVar);
                        if (aVar.b != 1.0f) {
                            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(str);
                            sb.append("{fill:");
                            sb.append(aVar.a);
                            sb.append(";fill-opacity:");
                            sb.append(aVar.b);
                            sb.append(";stroke-opacity:");
                            sb.append(aVar.b);
                            sb.append("!important}");
                        } else {
                            sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                            sb.append(str);
                            sb.append("{fill:");
                            sb.append(aVar.a);
                            sb.append(";fill-opacity:");
                            sb.append(aVar.b);
                            sb.append("!important}");
                        }
                    }
                }
            }
        }
        dVar.a(sb.toString());
        return this.a.renderToPicture(dVar);
    }
}
