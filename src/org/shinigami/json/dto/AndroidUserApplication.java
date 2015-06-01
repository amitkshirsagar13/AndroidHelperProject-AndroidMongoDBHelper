package org.shinigami.json.dto;

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

public class AndroidUserApplication extends ShinigamiBaseEntity {
	private String email;
	private String applicationName;
	private String crtDate;
	private int usedCount;
	private boolean isUpdated;
	private String lastUpdated;
	private List<String> comments;

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName
	 *            the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the crtDate
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * @param crtDate
	 *            the crtDate to set
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	/**
	 * @return the usedCount
	 */
	public int getUsedCount() {
		return usedCount;
	}

	/**
	 * @param usedCount
	 *            the usedCount to set
	 */
	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	/**
	 * @return the comments
	 */
	public List<String> getComments() {
		if (comments == null) {
			comments = new ArrayList<String>();
		}
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(List<String> comments) {
		this.comments = comments;
	}

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

	/**
	 * @return the lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * @param lastUpdated
	 *            the lastUpdated to set
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
