package patterns.afp.case1;

import java.io.File;

public interface IFactory {
	public Role createRole(File resource);
	public Effect createEffect(File resource);
}
