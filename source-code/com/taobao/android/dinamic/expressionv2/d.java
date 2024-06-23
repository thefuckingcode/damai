package com.taobao.android.dinamic.expressionv2;

import android.view.View;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expression.parser.DinamicDataParser;
import com.taobao.android.dinamic.expression.parser.a;
import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.ArrayList;
import java.util.List;
import tb.c80;
import tb.o70;
import tb.x70;

/* compiled from: Taobao */
public class d extends DinamicASTNode {
    private List e;

    public d() {
        this.a = DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod;
    }

    @Override // com.taobao.android.dinamic.expressionv2.DinamicASTNode
    public Object c() {
        ArrayList arrayList = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            Object c = this.b.get(i).c();
            if (c != null) {
                arrayList.add(c);
            } else {
                arrayList.add(o70.NL);
            }
        }
        String str = this.d;
        DinamicDataParser b = str != null ? a.b(str) : null;
        DinamicLog.h("MethodName:" + this.d);
        if (b == null) {
            return null;
        }
        try {
            DinamicLog.h("args:" + arrayList.toString());
            return b.evalWithArgs(arrayList, (x70) this.c);
        } catch (Throwable th) {
            DinamicLog.i("DinamicExpresstion", th, "parse express failed, parser=", b.getClass().getName());
            return null;
        }
    }

    public void d() {
        this.e = new ArrayList();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.e.add(this.b.get(i).c());
        }
    }

    public List e() {
        return this.e;
    }

    public void f(View view) {
        DinamicLog.j("DinamicExpression handleEvent", new String[0]);
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(this.b.get(i).c());
            }
            DinamicEventHandler dinamicEventHandler = null;
            String str = this.d;
            if (str != null) {
                dinamicEventHandler = b.b(str);
            }
            if (dinamicEventHandler != null) {
                try {
                    x70 x70 = (x70) this.c;
                    dinamicEventHandler.handleEvent(view, x70.c(), arrayList, x70.d(), x70.b(), (ArrayList) view.getTag(c80.VIEW_PARAMS));
                } catch (Throwable th) {
                    DinamicLog.i("DinamicExpression", th, "parse express failed, parser=", dinamicEventHandler.getClass().getName());
                }
            }
        }
    }
}
