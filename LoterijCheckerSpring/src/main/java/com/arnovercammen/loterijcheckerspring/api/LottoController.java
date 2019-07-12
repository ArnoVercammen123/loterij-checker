package com.arnovercammen.loterijcheckerspring.api;

import com.arnovercammen.loterijcheckerspring.model.LottoRooster;
import com.arnovercammen.loterijcheckerspring.model.Trekking;
import com.arnovercammen.loterijcheckerspring.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.tools.FileObject;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LottoController {

    private Trekking winningNumbers;

    @Autowired
    private LottoService lottoService;

    @GetMapping("/lotto/roosters")
    public List<LottoRooster> getRoosters(){
        return lottoService.getRoosters();
    }

    @PostMapping("/lotto/roosters")
    public void newLottoRooster(@RequestBody LottoRooster lottoRooster){
        lottoService.addRooster(lottoRooster);
    }

    @DeleteMapping("/lotto/roosters/{id}")
    public void deleteLottoRooster(@PathVariable(value = "id") String id){
        lottoService.deleteRooster(id);
    }

    @PostMapping("/lotto/trekking")
    public List<LottoRooster> trekking(@RequestBody Trekking trekking){
        return lottoService.checkProfits(trekking);
    }

    @GetMapping("/trek")
    public Trekking trek(){
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.add(6);
        return new Trekking(ar,9);
    }




}
