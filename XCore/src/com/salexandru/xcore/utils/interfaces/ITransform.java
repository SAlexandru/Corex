package com.salexandru.xcore.utils.interfaces;

public interface ITransform <OriginalUnderlyingType, NewUnderlyingType> {
	NewUnderlyingType transform(OriginalUnderlyingType origObj);
	OriginalUnderlyingType reverse (NewUnderlyingType newObj);	
}
