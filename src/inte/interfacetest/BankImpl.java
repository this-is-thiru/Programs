package inte.interfacetest;

public class BankImpl implements Bank{

    @Override
    public void doSomeThing()  {
        System.out.println("BankImpl");
    }

    public static void main(String[] args) throws Exception {
        Bank bank = new BankImpl();
        bank.doSomeThing();
    }
}
