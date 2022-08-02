package com.meumicroservico.pagamento.service;

import com.meumicroservico.pagamento.dto.PagamentoDto;
import com.meumicroservico.pagamento.model.Pagamento;
import com.meumicroservico.pagamento.model.Status;
import com.meumicroservico.pagamento.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pgRepository;
    
    @Autowired
    private ModelMapper mapper;
    
    /*
    ** Método responsável por pegar todos os pagamentos
    * já paginados e mapeando-os na classe PagamentoDto
     */
    public Page<PagamentoDto> obterTodos(Pageable paginacao){
        return pgRepository
                .findAll(paginacao)
                .map(pg -> mapper.map(pg, PagamentoDto.class));
    }
    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = pgRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        
        return mapper.map(pagamento, PagamentoDto.class);
    }
    
    /*
     ** Método responsável por salvar um pagamento no
     * banco e já retornar ao usuário o PagamentoDTO
     * mapeado.
     */
    public PagamentoDto criarPagamento(PagamentoDto dto){
        Pagamento pagamento = mapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        pgRepository.save(pagamento);
        
        return mapper.map(pagamento, PagamentoDto.class);
    }
    
    /*
     ** Método responsável por atualizar um pagamento no
     * banco e já retornar ao usuário o PagamentoDTO
     * mapeado.
     */
    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = mapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = pgRepository.save(pagamento);
        return mapper.map(pagamento, PagamentoDto.class);
    }
    
    /*
     ** Método responsável por deletar um pagamento no
     * banco.
     */
    public void excluirPagamento(Long id) {
        pgRepository.deleteById(id);
    }
    
}
