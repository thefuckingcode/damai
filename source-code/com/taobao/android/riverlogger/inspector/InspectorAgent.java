package com.taobao.android.riverlogger.inspector;

import java.util.Map;

/* compiled from: Taobao */
public interface InspectorAgent {
    void connectionChanged(boolean z);

    Map<String, InspectorCommandHandler> getCommands();

    void sessionClosed(String str);
}
