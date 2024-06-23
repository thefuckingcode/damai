package tb;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import com.taobao.weex.devtools.inspector.elements.W3CStyleConstants;
import com.youku.live.dsl.danmaku.DanmakuItemBuilder;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.nq0;

/* compiled from: Taobao */
public final class dp0 {
    @NotNull
    public static final dp0 INSTANCE = new dp0();

    private dp0() {
    }

    @Nullable
    public final AlignContent a(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("align-content");
        if (string != null) {
            switch (string.hashCode()) {
                case -1881872635:
                    if (string.equals("stretch")) {
                        return AlignContent.Stretch;
                    }
                    break;
                case -1364013995:
                    if (string.equals("center")) {
                        return AlignContent.Center;
                    }
                    break;
                case -46581362:
                    if (string.equals("flex-start")) {
                        return AlignContent.FlexStart;
                    }
                    break;
                case 441309761:
                    if (string.equals("space-between")) {
                        return AlignContent.SpaceBetween;
                    }
                    break;
                case 1742952711:
                    if (string.equals("flex-end")) {
                        return AlignContent.FlexEnd;
                    }
                    break;
                case 1937124468:
                    if (string.equals("space-around")) {
                        return AlignContent.SpaceAround;
                    }
                    break;
            }
        }
        return null;
    }

    @Nullable
    public final AlignItems b(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("align-items");
        if (string != null) {
            switch (string.hashCode()) {
                case -1881872635:
                    if (string.equals("stretch")) {
                        return AlignItems.Stretch;
                    }
                    break;
                case -1720785339:
                    if (string.equals("baseline")) {
                        return AlignItems.Baseline;
                    }
                    break;
                case -1364013995:
                    if (string.equals("center")) {
                        return AlignItems.Center;
                    }
                    break;
                case -46581362:
                    if (string.equals("flex-start")) {
                        return AlignItems.FlexStart;
                    }
                    break;
                case 1742952711:
                    if (string.equals("flex-end")) {
                        return AlignItems.FlexEnd;
                    }
                    break;
            }
        }
        return null;
    }

    @Nullable
    public final AlignSelf c(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("align-self");
        if (string != null) {
            switch (string.hashCode()) {
                case -1881872635:
                    if (string.equals("stretch")) {
                        return AlignSelf.Stretch;
                    }
                    break;
                case -1720785339:
                    if (string.equals("baseline")) {
                        return AlignSelf.Baseline;
                    }
                    break;
                case -1364013995:
                    if (string.equals("center")) {
                        return AlignSelf.Center;
                    }
                    break;
                case -46581362:
                    if (string.equals("flex-start")) {
                        return AlignSelf.FlexStart;
                    }
                    break;
                case 3005871:
                    if (string.equals("auto")) {
                        return AlignSelf.Auto;
                    }
                    break;
                case 1742952711:
                    if (string.equals("flex-end")) {
                        return AlignSelf.FlexEnd;
                    }
                    break;
            }
        }
        return null;
    }

    @Nullable
    public final Float d(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("aspect-ratio");
        if (string == null) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(string));
        } catch (Exception unused) {
            try {
                if (!(StringsKt__StringsKt.Q(string, ":", false, 2, null))) {
                    return null;
                }
                List list = StringsKt__StringsKt.z0(string, new String[]{":"}, false, 0, 6, null);
                return Float.valueOf(Float.parseFloat((String) list.get(0)) / Float.parseFloat((String) list.get(1)));
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    @Nullable
    public final ox1<m70> e(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("border");
        if (string != null) {
            m70 b = nq0.Companion.d(string).b();
            return new ox1<>(b, b, b, b);
        }
        String string2 = jSONObject.getString("border-left");
        String string3 = jSONObject.getString("border-right");
        String string4 = jSONObject.getString("border-top");
        String string5 = jSONObject.getString("border-bottom");
        boolean z = false;
        if (string2 == null || string2.length() == 0) {
            if (string3 == null || string3.length() == 0) {
                if (string4 == null || string4.length() == 0) {
                    if (string5 == null || string5.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                }
            }
        }
        nq0.b bVar = nq0.Companion;
        if (string2 == null) {
            string2 = "";
        }
        m70 b2 = bVar.d(string2).b();
        if (string3 == null) {
            string3 = "";
        }
        m70 b3 = bVar.d(string3).b();
        if (string4 == null) {
            string4 = "";
        }
        m70 b4 = bVar.d(string4).b();
        if (string5 == null) {
            string5 = "";
        }
        return new ox1<>(b2, b3, b4, bVar.d(string5).b());
    }

    @Nullable
    public final Direction f(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("direction");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != 107498) {
                if (hashCode != 1728122231) {
                    if (hashCode == 1946980603 && string.equals("inherit")) {
                        return Direction.Inherit;
                    }
                } else if (string.equals("absolute")) {
                    return Direction.RTL;
                }
            } else if (string.equals("ltr")) {
                return Direction.LTR;
            }
        }
        return null;
    }

    @Nullable
    public final Display g(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("display");
        if (k21.d(string, Constants.Name.FLEX)) {
            return Display.Flex;
        }
        if (k21.d(string, "none")) {
            return Display.None;
        }
        return null;
    }

    @Nullable
    public final m70 h(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("flex-basis");
        if (string != null) {
            return nq0.Companion.d(string).b();
        }
        return null;
    }

    @Nullable
    public final FlexDirection i(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("flex-direction");
        if (string != null) {
            switch (string.hashCode()) {
                case -1448970769:
                    if (string.equals("row-reverse")) {
                        return FlexDirection.RowReverse;
                    }
                    break;
                case -1354837162:
                    if (string.equals("column")) {
                        return FlexDirection.Column;
                    }
                    break;
                case 113114:
                    if (string.equals(DanmakuItemBuilder.KEY_ROW)) {
                        return FlexDirection.Row;
                    }
                    break;
                case 1272730475:
                    if (string.equals("column-reverse")) {
                        return FlexDirection.ColumnReverse;
                    }
                    break;
            }
        }
        return null;
    }

    @Nullable
    public final Float j(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("flex-grow");
        if (string == null) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    @Nullable
    public final Float k(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("flex-shrink");
        if (string == null) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    @Nullable
    public final FlexWrap l(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("flex-wrap");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1039592053) {
                if (hashCode != -749527969) {
                    if (hashCode == 3657802 && string.equals("wrap")) {
                        return FlexWrap.Wrap;
                    }
                } else if (string.equals("wrap-reverse")) {
                    return FlexWrap.WrapReverse;
                }
            } else if (string.equals("nowrap")) {
                return FlexWrap.NoWrap;
            }
        }
        return null;
    }

    @Nullable
    public final JustifyContent m(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("justify-content");
        if (string != null) {
            switch (string.hashCode()) {
                case -1364013995:
                    if (string.equals("center")) {
                        return JustifyContent.Center;
                    }
                    break;
                case -46581362:
                    if (string.equals("flex-start")) {
                        return JustifyContent.FlexStart;
                    }
                    break;
                case 441309761:
                    if (string.equals("space-between")) {
                        return JustifyContent.SpaceBetween;
                    }
                    break;
                case 1742952711:
                    if (string.equals("flex-end")) {
                        return JustifyContent.FlexEnd;
                    }
                    break;
                case 1937124468:
                    if (string.equals("space-around")) {
                        return JustifyContent.SpaceAround;
                    }
                    break;
                case 2055030478:
                    if (string.equals("space-evenly")) {
                        return JustifyContent.SpaceEvenly;
                    }
                    break;
            }
        }
        return null;
    }

    @Nullable
    public final ox1<m70> n(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.MARGIN);
        if (string == null) {
            String string2 = jSONObject.getString(W3CStyleConstants.MARGIN_LEFT);
            String string3 = jSONObject.getString(W3CStyleConstants.MARGIN_RIGHT);
            String string4 = jSONObject.getString(W3CStyleConstants.MARGIN_TOP);
            String string5 = jSONObject.getString(W3CStyleConstants.MARGIN_BOTTOM);
            boolean z = false;
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        if (string5 == null || string5.length() == 0) {
                            z = true;
                        }
                        if (z) {
                            return null;
                        }
                    }
                }
            }
            nq0.b bVar = nq0.Companion;
            if (string2 == null) {
                string2 = "";
            }
            m70 b = bVar.d(string2).b();
            if (string3 == null) {
                string3 = "";
            }
            m70 b2 = bVar.d(string3).b();
            if (string4 == null) {
                string4 = "";
            }
            m70 b3 = bVar.d(string4).b();
            if (string5 == null) {
                string5 = "";
            }
            return new ox1<>(b, b2, b3, bVar.d(string5).b());
        }
        m70 b4 = nq0.Companion.d(string).b();
        return new ox1<>(b4, b4, b4, b4);
    }

    @Nullable
    public final ob2<m70> o(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("max-width");
        String string2 = jSONObject.getString("max-height");
        if (string != null && string2 != null) {
            nq0.b bVar = nq0.Companion;
            return new ob2<>(bVar.d(string).b(), bVar.d(string2).b());
        } else if (string != null && string2 == null) {
            return new ob2<>(nq0.Companion.d(string).b(), nq0.a.INSTANCE.b());
        } else {
            if (string2 == null || string != null) {
                return null;
            }
            return new ob2<>(nq0.a.INSTANCE.b(), nq0.Companion.d(string2).b());
        }
    }

    @Nullable
    public final ob2<m70> p(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("min-width");
        String string2 = jSONObject.getString("min-height");
        if (string != null && string2 != null) {
            nq0.b bVar = nq0.Companion;
            return new ob2<>(bVar.d(string).b(), bVar.d(string2).b());
        } else if (string != null && string2 == null) {
            return new ob2<>(nq0.Companion.d(string).b(), nq0.a.INSTANCE.b());
        } else {
            if (string2 == null || string != null) {
                return null;
            }
            return new ob2<>(nq0.a.INSTANCE.b(), nq0.Companion.d(string2).b());
        }
    }

    @Nullable
    public final Overflow q(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.OVERFLOW);
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode != -907680051) {
                    if (hashCode == 466743410 && string.equals("visible")) {
                        return Overflow.Visible;
                    }
                } else if (string.equals("scroll")) {
                    return Overflow.Scroll;
                }
            } else if (string.equals("hidden")) {
                return Overflow.Hidden;
            }
        }
        return null;
    }

    @Nullable
    public final ox1<m70> r(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString(Constants.Name.PADDING);
        if (string == null) {
            String string2 = jSONObject.getString(W3CStyleConstants.PADDING_LEFT);
            String string3 = jSONObject.getString(W3CStyleConstants.PADDING_RIGHT);
            String string4 = jSONObject.getString(W3CStyleConstants.PADDING_TOP);
            String string5 = jSONObject.getString(W3CStyleConstants.PADDING_BOTTOM);
            boolean z = false;
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        if (string5 == null || string5.length() == 0) {
                            z = true;
                        }
                        if (z) {
                            return null;
                        }
                    }
                }
            }
            nq0.b bVar = nq0.Companion;
            if (string2 == null) {
                string2 = "";
            }
            m70 b = bVar.d(string2).b();
            if (string3 == null) {
                string3 = "";
            }
            m70 b2 = bVar.d(string3).b();
            if (string4 == null) {
                string4 = "";
            }
            m70 b3 = bVar.d(string4).b();
            if (string5 == null) {
                string5 = "";
            }
            return new ox1<>(b, b2, b3, bVar.d(string5).b());
        }
        m70 b4 = nq0.Companion.d(string).b();
        return new ox1<>(b4, b4, b4, b4);
    }

    @Nullable
    public final ox1<m70> s(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        if (u(jSONObject) != PositionType.Absolute) {
            return null;
        }
        String string = jSONObject.getString("left");
        String string2 = jSONObject.getString("right");
        String string3 = jSONObject.getString("top");
        String string4 = jSONObject.getString("bottom");
        boolean z = false;
        if (string == null || string.length() == 0) {
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                }
            }
        }
        nq0.b bVar = nq0.Companion;
        if (string == null) {
            string = "";
        }
        m70 b = bVar.d(string).b();
        if (string2 == null) {
            string2 = "";
        }
        m70 b2 = bVar.d(string2).b();
        if (string3 == null) {
            string3 = "";
        }
        m70 b3 = bVar.d(string3).b();
        if (string4 == null) {
            string4 = "";
        }
        return new ox1<>(b, b2, b3, bVar.d(string4).b());
    }

    @Nullable
    public final ox1<m70> t(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("left");
        String string2 = jSONObject.getString("right");
        String string3 = jSONObject.getString("top");
        String string4 = jSONObject.getString("bottom");
        boolean z = false;
        if (string == null || string.length() == 0) {
            if (string2 == null || string2.length() == 0) {
                if (string3 == null || string3.length() == 0) {
                    if (string4 == null || string4.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                }
            }
        }
        nq0.b bVar = nq0.Companion;
        if (string == null) {
            string = "";
        }
        m70 b = bVar.d(string).b();
        if (string2 == null) {
            string2 = "";
        }
        m70 b2 = bVar.d(string2).b();
        if (string3 == null) {
            string3 = "";
        }
        m70 b3 = bVar.d(string3).b();
        if (string4 == null) {
            string4 = "";
        }
        return new ox1<>(b, b2, b3, bVar.d(string4).b());
    }

    @Nullable
    public final PositionType u(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("position");
        if (k21.d(string, "relative")) {
            return PositionType.Relative;
        }
        if (k21.d(string, "absolute")) {
            return PositionType.Absolute;
        }
        return null;
    }

    @Nullable
    public final ob2<m70> v(@NotNull JSONObject jSONObject) {
        k21.i(jSONObject, "cssJson");
        String string = jSONObject.getString("width");
        String string2 = jSONObject.getString("height");
        if (string != null && string2 != null) {
            nq0.b bVar = nq0.Companion;
            return new ob2<>(bVar.d(string).b(), bVar.d(string2).b());
        } else if (string != null && string2 == null) {
            return new ob2<>(nq0.Companion.d(string).b(), nq0.a.INSTANCE.b());
        } else {
            if (string2 == null || string != null) {
                return null;
            }
            return new ob2<>(nq0.a.INSTANCE.b(), nq0.Companion.d(string2).b());
        }
    }
}
