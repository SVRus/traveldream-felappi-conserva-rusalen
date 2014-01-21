package webbeans;

import java.util.List;

public class CarStore {
	private String name;
	private List<Car> carList;
	
	public CarStore(String name, List<Car> carList) {
		super();
		this.name = name;
		this.carList = carList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	
	
	

}
