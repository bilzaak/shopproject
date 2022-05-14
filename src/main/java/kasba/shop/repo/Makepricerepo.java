package kasba.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kasba.shop.model.Makeprice;
import kasba.shop.model.Product;

public interface Makepricerepo extends JpaRepository<Makeprice,Integer> {

}
