package service;

import bean.Slide;
import dao.AddSlideDAO;

import java.util.ArrayList;
import java.util.List;

public class Add_Image_Service {
    private static AddSlideDAO slideDAO;

    public void uploadSlide(String name, byte[] data) {
        slideDAO = new AddSlideDAO();
        slideDAO.insertSlide(name, data);
    }

    public static List<String> loadSlider() {
        List<Slide> slideList = new AddSlideDAO().loadSlider();
        List<String> paths = new ArrayList<>();
        if (!slideList.isEmpty()) {
            for (Slide s : slideList
            ) {
               paths.add(s.getLink());
            }
        }
        return paths;

    }

    public static String generateImageTags(List<String> imagePaths) {
        StringBuilder html = new StringBuilder();

        // Tạo thẻ img cho mỗi đường dẫn hình ảnh
        for (String imagePath : imagePaths) {
            html.append("<img src=\"").append(imagePath).append("\" alt=\"\">");
        }

        return html.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Add_Image_Service().loadSlider().toString());
    }
}
