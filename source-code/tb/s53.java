package tb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.district.DistrictSearchQuery;
import com.loc.ei;
import com.loc.eo;
import com.loc.j1;
import com.loc.l;
import com.loc.l1;
import com.loc.m1;
import com.tencent.open.SocialConstants;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class s53 {
    private StringBuilder a = new StringBuilder();
    private AMapLocationClientOption b = new AMapLocationClientOption();

    private void e(eo eoVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            g(str, str2, sb);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            h(str7, str6, sb, eoVar);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", eoVar.getCityCode());
        bundle.putString(SocialConstants.PARAM_APP_DESC, sb.toString());
        bundle.putString("adcode", eoVar.getAdCode());
        eoVar.setExtras(bundle);
        eoVar.g(sb.toString());
        String adCode = eoVar.getAdCode();
        eoVar.setAddress((adCode == null || adCode.trim().length() <= 0 || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) ? sb.toString() : sb.toString().replace(" ", ""));
    }

    private static void f(eo eoVar, short s) {
        if (!"-1".equals(eoVar.d())) {
            if (s == -1) {
                s = 0;
            } else if (s == 0) {
                s = -1;
            }
            eoVar.setConScenario(s);
            return;
        }
        if (s == 101) {
            s = 100;
        }
        eoVar.setConScenario(s);
    }

    private void g(String str, String str2, StringBuilder sb) {
        if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            if (!str2.equals(str)) {
                sb.append(str2);
                sb.append(" ");
            }
        } else if (!str.contains("市") || !str.equals(str2)) {
            sb.append(str2);
            sb.append(" ");
        }
    }

    private void h(String str, String str2, StringBuilder sb, eo eoVar) {
        String concat;
        if (TextUtils.isEmpty(str) || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("Near ".concat(String.valueOf(str2)));
            concat = "Near ".concat(String.valueOf(str2));
        } else {
            sb.append("靠近");
            sb.append(str2);
            sb.append(" ");
            concat = "在" + str2 + "附近";
        }
        eoVar.setDescription(concat);
    }

    private static String i(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x028b A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0297  */
    public final eo a(eo eoVar, byte[] bArr, ei eiVar) {
        String str;
        ByteBuffer byteBuffer;
        Throwable th;
        ByteBuffer byteBuffer2;
        String str2;
        byte b2;
        ByteBuffer byteBuffer3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        eo eoVar2 = eoVar;
        if (bArr == null) {
            try {
                eoVar2.setErrorCode(5);
                eiVar.f("#0504");
                this.a.append("binaryResult is null#0504");
                eoVar2.setLocationDetail(this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                return eoVar2;
            } catch (Throwable th2) {
                th = th2;
                str = "";
                byteBuffer = null;
                try {
                    eo eoVar3 = new eo(str);
                    eoVar3.setErrorCode(5);
                    eiVar.f("#0505");
                    StringBuilder sb2 = this.a;
                    sb2.append("parser data error:" + th.getMessage() + "#0505");
                    l1.p(null, 2054);
                    eoVar3.setLocationDetail(this.a.toString());
                    eoVar2 = eoVar3;
                    if (this.a.length() > 0) {
                    }
                    return eoVar2;
                } finally {
                    if (byteBuffer != null) {
                        byteBuffer.clear();
                    }
                }
            }
        } else {
            byteBuffer = ByteBuffer.wrap(bArr);
            try {
                if (byteBuffer.get() == 0) {
                    try {
                        eoVar2.b(String.valueOf((int) byteBuffer.getShort()));
                        byteBuffer.clear();
                        byteBuffer.clear();
                        return eoVar2;
                    } catch (Throwable th3) {
                        th = th3;
                        str = "";
                        eo eoVar32 = new eo(str);
                        eoVar32.setErrorCode(5);
                        eiVar.f("#0505");
                        StringBuilder sb22 = this.a;
                        sb22.append("parser data error:" + th.getMessage() + "#0505");
                        l1.p(null, 2054);
                        eoVar32.setLocationDetail(this.a.toString());
                        eoVar2 = eoVar32;
                        if (this.a.length() > 0) {
                        }
                        return eoVar2;
                    }
                } else {
                    eoVar2.setLongitude(m1.a(((double) byteBuffer.getInt()) / 1000000.0d));
                    eoVar2.setLatitude(m1.a(((double) byteBuffer.getInt()) / 1000000.0d));
                    eoVar2.setAccuracy((float) byteBuffer.getShort());
                    eoVar2.c(String.valueOf((int) byteBuffer.get()));
                    eoVar2.d(String.valueOf((int) byteBuffer.get()));
                    if (byteBuffer.get() == 1) {
                        try {
                            byte[] bArr2 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr2);
                            try {
                                eoVar2.setCountry(new String(bArr2, "UTF-8"));
                            } catch (Throwable unused) {
                            }
                            byte[] bArr3 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr3);
                            try {
                                str3 = new String(bArr3, "UTF-8");
                                try {
                                    eoVar2.setProvince(str3);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable unused3) {
                                str3 = "";
                            }
                            byte[] bArr4 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr4);
                            try {
                                str4 = new String(bArr4, "UTF-8");
                                try {
                                    eoVar2.setCity(str4);
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                                str4 = "";
                            }
                            byte[] bArr5 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr5);
                            try {
                                str5 = new String(bArr5, "UTF-8");
                                try {
                                    eoVar2.setDistrict(str5);
                                } catch (Throwable unused6) {
                                }
                            } catch (Throwable unused7) {
                                str5 = "";
                            }
                            byte[] bArr6 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr6);
                            try {
                                str6 = new String(bArr6, "UTF-8");
                                try {
                                    eoVar2.setStreet(str6);
                                    eoVar2.setRoad(str6);
                                } catch (Throwable unused8) {
                                }
                            } catch (Throwable unused9) {
                                str6 = "";
                            }
                            byte[] bArr7 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr7);
                            try {
                                str7 = new String(bArr7, "UTF-8");
                                try {
                                    eoVar2.setNumber(str7);
                                } catch (Throwable unused10) {
                                }
                            } catch (Throwable unused11) {
                                str7 = "";
                            }
                            byte[] bArr8 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr8);
                            try {
                                str8 = new String(bArr8, "UTF-8");
                                try {
                                    eoVar2.setPoiName(str8);
                                } catch (Throwable unused12) {
                                }
                            } catch (Throwable unused13) {
                                str8 = "";
                            }
                            byte[] bArr9 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr9);
                            try {
                                eoVar2.setAoiName(new String(bArr9, "UTF-8"));
                            } catch (Throwable unused14) {
                            }
                            byte[] bArr10 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr10);
                            try {
                                str9 = new String(bArr10, "UTF-8");
                                try {
                                    eoVar2.setAdCode(str9);
                                } catch (Throwable unused15) {
                                }
                            } catch (Throwable unused16) {
                                str9 = "";
                            }
                            byte[] bArr11 = new byte[(byteBuffer.get() & 255)];
                            byteBuffer.get(bArr11);
                            try {
                                eoVar2.setCityCode(new String(bArr11, "UTF-8"));
                            } catch (Throwable unused17) {
                            }
                            str2 = "UTF-8";
                            b2 = 1;
                            byteBuffer2 = byteBuffer;
                            str = "";
                            try {
                                e(eoVar, str3, str4, str5, str6, str7, str8, str9);
                            } catch (Throwable th4) {
                                th = th4;
                                byteBuffer = byteBuffer2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str = "";
                            eo eoVar322 = new eo(str);
                            eoVar322.setErrorCode(5);
                            eiVar.f("#0505");
                            StringBuilder sb222 = this.a;
                            sb222.append("parser data error:" + th.getMessage() + "#0505");
                            l1.p(null, 2054);
                            eoVar322.setLocationDetail(this.a.toString());
                            eoVar2 = eoVar322;
                            if (this.a.length() > 0) {
                            }
                            return eoVar2;
                        }
                    } else {
                        str2 = "UTF-8";
                        byteBuffer2 = byteBuffer;
                        str = "";
                        b2 = 1;
                    }
                    try {
                        byteBuffer3 = byteBuffer2;
                        try {
                            byteBuffer3.get(new byte[(byteBuffer2.get() & 255)]);
                            if (byteBuffer3.get() == b2) {
                                byteBuffer3.getInt();
                                byteBuffer3.getInt();
                                byteBuffer3.getShort();
                            }
                            if (byteBuffer3.get() == b2) {
                                byte[] bArr12 = new byte[(byteBuffer3.get() & 255)];
                                byteBuffer3.get(bArr12);
                                try {
                                    eoVar2.setBuildingId(new String(bArr12, str2));
                                } catch (Throwable unused18) {
                                }
                                byte[] bArr13 = new byte[(byteBuffer3.get() & 255)];
                                byteBuffer3.get(bArr13);
                                try {
                                    eoVar2.setFloor(new String(bArr13, str2));
                                } catch (Throwable unused19) {
                                }
                            }
                            if (byteBuffer3.get() == b2) {
                                byteBuffer3.get();
                                byteBuffer3.getInt();
                                byteBuffer3.get();
                            }
                            if (byteBuffer3.get() == b2) {
                                eoVar2.setTime(byteBuffer3.getLong());
                            }
                            int i = byteBuffer3.getShort();
                            if (i > 0) {
                                byte[] bArr14 = new byte[i];
                                byteBuffer3.get(bArr14);
                                if (i > 0) {
                                    try {
                                        eoVar2.a(new String(Base64.decode(bArr14, 0), str2));
                                    } catch (Throwable unused20) {
                                    }
                                }
                            }
                            int i2 = byteBuffer3.getShort();
                            if (i2 > 0) {
                                byteBuffer3.get(new byte[i2]);
                            }
                            if (Double.valueOf(j1.a).doubleValue() >= 5.1d) {
                                f(eoVar2, byteBuffer3.getShort());
                                eoVar2.a(byteBuffer3.get());
                            }
                            byteBuffer3.clear();
                        } catch (Throwable th6) {
                            th = th6;
                            byteBuffer = byteBuffer3;
                            eo eoVar3222 = new eo(str);
                            eoVar3222.setErrorCode(5);
                            eiVar.f("#0505");
                            StringBuilder sb2222 = this.a;
                            sb2222.append("parser data error:" + th.getMessage() + "#0505");
                            l1.p(null, 2054);
                            eoVar3222.setLocationDetail(this.a.toString());
                            eoVar2 = eoVar3222;
                            if (this.a.length() > 0) {
                            }
                            return eoVar2;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        byteBuffer3 = byteBuffer2;
                        byteBuffer = byteBuffer3;
                        eo eoVar32222 = new eo(str);
                        eoVar32222.setErrorCode(5);
                        eiVar.f("#0505");
                        StringBuilder sb22222 = this.a;
                        sb22222.append("parser data error:" + th.getMessage() + "#0505");
                        l1.p(null, 2054);
                        eoVar32222.setLocationDetail(this.a.toString());
                        eoVar2 = eoVar32222;
                        if (this.a.length() > 0) {
                        }
                        return eoVar2;
                    }
                    if (this.a.length() > 0) {
                        StringBuilder sb3 = this.a;
                        sb3.delete(0, sb3.length());
                    }
                    return eoVar2;
                }
            } catch (Throwable th8) {
                th = th8;
                str = "";
                eo eoVar322222 = new eo(str);
                eoVar322222.setErrorCode(5);
                eiVar.f("#0505");
                StringBuilder sb222222 = this.a;
                sb222222.append("parser data error:" + th.getMessage() + "#0505");
                l1.p(null, 2054);
                eoVar322222.setLocationDetail(this.a.toString());
                eoVar2 = eoVar322222;
                if (this.a.length() > 0) {
                }
                return eoVar2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081 A[Catch:{ all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ef  */
    public final eo b(String str) {
        JSONArray optJSONArray;
        String str2;
        JSONArray optJSONArray2;
        try {
            eo eoVar = new eo("");
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            eoVar.setCountry(i(optJSONObject2.optString(DistrictSearchQuery.KEYWORDS_COUNTRY)));
            String i = i(optJSONObject2.optString(DistrictSearchQuery.KEYWORDS_PROVINCE));
            eoVar.setProvince(i);
            String i2 = i(optJSONObject2.optString("citycode"));
            eoVar.setCityCode(i2);
            String optString = optJSONObject2.optString("city");
            if (!i2.endsWith("010") && !i2.endsWith("021") && !i2.endsWith("022")) {
                if (!i2.endsWith("023")) {
                    optString = i(optString);
                    eoVar.setCity(optString);
                    if (TextUtils.isEmpty(optString)) {
                        eoVar.setCity(i);
                        optString = i;
                    }
                    String i3 = i(optJSONObject2.optString(DistrictSearchQuery.KEYWORDS_DISTRICT));
                    eoVar.setDistrict(i3);
                    String i4 = i(optJSONObject2.optString("adcode"));
                    eoVar.setAdCode(i4);
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
                    String i5 = i(optJSONObject3.optString("street"));
                    eoVar.setStreet(i5);
                    eoVar.setRoad(i5);
                    String i6 = i(optJSONObject3.optString("number"));
                    eoVar.setNumber(i6);
                    optJSONArray = optJSONObject.optJSONArray("pois");
                    if (optJSONArray.length() <= 0) {
                        String i7 = i(optJSONArray.getJSONObject(0).optString("name"));
                        eoVar.setPoiName(i7);
                        str2 = i7;
                    } else {
                        str2 = null;
                    }
                    optJSONArray2 = optJSONObject.optJSONArray("aois");
                    if (optJSONArray2.length() > 0) {
                        eoVar.setAoiName(i(optJSONArray2.getJSONObject(0).optString("name")));
                    }
                    e(eoVar, i, optString, i3, i5, i6, str2, i4);
                    return eoVar;
                }
            }
            if (i != null && i.length() > 0) {
                eoVar.setCity(i);
                optString = i;
            }
            if (TextUtils.isEmpty(optString)) {
            }
            String i32 = i(optJSONObject2.optString(DistrictSearchQuery.KEYWORDS_DISTRICT));
            eoVar.setDistrict(i32);
            String i42 = i(optJSONObject2.optString("adcode"));
            eoVar.setAdCode(i42);
            JSONObject optJSONObject32 = optJSONObject2.optJSONObject("streetNumber");
            String i52 = i(optJSONObject32.optString("street"));
            eoVar.setStreet(i52);
            eoVar.setRoad(i52);
            String i62 = i(optJSONObject32.optString("number"));
            eoVar.setNumber(i62);
            optJSONArray = optJSONObject.optJSONArray("pois");
            if (optJSONArray.length() <= 0) {
            }
            optJSONArray2 = optJSONObject.optJSONArray("aois");
            if (optJSONArray2.length() > 0) {
            }
            e(eoVar, i, optString, i32, i52, i62, str2, i42);
            return eoVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00dd  */
    public final eo c(String str, Context context, q23 q23, ei eiVar) {
        eo eoVar = new eo("");
        eoVar.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#SHA1AndPackage#");
        stringBuffer.append(l.i(context));
        String str2 = q23.b.get("gsid").get(0);
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("#gsid#");
            stringBuffer.append(str2);
        }
        String str3 = q23.c;
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("#csid#".concat(String.valueOf(str3)));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                eiVar.f("#0702");
                StringBuilder sb = this.a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                eiVar.f("#0701");
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                l1.r(q23.d, string3, string2);
            }
        } catch (Throwable th) {
            eiVar.f("#0703");
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            j1.h(th, "parser", "paseAuthFailurJson");
        }
        eoVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            StringBuilder sb4 = this.a;
            sb4.delete(0, sb4.length());
        }
        return eoVar;
    }

    public final void d(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }
}
