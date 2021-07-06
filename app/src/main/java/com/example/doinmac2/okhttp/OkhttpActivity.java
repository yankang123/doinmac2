package com.example.doinmac2.okhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.doinmac2.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp2);
        require();
    }
    public void require(){
        MediaType mediaType=MediaType.parse("text,charset=utf-8");
        String requestbody ="iii";

        String url ="http://open.iciba.com/dsapi/";
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor()).build();
        final Request request =new Request
                .Builder()//构造请求对象
                .url(url)
                .header("yk","ykk")
                .post(RequestBody.create(mediaType,requestbody))
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("八",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("八",response.body().string()+"/n"+
                        response.protocol()+"/n");
                Headers headers=response.headers();
                for(int i=0;i<headers.size();i++)
                {
                    Log.d("八", headers.name(i)+"   onResponse: "+headers.value(i));
                }
            }
        });

    }
}