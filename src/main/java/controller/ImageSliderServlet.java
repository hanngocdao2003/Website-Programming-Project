package controller;

import bean.Slide;
import service.Add_Image_Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static service.Add_Image_Service.generateImageTags;

@WebServlet("/ImageSliderServlet")
public class ImageSliderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy danh sách đường dẫn hình ảnh từ cơ sở dữ liệu
        List<String> imagePaths = new ArrayList<>();

        // Tạo chuỗi HTML chứa các thẻ img với đường dẫn hình ảnh
        String imageTags = generateImageTags(imagePaths);

    }
}
