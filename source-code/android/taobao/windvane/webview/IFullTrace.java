package android.taobao.windvane.webview;

import android.taobao.windvane.fullspan.SpanWrapper;
import com.taobao.analysis.v3.FalcoSpan;
import java.util.Map;

/* compiled from: Taobao */
public interface IFullTrace {
    FalcoSpan getFalcoSpan();

    Map<String, String> getOpenTracingContext();

    SpanWrapper getSpanWrapper();

    void setFalcoSpan(FalcoSpan falcoSpan);

    void setOpenTracingContext(Map<String, String> map);
}
