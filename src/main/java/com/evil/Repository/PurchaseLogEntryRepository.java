package com.evil.Repository;

import com.evil.Entity.LogProjection;
import com.evil.Entity.PurchaseLogEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vili on 15/04/2017.
 */
@RepositoryRestResource(excerptProjection = LogProjection.class)
public interface PurchaseLogEntryRepository extends PagingAndSortingRepository<PurchaseLogEntry, Long> {
}
