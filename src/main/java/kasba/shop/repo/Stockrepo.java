package kasba.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Odar;
import kasba.shop.model.Product;
import kasba.shop.model.Stock;

public interface Stockrepo extends JpaRepository<Stock,Integer> {

	List<Stock> findByCompanyAndNameAndCode(String company, String name, String code);

	List<Stock> findByShopidAndCompanyAndNameAndCode(int shopid,String company, String name, String code);

	List<Stock> findByShopid(int shopid);

	
}
