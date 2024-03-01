package controller.shoppingcart;

import bean.CartProduct;
import bean.ShoppingCart;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "remove", value = "/remove")
public class Remove extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        int idUser = (int) session.getAttribute("Id");
        int productId = Integer.parseInt(request.getParameter("id"));
        int index = Integer.parseInt(request.getParameter("index"));
        if (shoppingCart.getMapCart().containsKey(productId)) {
            List<CartProduct> productList = shoppingCart.getMapCart().get(productId);
            if (index >= 0 && index < productList.size()) {
                // Gọi phương thức removeProduct để xóa sản phẩm
                boolean removalSuccessful = shoppingCart.removeProduct(productId, index);

                if (removalSuccessful) {
                    session.setAttribute("cart", shoppingCart);

                    int totalItems = shoppingCart.getTotalItem(idUser);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("totalItems", totalItems);
                    response.setContentType("application/json");
                    response.getWriter().println(jsonObject);
                } else {
                    // Nếu việc xóa không thành công, trả về mã lỗi
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            } else {
                // Nếu index không hợp lệ, trả về mã lỗi
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } else {
            // Nếu productId không tồn tại trong giỏ hàng, trả về mã lỗi
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
