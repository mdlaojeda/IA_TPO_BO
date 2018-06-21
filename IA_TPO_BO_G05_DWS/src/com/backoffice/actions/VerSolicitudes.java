package com.backoffice.actions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backoffice.beans.SolicitudesBeanRemote;
import com.backoffice.dto.SolicitudDTO;


public class VerSolicitudes implements IAction {
	@EJB
    private SolicitudesBeanRemote solicitudesBean;
	
	@Override
	public boolean isValid(String action) {
		return "VerSolicitudes".equals(action);
	}

	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, NumberFormatException {
		
		List<SolicitudDTO> solicitudes = new ArrayList<>();
		
    	solicitudes = solicitudesBean.getAll();
    	
    	request.setAttribute("solicitudes", solicitudes);
    	
		return "/versolicitudes.jsp";
	}

}
