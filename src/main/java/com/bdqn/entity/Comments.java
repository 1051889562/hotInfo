package com.bdqn.entity;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer hoteventsid;

    private Date commentdate;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHoteventsid() {
        return hoteventsid;
    }

    public void setHoteventsid(Integer hoteventsid) {
        this.hoteventsid = hoteventsid;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}