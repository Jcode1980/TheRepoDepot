package financetrack.common;
import java.math.*;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import financetrack.FinanceTrackUtils;

public class Asset {
	public static final ArrayList<PaymentFrequency> paymentTypesEnumArray = new ArrayList<PaymentFrequency>();
	private int assetID;
	private String name;
	private String descText;
	private String address;
	private BigDecimal incomeYield;
	private AssetType assetType;
	
	public Asset(){
		System.out.println("Creating an asset");
		Thread.dumpStack();
	}
	
    public enum PaymentFrequency{
    	WEEKLY_PAYMENT("Weekly", new Integer(1)), MONTHLY_PAYMENT("Monthly", new Integer(2)), ANNUAL_PAYMENT("Purchase Order", new Integer(3));
    	
    	private final String _label;
    	private Integer _type;
    	
    	private PaymentFrequency(String label, Integer typeInt){
    		_label = label;
    		_type = typeInt;
    	}
    	
    	static{
    		paymentTypesEnumArray.add(PaymentFrequency.WEEKLY_PAYMENT);
    		paymentTypesEnumArray.add(PaymentFrequency.MONTHLY_PAYMENT);
    		paymentTypesEnumArray.add(PaymentFrequency.ANNUAL_PAYMENT);
    	}
    	
    	public String label() {
			return _label;
		}
    	
    	public Integer type() {
			return _type;
		}
    }	

	public int getAssetID() {
		return assetID;
	}

	
	public void setAssetID(int assetID) {
		System.out.println("setting assetID: " + assetID);
		this.assetID = assetID;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		System.out.println("setting the name");
		this.name = name;
	}
	
	public String getDescText() {
		return descText;
	}
	
	public void setDescText(String desctext) {
		this.descText = desctext;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public BigDecimal getIncomeYield() {
		return incomeYield;
	}
	public void setIncomeYield(BigDecimal incomeYield) {
		this.incomeYield = incomeYield;
	}
	
	/*
	public BigDecimal getWeeklyRent() {
		return weeklyRent;
	}
	public void setWeeklyRent(BigDecimal weeklyRent) {
		this.weeklyRent = weeklyRent;
	}*/
	
	
	public BigDecimal grossAnnualReturn(){
		BigDecimal grossMonthlyReturn = grossMonthlyReturn();
		
		if(!grossMonthlyReturn.equals(FinanceTrackUtils.ZERO_BIG_DECIMAL)){
			return grossMonthlyReturn.multiply(FinanceTrackUtils.NUMBER_OF_MONTHS_PER_YEAR);
		}
		else{
			return FinanceTrackUtils.ZERO_BIG_DECIMAL;
		}
	}
	
	public BigDecimal grossMonthlyReturn(){
		BigDecimal incomeYield = getIncomeYield();
		
		if(incomeYield != null){
			
			/*
			switch(activeView)
			{
				case Day:
					start.set(Calendar.DATE, start.get(Calendar.DATE) + offset);
					break;
				case Month:
	
			}*/
			return null;
		}
		return null;
	}
	
	public AssetType getAssettype(){
		return assetType;
	}
	
	public void setAssettype(AssetType value){
		assetType = value;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(512);
		sb.append("\n----Asset----\n");
		sb.append("assetID=" + assetID + "\n");
		sb.append("name=" + getName() + "\n");
		sb.append("Income yield = " + incomeYield + "\n");
		sb.append("----Asset----\n");
		return sb.toString();
	}
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		return true;
	}
	*/
}
