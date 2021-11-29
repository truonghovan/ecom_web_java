package com.website.Cons;

public class Message {
    public static String errUser = "";
    public static String errEmail = "";
    public  static String errPhone = "";
    public  static String errPassword = "";
    public static String errAddress = "";
    public static String errFullName ="";

    public static  void reset() {
        Message.errUser="";
        Message.errAddress = "";
        Message.errPassword = "";
        Message.errPhone = "";
        Message.errEmail = "";
        Message.errFullName ="";
    }
}
