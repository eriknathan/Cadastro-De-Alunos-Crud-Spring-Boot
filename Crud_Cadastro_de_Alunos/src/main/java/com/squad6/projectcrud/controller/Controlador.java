package com.squad6.projectcrud.controller;

import com.squad6.projectcrud.interfaceservice.CursoInterfSer;
import com.squad6.projectcrud.interfaceservice.InfoAlunosInterfServ;
import com.squad6.projectcrud.interfaceservice.PeriodoInterfServ;
import com.squad6.projectcrud.model.Curso;
import com.squad6.projectcrud.model.Info_alunos;
import com.squad6.projectcrud.model.Periodo;
import com.squad6.projectcrud.repository.CursoRepository;
import com.squad6.projectcrud.repository.EnderecoRepository;
import com.squad6.projectcrud.repository.InfoAlunosRepository;
import com.squad6.projectcrud.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private InfoAlunosInterfServ servicealuno;

    @Autowired
    private InfoAlunosRepository repoalunos;

    @Autowired
    private CursoInterfSer servicecurso;

    @Autowired
    private CursoRepository repocurso;

    @Autowired
    private PeriodoInterfServ serviceperiodo;

    @Autowired
    private PeriodoRepository repoperiodo;

    @Autowired
    private EnderecoRepository repoendereco;
/*--------------------------------------------------------------*/

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    @GetMapping("/")
    public String Index(Model model){

        List <Info_alunos> infoalunos = servicealuno.listar();
        model.addAttribute("infoalunos", infoalunos);

        return "index";
    }

    @GetMapping(value = "/{matricula}")
    public String userView(@PathVariable("matricula") Integer matricula, Model model){

        Info_alunos aluno = repoalunos.findById(matricula).get();
        model.addAttribute("infoalunos", aluno);

        return "index";
    }

    @GetMapping("/Cadastrar")
    public String Cadastrar(Model model){

        Info_alunos infoalunos = new Info_alunos();
        model.addAttribute("info_alunos",infoalunos);

        List<Curso> cursos = servicecurso.listar();
        model.addAttribute("cursos", cursos);

        List<Periodo> periodos = serviceperiodo.listar();
        model.addAttribute("periodos", periodos);

        return "cadastrar-editar/cadastro";
    }

    @GetMapping("/Cadastrar/Sucesso")
    public String SucessForm(){
        return "cadastrar-editar/Sucesso";
    }

    @GetMapping("/editar/{matricula}")
    public String EditForm(@PathVariable("matricula") Integer matricula,Model model){

        Optional<Info_alunos> aluno = repoalunos.findById(matricula);
        model.addAttribute("pessoaobj", aluno.get());

        List<Curso> cursos = servicecurso.listar();
        model.addAttribute("cursos", cursos);

        List<Periodo> periodos = serviceperiodo.listar();
        model.addAttribute("periodos", periodos);

        return "cadastrar-editar/editar";
    }

    @GetMapping("/remove/{matricula}")
    public String deleteForm(@PathVariable("matricula") Integer matricula){

        Info_alunos aluno = repoalunos.findById(matricula).get();
        repoendereco.delete(aluno.getEndereco());
        repoalunos.delete(aluno);

        return "redirect:/";
    }

    @PostMapping("/salvar")
    public String CadastroForm(@ModelAttribute ("info_alunos") Info_alunos infoalunos){

        repoendereco.save(infoalunos.getEndereco());
        repoalunos.save(infoalunos);

        return "redirect:Cadastrar/Sucesso";
    }

    @PostMapping("/editar")
    public String EditarForm(@ModelAttribute ("info_alunos") Info_alunos infoalunos){

        repoendereco.save(infoalunos.getEndereco());
        repoalunos.save(infoalunos);

        return "redirect:/";
    }

}
