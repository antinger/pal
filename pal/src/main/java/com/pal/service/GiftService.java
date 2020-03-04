package com.pal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pal.dao.GiftDao;
import com.pal.entity.Gift;

@Service
public class GiftService {
	
	@Autowired
	GiftDao giftDao;
	
	@Autowired
	QiniuService qiniuService;

	//获取最新的礼物
	public Map<String, Object> getLaterGift() {
		List<Gift> gifts = giftDao.getLaterGift(0);
		List<Gift> data = new ArrayList<Gift>();
		for (Gift gift : gifts) {
			gift.setPath(qiniuService.dealOnlyImage(gift.getPath()));
			data.add(gift);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", data);
		return map;
	}

	//添加礼物
	public Map<String, Object> addGift(String name, Integer price, MultipartFile path) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> saveImage = qiniuService.saveImage(path);
		Gift gift = new Gift();
		gift.setName(name);
		gift.setPath(saveImage.get("fileList").toString());
		gift.setPrice(price);
		giftDao.addGift(gift);
		return map;
	}
	
	

}
