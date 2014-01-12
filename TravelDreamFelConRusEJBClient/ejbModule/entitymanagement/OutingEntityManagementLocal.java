package entitymanagement;

import javax.ejb.Local;

@Local
public interface OutingEntityManagementLocal {
	public <Outing> void create(Outing outing);
	public <Outing>  Outing find(Object id);
}
