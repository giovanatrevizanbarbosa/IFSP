public class Main {
    public static void main(String[] args) {
        metodoA();
    }

    private static void metodoA() {
        try {
            metodoB();
        }catch (Exception e){
            System.out.println("metodoA.");
        }
    }

    private static void metodoB() throws Exception {
        try{
            metodoC();
        }catch (Exception e){

        }
    }

    private static void metodoC() throws Exception {
        metodoD();
    }

    private static void metodoD() throws Exception{
        throw new Exception("Exceção lançada no metodoD.");
    }
}