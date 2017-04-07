package com.evil.Repository;

import com.evil.Entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vili on 07/04/2017.
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>{
}