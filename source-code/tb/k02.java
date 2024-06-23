package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class k02 {
    Map<String, String> a;
    Map<String, String> b;
    Context c;
    String d = null;

    public k02(Context context, String str) {
        this.c = context;
        this.d = str;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public void a(String str, String str2) {
        this.a.put(str, str2);
    }

    public void b(String str, String str2) {
        this.b.put(str, str2);
    }

    public void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("image");
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a(next, jSONObject2.getString(next));
                }
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("text");
            if (jSONObject3 != null) {
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    b(next2, jSONObject3.getString(next2));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Bitmap d(String str) {
        String f = f(str);
        if (TextUtils.isEmpty(f)) {
            return null;
        }
        String str2 = this.d + File.separator + f;
        File file = new File(str2);
        if (!file.isFile() || !file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(str2);
    }

    public Bitmap e(String str, int i) {
        return d(str) != null ? d(str) : BitmapFactory.decodeResource(this.c.getResources(), i);
    }

    public String f(String str) {
        return this.a.get(str);
    }

    public String g(String str) {
        return this.b.get(str);
    }

    public String h(String str, int i) {
        if (!TextUtils.isEmpty(g(str))) {
            return g(str);
        }
        return this.c.getResources().getString(i);
    }

    public void i(ImageView imageView, String str, int i) {
        if (d(str) != null) {
            imageView.setImageBitmap(d(str));
        } else {
            imageView.setImageDrawable(this.c.getResources().getDrawable(i));
        }
    }
}
