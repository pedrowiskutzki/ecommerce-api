package com.ecommerce.domain.service;
/* package com.serratec.ecommerce.ecommerce.service;

import com.api.cadastro_cliente.domain.exception.FotoClienteNaoEncontradaException;
import com.api.cadastro_cliente.domain.model.FotoCliente;
import com.api.cadastro_cliente.domain.repository.ClienteRepository;
import com.api.cadastro_cliente.domain.service.FotoStorageService.NovaFoto;
import java.io.InputStream;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FotoClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private FotoStorageService fotoStorage;

  @Transactional
  public FotoCliente salvar(FotoCliente foto, InputStream dadosArquivo) {
    Long clienteId = foto.getCliente().getId();

    String nomeNovoArquivo = fotoStorage.gerarNomeArquivo(
      foto.getNomeArquivo()
    );
    String nomeArquivoExistente = null;

    Optional<FotoCliente> fotoExistente = clienteRepository.findFotoById(
      clienteId
    );
    if (fotoExistente.isPresent()) {
      nomeArquivoExistente = fotoExistente.get().getNomeArquivo();
      clienteRepository.delete(fotoExistente.get());
    }

    foto.setNomeArquivo(nomeNovoArquivo);

    foto = clienteRepository.save(foto);
    clienteRepository.flush();

    NovaFoto novaFoto = NovaFoto
      .builder()
      .nomeAquivo(foto.getNomeArquivo())
      .inputStream(dadosArquivo)
      .build();

    fotoStorage.substituir(nomeArquivoExistente, novaFoto);

    return foto;
  }

  @Transactional
  public void excluir(Long clienteId) {
    FotoCliente foto = buscarOuFalhar(clienteId);

    clienteRepository.delete(foto);
    clienteRepository.flush();

    fotoStorage.remover(foto.getNomeArquivo());
  }

  public FotoCliente buscarOuFalhar(Long clienteId) {
    return clienteRepository
      .findFotoById(clienteId)
      .orElseThrow(() -> new FotoClienteNaoEncontradaException(clienteId));
  }
}
 */