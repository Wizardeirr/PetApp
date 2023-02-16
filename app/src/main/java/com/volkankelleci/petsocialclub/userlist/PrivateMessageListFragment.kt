package com.volkankelleci.petsocialclub.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.Query
import com.volkankelleci.petsocialclub.R
import com.volkankelleci.petsocialclub.databinding.FragmentPrivateMessageListBinding
import com.volkankelleci.petsocialclub.privatemessage.PrivateMessageDataBase
import com.volkankelleci.petsocialclub.util.Util
import com.volkankelleci.petsocialclub.util.Util.database
import kotlinx.android.synthetic.main.fragment_private_message_list.*

class PrivateMessageListFragment: Fragment(R.layout.fragment_private_message_list) {
    private  var _binding:FragmentPrivateMessageListBinding?=null
    private val binding get() =_binding!!
    var userMessage=ArrayList<PrivateMessageDataBase>()
    private lateinit var adapter: PrivateMessageListAdapter

    val toUUID= arguments?.let {
        PrivateMessageListFragmentArgs.fromBundle(it).pp
    }
    val userUUID = Util.auth.currentUser!!.uid
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentPrivateMessageListBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager=LinearLayoutManager(activity)
        userChatPartRV.layoutManager=layoutManager
        adapter= PrivateMessageListAdapter(userMessage)
        userChatPartRV.adapter=adapter

        takesInputs()

        fabForPM.setOnClickListener{
            val action=PrivateMessageListFragmentDirections.actionPrivateMessageListFragmentToPrivateChatFragment()
            findNavController().navigate(action)
        }

    }

    fun takesInputs(){
        database.collection("privateChatInfo/$toUUID/${Util.auth.currentUser!!.uid}")
            .addSnapshotListener { value, error ->
                if (error != null) {
                } else
                    if (value != null) {
                        if (value.isEmpty == false) {
                            val documents = value.documents
                            userMessage.clear()
                            for (document in documents) {
                                document.get("privateChatInfo/$toUUID/${Util.auth.currentUser!!.uid}")
                                val privateMessageUserText = document.get("userText").toString()
                                val privateChatUserUUID = document.get("PrivateChatUserUUID").toString()
                                val privateChatUserEmail = document.get("PrivateChatUserEmail").toString()
                                val privateChatUserDate = document.get("userDate").toString()
                                val privateChatToUUID = document.get("toUUID").toString()
                                val downloadInfos = PrivateMessageDataBase(privateMessageUserText,privateChatUserUUID,privateChatToUUID,privateChatUserDate,privateChatUserEmail)
                                userMessage.add(downloadInfos)
                                adapter.userMessage=userMessage

                            }
                            adapter.notifyDataSetChanged()
                        }
                    }
            }

    }


}
