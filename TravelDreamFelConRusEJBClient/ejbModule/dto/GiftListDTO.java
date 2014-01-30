package dto;

import stateenum.State;



public class GiftListDTO {
	private ProductDTO product;
	private String idBuyer;
	private String moreInfo;
	private boolean bought;
	private long travelPackageid;
	private String idCustomerCreator;
	//TODO
	
/**
 * constructor used during the acquisition phase
 * @param product
 * @param idBuyer
 * @param moreInfo
 * @param bought
 * @param travelPackageid
 * @param idCustomerCreator
 */
	public GiftListDTO(ProductDTO product, String idBuyer, String moreInfo,
			boolean bought, long travelPackageid,String idCustomerCreator) {
		super();
		this.product = product;
		this.idBuyer = idBuyer;
		this.moreInfo = moreInfo;
		this.bought = bought;
		this.travelPackageid = travelPackageid;
		this.idCustomerCreator=idCustomerCreator;
	}
	/**
	 * constructor used during the creation phase
	 * @param product
	 * @param idBuyer
	 * @param moreInfo
	 * @param bought
	 * @param travelPackageid
	 */
	public GiftListDTO(ProductDTO product, String idBuyer, String moreInfo,
			boolean bought, long travelPackageid) {
		super();
		this.product = product;
		this.idBuyer = idBuyer;
		this.moreInfo = moreInfo;
		this.bought = bought;
		this.travelPackageid = travelPackageid;
	}
	public String getIdCustomerCreator() {
		return idCustomerCreator;
	}

	public void setIdCustomerCreator(String idCustomerCreator) {
		this.idCustomerCreator = idCustomerCreator;
	}

	public boolean isBought() {
		return bought;
	}
	public void setBought(boolean bought) {
		this.bought = bought;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public String getIdBuyer() {
		return idBuyer;
	}
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public long getTravelPackageid() {
		return travelPackageid;
	}
	public void setTravelPackageid(long travelPackageid) {
		this.travelPackageid = travelPackageid;
	}
	
	public void setProductReserved()
	{
		product.setState(State.SOLD);
		
		
	}
}
