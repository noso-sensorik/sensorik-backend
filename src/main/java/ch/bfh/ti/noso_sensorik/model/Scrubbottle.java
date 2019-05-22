package ch.bfh.ti.noso_sensorik.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Scrubbottle {
	private @Id @GeneratedValue Long id;
	private LocalDate date;
    private LocalTime time;
//    @OneToOne(cascade = {CascadeType.ALL})
//    private Acceleration acceleration;
    private int x, y, z;
    private int rssi;
    private String label;
    private String station;
    private String job;

    @ManyToOne(cascade = {CascadeType.ALL})
	private DataCollectionNode collectedFrom;
    
    public Scrubbottle(LocalDate date, LocalTime localTime, int x, int y, int z, int rssi, String label, String station, String job, DataCollectionNode collectedFrom) {
        this.date = date;
        this.time = localTime;
        this.x = x;
        this.y = y;
        this.z = z;
        this.rssi = rssi;
        this.label = label;
        this.station = station;
        this.job = job;
        this.collectedFrom = collectedFrom;
    }

}
