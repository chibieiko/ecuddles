package com.evil.Entity;

/**
 * Created by vili on 08/04/2017.
 */
public class MockData {
    static String[] productNames = {"Teddy", "Vilipehmo", "Erikapehmo", "Bunny", "Pahmo"};
    static String[] descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Nulla posuere, risus quis sagittis tincidunt, sapien elit sodales diam, id rutrum eros urna non tellus. Nunc sed elit nisl. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Quisque tincidunt vel mi sed venenatis. Vivamus dictum arcu vel ligula tristique faucibus. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt. Aliquam pharetra scelerisque turpis, vitae efficitur orci hendrerit vel. Aenean nec ornare eros."
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis et est vel ipsum dapibus sagittis. Donec imperdiet sit amet magna vitae dictum. Mauris sit amet luctus velit. Morbi iaculis tincidunt leo nec iaculis. Morbi eget nibh molestie, vulputate mi at, lobortis massa. Curabitur condimentum purus non euismod egestas. Morbi facilisis velit in ligula mollis, vel pharetra odio lacinia. Praesent sed sem a leo tristique sagittis ac at nisi. Etiam tempor risus magna, et molestie nulla molestie vel. Ut dictum condimentum tincidunt."
    };

    static double[] doubles = {
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

    static int[] ints = {
            0, 4, 1, 5, 6, 100, 34, 5349
    };

    static String[] colors = {
            "Blue", "Yellow", "Black", "Green", "Purple", "TAMK Events-color"
    };

    static String[] fabrics = {
            "Kangas", "Toinen kangas", "En minä vittu tiedä"
    };

    static String[] fillings = {
            "Suolet ja sisäelimet", "Vanu"
    };

    private static Object getRandom(Object[] objects) {
        return objects[(int)(Math.random()*objects.length)];
    }

    public static Product getProduct() {
        Product product = new Product();

        product.setName((String)getRandom(productNames));
        product.setDescription((String)getRandom(descriptions));

        return product;
    }


}
