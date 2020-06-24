package com.lmonkey.entity;
/*6/21 这个类的作用是lmonkey_category表的bean*/
public class LMONKEY_CATEGORY {
	private int CATE_ID;
	private String CATE_NAME;
	private int CATE_PARTENR_ID;
	public LMONKEY_CATEGORY(int cATE_ID, String cATE_NAME, int cATE_PARTENR_ID) {
		super();
		CATE_ID = cATE_ID;
		CATE_NAME = cATE_NAME;
		CATE_PARTENR_ID = cATE_PARTENR_ID;
	}
	public int getCATE_ID() {
		return CATE_ID;
	}
	public void setCATE_ID(int cATE_ID) {
		CATE_ID = cATE_ID;
	}
	public String getCATE_NAME() {
		return CATE_NAME;
	}
	public void setCATE_NAME(String cATE_NAME) {
		CATE_NAME = cATE_NAME;
	}
	public int getCATE_PARTENR_ID() {
		return CATE_PARTENR_ID;
	}
	public void setCATE_PARTENR_ID(int cATE_PARTENR_ID) {
		CATE_PARTENR_ID = cATE_PARTENR_ID;
	}	
}
