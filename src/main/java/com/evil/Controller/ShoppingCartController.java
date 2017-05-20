package com.evil.Controller;

import com.evil.Entity.Product;
import com.evil.Entity.PurchaseLogEntry;
import com.evil.Entity.ShoppingCartItem;
import com.evil.Entity.User;
import com.evil.Exception.OutOfStockException;
import com.evil.Repository.ProductRepository;
import com.evil.Repository.PurchaseLogEntryRepository;
import com.evil.Repository.ShoppingCartItemRepository;
import com.evil.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vili on 01/04/2017.
 */
@RestController
@RequestMapping(path = "/api/cart")
public class ShoppingCartController {
    @Autowired
    private UserRepository users;

    @Autowired
    private ProductRepository products;

    @Autowired
    private PurchaseLogEntryRepository log;

    @Autowired
    private ShoppingCartItemRepository cart;

    @RequestMapping(method = RequestMethod.GET)
    public List<ShoppingCartItem> getCart() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return users.findByEmail(email).getShoppingCartProducts();
    }

    @RequestMapping(path = "/checkout", method = RequestMethod.GET)
    public ResponseEntity<?> checkout(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "address") String address,
                                      @RequestParam(name = "postalCode") String postalCode,
                                      @RequestParam(name = "city") String city,
                                      @RequestParam(name = "phone") String phone) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = users.findByEmail(email);

        List<ShoppingCartItem> userCart = user.getShoppingCartProducts();

        for (ShoppingCartItem shoppingCartItem : userCart) {
            if (shoppingCartItem.getQuantity() > shoppingCartItem.getProduct().getStock()) {
                throw new OutOfStockException();
            }
        }

        Date now = new Date();

        List<ShoppingCartItem> removeItems = new ArrayList<>();

        for (ShoppingCartItem shoppingCartItem : userCart) {
            Product product = shoppingCartItem.getProduct();
            product.setStock(product.getStock() - shoppingCartItem.getQuantity());
            products.save(product);

            PurchaseLogEntry entry = new PurchaseLogEntry();
            entry.setProduct(shoppingCartItem.getProduct());
            entry.setQuantity(shoppingCartItem.getQuantity());
            entry.setUser(user);

            entry.setName(name);
            entry.setAddress(address);
            entry.setPostalCode(postalCode);
            entry.setCity(city);
            entry.setPhone(phone);

            entry.setBought(now);
            log.save(entry);
            removeItems.add(shoppingCartItem);
        }

        List<ShoppingCartItem> cartCopy = userCart.subList(0, userCart.size());
        userCart.clear();

        users.save(user);

        for (ShoppingCartItem removeItem : removeItems) {
            cart.delete(removeItem);
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/modify", method = RequestMethod.GET)
    public ResponseEntity<ShoppingCartItem> modifyCart
            (@RequestParam(name = "product") int productId,
             @RequestParam(name = "quantity") int quantity) throws OutOfStockException {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = users.findByEmail(email);

        List<ShoppingCartItem> userCart = user.getShoppingCartProducts();

        if (productId == -1) {
            userCart.clear();
        } else {
            Product product = products.findOne(productId);

            if (quantity <= 0) {
                userCart.removeIf(shoppingCartItem -> shoppingCartItem.getProduct() == product);
            } else {
                if (product.getStock() < quantity) {
                    throw new OutOfStockException();
                }

                boolean updated = false;
                for (ShoppingCartItem shoppingCartItem : userCart) {
                    if (shoppingCartItem.getProduct() == product) {
                        shoppingCartItem.setQuantity(quantity);
                        updated = true;
                    }
                }

                if (!updated) {
                    ShoppingCartItem item = new ShoppingCartItem();
                    item.setQuantity(quantity);
                    item.setProduct(product);
                    cart.save(item);
                    userCart.add(item);
                }
            }
        }

        users.save(user);

        return ResponseEntity.ok().build();
    }
}
