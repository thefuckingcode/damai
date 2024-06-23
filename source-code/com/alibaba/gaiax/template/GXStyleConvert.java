package com.alibaba.gaiax.template;

import android.content.res.AssetManager;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.taobao.weex.utils.TypefaceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.m;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ao0;
import tb.ip0;
import tb.jl1;
import tb.jo0;
import tb.jp0;
import tb.jq0;
import tb.k21;
import tb.ko0;
import tb.m40;
import tb.nq0;
import tb.ox1;
import tb.tp0;

/* compiled from: Taobao */
public final class GXStyleConvert {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXStyleConvert> a = kotlin.b.b(GXStyleConvert$Companion$instance$2.INSTANCE);

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final GXStyleConvert a() {
            return (GXStyleConvert) GXStyleConvert.a.getValue();
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            iArr[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 2;
            iArr[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 3;
            iArr[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 4;
            iArr[GradientDrawable.Orientation.TL_BR.ordinal()] = 5;
            iArr[GradientDrawable.Orientation.TR_BL.ordinal()] = 6;
            iArr[GradientDrawable.Orientation.BR_TL.ordinal()] = 7;
            iArr[GradientDrawable.Orientation.BL_TR.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public final tp0 A(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        if (!jSONObject.containsKey("mode")) {
            return null;
        }
        String string = jSONObject.getString("mode");
        if (string == null) {
            string = "scaleToFill";
        }
        String string2 = jSONObject.getString("mode-type");
        if (string2 == null) {
            string2 = "scale";
        }
        return new tp0(string2, string);
    }

    @Nullable
    public final Float B(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("opacity");
        if (string == null) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    @Nullable
    public final Boolean C(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString(Constants.Name.OVERFLOW);
        if (k21.d(string, "visible")) {
            return Boolean.FALSE;
        }
        if (k21.d(string, "hidden")) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Nullable
    public final ox1<nq0> D(@NotNull JSONObject jSONObject) {
        ox1<nq0> ox1;
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.PADDING);
        if (string == null) {
            ox1 = null;
        } else {
            nq0 d = nq0.Companion.d(string);
            ox1 = new ox1<>(d, d, d, d);
        }
        String string2 = jSONObject.getString(W3CStyleConstants.PADDING_LEFT);
        if (string2 != null) {
            if (ox1 == null) {
                nq0.f fVar = nq0.f.INSTANCE;
                ox1 = new ox1<>(fVar, fVar, fVar, fVar);
            }
            ox1.g(nq0.Companion.d(string2));
        }
        String string3 = jSONObject.getString(W3CStyleConstants.PADDING_RIGHT);
        if (string3 != null) {
            if (ox1 == null) {
                nq0.f fVar2 = nq0.f.INSTANCE;
                ox1 = new ox1<>(fVar2, fVar2, fVar2, fVar2);
            }
            ox1.f(nq0.Companion.d(string3));
        }
        String string4 = jSONObject.getString(W3CStyleConstants.PADDING_TOP);
        if (string4 != null) {
            if (ox1 == null) {
                nq0.f fVar3 = nq0.f.INSTANCE;
                ox1 = new ox1<>(fVar3, fVar3, fVar3, fVar3);
            }
            ox1.h(nq0.Companion.d(string4));
        }
        String string5 = jSONObject.getString(W3CStyleConstants.PADDING_BOTTOM);
        if (string5 != null) {
            if (ox1 == null) {
                nq0.f fVar4 = nq0.f.INSTANCE;
                ox1 = new ox1<>(fVar4, fVar4, fVar4, fVar4);
            }
            ox1.e(nq0.Companion.d(string5));
        }
        return ox1;
    }

    public final void E(@NotNull AssetManager assetManager) {
        k21.i(assetManager, "<set-?>");
    }

    @Nullable
    public final Integer F(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("text-decoration");
        if (k21.d(string, "line-through")) {
            return 16;
        }
        return k21.d(string, "underline") ? 8 : null;
    }

    @Nullable
    public final ao0 b(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("backdrop-filter");
        if (string == null) {
            return null;
        }
        return ao0.Companion.a(string);
    }

    @Nullable
    public final ko0 c(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("background-color");
        if (string == null) {
            return null;
        }
        return ko0.Companion.a(string);
    }

    @Nullable
    public final ip0 d(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("background-image");
        if (string == null) {
            return null;
        }
        if (o.L(string, "linear-gradient", false, 2, null)) {
            List<String> w = w(string);
            return new ip0(v(w), x(w));
        }
        ko0 a2 = ko0.Companion.a(string);
        if (a2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        return new ip0(GradientDrawable.Orientation.LEFT_RIGHT, arrayList);
    }

    @Nullable
    public final ko0 e(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("border-color");
        if (string == null) {
            return null;
        }
        return ko0.Companion.a(string);
    }

    @Nullable
    public final jq0 f(@NotNull JSONObject jSONObject) {
        jq0 jq0;
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("border-radius");
        if (string == null) {
            jq0 = null;
        } else {
            nq0 d = nq0.Companion.d(string);
            jq0 = new jq0(d, d, d, d);
        }
        String string2 = jSONObject.getString("border-top-left-radius");
        if (string2 != null) {
            if (jq0 == null) {
                jq0 = new jq0(null, null, null, null);
            }
            jq0.h(nq0.Companion.d(string2));
        }
        String string3 = jSONObject.getString("border-top-right-radius");
        if (string3 != null) {
            if (jq0 == null) {
                jq0 = new jq0(null, null, null, null);
            }
            jq0.i(nq0.Companion.d(string3));
        }
        String string4 = jSONObject.getString("border-bottom-left-radius");
        if (string4 != null) {
            if (jq0 == null) {
                jq0 = new jq0(null, null, null, null);
            }
            jq0.f(nq0.Companion.d(string4));
        }
        String string5 = jSONObject.getString("border-bottom-right-radius");
        if (string5 != null) {
            if (jq0 == null) {
                jq0 = new jq0(null, null, null, null);
            }
            jq0.g(nq0.Companion.d(string5));
        }
        return jq0;
    }

    @Nullable
    public final nq0 g(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("border-width");
        if (string == null) {
            return null;
        }
        return nq0.Companion.d(string);
    }

    @Nullable
    public final jo0 h(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("box-shadow");
        if (string == null) {
            return null;
        }
        List list = StringsKt__StringsKt.z0(string, new String[]{" "}, false, 0, 6, null);
        if (list.size() != 5) {
            return null;
        }
        nq0.b bVar = nq0.Companion;
        nq0 d = bVar.d((String) list.get(0));
        nq0 d2 = bVar.d((String) list.get(1));
        nq0 d3 = bVar.d((String) list.get(2));
        nq0 d4 = bVar.d((String) list.get(3));
        ko0.a aVar = ko0.Companion;
        ko0 a2 = aVar.a((String) list.get(4));
        if (a2 == null) {
            a2 = aVar.c();
        }
        return new jo0(d, d2, d3, d4, a2);
    }

    @Nullable
    public final Shader i(float f, float f2, @NotNull GradientDrawable.Orientation orientation, @NotNull int[] iArr) {
        k21.i(orientation, "direction");
        k21.i(iArr, "colors");
        switch (b.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
                return new jp0(0.0f, 0.0f, 0.0f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 2:
                return new jp0(0.0f, f2, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 3:
                return new jp0(0.0f, 0.0f, f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 4:
                return new jp0(f, 0.0f, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 5:
                return new jp0(0.0f, 0.0f, f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 6:
                return new jp0(f, 0.0f, 0.0f, f2, iArr, null, Shader.TileMode.CLAMP);
            case 7:
                return new jp0(f, f2, 0.0f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            case 8:
                return new jp0(0.0f, f2, f, 0.0f, iArr, null, Shader.TileMode.CLAMP);
            default:
                return null;
        }
    }

    @Nullable
    public final Integer j(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("display");
        if (k21.d(string, "none")) {
            return 8;
        }
        return k21.d(string, Constants.Name.FLEX) ? 0 : null;
    }

    @Nullable
    public final Boolean k(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        Boolean bool = jSONObject.getBoolean("fit-content");
        if (bool != null) {
            return bool;
        }
        return null;
    }

    @Nullable
    public final nq0 l(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("font-size");
        if (string == null) {
            return null;
        }
        return nq0.Companion.d(string);
    }

    @Nullable
    public final ko0 m(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("color");
        if (string == null) {
            return null;
        }
        return ko0.Companion.a(string);
    }

    @Nullable
    public final Typeface n(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString(TypefaceUtil.FONT_CACHE_DIR_NAME);
        if (string == null) {
            return null;
        }
        return o(string);
    }

    @Nullable
    public final Typeface o(@NotNull String str) {
        Object convert;
        k21.i(str, Constants.Name.FONT_FAMILY);
        GXRegisterCenter.GXIExtensionStaticProperty p = GXRegisterCenter.Companion.a().p();
        if (!(p == null || (convert = p.convert(new GXRegisterCenter.GXIExtensionStaticProperty.a(TypefaceUtil.FONT_CACHE_DIR_NAME, str))) == null)) {
            Typeface typeface = convert instanceof Typeface ? (Typeface) convert : null;
            if (typeface == null) {
                return null;
            }
            return typeface;
        }
        return null;
    }

    @Nullable
    public final nq0 p(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("line-height");
        if (string == null) {
            return null;
        }
        return nq0.Companion.d(string);
    }

    @Nullable
    public final Integer q(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString(Constants.Name.LINES);
        if (string == null) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(string));
    }

    @Nullable
    public final Integer r(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("text-align");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 3317767) {
                    if (hashCode == 108511772 && string.equals("right")) {
                        return 5;
                    }
                } else if (string.equals("left")) {
                    return 3;
                }
            } else if (string.equals("center")) {
                return 17;
            }
        }
        return null;
    }

    @Nullable
    public final TextUtils.TruncateAt s(@NotNull JSONObject jSONObject) {
        Object convert;
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("text-overflow");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1074341483) {
                if (hashCode != 3056464) {
                    if (hashCode == 188702929 && string.equals(Constants.Name.ELLIPSIS)) {
                        return TextUtils.TruncateAt.END;
                    }
                } else if (string.equals("clip")) {
                    GXRegisterCenter.GXIExtensionStaticProperty p = GXRegisterCenter.Companion.a().p();
                    if (p == null || (convert = p.convert(new GXRegisterCenter.GXIExtensionStaticProperty.a("text-overflow", "clip"))) == null) {
                        return null;
                    }
                    return (TextUtils.TruncateAt) convert;
                }
            } else if (string.equals("middle")) {
                return TextUtils.TruncateAt.MIDDLE;
            }
        }
        return TextUtils.TruncateAt.END;
    }

    @Nullable
    public final Typeface t(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("font-weight");
        if (string == null) {
            return null;
        }
        return u(string);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r2.equals("500") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r2.equals("400") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if (r2.equals("300") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r2.equals("200") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r2.equals(org.android.agoo.message.MessageService.MSG_DB_COMPLETE) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r2.equals("normal") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r2.equals(tb.av.PARAM_LEVEL_MEDIUM) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return android.graphics.Typeface.DEFAULT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return android.graphics.Typeface.DEFAULT_BOLD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r2.equals(com.taobao.weex.common.Constants.Value.BOLD) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r2.equals("700") == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r2.equals("600") == false) goto L_0x006a;
     */
    @Nullable
    public final Typeface u(@Nullable String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1078030475:
                    break;
                case -1039745817:
                    break;
                case 48625:
                    break;
                case 49586:
                    break;
                case 50547:
                    break;
                case 51508:
                    break;
                case 52469:
                    break;
                case 53430:
                    break;
                case 54391:
                    break;
                case 3029637:
                    break;
            }
        }
        return null;
    }

    @NotNull
    public final GradientDrawable.Orientation v(@NotNull List<String> list) {
        k21.i(list, "linear");
        if (!(!list.isEmpty())) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        String str = list.get(0);
        switch (str.hashCode()) {
            case -2080783504:
                if (str.equals("to bottom")) {
                    return GradientDrawable.Orientation.TOP_BOTTOM;
                }
                break;
            case -1849920841:
                if (str.equals("to bottom left")) {
                    return GradientDrawable.Orientation.TR_BL;
                }
                break;
            case -1507310228:
                if (str.equals("to bottom right")) {
                    return GradientDrawable.Orientation.TL_BR;
                }
                break;
            case -1486250643:
                if (str.equals("tobottomleft")) {
                    return GradientDrawable.Orientation.TR_BL;
                }
                break;
            case -1359525897:
                if (str.equals("to top left")) {
                    return GradientDrawable.Orientation.BR_TL;
                }
                break;
            case -1352032154:
                if (str.equals("tobottom")) {
                    return GradientDrawable.Orientation.TOP_BOTTOM;
                }
                break;
            case -1213049204:
                if (str.equals("to left")) {
                    return GradientDrawable.Orientation.RIGHT_LEFT;
                }
                break;
            case -1137407871:
                if (str.equals("toright")) {
                    return GradientDrawable.Orientation.LEFT_RIGHT;
                }
                break;
            case -1033506462:
                if (str.equals("totopright")) {
                    return GradientDrawable.Orientation.BL_TR;
                }
                break;
            case -870406608:
                if (str.equals("to top")) {
                    return GradientDrawable.Orientation.BOTTOM_TOP;
                }
                break;
            case -868157182:
                if (str.equals("toleft")) {
                    return GradientDrawable.Orientation.RIGHT_LEFT;
                }
                break;
            case -172068863:
                if (str.equals("totopleft")) {
                    return GradientDrawable.Orientation.BR_TL;
                }
                break;
            case 110550266:
                if (str.equals("totop")) {
                    return GradientDrawable.Orientation.BOTTOM_TOP;
                }
                break;
            case 810031148:
                if (str.equals("to top right")) {
                    return GradientDrawable.Orientation.BL_TR;
                }
                break;
            case 1055841335:
                if (str.equals("to right")) {
                    return GradientDrawable.Orientation.LEFT_RIGHT;
                }
                break;
            case 1176531318:
                if (str.equals("tobottomright")) {
                    return GradientDrawable.Orientation.TL_BR;
                }
                break;
        }
        return GradientDrawable.Orientation.TOP_BOTTOM;
    }

    @NotNull
    public final List<String> w(@NotNull String str) {
        k21.i(str, "linear");
        ArrayList arrayList = new ArrayList();
        try {
            String substring = str.substring(StringsKt__StringsKt.f0(str, jl1.BRACKET_START_STR, 0, false, 6, null) + 1, StringsKt__StringsKt.l0(str, jl1.BRACKET_END_STR, 0, false, 6, null));
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (StringsKt__StringsKt.Q(substring, "rgba", false, 2, null)) {
                int i = 0;
                for (Object obj : StringsKt__StringsKt.z0(substring, new String[]{"rgba"}, false, 0, 6, null)) {
                    int i2 = i + 1;
                    if (i < 0) {
                        m.p();
                    }
                    String str2 = (String) obj;
                    if (str2 != null) {
                        String obj2 = StringsKt__StringsKt.T0(str2).toString();
                        if (o.v(obj2, ",", false, 2, null)) {
                            obj2 = obj2.substring(0, obj2.length() - 1);
                            k21.h(obj2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        if (i > 0) {
                            arrayList.add(k21.r("rgba", obj2));
                        } else {
                            arrayList.add(obj2);
                        }
                        i = i2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            } else if (StringsKt__StringsKt.Q(substring, "rgb", false, 2, null)) {
                int i3 = 0;
                for (Object obj3 : StringsKt__StringsKt.z0(substring, new String[]{"rgb"}, false, 0, 6, null)) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        m.p();
                    }
                    String str3 = (String) obj3;
                    if (str3 != null) {
                        String obj4 = StringsKt__StringsKt.T0(str3).toString();
                        if (o.v(obj4, ",", false, 2, null)) {
                            obj4 = obj4.substring(0, obj4.length() - 1);
                            k21.h(obj4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        if (i3 > 0) {
                            arrayList.add(k21.r("rgb", obj4));
                        } else {
                            arrayList.add(obj4);
                        }
                        i3 = i4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            } else {
                for (String str4 : StringsKt__StringsKt.z0(substring, new String[]{","}, false, 0, 6, null)) {
                    if (str4 != null) {
                        arrayList.add(StringsKt__StringsKt.T0(str4).toString());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @NotNull
    public final List<ko0> x(@NotNull List<String> list) {
        k21.i(list, "linear");
        ArrayList<String> arrayList = new ArrayList();
        for (T t : list) {
            if (!(o.L(t, "to", false, 2, null))) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            ko0 a2 = ko0.Companion.a(str);
            if (a2 != null) {
                arrayList2.add(a2);
            } else {
                throw new IllegalArgumentException("linearColor create color error");
            }
        }
        return arrayList2;
    }

    @Nullable
    public final Integer y(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "css");
        String string = jSONObject.getString("hidden");
        if (k21.d(string, "true")) {
            return 4;
        }
        return k21.d(string, "false") ? 0 : null;
    }

    public final void z(@NotNull AssetManager assetManager) {
        k21.i(assetManager, "assetManager");
        E(assetManager);
    }
}
