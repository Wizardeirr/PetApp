package com.volkankelleci.petsocialclub.data

class PrivateMessageDataBase(
    var message:String,
    var fromUUID:String,
    var toUUID:String,
    var timestamp: String,
    var chatUser:String) {
}