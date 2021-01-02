package com.reuben.store.repository;


import com.reuben.store.model.Customer;
import com.reuben.store.model.Product;
import com.reuben.store.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("select distinct(pd) from Purchase ph JOIN ph.product pd JOIN pd.vendor v where  ph.date < '2020-12-25' and v.id = ?1")
    List<Product> fetchAllProductsByVendorId(Long vendor_id);

    @Query("select distinct(C) from Purchase ph JOIN ph.product pd JOIN ph.customer C JOIN pd.vendor v where v.id = ?1")
    List<Customer> fetchAllCustomerByVendorId(Long vendor_id);

    @Query("select distinct(pd) from Purchase ph JOIN ph.product pd JOIN ph.customer C JOIN C.profile pr where ph.date < '2020-12-25' and pr.city=?1")
    List<Product> fetchAllProductsByCity(String city);
}
