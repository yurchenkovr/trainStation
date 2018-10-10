package db.interfaces;

import java.io.Serializable;

public interface Identified <PK extends Serializable> {
    PK getId();
}
