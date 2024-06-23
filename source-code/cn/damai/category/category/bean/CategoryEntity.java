package cn.damai.category.category.bean;

import java.io.Serializable;

/* compiled from: Taobao */
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = -4523206817754221234L;
    public String categoryId = "0";
    public String categoryName;
    public int index = 0;
    public boolean isSelected;
    public String subCategoryId;
    public int subIndex = 0;
    public String subName;
    public int subNum;
}
