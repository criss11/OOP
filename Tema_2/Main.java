import utils.Context;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String input = "C:\\Users\\Cris\\Tema_2\\checker\\in\\test1.in";
        String output = "C:\\Users\\Cris\\Tema_2\\checker\\test1.out";
        Context context = Context.getInstance();

        context.init(input, output);
        context.run();
    }
}
