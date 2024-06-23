package tb;

import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.d;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.Map;

/* compiled from: Taobao */
public final /* synthetic */ class gd1 implements Messages.Result {
    public final /* synthetic */ Map a;
    public final /* synthetic */ BasicMessageChannel.Reply b;

    public /* synthetic */ gd1(Map map, BasicMessageChannel.Reply reply) {
        this.a = map;
        this.b = reply;
    }

    @Override // com.idlefish.flutterboost.Messages.Result
    public final void success(Object obj) {
        d.j(this.a, this.b, (Void) obj);
    }
}
