package com.tencent.stat.event;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ErrorEvent extends Event {
    private String error;
    private int errorAttr;
    private int maxErrorLength = 100;

    public ErrorEvent(Context context, int i, int i2, Throwable th) {
        super(context, i);
        int i3;
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > (i3 = this.maxErrorLength)) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[i3];
            for (int i4 = 0; i4 < this.maxErrorLength; i4++) {
                stackTraceElementArr[i4] = stackTrace[i4];
            }
            th.setStackTrace(stackTraceElementArr);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        this.error = stringWriter.toString();
        this.errorAttr = i2;
        printWriter.close();
    }

    public ErrorEvent(Context context, int i, String str) {
        super(context, i);
        this.error = str;
        this.errorAttr = 0;
    }

    @Override // com.tencent.stat.event.Event
    public EventType getType() {
        return EventType.ERROR;
    }

    @Override // com.tencent.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put("er", this.error);
        jSONObject.put("ea", this.errorAttr);
        return true;
    }
}
