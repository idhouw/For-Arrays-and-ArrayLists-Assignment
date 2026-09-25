import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Pendaftaran Nasabah ---");
        System.out.print("Masukkan Nama Depan: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Masukkan Nama Belakang: ");
        String lastName = scanner.nextLine();
        
        Customer customer = new Customer(firstName, lastName);

        System.out.println("\n--- Pembuatan Rekening ---");
        System.out.print("Masukkan Saldo Awal: ");
        double initBalance = scanner.nextDouble();
        
        Account account = new Account(initBalance);

        customer.setAccount(account);

        System.out.println("\n--- Ringkasan Akun ---");
        System.out.println("Nama Nasabah: " + customer.getFirstName() + " " + customer.getLastName());

        System.out.println("Jumlah Rekening: " + customer.getNumOfAccounts()); 
        
        Account activeAccount = customer.getAccount(0); 
        System.out.println("Saldo Saat Ini: " + activeAccount.getBalance());

        System.out.println("\n--- Transaksi Deposit ---");
        System.out.print("Masukkan jumlah uang yang ingin disetor: ");
        double depositAmt = scanner.nextDouble();
        
        if (activeAccount.deposit(depositAmt)) {
            System.out.println("Deposit Berhasil!");
        } else {
            System.out.println("Deposit Gagal! Masukkan nominal lebih dari 0.");
        }
        System.out.println("Saldo Anda sekarang: " + activeAccount.getBalance());

        System.out.println("\n--- Transaksi Penarikan ---");
        System.out.print("Masukkan jumlah uang yang ingin ditarik: ");
        double withdrawAmt = scanner.nextDouble();
        
        if (activeAccount.withdraw(withdrawAmt)) {
            System.out.println("Penarikan Berhasil!");
        } else {
            System.out.println("Penarikan Gagal! Saldo tidak mencukupi atau nominal salah.");
        }
        System.out.println("Saldo Anda sekarang: " + activeAccount.getBalance());

        scanner.close();
    }
}