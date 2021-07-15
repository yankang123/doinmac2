package com.example.doinmac2

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doinmac2.okhttp.OkhttpActivity
import com.example.finishallbyme.finishall.FinishAllAdapter
import com.example.finishallbyme.finishall.finishData
import com.example.doinmac2.R
import com.example.doinmac2.mpdel.User
//import com.example.doinmac2.mpdel.AppDatabase
//import com.example.doinmac2.mpdel.Item
import com.example.doinmac2.paixu.SortActivity
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    var list = ArrayList<finishData>()
    var edit_dialog :EditText?=null
    var view:View? = null
    var dialog :Dialog?= null
    var button_dialog: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view=View.inflate(this,R.layout.dialog_edit,null)
        edit_dialog=findViewById(R.id.edit_dialog)
        dialog=Dialog(this, R.style.DialogTheme)
        view?.let { dialog?.setContentView(it) }
        button_dialog=view?.findViewById(R.id.btn_dialog)

        initList()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_finish)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val myAdapter = FinishAllAdapter(list,this)
        recyclerView.adapter = myAdapter
      button_dialog?.setOnClickListener {
          thread{

              val itemDao = AppDatabase.getDatabase(this).userDao()
              itemDao.insertUser(User("y", edit_dialog?.text.toString(), 1))
          }
      }
    }
    fun initList() {
        for (i in 1..10) {
            list.add(finishData(true, "我是好人"))
        }
    }



    fun showBottomDialog() {

        val display = windowManager.defaultDisplay
        val window = dialog?.window

        //设置该属性，dialog可以铺满屏幕
        dialog?.getWindow()?.setBackgroundDrawable(null);
//        val lp: WindowManager.LayoutParams? = window?.getAttributes()
//        lp?.width = (display.width)
//        lp?.y = 20 //设置Dialog距离底部的距离
//
//        window?.setAttributes(lp) //将属性设置给窗体

        window?.let {
            it.setGravity(Gravity.BOTTOM)
            it.setWindowAnimations(R.style.my_style)
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,400)
//            TODO("适配大小")
            dialog?.show()
            edit_dialog=findViewById(R.id.edit_dialog)
        }

    }
}