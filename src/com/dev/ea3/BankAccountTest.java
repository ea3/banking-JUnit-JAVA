package com.dev.ea3;


import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before any test classprivate. Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Emilio", "Araos", 10000.00, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @org.junit.jupiter.api.Test
   public  void deposit() {
        double balance = account.deposit(2000.00, true);
        assertEquals(12000.00,balance,0);
    }

    @org.junit.jupiter.api.Test
    public void withdraw_branch() {
        double balance = account.withdraw(6000.00,true);
        assertEquals(4000.00,balance,0);
    }

    @org.junit.jupiter.api.Test
    public void withdraw_atm()  {
        account.withdraw(6000.00,false);
//        assertEquals(4000.00,balance,0);
    }

    @org.junit.jupiter.api.Test
    public void getBalance_deposit() {
        account.deposit(2000.00, true);
        assertEquals(12000.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void getBalance_withdraw() {
        account.withdraw(2000.00, true);
        assertEquals(8000.00, account.getBalance(), 0);
    }


    @org.junit.jupiter.api.Test
    public void isChecking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.jupiter.api.AfterAll
    public static void afterClass(){
        System.out.println("This executes after any test class. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown(){
        System.out.println("Count = "+  count++);
    }


}
