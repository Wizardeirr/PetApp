package com.volkankelleci.petsocialclub.privatemessage

class PrivateMessageDataBase(
    var message:String,
    var fromUUID:String,
    var toUUID:String,
    var timestamp: String,
    var chatUser:String) {
}