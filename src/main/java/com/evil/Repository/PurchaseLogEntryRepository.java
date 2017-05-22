package com.evil.Repository;

import com.evil.Entity.LogProjection;
import com.evil.Entity.PurchaseLogEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Implements repository for purchase log entries.
 *
 * @author Vili Kinnunen and Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(excerptProjection = LogProjection.class)
public interface PurchaseLogEntryRepository extends PagingAndSortingRepository<PurchaseLogEntry, Long> {
}
