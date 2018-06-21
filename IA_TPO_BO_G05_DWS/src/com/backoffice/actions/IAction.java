package com.backoffice.actions;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {

    boolean isValid(String action);

    String doAction(HttpServletRequest request, HttpServletResponse response) throws ParseException,  NumberFormatException;

}
