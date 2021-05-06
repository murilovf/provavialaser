package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.PessoaBusiness;
import entity.PessoaJuridica;
import entity.PessoaJuridicaTelefone;

@ViewScoped
@ManagedBean
public class PessoaJuridicaBean {
	
	private PessoaJuridica pessoaJuridica;
	
	private PessoaBusiness pessoaBusiness = new PessoaBusiness();
	
	private Integer idPessoa;
	
	private String novoTelefone;
	
	@PostConstruct
	public void inicializar() {
		if (idPessoa == null) {
			iniciarNovaPessoaJuridica();			
		} else {
			buscarPessoaJuridica();
		}
	}
	
	private void buscarPessoaJuridica() {
		pessoaJuridica = pessoaBusiness.getPessoaJuridica(idPessoa);
	}

	private void iniciarNovaPessoaJuridica() {
		idPessoa = null;
		novoTelefone = "";
		pessoaJuridica = new PessoaJuridica();
	}
	
	public void salvar() {
		pessoaBusiness.salvarPessoaJuridica(pessoaJuridica);
		iniciarNovaPessoaJuridica();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pessoa Jurídica salva com sucesso"));
	}
	
	public void adicionarTelefone() {
		PessoaJuridicaTelefone pessoaJuridicaTelefone = new PessoaJuridicaTelefone();
		pessoaJuridicaTelefone.setTelefone(novoTelefone);
		pessoaJuridicaTelefone.setPessoa(pessoaJuridica);
		
		pessoaJuridica.getTelefones().add(pessoaJuridicaTelefone);
		
		novoTelefone = "";
	}
	
	public void removerTelefone(PessoaJuridicaTelefone pessoaJuridicaTelefone) {
		pessoaJuridica.getTelefones().remove(pessoaJuridicaTelefone);
	}
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	
	public void setPessoaBusiness(PessoaBusiness pessoaBusiness) {
		this.pessoaBusiness = pessoaBusiness;
	}
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNovoTelefone() {
		return novoTelefone;
	}
	
	public void setNovoTelefone(String novoTelefone) {
		this.novoTelefone = novoTelefone;
	}

}
