package com.taobao.weex.devtools;

import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;

/* compiled from: Taobao */
public interface InspectorModulesProvider {
    Iterable<ChromeDevtoolsDomain> get();
}
