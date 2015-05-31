package org.shinigami.db.test;

import java.io.IOException;

import org.shinigami.db.ShinigamiDBInstance;
import org.shinigami.dto.AndroidApplicationMetadata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

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

public class AndroidDBConnectionTest {

	public static void main(String[] args) throws IOException {
		// MongoClient mongoClient = new MongoClient(new MongoClientURI(
		// "mongodb://androiduser:androiduser@ds043082.mongolab.com:43082/shinigami"));
		// DB shinigami = mongoClient.getDB("shinigami");
		// DBCollection androidVersions =
		// shinigami.getCollection("androidVersions");

		ShinigamiDBInstance dbInstance = ShinigamiDBInstance.getInstance(
				"mongodb://androiduser:androiduser@ds043082.mongolab.com:43082/shinigami", "shinigami");

		ShinigamiDBInstance.QueryUpdate queryUpdate = dbInstance.new QueryUpdate();

		AndroidApplicationMetadata androidApplicationMetadata = new AndroidApplicationMetadata();
		androidApplicationMetadata.setApplicationName("ExchangeRate");
		System.out.println(androidApplicationMetadata.getDBObject());
		DBObject updateMe = queryUpdate.getRecordForUpdate("androidVersions", androidApplicationMetadata);

		System.out.println(updateMe);

		androidApplicationMetadata = AndroidApplicationMetadata.getInstance(updateMe, AndroidApplicationMetadata.class);

		androidApplicationMetadata.getMetadata().setBuildDate("05-31-2015");

		ObjectMapper mapper = new ObjectMapper();
		queryUpdate.setUpdateMe(androidApplicationMetadata);
		WriteResult writeResult = queryUpdate.saveRecord();
		System.out.println(writeResult.getN());
	}
}
