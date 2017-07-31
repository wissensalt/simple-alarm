package com.wissensalt.rnd.simplealarm.view.table;

import java.util.Collection;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * 
 * @param <DATA>
 */
public interface ITableModelListener<DATA> {
    boolean add(DATA p_Object);

    DATA get(int p_Index);

    DATA set(int p_Index, DATA p_Element);

    DATA remove(int p_Index);

    boolean removeAll(Collection<DATA> p_CollectionObjects);
}
