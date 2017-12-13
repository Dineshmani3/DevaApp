package com.acuizen.root.devaapp;

/**
 * Created by root on 24/11/17.
 */

public class Equipments {
    private String equip_name,tag_no,area,preservation;

    public Equipments(){

    }

     public Equipments(String equip_name,String tag_no,String area,String preservation){
        this.equip_name = equip_name;
        this.tag_no = tag_no;
        this.area = area;
        this.preservation = preservation;
     }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getTag_no() {
        return tag_no;
    }

    public void setTag_no(String tag_no) {
        this.tag_no = tag_no;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPreservation() {
        return preservation;
    }

    public void setPreservation(String preservation) {
        this.preservation = preservation;
    }

    
}
