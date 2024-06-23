package com.real.android.nativehtml.android;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.io.InternalLinkHandler;
import com.real.android.nativehtml.common.io.a;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import tb.d50;
import tb.n21;

/* compiled from: Taobao */
public class HtmlView extends FrameLayout implements InternalLinkHandler {
    private static boolean mIsOneLine;
    private a htmlParser;
    private d50 requestHandler;

    public HtmlView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        AndroidPlatform androidPlatform = new AndroidPlatform(context);
        d50 d50 = new d50(androidPlatform);
        this.requestHandler = d50;
        d50.c(this);
        this.htmlParser = new a(androidPlatform, this.requestHandler, null);
        reset();
    }

    public static boolean isTextOneLine() {
        return mIsOneLine;
    }

    public static boolean isXml(String str) {
        try {
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(str)));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void reset() {
        mIsOneLine = false;
    }

    public static void setTextOneLine(boolean z) {
        mIsOneLine = z;
    }

    public void addInternalLinkPrefix(String str) {
        this.requestHandler.a(str);
    }

    public void loadHtml(URI uri) {
        this.requestHandler.b(uri);
    }

    @Override // com.real.android.nativehtml.common.io.InternalLinkHandler
    public void loadHtml(Reader reader, URI uri) {
        Element b = this.htmlParser.b(reader, uri);
        removeAllViews();
        if (b instanceof AbstractAndroidComponentElement) {
            addView((AbstractAndroidComponentElement) b);
        }
    }

    public HtmlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public HtmlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init() {
        reset();
    }

    public void loadHtml(String str) {
        try {
            if (!isXml(str)) {
                str = "<p>" + str + "</p>";
            }
            Element b = this.htmlParser.b(n21.a(str), URI.create("temp.html"));
            removeAllViews();
            if (b instanceof AbstractAndroidComponentElement) {
                addView((AbstractAndroidComponentElement) b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
