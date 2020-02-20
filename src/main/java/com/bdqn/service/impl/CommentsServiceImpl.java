package com.bdqn.service.impl;

import com.bdqn.entity.Comments;
import com.bdqn.entity.CommentsExample;
import com.bdqn.mapper.CommentsMapper;
import com.bdqn.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    public List<Comments> selectByExample(Integer id) {
        CommentsExample commentsExample=new CommentsExample();
        CommentsExample.Criteria criteria= commentsExample.createCriteria();
        criteria.andIdEqualTo(id);
        return commentsMapper.selectByExample(commentsExample);
    }
}
