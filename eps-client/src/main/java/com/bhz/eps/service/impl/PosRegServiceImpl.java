package com.bhz.eps.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bhz.eps.dao.PosInfoDao;
import com.bhz.eps.entity.PosRegInfo;
import com.bhz.eps.service.PosRegService;

@Service("posRegService")
public class PosRegServiceImpl implements PosRegService {

	@Resource
	PosInfoDao posDao;
	
	@Override
	public void regist(PosRegInfo pos) {
		PosRegInfo p = posDao.findPos(pos.getPosCode());
		if(p == null){
			posDao.addPos(pos);
		}else{
			posDao.updatePos(pos);
		}
	}

	@Override
	public List<PosRegInfo> allRegPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PosRegInfo findPosByCode(String posCode) {
		return posDao.findPos(posCode);
	}

	@Override
	public void updatePos(PosRegInfo pos) {
		posDao.updatePos(pos);
	}

}
