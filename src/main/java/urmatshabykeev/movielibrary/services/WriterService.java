package urmatshabykeev.movielibrary.services;

import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;

import java.util.List;

@Service
public interface WriterService {
    WriterDTO createWriter(WriterDTO directorDTO);
    WriterDTO findWriterById(Long id);
    List<WriterDTO> findAllWriters();
    WriterDTO updateWriterById(WriterDTO directorDTO);
    WriterDTO deleteWriterById(Long id);
}
