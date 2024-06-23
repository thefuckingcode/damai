package com.idlefish.flutterboost;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.Map;
import tb.gd1;
import tb.hd1;
import tb.id1;
import tb.jd1;
import tb.kd1;
import tb.ld1;
import tb.md1;

/* compiled from: Taobao */
public final /* synthetic */ class d {
    public static /* synthetic */ void h(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.pushNativeRoute(Messages.a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void i(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.pushFlutterRoute(Messages.a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void j(Map map, BasicMessageChannel.Reply reply, Void r3) {
        map.put("result", null);
        reply.reply(map);
    }

    public static /* synthetic */ void k(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.popRoute(Messages.a.a((Map) obj), new gd1(hashMap, reply));
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void l(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", nativeRouterApi.getStackFromHost().b());
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void m(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.saveStackToHost(Messages.b.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void n(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.sendEventToNative(Messages.a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", Messages.b(e));
        }
        reply.reply(hashMap);
    }

    public static void o(BinaryMessenger binaryMessenger, Messages.NativeRouterApi nativeRouterApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushNativeRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel.setMessageHandler(new jd1(nativeRouterApi));
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushFlutterRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel2.setMessageHandler(new hd1(nativeRouterApi));
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.popRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel3.setMessageHandler(new id1(nativeRouterApi));
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.getStackFromHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel4.setMessageHandler(new kd1(nativeRouterApi));
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.saveStackToHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel5.setMessageHandler(new md1(nativeRouterApi));
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.sendEventToNative", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel6.setMessageHandler(new ld1(nativeRouterApi));
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
    }
}
