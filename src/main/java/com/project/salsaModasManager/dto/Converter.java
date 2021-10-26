package com.project.salsaModasManager.dto;

public interface Converter<T> {

    public T converterToModel();

    public T converterToResponse();



}
