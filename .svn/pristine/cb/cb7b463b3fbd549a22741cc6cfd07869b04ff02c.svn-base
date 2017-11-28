package com.anrong.wulan.admin.common;

public class RateUtil {
	
	/**
	 * 四舍五入 保留一位小数的百分数
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static String getRate(int a, int b) {
		String rate = "";
		if (b == 0) {
			rate = "--";
		} else {
			//四舍五入 保留一位小数的百分数
			rate = String.valueOf(Math.round(((float) a / b * 100)
					* Math.pow(10, 1))
					/ Math.pow(10, 1))
					+ "%";
		}

		return rate;
	}

	/**
	 * 四舍五入 保留一位小数
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getDecimal(int a, int b) {
		String decimal = "";
		if (b == 0) {
			decimal = "--";
		} else {
			//四舍五入 保留一位小数
			decimal = String.valueOf((float) (Math.round((float) a / b
					* Math.pow(10, 1)))
					/ Math.pow(10, 1));

		}
		return decimal;
	}
	/**
	 * 四舍五入 保留一位小数的百分数
	 * @param a
	 * @return
	 */
	public static String getRate(double a) {
		String rate = "";
		if (a == 0) {
			rate = "--";
		} else {
			//四舍五入 保留一位小数的百分数
			rate = String.valueOf(Math.round((a * 100)
					* Math.pow(10, 1))
					/ Math.pow(10, 1))
					+ "%";
		}

		return rate;
	}
	/**
	 * 四舍五入 保留一位小数
	 * @param a
	 * @param b
	 * @param c 30日平均
	 * @return
	 */

	public static String getPreRate(int a, int b,String c) {
		String rate = "";
		if (b == 0) {
			rate = "--";
		} else {
			//四舍五入 保留一位小数
			rate = String.valueOf((float) (Math.round((float) a / b /Float.parseFloat(c)
					* Math.pow(10, 2)))
					/ Math.pow(10, 2));
		}
		return rate;
	}
}
