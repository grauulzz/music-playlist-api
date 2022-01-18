//package com.amazon.ata.music.playlist.service.activity;
//
//import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
//import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
//import com.amazonaws.services.dynamodbv2.model.*;
//
//
//import java.util.HashMap;
//
///**
// * To run this Java V2 code example, ensure that you have setup your development environment, including your credentials.
// *
// * For information, see this documentation topic:
// *
// * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
// *
// * To update an Amazon DynamoDB table using the AWS SDK for Java V2, its better practice to use the
// * Enhanced Client, See the EnhancedModifyItem example.
// */
//public class UpdateItem {
//
//    public static void main(String[] args) {
//        final String USAGE = "\n" +
//                "Usage:\n" +
//                "    UpdateItem <tableName> <key> <keyVal> <name> <updateVal>\n\n" +
//                "Where:\n" +
//                "    tableName - the Amazon DynamoDB table (for example, Music3).\n" +
//                "    key - the name of the key in the table (for example, Artist).\n" +
//                "    keyVal - the value of the key (for example, Famous Band).\n" +
//                "    name - the name of the column where the value is updated (for example, Awards).\n" +
//                "    updateVal - the value used to update an item (for example, 14).\n" +
//                " Example:\n" +
//                "    UpdateItem Music3 Artist Famous Band Awards 14\n";
//
//        if (args.length != 5) {
//            System.out.println(USAGE);
//            System.exit(1);
//        }
//
//        String tableName = args[0];
//        String key = args[1];
//        String keyVal = args[2];
//        String name = args[3];
//        String updateVal = args[4];
//
//        Region region = Region.US_EAST_1;
//        DynamoDbClient ddb = DynamoDbClient.builder()
//                .region(region)
//                .build();
//
//        updateTableItem(ddb, tableName,key, keyVal, name, updateVal);
//        ddb.close();
//    }
//    // snippet-start:[dynamodb.java2.update_item.main]
//    public static void updateTableItem(DynamoDbClient ddb,
//                                       String tableName,
//                                       String key,
//                                       String keyVal,
//                                       String name,
//                                       String updateVal){
//
//        HashMap<String, AttributeValue> itemKey = new HashMap<String,AttributeValue>();
//
//        itemKey.put(key, AttributeValue.builder().s(keyVal).build());
//
//        HashMap<String, AttributeValueUpdate> updatedValues =
//                new HashMap<String,AttributeValueUpdate>();
//
//        // Update the column specified by name with updatedVal
//        updatedValues.put(name, AttributeValueUpdate.builder()
//                .value(AttributeValue.builder().s(updateVal).build())
//                .action(AttributeAction.PUT)
//                .build());
//
//        UpdateItemRequest request = UpdateItemRequest.builder()
//                .tableName(tableName)
//                .key(itemKey)
//                .attributeUpdates(updatedValues)
//                .build();
//
//        try {
//            ddb.updateItem(request);
//        } catch (ResourceNotFoundException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        } catch (DynamoDbException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
//
//        System.out.println("Done!");
//    }
//    // snippet-end:[dynamodb.java2.update_item.main]
//}
