package com.fs.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr-Yang
 *
 */
public interface SupplierService {

	HashMap<String, Object> supplier_info(HttpServletRequest request, HttpServletResponse response, int page, int row);

	String Q_deleteSupMessage(HttpServletRequest request, HttpServletResponse response);

	String Q_selectSupplier(HttpServletRequest request, HttpServletResponse response);

	/*String Q_SupUpdateByMess(HttpServletRequest request, HttpServletResponse response);*/

/*	String Q_SuppInsertByMess(HttpServletRequest request, HttpServletResponse response);*/

	String Q_SupSelectMessage(HttpServletRequest request, HttpServletResponse response);

	HashMap<String, Object> Q_SupUpdateByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row);

	HashMap<String, Object> Q_SuppInsertByMess(HttpServletRequest request, HttpServletResponse response, int page,
			int row);

	

}
