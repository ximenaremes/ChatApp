package com.example.chatapp.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.data.User
import com.example.chatapp.ui.home.fragments.ChatFragment
import com.example.chatapp.ui.home.fragments.MessageFragment
import com.google.firebase.auth.FirebaseAuth

class RecyclerAdapterContacts(

    val context: ChatFragment,
    val userList:ArrayList<User>

    ): RecyclerView.Adapter<RecyclerAdapterContacts.ViewHolder>() {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
//    private var name= arrayOf("Erik Schmidt","George", "Vecinuta")
//    private  var message= arrayOf("Erik,nu dormi, vreau sa-ti arat ceva", "Il iubi pe Erik ", "Am terminat aplicatia")
//    private var time= arrayOf("01:10 AM", "01:07 AM", "01:00 AM")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentUser = userList[position]

        holder.itemName.text= currentUser.name

        holder.itemView.setOnClickListener{
//            Navigation.findNavController(view).navigate(R.id.action_chatFragment_to_messageFragment)
            val i = Intent(context.requireActivity(), MessageFragment::class.java)
            i.putExtra("name",currentUser.name)
            i.putExtra("uid",currentUser.uid)
            context.startActivity(i)
        }
//        holder.itemMessage.text= message[position]
//        holder.itemTime.text= time[position]

    }


    class ViewHolder(item: View):RecyclerView.ViewHolder(item){

        var itemName: TextView
//        var itemMessage: TextView
//        var itemTime: TextView


        init {
            itemName= item.findViewById(R.id.textNameUser)
//            itemMessage= item.findViewById(R.id.textMessageUser)
//            itemTime= item.findViewById(R.id.time)

        }
    }


}