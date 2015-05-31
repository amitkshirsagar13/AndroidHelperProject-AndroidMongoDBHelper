package org.shinigami.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.DBObject;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShinigamiBaseEntity implements ShinigamiDBHelper {
	/**
	 * @return
	 * 
	 */
	public static <T> T getInstance(DBObject strValue, Class<T> typeObject) {
		return MAPPER.convertValue(strValue, typeObject);
	}

	@JsonIgnore
	public String getDBObject() throws JsonProcessingException {
		return MAPPER.writeValueAsString(this);
	}
}
