package xcorexview.metrics.methods;
import java.util.Scanner;

import org.eclipse.jdt.core.JavaModelException;

import com.salexandru.xcore.utils.interfaces.IPropertyComputer;
import com.salexandru.xcore.utils.metaAnnotation.PropertyComputer;

import exampletool.metamodel.entity.XMethod;

@PropertyComputer
public class NumberOfLines implements IPropertyComputer<Integer, XMethod> {
	@Override
	public Integer compute(XMethod entity) {
		
		try {
			final String commentsRegex = "(?://.*)|(/\\*(?:.|[\\n\\r])*?\\*/)";
			final String sourceCode = entity.getUnderlyingObject().getSource().replaceAll(commentsRegex, "");
			
			int count = 0;
			for (final Scanner scanner = new Scanner(sourceCode); scanner.hasNext(); ) {
				final String line = scanner.nextLine();
				if (!line.trim().isEmpty()) {
					++count;
				}
			}
			return count;
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
