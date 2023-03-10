package com.volkankelleci.petsocialclub.userlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.Query
import com.volkankelleci.petsocialclub.R
import com.volkankelleci.petsocialclub.data.LastMessageDataBase
import com.volkankelleci.petsocialclub.data.UserInfo
import com.volkankelleci.petsocialclub.databinding.FragmentPrivateMessageListBinding
import com.volkankelleci.petsocialclub.data.PrivateMessageDataBase
import com.volkankelleci.petsocialclub.privatemessage.PrivateChatFragment
import com.volkankelleci.petsocialclub.privatemessage.PrivateChatFragmentArgs
import com.volkankelleci.petsocialclub.util.Util
import com.volkankelleci.petsocialclub.util.Util.auth
import com.volkankelleci.petsocialclub.util.Util.database
import com.volkankelleci.petsocialclub.util.Util.downloadImageToRecycler
import kotlinx.android.synthetic.main.fragment_private_chat_room.*
import kotlinx.android.synthetic.main.fragment_private_message_list.*
import kotlinx.android.synthetic.main.fragment_user_profile_menu.*

class PrivateMessageListFragment: Fragment() {
    private  var _binding:FragmentPrivateMessageListBinding?=null
    private val binding get() =_binding!!
    var userMessage=ArrayList<PrivateMessageDataBase>()
    private lateinit var adapter: PrivateMessageListAdapter
    val currentUserID=auth.currentUser!!.uid

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentPrivateMessageListBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fabForPM.setOnClickListener{
            val action=PrivateMessageListFragmentDirections.actionPrivateMessageListFragmentToPrivateChatFragment()
            findNavController().navigate(action)
        }
        val layoutManager=LinearLayoutManager(activity)
        userChatPartRV.layoutManager=layoutManager
        adapter= PrivateMessageListAdapter(userMessage)
        userChatPartRV.adapter=adapter

    }
}