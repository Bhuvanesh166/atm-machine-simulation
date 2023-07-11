import java.util.Scanner;

class Atm{
    private int balance=1000;
    public void withdraw(int amount) throws InsufficientFundsException,InvalidAmountException{
        if(amount>balance){
            throw new InsufficientFundsException("Amount Greater Then Balance");
        } else if (amount<=0) {
            throw new InvalidAmountException("Invalid Amount");
            
        }
        else {
            balance-=amount;

        }
    }
    public void deposit(int amount){
        balance+=amount;
    }

    public int getBalance() {
        return balance;
    }

}
class  InsufficientFundsException extends Exception{
    InsufficientFundsException(String msg){
        super(msg);
    }

}
class  InvalidAmountException extends Exception{
    InvalidAmountException(String msg){
        super(msg);
    }

}

class Main {
    public static void main(String[] args) {

        Atm atm = new Atm();
        int v=5;
        do {
        System.out.println("enter 1 for deposit");
        System.out.println("enter 2 for withdraw");
        System.out.println("enter 0 for exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        v=choice;
                if(choice==1) {
                    System.out.println("enter deposit amount");
                    int dep=scanner.nextInt();
                    atm.deposit(dep);
                    System.out.println("Balance: " + atm.getBalance());
                }
                if(choice==2) {
                    try {
                        System.out.println("enter withdraw  amount");
                        int with=scanner.nextInt();
                        atm.withdraw(with);
                        System.out.println("Balance: " + atm.getBalance());

                    } catch (InsufficientFundsException e) {
                        System.out.println(e);

                    } catch (InvalidAmountException e) {
                        System.out.println(e);
                    }
                }

        }while (v!=0);


    }
}





