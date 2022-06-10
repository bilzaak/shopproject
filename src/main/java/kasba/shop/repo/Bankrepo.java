package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Bank;

public interface Bankrepo extends JpaRepository<Bank,Integer> {

	List<Bank> findByShopid(int shopid);

	
	
}
