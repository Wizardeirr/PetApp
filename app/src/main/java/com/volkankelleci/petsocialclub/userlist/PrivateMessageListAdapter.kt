package com.volkankelleci.petsocialclub.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volkankelleci.petsocialclub.R
import com.volkankelleci.petsocialclub.data.LastMessageDataBase
import com.volkankelleci.petsocialclub.data.PrivateMessageDataBase
import com.volkankelleci.petsocialclub.data.UserInfo
import kotlinx.android.synthetic.main.chat_list_raw.view.*

class PrivateMessageListAdapter(var userChatWindow: ArrayList<LastMessageDataBase>): RecyclerView.Adapter<PrivateMessageListAdapter.PrivateMessageListFragmentPart>() {
    class PrivateMessageListFragmentPart(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PrivateMessageListFragmentPart {
        val inflater=LayoutInflater.from(parent.context)
        val viewHolder=inflater.inflate(R.layout.chat_list_raw,parent,false)
        return PrivateMessageListFragmentPart(viewHolder)
    }

    override fun onBindViewHolder(holder: PrivateMessageListFragmentPart, position: Int) {
        holder.itemView.userNameForChat.text=userChatWindow.get(position).lastMessage
        holder.itemView.lastMessage.text=userChatWindow.get(position).lastMessagechatUser
        holder.itemView.timerMessage.text=userChatWindow.get(position).lastMessagetimestamp


    }

    override fun getItemCount(): Int {
        return userChatWindow.size
    }
}