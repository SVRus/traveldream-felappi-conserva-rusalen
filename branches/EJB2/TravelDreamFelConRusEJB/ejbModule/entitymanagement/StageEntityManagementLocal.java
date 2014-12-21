package entitymanagement;

import javax.ejb.Local;

@Local
public interface StageEntityManagementLocal {
public Long findIdTravelPackageContainer(Long idStage);

}
