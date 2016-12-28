package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.bean.Notice;
import com.wms.commons.utils.PageInfo;
import com.wms.dao.NoticeMapper;
import com.wms.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

	@Override
	public List<Notice> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectDataGrid(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Notice selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addShipment(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateShipment(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
