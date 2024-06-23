package com.youku.middlewareservice.provider.member;

/* compiled from: Taobao */
public interface MemberProvider {
    public static final int IS_EXPIRED_VIP = 2;
    public static final int IS_NON_VIP = 0;
    public static final int IS_VIP = 1;

    /* compiled from: Taobao */
    public interface MemberInfoErrorListener {
        void onError(String str, String str2);
    }

    /* compiled from: Taobao */
    public interface MemberInfoUpdateListener {
        void onUpdated();
    }

    String getLoginEmail(String str);

    String getLoginMobile(String str);

    String getMemberId(String str);

    void getNewestMemberInfo(MemberInfoUpdateListener memberInfoUpdateListener, MemberInfoErrorListener memberInfoErrorListener);

    String getVipExpireTime(String str);

    int getVipStatus(String str);

    boolean isMember(String str);
}
