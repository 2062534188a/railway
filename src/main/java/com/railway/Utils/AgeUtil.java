package com.railway.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AgeUtil {
    public static int getAgeByIdCard(String IdCardNumber) {
        //截取身份证上出生日期
        int year = Integer.parseInt(IdCardNumber.substring(0, 4));
        int month = Integer.parseInt(IdCardNumber.substring(4, 6));
        int day = Integer.parseInt(IdCardNumber.substring(6, 8));
        //获取当前日期
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeNow = formatter.format(calendar.getTime()).toString();
        //计算年龄/生日
        year = Integer.parseInt(timeNow.substring(0, 4)) - year;
        month = Integer.parseInt(timeNow.substring(5, 7)) - month;
        day = Integer.parseInt(timeNow.substring(8, 10)) - day;
        if (month < 0) {
            //返回年龄
            return ++year;
        } else if (month == 0) {
            if (day <= 0) {
                return ++year;
            }
        }
        return year;

    }

}
