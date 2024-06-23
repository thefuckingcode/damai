package com.taobao.android.dinamic.expressionv2;

import android.util.LruCache;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;
import tb.d80;
import tb.o70;
import tb.r70;
import tb.x70;
import tb.z70;

/* compiled from: Taobao */
public class g implements DinamicProcessor {
    private static LruCache<String, DinamicASTNode> a = new LruCache<>(32);

    @Nullable
    private static Object a(DinamicASTNode dinamicASTNode, String str, x70 x70) {
        return dinamicASTNode.c();
    }

    public static DinamicASTNode[] b(View view, String str, x70 x70) {
        DinamicASTNode dinamicASTNode = o70.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new d80().a(str);
            if (a2 != null) {
                a aVar = new a();
                aVar.b(x70);
                DinamicASTNode a3 = aVar.a(a2);
                if (a3 != null) {
                    if (o70.a) {
                        a.put(str, a3);
                    }
                    return c(view, a3);
                }
            }
            return null;
        }
        dinamicASTNode.b(x70);
        return c(view, dinamicASTNode);
    }

    private static DinamicASTNode[] c(View view, DinamicASTNode dinamicASTNode) {
        int size;
        if (dinamicASTNode == null) {
            return null;
        }
        DinamicASTNode.DinamicASTNodeType dinamicASTNodeType = dinamicASTNode.a;
        if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
            try {
                ((d) dinamicASTNode).d();
                return new DinamicASTNode[]{dinamicASTNode};
            } catch (ClassCastException unused) {
                DinamicLog.d(b.TAG, "root node class cast error!");
                return null;
            }
        } else if (dinamicASTNodeType != DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock || (size = dinamicASTNode.b.size()) <= 0) {
            return null;
        } else {
            for (int i = 0; i < size; i++) {
                DinamicASTNode dinamicASTNode2 = dinamicASTNode.b.get(i);
                if (dinamicASTNode2 instanceof d) {
                    ((d) dinamicASTNode2).d();
                }
            }
            return (DinamicASTNode[]) dinamicASTNode.b.toArray(new DinamicASTNode[size]);
        }
    }

    public static void d(View view, String str, x70 x70) {
        DinamicASTNode dinamicASTNode = o70.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new d80().a(str);
            if (a2 != null) {
                a aVar = new a();
                aVar.b(x70);
                DinamicASTNode a3 = aVar.a(a2);
                if (a3 != null) {
                    if (o70.a) {
                        a.put(str, a3);
                    }
                    e(view, a3);
                    return;
                }
                return;
            }
            return;
        }
        dinamicASTNode.b(x70);
        e(view, dinamicASTNode);
    }

    private static void e(View view, DinamicASTNode dinamicASTNode) {
        if (dinamicASTNode != null) {
            DinamicASTNode.DinamicASTNodeType dinamicASTNodeType = dinamicASTNode.a;
            if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
                try {
                    ((d) dinamicASTNode).f(view);
                } catch (ClassCastException unused) {
                    DinamicLog.d(b.TAG, "root node class cast error!");
                }
            } else if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock) {
                int size = dinamicASTNode.b.size();
                for (int i = 0; i < size; i++) {
                    DinamicASTNode dinamicASTNode2 = dinamicASTNode.b.get(i);
                    if (dinamicASTNode2.a == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeMethod) {
                        try {
                            ((d) dinamicASTNode2).f(view);
                        } catch (ClassCastException unused2) {
                            DinamicLog.d(b.TAG, "child node class cast error!");
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void f(View view, String str, x70 x70, z70 z70) {
        try {
            DinamicASTNode[] b = b(view, str, x70);
            if (b != null && b.length > 0) {
                for (int i = 0; i < b.length; i++) {
                    DinamicEventHandler b2 = b.b(b[i].d);
                    if (b2 != null && (b[i] instanceof d)) {
                        b2.prepareBindEvent(view, ((d) b[i]).e(), x70.d());
                    }
                }
            }
        } catch (Throwable unused) {
            x70.e().b().a(r70.ERROR_CODE_EVENT_HANDLER_EXCEPTION, z70.a);
        }
    }

    public static Object g(String str, String str2, x70 x70) {
        DinamicASTNode dinamicASTNode = o70.a ? a.get(str) : null;
        if (dinamicASTNode == null) {
            Pair<List, List> a2 = new d80().a(str);
            if (a2 != null) {
                a aVar = new a();
                aVar.b(x70);
                DinamicASTNode a3 = aVar.a(a2);
                if (a3 != null) {
                    if (o70.a) {
                        a.put(str, a3);
                    }
                    Object a4 = a(a3, str, x70);
                    if (a4 != null) {
                        return a4;
                    }
                } else {
                    DinamicLog.h("build AST Tree error!");
                }
            } else {
                DinamicLog.h("token error!");
            }
        } else {
            dinamicASTNode.b(x70);
            Object a5 = a(dinamicASTNode, str, x70);
            if (a5 == null || a5 == o70.NL) {
                return null;
            }
            return a5;
        }
        return null;
    }
}
