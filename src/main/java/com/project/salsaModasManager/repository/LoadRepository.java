package com.project.salsaModasManager.repository;

public interface LoadRepository<T> {

    public T listAll(String productCode);

}
