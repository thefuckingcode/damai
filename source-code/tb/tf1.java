package tb;

import android.os.RemoteException;
import android.text.TextUtils;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.statist.StatisticData;
import com.taobao.phenix.compat.mtop.MtopCertificateException;
import com.taobao.phenix.compat.mtop.MtopConnectTimeoutException;
import com.taobao.phenix.compat.mtop.MtopIndifferentException;
import com.taobao.phenix.compat.mtop.MtopInvalidHostException;
import com.taobao.phenix.compat.mtop.MtopInvalidUrlException;
import com.taobao.phenix.compat.mtop.a;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.loader.network.HttpLoader;
import com.taobao.phenix.loader.network.IncompleteResponseException;
import com.taobao.phenix.loader.network.NetworkResponseException;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class tf1 implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private final HttpLoader.FinishCallback a;
    private final Map<String, String> b;
    private boolean c;

    public tf1(HttpLoader.FinishCallback finishCallback, Map<String, String> map) {
        this.a = finishCallback;
        this.b = map;
    }

    private NetworkResponseException a(NetworkEvent$FinishEvent networkEvent$FinishEvent) {
        int httpCode = networkEvent$FinishEvent != null ? networkEvent$FinishEvent.getHttpCode() : 0;
        if (httpCode != -405) {
            if (httpCode != -202) {
                if (httpCode == -102) {
                    return new MtopInvalidUrlException(httpCode);
                }
                if (httpCode == 200) {
                    return new IncompleteResponseException();
                }
                switch (httpCode) {
                    case fe0.ERROR_HOST_NOT_VERIFY_ERROR:
                        break;
                    case fe0.ERROR_SSL_ERROR:
                        return new MtopCertificateException(httpCode);
                    case fe0.ERROR_SOCKET_TIME_OUT:
                    case -400:
                        break;
                    default:
                        return new MtopIndifferentException(httpCode, networkEvent$FinishEvent != null ? networkEvent$FinishEvent.getDesc() : "unknown");
                }
            }
            return new MtopConnectTimeoutException(httpCode);
        }
        return new MtopInvalidHostException(httpCode);
    }

    private String b(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        String lowerCase = str.toLowerCase();
        if (list == null && !str.equals(lowerCase)) {
            list = map.get(lowerCase);
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    private String c(String str) {
        String[] split;
        String[] split2;
        if (TextUtils.isEmpty(str) || (split = str.replace(" ", "").split(",")) == null || split.length <= 0) {
            return "";
        }
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && (split2 = split[i].split("=")) != null && split2.length > 1 && "max-age".equals(split2[0])) {
                return split2[1];
            }
        }
        return "";
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        StatisticData statisticData;
        if (!(this.b == null || networkEvent$FinishEvent == null || (statisticData = networkEvent$FinishEvent.getStatisticData()) == null)) {
            this.b.put(rf1.MTOP_EXTRA_CONNECT_TYPE, statisticData.connectionType);
            this.b.put(rf1.MTOP_EXTRA_CDN_IP_PORT, statisticData.ip_port);
            this.b.put(rf1.MTOP_EXTRA_FIRST_DATA, String.valueOf(statisticData.firstDataTime));
            this.b.put(rf1.MTOP_EXTRA_SEND_BEFORE, String.valueOf(statisticData.sendBeforeTime));
            this.b.put(rf1.MTOP_EXTRA_SERVER_RT, String.valueOf(statisticData.serverRT));
        }
        if (!this.c) {
            this.c = true;
            this.a.onError(a(networkEvent$FinishEvent));
        }
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream, Object obj) {
        int i;
        if (!this.c && parcelableInputStream != null) {
            a aVar = new a(parcelableInputStream);
            try {
                i = parcelableInputStream.length();
                try {
                    vr2.a("Network", "%s get content length(%d) from stream success", rf1.MTOP_PREFIX, Integer.valueOf(i));
                } catch (RemoteException unused) {
                }
            } catch (RemoteException unused2) {
                i = 0;
                vr2.c("Network", "%s get content length from stream failed", rf1.MTOP_PREFIX);
                this.c = true;
                this.a.onFinished(new r02(aVar, i));
            }
            this.c = true;
            this.a.onFinished(new r02(aVar, i));
        }
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
        String str;
        String str2;
        String str3 = null;
        if (map != null) {
            str3 = b(map, "X-Cache");
            str2 = b(map, "eagleid");
            str = b(map, "Cache-Control");
        } else {
            str = null;
            str2 = null;
        }
        if (this.b != null) {
            if (!TextUtils.isEmpty(str3)) {
                this.b.put(rf1.MTOP_EXTRA_HIT_CDN_CACHE, str3.startsWith("HIT") ? "1" : "0");
            }
            if (!TextUtils.isEmpty(str2)) {
                this.b.put("eagleid", str2);
            }
            String c2 = c(str);
            if (!TextUtils.isEmpty(c2)) {
                this.b.put("max-age", c2);
            }
            String str4 = this.b.get("inner_network_start_time");
            if (str4 != null) {
                this.b.put(rf1.MTOP_EXTRA_RESPONSE_CODE, String.valueOf(System.currentTimeMillis() - Long.parseLong(str4)));
            }
        }
        if (!this.c && i != 200) {
            this.c = true;
            this.a.onError(new HttpCodeResponseException(i));
        }
        return true;
    }
}
