package com.zxl.dailypractice.card.three.february.february1;

import java.io.Serializable;

/**
 * @author: zhaoxl
 * @date: 2022/11/3
 * @desc:
 **/
public class CoverList implements Serializable {
    private static final long serialVersionUID = 6772220160528191342L;
    private String neName;
    private String ipAddress;

    public String getNeName() {
        return neName;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "CoverList{" +
                "neName='" + neName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
