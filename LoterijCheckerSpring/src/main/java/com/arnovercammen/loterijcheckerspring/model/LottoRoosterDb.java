package com.arnovercammen.loterijcheckerspring.model;

import javax.persistence.*;

@Entity
@Table(name = "lotto_roosters")
public class LottoRoosterDb {

    @Id
    @SequenceGenerator(name="lotto_roosters_id_seq",
            sequenceName="lotto_roosters_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="lotto_roosters_id_seq")
    private Integer id;

    @Column
    private String numbers;

    public LottoRoosterDb(){

    }
    public LottoRoosterDb(String numbers){
        this.numbers = numbers;
    }
    public LottoRoosterDb(Integer id, String numbers){
        this.id = id;
        this.numbers = numbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
