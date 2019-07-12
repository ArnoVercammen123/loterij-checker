package com.arnovercammen.loterijcheckerspring.service;


import com.arnovercammen.loterijcheckerspring.model.LottoRoosterDb;
import com.arnovercammen.loterijcheckerspring.model.Trekking;
import com.arnovercammen.loterijcheckerspring.repositories.LottoRoosterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LottoServiceTest {




    @Mock
    private LottoRoosterRepository lottoRoosterRepository;

    private LottoService lottoService;

    @Test
    public void checkProfitsTest(){
        lottoService = new LottoService(lottoRoosterRepository);
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        HashMap<String,Double> winstVerdeling = new HashMap<>();
        winstVerdeling.put("1+1", 10.11);
        winstVerdeling.put("2+", 50.11);
        winstVerdeling.put("3", 1000.11);
        winstVerdeling.put("3+", 5000.55);
        winstVerdeling.put("4", 10000.21);
        winstVerdeling.put("4+", 100000.22);
        winstVerdeling.put("5", 200000.11);
        winstVerdeling.put("5+", 500000.51);
        winstVerdeling.put("6", 1000000.0);
        ArrayList<LottoRoosterDb> lottoRoosters = new ArrayList<>();

        // WINNING NUMBERS: 1 2 3 4 5 6 extra number: 12

        lottoRoosters.add(new LottoRoosterDb(1,"[1,2,3,4,5,6]")); // 1000000.0
        lottoRoosters.add(new LottoRoosterDb(2,"[1,2,3,4,5,12]")); // 500000.51
        lottoRoosters.add(new LottoRoosterDb(3,"[1,2,3,4,5,13]")); // 200000.11
        lottoRoosters.add(new LottoRoosterDb(4,"[1,2,3,4,11,12]")); // 100000.22
        lottoRoosters.add(new LottoRoosterDb(5,"[1,2,3,4,11,13]")); // 10000.21
        lottoRoosters.add(new LottoRoosterDb(6,"[1,2,3,10,11,12]")); // 5000.55
        lottoRoosters.add(new LottoRoosterDb(7,"[1,2,3,10,11,13]")); // 1000.11
        lottoRoosters.add(new LottoRoosterDb(8,"[1,2,9,10,11,12]")); // 50.11
        lottoRoosters.add(new LottoRoosterDb(9,"[1,8,9,10,11,12]")); // 10.11
        lottoRoosters.add(new LottoRoosterDb(10,"[7,8,9,10,11,12]")); // 0
        lottoRoosters.add(new LottoRoosterDb(10,"[7,8,9,10,11,13]")); // 0
        lottoRoosters.add(new LottoRoosterDb(10,"[1,8,9,10,11,13]")); // 0


        when(lottoRoosterRepository.findAll()).thenReturn(lottoRoosters);

        Trekking trekking = new Trekking(winningNumbers, 12, winstVerdeling);
        //System.out.println(lottoService.checkProfits(trekking).size());
        //volle pot
        assertThat(lottoService.checkProfits(trekking).get(0).getWinnings()).isEqualTo(1000000.0);
        //5+
        assertThat(lottoService.checkProfits(trekking).get(1).getWinnings()).isEqualTo(500000.51);
        //5
        assertThat(lottoService.checkProfits(trekking).get(2).getWinnings()).isEqualTo(200000.11);
        //4+
        assertThat(lottoService.checkProfits(trekking).get(3).getWinnings()).isEqualTo(100000.22);
        //4
        assertThat(lottoService.checkProfits(trekking).get(4).getWinnings()).isEqualTo(10000.21);
        //3+
        assertThat(lottoService.checkProfits(trekking).get(5).getWinnings()).isEqualTo(5000.55);
        //3
        assertThat(lottoService.checkProfits(trekking).get(6).getWinnings()).isEqualTo(1000.11);
        //2+
        assertThat(lottoService.checkProfits(trekking).get(7).getWinnings()).isEqualTo(50.11);
        //1 + 1
        assertThat(lottoService.checkProfits(trekking).get(8).getWinnings()).isEqualTo(10.11);
        // 0
        assertThat(lottoService.checkProfits(trekking).get(9).getWinnings()).isEqualTo(0.0);
        // 0
        assertThat(lottoService.checkProfits(trekking).get(10).getWinnings()).isEqualTo(0.0);
        // 0
        assertThat(lottoService.checkProfits(trekking).get(11).getWinnings()).isEqualTo(0.0);





    }
}
