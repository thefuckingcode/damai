package android.taobao.windvane.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class WVMonitorConfig {
    public List<ErrorRule> errorRule = new ArrayList();
    public boolean isErrorBlacklist = true;
    public double perfCheckSampleRate = 0.0d;
    public String perfCheckURL = "";
    public StatRule stat = new StatRule();
    public String v = "0";

    /* compiled from: Taobao */
    public class ErrorRule {
        public String code = "";
        public String msg = "";
        public Pattern msgPattern = null;
        public String url = "";
        public Pattern urlPattern = null;

        public ErrorRule() {
        }
    }

    /* compiled from: Taobao */
    public class StatRule {
        public boolean netstat = false;
        public long onDomLoad = 0;
        public long onLoad = 0;
        public int resSample;
        public long resTime = 0;

        public StatRule() {
        }
    }

    public ErrorRule newErrorRuleInstance(String str, String str2, String str3) {
        ErrorRule errorRule2 = new ErrorRule();
        errorRule2.url = str;
        errorRule2.msg = str2;
        errorRule2.code = str3;
        return errorRule2;
    }
}
