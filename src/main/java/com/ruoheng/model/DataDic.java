package com.ruoheng.model;

public class DataDic {
    private Integer id;

    private String datadicname;

    private String datadicvalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatadicname() {
        return datadicname;
    }

    public void setDatadicname(String datadicname) {
        this.datadicname = datadicname == null ? null : datadicname.trim();
    }

    public String getDatadicvalue() {
        return datadicvalue;
    }

    public void setDatadicvalue(String datadicvalue) {
        this.datadicvalue = datadicvalue == null ? null : datadicvalue.trim();
    }
}