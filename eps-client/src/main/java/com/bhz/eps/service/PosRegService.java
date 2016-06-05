package com.bhz.eps.service;

import java.util.List;

import com.bhz.eps.entity.PosRegInfo;

public interface PosRegService {
	public void regist(PosRegInfo pos);
	public List<PosRegInfo> allRegPos();
	public PosRegInfo findPosByCode(String posCode);
	public void updatePos(PosRegInfo pos);
}
