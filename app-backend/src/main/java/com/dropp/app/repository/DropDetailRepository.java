package com.dropp.app.repository;

import com.dropp.app.model.DropDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DropDetailRepository extends JpaRepository<DropDetail, Long> {

    Optional<DropDetail> findById(Long id);

    List<DropDetail> findByUserId(Long userId);
}
