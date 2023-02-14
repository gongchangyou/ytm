package com.mouse.ytm;

/**
 * @author gongchangyou
 * @version 1.0
 * @date 2023/2/14 21:45
 */
public class YTMUtil {

    /**
     *
     * @param current_price 现价
     * @param price 票面价格 通常是100
     * @param rate 票面利率
     * @param year 到期年份
     * @return
     */
    public static double calculateYield(double current_price, double price, double rate, int year) {
        if (year == 3) {
            return calculateYield3Year(current_price, price, rate);
        }

        return 0;
    }

    /**
     * 卡丹公式 https://baike.baidu.com/item/%E5%8D%A1%E5%B0%94%E8%BE%BE%E8%AF%BA%E5%85%AC%E5%BC%8F/18880906?fromtitle=%E5%8D%A1%E4%B8%B9%E5%85%AC%E5%BC%8F&fromid=7133385&fr=aladdin
     * 由于一般三次方程y3+ay2+by+c=0经过未知量的代换y=x-b/3后，可化为形如x3+px+q=0的三次方程。
     * 令 1+r = R
     * 有  R^3 - pr/cp * R^2 - pr/cp * R - (p+pr)/cp = 0
     * 其中cp= current_price pr=price * rate
     * 令  -pr/cp = b,  R = x - b / 3
     * 公式可以转换成 x^3 - b^2 / 3 * x + 2/27*b^3 + b - p/cp = 0
     * x= u + v
     * @param current_price
     * @param price
     * @param rate
     * @return
     */
    public static double calculateYield3Year(double current_price, double price, double rate) {
        double b = (-price * rate) / current_price;
        double p = - Math.pow(b, 2) / 3;
        double q = 2/27.0d * Math.pow(b, 3) + b - price/current_price;
        double u = Math.pow((-q/2 + Math.pow(Math.pow(p, 3)/27 + Math.pow(q, 2)/4, 1.0/2)), 1.0/3);
        double v = Math.pow((-q/2 - Math.pow(Math.pow(p, 3)/27 + Math.pow(q, 2)/4, 1.0/2)), 1.0/3);
        double x = u + v;
        double R = x - b /3;

        double tmp = Math.pow(R, 3) + b *Math.pow(R, 2) +b *R - price/current_price + b;
        System.out.println(tmp); //not zero!!

        double r = R - 1 ;
        return r;
    }


}
