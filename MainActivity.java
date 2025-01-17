package com.example.mp10_pgpb;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.mp10_pgpb.model.Data;
import com.example.mp10_pgpb.network.ApiClient;
import com.example.mp10_pgpb.network.ApiService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the ListView by ID
        ListView listView = findViewById(R.id.tv_nama);

        //create service
        ApiService client = ApiClient.getInstance();

        //Call the API to get users
        Call<List<Data>> response = client.getAllUsers();

        //list to hold user details
        List<String> dataUsers = new ArrayList<>();

        //Enqueue the call
        response.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    for (Data data : response.body()){
                        String userDetails = "Surveyor: " + data.getNamaSurveyor() + "\n" +
                                "Usia: " + data.getUsia() + "\n" +
                                "Jenis Kelamin: " + data.getJeniskelamin() + "\n" +
                                "Pekerjaan: " + data.getPekerjaan() + "\n" +
                                "ID Desa: " + data.getIdDesa() + "\n" +
                                "Nama Desa: " + data.getNamaDesa() + "\n" +
                                "Latitude: " + data.getLatitude() + "\n" +
                                "Longitude: " + data.getLongitude() + "\n";
                        dataUsers.add(userDetails);
                    }
                    ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                            MainActivity.this, android.R.layout.simple_list_item_1, dataUsers
                    );
                    listView.setAdapter(listAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });
    }
}