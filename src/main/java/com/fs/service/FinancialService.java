package com.fs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.fs.model.Audit;
import com.fs.model.Product;

/**
 * @author Mr-Yang
 *
 */
public interface FinancialService {

	/**
	 * @param catagory
	 * @return
	 */
	List<Product> queryProductBycatagory(String catagorg);

	/**
	 * @return
	 */
	List<Audit> queryAllAudit();

	/**
	 * @param catagorg
	 * @return
	 */
	List<Audit> queryAuditByCatagorg(String catagorg);

	/**
	 * @return
	 */
	List<Audit> queryAllOutAudit();

	/**
	 * @param integer
	 * @return
	 */
	int querySingleCostByName(int id);

	/**
	 * @param catagorg
	 * @return
	 */
	List<Audit> queryAllOutAuditByCatagorg(String catagorg);

	/**
	 * @return
	 */
	List<Product> queryAllProduct();

	/**
	 * @return
	 */
	List<Audit> queryAuditSecondCheck();

	/**
	 * @param id
	 * @return
	 */
	Audit queryAuditById(int id);

	/**
	 * @param name
	 * @param id 
	 * @return
	 */
	int updateAuditByName(String name, int id);

	/**
	 * @param productName
	 * @return
	 */
	Product queryProductByProductName(String productName);

	/**
	 * @param newprice
	 * @param newnumber
	 * @param pro_id 
	 * @return
	 */
	int updateProductByPriceAndNumber(double newprice, double newnumber, int pro_id);

	/**
	 * @param newnumber
	 * @param p_id 
	 * @return
	 */
	int updateProductByNumber(double newnumber, int p_id);

	/**
	 * @param id
	 * @param name 
	 * @return
	 */
	int noPass(int id, String name);

	/**
	 * @param goodsType
	 * @return
	 */
	List<Product> queryAllProductByGoodsType(String goodsType);

	/**
	 * @param name
	 * @param timeType 
	 * @return
	 */
	List<Audit> queryAuditByName(String name, String timeType);

	/**
	 * @return
	 */
	List<String> queryAllBround();

	/**
	 * @param string
	 * @param row 
	 * @param page 
	 * @return
	 */
	HashMap<String, Object> queryProductByBround(String string, int page, int row);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAllAuditByBround(String string);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAllOutAuditByBround(String string);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAllAuditByBround_Statistic(String string,String timeType);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAllAuditByBround_ChuKu(String string);

	/**
	 * @param productName
	 * @return
	 */
	String queryCostByName(String productName);

	/**
	 * @param id
	 * @return
	 */
	String queryBroundById(int id);

	/**
	 * @param bround
	 * @return
	 */
	List<String> quertAllProductByBround(String bround);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAuditByProName(String string);

	/**
	 * @param catagorg
	 * @param page
	 * @param row
	 * @return
	 */
	HashMap<String, Object> queryProductByBround_1(String catagorg,String mohu, int page, int row);

	/**
	 * @param name
	 * @param timeType
	 * @return
	 */
	List<Audit> queryAllAuditByProName(String name, String timeType);

	/**
	 * @param goodsType
	 * @return
	 */
	List<String> queryAllProductByGoods(String goodsType);

	/**
	 * @return
	 */
	List<String> queryAllBroundNoCondition();

	/**
	 * @param goodsType
	 * @return
	 */
	List<String> searAllProduct(String goodsType);

	/**
	 * @param string
	 * @param timeType
	 * @return
	 */
	List<Audit> queryAuditByTimeAndBround(String string, String timeType);

	/**
	 * @param string
	 * @param timeType
	 * @return
	 */
	List<Audit> queryAllSellAuditByProName(String string, String timeType);

	/**
	 * @return
	 */
	List<Audit> queryAuditSecondCheck_Success();

	/**
	 * @param timeType
	 * @param catagorg
	 * @return
	 */
	List<Audit> queryAuditSecondCheck_SuccessByCondition(String timeType, String catagorg);

	/**
	 * @param month
	 * @return
	 */
	List<Audit> queryAllAuditByMonth(int month);

}
