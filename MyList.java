public class MyList {
    private String[] elementData;
    private int size = 0;

    public MyList() {
        this.elementData = new String[10];
    }

    public void add(String element) {//додавання в кінець
        if (size == elementData.length) {
            grow();//якщо розмір більший за РОЗМІР то викликається збільшення масиву
        }
        elementData[size] = element;
        size++;//запис елементу
    }

    public void add(int index, String element) {//додавання за індексом
        if (index < 0 || index > size)
            return;//умова при якій індекс не може бути меньшим за нуль або більшим за розмір
        if (size == elementData.length) {
            grow();//якщо місця немає - розширення масиву
        }

        System.arraycopy(elementData, index, elementData, index + 1, size - index);//запис елемента вправо
        elementData[index] = element;//вставлення нового елементу
        size++;
    }

    public void remove(int index) {//видалення за індексом
        if (index < 0 || index >= size)
            return;

        int numMoved = size - index - 1;//зсунення елементів вліво
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);//запис нового елементу у вільне місце
        }
        elementData[size] = null;
        size--;
       //зменьшення розміру
    }

    public void removeLast() {//виадлення останнього
        if (size > 0) {//якщо список не порожній
            size--;//зменьшення розміру і видаляємо останній елемент
            elementData[size] = null;
        }
    }

    public int getSize() {
        return size;//розмір списку
    }

    public int getCapacity() {
        return elementData.length;//розмір буферц
    }
    public String getElements() {//поверення розміру масиву
        if (size == 0) return "()";//якщо пусто - повернення квадратних дужок
        String result = "(";//новий рядок
        for (int i = 0; i < size; i++) {
            result += elementData[i];//додавання елементу у рядок
            if (i != size - 1) result += ", ";//додавання коми
        }
        return result + ")";//закриття
    }

    private void grow() {//збільшення масиву
        String[] newArray = new String[elementData.length * 2];//створення в 2 рази більшого
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = newArray;//копіювання і перенос старих даних у новий
    }
}