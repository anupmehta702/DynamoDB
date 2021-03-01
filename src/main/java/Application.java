import com.anup.dynamodb.model.Customer;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DeleteTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

public class Application {

    private static DynamoDbEnhancedClient enhancedClient;
    private static DynamoDbTable<Customer> customerTable;
    private static Customer record;

    public static void main(String[] args) {
        System.out.println("**** Dynamo DB Crud operations ****");
        Region region = Region.US_EAST_2;
        DynamoDbClient ddb = DynamoDbClient.builder()
               // .endpointOverride(URI.create("http://localhost:8000")) //uncomment this line if you wish to connect to local dynamoDB
                .region(region)
                .build();

        enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();

        customerTable = enhancedClient.table("customer", TableSchema.fromBean(Customer.class));

        //createTable();
        putRecord();
        getRecord();
        //deleteTable(ddb);
    }

    private static void getRecord() {
        try {
            Key key = Key.builder().partitionValue(record.getId()).sortValue(record.getName()).build();
            Customer result = customerTable.getItem(key);
            System.out.println("GET query result - " + result);
        }catch(DynamoDbException ex){
            System.out.println("GET error message - "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void putRecord() {
        try {
             record = new Customer("1", "Anup Mehta", "anupmehta702@gmail.com");
            customerTable.putItem(record);
            System.out.println("Record - " + record + " added successfully !");
        }catch(DynamoDbException ex){
        System.out.println("PUT error message - "+ex.getMessage());
        ex.printStackTrace();
    }
    }

    private static void createTable() {
        customerTable.createTable();
        System.out.println("Customer table created successfully !");
    }

    private static void deleteTable(DynamoDbClient ddb){
        ddb.deleteTable(DeleteTableRequest.builder().tableName("customer").build());
        System.out.println("Customer table deleted successfully !");
    }

}
