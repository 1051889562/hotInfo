package com.bdqn.service.impl;

import com.bdqn.entity.Hotevents;
import com.bdqn.entity.HoteventsExample;
import com.bdqn.mapper.HoteventsMapper;
import com.bdqn.service.HoteventsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class HoteventsServiceImpl implements HoteventsService {

    @Autowired
    private HoteventsMapper hoteventsMapper;
    @Override
    public int insert(Hotevents hotevents) {
        return hoteventsMapper.insert(hotevents);
    }

    @Override
    public int updateByPrimaryKey(Hotevents hotevents) {
        return hoteventsMapper.updateByPrimaryKey(hotevents);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return hoteventsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo getHots(Integer page, Integer rows ,String hotcontent) {
        HoteventsExample hoteventsExample=new HoteventsExample();
        HoteventsExample.Criteria criteria= hoteventsExample.createCriteria();
        criteria.andHotcontentLike("%"+hotcontent+"%");

        PageHelper.startPage(page,rows);
        List<Hotevents> hoteventsList= hoteventsMapper.selectByExample(hoteventsExample);
        PageInfo hoteventsPageInfo=new PageInfo(hoteventsList);
        return hoteventsPageInfo;
    }
}
