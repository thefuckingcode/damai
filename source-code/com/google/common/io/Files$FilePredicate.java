package com.google.common.io;

import com.google.common.base.Predicate;
import java.io.File;

/* compiled from: Taobao */
enum Files$FilePredicate implements Predicate<File> {
    IS_DIRECTORY {
        public String toString() {
            return "Files.isDirectory()";
        }

        public boolean apply(File file) {
            return file.isDirectory();
        }
    },
    IS_FILE {
        public String toString() {
            return "Files.isFile()";
        }

        public boolean apply(File file) {
            return file.isFile();
        }
    };

    /* synthetic */ Files$FilePredicate(a aVar) {
        this();
    }
}
