package com.evil.Repository;

import com.evil.Entity.PurchaseLogEntry;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by vili on 15/04/2017.
 */

public interface PurchaseLogEntryRepository extends PagingAndSortingRepository<PurchaseLogEntry, Long> {
}
