package resources;

import com.mongodb.client.*;

public class MongoDb {

    private static  MongoClient mongoClient;

    /*CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));*/

    public static boolean loadDb(){
        try{
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static void closeConnection(){
        mongoClient.close();
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    /*try{
            mongoClient = MongoClients.create();
            MongoDatabase database = mongoClient.getDatabase("booking");//.withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Document> collection = database.getCollection("books");

            List<Book> books = new ArrayList<>();
            Gson gson = new Gson();
            collection.find().forEach(b -> books.add(gson.fromJson(b.toJson(), Book.class)));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/

}
