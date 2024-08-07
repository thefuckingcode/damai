package app.visly.stretch;

import androidx.annotation.Keep;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.weex.common.Constants;
import com.uc.webview.export.extension.UCCore;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.k21;
import tb.m40;
import tb.m70;
import tb.ob2;
import tb.ox1;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b4\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\bb\b\b\u0018\u0000 Ø\u00012\u00020\u0001:\u0002Ù\u0001B\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020I\u0012\b\b\u0002\u0010\b\u001a\u00020K\u0012\b\b\u0002\u0010\t\u001a\u00020M\u0012\b\b\u0002\u0010\n\u001a\u00020O\u0012\b\b\u0002\u0010\u000b\u001a\u00020Q\u0012\b\b\u0002\u0010\f\u001a\u00020S\u0012\b\b\u0002\u0010\r\u001a\u00020U\u0012\b\b\u0002\u0010\u000e\u001a\u00020W\u0012\b\b\u0002\u0010\u000f\u001a\u00020Y\u0012\b\b\u0002\u0010\u0010\u001a\u00020[\u0012\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020^0]\u0012\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u00020^0]\u0012\u000e\b\u0002\u0010n\u001a\b\u0012\u0004\u0012\u00020^0]\u0012\u000e\b\u0002\u0010o\u001a\b\u0012\u0004\u0012\u00020^0]\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\b\b\u0002\u00103\u001a\u00020\u0012\u0012\b\b\u0002\u0010p\u001a\u00020^\u0012\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020^0f\u0012\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020^0f\u0012\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020^0f\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H Já\u0003\u0010C\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0012H J\u0006\u0010D\u001a\u00020\u0004J\u0006\u0010E\u001a\u00020\u0004J\u0006\u0010F\u001a\u00020\u0004J\b\u0010H\u001a\u00020GH\u0016J\t\u0010J\u001a\u00020IHÆ\u0003J\t\u0010L\u001a\u00020KHÆ\u0003J\t\u0010N\u001a\u00020MHÆ\u0003J\t\u0010P\u001a\u00020OHÆ\u0003J\t\u0010R\u001a\u00020QHÆ\u0003J\t\u0010T\u001a\u00020SHÆ\u0003J\t\u0010V\u001a\u00020UHÆ\u0003J\t\u0010X\u001a\u00020WHÆ\u0003J\t\u0010Z\u001a\u00020YHÆ\u0003J\t\u0010\\\u001a\u00020[HÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020^0]HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020^0]HÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020^0]HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020^0]HÆ\u0003J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\t\u0010d\u001a\u00020\u0012HÆ\u0003J\t\u0010e\u001a\u00020^HÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020^0fHÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020^0fHÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020^0fHÆ\u0003J\u0012\u0010j\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\bj\u0010kJ\u0002\u0010t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020I2\b\b\u0002\u0010\b\u001a\u00020K2\b\b\u0002\u0010\t\u001a\u00020M2\b\b\u0002\u0010\n\u001a\u00020O2\b\b\u0002\u0010\u000b\u001a\u00020Q2\b\b\u0002\u0010\f\u001a\u00020S2\b\b\u0002\u0010\r\u001a\u00020U2\b\b\u0002\u0010\u000e\u001a\u00020W2\b\b\u0002\u0010\u000f\u001a\u00020Y2\b\b\u0002\u0010\u0010\u001a\u00020[2\u000e\b\u0002\u0010l\u001a\b\u0012\u0004\u0012\u00020^0]2\u000e\b\u0002\u0010m\u001a\b\u0012\u0004\u0012\u00020^0]2\u000e\b\u0002\u0010n\u001a\b\u0012\u0004\u0012\u00020^0]2\u000e\b\u0002\u0010o\u001a\b\u0012\u0004\u0012\u00020^0]2\b\b\u0002\u00102\u001a\u00020\u00122\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u0010p\u001a\u00020^2\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020^0f2\u000e\b\u0002\u0010r\u001a\b\u0012\u0004\u0012\u00020^0f2\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020^0f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\bt\u0010uJ\t\u0010v\u001a\u00020\u0006HÖ\u0001J\u0013\u0010y\u001a\u00020x2\b\u0010w\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0007\u001a\u00020I8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R&\u0010\b\u001a\u00020K8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0004\b\b\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\t\u001a\u00020M8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\t\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\n\u001a\u00020O8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\n\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u000b\u001a\u00020Q8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u000b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\f\u001a\u00020S8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\f\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\r\u001a\u00020U8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\r\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u000e\u001a\u00020W8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u000e\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R'\u0010\u000f\u001a\u00020Y8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u000f\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R'\u0010\u0010\u001a\u00020[8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b\u0010\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R'\u00102\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b2\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R'\u00103\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\b3\u0010¬\u0001\u001a\u0006\b±\u0001\u0010®\u0001\"\u0006\b²\u0001\u0010°\u0001R(\u0010B\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\bB\u0010³\u0001\u001a\u0005\b´\u0001\u0010k\"\u0006\bµ\u0001\u0010¶\u0001R)\u0010·\u0001\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R-\u0010l\u001a\b\u0012\u0004\u0012\u00020^0]8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bl\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R-\u0010m\u001a\b\u0012\u0004\u0012\u00020^0]8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bm\u0010½\u0001\u001a\u0006\bÂ\u0001\u0010¿\u0001\"\u0006\bÃ\u0001\u0010Á\u0001R-\u0010n\u001a\b\u0012\u0004\u0012\u00020^0]8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bn\u0010½\u0001\u001a\u0006\bÄ\u0001\u0010¿\u0001\"\u0006\bÅ\u0001\u0010Á\u0001R-\u0010o\u001a\b\u0012\u0004\u0012\u00020^0]8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bo\u0010½\u0001\u001a\u0006\bÆ\u0001\u0010¿\u0001\"\u0006\bÇ\u0001\u0010Á\u0001R'\u0010p\u001a\u00020^8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bp\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R-\u0010q\u001a\b\u0012\u0004\u0012\u00020^0f8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bq\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R-\u0010r\u001a\b\u0012\u0004\u0012\u00020^0f8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\br\u0010Í\u0001\u001a\u0006\bÒ\u0001\u0010Ï\u0001\"\u0006\bÓ\u0001\u0010Ñ\u0001R-\u0010s\u001a\b\u0012\u0004\u0012\u00020^0f8\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bs\u0010Í\u0001\u001a\u0006\bÔ\u0001\u0010Ï\u0001\"\u0006\bÕ\u0001\u0010Ñ\u0001¨\u0006Ú\u0001"}, d2 = {"Lapp/visly/stretch/Style;", "", "", "ptr", "Ltb/ur2;", "nFree", "", "display", "positionType", "direction", Constants.Name.FLEX_DIRECTION, Constants.Name.FLEX_WRAP, Constants.Name.OVERFLOW, Constants.Name.ALIGN_ITEMS, Constants.Name.ALIGN_SELF, "alignContent", Constants.Name.JUSTIFY_CONTENT, "positionStartType", "", "positionStartValue", "positionEndType", "positionEndValue", "positionTopType", "positionTopValue", "positionBottomType", "positionBottomValue", "marginStartType", "marginStartValue", "marginEndType", "marginEndValue", "marginTopType", "marginTopValue", "marginBottomType", "marginBottomValue", "paddingStartType", "paddingStartValue", "paddingEndType", "paddingEndValue", "paddingTopType", "paddingTopValue", "paddingBottomType", "paddingBottomValue", "borderStartType", "borderStartValue", "borderEndType", "borderEndValue", "borderTopType", "borderTopValue", "borderBottomType", "borderBottomValue", "flexGrow", "flexShrink", "flexBasisType", "flexBasisValue", "widthType", "widthValue", "heightType", "heightValue", "minWidthType", "minWidthValue", "minHeightType", "minHeightValue", "maxWidthType", "maxWidthValue", "maxHeightType", "maxHeightValue", "aspectRatio", "nConstruct", UCCore.LEGACY_EVENT_INIT, "free", "safeFree", "", "toString", "Lapp/visly/stretch/Display;", "component1", "Lapp/visly/stretch/PositionType;", "component2", "Lapp/visly/stretch/Direction;", "component3", "Lapp/visly/stretch/FlexDirection;", "component4", "Lapp/visly/stretch/FlexWrap;", "component5", "Lapp/visly/stretch/Overflow;", "component6", "Lapp/visly/stretch/AlignItems;", "component7", "Lapp/visly/stretch/AlignSelf;", "component8", "Lapp/visly/stretch/AlignContent;", "component9", "Lapp/visly/stretch/JustifyContent;", "component10", "Ltb/ox1;", "Ltb/m70;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "Ltb/ob2;", "component18", "component19", "component20", "component21", "()Ljava/lang/Float;", "position", Constants.Name.MARGIN, Constants.Name.PADDING, "border", "flexBasis", "size", "minSize", "maxSize", by0.ARG_COPY, "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Ltb/ox1;Ltb/ox1;Ltb/ox1;Ltb/ox1;FFLtb/m70;Ltb/ob2;Ltb/ob2;Ltb/ob2;Ljava/lang/Float;)Lapp/visly/stretch/Style;", "hashCode", "other", "", "equals", "Lapp/visly/stretch/Display;", "getDisplay", "()Lapp/visly/stretch/Display;", "setDisplay", "(Lapp/visly/stretch/Display;)V", "Lapp/visly/stretch/PositionType;", "getPositionType", "()Lapp/visly/stretch/PositionType;", "setPositionType", "(Lapp/visly/stretch/PositionType;)V", "Lapp/visly/stretch/Direction;", "getDirection", "()Lapp/visly/stretch/Direction;", "setDirection", "(Lapp/visly/stretch/Direction;)V", "Lapp/visly/stretch/FlexDirection;", "getFlexDirection", "()Lapp/visly/stretch/FlexDirection;", "setFlexDirection", "(Lapp/visly/stretch/FlexDirection;)V", "Lapp/visly/stretch/FlexWrap;", "getFlexWrap", "()Lapp/visly/stretch/FlexWrap;", "setFlexWrap", "(Lapp/visly/stretch/FlexWrap;)V", "Lapp/visly/stretch/Overflow;", "getOverflow", "()Lapp/visly/stretch/Overflow;", "setOverflow", "(Lapp/visly/stretch/Overflow;)V", "Lapp/visly/stretch/AlignItems;", "getAlignItems", "()Lapp/visly/stretch/AlignItems;", "setAlignItems", "(Lapp/visly/stretch/AlignItems;)V", "Lapp/visly/stretch/AlignSelf;", "getAlignSelf", "()Lapp/visly/stretch/AlignSelf;", "setAlignSelf", "(Lapp/visly/stretch/AlignSelf;)V", "Lapp/visly/stretch/AlignContent;", "getAlignContent", "()Lapp/visly/stretch/AlignContent;", "setAlignContent", "(Lapp/visly/stretch/AlignContent;)V", "Lapp/visly/stretch/JustifyContent;", "getJustifyContent", "()Lapp/visly/stretch/JustifyContent;", "setJustifyContent", "(Lapp/visly/stretch/JustifyContent;)V", UTConstant.Args.UT_SUCCESS_F, "getFlexGrow", "()F", "setFlexGrow", "(F)V", "getFlexShrink", "setFlexShrink", "Ljava/lang/Float;", "getAspectRatio", "setAspectRatio", "(Ljava/lang/Float;)V", "rustptr", "J", "getRustptr", "()J", "setRustptr", "(J)V", "Ltb/ox1;", "getPosition", "()Ltb/ox1;", "setPosition", "(Ltb/ox1;)V", "getMargin", "setMargin", "getPadding", "setPadding", "getBorder", "setBorder", "Ltb/m70;", "getFlexBasis", "()Ltb/m70;", "setFlexBasis", "(Ltb/m70;)V", "Ltb/ob2;", "getSize", "()Ltb/ob2;", "setSize", "(Ltb/ob2;)V", "getMinSize", "setMinSize", "getMaxSize", "setMaxSize", "<init>", "(Lapp/visly/stretch/Display;Lapp/visly/stretch/PositionType;Lapp/visly/stretch/Direction;Lapp/visly/stretch/FlexDirection;Lapp/visly/stretch/FlexWrap;Lapp/visly/stretch/Overflow;Lapp/visly/stretch/AlignItems;Lapp/visly/stretch/AlignSelf;Lapp/visly/stretch/AlignContent;Lapp/visly/stretch/JustifyContent;Ltb/ox1;Ltb/ox1;Ltb/ox1;Ltb/ox1;FFLtb/m70;Ltb/ob2;Ltb/ob2;Ltb/ob2;Ljava/lang/Float;)V", "Companion", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class Style {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private AlignContent alignContent;
    @NotNull
    private AlignItems alignItems;
    @NotNull
    private AlignSelf alignSelf;
    @Nullable
    private Float aspectRatio;
    @NotNull
    private ox1<m70> border;
    @NotNull
    private Direction direction;
    @NotNull
    private Display display;
    @NotNull
    private m70 flexBasis;
    @NotNull
    private FlexDirection flexDirection;
    private float flexGrow;
    private float flexShrink;
    @NotNull
    private FlexWrap flexWrap;
    @NotNull
    private JustifyContent justifyContent;
    @NotNull
    private ox1<m70> margin;
    @NotNull
    private ob2<m70> maxSize;
    @NotNull
    private ob2<m70> minSize;
    @NotNull
    private Overflow overflow;
    @NotNull
    private ox1<m70> padding;
    @NotNull
    private ox1<m70> position;
    @NotNull
    private PositionType positionType;
    private long rustptr;
    @NotNull
    private ob2<m70> size;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    static {
        Stretch.Companion.b();
    }

    public Style() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, 2097151, null);
    }

    public Style(@NotNull Display display2, @NotNull PositionType positionType2, @NotNull Direction direction2, @NotNull FlexDirection flexDirection2, @NotNull FlexWrap flexWrap2, @NotNull Overflow overflow2, @NotNull AlignItems alignItems2, @NotNull AlignSelf alignSelf2, @NotNull AlignContent alignContent2, @NotNull JustifyContent justifyContent2, @NotNull ox1<m70> ox1, @NotNull ox1<m70> ox12, @NotNull ox1<m70> ox13, @NotNull ox1<m70> ox14, float f, float f2, @NotNull m70 m70, @NotNull ob2<m70> ob2, @NotNull ob2<m70> ob22, @NotNull ob2<m70> ob23, @Nullable Float f3) {
        k21.i(display2, "display");
        k21.i(positionType2, "positionType");
        k21.i(direction2, "direction");
        k21.i(flexDirection2, Constants.Name.FLEX_DIRECTION);
        k21.i(flexWrap2, Constants.Name.FLEX_WRAP);
        k21.i(overflow2, Constants.Name.OVERFLOW);
        k21.i(alignItems2, Constants.Name.ALIGN_ITEMS);
        k21.i(alignSelf2, Constants.Name.ALIGN_SELF);
        k21.i(alignContent2, "alignContent");
        k21.i(justifyContent2, Constants.Name.JUSTIFY_CONTENT);
        k21.i(ox1, "position");
        k21.i(ox12, Constants.Name.MARGIN);
        k21.i(ox13, Constants.Name.PADDING);
        k21.i(ox14, "border");
        k21.i(m70, "flexBasis");
        k21.i(ob2, "size");
        k21.i(ob22, "minSize");
        k21.i(ob23, "maxSize");
        this.display = display2;
        this.positionType = positionType2;
        this.direction = direction2;
        this.flexDirection = flexDirection2;
        this.flexWrap = flexWrap2;
        this.overflow = overflow2;
        this.alignItems = alignItems2;
        this.alignSelf = alignSelf2;
        this.alignContent = alignContent2;
        this.justifyContent = justifyContent2;
        this.position = ox1;
        this.margin = ox12;
        this.padding = ox13;
        this.border = ox14;
        this.flexGrow = f;
        this.flexShrink = f2;
        this.flexBasis = m70;
        this.size = ob2;
        this.minSize = ob22;
        this.maxSize = ob23;
        this.aspectRatio = f3;
        this.rustptr = -1;
    }

    public static /* synthetic */ Style copy$default(Style style, Display display2, PositionType positionType2, Direction direction2, FlexDirection flexDirection2, FlexWrap flexWrap2, Overflow overflow2, AlignItems alignItems2, AlignSelf alignSelf2, AlignContent alignContent2, JustifyContent justifyContent2, ox1 ox1, ox1 ox12, ox1 ox13, ox1 ox14, float f, float f2, m70 m70, ob2 ob2, ob2 ob22, ob2 ob23, Float f3, int i, Object obj) {
        return style.copy((i & 1) != 0 ? style.display : display2, (i & 2) != 0 ? style.positionType : positionType2, (i & 4) != 0 ? style.direction : direction2, (i & 8) != 0 ? style.flexDirection : flexDirection2, (i & 16) != 0 ? style.flexWrap : flexWrap2, (i & 32) != 0 ? style.overflow : overflow2, (i & 64) != 0 ? style.alignItems : alignItems2, (i & 128) != 0 ? style.alignSelf : alignSelf2, (i & 256) != 0 ? style.alignContent : alignContent2, (i & 512) != 0 ? style.justifyContent : justifyContent2, (i & 1024) != 0 ? style.position : ox1, (i & 2048) != 0 ? style.margin : ox12, (i & 4096) != 0 ? style.padding : ox13, (i & 8192) != 0 ? style.border : ox14, (i & 16384) != 0 ? style.flexGrow : f, (i & 32768) != 0 ? style.flexShrink : f2, (i & 65536) != 0 ? style.flexBasis : m70, (i & 131072) != 0 ? style.size : ob2, (i & 262144) != 0 ? style.minSize : ob22, (i & 524288) != 0 ? style.maxSize : ob23, (i & 1048576) != 0 ? style.aspectRatio : f3);
    }

    private final native long nConstruct(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, float f, int i12, float f2, int i13, float f3, int i14, float f4, int i15, float f5, int i16, float f6, int i17, float f7, int i18, float f8, int i19, float f9, int i20, float f10, int i21, float f11, int i22, float f12, int i23, float f13, int i24, float f14, int i25, float f15, int i26, float f16, float f17, float f18, int i27, float f19, int i28, float f20, int i29, float f21, int i30, float f22, int i31, float f23, int i32, float f24, int i33, float f25, float f26);

    private final native void nFree(long j);

    @NotNull
    public final Display component1() {
        return this.display;
    }

    @NotNull
    public final JustifyContent component10() {
        return this.justifyContent;
    }

    @NotNull
    public final ox1<m70> component11() {
        return this.position;
    }

    @NotNull
    public final ox1<m70> component12() {
        return this.margin;
    }

    @NotNull
    public final ox1<m70> component13() {
        return this.padding;
    }

    @NotNull
    public final ox1<m70> component14() {
        return this.border;
    }

    public final float component15() {
        return this.flexGrow;
    }

    public final float component16() {
        return this.flexShrink;
    }

    @NotNull
    public final m70 component17() {
        return this.flexBasis;
    }

    @NotNull
    public final ob2<m70> component18() {
        return this.size;
    }

    @NotNull
    public final ob2<m70> component19() {
        return this.minSize;
    }

    @NotNull
    public final PositionType component2() {
        return this.positionType;
    }

    @NotNull
    public final ob2<m70> component20() {
        return this.maxSize;
    }

    @Nullable
    public final Float component21() {
        return this.aspectRatio;
    }

    @NotNull
    public final Direction component3() {
        return this.direction;
    }

    @NotNull
    public final FlexDirection component4() {
        return this.flexDirection;
    }

    @NotNull
    public final FlexWrap component5() {
        return this.flexWrap;
    }

    @NotNull
    public final Overflow component6() {
        return this.overflow;
    }

    @NotNull
    public final AlignItems component7() {
        return this.alignItems;
    }

    @NotNull
    public final AlignSelf component8() {
        return this.alignSelf;
    }

    @NotNull
    public final AlignContent component9() {
        return this.alignContent;
    }

    @NotNull
    public final Style copy(@NotNull Display display2, @NotNull PositionType positionType2, @NotNull Direction direction2, @NotNull FlexDirection flexDirection2, @NotNull FlexWrap flexWrap2, @NotNull Overflow overflow2, @NotNull AlignItems alignItems2, @NotNull AlignSelf alignSelf2, @NotNull AlignContent alignContent2, @NotNull JustifyContent justifyContent2, @NotNull ox1<m70> ox1, @NotNull ox1<m70> ox12, @NotNull ox1<m70> ox13, @NotNull ox1<m70> ox14, float f, float f2, @NotNull m70 m70, @NotNull ob2<m70> ob2, @NotNull ob2<m70> ob22, @NotNull ob2<m70> ob23, @Nullable Float f3) {
        k21.i(display2, "display");
        k21.i(positionType2, "positionType");
        k21.i(direction2, "direction");
        k21.i(flexDirection2, Constants.Name.FLEX_DIRECTION);
        k21.i(flexWrap2, Constants.Name.FLEX_WRAP);
        k21.i(overflow2, Constants.Name.OVERFLOW);
        k21.i(alignItems2, Constants.Name.ALIGN_ITEMS);
        k21.i(alignSelf2, Constants.Name.ALIGN_SELF);
        k21.i(alignContent2, "alignContent");
        k21.i(justifyContent2, Constants.Name.JUSTIFY_CONTENT);
        k21.i(ox1, "position");
        k21.i(ox12, Constants.Name.MARGIN);
        k21.i(ox13, Constants.Name.PADDING);
        k21.i(ox14, "border");
        k21.i(m70, "flexBasis");
        k21.i(ob2, "size");
        k21.i(ob22, "minSize");
        k21.i(ob23, "maxSize");
        return new Style(display2, positionType2, direction2, flexDirection2, flexWrap2, overflow2, alignItems2, alignSelf2, alignContent2, justifyContent2, ox1, ox12, ox13, ox14, f, f2, m70, ob2, ob22, ob23, f3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Style)) {
            return false;
        }
        Style style = (Style) obj;
        return this.display == style.display && this.positionType == style.positionType && this.direction == style.direction && this.flexDirection == style.flexDirection && this.flexWrap == style.flexWrap && this.overflow == style.overflow && this.alignItems == style.alignItems && this.alignSelf == style.alignSelf && this.alignContent == style.alignContent && this.justifyContent == style.justifyContent && k21.d(this.position, style.position) && k21.d(this.margin, style.margin) && k21.d(this.padding, style.padding) && k21.d(this.border, style.border) && k21.d(Float.valueOf(this.flexGrow), Float.valueOf(style.flexGrow)) && k21.d(Float.valueOf(this.flexShrink), Float.valueOf(style.flexShrink)) && k21.d(this.flexBasis, style.flexBasis) && k21.d(this.size, style.size) && k21.d(this.minSize, style.minSize) && k21.d(this.maxSize, style.maxSize) && k21.d(this.aspectRatio, style.aspectRatio);
    }

    public final void free() {
        long j = this.rustptr;
        if (j != -1) {
            nFree(j);
            this.rustptr = -1;
        }
    }

    @NotNull
    public final AlignContent getAlignContent() {
        return this.alignContent;
    }

    @NotNull
    public final AlignItems getAlignItems() {
        return this.alignItems;
    }

    @NotNull
    public final AlignSelf getAlignSelf() {
        return this.alignSelf;
    }

    @Nullable
    public final Float getAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    public final ox1<m70> getBorder() {
        return this.border;
    }

    @NotNull
    public final Direction getDirection() {
        return this.direction;
    }

    @NotNull
    public final Display getDisplay() {
        return this.display;
    }

    @NotNull
    public final m70 getFlexBasis() {
        return this.flexBasis;
    }

    @NotNull
    public final FlexDirection getFlexDirection() {
        return this.flexDirection;
    }

    public final float getFlexGrow() {
        return this.flexGrow;
    }

    public final float getFlexShrink() {
        return this.flexShrink;
    }

    @NotNull
    public final FlexWrap getFlexWrap() {
        return this.flexWrap;
    }

    @NotNull
    public final JustifyContent getJustifyContent() {
        return this.justifyContent;
    }

    @NotNull
    public final ox1<m70> getMargin() {
        return this.margin;
    }

    @NotNull
    public final ob2<m70> getMaxSize() {
        return this.maxSize;
    }

    @NotNull
    public final ob2<m70> getMinSize() {
        return this.minSize;
    }

    @NotNull
    public final Overflow getOverflow() {
        return this.overflow;
    }

    @NotNull
    public final ox1<m70> getPadding() {
        return this.padding;
    }

    @NotNull
    public final ox1<m70> getPosition() {
        return this.position;
    }

    @NotNull
    public final PositionType getPositionType() {
        return this.positionType;
    }

    public final long getRustptr() {
        return this.rustptr;
    }

    @NotNull
    public final ob2<m70> getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((this.display.hashCode() * 31) + this.positionType.hashCode()) * 31) + this.direction.hashCode()) * 31) + this.flexDirection.hashCode()) * 31) + this.flexWrap.hashCode()) * 31) + this.overflow.hashCode()) * 31) + this.alignItems.hashCode()) * 31) + this.alignSelf.hashCode()) * 31) + this.alignContent.hashCode()) * 31) + this.justifyContent.hashCode()) * 31) + this.position.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.border.hashCode()) * 31) + Float.floatToIntBits(this.flexGrow)) * 31) + Float.floatToIntBits(this.flexShrink)) * 31) + this.flexBasis.hashCode()) * 31) + this.size.hashCode()) * 31) + this.minSize.hashCode()) * 31) + this.maxSize.hashCode()) * 31;
        Float f = this.aspectRatio;
        return hashCode + (f == null ? 0 : f.hashCode());
    }

    public final void init() {
        int ordinal = this.display.ordinal();
        int ordinal2 = this.positionType.ordinal();
        int ordinal3 = this.direction.ordinal();
        int ordinal4 = this.flexDirection.ordinal();
        int ordinal5 = this.flexWrap.ordinal();
        int ordinal6 = this.overflow.ordinal();
        int ordinal7 = this.alignItems.ordinal();
        int ordinal8 = this.alignSelf.ordinal();
        int ordinal9 = this.alignContent.ordinal();
        int ordinal10 = this.justifyContent.ordinal();
        int a2 = this.position.c().a();
        float b = this.position.c().b();
        int a3 = this.position.b().a();
        float b2 = this.position.b().b();
        int a4 = this.position.d().a();
        float b3 = this.position.d().b();
        int a5 = this.position.a().a();
        float b4 = this.position.a().b();
        int a6 = this.margin.c().a();
        float b5 = this.margin.c().b();
        int a7 = this.margin.b().a();
        float b6 = this.margin.b().b();
        int a8 = this.margin.d().a();
        float b7 = this.margin.d().b();
        int a9 = this.margin.a().a();
        float b8 = this.margin.a().b();
        int a10 = this.padding.c().a();
        float b9 = this.padding.c().b();
        int a11 = this.padding.b().a();
        float b10 = this.padding.b().b();
        int a12 = this.padding.d().a();
        float b11 = this.padding.d().b();
        int a13 = this.padding.a().a();
        float b12 = this.padding.a().b();
        int a14 = this.border.c().a();
        float b13 = this.border.c().b();
        int a15 = this.border.b().a();
        float b14 = this.border.b().b();
        int a16 = this.border.d().a();
        float b15 = this.border.d().b();
        int a17 = this.border.a().a();
        float b16 = this.border.a().b();
        float f = this.flexGrow;
        float f2 = this.flexShrink;
        int a18 = this.flexBasis.a();
        float b17 = this.flexBasis.b();
        int a19 = this.size.b().a();
        float b18 = this.size.b().b();
        int a20 = this.size.a().a();
        float b19 = this.size.a().b();
        int a21 = this.minSize.b().a();
        float b20 = this.minSize.b().b();
        int a22 = this.minSize.a().a();
        float b21 = this.minSize.a().b();
        int a23 = this.maxSize.b().a();
        float b22 = this.maxSize.b().b();
        int a24 = this.maxSize.a().a();
        float b23 = this.maxSize.a().b();
        Float f3 = this.aspectRatio;
        this.rustptr = nConstruct(ordinal, ordinal2, ordinal3, ordinal4, ordinal5, ordinal6, ordinal7, ordinal8, ordinal9, ordinal10, a2, b, a3, b2, a4, b3, a5, b4, a6, b5, a7, b6, a8, b7, a9, b8, a10, b9, a11, b10, a12, b11, a13, b12, a14, b13, a15, b14, a16, b15, a17, b16, f, f2, a18, b17, a19, b18, a20, b19, a21, b20, a22, b21, a23, b22, a24, b23, f3 == null ? Float.NaN : f3.floatValue());
    }

    public final void safeFree() {
        synchronized (this) {
            if (getRustptr() != -1) {
                nFree(getRustptr());
                setRustptr(-1);
            }
            ur2 ur2 = ur2.INSTANCE;
        }
    }

    public final void setAlignContent(@NotNull AlignContent alignContent2) {
        k21.i(alignContent2, "<set-?>");
        this.alignContent = alignContent2;
    }

    public final void setAlignItems(@NotNull AlignItems alignItems2) {
        k21.i(alignItems2, "<set-?>");
        this.alignItems = alignItems2;
    }

    public final void setAlignSelf(@NotNull AlignSelf alignSelf2) {
        k21.i(alignSelf2, "<set-?>");
        this.alignSelf = alignSelf2;
    }

    public final void setAspectRatio(@Nullable Float f) {
        this.aspectRatio = f;
    }

    public final void setBorder(@NotNull ox1<m70> ox1) {
        k21.i(ox1, "<set-?>");
        this.border = ox1;
    }

    public final void setDirection(@NotNull Direction direction2) {
        k21.i(direction2, "<set-?>");
        this.direction = direction2;
    }

    public final void setDisplay(@NotNull Display display2) {
        k21.i(display2, "<set-?>");
        this.display = display2;
    }

    public final void setFlexBasis(@NotNull m70 m70) {
        k21.i(m70, "<set-?>");
        this.flexBasis = m70;
    }

    public final void setFlexDirection(@NotNull FlexDirection flexDirection2) {
        k21.i(flexDirection2, "<set-?>");
        this.flexDirection = flexDirection2;
    }

    public final void setFlexGrow(float f) {
        this.flexGrow = f;
    }

    public final void setFlexShrink(float f) {
        this.flexShrink = f;
    }

    public final void setFlexWrap(@NotNull FlexWrap flexWrap2) {
        k21.i(flexWrap2, "<set-?>");
        this.flexWrap = flexWrap2;
    }

    public final void setJustifyContent(@NotNull JustifyContent justifyContent2) {
        k21.i(justifyContent2, "<set-?>");
        this.justifyContent = justifyContent2;
    }

    public final void setMargin(@NotNull ox1<m70> ox1) {
        k21.i(ox1, "<set-?>");
        this.margin = ox1;
    }

    public final void setMaxSize(@NotNull ob2<m70> ob2) {
        k21.i(ob2, "<set-?>");
        this.maxSize = ob2;
    }

    public final void setMinSize(@NotNull ob2<m70> ob2) {
        k21.i(ob2, "<set-?>");
        this.minSize = ob2;
    }

    public final void setOverflow(@NotNull Overflow overflow2) {
        k21.i(overflow2, "<set-?>");
        this.overflow = overflow2;
    }

    public final void setPadding(@NotNull ox1<m70> ox1) {
        k21.i(ox1, "<set-?>");
        this.padding = ox1;
    }

    public final void setPosition(@NotNull ox1<m70> ox1) {
        k21.i(ox1, "<set-?>");
        this.position = ox1;
    }

    public final void setPositionType(@NotNull PositionType positionType2) {
        k21.i(positionType2, "<set-?>");
        this.positionType = positionType2;
    }

    public final void setRustptr(long j) {
        this.rustptr = j;
    }

    public final void setSize(@NotNull ob2<m70> ob2) {
        k21.i(ob2, "<set-?>");
        this.size = ob2;
    }

    @NotNull
    public String toString() {
        return "Style(display=" + this.display + ", positionType=" + this.positionType + ", direction=" + this.direction + ", flexDirection=" + this.flexDirection + ", flexWrap=" + this.flexWrap + ", overflow=" + this.overflow + ", alignItems=" + this.alignItems + ", alignSelf=" + this.alignSelf + ", alignContent=" + this.alignContent + ", justifyContent=" + this.justifyContent + ", position=" + this.position + ", margin=" + this.margin + ", padding=" + this.padding + ", border=" + this.border + ", flexGrow=" + this.flexGrow + ", flexShrink=" + this.flexShrink + ", flexBasis=" + this.flexBasis + ", size=" + this.size + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", aspectRatio=" + this.aspectRatio + ", rustptr=" + this.rustptr + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ Style(Display display2, PositionType positionType2, Direction direction2, FlexDirection flexDirection2, FlexWrap flexWrap2, Overflow overflow2, AlignItems alignItems2, AlignSelf alignSelf2, AlignContent alignContent2, JustifyContent justifyContent2, ox1 ox1, ox1 ox12, ox1 ox13, ox1 ox14, float f, float f2, m70 m70, ob2 ob2, ob2 ob22, ob2 ob23, Float f3, int i, m40 m40) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r18, r44, r16, r17, r19, r20, r15, (i & 1048576) != 0 ? null : f3);
        ox1 ox15;
        ox1 ox16;
        ox1 ox17;
        ox1 ox18;
        float f4;
        ox1 ox19;
        ob2 ob24;
        ob2 ob25;
        ob2 ob26;
        ob2 ob27;
        ob2 ob28;
        Display display3 = (i & 1) != 0 ? Display.Flex : display2;
        PositionType positionType3 = (i & 2) != 0 ? PositionType.Relative : positionType2;
        Direction direction3 = (i & 4) != 0 ? Direction.Inherit : direction2;
        FlexDirection flexDirection3 = (i & 8) != 0 ? FlexDirection.Row : flexDirection2;
        FlexWrap flexWrap3 = (i & 16) != 0 ? FlexWrap.NoWrap : flexWrap2;
        Overflow overflow3 = (i & 32) != 0 ? Overflow.Hidden : overflow2;
        AlignItems alignItems3 = (i & 64) != 0 ? AlignItems.Stretch : alignItems2;
        AlignSelf alignSelf3 = (i & 128) != 0 ? AlignSelf.Auto : alignSelf2;
        AlignContent alignContent3 = (i & 256) != 0 ? AlignContent.FlexStart : alignContent2;
        JustifyContent justifyContent3 = (i & 512) != 0 ? JustifyContent.FlexStart : justifyContent2;
        if ((i & 1024) != 0) {
            m70.d dVar = m70.d.INSTANCE;
            ox15 = new ox1(dVar, dVar, dVar, dVar);
        } else {
            ox15 = ox1;
        }
        if ((i & 2048) != 0) {
            m70.d dVar2 = m70.d.INSTANCE;
            ox16 = new ox1(dVar2, dVar2, dVar2, dVar2);
        } else {
            ox16 = ox12;
        }
        if ((i & 4096) != 0) {
            m70.d dVar3 = m70.d.INSTANCE;
            ox17 = new ox1(dVar3, dVar3, dVar3, dVar3);
        } else {
            ox17 = ox13;
        }
        if ((i & 8192) != 0) {
            m70.d dVar4 = m70.d.INSTANCE;
            ox18 = new ox1(dVar4, dVar4, dVar4, dVar4);
        } else {
            ox18 = ox14;
        }
        float f5 = 0.0f;
        float f6 = (i & 16384) != 0 ? 0.0f : f;
        f5 = (i & 32768) == 0 ? f2 : f5;
        m70 m702 = (i & 65536) != 0 ? m70.a.INSTANCE : m70;
        if ((i & 131072) != 0) {
            f4 = f6;
            ox19 = ox18;
            m70.a aVar = m70.a.INSTANCE;
            ob24 = new ob2(aVar, aVar);
        } else {
            ox19 = ox18;
            f4 = f6;
            ob24 = ob2;
        }
        if ((262144 & i) != 0) {
            ob25 = ob24;
            m70.a aVar2 = m70.a.INSTANCE;
            ob26 = new ob2(aVar2, aVar2);
        } else {
            ob25 = ob24;
            ob26 = ob22;
        }
        if ((524288 & i) != 0) {
            ob27 = ob26;
            m70.a aVar3 = m70.a.INSTANCE;
            ob28 = new ob2(aVar3, aVar3);
        } else {
            ob27 = ob26;
            ob28 = ob23;
        }
    }
}
