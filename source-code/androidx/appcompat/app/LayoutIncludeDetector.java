package androidx.appcompat.app;

import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Taobao */
class LayoutIncludeDetector {
    @NonNull
    private final Deque<WeakReference<XmlPullParser>> mXmlParserStack = new ArrayDeque();

    LayoutIncludeDetector() {
    }

    private static boolean isParserOutdated(@Nullable XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return true;
        }
        try {
            if (xmlPullParser.getEventType() == 3 || xmlPullParser.getEventType() == 1) {
                return true;
            }
            return false;
        } catch (XmlPullParserException unused) {
            return true;
        }
    }

    @Nullable
    private static XmlPullParser popOutdatedAttrHolders(@NonNull Deque<WeakReference<XmlPullParser>> deque) {
        while (!deque.isEmpty()) {
            XmlPullParser xmlPullParser = deque.peek().get();
            if (!isParserOutdated(xmlPullParser)) {
                return xmlPullParser;
            }
            deque.pop();
        }
        return null;
    }

    private static boolean shouldInheritContext(@NonNull XmlPullParser xmlPullParser, @Nullable XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() == 2) {
                return "include".equals(xmlPullParser2.getName());
            }
            return false;
        } catch (XmlPullParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean detect(@NonNull AttributeSet attributeSet) {
        if (!(attributeSet instanceof XmlPullParser)) {
            return false;
        }
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        if (xmlPullParser.getDepth() != 1) {
            return false;
        }
        XmlPullParser popOutdatedAttrHolders = popOutdatedAttrHolders(this.mXmlParserStack);
        this.mXmlParserStack.push(new WeakReference<>(xmlPullParser));
        if (shouldInheritContext(xmlPullParser, popOutdatedAttrHolders)) {
            return true;
        }
        return false;
    }
}
