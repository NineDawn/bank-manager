package org.practice.mrj.bankmanager.domain.mapper;

import cn.hutool.core.date.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.practice.mrj.bankmanager.domain.dto.BillDTO;
import org.practice.mrj.bankmanager.domain.entity.BillDO;
import org.practice.mrj.bankmanager.domain.vo.BillVO;

import java.util.List;

/**
 * Interface: BillEntityMapper
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/11 12:28
 * @Version: 1.0
 */
@Mapper(imports = DateUtil.class)
public interface BillEntityMapper {

    BillEntityMapper INSTANCE = Mappers.getMapper(BillEntityMapper.class);

    BillDTO billDo2Dto(BillDO billDO);

    BillDO billDto2Do(BillDTO billDTO);

    List<BillDTO> billDoList2DtoList(List<BillDO> billDOList);

    @Mapping(target = "tradeTime",expression = "java(DateUtil.format(billDTO.getTradeTime(),\"yyyy-MM-dd HH:mm:ss\"))")
    BillVO billDto2Vo(BillDTO billDTO);

    List<BillVO> billDtoList2VoList(List<BillDTO> billDTOList);

}
