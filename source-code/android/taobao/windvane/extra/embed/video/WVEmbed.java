package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.embed.WVEVManager;

/* compiled from: Taobao */
public class WVEmbed {
    public static void init() {
        WVEVManager.registerEmbedView(MyTBVideoEmbedView.NAME, MyTBVideoEmbedView.class, true);
        WVEVManager.registerEmbedView(MyTBLiveEmbedView.NAME, MyTBLiveEmbedView.class, true);
    }
}
