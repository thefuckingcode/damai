package cn.damai.ticklet.bean;

import java.util.List;

/* compiled from: Taobao */
public class TickletFaceUnbindResult {
    public String allSuccess;
    public String failNote;
    public List<UserFaceUnbindInfo> userFaceUnbindingInfoList;

    /* compiled from: Taobao */
    public static class UserFaceUnbindInfo {
        public String opResult;
        public String opResultMsg;
        public String opResultNote;
        public String subFailNote;
    }
}
