package com.project.salsaModasManager.model.dto;

public interface Converter<T> {

     T converterToModel();

     T converterToResponse();



}
