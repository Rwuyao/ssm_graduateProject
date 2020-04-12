package com.fs.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr-Yang
 *
 */
public interface Q_ProductService {

	HashMap<String, Object> product_info(HttpServletRequest request, HttpServletResponse response,int page,int row);

	HashMap<String, Object> Q_selectMess(HttpServletRequest request, HttpServletResponse response,int page,int row);

	/*String autoPrompting(HttpServletRequest request,HttpServletResponse response);*/

}
