package tb;

import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.Platform;
import com.real.android.nativehtml.common.io.RequestHandler;
import com.taobao.weex.adapter.URIAdapter;
import com.youku.live.livesdk.wkit.component.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
public class sa0 {
    private static final LinkedHashMap<String, ElementType> g = new LinkedHashMap<>();
    private static final LinkedHashMap<String, ContentType> h = new LinkedHashMap<>();
    private final Platform a;
    private final bz2 b;
    private RequestHandler c;
    private URI d;
    private Element e;
    private Element f;

    static {
        ElementType elementType = ElementType.FORMATTED_TEXT;
        ContentType contentType = ContentType.FORMATTED_TEXT;
        a("a", elementType, contentType);
        a("b", elementType, contentType);
        a("big", elementType, contentType);
        ContentType contentType2 = ContentType.EMPTY;
        a(BrightRemindSetting.BRIGHT_REMIND, elementType, contentType2);
        a("del", elementType, contentType);
        a("em", elementType, contentType);
        a(URIAdapter.FONT, elementType, contentType);
        ElementType elementType2 = ElementType.DATA;
        ContentType contentType3 = ContentType.DATA_ELEMENTS;
        a("head", elementType2, contentType3);
        ElementType elementType3 = ElementType.SKIP;
        ContentType contentType4 = ContentType.COMPONENTS;
        a("html", elementType3, contentType4);
        a("i", elementType, contentType);
        a("img", ElementType.INLINE_IMAGE, contentType2);
        ElementType elementType4 = ElementType.COMPONENT;
        a("input", elementType4, contentType2);
        a("ins", elementType, contentType);
        a(URIAdapter.LINK, elementType2, contentType2);
        a("meta", elementType2, contentType2);
        ContentType contentType5 = ContentType.TEXT_ONLY;
        a("option", elementType2, contentType5);
        a("script", elementType2, contentType5);
        a("select", elementType4, contentType3);
        a("small", elementType, contentType);
        a("span", elementType, contentType);
        a("strike", elementType, contentType);
        a("strong", elementType, contentType);
        a("style", elementType2, contentType5);
        a("sub", elementType, contentType);
        a("sup", elementType, contentType);
        a("tbody", elementType3, contentType4);
        a("text-component", elementType4, contentType);
        a("thead", elementType3, contentType4);
        a("title", elementType2, contentType5);
        a(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, elementType, contentType);
        a(IRequestConst.U, elementType, contentType);
    }

    public sa0(Platform platform, RequestHandler requestHandler, bz2 bz2, URI uri) {
        this.a = platform;
        this.c = requestHandler;
        if (bz2 == null) {
            bz2 bz22 = new bz2();
            this.b = bz22;
            bz22.b(platform.getPixelPerDp());
        } else {
            this.b = bz2;
        }
        this.d = uri;
    }

    static void a(String str, ElementType elementType, ContentType contentType) {
        g.put(str, elementType);
        h.put(str, contentType);
    }

    private static ContentType c(String str) {
        ContentType contentType = h.get(str);
        return contentType == null ? ContentType.COMPONENTS : contentType;
    }

    public static ElementType d(String str) {
        ElementType elementType = g.get(str);
        return elementType == null ? ElementType.COMPONENT : elementType;
    }

    public Element b(String str) {
        ElementType d2 = d(str);
        Element createElement = this.a.createElement(this, d2, str);
        return createElement == null ? new vc0(this, str, d2, c(str)) : createElement;
    }

    public Element e() {
        return this.e;
    }

    public Platform f() {
        return this.a;
    }

    public RequestHandler g() {
        return this.c;
    }

    public bz2 h() {
        return this.b;
    }

    public URI i() {
        return this.d;
    }

    public URI j(String str) {
        int i;
        if (!this.d.isOpaque()) {
            return this.d.resolve(str);
        }
        try {
            URI uri = new URI(str);
            if (uri.isAbsolute()) {
                return uri;
            }
            String uri2 = this.d.toString();
            if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                i = uri2.indexOf(35);
                if (i == -1) {
                    i = uri2.length();
                }
            } else {
                i = uri2.lastIndexOf(47) + 1;
            }
            return new URI(uri2.substring(0, i) + str);
        } catch (URISyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void k(Element element) {
        this.f = element;
    }

    public void l(Element element) {
        this.e = element;
    }
}
