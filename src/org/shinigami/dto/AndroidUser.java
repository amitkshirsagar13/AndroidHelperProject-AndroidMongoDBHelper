package org.shinigami.dto;

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
	private List<AndroidUserApplication> applicationNames;

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
	 * @return the applicationNames
	 */
	public List<AndroidUserApplication> getApplicationNames() {
		return applicationNames;
	}

	/**
	 * @param applicationNames
	 *            the applicationNames to set
	 */
	public void setApplicationNames(List<AndroidUserApplication> applicationNames) {
		this.applicationNames = applicationNames;
	}

}
