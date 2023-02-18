package db.entitas;

import java.sql.Timestamp;
import java.util.Date;

@lombok.Data
public class Reservasi_Entitas {
    String id_reservasi;
    String id_penumpang ;
    String stasiun_berangkat;
    String stasiun_tujuan;
    Date tanggal_berangkat;
    String jam_berangkat;
    String jam_tiba;        
    Timestamp waktu_pemesanan;
    String kereta;
}
