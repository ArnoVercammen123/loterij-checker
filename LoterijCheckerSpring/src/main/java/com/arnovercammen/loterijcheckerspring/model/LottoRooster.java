package com.arnovercammen.loterijcheckerspring.model;

import java.util.ArrayList;

public class LottoRooster {

    private Integer id;

    private ArrayList<Integer> numbers;

    private double winnings;
    public LottoRooster(ArrayList<Integer> numbers){
        this.numbers = numbers;

    }


    public LottoRooster(Integer id, ArrayList<Integer> numbers){
        this.id = id;
        this.numbers = numbers;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }
}
