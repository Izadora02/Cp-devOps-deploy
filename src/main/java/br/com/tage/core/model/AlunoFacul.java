package br.com.tage.core.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ALUNOF")
@SequenceGenerator(name = "aluno", sequenceName = "SQ_ALUNO", allocationSize = 1)
public class AlunoFacul {

  @Id
  @Column(name = "CD_ALUNO")
  @GeneratedValue(generator = "professor", strategy = GenerationType.SEQUENCE)
  private int codAluno;

  @Column(name = "NM_PROF", nullable = false, length = 50)
  private String nomeAluno;

  @Column(name = "NM_FACULDADE", nullable = false)
  private String faculdade;

  @Column(name = "NM_TURMA")
  private String turma;

  @Column(name = "TEL_ALUNO")
  private long telefone;

  public AlunoFacul() {

  }

  public AlunoFacul(String nomeAluno, String faculdade, String turma, long telefone) {
    this.nomeAluno = nomeAluno;
    this.faculdade = faculdade;
    this.turma = turma;
    this.telefone = telefone;
  }

  public int getCodAluno() {
    return codAluno;
  }

  public void setCodAluno(int codAluno) {
    this.codAluno = codAluno;
  }

  public String getNomeAluno() {
    return nomeAluno;
  }

  public void setNomeAluno(String nomeAluno) {
    this.nomeAluno = nomeAluno;
  }

  public String getFaculdade() {
    return faculdade;
  }

  public void setFaculdade(String faculdade) {
    this.faculdade = faculdade;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }

  public long getTelefone() {
    return telefone;
  }

  public void setTelefone(long telefone) {
    this.telefone = telefone;
  }

}
