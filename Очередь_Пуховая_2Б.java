public class Primer {
public static void main(String[] args) {
    Queue myQueue = new Queue();
    myQueue.enQueue(3); //Создаем элементы и их параметры
    myQueue.enQueue(2);
    myQueue.enQueue(1);
    myQueue.display();
    myQueue.deQueue();
    myQueue.peak();
}
}
class Queue {
  int queueLength = 3; // максимальное количество элементов
  int items[] = new int[queueLength];
  int front = -1; // элемент за очередью спереди
  int back = -1; // элемент за очередью сзади


  boolean isFull(){
      if(back == queueLength - 1){    // max количество элементов = 3, но три элемента в массиве обозначаются не индексом 3, а 2, поскольку первый индекс равен 0. max длина -1 дает индекс 2, который является третьей ячейкой в ​​массиве. 
                                      // Когда все ячейки поставлены в очередь со значением до третьей ячейки, массив заполнен.
          return true;
      } else {
          return false;
      }
  }
  boolean isEmpty(){
      if(front == -1 && back == -1){
          return true;
      } else {
          return false;
      }
  }


   void enQueue(int itemValue) {
      if(isFull()){
          System.out.println("Queue zapolnen");   //если массив заполнен, получаем сообщение, что он заполнен. Если Front и Back = -1, 
                                                  //то элемент присваивается первой ячейке с индексом 0 — иначе значение вставляется, а задняя позиция увеличивается.
      } else if(front == -1 && back == -1){
          front = back = 0;
          items[back] = itemValue;
      } else{
          back++;
          items[back] = itemValue;
      }
  }


   void deQueue(){
      if(isEmpty()){
          System.out.println("Queue pustoi"); //если массив пуст, получаем соответствующее сообщение. Если Front встретилась с Back, мы сбрасываем их индекс обратно на -1. Если последние два условия неприменимы, то Front увеличивается.
      } else if (front == back){
          front = back = -1;
      } else {
          front++;
      }
  }



  void display(){
      int i;
      if(isEmpty()){
          System.out.println("Queue pustoi"); // если массив не пуст, мы перебираем и печатаем все элементы.
      } else {
          for(i = front; i <= back; i++){
              System.out.println(items[i]);
          }
      }
  }
  void peak(){
      System.out.println("Front value is: " + items[front]); //вывод значения переднего элемента
  }
}