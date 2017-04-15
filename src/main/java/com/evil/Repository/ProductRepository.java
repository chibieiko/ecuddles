package com.evil.Repository;

import com.evil.Entity.Product;
import com.evil.Entity.ProductListingProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TODO Short Description
 * <p>
 * TODO caption and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@RepositoryRestResource(excerptProjection = ProductListingProjection.class)
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
