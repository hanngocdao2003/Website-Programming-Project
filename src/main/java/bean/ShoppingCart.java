package bean;

import service.ProductService;

import java.text.NumberFormat;
import java.util.*;

public class ShoppingCart {
    private Map<Integer, List<CartProduct>> mapCart = new HashMap<>();

    public Map<Integer, List<CartProduct>> getMapCart() {
        return mapCart;
    }

    public void setMapCart(Map<Integer, List<CartProduct>> mapCart) {
        this.mapCart = mapCart;
    }

    public boolean addProduct( int idUser ,String color, String size, int productId, int quantity) {
        CartProduct cartProduct = new CartProduct(quantity, size, color, productId);
        if (mapCart.containsKey(idUser)) {
            List<CartProduct> listCartProduct = mapCart.get(idUser);
            if (listCartProduct.contains(cartProduct)) {
                CartProduct product = listCartProduct.get(listCartProduct.indexOf(cartProduct));
                product.setQuantity(product.getQuantity() + quantity);
                System.out.println(product.getQuantity());
            } else {
                listCartProduct.add(cartProduct);
            }
            return true;
        } else {
            List<CartProduct> listCartProduct = new ArrayList<>();
            listCartProduct.add(cartProduct);
            mapCart.put(idUser, listCartProduct);
            return true;
        }
    }

    public boolean increasingQuantity(int productId, int cartProductIndex){
        CartProduct cartProduct = mapCart.get(productId).get(cartProductIndex);
        cartProduct.setQuantity(cartProduct.getQuantity() + 1);
        return true;
    }

    public boolean decreaseQuantity(int productId, int cartProductIndex) {
        CartProduct cartProduct = mapCart.get(productId).get(cartProductIndex);
        if (cartProduct.getQuantity() >= 1 ) {
            cartProduct.setQuantity(cartProduct.getQuantity() - 1);
            return true;
        } else {
            return false;
        }
    }
    public boolean removeProduct(int productId, int index) {
        mapCart.get(productId).remove(index);
        if(mapCart.get(productId).isEmpty()){
            mapCart.remove(productId);
        }
        return true;
    }

    public int getTotalItem(int idUser) {
        try{

            return mapCart.get(idUser).size();
        }catch (NullPointerException e){
            return 0;
        }
    }
    public double getTotalPrice(){
        double totalPrice = 0.0;
        for (Map.Entry<Integer, List<CartProduct>> entry : mapCart.entrySet()) {
            for (CartProduct cartProduct : entry.getValue()) {
                totalPrice += cartProduct.getQuantity() * ProductService.getDetails(cartProduct.getProductId()).getPrice();
            }
        }
        return totalPrice;
    }

    public String totalPriceFormatted(double cost) {
        Locale vietnamese = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(vietnamese);
        String price = format.format(cost);
        return price;
    }

    public static void main(String[] args) {
        // Tạo đối tượng ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct(1, "Red", "M", 1, 2);
        shoppingCart.addProduct(1, "Blue", "L", 2, 1);
        shoppingCart.addProduct(1,"Blue", "L", 2, 2);
        System.out.println(shoppingCart.mapCart);
        System.out.println(shoppingCart.getTotalPrice());

//        shoppingCart.increasingQuantity(1, 0);
//        shoppingCart.increasingQuantity(1, 0);
//        System.out.println(shoppingCart.mapCart);
//
//        shoppingCart.decreaseQuantity(1, 0);
//        shoppingCart.decreaseQuantity(1, 0);
//        shoppingCart.decreaseQuantity(1, 0);
//        System.out.println(shoppingCart.mapCart);

//        shoppingCart.removeProduct(1, 0);
//        System.out.println(shoppingCart.mapCart);
//        System.out.println(shoppingCart.getTotalItem());
    }
}
