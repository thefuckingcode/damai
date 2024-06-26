package com.baseproject.utils.speedtest;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.annotation.JSONField;
import com.taobao.tao.log.TLogConstant;
import com.youku.arch.v3.core.Constants;

/* compiled from: Taobao */
public class a {
    @JSONField(name = "version")
    public String a;
    @JSONField(name = "id")
    public String b;
    @JSONField(name = "ruleId")
    public long c;
    @JSONField(name = Constants.CONFIG)
    public C0148a[] d;
    @JSONField(name = "message")
    public String e;
    @JSONField(name = "errorCode")
    public int f;

    /* renamed from: com.baseproject.utils.speedtest.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0148a {
        @JSONField(name = "url")
        public String a;
        @JSONField(name = TbAuthConstants.IP)
        public String b;
        @JSONField(name = "host")
        public String c;
        @JSONField(name = "duration")
        public int d;
        @JSONField(name = "concurrent")
        public int e;
        @JSONField(name = TLogConstant.PERSIST_TASK_ID)
        public int f;
        @JSONField(name = "networkType")
        public int g = 1;
    }
}
