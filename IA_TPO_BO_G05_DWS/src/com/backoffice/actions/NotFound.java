package com.backoffice.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotFound implements IAction {

    public static final NotFound NOT_FOUND_ACTION = new NotFound();

    @Override
    public boolean isValid(String action) {
        return false;
    }

    @Override
    public String doAction(HttpServletRequest request, HttpServletResponse response) {
        return "/404.jsp";
    }

}
