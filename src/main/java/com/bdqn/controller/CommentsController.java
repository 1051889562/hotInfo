package com.bdqn.controller;

import com.bdqn.entity.Comments;
import com.bdqn.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("com")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @RequestMapping("/showcomments")
    @ResponseBody
    public List<Comments> showcomments(Integer id){
        List<Comments> commentsList= commentsService.selectByExample(id);

        return commentsList;
    }

}
