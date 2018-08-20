package com.psychotech.anuragraphy.sedat;


public class OrderNames {

    private String name,address,rate,tax,discount,grandtotal,starttime,endtime,totaltime,flag;
   private String date;
   private String id;
   private String work;

   public OrderNames(){

   }
    public void setName(String n){
       this.name=n;
    }
    public void setAddress(String a){
       this.address=a;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setTotaltime(String totaltime) {
        this.totaltime = totaltime;
    }

    public void setGrandtotal(String grandtotal) {
        this.grandtotal = grandtotal;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public void setDate(String d){
        this.date=d;
    }
    public void setId(String i){
        this.id=i;
    }

    public void setWork(String w) {
        this.work = w;
    }


    public String getTotaltime() {
        return totaltime;
    }

    public String getGrandtotal() {
        return grandtotal;
    }

    public String getTax() {
        return tax;
    }

    public String getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public String getDiscount() {
        return discount;
    }

    public String getAddress() {
        return address;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getStarttime() {
        return starttime;
    }


    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getWork() {
        return work;
    }


}
