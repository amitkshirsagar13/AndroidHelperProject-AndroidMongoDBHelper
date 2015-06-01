package org.shinigami.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * @projectName AndroidMongoDBHelper
 * Creation date: May 31, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class AndroidUser extends ShinigamiBaseEntity {
	private String email;
	private String phone;
	private List<AndroidUserApplication> applicationNames;
	private String lastUpdted;
	private boolean isUpdated;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the applicationNames
	 */
	public List<AndroidUserApplication> getApplicationNames() {
		if (applicationNames == null) {
			applicationNames = new ArrayList<AndroidUserApplication>();
		}
		return applicationNames;
	}

	/**
	 * @param applicationNames
	 *            the applicationNames to set
	 */
	public void setApplicationNames(List<AndroidUserApplication> applicationNames) {
		this.applicationNames = applicationNames;
	}

	/**
	 * @return the lastUpdted
	 */
	public String getLastUpdted() {
		return lastUpdted;
	}

	/**
	 * @param lastUpdted
	 *            the lastUpdted to set
	 */
	public void setLastUpdted(String lastUpdted) {
		this.lastUpdted = lastUpdted;
	}

	/**
	 * @return the isUpdated
	 */
	public boolean isUpdated() {
		return isUpdated;
	}

	/**
	 * @param isUpdated
	 *            the isUpdated to set
	 */
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

}
