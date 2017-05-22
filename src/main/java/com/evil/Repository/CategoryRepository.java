package com.evil.Repository;

import com.evil.Entity.Category;
import com.evil.Entity.CategoryListingProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Implements repository for categories.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(excerptProjection = CategoryListingProjection.class)
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>{
}