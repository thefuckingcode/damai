package android.taobao.windvane.fullspan;

import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.opentracing.api.SpanContext;

/* compiled from: Taobao */
public class SpanWrapper {
    FalcoSpan falcoSpan;

    public SpanWrapper() {
    }

    public SpanContext context() {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            return falcoSpan2.context();
        }
        return null;
    }

    public FalcoStage customStage(String str) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            return falcoSpan2.customStage(str);
        }
        return null;
    }

    public void finish() {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.finish();
        }
    }

    public void log(String str) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.log(str);
        }
    }

    public void releaseLog(String str) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.releaseLog(str);
        }
    }

    public void setCustomTag(String str, String str2) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.setTag(str, str2);
            FalcoSpan falcoSpan3 = this.falcoSpan;
            falcoSpan3.log("{\"H5CustomProperty\":\"" + str + "\",\"value\":\"" + str2 + "\"}");
        }
    }

    public void setFailStatus() {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            FalcoSpan.ERROR_CODE.set(falcoSpan2, "failed");
        }
    }

    public void setFalcoSpan(FalcoSpan falcoSpan2) {
        this.falcoSpan = falcoSpan2;
    }

    public void setTag(String str, String str2) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.setTag(str, str2);
            FalcoSpan falcoSpan3 = this.falcoSpan;
            falcoSpan3.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + str2 + "\"}");
        }
    }

    public SpanWrapper(FalcoSpan falcoSpan2) {
        this.falcoSpan = falcoSpan2;
    }

    public void setFalcoSpan(SpanWrapper spanWrapper) {
        if (spanWrapper != null) {
            this.falcoSpan = spanWrapper.falcoSpan;
        }
    }

    public void finish(String str) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.finish(str);
        }
    }

    public void setTag(String str, boolean z) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.setTag(str, z);
            FalcoSpan falcoSpan3 = this.falcoSpan;
            falcoSpan3.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + z + "\"}");
        }
    }

    public void setTag(String str, Number number) {
        FalcoSpan falcoSpan2 = this.falcoSpan;
        if (falcoSpan2 != null) {
            falcoSpan2.setTag(str, number);
            FalcoSpan falcoSpan3 = this.falcoSpan;
            falcoSpan3.log("{\"H5Property\":\"" + str + "\",\"value\":\"" + number + "\"}");
        }
    }
}
