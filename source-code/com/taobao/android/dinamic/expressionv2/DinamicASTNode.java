package com.taobao.android.dinamic.expressionv2;

import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
public class DinamicASTNode {
    public DinamicASTNodeType a;
    public List<DinamicASTNode> b;
    public Object c;
    public String d;

    /* compiled from: Taobao */
    public enum DinamicASTNodeType {
        DinamicASTNodeTypeNone,
        DinamicASTNodeTypeRoot,
        DinamicASTNodeTypeMethod,
        DinamicASTNodeTypeVar,
        DinamicASTNodeTypeConst,
        DinamicASTNodeTypeBranchBlock,
        DinamicASTNodeTypeSerialBlock
    }

    public void a(DinamicASTNode dinamicASTNode) {
        if (dinamicASTNode != null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b.add(dinamicASTNode);
        }
    }

    public void b(Object obj) {
        if (this.c != obj) {
            this.c = obj;
            List<DinamicASTNode> list = this.b;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.b.get(i).b(obj);
                }
            }
        }
    }

    public Object c() {
        return this.d;
    }
}
