package com.squad6.projectcrud.service;


import com.squad6.projectcrud.interfaceservice.PeriodoInterfServ;
import com.squad6.projectcrud.model.Periodo;
import com.squad6.projectcrud.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodoService implements PeriodoInterfServ {

    @Autowired
    private PeriodoRepository data;

    @Override
    public List<Periodo> listar() {
        return (List<Periodo>) data.findAll();
    }
}
