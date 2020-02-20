package com.bdqn.controller;

import com.bdqn.entity.Hotevents;
import com.bdqn.service.HoteventsService;
import com.bdqn.util.HotResult;
import com.bdqn.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("hot")
public class HoteventsController {

    @Autowired
    private HoteventsService hoteventsService;

    @RequestMapping("/getHots")
    @ResponseBody
    public HotResult getHots(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer rows) {
        if (hotcontent==null){
            hotcontent="";
        }
        PageInfo pageInfo = hoteventsService.getHots(page, rows,hotcontent);
        HotResult hotResult = new HotResult();
        hotResult.setTotal(pageInfo.getTotal());
        hotResult.setRows(pageInfo.getList());
        return hotResult;
    }

    @RequestMapping("/save_hot")
    @ResponseBody
    public JsonResult save_hot(Hotevents hotevents) {
        JsonResult jsonResult = new JsonResult();
        int index = hoteventsService.insert(hotevents);
        if (index > 0) {
            jsonResult.setSuccess(true);
        } else {
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }

    @RequestMapping("/update_hot")
    @ResponseBody
    public JsonResult update_hot(Hotevents hotevents) {
        JsonResult jsonResult = new JsonResult();
        int index = hoteventsService.updateByPrimaryKey(hotevents);
        if (index > 0) {
            jsonResult.setSuccess(true);
        } else {
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }

    @RequestMapping("/remove_hot")
    @ResponseBody
    public JsonResult remove_hot(int id) {
        JsonResult jsonResult = new JsonResult();
        int index = hoteventsService.deleteByPrimaryKey(id);
        if (index > 0) {
            jsonResult.setSuccess(true);
        } else {
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }
    public String hotcontent="";
    @RequestMapping(value = "/getHotsSeach",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult getHotsSeach(String hotcontent){
        this.hotcontent=hotcontent;
        JsonResult jsonResult=new JsonResult();
        jsonResult.setSuccess(true);
        return jsonResult;
    }

}
