public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();

        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());

        arrayList.remove(1);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.size());

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.size());

        linkedList.remove(1);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.size());

        MyQueue queue = new MyQueue();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());

        MyStack stack = new MyStack();

        stack.push("first");
        stack.push("second");
        stack.push("third");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        MyHashMap hashMap = new MyHashMap();

        hashMap.put("name", "Kirill");
        hashMap.put("age", 25);
        hashMap.put("name", "Sergey");

        System.out.println(hashMap.get("name"));
        System.out.println(hashMap.get("age"));
        System.out.println(hashMap.size());

        hashMap.remove("age");

        System.out.println(hashMap.get("age"));
        System.out.println(hashMap.size());
    }
}
