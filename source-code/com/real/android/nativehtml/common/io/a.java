package com.real.android.nativehtml.common.io;

import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.real.android.nativehtml.common.dom.ContentType;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.ElementType;
import com.real.android.nativehtml.common.dom.Platform;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.xmlpull.v1.XmlPullParserException;
import tb.bz2;
import tb.kp;
import tb.sa0;

/* compiled from: Taobao */
public class a {
    private final HtmlNormalizer a;
    private final Platform b;
    private kp c;
    private sa0 d;
    private bz2 e;
    private RequestHandler f;
    String g = "";

    /* access modifiers changed from: package-private */
    /* renamed from: com.real.android.nativehtml.common.io.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class C0192a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            int[] iArr = new int[ContentType.values().length];
            a = iArr;
            iArr[ContentType.COMPONENTS.ordinal()] = 1;
            a[ContentType.DATA_ELEMENTS.ordinal()] = 2;
            try {
                a[ContentType.TEXT_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public a(Platform platform, RequestHandler requestHandler, bz2 bz2) {
        this.b = platform;
        this.f = requestHandler;
        this.e = bz2;
        try {
            this.a = new HtmlNormalizer();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String a(String str, boolean z) {
        boolean z2 = !z;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt > ' ') {
                sb.append(charAt);
                z2 = false;
            } else if (!z2) {
                sb.append(' ');
                z2 = true;
            }
        }
        return sb.toString();
    }

    private void c(Element element) throws IOException, XmlPullParserException {
        while (this.a.e() != 3 && this.a.e() != 1) {
            if ((this.a.e() != 2 && this.a.e() != 4) || (this.a.e() == 4 && this.a.h().trim().isEmpty())) {
                this.a.i();
            } else if (this.a.e() != 2 || sa0.d(this.a.f()) == ElementType.FORMATTED_TEXT) {
                g(element);
            } else if (sa0.d(this.a.f()).equals(ElementType.SKIP)) {
                this.a.i();
                c(element);
                this.a.i();
            } else {
                Element e2 = e();
                if (e2.getElementType() == ElementType.COMPONENT) {
                    element.insertBefore(e2, null);
                } else if (e2.getLocalName().equals("head") && this.d.e() == null) {
                    this.d.l(e2);
                }
                this.a.i();
            }
        }
    }

    private void d(Element element) throws IOException, XmlPullParserException {
        while (this.a.e() != 3 && this.a.e() != 1) {
            if (this.a.e() == 2) {
                element.insertBefore(e(), null);
            }
            this.a.i();
        }
    }

    private Element e() throws IOException, XmlPullParserException {
        this.g += AltriaXLaunchTime.SPACE;
        Element b2 = this.d.b(this.a.f());
        for (int i = 0; i < this.a.a(); i++) {
            b2.setAttribute(this.a.b(i), this.a.c(i));
        }
        this.a.i();
        int i2 = C0192a.a[b2.getElementContentType().ordinal()];
        if (i2 == 1) {
            c(b2);
        } else if (i2 == 2) {
            d(b2);
        } else if (i2 != 3) {
            f(null);
        } else {
            StringBuilder sb = new StringBuilder();
            f(sb);
            String sb2 = sb.toString();
            if ("style".equals(b2.getLocalName())) {
                this.c.k(sb2, this.d.i(), new int[0], null, null);
            }
            b2.setTextContent(sb2);
        }
        this.g = this.g.substring(2);
        return b2;
    }

    private void f(StringBuilder sb) throws IOException, XmlPullParserException {
        while (this.a.e() != 3) {
            int e2 = this.a.e();
            if (e2 == 2) {
                this.a.i();
                f(sb);
                this.a.i();
            } else if (e2 == 4) {
                if (sb != null) {
                    sb.append(this.a.h());
                }
                this.a.i();
            } else {
                throw new RuntimeException("Unexpected event: " + this.a.g());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        if (r0 != r4) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    private void g(Element element) throws IOException, XmlPullParserException {
        Element b2 = this.d.b("text-component");
        element.insertBefore(b2, null);
        if (b2 != null) {
            Element element2 = b2;
            while (true) {
                boolean z = false;
                while (true) {
                    int e2 = this.a.e();
                    if (e2 == 1) {
                        return;
                    }
                    if (e2 == 2) {
                        ElementType d2 = sa0.d(this.a.f());
                        if (!(d2 == ElementType.FORMATTED_TEXT || d2 == ElementType.INLINE_IMAGE)) {
                            break;
                        }
                        if (this.a.f().equals(BrightRemindSetting.BRIGHT_REMIND)) {
                            z = false;
                        }
                        Element b3 = this.d.b(this.a.f());
                        for (int i = 0; i < this.a.a(); i++) {
                            b3.setAttribute(this.a.b(i), this.a.c(i));
                        }
                        b2.insertBefore(b3, null);
                        this.a.i();
                        b2 = b3;
                    } else if (e2 != 3) {
                        if (e2 != 4) {
                            this.a.i();
                        } else {
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(a(this.a.h(), z));
                                z = sb.length() > 0 && sb.charAt(sb.length() - 1) > ' ';
                                this.a.i();
                            } while (this.a.e() == 4);
                            Element b4 = this.d.b("span");
                            b4.setTextContent(sb.toString());
                            b2.insertBefore(b4, null);
                        }
                    } else if (b2 == element2) {
                        return;
                    } else {
                        if (b2.getParentElement() != null) {
                            b2 = b2.getParentElement();
                            this.a.i();
                        } else {
                            throw new RuntimeException("null parent for " + b2 + b2.getClass());
                        }
                    }
                }
                element.insertBefore(e(), null);
                Element b5 = this.d.b("text-component");
                b2 = h(b2, element2, b5);
                element.insertBefore(b5, null);
                this.a.i();
                element2 = b5;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public Element b(Reader reader, URI uri) {
        try {
            this.a.j(reader);
            this.a.i();
            this.d = new sa0(this.b, this.f, this.e, uri);
            this.c = kp.f(20);
            Element b2 = this.d.b("body");
            c(b2);
            if (b2.getChildren().getLength() == 1) {
                b2 = b2.getChildren().item(0);
                b2.setParentElement(null);
            }
            this.d.k(b2);
            this.c.a(b2, this.d.i());
            return b2;
        } catch (XmlPullParserException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public Element h(Element element, Element element2, Element element3) {
        if (element.getParentElement() != element2) {
            element3 = h(element.getParentElement(), element2, element3);
        }
        Element b2 = this.d.b(element.getLocalName());
        element3.insertBefore(b2, null);
        return b2;
    }
}
