package financetrack.dao;
import financetrack.HibernateUtil;
import financetrack.common.Asset;
import financetrack.common.User;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class AssetDAO {

	   @SessionTarget
	   Session session;
	   
	   @TransactionTarget
	   Transaction transaction;

   @SuppressWarnings("unchecked")
   public List<Asset> getAllAssets()
   {
      List<Asset> assets = new ArrayList<Asset>();
      try
      {
    	  System.out.println("this is the session: "  + (session != null));
    	  session = HibernateUtil.getSessionFactory().getCurrentSession();
    	  session.beginTransaction();
    	  assets = session.createQuery("from Asset").list();
    	  session.getTransaction().commit();
  			HibernateUtil.getSessionFactory().close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return assets;
   }

   public void addAsset(Asset asset) throws Exception
   {
	  System.out.println("addAsset");
	  System.out.println("is Session null?? " + (session== null));
	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  session.beginTransaction();
	  try{
	      session.save(asset);
	      session.getTransaction().commit();
	  }catch(Exception e){
		  e.printStackTrace();
	  }
      
      System.out.println("after add");
   }
   
   public void saveOrUpdateAsset(Asset asset) throws Exception{
	   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	  session.beginTransaction();
	  System.out.println("this is the asset ID: " + asset.getAssetID());
	  
	  try{
	      session.saveOrUpdate(asset);
	      session.getTransaction().commit();
	  }catch(Exception e){
		  e.printStackTrace();
	  }
   }
  
	public void deleteAsset(Asset asset) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(asset);
	}
	
	
	public Asset getAsset(int assetID) {
		Asset asset = null;
  	  	session = HibernateUtil.getSessionFactory().getCurrentSession();
  	  	session.beginTransaction();
		
		try {
			System.out.println("this is the session: "  + (session != null));
			//asset = (Asset) session.get(Asset.class, assetID);
			asset = (Asset) session.get(Asset.class, assetID);
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