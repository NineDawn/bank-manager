package org.practice.mrj.bankmanager.domain.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.practice.mrj.bankmanager.domain.dto.AccountDTO;
import org.practice.mrj.bankmanager.domain.entity.AccountDO;
import org.practice.mrj.bankmanager.domain.param.AccountParam;
import org.practice.mrj.bankmanager.domain.vo.AccountVO;

/**
 * InterfaceName: AccountEntityMapper
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 19:09
 * @Version: 1.0
 */
@Mapper
public interface AccountEntityMapper {

    AccountEntityMapper INSTANCE = Mappers.getMapper(AccountEntityMapper.class);

    AccountDTO accountDo2Dto(AccountDO accountDO);

    AccountDO accountDto2Do(AccountDTO accountDTO);

    AccountVO accountDto2Vo(AccountDTO accountDTO);

    AccountDTO accountParam2Dto(AccountParam accountParam);

}
