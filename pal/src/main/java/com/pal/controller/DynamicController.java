package com.pal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pal.service.DynamicService;
import com.pal.service.QiniuService;
import com.pal.utils.PalUtils;

@Controller
public class DynamicController {

	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	DynamicService dynamicService;
	
	//获取动态
	@RequestMapping(path="/user/getLaterDynamic/", method=RequestMethod.GET)
	@ResponseBody
	public String getLaterDynamic(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		try {
			Map<String, Object> map = dynamicService.getLaterDynamic(page, limit);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//根据用户ID获取动态
	@RequestMapping(path="/user/getDynamicByUserID/", method=RequestMethod.GET)
	@ResponseBody
	public String getDynamicByUserID(@RequestParam("userID") Integer userID) {
		try {
			Map<String, Object> map = dynamicService.getDynamicByUserID(userID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//添加动态
	@RequestMapping(path="/user/addDynamic/", method=RequestMethod.POST)
	@ResponseBody
	public String addDynamic(@RequestParam("content") String content, @RequestParam("image") MultipartFile image) {
		try {
			Map<String, Object> map = dynamicService.addDynamic(content, image);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
	@RequestMapping(path="/user/addDynamicContent/", method=RequestMethod.POST)
	@ResponseBody
	public String addDynamic(@RequestParam("content") String content) {
		try {
			Map<String, Object> map = dynamicService.addDynamic(content, null);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
	//审核动态
	@RequestMapping(path="/user/updateDynamic/", method=RequestMethod.GET)
	@ResponseBody
	public String updateDynamic(@RequestParam("id") Integer id) {
		try {
			Map<String, Object> map = dynamicService.updateDynamic(id);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "审核失败");
		}
	}
	
	@RequestMapping(path = "/user/upload/", method = {RequestMethod.POST})
	@ResponseBody
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		try {
			Map<String, Object> map = qiniuService.saveImage(file);
			map.put("file", map.get("fileList"));
			map.put("show", qiniuService.dealOnlyImage(map.get("fileList").toString()));
			return PalUtils.toJSONString(200, map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PalUtils.toJSONString(1, "添加失败");
	}
}
