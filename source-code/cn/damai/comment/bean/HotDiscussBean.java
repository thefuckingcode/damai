package cn.damai.comment.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class HotDiscussBean implements Serializable {
    public Card card;
    public CommentList commentList;
    public ContentDetailItem contentDetail;
    public int pos;
    public ThemeInfo themeInfo;

    /* compiled from: Taobao */
    public class Card implements Serializable {
        public String targetId;
        public String targetType;

        public Card() {
        }
    }

    /* compiled from: Taobao */
    public class CommentList implements Serializable {
        public List<CommentsItemBean> comments;
        public int totalComment;

        public CommentList() {
        }
    }

    /* compiled from: Taobao */
    public class ThemeInfo implements Serializable {
        public String id;
        public String name;

        public ThemeInfo() {
        }
    }
}
