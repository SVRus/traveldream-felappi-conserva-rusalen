package productManagement;

import javax.ejb.Local;

import dto.ProductDTO;

@Local
public interface ProductCreateBeanLocal {
    public boolean createProduct(ProductDTO productdto);

}
