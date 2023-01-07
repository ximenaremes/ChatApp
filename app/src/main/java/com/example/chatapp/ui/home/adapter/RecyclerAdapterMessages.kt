package com.example.chatapp.ui.home.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.data.Message
import com.example.chatapp.ui.home.fragments.MessageFragment
import com.example.chatapp.utils.Constants
import com.google.firebase.auth.FirebaseAuth


class RecyclerAdapterMessages(
    val context:MessageFragment,
    val messageList:ArrayList<Message>
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 1){
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_message_received, parent, false)
            return ReceiveViewHolder(view)
        }
        else{
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_message_send, parent, false)
            return SentViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentMessage= messageList[position]

        if(holder.javaClass == SentViewHolder::class.java){

           val viewHolder = holder as SentViewHolder
           holder.sentMessage.text= currentMessage.message
       }
       else{

           val viewHolder = holder as ReceiveViewHolder
           holder.receiveMessage.text = currentMessage.message
       }
    }

    override fun getItemViewType(position: Int): Int {

        val currentMessage = messageList[position]

        if (firebaseAuth.currentUser?.uid.equals(currentMessage.senderId)){
            return Constants.ITEM_SENT
        }
        else {
            return Constants.ITEM_RECEIVE
        }

    }

    override fun getItemCount(): Int {
       return messageList.size
    }
    class SentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val sentMessage = itemView.findViewById<TextView>(R.id.messageUserSent)

    }

    class ReceiveViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val receiveMessage = itemView.findViewById<TextView>(R.id.messageUserReceive)
    }

}



//recyclerViewMessage