package com.fs.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.fs.model.Audit;
import com.fs.model.Financial;
import com.fs.model.Product;
//import com.sun.org.glassfish.gmbal.ParameterNames;

public interface FinancialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Financial record);

    int insertSelective(Financial record);

    Financial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Financial record);

    int updateByPrimaryKey(Financial record);


	List<Product> queryProductBycatagory(@Param(value="catagorg")String catagorg);


	List<Audit> queryAllAudit();


	List<Audit> queryAuditByCatagorg(String catagorg);


	List<Audit> queryAllOutAudit();


	int querySingleCostByName(@Param(value="id")int id);


	List<Audit> queryAllOutAuditByCatagorg(String catagorg);


	List<Product> queryAllProduct();


	List<Audit> queryAuditSecondCheck();


	Audit queryAuditById(int id);


	int updateAuditByName(@Param(value="name")String name,@Param(value="id") int id);


	Product queryProductByProductName(String productName);


	int updateProductByPriceAndNumber(@Param(value="cost")String cost, @Param(value="number")double number,@Param(value="id") int pro_id);


	int updateProductByNumber(@Param(value="number")int number, @Param(value="id")int id);


	int noPass(@Param(value="id")int id, @Param(value="name")String name);

	/**
	 * @param goodsType
	 * @param timeType 
	 * @return
	 */
	List<Product> queryAllProductByGoodsType(@Param(value="goodsType")String goodsType);

	/**
	 * @param name
	 * @return
	 */
	List<Audit> queryAuditByName(@Param(value="name")String name,@Param(value="timeType")String timeType);

	/**
	 * @return
	 */
	List<String> queryAllBround();

	/**
	 * @param string
	 * @return
	 */
	List<Product> queryProductByBround(String string);

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
	List<Audit> queryAllAuditByBround_Statistic(@Param(value="string")String string,@Param(value="timeType")String timeType);

	/**
	 * @param string
	 * @return
	 */
	List<Audit> queryAllAuditByBround_ChuKu(String string);

	/**
	 * @param productName
	 * @return
	 */
	String queryCostByName(@Param(value="name")String productName);

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
	 * @param string
	 * @param page
	 * @param row
	 * @return
	 */
	List<Product> queryProductByBround(@Param(value="string")String string, @Param(value="start")int start,@Param(value="row") int row);

	/**
	 * @param string
	 * @return
	 */
	int selectCount(@Param(value="string")String string,@Param(value="sear")String sear);

	/**
	 * @param catagorg
	 * @param mohu
	 * @param start
	 * @param row
	 * @return
	 */
	List<Product> queryProductByBround_1(@Param(value="catagorg")String catagorg, @Param(value="sear")String sear, @Param(value="start")int start, @Param(value="row")int row);

	/**
	 * @param string
	 * @return
	 */
	int selectCountByString(String string);

	/**
	 * @param name
	 * @param timeType
	 * @return
	 */
	List<Audit> queryAllAuditByProName(@Param(value="name")String name, @Param(value="timeType")String timeType);

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
	List<Audit> queryAuditByTimeAndBround(@Param(value="string")String string, @Param(value="timeType")String timeType);

	/**
	 * @param string
	 * @param timeType
	 * @return
	 */
	List<Audit> queryAllSellAuditByProName(@Param(value="string")String string, @Param(value="timeType")String timeType);

	/**
	 * @return
	 */
	List<Audit> queryAuditSecondCheck_Success();

	/**
	 * @param timeType
	 * @param catagorg
	 * @return
	 */
	List<Audit> queryAuditSecondCheck_SuccessByCondition(@Param(value="timeType")String timeType, @Param(value="catagorg")String catagorg);

	/**
	 * @param month
	 * @return
	 */
	List<Audit> queryAllAuditByMonth(int month);
	
	
	
	
}