package com.wake.nlkm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class get_time {
    public static String getLastTimeInterval(Date date) {

//        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0) {
            dayOfWeek = 7;
        }
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        calendar2.add(Calendar.DATE, offset2 - 7);
        // last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
        // last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        return lastBeginDate + "," + lastEndDate;
    }

    public static String getNextTimeInterval(Date date) {
//        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0) {
            dayOfWeek = 7;
        }
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 + 7);
        calendar2.add(Calendar.DATE, offset2 + 7);
        // last Monday
        String lastBeginDate = sdf.format(calendar1.getTime());
        // last Sunday
        String lastEndDate = sdf.format(calendar2.getTime());
        return lastBeginDate + "," + lastEndDate;
    }

    public static String getTimeInterval(Date date) {
//        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, 0);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        return imptimeBegin + "," + imptimeEnd;
    }

    public static void main(String[] args) {
        String yz_time = getTimeInterval(new Date());
        String lastWeekReturnDate = getLastTimeInterval(new Date(2020 - 1900, 7 - 1, 12));//2020-10-02
        String nextWeekReturnDate = getNextTimeInterval(new Date());

        System.out.println("本周日期" + "" + yz_time);
        System.out.println("指定日期获取上周日期" + "" + lastWeekReturnDate);
        System.out.println("指定日期获取下周周日期" + "" + nextWeekReturnDate);

    }

}
