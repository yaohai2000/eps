package com.bhz.eps.dao;

import org.apache.ibatis.annotations.Param;

import com.bhz.eps.entity.PosRegInfo;

public interface PosInfoDao {
	public PosRegInfo findPos(@Param("posCode") String posCode);
	public void addPos(PosRegInfo pos);
	public void updatePos(PosRegInfo pos);
}
