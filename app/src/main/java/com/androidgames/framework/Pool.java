package com.androidgames.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manu on 7/13/2017.
 */

public class Pool<T> {

    public interface PoolObjetcFactory<T>{
        public T createObject();
    }

    private final List<T> freeObjects;
    private final PoolObjetcFactory<T> factory;
    private final int maxSize;

    public Pool(PoolObjetcFactory<T> factory, int maxSize){
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    public T newObject(){
        T object = null;
        if(freeObjects.size() == 0){
            object = factory.createObject();
        }else{
            object = freeObjects.remove(freeObjects.size()-1);
        }
        return object;
    }

    public void free(T object){
        if(freeObjects.size()<maxSize){
            freeObjects.add(object);
        }
    }

}