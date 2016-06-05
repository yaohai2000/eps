package com.bhz.eps.pdu;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class BizPDUHeader implements Serializable {

    private static final long serialVersionUID = 4L;
    
    @Getter @Setter
    private String stationID;
    @Getter @Setter
    private Integer cashier;
    @Getter @Setter
    private Integer cmd;
    @Getter @Setter
    private byte[] originalContent;
    
    public BizPDUHeader(){}

    

    @Override
    public String toString(){
        return ":stationID:" + stationID+",cashier:"+cashier+",cmd:"+cmd;
    }

}
