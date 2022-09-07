package br.com.tage.core.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tage.core.exception.ResourceNotFoundException;
import br.com.tage.core.model.ProfessorFacul;
import br.com.tage.core.repository.ProfessorFaculRepository;

@Controller
@RequestMapping({ "professor", "/" })
public class ProfessorFaculController {
  private ProfessorFaculRepository repository;

  public ProfessorFaculController(ProfessorFaculRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("professorFacul", repository.findAll());
    return "professor/index";
  }

  @GetMapping("cadastrar")
  public String cadastrar(ProfessorFacul professorFacul) {
    return "professor/form";
  }

  @PostMapping("cadastrar")
  public String cadastrar(ProfessorFacul professorFacul, RedirectAttributes redirectAttributes) {

    String msg = "Professor cadastrado com sucesso!";
    if (professorFacul.getCodProf() != 0)
      msg = "Professor Atualizado com sucesso!";

    repository.save(professorFacul);
    redirectAttributes.addFlashAttribute("msg", msg);

    return "redirect:/";
  }

  @GetMapping("editar/{id}")
  public String update(@PathVariable("id") int id, Model model) {

    model.addAttribute("professorFacul", repository.findById(id));

    return "professor/form";
  }

  @PostMapping("excluir/{id}")
  public String excluir(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {

    repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    repository.deleteById(id);

    redirectAttributes.addFlashAttribute("msg", "Professor Removido!");

    return "redirect:/";
  }

  @GetMapping("buscar")
  public List<ProfessorFacul> buscarLojaPeloNome(@RequestParam String nome) {
    return repository.findByNomeProfContainsIgnoreCase(nome);
  }

}
