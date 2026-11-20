public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo() { return saldo; }
    public void setor(int jumlah) {
        if (jumlah > 0) saldo += jumlah;
    }


    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) return false;
        saldo -= jumlah;
        return true;
    }

    public abstract int biayaAdminBulanan();
    public abstract String keterangan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    protected static String formatRupiah(int angka) {
        String s = String.format("%,d", Math.abs(angka)).replace(',', '.');
        return "Rp" + (angka < 0 ? "-" : "") + s;
    }
}