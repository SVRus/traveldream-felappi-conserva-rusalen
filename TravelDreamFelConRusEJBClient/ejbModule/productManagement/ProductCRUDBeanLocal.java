package productManagement;

import javax.ejb.Local;

import dto.ProductDTO;

@Local
public interface ProductCRUDBeanLocal {
    public boolean createProduct(ProductDTO productdto);

}
