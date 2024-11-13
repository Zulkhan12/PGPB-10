package com.example.mp10_pgpb.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class Users {
    @SerializedName("data")
    private List<Data> data;

    public List<Data> getData(){
        return data;
    }
}
