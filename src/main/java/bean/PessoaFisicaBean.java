package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.PessoaBusiness;
import entity.PessoaFisica;

@ViewScoped
@ManagedBean
public class PessoaFisicaBean {
	
	private PessoaFisica pessoaFisica;
	
	private PessoaBusiness pessoaBusiness = new PessoaBusiness();
	
	private Integer idPessoa;
	
	@PostConstruct
	public void inicializar() {
		if (idPessoa == null) {
			iniciarNovaPessoaFisica();			
		} else {
			buscarPessoaFisica();
		}
	}

	private void iniciarNovaPessoaFisica() {
		pessoaFisica = new PessoaFisica();
	}
	
	private void buscarPessoaFisica() {
		pessoaFisica = pessoaBusiness.getPessoaFisica(idPessoa);
	}
	
	public void salvar() {
		pessoaBusiness.salvarPessoaFisica(pessoaFisica);
		iniciarNovaPessoaFisica();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pessoa Física salva com sucesso"));
	}
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

}
