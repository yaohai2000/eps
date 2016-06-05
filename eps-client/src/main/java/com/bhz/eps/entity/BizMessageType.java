package com.bhz.eps.entity;

public class BizMessageType {
	public static final int CONN = 0x01;
	public static final int HEARTBEAT = 0x02;
	public static final int FP_INFO = 0x03;
	public static final int FP_ORDERLIST = 0x04;
	public static final int LOCK_ORDER = 0x05;
	public static final int GET_TRANS_DETAIL = 0x06;
	public static final int ORDER_PAY_COMPLETE = 0x07;
	public static final int UNLOCK_ORDER = 0x08;
}
