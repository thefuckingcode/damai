package tb;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.apshare.AlipayApi;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.share.ShareService;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.pictures.share.ddshare.DDApi;
import com.alibaba.pictures.share.wxapi.WeixinApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class z92 extends ShareService {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final z92 INSTANCE = new z92();
    private static ShareService.ShareActionListener a;

    private z92() {
    }

    @Override // com.alibaba.pictures.share.common.share.ShareService
    @Nullable
    public ShareService.ShareActionListener a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1272937980")) {
            return a;
        }
        return (ShareService.ShareActionListener) ipChange.ipc$dispatch("1272937980", new Object[]{this});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.alibaba.pictures.share.common.share.ShareService
    public void b(@Nullable Context context, @Nullable ShareContent shareContent, @Nullable ShareChannel shareChannel, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360154194")) {
            ipChange.ipc$dispatch("1360154194", new Object[]{this, context, shareContent, shareChannel, str});
        } else if (shareContent == null) {
            throw new ShareException("share content is null");
        } else if (context != null) {
            if (shareChannel != null) {
                try {
                    switch (y92.$EnumSwitchMapping$0[shareChannel.ordinal()]) {
                        case 1:
                            v92.c(null, "WEIXIN:" + str, 1, null);
                            new WeixinApi().g(context, shareContent, false, shareChannel);
                            return;
                        case 2:
                            v92.c(null, "WEIXIN_FRIEND:" + str, 1, null);
                            new WeixinApi().g(context, shareContent, true, shareChannel);
                            return;
                        case 3:
                            v92.c(null, "QQ:" + str, 1, null);
                            new cw1().b(context, shareContent, false, shareChannel);
                            return;
                        case 4:
                            v92.c(null, "QZONE:" + str, 1, null);
                            new cw1().b(context, shareContent, true, shareChannel);
                            return;
                        case 5:
                            v92.c(null, "WEIBO:" + str, 1, null);
                            new lz2().a(context, shareContent, shareChannel);
                            return;
                        case 6:
                            v92.c(null, "ALIPAY:" + str, 1, null);
                            new AlipayApi().f(context, shareContent, shareChannel, false);
                            return;
                        case 7:
                            v92.c(null, "ALIPAY_TIMELINE:" + str, 1, null);
                            new AlipayApi().f(context, shareContent, shareChannel, true);
                            return;
                        case 8:
                            v92.c(null, "DD:" + str, 1, null);
                            new DDApi().c(context, shareContent, shareChannel);
                            return;
                        case 9:
                            v92.c(null, "COPYLINK:" + str, 1, null);
                            String url = shareContent.getUrl();
                            if (Build.VERSION.SDK_INT < 11) {
                                Object systemService = context.getApplicationContext().getSystemService("clipboard");
                                if (systemService != null) {
                                    ((ClipboardManager) systemService).setText(url);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type android.text.ClipboardManager");
                                }
                            } else {
                                Object systemService2 = context.getApplicationContext().getSystemService("clipboard");
                                if (systemService2 != null) {
                                    ((android.content.ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText("Copied Text", url));
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
                                }
                            }
                            df.b(ShareChannel.COPYLINK);
                            String string = context.getString(R$string.link_copy_success);
                            k21.h(string, "context.getString(R.string.link_copy_success)");
                            ShareUtil.n(string);
                            return;
                    }
                } catch (Exception e) {
                    v92.b("ShareServiceImpl", e.toString());
                    return;
                }
            }
            v92.c(null, "NONE:" + str, 1, null);
        }
    }

    public void c(@Nullable ShareService.ShareActionListener shareActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "912386520")) {
            ipChange.ipc$dispatch("912386520", new Object[]{this, shareActionListener});
            return;
        }
        a = shareActionListener;
    }
}
