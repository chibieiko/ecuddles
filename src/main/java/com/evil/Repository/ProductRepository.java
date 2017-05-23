package com.evil.Repository;

import com.evil.Entity.Product;
import com.evil.Entity.ProductListingProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Implements repository for products.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(excerptProjection = ProductListingProjection.class)
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    /**
     * Enables search of products by name.
     *
     * @param name  Name
     * @param p     Page
     * @return      Page
     */
    @RestResource(path = "/contains",rel="nameContaining")
    public Page findByNameContainingIgnoreCase(@Param("name") String name, Pageable p);

    /**
     * Enables search of products by category id.
     * @param id    Category id
     * @param p     Page
     * @return      Page
     */
    @RestResource(path = "/has",rel="productCategory")
    @Query(value="select p from Product p inner join p.categories category on " +
            "category.id = :categoryid")
    public Page findByCategory(@Param("categoryid")int id, Pageable p);
}