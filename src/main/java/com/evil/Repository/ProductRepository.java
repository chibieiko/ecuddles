package com.evil.Repository;

import com.evil.Entity.Picture;
import com.evil.Entity.Product;
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

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @RestResource(path = "/name-start", rel = "search")
    Page findByNameStartsWith(@Param("name") String name, Pageable p);

    @RestResource(path = "/name-end", rel = "search")
    Page findByNameEndsWith(@Param("name") String name, Pageable p);

 /*   @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Product save(@Param("product")Product product);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(@Param("id")Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(@Param("product")Product product);*/
}
