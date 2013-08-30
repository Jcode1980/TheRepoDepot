package financetrack.test;
import financetrack.common.Asset;
import financetrack.service.*;
import financetrack.HibernateUtil;

import java.util.Date;
import org.hibernate.Session;
import java.math.*;


/**
 * Parent class for Service Tests that contains helper methods
 */
public abstract class ServiceTest {
	/**
	 * Build an Asset
	 * @return Asset
	 */
	protected Asset buildAsset() {
		Asset Asset = new Asset();
		Asset.setName("New Property");
		Asset.setDescText("The description");
		Asset.setIncomeYield(new BigDecimal(1000));
		
		return Asset;
	}

	/**
	 * Create an Asset
	 * @return Asset that was created
	 */
	protected Asset createAsset(){
		AssetService AssetService = new AssetService();
		Asset Asset = buildAsset();
		//System.out.println("thisis the asset");
		AssetService.saveOrUpdateAsset(Asset);
		//System.out.println("after: thisis the asset");
		return Asset;
	}
	
	/**
	 * Delete an Asset
	 * @param Asset Asset to be deleted
	 */
	protected void deleteAsset(Asset Asset) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		AssetService AssetService = new AssetService();
		AssetService.deleteAsset(Asset);
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}
}

