package com.evil.Repository;

import com.evil.Entity.StockNotification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Implements repository for stock notifications.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(exported = false)
public interface StockNotificationRepository extends PagingAndSortingRepository<StockNotification, Integer> {
}
