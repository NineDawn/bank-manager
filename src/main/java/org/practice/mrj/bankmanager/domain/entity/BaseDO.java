package org.practice.mrj.bankmanager.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * ClassName: BaseDO
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/11/28 16:18
 * @Version: 1.0
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseDO {


    protected Long id;

    protected Date gmtCreate;

    protected Date gmtModified;

}
