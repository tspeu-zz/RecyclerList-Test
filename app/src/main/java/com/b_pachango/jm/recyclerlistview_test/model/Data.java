package com.b_pachango.jm.recyclerlistview_test.model;

import java.util.Random;

/**
 * Created by JM_B on 01-Oct-16.
 */

public class Data {
    private long _id;
    private String data;
    private long seconds_since_epoch;
    private boolean sent = false;

    long range = 1234567L;
    Random r = new Random();
    long number = (long)(r.nextDouble()*range);
    long dataNow =System.currentTimeMillis()/1000;


 public Data(String d ){
     this._id=number;
     this.data = d;
     this.seconds_since_epoch = System.currentTimeMillis()/1000;
     this.sent= false;
 }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getSeconds_since_epoch() {
        return seconds_since_epoch;
    }

    public void setSeconds_since_epoch(long seconds_since_epoch) {


        this.seconds_since_epoch = seconds_since_epoch;
    }

    public String convertLong(){
        String valor = String.valueOf(this.seconds_since_epoch);
        return valor;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
