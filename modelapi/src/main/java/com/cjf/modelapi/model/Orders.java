package com.cjf.modelapi.model;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private Integer oid;

    private Integer uid;

    private String uname;

    private Integer gid;

    private String gname;

    private Integer gnum;

    private Double totalmoney;

    private Double oldmoney;

    private Double discount;

    private Double newmoney;

    private String ordertime;

    private String remarks;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getOldmoney() {
        return oldmoney;
    }

    public void setOldmoney(Double oldmoney) {
        this.oldmoney = oldmoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNewmoney() {
        return newmoney;
    }

    public void setNewmoney(Double newmoney) {
        this.newmoney = newmoney;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}