package com.taobao.alivfssdk.fresco.common.file;

import java.io.File;

/* compiled from: Taobao */
public interface FileTreeVisitor {
    void postVisitDirectory(File file);

    void preVisitDirectory(File file);

    void visitFile(File file);
}
