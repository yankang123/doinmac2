package com.example.finishallbyme.finishall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.doinmac2.MainActivity
import com.example.doinmac2.MyApplication
import com.example.doinmac2.R
import java.util.Timer
import java.util.TimerTask


class FinishAllAdapter(private val list:ArrayList<finishData>,val activity: MainActivity)
    : RecyclerView.Adapter<FinishAllAdapter.MyViewHolder>() {

  class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
     val  layout_ponit_hook=itemView.findViewById<LinearLayout>(R.id.layout_point_hook)
      val finishTextTwo=itemView.findViewById<TextView>(R.id.finish_text_two)
      val image_hook =itemView.findViewById<ImageView>(R.id.image_hook)
  }



    override fun getItemCount(): Int {
       return list.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layout_ponit_hook.setOnClickListener {
            //划勾加划线
            //更新Adapter

        }

        //TODO("根据数据去  看是否已经完成 完成则划勾加划线")
        holder.finishTextTwo.setText(list.get(position).textFinish, TextView.BufferType.EDITABLE)
        holder.finishTextTwo.setOnClickListener {
            activity.showBottomDialog()
            showSoftInput()

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_finish_all,parent,false)
        return MyViewHolder(view)
    }

   public  fun showSoftInput(){
       var timer = Timer()
       val edit_dialog = activity.view?.findViewById<EditText>(R.id.edit_dialog)
       //设置可获得焦点
       edit_dialog?.isFocusable = true
       edit_dialog?.isFocusableInTouchMode = true
       edit_dialog?.requestFocus()
       timer.schedule(object : TimerTask() {
           override fun run() {

               val inputManager: InputMethodManager =
                   MyApplication.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

               inputManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);



           }
       }
           , 300)

   }
}