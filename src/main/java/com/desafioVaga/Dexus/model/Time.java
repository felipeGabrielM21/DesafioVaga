package com.desafioVaga.Dexus.model;


import com.desafioVaga.Dexus.dtos.TimeDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate data;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<ComposicaoTime> composicaoTime;

    public Time() {
    }

    public Time(TimeDto dados) {
        this.data = dados.data();
        this.composicaoTime = dados.composicaoTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ComposicaoTime> getComposicaoTime() {
        return composicaoTime;
    }

    public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
        this.composicaoTime = composicaoTime;
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return id == time.id && Objects.equals(data, time.data);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
