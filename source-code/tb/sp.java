package tb;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.log.DinamicLog;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.util.Map;

/* compiled from: Taobao */
public class sp {
    public static final int HEIGHT = 1;
    public static final int MARGINBOTTOM = 5;
    public static final int MARGINLEFT = 2;
    public static final int MARGINRIGHT = 4;
    public static final int MARGINTOP = 3;
    public static final int WIDTH = 0;

    public static int a(Map<String, Object> map) {
        if (map.containsKey(DAttrConstant.VIEW_LAYOUTGRAVITY)) {
            switch (Integer.valueOf((String) map.get(DAttrConstant.VIEW_LAYOUTGRAVITY)).intValue()) {
                case 0:
                    return 48;
                case 1:
                    return 16;
                case 2:
                    return 80;
                case 3:
                    return 49;
                case 4:
                    return 17;
                case 5:
                    return 81;
                case 6:
                    return 53;
                case 7:
                    return 21;
                case 8:
                    return 85;
            }
        }
        return -1;
    }

    public static int[] b(Context context, Map<String, Object> map) {
        int i;
        String str = (String) map.get(DAttrConstant.VIEW_WIDTH);
        String str2 = (String) map.get(DAttrConstant.VIEW_HEIGHT);
        int i2 = -1;
        if (TextUtils.equals(str, DAttrConstant.MATCH_CONTENT)) {
            i = -2;
        } else if (TextUtils.equals(str, DAttrConstant.MATCH_PARENT)) {
            i = -1;
        } else {
            i = q42.b(context, str, 0);
        }
        if (TextUtils.equals(str2, DAttrConstant.MATCH_CONTENT)) {
            i2 = -2;
        } else if (!TextUtils.equals(str2, DAttrConstant.MATCH_PARENT)) {
            i2 = q42.b(context, str2, 0);
        }
        return new int[]{i, i2, q42.b(context, map.get(DAttrConstant.VIEW_MARGIN_LEFT), 0), q42.b(context, map.get(DAttrConstant.VIEW_MARGIN_TOP), 0), q42.b(context, map.get(DAttrConstant.VIEW_MARGIN_RIGHT), 0), q42.b(context, map.get(DAttrConstant.VIEW_MARGIN_BOTTOM), 0)};
    }

    public static void c(View view, ViewGroup viewGroup) {
        z70 z70 = (z70) view.getTag(c80.PROPERTY_KEY);
        if (z70 != null && (view instanceof ViewGroup)) {
            int[] b = b(view.getContext(), z70.b);
            if (viewGroup == null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(b[0], b[1]);
                marginLayoutParams.setMargins(b[2], b[3], b[4], b[5]);
                view.setLayoutParams(marginLayoutParams);
                if (b.e()) {
                    DinamicLog.a(b.TAG, "reflect layout params fail");
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) bz1.b(viewGroup, "generateDefaultLayoutParams", new Object[0]);
            if (layoutParams != null) {
                layoutParams.width = b[0];
                layoutParams.height = b[1];
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(b[2], b[3], b[4], b[5]);
                }
                view.setLayoutParams(layoutParams);
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(b[0], b[1]);
            marginLayoutParams2.setMargins(b[2], b[3], b[4], b[5]);
            view.setLayoutParams(marginLayoutParams2);
            if (b.e()) {
                DinamicLog.a(b.TAG, "reflect layout params fail");
            }
        }
    }

    public static int d(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable th) {
            if (b.e()) {
                DinamicLog.i(b.TAG, th, str, "写法错误，解析出错");
            }
            return i;
        }
    }
}
