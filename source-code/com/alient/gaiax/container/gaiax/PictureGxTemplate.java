package com.alient.gaiax.container.gaiax;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.by0;
import tb.if1;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J7\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/alient/gaiax/container/gaiax/PictureGxTemplate;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", if1.DIMEN_BIZ, "templateId", "templateVersion", "pageName", by0.ARG_COPY, "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getBizId", "()Ljava/lang/String;", "setBizId", "(Ljava/lang/String;)V", "getTemplateId", "getTemplateVersion", "setTemplateVersion", "getPageName", "setPageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PictureGxTemplate implements Serializable {
    @Nullable
    private String bizId;
    @Nullable
    private String pageName;
    @NotNull
    private final String templateId;
    @Nullable
    private String templateVersion;

    public PictureGxTemplate(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        k21.i(str2, "templateId");
        this.bizId = str;
        this.templateId = str2;
        this.templateVersion = str3;
        this.pageName = str4;
    }

    public static /* synthetic */ PictureGxTemplate copy$default(PictureGxTemplate pictureGxTemplate, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pictureGxTemplate.bizId;
        }
        if ((i & 2) != 0) {
            str2 = pictureGxTemplate.templateId;
        }
        if ((i & 4) != 0) {
            str3 = pictureGxTemplate.templateVersion;
        }
        if ((i & 8) != 0) {
            str4 = pictureGxTemplate.pageName;
        }
        return pictureGxTemplate.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.bizId;
    }

    @NotNull
    public final String component2() {
        return this.templateId;
    }

    @Nullable
    public final String component3() {
        return this.templateVersion;
    }

    @Nullable
    public final String component4() {
        return this.pageName;
    }

    @NotNull
    public final PictureGxTemplate copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        k21.i(str2, "templateId");
        return new PictureGxTemplate(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PictureGxTemplate)) {
            return false;
        }
        PictureGxTemplate pictureGxTemplate = (PictureGxTemplate) obj;
        return k21.d(this.bizId, pictureGxTemplate.bizId) && k21.d(this.templateId, pictureGxTemplate.templateId) && k21.d(this.templateVersion, pictureGxTemplate.templateVersion) && k21.d(this.pageName, pictureGxTemplate.pageName);
    }

    @Nullable
    public final String getBizId() {
        return this.bizId;
    }

    @Nullable
    public final String getPageName() {
        return this.pageName;
    }

    @NotNull
    public final String getTemplateId() {
        return this.templateId;
    }

    @Nullable
    public final String getTemplateVersion() {
        return this.templateVersion;
    }

    public int hashCode() {
        String str = this.bizId;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.templateId.hashCode()) * 31;
        String str2 = this.templateVersion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pageName;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setBizId(@Nullable String str) {
        this.bizId = str;
    }

    public final void setPageName(@Nullable String str) {
        this.pageName = str;
    }

    public final void setTemplateVersion(@Nullable String str) {
        this.templateVersion = str;
    }

    @NotNull
    public String toString() {
        return "PictureGxTemplate(bizId=" + ((Object) this.bizId) + ", templateId=" + this.templateId + ", templateVersion=" + ((Object) this.templateVersion) + ", pageName=" + ((Object) this.pageName) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PictureGxTemplate(String str, String str2, String str3, String str4, int i, m40 m40) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4);
    }
}
