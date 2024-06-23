package com.taobao.tao.log.logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Map;
import java.util.concurrent.Executor;
import tb.hz0;

/* compiled from: Taobao */
public abstract class ILogger {
    @JSONField(name = "data")
    protected Map<String, String> data = null;

    public Map<String, String> getData() {
        return this.data;
    }

    public abstract void log();

    public void log(Executor executor) {
        if (executor != null) {
            executor.execute(new hz0(this));
        }
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
