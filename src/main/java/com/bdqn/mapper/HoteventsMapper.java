package com.bdqn.mapper;

import com.bdqn.entity.Hotevents;
import com.bdqn.entity.HoteventsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HoteventsMapper {
    int countByExample(HoteventsExample example);

    int deleteByExample(HoteventsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hotevents record);

    int insertSelective(Hotevents record);

    List<Hotevents> selectByExample(HoteventsExample example);

    Hotevents selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hotevents record, @Param("example") HoteventsExample example);

    int updateByExample(@Param("record") Hotevents record, @Param("example") HoteventsExample example);

    int updateByPrimaryKeySelective(Hotevents record);

    int updateByPrimaryKey(Hotevents record);
}