package com.example.finishallbyme.finishall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicekotlin.R


class FinishAllAdapter(private val list:ArrayList<finishData>)
    : RecyclerView.Adapter<FinishAllAdapter.MyViewHolder>() {
  class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
     val  layout_ponit_hook=itemView.findViewById<LinearLayout>(R.id.layout_point_hook)
      val finishTextTwo=itemView.findViewById<EditText>(R.id.finish_text_two)
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
       holder.finishTextTwo.setText(list.get(position).textFinish,TextView.BufferType.EDITABLE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_finish_all,parent,false)
        return MyViewHolder(view)
    }

}