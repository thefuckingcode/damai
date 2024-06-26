package com.alibaba.appmonitor.pool;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public class ReuseJSONObject extends JSONObject implements Reusable {
    private static final long serialVersionUID = 1465414806753619992L;

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        for (Object obj : values()) {
            if (obj instanceof Reusable) {
                a.a().offer((Reusable) obj);
            }
        }
        super.clear();
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
    }
}
