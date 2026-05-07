public class Main {
    public static void main(String[] args) {

        MyList myVec = new MyList();

        myVec.add("коза");
        myVec.add("десоти");
        myVec.add(0, "папайя");

        System.out.println(myVec.getElements());
        System.out.println("Розмір: " + myVec.getSize());
        System.out.println("Вміст(Capacity):" + myVec.getCapacity());

        myVec.remove(1);

        System.out.println("Після: " + myVec.getElements());
    }
}