package com.projeto.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.model.ProcDiarioOficial;

public interface ProcDiarioOficialRepository extends JpaRepository<ProcDiarioOficial, Long> {

	@Query("Select p from ProcDiarioOficial p where p.tipoProcedimento = :filtro")
	public Page<ProcDiarioOficial> findByTipo(Pageable page, @Param("filtro") int filtro);
	
	@Query(value = "SELECT TOP 60 * FROM proc_diario_oficial WHERE edital_gerado = 0 and tipo_procedimento = ?1", nativeQuery = true)
	public List<ProcDiarioOficial> findProcessosNaoGerados(int tipo);
	

}
