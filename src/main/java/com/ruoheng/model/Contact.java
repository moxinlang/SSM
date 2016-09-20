package com.ruoheng.model;

import java.util.Date;

public class Contact {
    private Integer id;

    private Integer cusid;

    private Date contacttime;

    private String address;

    private String overview;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public Date getContacttime() {
        return contacttime;
    }

    public void setContacttime(Date contacttime) {
        this.contacttime = contacttime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }
}