package br.com.tage.core.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tage.core.exception.ResourceNotFoundException;
import br.com.tage.core.model.AlunoFacul;
import br.com.tage.core.repository.AlunoFaculRepository;

@Controller
@RequestMapping("aluno")
public class AlunoFaculController {
  private AlunoFaculRepository repository;

  public AlunoFaculController(AlunoFaculRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("alunoFacul", repository.findAll());
    return "aluno/index";
  }

  @GetMapping("cadastrar")
  public String cadastrar(AlunoFacul alunoFacul) {
    return "aluno/form";
  }

  @PostMapping("cadastrar")
  public String cadastrar(AlunoFacul alunoFacul, RedirectAttributes redirectAttributes) {

    String msg = "Aluno cadastrado com sucesso!";
    if (alunoFacul.getCodAluno() != 0)
      msg = "Aluno Atualizado com sucesso!";

    repository.save(alunoFacul);
    redirectAttributes.addFlashAttribute("msg", msg);

    return "redirect:/aluno";
  }

  @GetMapping("editar/{id}")
  public String update(@PathVariable("id") int id, Model model) {

    model.addAttribute("alunoFacul", repository.findById(id));

    return "aluno/form";
  }

  @PostMapping("excluir/{id}")
  public String excluir(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {

    repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    repository.deleteById(id);

    redirectAttributes.addFlashAttribute("msg", "Aluno Removido!");

    return "redirect:/aluno";
  }

  @GetMapping("buscar")
  public List<AlunoFacul> buscarLojaPeloNome(@RequestParam String nome) {
    return repository.findByNomeAlunoContainsIgnoreCase(nome);
  }

}
