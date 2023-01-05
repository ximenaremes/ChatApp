package com.example.chatapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R

class RecyclerAdapterContacts(): RecyclerView.Adapter<RecyclerAdapterContacts.ViewHolder>() {

    private var name= arrayOf("Erik Schmidt","George", "Vecinuta")
    private  var message= arrayOf("Erik,nu dormi, vreau sa-ti arat ceva", "Il iubi pe Erik ", "Am terminat aplicatia")
    private var time= arrayOf("01:10 AM", "01:07 AM", "01:00 AM")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  name.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text= name[position]
        holder.itemMessage.text= message[position]
        holder.itemTime.text= time[position]

    }

    class ViewHolder(item: View):RecyclerView.ViewHolder(item){

        var itemName: TextView
        var itemMessage: TextView
        var itemTime: TextView


        init {
            itemName= item.findViewById(R.id.textNameUser)
            itemMessage= item.findViewById(R.id.textMessageUser)
            itemTime= item.findViewById(R.id.time)

        }
    }


}