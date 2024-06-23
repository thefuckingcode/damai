package com.taobao.alivfssdk.fresco.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import tb.bs1;

/* compiled from: Taobao */
public class FileUtils {

    /* compiled from: Taobao */
    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String str) {
            super(str);
        }

        public CreateDirectoryException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    /* compiled from: Taobao */
    public static class FileDeleteException extends IOException {
        public FileDeleteException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    public static class RenameException extends IOException {
        public RenameException(String str) {
            super(str);
        }

        public RenameException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    public static void a(File file) throws CreateDirectoryException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.delete()) {
                    throw new CreateDirectoryException(file.getAbsolutePath(), new FileDeleteException(file.getAbsolutePath()));
                }
            } else {
                return;
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static void b(File file, File file2) throws RenameException {
        bs1.a(file);
        bs1.a(file2);
        file2.delete();
        if (!file.renameTo(file2)) {
            Throwable th = null;
            if (file2.exists()) {
                th = new FileDeleteException(file2.getAbsolutePath());
            } else if (!file.getParentFile().exists()) {
                th = new ParentDirNotFoundException(file.getAbsolutePath());
            } else if (!file.exists()) {
                th = new FileNotFoundException(file.getAbsolutePath());
            }
            throw new RenameException("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath(), th);
        }
    }
}
