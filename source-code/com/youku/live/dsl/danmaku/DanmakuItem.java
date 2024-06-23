package com.youku.live.dsl.danmaku;

/* compiled from: Taobao */
public class DanmakuItem {
    public String avatarUrl;
    public CharSequence content;
    public DanmakuConfig danmuConfig = new DanmakuConfig();
    public long id = System.currentTimeMillis();
    public boolean isGuest;
    public String nickName;
    public long userId;

    public DanmakuItem(CharSequence charSequence) {
        this.content = charSequence;
    }

    public DanmakuItem(long j, boolean z, String str, String str2, CharSequence charSequence) {
        this.userId = j;
        this.isGuest = z;
        this.avatarUrl = str;
        this.content = charSequence;
        this.nickName = str2;
    }

    public DanmakuItem(long j, boolean z, String str, String str2, CharSequence charSequence, DanmakuConfig danmakuConfig) {
        this.userId = j;
        this.isGuest = z;
        this.avatarUrl = str;
        this.content = charSequence;
        this.nickName = str2;
        this.danmuConfig = danmakuConfig;
    }
}
