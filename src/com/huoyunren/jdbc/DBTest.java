package com.huoyunren.jdbc;

import java.sql.ResultSet;

import junit.framework.TestCase;

public class DBTest extends TestCase {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		System.out.println("setUp()");
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		System.out.println("tearDown()");
	}

	public void testInsert() {
		sql = "insert into database_test (Brand, Motorcycle_type, engine, Factory_year, Effluent_standard, SMART_version, CTBOX_version, Adaptation_situation, Time, Vehiclespeed_ID, Speed_ID, Instantaneous_fuel, Totle_fuel, Totle_mileage, Speed_high, Totle_mileage_high, Image) values('测试','环达牌BJQ5160TQPtest','BF6M2012-18E4test','2014test','国四/欧四','','1.27.0.5','已适配（SMART）','2016-03-08','0x0cfe6c17','0x0cf00400','0x18fef200','','','','',NULL);";
		db1 = new DBHelper(sql);
		try {
			db1.pst.execute();
			System.out.println("testInsert()");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db1.close();
		}

	}

	public void testSelect() {
		sql = "SELECT * from database_test t where Brand='测试'";
		db1 = new DBHelper(sql);
		try {
			ret = db1.pst.executeQuery();
			while (ret.next()) {
				assertEquals("测试", ret.getString("Brand"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db1.close();
		}
		System.out.println("testSelect()");
	}

	/**
	 * 请注意加密字段在修改语句中 不支持作为where 条件。
	 */
	public void testUpdate() {
		sql = "update database_test t  set Brand='测试update' where t.Motorcycle_type='环达牌BJQ5160TQPtest'";
		db1 = new DBHelper(sql);
		try {
			db1.pst.execute();
			System.out.println("testUpdate()");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db1.close();
		}

	}

	/**
	 * 请注意加密字段在删除语句中 不支持作为where 条件。
	 */
	public void testDelete() {
		System.out.println("testDelete()");
	}

}
