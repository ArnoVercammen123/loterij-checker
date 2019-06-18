package com.arnovercammen.loterijcheckerspring.repositories;

import com.arnovercammen.loterijcheckerspring.model.LottoRoosterDb;
import org.springframework.data.repository.CrudRepository;

public interface LottoRoosterRepository extends CrudRepository<LottoRoosterDb, Integer> {
}
