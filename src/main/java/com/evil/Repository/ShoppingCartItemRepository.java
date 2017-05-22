package com.evil.Repository;

import com.evil.Entity.ShoppingCartItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Implements repository for shopping cart items.
 *
 * @author Vili Kinnunen & Erika Sankari
 * @version 2017.2205
 * @since 1.7
 */
@RepositoryRestResource(exported = false)
public interface ShoppingCartItemRepository extends PagingAndSortingRepository<ShoppingCartItem, Integer> {
}
