package com.example.doinmac2.paixu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.doinmac2.R;

public class SortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        int[] a ={3,3, 30, 34, 5, 35,2,98,78,99};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp=a[j+1];
                    a[j=1]=a[j];
                    a[j]=tmp;
                }
            }
        }
        Log.d("八",a+"");
    }
}