public class Bank {
    public String bankName;
    private MyLinkedList usersList;//store users
    public int idCounter = 0; //self-increment
    public AvailableIdList availableIdList;

    public MyLinkedList getUsersList() {
        return usersList;
    }

    public Bank(String bankName) {
        this.bankName = bankName;
        usersList = new MyLinkedList();
        availableIdList = new AvailableIdList();
    }
    // unique ID that is either 1 more than the last unique ID or equal to the first free-up unique ID
    public int getNewId() {
        if(availableIdList.isEmpty()) {
            return idCounter++;
        }
        return availableIdList.removeHead();
    }
    //Task-2: Write a method/function addUser(user) that adds a new user.
    public void addNewUser(String name, String address, String ssn, double balance) {
        int newId = getNewId();
        addNewUserWithId(newId, name, address, ssn, balance);
    }

    public void addNewUserWithId(int id, String name, String address, String ssn, double balance) {
        User newUser = new User(id, name, address, ssn, balance);
        usersList.addNode(newUser);
        //System.out.println("User added: " + newUser);
    }
    //Task-3: Write a method/function deleteUser(ID) that deletes an existing user. Free up the unique ID while deleting the user
    public void deleteUser(int userId) {
        if(userId < 0 || userId > idCounter) {
            System.out.println("Invalid user Id");
            return;
        }
        User deleteUser = usersList.get(userId);
        if(usersList.deleteNode(userId)) {
            availableIdList.addId(userId); //add id into availableIdList
            //System.out.println("User " + userId + " deleted");
            System.out.println(deleteUser + " deleted");
        } else {
            System.out.println("User " + userId + " is not found");
        }

    }
    //Task-4: Write a method/function payUserToUser(payer ID, payee ID, amount) that lets the user with ID1 pay the user with ID3 by amount.
    //chatgpt
    public void payUserToUser(int payerId, int payeeId, double amount) {
        User payer = usersList.get(payerId);
        User payee = usersList.get(payeeId);
        if(payer != null && payee != null && payer.getBalance() >= amount) {
            payer.setBalance(payer.getBalance() - amount);
            payee.setBalance(payee.getBalance() + amount);
            System.out.println("Transfer successful: " + amount + " from " + payerId + " to " + payeeId);
        } else {
            System.out.println("Transfer failed: Insufficient funds or user not fund");
        }
    }
    // Task-5: returns the median of all the account IDs
    public float getMedianId() {
        float res;
        int listSize = usersList.getSize();
        if(listSize == 0) {
            System.out.println("The list is empty!");
            return -1;
        }
        int idMid = listSize / 2;
        if(listSize % 2 == 0) {
            float id1 = (float) usersList.get(idMid).getId();
            float id2 = (float) usersList.get(idMid - 1).getId();
            res = (id1 + id2) / 2;
            //wrong: store the result from int to float type
            //res = (usersList.get(idMid).getId() + usersList.get(idMid + 1).getId()) / 2;
        } else {
            res = usersList.get(idMid).getId();
        }
        return res;
    }
    // Task-6: merges two accounts into one.
    public void mergeAccount(int id1, int id2) {
        User user1 = usersList.get(id1);
        User user2 = usersList.get(id2);
        if(user1.equals(user2)) {
            double total = user1.getBalance() + user2.getBalance();
            if(id1 < id2) {
                user1.setBalance(total);
                deleteUser(id2);
            } else {
                user2.setBalance(total);
                deleteUser(id1);
            }
            System.out.println("Account " + id1 + " and " + id2 + " merged into " + id1 + ". The balance is " + total);
            return;
        }
        System.out.println("Cannot merge accounts: Invalid details or mismatch.");
    }
    //Task-7: Merge the two linked lists into one
    public void bankMerge(Bank other) {
        ListNode cur = other.usersList.getHead();
        while(cur != null) {
            int id = cur.getUser().getId();
            User user = usersList.get(id);//check whether the id exist in the orange bank

            if(user == null) { //if it is not exist, addNewUserWithId()
                addNewUserWithId(cur.getUser().getId(), cur.getUser().getName(), cur.getUser().getAddress(),
                        cur.getUser().getSocialSecurityNum(), cur.getUser().getBalance());
            } else { //need to get the new id
                addNewUser(cur.getUser().getName(), cur.getUser().getAddress(),
                        cur.getUser().getSocialSecurityNum(), cur.getUser().getBalance());
            }
            cur = cur.getNext();
        }
    }
    public void printBank() {
        ListNode cur = usersList.getHead();
        while(cur != null) {
            System.out.println(cur.getUser());
            cur = cur.getNext();
        }
    }
}
