package com.evil.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates mockdata for a product.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
public class MockData {

    /**
     * All possible names for a product.
     */
    static String[] productNames = {"Teddy", "Bunny", "Teddy bear", "Bulbasaur", "Charmander", "Patamon", "Erika-plushie", "Vili-toy", "Playboy", "Fox", "Pohjus", "Pig", "Lion", "Best friend", "Nekolombus"};

    /**
     * All possible descriptions for a product.
     */
    static String[] descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et" +
                    " est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Nulla posuere, risus quis sagittis tincidunt, sapien elit sodales diam, id rutrum eros urna non tellus. Nunc sed elit nisl. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Quisque tincidunt vel mi sed venenatis. Vivamus dictum arcu vel ligula tristique faucibus. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt. Aliquam pharetra scelerisque turpis, vitae efficitur orci hendrerit vel. Aenean nec ornare eros.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt."
    };

    /**
     * All possible doubles used by various parameters of the product.
     */
    static Double[] doubles = {
            15.00,
            10.00,
            19.99,
            25.00,
            99.99,
            150.00,
            40.00,
            60.00,
            18.50,
            19.50,
            13.20,
            14.99,
            9.99,
            17.85,
            29.99,
            4.99,
            4.00,
            2.50,
            2.99
    };

    /**
     * All possible care instructions for a product.
     */
    static String[] careInstructions = {
            "Machine wash, max 40°C, mild process.",
            "Don't wash",
            "Take it out to the nature",
            "No drycleaning",
            "Do not bleach.",
            "Tumble drying, low temperature (max 60°C)."
    };

    /**
     * All possible designers for a product.
     */
    static String[] designers = {"Erika Sankari", "Vili Kinnunen", "Jussi Pohjolainen", "Juha Leino", "Max Power"};

    /**
     * All possible dispose instructions for a product.
     */
    static String[] disposingInstructions = {
            "Throw it into a garbage bin",
            "Burn it in flames",
            "Drown it into a river",
            "Hang it on a tree",
            "Never throw it away"
    };

    /**
     * All possible integers for stock.
     */
    static Integer[] ints = {
            0, 4, 1, 5, 6, 100, 34, 200, 300, 400, 500, 13, 445, 23, 45, 667, 56, 24, 1000
    };

    /**
     * All possible colors for a product.
     */
    static String[] colors = {
            "Blue", "Indigo", "Black", "Brown", "Gray", "White", "Yellow", "Red", "Green", "Beige"
    };

    /**
     * All possible fabrics for a product.
     */
    static String[] fabrics = {
            "100% polyester"
    };

    /**
     * All possible fillings for a product.
     */
    static String[] fillings = {
            "Polyester fibres"
    };

    /**
     * All possible picture URLs.
     */
    static String[] urls = {
            "http://3.bp.blogspot.com/-_o7n1MQfVIw/VTORL0TSCrI/AAAAAAAAA4Y/JRMKuFH5LYU/s1600/IMG_4994.jpg",
            "https://www.karkkainen.com/tuotekuva/ISO/7331626101080.jpg",
            "https://www.pentik" +
                    ".com/media/catalog/product/cache/1/pentik_products/450x" +
                    "/9df78eab33525d08d6e5fb8d27136e95/pentik_products/1/P/1PUV4515221_1.jpg",
            "https://www.prisma" +
                    ".fi/wcsstore/PRISMA_StorefrontAssetStore/images/product/iso/0089606774423_kuva1.jpg",
            "http://www.primaverainteriors.fi/wp-content/uploads/2015/08/TOA6P-Toastie-Piglet.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/e2/70/24/e27024586f427793216d8d58f518b3af.jpg",
            "http://www.buildabear.com/ProductImages/BABW_US/XL/21709x.jpg?01AD=3iMM3YZ4uXA3sKZ1k73iSSH_ulXJK4UFO2C8RRNuDzIJbvKyWfEom9w&01RI=4260BD0AF9EB2A3&01NA=",
            "http://www.euro-teddy.de/wordpress/wp-content/uploads/2014/07/Folksy4-e1404377156349.jpg",
            "http://www.jellycat.com/images/products/large/BAS3B.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/71MiN0m1hVL._SL1500_.jpg",
            "http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=47614424"
    };

    /**
     * All possible captions for a picture.
     */
    static String[] captions = {
            "Front", "Back", "Belfie", "Selfie"
    };

    /**
     * Gets random categories from a list.
     *
     * @param list  List of categories to choose from
     * @return      Categories
     */
    private static List<Category> getRandomCategoryList(List<Category> list) {
        ArrayList<Category> randomList = new ArrayList<>();
        int size = (int) (Math.random() * 2);
        for (int i = 0; i < size; i++) {
            int randomObject = (int) (Math.random() * list.size());
            if (!randomList.contains(list.get(randomObject))) {
                randomList.add(list.get(randomObject));
            }
        }

        return randomList;
    }

    /**
     * Gets random element from specified array.
     *
     * @param objects   Elements to choose from
     * @return          Random element
     */
    private static Object getRandom(Object[] objects) {
        return objects[(int)(Math.random()*objects.length)];
    }

    /**
     * Generates product with mockdata.
     *
     * @param categoryList  List of categories to choose from
     * @return              Random product
     */
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

        ArrayList<Picture> pictureList = new ArrayList<Picture>(){{
            add(getPicture());
            add(getPicture());
            add(getPicture());
        }};

        product.setPictures(pictureList);

        return product;
    }

    /**
     * Generates category based on a name.
     *
     * @param name  Name for the category
     * @return      Category
     */
    public static Category getCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return category;
    }

    /**
     * Generates random picture.
     *
     * @return  Picture
     */
    public static Picture getPicture() {
        Picture picture = new Picture();
        picture.setCaption((String)getRandom(captions));
        picture.setUrl((String)getRandom(urls));

        return picture;
    }
}