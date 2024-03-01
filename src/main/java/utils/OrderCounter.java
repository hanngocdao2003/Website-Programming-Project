package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderCounter {
    private static int orderCount = 0;
    private static String lastDate = "";

    public static synchronized int getNextOrderNumberForToday() {
        String currentDate = new SimpleDateFormat("yymmdd").format(new Date());

        if (!currentDate.equals(lastDate)) {
            // Nếu qua ngày mới, reset số thứ tự
            orderCount = 1;
            lastDate = currentDate;
        } else {
            // Ngày vẫn còn nguyên, tăng số thứ tự
            orderCount++;
        }

        return orderCount;
    }

}
