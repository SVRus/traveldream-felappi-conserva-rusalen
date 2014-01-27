package entitymanagement;

import javax.ejb.Local;

@Local
public interface CodeEntityManagementLocal {
	public <Code> void create(Code code);
	public <Code>  Code find(Object id);
}
