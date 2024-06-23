package com.taobao.android.dinamicx.template.download;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

/* compiled from: Taobao */
public class DXTemplateItem {
    public static final int DEFAULT_VERSION = -1;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_REMOTE_CHILD = 1;
    private int fileVersion = 0;
    private String identifier;
    public boolean isPreset = false;
    public String name;
    public DXTemplateItem originalItem;
    public DXTemplatePackageInfo packageInfo;
    public Collection<String> skipVersions;
    private int templateType = 0;
    public String templateUrl;
    public long version = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: Taobao */
    public @interface TemplateType {
    }

    public boolean checkValid() {
        return !TextUtils.isEmpty(this.name) && this.version > -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DXTemplateItem dXTemplateItem = (DXTemplateItem) obj;
        String str = this.name;
        if (str == null ? dXTemplateItem.name != null : !str.equals(dXTemplateItem.name)) {
            return false;
        }
        if (this.fileVersion == dXTemplateItem.fileVersion && this.version == dXTemplateItem.version) {
            return true;
        }
        return false;
    }

    public int getFileVersion() {
        return this.fileVersion;
    }

    public String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            this.identifier = this.name + " : " + this.version;
        }
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public long getVersion() {
        return this.version;
    }

    public int hashCode() {
        return getIdentifier().hashCode();
    }

    public void setFileVersion(int i) {
        this.fileVersion = i;
    }

    public void setTemplateType(int i) {
        this.templateType = i;
    }

    public String toString() {
        return "name=" + this.name + "version=" + this.version + "templateUrl=" + this.templateUrl;
    }
}
