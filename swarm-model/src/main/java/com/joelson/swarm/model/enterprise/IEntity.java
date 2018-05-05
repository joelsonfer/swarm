package com.joelson.swarm.model.enterprise;

import java.io.Serializable;

public interface IEntity<T> extends Serializable {

    T getId();
}
