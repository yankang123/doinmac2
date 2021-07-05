package com.example.finishallbyme

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finishallbyme.finishall.FinishAllAdapter
import com.example.finishallbyme.finishall.finishData
import com.example.practicekotlin.R


class MainActivity : AppCompatActivity() {
    var list = ArrayList<finishData>()

    //aaa
    //1

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_finish)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val myAdapter = FinishAllAdapter(list)
        recyclerView.adapter = myAdapter
        val button_dialog = findViewById<Button>(R.id.dialog_button)
        button_dialog.setOnClickListener {

            showBottomDialog()
        }

    }

    fun initList() {
        for (i in 1..15) {
            list.add(finishData(true, "hahahh"))
        }
    }


    @RequiresApi(Build.VERSION_CODES.R)
    fun showBottomDialog() {
        val dialog = Dialog(this, R.style.DialogTheme)
        val view = View.inflate(this,R.layout.dialog_edit,null)
        dialog.setContentView(view)
        val display = windowManager.defaultDisplay
        val window = dialog.window

        //设置该属性，dialog可以铺满屏幕
        dialog.getWindow()?.setBackgroundDrawable(null);
//        val lp: WindowManager.LayoutParams? = window?.getAttributes()
//        lp?.width = (display.width)
//        lp?.y = 20 //设置Dialog距离底部的距离
//
//        window?.setAttributes(lp) //将属性设置给窗体

        window?.let {
            it.setGravity(Gravity.BOTTOM)
            it.setWindowAnimations(R.style.my_style)
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()
        }

    }
}