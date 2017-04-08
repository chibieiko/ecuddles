package com.evil.Repository;

import com.evil.Entity.Category;
import com.evil.Entity.Picture;
import com.evil.Entity.Product;
import com.evil.Entity.ProductListingProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0328
 * @since 1.7
 */

@RepositoryRestResource(excerptProjection = ProductListingProjection.class)
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
