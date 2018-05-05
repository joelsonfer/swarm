package com.joelson.swarm.model.enterprise;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Inherited
@Qualifier
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntitySaved {
}
