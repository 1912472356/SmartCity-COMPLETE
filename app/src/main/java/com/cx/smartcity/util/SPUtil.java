package com.cx.smartcity.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtil {

    private static SharedPreferences sp;
    public static final String TOKEN = "TOKEN";
    public static final String HTTP = "HTTP";
    public static final String USER_HEAD = "USER_HEAD";
    public static final String FIRST = "FIRST";
    public static final String SHEQU_YOULING = "SHEQU_YOULING";
    public static final String SHEQU_CHELIANG = "SHEQU_CHELIANG";
    public static final String HUANBAO_YUYUE = "HUANBAO_YUYUE";
    public static final String HUANBAO_PRE_MSg = "HUANBAO_PRE_MSg";
    public static final String KAIMO_GONGYI = "KAIMO_GONGYI";
    public static final String KAIMO_NEAR_HERO = "KAIMO_NEAR_HERO";
    public static final String YANGLAO = "YANGLAO";
    public static final String ZHIZAO_ZHANHUI = "ZHIZAO_ZHANHUI";
    public static final String FUPING_CASE = "FUPING_CASE";
    public static final String BUS_MSG = "BUS_MSG";
    public static final String RECENT_CALL = "RECENT_CALL";

    public static void init(Context context){
        sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public static void put(String s, String v){
        sp.edit().putString(s, v).apply();
    }
    public static String get(String s){
        return sp.getString(s, null);
    }
}
