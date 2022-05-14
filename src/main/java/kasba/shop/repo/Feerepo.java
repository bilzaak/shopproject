package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Fee;

public interface Feerepo extends JpaRepository<Fee,Integer>{

	List<Fee> findByShopid(int shopid);

	List<Fee> findByDistrictOrderByShopnameAsc(String district);

	List<Fee> findByDistrictAndThanaOrderByShopnameAsc(String district, String thana);

	List<Fee> findByThanaOrderByShopnameAsc(String district);

	List<Fee> findByDistrictAndThanaAndShopname(String district, String thana, String shopname);


	
}
