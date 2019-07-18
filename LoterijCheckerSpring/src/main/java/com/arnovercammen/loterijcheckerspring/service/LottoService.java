package com.arnovercammen.loterijcheckerspring.service;

import com.arnovercammen.loterijcheckerspring.model.LottoRooster;
import com.arnovercammen.loterijcheckerspring.model.LottoRoosterDb;
import com.arnovercammen.loterijcheckerspring.model.Trekking;
import com.arnovercammen.loterijcheckerspring.repositories.LottoRoosterRepository;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class LottoService {


    private LottoRoosterRepository lottoRoosterRepository;

    private HashMap<Integer,String> intToString;
    /*
    public LottoService(){
        intToString = new HashMap<>();
        intToString.put(11, "1+1");
        intToString.put(12, "2+");
        intToString.put(3, "3");
        intToString.put(13, "3+");
        intToString.put(4, "4");
        intToString.put(14, "4+");
        intToString.put(5, "5");
        intToString.put(15, "5+");
        intToString.put(6, "6");
    }

     */

    public LottoService(LottoRoosterRepository lottoRoosterRepository1){
        lottoRoosterRepository = lottoRoosterRepository1;
        intToString = new HashMap<>();
        intToString.put(11, "1+1");
        intToString.put(12, "2+");
        intToString.put(3, "3");
        intToString.put(13, "3+");
        intToString.put(4, "4");
        intToString.put(14, "4+");
        intToString.put(5, "5");
        intToString.put(15, "5+");
        intToString.put(6, "6");
    }

    public void addRooster(LottoRooster lottoRooster){
        if(lottoRooster.getNumbers().size()>= 6){
            JSONArray jsonArray = new JSONArray(lottoRooster.getNumbers());
            lottoRoosterRepository.save(new LottoRoosterDb(lottoRooster.getId(),jsonArray.toString()));
        }else{
            System.out.println("ALERT!: tried to add rooster with less then 6 numbers.");
        }
    }

    public ArrayList<LottoRooster> getRoosters(){
        ArrayList<LottoRooster> lottoRoosters = new ArrayList<LottoRooster>();
        lottoRoosterRepository.findAll().forEach(r -> lottoRoosters.add(dbToListConverter(r)));
        return lottoRoosters;
    }

    public ArrayList<LottoRooster> checkProfits(Trekking trekking){
        trekking.getWinstVerdeling().put("1+1", 1.25);
        trekking.getWinstVerdeling().put("2+", 3.75);
        trekking.getWinstVerdeling().put("3", 6.25);

        ArrayList<LottoRooster> result = new ArrayList<LottoRooster>();
        for(LottoRooster lottoRooster : getRoosters()){
            result.add(this.checkRooster(trekking,lottoRooster));
        }
        return result;
    }

    private LottoRooster checkRooster(Trekking trekking, LottoRooster lottoRooster){
        int numbersCorrect = 0;
        for(int trekkingNumber : trekking.getNumbers()){
            for(int roosterNumber : lottoRooster.getNumbers()){
                if(trekkingNumber == roosterNumber){
                    numbersCorrect++;
                }
            }
        }
        if(numbersCorrect > 0){
            for(int number : lottoRooster.getNumbers()){
                if(number == trekking.getExtraNumber()){
                    numbersCorrect = numbersCorrect + 10;
                }
            }
            if(numbersCorrect > 2) {
                lottoRooster.setWinnings(trekking.getWinstVerdeling().get(intToString.get(numbersCorrect)));
                lottoRooster.setRang(intToString.get(numbersCorrect));
            }
        }

        return lottoRooster;
    }

    private LottoRooster dbToListConverter(LottoRoosterDb lottoRoosterDb){
        JSONArray jsonArray = new JSONArray(lottoRoosterDb.getNumbers());
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0 ; i < jsonArray.length(); i++){
            numbers.add(jsonArray.getInt(i));
        }
        return new LottoRooster(lottoRoosterDb.getId(), numbers);
    }


    public void deleteRooster(String id) {
        lottoRoosterRepository.delete(new LottoRoosterDb(Integer.valueOf(id)));
    }
}
