package test;

class Node {
    public int data;
    public Node next;

    public Node() {}

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("%d", data);
    }

}

class LinkedList {
    private Node header;
    private int size;

    public LinkedList() {
        this.header = new Node(9999);

    }

    public void add(int index, int data) {
        Node newNode = new Node(data);

        //index가 0일 때
        if(index == 0) {

            //index == 0이고 size == 0일 때
            if (size == 0) {
                //헤더 뒤에 node를 붙인다.
                header.next = newNode;
            } else {
                //index가 0이고 size가 0이 아니라면 새로운 노드에 헤더를 넣는다.
                newNode.next = header.next;
                header.next = newNode;
            }
        }
        else {
            //temp node 선언
            Node temp = header;

            //인덱스 체크
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException();
            }
            // 몇번째를 찾아가기 위한 for문
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            if(temp.next != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                temp.next = newNode;
            }
        }
        size++;
    }

    public String toString() {
        String s = "";
        Node tmp = header;
        boolean hasNext = true;
        while (hasNext) {
            s += tmp.toString() + "->";
            tmp = tmp.next;

            if (tmp == null) {
                hasNext = false;
            }
        }
        return s.substring(0, s.length()-2);
    }
}

public class testtest {

    public static void main(String[] args) {
        LinkedList sumin = new LinkedList();
        sumin.add(0, 1);
        sumin.add(1, 2);
        sumin.add(1, 3);

        System.out.println(sumin.toString());
    }
}