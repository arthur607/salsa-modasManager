package com.project.salsa_Modas_Manager.repository;

public interface LoadRepository<T> {

    public T listAll(String productCode);

}
