/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_data_loader.data_classes;

import exceptions.CouldntStoreDataException;

/**
 *
 * @author Paris
 */
public interface DBItem {
    
    public void store() throws CouldntStoreDataException;
    @Override
    public String toString();
}
