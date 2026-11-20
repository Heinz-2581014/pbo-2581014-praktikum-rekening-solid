public class Deposito extends Rekening implements BerBunga {
    private double sukuBunga;

    public Deposito(String nomor, String pemilik, int saldo, double sukuBunga) {
        super(nomor, pemilik, saldo);
        this.sukuBunga = sukuBunga;
    }

    @Override
    public double getSukuBunga() { return sukuBunga; }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * sukuBunga / 100.0);
        saldo += bunga;
        return bunga;
    }

    @Override
    public int biayaAdminBulanan() { return 0; }

    /*
     * Langkah 7 (LSP): versi awal melempar exception dan melanggar kontrak tarik:
     *
     *   Exception in thread "main" java.lang.UnsupportedOperationException: Deposito tidak bisa ditarik
     *       at Deposito.tarik(Deposito.java:..)
     *       at ProsesAkhirBulan.autodebet(ProsesAkhirBulan.java:..)
     *       at BankSolid.main(BankSolid.java:..)
     *
     * Perbaikan: kembalikan false (tidak pernah melempar exception).
     */


    @Override
    public boolean tarik(int jumlah) {
        return false;
    }

    @Override
    public String keterangan() {
        return String.format("Deposito, bunga %.1f%% per bulan", sukuBunga);
    }
}