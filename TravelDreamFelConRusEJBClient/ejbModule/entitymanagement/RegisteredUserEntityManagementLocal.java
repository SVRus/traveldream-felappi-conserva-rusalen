package entitymanagement;

import groupenum.Group;

import java.util.ArrayList;

import javax.ejb.Local;

@Local
public interface RegisteredUserEntityManagementLocal {

    public ArrayList <Group> findGroups(String username);

	
}
