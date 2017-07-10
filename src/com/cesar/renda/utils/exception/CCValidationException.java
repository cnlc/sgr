/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.renda.utils.exception;

import java.util.List;

/**
 *
 * @author cesar
 */
public class CCValidationException extends CCException {

    public CCValidationException(List<String> errors) {
        super(configError(errors));
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    private static String configError(List<String> errors) {
        StringBuilder strError = new StringBuilder();
        strError.append("Ocorreu os seguintes erros ao validadar os campos : ");
        for (String error : errors) {
            strError.append("\n").append(error);
        }
        return strError.toString();
    }

    private List<String> errors;

}
