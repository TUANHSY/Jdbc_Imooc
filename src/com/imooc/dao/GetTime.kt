package com.imooc.dao

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

/**
 * @Author: duanxu
 * @Date: 2019/5/8 16:50
 */
class GetTime {
    val timeByDateWithFormat: Long
        get() {
            val date = Date()
            return date.time
        }
    //        System.out.println(df.format(System.currentTimeMillis()));
    val timeByCurrentTimeMillis: String
        get() {
            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return df.format(System.currentTimeMillis())
        }
    //        System.out.println(year + "-" + month + "-" + date + " " +hour + ":" +minute + ":" + second);
    val timeByCalendar: String
        get() {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH) + 1
            val date = c.get(Calendar.DATE)
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)
            val second = c.get(Calendar.SECOND)
            return year.toString() + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second
        }
    //        System.out.println(year+"-"+month+"-"+day);
    val timeByDate: String
        get() {
            val date = Date()
            val year = String.format("%tY", date)
            val month = String.format("%tB", date)
            val day = String.format("%te", date)
            return year + "-" + month + "-" + day
        }
    /*    public static void main(String[] args) {
        GetTime getTime =new GetTime();
        getTime.getTimeByDateWithFormat();
        getTime.getTimeByCurrentTimeMillis();
        getTime.getTimeByCalendar();
        getTime.getTimeByDate();
    }*/
}
