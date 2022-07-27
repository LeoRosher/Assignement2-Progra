public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas(7,7);
        canvas.draw(1, 1, 5, 4).fill(3, 3, 'o');
        System.out.println(canvas.drawCanvas());
    }
}
