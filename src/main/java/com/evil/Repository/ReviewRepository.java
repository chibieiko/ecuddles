package com.evil.Repository;

import com.evil.Entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Implements repository for reviews of a product.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(exported = false)
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

}
