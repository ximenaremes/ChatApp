package com.example.chatapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.data.User
import com.example.chatapp.ui.home.fragments.ChatFragment
import com.google.firebase.auth.FirebaseAuth

typealias OnSelectItemChat = (User) -> Unit


class RecyclerAdapterContacts(

    val context: ChatFragment,
    val userList: ArrayList<User>,
    private val selectedItemChat: OnSelectItemChat

) : RecyclerView.Adapter<RecyclerAdapterContacts.ViewHolder>() {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentUser = userList[position]

        holder.itemName.text = currentUser.name

        holder.itemView.setOnClickListener {
            selectedItemChat.invoke(currentUser)
        }
//        holder.itemMessage.text= message[position]
//        holder.itemTime.text= time[position]

    }


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var itemName: TextView
//        var itemMessage: TextView
//        var itemTime: TextView


        init {
            itemName = item.findViewById(R.id.textNameUser)
//            itemMessage= item.findViewById(R.id.textMessageUser)
//            itemTime= item.findViewById(R.id.time)

        }
    }


}