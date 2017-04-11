package com.evil.Repository;

import com.evil.Entity.Category;
import com.evil.Entity.CategoryListingProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vili on 07/04/2017.
 */

@RepositoryRestResource(excerptProjection = CategoryListingProjection.class)
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>{
}