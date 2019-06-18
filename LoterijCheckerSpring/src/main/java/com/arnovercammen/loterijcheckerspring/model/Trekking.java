package com.arnovercammen.loterijcheckerspring.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Trekking {

    private ArrayList<Integer> numbers;
    private int extraNumber;
    private HashMap<String,Double> winstVerdeling;

    public Trekking(){
        this.initializeMap();
    }
    public Trekking(ArrayList<Integer> numbers, int extraNumber){
        this.numbers = numbers;
        this.extraNumber = extraNumber;
        this.initializeMap();
    }

    private void initializeMap(){
        HashMap<String,Double> map = new HashMap<>();
        map.put("1+1", 0.0);
        map.put("2+", 0.0);
        map.put("3", 0.0);
        map.put("3+", 0.0);
        map.put("4", 0.0);
        map.put("4+", 0.0);
        map.put("5", 0.0);
        map.put("5+", 0.0);
        map.put("6", 0.0);
        this.winstVerdeling = map;
    }

    public Trekking(ArrayList<Integer> numbers, int extraNumber, HashMap<String,Double> verd){
        this.numbers = numbers;
        this.extraNumber = extraNumber;
        this.winstVerdeling = verd;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getExtraNumber() {
        return extraNumber;
    }

    public void setExtraNumber(int extraNumber) {
        this.extraNumber = extraNumber;
    }

    public HashMap<String, Double> getWinstVerdeling() {
        return winstVerdeling;
    }

    public void setWinstVerdeling(HashMap<String, Double> winstVerdeling) {
        this.winstVerdeling = winstVerdeling;
    }
}
