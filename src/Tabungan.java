public class Tabungan extends Rekening implements BerBunga {
    private double sukuBunga;

    public Tabungan(String nomor, String pemilik, int saldo, double sukuBunga) {
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
    public int biayaAdminBulanan() {
        return saldo < 500_000 ? 5_000 : 0;
    }

    @Override
    public String keterangan() {
        return String.format("Tabungan, bunga %.1f%% per bulan", sukuBunga);
    }
}