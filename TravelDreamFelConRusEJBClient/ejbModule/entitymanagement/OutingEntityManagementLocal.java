package entitymanagement;

import java.util.List;

import javax.ejb.Local;


@Local
public interface OutingEntityManagementLocal {
	public <Outing> void create(Outing outing);
	public <Outing>  Outing find(Object id);
	public <Outing> void edit (Outing outing);
    public <Outing>   List<Outing> findAll(); 	
	public <Outing> List<Outing> findAllByParameter(Object par) ;

}
