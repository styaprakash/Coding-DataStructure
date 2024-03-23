class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        // Move fast pointer to the nth node from the beginning
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the head of the modified list
        return start.next;


    }

    static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Remove the 2nd node from the end
        int n = 2;
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode modifiedHead = solution.removeNthFromEnd(head, n);

        // Print the modified linked list
        System.out.println("\nLinked List after removing the " + n + "nd node from the end:");
        printLinkedList(modifiedHead);

        //Reversing the linkedlist
        System.out.println("\n The LinkedList reversal is: ");
        ListNode reversedHead=reverse(modifiedHead);
        printLinkedList(reversedHead);
    }

    // Utility method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}





