public class BankTest {
    public static void main(String[] args) {
        Bank orangeBank = new Bank("Bank of Orange");

        orangeBank.addNewUser("Alice", "123 Main St", "111-11-1111", 1000);
        orangeBank.addNewUser("Bob", "456 Oak St", "222-22-2222", 500);
        orangeBank.addNewUser("Charlie", "789 Pine St", "333-33-3333", 1500);
        orangeBank.addNewUser("Nancy", "1223 Del mar Ave", "123-34-6221", 5000);
        orangeBank.addNewUser("Ketty", "855 Moon Ave", "333-34-6777", 3500);
        orangeBank.addNewUser("Garvin", "999 Star St", "999-66-9999", 2000);

        int size = orangeBank.getUsersList().getSize();
        System.out.println(size + " clients are in " + orangeBank.bankName);
        // Task 3: Delete a user
        //orangeBank.deleteUser(0);

        // Task 4: Transfer money
        orangeBank.payUserToUser(3, 1, 300);
        orangeBank.payUserToUser(2, 1, 300);
        // Task 5: Get median ID
        System.out.println("Median ID: " + orangeBank.getMedianId());
        // Task 6: Merge accounts
        orangeBank.addNewUser("Alice", "123 Main St", "111-11-1111", 1000);
        orangeBank.mergeAccount(0, 6);
        orangeBank.mergeAccount(0, 4);
        // Task 7: Merge two banks
        Bank labank = new Bank("Bank of LA");
        labank.addNewUser("Jane", "222 Main st", "222-33-4444", 1200);
        labank.addNewUser("Mike", "333 Vally blvd", "333-33-4444", 2200);
        labank.addNewUser("Tony", "222 3th st", "666-33-4444", 3200);
        orangeBank.bankMerge(labank);
        orangeBank.printBank();
    }
}
