import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Linea de conexión*/
        /*try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")){
            MongoDatabase db = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = db.getCollection("mycollection");
            Document document = new Document("nombre", "Mireya").append("apellido", "Garcia").append("edad", 19);
            collection.insertOne(document);
            System.out.println("Docuemnto insertado correctamente");

        }*/
        /*Leer*/
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> collection = database.getCollection("mycollection");

            FindIterable<Document> documentos = collection.find();

            for (Document documento : documentos) {
                //System.out.println(documento.toJson());
                String nombre = documento.getString("nombre");
                String apellido = documento.getString("apellido");
                int edad = documento.getInteger("edad");

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
            }
        }
    }
}