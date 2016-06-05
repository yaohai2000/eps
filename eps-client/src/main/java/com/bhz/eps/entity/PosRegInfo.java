package com.bhz.eps.entity;

import lombok.Getter;
import lombok.Setter;

public class PosRegInfo implements java.io.Serializable{
	private static final long serialVersionUID = 4881170976880428706L;
	@Getter @Setter
	private String posCode;
	@Getter @Setter
	private String psamNum;
	@Getter @Setter
	private int status;
}
