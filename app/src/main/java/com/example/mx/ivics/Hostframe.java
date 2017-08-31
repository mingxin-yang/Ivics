package com.example.mx.ivics;

/**
 * Created by 12 on 2017/8/30.
 */

public class Hostframe {
    private String name;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Hostframe{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
