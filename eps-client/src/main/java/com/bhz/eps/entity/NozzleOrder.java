package com.bhz.eps.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class NozzleOrder implements java.io.Serializable{
	private static final long serialVersionUID = 3883165105572886859L;
	@Getter @Setter
	private String workOrder;
	@Getter @Setter
	private String nozzleNumber;
	@Getter @Setter
	private int orderStatus;
	@Getter @Setter
	private int oilType;
	@Getter @Setter
	private int oilCategory;
	@Getter @Setter
	private int price;
	@Getter @Setter
	private BigDecimal volumeConsume;
}
