package com.evil.Entity;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vili on 08/04/2017.
 */
public class MockData {
    static String[] productNames = {"Teddy", "Vilipehmo", "Erikapehmo", "Bunny", "Pahmo"};
    static String[] descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et" +
                    " est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Nulla posuere, risus quis sagittis tincidunt, sapien elit sodales diam, id rutrum eros urna non tellus. Nunc sed elit nisl. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Quisque tincidunt vel mi sed venenatis. Vivamus dictum arcu vel ligula tristique faucibus. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt. Aliquam pharetra scelerisque turpis, vitae efficitur orci hendrerit vel. Aenean nec ornare eros.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt."
    };

    static Double[] doubles = {
            15.00,
            10.00,
            19.99,
            25.00,
            99.99,
            150.00,
            40.00,
            60.00
    };

    static String[] careInstructions = {"Pese", "Älä pese", "Vie ulos tai jotain"};
    static String[] designers = {"Erika Sankari", "Vili Kinnunen", "jussi pohjolainen"};

    static String[] disposingInstructions = {
            "Heitä roskiin",
            "Polta",
            "Hukuta",
            "Hirtä"
    };

    static Integer[] ints = {
            0, 4, 1, 5, 6, 100, 34, 5349
    };

    static String[] colors = {
            "Sininen", "Keltainen", "Musta", "Vihreä", "Purppura", "TAMK " +
            "Events -väri"
    };

    static String[] fabrics = {
            "Kangas", "Toinen kangas", "En minä vittu tiedä"
    };

    static String[] fillings = {
            "Suolet ja sisäelimet", "Vanu"
    };

    static String[] urls = {
            "http://3.bp.blogspot.com/-_o7n1MQfVIw/VTORL0TSCrI/AAAAAAAAA4Y/JRMKuFH5LYU/s1600/IMG_4994.jpg",
            "https://www.karkkainen.com/tuotekuva/ISO/7331626101080.jpg",
            "https://www.pentik" +
                    ".com/media/catalog/product/cache/1/pentik_products/450x" +
                    "/9df78eab33525d08d6e5fb8d27136e95/pentik_products/1/P/1PUV4515221_1.jpg",
            "https://www.prisma" +
                    ".fi/wcsstore/PRISMA_StorefrontAssetStore/images/product/iso/0089606774423_kuva1.jpg",
            "http://www.primaverainteriors.fi/wp-content/uploads/2015/08/TOA6P-Toastie-Piglet.jpg"
    };

    static String[] captions = {
            "Kuva edestä", "Kuva takaa", "Kuva ylhäältä", "Kuva jostain " +
            "päin", "Belfie", "Selfie"
    };

    static Boolean[] booleans = {
            true, false
    };

    private static List<Category> getRandomCategoryList(List<Category> list) {
        ArrayList<Category> randomList = new ArrayList<>();
        int size = (int) (Math.random() * list.size());
        for (int i = 0; i < size; i++) {
            int randomObject = (int) (Math.random() * list.size());
            if (!randomList.contains(list.get(randomObject))) {
                randomList.add(list.get(randomObject));
            }
        }

        return randomList;
    }

    private static List<Review> getReviewList(List<Review> list) {
        ArrayList<Review> randomList = new ArrayList<>();
        int size = (int) (Math.random() * list.size());
        for (int i = 0; i < size; i++) {
            int randomObject = (int) (Math.random() * list.size());
            if (!randomList.contains(list.get(randomObject))) {
                randomList.add(list.get(randomObject));
            }
        }

        return randomList;
    }

    private static Object getRandom(Object[] objects) {
        return objects[(int)(Math.random()*objects.length)];
    }

    public static Product getProduct(List<Category> categoryList) {
        Product product = new Product();

        product.setName((String)getRandom(productNames));
        product.setDescription((String)getRandom(descriptions));
        product.setPrice((double)getRandom(doubles));
        product.setFabric((String)getRandom(fabrics));
        product.setFilling((String)getRandom(fillings));
        product.setDesigner((String)getRandom(designers));
        product.setHeight((double)getRandom(doubles));
        product.setWidth((double)getRandom(doubles));
        product.setLength((double)getRandom(doubles));
        product.setWeight((double)getRandom(doubles));
        product.setDisposeInstructions((String)getRandom(disposingInstructions));
        product.setStock((int)getRandom(ints));
        product.setColor((String)getRandom(colors));
        product.setCareInstructions((String)getRandom(careInstructions));
        product.setCategories(getRandomCategoryList(categoryList));
        /*
        ArrayList<Review> reviewList = new ArrayList<Review>(){{
            add(getReview("testi"));
            add(getReview("Tää on toinen testi"));
            add(getReview("Kolmeas testi"));
        }};

        product.setReviews(reviewList);
*/
        ArrayList<Picture> pictureList = new ArrayList<Picture>(){{
            add(getPicture());
            add(getPicture());
            add(getPicture());
        }};

        product.setPictures(pictureList);

        return product;
    }

    public static Category getCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return category;
    }

    public static Review getReview(String title) {
        Review review = new Review();
        review.setTitle(title);

        return review;
    }

    public static Picture getPicture() {
        Picture picture = new Picture();
        picture.setCaption((String)getRandom(captions));
        picture.setUrl((String)getRandom(urls));

        return picture;
    }
}