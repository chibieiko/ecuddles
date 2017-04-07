package com.evil.Repository;

import com.evil.Entity.Picture;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TODO Short Description
 * <p>
 * TODO description and @since
 *
 * @author Erika Sankari
 * @version 2017.0404
 * @since 1.7
 */


public interface PictureRepository extends PagingAndSortingRepository<Picture,
        Long> {

}