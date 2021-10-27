package com.project.salsaModasManager.dto;

public interface Converter<T> {

     T converterToModel();

     T converterToResponse();



}
