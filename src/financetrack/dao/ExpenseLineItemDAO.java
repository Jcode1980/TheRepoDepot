package financetrack.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import financetrack.HibernateUtil;
import financetrack.common.ExpenseLineItem;
import financetrack.common.ExpenseLineItem;

public class ExpenseLineItemDAO {
	   @SessionTarget
	   Session session;
	   
	   @TransactionTarget
	   Transaction transaction;

   @SuppressWarnings("unchecked")
   public List<ExpenseLineItem> getAllExpenseLineItems()
   {
      List<ExpenseLineItem> assets = new ArrayList<ExpenseLineItem>();
      try
      {
    	  System.out.println("this is the session: "  + (session != null));
    	  session = HibernateUtil.getSessionFactory().getCurrentSession();
    	  session.beginTransaction();
    	  assets = session.createQuery("from ExpenseLineItem").list();
    	  session.getTransaction().commit();
  			HibernateUtil.getSessionFactory().close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return assets;
   }

   public void addExpenseLineItem(ExpenseLineItem asset) throws Exception
   {
	  System.out.println("addExpenseLineItem");
	  System.out.println("is Session null?? " + (session== null));
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
      session.save(asset);
      System.out.println("after add");
   }
  
	public void deleteExpenseLineItem(ExpenseLineItem asset) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(asset);
	}
	
	public ExpenseLineItem getExpenseLineItem(Long assetID) {
		ExpenseLineItem asset = null;
  	  	session = HibernateUtil.getSessionFactory().getCurrentSession();
  	  	session.beginTransaction();
		
		try {
			System.out.println("this is the session: "  + (session != null));
			//asset = (ExpenseLineItem) session.get(ExpenseLineItem.class, assetID);
			asset = (ExpenseLineItem) session.get(ExpenseLineItem.class, assetID);
			System.out.println("am i getting here?? " + asset);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
		e.printStackTrace();
		}
		finally{
			
  			HibernateUtil.getSessionFactory().close();
		}
		return asset;
	
	}
}
