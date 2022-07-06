package com.valoit.volleyrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HospitalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String url="https://api.jsonserve.com/evaDHA";
    MyAdapter myAdapter;
    List<MyItem> listItems;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems=new ArrayList<>();

        loadData();


    }
    public void loadData(){
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {

                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        JSONArray array=jsonObject.getJSONArray("MyData");

                        for (int i=0; i<array.length();i++){
                            JSONObject receive=array.getJSONObject(i);

                            MyItem item=new MyItem(
                                    receive.getString("headerText"),
                                    receive.getString("descText"),
                                    receive.getString("imgLocation")
                            );

                            listItems.add(item);
                        }
                        myAdapter=new MyAdapter(listItems,getApplicationContext());
                        recyclerView.setAdapter(myAdapter);


                    }catch (JSONException e){
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(HospitalActivity.this,"Server Error",Toast.LENGTH_SHORT).show());

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);



    }



}