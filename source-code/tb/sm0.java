package tb;

import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class sm0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private ArrayList<Image> b;

    public sm0(String str) {
        this.a = str;
    }

    public void a(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225290211")) {
            ipChange.ipc$dispatch("-1225290211", new Object[]{this, image});
        } else if (image != null && xf2.i(image.getPath())) {
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            this.b.add(image);
        }
    }

    public ArrayList<Image> b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1749541843")) {
            return this.b;
        }
        return (ArrayList) ipChange.ipc$dispatch("1749541843", new Object[]{this});
    }

    public String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "768721114")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("768721114", new Object[]{this});
    }

    public void d(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1343461155")) {
            ipChange.ipc$dispatch("-1343461155", new Object[]{this, arrayList});
            return;
        }
        this.b = arrayList;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866414953")) {
            return (String) ipChange.ipc$dispatch("866414953", new Object[]{this});
        }
        return "Folder{name='" + this.a + '\'' + ", images=" + this.b + '}';
    }

    public sm0(String str, ArrayList<Image> arrayList) {
        this.a = str;
        this.b = arrayList;
    }
}
