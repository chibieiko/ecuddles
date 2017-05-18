package com.evil.Repository;

import com.evil.Entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0415
 * @since 1.7
 */

@RepositoryRestResource(exported = false)
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

}
