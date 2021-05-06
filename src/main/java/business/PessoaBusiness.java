package business;

import java.util.List;

import entity.PessoaFisica;
import entity.PessoaJuridica;
import repository.PessoaRepository;
import utils.FiltroDTO;

public class PessoaBusiness {
	
	private PessoaRepository pessoaRepository = new PessoaRepository();

	public void salvarPessoaFisica(PessoaFisica pessoaFisica) {
		pessoaRepository.salvarPessoaFisica(pessoaFisica);
				
	}

	public void salvarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		pessoaRepository.salvarPessoaJuridica(pessoaJuridica);	
	}

	public List<PessoaFisica> getListaPessoaFisica(FiltroDTO filtroDTO) {
		return pessoaRepository.getListaPessoaFisica(filtroDTO);
	}

	public List<PessoaJuridica> getListaPessoaJuridica(FiltroDTO filtroDTO) {
		return pessoaRepository.getListaPessoaJuridica(filtroDTO);
	}

	public void removerPessoaFisica(PessoaFisica pessoaFisica) {
		pessoaRepository.removerPessoaFisica(pessoaFisica);
	}

	public void removerPessoaJuridica(PessoaJuridica pessoaJuridica) {
		pessoaRepository.removerPessoaJuridica(pessoaJuridica);	
	}

	public PessoaJuridica getPessoaJuridica(Integer idPessoa) {
		return pessoaRepository.getPessoaJuridica(idPessoa);
	}
	
	public PessoaFisica getPessoaFisica(Integer idPessoa) {
		return pessoaRepository.getPessoaFisica(idPessoa);
	}

}
