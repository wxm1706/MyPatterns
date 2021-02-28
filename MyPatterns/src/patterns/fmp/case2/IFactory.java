package patterns.fmp.case2;

import java.io.File;

public interface IFactory {
	public Role create(File resource);
}
