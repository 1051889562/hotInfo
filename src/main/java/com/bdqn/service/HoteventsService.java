package com.bdqn.service;

import com.bdqn.entity.Hotevents;
import com.github.pagehelper.PageInfo;

public interface HoteventsService {
    int insert(Hotevents hotevents);
    int updateByPrimaryKey(Hotevents hotevents);
    int deleteByPrimaryKey(int id);
    PageInfo getHots(Integer page, Integer rows,String hotcontent);
}
