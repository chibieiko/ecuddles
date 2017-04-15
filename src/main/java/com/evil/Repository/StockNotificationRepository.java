package com.evil.Repository;

import com.evil.Entity.StockNotification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vili on 15/04/2017.
 */
@RepositoryRestResource(exported = false)
public interface StockNotificationRepository extends PagingAndSortingRepository<StockNotification, Integer> {
}