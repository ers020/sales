package com.sales.dao.repository;

import com.sales.dao.model.ItemPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemPurchaseRepository extends JpaRepository<ItemPurchase, Integer> {
}
