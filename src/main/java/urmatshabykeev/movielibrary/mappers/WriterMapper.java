package urmatshabykeev.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import urmatshabykeev.movielibrary.models.DTOs.WriterDTO;
import urmatshabykeev.movielibrary.models.entities.Writer;

import java.util.List;

@Mapper
public interface WriterMapper {
    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);

    Writer toWriter(WriterDTO writerDTO);
    WriterDTO toWriterDTO(Writer writer);
    List<Writer> toWriters(List<WriterDTO> writerDTOS);
    List<WriterDTO> toWriterDTOS(List<Writer> writers);
}
