package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Makeprice;
import kasba.shop.model.Product;

public interface Makepricerepo extends JpaRepository<Makeprice,Integer> {

	List<Makeprice> findByShopidAndCompanyAndNameContainingIgnoreCase(int ashopid,
			String company, String name);

	List<Makeprice> findByShopidAndCompanyAndCodeContainingIgnoreCase(int shopid,
			String company, String code);

	List<Makeprice> findByShopidAndCompanyAndCode(int shopid, String company, String code);

}
