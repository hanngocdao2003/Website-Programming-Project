package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
    public static String generateOrderId() {
        // "DH" + yymmdd + stt
        SimpleDateFormat dateFormat = new SimpleDateFormat("yymmdd");
        String dateString = dateFormat.format(new Date());

        // Lấy số thứ tự của đơn hàng trong ngày (có thể lấy từ cơ sở dữ liệu hoặc logic khác)
        int orderNumber = getOrderNumberForToday();

        // Tạo mã đơn hàng
        return "DH" + dateString + String.format("%02d", orderNumber);
    }

    private static int getOrderNumberForToday() {
        return OrderCounter.getNextOrderNumberForToday();
    }

    public static void main(String[] args) {
        System.out.println(generateOrderId());
    }
}
