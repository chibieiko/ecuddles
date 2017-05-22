package com.evil.Entity;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Implements projection for inspection of a product.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@Projection(name = "inspect", types = { Product.class })
public interface ProductInspectionProjection {

    /**
     * Gets id of the product.
     *
     * @return Id of the product
     */
    int getId();

    /**
     * Gets name of the product.
     *
     * @return Name of the product
     */
    String getName();

    /**
     * Gets name of the product.
     *
     * @return Name of the product
     */
    String getDescription();

    /**
     * Gets description of the product.
     *
     * @return Description of the product
     */
    double getPrice();

    /**
     * Gets fabric of the product.
     *
     * @return Fabric of the product
     */
    String getFabric();

    /**
     * Gets filling of the product.
     *
     * @return Filling of the product
     */
    String getFilling();

    /**
     * Gets designer of the product.
     *
     * @return Designer of the product
     */
    String getDesigner();

    /**
     * Gets height of the product.
     *
     * @return Height of the product
     */
    double getHeight();

    /**
     * Gets width of the product.
     *
     * @return Width of the product
     */
    double getWidth();

    /**
     * Gets length of the product.
     *
     * @return Length of the product
     */
    double getLength();

    /**
     * Gets weight of the product.
     *
     * @return Weight of the product
     */
    double getWeight();

    /**
     * Gets dispose instructions for the product.
     *
     * @return Dispose instructions for the product
     */
    String getDisposeInstructions();

    /**
     * Gets stock of the product.
     *
     * @return Stock of the product
     */
    int getStock();

    /**
     * Gets color of the product.
     *
     * @return Color of the product
     */
    String getColor();

    /**
     * Gets care instructions for the product.
     *
     * @return Care instructions for the product
     */
    String getCareInstructions();

    /**
     * Gets pictures of the product.
     *
     * @return Pictures of the product
     */
    List<Picture> getPictures();

    /**
     * Gets categories of the product
     *
     * @return Categories of the product
     */
    List<Category> getCategories();

    /**
     * Gets reviews of the product
     *
     * @return Reviews of the product
     */
    List<Review> getReviews();
}