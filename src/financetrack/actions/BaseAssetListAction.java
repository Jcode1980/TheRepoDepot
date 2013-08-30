package financetrack.actions;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAssetListAction extends ActionSupport {
	private static List<String> comboMeals;
    
    static{
		comboMeals = new ArrayList<String>();
		comboMeals.add("Snack Plate");
		comboMeals.add("Dinner Plate");
		comboMeals.add("Colonel Chicken Rice Combo");
		comboMeals.add("Colonel Burger");
		comboMeals.add("O.R. Fillet Burger");
		comboMeals.add("Zinger Burger");
    }
    
	public List<String> getComboMeals() {
		return comboMeals;
	}

	/*
	public void setComboMeals(List<String> comboMeals) {
		this.comboMeals = comboMeals;
	}*/

}
