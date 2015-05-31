package org.shinigami.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

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
@JsonInclude(Include.NON_NULL)
public class ShinigamiBaseEntity implements ShinigamiDBHelper {
	/**
	 * @return
	 * 
	 */
	public static <T> T getInstance(DBObject strValue, Class<T> typeObject) {
		return MAPPER.convertValue(strValue, typeObject);
	}

	@JsonIgnore
	public String getJsonString() throws JsonProcessingException {
		return MAPPER.writeValueAsString(this);
	}

	@JsonIgnore
	public DBObject getDBObject() throws JsonProcessingException {
		return (DBObject) JSON.parse(getJsonString());
	}
}
