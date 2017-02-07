package com.chakrar.cb.prodcat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.error.DocumentDoesNotExistException;

@Configuration
public class Injector implements CommandLineRunner {
	
	/** The Constant logger. */
	private static final Logger log = LoggerFactory.getLogger(Injector.class);
	
	static final String BUCKET_NAME = "prodcat";


	@Override
	public void run(String... arg0) throws Exception {
		log.info("...Inserting product data...");
		Cluster cluster = CouchbaseCluster.create("127.0.0.1");
		Bucket bucket = cluster.openBucket(BUCKET_NAME);
		
		
		String key = "idGeneratorForProducts";
        
		try {
            bucket.remove(key);
        } catch (DocumentDoesNotExistException e) {
        }

        try {
            bucket.counter(key, 0, 20);
        } catch (DocumentDoesNotExistException e) {
            log.info("The counter method failed because the counter doesn't exist yet and no initial value was provided");
        } 

        for (int i = 0; i < 3; i++) {
    		long nextIdNumber = bucket.counter(key, 1).content();
    		log.info("nextIdNumber = "+ nextIdNumber);
    		String id = "Prod::" + nextIdNumber; 
    		//you're now ready to save your document:
            Product product = ProductUtil.getProduct(nextIdNumber);
            JsonObject content = JsonObject.create()
                   .put("type", Product.TYPE)
                   .put("id", product.getId())
                   .put("description", product.getDescription())
                   .put("price", product.getPrice());
    	
    		bucket.insert(JsonDocument.create(id, content));
    		log.info("...Inserted product data..."+ i);
        }
        log.info("...Inserted ALL product data..."); 
	}
	

}
