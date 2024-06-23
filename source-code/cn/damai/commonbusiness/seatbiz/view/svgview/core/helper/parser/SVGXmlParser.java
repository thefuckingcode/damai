package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser;

import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.CSSStyle;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.G;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGLine;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGOval;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPaintData;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPath;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGPolygon;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGRect;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.SVGText;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.model.PointLocation;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import tb.f92;
import tb.g91;
import tb.jl1;
import tb.ro1;

/* compiled from: Taobao */
public class SVGXmlParser {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean a = true;
    private static final Pattern b = Pattern.compile("[\\s,]*");
    private static final RectF c = new RectF();
    private static final Matrix d = new Matrix();
    private static final Matrix e = new Matrix();

    /* compiled from: Taobao */
    public static class Properties {
        private static transient /* synthetic */ IpChange $ipChange;
        Attributes atts;
        e styles;

        private int hex3Tohex6(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-414144069")) {
                return ((Integer) ipChange.ipc$dispatch("-414144069", new Object[]{this, Integer.valueOf(i)})).intValue();
            }
            int i2 = i & 3840;
            int i3 = (i2 << 12) | (i2 << 8);
            int i4 = i & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
            int i5 = i & 15;
            return i5 | i3 | (i4 << 4) | (i4 << 8) | (i5 << 4);
        }

        private int parseNum(String str) throws NumberFormatException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "34264051")) {
                return ((Integer) ipChange.ipc$dispatch("34264051", new Object[]{this, str})).intValue();
            } else if (str == null) {
                return 0;
            } else {
                String trim = str.trim();
                if (trim.endsWith("%")) {
                    return Math.round((Float.parseFloat(trim.substring(0, trim.length() - 1)) / 100.0f) * 255.0f);
                }
                return Integer.parseInt(trim);
            }
        }

        private Integer rgb(int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "236454262")) {
                return Integer.valueOf(((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255));
            }
            return (Integer) ipChange.ipc$dispatch("236454262", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setAttributes(Attributes attributes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2113870952")) {
                ipChange.ipc$dispatch("-2113870952", new Object[]{this, attributes});
                return;
            }
            this.atts = attributes;
            String m = SVGXmlParser.m("style", attributes);
            if (m != null) {
                this.styles = new e(m);
            } else {
                this.styles = null;
            }
        }

        public void clearData() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-473639414")) {
                ipChange.ipc$dispatch("-473639414", new Object[]{this});
                return;
            }
            this.styles = null;
            this.atts = null;
        }

        public String getAttr(String str) {
            Attributes attributes;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "674864540")) {
                return (String) ipChange.ipc$dispatch("674864540", new Object[]{this, str});
            }
            String str2 = null;
            e eVar = this.styles;
            if (eVar != null) {
                str2 = eVar.a(str);
            }
            return (str2 != null || (attributes = this.atts) == null) ? str2 : SVGXmlParser.m(str, attributes);
        }

        public Integer getColor(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1455467507")) {
                return parseColor(getAttr(str));
            }
            return (Integer) ipChange.ipc$dispatch("-1455467507", new Object[]{this, str});
        }

        public float getFloat(String str, float f) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "457634883")) {
                return ((Float) ipChange.ipc$dispatch("457634883", new Object[]{this, str, Float.valueOf(f)})).floatValue();
            }
            String attr = getAttr(str);
            if (attr == null) {
                return f;
            }
            try {
                return Float.parseFloat(attr);
            } catch (NumberFormatException unused) {
                return f;
            }
        }

        public String getString(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1545389764")) {
                return getAttr(str);
            }
            return (String) ipChange.ipc$dispatch("-1545389764", new Object[]{this, str});
        }

        public Integer parseColor(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-335602966")) {
                return c.c(str);
            }
            return (Integer) ipChange.ipc$dispatch("-335602966", new Object[]{this, str});
        }

        private Properties() {
            this.styles = null;
        }

        public float getFloat(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1815876861")) {
                return getFloat(str, 0.0f);
            }
            return ((Float) ipChange.ipc$dispatch("1815876861", new Object[]{this, str})).floatValue();
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private static transient /* synthetic */ IpChange $ipChange;
        String a;
        String b;
        boolean c;
        float d;
        float e;
        float f;
        float g;
        float h;
        float i;
        float j;
        ArrayList<Float> k;
        ArrayList<Integer> l;
        Matrix m;
        public Shader n;
        public boolean o;
        public Shader.TileMode p;

        private b() {
            this.k = new ArrayList<>();
            this.l = new ArrayList<>();
            this.m = null;
            this.n = null;
            this.o = false;
        }

        public b a(b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "264422268")) {
                return (b) ipChange.ipc$dispatch("264422268", new Object[]{this, bVar});
            }
            b bVar2 = new b();
            bVar2.a = bVar.a;
            bVar2.b = this.a;
            bVar2.c = bVar.c;
            bVar2.d = bVar.d;
            bVar2.f = bVar.f;
            bVar2.e = bVar.e;
            bVar2.g = bVar.g;
            bVar2.h = bVar.h;
            bVar2.i = bVar.i;
            bVar2.j = bVar.j;
            bVar2.k = this.k;
            bVar2.l = this.l;
            bVar2.m = this.m;
            Matrix matrix = bVar.m;
            if (matrix != null) {
                if (this.m == null) {
                    bVar2.m = matrix;
                } else {
                    Matrix matrix2 = new Matrix(this.m);
                    matrix2.preConcat(bVar.m);
                    bVar2.m = matrix2;
                }
            }
            bVar2.o = bVar.o;
            bVar2.n = bVar.n;
            bVar2.p = bVar.p;
            return bVar2;
        }
    }

    /* compiled from: Taobao */
    public static class c {
        private static transient /* synthetic */ IpChange $ipChange;
        private ArrayList<Float> a;

        public c(ArrayList<Float> arrayList, int i) {
            this.a = arrayList;
        }
    }

    /* compiled from: Taobao */
    public static class d extends DefaultHandler {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a;
        final LinkedList<Float> b;
        Paint c;
        final LinkedList<Paint> d = new LinkedList<>();
        Paint e;
        final LinkedList<Paint> f = new LinkedList<>();
        final LinkedList<String> g = new LinkedList<>();
        final RectF h = new RectF();
        final HashMap<String, b> i = new HashMap<>();
        final Matrix j = new Matrix();
        b k = null;
        private int l = 0;
        private boolean m = false;
        List<String> n = new ArrayList();
        Properties o;
        Properties p;
        SVGPaintData q;
        private String r;
        private SVGText s;
        private String t;
        private StringBuilder u;
        private List<CSSStyle> v;

        public d() {
            LinkedList<Float> linkedList = new LinkedList<>();
            this.b = linkedList;
            new ArrayList();
            this.o = new Properties();
            this.p = new Properties();
            this.t = "";
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setAntiAlias(true);
            this.e.setStyle(Paint.Style.FILL);
            linkedList.addFirst(Float.valueOf(1.0f));
            this.q = new SVGPaintData();
        }

        private void b(Properties properties, int i2, boolean z, Paint paint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-142916123")) {
                ipChange.ipc$dispatch("-142916123", new Object[]{this, properties, Integer.valueOf(i2), Boolean.valueOf(z), paint});
                return;
            }
            paint.setShader(null);
            paint.setColor((i2 & 16777215) | -16777216);
            String string = properties.getString("opacity");
            float f2 = 1.0f;
            if (!TextUtils.isEmpty(string)) {
                f2 = SVGXmlParser.p(string, 1.0f);
            } else {
                String string2 = properties.getString(z ? "fill-opacity" : "stroke-opacity");
                if (!TextUtils.isEmpty(string2)) {
                    f2 = SVGXmlParser.p(string2, 1.0f);
                }
            }
            paint.setAlpha((int) (f2 * a().floatValue() * 255.0f));
        }

        private void c(CSSStyle cSSStyle, int i2, boolean z, Paint paint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-186780770")) {
                ipChange.ipc$dispatch("-186780770", new Object[]{this, cSSStyle, Integer.valueOf(i2), Boolean.valueOf(z), paint});
                return;
            }
            paint.setShader(null);
            paint.setColor((i2 & 16777215) | -16777216);
            String string = cSSStyle.getString("opacity");
            float f2 = 1.0f;
            if (!TextUtils.isEmpty(string)) {
                f2 = SVGXmlParser.p(string, 1.0f);
            } else {
                String string2 = cSSStyle.getString(z ? "fill-opacity" : "stroke-opacity");
                if (!TextUtils.isEmpty(string2)) {
                    f2 = SVGXmlParser.p(string2, 1.0f);
                }
            }
            paint.setAlpha((int) (f2 * a().floatValue() * 255.0f));
        }

        private boolean d(Properties properties, RectF rectF) {
            String string;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "68617500")) {
                return ((Boolean) ipChange.ipc$dispatch("68617500", new Object[]{this, properties, rectF})).booleanValue();
            }
            if ("none".equals(properties.getString("display"))) {
                return false;
            }
            String string2 = properties.getString("fill");
            if (string2 == null) {
                CSSStyle i2 = i(this.v, this.o);
                if (i2 == null || (string = i2.getString("fill")) == null) {
                    if (this.f.isEmpty() || this.f.getLast() == null) {
                        this.e.setShader(null);
                        this.e.setColor(-16777216);
                        return true;
                    }
                    Paint last = this.f.getLast();
                    this.e = last;
                    if (last.getColor() != 0) {
                        return true;
                    }
                    return false;
                } else if (string.equalsIgnoreCase("none")) {
                    this.e.setShader(null);
                    this.e.setColor(0);
                    return true;
                } else {
                    this.e.setShader(null);
                    Integer color = i2.getColor("fill");
                    if (color != null) {
                        c(i2, color.intValue(), true, this.e);
                        return true;
                    }
                    g91.c("SVGAndroid", "Unrecognized fill color, using black: " + string);
                    c(i2, -16777216, true, this.e);
                    return true;
                }
            } else if (string2.startsWith("url(#")) {
                String substring = string2.substring(5, string2.length() - 1);
                b bVar = this.i.get(substring);
                Shader shader = bVar != null ? bVar.n : null;
                if (shader != null) {
                    this.e.setShader(shader);
                    this.j.set(bVar.m);
                    if (bVar.o && rectF != null) {
                        this.j.preTranslate(rectF.left, rectF.top);
                        this.j.preScale(rectF.width(), rectF.height());
                    }
                    shader.setLocalMatrix(this.j);
                    return true;
                }
                g91.c("SVGAndroid", "Didn't find shader, using white: " + substring);
                this.e.setShader(null);
                b(properties, -16777216, true, this.e);
                return true;
            } else if (string2.equalsIgnoreCase("none")) {
                this.e.setShader(null);
                this.e.setColor(0);
                return true;
            } else {
                this.e.setShader(null);
                Integer color2 = properties.getColor("fill");
                if (color2 != null) {
                    b(properties, color2.intValue(), true, this.e);
                    return true;
                }
                g91.c("SVGAndroid", "Unrecognized fill color, using black: " + string2);
                b(properties, -16777216, true, this.e);
                return true;
            }
        }

        private b e(boolean z, Attributes attributes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2075496021")) {
                return (b) ipChange.ipc$dispatch("-2075496021", new Object[]{this, Boolean.valueOf(z), attributes});
            }
            b bVar = new b();
            bVar.a = SVGXmlParser.m("id", attributes);
            bVar.c = z;
            if (z) {
                bVar.d = SVGXmlParser.k("x1", attributes, 0.0f);
                bVar.f = SVGXmlParser.k("x2", attributes, 1.0f);
                bVar.e = SVGXmlParser.k("y1", attributes, 0.0f);
                bVar.g = SVGXmlParser.k("y2", attributes, 0.0f);
            } else {
                bVar.h = SVGXmlParser.k("cx", attributes, 0.0f);
                bVar.i = SVGXmlParser.k("cy", attributes, 0.0f);
                bVar.j = SVGXmlParser.k(UploadQueueMgr.MSGTYPE_REALTIME, attributes, 0.0f);
            }
            String m2 = SVGXmlParser.m("gradientTransform", attributes);
            if (m2 != null) {
                bVar.m = SVGXmlParser.r(m2);
            }
            String m3 = SVGXmlParser.m("spreadMethod", attributes);
            if (m3 == null) {
                m3 = "pad";
            }
            bVar.p = m3.equals("reflect") ? Shader.TileMode.MIRROR : m3.equals("repeat") ? Shader.TileMode.REPEAT : Shader.TileMode.CLAMP;
            String m4 = SVGXmlParser.m("gradientUnits", attributes);
            if (m4 == null) {
                m4 = "objectBoundingBox";
            }
            bVar.o = !m4.equals("userSpaceOnUse");
            String m5 = SVGXmlParser.m("href", attributes);
            if (m5 != null) {
                if (m5.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    m5 = m5.substring(1);
                }
                bVar.b = m5;
            }
            return bVar;
        }

        private boolean f(Properties properties) {
            String string;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-767164096")) {
                return ((Boolean) ipChange.ipc$dispatch("-767164096", new Object[]{this, properties})).booleanValue();
            }
            if ("none".equals(properties.getString("display"))) {
                return false;
            }
            String string2 = properties.getString("stroke-width");
            if (!TextUtils.isEmpty(string2)) {
                this.c.setStrokeWidth(Float.valueOf(SVGXmlParser.p(string2, 1.0f)).floatValue());
            }
            String string3 = properties.getString("stroke-linecap");
            if ("round".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.ROUND);
            } else if ("square".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.SQUARE);
            } else if ("butt".equals(string3)) {
                this.c.setStrokeCap(Paint.Cap.BUTT);
            }
            String string4 = properties.getString("stroke-linejoin");
            if ("miter".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.MITER);
            } else if ("round".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.ROUND);
            } else if ("bevel".equals(string4)) {
                this.c.setStrokeJoin(Paint.Join.BEVEL);
            }
            q(properties.getString("stroke-dasharray"), properties.getString("stroke-dashoffset"));
            String attr = properties.getAttr("stroke");
            if (attr == null) {
                CSSStyle i2 = i(this.v, properties);
                if (!(i2 == null || (string = i2.getString("stroke")) == null)) {
                    if (string.equalsIgnoreCase("none")) {
                        this.c.setColor(0);
                        return false;
                    }
                    Integer color = i2.getColor("stroke");
                    if (color != null) {
                        String string5 = i2.getString("stroke-width");
                        if (!TextUtils.isEmpty(string5)) {
                            this.c.setStrokeWidth(Float.valueOf(SVGXmlParser.p(string5, 1.0f)).floatValue());
                        }
                        String string6 = i2.getString("stroke-linecap");
                        if ("round".equals(string6)) {
                            this.c.setStrokeCap(Paint.Cap.ROUND);
                        } else if ("square".equals(string6)) {
                            this.c.setStrokeCap(Paint.Cap.SQUARE);
                        } else if ("butt".equals(string6)) {
                            this.c.setStrokeCap(Paint.Cap.BUTT);
                        }
                        String string7 = i2.getString("stroke-linejoin");
                        if ("miter".equals(string7)) {
                            this.c.setStrokeJoin(Paint.Join.MITER);
                        } else if ("round".equals(string7)) {
                            this.c.setStrokeJoin(Paint.Join.ROUND);
                        } else if ("bevel".equals(string7)) {
                            this.c.setStrokeJoin(Paint.Join.BEVEL);
                        }
                        c(i2, color.intValue(), false, this.c);
                        return true;
                    }
                }
                if (this.d.isEmpty() || this.d.getLast() == null) {
                    return false;
                }
                Paint last = this.d.getLast();
                this.c = last;
                if (last.getColor() != 0) {
                    return true;
                }
                return false;
            } else if (attr.equalsIgnoreCase("none")) {
                this.c.setColor(0);
                return false;
            } else {
                Integer color2 = properties.getColor("stroke");
                if (color2 != null) {
                    b(properties, color2.intValue(), false, this.c);
                    return true;
                }
                g91.c("SVGAndroid", "Unrecognized stroke color, using none: " + attr);
                this.c.setColor(0);
                return false;
            }
        }

        private List<PointLocation> g(RectF rectF, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329762763")) {
                return (List) ipChange.ipc$dispatch("-329762763", new Object[]{this, rectF, str});
            }
            PointLocation pointLocation = new PointLocation();
            pointLocation.id = str;
            pointLocation.x = rectF.left;
            pointLocation.y = rectF.top;
            pointLocation.rectF = rectF;
            PointLocation pointLocation2 = new PointLocation();
            pointLocation2.id = str;
            pointLocation2.x = rectF.right;
            pointLocation2.y = rectF.bottom;
            pointLocation2.rectF = rectF;
            ArrayList arrayList = new ArrayList();
            arrayList.add(pointLocation);
            arrayList.add(pointLocation2);
            return arrayList;
        }

        private List<PointLocation> h(ArrayList<Float> arrayList, RectF rectF, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-534189671")) {
                return (List) ipChange.ipc$dispatch("-534189671", new Object[]{this, arrayList, rectF, str});
            }
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                return null;
            }
            if (arrayList.size() > 1) {
                arrayList2 = new ArrayList();
                PointLocation pointLocation = new PointLocation();
                pointLocation.id = str;
                pointLocation.x = arrayList.get(0).floatValue();
                pointLocation.y = arrayList.get(1).floatValue();
                pointLocation.rectF = rectF;
                arrayList2.add(pointLocation);
                for (int i2 = 2; i2 < arrayList.size(); i2 += 2) {
                    PointLocation pointLocation2 = new PointLocation();
                    float floatValue = arrayList.get(i2).floatValue();
                    float floatValue2 = arrayList.get(i2 + 1).floatValue();
                    pointLocation2.id = str;
                    pointLocation2.x = floatValue;
                    pointLocation2.y = floatValue2;
                    pointLocation2.rectF = rectF;
                    arrayList2.add(pointLocation2);
                }
                PointLocation pointLocation3 = new PointLocation();
                pointLocation3.id = str;
                pointLocation3.x = arrayList.get(0).floatValue();
                pointLocation3.y = arrayList.get(1).floatValue();
                pointLocation3.rectF = rectF;
                arrayList2.add(pointLocation3);
            }
            return arrayList2;
        }

        private CSSStyle i(@Nullable List<CSSStyle> list, @Nullable Properties properties) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1388147225")) {
                return (CSSStyle) ipChange.ipc$dispatch("1388147225", new Object[]{this, list, properties});
            }
            if (!(list == null || list.size() == 0 || properties == null)) {
                String attr = properties.getAttr("id");
                if (!TextUtils.isEmpty(attr)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        CSSStyle cSSStyle = list.get(i2);
                        if (cSSStyle.isIdSelector() && cSSStyle.isNameEquals(attr)) {
                            return cSSStyle;
                        }
                    }
                }
                String attr2 = properties.getAttr("class");
                if (!TextUtils.isEmpty(attr2)) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CSSStyle cSSStyle2 = list.get(i3);
                        if (cSSStyle2.isClassSelector() && cSSStyle2.isNameEquals(attr2)) {
                            return cSSStyle2;
                        }
                    }
                }
            }
            return null;
        }

        private String j(char[] cArr, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1290655759")) {
                return (String) ipChange.ipc$dispatch("-1290655759", new Object[]{this, cArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            }
            try {
                return new String(cArr, i2, i3);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        private RectF n(RectF rectF, @Nullable Matrix matrix) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "918997535")) {
                return (RectF) ipChange.ipc$dispatch("918997535", new Object[]{this, rectF, matrix});
            }
            if (matrix != null) {
                try {
                    RectF rectF2 = new RectF(rectF);
                    matrix.mapRect(rectF2);
                    return rectF2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return rectF;
        }

        private ArrayList<Float> o(ArrayList<Float> arrayList, @Nullable Matrix matrix) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1774112113")) {
                return (ArrayList) ipChange.ipc$dispatch("-1774112113", new Object[]{this, arrayList, matrix});
            }
            if (matrix != null) {
                try {
                    if (!f92.d(arrayList)) {
                        int size = arrayList.size();
                        float[] fArr = new float[size];
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            fArr[i2] = arrayList.get(i2).floatValue();
                        }
                        matrix.mapPoints(fArr);
                        ArrayList<Float> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList2.add(Float.valueOf(fArr[i3]));
                        }
                        return arrayList2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        }

        private float p(Attributes attributes) {
            int indexOf;
            String substring;
            int indexOf2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "906264487")) {
                return ((Float) ipChange.ipc$dispatch("906264487", new Object[]{this, attributes})).floatValue();
            }
            String m2 = SVGXmlParser.m("transform", attributes);
            if (TextUtils.isEmpty(m2)) {
                return 1.0f;
            }
            String replaceAll = m2.replaceAll(" ", "");
            if (!replaceAll.contains("scale(") || (indexOf = replaceAll.indexOf("scale(")) >= replaceAll.length() || (indexOf2 = (substring = replaceAll.substring(indexOf)).indexOf(jl1.BRACKET_END_STR)) == -1) {
                return 1.0f;
            }
            try {
                return Float.parseFloat(substring.substring(6, indexOf2));
            } catch (Exception e2) {
                e2.printStackTrace();
                return 1.0f;
            }
        }

        private void q(String str, String str2) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1640830904")) {
                ipChange.ipc$dispatch("-1640830904", new Object[]{this, str, str2});
            } else if (str != null) {
                String trim = str.trim();
                if (trim.equals("none")) {
                    this.c.setPathEffect(null);
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(trim, " ,");
                int countTokens = stringTokenizer.countTokens();
                if ((countTokens & 1) == 1) {
                    countTokens *= 2;
                }
                float[] fArr = new float[countTokens];
                float f2 = 1.0f;
                float f3 = 0.0f;
                int i3 = 0;
                float f4 = 0.0f;
                while (stringTokenizer.hasMoreTokens()) {
                    f2 = SVGXmlParser.p(stringTokenizer.nextToken(), f2);
                    fArr[i3] = f2;
                    f4 += f2;
                    i3++;
                }
                while (i3 < countTokens) {
                    float f5 = fArr[i2];
                    fArr[i3] = f5;
                    f4 += f5;
                    i3++;
                    i2++;
                }
                if (str2 != null) {
                    try {
                        f3 = Float.parseFloat(str2) % f4;
                    } catch (NumberFormatException unused) {
                    }
                }
                this.c.setPathEffect(new DashPathEffect(fArr, f3));
            }
        }

        public Float a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "918172438")) {
                return this.b.getLast();
            }
            return (Float) ipChange.ipc$dispatch("918172438", new Object[]{this});
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-66357318")) {
                ipChange.ipc$dispatch("-66357318", new Object[]{this, cArr, Integer.valueOf(i2), Integer.valueOf(i3)});
            } else if ("style".equals(this.r)) {
                if (this.u != null) {
                    String j2 = j(cArr, i2, i3);
                    if (!TextUtils.isEmpty(j2)) {
                        this.u.append(j2);
                    }
                }
            } else if ("text".equals(this.r)) {
                this.t = new String(cArr, i2, i3);
            } else {
                this.t = "";
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-454938504")) {
                ipChange.ipc$dispatch("-454938504", new Object[]{this});
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            b bVar;
            StringBuilder sb;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-987448615")) {
                ipChange.ipc$dispatch("-987448615", new Object[]{this, str, str2, str3});
            } else if (!str2.equals("svg")) {
                if (str2.equals("linearGradient") || str2.equals("radialGradient")) {
                    b bVar2 = this.k;
                    if (bVar2.a != null) {
                        String str4 = bVar2.b;
                        if (!(str4 == null || (bVar = this.i.get(str4)) == null)) {
                            this.k = bVar.a(this.k);
                        }
                        int size = this.k.l.size();
                        int[] iArr = new int[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            iArr[i2] = this.k.l.get(i2).intValue();
                        }
                        int size2 = this.k.k.size();
                        float[] fArr = new float[size2];
                        for (int i3 = 0; i3 < size2; i3++) {
                            fArr[i3] = this.k.k.get(i3).floatValue();
                        }
                        if (size == 0) {
                            g91.b("BAD", "BAD");
                        }
                        if (str2.equals("linearGradient")) {
                            b bVar3 = this.k;
                            b bVar4 = this.k;
                            bVar3.n = new LinearGradient(bVar4.d, bVar4.e, bVar4.f, bVar4.g, iArr, fArr, bVar4.p);
                        } else {
                            b bVar5 = this.k;
                            b bVar6 = this.k;
                            bVar5.n = new RadialGradient(bVar6.h, bVar6.i, bVar6.j, iArr, fArr, bVar6.p);
                        }
                        HashMap<String, b> hashMap = this.i;
                        b bVar7 = this.k;
                        hashMap.put(bVar7.a, bVar7);
                    }
                } else if (str2.equals("g")) {
                    if (this.m) {
                        int i4 = this.l - 1;
                        this.l = i4;
                        if (i4 == 0) {
                            this.m = false;
                        }
                    }
                    if (!this.g.isEmpty()) {
                        G g2 = new G();
                        g2.isParseEnd = true;
                        this.q.addShape(102);
                        this.q.addG(g2);
                        this.g.removeLast();
                    }
                    if (this.b.size() > 1) {
                        this.b.removeLast();
                    }
                    if (!this.f.isEmpty()) {
                        this.f.removeLast();
                    }
                    if (!this.d.isEmpty()) {
                        this.d.removeLast();
                    }
                    this.p.clearData();
                } else if (str2.equals("text")) {
                    SVGText sVGText = this.s;
                    if (sVGText != null) {
                        sVGText.content = this.t;
                        this.q.addShape(107);
                        this.q.addText(this.s);
                    }
                } else if ("style".equals(str2) && (sb = this.u) != null) {
                    List<CSSStyle> parse = CSSStyle.parse(sb.toString());
                    if (parse != null && parse.size() > 0) {
                        if (this.v == null) {
                            this.v = new ArrayList();
                        }
                        this.v.addAll(parse);
                    }
                    this.u = null;
                }
            }
        }

        public SVGPaintData k() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-515423538")) {
                return this.q;
            }
            return (SVGPaintData) ipChange.ipc$dispatch("-515423538", new Object[]{this});
        }

        public float l() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1782938878")) {
                return this.a;
            }
            return ((Float) ipChange.ipc$dispatch("-1782938878", new Object[]{this})).floatValue();
        }

        public List<String> m() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1769823953")) {
                return this.n;
            }
            return (List) ipChange.ipc$dispatch("-1769823953", new Object[]{this});
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1441154991")) {
                ipChange.ipc$dispatch("-1441154991", new Object[]{this});
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            String str4;
            String str5;
            float f2;
            float f3;
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "-72120528")) {
                ipChange.ipc$dispatch("-72120528", new Object[]{this, str, str2, str3, attributes});
            } else if (str2 != null) {
                this.r = str2;
                this.c.setAlpha(255);
                this.e.setAlpha(255);
                if (str2.equals("style")) {
                    if (TextUtils.equals("text/css", SVGXmlParser.m("type", attributes))) {
                        this.u = new StringBuilder();
                    }
                } else if (!this.m && str2.equals(com.alibaba.security.realidentity.jsbridge.a.V)) {
                    Path i3 = SVGXmlParser.i(SVGXmlParser.m("d", attributes));
                    if (i3 != null) {
                        SVGPath sVGPath = new SVGPath();
                        sVGPath.path = i3;
                        String m2 = SVGXmlParser.m("transform", attributes);
                        if (m2 != null) {
                            sVGPath.transformMatrix = SVGXmlParser.r(m2);
                        }
                        this.o.setAttributes(attributes);
                        i3.computeBounds(this.h, false);
                        sVGPath.rect = new RectF(this.h);
                        sVGPath.floorId = SVGXmlParser.m("floorId", attributes);
                        String m3 = SVGXmlParser.m("row_id", attributes);
                        sVGPath.rowId = m3;
                        if (sVGPath.floorId != null && m3 == null) {
                            Path path = new Path(i3);
                            Matrix matrix = sVGPath.transformMatrix;
                            if (matrix != null) {
                                path.transform(matrix);
                            }
                            sVGPath.locationList = g(n(sVGPath.rect, sVGPath.transformMatrix), sVGPath.floorId);
                            sVGPath.transformBound = path;
                        }
                        if (d(this.o, this.h)) {
                            sVGPath.fillPaint = new Paint(this.e);
                            sVGPath.fillColor = this.e.getColor();
                        }
                        if (f(this.o)) {
                            sVGPath.strokePaint = new Paint(this.c);
                            sVGPath.strokeColor = this.c.getColor();
                        }
                        this.q.addShape(106);
                        this.q.addPath(sVGPath);
                    }
                } else if (str2.equals("g")) {
                    this.o.setAttributes(attributes);
                    this.p.setAttributes(attributes);
                    if (this.m) {
                        this.l++;
                    }
                    if (("none".equals(SVGXmlParser.m("display", attributes)) || "none".equals(this.o.getString("display"))) && !this.m) {
                        this.m = true;
                        this.l = 1;
                    }
                    String attr = this.o.getAttr("opacity");
                    if (attr != null) {
                        this.b.addLast(Float.valueOf(a().floatValue() * SVGXmlParser.p(attr, 1.0f)));
                    }
                    if (this.o.getString("fill") != null) {
                        d(this.o, null);
                        this.f.addLast(new Paint(this.e));
                    }
                    if (this.o.getString("stroke") != null) {
                        f(this.o);
                        this.d.addLast(new Paint(this.c));
                    }
                    String m4 = SVGXmlParser.m("transform", attributes);
                    if (m4 != null) {
                        G g2 = new G();
                        g2.transformMatrix = SVGXmlParser.r(m4);
                        g2.isParseEnd = false;
                        this.q.addShape(102);
                        this.q.addG(g2);
                        this.g.add(m4);
                    }
                } else if (!this.m && (str2.equals("polygon") || str2.equals("polyline"))) {
                    c l2 = SVGXmlParser.l("points", attributes);
                    if (l2 != null) {
                        ArrayList<Float> arrayList = l2.a;
                        if (arrayList.size() > 1) {
                            SVGPolygon sVGPolygon = new SVGPolygon();
                            sVGPolygon.points = l2.a;
                            String m5 = SVGXmlParser.m("transform", attributes);
                            if (m5 != null) {
                                sVGPolygon.transformMatrix = SVGXmlParser.r(m5);
                            }
                            Path path2 = new Path();
                            path2.moveTo(arrayList.get(0).floatValue(), arrayList.get(1).floatValue());
                            for (int i4 = 2; i4 < arrayList.size(); i4 += 2) {
                                path2.lineTo(arrayList.get(i4).floatValue(), arrayList.get(i4 + 1).floatValue());
                            }
                            if (str2.equals("polygon")) {
                                path2.close();
                            }
                            path2.computeBounds(this.h, false);
                            sVGPolygon.path = path2;
                            sVGPolygon.rect = new RectF(this.h);
                            this.o.setAttributes(attributes);
                            sVGPolygon.floorId = SVGXmlParser.m("floorId", attributes);
                            String m6 = SVGXmlParser.m("row_id", attributes);
                            sVGPolygon.rowId = m6;
                            if (sVGPolygon.floorId != null && m6 == null) {
                                sVGPolygon.locationList = h(o(arrayList, sVGPolygon.transformMatrix), sVGPolygon.rect, sVGPolygon.floorId);
                            }
                            if (d(this.o, this.h)) {
                                sVGPolygon.fillPaint = new Paint(this.e);
                                sVGPolygon.fillColor = this.e.getColor();
                            }
                            if (f(this.o)) {
                                sVGPolygon.strokePaint = new Paint(this.c);
                                sVGPolygon.strokeColor = this.c.getColor();
                            }
                            this.q.addShape(105);
                            this.q.addPolygon(sVGPolygon);
                        }
                    }
                } else if (!this.m && (str2.equals("circle") || str2.equals("ellipse"))) {
                    if (str2.equals("ellipse")) {
                        str5 = SVGXmlParser.m("rx", attributes);
                        str4 = SVGXmlParser.m("ry", attributes);
                    } else {
                        str5 = SVGXmlParser.m(UploadQueueMgr.MSGTYPE_REALTIME, attributes);
                        str4 = str5;
                    }
                    if (!(str5 == null || str4 == null)) {
                        float k2 = SVGXmlParser.k("cx", attributes, 0.0f);
                        float k3 = SVGXmlParser.k("cy", attributes, 0.0f);
                        if (str2.equals("ellipse")) {
                            f3 = SVGXmlParser.p(str5, 0.0f);
                            f2 = SVGXmlParser.p(str4, 0.0f);
                        } else {
                            f3 = SVGXmlParser.p(str5, 0.0f);
                            f2 = f3;
                        }
                        SVGOval sVGOval = new SVGOval();
                        sVGOval.centerX = k2;
                        sVGOval.centerY = k3;
                        sVGOval.radiusX = f3;
                        sVGOval.radiusY = f2;
                        String m7 = SVGXmlParser.m("transform", attributes);
                        if (m7 != null) {
                            sVGOval.transformMatrix = SVGXmlParser.r(m7);
                        }
                        this.o.setAttributes(attributes);
                        this.h.set(k2 - f3, k3 - f2, k2 + f3, k3 + f2);
                        sVGOval.rect = new RectF(this.h);
                        sVGOval.floorId = SVGXmlParser.m("floorId", attributes);
                        String m8 = SVGXmlParser.m("row_id", attributes);
                        sVGOval.rowId = m8;
                        if (sVGOval.floorId != null && m8 == null) {
                            sVGOval.locationList = g(n(sVGOval.rect, sVGOval.transformMatrix), sVGOval.floorId);
                        }
                        if (d(this.o, this.h)) {
                            sVGOval.fillPaint = new Paint(this.e);
                            sVGOval.fillColor = this.e.getColor();
                        }
                        if (f(this.o)) {
                            sVGOval.strokePaint = new Paint(this.c);
                            sVGOval.strokeColor = this.c.getColor();
                        }
                        this.q.addShape(104);
                        this.q.addOval(sVGOval);
                    }
                } else if (!this.m && str2.equals("rect")) {
                    float k4 = SVGXmlParser.k(Constants.Name.X, attributes, 0.0f);
                    float k5 = SVGXmlParser.k(Constants.Name.Y, attributes, 0.0f);
                    float k6 = SVGXmlParser.k("width", attributes, 0.0f);
                    float k7 = SVGXmlParser.k("height", attributes, 0.0f);
                    float k8 = SVGXmlParser.k("rx", attributes, 0.0f);
                    float k9 = SVGXmlParser.k("ry", attributes, 0.0f);
                    SVGRect sVGRect = new SVGRect();
                    sVGRect.x = k4;
                    sVGRect.y = k5;
                    sVGRect.rx = k8;
                    sVGRect.ry = k9;
                    sVGRect.width = k6;
                    sVGRect.height = k7;
                    String m9 = SVGXmlParser.m("transform", attributes);
                    if (m9 != null) {
                        sVGRect.transformMatrix = SVGXmlParser.r(m9);
                    }
                    this.h.set(k4, k5, k6 + k4, k7 + k5);
                    sVGRect.rect = new RectF(this.h);
                    this.o.setAttributes(attributes);
                    sVGRect.floorId = SVGXmlParser.m("floorId", attributes);
                    String m10 = SVGXmlParser.m("row_id", attributes);
                    sVGRect.rowId = m10;
                    if (sVGRect.floorId != null && m10 == null) {
                        sVGRect.locationList = g(n(sVGRect.rect, sVGRect.transformMatrix), sVGRect.floorId);
                    }
                    if (d(this.o, this.h)) {
                        sVGRect.fillPaint = new Paint(this.e);
                        sVGRect.fillColor = this.e.getColor();
                    }
                    if (f(this.o)) {
                        sVGRect.strokePaint = new Paint(this.c);
                        sVGRect.strokeColor = this.c.getColor();
                    }
                    this.q.addShape(101);
                    this.q.addRect(sVGRect);
                } else if (!this.m && str2.equals("line")) {
                    SVGLine sVGLine = new SVGLine();
                    sVGLine.startX = SVGXmlParser.k("x1", attributes, 0.0f);
                    sVGLine.startY = SVGXmlParser.k("y1", attributes, 0.0f);
                    sVGLine.endX = SVGXmlParser.k("x2", attributes, 0.0f);
                    sVGLine.endY = SVGXmlParser.k("y2", attributes, 0.0f);
                    String m11 = SVGXmlParser.m("transform", attributes);
                    if (m11 != null) {
                        sVGLine.transformMatrix = SVGXmlParser.r(m11);
                    }
                    this.o.setAttributes(attributes);
                    if (f(this.o)) {
                        sVGLine.strokePaint = new Paint(this.c);
                        sVGLine.strokeColor = this.c.getColor();
                    }
                    this.q.addShape(103);
                    this.q.addLine(sVGLine);
                } else if (str2.equals("svg")) {
                    this.a = p(attributes);
                    String m12 = SVGXmlParser.m("viewBox", attributes);
                    if (m12 != null) {
                        String[] split = m12.replace(',', ' ').split("\\s+");
                        if (split.length == 4) {
                            float p2 = SVGXmlParser.p(split[0], 0.0f);
                            float p3 = SVGXmlParser.p(split[1], 0.0f);
                            float p4 = SVGXmlParser.p(split[2], 0.0f);
                            float p5 = SVGXmlParser.p(split[3], 0.0f);
                            float ceil = (float) Math.ceil((double) (p4 - p2));
                            float ceil2 = (float) Math.ceil((double) (p5 - p3));
                            if (ceil > 0.0f && ceil2 > 0.0f) {
                                this.q.setSVGHeightAndWidth((int) ceil, (int) ceil2, true, p2, p3);
                                i2 = 1;
                            } else {
                                return;
                            }
                        }
                    }
                    if (i2 == 0) {
                        String m13 = SVGXmlParser.m("width", attributes);
                        String m14 = SVGXmlParser.m("height", attributes);
                        float f4 = 3000.0f;
                        float p6 = (TextUtils.isEmpty(m13) || m13.endsWith("%")) ? 3000.0f : SVGXmlParser.p(m13, 3000.0f);
                        if (!TextUtils.isEmpty(m14) && !m14.endsWith("%")) {
                            f4 = SVGXmlParser.p(m14, 3000.0f);
                        }
                        this.q.setSVGHeightAndWidth((int) ((float) Math.ceil((double) p6)), (int) ((float) Math.ceil((double) f4)), false, 0.0f, 0.0f);
                    }
                } else if (!str2.equals("defs")) {
                    if (str2.equals("linearGradient")) {
                        this.k = e(true, attributes);
                    } else if (str2.equals("radialGradient")) {
                        this.k = e(false, attributes);
                    } else if (str2.equals("stop")) {
                        if (this.k != null) {
                            this.o.setAttributes(attributes);
                            Integer color = this.o.getColor("stop-color");
                            if (color != null) {
                                i2 = color.intValue() | (Math.round((this.o.getFloat("stop-opacity", 1.0f) * a().floatValue()) * 255.0f) << 24);
                            }
                            this.k.l.add(Integer.valueOf(i2));
                            this.k.k.add(Float.valueOf(this.o.getFloat("offset", 0.0f)));
                        }
                    } else if (!this.m && str2.equals("text")) {
                        this.t = "";
                        this.s = new SVGText();
                        float n2 = SVGXmlParser.n("dx", attributes, 0.0f);
                        float n3 = SVGXmlParser.n(Constants.Name.DISTANCE_Y, attributes, 0.0f);
                        this.s.x = SVGXmlParser.n(Constants.Name.X, attributes, 0.0f) + n2;
                        this.s.y = SVGXmlParser.n(Constants.Name.Y, attributes, 0.0f) + n3;
                        String m15 = SVGXmlParser.m("transform", attributes);
                        if (m15 != null) {
                            this.s.transformMatrix = SVGXmlParser.r(m15);
                        }
                        this.o.setAttributes(attributes);
                        String string = this.o.getString("font-size");
                        if (TextUtils.isEmpty(string)) {
                            string = this.p.getString("font-size");
                        }
                        this.s.textSize = SVGXmlParser.p(string, 40.0f);
                        String string2 = this.o.getString("text-anchor");
                        if (TextUtils.isEmpty(string2)) {
                            string2 = this.p.getAttr("text-anchor");
                        }
                        if (d(this.o, this.h) && this.e.getColor() != 0) {
                            this.s.fillPaint = new Paint(this.e);
                            this.s.fillColor = this.e.getColor();
                            if ("middle".equals(string2)) {
                                this.s.fillPaint.setTextAlign(Paint.Align.CENTER);
                            } else if ("end".equals(string2)) {
                                this.s.fillPaint.setTextAlign(Paint.Align.RIGHT);
                            } else {
                                this.s.fillPaint.setTextAlign(Paint.Align.LEFT);
                            }
                        }
                        if (f(this.o)) {
                            this.s.strokePaint = new Paint(this.c);
                            this.s.strokeColor = this.c.getColor();
                            if ("middle".equals(string2)) {
                                this.s.strokePaint.setTextAlign(Paint.Align.CENTER);
                            } else if ("end".equals(string2)) {
                                this.s.strokePaint.setTextAlign(Paint.Align.RIGHT);
                            } else {
                                this.s.strokePaint.setTextAlign(Paint.Align.LEFT);
                            }
                        }
                    } else if (!this.m) {
                        g91.g("SVGAndroid", "UNRECOGNIZED SVG COMMAND: " + str2);
                        if (!this.n.contains(str2)) {
                            this.n.add(str2);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class e {
        private static transient /* synthetic */ IpChange $ipChange;
        HashMap<String, String> a;

        public e(String str) {
            HashMap<String, String> hashMap = new HashMap<>();
            this.a = hashMap;
            hashMap.clear();
            for (String str2 : str.split(";")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    this.a.put(split[0].trim(), split[1].trim());
                }
            }
        }

        public String a(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-726615158")) {
                return this.a.get(str);
            }
            return (String) ipChange.ipc$dispatch("-726615158", new Object[]{this, str});
        }
    }

    private static float h(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-427380601")) {
            return ((float) Math.toDegrees(Math.atan2((double) f, (double) f2) - Math.atan2((double) f3, (double) f4))) % 360.0f;
        }
        return ((Float) ipChange.ipc$dispatch("-427380601", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})).floatValue();
    }

    /* access modifiers changed from: private */
    public static Path i(String str) {
        char c2;
        char c3;
        char c4;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1171217378")) {
            return (Path) ipChange.ipc$dispatch("1171217378", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            Path path = new Path();
            int length = str.length();
            ro1 ro1 = new ro1(str, 0);
            ro1.i();
            float f6 = 0.0f;
            char c5 = 0;
            float f7 = 0.0f;
            float f8 = 0.0f;
            char c6 = 0;
            float f9 = 0.0f;
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (true) {
                int i = ro1.d;
                if (i >= length) {
                    return path;
                }
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        if (c5 != 'm' && c5 != 'M') {
                            if ("lhvcsqta".indexOf(Character.toLowerCase(c5)) >= 0) {
                                c3 = c5;
                                c2 = c6;
                                break;
                            }
                        } else {
                            c2 = c6;
                            c5 = (char) (c5 - 1);
                            c3 = c5;
                            break;
                        }
                        break;
                    case '/':
                    default:
                        ro1.a();
                        c2 = c5;
                        c3 = charAt;
                        c5 = c3;
                        break;
                }
                switch (c5) {
                    case 'A':
                    case 'a':
                        c4 = c2;
                        float d2 = ro1.d();
                        float d3 = ro1.d();
                        float d4 = ro1.d();
                        int c7 = ro1.c();
                        int c8 = ro1.c();
                        float d5 = ro1.d();
                        float d6 = ro1.d();
                        if (c5 == 'a') {
                            d5 += f7;
                            d6 += f8;
                        }
                        j(path, f7, f8, d5, d6, d2, d3, d4, c7, c8);
                        f10 = f10;
                        f7 = d5;
                        f8 = d6;
                        f9 = f9;
                        z = false;
                        break;
                    case 'C':
                    case 'c':
                        c4 = c2;
                        float d7 = ro1.d();
                        float d8 = ro1.d();
                        float d9 = ro1.d();
                        float d10 = ro1.d();
                        float d11 = ro1.d();
                        float d12 = ro1.d();
                        if (c5 == 'c') {
                            d7 += f7;
                            d9 += f7;
                            d11 += f7;
                            d8 += f8;
                            d10 += f8;
                            d12 += f8;
                        }
                        path.cubicTo(d7, d8, d9, d10, d11, d12);
                        f7 = d11;
                        f8 = d12;
                        f12 = d10;
                        f11 = d9;
                        z = true;
                        break;
                    case 'H':
                    case 'h':
                        c4 = c2;
                        float d13 = ro1.d();
                        if (c5 == 'h') {
                            path.rLineTo(d13, 0.0f);
                            f7 += d13;
                        } else {
                            path.lineTo(d13, f8);
                            f7 = d13;
                        }
                        z = false;
                        break;
                    case 'L':
                    case 'l':
                        c4 = c2;
                        f2 = ro1.d();
                        f = ro1.d();
                        if (c5 == 'l') {
                            path.rLineTo(f2, f);
                            f7 += f2;
                            f8 += f;
                            z = false;
                            break;
                        } else {
                            path.lineTo(f2, f);
                            f7 = f2;
                            f8 = f;
                            z = false;
                        }
                    case 'M':
                    case 'm':
                        c4 = c2;
                        f2 = ro1.d();
                        f = ro1.d();
                        if (c5 == 'm') {
                            f10 += f2;
                            f9 += f;
                            path.rMoveTo(f2, f);
                            f7 += f2;
                            f8 += f;
                            z = false;
                            break;
                        } else {
                            path.moveTo(f2, f);
                            f7 = f2;
                            f10 = f7;
                            f8 = f;
                            f9 = f8;
                            z = false;
                        }
                    case 'Q':
                    case 'q':
                        c4 = c2;
                        float d14 = ro1.d();
                        float d15 = ro1.d();
                        float d16 = ro1.d();
                        float d17 = ro1.d();
                        if (Character.isLowerCase(c5)) {
                            d14 += f7;
                            d16 += f7;
                            d15 += f8;
                            d17 += f8;
                        }
                        f7 = d16;
                        f8 = d17;
                        path.quadTo(d14, d15, f7, f8);
                        f11 = d14;
                        f12 = d15;
                        z = true;
                        break;
                    case 'S':
                    case 's':
                        float d18 = ro1.d();
                        float d19 = ro1.d();
                        float d20 = ro1.d();
                        float d21 = ro1.d();
                        if (Character.isLowerCase(c5)) {
                            d18 += f7;
                            d20 += f7;
                            d19 += f8;
                            d21 += f8;
                        }
                        if (c2 == 'C' || c2 == 'c' || c2 == 'S' || c2 == 's') {
                            float f13 = (f7 * 2.0f) - f11;
                            float f14 = (f8 * 2.0f) - f12;
                            f5 = d20;
                            f4 = d19;
                            f3 = d18;
                            c4 = c2;
                            path.cubicTo(f13, f14, d18, d19, f5, d21);
                        } else {
                            path.quadTo(d18, d19, d20, d21);
                            f5 = d20;
                            f4 = d19;
                            f3 = d18;
                            c4 = c2;
                        }
                        f8 = d21;
                        f7 = f5;
                        z = true;
                        f12 = f4;
                        f11 = f3;
                        break;
                    case 'T':
                    case 't':
                        float d22 = ro1.d();
                        float d23 = ro1.d();
                        if (c2 == 'T' || c2 == 't' || c2 == 'Q' || c2 == 'q') {
                            if (Character.isLowerCase(c5)) {
                                d22 += f7;
                                d23 += f8;
                            }
                            path.quadTo((f7 - f11) + f7, (f8 - f12) + f8, d22, d23);
                        } else if (Character.isLowerCase(c5)) {
                            path.rLineTo(d22, d23);
                            d22 += f7;
                            d23 += f8;
                        } else {
                            path.lineTo(d22, d23);
                        }
                        f7 = d22;
                        f8 = d23;
                        c4 = c2;
                        z = false;
                        break;
                    case 'V':
                    case 'v':
                        float d24 = ro1.d();
                        if (c5 == 'v') {
                            path.rLineTo(f6, d24);
                            f8 += d24;
                        } else {
                            path.lineTo(f7, d24);
                            f8 = d24;
                        }
                        c4 = c2;
                        z = false;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f10, f9);
                        c4 = c2;
                        f8 = f9;
                        f12 = f8;
                        f7 = f10;
                        f11 = f7;
                        break;
                    default:
                        c4 = c2;
                        g91.c("SVGAndroid", "Invalid path command: " + c5);
                        ro1.a();
                        z = false;
                        break;
                }
                if (!z) {
                    f11 = f7;
                    f12 = f8;
                }
                ro1.i();
                c5 = c3;
                c6 = c4;
                z = true;
                f6 = 0.0f;
            }
        }
    }

    private static void j(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
        float f8;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218272316")) {
            ipChange.ipc$dispatch("-218272316", new Object[]{path, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (f5 == 0.0f || f6 == 0.0f) {
            path.lineTo(f3, f4);
        } else if (f3 != f || f4 != f2) {
            float abs = Math.abs(f5);
            float abs2 = Math.abs(f6);
            double d2 = (double) ((3.1415927f * f7) / 180.0f);
            float sin = (float) Math.sin(d2);
            float cos = (float) Math.cos(d2);
            float f9 = (f - f3) / 2.0f;
            float f10 = (f2 - f4) / 2.0f;
            float f11 = (cos * f9) + (sin * f10);
            float f12 = ((-sin) * f9) + (f10 * cos);
            float f13 = f11 * f11;
            float f14 = f12 * f12;
            float f15 = abs * abs;
            float f16 = abs2 * abs2;
            float f17 = ((f13 / f15) + (f14 / f16)) * 1.001f;
            if (f17 > 1.0f) {
                float sqrt = (float) Math.sqrt((double) f17);
                abs *= sqrt;
                abs2 *= sqrt;
                f15 = abs * abs;
                f16 = abs2 * abs2;
            }
            float f18 = f15 * f16;
            float f19 = f15 * f14;
            float f20 = f16 * f13;
            double sqrt2 = Math.sqrt((double) (((f18 - f19) - f20) / (f19 + f20)));
            if (i == i2) {
                i3 = -1;
                f8 = abs;
            } else {
                f8 = abs;
                i3 = 1;
            }
            float f21 = (float) (sqrt2 * ((double) i3));
            float f22 = ((f21 * f8) * f12) / abs2;
            float f23 = (((-f21) * abs2) * f11) / f8;
            float f24 = ((cos * f22) - (sin * f23)) + ((f + f3) / 2.0f);
            float f25 = (sin * f22) + (cos * f23) + ((f2 + f4) / 2.0f);
            float f26 = (f11 - f22) / f8;
            float f27 = (f12 - f23) / abs2;
            float h = h(1.0f, 0.0f, f26, f27);
            float h2 = h(f26, f27, ((-f11) - f22) / f8, ((-f12) - f23) / abs2);
            if (i2 == 0 && h2 > 0.0f) {
                h2 -= 360.0f;
            } else if (i2 != 0 && h2 < 0.0f) {
                h2 += 360.0f;
            }
            if (f7 % 360.0f == 0.0f) {
                RectF rectF = c;
                rectF.set(f24 - f8, f25 - abs2, f24 + f8, f25 + abs2);
                path.arcTo(rectF, h, h2);
                return;
            }
            RectF rectF2 = c;
            rectF2.set(-f8, -abs2, f8, abs2);
            Matrix matrix = d;
            matrix.reset();
            matrix.postRotate(f7);
            matrix.postTranslate(f24, f25);
            Matrix matrix2 = e;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.arcTo(rectF2, h, h2);
            path.transform(matrix);
        }
    }

    /* access modifiers changed from: private */
    public static float k(String str, Attributes attributes, float f) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-682665843")) {
            return p(m(str, attributes), f);
        }
        return ((Float) ipChange.ipc$dispatch("-682665843", new Object[]{str, attributes, Float.valueOf(f)})).floatValue();
    }

    /* access modifiers changed from: private */
    public static c l(String str, Attributes attributes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382387457")) {
            return (c) ipChange.ipc$dispatch("-382387457", new Object[]{str, attributes});
        } else if (str == null) {
            return null;
        } else {
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                if (attributes.getLocalName(i).trim().equals(str)) {
                    return q(attributes.getValue(i).trim());
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static String m(String str, Attributes attributes) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-325127660")) {
            return (String) ipChange.ipc$dispatch("-325127660", new Object[]{str, attributes});
        } else if (str == null) {
            return null;
        } else {
            int length = attributes.getLength();
            for (int i = 0; i < length; i++) {
                if (attributes.getLocalName(i).trim().equals(str)) {
                    return attributes.getValue(i).trim();
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static float n(String str, Attributes attributes, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842555616")) {
            return ((Float) ipChange.ipc$dispatch("-1842555616", new Object[]{str, attributes, Float.valueOf(f)})).floatValue();
        }
        String m = m(str, attributes);
        if (m != null && m.contains(" ")) {
            m = m.split(" ")[0];
        }
        return p(m, f);
    }

    public static SVGPaintData o(InputSource inputSource, d dVar) throws SVGParseException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951691981")) {
            return (SVGPaintData) ipChange.ipc$dispatch("1951691981", new Object[]{inputSource, dVar});
        }
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(dVar);
            xMLReader.setFeature("http://xml.org/sax/features/validation", false);
            if (a) {
                try {
                    xMLReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                } catch (SAXNotRecognizedException unused) {
                    a = false;
                }
            }
            xMLReader.parse(inputSource);
            SVGPaintData k = dVar.k();
            k.setSvgScale(dVar.l());
            k.setUnrecognizedCommandList(dVar.m());
            return k;
        } catch (Exception e2) {
            throw new SVGParseException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static float p(String str, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236474596")) {
            return ((Float) ipChange.ipc$dispatch("236474596", new Object[]{str, Float.valueOf(f)})).floatValue();
        } else if (str == null) {
            return f;
        } else {
            if (str.endsWith("px") && str.length() > 2) {
                str = str.substring(0, str.length() - 2);
            } else if (str.endsWith("%") && str.length() > 1) {
                try {
                    return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
                } catch (Exception unused) {
                    return f;
                }
            } else if (str.endsWith("pt") && str.length() > 2) {
                try {
                    return Float.parseFloat(str.substring(0, str.length() - 2)) * 1.25f;
                } catch (NumberFormatException unused2) {
                    return f;
                }
            }
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException unused3) {
                return f;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r7 != false) goto L_0x0031;
     */
    private static c q(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195581663")) {
            return (c) ipChange.ipc$dispatch("-195581663", new Object[]{str});
        }
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 1; i2 < length; i2++) {
            if (!z) {
                char charAt = str.charAt(i2);
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case ' ':
                    case ',':
                        String substring = str.substring(i, i2);
                        if (substring.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring)));
                            if (charAt == '-') {
                                i = i2;
                            } else {
                                i = i2 + 1;
                                z = true;
                            }
                        } else {
                            i++;
                        }
                        z2 = false;
                        break;
                    case ')':
                    case 'A':
                    case 'C':
                    case 'H':
                    case 'L':
                    case 'M':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'V':
                    case 'Z':
                    case 'a':
                    case 'c':
                    case 'h':
                    case 'l':
                    case 'm':
                    case 'q':
                    case 's':
                    case 't':
                    case 'v':
                    case 'z':
                        String substring2 = str.substring(i, i2);
                        if (substring2.trim().length() > 0) {
                            arrayList.add(Float.valueOf(Float.parseFloat(substring2)));
                        }
                        return new c(arrayList, i2);
                    case '-':
                        break;
                    case 'e':
                        z2 = true;
                        break;
                    default:
                        z2 = false;
                        break;
                }
            } else {
                z = false;
            }
        }
        String substring3 = str.substring(i);
        if (substring3.length() > 0) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(substring3)));
            } catch (NumberFormatException unused) {
            }
            i = str.length();
        }
        return new c(arrayList, i);
    }

    /* access modifiers changed from: private */
    public static Matrix r(String str) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143695427")) {
            return (Matrix) ipChange.ipc$dispatch("-143695427", new Object[]{str});
        }
        Matrix matrix = new Matrix();
        while (true) {
            s(str, matrix);
            int indexOf = str.indexOf(jl1.BRACKET_END_STR);
            if (indexOf <= 0 || str.length() <= (i = indexOf + 1)) {
                return matrix;
            }
            str = b.matcher(str.substring(i)).replaceFirst("");
        }
        return matrix;
    }

    private static Matrix s(String str, Matrix matrix) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076414666")) {
            return (Matrix) ipChange.ipc$dispatch("1076414666", new Object[]{str, matrix});
        } else if (str == null) {
            return matrix;
        } else {
            float f2 = 0.0f;
            if (str.startsWith("matrix(")) {
                c q = q(str.substring(7));
                if (q.a.size() == 6) {
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{((Float) q.a.get(0)).floatValue(), ((Float) q.a.get(2)).floatValue(), ((Float) q.a.get(4)).floatValue(), ((Float) q.a.get(1)).floatValue(), ((Float) q.a.get(3)).floatValue(), ((Float) q.a.get(5)).floatValue(), 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                }
            } else if (str.startsWith("translate(")) {
                c q2 = q(str.substring(10));
                if (q2.a.size() > 0) {
                    float floatValue = ((Float) q2.a.get(0)).floatValue();
                    if (q2.a.size() > 1) {
                        f2 = ((Float) q2.a.get(1)).floatValue();
                    }
                    matrix.preTranslate(floatValue, f2);
                }
            } else if (str.startsWith("scale(")) {
                c q3 = q(str.substring(6));
                if (q3.a.size() > 0) {
                    float floatValue2 = ((Float) q3.a.get(0)).floatValue();
                    matrix.preScale(floatValue2, q3.a.size() > 1 ? ((Float) q3.a.get(1)).floatValue() : floatValue2);
                }
            } else if (str.startsWith("skewX(")) {
                c q4 = q(str.substring(6));
                if (q4.a.size() > 0) {
                    matrix.preSkew((float) Math.tan((double) ((Float) q4.a.get(0)).floatValue()), 0.0f);
                }
            } else if (str.startsWith("skewY(")) {
                c q5 = q(str.substring(6));
                if (q5.a.size() > 0) {
                    matrix.preSkew(0.0f, (float) Math.tan((double) ((Float) q5.a.get(0)).floatValue()));
                }
            } else if (str.startsWith("rotate(")) {
                c q6 = q(str.substring(7));
                if (q6.a.size() > 0) {
                    float floatValue3 = ((Float) q6.a.get(0)).floatValue();
                    if (q6.a.size() > 2) {
                        f2 = ((Float) q6.a.get(1)).floatValue();
                        f = ((Float) q6.a.get(2)).floatValue();
                    } else {
                        f = 0.0f;
                    }
                    matrix.preTranslate(-f2, -f);
                    matrix.preRotate(floatValue3);
                    matrix.preTranslate(f2, f);
                }
            } else {
                g91.c("SVGAndroid", "Invalid transform (" + str + jl1.BRACKET_END_STR);
            }
            return matrix;
        }
    }
}
