package com.example.mp10_pgpb.network;

import com.example.mp10_pgpb.model.Data;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("3401")
    Call<List<Data>> getAllUsers();
}
