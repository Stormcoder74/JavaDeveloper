public class Main {
    private int counter = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.loop();
    }

    private void loop(){
        while(true){
            counter++;
            print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void print() {
        int c = counter * 3;
        System.out.println("counter = " + counter);
    }
}
