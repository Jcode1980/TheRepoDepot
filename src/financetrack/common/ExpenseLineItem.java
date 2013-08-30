package financetrack.common;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseLineItem {
	private long expenseLineItemID;
	private String descText;
	private BigDecimal totalCost;
	private Date datePaid;
	private Asset asset;
	
	public long getExpenseLineItemID() {
		return expenseLineItemID;
	}

	@SuppressWarnings("unused")
	private void setExpenseLineItemID(long expenseLineItemID) {
		this.expenseLineItemID = expenseLineItemID;
	}
	
	public String getDescText() {
		return descText;
	}
	public void setDescText(String descText) {
		this.descText = descText;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public Date getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
	
	public Asset asset(){
		return asset;
	}
	
	public void setAsset(Asset value){
		asset = value;
	}
	
}
