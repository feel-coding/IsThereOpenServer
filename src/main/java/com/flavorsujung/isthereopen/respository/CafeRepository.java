package com.flavorsujung.isthereopen.respository;
import com.flavorsujung.isthereopen.domain.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe,Integer> {
}
