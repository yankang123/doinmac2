package com.example.doinmac2

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finishallbyme.finishall.FinishAllAdapter
import com.example.finishallbyme.finishall.finishData
import com.example.doinmac2.mpdel.AppDatabase
import com.example.doinmac2.mpdel.User
//import com.example.doinmac2.mpdel.com.example.doinmac2.mpdel.AppDatabase
//import com.example.doinmac2.mpdel.Item
import java.util.TimerTask
import kotlin.concurrent.thread
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    var list = ArrayList<finishData>()
    var edit_dialog :EditText?=null
    var view2:View? = null
    var dialog :Dialog?= null
    var button_dialog: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view2=View.inflate(this,R.layout.dialog_edit,null)

        dialog=Dialog(this, R.style.DialogTheme)

        view2?.let { dialog?.setContentView(it) }
        button_dialog=view2?.findViewById(R.id.btn_dialog)
        edit_dialog=view2?.findViewById(R.id.edit_dialog) as EditText
        Log.d("ddd", "onCreate: "+ button_dialog)
        Log.d("ddd", "onCreate: "+ edit_dialog)
        initList()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_finish)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val myAdapter = FinishAllAdapter(list,this)
        recyclerView.adapter = myAdapter
        Log.d("ddd", "onCreate: "+ edit_dialog)
      button_dialog?.setOnClickListener {
          Log.d("ddd", "onCreate: "+ edit_dialog)
          thread{

              val itemDao = AppDatabase.getDatabase(this).userDao()
              itemDao.insertUser(User("y", edit_dialog?.text.toString(), 1))
              Log.d("ddd", "onCreate: "+ itemDao.loadAllUsers())
              Log.d("ddd", "onCreate: "+ edit_dialog)
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

        }

    }
}