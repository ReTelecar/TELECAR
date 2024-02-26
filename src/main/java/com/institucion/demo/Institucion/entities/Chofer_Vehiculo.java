package com.institucion.demo.Institucion.entities;

import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;

@Entity
public class Chofer_Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Chofer chofer;

    @ManyToOne
    private Vehiculo vehiculo;

    public Chofer_Vehiculo() {
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
