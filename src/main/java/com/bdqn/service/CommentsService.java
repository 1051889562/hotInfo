package com.bdqn.service;

import com.bdqn.entity.Comments;
import com.bdqn.entity.CommentsExample;

import java.util.List;

public interface CommentsService {
    List<Comments> selectByExample(Integer id);
}
