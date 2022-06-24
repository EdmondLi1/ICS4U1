import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;

public class List {
    private Node head;

    class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        /* **** Lesson 6.3 RECURSIVE **** */

        // helper method
        void printListRecursive() {
            System.out.println(data);
            if (next != null) {
                next.printListRecursive();
            }
        }

        // helper method
        public void insertRecursive(int item) {
            // if end of list or is smaller
            if (next == null || item < next.data) {
                next = new Node(item, next);
            }
            else {
                next.insertRecursive(item);
            }
        }

        public void deleteLastRecursive() {
            if (next.next == null) {
                next = null;
            }
            else {
                next.deleteLastRecursive();
            }
        }

        // ???
        public Node copy() {
            if (next != null) {
                next.next = next.copy();
            }
            return next;
        }
    }

    /* **** Lesson 6.1 **** */

    public void addAtFront(int item) {
        head = new Node(item, head);
    }

    // 1. was done on .txt file

    public void printList() {
        // 2. Rewrite the method printList so that if the list is empty,
        // it prints a message instead of nothing.
        if (head == null) {
            System.out.println("This list is empty!");
        }
        else {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.println(temp.data);
            }
        }
    }

    public void deleteAllNodes() {
        head = null;
    }

    /* **** Lesson 6.1 QUESTIONS **** */

    // 3. Write an instance method sum for the List class that returns the sum of
    // the values in the data fields of its implicit List object.
    public int sum() {
        int sum = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            sum += temp.data;
        }
        return sum;
    }

    // 4. Write an instance method deleteFirst for the List class that deletes the first node
    // of the linked list. If the list is empty, the method should print a warning message.
    public void deleteFirst() {
        if (head == null) {
            System.out.println("This list is already empty!");
        }
        else {
            head = head.next;
        }
    }

    // 5. Write an instance method deleteLast for the List class that deletes the last node of the linked list.
    // If the list is empty, the method should print a warning message.
    public void deleteLast() {
        Node currNode = head;

        if (currNode == null) {
            System.out.println("This list is already empty!");
        }
        else if (currNode.next == null) {
            head = null;
        }
        else {
            // 2nd last node lol
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            currNode.next = null;
        }
    }

    // 6. Write an override for the toString method for the List class. The method should return a string that contains
    // all the data fields of the list, separated by //. For example, if the list contained
    // the integers 3, 5, and 8 in its data fields, the method should return "3//5//8".
    @Override
    public String toString() {
        String result = "";
        Node temp = head;

        if (temp != null) {
            while (temp != null) {
                if (temp.next != null) {
                    result += temp.data + "//";
                    temp = temp.next;
                }
                else {
                    break;
                }
            }
            result += temp.data;
        }
        return result;
    }

    // 7. Write an instance method addAtRear for the List class. The method should have a single int parameter called item.
    // The method should first locate the last node in the list and then create and attach a new node, containing the value of item, at that end of the list. In writing your method, be sure that it works correctly for an empty list.
    public void addAtRear(int item) {
        // put into while loop
        Node newNode = new Node(item, null);
        if (head == null) {
            head = newNode;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }


    /* **** Lesson 6.2 **** */

    // LIST MUST BE SORTED (DATA IN ASCENDING ORDER)
    public void insert(int item) {
        Node currNode = head;
        Node prevNode = null;
        boolean located = false;

        // location algorithm
        while(!located && currNode != null) {
            // while not found and not at last node
            if (item < currNode.data) {
                located = true;
            }
            else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        // Make new node which links TO CURRENT NODE
        Node newNode = new Node(item, currNode);

        // IF SMALLEST OR only ONE NODE, put at front
        if (currNode == head) {
            head = newNode;
        }
        else {
            // change that PREV NODE Links to NEW NODE
            prevNode.next = newNode;
        }
    }

    public void delete(int item) {
        Node currNode = head;
        Node prevNode = null;
        boolean found = false;

        // location algorithm
        while(!found && currNode != null) {
            if (currNode.data == item) {
                found = true;
            }
            else {
                // window shuffle the nodes (pointers)
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        // if i found the node
        if (found) {
            // IF HEAD/ONE ITEM, go to NEXT ONE
            if (currNode == head) {
                head = head.next;
            }
            else {
                // prev nodes SKIPS THE CURRENT NODE
                prevNode = currNode.next;
            }
        }
    }

    /* **** Lesson 6.2 QUESTIONS **** */

    // 1. was done on .txt file

    // 2.  public boolean contains(int item)
    //The method should return true if and only if its implicit List object contains item.
    public boolean contains(int item) {
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data == item) {
                return true;
            }
        }
        return false;
    }

    // 3. yes its possible, but since we need to find the middle node of a linked list; its
    // a little cumbersome.

    // 4. Write an instance method deleteAll for the List class. The method should have one int parameter, item.
    // It should delete all nodes in the list that contain item in their data field.
    public void deleteAll(int item) {
        // find a more efficient way to do this (dont call delete and search)
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data == item) {
                delete(item);
            }
        }

        if (head == null) {
            System.out.println("Cannot delete from empty list");
        }
        else {
            // dup node or no? need to fix
            Node currNode = head, prevNode = null, dupNode = null;
            while (currNode != null) {
                if (currNode.data == item) {
                    // delete the node
                    // use dup here or soemthing ?
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        //NEED TO FINISH THIS TONIGHT!
//        Node currNode = head;
//        Node prevNode = null;
//
    }

    // 5. public boolean isOrderedIncreasing()
    // The method should return true if and only if the data fields of the
    // implicit List object are in strictly increasing order.
    public boolean isOrderedIncreasing() {
        Node currNode = head;
        Node prevNode = null;
        if (currNode == null) {
            return false;
        }
        else if (currNode.next == null) {
            return true;
        }
        while (currNode.next.next != null) {
            prevNode = currNode;
            currNode = currNode.next;

            if (currNode.data < prevNode.data) {
                return false;
            }
        }
        return true;
    }

    // 6. The technique shown in Question 1 can be used to insert a value into an
    // ordered list without using two auxiliary references. Write an instance method
    // that uses this technique to achieve the same effect as the method shown in Example 1, Lesson 6.2.
    // Call the method insert2, and be sure that it works at both ends of the list.
    public void insert2(int item) {
        Node currNode = head;
        Node prevNode = null;
        boolean done = false;

        // if empty
        if (currNode == null) {
            head = new Node(item,null);
        }
        // with an item
        else {
            // location algorithm
            while(!done && currNode != null) {
                if (item < currNode.data) {
                    Node temp = new Node(currNode.data, currNode.next);
                    currNode.data = item;
                    currNode.next = temp;
                    done = true;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            // if at the last one
            if (prevNode.data < item) {
                prevNode.next = new Node(item, null);
            }
        }
    }

    // 7.    public boolean isIdentical(List other)
    // The method should return true if and only if its implicit List object is identical to other.
    // That is, each list contains the same data in the same order.
    public boolean isIdentical(List other) {
        Node nodeOne = head, nodeTwo = other.head;
        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.data != nodeTwo.data) {
                return false;
            }
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }
        // return true;  not always true
        return (nodeOne == null && nodeTwo == null);
    }


    /* **** Lesson 6.3 ReCURSIVE METHODS **** */

    // recursive method used to print list
    public void printListRecursive() {
        if (head != null) {
            head.printListRecursive();
        }
    }

    // recursive method used to insert item into list
    public void insertRecursive(int item) {
        // if the start is null OR if smallest
        if (head == null || item < head.data) {
            head = new Node(item, head);
        }
        else {
            head.insertRecursive(item);
        }
    }

    /* **** Lesson 6.3 QUESTIONS **** */

    public void deleteLastRecursive() {
        if (head != null) {
            head.deleteLastRecursive();
        }
    }

    public List copy() {
        List other = new List();
        if (head != null) {
            other.head = head.copy();
        }
        return other;
    }
}
