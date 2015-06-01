package org.shinigami.json.db;

import org.shinigami.json.dto.ShinigamiBaseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
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

public class ShinigamiJsonDBInstance implements ShinigamiJsonDBInterface {
	private static ShinigamiJsonDBInstance shinigamiDBInstance;

	private MongoClient mongoClient;
	private DB shinigami;

	private ShinigamiJsonDBInstance(String mongoDBUri, String dbName) {
		setMongoClient(new MongoClient(new MongoClientURI(mongoDBUri)));
		setShinigami(dbName);
	}

	public static ShinigamiJsonDBInstance getInstance(String mongoDBUri, String dbName) {
		if (shinigamiDBInstance == null) {
			shinigamiDBInstance = new ShinigamiJsonDBInstance(mongoDBUri, dbName);
		}

		return shinigamiDBInstance;
	}

	/**
	 * @return the mongoClient
	 */
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	/**
	 * @param mongoClient
	 *            the mongoClient to set
	 */
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	/**
	 * @return the shinigami
	 */
	public DB getShinigami() {
		return shinigami;
	}

	/**
	 * @param shinigami
	 *            the shinigami to set
	 */
	public void setShinigami(String dbName) {
		this.shinigami = mongoClient.getDB(dbName);
	}

	public DBCollection getDbCollection(String dbName, String dbCollection) {
		if (shinigami == null) {
			setShinigami(dbName);
		}
		return getShinigami().getCollection(dbCollection);
	}

	public class QueryUpdate {
		private String dbCollection;

		private DBObject query;
		private DBObject updateMe;

		/**
		 * @return the query
		 */
		public DBObject getQuery() {
			return query;
		}

		/**
		 * @param query
		 *            the query to set
		 */
		public void setQuery(DBObject query) {
			this.query = query;
		}

		/**
		 * @return the updateMe
		 */
		public DBObject getUpdateMe() {
			return updateMe;
		}

		/**
		 * @param updateMe
		 *            the updateMe to set
		 */
		public void setUpdateMe(DBObject updateMe) {
			this.updateMe = updateMe;
		}

		/**
		 * @param updateMe
		 *            the updateMe to set
		 * @throws JsonProcessingException
		 */
		public void setUpdateMe(ShinigamiBaseEntity updateMe) throws JsonProcessingException {
			this.updateMe = updateMe.getDBObject();
		}

		public DBObject getRecordForUpdate(String dbCollection, DBObject query) {
			this.dbCollection = dbCollection;
			setQuery(query);
			DBCursor cursor = getDbCollection(null, this.dbCollection).find(query);
			while (cursor.hasNext()) {
				updateMe = cursor.next();
				break;
			}
			return updateMe;
		}

		public DBObject getRecordForUpdate(String dbCollection, ShinigamiBaseEntity query)
				throws JsonProcessingException {
			this.dbCollection = dbCollection;
			setQuery(query.getDBObject());
			DBCursor cursor = getDbCollection(null, this.dbCollection).find(getQuery());
			while (cursor.hasNext()) {
				updateMe = cursor.next();
				break;
			}
			return updateMe;
		}

		public WriteResult insertRecord(String dbCollection, DBObject saveMe) {
			return getDbCollection(null, this.dbCollection).insert(saveMe);
		}

		public WriteResult insertRecord(String dbCollection, ShinigamiBaseEntity saveMe) throws JsonProcessingException {
			return getDbCollection(null, this.dbCollection).insert(saveMe.getDBObject());
		}

		public WriteResult saveRecord() {
			return getDbCollection(null, this.dbCollection).update(query, updateMe, true, true);
		}
	}
}
