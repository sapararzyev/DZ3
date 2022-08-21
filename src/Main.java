public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);
        while (true){
            System.out.println("ваш баланс:" + bankAccount.getAmount());
            try {
                bankAccount.withDraw(6000);
            }catch (LimitException e){
                System.out.println(e.getMessage() + "была вызято" + e.getRemainingAmount());
                try {
                    bankAccount.withDraw((int) e.getRemainingAmount());
                    System.out.println("сталос" + bankAccount.getAmount());
                    break;
                }catch (LimitException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}