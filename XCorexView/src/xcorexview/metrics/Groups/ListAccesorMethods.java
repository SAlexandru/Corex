package xcorexview.metrics.Groups;

import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;

import xmetamodel.XClass;
import xmetamodel.XMethod;
import xmetamodel.factory.FactoryMethod;

import com.salexandru.xcorex.interfaces.Group;
import com.salexandru.xcorex.interfaces.IGroupBuilder;
import com.salexandru.xcorex.metaAnnotation.GroupBuilder;


@GroupBuilder
public class ListAccesorMethods implements IGroupBuilder<XMethod, XClass> {
	@Override
	public Group<XMethod> buildGroup(XClass entity) {
		Group<XMethod> group_ = new Group<>();
		try {
			for (final IMethod method: entity.getUnderlyingObject().getMethods()) {
				    final XMethod xmethod = FactoryMethod.createXMethod(method);
					if (xmethod.isAccessor()) {
						group_.add(FactoryMethod.createXMethod(method));
					}
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return group_;
	}
}