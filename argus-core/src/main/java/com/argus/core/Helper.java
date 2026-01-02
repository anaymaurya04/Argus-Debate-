package com.argus.core;

public class Helper {
    static {
        System.out.println("Helper static block loaded");
    }
    {
        System.out.println("Helper instance class executed");
    }

    public Helper(){
        System.out.println("Constructor is called");
    }

    static  void modify(Helper h){
        h=null;
    }

    public static void help() {
        System.out.println("help() method is called");
    }
}
