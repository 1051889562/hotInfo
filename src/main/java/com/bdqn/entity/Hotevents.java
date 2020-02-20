package com.bdqn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotevents {
    private Integer id;

    private String keyword;

    private String hotcontent;

    private Integer searchsum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getHotcontent() {
        return hotcontent;
    }

    public void setHotcontent(String hotcontent) {
        this.hotcontent = hotcontent == null ? null : hotcontent.trim();
    }

    public Integer getSearchsum() {
        return searchsum;
    }

    public void setSearchsum(Integer searchsum) {
        this.searchsum = searchsum;
    }

    public String getCreatedate() {
        return simpleDateFormat.format(createdate);
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}