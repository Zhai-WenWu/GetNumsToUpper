package com.goumin.forum.utils;

/**
 * Created by ZHAI on 2017/7/26.
 * zhai1615@163.com
 */

public class GetNumsToUpper {

    public static final String ZEROstr = "零";
    public static final long ZEROnum = 0;
    public static final String TENstr = "十";
    public static final long TENnum = 10;
    public static final String Hstr = "百";
    public static final long Hnum = TENnum * 10L;
    public static final String Tstr = "千";
    public static final long Tnum = Hnum * 10L;

    public static final String TTstr = "万";
    public static final long TTnum = Tnum * 10;
    public static final String HMstr = "亿";
    public static final long HMnum = TTnum * 10000L;

    public static final String TTHMstr = "万亿";
    public static final long TTHMnum = HMnum * 10000L;


    public static final String ONE = "一";
    public static final String TWO = "二";
    public static final String THREE = "三";
    public static final String FOUR = "四";
    public static final String FIVE = "五";
    public static final String SIX = "六";
    public static final String SEVEN = "七";
    public static final String EIGHT = "八";
    public static final String NINE = "九";


    public static String getNumString(long intInput) {
        if (intInput <= 0) {
            return ZEROstr;
        }
        long x000 = intInput / 1000; // 千
        intInput = intInput - x000 * 1000;
        long x00 = intInput / 100;   // 百
        intInput = intInput - x00 * 100;
        long x0 = intInput / 10;     // 十
        intInput = intInput - x0 * 10;
        long x = intInput;          // 个
        StringBuilder stringBuilder = new StringBuilder();
        if (x000 > 0) {
            stringBuilder.append(GetCH(x000)).append(Tstr);
        }
        if (x00 > 0) {
            stringBuilder.append(GetCH(x00)).append(Hstr);
        } else {
            if (x000 > 0 && (x0 > 0 || x > 0)) {
                stringBuilder.append(ZEROstr);
            }
        }
        if (x0 > 0) {
            if (x000 <= 0 && x00 <= 0 && x0 == 1) {
                stringBuilder.append(TENstr);
            } else {
                stringBuilder.append(GetCH(x0)).append(TENstr);
            }
        } else {
            if (x00 > 0 && x > 0) {
                stringBuilder.append(ZEROstr);
            }
        }
        if (x > 0) {
            stringBuilder.append(GetCH(x));
        }

        return stringBuilder.toString();
    }

    public static String getCnString(long intInput) {

        if (intInput >= TTHMnum) { //  大于千亿不考虑
            String str = new String(intInput + "");
            str = str.substring(str.length() - 12);
            intInput = Long.valueOf(str);
        }
        StringBuilder stringBuilder = new StringBuilder();

        if (intInput >= HMnum) {  // 过亿了
            long ttNum = intInput / HMnum;
            intInput = intInput % HMnum;
            stringBuilder.append(getNumString(ttNum)).append(HMstr);
        }

        if (intInput >= TTnum) {  // 过万
            long ttNum = intInput / TTnum;
            intInput = intInput % TTnum;
            stringBuilder.append(getNumString(ttNum)).append(TTstr);
        }

        if (intInput > 0) {
            if (stringBuilder.length() > 0 && (intInput < Tnum || intInput < Hnum || intInput < TENnum)) {
                stringBuilder.append(ZEROstr);
            }
            stringBuilder.append(getNumString(intInput));
        }
        return stringBuilder.toString();
    }


    private static String GetCH(long input) {
        String sd = "";
        int x = (int) input;
        switch (x) {
            case 1:
                sd = ONE;
                break;
            case 2:
                sd = TWO;
                break;
            case 3:
                sd = THREE;
                break;
            case 4:
                sd = FOUR;
                break;
            case 5:
                sd = FIVE;
                break;
            case 6:
                sd = SIX;
                break;
            case 7:
                sd = SEVEN;
                break;
            case 8:
                sd = EIGHT;
                break;
            case 9:
                sd = NINE;
                break;
            default:
                break;
        }
        return sd;
    }
}
