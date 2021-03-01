import com.anup.dynamodb.model.Customer;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

public class Application {

    private static DynamoDbEnhancedClient enhancedClient;
    private static DynamoDbTable<Customer> customerTable;

    public static void main(String[] args) {
        System.out.println("**** Dynamo DB Crud operations");
    }

}
