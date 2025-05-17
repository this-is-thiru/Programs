package inte.interfacetest;

public class Bank1Impl implements Bank1{

    @Override
    public void doSomeThing() throws RuntimeException {
        System.out.println("Bank1Impl");
    }

    public static void main(String[] args) throws Exception {
        Bank1 bank = new Bank1Impl();
        bank.doSomeThing();
    }
}
