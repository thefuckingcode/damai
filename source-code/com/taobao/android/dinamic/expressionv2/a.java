package com.taobao.android.dinamic.expressionv2;

import android.util.Pair;
import com.taobao.android.dinamic.expressionv2.DinamicASTNode;
import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;
import java.util.Stack;
import tb.x70;

/* compiled from: Taobao */
public class a {
    private x70 a;

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0115, code lost:
        continue;
     */
    public DinamicASTNode a(Pair pair) {
        DinamicASTNode cVar;
        if (pair == null) {
            return null;
        }
        List list = (List) pair.first;
        List list2 = (List) pair.second;
        int size = list.size();
        if (size < 1) {
            return null;
        }
        Stack stack = new Stack();
        DinamicASTNode dinamicASTNode = null;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = ((Integer) list.get(i3)).intValue();
            if (intValue != 2) {
                if (intValue == 7) {
                    cVar = new c();
                    cVar.d = (String) list2.get(i3);
                    if (dinamicASTNode != null) {
                        dinamicASTNode.a(cVar);
                    }
                } else if (intValue == 4) {
                    f fVar = new f();
                    fVar.d = (String) list2.get(i3);
                    dinamicASTNode.a(fVar);
                } else if (intValue != 5) {
                    switch (intValue) {
                        case 9:
                            if (i == 0 && dinamicASTNode.a != DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock) {
                                cVar = new e();
                                cVar.a(dinamicASTNode);
                                break;
                            } else if (dinamicASTNode.a != DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeBranchBlock) {
                                break;
                            } else {
                                return null;
                            }
                        case 10:
                            if (i == 0 || i2 != 0) {
                                DinamicASTNode.DinamicASTNodeType dinamicASTNodeType = dinamicASTNode.a;
                                if (dinamicASTNodeType == DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeBranchBlock) {
                                    continue;
                                } else if (dinamicASTNodeType != DinamicASTNode.DinamicASTNodeType.DinamicASTNodeTypeSerialBlock) {
                                    cVar = new b();
                                    cVar.a(dinamicASTNode);
                                    break;
                                } else {
                                    List<DinamicASTNode> list3 = dinamicASTNode.b;
                                    if (list3 != null) {
                                        int size2 = list3.size();
                                        b bVar = new b();
                                        bVar.a(dinamicASTNode.b.remove(size2 - 1));
                                        dinamicASTNode.a(bVar);
                                        break;
                                    } else {
                                        return null;
                                    }
                                }
                            } else {
                                DinamicLog.h("in method inner, ; and () is match!");
                                return null;
                            }
                        case 11:
                            i2++;
                            if (dinamicASTNode != null) {
                                stack.push(dinamicASTNode);
                            }
                            dinamicASTNode = new b();
                            break;
                        case 12:
                            i2--;
                            if (!stack.empty()) {
                                cVar = (DinamicASTNode) stack.peek();
                                stack.pop();
                                cVar.a(dinamicASTNode);
                                break;
                            } else {
                                break;
                            }
                    }
                } else {
                    i--;
                    if (!stack.empty()) {
                        cVar = (DinamicASTNode) stack.peek();
                        stack.pop();
                        cVar.a(dinamicASTNode);
                    }
                }
                dinamicASTNode = cVar;
            } else {
                i++;
                if (dinamicASTNode != null) {
                    DinamicLog.h("TokenizerStateMethodName:" + dinamicASTNode.a);
                    stack.push(dinamicASTNode);
                }
                dinamicASTNode = new d();
                dinamicASTNode.d = (String) list2.get(i3);
            }
        }
        if (i != 0) {
            DinamicLog.h("method balance error!");
        }
        if (i2 != 0) {
            DinamicLog.h("branch balance error!");
        }
        if (dinamicASTNode != null) {
            dinamicASTNode.b(this.a);
        }
        return dinamicASTNode;
    }

    public void b(x70 x70) {
        this.a = x70;
    }
}
