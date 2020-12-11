package org.practice.mrj.bankmanager.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.dto.BillDTO;
import org.practice.mrj.bankmanager.domain.entity.BillDO;
import org.practice.mrj.bankmanager.domain.param.AccountParam;
import org.practice.mrj.bankmanager.domain.vo.AccountVO;

/**
 * Interface: BillEntityMapper
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/11 12:28
 * @Version: 1.0
 */
@Mapper
public interface BillEntityMapper {

    BillEntityMapper INSTANCE = Mappers.getMapper(BillEntityMapper.class);

    BillDTO billDo2Dto(BillDO billDO);

    BillDO billDto2Do(BillDTO billDTO);

    //AccountVO accountDto2Vo(AccountDTO accountDTO);

}
