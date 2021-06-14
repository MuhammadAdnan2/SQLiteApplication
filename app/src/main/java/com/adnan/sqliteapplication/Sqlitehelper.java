package com.adnan.sqliteapplication;

public class Sqlitehelper {

    public  static final String Table_Name = "Student";
    public static  final String Student_Name = "name";
    public static  final String Students_Father = "father_name";

    public  static  final String[] ALL_COLUMN = new String[]{Student_Name, Students_Father};


    public static final  String SQL_CREATE = "CREATE TABLE "+ Table_Name + "("
                                              +Student_Name+ " TEXT, " + Students_Father +" TEXT);";

    public   static  final  String SQL_Delete = "DROP TABLE IF EXISTS"+Table_Name;



}
