package cn.damai.commonbusiness.yymember.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
public class MemberAuthBean implements Serializable {
    private static final long serialVersionUID = 1;
    public QuickAuthModel quickAuthModal;

    /* compiled from: Taobao */
    public static class AuthProtocol implements Serializable {
        private static final long serialVersionUID = 1;
        public ArrayList<String> desc;
        public String pageSource;
        public ArrayList<Protocol> protocol;
        public String title;
        public String type;
    }

    /* compiled from: Taobao */
    public static class Protocol implements Serializable {
        private static final long serialVersionUID = 1;
        public String protocolName;
        public String protocolTitle;
        public String protocolUrl;
    }

    /* compiled from: Taobao */
    public static class QuickAuthModel implements Serializable {
        private static final long serialVersionUID = 1;
        public AuthProtocol dmToTpp;
        public AuthProtocol tppToDm;
    }
}
