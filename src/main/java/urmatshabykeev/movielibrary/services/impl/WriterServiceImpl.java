package urmatshabykeev.movielibrary.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urmatshabykeev.movielibrary.dao.WriterRepository;
import urmatshabykeev.movielibrary.errors.CreateEntityException;
import urmatshabykeev.movielibrary.errors.DeleteEntityException;
import urmatshabykeev.movielibrary.errors.NoDataFoundException;
import urmatshabykeev.movielibrary.errors.UpdateEntityException;
import urmatshabykeev.movielibrary.mappers.WriterMapper;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;
import urmatshabykeev.movielibrary.models.entities.Writer;
import urmatshabykeev.movielibrary.services.WriterService;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {
    @Autowired
    private WriterRepository writerRepository;

    private WriterMapper writerMapper = WriterMapper.INSTANCE;

    @Override
    public WriterDTO createWriter(WriterDTO writerDTO){
        try{
            Writer writer = writerMapper.toWriter(writerDTO);

            writerRepository.save(writer);

            writerDTO = writerMapper.toWriterDTO(writer);
        }catch (Exception e){
            throw new CreateEntityException("Writer");
        }

        return writerDTO;
    }

    @Override
    public List<WriterDTO> findAllWriters(){
        List<WriterDTO> writerDTOS = writerMapper.toWriterDTOS(writerRepository.findAll());

        if(writerDTOS.isEmpty()){
            throw  new NoDataFoundException();
        }

        return writerDTOS;
    }

    @Override
    public WriterDTO findWriterById(Long id){
        WriterDTO directorDTO = writerMapper.toWriterDTO(writerRepository.findById(id).orElseThrow(
                () -> new NoDataFoundException()
        ));

        return directorDTO;
    }

    @Override
    public WriterDTO deleteWriterById(Long id){
        WriterDTO writerDTO;

        try{
            writerDTO = writerMapper.toWriterDTO(writerRepository.findById(id).orElseThrow(
                    () -> new NoDataFoundException()
            ));

            writerRepository.deleteById(id);
        }catch (Exception e){
            throw new DeleteEntityException("Writer", id);
        }

        return writerDTO;
    }

    @Override
    public WriterDTO updateWriterById(WriterDTO writerDTO){
        Writer writer = writerRepository.findById(writerDTO.getId()).orElseThrow(
                () -> new NoDataFoundException()
        );
        writer = writerMapper.toWriter(writerDTO);

        try{
            writerRepository.save(writer);
        }catch (Exception e){
            throw new UpdateEntityException("Writer", writerDTO.getId());
        }

        WriterDTO directorDTO1 = writerMapper.toWriterDTO(writer);
        return directorDTO1;
    }
}
