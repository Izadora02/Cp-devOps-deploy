package br.com.tage.core.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_PROF")
@SequenceGenerator(name = "professor", sequenceName = "SQ_PROF", allocationSize = 1)
public class ProfessorFacul {

  @Id
  @Column(name = "CD_PROF")
  @GeneratedValue(generator = "professor", strategy = GenerationType.SEQUENCE)
  private int codProf;

  @Column(name = "NM_PROF", nullable = false, length = 50)
  private String nomeProf;

  @Column(name = "QNTD_PROF", nullable = false)
  private int qntAlunos;

  @Column(name = "END_PROF", nullable = false)
  private String endereco;

  @Column(name = "TEL_PROF")
  private long telefone;

  @Enumerated(EnumType.STRING)
  @Column(name = "CAT_PROF", nullable = false)
  private Categoria categoria;

  public ProfessorFacul() {
  }

  public ProfessorFacul(String nomeProf, int qntAlunos, String endereco, long telefone, Categoria categoria) {
    this.nomeProf = nomeProf;
    this.qntAlunos = qntAlunos;
    this.endereco = endereco;
    this.telefone = telefone;
    this.categoria = categoria;
  }

  public int getCodProf() {
    return codProf;
  }

  public void setCodProf(int codProf) {
    this.codProf = codProf;
  }

  public String getNomeProf() {
    return nomeProf;
  }

  public void setNomeProf(String nomeProf) {
    this.nomeProf = nomeProf;
  }

  public int getQntAlunos() {
    return qntAlunos;
  }

  public void setQntAlunos(int qntAlunos) {
    this.qntAlunos = qntAlunos;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public long getTelefone() {
    return telefone;
  }

  public void setTelefone(long telefone) {
    this.telefone = telefone;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

}
